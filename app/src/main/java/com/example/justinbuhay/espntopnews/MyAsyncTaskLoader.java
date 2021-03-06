package com.example.justinbuhay.espntopnews;

import android.content.Context;
import android.net.Uri;
import android.util.Log;

import java.util.List;

/**
 * Created by justinbuhay on 7/24/17.
 */

public class MyAsyncTaskLoader extends android.support.v4.content.AsyncTaskLoader<List<ESPNArticle>> {

    private String mNews;


    public MyAsyncTaskLoader(Context context, String news) {
        super(context);

        mNews = news;

    }

    public void setmNews(String mNews) {
        this.mNews = mNews;
    }

    @Override
    public List<ESPNArticle> loadInBackground() {

        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https")
                .authority("newsapi.org")
                .appendPath("v1")
                .appendPath("articles")
                .appendQueryParameter("source", mNews)
                .appendQueryParameter("sortby", "top")
                .appendQueryParameter("apiKey", "c7fb926751964ccc90f758f027682a2f");

        Log.i("NetworkUtils1", builder.toString());


        String json = NetworkUtils.fetchArticleData(builder.toString());


        return ParseJSON.makeESPNArticlesFromJSON(json);
    }
}
