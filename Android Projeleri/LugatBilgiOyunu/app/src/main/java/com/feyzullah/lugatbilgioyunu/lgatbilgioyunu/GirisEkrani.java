package com.feyzullah.lugatbilgioyunu.lgatbilgioyunu;

import android.app.Application;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class GirisEkrani extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris_ekrani);

        getSupportActionBar().hide();



        Veritabani vt;
        vt = new Veritabani(this);
        Cursor csr = vt.kayitGor(vt);
        if(csr.getCount() == 0)
        {
            vt.kayıtEkleme(vt,"0","0","0","0","0","0");
        }

        vt.close();
        vt = new Veritabani(this);
        csr = vt.kayitGor(vt);

        csr.moveToNext();


        String saat = csr.getString(csr.getColumnIndex("saat"));
        String dakika = csr.getString(csr.getColumnIndex("dakika"));
        String saniye = csr.getString(csr.getColumnIndex("saniye"));

        if(saat.length() < 2) saat = "0"+saat;
        if(dakika.length() < 2) dakika = "0"+dakika;
        if(saniye.length() < 2) saniye = "0"+saniye;
        ((TextView)findViewById(R.id.cevaplanan)).setText(" Cevapladığınız Soru Sayısı:  " + csr.getString(1));
        ((TextView)findViewById(R.id.dogrucevap)).setText(" Doğru Cevap Sayısı:  " + csr.getString(2));
        ((TextView)findViewById(R.id.yanliscevap)).setText(" Yanlış Cevap Sayısı:  " + csr.getString(csr.getColumnIndex("yanliscevap")));
        ((TextView)findViewById(R.id.toplamsure)).setText(" Toplam Harcanan Süre:  " + saat + ":" + dakika + ":" + saniye);


    }



    public void onBasla(View v)
    {
        startActivity(new Intent(GirisEkrani.this, OyunEkrani.class));
    }

    @Override
    public void onBackPressed() {
    }



}
