package com.feyzullah.trabzonbelediyesi.trabzonbelediyesi_binayeriyol;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.ToxicBakery.viewpager.transforms.RotateDownTransformer;
import com.ToxicBakery.viewpager.transforms.RotateUpTransformer;
import com.astuetz.PagerSlidingTabStrip;

public class Yol extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yol);

        ViewPager viewPager = (ViewPager) findViewById(R.id.pager3);
        viewPager.setPageTransformer(true, new RotateUpTransformer());
        viewPager.setAdapter(new Yol_ViewPagerAdapter(getSupportFragmentManager()));


        PagerSlidingTabStrip tabsStrip = (PagerSlidingTabStrip) findViewById(R.id.tabs3);
        // Attach the view pager to the tab strip
        tabsStrip.setViewPager(viewPager);
    }


}
