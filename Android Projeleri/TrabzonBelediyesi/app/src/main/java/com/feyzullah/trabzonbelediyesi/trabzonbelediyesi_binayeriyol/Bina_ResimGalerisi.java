package com.feyzullah.trabzonbelediyesi.trabzonbelediyesi_binayeriyol;


import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;


public class Bina_ResimGalerisi extends AppCompatActivity {



    private FullScreenImageAdapter adapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bina__resim_galerisi);
        getSupportActionBar().hide();
        viewPager = (ViewPager) findViewById(R.id.Galeripager);
        Intent i = getIntent();

        int position = i.getIntExtra("position", 0);

        adapter = new FullScreenImageAdapter(this, Bina_veriler.byi);

        if(adapter.getCount() < 1) ((TextView)findViewById(R.id.resimyok)).setVisibility(View.VISIBLE);
        else ((TextView)findViewById(R.id.resimyok)).setVisibility(View.INVISIBLE);
        viewPager.setAdapter(adapter);


        viewPager.setCurrentItem(position);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bina__resim_galerisi, menu);
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
