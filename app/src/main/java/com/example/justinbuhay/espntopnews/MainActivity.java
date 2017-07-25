package com.example.justinbuhay.espntopnews;

import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderCallbacks<List<ESPNArticle>>{


    private ESPNNewsRecyclerViewAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private ProgressBar mProgressBar;

    private static final int LOADER_MANAGER_ID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false));

        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);

        mProgressBar.setVisibility(View.VISIBLE);

        getSupportLoaderManager().initLoader(LOADER_MANAGER_ID, null, this).forceLoad();


    }

    @Override
    public Loader<List<ESPNArticle>> onCreateLoader(int id, Bundle args) {
        if(id == LOADER_MANAGER_ID) {
            Loader asyncTaskLoader = new MyAsyncTaskLoader(MainActivity.this);
            return asyncTaskLoader;
        }
        else{
            return null;
        }
    }

    @Override
    public void onLoadFinished(Loader<List<ESPNArticle>> loader, List<ESPNArticle> data) {

        mProgressBar.setVisibility(View.GONE);

        mAdapter = new ESPNNewsRecyclerViewAdapter(MainActivity.this, data);

        mRecyclerView.setAdapter(mAdapter);


    }

    @Override
    public void onLoaderReset(Loader<List<ESPNArticle>> loader) {


    }


}
