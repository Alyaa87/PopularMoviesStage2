package com.example.android.popularmoviesstage2;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.android.popularmoviesstage2.Data.Contract;
import com.example.android.popularmoviesstage2.Database.MovieDbHelper;
import com.squareup.picasso.Picasso;

import static com.example.android.popularmoviesstage2.Data.Contract.EXTRA_OVERVIEW;
import static com.example.android.popularmoviesstage2.Data.Contract.EXTRA_RATE;
import static com.example.android.popularmoviesstage2.Data.Contract.EXTRA_TITLE;
import static com.example.android.popularmoviesstage2.Data.Contract.EXTRA_URL;
import static com.example.android.popularmoviesstage2.Data.Contract.EXTRA_YEAR;

public class DetailsActivity extends AppCompatActivity {
    //field to store the movie details
    private String mUrl;
    private String mTitle;
    public TextView mTitleTxt, mReleaseDate, mVoteAverage, mOverview;
    private MovieDbHelper mDbHelper;
    private CheckBox mCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mDbHelper = new MovieDbHelper(this);
        mCheckBox = (CheckBox)findViewById(R.id.favorites_checkbox);
        mCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent checkBoxIntent = new Intent();
                displayDatabaseInfo();
            }
        });


        //Reference
        mTitleTxt = findViewById(R.id.original_title_tv);
        mReleaseDate = findViewById(R.id.release_date);
        mVoteAverage = findViewById(R.id.vote_average);
        mOverview = findViewById(R.id.overview);
        ImageView mMoviePoster = findViewById(R.id.movie_poster);
        RatingBar ratingBar = findViewById(R.id.ratingBar);

        Intent intentStartDetailActivity = getIntent();
        //get the intent
        Bundle bundle = getIntent().getExtras();
        if (bundle.getString(EXTRA_TITLE) != null) {
            mTitle = bundle.getString(EXTRA_TITLE);
            mTitleTxt.setText(mTitle);
        }
        if (bundle.getString(EXTRA_URL) != null) {
            mUrl = bundle.getString(EXTRA_URL);
        }
        if (bundle.getString(EXTRA_YEAR) != null) {
            mReleaseDate.setText(bundle.getString(EXTRA_YEAR));
        }
        if (bundle.getString(EXTRA_RATE) != null) {
            int number = Integer.parseInt(bundle.getString(EXTRA_RATE));
            float d = (float) ((number * 5) / 10);
            ratingBar.setRating(d);
        }
        if (bundle.getString(EXTRA_OVERVIEW) != null) {
            mOverview.setText(bundle.getString(EXTRA_OVERVIEW));
        }
        Picasso.with(this)
                .load(Contract.IMAGE_URL + Contract.W780 + mUrl)
                .into(mMoviePoster);
    }

    private void displayDatabaseInfo() {
        // To access our database, we instantiate our subclass of SQLiteOpenHelper
        // and pass the context, which is the current activity.

        // Create and/or open a database to read from it

        SQLiteDatabase db = mDbHelper.getReadableDatabase();}

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }



}
