package com.feyzullah.trabzonbelediyesi.trabzonbelediyesi_binayeriyol;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by feyzullah on 8.11.2015.
 */
public class Yol_veriler {
    public static String                    id;
    public static String                    yolkod;
    public static String                    genislik;
    public static String                    ad;
    public static String                    kaplamaturu;
    public static String                    location_x;
    public static String                    location_y;
    public static List<String>              Resimler;
    public static int                       islem;

    public static void sifirla()
    {
        id                      = "";
        yolkod                  = "";
        genislik                = "";
        ad                      = "";
        kaplamaturu             = "";
        location_x              = "";
        location_y              = "";
        islem                   =  0;
        Resimler                = new ArrayList<String>();

    }
}
