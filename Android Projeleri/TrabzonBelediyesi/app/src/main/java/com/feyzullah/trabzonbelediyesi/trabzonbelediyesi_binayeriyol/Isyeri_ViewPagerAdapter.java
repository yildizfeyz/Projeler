package com.feyzullah.trabzonbelediyesi.trabzonbelediyesi_binayeriyol;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class Isyeri_ViewPagerAdapter extends FragmentPagerAdapter {

    final int PAGE_COUNT = 7;
    // Tab Titles
    private String tabtitles[] = new String[]{"İşyeri Kodu-Türü", "İşletme Kapı-Adı", "Mülkiyet Durumu", "İşyeri Sahibi", "Telefon/Web Adresi", "Fotoğraf", "Kaydet" };
    Context context;

    public Isyeri_ViewPagerAdapter(FragmentManager fm) {
        super(fm);

    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {

            case 0:
                Isyeri_1 fragmenttab1 = new Isyeri_1();
                return fragmenttab1;

            case 1:
                Isyeri_2 fragmenttab2 = new Isyeri_2();
                return fragmenttab2;

            case 2:
                Isyeri_3 fragmenttab3 = new Isyeri_3();
                return fragmenttab3;

            case 3:
                Isyeri_4 fragmenttab4 = new Isyeri_4();
                return fragmenttab4;

            case 4:
                Isyeri_5 fragmenttab5 = new Isyeri_5();
                return fragmenttab5;

            case 5:
                Isyeri_6 fragmenttab6 = new Isyeri_6();
                return fragmenttab6;

            case 6:
                Isyeri_7 fragmenttab7 = new Isyeri_7();
                return fragmenttab7;
            case 7:
                Bina_8 fragmenttab8 = new Bina_8();
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

