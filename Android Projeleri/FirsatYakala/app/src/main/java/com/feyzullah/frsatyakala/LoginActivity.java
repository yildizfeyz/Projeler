package com.feyzullah.frsatyakala;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import im.delight.android.location.SimpleLocation;

public class LoginActivity extends AppCompatActivity {

    int z = 0;
    public boolean isOnline() {
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    private SimpleLocation location;
    Context context;
    com.beardedhen.androidbootstrap.BootstrapButton btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        setTitle("Fırsat Yakala");
        location = new SimpleLocation(getApplicationContext());

        context = this;
        android.support.v7.app.ActionBar actionbar = getSupportActionBar();
        actionbar.setBackgroundDrawable(getResources().getDrawable(R.drawable.action_background));

        actionbar.setHomeButtonEnabled(true);

        // navigationu t?klanabilir hale getiriyoruz
        actionbar.setDisplayHomeAsUpEnabled(true);

        actionbar.setHomeAsUpIndicator(R.drawable.action_icon);

        btn = (com.beardedhen.androidbootstrap.BootstrapButton) findViewById(R.id.btn_login);

        Veritabani vt = new Veritabani(this);
        if(vt.kayitGor(vt).getCount() > 0)
            btn.setText("Giriş Yap");
        else
            btn.setText("Üye Ol!");



        final EditText ad_edt = (EditText) findViewById(R.id.input_ad);
        final EditText parola_edt = (EditText) findViewById(R.id.input_password);

        final TextView zatenuyeyim = (TextView) findViewById(R.id.zaten_uyeyim);

        zatenuyeyim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(z == 0) {
                    btn.setText("Giriş Yap");
                    zatenuyeyim.setText("Üye Ol!");
                    z = 1;
                }
                else {
                    btn.setText("Üye Ol!");
                    zatenuyeyim.setText("Zaten Üyeyim");
                    z = 0;
                }
            }
        });
        if (vt.kayitGor(vt).getCount() < 1) {
            zatenuyeyim.setVisibility(View.VISIBLE); }
        else {
            Bundle veriler = new Bundle();
            veriler.putString("gonderen", vt.kayitGor(vt).getString(1));
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtras(veriler);
            startActivity(intent);
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(ad_edt.getText().toString().length() > 0 && parola_edt.getText().toString().length() > 0) {

                    if (isOnline() && location.hasLocationEnabled()) {

                        Veritabani vt = new Veritabani(v.getContext());
                        if (vt.kayitGor(vt).getCount() < 1) {
                            if(z == 1)
                            {
                                WebService ws = new WebService();
                                if(ws.uye_girisi(ad_edt.getText().toString(),parola_edt.getText().toString()))
                                {
                                    vt.kayıtEkleme(vt, ad_edt.getText().toString(), parola_edt.getText().toString(), WebService.bitmapTOstring(ws.profil_getir(ad_edt.getText().toString())));
                                    Toast.makeText(v.getContext(), "Başarıyla giriş yaptınız!", Toast.LENGTH_LONG).show();
                                    Bundle veriler = new Bundle();
                                    veriler.putString("gonderen", ad_edt.getText().toString());
                                    Intent intent = new Intent(v.getContext(), MainActivity.class);
                                    intent.putExtras(veriler);
                                    startActivity(intent);
                                }
                                else
                                {
                                    Toast.makeText(v.getContext(), "Yanlış Kullanıcı Adı veya Şifre", Toast.LENGTH_LONG).show();
                                }
                            }
                            else {
                                Bitmap icon = BitmapFactory.decodeResource(v.getContext().getResources(),
                                        R.drawable.action_icon);
                                WebService ws = new WebService();
                                if (ws.uye_ekle(ad_edt.getText().toString(), parola_edt.getText().toString(), WebService.bitmapTOstring(icon))) {
                                    vt.kayıtEkleme(vt, ad_edt.getText().toString(), parola_edt.getText().toString(), WebService.bitmapTOstring(icon));
                                    Toast.makeText(v.getContext(), "Başarıyla kayıt oldunuz!", Toast.LENGTH_LONG).show();
                                    Bundle veriler = new Bundle();
                                    veriler.putString("gonderen", ad_edt.getText().toString());
                                    Intent intent = new Intent(v.getContext(), MainActivity.class);
                                    intent.putExtras(veriler);
                                    startActivity(intent);
                                } else
                                    Toast.makeText(v.getContext(), "Bu isim kayıtlı lütfen başka isim seçin!", Toast.LENGTH_LONG).show();

                            }
                        } else {

                            if (vt.uyegirisi(vt, ad_edt.getText().toString(), parola_edt.getText().toString()))

                            {
                                Bundle veriler = new Bundle();
                                veriler.putString("gonderen", ad_edt.getText().toString());
                                Intent intent = new Intent(v.getContext(), MainActivity.class);
                                intent.putExtras(veriler);
                                startActivity(intent);
                            }
                            else
                                Toast.makeText(v.getContext(), "Yanlış Kullanıcı Adı veya Şifre", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(v.getContext(), "İnternet Bağlantısı ve GPS ayarlarını kontrol edin", Toast.LENGTH_LONG).show();
                    }

                }
                else
                {
                    Toast.makeText(v.getContext(),"Kullanıcı adı ve Şifre boş bırakılamaz", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }
}
