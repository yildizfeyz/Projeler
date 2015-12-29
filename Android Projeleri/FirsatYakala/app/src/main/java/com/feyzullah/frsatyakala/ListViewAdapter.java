package com.feyzullah.frsatyakala;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.kobjects.util.Strings;

public class ListViewAdapter extends BaseAdapter {

    // Declare Variables
    Context context;
    String[] paylasimlar;
    String enlem;
    String boylam;
    LayoutInflater inflater;
    Bitmap[] bitmap;

    //ListviewAdapter constructor
    //Gelen deðerleri set ediyor
    public ListViewAdapter(Context context, String[] paylasimlar, String enlem, String boylam, Bitmap[] bitmap) {
        this.context = context;
        this.paylasimlar = paylasimlar;
        this.enlem = enlem;
        this.boylam = boylam;
        this.bitmap = bitmap;

    }

    @Override
    public int getCount() {
        return paylasimlar.length / 11;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public View getView(final int position, final View convertView, ViewGroup parent) {

        // Declare Variables
        final TextView gonderen;
        TextView baslik;
        TextView aciklama;

        TextView zaman;

        final ImageView imageView;
        final ImageView profil_image;

        final com.beardedhen.androidbootstrap.BootstrapButton btn_git;
        final com.beardedhen.androidbootstrap.BootstrapButton btn_begen;
        final com.beardedhen.androidbootstrap.BootstrapButton btn_yorum;

        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView;

        itemView = inflater.inflate(R.layout.main_listview, parent, false);//list_item_row dan yeni bir view oluþturuyoruz

        gonderen = (TextView) itemView.findViewById(R.id.listview_gonderen);
        baslik = (TextView) itemView.findViewById(R.id.listview_textview1);
        aciklama = (TextView) itemView.findViewById(R.id.listview_aciklama);
        final TextView begenyorum = (TextView) itemView.findViewById(R.id.listview_begeniyorum);
        zaman = (TextView) itemView.findViewById(R.id.listview_zaman);
        imageView = (ImageView) itemView.findViewById(R.id.listview_imageview);
        btn_git = (com.beardedhen.androidbootstrap.BootstrapButton) itemView.findViewById(R.id.listview_btn_git);
        btn_begen = (com.beardedhen.androidbootstrap.BootstrapButton) itemView.findViewById(R.id.listview_btn_begen);
        btn_yorum = (com.beardedhen.androidbootstrap.BootstrapButton) itemView.findViewById(R.id.listview_btn_yorum);


        profil_image = (ImageView) itemView.findViewById(R.id.listview_profil);

        gonderen.setText(paylasimlar[11*position + 1]);
        zaman.setText(paylasimlar[11*position + 2]);

        final String _baslik = "<b>" + paylasimlar[11*position + 3] +"</b>'de <b>" + paylasimlar[11*position + 4] + "</b> var";
        baslik.setText(Html.fromHtml( _baslik));
        aciklama.setText(paylasimlar[11*position + 5]);
        begenyorum.setText(paylasimlar[11*position + 8] + " beğeni, " + paylasimlar[11*position + 9] + " yorum" );

        Veritabani vt = new Veritabani(context);
        if(vt.isLike(vt, paylasimlar[11 * position]))
        { btn_begen.setEnabled(false); btn_begen.setText("Beğendin");}

        if(Integer.parseInt(paylasimlar[11*position + 10]) > 0)
        {
            imageView.setImageResource(R.drawable.one);
            if(Integer.parseInt(paylasimlar[11*position + 10]) > 1)
            {
                imageView.setImageResource(R.drawable.two);
                if(Integer.parseInt(paylasimlar[11*position + 10]) > 2)
                {
                    imageView.setImageResource(R.drawable.three);
                }
            }
        }

        final WebService ws = new WebService();





        final TextView sil = (TextView) itemView.findViewById(R.id.listview_sil);
        if(paylasimlar[11*position + 1].equals(vt.kayitGor(vt).getString(1))) sil.setVisibility(View.VISIBLE);

        sil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(ws.paylasim_sil(paylasimlar[11*position])) {
                    Toast.makeText(context, "Gönderi veritabanından silinmiştir!", Toast.LENGTH_LONG).show();
                    btn_begen.setEnabled(false);
                    btn_git.setEnabled(false);
                    btn_yorum.setEnabled(false);
                    sil.setEnabled(false);
                    profil_image.setEnabled(false);
                    imageView.setEnabled(false);

                }
                else Toast.makeText(context, "Gönderi silinemedi!!", Toast.LENGTH_LONG).show();
            }
        });

        profil_image.setImageBitmap(bitmap[position]);
        profil_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Bundle veriler = new Bundle();
                    veriler.putString("gonderen", paylasimlar[11 * position + 1]);
                    veriler.putInt("profil", 0);
                    Intent intent = new Intent(v.getContext(), ResimGalerisi.class);
                    intent.putExtras(veriler);
                    context.startActivity(intent);
                }
                catch (Exception ex) { }
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Bundle veriler = new Bundle();
                    veriler.putString("ID", paylasimlar[11 * position]);
                    veriler.putInt("profil", -1);
                    veriler.putInt("resimsayisi", Integer.parseInt(paylasimlar[11 * position + 10]));
                    Intent intent = new Intent(v.getContext(), ResimGalerisi.class);
                    intent.putExtras(veriler);
                    context.startActivity(intent);



                }
                catch (Exception ex) { }
            }
        });

        //if(Integer.parseInt(paylasimlar[14*position + 13]) > 0 )
         //   imageView.setImageBitmap(WebService.stringTObitmap(paylasimlar[14*position + 10]));


        btn_git.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(enlem.equals("0.0") && boylam.equals("0.0"))
                {
                    Toast.makeText(context, "GPS bilgisi alınamıyor",Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?saddr=" + enlem + "," + boylam + " &daddr=" + paylasimlar[11 * position + 6].replace(",", ".") + "," + paylasimlar[11 * position + 7].replace(",", ".")));
                    intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                    context.startActivity(intent);
                }
            }
        });


        btn_begen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ws.begen(paylasimlar[11 * position]);
                begenyorum.setText(String.valueOf(Integer.parseInt(paylasimlar[11 * position + 8]) + 1) + " beğeni, " + paylasimlar[11 * position + 9] + " yorum");
                btn_begen.setEnabled(false);
                btn_begen.setText("Beğendin");
                Veritabani vt = new Veritabani(v.getContext());
                vt.addLike(vt, paylasimlar[11 * position]);
            }
        });

        LinearLayout listview_layout = (LinearLayout) itemView.findViewById(R.id.listview_layout);
        listview_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle veriler = new Bundle();
                veriler.putString("ID", paylasimlar[11 * position]);
                veriler.putString("gonderen", paylasimlar[11*position + 1]);
                veriler.putString("baslik", _baslik);
                veriler.putString("resimsayisi", paylasimlar[11*position + 10]);
                veriler.putString("zaman", paylasimlar[11*position + 2]);
                veriler.putString("aciklama", paylasimlar[11*position + 5]);
                veriler.putString("begeniyorum", paylasimlar[11*position + 8] + " beğeni, " + paylasimlar[11*position + 9] + " yorum");

                Intent intent = new Intent(v.getContext(), YorumActivity.class);
                intent.putExtras(veriler);
                context.startActivity(intent);
            }
        });

        btn_yorum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle veriler = new Bundle();
                veriler.putString("ID", paylasimlar[11 * position]);
                veriler.putString("gonderen", paylasimlar[11 * position + 1]);
                veriler.putString("baslik", _baslik);
                veriler.putString("resimsayisi", paylasimlar[11 * position + 10]);
                //veriler.putString("resim", paylasimlar[14*position + 10]);
                veriler.putString("zaman", paylasimlar[11 * position + 2]);
                veriler.putString("aciklama", paylasimlar[11 * position + 5]);
                veriler.putString("begeniyorum", paylasimlar[11 * position + 8] + " beğeni, " + paylasimlar[11 * position + 9] + " yorum");

                Intent intent = new Intent(v.getContext(), YeniYorumActivity.class);
                intent.putExtras(veriler);
                context.startActivity(intent);
            }
        });

        return itemView;
    }
}