package com.feyzullah.trabzonbelediyesi.trabzonbelediyesi_binayeriyol;

import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by feyzullah on 9.10.2015.
 */
public class Bina_verilerListe {

    public static List<String> id;
    public static List<String> geocode;
    public static List<String> mahalleadi;
    public static List<String> caddesokakadi;
    public static List<String> caddesokakkodu;
    public static List<String> kapino;
    public static List<String> siteadi;
    public static List<String> apartmanadi;
    public static List<String> halihazirdurum;
    public static List<String> discephe_durumu;
    public static List<String> yapidurumu;
    public static List<String> catidurumu;
    public static List<String> yapisistemi;
    public static List<String> kullanilanmalzeme;
    public static List<String> ortakkullanim;
    public static List<String> digerbilgiler;
    public static List<String> binasorumlusu;
    public static List<String> sorumlu_tel;
    public static List<String> kullanimamaci;
    public static List<String> gelismislik;
    public static List<String> ickapino;
    public static List<String> nitelik;
    public static List<String> nitelikkodu;
    public static List<String> baskamahalleadi;
    public static List<String> baskakapino;
    public static List<String> baskadusunceler;
    public static List<String> notlar;
    public static List<String> Resimler;
    public static String       Resim_id;


    public static void sifirla()
    {



        id                  = new ArrayList<String>();
        geocode             = new ArrayList<String>();
        mahalleadi          = new ArrayList<String>();
        caddesokakadi       = new ArrayList<String>();
        caddesokakkodu      = new ArrayList<String>();
        kapino              = new ArrayList<String>();
        siteadi             = new ArrayList<String>();
        apartmanadi         = new ArrayList<String>();
        halihazirdurum      = new ArrayList<String>();
        discephe_durumu     = new ArrayList<String>();
        yapidurumu          = new ArrayList<String>();
        catidurumu          = new ArrayList<String>();
        yapisistemi         = new ArrayList<String>();
        kullanilanmalzeme   = new ArrayList<String>();
        ortakkullanim       = new ArrayList<String>();
        digerbilgiler       = new ArrayList<String>();
        binasorumlusu       = new ArrayList<String>();
        sorumlu_tel         = new ArrayList<String>();
        kullanimamaci       = new ArrayList<String>();
        gelismislik         = new ArrayList<String>();
        ickapino            = new ArrayList<String>();
        nitelik             = new ArrayList<String>();
        nitelikkodu         = new ArrayList<String>();
        baskamahalleadi     = new ArrayList<String>();
        baskakapino         = new ArrayList<String>();
        baskadusunceler     = new ArrayList<String>();
        notlar              = new ArrayList<String>();

        id                  .add("ID");
        geocode             .add("Geocode");
        mahalleadi          .add("Mahalle Adı");
        caddesokakadi       .add("Cadde/Sokak Adı");
        caddesokakkodu      .add("Cadde/Sokak Kodu");
        kapino              .add("Kapı No");
        siteadi             .add("Site Adı");
        apartmanadi         .add("Apartman Adı");
        halihazirdurum      .add("Halihazır Durum");
        discephe_durumu     .add("Dış Cephe Durumu");
        yapidurumu          .add("Yapı Durumu");
        catidurumu          .add("Çatı Durumu");
        yapisistemi         .add("Yapı Sistemi");
        kullanilanmalzeme   .add("Kullanılan Malzeme");
        ortakkullanim       .add("Ortak Kullanım");
        digerbilgiler       .add("Diğer Bilgiler");
        binasorumlusu       .add("Bina Sorumlusu");
        sorumlu_tel         .add("Sorumlu telefonu");
        kullanimamaci       .add("Kullanım Amacı");
        gelismislik         .add("Gelişmişlik");
        ickapino            .add("İç Kapı No");
        nitelik             .add("Nitelik");
        nitelikkodu         .add("Nitelik Kodu");
        baskamahalleadi     .add("Başka Mahalle Adı");
        baskakapino         .add("Başka Kapı No");
        baskadusunceler     .add("Başka Düşünceler");
        notlar              .add("Notlar");

    }
    public static void sifirlaResim()
    {

        Resimler = new ArrayList<String>();
    }

}
