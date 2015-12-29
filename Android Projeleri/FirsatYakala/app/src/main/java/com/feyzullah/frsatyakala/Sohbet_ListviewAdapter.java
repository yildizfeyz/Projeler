package com.feyzullah.frsatyakala;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Sohbet_ListviewAdapter extends BaseAdapter {

    // Declare Variables
    Context context;

    public static String[] mesajlar;
    LayoutInflater inflater;


    public Sohbet_ListviewAdapter(Context context) {
        this.context = context;
    }



    @Override
    public int getCount() {
        return mesajlar.length;
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

        // Declare Variables




        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView;

        itemView = inflater.inflate(R.layout.sohbet_listviewlayout, parent, false);

        TextView txt = (TextView) itemView.findViewById(R.id.sohbet_textview);

        String[] mesaj = mesajlar[position].split(";");

        txt.setText(Html.fromHtml("<b>"+ mesaj[0] + ":</b>" + mesaj[1] ));

        return itemView;
    }

    public void refreshResultList(){

        notifyDataSetChanged();

    }
}