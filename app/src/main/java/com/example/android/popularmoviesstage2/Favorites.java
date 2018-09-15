package com.example.android.popularmoviesstage2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Favorites extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
