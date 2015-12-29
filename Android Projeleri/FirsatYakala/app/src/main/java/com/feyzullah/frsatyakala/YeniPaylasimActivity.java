package com.feyzullah.frsatyakala;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import im.delight.android.location.SimpleLocation;

public class YeniPaylasimActivity extends AppCompatActivity {

    String gonderen;
    String nevar;
    ImageView imgview1;
    ImageView imgview2;
    ImageView imgview3;
    int rsm = 0;
    String resim1 = "0";
    String resim2 = "0";
    String resim3 = "0";


    private static final int CAMERA_REQUEST = 1888;

    SimpleLocation location;
    ProgressDialog pdialog;

    EditText nerede_edt;
    EditText aciklama_edt;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yeni_paylasim);

        setTitle("Paylaş");

        android.support.v7.app.ActionBar actionbar = getSupportActionBar();
        actionbar.setBackgroundDrawable(getResources().getDrawable(R.drawable.action_background));

        actionbar.setHomeButtonEnabled(true);

        // navigationu t?klanabilir hale getiriyoruz
        actionbar.setDisplayHomeAsUpEnabled(true);


        context = this;
        pdialog = new ProgressDialog(this);

        Spinner spinnerAndroidVersion;
        String [] androidVersion;
        androidVersion =getResources().getStringArray(R.array.spinnerVeriler);
        spinnerAndroidVersion =(Spinner) findViewById(R.id.yenipaylasim_nevar);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,androidVersion);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAndroidVersion.setAdapter(arrayAdapter);
        spinnerAndroidVersion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                // TODO Auto-generated method stub
                nevar = arg0.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Veritabani vt = new Veritabani(this);

        gonderen = vt.kayitGor(vt).getString(1).toString();
        imgview1 = (ImageView) findViewById(R.id.yenipaylasim_imageView);
        imgview2 = (ImageView) findViewById(R.id.yenipaylasim_imageView2);
        imgview3 = (ImageView) findViewById(R.id.yenipaylasim_imageView3);

        com.beardedhen.androidbootstrap.BootstrapButton foto_btn = (com.beardedhen.androidbootstrap.BootstrapButton) findViewById(R.id.yenipaylasim_btn_foto);
        com.beardedhen.androidbootstrap.BootstrapButton paylas_btn = (com.beardedhen.androidbootstrap.BootstrapButton) findViewById(R.id.yenipaylasim_btn_paylas);
        nerede_edt = (EditText) findViewById(R.id.yenipaylasim_nerede);
        aciklama_edt = (EditText) findViewById(R.id.yenipaylasim_aciklama);


        foto_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(rsm < 3) {
                    Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(cameraIntent, CAMERA_REQUEST);
                } else {
                    Toast.makeText(v.getContext(), "En fazla 3 resim eklenebilir" , Toast.LENGTH_LONG).show();
                }
            }
        });



        paylas_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(nerede_edt.getText().toString().length() > 0 && aciklama_edt.getText().toString().length() > 0) {

                    location = new SimpleLocation(v.getContext());
                    if (!location.hasLocationEnabled()) {
                        SimpleLocation.openSettings(v.getContext());
                    }
                    if (location.getLatitude() != 0.0 && location.getLongitude() != 0.0)
                        new ArkaPlanKaydet().execute((Void) null);
                    else
                        Toast.makeText(v.getContext(), "GPS bilgisi alınamıyor", Toast.LENGTH_SHORT).show();

                }
                else {
                    Toast.makeText(v.getContext(), "Nerede ve Açıklama alanları boş bırakılamaz", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    public class ArkaPlanKaydet extends AsyncTask<Void, Void, Void> {


        String nerede;
        String aciklama;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();


            nerede = nerede_edt.getText().toString();
            aciklama = aciklama_edt.getText().toString();
            pdialog.setCancelable(false);
            pdialog.setMessage("Hazırlanıyor...");
            pdialog.show();




        }

        ListViewAdapter adapter;

        @Override
        protected Void doInBackground(Void... params) {

            Date simdikiZaman = new Date();
            DateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm");
            String latitude = Double.toString(location.getLatitude());   //enlem
            String longitude = Double.toString(location.getLongitude()); // boylam



            WebService ws = new WebService();
            ws.paylasim_ekle(gonderen,df.format(simdikiZaman), nerede,nevar,aciklama, latitude, longitude,resim1,resim2,resim3,String.valueOf(rsm));


            return null;
        }



        @Override
        protected void onPostExecute(Void result) {


            pdialog.dismiss();

            Toast.makeText(context, "Paylaşım yapıldı...", Toast.LENGTH_LONG).show();

            Bundle veriler = new Bundle();
            veriler.putString("gonderen", gonderen);
            Intent intent = new Intent(context, MainActivity.class);
            intent.putExtras(veriler);
            startActivity(intent);
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
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
            rsm++;
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            if(rsm == 1) { imgview1.setImageBitmap(photo); resim1 = WebService.bitmapTOstring(photo); }
            if(rsm == 2) { imgview2.setImageBitmap(photo); resim2 = WebService.bitmapTOstring(photo); }
            if(rsm == 3) { imgview3.setImageBitmap(photo); resim3 = WebService.bitmapTOstring(photo); }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_yeni_paylasim, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        if(id == android.R.id.home)
        {
            super.onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }
}
