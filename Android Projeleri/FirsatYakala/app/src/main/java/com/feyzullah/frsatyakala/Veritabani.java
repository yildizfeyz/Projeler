package com.feyzullah.frsatyakala;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Veritabani extends SQLiteOpenHelper {
    private static final String Veritabani_Adi = "Kullanici_Tablosu.db";
    private static final int Veritabani_Version = 1;
    public Veritabani(Context context) {
        super(context, Veritabani_Adi, null, Veritabani_Version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Kullanici_Tablosu(_id INTEGER primary key AUTOINCREMENT,"
                + " uyeadi String , parola String, resim BLOB);");
        db.execSQL("CREATE TABLE ID_Tablosu(_id INTEGER primary key AUTOINCREMENT,"
                + " ID String);");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST Kullanici_Tablosu");
        db.execSQL("DROP TABLE IF EXIST ID_Tablosu");
        onCreate(db);
    }



    public int kayıtEkleme(Veritabani database, String uyeadi, String parola, String resim){

        int size = 0;
        SQLiteDatabase db = database.getWritableDatabase();


        ContentValues veriler = new ContentValues();
        veriler.put("uyeadi", uyeadi);
        veriler.put("parola", parola);
        veriler.put("resim", resim);
        int ex = (int) db.insert("Kullanici_Tablosu", null, veriler);

        if(ex == -1) return 0;


        return 1;
    }


    public int kayıtGuncelle(Veritabani database, String uyeadi, String parola, String resim){


        SQLiteDatabase db = database.getWritableDatabase();

        ContentValues veriler = new ContentValues();
        veriler.put("uyeadi", uyeadi);
        veriler.put("parola", parola);
        veriler.put("resim", resim);

        int ex = (int) db.update("Kullanici_Tablosu", veriler, "_id=" + 1, null);
        if(ex == -1) return 0;


        return 1;
    }


    public Cursor kayitGor(Veritabani database){

        String[] sutunlar = {"_id", "uyeadi","parola", "resim"};

        SQLiteDatabase db = database.getReadableDatabase();
        Cursor cursorKayit = db.query("Kullanici_Tablosu", sutunlar,
                null, null, null, null, null);
        cursorKayit.moveToNext();
        return cursorKayit;
    }

    public int addLike(Veritabani database, String ID){


        SQLiteDatabase db = database.getWritableDatabase();


        ContentValues veriler = new ContentValues();
        veriler.put("ID", ID);

        int ex = (int) db.insert("ID_Tablosu", null, veriler);

        if(ex == -1) return 0;


        return 1;
    }

    public boolean isLike(Veritabani database, String ID)
    {
        String[] sutunlar = {"_id", "ID"};

        SQLiteDatabase db = database.getReadableDatabase();
        Cursor cursorKayit = db.query("ID_Tablosu", sutunlar,
                null, null, null, null, null);

        while(cursorKayit.moveToNext()){
            if(cursorKayit.getString(1).equals(ID))
                return true;


        }
        return false;
    }

    public boolean uyegirisi(Veritabani database, String uyeadi, String parola)
    {
        String[] sutunlar = {"_id", "uyeadi","parola"};

        SQLiteDatabase db = database.getReadableDatabase();
        Cursor cursorKayit = db.query("Kullanici_Tablosu", sutunlar,
                null, null, null, null, null);

        if(cursorKayit.moveToNext()){
            if(cursorKayit.getString(1).equals(uyeadi) && cursorKayit.getString(2).equals(parola) )
                return true;
            else return false;

        }
        return false;
    }

    public void kayitSil(Veritabani database)
    {
        SQLiteDatabase db = database.getWritableDatabase();
        db.delete("Kullanici_Tablosu", "_id=1", null);
    }

}