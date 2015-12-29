package com.feyzullah.trabzonbelediyesi.trabzonbelediyesi_binayeriyol;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Yol_1.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Yol_1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Yol_1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_yol_1, container, false);

        final EditText yolkod_edt = ((EditText) view.findViewById(R.id.yolkod));
        yolkod_edt.addTextChangedListener(new TextWatcher() {
            @Override public void afterTextChanged(Editable s) {}
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {
                try { Yol_veriler.yolkod = yolkod_edt.getText().toString(); } catch (Exception ex) { } }
        });

        final EditText genislik_edt = ((EditText) view.findViewById(R.id.genislik));
        genislik_edt.addTextChangedListener(new TextWatcher() {
            @Override public void afterTextChanged(Editable s) {}
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {
                try { Yol_veriler.genislik = genislik_edt.getText().toString(); } catch (Exception ex) { } }
        });

        final EditText ad_edt = ((EditText) view.findViewById(R.id.ad));
        ad_edt.addTextChangedListener(new TextWatcher() {
            @Override public void afterTextChanged(Editable s) {}
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {
                try { Yol_veriler.ad = ad_edt.getText().toString(); } catch (Exception ex) { } }
        });

        if(Yol_veriler.islem == 1)
        {
            yolkod_edt.setText(Yol_veriler.yolkod);
            genislik_edt.setText(Yol_veriler.genislik);
            ad_edt.setText(Yol_veriler.ad);
        }

        return view;
    }


}
