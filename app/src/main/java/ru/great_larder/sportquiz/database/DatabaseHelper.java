package ru.great_larder.sportquiz.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    
    public static final String TABLE_USERS = "user";
    public static final String TABLE_FON = "fon";
    private static final String DATABASE_NAME = "sport.db";
    private static final int SCHEMA = 1;
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name" ;
    public static final String COLUMN_GLASSES = "glasses";
    public static final String COLUMN_THEME_INSTALL = "themeInstalledNow";
    
    /*--------------------------------------------------- FON --------------------------------------------------*/
    public static final String COLUMN_ID_FON = "id";
    public static final String COLUMN_NAME_FON = "name" ;
    public static final String COLUMN_PRICE_FON = "price";
    public static final String COLUMN_IMAGE_FON = "image" ;
    public static final String COLUMN_AFFILIATION_FON = "affiliation";
    
    
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, SCHEMA);
    }
    
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQLiteUser.CREATE_TABLE_USER);
        db.execSQL(SQLiteFon.CREATE_TABLE_FON);
    }
    
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        /*db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);*/
        db.execSQL(SQLiteUser.UPDATE_USER);
        db.execSQL(SQLiteFon.UPDATE_FON);
        onCreate(db);
    }
}
