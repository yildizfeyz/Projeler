package com.feyzullah.trabzonbelediyesi.trabzonbelediyesi_binayeriyol;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


public class Bina_12 extends Fragment {

    public Bina_12() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bina_12, container, false);

        final EditText notlar_edt = ((EditText) view.findViewById(R.id.notlar));
        notlar_edt.addTextChangedListener(new TextWatcher() {
            @Override public void afterTextChanged(Editable s) { }
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {
                try { Bina_veriler.notlar = notlar_edt.getText().toString(); } catch (Exception ex) {} }
        });

        if(Bina_veriler.islem == 1)
        {
            notlar_edt.setText(Bina_veriler.notlar);
        }

        return view;
    }



}
