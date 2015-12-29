package com.feyzullah.trabzonbelediyesi.trabzonbelediyesi_binayeriyol;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Yol_2.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Yol_2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Yol_2 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_yol_2, container, false);

        RadioGroup kaplamaturu_group = (RadioGroup)view.findViewById(R.id.kaplama_radiogroup);
        kaplamaturu_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId)
                {
                    case R.id.kaplamaturu1: { Yol_veriler.kaplamaturu = "1"; break;}
                    case R.id.kaplamaturu2: { Yol_veriler.kaplamaturu = "2"; break;}
                    case R.id.kaplamaturu3: { Yol_veriler.kaplamaturu = "3"; break;}
                    case R.id.kaplamaturu4: { Yol_veriler.kaplamaturu = "4"; break;}

                } } } );



        if(Yol_veriler.islem == 1)
        {
            switch (Yol_veriler.kaplamaturu)
            {
                case "1" : ((RadioButton)view.findViewById(R.id.kaplamaturu1)).setChecked(true); break;
                case "2" : ((RadioButton)view.findViewById(R.id.kaplamaturu2)).setChecked(true); break;
                case "3" : ((RadioButton)view.findViewById(R.id.kaplamaturu3)).setChecked(true); break;
                case "4" : ((RadioButton)view.findViewById(R.id.kaplamaturu4)).setChecked(true); break;
                default  : break;
            }

        }

        return view;
    }


}

