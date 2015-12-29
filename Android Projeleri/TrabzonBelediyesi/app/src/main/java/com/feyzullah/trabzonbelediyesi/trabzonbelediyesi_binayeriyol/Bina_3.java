package com.feyzullah.trabzonbelediyesi.trabzonbelediyesi_binayeriyol;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


public class Bina_3 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bina_3, container, false);


        final EditText kapino_edt = ((EditText) view.findViewById(R.id.kapino));
        kapino_edt.addTextChangedListener(new TextWatcher() {
            @Override public void afterTextChanged(Editable s) {}
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {
                try { Bina_veriler.kapino = kapino_edt.getText().toString(); } catch (Exception ex) { } }
        });

        final EditText siteadi_edt = ((EditText) view.findViewById(R.id.siteadi));
        siteadi_edt.addTextChangedListener(new TextWatcher() {
            @Override public void afterTextChanged(Editable s) {}
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {
                try { Bina_veriler.siteadi = siteadi_edt.getText().toString(); } catch (Exception ex) { } }
        });

        final EditText apartmanadi_edt = ((EditText) view.findViewById(R.id.apartmanadi));
        apartmanadi_edt.addTextChangedListener(new TextWatcher() {
            @Override public void afterTextChanged(Editable s) {}
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {
                try { Bina_veriler.apartmanadi = apartmanadi_edt.getText().toString(); } catch (Exception ex) { } }
        });


        if(Bina_veriler.islem == 1)
        {
            kapino_edt.setText(Bina_veriler.kapino);
            siteadi_edt.setText(Bina_veriler.siteadi);
            apartmanadi_edt.setText(Bina_veriler.apartmanadi);
        }
        return view;
    }


}
