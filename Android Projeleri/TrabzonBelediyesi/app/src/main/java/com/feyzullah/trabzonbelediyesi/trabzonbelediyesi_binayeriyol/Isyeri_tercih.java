package com.feyzullah.trabzonbelediyesi.trabzonbelediyesi_binayeriyol;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Isyeri_tercih extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isyeri_tercih);

        getSupportActionBar().hide();
        ((com.beardedhen.androidbootstrap.BootstrapButton)findViewById(R.id.Isyeri_yeniekleBTN)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Isyeri_veriler.sifirla();
                Isyeri_veriler.islem = 0;
                Intent intent = new Intent(getApplicationContext(), Isyeri.class);
                startActivity(intent);
            }
        });

        ((com.beardedhen.androidbootstrap.BootstrapButton)findViewById(R.id.Isyeri_kayitgorBTN)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Isyeri_verilerListe.sifirla();
                    Intent intent = new Intent(getApplicationContext(), Isyeri_Kayitlar.class);
                    startActivity(intent);
                } catch (Exception ex) {
                    Toast.makeText(getApplicationContext(), ex.getMessage().toString(), Toast.LENGTH_LONG).show();
                }
            }
        });

        final AlertDialog silBuilder = new AlertDialog.Builder(this)
                .setTitle("Herşey Siliniyor")
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
                        Isyeri_veritabani vt = new Isyeri_veritabani(getApplicationContext());
                        Isyeri_Resimler rsm = new Isyeri_Resimler(getApplicationContext());
                        vt.HerSeyiSil(vt);
                        rsm.HerSeyiSil(rsm);
                        Toast.makeText(getApplicationContext(), "Başarıyla Silindi!", Toast.LENGTH_LONG).show();
                    }
                })
                .create();

        ((com.beardedhen.androidbootstrap.BootstrapButton)findViewById(R.id.Isyeri_silBTN)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    silBuilder.show();

                }catch (Exception ex) {
                    Toast.makeText(getApplicationContext(),ex.getMessage().toString(),Toast.LENGTH_LONG).show();
                }
            }
        });

        ((com.beardedhen.androidbootstrap.BootstrapButton)findViewById(R.id.Isyeri_excelBTN)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    try{
                        // Creating Input Stream
                        File exportDir = new File(Environment.getExternalStorageDirectory(), "");
                        if (!exportDir.exists())
                        {
                            exportDir.mkdirs();
                        }

                        File file = new File(exportDir, "TrabzonBelediyesi_Isyeri.xls");

                        //new FileWriter(file);
                        boolean success = false;

                        //New Workbook
                        Workbook wb = new HSSFWorkbook();

                        Cell c = null;

                        //Cell style for header row
                        CellStyle cs = wb.createCellStyle();
                        //cs.setFillForegroundColor(HSSFColor.LIME.index);
                        //cs.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

                        //New Sheet
                        Sheet sheet1 = null;
                        sheet1 = wb.createSheet("myOrder");

                        // Generate column headings
                        Row row = sheet1.createRow(0);

                        c = row.createCell(0);  c.setCellValue("Ticari Kod"); c.setCellStyle(cs);
                        c = row.createCell(1);  c.setCellValue("İşletme Türü"); c.setCellStyle(cs);
                        c = row.createCell(2);  c.setCellValue("İç Kapı No"); c.setCellStyle(cs);
                        c = row.createCell(3);  c.setCellValue("İşletme Adı"); c.setCellStyle(cs);
                        c = row.createCell(4);  c.setCellValue("Mülkiyet Durumu"); c.setCellStyle(cs);
                        c = row.createCell(5);  c.setCellValue("Adı Soyadı"); c.setCellStyle(cs);
                        c = row.createCell(6);  c.setCellValue("TC No"); c.setCellStyle(cs);
                        c = row.createCell(7);  c.setCellValue("Vergi No"); c.setCellStyle(cs);
                        c = row.createCell(8);  c.setCellValue("Telefon"); c.setCellStyle(cs);
                        c = row.createCell(9);  c.setCellValue("Web Adresi"); c.setCellStyle(cs);
                        c = row.createCell(10);  c.setCellValue("Location X"); c.setCellStyle(cs);
                        c = row.createCell(11);  c.setCellValue("Location Y"); c.setCellStyle(cs);



                        Isyeri_veritabani vt = new Isyeri_veritabani(v.getContext());
                        Cursor cursorKayit = vt.kayitGor(vt);

                        for(int satir = 1; satir <= cursorKayit.getCount();satir++)
                        {
                            cursorKayit.moveToNext();
                            row = sheet1.createRow(satir);
                            c = row.createCell(0);  c.setCellValue(cursorKayit.getString(cursorKayit.getColumnIndex("ticarikod"))); c.setCellStyle(cs);
                            c = row.createCell(1);  c.setCellValue(cursorKayit.getString(cursorKayit.getColumnIndex("isletmeturu"))); c.setCellStyle(cs);
                            c = row.createCell(2);  c.setCellValue(cursorKayit.getString(cursorKayit.getColumnIndex("ickapino"))); c.setCellStyle(cs);
                            c = row.createCell(3);  c.setCellValue(cursorKayit.getString(cursorKayit.getColumnIndex("isletmeadi"))); c.setCellStyle(cs);
                            c = row.createCell(4);  c.setCellValue(cursorKayit.getString(cursorKayit.getColumnIndex("mulkiyetdurumu"))); c.setCellStyle(cs);
                            c = row.createCell(5);  c.setCellValue(cursorKayit.getString(cursorKayit.getColumnIndex("adisoyadi"))); c.setCellStyle(cs);
                            c = row.createCell(6);  c.setCellValue(cursorKayit.getString(cursorKayit.getColumnIndex("tcno"))); c.setCellStyle(cs);
                            c = row.createCell(7);  c.setCellValue(cursorKayit.getString(cursorKayit.getColumnIndex("vergino"))); c.setCellStyle(cs);
                            c = row.createCell(8);  c.setCellValue(cursorKayit.getString(cursorKayit.getColumnIndex("telefon"))); c.setCellStyle(cs);
                            c = row.createCell(9);  c.setCellValue(cursorKayit.getString(cursorKayit.getColumnIndex("webadresi"))); c.setCellStyle(cs);
                            c = row.createCell(10); c.setCellValue(cursorKayit.getString(cursorKayit.getColumnIndex("location_x"))); c.setCellStyle(cs);
                            c = row.createCell(11); c.setCellValue(cursorKayit.getString(cursorKayit.getColumnIndex("location_y"))); c.setCellStyle(cs);

                        }

                        int genislik = (15 * 500);
                        sheet1.setColumnWidth(0, genislik); sheet1.setColumnWidth(8, genislik);
                        sheet1.setColumnWidth(1, genislik); sheet1.setColumnWidth(9, genislik);
                        sheet1.setColumnWidth(2, genislik); sheet1.setColumnWidth(10, genislik);
                        sheet1.setColumnWidth(3, genislik); sheet1.setColumnWidth(11, genislik);
                        sheet1.setColumnWidth(4, genislik);
                        sheet1.setColumnWidth(5, genislik);
                        sheet1.setColumnWidth(6, genislik);
                        sheet1.setColumnWidth(7, genislik);
                        // Create a path where we will place our List of objects on external storage
                        //File file = new File(context.getExternalFilesDir(null), fileName);
                        FileOutputStream os = null;

                        try {
                            os = new FileOutputStream(file);
                            wb.write(os);
                            //Log.w("FileUtils", "Writing file" + file);
                            success = true;
                            new AlertDialog.Builder(v.getContext())
                                    .setTitle("Excel Dosyası Oluşturuldu!")
                                    .setMessage("Dosya Yolu: \"" + file.getPath() + "\"")
                                    .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            //do things
                                        }
                                    })
                                    .create().show();
                        } catch (IOException e) {
                            //Log.w("FileUtils", "Error writing " + file, e);
                        } catch (Exception e) {
                            //Log.w("FileUtils", "Failed to save file", e);
                        } finally {
                            try {
                                if (null != os)
                                    os.close();
                            } catch (Exception ex) {
                            }
                        }


                    }catch (Exception e){Toast.makeText(getApplicationContext(),e.getMessage().toString(),Toast.LENGTH_LONG).show(); e.printStackTrace(); }



            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_isyeri_tercih, menu);
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
