package com.example.admin.jsonrecyclerview;

import android.os.AsyncTask;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class fetchData extends AsyncTask<String, Void, List<User>> {
    String data = "";
    List<User> list = new ArrayList<>();
    private PassData passData;
    private ParseJsonToObject mParseJsonToObject;

    public fetchData(PassData passData) {
        this.passData = passData;
        mParseJsonToObject = new ParseJsonToObject();
    }

    @Override
    protected List<User> doInBackground(String... strings) {

        try {
            URL url = new URL("https://api.github.com/users");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while (line != null) {
                line = bufferedReader.readLine();
                data = data + line;
            }
            httpURLConnection.disconnect();
            try {

                list = mParseJsonToObject.pareJsonToObject(data);
            } catch (JSONException e) {
                e.printStackTrace();
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    protected void onPostExecute(List<User> s) {
        super.onPostExecute(s);
        passData.result(s);
    }


    //    public void setPassData(PassData passData) {
//        this.passData = passData;
//    }
}