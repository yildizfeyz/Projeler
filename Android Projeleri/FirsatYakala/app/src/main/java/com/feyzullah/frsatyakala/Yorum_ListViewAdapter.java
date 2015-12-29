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

public class Yorum_ListViewAdapter extends BaseAdapter {

    // Declare Variables
    Context context;
    String baslik;
    String aciklama;
    String begenyorum;
    String[] yorumlar;
    String py_gonderen;
    String py_zaman;
    int resimsayisi;
    String resim;


    LayoutInflater inflater;


    public Yorum_ListViewAdapter(Context context, String py_gonderen, String py_zaman, String baslik, String aciklama, String begenyorum
                                 ,int resimsayisi, String[] yorumlar) {
        this.context = context;
        this.baslik = baslik;
        this.aciklama = aciklama;
        this.begenyorum = begenyorum;
        this.yorumlar = yorumlar;
        this.py_gonderen = py_gonderen;
        this.py_zaman = py_zaman;
        this.resimsayisi = resimsayisi;
        this.resim = resim;
    }



    @Override
    public int getCount() {
        return (yorumlar.length / 4) + 1;
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

        itemView = inflater.inflate(R.layout.yorum_listview, parent, false);

        if(position == 0) {

            itemView = inflater.inflate(R.layout.main_listview, parent, false);//list_item_row dan yeni bir view oluþturuyoruz


            TextView gonderen = (TextView) itemView.findViewById(R.id.listview_gonderen);
            TextView baslik = (TextView) itemView.findViewById(R.id.listview_textview1);
            TextView aciklama = (TextView) itemView.findViewById(R.id.listview_aciklama);
            TextView zaman = (TextView) itemView.findViewById(R.id.listview_zaman);
            TextView begenyorum = (TextView) itemView.findViewById(R.id.listview_begeniyorum);



            com.beardedhen.androidbootstrap.BootstrapButton btn_git = (com.beardedhen.androidbootstrap.BootstrapButton) itemView.findViewById(R.id.listview_btn_git);
            com.beardedhen.androidbootstrap.BootstrapButton btn_begen = (com.beardedhen.androidbootstrap.BootstrapButton) itemView.findViewById(R.id.listview_btn_begen);
            com.beardedhen.androidbootstrap.BootstrapButton btn_yorum = (com.beardedhen.androidbootstrap.BootstrapButton) itemView.findViewById(R.id.listview_btn_yorum);

            btn_git.setEnabled(false);
            btn_begen.setVisibility(View.GONE);
            btn_yorum.setVisibility(View.GONE);

            zaman.setText(this.py_zaman);
            gonderen.setText(this.py_gonderen);
            baslik.setText(Html.fromHtml(this.baslik));
            aciklama.setText(this.aciklama);
            begenyorum.setText(this.begenyorum);


        }
        else {
            TextView zaman_txt = (TextView) itemView.findViewById(R.id.yorum_listview_zaman);
            TextView gonderen_txt = (TextView) itemView.findViewById(R.id.yorum_listview_gonderen);
            TextView yorum_txt = (TextView) itemView.findViewById(R.id.yorum_listview_yorumu);

            zaman_txt.setText(yorumlar[(4*(position - 1)) + 1]);
            gonderen_txt.setText(yorumlar[(4*(position - 1)) + 2]);
            yorum_txt.setText(yorumlar[(4*(position - 1)) + 3]);
        }
        return itemView;
    }
}