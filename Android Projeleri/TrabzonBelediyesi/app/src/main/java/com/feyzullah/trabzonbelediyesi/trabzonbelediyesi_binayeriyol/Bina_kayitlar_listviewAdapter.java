package com.feyzullah.trabzonbelediyesi.trabzonbelediyesi_binayeriyol;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by feyzullah on 9.10.2015.
 */
public class Bina_kayitlar_listviewAdapter extends BaseAdapter {

    LayoutInflater inflater;
    Context context;
    String geocode;
    int renk;

    public void setContext(Context context)
    {
        this.context = context;

    }

    public Bina_kayitlar_listviewAdapter(Context context ) {

        this.context = context;
        geocode = Bina_verilerListe.geocode.get(1);
        renk = 0;

    }

    @Override
    public int getCount() {
        return Bina_verilerListe.geocode.size();
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

        int[] color = {R.color.Maroon, R.color.blue};
        itemView = inflater.inflate(R.layout.bina_kayitlar_listviewrow, parent, false);


        if(position != 0)
        if(geocode.equals(Bina_verilerListe.geocode.get(position)))
            ((RelativeLayout)itemView.findViewById(R.id.kayitgor_layout)).setBackgroundColor(itemView.getResources().getColor(color[renk]));
        else {
            renk = 1 -renk;
            ((RelativeLayout) itemView.findViewById(R.id.kayitgor_layout)).setBackgroundColor(itemView.getResources().getColor(color[renk]));
        }
        ((TextView) itemView.findViewById(R.id.Bina_kayitgor_id)).setText(Bina_verilerListe.id.get(position));
        ((TextView) itemView.findViewById(R.id.Bina_kayitgor_geocode)).setText(Bina_verilerListe.geocode.get(position));
        ((TextView) itemView.findViewById(R.id.Bina_kayitgor_mahalleadi)).setText(Bina_verilerListe.mahalleadi.get(position));
        ((TextView) itemView.findViewById(R.id.Bina_kayitgor_caddesokakadi)).setText(Bina_verilerListe.caddesokakadi.get(position));
        ((TextView) itemView.findViewById(R.id.Bina_kayitgor_caddesokakkodu)).setText(Bina_verilerListe.caddesokakkodu.get(position));
        ((TextView) itemView.findViewById(R.id.Bina_kayitgor_kapino)).setText(Bina_verilerListe.kapino.get(position));
        ((TextView) itemView.findViewById(R.id.Bina_kayitgor_siteadi)).setText(Bina_verilerListe.siteadi.get(position));
        ((TextView) itemView.findViewById(R.id.Bina_kayitgor_apartmanadi)).setText(Bina_verilerListe.apartmanadi.get(position));
        ((TextView) itemView.findViewById(R.id.Bina_kayitgor_halihazirdurum)).setText(Bina_verilerListe.halihazirdurum.get(position));
        ((TextView) itemView.findViewById(R.id.Bina_kayitgor_discephedurumu)).setText(Bina_verilerListe.discephe_durumu.get(position));
        ((TextView) itemView.findViewById(R.id.Bina_kayitgor_yapidurumu)).setText(Bina_verilerListe.yapidurumu.get(position));
        ((TextView) itemView.findViewById(R.id.Bina_kayitgor_catidurumu)).setText(Bina_verilerListe.catidurumu.get(position));
        ((TextView) itemView.findViewById(R.id.Bina_kayitgor_yapisistemi)).setText(Bina_verilerListe.yapisistemi.get(position));
        ((TextView) itemView.findViewById(R.id.Bina_kayitgor_kullanilanmalzeme)).setText(Bina_verilerListe.kullanilanmalzeme.get(position));
        ((TextView) itemView.findViewById(R.id.Bina_kayitgor_ortakkullanim)).setText(Bina_verilerListe.ortakkullanim.get(position));
        ((TextView) itemView.findViewById(R.id.Bina_kayitgor_digerbilgiler)).setText(Bina_verilerListe.digerbilgiler.get(position));
        ((TextView) itemView.findViewById(R.id.Bina_kayitgor_binasorumlusu)).setText(Bina_verilerListe.binasorumlusu.get(position));
        ((TextView) itemView.findViewById(R.id.Bina_kayitgor_sorumlutel)).setText(Bina_verilerListe.sorumlu_tel.get(position));
        ((TextView) itemView.findViewById(R.id.Bina_kayitgor_kullanimamaci)).setText(Bina_verilerListe.kullanimamaci.get(position));
        ((TextView) itemView.findViewById(R.id.Bina_kayitgor_gelismislik)).setText(Bina_verilerListe.gelismislik.get(position));
        ((TextView) itemView.findViewById(R.id.Bina_kayitgor_ickapino)).setText(Bina_verilerListe.ickapino.get(position));
        ((TextView) itemView.findViewById(R.id.Bina_kayitgor_nitelik)).setText(Bina_verilerListe.nitelik.get(position));
        ((TextView) itemView.findViewById(R.id.Bina_kayitgor_nitelikkodu)).setText(Bina_verilerListe.nitelikkodu.get(position));
        ((TextView) itemView.findViewById(R.id.Bina_kayitgor_baskamahalleadi)).setText(Bina_verilerListe.baskamahalleadi.get(position));
        ((TextView) itemView.findViewById(R.id.Bina_kayitgor_baskakapino)).setText(Bina_verilerListe.baskakapino.get(position));
        ((TextView) itemView.findViewById(R.id.Bina_kayitgor_baskadusunceler)).setText(Bina_verilerListe.baskadusunceler.get(position));
        ((TextView) itemView.findViewById(R.id.Bina_kayitgor_notlar)).setText(Bina_verilerListe.notlar.get(position));

        if(position == 0) {
            ((TextView) itemView.findViewById(R.id.Bina_kayitgor_id))
                    .setTypeface(((TextView) itemView.findViewById(R.id.Bina_kayitgor_id)).getTypeface(), Typeface.BOLD);
            ((TextView) itemView.findViewById(R.id.Bina_kayitgor_geocode))
                    .setTypeface(((TextView) itemView.findViewById(R.id.Bina_kayitgor_geocode)).getTypeface(), Typeface.BOLD);
            ((TextView) itemView.findViewById(R.id.Bina_kayitgor_mahalleadi))
                    .setTypeface(((TextView) itemView.findViewById(R.id.Bina_kayitgor_mahalleadi)).getTypeface(), Typeface.BOLD);
            ((TextView) itemView.findViewById(R.id.Bina_kayitgor_caddesokakadi))
                    .setTypeface(((TextView) itemView.findViewById(R.id.Bina_kayitgor_caddesokakadi)).getTypeface(), Typeface.BOLD);
            ((TextView) itemView.findViewById(R.id.Bina_kayitgor_caddesokakkodu))
                    .setTypeface(((TextView) itemView.findViewById(R.id.Bina_kayitgor_caddesokakkodu)).getTypeface(), Typeface.BOLD);
            ((TextView) itemView.findViewById(R.id.Bina_kayitgor_kapino))
                    .setTypeface(((TextView) itemView.findViewById(R.id.Bina_kayitgor_kapino)).getTypeface(), Typeface.BOLD);
            ((TextView) itemView.findViewById(R.id.Bina_kayitgor_siteadi))
                    .setTypeface(((TextView) itemView.findViewById(R.id.Bina_kayitgor_siteadi)).getTypeface(), Typeface.BOLD);
            ((TextView) itemView.findViewById(R.id.Bina_kayitgor_apartmanadi))
                    .setTypeface(((TextView) itemView.findViewById(R.id.Bina_kayitgor_apartmanadi)).getTypeface(), Typeface.BOLD);
            ((TextView) itemView.findViewById(R.id.Bina_kayitgor_halihazirdurum))
                    .setTypeface(((TextView) itemView.findViewById(R.id.Bina_kayitgor_halihazirdurum)).getTypeface(), Typeface.BOLD);
            ((TextView) itemView.findViewById(R.id.Bina_kayitgor_discephedurumu))
                    .setTypeface(((TextView) itemView.findViewById(R.id.Bina_kayitgor_discephedurumu)).getTypeface(), Typeface.BOLD);
            ((TextView) itemView.findViewById(R.id.Bina_kayitgor_yapidurumu))
                    .setTypeface(((TextView) itemView.findViewById(R.id.Bina_kayitgor_yapidurumu)).getTypeface(), Typeface.BOLD);
            ((TextView) itemView.findViewById(R.id.Bina_kayitgor_catidurumu))
                    .setTypeface(((TextView) itemView.findViewById(R.id.Bina_kayitgor_catidurumu)).getTypeface(), Typeface.BOLD);
            ((TextView) itemView.findViewById(R.id.Bina_kayitgor_yapisistemi))
                    .setTypeface(((TextView) itemView.findViewById(R.id.Bina_kayitgor_yapisistemi)).getTypeface(), Typeface.BOLD);
            ((TextView) itemView.findViewById(R.id.Bina_kayitgor_kullanilanmalzeme))
                    .setTypeface(((TextView) itemView.findViewById(R.id.Bina_kayitgor_kullanilanmalzeme)).getTypeface(), Typeface.BOLD);
            ((TextView) itemView.findViewById(R.id.Bina_kayitgor_ortakkullanim))
                    .setTypeface(((TextView) itemView.findViewById(R.id.Bina_kayitgor_ortakkullanim)).getTypeface(), Typeface.BOLD);
            ((TextView) itemView.findViewById(R.id.Bina_kayitgor_digerbilgiler))
                    .setTypeface(((TextView) itemView.findViewById(R.id.Bina_kayitgor_digerbilgiler)).getTypeface(), Typeface.BOLD);
            ((TextView) itemView.findViewById(R.id.Bina_kayitgor_binasorumlusu))
                    .setTypeface(((TextView) itemView.findViewById(R.id.Bina_kayitgor_binasorumlusu)).getTypeface(), Typeface.BOLD);
            ((TextView) itemView.findViewById(R.id.Bina_kayitgor_sorumlutel))
                    .setTypeface(((TextView) itemView.findViewById(R.id.Bina_kayitgor_sorumlutel)).getTypeface(), Typeface.BOLD);
            ((TextView) itemView.findViewById(R.id.Bina_kayitgor_kullanimamaci))
                    .setTypeface(((TextView) itemView.findViewById(R.id.Bina_kayitgor_kullanimamaci)).getTypeface(), Typeface.BOLD);
            ((TextView) itemView.findViewById(R.id.Bina_kayitgor_gelismislik))
                    .setTypeface(((TextView) itemView.findViewById(R.id.Bina_kayitgor_gelismislik)).getTypeface(), Typeface.BOLD);
            ((TextView) itemView.findViewById(R.id.Bina_kayitgor_ickapino))
                    .setTypeface(((TextView) itemView.findViewById(R.id.Bina_kayitgor_ickapino)).getTypeface(), Typeface.BOLD);
            ((TextView) itemView.findViewById(R.id.Bina_kayitgor_nitelik))
                    .setTypeface(((TextView) itemView.findViewById(R.id.Bina_kayitgor_nitelik)).getTypeface(), Typeface.BOLD);
            ((TextView) itemView.findViewById(R.id.Bina_kayitgor_nitelikkodu))
                    .setTypeface(((TextView) itemView.findViewById(R.id.Bina_kayitgor_nitelikkodu)).getTypeface(), Typeface.BOLD);
            ((TextView) itemView.findViewById(R.id.Bina_kayitgor_baskamahalleadi))
                    .setTypeface(((TextView) itemView.findViewById(R.id.Bina_kayitgor_baskamahalleadi)).getTypeface(), Typeface.BOLD);
            ((TextView) itemView.findViewById(R.id.Bina_kayitgor_baskakapino))
                    .setTypeface(((TextView) itemView.findViewById(R.id.Bina_kayitgor_baskakapino)).getTypeface(), Typeface.BOLD);
            ((TextView) itemView.findViewById(R.id.Bina_kayitgor_baskadusunceler))
                    .setTypeface(((TextView) itemView.findViewById(R.id.Bina_kayitgor_baskadusunceler)).getTypeface(), Typeface.BOLD);
            ((TextView) itemView.findViewById(R.id.Bina_kayitgor_notlar))
                    .setTypeface(((TextView) itemView.findViewById(R.id.Bina_kayitgor_notlar)).getTypeface(), Typeface.BOLD);

            ((TextView) itemView.findViewById(R.id.Bina_kayitgor_id))
                    .setTextColor(itemView.getResources().getColor(R.color.black));
            ((TextView) itemView.findViewById(R.id.Bina_kayitgor_geocode))
                    .setTextColor(itemView.getResources().getColor(R.color.black));
            ((TextView) itemView.findViewById(R.id.Bina_kayitgor_mahalleadi))
                    .setTextColor(itemView.getResources().getColor(R.color.black));
            ((TextView) itemView.findViewById(R.id.Bina_kayitgor_caddesokakadi))
                    .setTextColor(itemView.getResources().getColor(R.color.black));
            ((TextView) itemView.findViewById(R.id.Bina_kayitgor_caddesokakkodu))
                    .setTextColor(itemView.getResources().getColor(R.color.black));
            ((TextView) itemView.findViewById(R.id.Bina_kayitgor_kapino))
                    .setTextColor(itemView.getResources().getColor(R.color.black));
            ((TextView) itemView.findViewById(R.id.Bina_kayitgor_siteadi))
                    .setTextColor(itemView.getResources().getColor(R.color.black));
            ((TextView) itemView.findViewById(R.id.Bina_kayitgor_apartmanadi))
                    .setTextColor(itemView.getResources().getColor(R.color.black));
            ((TextView) itemView.findViewById(R.id.Bina_kayitgor_halihazirdurum))
                    .setTextColor(itemView.getResources().getColor(R.color.black));
            ((TextView) itemView.findViewById(R.id.Bina_kayitgor_discephedurumu))
                    .setTextColor(itemView.getResources().getColor(R.color.black));
            ((TextView) itemView.findViewById(R.id.Bina_kayitgor_yapidurumu))
                    .setTextColor(itemView.getResources().getColor(R.color.black));
            ((TextView) itemView.findViewById(R.id.Bina_kayitgor_catidurumu))
                    .setTextColor(itemView.getResources().getColor(R.color.black));
            ((TextView) itemView.findViewById(R.id.Bina_kayitgor_yapisistemi))
                    .setTextColor(itemView.getResources().getColor(R.color.black));
            ((TextView) itemView.findViewById(R.id.Bina_kayitgor_kullanilanmalzeme))
                    .setTextColor(itemView.getResources().getColor(R.color.black));
            ((TextView) itemView.findViewById(R.id.Bina_kayitgor_ortakkullanim))
                    .setTextColor(itemView.getResources().getColor(R.color.black));
            ((TextView) itemView.findViewById(R.id.Bina_kayitgor_digerbilgiler))
                    .setTextColor(itemView.getResources().getColor(R.color.black));
            ((TextView) itemView.findViewById(R.id.Bina_kayitgor_binasorumlusu))
                    .setTextColor(itemView.getResources().getColor(R.color.black));
            ((TextView) itemView.findViewById(R.id.Bina_kayitgor_sorumlutel))
                    .setTextColor(itemView.getResources().getColor(R.color.black));
            ((TextView) itemView.findViewById(R.id.Bina_kayitgor_kullanimamaci))
                    .setTextColor(itemView.getResources().getColor(R.color.black));
            ((TextView) itemView.findViewById(R.id.Bina_kayitgor_gelismislik))
                    .setTextColor(itemView.getResources().getColor(R.color.black));
            ((TextView) itemView.findViewById(R.id.Bina_kayitgor_ickapino))
                    .setTextColor(itemView.getResources().getColor(R.color.black));
            ((TextView) itemView.findViewById(R.id.Bina_kayitgor_nitelik))
                    .setTextColor(itemView.getResources().getColor(R.color.black));
            ((TextView) itemView.findViewById(R.id.Bina_kayitgor_nitelikkodu))
                    .setTextColor(itemView.getResources().getColor(R.color.black));
            ((TextView) itemView.findViewById(R.id.Bina_kayitgor_baskamahalleadi))
                    .setTextColor(itemView.getResources().getColor(R.color.black));
            ((TextView) itemView.findViewById(R.id.Bina_kayitgor_baskakapino))
                    .setTextColor(itemView.getResources().getColor(R.color.black));
            ((TextView) itemView.findViewById(R.id.Bina_kayitgor_baskadusunceler))
                    .setTextColor(itemView.getResources().getColor(R.color.black));
            ((TextView) itemView.findViewById(R.id.Bina_kayitgor_notlar))
                    .setTextColor(itemView.getResources().getColor(R.color.black));
        }

        if(position != 0)
        geocode = Bina_verilerListe.geocode.get(position);

        if(position == Bina_verilerListe.geocode.size() - 1) {renk = 0; geocode = Bina_verilerListe.geocode.get(1);}
        return itemView;
    }


    public void refreshResultList(){

        notifyDataSetChanged();

    }


}