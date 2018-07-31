package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.util.Pair;
import android.util.Log;

import com.example.sprachmensch.displayjoke.JokeActivity;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

/*

    Based on:
    https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/77e9910911d5412e5efede5fa681ec105a0f02ad/HelloEndpoints

 */

public class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
    private static MyApi myApiService = null;
    private Context context;

    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        if (myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/");

            myApiService = builder.build();
        }

        /*

            Learnings don't use another IP and never ever remove the http infront of the IP!
            -> costs me around 10h of my life :(

            debug emulator
            .setRootUrl("http://10.0.2.2:8080/_ah/api/");

            PC
            .setRootUrl("http://192.168.2.104:8080/_ah/api/");

         */

        try {
            Log.e("myApiService", "myApiService.getJoke().execute().getData()" + myApiService.getJoke().execute().getData());
            return myApiService.getJoke().execute().getData();
        } catch (IOException e) {
            Log.e("myApiService", "" + e.getMessage());

            return e.getMessage();
        }
    }

    public EndpointsAsyncTask(Context context) {
        this.context = context;
    }

    @Override
    protected void onPostExecute(String result) {
        Intent intent = new Intent(context, JokeActivity.class);
        intent.putExtra(JokeActivity.EXTRA_KEY, result);
        context.startActivity(intent);
    }

}
