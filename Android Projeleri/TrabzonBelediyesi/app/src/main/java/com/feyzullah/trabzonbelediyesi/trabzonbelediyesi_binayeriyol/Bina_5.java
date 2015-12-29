package com.feyzullah.trabzonbelediyesi.trabzonbelediyesi_binayeriyol;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class Bina_5 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bina_5, container, false);
        RadioGroup yapidurumu_group = (RadioGroup)view.findViewById(R.id.bina5_radiogroup1);
        yapidurumu_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId)
                {
                    case R.id.yapidurumu1: { Bina_veriler.yapidurumu = "1"; break; }
                    case R.id.yapidurumu2: { Bina_veriler.yapidurumu = "2"; break;}
                    case R.id.yapidurumu3: { Bina_veriler.yapidurumu = "3"; break;}
                } } } );

        RadioGroup catidurumu_group = (RadioGroup)view.findViewById(R.id.bina5_radiogroup2);
        catidurumu_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId)
                {
                    case R.id.catidurumu1: { Bina_veriler.catidurumu = "1"; break; }
                    case R.id.catidurumu2: { Bina_veriler.catidurumu = "2"; break;}
                    case R.id.catidurumu3: { Bina_veriler.catidurumu = "3"; break;}
                    case R.id.catidurumu4: { Bina_veriler.catidurumu = "3"; break;}
                } } } );

        if(Bina_veriler.islem == 1)
        {
            switch (Bina_veriler.yapidurumu)
            {
                case "1" : ((RadioButton)view.findViewById(R.id.yapidurumu1)).setChecked(true); break;
                case "2" : ((RadioButton)view.findViewById(R.id.yapidurumu2)).setChecked(true); break;
                case "3" : ((RadioButton)view.findViewById(R.id.yapidurumu3)).setChecked(true); break;
                default  : break;
            }
            switch (Bina_veriler.catidurumu)
            {
                case "1" : ((RadioButton)view.findViewById(R.id.catidurumu1)).setChecked(true); break;
                case "2" : ((RadioButton)view.findViewById(R.id.catidurumu2)).setChecked(true); break;
                case "3" : ((RadioButton)view.findViewById(R.id.catidurumu3)).setChecked(true); break;
                case "4" : ((RadioButton)view.findViewById(R.id.catidurumu4)).setChecked(true); break;
                default  : break;
            }
        }
        return view;
    }


}
