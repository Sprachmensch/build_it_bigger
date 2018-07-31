package com.example.sprachmensch.displayjoke;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    public static String EXTRA_KEY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        Intent intent = getIntent();
        String joke = intent.getStringExtra(EXTRA_KEY);

        TextView jokeTextView = (TextView) findViewById(R.id.joke_tv);
        if (joke != null && joke.length() != 0) {
            jokeTextView.setText(joke);
        }
    }
}
