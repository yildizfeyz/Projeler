package com.feyzullah.trabzonbelediyesi.trabzonbelediyesi_binayeriyol;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.content.ContentResolver;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;

import im.delight.android.location.SimpleLocation;


public class Bina_14 extends Fragment {



    public Bina_14() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    private SimpleLocation location;
    Cursor cursorKayit;
    public void KayitGetir()
    {
        Bina_verilerListe.sifirla();
        while (cursorKayit.moveToNext()) {
            Bina_verilerListe.id.add(Integer.toString(cursorKayit.getInt(cursorKayit.getColumnIndex("_id"))));
        }
        cursorKayit.close();
    }


    public class ArkaPlanKaydet extends AsyncTask<Void, Void, Void> {

        AlertDialog bilgi;
        Bina_veritabani database = new Bina_veritabani(getContext());
        Bina_Resimler resim_kayit = new Bina_Resimler(getContext());
        ProgressDialog pdialog;
        int hata = 0;
        String dosyalar[];
        int snc;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            pdialog=new ProgressDialog(getContext());
            pdialog.setCancelable(false);
            pdialog.setMessage("Kaydediliyor...");
            pdialog.show();

            /*
            bilgi = new AlertDialog.Builder(getContext())
                    .setTitle("Kaydediliyor!")
                    .setMessage("Lütfen Bekleyin...")
                    .create();
            bilgi.show();
            */
            location = new SimpleLocation(getContext());
            if (!location.hasLocationEnabled()) {
                SimpleLocation.openSettings(getContext());
            }

            dosyalar = new String[Bina_veriler.Resimler.size()];
            for(int i = 0; i < dosyalar.length; i++)
            {
                dosyalar[i] = Bina_veriler.Resimler.get(i);
            }

        }

        @Override
        protected Void doInBackground(Void... params) {


            String latitude = Double.toString(location.getLatitude());   //enlem
            String longitude = Double.toString(location.getLongitude()); // boylam
            String altitude = Double.toString(location.getAltitude());   //yukseklik
            Bina_veriler.location_x = latitude;
            Bina_veriler.location_y = longitude;

            snc = database.kayıtEkleme(database);

            cursorKayit = database.kayitGor(database);
            KayitGetir();


            int boyut = (Bina_veriler.ickapino.size() > Bina_veriler.baskakapino.size()) ? Bina_veriler.ickapino.size() : Bina_veriler.baskakapino.size();

            Bina_Resimler.kayıtEkleme(resim_kayit, Bina_verilerListe.id.get(Bina_verilerListe.id.size() - 1), boyut);







            Bitmap bmImg = null;
            Canvas canvas;
            Paint paint;
            File file;
            FileOutputStream fOut = null;
            for(int i = 0; i < Bina_veriler.Resimler.size(); i++)
            {
                try
                {
                    if (bmImg != null) {

                        bmImg.recycle();
                        bmImg = null;

                    }
                    bmImg = BitmapFactory.decodeFile(dosyalar[i]);
                    bmImg = bmImg.copy(Bitmap.Config.ARGB_8888, true);
                    canvas = new Canvas(bmImg);

                    Paint backpaint = new Paint();
                    backpaint.setColor(Color.BLACK);
                    backpaint.setStyle(Paint.Style.FILL_AND_STROKE);
                    backpaint.setStrokeWidth(10);

                    paint = new Paint();
                    paint.setColor(Color.WHITE);
                    paint.setTextSize((int) ((bmImg.getWidth() / 10) * 0.6));
                    paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));

                    canvas.drawRect(0, bmImg.getHeight() - (int)((bmImg.getWidth() / 10) * 0.6), bmImg.getWidth(), bmImg.getHeight() , backpaint);
                    canvas.drawText("x: " + latitude + "  y: " + longitude + "  z: " + altitude
                            , 0, bmImg.getHeight() - 5, paint);
                    file = new File(Bina_veriler.Resimler.get(i));
                    fOut = new FileOutputStream(file);
                    bmImg.compress(Bitmap.CompressFormat.PNG, 100, fOut);


                } catch (Exception ex)
                {
                    hata = 1;
                    break;
                }


            }
            try {
                fOut.flush();
                fOut.close();
            }
            catch (Exception ex) { }


            return null;
        }

        public  boolean deleteDir(File dir)
        {
            if (dir != null && dir.isDirectory()) {
                String[] children = dir.list();
                for (int i = 0; i < children.length; i++) {
                    boolean success = deleteDir(new File(dir, children[i]));
                    if (!success) {
                        return false;
                    }
                }
            }
            return dir.delete();
        }

        @Override
        protected void onPostExecute(Void result) {

            if (snc == -1 || hata == 1)
                Toast.makeText(getContext(), "Hata: Kaydedilemedi! snc:" + snc + " hata: " + hata, Toast.LENGTH_SHORT).show();
            else {



                Toast.makeText(getContext(), "Başarıyla kaydedildi!", Toast.LENGTH_SHORT).show();
                File cache;
                cache = getContext().getCacheDir();
                File appDir = new File(cache.getParent());
                if (appDir.exists()) {
                    String[] children = appDir.list();
                    for (String s : children) {
                        if (!s.equals("lib")) {

                            deleteDir(new File(appDir, s));
                            //Log.i("TAG", "**************** File /data/data/APP_PACKAGE/" + s + " DELETED *******************");
                        }
                    }
                }
                Bina_veriler.sifirla();


                /*
                Context context = getContext();
                Intent i = context.getPackageManager()
                        .getLaunchIntentForPackage( context.getPackageName() );
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                System.exit(2);
                */
                pdialog.dismiss();
                startActivity(new Intent(getContext(), Bina_tercih.class));
            }

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bina_14, container, false);


        final com.beardedhen.androidbootstrap.BootstrapButton loc_button = (com.beardedhen.androidbootstrap.BootstrapButton)view.findViewById(R.id.bina_locationBTN);

        location = new SimpleLocation(getContext());
        if (!location.hasLocationEnabled()) {
            loc_button.setText("GPS(Konum) Açık Değil. | Yenile");
        }
        else {
            loc_button.setText("X: " + Double.toString(location.getLatitude()) + " Y: " + Double.toString(location.getLongitude()) + " | Yenile");

        }

        loc_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                location = new SimpleLocation(getContext());
                if (!location.hasLocationEnabled()) {
                    loc_button.setText("GPS(Konum) Açık Değil. | Yenile");
                }
                else {
                    loc_button.setText("X: " + Double.toString(location.getLatitude()) + " Y: " + Double.toString(location.getLongitude()) + " | Yenile");

                }
            }
        });
        com.beardedhen.androidbootstrap.BootstrapButton kaydet = (com.beardedhen.androidbootstrap.BootstrapButton)view.findViewById(R.id.bina_kaydetBTN);

        if(Bina_veriler.islem == 1) kaydet.setText("GÜNCELLE"); else kaydet.setText("KAYDET");

        kaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    Bina_veritabani database = new Bina_veritabani(getContext());
                    if (Bina_veriler.islem == 1) {

                        database.kayıtGuncelle(database, Bina_veriler.id);
                        Toast.makeText(getContext(), "Başarıyla Güncellendi!", Toast.LENGTH_SHORT).show();
                        Bina_verilerListe.sifirla();
                        startActivity(new Intent(getContext(), Bina_Kayitlar.class));
                    } else {

                        if (Bina_veriler.geocode.length() > 0)
                            new ArkaPlanKaydet().execute((Void) null);
                        else
                            Toast.makeText(getContext(), "Geocode boş bırakılamaz!", Toast.LENGTH_LONG).show();

                    }

                } catch (Exception ex) {
                    Toast.makeText(getContext(), ex.getMessage().toString(), Toast.LENGTH_LONG).show();
                }
            }
        });
        return view;
    }




}
