package com.feyzullah.trabzonbelediyesi.trabzonbelediyesi_binayeriyol;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Arrays;


public class Bina_1 extends Fragment {

    EditText geocode_edt;
    EditText mahalleadi_edt;
    Spinner spinnerAndroidVersion;
    String [] androidVersion;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_bina_1, container, false);

        androidVersion =getResources().getStringArray(R.array.Bina_1_spinnerVeriler);
        spinnerAndroidVersion =(Spinner) view.findViewById(R.id.mahalleadi);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item,androidVersion);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAndroidVersion.setAdapter(arrayAdapter);
        spinnerAndroidVersion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                // TODO Auto-generated method stub
                Bina_veriler.mahalleadi = arg0.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
/*
        mahalleadi_edt = ((EditText) view.findViewById(R.id.mahalleadi));
        mahalleadi_edt.addTextChangedListener(new TextWatcher() {
            @Override public void afterTextChanged(Editable s) {}
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {
                try { Bina_veriler.mahalleadi = mahalleadi_edt.getText().toString(); } catch (Exception ex) { } }
        });
*/
        geocode_edt = ((EditText) view.findViewById(R.id.geocode));
        geocode_edt.addTextChangedListener(new TextWatcher() {
            @Override public void afterTextChanged(Editable s) {}
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {
                try { Bina_veriler.geocode = geocode_edt.getText().toString(); } catch (Exception ex) { } }
        });

        if(Bina_veriler.islem == 1)
        {
            geocode_edt.setText(Bina_veriler.geocode);
            spinnerAndroidVersion.setSelection(Arrays.asList(androidVersion).indexOf(Bina_veriler.mahalleadi));
        }
        return view;
    }


}
