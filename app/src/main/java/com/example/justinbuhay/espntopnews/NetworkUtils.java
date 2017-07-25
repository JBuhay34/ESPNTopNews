package com.example.justinbuhay.espntopnews;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by justinbuhay on 7/24/17.
 */

public class NetworkUtils {

    private static String LOG_TAG = "NetworkUtils";

    //"https://newsapi.org/v1/articles?source=espn&sortBy=top&apiKey=c7fb926751964ccc90f758f027682a2f"

    public static String fetchArticleData(String api_String){

        String jsonParsed = "";

        URL newURL = convertToURL(api_String);

        if(newURL != null){

            Log.i(LOG_TAG, "" + newURL);
            jsonParsed = makeHTTPURLConnection(newURL);


        }

        return jsonParsed;



    }


    private static String makeHTTPURLConnection(URL url){

        HttpURLConnection connection = null;
        String jsonParsed = null;

        try{
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            jsonParsed = makeStreamConverter(connection);


        } catch(IOException e){
            Log.e(LOG_TAG, "Unable to make connection to URL");
        } finally {
            connection.disconnect();
        }

        return jsonParsed;


    }

    private static String makeStreamConverter(HttpURLConnection connection) throws IOException{
        InputStreamReader streamReader = new InputStreamReader(connection.getInputStream());
        String tempString;

        BufferedReader reader = new BufferedReader(streamReader);
        StringBuilder builder = new StringBuilder();

        while((tempString = reader.readLine()) != null){
            builder.append(tempString);
        }

        return builder.toString();

    }



    private static URL convertToURL(String api_String){

        try {
            URL newURL = new URL(api_String);
            return newURL;
        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, "Unable to convert the string to a URL");
        }
        return null;

    }

}
