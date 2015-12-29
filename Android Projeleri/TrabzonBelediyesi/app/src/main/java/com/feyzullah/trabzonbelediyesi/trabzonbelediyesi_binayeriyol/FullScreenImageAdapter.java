package com.feyzullah.trabzonbelediyesi.trabzonbelediyesi_binayeriyol;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class FullScreenImageAdapter extends PagerAdapter {

    private Activity _activity;
    private LayoutInflater inflater;

    private int byi;
    // constructor

    public FullScreenImageAdapter(Activity activity, int byi) {
        this._activity = activity;

        this.byi = byi;

        if(byi == 0) {
            Bina_Resimler Resimler_vt = new Bina_Resimler(activity);
            Bina_verilerListe.Resimler = Bina_Resimler.KayitSorgula(Resimler_vt, Bina_verilerListe.Resim_id);
        }
        else if(byi == 1)
        {
            Yol_Resimler Resimler_vt = new Yol_Resimler(activity);
            Yol_verilerListe.Resimler = Yol_Resimler.KayitSorgula(Resimler_vt, Yol_verilerListe.Resim_id);
        }
        else if(byi == 2)
        {
            Isyeri_Resimler Resimler_vt = new Isyeri_Resimler(activity);
            Isyeri_verilerListe.Resimler = Isyeri_Resimler.KayitSorgula(Resimler_vt, Isyeri_verilerListe.Resim_id);
        }
    }

    @Override
    public int getCount() {
        int rt = 0;
        if(byi == 0)      rt = Bina_verilerListe.Resimler.size();
        else if(byi == 1) rt = Yol_verilerListe.Resimler.size();
        else if(byi == 2) rt = Isyeri_verilerListe.Resimler.size();
        return rt;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((RelativeLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Touch_image_view imgDisplay;
        Button btnClose;

        inflater = (LayoutInflater) _activity
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewLayout = inflater.inflate(R.layout.layout_fullscreen_image, container,
                false);

        Bitmap bmImg = null;
        if(byi == 0)      bmImg = BitmapFactory.decodeFile(Bina_verilerListe.Resimler.get(position));
        else if(byi == 1) bmImg = BitmapFactory.decodeFile(Yol_verilerListe.Resimler.get(position));
        else if(byi == 2) bmImg = BitmapFactory.decodeFile(Isyeri_verilerListe.Resimler.get(position));
        imgDisplay = (Touch_image_view) viewLayout.findViewById(R.id.imgDisplay);
        btnClose = (Button) viewLayout.findViewById(R.id.btnClose);
        imgDisplay.setImageBitmap(bmImg);
        //imageView.setImageBitmap(Bina_verilerListe.Resimler.get(position));
        //imgDisplay.setLayoutParams(new Gallery.LayoutParams(100, 100));
        //imgDisplay.setBackgroundResource(itemBackground);



        //BitmapFactory.Options options = new BitmapFactory.Options();
        //options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        //Bitmap bitmap = BitmapFactory.decodeFile(_imagePaths.get(position), options);
        //imgDisplay.setImageBitmap(bitmap);

        // close button click event
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _activity.finish();
            }
        });

        ((ViewPager) container).addView(viewLayout);

        return viewLayout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((RelativeLayout) object);

    }
}