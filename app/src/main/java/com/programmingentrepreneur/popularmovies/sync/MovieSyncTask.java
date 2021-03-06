//package com.programmingentrepreneur.popularmovies.sync;
//
//import android.content.ContentResolver;
//import android.content.ContentValues;
//import android.content.Context;
//
//import com.programmingentrepreneur.popularmovies.R;
//import com.programmingentrepreneur.popularmovies.utilities.NetworkUtils;
//
//import java.net.URL;
//
///**
// * Created by phili on 5/10/2017.
// */
//
//public class MovieSyncTask {
//
//    /**
//     * Performs the network request for updated weather, parses the JSON from that request, and
//     * inserts the new weather information into our ContentProvider. Will notify the user that new
//     * weather has been loaded if the user hasn't been notified of the weather within the last day
//     * AND they haven't disabled notifications in the preferences screen.
//     *
//     * @param context Used to access utility methods and the ContentResolver
//     */
//    synchronized public static void syncMovies(Context context) {
//
//
//        try {
//            /*
//             * The getUrl method will return the URL that we need to get the forecast JSON for the
//             * weather. It will decide whether to create a URL based off of the latitude and
//             * longitude or off of a simple location as a String.
//             */
//            URL movieRequestUrl = NetworkUtils.buildMovieUrl(context.getString(R.string.tmdb_api_key), );
//
//            /* Use the URL to retrieve the JSON */
//            String jsonWeatherResponse = NetworkUtils.getResponseFromHttpUrl(weatherRequestUrl);
//
//            /* Parse the JSON into a list of weather values */
//            ContentValues[] weatherValues = OpenWeatherJsonUtils
//                    .getWeatherContentValuesFromJson(context, jsonWeatherResponse);
//
//            /*
//             * In cases where our JSON contained an error code, getWeatherContentValuesFromJson
//             * would have returned null. We need to check for those cases here to prevent any
//             * NullPointerExceptions being thrown. We also have no reason to insert fresh data if
//             * there isn't any to insert.
//             */
//            if (weatherValues != null && weatherValues.length != 0) {
//                /* Get a handle on the ContentResolver to delete and insert data */
//                ContentResolver sunshineContentResolver = context.getContentResolver();
//
//                /* Delete old weather data because we don't need to keep multiple days' data */
//                sunshineContentResolver.delete(
//                        WeatherContract.WeatherEntry.CONTENT_URI,
//                        null,
//                        null);
//
//                /* Insert our new weather data into Sunshine's ContentProvider */
//                sunshineContentResolver.bulkInsert(
//                        WeatherContract.WeatherEntry.CONTENT_URI,
//                        weatherValues);
//            }
//
//            /* If the code reaches this point, we have successfully performed our sync */
//
//        } catch (Exception e) {
//            /* Server probably invalid */
//            e.printStackTrace();
//        }
//    }
//}
