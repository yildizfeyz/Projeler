package com.feyzullah.trabzonbelediyesi.trabzonbelediyesi_binayeriyol;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.SystemClock;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;


import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import im.delight.android.location.SimpleLocation;

public class MainActivity extends AppCompatActivity {



    public class ArkaPlanKaydet extends AsyncTask<Void, Void, Void> {



        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            MainActivity.this.setContentView(R.layout.main_intro);



        }

        @Override
        protected Void doInBackground(Void... params) {

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {



            MainActivity.this.setContentView(R.layout.activity_main);
            super.onPostExecute(result);
        }



        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onCancelled(Void result) {
            super.onCancelled(result);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        getSupportActionBar().hide();



        new ArkaPlanKaydet().execute((Void) null);








/*
Veritabanı taşıma
try {

                    InputStream myInput = new FileInputStream(getApplicationContext().getCacheDir().getParent() + "/databases/Veritabanim");

                    File directory = new File("/sdcard/TrabzonBelediyesi");
                    if (!directory.exists()) {
                        directory.mkdirs();
                    }

                    OutputStream myOutput = new FileOutputStream(directory.getPath() + "/Veritabanim.db");

                    byte[] buffer = new byte[1024];
                    int length;
                    while ((length = myInput.read(buffer)) > 0) {
                        myOutput.write(buffer, 0, length);
                    }

                    myOutput.flush();
                    myOutput.close();
                    myInput.close();

                }catch (Exception ex) { }
 */


/*

        com.beardedhen.androidbootstrap.BootstrapButton bina = (com.beardedhen.androidbootstrap.BootstrapButton)findViewById(R.id.imageButton);
        bina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Bina_tercih.class);
                startActivity(intent);


            }
        });

        com.beardedhen.androidbootstrap.BootstrapButton bina2 = (com.beardedhen.androidbootstrap.BootstrapButton)findViewById(R.id.imageButton2);
        bina2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Yol_tercih.class);
                startActivity(intent);

            }
        });
        com.beardedhen.androidbootstrap.BootstrapButton img3 = (com.beardedhen.androidbootstrap.BootstrapButton)findViewById(R.id.imageButton3);
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Isyeri_tercih.class);
                startActivity(intent);

            }
        });
        */
    }

    public void onInfo(View v)
    {
        new AlertDialog.Builder(v.getContext())
                .setIcon(R.drawable.infoicon)
                .setTitle("Geliştiren")
                .setMessage("Feyzullah YILDIZ\n\nİletişim:\nyildiz0493@gmail.com")
                .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //do things
                    }
                })
                .create().show();
    }

    public void onBina(View v)
    {
        Intent intent = new Intent(getApplicationContext(), Bina_tercih.class);
        startActivity(intent);
    }

    public void onYol(View v)
    {
        Intent intent = new Intent(getApplicationContext(), Yol_tercih.class);
        startActivity(intent);
    }

    public void onIsyeri(View v)
    {
        Intent intent = new Intent(getApplicationContext(), Isyeri_tercih.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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




    private class ExportDatabaseCSVTask extends AsyncTask<Void, Void, Void> {

        // to show Loading dialog box
        @Override
        protected void onPreExecute() {
        }

        // to write process
        protected Void doInBackground(Void... args) {

            //File dbFile = getDatabasePath("MyDBName.db");
            Bina_veritabani dbhelper = new Bina_veritabani(getApplicationContext());
            File exportDir = new File(Environment.getExternalStorageDirectory(), "");
            if (!exportDir.exists())
            {
                exportDir.mkdirs();
            }

            File file = new File(exportDir, "csvname.csv");
            /*
            CSVWriter csvWrite = new CSVWriter(new FileWriter(file));
                SQLiteDatabase db = dbhelper.getReadableDatabase();
                Cursor curCSV = db.rawQuery("SELECT * FROM BinaTablosu",null);
                csvWrite.writeNext(curCSV.getColumnNames());
                while(curCSV.moveToNext())
                {
                    //Which column you want to exprort
                    String arrStr[] ={curCSV.getString(0),curCSV.getString(1), curCSV.getString(2)};
                    csvWrite.write
                    csvWrite.writeNext(arrStr);
                }
                csvWrite.close();
                curCSV.close();
             */

            try
            {
                file.createNewFile();

                //CsvWriter csvWrite = new CsvWriter(file.getPath());
                SQLiteDatabase db = dbhelper.getReadableDatabase();
                Cursor curCSV = db.rawQuery("SELECT * FROM BinaTablosu",null);
                //csvWrite.w(curCSV.getColumnNames());
                while(curCSV.moveToNext())
                {
                    //Which column you want to exprort
                    String arrStr[] ={curCSV.getString(0),curCSV.getString(1), curCSV.getString(2)};
                    //csvWrite.write(curCSV.getString(0));
                    //csvWrite.write(curCSV.getString(1));
                    //csvWrite.

                    //csvWrite.writeNext(arrStr);
                }
                //csvWrite.close();
                curCSV.close();
            }
            catch(Exception sqlEx)
            {
               // Log.e("MainActivity", sqlEx.getMessage(), sqlEx);
            }
            return null;
        }

        // close dialog and give msg
        protected void onPostExecute(Void success) {
           Toast.makeText(getApplicationContext(),"Tamam",Toast.LENGTH_LONG).show();
        }
    }


}
