package com.effugiumtechnologies.jchaf.explicitintents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    TextView tvWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        String name = getIntent().getStringExtra("username");

        tvWelcome = (TextView) findViewById(R.id.tvWelcome);

        tvWelcome.setText(name + " welcome to Activity 2!");
    }
}
