package com.capsapp.feyzullah.caps;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.media.audiofx.BassBoost;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.Random;


public class MainActivity extends ActionBarActivity {

    final static int cameraData = 0;
    Bitmap bmp;
    ImageView imgview;
    EditText edt;
    Toast mesaj;
    Paint backpaint, yazipaint;
    ColorDrawable buttonColor;
    int color = Color.BLACK;
    public static int yaziboyu = 10, yaziboyu1 = 10, yaziboyu2 = 10, yaziboyu3 = 10;
    ProgressDialog mDialog;

    public class BackgroundTask extends AsyncTask<Void, Void, Void> {
        String hata = "";
        String path;
        int durum = 0;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {


            try {
                path = Environment.getExternalStorageDirectory().toString();

                OutputStream fOut = null;
                Random generator = new Random();
                char x = (char) (97 + generator.nextInt(24));
                File file = new File(path, "caps" + (char) (97 + generator.nextInt(24)) + generator.nextInt(24) + (char) (97 + generator.nextInt(24)) + generator.nextInt(24) + (char) (97 + generator.nextInt(24)) + generator.nextInt(24) + ".jpg"); // the File to save to
                try {

                    Bitmap birlesmisBitmap;

                    int width, height;

                    if (bitmap1.getWidth() >= bitmap2.getWidth() && bitmap1.getWidth() >= bitmap3.getWidth()) {
                        if (bitmap2.getWidth() != 1)
                            bitmap2 = Bitmap.createScaledBitmap(bitmap2, bitmap1.getWidth(), (int)((float)((float)bitmap2.getHeight() / (float)bitmap2.getWidth()) * bitmap1.getWidth()), false);
                        if (bitmap3.getWidth() != 1)
                            bitmap3 = Bitmap.createScaledBitmap(bitmap3, bitmap1.getWidth(), (int)((float)((float)bitmap3.getHeight() / (float)bitmap3.getWidth()) * bitmap1.getWidth()), false);
                    } else if (bitmap2.getWidth() >= bitmap1.getWidth() && bitmap2.getWidth() >= bitmap3.getWidth()) {
                        if (bitmap1.getWidth() != 1)
                            bitmap1 = Bitmap.createScaledBitmap(bitmap1, bitmap2.getWidth(), (int)((float)((float)bitmap1.getHeight() /(float) bitmap1.getWidth()) * bitmap2.getWidth()), false);
                        if (bitmap3.getWidth() != 1)
                            bitmap3 = Bitmap.createScaledBitmap(bitmap3, bitmap2.getWidth(), (int)((float)((float)bitmap3.getHeight() / (float)bitmap3.getWidth()) * bitmap2.getWidth()), false);
                    } else if (bitmap3.getWidth() >= bitmap2.getWidth() && bitmap3.getWidth() >= bitmap1.getWidth()) {
                        if (bitmap2.getWidth() != 1)
                            bitmap2 = Bitmap.createScaledBitmap(bitmap2, bitmap3.getWidth(), (int)((float)((float)bitmap2.getHeight() / (float)bitmap2.getWidth()) * bitmap3.getWidth()), false);
                        if (bitmap1.getWidth() != 1)
                            bitmap1 = Bitmap.createScaledBitmap(bitmap1, bitmap3.getWidth(), (int)((float)((float)bitmap1.getHeight() / (float)bitmap1.getWidth()) * bitmap3.getWidth()), false);
                    }



                    width = bitmap1.getWidth();
                    height = bitmap1.getHeight() + bitmap2.getHeight();

                    birlesmisBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);

                    Canvas comboImage = new Canvas(birlesmisBitmap);


                    comboImage.drawBitmap(bitmap1, 0f, 0f, null);
                    comboImage.drawBitmap(bitmap2, 0f, bitmap1.getHeight(), null);


                    Bitmap birlesmisBitmap2;



                    width = birlesmisBitmap.getWidth();
                    height = birlesmisBitmap.getHeight() + bitmap3.getHeight();

                    birlesmisBitmap2 = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);

                    comboImage = new Canvas(birlesmisBitmap2);


                    comboImage.drawBitmap(birlesmisBitmap, 0f, 0f, null);
                    comboImage.drawBitmap(bitmap3, 0f, birlesmisBitmap.getHeight(), null);

                    orjinal = birlesmisBitmap2;



                    MediaStore.Images.Media.insertImage(getContentResolver(), birlesmisBitmap2, "Baslik", "aciklama");



                } catch (Exception e) {
                    durum = 1;
                    hata = e.getMessage().toString();
                    e.printStackTrace();
                }

            }
            catch (Exception hata)
            {
                mesaj.show();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            mDialog.dismiss();
            if(durum == 0)
            {
                Toast.makeText(getApplicationContext(),  getString(R.string.toast),Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(getApplicationContext(),hata,Toast.LENGTH_LONG).show();
            }
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


    ImageView imgView1;
    ImageView imgView2;
    ImageView imgView3;

    TextView cizgi1;
    TextView cizgi2;
    TextView cizgi3;

    Toast hatamesaji;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        try {
            hatamesaji = Toast.makeText(this, "Operation can not" , Toast.LENGTH_LONG);
            mesaj = Toast.makeText(getApplicationContext(), "Kaydedilemedi!", Toast.LENGTH_LONG);
            syc1 = 0;
            syc2 = 0;
            syc3 = 0;

            cizgi1 = (TextView) findViewById(R.id.cztextView3);
            cizgi2 = (TextView) findViewById(R.id.cztextView4);
            cizgi3 = (TextView) findViewById(R.id.cztextView5);

            imgView1 = (ImageView) findViewById(R.id.imageView);
            imgView2 = (ImageView) findViewById(R.id.imageView2);
            imgView3 = (ImageView) findViewById(R.id.imageView3);


            mDialog = new ProgressDialog(this);

            mDialog.setMessage(getString(R.string.kaydet));
            ActionBar actionBar = getSupportActionBar();
            //actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME );
            Bitmap.Config conf = Bitmap.Config.ARGB_4444; // see other conf types

            bitmap1 = Bitmap.createBitmap(1, 1, conf);
            bitmap2 = Bitmap.createBitmap(1, 1, conf);
            bitmap3 = Bitmap.createBitmap(1, 1, conf);
            actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF5722")));
            //actionBar.setIcon(R.drawable.capsicon);
            imgview = (ImageView) findViewById(R.id.imageView);
            edt = (EditText) findViewById(R.id.editText);


            backpaint = new Paint();
            backpaint.setColor(Color.GREEN);
            backpaint.setStyle(Paint.Style.FILL_AND_STROKE);
            backpaint.setStrokeWidth(10);

            yazipaint = new Paint();
            yazipaint.setColor(color);
            yazipaint.setTextSize(yaziboyu);
            yazipaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));


            if (actionBar != null) {
                actionBar.show();

                // Modify the action bar to use a custom layout to center the title.
                actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
                actionBar.setCustomView(R.layout.custom_actionbar);

            }

            ((Button)findViewById(R.id.galeriacbtn)).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.setType("image/*");
                    intent.setAction(Intent.ACTION_DEFAULT);
                    startActivity(intent);
                }
            });

            ((ImageView) findViewById(R.id.imageButtonsave)).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new BackgroundTask().execute((Void) null);
                }
            });
            //buttonColor = (ColorDrawable) colorbtn.getBackground();
        }
        catch (Exception hata)
        {
            Toast.makeText(getApplicationContext(), hata.getMessage().toString(), Toast.LENGTH_LONG);
        }
    }

    public void onColor(View v)
    {
        try
        {
        buttonColor = (ColorDrawable) v.getBackground();
        color = buttonColor.getColor();
        yazipaint.setColor(color);
        ResmiYap();
        }
        catch (Exception hata)
        {
            hatamesaji.show();
        }
    }

    public void onColor2(View v)
    {
        try
        {
        buttonColor = (ColorDrawable) v.getBackground();
        color = buttonColor.getColor();
        backpaint.setColor(color);
        ResmiYap();
        }
        catch (Exception hata)
        {
            hatamesaji.show();
        }
    }
    public static float topy, topy1, topy2, topy3;
    public static int yazi_x = 0, yazi_x1 = 0, yazi_x2 = 0, yazi_x3 = 0;
    public static int yazi_y = 0, yazi_y1 = 0, yazi_y2 = 0, yazi_y3 = 0;

    public void yaziSol(View v)
    {
        try
        {
        yazi_x = yazi_x - 10;
        ResmiYap();
        }
        catch (Exception hata)
        {
            hatamesaji.show();
        }
    }
    public void yaziSag(View v)
    {
        try
        {
        yazi_x = yazi_x + 10;
        ResmiYap();
        }
        catch (Exception hata)
        {
            hatamesaji.show();
        }
    }
    public void yaziUp(View v)
    {
        try
        {
        yazi_y = yazi_y - 10;
        ResmiYap();
        }
        catch (Exception hata)
        {
            hatamesaji.show();
        }
    }
    public void yaziDown(View v)
    {
        try
        {
        yazi_y = yazi_y + 10;
        ResmiYap();
        }
        catch (Exception hata)
        {
            hatamesaji.show();
        }
    }

    public void kutuUp(View v)
    {
        try
        {
        topy = topy - 10;
        ResmiYap();
        }
        catch (Exception hata)
        {
            hatamesaji.show();
        }
    }
    public void kutuDown(View v)
    {
        try
        {
        topy = topy + 10;
        ResmiYap();
        }
        catch (Exception hata)
        {
            hatamesaji.show();
        }
    }

    public void yaziBoyUp(View v)
    {
        try
        {
        yaziboyu = yaziboyu + 5;
        yazipaint.setTextSize(yaziboyu);
        ResmiYap();
        }
        catch (Exception hata)
        {
            hatamesaji.show();
        }
    }
    public void yaziBoyDown(View v)
    {
        try
        {
        yaziboyu = yaziboyu - 5;
        yazipaint.setTextSize(yaziboyu);
        ResmiYap();
        }
        catch (Exception hata)
        {
            hatamesaji.show();
        }
    }
    Bitmap bitmap1, bitmap2, bitmap3;
    int i1 = 0, i2 = 0, i3 = 0;
    public void ResmiYap()
    {
        try {
            if(imgwho == 1) {
                bmp = bmp1;
                bitmap1  = bmp.copy(Bitmap.Config.ARGB_8888, true); // Load your bitmap here
                Canvas canvas = new Canvas(bitmap1);

                float leftx = 0;
                 //topy= bmp.getHeight() - 20;
                topy1 = topy;
                yazi_x1 = yazi_x;
                yazi_y1 = yazi_y;
                yaziboyu1 = yaziboyu;

                float rightx = bmp.getWidth();
                float bottomy =  bmp.getHeight();
                canvas.drawRect(leftx, topy, rightx, bottomy, backpaint);

                canvas.drawText(edt.getText().toString(), yazi_x, yazi_y, yazipaint);

                imgview.setImageBitmap(bitmap1);
            }
            else if(imgwho == 2) {
                bmp = bmp2;
                bitmap2  = bmp.copy(Bitmap.Config.ARGB_8888, true); // Load your bitmap here
                Canvas canvas = new Canvas(bitmap2);

                float leftx = 0;
                // topy= bmp.getHeight() - 20;
                topy2 = topy;
                yazi_x2 = yazi_x;
                yazi_y2 = yazi_y;
                yaziboyu2 = yaziboyu;
                float rightx = bmp.getWidth();
                float bottomy =  bmp.getHeight();
                canvas.drawRect(leftx, topy, rightx, bottomy, backpaint);

                canvas.drawText(edt.getText().toString(), yazi_x, yazi_y, yazipaint);

                imgview.setImageBitmap(bitmap2);
            }
            else {
                bmp = bmp3;
                bitmap3  = bmp.copy(Bitmap.Config.ARGB_8888, true); // Load your bitmap here
                Canvas canvas = new Canvas(bitmap3);

                float leftx = 0;
                //topy= bmp.getHeight() - 20;
                topy3 = topy;
                yazi_x3 = yazi_x;
                yazi_y3 = yazi_y;
                yaziboyu3 = yaziboyu;
                float rightx = bmp.getWidth();
                float bottomy =  bmp.getHeight();
                canvas.drawRect(leftx, topy, rightx, bottomy, backpaint);

                canvas.drawText(edt.getText().toString(), yazi_x, yazi_y, yazipaint);

                imgview.setImageBitmap(bitmap3);
            }


        }
        catch (Exception hata)
        {
            hatamesaji.show();
        }
    }
    Bitmap bmp1, bmp2, bmp3;
    int syc1, syc2, syc3;
    int imgwho = 0;
    Bitmap resim;
    Paint paint;
    public void onYazi(View v)
    {

        try
        {
        yazipaint.setTextSize(yaziboyu);
        ResmiYap();
        }
        catch (Exception hata)
        {

        }

    }
    private static final int IMAGE_PICK = 1;


    public void onCamera(View v)
    {

try {
    imgview = (ImageView) v;
    if (v.getTag().equals("bmp1")) {
        imgwho = 1;
        topy = topy1;
        yazi_x = yazi_x1;
        yazi_y = yazi_y1;
        yaziboyu = yaziboyu1;
        if (syc1 != 0) {

            resim = bitmap1.copy(Bitmap.Config.ARGB_8888, true);
            paint = new Paint();
            paint.setColor(Color.GREEN);
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            paint.setStrokeWidth(10);
            Canvas canvas = new Canvas(resim);
            canvas.drawRect(0, 0, resim.getWidth(), resim.getHeight() / 10, paint);
            imgView1.setImageBitmap(resim);
            if (bitmap2.getWidth() == 1)
                imgView2.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.new_image));
            else imgView2.setImageBitmap(bitmap2);
            if (bitmap3.getWidth() == 1)
                imgView3.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.new_image));
            else imgView3.setImageBitmap(bitmap3);

        } else {
            syc1++;
            Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            intent.setType("image/*");
            startActivityForResult(Intent.createChooser(intent, "Bir Fotoğraf Seçin"), IMAGE_PICK);
        }


    } else if (v.getTag().equals("bmp2")) {

        imgwho = 2;
        if (syc2 != 0) {
            topy = topy2;
            yazi_x = yazi_x2;
            yazi_y = yazi_y2;
            yaziboyu = yaziboyu2;
            resim = bitmap2.copy(Bitmap.Config.ARGB_8888, true);
            paint = new Paint();
            paint.setColor(Color.GREEN);
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            paint.setStrokeWidth(10);
            Canvas canvas = new Canvas(resim);
            canvas.drawRect(0, 0, resim.getWidth(), resim.getHeight() / 10, paint);
            if (bitmap1.getWidth() == 1)
                imgView1.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.new_image));
            else imgView1.setImageBitmap(bitmap1);
            imgView2.setImageBitmap(resim);
            if (bitmap3.getWidth() == 1)
                imgView3.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.new_image));
            else imgView3.setImageBitmap(bitmap3);
        } else {
            syc2 = 1;
            Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            intent.setType("image/*");
            startActivityForResult(Intent.createChooser(intent, "Bir Fotoğraf Seçin"), IMAGE_PICK);
        }


    } else {
        topy = topy3;
        yazi_x = yazi_x3;
        yazi_y = yazi_y3;
        yaziboyu = yaziboyu3;
        imgwho = 3;
        if (syc3 != 0) {

            resim = bitmap3.copy(Bitmap.Config.ARGB_8888, true);
            paint = new Paint();
            paint.setColor(Color.GREEN);
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            paint.setStrokeWidth(10);
            Canvas canvas = new Canvas(resim);
            canvas.drawRect(0, 0, resim.getWidth(), resim.getHeight() / 10, paint);
            if (bitmap1.getWidth() == 1)
                imgView1.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.new_image));
            else imgView1.setImageBitmap(bitmap1);
            if (bitmap2.getWidth() == 1)
                imgView2.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.new_image));
            else imgView2.setImageBitmap(bitmap2);
            imgView3.setImageBitmap(resim);
        } else {
            syc3++;
            Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            intent.setType("image/*");
            startActivityForResult(Intent.createChooser(intent, "Bir Fotoğraf Seçin"), IMAGE_PICK);

        }


    }


}
catch (Exception hata)
{
    Toast.makeText(getApplicationContext(), hata.getMessage().toString(), Toast.LENGTH_LONG);
}
    }

    Bitmap orjinal;
    float oran_x, oran_y;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);

        try
        {
        Display display = ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
        if(requestCode == IMAGE_PICK && resultCode == RESULT_OK)
        {
            Uri selectedImage = data.getData();
            String [] filePathColumn = {MediaStore.Images.Media.DATA};

            Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String filePath = cursor.getString(columnIndex);
            bmp =  BitmapFactory.decodeFile(filePath);

            int sbt = 1280;
            if(bmp.getHeight() > bmp.getWidth()) {
                if (bmp.getHeight() > sbt) {
                    bmp = Bitmap.createScaledBitmap(bmp, (int) ((float) ((float) bmp.getWidth() / (float) bmp.getHeight()) * sbt), sbt, false);
                }
            }
            else
            {
                if(bmp.getWidth() > sbt)
                {
                    bmp = Bitmap.createScaledBitmap(bmp, sbt , (int) ((float) ((float) bmp.getHeight() / (float) bmp.getWidth()) * sbt), false);
                }
            }

            orjinal = Bitmap.createScaledBitmap(bmp, bmp.getWidth() , bmp.getHeight(), false);;
            int x = bmp.getWidth(), y = bmp.getHeight();
            int yenix = x; // (x > display.getWidth()) ? display.getWidth() : x;
            int yeniy = y; // (int)(display.getHeight()/3);
            //bmp = Bitmap.createScaledBitmap(bmp, yenix, yeniy, false);
            cursor.close();
            oran_x = x / yenix;
            oran_y = y / yeniy;


            imgview.setImageBitmap(bmp);
            imgview.getLayoutParams().height = (display.getHeight()/3);
            imgview.getLayoutParams().width = (display.getWidth()/2);
            int tpy = (int)(bmp.getHeight() / 5);
            if(imgwho == 1) { bmp1 = bmp; bitmap1 = bmp; topy1 = (int)(bmp.getHeight() - tpy); topy = topy1;  yazi_y1 = bmp.getHeight() - (tpy / 2); yazi_y = yazi_y1; yazi_x = yazi_x1; yaziboyu1 = (int)(tpy * 0.60); yaziboyu = yaziboyu1;}
            else if(imgwho == 2) { bmp2 = bmp; bitmap2 = bmp; topy2 = (int)(bmp.getHeight() - tpy); topy = topy2; yazi_y2 = bmp.getHeight() -  (tpy / 2); yazi_y = yazi_y2; yazi_x = yazi_x2; yaziboyu2 = (int)(tpy * 0.60); yaziboyu = yaziboyu2;}
            else { bmp3 = bmp; bitmap3 = bmp; topy3 = (int)(bmp.getHeight() - tpy); topy = topy3; yazi_y3 = bmp.getHeight() -  (tpy / 2); yazi_y = yazi_y3; yazi_x = yazi_x3; yaziboyu3 = (int)(tpy * 0.60); yaziboyu = yaziboyu3; }
        }

        }
        catch (Exception hata)
        {
            Toast.makeText(getApplicationContext(), hata.getMessage().toString(), Toast.LENGTH_LONG);
        }
    }
        @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();



        return super.onOptionsItemSelected(item);
    }
}
