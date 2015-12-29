package com.feyzullah.trabzonbelediyesi.trabzonbelediyesi_binayeriyol;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Bina_Kayitlar extends AppCompatActivity {

    static int _position;
    AlertDialog alert;

    public int KayitlariListele()
    {
        Bina_veritabani vt = new Bina_veritabani(getApplicationContext());
        Cursor cursorKayit = vt.kayitGor(vt);

        while (cursorKayit.moveToNext()) {


            Bina_verilerListe.id.add(Integer.toString(cursorKayit.getInt(cursorKayit.getColumnIndex("_id"))));
            Bina_verilerListe.geocode.add(cursorKayit.getString(cursorKayit.getColumnIndex("geocode")));
            Bina_verilerListe.mahalleadi.add(cursorKayit.getString(cursorKayit.getColumnIndex("mahalleadi")));
            Bina_verilerListe.caddesokakadi.add(cursorKayit.getString(cursorKayit.getColumnIndex("caddesokakadi")));
            Bina_verilerListe.caddesokakkodu.add(cursorKayit.getString(cursorKayit.getColumnIndex("caddesokakkodu")));
            Bina_verilerListe.kapino.add(cursorKayit.getString(cursorKayit.getColumnIndex("kapino")));
            Bina_verilerListe.siteadi.add(cursorKayit.getString(cursorKayit.getColumnIndex("siteadi")));
            Bina_verilerListe.apartmanadi.add(cursorKayit.getString(cursorKayit.getColumnIndex("apartmanadi")));
            Bina_verilerListe.halihazirdurum.add(cursorKayit.getString(cursorKayit.getColumnIndex("halihazirdurum")));
            Bina_verilerListe.discephe_durumu.add(cursorKayit.getString(cursorKayit.getColumnIndex("discephe_durumu")));
            Bina_verilerListe.yapidurumu.add(cursorKayit.getString(cursorKayit.getColumnIndex("yapidurumu")));
            Bina_verilerListe.catidurumu.add(cursorKayit.getString(cursorKayit.getColumnIndex("catidurumu")));
            Bina_verilerListe.yapisistemi.add(cursorKayit.getString(cursorKayit.getColumnIndex("yapisistemi")));
            Bina_verilerListe.kullanilanmalzeme.add(cursorKayit.getString(cursorKayit.getColumnIndex("kullanilanmalzeme")));
            Bina_verilerListe.ortakkullanim.add(cursorKayit.getString(cursorKayit.getColumnIndex("ortakkullanim")));
            Bina_verilerListe.digerbilgiler.add(cursorKayit.getString(cursorKayit.getColumnIndex("digerbilgiler")));
            Bina_verilerListe.binasorumlusu.add(cursorKayit.getString(cursorKayit.getColumnIndex("binasorumlusu")));
            Bina_verilerListe.sorumlu_tel.add(cursorKayit.getString(cursorKayit.getColumnIndex("sorumlu_tel")));
            Bina_verilerListe.kullanimamaci.add(cursorKayit.getString(cursorKayit.getColumnIndex("kullanimamaci")));
            Bina_verilerListe.gelismislik.add(cursorKayit.getString(cursorKayit.getColumnIndex("gelismislik")));
            Bina_verilerListe.ickapino.add(cursorKayit.getString(cursorKayit.getColumnIndex("ickapino")));
            Bina_verilerListe.nitelik.add(cursorKayit.getString(cursorKayit.getColumnIndex("nitelik")));
            Bina_verilerListe.nitelikkodu.add(cursorKayit.getString(cursorKayit.getColumnIndex("nitelikkodu")));
            Bina_verilerListe.baskamahalleadi.add(cursorKayit.getString(cursorKayit.getColumnIndex("baskamahalleadi")));
            Bina_verilerListe.baskakapino.add(cursorKayit.getString(cursorKayit.getColumnIndex("baskakapino")));
            Bina_verilerListe.baskadusunceler.add(cursorKayit.getString(cursorKayit.getColumnIndex("baskadusunceler")));
            Bina_verilerListe.notlar.add(cursorKayit.getString(cursorKayit.getColumnIndex("notlar")));



        }
        int clm = cursorKayit.getCount();
        cursorKayit.close();
        return clm;
    }
    public void GuncellemeSinifi(int i)
    {
        Bina_veriler.id                  = Bina_verilerListe.id.get(i);
        Bina_veriler.geocode             = Bina_verilerListe.geocode.get(i);
        Bina_veriler.mahalleadi          = Bina_verilerListe.mahalleadi.get(i);
        Bina_veriler.caddesokakadi       = Bina_verilerListe.caddesokakadi.get(i);
        Bina_veriler.caddesokakkodu      = Bina_verilerListe.caddesokakkodu.get(i);
        Bina_veriler.kapino              = Bina_verilerListe.kapino.get(i);
        Bina_veriler.siteadi             = Bina_verilerListe.siteadi.get(i);
        Bina_veriler.apartmanadi         = Bina_verilerListe.apartmanadi.get(i);
        Bina_veriler.halihazirdurum      = Bina_verilerListe.halihazirdurum.get(i);
        Bina_veriler.discephe_durumu     = Bina_verilerListe.discephe_durumu.get(i);
        Bina_veriler.yapidurumu          = Bina_verilerListe.yapidurumu.get(i);
        Bina_veriler.catidurumu          = Bina_verilerListe.catidurumu.get(i);
        Bina_veriler.yapisistemi         = Bina_verilerListe.yapisistemi.get(i);
        Bina_veriler.kullanilanmalzeme   = Bina_verilerListe.kullanilanmalzeme.get(i);
        Bina_veriler.ortakkullanim       = Bina_verilerListe.ortakkullanim.get(i);
        Bina_veriler.digerbilgiler       = Bina_verilerListe.digerbilgiler.get(i);
        Bina_veriler.binasorumlusu       = Bina_verilerListe.binasorumlusu.get(i);
        Bina_veriler.sorumlu_tel         = Bina_verilerListe.sorumlu_tel.get(i);
        Bina_veriler.kullanimamaci       = Bina_verilerListe.kullanimamaci.get(i);
        Bina_veriler.gelismislik         = Bina_verilerListe.gelismislik.get(i);
        Bina_veriler.ickapino            .add(0, Bina_verilerListe.ickapino.get(i));
        Bina_veriler.nitelik             .add(0, Bina_verilerListe.nitelik.get(i));
        Bina_veriler.nitelikkodu         .add(0, Bina_verilerListe.nitelikkodu.get(i));
        Bina_veriler.baskamahalleadi     .add(0, Bina_verilerListe.baskamahalleadi.get(i));
        Bina_veriler.baskakapino         .add(0, Bina_verilerListe.baskakapino.get(i));
        Bina_veriler.baskadusunceler     .add(0, Bina_verilerListe.baskadusunceler.get(i));
        Bina_veriler.notlar              = Bina_verilerListe.notlar.get(i);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bina__kayitlar);
        getSupportActionBar().hide();



            Bina_verilerListe.sifirla();
            if(KayitlariListele() > 0) {
                final Bina_kayitlar_listviewAdapter adapter = new Bina_kayitlar_listviewAdapter(this);
                ((ListView) findViewById(R.id.Bina_kayitlarlistview)).setAdapter(adapter);


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
                                Bina_veritabani db = new Bina_veritabani(getApplicationContext());
                                db.kayitSil(db, Bina_verilerListe.id.get(_position));
                                Bina_verilerListe.sifirla();
                                KayitlariListele();
                                adapter.refreshResultList();
                            }
                        })
                        .create();

                final CharSequence[] items = {
                        "Fotoğrafları Gör", "Kaydı Güncelle", "Kaydı Sil"
                };


                _position = 0;
                Bina_veriler.byi = 0;
                final Intent intent = new Intent(this, Bina_ResimGalerisi.class);


                builder.setItems(items, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        // Do something with the selection
                        //mDoneButton.setText(items[item]);

                        if (item == 0) {
                            try {
                                Bina_verilerListe.Resim_id = Bina_verilerListe.id.get(_position);
                                startActivity(intent);
                            } catch (Exception ex) {
                            }
                        } else if (item == 1) {
                            Bina_veriler.sifirla();
                            GuncellemeSinifi(_position);
                            Bina_veriler.islem = 1;
                            startActivity(new Intent(getApplicationContext(), Bina.class));
                        } else if (item == 2) {
                            silBuilder.show();


                        }

                    }
                });


                ListView list = ((ListView) findViewById(R.id.Bina_kayitlarlistview));
                list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    public void onItemClick(AdapterView<?> parent, View itemClicked, final int
                            position, long id) {

                        if (position != 0) {
                            _position = position;
                            builder.setTitle("ID: " + Bina_verilerListe.id.get(position) + " - Geocode: " + Bina_verilerListe.geocode.get(position));
                            alert = builder.create();
                            alert.show();
                        }


                    }
                });


            }

    }




}
