package com.feyzullah.trabzonbelediyesi.trabzonbelediyesi_binayeriyol;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    final int PAGE_COUNT = 14;
    // Tab Titles
    private String tabtitles[] = new String[]{"Bina Geocode - Mahalle Adı", "Cadde-Sokak Adı/Kodu", "Kapı No - Site - Apartman", "Bina ve Dış Cephe Durumu" , "Yapı ve Çatı Durumu" , "Yapı Sistemi ve Kullanılan Malzeme", "Ortak Kullanım ve Diğer Bilgiler", "Bina Sorumlusu", "Amaç ve Gelişmişlik","İç Kapı Nitelikleri", "Dışa Açılan Kapılar", "NOTLAR", "FOTOĞRAF","KAYDET"};
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
                Bina_1 fragmenttab1 = new Bina_1();
                return fragmenttab1;

            // Open BinaCaddeSokak.java
            case 1:
                Bina_2 fragmenttab2 = new Bina_2();

                return fragmenttab2;

            // Open KapiNoSiteAdiApartmanBlokAdi.java
            case 2:
                Bina_3 fragmenttab3 = new Bina_3();
                return fragmenttab3;

            case 3:
                Bina_4 fragmenttab4 = new Bina_4();
                return fragmenttab4;

            case 4:
                Bina_5 fragmenttab5 = new Bina_5();
                return fragmenttab5;

            case 5:
                Bina_6 fragmenttab6 = new Bina_6();
                return fragmenttab6;

            case 6:
                Bina_7 fragmenttab7 = new Bina_7();
                return fragmenttab7;
            case 7:
                Bina_8 fragmenttab8 = new Bina_8();
                return fragmenttab8;
            case 8:
                Bina_9 fragmenttab9 = new Bina_9();
                return fragmenttab9;

            case 9:
                Bina_10 fragmenttab10 = new Bina_10();
                return fragmenttab10;
            case 10:
                Bina_11 fragmenttab11 = new Bina_11();
                return fragmenttab11;
            case 11:
                Bina_12 fragmenttab12 = new Bina_12();
                return fragmenttab12;
            case 12:
                Bina_13 fragmenttab13 = new Bina_13();
                return fragmenttab13;
            case 13:
                Bina_14 fragmenttab14 = new Bina_14();
                return fragmenttab14;
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabtitles[position];
    }

    //@Override public float getPageWidth(int position) { return(0.9f); }
}
