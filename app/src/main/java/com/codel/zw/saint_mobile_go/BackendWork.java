package com.codel.zw.saint_mobile_go;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by gifty on 12/11/17.
 */

public class BackendWork extends AsyncTask<String, Void, String>{

    Context context;
    AlertDialog alertDialog;

    BackendWork(Context ctx){
        context = ctx;
    }

    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        String kycdata_url = "http://saints.codel.co.zw/kycdata.php";
        //String merchantdata_url = "http://saints.codel.co.zw/merchantRegister.php";

        if(type.equals("kycdata")){
            try {
                String firstname = params[1];
                String lastname = params[2];
                String dob = params[3];
                String personalphone = params[4];
                String homephone = params[5];
                String workphone = params[6];
                String email = params[7];
                String facebook = params[8];
                String twitter = params[9];
                String whatsapp = params[10];
                String instagram = params[11];
                String workaddress = params[12];
                String idnumber = params[13];
                String passport = params[14];
                String driverlicense = params[15];
                String nationality = params[16];
                String hobies = params[17];
                String fhobies = params[18];
                String fvisitedmalls = params[19];
                String leisuretime = params[20];
                String numberofchildren = params[21];
                String males = params[22];
                String females = params[23];
                String childreninhouse = params[24];
                String childrenunder18 = params[25];
                String rentcost = params[26];
                String utilities = params[27];
                String foodgrocery = params[28];
                String educationcost = params[29];
                String transport = params[30];
                String savings = params[31];
                String houses = params[32];
                String vehicle = params[33];
                String furniture = params[34];
                String land = params[35];
                String homeaddress = params[36];


                URL url = new URL(kycdata_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("firstname","UTF-8")+"="+URLEncoder.encode(firstname,"UTF-8")+"&"
                        + URLEncoder.encode("lastname","UTF-8")+"="+URLEncoder.encode(lastname,"UTF-8")+"&"
                        + URLEncoder.encode("dob","UTF-8")+"="+URLEncoder.encode(dob,"UTF-8")+"&"
                        + URLEncoder.encode("personalphone","UTF-8")+"="+URLEncoder.encode(personalphone,"UTF-8")+"&"
                        + URLEncoder.encode("homephone","UTF-8")+"="+URLEncoder.encode(homephone,"UTF-8")+"&"
                        + URLEncoder.encode("workphone","UTF-8")+"="+URLEncoder.encode(workphone,"UTF-8")+"&"
                        + URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(email,"UTF-8")+"&"
                        + URLEncoder.encode("facebook","UTF-8")+"="+URLEncoder.encode(facebook,"UTF-8")+"&"
                        + URLEncoder.encode("twitter","UTF-8")+"="+URLEncoder.encode(twitter,"UTF-8")+"&"
                        + URLEncoder.encode("whatsapp","UTF-8")+"="+URLEncoder.encode(whatsapp,"UTF-8")+"&"
                        + URLEncoder.encode("instagram","UTF-8")+"="+URLEncoder.encode(instagram,"UTF-8")+"&"
                        + URLEncoder.encode("homeaddress","UTF-8")+"="+URLEncoder.encode(homeaddress,"UTF-8")+"&"
                        + URLEncoder.encode("workaddress","UTF-8")+"="+URLEncoder.encode(workaddress,"UTF-8")+"&"
                        + URLEncoder.encode("idnumber","UTF-8")+"="+URLEncoder.encode(idnumber,"UTF-8")+"&"
                        + URLEncoder.encode("passport","UTF-8")+"="+URLEncoder.encode(passport,"UTF-8")+"&"
                        + URLEncoder.encode("driverlicense","UTF-8")+"="+URLEncoder.encode(driverlicense,"UTF-8")+"&"
                        + URLEncoder.encode("nationality","UTF-8")+"="+URLEncoder.encode(nationality,"UTF-8")+"&"
                        + URLEncoder.encode("hobies","UTF-8")+"="+URLEncoder.encode(hobies,"UTF-8")+"&"
                        + URLEncoder.encode("fhobies","UTF-8")+"="+URLEncoder.encode(fhobies,"UTF-8")+"&"
                        + URLEncoder.encode("fvisitedmalls","UTF-8")+"="+URLEncoder.encode(fvisitedmalls,"UTF-8")+"&"
                        + URLEncoder.encode("leisuretime","UTF-8")+"="+URLEncoder.encode(leisuretime,"UTF-8")+"&"
                        + URLEncoder.encode("numberofchildren","UTF-8")+"="+URLEncoder.encode(numberofchildren,"UTF-8")+"&"
                        + URLEncoder.encode("males","UTF-8")+"="+URLEncoder.encode(males,"UTF-8")+"&"
                        + URLEncoder.encode("females","UTF-8")+"="+URLEncoder.encode(females,"UTF-8")+"&"
                        + URLEncoder.encode("childreninhouse","UTF-8")+"="+URLEncoder.encode(childreninhouse,"UTF-8")+"&"
                        + URLEncoder.encode("childrenunder18","UTF-8")+"="+URLEncoder.encode(childrenunder18,"UTF-8")+"&"
                        + URLEncoder.encode("rentcost","UTF-8")+"="+URLEncoder.encode(rentcost,"UTF-8")+"&"
                        + URLEncoder.encode("utilities","UTF-8")+"="+URLEncoder.encode(utilities,"UTF-8")+"&"
                        + URLEncoder.encode("foodgrocery","UTF-8")+"="+URLEncoder.encode(foodgrocery,"UTF-8")+"&"
                        + URLEncoder.encode("educationcost","UTF-8")+"="+URLEncoder.encode(educationcost,"UTF-8")+"&"
                        + URLEncoder.encode("transport","UTF-8")+"="+URLEncoder.encode(transport,"UTF-8")+"&"
                        + URLEncoder.encode("savings","UTF-8")+"="+URLEncoder.encode(savings,"UTF-8")+"&"
                        + URLEncoder.encode("houses","UTF-8")+"="+URLEncoder.encode(houses,"UTF-8")+"&"
                        + URLEncoder.encode("vehicle","UTF-8")+"="+URLEncoder.encode(vehicle,"UTF-8")+"&"
                        + URLEncoder.encode("furniture","UTF-8")+"="+URLEncoder.encode(furniture,"UTF-8")+"&"
                        + URLEncoder.encode("land","UTF-8")+"="+URLEncoder.encode(land,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result="";
                String line="";
                while((line = bufferedReader.readLine())!=null){
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;


            } catch (MalformedURLException e){
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Upload Status");
    }

    @Override
    protected void onPostExecute(String result) {
        alertDialog.setMessage(result);
        alertDialog.show();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
