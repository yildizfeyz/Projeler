package com.feyzullah.trabzonbelediyesi.trabzonbelediyesi_binayeriyol;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

import java.util.ArrayList;
import java.util.List;


public class Bina_11 extends Fragment {

    ListView list;


    String nitelikkodu_str;


    public Bina_11() {
        // Required empty public constructor


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_bina_11, container, false);
        final Button show=(Button) view.findViewById(R.id.Bina_11btn);
        final EditText meydan_edt=(EditText) view.findViewById(R.id.baskamahalleadi);
        final EditText kapino_edt=(EditText) view.findViewById(R.id.baskakapino);
        final EditText dusunceler_edt=(EditText) view.findViewById(R.id.baskadusunceler);
        list=(ListView) view.findViewById(R.id.Bina_11listview);

        //add();

        show.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                if(Bina_veriler.islem == 1) {
                    Bina_veriler.baskakapino.set(0, kapino_edt.getText().toString());
                    Bina_veriler.baskamahalleadi.set(0, meydan_edt.getText().toString());
                    Bina_veriler.baskadusunceler.set(0, dusunceler_edt.getText().toString());
                }
                else {
                    Bina_veriler.baskakapino.add(Bina_veriler.baskakapino.size(), kapino_edt.getText().toString());
                    Bina_veriler.baskamahalleadi.add(Bina_veriler.baskamahalleadi.size(), meydan_edt.getText().toString());
                    Bina_veriler.baskadusunceler.add(Bina_veriler.baskadusunceler.size(), dusunceler_edt.getText().toString());
                    Bina_veriler.Bina11_adapter.refreshResultList();
                }

            }
        });
        list = (ListView) view.findViewById(R.id.Bina_11listview);
        list.setAdapter(Bina_veriler.Bina11_adapter);

        if(Bina_veriler.islem == 1) {
            list.setVisibility(View.INVISIBLE);

            if(Bina_veriler.baskakapino.size() > 0) {
                ((EditText) view.findViewById(R.id.baskakapino)).setText(Bina_veriler.baskakapino.get(0));
                ((EditText) view.findViewById(R.id.baskamahalleadi)).setText(Bina_veriler.baskamahalleadi.get(0));
                ((EditText) view.findViewById(R.id.baskadusunceler)).setText(Bina_veriler.baskadusunceler.get(0));
            }
        }

        return view;
    }



}
