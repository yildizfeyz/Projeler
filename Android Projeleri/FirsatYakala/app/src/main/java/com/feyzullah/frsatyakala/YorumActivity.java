package com.feyzullah.frsatyakala;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class YorumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yorum);


        setTitle("Yorumlar");

        android.support.v7.app.ActionBar actionbar = getSupportActionBar();
        actionbar.setBackgroundDrawable(getResources().getDrawable(R.drawable.action_background));

        actionbar.setHomeButtonEnabled(true);

        // navigationu t?klanabilir hale getiriyoruz
        actionbar.setDisplayHomeAsUpEnabled(true);

        /*


        veriler.putString("ID", paylasimlar[14 * position]);
                veriler.putString("gonderen", paylasimlar[14*position + 1]);
                veriler.putString("baslik", _baslik);
                veriler.putString("resimsayisi", paylasimlar[14*position + 13]);
                veriler.putString("resim", paylasimlar[14*position + 10]);
                veriler.putString("zaman", paylasimlar[14*position + 2]);
                veriler.putString("aciklama", paylasimlar[14*position + 5]);
                veriler.putString("begeniyorum", paylasimlar[14*position + 8] + " beğeni, " + paylasimlar[14*position + 9] + " yorum");
         */
        Intent intent = getIntent();
        Bundle veriler = intent.getExtras();
        String Paylasim_ID = veriler.getString("ID");
        String gonderen = veriler.getString("gonderen");
        String baslik = veriler.getString("baslik");
        int resimsayisi = Integer.parseInt(veriler.getString("resimsayisi"));
        String zaman = veriler.getString("zaman");
        String aciklama = veriler.getString("aciklama");
        String begeniyorum = veriler.getString("begeniyorum");

        WebService ws = new WebService();
        String[] yorumlar = ws.yorum_getir(Paylasim_ID);
        Yorum_ListViewAdapter adapter = new Yorum_ListViewAdapter(this,gonderen,zaman,baslik,aciklama,begeniyorum,resimsayisi,yorumlar);
        ((ListView)findViewById(R.id.listView_yorum)).setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_yorum, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();



        if(id == android.R.id.home)
        {
            super.onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
