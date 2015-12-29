package com.feyzullah.trabzonbelediyesi.trabzonbelediyesi_binayeriyol;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Yol_Kayitlar extends AppCompatActivity {

    static int _position;
    AlertDialog alert;

    public int KayitlariListele()
    {
        Yol_veritabani vt = new Yol_veritabani(getApplicationContext());
        Cursor cursorKayit = vt.kayitGor(vt);

        while (cursorKayit.moveToNext()) {


            Yol_verilerListe.id.add(Integer.toString(cursorKayit.getInt(cursorKayit.getColumnIndex("_id"))));
            Yol_verilerListe.yolkod.add(cursorKayit.getString(cursorKayit.getColumnIndex("yolkod")));
            Yol_verilerListe.genislik.add(cursorKayit.getString(cursorKayit.getColumnIndex("genislik")));
            Yol_verilerListe.ad.add(cursorKayit.getString(cursorKayit.getColumnIndex("ad")));
            Yol_verilerListe.kaplamaturu.add(cursorKayit.getString(cursorKayit.getColumnIndex("kaplamaturu")));

        }
        int clm = cursorKayit.getCount();
        cursorKayit.close();
        return clm;
    }
    public void GuncellemeSinifi(int i)
    {
        Yol_veriler.id                       = Yol_verilerListe.id.get(i);
        Yol_veriler.yolkod                   = Yol_verilerListe.yolkod.get(i);
        Yol_veriler.genislik                 = Yol_verilerListe.genislik.get(i);
        Yol_veriler.ad                       = Yol_verilerListe.ad.get(i);
        Yol_veriler.kaplamaturu              = Yol_verilerListe.kaplamaturu.get(i);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yol__kayitlar);

        getSupportActionBar().hide();



        Yol_verilerListe.sifirla();
        if(KayitlariListele() > 0) {
            final Yol_kayitlar_listviewAdapter adapter = new Yol_kayitlar_listviewAdapter(this);
            ((ListView) findViewById(R.id.Yol_kayitlarlistview)).setAdapter(adapter);


            final AlertDialog.Builder builder = new AlertDialog.Builder(this);

            final AlertDialog silBuilder = new AlertDialog.Builder(this)
                    .setTitle("Siliniyor")
                    .setMessage("Silmek istediğinizden emin misiniz?")
                    .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // do nothing (will close dialog)
                        }
                    })
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Yol_veritabani db = new Yol_veritabani(getApplicationContext());
                            db.kayitSil(db, Yol_verilerListe.id.get(_position));
                            Yol_verilerListe.sifirla();
                            KayitlariListele();
                            adapter.refreshResultList();
                        }
                    })
                    .create();

            final CharSequence[] items = {
                    "Fotoğrafları Gör", "Kaydı Güncelle", "Kaydı Sil"
            };


            _position = 0;
            Bina_veriler.byi = 1;
            final Intent intent = new Intent(this, Bina_ResimGalerisi.class);


            builder.setItems(items, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int item) {
                    // Do something with the selection
                    //mDoneButton.setText(items[item]);

                    if (item == 0) {
                        try {
                            Yol_verilerListe.Resim_id = Yol_verilerListe.id.get(_position);
                            startActivity(intent);
                        } catch (Exception ex) {
                        }
                    } else if (item == 1) {
                        Yol_veriler.sifirla();
                        GuncellemeSinifi(_position);
                        Yol_veriler.islem = 1;
                        startActivity(new Intent(getApplicationContext(), Yol.class));
                    } else if (item == 2) {
                        silBuilder.show();


                    }

                }
            });


            ListView list = ((ListView) findViewById(R.id.Yol_kayitlarlistview));
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                public void onItemClick(AdapterView<?> parent, View itemClicked, final int
                        position, long id) {

                    if (position != 0) {
                        _position = position;
                        builder.setTitle("ID: " + Yol_verilerListe.id.get(position) + " - Yol Kod: " + Yol_verilerListe.yolkod.get(position));
                        alert = builder.create();
                        alert.show();
                    }


                }
            });


        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_yol__kayitlar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
