package com.example.hp.women_security;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.Snackbar;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by suraj on 04-10-2017.
 */
public class getdataonline extends AsyncTask<Void,Void,String> {
    String get_url;
    String user_data;
    @Override
    protected void onPreExecute() {
        get_url="https://www.piettechies.com/android/view_data.php";
        System.out.println(get_url);
    }

    @Override
    protected String doInBackground(Void... voids) {
        try {
            URL url = new URL(get_url);

            HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
            InputStream inputStream=httpURLConnection.getInputStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder=new StringBuilder();
            while ((user_data=bufferedReader.readLine())!=null){
                stringBuilder.append(user_data+"\n");
                System.out.println(user_data+"\n");
            }
            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();
            return stringBuilder.toString().trim();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String data) {
        try{
            JSONObject jsonObject=new JSONObject(data);
            JSONArray jsonArray=jsonObject.getJSONArray("result");
            int count=0;
            String Named,Phoned,Emaild,Passd;
            while (count<jsonArray.length()){
                JSONObject JO=jsonArray.getJSONObject(0);
                Named=JO.getString("Name");
                Emaild=JO.getString("Email");
                Phoned=JO.getString("Phone");
                Passd=JO.getString("Pass");
            }
        }catch (Exception e){

        }
    }


}
