package ru.great_larder.sportquiz.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import ru.great_larder.sportquiz.domain.User;

public class DatabaseHelper extends SQLiteOpenHelper {
    
    public static final String TABLE_USERS = "user";
    public static final String TABLE_FON = "fon";
    private static final String DATABASE_NAME = "sport.db";
    private static final int SCHEMA = 2;
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name" ;
    /**
     * 'COLUMN_CITY' - The column was added in 2 versions of the database
     */
    public static final String COLUMN_CITY = "city" ;
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
        
        if(!existsColumnInTable(db, TABLE_USERS, COLUMN_CITY)){
            db.execSQL("ALTER TABLE " + TABLE_USERS + " ADD COLUMN " + COLUMN_CITY + " TEXT DEFAULT null");
        }
       
    }
    private boolean existsColumnInTable(SQLiteDatabase inDatabase, String inTable, String columnToCheck) {
        Cursor cursor = null;
        try {
            // Query 1 row
            cursor = inDatabase.rawQuery("SELECT * FROM " + inTable + " LIMIT 0", null);
            
            // getColumnIndex() gives us the index (0 to ...) of the column - otherwise we get a -1
            if (cursor.getColumnIndex(columnToCheck) != -1)
                return true;
            else
                return false;
            
        } catch (Exception Exp) {
            return false;
        } finally {
            if (cursor != null) cursor.close();
        }
    }
}
