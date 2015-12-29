package com.feyzullah.recursivefark;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;



public class View2 extends Fragment {
    TextView sonuc;
    TextView sure;
    ScrollView scroll;
    Button btn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        final View view = inflater.inflate(R.layout.fragment_view2, container, false);

        AlertDialog.Builder alertMessage = new AlertDialog.Builder(view.getContext());
        final ScrollView s_view = new ScrollView(view.getContext());
        final TextView t_view = new TextView(view.getContext());
        //t_view.setText(str);
        t_view.setTextSize(10);
        t_view.setTextColor(Color.parseColor("#000000"));
        s_view.addView(t_view);
        alertMessage.setTitle("Kodu İncele");
        alertMessage.setView(s_view);


        t_view.setText("for(int i = 1, j, T; i < ArrayFunc.boyut; i++)\n" +
                "        {\n" +
                "            T = ArrayFunc.dizi[i];  j = i;\n" +
                "            while(j > 0 && ArrayFunc.dizi[j-1] > T)\n" +
                "            {\n" +
                "                ArrayFunc.dizi[j] = ArrayFunc.dizi[j-1];\n" +
                "                j--;\n" +
                "            }\n" +
                "            ArrayFunc.dizi[j] = T;\n" +
                "        }");
        final AlertDialog alt = alertMessage.setCancelable(true).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // if this button is clicked, close
                // current activity
                dialog.cancel();
            }
        }).create();

        ((Button) view.findViewById(R.id.kodV2)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alt.show();
            }
        });

        scroll = (ScrollView) view.findViewById(R.id.scrollView1);
        sonuc = (TextView) view.findViewById(R.id.sonucV2);
        sure = (TextView) view.findViewById(R.id.sureV2);
        btn = (Button) view.findViewById(R.id.siralaV2);


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
        for(int i = 1, j, T; i < ArrayFunc.boyut; i++)
        {
            T = ArrayFunc.dizi[i];  j = i;
            while(j > 0 && ArrayFunc.dizi[j-1] > T)
            {
                ArrayFunc.dizi[j] = ArrayFunc.dizi[j-1];
                j--;
            }
            ArrayFunc.dizi[j] = T;
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


            for(int i = 1, j, T; i < ArrayFunc.boyut; i++)
            {
                T = ArrayFunc.dizi[i];  j = i;

                while(j > 0 && ArrayFunc.dizi[j-1] > T)
                {

                    publishProgress(-1, i, j -1, T);
                    try {
                        Thread.sleep(ArrayFunc.zaman);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ArrayFunc.dizi[j] = ArrayFunc.dizi[j-1];

                    publishProgress(j, -1, -1, T);
                    try {
                        Thread.sleep(ArrayFunc.zaman);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    j--;
                }
                ArrayFunc.dizi[j] = T;

                publishProgress(j, -1, -1, -1);
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
            btn.setEnabled(true);

        }
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            String uretilendizi = "";

            for(int i = 0; i < ArrayFunc.boyut; i++)
            {
                //if(values[0] == i && values[1] == i) uretilendizi = uretilendizi + " <u><font color=\'#ff0000\'>" + ArrayFunc.dizi[i] + "</font></u>";
                if(values[0] == i) uretilendizi = uretilendizi + " <b><font color=\'#ff0000\'>" + ArrayFunc.dizi[i] + "</font></b>";
                else if(values[1] == i) uretilendizi = uretilendizi + " <b><font color=\'#0000ff\'>" + ArrayFunc.dizi[i] + "</font></b>";
                else if(values[2] == i) uretilendizi = uretilendizi + " <b><font color=\'#0000ff\'>" + ArrayFunc.dizi[i] + "</font></b>";
                else uretilendizi = uretilendizi + " " + ArrayFunc.dizi[i];
            }
            if(values[3] != -1) uretilendizi = uretilendizi + " ( " + values[3] + " elde )";
            sonuc.setText(Html.fromHtml(Html.toHtml(sonuc.getEditableText()).toString()+ "<br/>" + uretilendizi));
            scroll.scrollTo(0, scroll.getBottom());
        }
    }

}
