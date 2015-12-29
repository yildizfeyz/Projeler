package com.feyzullah.trabzonbelediyesi.trabzonbelediyesi_binayeriyol;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by feyzullah on 7.10.2015.
 */
public  class Isyeri_veriler {

    public static String                    id;
    public static String                    ticarikod;
    public static String                    isletmeturu;
    public static String                    ickapino;
    public static String                    isletmeadi;
    public static String                    mulkiyetdurumu;
    public static String                    adisoyadi;
    public static String                    tcno;
    public static String                    vergino;
    public static String                    telefon;
    public static String                    webadresi;
    public static String                    location_x;
    public static String                    location_y;
    public static List<String>              Resimler;
    public static int                       islem;

    public static void sifirla()
    {
        id                      = "";
        ticarikod               = "";
        isletmeturu             = "";
        ickapino                = "";
        isletmeadi              = "";
        mulkiyetdurumu          = "";
        adisoyadi               = "";
        tcno                    = "";
        vergino                 = "";
        telefon                 = "";
        webadresi               = "";
        location_x              = "";
        location_y              = "";
        islem                   =  0;
        Resimler                = new ArrayList<String>();

    }




}
