package com.feyzullah.frsatyakala;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

import im.delight.android.location.SimpleLocation;

public class MainActivity extends AppCompatActivity {

    int action_spin = 0;
    ProgressDialog pdialog;
    ListView listView;
    Context context;
    private SimpleLocation location;

    String gonderen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Intent intent = getIntent();
        Bundle veriler = intent.getExtras();
        gonderen = veriler.getString("gonderen");
        setTitle("Fırsat Yakala");

        ImageView sohbet = (ImageView) findViewById(R.id.image_chatbtn);
        sohbet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle veriler = new Bundle();
                veriler.putString("gonderen", gonderen);
                Intent intent = new Intent(v.getContext(), SohbetActivity.class);
                intent.putExtras(veriler);
                startActivity(intent);
            }
        });

        ImageView paylastiklarim = (ImageView) findViewById(R.id.image_profilebtn);
        paylastiklarim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle veriler = new Bundle();
                veriler.putString("gonderen", gonderen);
                Intent intent = new Intent(v.getContext(), PaylastiklarimActivity.class);
                intent.putExtras(veriler);
                startActivity(intent);
            }
        });

        android.support.v7.app.ActionBar actionbar = getSupportActionBar();
        actionbar.setBackgroundDrawable(getResources().getDrawable(R.drawable.action_background));

        actionbar.setHomeButtonEnabled(true);

        // navigationu t?klanabilir hale getiriyoruz
        actionbar.setDisplayHomeAsUpEnabled(true);

        actionbar.setHomeAsUpIndicator(R.drawable.action_icon);

        context = this;


        com.beardedhen.androidbootstrap.BootstrapEditText txt_pyls = (com.beardedhen.androidbootstrap.BootstrapEditText) findViewById(R.id.text_paylas);
        txt_pyls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), YeniPaylasimActivity.class));
            }
        });
        listView = (ListView) findViewById(R.id.listView);

        location = new SimpleLocation(getApplicationContext());
        if (!location.hasLocationEnabled()) {
            SimpleLocation.openSettings(this);
        }

        new ArkaPlanKaydet().execute((Void) null);
    }

    int _position = 0;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem item = menu.findItem(R.id.action_spinner);
        final Spinner spinner = (Spinner) MenuItemCompat.getActionView(item);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.action_spinnerVeriler));

        //spinner.setBackgroundColor(Color.parseColor("#ffffff"));

        spinner.setAdapter(adapter); // set the adapter to provide layout of rows and content

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            int eskipos = 0;
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //btn.setEnabled(true);
                //eleman_edt.setEnabled(true);

                ((TextView) parent.getChildAt(0)).setTextColor(Color.BLUE);

                if(position == 0 && eskipos != 0)
                {
                    action_spin = 0;
                    new ArkaPlanKaydet().execute((Void) null);
                    eskipos = 0;
                }
                else if(position == 1 && eskipos != 1)
                {
                    if(location.getLatitude() != 0.0 && location.getLongitude() != 0.0) {
                        action_spin = 1;
                        new ArkaPlanKaydet().execute((Void) null);

                    }
                    else {
                        spinner.setSelection(0);
                        Toast.makeText(view.getContext(),"GPS bilgisi alınamıyor", Toast.LENGTH_LONG).show();
                    }
                    eskipos = 1;
                }
                else if(position == 2 && eskipos != 2 ){
                    if(location.getLatitude() != 0.0 && location.getLongitude() != 0.0) {
                        action_spin = 2;
                        new ArkaPlanKaydet().execute((Void) null);

                    }
                    else {
                        spinner.setSelection(0);
                        Toast.makeText(view.getContext(),"GPS bilgisi alınamıyor", Toast.LENGTH_LONG).show();
                    }
                    eskipos = 2;
                } else if(position == 3 && eskipos != 3 ){
                    if(location.getLatitude() != 0.0 && location.getLongitude() != 0.0) {
                        action_spin = 3;
                        new ArkaPlanKaydet().execute((Void) null);

                    }
                    else {
                        spinner.setSelection(0);
                        Toast.makeText(view.getContext(),"GPS bilgisi alınamıyor", Toast.LENGTH_LONG).show();
                    }
                    eskipos = 3;
                } else if(position == 4 && eskipos != 4 ){
                    if(location.getLatitude() != 0.0 && location.getLongitude() != 0.0) {
                        action_spin = 4;
                        new ArkaPlanKaydet().execute((Void) null);

                    }
                    else {
                        spinner.setSelection(0);
                        Toast.makeText(view.getContext(),"GPS bilgisi alınamıyor", Toast.LENGTH_LONG).show();
                    }
                    eskipos = 4;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }



        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_setting) {
            startActivity(new Intent(getApplicationContext(), AyarlarActivity.class));
            return true;
        }


        return super.onOptionsItemSelected(item);
    }


    public class ArkaPlanKaydet extends AsyncTask<Void, Void, Void> {

        private SimpleLocation location;
        String latitude;
        String longitude;
        String[] paylasimlar;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();


            pdialog = new ProgressDialog(context);
            location = new SimpleLocation(context);

            latitude = Double.toString(location.getLatitude());   //enlem
            longitude = Double.toString(location.getLongitude()); // boylam
            pdialog.setCancelable(false);
            pdialog.setMessage("Hazırlanıyor...");
            pdialog.show();




        }

        ListViewAdapter adapter;
        Bitmap[] bitmap;

        @Override
        protected Void doInBackground(Void... params) {

            WebService ws = new WebService();
            try {
                int uzaklk = 0;
                if(action_spin == 0) uzaklk = 0;
                if(action_spin == 1) uzaklk = 100000;
                if(action_spin == 2) uzaklk = 50000;
                if(action_spin == 3) uzaklk = 10000;
                if(action_spin == 4) uzaklk = 5000;
                paylasimlar = ws.paylasim_getir(latitude, longitude, "0" , uzaklk);
                bitmap = new Bitmap[paylasimlar.length / 11];
                for(int i = 0; i < paylasimlar.length / 11; i++)
                {
                    bitmap[i] = ws.profil_getir(paylasimlar[ (11*i) + 1 ]);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            }


            return null;
        }



        @Override
        protected void onPostExecute(Void result) {

            adapter = new ListViewAdapter(context, paylasimlar, latitude, longitude, bitmap);
            listView.setAdapter(adapter);


            pdialog.dismiss();


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


    public void onBackPressed()
    {


    }

}
