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


public class View3 extends Fragment {
    TextView sonuc;
    TextView sure;
    ScrollView scroll;
    Button btn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        final View view = inflater.inflate(R.layout.fragment_view3, container, false);

        AlertDialog.Builder alertMessage = new AlertDialog.Builder(view.getContext());
        final ScrollView s_view = new ScrollView(view.getContext());
        final TextView t_view = new TextView(view.getContext());
        //t_view.setText(str);
        t_view.setTextSize(10);
        t_view.setTextColor(Color.parseColor("#000000"));
        s_view.addView(t_view);
        alertMessage.setTitle("Kodu İncele");
        alertMessage.setView(s_view);


        t_view.setText(" for(int i = 1; i < ArrayFunc.boyut; i++)\n" +
                "        {\n" +
                "            int X = ArrayFunc.dizi[i];\n" +
                "            int Alt = 0;\n" +
                "            int Ust = i - 1;\n" +
                "            while(Alt <= Ust)\n" +
                "            {\n" +
                "                int Pivot = (int)((Alt + Ust) / 2);\n" +
                "                if(X < ArrayFunc.dizi[Pivot]) Ust = Pivot - 1;\n" +
                "                else Alt = Pivot + 1;\n" +
                "            }\n" +
                "\n" +
                "            for(int j = i - 1; j >= Alt; --j)\n" +
                "            {\n" +
                "                ArrayFunc.dizi[j + 1] = ArrayFunc.dizi[j];\n" +
                "            }\n" +
                "            ArrayFunc.dizi[Alt] = X;\n" +
                "        }");
        final AlertDialog alt = alertMessage.setCancelable(true).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // if this button is clicked, close
                // current activity
                dialog.cancel();
            }
        }).create();

        ((Button) view.findViewById(R.id.kodV3)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alt.show();
            }
        });

        scroll = (ScrollView) view.findViewById(R.id.scrollView2);
        sonuc = (TextView) view.findViewById(R.id.sonucV3);
        sure = (TextView) view.findViewById(R.id.sureV3);
        btn = (Button) view.findViewById(R.id.siralaV3);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ArrayFunc.yazdir == 2) {
                    new Gozlemle().execute((Void) null);
                } else {
                    String _sonuc = "";
                    new Zaman(0).execute((Void) null);

                    F();

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



    void F()  // rec
    {

        for(int i = 1; i < ArrayFunc.boyut; i++)
        {
            int X = ArrayFunc.dizi[i];
            int Alt = 0;
            int Ust = i - 1;
            while(Alt <= Ust)
            {
                int Pivot = (int)((Alt + Ust) / 2);
                if(X < ArrayFunc.dizi[Pivot]) Ust = Pivot - 1;
                else Alt = Pivot + 1;
            }

            for(int j = i - 1; j >= Alt; --j)
            {
                ArrayFunc.dizi[j + 1] = ArrayFunc.dizi[j];
            }
            ArrayFunc.dizi[Alt] = X;
        }

    }

    public class Gozlemle extends AsyncTask<Void, Integer, Void> {


        int boyut;
        String sdizi;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            String ax = Html.fromHtml(ArrayFunc.DiziYazdir() + "<br/>").toString();
            sonuc.setText(ax, TextView.BufferType.EDITABLE);
            btn.setEnabled(false);


        }
        @Override
        protected Void doInBackground(Void... params) {



            int i;
            for(i = 1; i < ArrayFunc.boyut; i++)
            {
                int X = ArrayFunc.dizi[i];
                int Alt = 0;
                int Ust = i - 1;
                while(Alt <= Ust)
                {
                    int Pivot = (int)((Alt + Ust) / 2);
                    if(X < ArrayFunc.dizi[Pivot]) Ust = Pivot - 1;
                    else Alt = Pivot + 1;
                }

                for(int j = i - 1; j >= Alt; --j)
                {
                    ArrayFunc.dizi[j + 1] = ArrayFunc.dizi[j];
                    publishProgress(j + 1, (Alt + Ust) / 2);
                    try {
                        Thread.sleep(ArrayFunc.zaman);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                ArrayFunc.dizi[Alt] = X;
                publishProgress(Alt, (Alt + Ust) / 2);
                try {
                    Thread.sleep(ArrayFunc.zaman);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }



            return null;
        }
        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            scroll.scrollTo(0, scroll.getHeight());
            btn.setEnabled(true);

        }
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            String uretilendizi = "";

            for(int i = 0; i < ArrayFunc.boyut; i++)
            {
                if(values[0] == i) uretilendizi = uretilendizi + " <font color=\'#ff0000\'>" + ArrayFunc.dizi[i] + "</font>";
                else if(values[1] == i) uretilendizi = uretilendizi + " <u>" + ArrayFunc.dizi[i] + "</u>";
                else uretilendizi = uretilendizi + " " + ArrayFunc.dizi[i];
            }
            sonuc.setText(Html.fromHtml(Html.toHtml(sonuc.getEditableText()).toString() + "<br/>" + uretilendizi));
            scroll.fullScroll(View.FOCUS_DOWN);
            //scroll.scrollTo(0, scroll.getHeight());
        }
    }

}
