package com.feyzullah.trabzonbelediyesi.trabzonbelediyesi_binayeriyol;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class Bina_13 extends Fragment {

    View view;

    public Bina_13() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    private String appFolderCheckandCreate(){

        String appFolderPath="";
        File externalStorage = Environment.getExternalStorageDirectory();

        if (externalStorage.canWrite())
        {
            appFolderPath = externalStorage.getAbsolutePath() + "/_KTUGisLabResimler/Bina";
            File dir = new File(appFolderPath);

            if (!dir.exists())
            {
                dir.mkdirs();
            }

        }
        else
        {

        }

        return appFolderPath;
    }


    private String getTimeStamp() {

        final long timestamp = new Date().getTime();

        final Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(timestamp);

        final String timeString = new SimpleDateFormat("ss.SSS").format(cal.getTime());


        return timeString;
    }



    static String dosyayolu = "";

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {

            Bina_veriler.Resimler.add(dosyayolu);
            //Bina_veriler.Bina13_adapter.refreshResultList();


        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_bina_13, container, false);

        if(Bina_veriler.islem == 1) ((Button)view.findViewById(R.id.Bina13_button)).setEnabled(false);

        ((Button)view.findViewById(R.id.Bina13_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bina_veriler.Bina13_adapter = new Bina_13_gridviewAdapter(getContext());
                //Toast.makeText(getContext(),Bina_veriler.geocode,Toast.LENGTH_LONG).show();
                ((GridView) view.findViewById(R.id.Bina13_gridView)).setAdapter(Bina_veriler.Bina13_adapter);
                dosyayolu = Bina_veriler.geocode + "_" + getTimeStamp() + ".jpg";
                File image = new File(appFolderCheckandCreate(), dosyayolu);
                dosyayolu = appFolderCheckandCreate() + "/" + dosyayolu;
                Uri uriSavedImage = Uri.fromFile(image);


                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                i.putExtra(MediaStore.EXTRA_OUTPUT, uriSavedImage);
                i.putExtra("return-data", true);
                //i.putExtra(MediaStore.EXTRA_VIDEO_QUALITY,1);
                startActivityForResult(i, 0);

            }
        });

        return view;
    }


}
