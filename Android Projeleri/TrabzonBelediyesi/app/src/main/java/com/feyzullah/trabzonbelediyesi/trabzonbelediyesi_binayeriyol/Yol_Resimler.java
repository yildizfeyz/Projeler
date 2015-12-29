package com.feyzullah.trabzonbelediyesi.trabzonbelediyesi_binayeriyol;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.os.Environment;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by feyzullah on 8.11.2015.
 */
public class Yol_Resimler extends SQLiteOpenHelper {
    private static final String Veritabani_Adi = "YolResimlerVeritabani.db";
    private static final int Veritabani_Version = 1;
    public Yol_Resimler(Context context) {
        super(context, Environment.getExternalStorageDirectory()
                + File.separator + "/TrabzonBelediyesi/" + File.separator
                + Veritabani_Adi, null, Veritabani_Version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE YolResimlerTablosu(ID INTEGER primary key AUTOINCREMENT, _id String, resim String);");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST YolResimlerTablosu");
        onCreate(db);
    }
    public static int kayıtEkleme(Yol_Resimler database, String id, int boyut){



        SQLiteDatabase db;
        ContentValues veriler;

        for(int h = 0; h < boyut; h++) {
            for (int i = 0; i < Yol_veriler.Resimler.size(); i++) {

                db = database.getWritableDatabase();
                veriler = new ContentValues();
                veriler.put("_id", id);
                veriler.put("resim", Yol_veriler.Resimler.get(i));


                int ex = (int) db.insert("YolResimlerTablosu", null, veriler);
                if (ex == -1) return 0;
            }
            id = Integer.toString(Integer.parseInt(id) - 1);
        }
        return 1;
    }

    public static List<String> KayitSorgula(Yol_Resimler database, String id){

        Bitmap bitmap;
        String[] sutunlar = {"_id", "resim"};
        SQLiteDatabase db = database.getReadableDatabase();

        Cursor cursorKayit = db.rawQuery("SELECT * FROM YolResimlerTablosu WHERE _id="+id, null); //db.query("IsyeriResimlerTablosu", sutunlar, "_id", null, "_id", "_id=" + id, null, null);
        List<String> resimler = new ArrayList<String>();
        if (cursorKayit.getCount()!=0)
        {

            while(cursorKayit.moveToNext()){
                String _resim = cursorKayit.getString(cursorKayit.getColumnIndex("resim"));

                resimler.add(_resim);
            }
            cursorKayit.close();
        }else{

        }
        return resimler;
    }


    public void HerSeyiSil(Yol_Resimler database)
    {
        SQLiteDatabase db = database.getWritableDatabase();
        db.delete("YolResimlerTablosu", null, null);
    }


}
