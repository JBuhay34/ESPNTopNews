package com.example.justinbuhay.espntopnews;

import android.os.AsyncTask;
import android.util.Log;

import java.net.URL;

/**
 * Created by justinbuhay on 7/24/17.
 */

public class MyAsyncTask extends AsyncTask<URL, Void, String> {

    @Override
    protected String doInBackground(URL... urls) {
        return NetworkUtils.fetchArticleData();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        Log.i("Let's see", s);
    }
}
