package ru.great_larder.sportquiz.database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import ru.great_larder.sportquiz.domain.User;

import java.util.ArrayList;
import java.util.List;

public class DatabaseAdapter {
    private final DatabaseHelper dbHelper;
    private SQLiteDatabase database;
    
    public DatabaseAdapter(Context context){
        dbHelper = new DatabaseHelper(context.getApplicationContext());
    }
    
    public DatabaseAdapter open(){
        database = dbHelper.getWritableDatabase();
        return this;
    }
    
    public void close(){
        dbHelper.close();
    }
    
    private Cursor getAllEntries(){
        String[] columns = new String[] {DatabaseHelper.COLUMN_ID, DatabaseHelper.COLUMN_NAME, DatabaseHelper.COLUMN_CITY
            , DatabaseHelper.COLUMN_GLASSES, DatabaseHelper.COLUMN_THEME_INSTALL, DatabaseHelper.COLUMN_DATE_OF_BIRTH
            , DatabaseHelper.COLUMN_AWATAR};
        return  database.query(DatabaseHelper.TABLE_USERS, columns, null, null, null, null, null);
    }
    
    @SuppressLint("Range")
    public List<User> getUsers(){
        ArrayList<User> users = new ArrayList<>();
        Cursor cursor = getAllEntries();
        
        while (cursor.moveToNext()){
            User user = new User();
            user.setId(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID)));
            user.setName(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_NAME)));
            user.setCity(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_CITY)));
            user.setGlasses(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_GLASSES)));
            user.setThemeInstalledNow(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_THEME_INSTALL)));
            user.setDate_of_birth(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_DATE_OF_BIRTH)));
            user.setAwatar(cursor.getBlob(cursor.getColumnIndex(DatabaseHelper.COLUMN_AWATAR)));
            users.add(user);
        }
        cursor.close();
        return  users;
    }
    
    public long getCount(){
        return DatabaseUtils.queryNumEntries(database, DatabaseHelper.TABLE_USERS);
    }
    
    @SuppressLint("Range")
    public User getUserById(long id){
        User user = new User();
        String query = String.format("SELECT * FROM %s WHERE %s=?",DatabaseHelper.TABLE_USERS, DatabaseHelper.COLUMN_ID);
        Cursor cursor = database.rawQuery(query, new String[]{ String.valueOf(id)});
        if(cursor.moveToFirst()){
            user.setId(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID)));
            user.setName(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_NAME)));
            user.setCity(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_CITY)));
            user.setGlasses(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_GLASSES)));
            user.setThemeInstalledNow(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_THEME_INSTALL)));
            user.setDate_of_birth(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_DATE_OF_BIRTH)));
            user.setAwatar(cursor.getBlob(cursor.getColumnIndex(DatabaseHelper.COLUMN_AWATAR)));
        }
        cursor.close();
        return  user;
    }
    
    public long insert(User user){
        
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.COLUMN_NAME, user.getName());
        cv.put(DatabaseHelper.COLUMN_CITY, user.getCity());
        cv.put(DatabaseHelper.COLUMN_GLASSES, user.getGlasses());
        cv.put(DatabaseHelper.COLUMN_THEME_INSTALL, user.getThemeInstalledNow());
        cv.put(DatabaseHelper.COLUMN_DATE_OF_BIRTH, user.getDate_of_birth());
        cv.put(DatabaseHelper.COLUMN_AWATAR, user.getAwatar());
        
        return  database.insert(DatabaseHelper.TABLE_USERS, null, cv);
    }
    
    public long deleteUserById(long userId){
        
        String whereClause = "id = ?";
        String[] whereArgs = new String[]{String.valueOf(userId)};
        return database.delete(DatabaseHelper.TABLE_USERS, whereClause, whereArgs);
    }
    
    public long update(User user){
        
        String whereClause = DatabaseHelper.COLUMN_ID + "=" + user.getId();
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.COLUMN_NAME, user.getName());
        cv.put(DatabaseHelper.COLUMN_CITY, user.getCity());
        cv.put(DatabaseHelper.COLUMN_GLASSES, user.getGlasses());
        cv.put(DatabaseHelper.COLUMN_THEME_INSTALL, user.getThemeInstalledNow());
        cv.put(DatabaseHelper.COLUMN_DATE_OF_BIRTH, user.getDate_of_birth());
        cv.put(DatabaseHelper.COLUMN_AWATAR, user.getAwatar());

        return database.update(DatabaseHelper.TABLE_USERS, cv, whereClause, null);
    }
  
}
