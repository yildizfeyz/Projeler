package com.feyzullah.frsatyakala;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class ResimGalerisi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resim_galerisi);

        Intent intent = getIntent();
        Bundle veriler = intent.getExtras();

        final int profil = veriler.getInt("profil");
        if(profil != 0) {
            final String ID = veriler.getString("ID");
            final int resimsayisi = veriler.getInt("resimsayisi");

            WebService ws = new WebService();
            String resim1 = "0", resim2 = "1", resim3 = "2";
            try {

                if (resimsayisi > 0) {
                    resim1 = ws.resim_getir(ID, "1");

                    if (resimsayisi > 1) {

                        resim2 = ws.resim_getir(ID, "2");
                        if (resimsayisi > 2) {
                            resim3 = ws.resim_getir(ID, "3");
                        }
                    }
                }
            } catch (Exception ex) {
            }

            getSupportActionBar().hide();
            ViewPager viewPager = (ViewPager) findViewById(R.id.Galeripager);
            Intent i = getIntent();

            int position = i.getIntExtra("position", 0);

            FullScreenImageAdapter adapter = new FullScreenImageAdapter(this, resim1, resim2, resim3, resimsayisi);

            if (adapter.getCount() < 1)
                ((TextView) findViewById(R.id.resimyok)).setVisibility(View.VISIBLE);
            else ((TextView) findViewById(R.id.resimyok)).setVisibility(View.INVISIBLE);
            viewPager.setAdapter(adapter);


            viewPager.setCurrentItem(position);
        } else
        {
            final String ID = veriler.getString("gonderen");

            WebService ws = new WebService();
            String resim1 = "0", resim2 = "1", resim3 = "2";
            try {


                    resim1 = WebService.bitmapTOstring(ws.profil_getir(ID));

            } catch (Exception ex) {
            }

            getSupportActionBar().hide();
            ViewPager viewPager = (ViewPager) findViewById(R.id.Galeripager);
            Intent i = getIntent();

            int position = i.getIntExtra("position", 0);

            FullScreenImageAdapter adapter = new FullScreenImageAdapter(this, resim1, resim2, resim3, 1);

            if (adapter.getCount() < 1)
                ((TextView) findViewById(R.id.resimyok)).setVisibility(View.VISIBLE);
            else ((TextView) findViewById(R.id.resimyok)).setVisibility(View.INVISIBLE);
            viewPager.setAdapter(adapter);


            viewPager.setCurrentItem(position);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_resim_galerisi, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();



        return super.onOptionsItemSelected(item);
    }
}
