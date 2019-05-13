package com.example.android.popularmovieappstagetwo.Utilities;

import android.net.Uri;

import com.example.android.popularmovieappstagetwo.Models.Constants;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import static com.example.android.popularmovieappstagetwo.Models.Constants.BASE_URL;
import static com.example.android.popularmovieappstagetwo.Models.Constants.MOVIEDB_BASE_URL;
import static com.example.android.popularmovieappstagetwo.Models.Constants.PARAM_API_KEY;

public class NetworkUtils {

    public static URL buildUrl(String movieSearchQuery, String apiKey) {

        Uri builtUri = Uri.parse(MOVIEDB_BASE_URL).buildUpon()
                .appendEncodedPath(movieSearchQuery)
                .appendQueryParameter(PARAM_API_KEY,apiKey)
                .build();

        URL url = null;
        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return url;
    }

    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }

    public static String buildPosterUrl(String poster) {
        String finalPath = BASE_URL + Constants.WIDTH + "/" + poster;
        return finalPath;
    }
}
