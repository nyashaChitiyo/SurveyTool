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
 * Created by gifty on 1/24/18.
 */

public class MerchantBackend extends AsyncTask<String, Void, String> {

    Context context;
    AlertDialog alertDialog;

    MerchantBackend(Context ctx){ context = ctx; }

    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        String stocks_url = "http://saints.codel.co.zw/stocks.php";

        if(type.equals("openStock_warehouse, openStock, closingStock")){
            try {
                String et_wbrand = params[1];
                String et_wpacksize = params[2];
                String et_wquantitycounted = params[3];
                String et_wbreakages_brand = params[4];
                String et_wquantity_breakages = params[5];
                String et_brand = params[6];
                String et_packsize = params[7];
                String et_quantitycounted = params[8];
                String et_breakages_brand = params[9];
                String et_quantity_breakages = params[10];
                String et_cbrand = params[11];
                String et_cpacksize = params[12];
                String et_cquantitycounted = params[13];
                String et_sales = params[14];
                String et_cswarehouse = params[15];




                URL url = new URL(stocks_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("et_wbrand","UTF-8")+"="+URLEncoder.encode(et_wbrand,"UTF-8")+"&"
                        + URLEncoder.encode("et_wpacksize","UTF-8")+"="+URLEncoder.encode(et_wpacksize,"UTF-8")+"&"
                        + URLEncoder.encode("et_wquantitycounted","UTF-8")+"="+URLEncoder.encode(et_wquantitycounted,"UTF-8")+"&"
                        + URLEncoder.encode("et_wbreakages_brand","UTF-8")+"="+URLEncoder.encode(et_wbreakages_brand,"UTF-8")+"&"
                        + URLEncoder.encode("et_wquantity_breakages","UTF-8")+"="+URLEncoder.encode(et_wquantity_breakages,"UTF-8")+"&"
                        + URLEncoder.encode("et_brand","UTF-8")+"="+URLEncoder.encode(et_brand,"UTF-8")+"&"
                        + URLEncoder.encode("et_packsize","UTF-8")+"="+URLEncoder.encode(et_packsize,"UTF-8")+"&"
                        + URLEncoder.encode("et_quantitycounted","UTF-8")+"="+URLEncoder.encode(et_quantitycounted,"UTF-8")+"&"
                        + URLEncoder.encode("et_breakages_brand","UTF-8")+"="+URLEncoder.encode(et_breakages_brand,"UTF-8")+"&"
                        + URLEncoder.encode("et_quantity_breakages","UTF-8")+"="+URLEncoder.encode(et_quantity_breakages,"UTF-8")+"&"
                        + URLEncoder.encode("et_cbrand","UTF-8")+"="+URLEncoder.encode(et_cbrand,"UTF-8")+"&"
                        + URLEncoder.encode("et_cpacksize","UTF-8")+"="+URLEncoder.encode(et_cpacksize,"UTF-8")+"&"
                        + URLEncoder.encode("et_cquantitycounted","UTF-8")+"="+URLEncoder.encode(et_cquantitycounted,"UTF-8")+"&"
                        + URLEncoder.encode("et_sales","UTF-8")+"="+URLEncoder.encode(et_sales,"UTF-8")+"&"
                        + URLEncoder.encode("et_cswarehouse","UTF-8")+"="+URLEncoder.encode(et_cswarehouse,"UTF-8");
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
