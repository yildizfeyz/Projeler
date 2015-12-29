package com.feyzullah.trabzonbelediyesi.trabzonbelediyesi_binayeriyol;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by feyzullah on 8.11.2015.
 */
public class Yol_ViewPagerAdapter extends FragmentPagerAdapter {

    final int PAGE_COUNT = 4;
    // Tab Titles
    private String tabtitles[] = new String[]{"Yol", "Kaplama Türü", "Fotoğraf", "Kaydet"};
    Context context;

    public Yol_ViewPagerAdapter(FragmentManager fm) {
        super(fm);

    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {

            // Open BinaGeocodeveMahalleAdi.java
            case 0:
                Yol_1 fragmenttab1 = new Yol_1();
                return fragmenttab1;

            // Open BinaCaddeSokak.java
            case 1:
                Yol_2 fragmenttab2 = new Yol_2();
                return fragmenttab2;

            // Open KapiNoSiteAdiApartmanBlokAdi.java
            case 2:
                Yol_3 fragmenttab3 = new Yol_3();
                return fragmenttab3;

            case 3:
                Yol_4 fragmenttab4 = new Yol_4();
                return fragmenttab4;
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabtitles[position];
    }

    //@Override public float getPageWidth(int position) { return(0.9f); }
}
