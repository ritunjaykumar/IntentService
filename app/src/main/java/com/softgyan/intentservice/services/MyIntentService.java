package com.softgyan.intentservice.services;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import com.softgyan.intentservice.widgets.MainActivity;


public class MyIntentService extends IntentService {

    private static final String TAG = "my_tag";

    public MyIntentService() {
        super("MyIntentService\n");
        setIntentRedelivery(true);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            String songName = intent.getStringExtra(MainActivity.MESSAGE);
            downloadSong(songName);
        } else {
            Log.d(TAG, "onHandleIntent: intent value is null\n");
        }
    }


    private void downloadSong(String songName) {
        Log.d(TAG, "downloadSong: song downloading: " + songName + "\n");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "downloadSong: song downloaded: " + songName + "\n\n");
    }


}