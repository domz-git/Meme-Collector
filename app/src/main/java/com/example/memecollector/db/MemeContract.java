package com.example.memecollector.db;

import android.provider.BaseColumns;

public class MemeContract {


    private MemeContract() {}

    public static final class MemeEntry implements BaseColumns {
        public static final String TABLE_NAME = "memes";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_IMAGE = "image";
    }
}
