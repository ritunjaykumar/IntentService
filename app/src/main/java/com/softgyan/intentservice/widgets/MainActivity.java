package com.softgyan.intentservice.widgets;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.softgyan.intentservice.R;
import com.softgyan.intentservice.services.MyIntentService;
import com.softgyan.intentservice.util.Playlist;

public class MainActivity extends AppCompatActivity {
    private final static int SET_TEXT = 0;
    private final static int APPEND_TEXT = 1;


    private static final String TAG = "my_tag";
    public static final String MESSAGE = "message_key";
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initCode();
    }

    private void callRunCode() {
        setText("code is running", APPEND_TEXT);
        for(String song : Playlist.songs){
            Intent intent = new Intent(this, MyIntentService.class);
            intent.putExtra(MESSAGE, song);
            startService(intent);
        }

    }
    private void initCode() {
        textView = findViewById(R.id.textView);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(v->{
            callRunCode();
        });
    }


    private void setText(String text, int flag){
        if(flag == 0){
            textView.setText(text);
        }else {
            textView.append(text+"\n");
        }
        Log.d(TAG, "setText: "+text);
    }
}