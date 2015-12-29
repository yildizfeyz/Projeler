package com.feyzullah.recursivefark;

import java.util.Random;

/**
 * Created by feyzullah on 30.11.2015.
 */
public class ArrayFunc {

    public static int dizi[] = {3, 2, 1};
    public static int boyut = 3;
    public static int yazdir = 1;
    public static int zaman = 1000;
    public static void YerDegis(int i, int j)
    {
        int bos = dizi[i];
        dizi[i] = dizi[j];
        dizi[j] = bos;
    }

    public static String DiziUret(int _boyut)
    {
        boyut = _boyut;
        dizi = new int[boyut];

        String uretilendizi = "Üretilen Dizi: ";
        Random rand = new Random();

        for(int i = 0; i < boyut; i++)
        {
            dizi[i] = rand.nextInt(boyut);
            uretilendizi = uretilendizi + " " + dizi[i];
        }

        return uretilendizi;
    }

    public static String DiziYazdir()
    {
        String uretilendizi = "";
        for(int i = 0; i < boyut; i++)
        {
            uretilendizi = uretilendizi + "   " + dizi[i];
        }
        return uretilendizi;
    }

}
