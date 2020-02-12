package com.example.watchablesbreda;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Scanner;

public class WatchablesCollector extends AsyncTask<String, Void, String> {

    private static final String TAG = WatchablesCollector.class.getSimpleName();
    private OnRandomWatchableListener listener;

    public WatchablesCollector(OnRandomWatchableListener listener) {
        this.listener = listener;
    }

    @Override
    protected String doInBackground(String... input) {
        //To make sure the asynctask is called
        Log.d(TAG, "doInBackground was called");

        //Get the first input which would be the static string
        String mArtworksUrl = input[0];

        Log.d(TAG, "Request to URL " + mArtworksUrl);
        String response = null;
        HttpURLConnection httpURLConnection = null;

        try {
            URL mUrl = new URL(mArtworksUrl);
            URLConnection mConnection = mUrl.openConnection();

            httpURLConnection = (HttpURLConnection) mConnection;
            httpURLConnection.setRequestMethod("GET");

            httpURLConnection.connect();

            int responseCode = httpURLConnection.getResponseCode();
            if(responseCode != HttpURLConnection.HTTP_OK){
                Log.e(TAG, "Aanroep naar de server is mislukt!");
            } else {
                InputStream in = httpURLConnection.getInputStream();

                Scanner scanner = new Scanner(in);
                scanner.useDelimiter("\\A");

                boolean hasInput = scanner.hasNext();
                if (hasInput) {
                    response = scanner.next();
                }
            }
            Log.d(TAG, response);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(httpURLConnection != null)
                httpURLConnection.disconnect();
        }

        return response;
    }

    @Override
    protected void onPostExecute(String response) {
        super.onPostExecute(response);
        Log.d(TAG, "onPostExecute was called");

        ArrayList<Watchable> mWatchablesList = new ArrayList<>();

        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray results = jsonObject.getJSONArray("keyValuePairs");

            for(int i = 0; i < results.length(); i++) {
                JSONObject fullArtwork = results.getJSONObject(i);
                JSONObject artworkFeatures = fullArtwork.getJSONObject("features");

                String artworkId = artworkFeatures.getJSONObject("features").getString("OBJECTID");
                String artworkTitle = artworkFeatures.getJSONObject("features").getString("AANDUIDINGOBJECT");
                String artworkLocation = artworkFeatures.getJSONObject("features").getString("GEOGRAFISCHELIGGING");
                String artworkArtist = artworkFeatures.getJSONObject("features").getString("KUNSTENAAR");
                String artworkMaterial = artworkFeatures.getJSONObject("features").getString("MATERIAAL");
                String artworkDescription = artworkFeatures.getJSONObject("features").getString("OMSCHRIJVING");
                String artworkPlacementDate = artworkFeatures.getJSONObject("features").getString("PLAATSINGSDATUM");
                String artworkImage = artworkFeatures.getJSONObject("features").getString("URL");


                Watchable newWatchable = new Watchable(artworkId,artworkTitle, artworkLocation, artworkArtist, artworkMaterial, artworkDescription, artworkPlacementDate, artworkImage);
                newWatchable.setWatchableImageUrl(artworkImage);

                mWatchablesList.add(newWatchable);
            }
            listener.onRandomWatchableAvailable(mWatchablesList);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

        public interface OnRandomWatchableListener {
         public void onRandomWatchableAvailable(ArrayList<Watchable> watchablesList);
    }
}
