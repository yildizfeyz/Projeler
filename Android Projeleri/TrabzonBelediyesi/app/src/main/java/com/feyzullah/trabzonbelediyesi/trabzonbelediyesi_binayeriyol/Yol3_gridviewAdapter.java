package com.feyzullah.trabzonbelediyesi.trabzonbelediyesi_binayeriyol;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * Created by feyzullah on 8.11.2015.
 */
public class Yol3_gridviewAdapter extends BaseAdapter {
    LayoutInflater inflater;
    Context context;


    public Yol3_gridviewAdapter(Context context) {

        this.context = context;


    }

    @Override
    public int getCount() {
        return Yol_veriler.Resimler.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {


        ImageView imgview;


        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView;

        itemView = inflater.inflate(R.layout.bina_13_gridviewcell, parent, false);
        imgview = (ImageView) itemView.findViewById(R.id.bina13_gridview_imageView);








        Bitmap bmImg = BitmapFactory.decodeFile(Yol_veriler.Resimler.get(position));
        imgview.setImageBitmap(bmImg);




        return itemView;
    }

    public void refreshResultList(){

        notifyDataSetChanged();

    }
}
