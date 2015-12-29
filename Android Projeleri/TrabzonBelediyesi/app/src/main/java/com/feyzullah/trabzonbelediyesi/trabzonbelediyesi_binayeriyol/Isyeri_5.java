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


public class Isyeri_5 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_isyeri_5, container, false);

        final EditText telefon_edt = ((EditText) view.findViewById(R.id.telefon));
        telefon_edt.addTextChangedListener(new TextWatcher() {
            @Override public void afterTextChanged(Editable s) {}
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {
                try { Isyeri_veriler.telefon = telefon_edt.getText().toString(); } catch (Exception ex) { } }
        });

        final EditText webadresi_edt = ((EditText) view.findViewById(R.id.websitesi));
        webadresi_edt.addTextChangedListener(new TextWatcher() {
            @Override public void afterTextChanged(Editable s) {}
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {
                try { Isyeri_veriler.webadresi = webadresi_edt.getText().toString(); } catch (Exception ex) { } }
        });

        if(Isyeri_veriler.islem == 1)
        {
            telefon_edt.setText(Isyeri_veriler.telefon);
            webadresi_edt.setText(Isyeri_veriler.webadresi);
        }

        return view;
    }


}
