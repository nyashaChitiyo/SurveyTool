package com.example.gifty.surveytool;

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
 * Created by gifty on 12/28/17.
 */

public class RetailBackend extends AsyncTask<String, Void, String> {

    Context context;
    AlertDialog alertDialog;

    RetailBackend(Context ctx){context = ctx;}

    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        String retaildata_url = "http://saints.codel.co.zw/retaildataconnect.php";

        if (type.equals("retaildata")){
            try{
                String etprojectname = params[1];
                String etfullname = params[2];
                String etphonenumber = params[3];
                String etemailentry = params[4];
                String etclient = params[5];
                String etba = params[6];
                String etwbrand = params[7];
                String etwpacksize = params[8];
                String etwquantitycounted = params[9];
                String etwbreakages_brand = params[10];
                String etwquantity_breakages = params[11];
                String etbrand = params[12];
                String etpacksize = params[13];
                String etquantitycounted = params[14];
                String driverlicense = params[15];
                String etbreakages_brand = params[16];
                String etquantity_breakages = params[17];
                String etcbrand = params[18];
                String etcpacksize = params[19];
                String etcquantitycounted = params[20];
                String etsales = params[21];
                String etcswarehouse = params[22];
                String etshelfpercentages = params[23];
                String etcompetitorprice = params[24];
                String etownskuprice = params[25];
                String etcompetitorposm = params[26];
                String etownposm = params[27];
                String etcompetitorspecials = params[28];
                String etsampling = params[29];
                String etgiveaways = params[30];
                String ettillpoints = params[31];
                String ettrolleys = params[32];
                String etbaskets = params[32];
                String etfullname2 = params[33];
                String etphonenumber2 = params[34];
                String etemail = params[35];
                String etfacebook = params[36];
                String ettwitter = params[37];
                String etrphonenumber2 = params[38];
                String etreceiptnumber = params[39];
                String etaddress = params[40];


                URL url = new URL(retaildata_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("etprojectname","UTF-8")+"="+URLEncoder.encode(etprojectname,"UTF-8")+"&"
                        + URLEncoder.encode("etfullname","UTF-8")+"="+URLEncoder.encode(etfullname,"UTF-8")+"&"
                        + URLEncoder.encode("etphonenumber","UTF-8")+"="+URLEncoder.encode(etphonenumber,"UTF-8")+"&"
                        + URLEncoder.encode("etemailentry","UTF-8")+"="+URLEncoder.encode(etemailentry,"UTF-8")+"&"
                        + URLEncoder.encode("etclient","UTF-8")+"="+URLEncoder.encode(etclient,"UTF-8")+"&"
                        + URLEncoder.encode("etba","UTF-8")+"="+URLEncoder.encode(etba,"UTF-8")+"&"
                        + URLEncoder.encode("etwbrand","UTF-8")+"="+URLEncoder.encode(etwbrand,"UTF-8")+"&"
                        + URLEncoder.encode("etwpacksize","UTF-8")+"="+URLEncoder.encode(etwpacksize,"UTF-8")+"&"
                        + URLEncoder.encode("etwquantitycounted","UTF-8")+"="+URLEncoder.encode(etwquantitycounted,"UTF-8")+"&"
                        + URLEncoder.encode("etwbreakages_brand","UTF-8")+"="+URLEncoder.encode(etwbreakages_brand,"UTF-8")+"&"
                        + URLEncoder.encode("etwquantity_breakages","UTF-8")+"="+URLEncoder.encode(etwquantity_breakages,"UTF-8")+"&"
                        + URLEncoder.encode("etbrand","UTF-8")+"="+URLEncoder.encode(etbrand,"UTF-8")+"&"
                        + URLEncoder.encode("etpacksize","UTF-8")+"="+URLEncoder.encode(etpacksize,"UTF-8")+"&"
                        + URLEncoder.encode("etquantitycounted","UTF-8")+"="+URLEncoder.encode(etquantitycounted,"UTF-8")+"&"
                        + URLEncoder.encode("etbreakages_brand","UTF-8")+"="+URLEncoder.encode(etbreakages_brand,"UTF-8")+"&"
                        + URLEncoder.encode("etquantity_breakages","UTF-8")+"="+URLEncoder.encode(etquantity_breakages,"UTF-8")+"&"
                        + URLEncoder.encode("etcbrand","UTF-8")+"="+URLEncoder.encode(etcbrand,"UTF-8")+"&"
                        + URLEncoder.encode("etcpacksize","UTF-8")+"="+URLEncoder.encode(etcpacksize,"UTF-8")+"&"
                        + URLEncoder.encode("etcquantitycounted","UTF-8")+"="+URLEncoder.encode(etcquantitycounted,"UTF-8")+"&"
                        + URLEncoder.encode("etsales","UTF-8")+"="+URLEncoder.encode(etsales,"UTF-8")+"&"
                        + URLEncoder.encode("etcswarehouse","UTF-8")+"="+URLEncoder.encode(etcswarehouse,"UTF-8")+"&"
                        + URLEncoder.encode("etshelfpercentages","UTF-8")+"="+URLEncoder.encode(etshelfpercentages,"UTF-8")+"&"
                        + URLEncoder.encode("etcompetitorprice","UTF-8")+"="+URLEncoder.encode(etcompetitorprice,"UTF-8")+"&"
                        + URLEncoder.encode("etownskuprice","UTF-8")+"="+URLEncoder.encode(etownskuprice,"UTF-8")+"&"
                        + URLEncoder.encode("etcompetitorposm","UTF-8")+"="+URLEncoder.encode(etcompetitorposm,"UTF-8")+"&"
                        + URLEncoder.encode("etownposm","UTF-8")+"="+URLEncoder.encode(etownposm,"UTF-8")+"&"
                        + URLEncoder.encode("etcompetitorspecials","UTF-8")+"="+URLEncoder.encode(etcompetitorspecials,"UTF-8")+"&"
                        + URLEncoder.encode("etsampling","UTF-8")+"="+URLEncoder.encode(etsampling,"UTF-8")+"&"
                        + URLEncoder.encode("etgiveaways","UTF-8")+"="+URLEncoder.encode(etgiveaways,"UTF-8")+"&"
                        + URLEncoder.encode("ettillpoints","UTF-8")+"="+URLEncoder.encode(ettillpoints,"UTF-8")+"&"
                        + URLEncoder.encode("ettrolleys","UTF-8")+"="+URLEncoder.encode(ettrolleys,"UTF-8")+"&"
                        + URLEncoder.encode("etbaskets","UTF-8")+"="+URLEncoder.encode(etbaskets,"UTF-8")+"&"
                        + URLEncoder.encode("etfullname2","UTF-8")+"="+URLEncoder.encode(etfullname2,"UTF-8")+"&"
                        + URLEncoder.encode("etphonenumber2","UTF-8")+"="+URLEncoder.encode(etphonenumber2,"UTF-8")+"&"
                        + URLEncoder.encode("etemail","UTF-8")+"="+URLEncoder.encode(etemail,"UTF-8")+"&"
                        + URLEncoder.encode("etfacebook","UTF-8")+"="+URLEncoder.encode(etfacebook,"UTF-8")+"&"
                        + URLEncoder.encode("ettwitter","UTF-8")+"="+URLEncoder.encode(ettwitter,"UTF-8")+"&"
                        + URLEncoder.encode("etrphonenumber2","UTF-8")+"="+URLEncoder.encode(etrphonenumber2,"UTF-8")+"&"
                        + URLEncoder.encode("etreceiptnumber","UTF-8")+"="+URLEncoder.encode(etreceiptnumber,"UTF-8")+"&"
                        + URLEncoder.encode("etaddress","UTF-8")+"="+URLEncoder.encode(etaddress,"UTF-8");
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

            } catch (IOException e){
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
