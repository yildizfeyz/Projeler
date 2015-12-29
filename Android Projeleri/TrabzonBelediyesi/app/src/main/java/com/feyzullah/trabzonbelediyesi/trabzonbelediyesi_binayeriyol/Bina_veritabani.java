package com.feyzullah.trabzonbelediyesi.trabzonbelediyesi_binayeriyol;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.widget.Toast;

import java.io.File;
import java.util.List;

public class Bina_veritabani extends SQLiteOpenHelper {
    private static final String Veritabani_Adi = "Bina_Veritabani.db";
    private static final int Veritabani_Version = 1;
    public Bina_veritabani(Context context) {
        super(context, Environment.getExternalStorageDirectory()
                + File.separator + "/TrabzonBelediyesi/" + File.separator
                + Veritabani_Adi, null, Veritabani_Version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE BinaTablosu(_id INTEGER primary key AUTOINCREMENT,"
                + " geocode String , mahalleadi String, caddesokakadi String, caddesokakkodu String, kapino String,"
                + " siteadi String , apartmanadi String, halihazirdurum String, discephe_durumu String, yapidurumu String,"
                + " catidurumu String , yapisistemi String, kullanilanmalzeme String, ortakkullanim String, digerbilgiler String,"
                + " binasorumlusu String , sorumlu_tel String, kullanimamaci String, gelismislik String,"
                + " ickapino String , nitelik String, nitelikkodu String, baskamahalleadi String, baskakapino String,"
                + " baskadusunceler String , notlar String, location_x String, location_y String);");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST BinaTablosu");
        onCreate(db);
    }
    public static int kayıtEkleme(Bina_veritabani database){

        int size = 0;
        SQLiteDatabase db = database.getWritableDatabase();

        if(Bina_veriler.ickapino.size() > Bina_veriler.baskakapino.size()) size = Bina_veriler.ickapino.size(); else size = Bina_veriler.baskakapino.size();

        for(int i = 0; i < size; i++) {
            ContentValues veriler = new ContentValues();
            veriler.put("geocode", Bina_veriler.geocode);
            veriler.put("mahalleadi", Bina_veriler.mahalleadi);
            veriler.put("caddesokakadi", Bina_veriler.caddesokakadi);
            veriler.put("caddesokakkodu", Bina_veriler.caddesokakkodu);
            veriler.put("kapino", Bina_veriler.kapino);
            veriler.put("siteadi", Bina_veriler.siteadi);
            veriler.put("apartmanadi", Bina_veriler.apartmanadi);
            veriler.put("halihazirdurum", Bina_veriler.halihazirdurum);
            veriler.put("discephe_durumu", Bina_veriler.discephe_durumu);
            veriler.put("yapidurumu", Bina_veriler.yapidurumu);
            veriler.put("catidurumu", Bina_veriler.catidurumu);
            veriler.put("yapisistemi", Bina_veriler.yapisistemi);
            veriler.put("kullanilanmalzeme", Bina_veriler.kullanilanmalzeme);
            veriler.put("ortakkullanim", Bina_veriler.ortakkullanim);
            veriler.put("digerbilgiler", Bina_veriler.digerbilgiler);
            veriler.put("binasorumlusu", Bina_veriler.binasorumlusu);
            veriler.put("sorumlu_tel", Bina_veriler.sorumlu_tel);
            veriler.put("kullanimamaci", Bina_veriler.kullanimamaci);
            veriler.put("gelismislik", Bina_veriler.gelismislik);
            veriler.put("location_x", Bina_veriler.location_x);
            veriler.put("location_y", Bina_veriler.location_y);

            if(i+1 < Bina_veriler.ickapino.size()) {
                veriler.put("ickapino", Bina_veriler.ickapino.get(i+1));
                veriler.put("nitelik", Bina_veriler.nitelik.get(i+1));
                veriler.put("nitelikkodu", Bina_veriler.nitelikkodu.get(i+1));
            }
            else
            {
                veriler.put("ickapino", "");
                veriler.put("nitelik", "");
                veriler.put("nitelikkodu", "");
            }
            if(i+1 < Bina_veriler.baskakapino.size()) {
                veriler.put("baskamahalleadi", Bina_veriler.baskamahalleadi.get(i+1));
                veriler.put("baskakapino", Bina_veriler.baskakapino.get(i+1));
                veriler.put("baskadusunceler", Bina_veriler.baskadusunceler.get(i+1));
            }
            else
            {
                veriler.put("baskamahalleadi", "");
                veriler.put("baskakapino", "");
                veriler.put("baskadusunceler", "");
            }
            veriler.put("notlar", Bina_veriler.notlar);


            int ex = (int) db.insert("BinaTablosu", null, veriler);

            if(ex == -1) return 0;
        }

        return 1;
    }


    public static int kayıtGuncelle(Bina_veritabani database, String id){


        SQLiteDatabase db = database.getWritableDatabase();

            ContentValues veriler = new ContentValues();
            veriler.put("geocode", Bina_veriler.geocode);
            veriler.put("mahalleadi", Bina_veriler.mahalleadi);
            veriler.put("caddesokakadi", Bina_veriler.caddesokakadi);
            veriler.put("caddesokakkodu", Bina_veriler.caddesokakkodu);
            veriler.put("kapino", Bina_veriler.kapino);
            veriler.put("siteadi", Bina_veriler.siteadi);
            veriler.put("apartmanadi", Bina_veriler.apartmanadi);
            veriler.put("halihazirdurum", Bina_veriler.halihazirdurum);
            veriler.put("discephe_durumu", Bina_veriler.discephe_durumu);
            veriler.put("yapidurumu", Bina_veriler.yapidurumu);
            veriler.put("catidurumu", Bina_veriler.catidurumu);
            veriler.put("yapisistemi", Bina_veriler.yapisistemi);
            veriler.put("kullanilanmalzeme", Bina_veriler.kullanilanmalzeme);
            veriler.put("ortakkullanim", Bina_veriler.ortakkullanim);
            veriler.put("digerbilgiler", Bina_veriler.digerbilgiler);
            veriler.put("binasorumlusu", Bina_veriler.binasorumlusu);
            veriler.put("sorumlu_tel", Bina_veriler.sorumlu_tel);
            veriler.put("kullanimamaci", Bina_veriler.kullanimamaci);
            veriler.put("gelismislik", Bina_veriler.gelismislik);

            veriler.put("ickapino", Bina_veriler.ickapino.get(0));
            veriler.put("nitelik", Bina_veriler.nitelik.get(0));
            veriler.put("nitelikkodu", Bina_veriler.nitelikkodu.get(0));

            veriler.put("baskamahalleadi", Bina_veriler.baskamahalleadi.get(0));
            veriler.put("baskakapino", Bina_veriler.baskakapino.get(0));
            veriler.put("baskadusunceler", Bina_veriler.baskadusunceler.get(0));

            veriler.put("notlar", Bina_veriler.notlar);

            int ex = (int) db.update("BinaTablosu", veriler, "_id=" + id,null);
            if(ex == -1) return 0;


        return 1;
    }


    public static Cursor kayitGor(Bina_veritabani database){

         String[] sutunlar = {"_id", "geocode","mahalleadi", "caddesokakadi","caddesokakkodu", "kapino","siteadi", "apartmanadi"
                ,"halihazirdurum", "discephe_durumu","yapidurumu", "catidurumu","yapisistemi", "kullanilanmalzeme","ortakkullanim"
                , "digerbilgiler","binasorumlusu", "sorumlu_tel","kullanimamaci", "gelismislik","ickapino", "nitelik","nitelikkodu"
                , "baskamahalleadi","baskakapino", "baskadusunceler","notlar","location_x", "location_y"};

        SQLiteDatabase db = database.getReadableDatabase();
        Cursor cursorKayit = db.query("BinaTablosu", sutunlar,
                null, null, null, null, null);

        return cursorKayit;


        /*
        while(cursorKayit.moveToNext()){
            int id=cursorKayit.getInt(cursorKayit.getColumnIndex("_id"));
            String num=cursorKayit.getString(cursorKayit.getColumnIndex("numara"));
            String operatorkodu = cursorKayit.getString(cursorKayit.getColumnIndex("operatorkodu"));
            tvKayitlar.setText(tvKayitlar.getText()+"\n"+" "+id+" "+num+" "+ operatorkodu);
        }
        cursorKayit.close();

        */

    }

    public void kayitSil(Bina_veritabani database, String id)
    {
        SQLiteDatabase db = database.getWritableDatabase();
        db.delete("BinaTablosu", "_id=" + id, null);
    }

    public void HerSeyiSil(Bina_veritabani database)
    {
        SQLiteDatabase db = database.getWritableDatabase();
        db.delete("BinaTablosu", null, null);
    }
}