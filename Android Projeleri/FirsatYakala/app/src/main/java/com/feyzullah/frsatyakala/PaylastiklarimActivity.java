package com.feyzullah.frsatyakala;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
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
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

import im.delight.android.location.SimpleLocation;

public class PaylastiklarimActivity extends AppCompatActivity {

    int action_spin = 0;
    ProgressDialog pdialog;
    ListView listView;
    Context context;
    private SimpleLocation location;

    String gonderen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paylastiklarim);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Intent intent = getIntent();
        Bundle veriler = intent.getExtras();
        gonderen = veriler.getString("gonderen");
        setTitle("Paylaştıklarım");

        android.support.v7.app.ActionBar actionbar = getSupportActionBar();
        actionbar.setBackgroundDrawable(getResources().getDrawable(R.drawable.action_background));

        actionbar.setHomeButtonEnabled(true);

        // navigationu t?klanabilir hale getiriyoruz
        actionbar.setDisplayHomeAsUpEnabled(true);


        context = this;




        listView = (ListView) findViewById(R.id.listView_paylastiklarim);

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
        getMenuInflater().inflate(R.menu.menu_paylastiklarim, menu);


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
            Bundle veriler = new Bundle();
            veriler.putString("gonderen", gonderen);
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtras(veriler);
            startActivity(intent);
        }


        return super.onOptionsItemSelected(item);
    }


    public void onBackPressed()
    {
        Bundle veriler = new Bundle();
        veriler.putString("gonderen", gonderen);
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtras(veriler);
        startActivity(intent);

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
                if(action_spin == 2) uzaklk = 10000;
                paylasimlar = ws.paylasim_getir(latitude, longitude, gonderen , uzaklk);
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

}
