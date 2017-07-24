package com.example.justinbuhay.espntopnews;

import android.content.Context;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by justinbuhay on 7/24/17.
 */

public class ESPNArticle {

    private String mArticleTitle;
    private String mArticleAuthor;
    private String mArticleDescription;
    private URL mImageURL;

    public ESPNArticle(String articleTitle, String articleAuthor, String articleDescription, URL imageURL){

        mArticleTitle = articleTitle;
        mArticleAuthor = articleAuthor;
        mArticleDescription = articleDescription;
        mImageURL = imageURL;

    }


    public static List<ESPNArticle> createArticles(int howMany, Context context){
        ArrayList<ESPNArticle> espnArticles = new ArrayList<ESPNArticle>();
        for(int i = 0; i < howMany; i++) {
            espnArticles.add(new ESPNArticle(context.getString(R.string.title_example), context.getString(R.string.author_example), context.getString(R.string.description_example), null));
        }
        return  espnArticles;
    }

    public String getmArticleTitle() {
        return mArticleTitle;
    }

    public String getmArticleAuthor() {
        return mArticleAuthor;
    }

    public String getmArticleDescription() {
        return mArticleDescription;
    }

    public URL getmImageURL() {
        return mImageURL;
    }
}
