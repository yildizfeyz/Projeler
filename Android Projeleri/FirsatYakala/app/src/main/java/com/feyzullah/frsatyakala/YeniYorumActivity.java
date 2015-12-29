package com.feyzullah.frsatyakala;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class YeniYorumActivity extends AppCompatActivity {

    Bitmap resim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yeni_yorum);

        setTitle("Yorum Yap");

        android.support.v7.app.ActionBar actionbar = getSupportActionBar();
        actionbar.setBackgroundDrawable(getResources().getDrawable(R.drawable.action_background));

        actionbar.setHomeButtonEnabled(true);

        // navigationu t?klanabilir hale getiriyoruz
        actionbar.setDisplayHomeAsUpEnabled(true);


        Intent gelen = getIntent();
        Bundle veriler = gelen.getExtras();
        final String Paylasim_ID = veriler.getString("ID");
        final String gonderen = veriler.getString("gonderen");
        final String zaman = veriler.getString("zaman");
        final String aciklama = veriler.getString("aciklama");
        final String begeniyorum = veriler.getString("begeniyorum");
        final String baslik = veriler.getString("baslik");
        final int resimsayisi = Integer.parseInt(veriler.getString("resimsayisi"));

        TextView txt_zaman = (TextView) findViewById(R.id.yeniyorum_zaman);
        TextView txt_gonderen = (TextView) findViewById(R.id.yeniyorum_gonderen);
        TextView txt_baslik = (TextView) findViewById(R.id.yeniyorum_baslik);
        TextView txt_aciklama = (TextView) findViewById(R.id.yeniyorum_aciklama);
        TextView txt_begeniyorum = (TextView) findViewById(R.id.yeniyorum_begeniyorum);
        ImageView img_resim = (ImageView) findViewById(R.id.yeniyorum_imageview);
        final EditText yeniyorum = (EditText) findViewById(R.id.yeniyorum_yorum);
        final com.beardedhen.androidbootstrap.BootstrapButton gonder = (com.beardedhen.androidbootstrap.BootstrapButton) findViewById(R.id.yeniyorum_gonder);

        txt_zaman.setText(zaman);
        txt_baslik.setText(Html.fromHtml(baslik));
        txt_gonderen.setText(gonderen);
        txt_aciklama.setText(aciklama);
        txt_begeniyorum.setText(begeniyorum);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Veritabani vt = new Veritabani(this);
        final String yorum_gonderen = vt.kayitGor(vt).getString(1);
        final Context context = this;
        gonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(yeniyorum.getText().toString().length() > 0 ) {

                    String _yeniyorum = yeniyorum.getText().toString();
                    WebService ws = new WebService();
                    Date simdikiZaman = new Date();
                    DateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm");

                    ws.yorum_ekle(Paylasim_ID, df.format(simdikiZaman), yorum_gonderen, _yeniyorum);

                    gonder.setEnabled(false);
                    Toast.makeText(v.getContext(), "Yorum başarıyla gönderildi", Toast.LENGTH_LONG).show();

                    Bundle veriler = new Bundle();
                    veriler.putString("gonderen", yorum_gonderen);
                    Intent intent = new Intent(context, MainActivity.class);
                    intent.putExtras(veriler);
                    startActivity(intent);

                }
                else
                {
                    Toast.makeText(v.getContext(), "Yorum boş bırakılamaz", Toast.LENGTH_SHORT).show();
                }
            }
        });









    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_yeni_yorum, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        if(id == android.R.id.home)
        {
            super.onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }
}
