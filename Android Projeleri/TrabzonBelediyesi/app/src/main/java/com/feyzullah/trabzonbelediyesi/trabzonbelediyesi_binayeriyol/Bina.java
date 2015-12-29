package com.feyzullah.trabzonbelediyesi.trabzonbelediyesi_binayeriyol;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import com.ToxicBakery.viewpager.transforms.RotateDownTransformer;
import com.astuetz.PagerSlidingTabStrip;

public class Bina extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bina);



        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setPageTransformer(true, new RotateDownTransformer());
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));


        PagerSlidingTabStrip tabsStrip = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        // Attach the view pager to the tab strip
        tabsStrip.setViewPager(viewPager);
    }



}
