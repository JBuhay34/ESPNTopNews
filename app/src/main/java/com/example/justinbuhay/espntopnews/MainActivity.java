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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);


        List<ESPNArticle> espnArticles = ESPNArticle.createArticles(20, this);
        mAdapter = new ESPNNewsRecyclerViewAdapter(this, espnArticles);

        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));


        // Test Run
        MyAsyncTask myAsyncTask = new MyAsyncTask();
        try {
            myAsyncTask.execute(new URL(NetworkUtils.api_String));
        } catch (MalformedURLException e){
            Log.e(this.getClass().getSimpleName(), "Unable to make URL");
        }


    }

}
