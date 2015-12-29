package com.feyzullah.trabzonbelediyesi.trabzonbelediyesi_binayeriyol;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;


public class Bina_13_gridviewAdapter extends BaseAdapter {
    LayoutInflater inflater;
    Context context;


    public Bina_13_gridviewAdapter(Context context) {

        this.context = context;


    }

    @Override
    public int getCount() {
        return Bina_veriler.Resimler.size();
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








        Bitmap bmImg = BitmapFactory.decodeFile(Bina_veriler.Resimler.get(position));
        imgview.setImageBitmap(bmImg);




        return itemView;
    }

    public void refreshResultList(){

        notifyDataSetChanged();

    }
}
