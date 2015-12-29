package com.feyzullah.recursivefark;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;


public class View7 extends Fragment {
    TextView sonuc;
    TextView sure;

    Button btn;

    View _v;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        final View view = inflater.inflate(R.layout.fragment_view7, container, false);


        AlertDialog.Builder alertMessage = new AlertDialog.Builder(view.getContext());
        final ScrollView s_view = new ScrollView(view.getContext());
        final TextView t_view = new TextView(view.getContext());
        //t_view.setText(str);
        t_view.setTextSize(10);
        t_view.setTextColor(Color.parseColor("#000000"));
        s_view.addView(t_view);
        alertMessage.setTitle("Kodu İncele");
        alertMessage.setView(s_view);


        t_view.setText("public void F(int Alt, int Ust) \n" +
                "    {\n" +
                "        int i = Alt, j = Ust;\n" +
                "        int tmp;\n" +
                "        int pivot;\n" +
                "\n" +
                "\n" +
                "        if(ArrayFunc.dizi[Ust] > ArrayFunc.dizi[Alt])\n" +
                "        {\n" +
                "            if(ArrayFunc.dizi[(Alt + Ust) / 2] > ArrayFunc.dizi[Ust])\n" +
                "                pivot = ArrayFunc.dizi[Ust];\n" +
                "            else{\n" +
                "                if(ArrayFunc.dizi[(Alt + Ust) / 2] > ArrayFunc.dizi[Alt])\n" +
                "                    pivot = ArrayFunc.dizi[(Alt + Ust) / 2];\n" +
                "                else pivot = ArrayFunc.dizi[Alt];\n" +
                "            }\n" +
                "        }\n" +
                "        else{\n" +
                "            if(ArrayFunc.dizi[(Alt + Ust) / 2] > ArrayFunc.dizi[Alt])\n" +
                "                pivot = ArrayFunc.dizi[Alt];\n" +
                "            else{\n" +
                "                if(ArrayFunc.dizi[(Alt + Ust) / 2] > ArrayFunc.dizi[Ust])\n" +
                "                    pivot = ArrayFunc.dizi[(Alt + Ust) / 2];\n" +
                "                else pivot = ArrayFunc.dizi[Ust];\n" +
                "            }\n" +
                "        }\n" +
                "\n" +
                "        while (i <= j) {\n" +
                "            while (ArrayFunc.dizi[i] < pivot)\n" +
                "                i++;\n" +
                "            while (ArrayFunc.dizi[j] > pivot)\n" +
                "                j--;\n" +
                "            if (i <= j) {\n" +
                "                tmp = ArrayFunc.dizi[i];\n" +
                "                ArrayFunc.dizi[i] = ArrayFunc.dizi[j];\n" +
                "                ArrayFunc.dizi[j] = tmp;\n" +
                "                i++;\n" +
                "                j--;\n" +
                "            }\n" +
                "        }\n" +
                "        if (Alt < i - 1)\n" +
                "            F(Alt, i - 1);\n" +
                "        if (i < Ust)\n" +
                "            F( i, Ust);\n" +
                "\n" +
                "    }");
        final AlertDialog alt = alertMessage.setCancelable(true).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // if this button is clicked, close
                // current activity
                dialog.cancel();
            }
        }).create();

        ((Button) view.findViewById(R.id.kodV7)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alt.show();
            }
        });

        sonuc = (TextView) view.findViewById(R.id.sonucV7);
        sure = (TextView) view.findViewById(R.id.sureV7);
        btn = (Button) view.findViewById(R.id.siralaV7);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ArrayFunc.yazdir == 2) {
                    new Gozlemle().execute((Void) null);
                } else {
                    _v = v;
                    String _sonuc = "";
                    new Zaman(0).execute((Void) null);
                    F(0, ArrayFunc.boyut - 1);


                    new Zaman(1).execute((Void) null);

                    long siralama = bitis - baslangic;

                    new Zaman(0).execute((Void) null);
                    if (ArrayFunc.yazdir == 1)
                        _sonuc = ArrayFunc.DiziYazdir();
                    new Zaman(1).execute((Void) null);

                    long yazdirma = bitis - baslangic;
                    if (ArrayFunc.yazdir == 0) yazdirma = 0;
                    sonuc.setText("Sıralı Dizi: " + String.valueOf(_sonuc));
                    sure.setText("Sıralama Süresi(us): " + String.valueOf((int) ((siralama) / 1000)) + " microsecond\n"
                            + "Sıralama Süresi(ms): " + String.valueOf((int) ((siralama) / 1000000)) + " millisecond\n"
                            + "Sıralama Süresi(sn): " + String.valueOf((int) ((siralama) / 1000000000)) + " second\n\n"
                            + "Yazdırma Süresi(us): " + String.valueOf((int) ((yazdirma) / 1000)) + " microsecond\n"
                            + "Yazdırma Süresi(ms): " + String.valueOf((int) ((yazdirma) / 1000000)) + " millisecond\n"
                            + "Yazdırma Süresi(sn): " + String.valueOf((int) ((yazdirma) / 1000000000)) + " second\n");
                }

            }
        });



        return view;
    }



    long baslangic = 0;
    long bitis = 0;

    public class Zaman extends AsyncTask<Void, Void, Void> {


        int hng;

        Zaman(int _hng)
        {
            hng = _hng;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //Date now = new Date();
            if(hng == 0) baslangic = System.nanoTime(); else bitis = System.nanoTime();

        }
        @Override
        protected Void doInBackground(Void... params) {


            return null;
        }
        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);


        }

    }




    public void F(int Alt, int Ust)
    {
        int i = Alt, j = Ust;
        int tmp;
        int pivot;


        if(ArrayFunc.dizi[Ust] > ArrayFunc.dizi[Alt])
        {
            if(ArrayFunc.dizi[(Alt + Ust) / 2] > ArrayFunc.dizi[Ust])
                pivot = ArrayFunc.dizi[Ust];
            else{
                if(ArrayFunc.dizi[(Alt + Ust) / 2] > ArrayFunc.dizi[Alt])
                    pivot = ArrayFunc.dizi[(Alt + Ust) / 2];
                else pivot = ArrayFunc.dizi[Alt];
            }
        }
        else{
            if(ArrayFunc.dizi[(Alt + Ust) / 2] > ArrayFunc.dizi[Alt])
                pivot = ArrayFunc.dizi[Alt];
            else{
                if(ArrayFunc.dizi[(Alt + Ust) / 2] > ArrayFunc.dizi[Ust])
                    pivot = ArrayFunc.dizi[(Alt + Ust) / 2];
                else pivot = ArrayFunc.dizi[Ust];
            }
        }

        while (i <= j) {
            while (ArrayFunc.dizi[i] < pivot)
                i++;
            while (ArrayFunc.dizi[j] > pivot)
                j--;
            if (i <= j) {
                tmp = ArrayFunc.dizi[i];
                ArrayFunc.dizi[i] = ArrayFunc.dizi[j];
                ArrayFunc.dizi[j] = tmp;
                i++;
                j--;
            }
        }
        if (Alt < i - 1)
            F(Alt, i - 1);
        if (i < Ust)
            F( i, Ust);

    }



    public class Gozlemle extends AsyncTask<Void, Integer, Void> {


        int boyut;
        String sdizi;
        public void F2(int Alt, int Ust)  // rec
        {


            int i = Alt, j = Ust;
            int tmp;
            int pivot;


            if(ArrayFunc.dizi[Ust] > ArrayFunc.dizi[Alt])
            {
                if(ArrayFunc.dizi[(Alt + Ust) / 2] > ArrayFunc.dizi[Ust])
                    pivot = ArrayFunc.dizi[Ust];
                else{
                    if(ArrayFunc.dizi[(Alt + Ust) / 2] > ArrayFunc.dizi[Alt])
                        pivot = ArrayFunc.dizi[(Alt + Ust) / 2];
                    else pivot = ArrayFunc.dizi[Alt];
                }
            }
            else{
                if(ArrayFunc.dizi[(Alt + Ust) / 2] > ArrayFunc.dizi[Alt])
                    pivot = ArrayFunc.dizi[Alt];
                else{
                    if(ArrayFunc.dizi[(Alt + Ust) / 2] > ArrayFunc.dizi[Ust])
                        pivot = ArrayFunc.dizi[(Alt + Ust) / 2];
                    else pivot = ArrayFunc.dizi[Ust];
                }
            }

            while (i <= j) {
                while (ArrayFunc.dizi[i] < pivot) {
                    publishProgress(i, -1, (Alt + Ust) / 2);
                    try {
                        Thread.sleep(ArrayFunc.zaman);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    i++;
                }
                publishProgress(i, -1, (Alt + Ust) / 2);
                try {
                    Thread.sleep(ArrayFunc.zaman);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                while (ArrayFunc.dizi[j] > pivot) {
                    publishProgress(i, j, (Alt + Ust) / 2);
                    try {
                        Thread.sleep(ArrayFunc.zaman);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    j--;
                }
                if (i <= j) {
                    publishProgress(i, j, (Alt + Ust) / 2);
                    try {
                        Thread.sleep(ArrayFunc.zaman);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    tmp = ArrayFunc.dizi[i];
                    ArrayFunc.dizi[i] = ArrayFunc.dizi[j];
                    ArrayFunc.dizi[j] = tmp;
                    publishProgress(j, i, (Alt + Ust) / 2);
                    try {
                        Thread.sleep(ArrayFunc.zaman);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    i++;
                    j--;
                }
            }
            if (Alt < i - 1)
                F2(Alt, i - 1);
            if (i < Ust)
                F2(i, Ust);






        }


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            String ax = Html.fromHtml(ArrayFunc.DiziYazdir() + "<br/>").toString();
            sonuc.setText(ax, TextView.BufferType.EDITABLE);
            btn.setEnabled(false);


        }
        @Override
        protected Void doInBackground(Void... params) {



            F2(0, ArrayFunc.boyut - 1);



            return null;
        }
        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            btn.setEnabled(true);

        }
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            String uretilendizi = "";
            for(int i = 0; i < ArrayFunc.boyut; i++)
            {
                if(values[0] == i && values[2] == i) uretilendizi = uretilendizi + " <u><font color=\'#ff0000\'>" + ArrayFunc.dizi[i] + "</font></u>";
                else if(values[1] == i && values[2] == i) uretilendizi = uretilendizi + " <u><font color=\'#0000ff\'>" + ArrayFunc.dizi[i] + "</font></u>";
                else if(values[0] == i) uretilendizi = uretilendizi + " <font color=\'#ff0000\'>" + ArrayFunc.dizi[i] + "</font>";
                else if(values[1] == i) uretilendizi = uretilendizi + " <font color=\'#0000ff\'>" + ArrayFunc.dizi[i] + "</font>";
                else if(values[2] == i) uretilendizi = uretilendizi + " <u>" + ArrayFunc.dizi[i] + "</u>";
                else uretilendizi = uretilendizi + " " + ArrayFunc.dizi[i];
            }
            sonuc.setText(Html.fromHtml(uretilendizi));


        }
    }
}
