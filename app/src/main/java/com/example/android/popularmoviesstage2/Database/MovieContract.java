package com.example.android.popularmoviesstage2.Database;

import android.provider.BaseColumns;

public class MovieContract {
    //inner class
    public static abstract class movieEntry implements BaseColumns {
        public final static String TABLE_MOVIE_NAME = "MOVIE";
        //columns of the table
        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_MOVIE_NAME = "name";
//        public final static String COLUMN_IMAGE = "image";

        //the values for the columns

    }
}
