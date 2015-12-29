package com.feyzullah.lugatbilgioyunu.lgatbilgioyunu;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class OyunEkrani extends AppCompatActivity {

    int cevap = 0, sure = -1, sorusayisi = -1;
    public void yenisoru()
    {



        try
        {
            String[] Secenek = new String[4];
            String[] dizi;
            String[] dizi2;
            String[] yanlis = new String[3];

            Random rand = new Random();
            int sayi = Math.abs(rand.nextInt(k));

            dizi = sozluk[sayi].split(": ");

            sayi = rand.nextInt(k);

            dizi2 = sozluk[sayi].split(": ");
            yanlis[0] = dizi2[1];

            sayi = rand.nextInt(k);

            dizi2 = sozluk[sayi].split(": ");
            yanlis[1] = dizi2[1];

            sayi = rand.nextInt(k);

            dizi2 = sozluk[sayi].split(": ");
            yanlis[2] = dizi2[1];
            ((TextView)findViewById(R.id.kelime_soru)).setText(Html.fromHtml("\"<b><font color=\'#ff0000\'>" + dizi[0] + "</font></b>\" kelimesinin anlamı aşağıdakilerden hangisidir?"));

            sayi = rand.nextInt(4);
            cevap = sayi;

            if(sayi == 0)
            {
                Secenek[0] = dizi[1];
                Secenek[1] = yanlis[0];
                Secenek[2] = yanlis[1];
                Secenek[3] = yanlis[2];
            }
            else if(sayi == 1)
            {
                Secenek[1] = dizi[1];
                Secenek[0] = yanlis[0];
                Secenek[2] = yanlis[1];
                Secenek[3] = yanlis[2];
            }
            else if(sayi == 2)
            {
                Secenek[2] = dizi[1];
                Secenek[0] = yanlis[0];
                Secenek[1] = yanlis[1];
                Secenek[3] = yanlis[2];
            }
            else if(sayi == 3)
            {
                Secenek[3] = dizi[1];
                Secenek[0] = yanlis[0];
                Secenek[2] = yanlis[1];
                Secenek[1] = yanlis[2];
            }

            ((Button)findViewById(R.id.kelime_secenek1)).setText(Secenek[0]);
            ((Button)findViewById(R.id.kelime_secenek2)).setText(Secenek[1]);
            ((Button)findViewById(R.id.kelime_secenek3)).setText(Secenek[2]);
            ((Button)findViewById(R.id.kelime_secenek4)).setText(Secenek[3]);
        }
        catch (Exception ex) { }
    }

    int sonuc = 0;
    public void GameOver()
    {
        suresayaci.cancel();
        if(sonuc == 0) {
            AlertDialog.Builder alertMessage = new AlertDialog.Builder(OyunEkrani.this);
            alertMessage.setTitle("Çok Hızlısın");
            alertMessage.setMessage("Çok yanlışın var. Biraz daha dikkat et.\nDoğru Cevap: " + skor + " Yanlış Cevap: " + (15 - skor) + "\n" + "Süre: " + Sdakika + ":" + Ssaniye);
            alertMessage.setCancelable(false);
            alertMessage.setPositiveButton("Tekrar Oyna", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // if this button is clicked, close
                    // current activity
                    // MainActivity.this.finish();
                    Intent geri = new Intent(getApplicationContext(), OyunEkrani.class);
                    startActivity(geri);

                }
            }).setNegativeButton("Çıkış", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // if this button is clicked, close
                    // current activity
                    // MainActivity.this.finish();
                    Intent geri = new Intent(getApplicationContext(), GirisEkrani.class);
                    startActivity(geri);

                }
            }).create().show();
        }
        else if(sonuc == 1)
        {
            AlertDialog.Builder alertMessage = new AlertDialog.Builder(OyunEkrani.this);
            alertMessage.setTitle("Daha iyi olmalısın");
            alertMessage.setMessage("Yanlışlarını düzeltmelisin...\nDoğru Cevap: " + skor + " Yanlış Cevap: " + (15 - skor) + "\n" + "Süre: " + Sdakika + ":" + Ssaniye);
            alertMessage.setCancelable(false);
            alertMessage.setPositiveButton("Tekrar Oyna", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // if this button is clicked, close
                    // current activity
                    // MainActivity.this.finish();
                    Intent geri = new Intent(getApplicationContext(), OyunEkrani.class);
                    startActivity(geri);

                }
            }).setNegativeButton("Çıkış", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // if this button is clicked, close
                    // current activity
                    // MainActivity.this.finish();
                    Intent geri = new Intent(getApplicationContext(), GirisEkrani.class);
                    startActivity(geri);

                }
            }).create().show();
        }
        else if(sonuc == 2)
        {
            AlertDialog.Builder alertMessage = new AlertDialog.Builder(OyunEkrani.this);
            alertMessage.setTitle("Malesef...");
            alertMessage.setMessage("Çok yanlış cevap ve yavaş...\nDoğru Cevap: " + skor + " Yanlış Cevap: " + (15 - skor) + "\n" + "Süre: " + Sdakika + ":" + Ssaniye);
            alertMessage.setCancelable(false);
            alertMessage.setPositiveButton("Tekrar Oyna", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // if this button is clicked, close
                    // current activity
                    // MainActivity.this.finish();
                    Intent geri = new Intent(getApplicationContext(), OyunEkrani.class);
                    startActivity(geri);

                }
            }).setNegativeButton("Çıkış", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // if this button is clicked, close
                    // current activity
                    // MainActivity.this.finish();
                    Intent geri = new Intent(getApplicationContext(), GirisEkrani.class);
                    startActivity(geri);

                }
            }).create().show();
        }
        else if(sonuc == 3)
        {
            AlertDialog.Builder alertMessage = new AlertDialog.Builder(OyunEkrani.this);
            alertMessage.setTitle("ÇOK OKUMALISIN");
            alertMessage.setMessage("Lütfen biraz kitap oku...\nDoğru Cevap: " + skor + " Yanlış Cevap: " + (15 - skor) + "\n" + "Süre: " + Sdakika + ":" + Ssaniye);
            alertMessage.setCancelable(false);
            alertMessage.setPositiveButton("Tekrar Oyna", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // if this button is clicked, close
                    // current activity
                    // MainActivity.this.finish();
                    Intent geri = new Intent(getApplicationContext(), OyunEkrani.class);
                    startActivity(geri);

                }
            }).setNegativeButton("Çıkış", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // if this button is clicked, close
                    // current activity
                    // MainActivity.this.finish();
                    Intent geri = new Intent(getApplicationContext(), GirisEkrani.class);
                    startActivity(geri);

                }
            }).create().show();
        }
        else if(sonuc == 4)
        {
            AlertDialog.Builder alertMessage = new AlertDialog.Builder(OyunEkrani.this);
            alertMessage.setTitle("Daha İyi Olabilirsin");
            alertMessage.setMessage("Kelime Hazinen fena değil...\nDoğru Cevap: " + skor + " Yanlış Cevap: " + (15 - skor) + "\n" + "Süre: " + Sdakika + ":" + Ssaniye);
            alertMessage.setCancelable(false);
            alertMessage.setPositiveButton("Tekrar Oyna", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // if this button is clicked, close
                    // current activity
                    // MainActivity.this.finish();
                    Intent geri = new Intent(getApplicationContext(), OyunEkrani.class);
                    startActivity(geri);

                }
            }).setNegativeButton("Çıkış", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // if this button is clicked, close
                    // current activity
                    // MainActivity.this.finish();
                    Intent geri = new Intent(getApplicationContext(), GirisEkrani.class);
                    startActivity(geri);

                }
            }).create().show();
        }
        else if(sonuc == 5)
        {
            AlertDialog.Builder alertMessage = new AlertDialog.Builder(OyunEkrani.this);
            alertMessage.setTitle("ÇOK İYİSİN!");
            alertMessage.setMessage("En iyi olmana çok az kaldı...\nDoğru Cevap: " + skor + " Yanlış Cevap: " + (15 - skor) + "\n" + "Süre: " + Sdakika + ":" + Ssaniye);
            alertMessage.setCancelable(false);
            alertMessage.setPositiveButton("Tekrar Oyna", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // if this button is clicked, close
                    // current activity
                    // MainActivity.this.finish();
                    Intent geri = new Intent(getApplicationContext(), OyunEkrani.class);
                    startActivity(geri);

                }
            }).setNegativeButton("Çıkış", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // if this button is clicked, close
                    // current activity
                    // MainActivity.this.finish();
                    Intent geri = new Intent(getApplicationContext(), GirisEkrani.class);
                    startActivity(geri);

                }
            }).create().show();
        }
        else if(sonuc == 6)
        {
            AlertDialog.Builder alertMessage = new AlertDialog.Builder(OyunEkrani.this);
            alertMessage.setTitle("İYİSİN AMA...");
            alertMessage.setMessage("Zamanı daha iyi kullanmalısın...\nDoğru Cevap: " + skor + " Yanlış Cevap: " + (15 - skor) + "\n" + "Süre: " + Sdakika + ":" + Ssaniye);
            alertMessage.setCancelable(false);
            alertMessage.setPositiveButton("Tekrar Oyna", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // if this button is clicked, close
                    // current activity
                    // MainActivity.this.finish();
                    Intent geri = new Intent(getApplicationContext(), OyunEkrani.class);
                    startActivity(geri);

                }
            }).setNegativeButton("Çıkış", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // if this button is clicked, close
                    // current activity
                    // MainActivity.this.finish();
                    Intent geri = new Intent(getApplicationContext(), GirisEkrani.class);
                    startActivity(geri);

                }
            }).create().show();
        }
        else if(sonuc == 7)
        {
            AlertDialog.Builder alertMessage = new AlertDialog.Builder(OyunEkrani.this);
            alertMessage.setTitle("ÇOK İYİ AMA...");
            alertMessage.setMessage("Zamanı daha iyi kullanmalısın...\nDoğru Cevap: " + skor + " Yanlış Cevap: " + (15 - skor) + "\n" + "Süre: " + Sdakika + ":" + Ssaniye);
            alertMessage.setCancelable(false);
            alertMessage.setPositiveButton("Tekrar Oyna", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // if this button is clicked, close
                    // current activity
                    // MainActivity.this.finish();
                    Intent geri = new Intent(getApplicationContext(), OyunEkrani.class);
                    startActivity(geri);

                }
            }).setNegativeButton("Çıkış", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // if this button is clicked, close
                    // current activity
                    // MainActivity.this.finish();
                    Intent geri = new Intent(getApplicationContext(), GirisEkrani.class);
                    startActivity(geri);

                }
            }).create().show();
        }
        else if(sonuc == 8)
        {
            AlertDialog.Builder alertMessage = new AlertDialog.Builder(OyunEkrani.this);
            alertMessage.setTitle("TEBRİKLER... İŞTE BU..");
            alertMessage.setMessage("Zirvedesin. Çok iyisin.\nDoğru Cevap: " + skor + " Yanlış Cevap: " + (15 - skor) + "\n" + "Süre: " + Sdakika + ":" + Ssaniye);
            alertMessage.setCancelable(false);
            alertMessage.setPositiveButton("Tekrar Oyna", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // if this button is clicked, close
                    // current activity
                    // MainActivity.this.finish();

                    Intent geri = new Intent(getApplicationContext(), OyunEkrani.class);
                    startActivity(geri);

                }
            }).setNegativeButton("Çıkış", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // if this button is clicked, close
                    // current activity
                    // MainActivity.this.finish();
                    Intent geri = new Intent(getApplicationContext(), GirisEkrani.class);
                    startActivity(geri);

                }
            }).create().show();
        }
    }

    String Ssaniye = "";
    String Sdakika = "";
    int saniye = 0, dakika = 0;
    final Handler handler = new Handler();
    TimerTask suresayaci = new TimerTask() {
        @Override
        public void run() {
            handler.post(new Runnable() {
                public void run() {

                    if(saniye < 10) Ssaniye = "0" + saniye; else Ssaniye = String.valueOf(saniye);
                    if(dakika < 10) Sdakika = "0" + dakika; else Sdakika = String.valueOf(dakika);
                    ((TextView)findViewById(R.id.kelime_sure)).setText(Sdakika + ":" + Ssaniye);
                    saniye++;

                    Veritabani vt = new Veritabani(getApplicationContext());
                    vt.saniyeat(vt);

                    if(saniye == 60)
                    {
                        dakika++;
                        saniye = 0;
                    }

                    if(soru == 0) {

                        if (skor >= 15 && ((dakika < 2) || (dakika == 2 && saniye <= 30))) {
                            sonuc = 8;
                            GameOver();
                            suresayaci.cancel();
                        }
                        else if(skor >= 15)
                        {
                            sonuc = 7;
                            GameOver();
                            suresayaci.cancel();
                        }
                        else if (skor >= 13 && ((dakika < 2) || (dakika == 2 && saniye <= 30))) {
                            sonuc = 5;
                            GameOver();
                            suresayaci.cancel();
                        }
                        else if(skor >= 13)
                        {
                            sonuc = 6;
                            GameOver();
                            suresayaci.cancel();
                        }
                        else if (skor > 8) {
                            sonuc = 4;
                            GameOver();
                            suresayaci.cancel();
                        }
                        else if ((dakika < 2) || (dakika == 2 && saniye <= 2)) {
                            sonuc = 0;
                            GameOver();
                            suresayaci.cancel();
                        }
                        else if (dakika < 3) {
                            sonuc = 1;
                            GameOver();
                            suresayaci.cancel();
                        }
                        else if (dakika < 4) {
                            sonuc = 2;
                            GameOver();
                            suresayaci.cancel();
                        }
                        else {
                            sonuc = 3;
                            GameOver();
                            suresayaci.cancel();
                        }
                    }

                }
            });
        }
    };

    int k = -1;
    String sozluk[] = new String[11052];
    public void sozlukyukle()
    {
        String hata = "";
        try {
            AssetManager am = getApplicationContext().getAssets();
            InputStream instream = am.open("dosya");

            InputStreamReader inputreader = new InputStreamReader(instream);
            BufferedReader input = new BufferedReader(inputreader);


            for (int i = 0; i < 11005; i++) {

                k++;
                if (((sozluk[k] = input.readLine()) == null) || (sozluk[k].split(": ")).length < 2) {
                    hata = hata + k + " ";
                    i++;
                    k--;
                }

            }

        } catch (Exception ex) { }
    }

    ProgressDialog pdialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oyun_ekrani);

        getSupportActionBar().hide();

        ((TextView)findViewById(R.id.kelime_sira)).setText(Html.fromHtml("Soru <b><font color='#000000'>15</font></b>"));





        pdialog=new ProgressDialog(this);
        new ArkaPlanKaydet().execute((Void) null);

    }


    @Override
    public void onBackPressed() {
        suresayaci.cancel();
        Intent geri = new Intent(getApplicationContext(), GirisEkrani.class);
        startActivity(geri);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_oyun_ekrani, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    int soru = 15, skor = 0, durum = 0;
    Button basilan;

    public class butonrengi extends AsyncTask<Void, Void, Void> {


        @Override
        protected void onPreExecute() {

            try
            {
                ((Button) findViewById(R.id.kelime_secenek1)).setClickable(false);
                ((Button) findViewById(R.id.kelime_secenek2)).setClickable(false);
                ((Button) findViewById(R.id.kelime_secenek3)).setClickable(false);
                ((Button) findViewById(R.id.kelime_secenek4)).setClickable(false);

                Veritabani vt = new Veritabani(getApplicationContext());
                if(durum == 0) {


                    //((TextView)findViewById(R.id.kelime_aciklama)).setText("Doğru: " + skor + " Yanlış: " + (soru - skor - 1));
                    vt.soruat(vt,0);
                    try {
                        basilan.setBackgroundResource(R.drawable.btn_red);
                        if (cevap == 0)
                        ((Button) findViewById(R.id.kelime_secenek1)).setBackgroundResource(R.drawable.btn_purple);
                        if (cevap == 1)
                        ((Button) findViewById(R.id.kelime_secenek2)).setBackgroundResource(R.drawable.btn_purple);
                        if (cevap == 2)
                        ((Button) findViewById(R.id.kelime_secenek3)).setBackgroundResource(R.drawable.btn_purple);
                        if (cevap == 3)
                        ((Button) findViewById(R.id.kelime_secenek4)).setBackgroundResource(R.drawable.btn_purple);
                    }
                    catch (Exception ex) { }




                }
                else {
                    vt.soruat(vt,1);
                    //((TextView)findViewById(R.id.kelime_sira)).setText("Soru " + String.valueOf(soru).toString());
                    skor ++;
                    //((TextView)findViewById(R.id.kelime_aciklama)).setText("Doğru: " + skor + " Yanlış: " + (soru - skor - 1));

                    basilan.setBackgroundResource(R.drawable.btn_purple);

                }




            }
            catch(Exception hata) { }

        }
        @Override
        protected Void doInBackground(Void... params) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return null;
        }
        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            try {


            } catch (Exception ex) { }

            if(soru > 1)
            yenisoru();

            try {
                soru--;
                if(soru > 0)
                ((TextView)findViewById(R.id.kelime_sira)).setText(Html.fromHtml("Soru <b><font color=\'#000000\'>" + String.valueOf(soru).toString() + "</font></b>"));

                //if (cevap == 0)
                ((Button) findViewById(R.id.kelime_secenek1)).setBackgroundResource(R.drawable.btn_yellow);
                //if (cevap == 1)
                ((Button) findViewById(R.id.kelime_secenek2)).setBackgroundResource(R.drawable.btn_yellow);
                //if (cevap == 2)
                ((Button) findViewById(R.id.kelime_secenek3)).setBackgroundResource(R.drawable.btn_yellow);
                //if (cevap == 3)
                ((Button) findViewById(R.id.kelime_secenek4)).setBackgroundResource(R.drawable.btn_yellow);
            } catch (Exception ex) { }

            try{ basilan.setBackgroundResource(R.drawable.btn_yellow); } catch (Exception ex) { }

            ((Button) findViewById(R.id.kelime_secenek1)).setClickable(true);
            ((Button) findViewById(R.id.kelime_secenek2)).setClickable(true);
            ((Button) findViewById(R.id.kelime_secenek3)).setClickable(true);
            ((Button) findViewById(R.id.kelime_secenek4)).setClickable(true);

        }

    }


    public void kelime_secenek1(View v)
    {
        if(cevap == 0) { durum = 1; } else { durum = 0; }
        basilan = (Button) v;
        new butonrengi().execute((Void) null);
    }

    public void kelime_secenek2(View v)
    {
        if(cevap == 1) { durum = 1; } else { durum = 0; }
        basilan = (Button)v;
        new butonrengi().execute((Void) null);
    }

    public void kelime_secenek3(View v)
    {
        if(cevap == 2) { durum = 1; } else { durum = 0; }
        basilan = (Button)v;
        new butonrengi().execute((Void) null);
    }

    public void kelime_secenek4(View v)
    {
        if(cevap == 3) { durum = 1; } else { durum = 0; }
        basilan = (Button)v;
        new butonrengi().execute((Void) null);
    }


    public class ArkaPlanKaydet extends AsyncTask<Void, Void, Void> {




        @Override
        protected void onPreExecute() {
            super.onPreExecute();


            pdialog.setCancelable(false);
            pdialog.setMessage("Hazırlanıyor...");
            pdialog.show();




        }

        @Override
        protected Void doInBackground(Void... params) {



            sozlukyukle();

            return null;
        }



        @Override
        protected void onPostExecute(Void result) {

            yenisoru();
            pdialog.dismiss();
            Timer timer = new Timer();
            try{ timer.schedule(suresayaci, 0, 1000); } catch(Exception ex) { }


            super.onPostExecute(result);
        }



        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onCancelled(Void result) {
            super.onCancelled(result);
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        suresayaci.cancel();
        System.exit(0);
    }

    @Override
    public void onPanelClosed(int featureId, Menu menu) {
        super.onPanelClosed(featureId, menu);
        suresayaci.cancel();
        System.exit(0);
    }

    @Override
    public void onPause() {
        super.onPause();

        suresayaci.cancel();
        System.exit(0);
    }



    @Override
    public void onStop() {
        super.onStop();


        suresayaci.cancel();
        System.exit(0);
    }


}
