package com.feyzullah.trabzonbelediyesi.trabzonbelediyesi_binayeriyol;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class Isyeri_3 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_isyeri_3, container, false);

        RadioGroup mulkiyetdurumu_group = (RadioGroup)view.findViewById(R.id.mulkiyet_radiogroup);
        mulkiyetdurumu_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId)
                {
                    case R.id.mulkiyetdurumu1: { Isyeri_veriler.mulkiyetdurumu = "1"; break;}
                    case R.id.mulkiyetdurumu2: { Isyeri_veriler.mulkiyetdurumu = "2"; break;}

                } } } );



        if(Isyeri_veriler.islem == 1)
        {
            switch (Isyeri_veriler.mulkiyetdurumu)
            {
                case "1" : ((RadioButton)view.findViewById(R.id.mulkiyetdurumu1)).setChecked(true); break;
                case "2" : ((RadioButton)view.findViewById(R.id.mulkiyetdurumu2)).setChecked(true); break;
                default  : break;
            }

        }

        return view;
    }


}
