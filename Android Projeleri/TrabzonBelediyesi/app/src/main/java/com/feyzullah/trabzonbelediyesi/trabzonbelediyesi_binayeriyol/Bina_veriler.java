package com.feyzullah.trabzonbelediyesi.trabzonbelediyesi_binayeriyol;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by feyzullah on 7.10.2015.
 */
public  class Bina_veriler {

    public static String                    id;
    public static String                    geocode;
    public static String                    mahalleadi;
    public static String                    caddesokakadi;
    public static String                    caddesokakkodu;
    public static String                    kapino;
    public static String                    siteadi;
    public static String                    apartmanadi;
    public static String                    halihazirdurum;
    public static String                    discephe_durumu;
    public static String                    yapidurumu;
    public static String                    catidurumu;
    public static String                    yapisistemi;
    public static String                    kullanilanmalzeme;
    public static String                    ortakkullanim;
    public static String                    digerbilgiler;
    public static String                    binasorumlusu;
    public static String                    sorumlu_tel;
    public static String                    kullanimamaci;
    public static String                    gelismislik;
    public static String                    location_x;
    public static String                    location_y;
    public static List<String>              ickapino;
    public static List<String>              nitelik;
    public static List<String>              nitelikkodu;
    public static List<String>              baskamahalleadi;
    public static List<String>              baskakapino;
    public static List<String>              baskadusunceler;
    public static String                    notlar;
    public static List<String>              Resimler;
    public static Bina_10_listviewAdapter   Bina10_adapter;
    public static Bina_11_listviewAdapter   Bina11_adapter;
    public static Bina_13_gridviewAdapter   Bina13_adapter;
    public static int                       islem;
    public static int                       byi;

    public static void sifirla()
    {
        id = "";
        geocode             = "";
        mahalleadi          = "";
        caddesokakadi       = "";
        caddesokakkodu      = "";
        kapino              = "";
        siteadi             = "";
        apartmanadi         = "";
        halihazirdurum      = "";
        discephe_durumu     = "";
        yapidurumu          = "";
        catidurumu          = "";
        yapisistemi         = "";
        kullanilanmalzeme   = "";
        ortakkullanim       = "";
        digerbilgiler       = "";
        binasorumlusu       = "";
        sorumlu_tel         = "";
        kullanimamaci       = "";
        gelismislik         = "";
        ickapino            = new ArrayList<String>();
        nitelik             = new ArrayList<String>();
        nitelikkodu         = new ArrayList<String>();
        baskamahalleadi     = new ArrayList<String>();
        baskakapino         = new ArrayList<String>();
        baskadusunceler     = new ArrayList<String>();
        Resimler            = new ArrayList<String>();
        notlar              = "";
        islem               = 0;

    }




}
