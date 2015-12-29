package com.feyzullah.frsatyakala;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Base64;
import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;


public class WebService {

    String uyeekle = "";
    int bekle = 0;
    private final String NAMESPACE = "http://tempuri.org/";
    private final String URL = "http://feyzullah.info/blogenginenet_9/Service1.asmx";
    private final String SOAP_ACTION = "http://tempuri.org/";
    private String TAG = "PGGURU";
    private static String responseJSON;
    String[] placelist;
    Gson gson = new Gson();


    public  String paylasim_ekle(String gonderen, String zaman, String nerede, String nevar, String aciklama
                                , String konum_X, String konum_Y, String resim1, String resim2, String resim3, String resimsayisi) {
        try {
            String methName = "paylasim_ekle";
            SoapObject request = new SoapObject(NAMESPACE, methName);
            PropertyInfo paramPI = new PropertyInfo();
            paramPI.setName("gonderen");
            paramPI.setValue(gonderen);
            paramPI.setType(PropertyInfo.STRING_CLASS);
            request.addProperty(paramPI);

            paramPI = new PropertyInfo();
            paramPI.setName("zaman");
            paramPI.setValue(zaman);
            paramPI.setType(PropertyInfo.STRING_CLASS);
            request.addProperty(paramPI);

            paramPI = new PropertyInfo();
            paramPI.setName("nerede");
            paramPI.setValue(nerede);
            paramPI.setType(PropertyInfo.STRING_CLASS);
            request.addProperty(paramPI);

            paramPI = new PropertyInfo();
            paramPI.setName("nevar");
            paramPI.setValue(nevar);
            paramPI.setType(PropertyInfo.STRING_CLASS);
            request.addProperty(paramPI);

            paramPI = new PropertyInfo();
            paramPI.setName("aciklama");
            paramPI.setValue(aciklama);
            paramPI.setType(PropertyInfo.STRING_CLASS);
            request.addProperty(paramPI);

            konum_X = konum_X.replace(".", ",");
            paramPI = new PropertyInfo();
            paramPI.setName("konum_X");
            paramPI.setValue(konum_X);
            paramPI.setType(PropertyInfo.STRING_CLASS);
            request.addProperty(paramPI);

            konum_Y = konum_Y.replace(".", ",");
            paramPI = new PropertyInfo();
            paramPI.setName("konum_Y");
            paramPI.setValue(konum_Y);
            paramPI.setType(PropertyInfo.STRING_CLASS);
            request.addProperty(paramPI);

            paramPI = new PropertyInfo();
            paramPI.setName("resim1");
            paramPI.setValue(resim1);
            paramPI.setType(PropertyInfo.STRING_CLASS);
            request.addProperty(paramPI);

            paramPI = new PropertyInfo();
            paramPI.setName("resim2");
            paramPI.setValue(resim2);
            paramPI.setType(PropertyInfo.STRING_CLASS);
            request.addProperty(paramPI);

            paramPI = new PropertyInfo();
            paramPI.setName("resim3");
            paramPI.setValue(resim3);
            paramPI.setType(PropertyInfo.STRING_CLASS);
            request.addProperty(paramPI);

            paramPI = new PropertyInfo();
            paramPI.setName("resimsayisi");
            paramPI.setValue(resimsayisi);
            paramPI.setType(PropertyInfo.STRING_CLASS);
            request.addProperty(paramPI);

            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                    SoapEnvelope.VER11);
            envelope.dotNet = true;
            envelope.setOutputSoapObject(request);
            HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
            androidHttpTransport.call(SOAP_ACTION+methName, envelope);
            SoapPrimitive response = (SoapPrimitive) envelope.getResponse();

            //SoapObject result = (SoapObject) envelope.bodyIn;

            //String str = ((SoapObject)result.getProperty(0)).getProperty(1).toString();

            responseJSON = response.toString();
            uyeekle = gson.fromJson(responseJSON, String.class);
            return uyeekle;
        }
        catch (Exception ex)
        {
            return ex.getMessage();
        }

    }

    public  boolean paylasim_sil(String ID) {
        try {
            String methName = "paylasim_sil";
            SoapObject request = new SoapObject(NAMESPACE, methName);
            PropertyInfo paramPI = new PropertyInfo();
            paramPI.setName("ID");
            paramPI.setValue(ID);
            paramPI.setType(PropertyInfo.STRING_CLASS);
            request.addProperty(paramPI);

            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                    SoapEnvelope.VER11);
            envelope.dotNet = true;
            envelope.setOutputSoapObject(request);
            HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
            androidHttpTransport.call(SOAP_ACTION+methName, envelope);
            SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
            responseJSON = response.toString();
            //uyeekle = gson.fromJson(responseJSON, String.class);


            return responseJSON.toString().equals("ok");
        }
        catch (Exception ex)
        {

            return false;
        }

    }

    public  String yorum_ekle(String paylasim_ID, String zaman, String gonderen, String yorum) {
        try {
            //invokeJSONWS("","uye_ekle");
            String methName = "yorum_ekle";
            SoapObject request = new SoapObject(NAMESPACE, methName);
            PropertyInfo paramPI = new PropertyInfo();
            paramPI.setName("Paylasim_ID");
            paramPI.setValue(paylasim_ID);
            paramPI.setType(PropertyInfo.STRING_CLASS);
            request.addProperty(paramPI);

            paramPI = new PropertyInfo();
            paramPI.setName("zaman");
            paramPI.setValue(zaman);
            paramPI.setType(PropertyInfo.STRING_CLASS);
            request.addProperty(paramPI);

            paramPI = new PropertyInfo();
            paramPI.setName("gonderen");
            paramPI.setValue(gonderen);
            paramPI.setType(PropertyInfo.STRING_CLASS);
            request.addProperty(paramPI);

            paramPI = new PropertyInfo();
            paramPI.setName("yorum");
            paramPI.setValue(yorum);
            paramPI.setType(PropertyInfo.STRING_CLASS);
            request.addProperty(paramPI);

            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                    SoapEnvelope.VER11);
            envelope.dotNet = true;
            envelope.setOutputSoapObject(request);
            HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
            androidHttpTransport.call(SOAP_ACTION+methName, envelope);
            SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
            responseJSON = response.toString();
            //uyeekle = gson.fromJson(responseJSON, String.class);


            return responseJSON.toString();
        }
        catch (Exception ex)
        {
            String a = ex.getMessage();
            return a;
        }

    }

    public  boolean uye_ekle(String kadi, String parola, String resim) {
        try {
            //invokeJSONWS("","uye_ekle");
            String methName = "uye_ekle";
            SoapObject request = new SoapObject(NAMESPACE, methName);
            PropertyInfo paramPI = new PropertyInfo();
            paramPI.setName("kadi");
            paramPI.setValue(kadi);
            paramPI.setType(PropertyInfo.STRING_CLASS);
            request.addProperty(paramPI);

            paramPI = new PropertyInfo();
            paramPI.setName("parola");
            paramPI.setValue(parola);
            paramPI.setType(PropertyInfo.STRING_CLASS);
            request.addProperty(paramPI);

            paramPI = new PropertyInfo();
            paramPI.setName("resim");
            paramPI.setValue(resim);
            paramPI.setType(PropertyInfo.STRING_CLASS);
            request.addProperty(paramPI);



            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                    SoapEnvelope.VER11);
            envelope.dotNet = true;
            envelope.setOutputSoapObject(request);
            HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
            androidHttpTransport.call(SOAP_ACTION+methName, envelope);
            SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
            responseJSON = response.toString();
            //uyeekle = gson.fromJson(responseJSON, String.class);


            return responseJSON.toString().equals("ok");
        }
        catch (Exception ex)
        {

            return false;
        }

    }



    public  boolean uye_girisi(String kadi, String parola) {
        try {
            //invokeJSONWS("","uye_ekle");
            String methName = "uye_girisi";
            SoapObject request = new SoapObject(NAMESPACE, methName);
            PropertyInfo paramPI = new PropertyInfo();
            paramPI.setName("kadi");
            paramPI.setValue(kadi);
            paramPI.setType(PropertyInfo.STRING_CLASS);
            request.addProperty(paramPI);

            paramPI = new PropertyInfo();
            paramPI.setName("parola");
            paramPI.setValue(parola);
            paramPI.setType(PropertyInfo.STRING_CLASS);
            request.addProperty(paramPI);




            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                    SoapEnvelope.VER11);
            envelope.dotNet = true;
            envelope.setOutputSoapObject(request);
            HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
            androidHttpTransport.call(SOAP_ACTION+methName, envelope);
            SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
            responseJSON = response.toString();
            //uyeekle = gson.fromJson(responseJSON, String.class);


            return responseJSON.toString().equals("ok");
        }
        catch (Exception ex)
        {

            return false;
        }

    }


    public  boolean uye_guncelle(String e_kadi, String kadi, String parola, String resim) {
        try {
            //invokeJSONWS("","uye_ekle");
            String methName = "uye_guncelle";
            SoapObject request = new SoapObject(NAMESPACE, methName);
            PropertyInfo paramPI = new PropertyInfo();
            paramPI.setName("e_kadi");
            paramPI.setValue(e_kadi);
            paramPI.setType(PropertyInfo.STRING_CLASS);
            request.addProperty(paramPI);

            paramPI = new PropertyInfo();
            paramPI.setName("kadi");
            paramPI.setValue(kadi);
            paramPI.setType(PropertyInfo.STRING_CLASS);
            request.addProperty(paramPI);

            paramPI = new PropertyInfo();
            paramPI.setName("parola");
            paramPI.setValue(parola);
            paramPI.setType(PropertyInfo.STRING_CLASS);
            request.addProperty(paramPI);

            paramPI = new PropertyInfo();
            paramPI.setName("resim");
            paramPI.setValue(resim);
            paramPI.setType(PropertyInfo.STRING_CLASS);
            request.addProperty(paramPI);


            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                    SoapEnvelope.VER11);
            envelope.dotNet = true;
            envelope.setOutputSoapObject(request);
            HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
            androidHttpTransport.call(SOAP_ACTION+methName, envelope);
            SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
            responseJSON = response.toString();
            //uyeekle = gson.fromJson(responseJSON, String.class);


            return responseJSON.toString().equals("ok");
        }
        catch (Exception ex)
        {

            return false;
        }

    }

    public  Bitmap profil_getir(String kadi) {
        try {
            //invokeJSONWS("","uye_ekle");
            String methName = "profil_getir";
            SoapObject request = new SoapObject(NAMESPACE, methName);
            PropertyInfo paramPI = new PropertyInfo();
            paramPI.setName("kullanici");
            paramPI.setValue(kadi);
            paramPI.setType(PropertyInfo.STRING_CLASS);
            request.addProperty(paramPI);





            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                    SoapEnvelope.VER11);
            envelope.dotNet = true;
            envelope.setOutputSoapObject(request);
            HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
            SoapPrimitive response = null;
            try {
                androidHttpTransport.call(SOAP_ACTION + methName, envelope);
                response = (SoapPrimitive) envelope.getResponse();
            }
            catch (Exception ex) {}
            responseJSON = response.toString();
            //uyeekle = gson.fromJson(responseJSON, String.class);


            return stringTObitmap(responseJSON.toString());
        }
        catch (Exception ex)
        {

            return null;
        }

    }

    public  String yorum_sil(String ID) {
        try {
            //invokeJSONWS("","uye_ekle");
            String methName = "yorum_sil";
            SoapObject request = new SoapObject(NAMESPACE, methName);
            PropertyInfo paramPI = new PropertyInfo();
            paramPI.setName("ID");
            paramPI.setValue(ID);
            paramPI.setType(PropertyInfo.STRING_CLASS);
            request.addProperty(paramPI);



            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                    SoapEnvelope.VER11);
            envelope.dotNet = true;
            envelope.setOutputSoapObject(request);
            HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
            androidHttpTransport.call(SOAP_ACTION+methName, envelope);
            SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
            responseJSON = response.toString();
            //uyeekle = gson.fromJson(responseJSON, String.class);


            return gson.fromJson(responseJSON, String.class);
        }
        catch (Exception ex)
        {
            String a = ex.getMessage();
            return a;
        }

    }


    int calcDistance2(double degLAT1, double degLON1, double degLAT2, double degLON2)   //returns meters
    {
        //Spherical Law of Cosines

        double deg2rad = 0.0174532925199433;
        double rad2deg = 57.2957795130823;
        double ROPE = 6371000;
        double radLAT1, radLAT2;
        double deltaLONdeg, deltaLONrad;
        int d;

        radLAT1 = degLAT1 * deg2rad;
        radLAT2 = degLAT2 * deg2rad;


        deltaLONdeg = degLON2 - degLON1;
        deltaLONrad = deltaLONdeg * deg2rad;

        d = (int)(Math.acos(Math.sin(radLAT1) * Math.sin(radLAT2) + Math.cos(radLAT1) * Math.cos(radLAT2) * Math.cos(deltaLONrad)) * ROPE);

        return d;


    }

    public  String[] paylasim_getir(String konum_X, String konum_Y, String gonderen, int uzaklik) throws IOException, XmlPullParserException {

            String methName = "p_getir";
            SoapObject request = new SoapObject(NAMESPACE, methName);
            PropertyInfo paramPI = new PropertyInfo();



            //if(uzaklik.equals("100000"))

        if(uzaklik != 0)
            paramPI.setName("X");
            paramPI.setName("X");
            paramPI.setValue(konum_X);
            paramPI.setType(PropertyInfo.STRING_CLASS);
            request.addProperty(paramPI);


            paramPI = new PropertyInfo();
            paramPI.setName("Y");
            paramPI.setValue(konum_Y);
            paramPI.setType(PropertyInfo.STRING_CLASS);
            request.addProperty(paramPI);



        paramPI = new PropertyInfo();
        paramPI.setName("k");
        paramPI.setValue(gonderen);
        paramPI.setType(PropertyInfo.STRING_CLASS);
        request.addProperty(paramPI);

        paramPI = new PropertyInfo();
        paramPI.setName("u");
        paramPI.setValue(0);
        paramPI.setType(PropertyInfo.INTEGER_CLASS);
        request.addProperty(paramPI);





            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.dotNet = true;

            envelope.setOutputSoapObject(request);
            HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
        SoapPrimitive response = null;
        try {
            androidHttpTransport.call(SOAP_ACTION + methName, envelope);
            response = (SoapPrimitive) envelope.getResponse();
        }
        catch (Exception ex) {}

            //SoapObject result = (SoapObject) envelope.bodyIn;

            //String str = ((SoapObject)result.getProperty(0)).getProperty(1).toString();

            responseJSON = response.toString();
            //String _rt = gson.fromJson(responseJSON, String.class);




            String[] rt = responseJSON.split(";");
            String sonuc[] = new String[0];
        if(uzaklik != 0) {
            int index = -1;
            int uz;

            int v = rt.length / 11;
            for (int i = 0; i < v; i++) {
                uz = calcDistance2(Double.parseDouble(rt[11 * i + 6].replace(",", ".")), Double.parseDouble(rt[11 * i + 7].replace(",", ".")), Double.parseDouble(konum_X), Double.parseDouble(konum_Y));
                if (uz < uzaklik) {
                    sonuc = Arrays.copyOf(sonuc, sonuc.length + 11);
                    sonuc[++index] = rt[i * 11];
                    sonuc[++index] = rt[i * 11 + 1];
                    sonuc[++index] = rt[i * 11 + 2];
                    sonuc[++index] = rt[i * 11 + 3];
                    sonuc[++index] = rt[i * 11 + 4];
                    sonuc[++index] = rt[i * 11 + 5];
                    sonuc[++index] = rt[i * 11 + 6];
                    sonuc[++index] = rt[i * 11 + 7];
                    sonuc[++index] = rt[i * 11 + 8];
                    sonuc[++index] = rt[i * 11 + 9];
                    sonuc[++index] = rt[i * 11 + 10];
                }
            }
        }
        else
        {
            sonuc = rt;
        }
            return sonuc;



    }



    public  String resim_getir(String Paylasim_ID, String resim) throws IOException, XmlPullParserException {

        String methName = "resim_getir";
        SoapObject request = new SoapObject(NAMESPACE, methName);
        PropertyInfo paramPI = new PropertyInfo();
        //if(uzaklik.equals("100000"))
        paramPI.setName("Paylasim_ID");
        paramPI.setValue(Paylasim_ID);
        paramPI.setType(PropertyInfo.STRING_CLASS);
        request.addProperty(paramPI);


        paramPI = new PropertyInfo();
        paramPI.setName("resim");
        paramPI.setValue(resim);
        paramPI.setType(PropertyInfo.STRING_CLASS);
        request.addProperty(paramPI);


        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER11);
        envelope.dotNet = true;
        envelope.setOutputSoapObject(request);
        HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
        SoapPrimitive response = null;
        try {
            androidHttpTransport.call(SOAP_ACTION + methName, envelope);
            response = (SoapPrimitive) envelope.getResponse();
        }
        catch (Exception ex) {}

        //SoapObject result = (SoapObject) envelope.bodyIn;

        //String str = ((SoapObject)result.getProperty(0)).getProperty(1).toString();

        responseJSON = response.toString();
        //String _rt = gson.fromJson(responseJSON, String.class);



        return responseJSON.toString();



    }

    public  String[] yorum_getir(String Paylasim_ID) {
        try {
            //invokeJSONWS("","uye_ekle");
            String methName = "yorum_getir";
            SoapObject request = new SoapObject(NAMESPACE, methName);

            PropertyInfo paramPI = new PropertyInfo();
            paramPI.setName("Paylasim_ID");
            paramPI.setValue(Paylasim_ID);
            paramPI.setType(PropertyInfo.STRING_CLASS);
            request.addProperty(paramPI);

            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                    SoapEnvelope.VER11);
            envelope.dotNet = true;
            envelope.setOutputSoapObject(request);
            HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
            androidHttpTransport.call(SOAP_ACTION+methName, envelope);
            SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
            responseJSON = response.toString();



            return responseJSON.split(";");
        }
        catch (Exception ex)
        {
            String[] a = {ex.getMessage()};
            return a;
        }
    }

    public  String begen(String Paylasim_ID) {
        try {

            String methName = "begen";
            SoapObject request = new SoapObject(NAMESPACE, methName);
            PropertyInfo paramPI = new PropertyInfo();
            paramPI.setName("Paylasim_ID");
            paramPI.setValue(Paylasim_ID);
            paramPI.setType(PropertyInfo.STRING_CLASS);
            request.addProperty(paramPI);


            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                    SoapEnvelope.VER11);
            envelope.dotNet = true;
            envelope.setOutputSoapObject(request);
            HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
            androidHttpTransport.call(SOAP_ACTION+methName, envelope);
            SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
            responseJSON = response.toString();
            uyeekle = gson.fromJson(responseJSON, String.class);
            return uyeekle;
        }
        catch (Exception ex)
        {
            return ex.getMessage();
        }

    }




    public static String bitmapTOstring(Bitmap image) {
        Bitmap immagex=image;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        immagex.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] b = baos.toByteArray();
        String imageEncoded = Base64.encodeToString(b, Base64.DEFAULT);

        Log.e("LOOK", imageEncoded);
        return imageEncoded;
    }
    public static Bitmap stringTObitmap(String input){
        byte[] decodedByte = Base64.decode(input, 0);
        return BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
    }


}

