package com.feyzullah.recursivefark;

import android.app.ActionBar;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.Time;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;

import java.util.Date;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    public class Zaman extends AsyncTask<Void, Integer, Void> {


        int boyut;
        String sdizi;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dizi_txt.setText("Uretiliyor...");
            boyut = Integer.parseInt(eleman_edt.getText().toString());

        }
        @Override
        protected Void doInBackground(Void... params) {

            ArrayFunc.dizi = new int[boyut];
            ArrayFunc.boyut = boyut;
            sdizi = "Uretilen Dizi: ";
            Random rand = new Random();

            for(int i = 0; i < boyut; i++)
            {
                ArrayFunc.dizi[i] = rand.nextInt(boyut);
                sdizi = sdizi + " " + ArrayFunc.dizi[i];
                if(i % 5 == 0)publishProgress(i);
            }


            return null;
        }
        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            dizi_txt.setText(sdizi);

        }
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            dizi_txt.setText("Uretiliyor... " + (100*values[0]) / boyut + "%");
        }
    }

    TextView dizi_txt;
    EditText eleman_edt;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        btn = (Button) findViewById(R.id.diziuret);
        eleman_edt = ((EditText) findViewById(R.id.elemansayisi));

        dizi_txt= (TextView) findViewById(R.id.uretilendizi);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((eleman_edt.getText().toString().trim().length() > 0)) {

                    if(btn.getText().toString().equals("Uygula"))
                    {
                        ArrayFunc.zaman = Integer.parseInt(eleman_edt.getText().toString());
                    }
                    else new Zaman().execute((Void) null);


                }

            }
        });

        ViewPager viewPager = (ViewPager) findViewById(R.id.pager3);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));

        setTitle("Sıralama Algoritmaları");
        PagerSlidingTabStrip tabsStrip = (PagerSlidingTabStrip) findViewById(R.id.tabs3);
        // Attach the view pager to the tab strip
        tabsStrip.setViewPager(viewPager);

        android.support.v7.app.ActionBar actionbar = getSupportActionBar();
        actionbar.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));

        actionbar.setHomeButtonEnabled(true);

        // navigationu t?klanabilir hale getiriyoruz
        actionbar.setDisplayHomeAsUpEnabled(true);

        actionbar.setHomeAsUpIndicator(R.drawable.icon_activitybar);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem item = menu.findItem(R.id.spinner);
        Spinner spinner = (Spinner) MenuItemCompat.getActionView(item);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.menu_spinner));

        spinner.setAdapter(adapter); // set the adapter to provide layout of rows and content
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //btn.setEnabled(true);
                //eleman_edt.setEnabled(true);
                btn.setText("Dizi Üret");
                eleman_edt.setText("");
                eleman_edt.setHint("Eleman Sayısı");
                ArrayFunc.zaman = 0;
                if(position == 0)
                {
                    ArrayFunc.yazdir = 1;
                }
                else if(position == 1)
                {
                    ArrayFunc.yazdir = 0;
                }
                else
                {
                    ArrayFunc.zaman = 1000;
                    ArrayFunc.yazdir = 2;
                    btn.setText("Uygula");
                    eleman_edt.setText("13");
                    eleman_edt.setHint("Hız(ms)");
                    //btn.setEnabled(false);
                    //eleman_edt.setEnabled(false);
                    new Zaman().execute((Void) null);
                    eleman_edt.setText("");

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


        return super.onOptionsItemSelected(item);
    }


}
