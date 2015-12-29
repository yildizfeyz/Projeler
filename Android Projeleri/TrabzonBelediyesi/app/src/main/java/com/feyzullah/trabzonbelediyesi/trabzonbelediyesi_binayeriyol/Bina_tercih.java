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

public class Bina_tercih extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bina_tercih);
        getSupportActionBar().hide();
        ((com.beardedhen.androidbootstrap.BootstrapButton)findViewById(R.id.Bina_yeniekleBTN)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bina_veriler.sifirla();

                Bina_veriler.Bina10_adapter = new Bina_10_listviewAdapter(getApplicationContext());

                Bina_veriler.ickapino.add("İç Kapı No");
                Bina_veriler.nitelik.add("Nitelik");
                Bina_veriler.nitelikkodu.add("Nitelik Kodu");

                Bina_veriler.Bina11_adapter = new Bina_11_listviewAdapter(getApplicationContext());
                Bina_veriler.baskakapino.add("Kapı No");
                Bina_veriler.baskamahalleadi.add("Cadde/Sokak Adı");
                Bina_veriler.baskadusunceler.add("Düşünceler");

                Bina_veriler.Bina13_adapter = new Bina_13_gridviewAdapter(getApplicationContext());

                Bina_veriler.islem = 0;
                Intent intent = new Intent(getApplicationContext(), Bina.class);
                startActivity(intent);
            }
        });

        ((com.beardedhen.androidbootstrap.BootstrapButton)findViewById(R.id.Bina_kayitgorBTN)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Bina_verilerListe.sifirla();
                    Intent intent = new Intent(getApplicationContext(), Bina_Kayitlar.class);
                    startActivity(intent);
                }catch (Exception ex) {
                    Toast.makeText(getApplicationContext(),ex.getMessage().toString(),Toast.LENGTH_LONG).show();
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
                        Bina_veritabani vt = new Bina_veritabani(getApplicationContext());
                        Bina_Resimler rsm = new Bina_Resimler(getApplicationContext());
                        vt.HerSeyiSil(vt);
                        rsm.HerSeyiSil(rsm);
                        Toast.makeText(getApplicationContext(), "Başarıyla Silindi!", Toast.LENGTH_LONG).show();
                    }
                })
                .create();

        ((com.beardedhen.androidbootstrap.BootstrapButton)findViewById(R.id.Bina_silBTN)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {


                    silBuilder.show();

                }catch (Exception ex) {
                    Toast.makeText(getApplicationContext(),ex.getMessage().toString(),Toast.LENGTH_LONG).show();
                }
            }
        });

        ((com.beardedhen.androidbootstrap.BootstrapButton)findViewById(R.id.Bina_excelBTN)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    try{
                        // Creating Input Stream
                        File exportDir = new File(Environment.getExternalStorageDirectory(), "");
                        if (!exportDir.exists())
                        {
                            exportDir.mkdirs();
                        }

                        File file = new File(exportDir, "TrabzonBelediyesi_Bina.xls");

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

                        c = row.createCell(0);  c.setCellValue("Bina Geocode"); c.setCellStyle(cs);
                        c = row.createCell(1);  c.setCellValue("Mahalle Adı"); c.setCellStyle(cs);
                        c = row.createCell(2);  c.setCellValue("Cadde/Sokak Adı"); c.setCellStyle(cs);
                        c = row.createCell(3);  c.setCellValue("Cadde/Sokak Kodu"); c.setCellStyle(cs);
                        c = row.createCell(4);  c.setCellValue("Kapı No"); c.setCellStyle(cs);
                        c = row.createCell(5);  c.setCellValue("Site Adı"); c.setCellStyle(cs);
                        c = row.createCell(6);  c.setCellValue("Apartman Blok Adı"); c.setCellStyle(cs);
                        c = row.createCell(7);  c.setCellValue("Bina Halihazır Durumu"); c.setCellStyle(cs);
                        c = row.createCell(8);  c.setCellValue("Dış Cephe Durumu"); c.setCellStyle(cs);
                        c = row.createCell(9);  c.setCellValue("Yapı Durumu"); c.setCellStyle(cs);
                        c = row.createCell(10); c.setCellValue("Çatı Durumu"); c.setCellStyle(cs);
                        c = row.createCell(11); c.setCellValue("Yapı Sistemleri"); c.setCellStyle(cs);
                        c = row.createCell(12); c.setCellValue("Kullanılan Malzeme"); c.setCellStyle(cs);
                        c = row.createCell(13); c.setCellValue("Ortak Kullanım"); c.setCellStyle(cs);
                        c = row.createCell(14); c.setCellValue("Diğer Bilgiler"); c.setCellStyle(cs);
                        c = row.createCell(15); c.setCellValue("Notlar"); c.setCellStyle(cs);
                        c = row.createCell(16); c.setCellValue("Bina Sorumlusu"); c.setCellStyle(cs);
                        c = row.createCell(17); c.setCellValue("Bina Sorumlusu Telefonu"); c.setCellStyle(cs);
                        c = row.createCell(18); c.setCellValue("Bina Kullanım Amacı"); c.setCellStyle(cs);
                        c = row.createCell(19); c.setCellValue("Gelişmişlik Durumu"); c.setCellStyle(cs);
                        c = row.createCell(20); c.setCellValue("İç Kapı No"); c.setCellStyle(cs);
                        c = row.createCell(21); c.setCellValue("Numaralı Yerin Niteliği"); c.setCellStyle(cs);
                        c = row.createCell(22); c.setCellValue("Nitelik Kodu"); c.setCellStyle(cs);
                        c = row.createCell(23); c.setCellValue("Binanın Başka Meydan,Bulvar,Cadde veya Sokağa Açılan varsa"); c.setCellStyle(cs);
                        c = row.createCell(24); c.setCellValue("Kapı No"); c.setCellStyle(cs);
                        c = row.createCell(25); c.setCellValue("Düşünceler"); c.setCellStyle(cs);
                        c = row.createCell(26); c.setCellValue("Location X"); c.setCellStyle(cs);
                        c = row.createCell(27); c.setCellValue("Location Y"); c.setCellStyle(cs);


                        Bina_veritabani vt = new Bina_veritabani(v.getContext());
                        Cursor cursorKayit = vt.kayitGor(vt);

                        for(int satir = 1; satir <= cursorKayit.getCount();satir++)
                        {
                            cursorKayit.moveToNext();
                            row = sheet1.createRow(satir);
                            c = row.createCell(0);  c.setCellValue(cursorKayit.getString(cursorKayit.getColumnIndex("geocode"))); c.setCellStyle(cs);
                            c = row.createCell(1);  c.setCellValue(cursorKayit.getString(cursorKayit.getColumnIndex("mahalleadi"))); c.setCellStyle(cs);
                            c = row.createCell(2);  c.setCellValue(cursorKayit.getString(cursorKayit.getColumnIndex("caddesokakadi"))); c.setCellStyle(cs);
                            c = row.createCell(3);  c.setCellValue(cursorKayit.getString(cursorKayit.getColumnIndex("caddesokakkodu"))); c.setCellStyle(cs);
                            c = row.createCell(4);  c.setCellValue(cursorKayit.getString(cursorKayit.getColumnIndex("kapino"))); c.setCellStyle(cs);
                            c = row.createCell(5);  c.setCellValue(cursorKayit.getString(cursorKayit.getColumnIndex("siteadi"))); c.setCellStyle(cs);
                            c = row.createCell(6);  c.setCellValue(cursorKayit.getString(cursorKayit.getColumnIndex("apartmanadi"))); c.setCellStyle(cs);
                            c = row.createCell(7);  c.setCellValue(cursorKayit.getString(cursorKayit.getColumnIndex("halihazirdurum"))); c.setCellStyle(cs);
                            c = row.createCell(8);  c.setCellValue(cursorKayit.getString(cursorKayit.getColumnIndex("discephe_durumu"))); c.setCellStyle(cs);
                            c = row.createCell(9);  c.setCellValue(cursorKayit.getString(cursorKayit.getColumnIndex("yapidurumu"))); c.setCellStyle(cs);
                            c = row.createCell(10); c.setCellValue(cursorKayit.getString(cursorKayit.getColumnIndex("catidurumu"))); c.setCellStyle(cs);
                            c = row.createCell(11); c.setCellValue(cursorKayit.getString(cursorKayit.getColumnIndex("yapisistemi"))); c.setCellStyle(cs);
                            c = row.createCell(12); c.setCellValue(cursorKayit.getString(cursorKayit.getColumnIndex("kullanilanmalzeme"))); c.setCellStyle(cs);
                            c = row.createCell(13); c.setCellValue(cursorKayit.getString(cursorKayit.getColumnIndex("ortakkullanim"))); c.setCellStyle(cs);
                            c = row.createCell(14); c.setCellValue(cursorKayit.getString(cursorKayit.getColumnIndex("digerbilgiler"))); c.setCellStyle(cs);
                            c = row.createCell(15); c.setCellValue(cursorKayit.getString(cursorKayit.getColumnIndex("notlar"))); c.setCellStyle(cs);
                            c = row.createCell(16); c.setCellValue(cursorKayit.getString(cursorKayit.getColumnIndex("binasorumlusu"))); c.setCellStyle(cs);
                            c = row.createCell(17); c.setCellValue(cursorKayit.getString(cursorKayit.getColumnIndex("sorumlu_tel"))); c.setCellStyle(cs);
                            c = row.createCell(18); c.setCellValue(cursorKayit.getString(cursorKayit.getColumnIndex("kullanimamaci"))); c.setCellStyle(cs);
                            c = row.createCell(19); c.setCellValue(cursorKayit.getString(cursorKayit.getColumnIndex("gelismislik"))); c.setCellStyle(cs);
                            c = row.createCell(20); c.setCellValue(cursorKayit.getString(cursorKayit.getColumnIndex("ickapino"))); c.setCellStyle(cs);
                            c = row.createCell(21); c.setCellValue(cursorKayit.getString(cursorKayit.getColumnIndex("nitelik"))); c.setCellStyle(cs);
                            c = row.createCell(22); c.setCellValue(cursorKayit.getString(cursorKayit.getColumnIndex("nitelikkodu"))); c.setCellStyle(cs);
                            c = row.createCell(23); c.setCellValue(cursorKayit.getString(cursorKayit.getColumnIndex("baskamahalleadi"))); c.setCellStyle(cs);
                            c = row.createCell(24); c.setCellValue(cursorKayit.getString(cursorKayit.getColumnIndex("baskakapino"))); c.setCellStyle(cs);
                            c = row.createCell(25); c.setCellValue(cursorKayit.getString(cursorKayit.getColumnIndex("baskadusunceler"))); c.setCellStyle(cs);
                            c = row.createCell(26); c.setCellValue(cursorKayit.getString(cursorKayit.getColumnIndex("location_x"))); c.setCellStyle(cs);
                            c = row.createCell(27); c.setCellValue(cursorKayit.getString(cursorKayit.getColumnIndex("location_y"))); c.setCellStyle(cs);
                        }

                        int genislik = (15 * 500);
                        sheet1.setColumnWidth(0, genislik); sheet1.setColumnWidth(8, genislik); sheet1.setColumnWidth(16, genislik);
                        sheet1.setColumnWidth(1, genislik); sheet1.setColumnWidth(9, genislik); sheet1.setColumnWidth(17, genislik);
                        sheet1.setColumnWidth(2, genislik); sheet1.setColumnWidth(10, genislik); sheet1.setColumnWidth(18, genislik);
                        sheet1.setColumnWidth(3, genislik); sheet1.setColumnWidth(11, genislik); sheet1.setColumnWidth(19, genislik);
                        sheet1.setColumnWidth(4, genislik); sheet1.setColumnWidth(12, genislik); sheet1.setColumnWidth(20, genislik);
                        sheet1.setColumnWidth(5, genislik); sheet1.setColumnWidth(13, genislik); sheet1.setColumnWidth(21, genislik);
                        sheet1.setColumnWidth(6, genislik); sheet1.setColumnWidth(14, genislik); sheet1.setColumnWidth(22, genislik);
                        sheet1.setColumnWidth(7, genislik); sheet1.setColumnWidth(15, genislik); sheet1.setColumnWidth(23, genislik);
                        sheet1.setColumnWidth(24, genislik); sheet1.setColumnWidth(25, genislik); sheet1.setColumnWidth(26, genislik);
                        sheet1.setColumnWidth(27, genislik);
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
        getMenuInflater().inflate(R.menu.menu_bina_tercih, menu);
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
