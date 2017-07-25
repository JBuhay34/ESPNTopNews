package com.example.justinbuhay.espntopnews;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private ESPNNewsRecyclerViewAdapter mAdapter;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);


        MyAsyncTask myAsyncTask = new MyAsyncTask();
        try {
            myAsyncTask.execute(new URL(NetworkUtils.api_String));
        } catch (MalformedURLException e){
            Log.e(this.getClass().getSimpleName(), "Unable to make URL");
        }


    }


    public class MyAsyncTask extends AsyncTask<URL, Void, List<ESPNArticle>> {


        @Override
        protected List<ESPNArticle> doInBackground(URL... urls) {
            String json = NetworkUtils.fetchArticleData();

            return ParseJSON.makeESPNArticlesFromJSON(json);
        }

        @Override
        protected void onPostExecute(List<ESPNArticle> espnArticles) {
            super.onPostExecute(espnArticles);

            mAdapter = new ESPNNewsRecyclerViewAdapter(MainActivity.this, espnArticles);

            mRecyclerView.setAdapter(mAdapter);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false));

        }
    }

}
