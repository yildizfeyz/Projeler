package com.feyzullah.trabzonbelediyesi.trabzonbelediyesi_binayeriyol;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by feyzullah on 6.10.2015.
 */
public class Bina_11_listviewAdapter extends BaseAdapter {

    LayoutInflater inflater;
    Context context;

    public Bina_11_listviewAdapter(Context context ) {

        this.context = context;

    }

    @Override
    public int getCount() {
        return Bina_veriler.baskakapino.size();
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
        TextView kapino_edt;
        TextView meydan_edt;
        TextView dusunceler_edt;

        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView;

        itemView = inflater.inflate(R.layout.bina_11_listviewrow, parent, false);//list_item_row dan yeni bir view oluþturuyoruz
        meydan_edt = (TextView) itemView.findViewById(R.id.Bina_11listview_meydan);
        kapino_edt = (TextView) itemView.findViewById(R.id.Bina_11listview_kapino);
        dusunceler_edt = (TextView) itemView.findViewById(R.id.Bina_11listview_dusunceler);

        kapino_edt.setText(Bina_veriler.baskakapino.get(position));
        meydan_edt.setText(Bina_veriler.baskamahalleadi.get(position));
        dusunceler_edt.setText(Bina_veriler.baskadusunceler.get(position));


        return itemView;
    }


    public void refreshResultList(){

        notifyDataSetChanged();

    }
}