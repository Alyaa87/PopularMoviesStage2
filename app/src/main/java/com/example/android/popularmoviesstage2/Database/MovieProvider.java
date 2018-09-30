package com.example.android.popularmoviesstage2.Database;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import com.example.android.popularmoviesstage2.Data.Contract;

public class MovieProvider extends ContentProvider {

    private MovieDbHelper mHelperDb;
    /**
     * Tag for the log messages
     */
    public static final String LOG_TAG = MovieDbHelper.class.getSimpleName();
    /**
     * Initialize the provider and the database helper object.
     */
    @Override
    public boolean onCreate() {
        mHelperDb = new MovieDbHelper(getContext());
        return true;
    }

    /**
     * Perform the query for the given URI. Use the given projection, selection, selection arguments, and sort order.
     */

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs,

                        String sortOrder) {

        // Get readable database
        SQLiteDatabase database = mHelperDb.getReadableDatabase();
        Cursor cursor;

        int match = sUriMatcher.match(uri);
        switch (match) {
            case MOVIES:

                cursor = database.query(Contract.movieEntry.TABLE_MOVIE_NAME, projection
                        , selection, selectionArgs, null, null, sortOrder);
                break;
            case MOVIES_ID:

                selection = Contract.movieEntry._ID + "=?";
                selectionArgs = new String[]{String.valueOf(ContentUris.parseId(uri))};
                // This will perform a query on the pets table where the _id equals 3 to return a
                // Cursor containing that row of the table.
                cursor = database.query(Contract.movieEntry.TABLE_MOVIE_NAME, projection, selection, selectionArgs,
                        null, null, sortOrder);
                break;
            default:
                throw new IllegalArgumentException("Cannot query unknown URI " + uri);
        }
        return cursor;
    }

    /**
     * Insert new data into the provider with the given ContentValues.
     */

    @Override

    public Uri insert(Uri uri, ContentValues contentValues) {

        return null;

    }

    /**
     * Updates the data at the given selection and selection arguments, with the new ContentValues.
     */
    @Override
    public int update(Uri uri, ContentValues contentValues, String selection, String[] selectionArgs) {
        return 0;
    }

    /**
     * Delete the data at the given selection and selection arguments.
     */
    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    /**
     * Returns the MIME type of data for the content URI.
     */
    @Override
    public String getType(Uri uri) {
        return null;
    }

//Movies case code
    private static final int MOVIES = 100;
    private static final int MOVIES_ID = 101;

    /**
     * UriMatcher object
     */

    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {

        sUriMatcher.addURI(Contract.CONTENT_AUTHORITY, Contract.PATH_MOVIES + "/#", MOVIES_ID);
        sUriMatcher.addURI(Contract.CONTENT_AUTHORITY, Contract.PATH_MOVIES, MOVIES);

    }

}



