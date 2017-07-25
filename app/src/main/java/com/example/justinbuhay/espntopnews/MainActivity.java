package com.example.justinbuhay.espntopnews;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderCallbacks<List<ESPNArticle>>, NavigationView.OnNavigationItemSelectedListener {


    private static final int LOADER_MANAGER_ID = 1;
    private ESPNNewsRecyclerViewAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private ProgressBar mProgressBar;
    private DrawerLayout mDrawerLayout;
    private MyAsyncTaskLoader asyncTaskLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        // The top left navigation view
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false));

        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);

        mProgressBar.setVisibility(View.VISIBLE);

        asyncTaskLoader = new MyAsyncTaskLoader(MainActivity.this, "espn");

        getSupportLoaderManager().initLoader(LOADER_MANAGER_ID, null, this).forceLoad();

        NavigationView navigationView = (NavigationView) findViewById(R.id.navView);
        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public Loader<List<ESPNArticle>> onCreateLoader(int id, Bundle args) {
        if(id == LOADER_MANAGER_ID) {
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


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.abc_news) {
            asyncTaskLoader.setmNews("abc-news-au");
        } else if (id == R.id.bbc_news) {
            asyncTaskLoader.setmNews("bbc-news");
        } else if (id == R.id.google_news) {
            asyncTaskLoader.setmNews("google-news");
        } else if (id == R.id.espn) {
            asyncTaskLoader.setmNews("espn");
        } else if (id == R.id.google_news) {
            asyncTaskLoader.setmNews("google-news");
        } else if (id == R.id.ign) {
            asyncTaskLoader.setmNews("ign");
        } else if (id == R.id.buzzfeed) {
            asyncTaskLoader.setmNews("buzzfeed");

        }

        mProgressBar.setVisibility(View.VISIBLE);
        getSupportLoaderManager().initLoader(LOADER_MANAGER_ID, null, this).forceLoad();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
