package com.example.justinbuhay.espntopnews;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.net.MalformedURLException;
import java.util.List;

/**
 * Created by justinbuhay on 7/24/17.
 */

public class MyAsyncTaskLoader extends android.support.v4.content.AsyncTaskLoader<List<ESPNArticle>> {


    public MyAsyncTaskLoader(Context context){
        super(context);
    }

    @Override
    public List<ESPNArticle> loadInBackground() {

        String json = NetworkUtils.fetchArticleData();


        return ParseJSON.makeESPNArticlesFromJSON(json);
    }
}
