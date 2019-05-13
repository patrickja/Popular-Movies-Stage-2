package com.example.android.popularmovieappstagetwo.Utilities;

import com.example.android.popularmovieappstagetwo.Models.Movie;
import com.example.android.popularmovieappstagetwo.Models.Review;
import com.example.android.popularmovieappstagetwo.Models.Trailer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {

    public static ArrayList<Movie> parseMoviesJson(String json) {
        try {

            Movie movie;
            JSONObject json_object = new JSONObject(json);

            JSONArray resultsArray = new JSONArray(json_object.optString("results","[\"\"]"));

            ArrayList<Movie> movieitems = new ArrayList<>();
            for (int i = 0; i < resultsArray.length(); i++) {
                String thisitem = resultsArray.optString(i, "");
                JSONObject movieJson = new JSONObject(thisitem);

                movie = new Movie(
                        movieJson.optString("id","Not Available"),
                        movieJson.optString("original_title","Not Available"),
                        movieJson.optString("release_date","Not Available"),
                        movieJson.optString("vote_average","Not Available"),
                        movieJson.optString("popularity","Not Available"),
                        movieJson.optString("overview","Not Available"),
                        movieJson.optString("poster_path","Not Available"),
                        movieJson.optString("backdrop_path","Not Available")
                );

                movieitems.add(movie);
            }

            return movieitems;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;

    }

    public static ArrayList<Review> parseReviewsJson(String json) {
        try {

            Review review;
            JSONObject json_object = new JSONObject(json);

            JSONArray resultsArray = new JSONArray(json_object.optString("results","[\"\"]"));

            ArrayList<Review> reviewitems = new ArrayList<>();
            for (int i = 0; i < resultsArray.length(); i++) {
                String thisitem = resultsArray.optString(i, "");
                JSONObject movieJson = new JSONObject(thisitem);

                review = new Review(
                        movieJson.optString("author","Not Available"),
                        movieJson.optString("content","Not Available"),
                        movieJson.optString("id","Not Available"),
                        movieJson.optString("url","Not Available")
                );

                reviewitems.add(review);
            }

            return reviewitems;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;

    }

    public static ArrayList<Trailer> parseTrailersJson(String json) {
        try {
            Trailer trailer;
            JSONObject json_object = new JSONObject(json);
            JSONArray resultsArray = new JSONArray(json_object.optString("results","[\"\"]"));

            ArrayList<Trailer> traileritems = new ArrayList<>();
            for (int i = 0; i < resultsArray.length(); i++) {
                String thisitem = resultsArray.optString(i, "");
                JSONObject movieJson = new JSONObject(thisitem);

                trailer = new Trailer(
                        movieJson.optString("name","Not Available"),
                        movieJson.optString("site","Not Available"),
                        movieJson.optString("key","Not Available")
                );

                traileritems.add(trailer);
            }
            return traileritems;

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}