package com.feyzullah.romarakamlar;

import android.app.ActionBar;
import android.app.Notification;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Set;

public class MainActivity extends AppCompatActivity {



    HashMap<Character, Integer> romasayilari = new HashMap<Character,Integer>();
    private String get_roma(int sayi)
    {
        int bin, yuz, on, bir;
        bir = sayi % 10;
        on = (sayi / 10) % 10;
        yuz = (sayi / 100) % 10;
        bin = (sayi / 1000) % 10;

        String _bin = "", _yuz = "", _on = "", _bir = "";
        switch (bir)
        {
            case 0: _bir = ""; break;
            case 1: _bir = "I"; break;
            case 2: _bir = "II"; break;
            case 3: _bir = "III"; break;
            case 4: _bir = "IV"; break;
            case 5: _bir = "V"; break;
            case 6: _bir = "VI"; break;
            case 7: _bir = "VII"; break;
            case 8: _bir = "VIII"; break;
            case 9: _bir = "IX"; break;
        }

        switch (on)
        {
            case 0: _on = ""; break;
            case 1: _on = "X"; break; //10
            case 2: _on = "XX"; break; //20
            case 3: _on = "XXX"; break; //30
            case 4: _on = "XL"; break; //40
            case 5: _on = "L"; break; //50
            case 6: _on = "LX"; break; //60
            case 7: _on = "LXX"; break; //70
            case 8: _on = "LXXX"; break; //80
            case 9: _on = "XC"; break; //90
        }

        switch (yuz)
        {
            case 0: _yuz = ""; break;
            case 1: _yuz = "C"; break; //100
            case 2: _yuz = "CC"; break; //200
            case 3: _yuz = "CCC"; break; //300
            case 4: _yuz = "CD"; break; //400
            case 5: _yuz = "D"; break; //500
            case 6: _yuz = "DC"; break; //600
            case 7: _yuz = "DCC"; break; //700
            case 8: _yuz = "DCCC"; break; //800
            case 9: _yuz = "CM"; break; //900
        }

        switch (bin)
        {
            case 0: _bin = ""; break;
            case 1: _bin = "M"; break; //1000
            case 2: _bin = "MM"; break; //2000
            case 3: _bin = "MMM"; break; //3000
        }


        return _bin + _yuz + _on + _bir;

    }


    private int get_arap(String roma)
    {
        int arap[] = new int[roma.length()];
        int sonuc = 0;
        for(int i = 0; i < roma.length(); i++)
        {
            if(romasayilari.get(roma.charAt(i)) == null) return 0;
            arap[i] = romasayilari.get(roma.charAt(i));
        }
        for(int i = 0; i < arap.length - 1; i++)
        {
            if(arap[i] < arap[i+1]) arap[i] *= -1;
        }
        for(int i = 0; i < arap.length; i++)
        {
            sonuc = sonuc + arap[i];
        }
        return sonuc;

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        android.support.v7.app.ActionBar actionbar = getSupportActionBar();

        actionbar.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
        actionbar.show();
        bumu = ((TextView) findViewById(R.id.bumu));
        final EditText roma_edt = ((EditText) findViewById(R.id.roma_edt));
        roma_edt.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable et) {
                String s = et.toString();
                if (!s.equals(s.toUpperCase())) {
                    s = s.toUpperCase();
                    roma_edt.setText(s);
                }

                roma_edt.setSelection(roma_edt.getText().length());
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }
        });


        romasayilari.put('I', 1);
        romasayilari.put('V', 5 );
        romasayilari.put('X', 10);
        romasayilari.put('L', 50);
        romasayilari.put('C', 100);
        romasayilari.put('D', 500);
        romasayilari.put('M', 1000);
    }


    public void onRoma(View v)
    {
        bumu.setText("");

        if((((EditText) findViewById(R.id.arap_edt)).getText().toString().trim().length() > 0)) {
            EditText roma = ((EditText) findViewById(R.id.roma_edt));

            int arap = Integer.parseInt(((EditText) findViewById(R.id.arap_edt)).getText().toString());


            if (arap > 3999 || arap < 0)
                Toast.makeText(v.getContext(), "Roma Rakamı 0 - 3999  arası olmalıdır.", Toast.LENGTH_LONG).show();
            else roma.setText(get_roma(arap));
        }
    }

    TextView bumu;
    public void onArap(View v)
    {
        String roma = ((EditText) findViewById(R.id.roma_edt)).getText().toString();
        EditText roma_edt = ((EditText) findViewById(R.id.roma_edt));
        final EditText arap = ((EditText) findViewById(R.id.arap_edt));


        //if(arap > 3999 || arap < 0) Toast.makeText(v.getContext(), "Roma Rakamı 0 - 3999  arası olmalıdır.",Toast.LENGTH_LONG).show();
        //else roma.setText(get_roma(arap));
        if((roma_edt.getText().toString().trim().length() > 0))
        {
            int sayi = get_arap(roma);
            if (sayi == 0 || sayi > 3999) { Toast.makeText(v.getContext(), "Geçersiz Roma Rakamı", Toast.LENGTH_LONG).show(); bumu.setText("");}
            else {
                final String rm = get_roma(sayi);
                if(rm.equals(roma))
                arap.setText(String.valueOf(sayi));
                else {
                    Toast.makeText(v.getContext(), "Hatalı Yazım Biçimi", Toast.LENGTH_LONG).show();
                    bumu.setText(Html.fromHtml("<html>Bunu mu demek istediniz? <b><font color=\'#ff0000\'>" + rm + "</font></b></html>"));
                    bumu.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ((EditText) findViewById(R.id.roma_edt)).setText(rm);
                            bumu.setText("");
                        }
                    });
                }
            }
        }
        else { Toast.makeText(v.getContext(), "Geçersiz Roma Rakamı", Toast.LENGTH_LONG).show(); bumu.setText(""); }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
