package com.feyzullah.trabzonbelediyesi.trabzonbelediyesi_binayeriyol;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Toast;


public class Bina_7 extends Fragment implements OnClickListener {
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_bina_7, container, false);
        ((com.rey.material.widget.CheckBox)view.findViewById(R.id.ortakkullanim1)).setOnClickListener(this);
        ((com.rey.material.widget.CheckBox)view.findViewById(R.id.ortakkullanim2)).setOnClickListener(this);
        ((com.rey.material.widget.CheckBox)view.findViewById(R.id.ortakkullanim3)).setOnClickListener(this);
        ((com.rey.material.widget.CheckBox)view.findViewById(R.id.ortakkullanim4)).setOnClickListener(this);
        ((com.rey.material.widget.CheckBox)view.findViewById(R.id.ortakkullanim5)).setOnClickListener(this);

        ((com.rey.material.widget.CheckBox)view.findViewById(R.id.digerbilgiler1)).setOnClickListener(this);
        ((com.rey.material.widget.CheckBox)view.findViewById(R.id.digerbilgiler2)).setOnClickListener(this);

        if(Bina_veriler.islem == 1)
        {

            char[] karakter = Bina_veriler.ortakkullanim.toCharArray();
            for(int i = 0; i < karakter.length; i++)
            {
                switch (karakter[i])
                {
                    case '1' : ((com.rey.material.widget.CheckBox)view.findViewById(R.id.ortakkullanim1)).setChecked(true); break;
                    case '2' : ((com.rey.material.widget.CheckBox)view.findViewById(R.id.ortakkullanim2)).setChecked(true); break;
                    case '3' : ((com.rey.material.widget.CheckBox)view.findViewById(R.id.ortakkullanim3)).setChecked(true); break;
                    case '4' : ((com.rey.material.widget.CheckBox)view.findViewById(R.id.ortakkullanim4)).setChecked(true); break;
                    case '5' : ((com.rey.material.widget.CheckBox)view.findViewById(R.id.ortakkullanim5)).setChecked(true); break;
                    default  : break;
                }
            }
            karakter = Bina_veriler.digerbilgiler.toCharArray();
            for(int i = 0; i < karakter.length; i++)
            {
                switch (karakter[i])
                {
                    case '1' : ((com.rey.material.widget.CheckBox)view.findViewById(R.id.digerbilgiler1)).setChecked(true); break;
                    case '2' : ((com.rey.material.widget.CheckBox)view.findViewById(R.id.digerbilgiler2)).setChecked(true); break;
                    default  : break;
                }
            }

        }
        return view;
    }

    @Override
    public void onClick(View v)
    {
        com.rey.material.widget.CheckBox ortakkullanim1 = (com.rey.material.widget.CheckBox)view.findViewById(R.id.ortakkullanim1);
        com.rey.material.widget.CheckBox ortakkullanim2 = (com.rey.material.widget.CheckBox)view.findViewById(R.id.ortakkullanim2);
        com.rey.material.widget.CheckBox ortakkullanim3 = (com.rey.material.widget.CheckBox)view.findViewById(R.id.ortakkullanim3);
        com.rey.material.widget.CheckBox ortakkullanim4 = (com.rey.material.widget.CheckBox)view.findViewById(R.id.ortakkullanim4);
        com.rey.material.widget.CheckBox ortakkullanim5 = (com.rey.material.widget.CheckBox)view.findViewById(R.id.ortakkullanim5);


        Bina_veriler.ortakkullanim = "";
        if(ortakkullanim1.isChecked()) Bina_veriler.ortakkullanim = Bina_veriler.ortakkullanim + "1";
        if(ortakkullanim2.isChecked()) Bina_veriler.ortakkullanim = Bina_veriler.ortakkullanim + "2";
        if(ortakkullanim3.isChecked()) Bina_veriler.ortakkullanim = Bina_veriler.ortakkullanim + "3";
        if(ortakkullanim4.isChecked()) Bina_veriler.ortakkullanim = Bina_veriler.ortakkullanim + "4";
        if(ortakkullanim5.isChecked()) Bina_veriler.ortakkullanim = Bina_veriler.ortakkullanim + "5";


        com.rey.material.widget.CheckBox digerbilgiler1 = (com.rey.material.widget.CheckBox)view.findViewById(R.id.digerbilgiler1);
        com.rey.material.widget.CheckBox digerbilgiler2 = (com.rey.material.widget.CheckBox)view.findViewById(R.id.digerbilgiler2);


        Bina_veriler.digerbilgiler = "";
        if(digerbilgiler1.isChecked()) Bina_veriler.digerbilgiler = Bina_veriler.digerbilgiler + "1";
        if(digerbilgiler2.isChecked()) Bina_veriler.digerbilgiler = Bina_veriler.digerbilgiler + "2";


    }

}
