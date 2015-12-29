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

public class Isyeri_veritabani extends SQLiteOpenHelper {
    private static final String Veritabani_Adi = "Isyeri_Veritabani.db";
    private static final int Veritabani_Version = 1;
    public Isyeri_veritabani(Context context) {
        super(context, Environment.getExternalStorageDirectory()
                + File.separator + "/TrabzonBelediyesi/" + File.separator
                + Veritabani_Adi, null, Veritabani_Version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IsyeriTablosu(_id INTEGER primary key AUTOINCREMENT,"
                + " ticarikod String , isletmeturu String, ickapino String, isletmeadi String, mulkiyetdurumu String,"
                + " adisoyadi String , tcno String, vergino String, telefon String, webadresi String, location_x String, location_y String);");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST IsyeriTablosu");
        onCreate(db);
    }
    public static int kayıtEkleme(Isyeri_veritabani database){


        SQLiteDatabase db = database.getWritableDatabase();


            ContentValues veriler = new ContentValues();
            veriler.put("ticarikod", Isyeri_veriler.ticarikod);
            veriler.put("isletmeturu", Isyeri_veriler.isletmeturu);
            veriler.put("ickapino", Isyeri_veriler.ickapino);
            veriler.put("isletmeadi", Isyeri_veriler.isletmeadi);
            veriler.put("mulkiyetdurumu", Isyeri_veriler.mulkiyetdurumu);
            veriler.put("adisoyadi", Isyeri_veriler.adisoyadi);
            veriler.put("tcno", Isyeri_veriler.tcno);
            veriler.put("vergino", Isyeri_veriler.vergino);
            veriler.put("telefon", Isyeri_veriler.telefon);
            veriler.put("webadresi", Isyeri_veriler.webadresi);
            veriler.put("location_x", Isyeri_veriler.location_x);
            veriler.put("location_y", Isyeri_veriler.location_y);

            int ex = (int) db.insert("IsyeriTablosu", null, veriler);

            if(ex == -1) return 0;


        return 1;
    }


    public static int kayıtGuncelle(Isyeri_veritabani database, String id){


        SQLiteDatabase db = database.getWritableDatabase();

        ContentValues veriler = new ContentValues();
        veriler.put("ticarikod", Isyeri_veriler.ticarikod);
        veriler.put("isletmeturu", Isyeri_veriler.isletmeturu);
        veriler.put("ickapino", Isyeri_veriler.ickapino);
        veriler.put("isletmeadi", Isyeri_veriler.isletmeadi);
        veriler.put("mulkiyetdurumu", Isyeri_veriler.mulkiyetdurumu);
        veriler.put("adisoyadi", Isyeri_veriler.adisoyadi);
        veriler.put("tcno", Isyeri_veriler.tcno);
        veriler.put("vergino", Isyeri_veriler.tcno);
        veriler.put("telefon", Isyeri_veriler.telefon);
        veriler.put("webadresi", Isyeri_veriler.webadresi);

        int ex = (int) db.update("IsyeriTablosu", veriler, "_id=" + id, null);
        if(ex == -1) return 0;


        return 1;
    }


    public static Cursor kayitGor(Isyeri_veritabani database){

        String[] sutunlar = {"_id", "ticarikod","isletmeturu", "ickapino","isletmeadi", "mulkiyetdurumu","adisoyadi", "tcno"
                ,"vergino","telefon", "webadresi, location_x, location_y"};


        SQLiteDatabase db = database.getReadableDatabase();
        Cursor cursorKayit = db.query("IsyeriTablosu", sutunlar,
                null, null, null, null, null);

        return cursorKayit;




    }

    public void kayitSil(Isyeri_veritabani database, String id)
    {
        SQLiteDatabase db = database.getWritableDatabase();
        db.delete("IsyeriTablosu", "_id=" + id, null);
    }

    public void HerSeyiSil(Isyeri_veritabani database)
    {
        SQLiteDatabase db = database.getWritableDatabase();
        db.delete("IsyeriTablosu", null, null);
    }

}