package com.feyzullah.frsatyakala;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.Socket;
import com.github.nkzawa.socketio.client.IO;
import org.json.JSONException;
import org.json.JSONObject;
import java.net.URISyntaxException;
import java.util.Arrays;


public class SohbetActivity extends AppCompatActivity {

    public static Sohbet_ListviewAdapter adapter;
    String mUsername;
    private EditText mInputMessageView;
    ListView listView1;
    Context bu;
    int hedef = 0;

    private Socket mSocket;
    {
        try {
            mSocket = IO.socket("http://chat.socket.io");
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
    private Socket mSocket2;
    {
        try {
            mSocket2 = IO.socket("http://chat.socket.io");
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    int rsmglc = 0;
    private Emitter.Listener onNewMessage = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    for (int t = 0; t < 1; t++) {
                        try {
                            JSONObject data = (JSONObject) args[0];
                            String username = "";
                            String message = "";
                            try {
                                username = data.getString("username");
                                message = data.getString("message");
                            } catch (JSONException e) {
                            }

                            if(hedef == 0) {
                                String[] mesaj = message.split(";");
                                if (mesaj.length == 2) {
                                    Sohbet_ListviewAdapter.mesajlar = Arrays.copyOf(Sohbet_ListviewAdapter.mesajlar, Sohbet_ListviewAdapter.mesajlar.length + 1);
                                    Sohbet_ListviewAdapter.mesajlar[Sohbet_ListviewAdapter.mesajlar.length - 1] = username + ";" + mesaj[1];

                                    adapter.refreshResultList();
                                }
                            } else {
                                Sohbet_ListviewAdapter.mesajlar = Arrays.copyOf(Sohbet_ListviewAdapter.mesajlar, Sohbet_ListviewAdapter.mesajlar.length + 1);
                                Sohbet_ListviewAdapter.mesajlar[Sohbet_ListviewAdapter.mesajlar.length - 1] = username + ";" + message;

                                adapter.refreshResultList();
                            }
                        } catch (Exception ex) {
                            Toast.makeText(bu, "ass2", Toast.LENGTH_LONG).show();
                        }
                    }
                }
            });
        }
    };


    private Emitter.Listener onLogin = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            JSONObject data = (JSONObject) args[0];

            int numUsers;
            try {
                numUsers = data.getInt("numUsers");
            } catch (JSONException e) {
                return;
            }

            Intent intent = new Intent();
            intent.putExtra("username", mUsername);
            intent.putExtra("numUsers", numUsers);
            setResult(RESULT_OK, intent);
        }
    };



    private void attemptSend(int tur) {
        if (null == mUsername) return;
        if (!mSocket.connected()) return;


            String message = mInputMessageView.getText().toString().trim();
            if (TextUtils.isEmpty(message)) {
                mInputMessageView.requestFocus();
                return;
            }

            mInputMessageView.setText("");
        if(hedef == 0) {

            Sohbet_ListviewAdapter.mesajlar = Arrays.copyOf(Sohbet_ListviewAdapter.mesajlar, Sohbet_ListviewAdapter.mesajlar.length + 1);
            Sohbet_ListviewAdapter.mesajlar[Sohbet_ListviewAdapter.mesajlar.length - 1] = mUsername + ";" + message;

            message = "firsat;" + message;
            mSocket.emit("new message", message);



        }
        else {
            mSocket.emit("new message", message);
            Sohbet_ListviewAdapter.mesajlar = Arrays.copyOf(Sohbet_ListviewAdapter.mesajlar, Sohbet_ListviewAdapter.mesajlar.length + 1);
            Sohbet_ListviewAdapter.mesajlar[Sohbet_ListviewAdapter.mesajlar.length - 1] = mUsername + ";" + message;
        }

        adapter.refreshResultList();

    }



    public void onBackPressed()
    {
        Intent intent = new Intent(this, MainActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("uye",mUsername);
        intent.putExtras(bundle);
        startActivity(intent);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sohbet);

        Sohbet_ListviewAdapter.mesajlar = new String[0];



        android.support.v7.app.ActionBar actionbar = getSupportActionBar();
        actionbar.setBackgroundDrawable(getResources().getDrawable(R.drawable.action_background));

        actionbar.setHomeButtonEnabled(true);

        // navigationu t?klanabilir hale getiriyoruz
        actionbar.setDisplayHomeAsUpEnabled(true);

        setTitle("Canlı Sohbet");
        listView1 = (ListView) findViewById(R.id.sohbetactivity_Listview);
        listView1.setStackFromBottom(true);

        adapter = new Sohbet_ListviewAdapter(this);
        listView1.setAdapter(adapter);

        bu = this;
        mInputMessageView = (EditText) findViewById(R.id.sohbetmesajText);

        Bundle veriler = getIntent().getExtras();
        mUsername = veriler.getString("gonderen");
        try {
            mSocket2.emit("add user", mUsername);
            mSocket2.on("login", onLogin);
            mSocket2.connect();

            mSocket.on("new message", onNewMessage);

            mSocket.connect();

        }
        catch(Exception ex)
        {
            Toast.makeText(getApplicationContext(), ex.getMessage().toString(), Toast.LENGTH_LONG).show();
        }





    }





    public void onTikla(View v)
    {
        EditText et = (EditText)findViewById(R.id.sohbetmesajText);
        if(et.getText().toString().trim().equals("") )
        {

        }
        else
            attemptSend(0);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);


    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        mSocket.disconnect();

        mSocket.off("new message", onNewMessage);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sohbet, menu);

        MenuItem item = menu.findItem(R.id.sohbet_spinner);
        final Spinner spinner = (Spinner) MenuItemCompat.getActionView(item);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.sohbet_spinnerVeriler));

        spinner.setAdapter(adapter); // set the adapter to provide layout of rows and content

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            int eskipos = 0;

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //btn.setEnabled(true);
                //eleman_edt.setEnabled(true);

                if (position == 0 && eskipos != 0) {
                    hedef = 0;
                    Sohbet_ListviewAdapter.mesajlar = new String[0];
                    SohbetActivity.adapter.notifyDataSetChanged();
                    eskipos = 0;
                } else if (position == 1 && eskipos != 1) {
                    hedef = 1;
                    Sohbet_ListviewAdapter.mesajlar = new String[0];
                    SohbetActivity.adapter.notifyDataSetChanged();
                    eskipos = 1;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if(id == android.R.id.home)
        {
            super.onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }
}
