package com.feyzullah.trabzonbelediyesi.trabzonbelediyesi_binayeriyol;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class Bina_6 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bina_6, container, false);
        RadioGroup yapisistemi_group = (RadioGroup)view.findViewById(R.id.bina6_radiogroup1);
        yapisistemi_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId)
                {
                    case R.id.yapisistemi1: { Bina_veriler.yapisistemi = "1"; break; }
                    case R.id.yapisistemi2: { Bina_veriler.yapisistemi = "2"; break;}
                    case R.id.yapisistemi3: { Bina_veriler.yapisistemi = "3"; break;}
                    case R.id.yapisistemi4: { Bina_veriler.yapisistemi = "4"; break;}
                } } } );

        RadioGroup kullanilanmalzeme_group = (RadioGroup)view.findViewById(R.id.bina6_radiogroup2);
        kullanilanmalzeme_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId)
                {
                    case R.id.kullanilanmalzeme1: { Bina_veriler.kullanilanmalzeme = "1"; break; }
                    case R.id.kullanilanmalzeme2: { Bina_veriler.kullanilanmalzeme = "2"; break;}
                    case R.id.kullanilanmalzeme3: { Bina_veriler.kullanilanmalzeme = "3"; break;}
                    case R.id.kullanilanmalzeme4: { Bina_veriler.kullanilanmalzeme = "4"; break;}
                } } } );

        if(Bina_veriler.islem == 1)
        {
            switch (Bina_veriler.yapisistemi)
            {
                case "1" : ((RadioButton)view.findViewById(R.id.yapisistemi1)).setChecked(true); break;
                case "2" : ((RadioButton)view.findViewById(R.id.yapisistemi2)).setChecked(true); break;
                case "3" : ((RadioButton)view.findViewById(R.id.yapisistemi3)).setChecked(true); break;
                case "4" : ((RadioButton)view.findViewById(R.id.yapisistemi4)).setChecked(true); break;
                default  : break;
            }
            switch (Bina_veriler.kullanilanmalzeme)
            {
                case "1" : ((RadioButton)view.findViewById(R.id.kullanilanmalzeme1)).setChecked(true); break;
                case "2" : ((RadioButton)view.findViewById(R.id.kullanilanmalzeme2)).setChecked(true); break;
                case "3" : ((RadioButton)view.findViewById(R.id.kullanilanmalzeme3)).setChecked(true); break;
                case "4" : ((RadioButton)view.findViewById(R.id.kullanilanmalzeme4)).setChecked(true); break;
                default  : break;
            }
        }

        return view;
    }


}
