package com.feyzullah.fibonaccisaylar;

import android.app.ActionBar;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.Time;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity {


    EditText sayi;
    TextView sonuc;
    TextView sure;

    long baslangic = 0;
    long bitis = 0;

    public class Zaman extends AsyncTask<Void, Void, Void> {


        int hng;

        Zaman(int _hng)
        {
            hng = _hng;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Date now = new Date();
            if(hng == 0) baslangic = now.getTime(); else bitis = now.getTime();

        }
        @Override
        protected Void doInBackground(Void... params) {


            return null;
        }
        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);


        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sayi = (EditText) findViewById(R.id.sayi_edt);
        sonuc = (TextView) findViewById(R.id.sonuc);
        sure = (TextView) findViewById(R.id.sure);

        android.support.v7.app.ActionBar actionbar = getSupportActionBar();
        actionbar.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));

        actionbar.setHomeButtonEnabled(true);

        // navigationu týklanabilir hale getiriyoruz
        actionbar.setDisplayHomeAsUpEnabled(true);

        actionbar.setHomeAsUpIndicator(R.drawable.icon);


    }

    long F(int n)
    {
        return n <= 1 ? n : F(n-1) + F(n-2);
    }



    public void onRec(View v)
    {

        if((((EditText) findViewById(R.id.sayi_edt)).getText().toString().trim().length() > 0)) {
            int _sayi = Integer.parseInt(sayi.getText().toString());
            long _sonuc;
            new Zaman(0).execute((Void) null);

            _sonuc = F(_sayi);

            new Zaman(1).execute((Void) null);

            sonuc.setText("Sonuç: " + String.valueOf(_sonuc));
            sure.setText("Hesaplama Süresi: " + String.valueOf(bitis - baslangic) + " ms");
        }
    }

    long F2(int n)
    {
        long Fibo1 = 0, Fibo2 = 1, Filius_bonacci = 0;

        if(n <= 1) return n;

        for(int i = 1; i<= n; i++)
        {
            Filius_bonacci = Fibo1 + Fibo2;
            Fibo2 = Fibo1;
            Fibo1 = Filius_bonacci;
        }
        return Filius_bonacci;
    }

    public void onSeri(View v)
    {
        if((((EditText) findViewById(R.id.sayi_edt)).getText().toString().trim().length() > 0)) {
            int _sayi = Integer.parseInt(sayi.getText().toString());
            long _sonuc;
            new Zaman(0).execute((Void) null);

            _sonuc = F2(_sayi);

            new Zaman(1).execute((Void) null);

            sonuc.setText("Sonuç: " + String.valueOf(_sonuc));
            sure.setText("Hesaplama Süresi: " + String.valueOf(bitis - baslangic) + " ms");
        }
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
        if (id == R.id.action_arama) {
            startActivity(new Intent(getApplicationContext(), Info.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
