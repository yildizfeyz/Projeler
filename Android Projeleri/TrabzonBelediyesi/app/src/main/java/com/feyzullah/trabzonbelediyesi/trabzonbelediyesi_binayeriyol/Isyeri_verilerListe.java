package com.feyzullah.trabzonbelediyesi.trabzonbelediyesi_binayeriyol;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by feyzullah on 8.11.2015.
 */
public class Isyeri_verilerListe {

    public static List<String>                     id;
    public static List<String>                     ticarikod;
    public static List<String>                     isletmeturu;
    public static List<String>                     ickapino;
    public static List<String>                     isletmeadi;
    public static List<String>                     mulkiyetdurumu;
    public static List<String>                     adisoyadi;
    public static List<String>                     tcno;
    public static List<String>                     vergino;
    public static List<String>                     telefon;
    public static List<String>                     webadresi;
    public static List<String>                     Resimler;
    public static String                           Resim_id;

    public static void sifirla()
    {
        id                      = new ArrayList<String>();
        ticarikod               = new ArrayList<String>();
        isletmeturu             = new ArrayList<String>();
        ickapino                = new ArrayList<String>();
        isletmeadi              = new ArrayList<String>();
        mulkiyetdurumu          = new ArrayList<String>();
        adisoyadi               = new ArrayList<String>();
        tcno                    = new ArrayList<String>();
        vergino                 = new ArrayList<String>();
        telefon                 = new ArrayList<String>();
        webadresi               = new ArrayList<String>();
        Resimler                = new ArrayList<String>();

        id                      .add("ID");
        ticarikod               .add("Ticari Kod");
        isletmeturu             .add("İşletme Türü");
        ickapino                .add("İç Kapı No");
        isletmeadi              .add("İşletme Adı");
        mulkiyetdurumu          .add("Mülkiyet Durumu");
        adisoyadi               .add("Adı Soyadı");
        tcno                    .add("TC No");
        vergino                 .add("Vergi No");
        telefon                 .add("Telefon");
        webadresi               .add("Web Adresi");

    }
}
