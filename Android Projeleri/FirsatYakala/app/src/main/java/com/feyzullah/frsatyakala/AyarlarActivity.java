package com.feyzullah.frsatyakala;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class AyarlarActivity extends AppCompatActivity {


    String resim;
    private static final int CAMERA_REQUEST = 1888;
    ImageView profil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayarlar);

        setTitle("Ayarlar");

        android.support.v7.app.ActionBar actionbar = getSupportActionBar();
        actionbar.setBackgroundDrawable(getResources().getDrawable(R.drawable.action_background));

        actionbar.setHomeButtonEnabled(true);

        // navigationu t?klanabilir hale getiriyoruz
        actionbar.setDisplayHomeAsUpEnabled(true);


        final EditText eski_ad = (EditText) findViewById(R.id.ayarlar_eskiad);
        final EditText eski_parola = (EditText) findViewById(R.id.ayarlar_eskiparola);
        final EditText yeni_ad = (EditText) findViewById(R.id.ayarlar_yeniad);
        final EditText yeni_parola = (EditText) findViewById(R.id.ayarlar_yeniparola);

        profil = (ImageView) findViewById(R.id.ayarlar_profil);
        final com.beardedhen.androidbootstrap.BootstrapButton profil_btn = (com.beardedhen.androidbootstrap.BootstrapButton) findViewById(R.id.ayarlar_profilbtn);

        profil_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        });

        Veritabani vt = new Veritabani(this);
        Cursor cr = vt.kayitGor(vt);

        resim = cr.getString(3);

        profil.setImageBitmap(WebService.stringTObitmap(resim));

        com.beardedhen.androidbootstrap.BootstrapButton btn = (com.beardedhen.androidbootstrap.BootstrapButton) findViewById(R.id.ayarlar_btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(eski_ad.getText().toString().length() > 0 && eski_parola.getText().toString().length() > 0 && yeni_parola.getText().toString().length() > 0) {

                    Veritabani vt = new Veritabani(v.getContext());
                    if (vt.uyegirisi(vt, eski_ad.getText().toString(), eski_parola.getText().toString())) {
                        WebService ws = new WebService();
                        ws.uye_guncelle(eski_ad.getText().toString(),eski_ad.getText().toString(),yeni_parola.getText().toString(),resim);
                        vt.kayıtGuncelle(vt, eski_ad.getText().toString(), yeni_parola.getText().toString(), resim);
                        Toast.makeText(v.getContext(), "Değişiklikler Başarıyla Uygulandı!", Toast.LENGTH_LONG).show();
                        Bundle veriler = new Bundle();
                        veriler.putString("gonderen", eski_ad.getText().toString());
                        Intent intent = new Intent(v.getContext(), MainActivity.class);
                        intent.putExtras(veriler);
                        startActivity(intent);
                    } else {
                        Toast.makeText(v.getContext(), "Kullanıcı Adı veya Parola Hatalı", Toast.LENGTH_LONG).show();
                    }

                }
                else {
                    Toast.makeText(v.getContext(), "Hiçbir alan boş bırakılamaz!", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ayarlar, menu);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {

            Bitmap photo = (Bitmap) data.getExtras().get("data");

            profil.setImageBitmap(photo);

            resim = WebService.bitmapTOstring(photo);

        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        if (id == R.id.action_search) {

            new AlertDialog.Builder(AyarlarActivity.this)
                    .setIcon(R.drawable.info)
                    .setCancelable(false)
                    .setTitle("Geliştiren")
                    .setMessage("Feyzullah YILDIZ\n" +
                            "\n" +
                            "İletişim\n" +
                            "yildiz0493@gmail.com")
                    .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            //do things
                        }
                    })
                    .create().show();
            return super.onOptionsItemSelected(item);
        }



        if(id == android.R.id.home)
        {
            super.onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }
}
