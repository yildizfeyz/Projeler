package com.feyzullah.trabzonbelediyesi.trabzonbelediyesi_binayeriyol;

import android.content.Context;
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
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;


public class Bina_10 extends Fragment {



    ListView list;


    String nitelikkodu_str;

    View view;
    public Bina_10() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_bina_10, container, false);
        String [] androidVersion =getResources().getStringArray(R.array.Bina_10_spinnerVeriler);
        Spinner spinnerAndroidVersion=(Spinner) view.findViewById(R.id.nitelikkodu_spinner);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item,androidVersion);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAndroidVersion.setAdapter(arrayAdapter);
        spinnerAndroidVersion.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                // TODO Auto-generated method stub
                nitelikkodu_str = Integer.toString(arg0.getSelectedItemPosition() + 1);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        final Button show=(Button) view.findViewById(R.id.Bina_10btn);
        final EditText kapino_edt=(EditText) view.findViewById(R.id.ickapino);
        final EditText nitelik_edt=(EditText) view.findViewById(R.id.nitelik);

        show.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if(Bina_veriler.islem == 1) {
                    Bina_veriler.ickapino.set(0, kapino_edt.getText().toString());
                    Bina_veriler.nitelik.set(0, nitelik_edt.getText().toString());
                    Bina_veriler.nitelikkodu.set(0, nitelikkodu_str);
                }
                else {
                    Bina_veriler.ickapino.add(Bina_veriler.ickapino.size(), kapino_edt.getText().toString());
                    Bina_veriler.nitelik.add(Bina_veriler.nitelik.size(), nitelik_edt.getText().toString());
                    Bina_veriler.nitelikkodu.add(Bina_veriler.nitelikkodu.size(), nitelikkodu_str);
                    Bina_veriler.Bina10_adapter.refreshResultList();
                }
            }
        });

        list = (ListView) view.findViewById(R.id.Bina_10listview);
        list.setAdapter(Bina_veriler.Bina10_adapter);


        if(Bina_veriler.islem == 1) {
            list.setVisibility(View.INVISIBLE);

            if(Bina_veriler.ickapino.size() > 0) {
                ((EditText) view.findViewById(R.id.ickapino)).setText(Bina_veriler.ickapino.get(0));
                ((EditText) view.findViewById(R.id.nitelik)).setText(Bina_veriler.nitelik.get(0));
                if(Bina_veriler.nitelikkodu.get(0).length() > 0) spinnerAndroidVersion.setSelection(Integer.parseInt(Bina_veriler.nitelikkodu.get(0)) - 1);
            }
        }

        return view;
    }



}
