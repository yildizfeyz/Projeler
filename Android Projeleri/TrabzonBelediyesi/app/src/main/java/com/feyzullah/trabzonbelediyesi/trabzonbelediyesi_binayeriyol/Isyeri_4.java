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


public class Isyeri_4 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_isyeri_4, container, false);

        final EditText adisoyadi_edt = ((EditText) view.findViewById(R.id.adisoyadi));
        adisoyadi_edt.addTextChangedListener(new TextWatcher() {
            @Override public void afterTextChanged(Editable s) {}
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {
                try { Isyeri_veriler.adisoyadi = adisoyadi_edt.getText().toString(); } catch (Exception ex) { } }
        });

        final EditText tcno_edt = ((EditText) view.findViewById(R.id.tcno));
        tcno_edt.addTextChangedListener(new TextWatcher() {
            @Override public void afterTextChanged(Editable s) {}
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {
                try { Isyeri_veriler.tcno = tcno_edt.getText().toString(); } catch (Exception ex) { } }
        });

        final EditText vergino_edt = ((EditText) view.findViewById(R.id.vergino));
        vergino_edt.addTextChangedListener(new TextWatcher() {
            @Override public void afterTextChanged(Editable s) {}
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {
                try { Isyeri_veriler.vergino = vergino_edt.getText().toString(); } catch (Exception ex) { } }
        });

        if(Isyeri_veriler.islem == 1)
        {
            adisoyadi_edt.setText(Isyeri_veriler.adisoyadi);
            tcno_edt.setText(Isyeri_veriler.tcno);
            vergino_edt.setText(Isyeri_veriler.vergino);
        }

        return view;
    }


}
