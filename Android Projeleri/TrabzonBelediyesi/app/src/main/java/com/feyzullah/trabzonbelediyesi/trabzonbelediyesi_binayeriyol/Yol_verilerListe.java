package com.feyzullah.trabzonbelediyesi.trabzonbelediyesi_binayeriyol;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by feyzullah on 8.11.2015.
 */
public class Yol_verilerListe {

    public static List<String>                     id;
    public static List<String>                     yolkod;
    public static List<String>                     genislik;
    public static List<String>                     ad;
    public static List<String>                     kaplamaturu;
    public static List<String>                     Resimler;
    public static String                           Resim_id;

    public static void sifirla()
    {
        id                      = new ArrayList<String>();
        yolkod                  = new ArrayList<String>();
        genislik                = new ArrayList<String>();
        ad                      = new ArrayList<String>();
        kaplamaturu             = new ArrayList<String>();
        Resimler                = new ArrayList<String>();

        id                      .add("ID");
        yolkod                  .add("Yol Kod");
        genislik                .add("Genişlik");
        ad                      .add("Ad");
        kaplamaturu             .add("Kaplama Türü");

    }

}
