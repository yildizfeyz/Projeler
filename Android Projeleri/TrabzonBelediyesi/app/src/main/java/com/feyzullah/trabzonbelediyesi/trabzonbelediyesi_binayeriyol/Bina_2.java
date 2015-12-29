package com.feyzullah.trabzonbelediyesi.trabzonbelediyesi_binayeriyol;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View.OnClickListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class Bina_2 extends Fragment implements OnClickListener {

    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_bina_2, container, false);

        ((com.rey.material.widget.CheckBox)view.findViewById(R.id.caddesokakkodu1)).setOnClickListener(this);
        ((com.rey.material.widget.CheckBox)view.findViewById(R.id.caddesokakkodu2)).setOnClickListener(this);
        ((com.rey.material.widget.CheckBox)view.findViewById(R.id.caddesokakkodu3)).setOnClickListener(this);
        ((com.rey.material.widget.CheckBox)view.findViewById(R.id.caddesokakkodu4)).setOnClickListener(this);
        ((com.rey.material.widget.CheckBox)view.findViewById(R.id.caddesokakkodu5)).setOnClickListener(this);
        ((com.rey.material.widget.CheckBox)view.findViewById(R.id.caddesokakkodu6)).setOnClickListener(this);

        final EditText caddesokakadi_edt = ((EditText) view.findViewById(R.id.caddesokakadi));
        caddesokakadi_edt.addTextChangedListener(new TextWatcher() {
            @Override public void afterTextChanged(Editable s) { }
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {
                try { Bina_veriler.caddesokakadi = caddesokakadi_edt.getText().toString(); } catch (Exception ex) {} }
        });


        if(Bina_veriler.islem == 1)
        {
            caddesokakadi_edt.setText(Bina_veriler.caddesokakadi);
            char[] caddekodu = Bina_veriler.caddesokakkodu.toCharArray();
            for(int i = 0; i < caddekodu.length; i++)
            {
                switch (caddekodu[i])
                {
                    case '1' : ((com.rey.material.widget.CheckBox)view.findViewById(R.id.caddesokakkodu1)).setChecked(true); break;
                    case '2' : ((com.rey.material.widget.CheckBox)view.findViewById(R.id.caddesokakkodu2)).setChecked(true); break;
                    case '3' : ((com.rey.material.widget.CheckBox)view.findViewById(R.id.caddesokakkodu3)).setChecked(true); break;
                    case '4' : ((com.rey.material.widget.CheckBox)view.findViewById(R.id.caddesokakkodu4)).setChecked(true); break;
                    case '5' : ((com.rey.material.widget.CheckBox)view.findViewById(R.id.caddesokakkodu5)).setChecked(true); break;
                    case '6' : ((com.rey.material.widget.CheckBox)view.findViewById(R.id.caddesokakkodu6)).setChecked(true); break;
                    default  : break;
                }
            }

        }



        return view;

    }

    @Override
    public void onClick(View v)
    {
        com.rey.material.widget.CheckBox caddesokakkodu1 = (com.rey.material.widget.CheckBox)view.findViewById(R.id.caddesokakkodu1);
        com.rey.material.widget.CheckBox caddesokakkodu2 = (com.rey.material.widget.CheckBox)view.findViewById(R.id.caddesokakkodu2);
        com.rey.material.widget.CheckBox caddesokakkodu3 = (com.rey.material.widget.CheckBox)view.findViewById(R.id.caddesokakkodu3);
        com.rey.material.widget.CheckBox caddesokakkodu4 = (com.rey.material.widget.CheckBox)view.findViewById(R.id.caddesokakkodu4);
        com.rey.material.widget.CheckBox caddesokakkodu5 = (com.rey.material.widget.CheckBox)view.findViewById(R.id.caddesokakkodu5);
        com.rey.material.widget.CheckBox caddesokakkodu6 = (com.rey.material.widget.CheckBox)view.findViewById(R.id.caddesokakkodu6);

        Bina_veriler.caddesokakkodu = "";
        if(caddesokakkodu1.isChecked()) Bina_veriler.caddesokakkodu = Bina_veriler.caddesokakkodu + "1";
        if(caddesokakkodu2.isChecked()) Bina_veriler.caddesokakkodu = Bina_veriler.caddesokakkodu + "2";
        if(caddesokakkodu3.isChecked()) Bina_veriler.caddesokakkodu = Bina_veriler.caddesokakkodu + "3";
        if(caddesokakkodu4.isChecked()) Bina_veriler.caddesokakkodu = Bina_veriler.caddesokakkodu + "4";
        if(caddesokakkodu5.isChecked()) Bina_veriler.caddesokakkodu = Bina_veriler.caddesokakkodu + "5";
        if(caddesokakkodu6.isChecked()) Bina_veriler.caddesokakkodu = Bina_veriler.caddesokakkodu + "6";


    }
}
