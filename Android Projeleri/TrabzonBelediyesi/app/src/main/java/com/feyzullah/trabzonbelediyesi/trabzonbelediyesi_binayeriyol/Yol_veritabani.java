package com.feyzullah.trabzonbelediyesi.trabzonbelediyesi_binayeriyol;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;

import java.io.File;

/**
 * Created by feyzullah on 8.11.2015.
 */
public class Yol_veritabani extends SQLiteOpenHelper {
    private static final String Veritabani_Adi = "Yol_Veritabani.db";
    private static final int Veritabani_Version = 1;
    public Yol_veritabani(Context context) {
        super(context, Environment.getExternalStorageDirectory()
                + File.separator + "/TrabzonBelediyesi/" + File.separator
                + Veritabani_Adi, null, Veritabani_Version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE YolTablosu(_id INTEGER primary key AUTOINCREMENT,"
                + " yolkod String , genislik String, ad String, kaplamaturu String, location_x String, location_y String);");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST YolTablosu");
        onCreate(db);
    }
    public static int kayıtEkleme(Yol_veritabani database){

        int size = 0;
        SQLiteDatabase db = database.getWritableDatabase();


        ContentValues veriler = new ContentValues();
        veriler.put("yolkod", Yol_veriler.yolkod);
        veriler.put("genislik", Yol_veriler.genislik);
        veriler.put("ad", Yol_veriler.ad);
        veriler.put("kaplamaturu", Yol_veriler.kaplamaturu);
        veriler.put("location_x", Yol_veriler.location_x);
        veriler.put("location_y", Yol_veriler.location_y);

        int ex = (int) db.insert("YolTablosu", null, veriler);

        if(ex == -1) return 0;


        return 1;
    }


    public static int kayıtGuncelle(Yol_veritabani database, String id){


        SQLiteDatabase db = database.getWritableDatabase();

        ContentValues veriler = new ContentValues();
        veriler.put("yolkod", Yol_veriler.yolkod);
        veriler.put("genislik", Yol_veriler.genislik);
        veriler.put("ad", Yol_veriler.ad);
        veriler.put("kaplamaturu", Yol_veriler.kaplamaturu);


        int ex = (int) db.update("YolTablosu", veriler, "_id=" + id, null);
        if(ex == -1) return 0;


        return 1;
    }


    public static Cursor kayitGor(Yol_veritabani database){

        String[] sutunlar = {"_id", "yolkod","genislik", "ad","kaplamaturu","location_x","location_y"};

        SQLiteDatabase db = database.getReadableDatabase();
        Cursor cursorKayit = db.query("YolTablosu", sutunlar,
                null, null, null, null, null);

        return cursorKayit;




    }

    public void kayitSil(Yol_veritabani database, String id)
    {
        SQLiteDatabase db = database.getWritableDatabase();
        db.delete("YolTablosu", "_id=" + id, null);
    }

    public void HerSeyiSil(Yol_veritabani database)
    {
        SQLiteDatabase db = database.getWritableDatabase();
        db.delete("YolTablosu", null, null);
    }
}