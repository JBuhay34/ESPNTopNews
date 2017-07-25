package com.example.justinbuhay.espntopnews;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by justinbuhay on 7/24/17.
 */

public class ParseJSON {

    public static List<ESPNArticle> makeESPNArticlesFromJSON(String jsonString){

        ArrayList<ESPNArticle> articlesList = new ArrayList<ESPNArticle>();

        try {
            JSONObject rootObject = new JSONObject(jsonString);
            JSONArray articlesArray = rootObject.getJSONArray("articles");

            for(int i = 0; i < articlesArray.length(); i++){
                JSONObject theObjects = articlesArray.getJSONObject(i);

                String title = theObjects.getString("title");
                String author = theObjects.getString("author");
                String description = theObjects.getString("description");
                String url = theObjects.getString("url");
                String imageURL = theObjects.getString("urlToImage");
                String timePublished = theObjects.getString("publishedAt");

                articlesList.add(new ESPNArticle(title, author, description, imageURL, timePublished, url));

            }


        } catch(JSONException e){
            Log.e("ParseJSON", "Unable to make JSON Objects");
        }

        return articlesList;

    }
}
