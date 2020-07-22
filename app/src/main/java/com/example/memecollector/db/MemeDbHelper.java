package com.example.memecollector.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.memecollector.model.Meme;

public class MemeDbHelper extends SQLiteOpenHelper {
    private static final String TEXT_TYPE = " TEXT";
    private static final String INTEGER_TYPE = " INTEGER";
    private static final String COMMA_SEP = ",";
    private static final String DATABASE_NAME = "memes.db";
    private static final int DATABASE_VERSION = 1;

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + MemeContract.MemeEntry.TABLE_NAME + " (" +
                    MemeContract.MemeEntry._ID + INTEGER_TYPE + " PRIMARY KEY" + COMMA_SEP +
                    MemeContract.MemeEntry.COLUMN_TITLE + TEXT_TYPE + COMMA_SEP +
                    MemeContract.MemeEntry.COLUMN_IMAGE + TEXT_TYPE + " )";

    public MemeDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        //This method has been intentionally left empty. There is only one version of the database.
    }

    public Cursor readAllMemes() {
        SQLiteDatabase db = getReadableDatabase();

        return db.query(
                MemeContract.MemeEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null
        );
    }

    public boolean addMeme(Meme meme) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(MemeContract.MemeEntry.COLUMN_TITLE, meme.getTitle());
        values.put(MemeContract.MemeEntry.COLUMN_IMAGE, meme.getImageAsString());

        return db.insert(MemeContract.MemeEntry.TABLE_NAME, null, values) != -1;
    }


}
