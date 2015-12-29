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

public class Isyeri_Kayitlar extends AppCompatActivity {

    static int _position;
    AlertDialog alert;

    public int KayitlariListele()
    {
        Isyeri_veritabani vt = new Isyeri_veritabani(getApplicationContext());
        Cursor cursorKayit = vt.kayitGor(vt);

        while (cursorKayit.moveToNext()) {


            Isyeri_verilerListe.id.add(Integer.toString(cursorKayit.getInt(cursorKayit.getColumnIndex("_id"))));
            Isyeri_verilerListe.ticarikod.add(cursorKayit.getString(cursorKayit.getColumnIndex("ticarikod")));
            Isyeri_verilerListe.isletmeturu.add(cursorKayit.getString(cursorKayit.getColumnIndex("isletmeturu")));
            Isyeri_verilerListe.ickapino.add(cursorKayit.getString(cursorKayit.getColumnIndex("ickapino")));
            Isyeri_verilerListe.isletmeadi.add(cursorKayit.getString(cursorKayit.getColumnIndex("isletmeadi")));
            Isyeri_verilerListe.mulkiyetdurumu.add(cursorKayit.getString(cursorKayit.getColumnIndex("mulkiyetdurumu")));
            Isyeri_verilerListe.adisoyadi.add(cursorKayit.getString(cursorKayit.getColumnIndex("adisoyadi")));
            Isyeri_verilerListe.tcno.add(cursorKayit.getString(cursorKayit.getColumnIndex("tcno")));
            Isyeri_verilerListe.vergino.add(cursorKayit.getString(cursorKayit.getColumnIndex("vergino")));
            Isyeri_verilerListe.telefon.add(cursorKayit.getString(cursorKayit.getColumnIndex("telefon")));
            Isyeri_verilerListe.webadresi.add(cursorKayit.getString(cursorKayit.getColumnIndex("webadresi")));




        }
        int clm = cursorKayit.getCount();
        cursorKayit.close();
        return clm;
    }
    public void GuncellemeSinifi(int i)
    {
        Isyeri_veriler.id                    = Isyeri_verilerListe.id.get(i);
        Isyeri_veriler.ticarikod             = Isyeri_verilerListe.ticarikod.get(i);
        Isyeri_veriler.isletmeturu           = Isyeri_verilerListe.isletmeturu.get(i);
        Isyeri_veriler.ickapino              = Isyeri_verilerListe.ickapino.get(i);
        Isyeri_veriler.isletmeadi            = Isyeri_verilerListe.isletmeadi.get(i);
        Isyeri_veriler.mulkiyetdurumu        = Isyeri_verilerListe.mulkiyetdurumu.get(i);
        Isyeri_veriler.adisoyadi             = Isyeri_verilerListe.adisoyadi.get(i);
        Isyeri_veriler.tcno                  = Isyeri_verilerListe.tcno.get(i);
        Isyeri_veriler.vergino               = Isyeri_verilerListe.vergino.get(i);
        Isyeri_veriler.telefon               = Isyeri_verilerListe.telefon.get(i);
        Isyeri_veriler.webadresi             = Isyeri_verilerListe.webadresi.get(i);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isyeri__kayitlar);

        getSupportActionBar().hide();



        Isyeri_verilerListe.sifirla();
        if(KayitlariListele() > 0) {
            final Isyeri_kayitlar_listviewAdapter adapter = new Isyeri_kayitlar_listviewAdapter(this);
            ((ListView) findViewById(R.id.Isyeri_kayitlarlistview)).setAdapter(adapter);


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
                            Isyeri_veritabani db = new Isyeri_veritabani(getApplicationContext());
                            db.kayitSil(db, Isyeri_verilerListe.id.get(_position));
                            Isyeri_verilerListe.sifirla();
                            KayitlariListele();
                            adapter.refreshResultList();
                        }
                    })
                    .create();

            final CharSequence[] items = {
                    "Fotoğrafları Gör", "Kaydı Güncelle", "Kaydı Sil"
            };


            _position = 0;
            Bina_veriler.byi = 2;
            final Intent intent = new Intent(this, Bina_ResimGalerisi.class);


            builder.setItems(items, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int item) {
                    // Do something with the selection
                    //mDoneButton.setText(items[item]);

                    if (item == 0) {
                        try {
                            Isyeri_verilerListe.Resim_id = Isyeri_verilerListe.id.get(_position);
                            startActivity(intent);
                        } catch (Exception ex) {
                        }
                    } else if (item == 1) {
                        Isyeri_veriler.sifirla();
                        GuncellemeSinifi(_position);
                        Isyeri_veriler.islem = 1;
                        startActivity(new Intent(getApplicationContext(), Isyeri.class));
                    } else if (item == 2) {
                        silBuilder.show();


                    }

                }
            });


            ListView list = ((ListView) findViewById(R.id.Isyeri_kayitlarlistview));
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                public void onItemClick(AdapterView<?> parent, View itemClicked, final int
                        position, long id) {

                    if (position != 0) {
                        _position = position;
                        builder.setTitle("ID: " + Isyeri_verilerListe.id.get(position) + " - Ticari Kod: " + Isyeri_verilerListe.ticarikod.get(position));
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
        getMenuInflater().inflate(R.menu.menu_isyeri__kayitlar, menu);
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
