package ru.great_larder.sportquiz.database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import ru.great_larder.sportquiz.domain.Fairies;
import ru.great_larder.sportquiz.domain.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.*;

public class FairiesDatabaseAdapter {
    private DatabaseHelper dbHelper;
    private SQLiteDatabase database;
    public FairiesDatabaseAdapter(Context context){
        dbHelper = new DatabaseHelper(context.getApplicationContext());
    }
    
    public FairiesDatabaseAdapter open(){
        database = dbHelper.getWritableDatabase();
        return this;
    }
    
    public void close(){
        dbHelper.close();
    }
    
    private Cursor getAllEntries(){
        String[] columns = new String[] {DatabaseHelper.COLUMN_ID_FAIRIES, DatabaseHelper.COLUMN_ID_USER_FAIRIES
            , DatabaseHelper.COLUMN_NAME_FAIRIES, DatabaseHelper.COLUMN_PRICE_FAIRIES
            , DatabaseHelper.COLUMN_IMAGE_FAIRIES, DatabaseHelper.COLUMN_DATE_START_FAIRIES
        , DatabaseHelper.COLUMN_VALIDITY_PERIOD_FAIRIES, DatabaseHelper.COLUMN_ACTIVITY_FAIRIES};
        return  database.query(DatabaseHelper.TABLE_FAIRIES, columns, null, null, null, null, null);
    }
    @SuppressLint("Range")
    public List<Fairies> getFairies(){
        ArrayList<Fairies> fairiesArray = new ArrayList<>();
        Cursor cursor = getAllEntries();
        while (cursor.moveToNext()){
            Fairies fairies = new Fairies();
            fairies.setId(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID_FAIRIES)));
            fairies.setIdUser(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID_USER_FAIRIES)));
            fairies.setName(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_NAME_FAIRIES)));
            fairies.setPrice(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PRICE_FAIRIES)));
            fairies.setImageI(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_IMAGE_FAIRIES)));
            String date = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_DATE_START_FAIRIES));
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            Date d = new Date();
            try {
                d = dateFormat.parse(date);
            } catch (ParseException e) {
                e.getStackTrace();
            }
            fairies.setDateStart(d);
            
            fairies.setValidity_period(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_VALIDITY_PERIOD_FAIRIES)));
            fairies.setActivity_fairies(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ACTIVITY_FAIRIES)));
            fairiesArray.add(fairies);
        }
        cursor.close();
        return  fairiesArray;
    }
    @SuppressLint("Range")
    public Fairies getFairyById(Integer id){
      
        Fairies fairies = new Fairies();
        String query = String.format("SELECT * FROM %s WHERE %s=?",DatabaseHelper.TABLE_FAIRIES, DatabaseHelper.COLUMN_ID_FAIRIES);
        Cursor cursor = database.rawQuery(query, new String[]{ String.valueOf(id)});
        if(cursor.moveToFirst()){
            fairies.setId(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID_FAIRIES)));
            fairies.setIdUser(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID_USER_FAIRIES)));
            fairies.setName(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_NAME_FAIRIES)));
            fairies.setPrice(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PRICE_FAIRIES)));
            fairies.setImageI(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_IMAGE_FAIRIES)));
            
            String date = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_DATE_START_FAIRIES));
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            Date d = new Date();
            try {
                d = dateFormat.parse(date);
            } catch (ParseException e) {
                e.getStackTrace();
            }
            fairies.setDateStart(d);
            
            fairies.setValidity_period(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_VALIDITY_PERIOD_FAIRIES)));
            fairies.setActivity_fairies(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ACTIVITY_FAIRIES)));
        }
        cursor.close();
        return  fairies;
        
    }
    
    public long insert(Fairies fairies){
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.COLUMN_ID_FAIRIES, fairies.getId());
        cv.put(DatabaseHelper.COLUMN_ID_USER_FAIRIES, fairies.getIdUser());
        cv.put(DatabaseHelper.COLUMN_NAME_FAIRIES, fairies.getName());
        cv.put(DatabaseHelper.COLUMN_PRICE_FAIRIES, fairies.getPrice());
        cv.put(DatabaseHelper.COLUMN_IMAGE_FAIRIES, fairies.getImageI());
        cv.put(DatabaseHelper.COLUMN_DATE_START_FAIRIES, getDateTime(fairies.getDateStart()));
        cv.put(DatabaseHelper.COLUMN_VALIDITY_PERIOD_FAIRIES, fairies.getValidity_period());
        cv.put(DatabaseHelper.COLUMN_ACTIVITY_FAIRIES, fairies.getActivity_fairies());
        
        return  database.insert(DatabaseHelper.TABLE_FAIRIES, null, cv);
    }
    private String getDateTime(Date d) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
            "yyyy-MM-dd", Locale.getDefault());
        return dateFormat.format(d);
    }
    public long update(Fairies fairies){
        String whereClause = DatabaseHelper.COLUMN_ID_FAIRIES + "=" + fairies.getId();
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.COLUMN_ID_FAIRIES, fairies.getId());
        cv.put(DatabaseHelper.COLUMN_ID_USER_FAIRIES, fairies.getIdUser());
        cv.put(DatabaseHelper.COLUMN_NAME_FAIRIES, fairies.getName());
        cv.put(DatabaseHelper.COLUMN_PRICE_FAIRIES, fairies.getPrice());
        cv.put(DatabaseHelper.COLUMN_IMAGE_FAIRIES, fairies.getImageI());
        cv.put(DatabaseHelper.COLUMN_DATE_START_FAIRIES, getDateTime(fairies.getDateStart()));
        cv.put(DatabaseHelper.COLUMN_VALIDITY_PERIOD_FAIRIES, fairies.getValidity_period());
        cv.put(DatabaseHelper.COLUMN_ACTIVITY_FAIRIES, fairies.getActivity_fairies());
        
        return database.update(DatabaseHelper.TABLE_FAIRIES, cv, whereClause, null);
    }
    public Fairies getFairiesByActive(){
        List<Fairies> list = getFairies();
            for (Fairies f : list) {
                if (f.getActivity_fairies() != null && Objects.equals(f.getActivity_fairies(), 1)) {
                    return f;
                }
            }
        return null;
    }
}
