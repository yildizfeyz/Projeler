package com.feyzullah.trabzonbelediyesi.trabzonbelediyesi_binayeriyol;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class Bina_9 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bina_9, container, false);
        RadioGroup kullanimamaci_group = (RadioGroup)view.findViewById(R.id.bina9_radiogroup1);
        kullanimamaci_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId)
                {
                    case R.id.kullanimamaci1: { Bina_veriler.kullanimamaci = "1"; break; }
                    case R.id.kullanimamaci2: { Bina_veriler.kullanimamaci = "2"; break;}
                    case R.id.kullanimamaci3: { Bina_veriler.kullanimamaci = "3"; break;}
                    case R.id.kullanimamaci4: { Bina_veriler.kullanimamaci = "4"; break;}
                    case R.id.kullanimamaci5: { Bina_veriler.kullanimamaci = "5"; break;}
                } } } );

        RadioGroup gelismislik_group = (RadioGroup)view.findViewById(R.id.bina9_radiogroup2);
        gelismislik_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId)
                {
                    case R.id.gelismislik1: { Bina_veriler.gelismislik = "1"; break; }
                    case R.id.gelismislik2: { Bina_veriler.gelismislik = "2"; break;}
                    case R.id.gelismislik3: { Bina_veriler.gelismislik = "3"; break;}
                    case R.id.gelismislik4: { Bina_veriler.gelismislik = "4"; break;}
                } } } );

        if(Bina_veriler.islem == 1)
        {
            switch (Bina_veriler.kullanimamaci)
            {
                case "1" : ((RadioButton)view.findViewById(R.id.kullanimamaci1)).setChecked(true); break;
                case "2" : ((RadioButton)view.findViewById(R.id.kullanimamaci2)).setChecked(true); break;
                case "3" : ((RadioButton)view.findViewById(R.id.kullanimamaci3)).setChecked(true); break;
                case "4" : ((RadioButton)view.findViewById(R.id.kullanimamaci4)).setChecked(true); break;
                case "5" : ((RadioButton)view.findViewById(R.id.kullanimamaci5)).setChecked(true); break;
                default  : break;
            }
            switch (Bina_veriler.gelismislik)
            {
                case "1" : ((RadioButton)view.findViewById(R.id.gelismislik1)).setChecked(true); break;
                case "2" : ((RadioButton)view.findViewById(R.id.gelismislik2)).setChecked(true); break;
                case "3" : ((RadioButton)view.findViewById(R.id.gelismislik3)).setChecked(true); break;
                case "4" : ((RadioButton)view.findViewById(R.id.gelismislik4)).setChecked(true); break;
                default  : break;
            }
        }
        return view;
    }


}
