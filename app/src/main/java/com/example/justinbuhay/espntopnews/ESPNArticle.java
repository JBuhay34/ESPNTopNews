package com.example.justinbuhay.espntopnews;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
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
    private Bitmap mImageURL;
    private String mTimePublished;
    private URL mURL;

    public ESPNArticle(String articleTitle, String articleAuthor, String articleDescription, String imageURL, String timePublished, String url){

        mArticleTitle = articleTitle;
        mArticleAuthor = articleAuthor;
        mArticleDescription = articleDescription;
        mTimePublished = timePublished;
        try{
            try{
                mImageURL = BitmapFactory.decodeStream((InputStream)new URL(imageURL).getContent());
            } catch (IOException e){
                Log.e("ESPNNewsRecyclerView", "Unable to make bitmap");
            }
            mURL = new URL(url);

        } catch (MalformedURLException e){
            Log.e("ESPNArticle", "Unable to make URL from image and the website");
        }

    }

    /*
    // Creates Fake Data
    public static List<ESPNArticle> createArticles(int howMany, Context context){
        ArrayList<ESPNArticle> espnArticles = new ArrayList<ESPNArticle>();
        for(int i = 0; i < howMany; i++) {
            espnArticles.add(new ESPNArticle(context.getString(R.string.title_example), context.getString(R.string.author_example), context.getString(R.string.description_example), null));
        }
        return  espnArticles;
    }
    */

    public String getmArticleTitle() {
        return mArticleTitle;
    }

    public String getmArticleAuthor() {
        return mArticleAuthor;
    }

    public String getmArticleDescription() {
        return mArticleDescription;
    }

    public Bitmap getmImageURL() {
        return mImageURL;
    }

    public String getmTimePublished() {
        return mTimePublished;
    }

    public URL getmURL() {
        return mURL;
    }
}
