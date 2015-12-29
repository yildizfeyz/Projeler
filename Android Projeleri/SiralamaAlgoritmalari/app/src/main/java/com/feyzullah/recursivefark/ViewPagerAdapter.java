package com.feyzullah.recursivefark;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by feyzullah on 8.11.2015.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    final int PAGE_COUNT = 8;
    // Tab Titles
    private String tabtitles[] = new String[]{"Insertion Sort", "Straight Insertion Sort", "Binary Insertion Sort", "Selection Sort", "Bubble Sort", "Quick Sort", "Enhanced Quick Sort", "Non-Recursive Quick Sort"};
    Context context;

    public ViewPagerAdapter(FragmentManager fm) {
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
                View1 fragmenttab1 = new View1();
                return fragmenttab1;

            // Open BinaCaddeSokak.java
            case 1:
                View2 fragmenttab2 = new View2();
                return fragmenttab2;

            // Open KapiNoSiteAdiApartmanBlokAdi.java
            case 2:
                View3 fragmenttab3 = new View3();
                return fragmenttab3;

            case 3:
                View4 fragmenttab4 = new View4();
                return fragmenttab4;
            case 4:
                View5 fragmenttab5 = new View5();
                return fragmenttab5;
            case 5:
                View6 fragmenttab6 = new View6();
                return fragmenttab6;
            case 6:
                View7 fragmenttab7 = new View7();
                return fragmenttab7;
            case 7:
                View8 fragmenttab8 = new View8();
                return fragmenttab8;
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabtitles[position];
    }

    //@Override public float getPageWidth(int position) { return(0.9f); }
}
