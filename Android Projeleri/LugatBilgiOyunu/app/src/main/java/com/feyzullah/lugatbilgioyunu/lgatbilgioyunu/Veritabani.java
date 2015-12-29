package com.feyzullah.lugatbilgioyunu.lgatbilgioyunu;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Veritabani extends SQLiteOpenHelper {
    private static final String Veritabani_Adi = "Yol_Veritabani.db";
    private static final int Veritabani_Version = 1;
    public Veritabani(Context context) {
        super(context, Veritabani_Adi, null, Veritabani_Version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE YolTablosu(_id INTEGER primary key AUTOINCREMENT,"
                + " toplamsoru String , dogrucevap String, yanliscevap String, saat String, dakika String, saniye String);");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST YolTablosu");
        onCreate(db);
    }
    public int kayıtEkleme(Veritabani database, String toplamsoru, String dogrucevap, String yanliscevap, String saat, String dakika, String saniye){

        int size = 0;
        SQLiteDatabase db = database.getWritableDatabase();


        ContentValues veriler = new ContentValues();
        veriler.put("toplamsoru", toplamsoru);
        veriler.put("dogrucevap", dogrucevap);
        veriler.put("yanliscevap", yanliscevap);
        veriler.put("saat", saat);
        veriler.put("dakika", dakika);
        veriler.put("saniye", saniye);

        int ex = (int) db.insert("YolTablosu", null, veriler);

        if(ex == -1) return 0;


        return 1;
    }


    public static int kayıtGuncelle(Veritabani database, String toplamsoru, String dogrucevap, String yanliscevap){


        SQLiteDatabase db = database.getWritableDatabase();

        ContentValues veriler = new ContentValues();
        veriler.put("toplamsoru", toplamsoru);
        veriler.put("dogrucevap", dogrucevap);
        veriler.put("yanliscevap", yanliscevap);


        int ex = (int) db.update("YolTablosu", veriler, "_id=" + 1, null);
        if(ex == -1) return 0;


        return 1;
    }


    public Cursor kayitGor(Veritabani database){

        String[] sutunlar = {"_id", "toplamsoru","dogrucevap", "yanliscevap","saat","dakika","saniye"};

        SQLiteDatabase db = database.getReadableDatabase();
        Cursor cursorKayit = db.query("YolTablosu", sutunlar,
                null, null, null, null, null);

        return cursorKayit;
    }


    public void soruat(Veritabani database, int durum)
    {
        SQLiteDatabase db = database.getReadableDatabase();

        Cursor csr = kayitGor(this);

        csr.moveToNext();
        int toplamsoru = Integer.parseInt(csr.getString(csr.getColumnIndex("toplamsoru")));
        int dogrucevap = Integer.parseInt(csr.getString(csr.getColumnIndex("dogrucevap")));
        int yanliscevap = Integer.parseInt(csr.getString(csr.getColumnIndex("yanliscevap")));

        toplamsoru++;
        if(durum == 1) dogrucevap++;
        else yanliscevap++;

        ContentValues veriler = new ContentValues();
        veriler.put("toplamsoru", String.valueOf(toplamsoru));
        veriler.put("dogrucevap", String.valueOf(dogrucevap));
        veriler.put("yanliscevap", String.valueOf(yanliscevap));


        int ex = (int) db.update("YolTablosu", veriler, "_id=" + 1, null);
    }

    public void saniyeat(Veritabani database)
    {
        SQLiteDatabase db = database.getReadableDatabase();

        Cursor csr = kayitGor(this);

        csr.moveToNext();
        int saat = Integer.parseInt(csr.getString(csr.getColumnIndex("saat")));
        int dakika = Integer.parseInt(csr.getString(csr.getColumnIndex("dakika")));
        int saniye = Integer.parseInt(csr.getString(csr.getColumnIndex("saniye")));

        if(saniye != 59)
        {
            saniye++;
        }
        else if(dakika != 59)
        {
            dakika++;
            saniye = 0;
        }
        else
        {
            saat++;
            dakika = 0;
            saniye = 0;
        }

        ContentValues veriler = new ContentValues();
        veriler.put("saat", String.valueOf(saat));
        veriler.put("dakika", String.valueOf(dakika));
        veriler.put("saniye", String.valueOf(saniye));


        int ex = (int) db.update("YolTablosu", veriler, "_id=" + 1, null);

    }


    public void kayitSil(Veritabani database, String id)
    {
        SQLiteDatabase db = database.getWritableDatabase();
        db.delete("YolTablosu", "_id=1", null);
    }

}