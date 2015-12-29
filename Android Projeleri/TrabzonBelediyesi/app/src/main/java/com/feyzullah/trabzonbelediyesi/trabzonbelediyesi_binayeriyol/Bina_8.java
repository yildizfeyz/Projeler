package com.feyzullah.trabzonbelediyesi.trabzonbelediyesi_binayeriyol;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


public class Bina_8 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bina_8, container, false);

        final EditText binasorumlusu_edt = ((EditText) view.findViewById(R.id.binasorumlusu));
        binasorumlusu_edt.addTextChangedListener(new TextWatcher() {
            @Override public void afterTextChanged(Editable s) { }
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {
                try { Bina_veriler.binasorumlusu = binasorumlusu_edt.getText().toString(); } catch (Exception ex) {} }
        });

        final EditText sorumlu_tel_edt = ((EditText) view.findViewById(R.id.sorumlu_tel));
        sorumlu_tel_edt.addTextChangedListener(new TextWatcher() {
            @Override public void afterTextChanged(Editable s) { }
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {
                try { Bina_veriler.sorumlu_tel = sorumlu_tel_edt.getText().toString(); } catch (Exception ex) {} }
        });

        if(Bina_veriler.islem == 1)
        {
            binasorumlusu_edt.setText(Bina_veriler.binasorumlusu);
            sorumlu_tel_edt.setText(Bina_veriler.sorumlu_tel);
        }
        return view;
    }


}
