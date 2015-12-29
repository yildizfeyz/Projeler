package com.feyzullah.trabzonbelediyesi.trabzonbelediyesi_binayeriyol;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class Bina_4 extends Fragment {

    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_bina_4, container, false);
        RadioGroup halihazirdurum_group = (RadioGroup)view.findViewById(R.id.radiogroup1);
        halihazirdurum_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId)
                {
                    case R.id.halihazirdurum1: { Bina_veriler.halihazirdurum = "1"; break;}
                    case R.id.halihazirdurum2: { Bina_veriler.halihazirdurum = "2"; break;}
                    case R.id.halihazirdurum3: { Bina_veriler.halihazirdurum = "3"; break;}
        } } } );
        RadioGroup discephedurum_group = (RadioGroup)view.findViewById(R.id.discephedurum_radiogroup);
        discephedurum_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId)
                {
                    case R.id.discephe_durumu1: { Bina_veriler.discephe_durumu = "1"; break;}
                    case R.id.discephe_durumu2: { Bina_veriler.discephe_durumu = "2"; break;}
                    case R.id.discephe_durumu3: { Bina_veriler.discephe_durumu = "3"; break;}
                    case R.id.discephe_durumu4: { Bina_veriler.discephe_durumu = "4"; break;}
                } } } );

        if(Bina_veriler.islem == 1)
        {
                switch (Bina_veriler.halihazirdurum)
                {
                     case "1" : ((RadioButton)view.findViewById(R.id.halihazirdurum1)).setChecked(true); break;
                     case "2" : ((RadioButton)view.findViewById(R.id.halihazirdurum2)).setChecked(true); break;
                     case "3" : ((RadioButton)view.findViewById(R.id.halihazirdurum3)).setChecked(true); break;
                     default  : break;
                }
                switch (Bina_veriler.discephe_durumu)
                {
                     case "1" : ((RadioButton)view.findViewById(R.id.discephe_durumu1)).setChecked(true); break;
                     case "2" : ((RadioButton)view.findViewById(R.id.discephe_durumu2)).setChecked(true); break;
                     case "3" : ((RadioButton)view.findViewById(R.id.discephe_durumu3)).setChecked(true); break;
                     case "4" : ((RadioButton)view.findViewById(R.id.discephe_durumu4)).setChecked(true); break;
                     default  : break;
                }
        }

        return view;
    }



}
