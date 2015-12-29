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
public class Bina_10_listviewAdapter extends BaseAdapter {

    LayoutInflater inflater;
    Context context;

    public void setContext(Context context)
    {
        this.context = context;

    }

    public Bina_10_listviewAdapter(Context context ) {

        this.context = context;

    }

    @Override
    public int getCount() {
        return Bina_veriler.ickapino.size();
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
        TextView nitelik_edt;
        TextView nitelikkod_edt;

        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView;

        itemView = inflater.inflate(R.layout.bina_10_listviewrow, parent, false);//list_item_row dan yeni bir view oluþturuyoruz
        kapino_edt = (TextView) itemView.findViewById(R.id.Bina_10listview_kapino);
        nitelik_edt = (TextView) itemView.findViewById(R.id.Bina_10listview_nitelik);
        nitelikkod_edt = (TextView) itemView.findViewById(R.id.Bina_10listview_nitelikkodu);





        // oluþan itemviewin içindeki alanlarý Anasayfadan gelen deðerler ile set ediyoruz

        kapino_edt.setText(Bina_veriler.ickapino.get(position));
        nitelik_edt.setText(Bina_veriler.nitelik.get(position));
        nitelikkod_edt.setText(Bina_veriler.nitelikkodu.get(position));


        return itemView;
    }

    public void refreshResultList(){

        notifyDataSetChanged();

    }

}
