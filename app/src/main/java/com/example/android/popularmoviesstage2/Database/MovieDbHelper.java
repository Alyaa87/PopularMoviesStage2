package com.example.android.popularmoviesstage2.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MovieDbHelper extends SQLiteOpenHelper {
    //create constants.
    public static final String DATABASE_NAME = "movie.db";
    public static final int DATABASE_VERSION = 1;
    //constructor
    public MovieDbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //CREATE TABLE movie (_id INTEGER, name TEXT);
        String SQL_CREATE_MOVIE_TABLE =  "CREATE TABLE " + MovieContract.movieEntry.TABLE_MOVIE_NAME + "("
                + MovieContract.movieEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + MovieContract.movieEntry.COLUMN_MOVIE_NAME + " TEXT NOT NULL);";

        db.execSQL(SQL_CREATE_MOVIE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
