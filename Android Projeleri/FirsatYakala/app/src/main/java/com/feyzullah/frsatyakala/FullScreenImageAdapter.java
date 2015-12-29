package com.feyzullah.frsatyakala;

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
import android.widget.RelativeLayout;

public class FullScreenImageAdapter extends PagerAdapter {

    private Activity _activity;
    private LayoutInflater inflater;

    String resim1;
    String resim2;
    String resim3;
    int resimsayisi;

    // constructor

    public FullScreenImageAdapter(Activity activity, String resim1, String resim2, String resim3, int resimsayisi) {
        this._activity = activity;
        this.resim1 = resim1;
        this.resim2 = resim2;
        this.resim3 = resim3;
        this.resimsayisi = resimsayisi;

    }

    @Override
    public int getCount() {


        return resimsayisi;
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

        imgDisplay = (Touch_image_view) viewLayout.findViewById(R.id.imgDisplay);
        btnClose = (Button) viewLayout.findViewById(R.id.btnClose);

        if(position == 0)
            imgDisplay.setImageBitmap(WebService.stringTObitmap(resim1));
        else if(position == 1)
            imgDisplay.setImageBitmap(WebService.stringTObitmap(resim2));
        else if(position == 2)
            imgDisplay.setImageBitmap(WebService.stringTObitmap(resim3));


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