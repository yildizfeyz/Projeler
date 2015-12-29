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


public class View8 extends Fragment {
    TextView sonuc;
    TextView sure;

    Button btn;
    Button kodbtn;
    View _v;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        final View view = inflater.inflate(R.layout.fragment_view8, container, false);


        AlertDialog.Builder alertMessage = new AlertDialog.Builder(view.getContext());
        final ScrollView s_view = new ScrollView(view.getContext());
        final TextView t_view = new TextView(view.getContext());
        //t_view.setText(str);
        t_view.setTextSize(10);
        t_view.setTextColor(Color.parseColor("#000000"));
        s_view.addView(t_view);
        alertMessage.setTitle("Kodu İncele");
        alertMessage.setView(s_view);


        t_view.setText("int AltDizi = 0, AltSinir, UstSinir, Pivot, Alt, Ust;\n" +
                "int _Alt[]= new int[ArrayFunc.boyut];\n" +
                "int _Ust[] = new int[ArrayFunc.boyut];\n" +
                "_Alt[AltDizi] = 0;\n" +
                "_Ust[AltDizi] = ArrayFunc.boyut - 1;\n" +
                "do{\n" +
                "Alt = _Alt[AltDizi];\n" +
                "Ust = _Ust[AltDizi];\n" +
                "AltDizi--;\n" +
                "do{\n" +
                "AltSinir = Alt; UstSinir = Ust;\n" +
                "Pivot = ArrayFunc.dizi[(Alt + Ust) / 2];\n" +
                "do{\n" +
                "while(ArrayFunc.dizi[AltSinir] < Pivot) ++AltSinir;\n" +
                "while(ArrayFunc.dizi[UstSinir] > Pivot) --UstSinir;\n" +
                "if(AltSinir <= UstSinir) {\n" +
                "if(AltSinir != UstSinir)\n" +
                "ArrayFunc.YerDegis(AltSinir, UstSinir);\n" +
                "++AltSinir;\n" +
                "--UstSinir;\n" +

                "}\n" +

                "}while (AltSinir <= UstSinir);\n" +

                "if(AltSinir < Ust) {\n" +
                "++AltDizi;\n" +
                "_Alt[AltDizi] = AltSinir;\n" +
                "_Ust[AltDizi] = Ust;\n" +
                "}\n" +
                "Ust = UstSinir;\n" +
                "}while(Alt < Ust);\n" +

                "}while(AltDizi > -1);\n");
        final AlertDialog alt = alertMessage.setCancelable(true).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // if this button is clicked, close
                // current activity
                dialog.cancel();
            }
        }).create();


        sonuc = (TextView) view.findViewById(R.id.sonucV8);
        sure = (TextView) view.findViewById(R.id.sureV8);
        btn = (Button) view.findViewById(R.id.siralaV8);

        ((Button) view.findViewById(R.id.kodV8)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alt.show();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(ArrayFunc.yazdir == 2)
                {
                    new Gozlemle().execute((Void) null);
                }
                else {
                    _v = v;
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




    public void F()  // rec
    {
        int AltDizi = 0, AltSinir, UstSinir, Pivot, Alt, Ust;
        int _Alt[]= new int[ArrayFunc.boyut]; int _Ust[] = new int[ArrayFunc.boyut];
        _Alt[AltDizi] = 0;
        _Ust[AltDizi] = ArrayFunc.boyut - 1;
        do{
            Alt = _Alt[AltDizi];
            Ust = _Ust[AltDizi];
            AltDizi--;
            do{
                AltSinir = Alt; UstSinir = Ust;
                Pivot = ArrayFunc.dizi[(Alt + Ust) / 2];
                do{
                    while(ArrayFunc.dizi[AltSinir] < Pivot) ++AltSinir;
                    while(ArrayFunc.dizi[UstSinir] > Pivot) --UstSinir;
                    if(AltSinir <= UstSinir) {
                        if(AltSinir != UstSinir)
                            ArrayFunc.YerDegis(AltSinir, UstSinir);
                            ++AltSinir;
                            --UstSinir;

                    }

                }while (AltSinir <= UstSinir);

                if(AltSinir < Ust) {
                    ++AltDizi;
                    _Alt[AltDizi] = AltSinir;
                    _Ust[AltDizi] = Ust;
                }
                Ust = UstSinir;
            }while(Alt < Ust);

        }while(AltDizi > -1);


    }


    public class Gozlemle extends AsyncTask<Void, Integer, Void> {


        int boyut;
        String sdizi;
        public void F2(int Alt, int Ust)  // rec
        {

            int AltDizi = 0, AltSinir, UstSinir, Pivot;
            int _Alt[]= new int[ArrayFunc.boyut]; int _Ust[] = new int[ArrayFunc.boyut];
            _Alt[AltDizi] = 0;
            _Ust[AltDizi] = ArrayFunc.boyut - 1;
            do{
                Alt = _Alt[AltDizi];
                Ust = _Ust[AltDizi];
                AltDizi--;
                do{
                    AltSinir = Alt; UstSinir = Ust;
                    Pivot = ArrayFunc.dizi[(Alt + Ust) / 2];
                    do{
                        while(ArrayFunc.dizi[AltSinir] < Pivot) {
                            publishProgress(AltSinir, -1, (Alt + Ust) / 2);
                            try {
                                Thread.sleep(ArrayFunc.zaman);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            ++AltSinir;
                        }
                        publishProgress(AltSinir, -1, (Alt + Ust) / 2);
                        try {
                            Thread.sleep(ArrayFunc.zaman);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        while(ArrayFunc.dizi[UstSinir] > Pivot) {
                            publishProgress(AltSinir, UstSinir, (Alt + Ust) / 2);
                            try {
                                Thread.sleep(ArrayFunc.zaman);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            --UstSinir;
                        }
                        if(AltSinir <= UstSinir) {
                            if(AltSinir != UstSinir) {
                                publishProgress(AltSinir, UstSinir, (Alt + Ust) / 2);
                                try {
                                    Thread.sleep(ArrayFunc.zaman);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                ArrayFunc.YerDegis(AltSinir, UstSinir);
                                publishProgress(UstSinir, AltSinir, (Alt + Ust) / 2);
                                try {
                                    Thread.sleep(ArrayFunc.zaman);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            ++AltSinir;
                            --UstSinir;

                        }

                    }while (AltSinir <= UstSinir);

                    if(AltSinir < Ust) {
                        ++AltDizi;
                        _Alt[AltDizi] = AltSinir;
                        _Ust[AltDizi] = Ust;
                    }
                    Ust = UstSinir;
                }while(Alt < Ust);

            }while(AltDizi > -1);






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
