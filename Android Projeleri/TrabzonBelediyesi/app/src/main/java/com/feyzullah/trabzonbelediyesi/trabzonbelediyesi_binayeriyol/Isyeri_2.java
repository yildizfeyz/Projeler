package com.feyzullah.trabzonbelediyesi.trabzonbelediyesi_binayeriyol;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;


public class Isyeri_2 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_isyeri_2, container, false);

        final EditText ickapino_edt = ((EditText) view.findViewById(R.id.isyeri_ickapino));
        ickapino_edt.addTextChangedListener(new TextWatcher() {
            @Override public void afterTextChanged(Editable s) {}
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {
                try { Isyeri_veriler.ickapino = ickapino_edt.getText().toString(); } catch (Exception ex) { } }
        });

        final EditText isletmeadi_edt = ((EditText) view.findViewById(R.id.isletmeadi));
        isletmeadi_edt.addTextChangedListener(new TextWatcher() {
            @Override public void afterTextChanged(Editable s) {}
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {
                try { Isyeri_veriler.isletmeadi = isletmeadi_edt.getText().toString(); } catch (Exception ex) { } }
        });

        if(Isyeri_veriler.islem == 1)
        {
            ickapino_edt.setText(Isyeri_veriler.ickapino);
            isletmeadi_edt.setText(Isyeri_veriler.isletmeadi);
        }

        return view;
    }


}
