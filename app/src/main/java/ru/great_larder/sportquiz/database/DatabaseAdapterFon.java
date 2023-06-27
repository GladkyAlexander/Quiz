package ru.great_larder.sportquiz.database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import ru.great_larder.sportquiz.domain.Fon;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DatabaseAdapterFon {
    private DatabaseHelper dbHelper;
    private SQLiteDatabase database;
    
    public DatabaseAdapterFon(Context context){
        dbHelper = new DatabaseHelper(context.getApplicationContext());
    }
    
    public DatabaseAdapterFon open(){
        database = dbHelper.getWritableDatabase();
        return this;
    }
    
    public void close(){
        dbHelper.close();
    }
    
    private Cursor getAllEntries(){
        String[] columns = new String[] {DatabaseHelper.COLUMN_ID_FON, DatabaseHelper.COLUMN_NAME_FON, DatabaseHelper.COLUMN_PRICE_FON
        , DatabaseHelper.COLUMN_IMAGE_FON, DatabaseHelper.COLUMN_AFFILIATION_FON};
        return  database.query(DatabaseHelper.TABLE_FON, columns, null, null, null, null, null);
    }
    
    @SuppressLint("Range")
    public List<Fon> getBackgrounds(int idUser){
        ArrayList<Fon> background = new ArrayList<>();
        Cursor cursor = getAllEntries();
        Fon fon = new Fon();
        while (cursor.moveToNext()){
            fon.setId(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID_FON)));
            fon.setName(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_NAME_FON)));
            fon.setPrice(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PRICE_FON)));
            fon.setImageI(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_IMAGE_FON)));
            fon.setAffiliation(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_AFFILIATION_FON)));
            if(Objects.equals(fon.getAffiliation(), idUser)) {
                background.add(fon);
            }
        }
        cursor.close();
        return  background;
    }
    
    public long getCount(){
        return DatabaseUtils.queryNumEntries(database, DatabaseHelper.TABLE_FON);
    }
    
    @SuppressLint("Range")
    public Fon getFonById(Integer id){
        Fon fon = new Fon();
        String query = String.format("SELECT * FROM %s WHERE %s=?",DatabaseHelper.TABLE_FON, DatabaseHelper.COLUMN_ID_FON);
        Cursor cursor = database.rawQuery(query, new String[]{ String.valueOf(id)});
        if(cursor.moveToFirst()){
            fon.setId(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID_FON)));
            fon.setName(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_NAME_FON)));
            fon.setPrice(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PRICE_FON)));
            fon.setImageI(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_IMAGE_FON)));
        }
        cursor.close();
        return  fon;
    }
    
    public Integer insert(Fon fon){
        
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.COLUMN_NAME_FON, fon.getName());
        cv.put(DatabaseHelper.COLUMN_PRICE_FON, fon.getPrice());
        cv.put(DatabaseHelper.COLUMN_IMAGE_FON, fon.getImageI());
        cv.put(DatabaseHelper.COLUMN_AFFILIATION_FON, fon.getAffiliation());
        
        return Math.toIntExact(database.insert(DatabaseHelper.TABLE_FON, null, cv));
    }
    
    public long deleteFonById(Integer fonId){
        
        String whereClause = "id = ?";
        String[] whereArgs = new String[]{String.valueOf(fonId)};
        return database.delete(DatabaseHelper.TABLE_FON, whereClause, whereArgs);
    }
    
    public long update(Fon fon){
        
        String whereClause = DatabaseHelper.COLUMN_ID_FON + "=" + fon.getId();
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.COLUMN_NAME_FON, fon.getName());
        cv.put(DatabaseHelper.COLUMN_PRICE_FON, fon.getPrice());
        cv.put(DatabaseHelper.COLUMN_IMAGE_FON, fon.getImageI());
        cv.put(DatabaseHelper.COLUMN_AFFILIATION_FON, fon.getAffiliation());
        
        return database.update(DatabaseHelper.TABLE_FON, cv, whereClause, null);
    }
}
