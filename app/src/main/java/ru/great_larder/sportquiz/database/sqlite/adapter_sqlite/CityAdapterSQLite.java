package ru.great_larder.sportquiz.database.sqlite.adapter_sqlite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import ru.great_larder.sportquiz.database.sqlite.DatabaseHelper;
import ru.great_larder.sportquiz.domain.QuestionCity;

import java.util.ArrayList;
import java.util.List;

public class CityAdapterSQLite {
    private final DatabaseHelper dbHelper;
    private SQLiteDatabase database;
    
    public CityAdapterSQLite(Context context){
        dbHelper = new DatabaseHelper(context.getApplicationContext());
    }
    
    public CityAdapterSQLite open(){
        database = dbHelper.getWritableDatabase();
        return this;
    }
    
    public void close(){
        dbHelper.close();
    }
    
    private Cursor getAllEntries(){
        String[] columns = new String[] {DatabaseHelper.COLUMN_ID_QUESTION, DatabaseHelper.COLUMN_QUESTION
            , DatabaseHelper.COLUMN_RIGHT_ANSWER, DatabaseHelper.COLUMN_WRONG_ANSWER_1, DatabaseHelper.COLUMN_WRONG_ANSWER_2
            , DatabaseHelper.COLUMN_WRONG_ANSWER_3, DatabaseHelper.COLUMN_LINK_QUESTION, DatabaseHelper.COLUMN_LEVEL_QUESTION
        , DatabaseHelper.COLUMN_CITY_QUESTION, DatabaseHelper.COLUMN_LINK_HISTORY_ONE_STREET, DatabaseHelper.COLUMN_LABEL_QUESTION_CITY};
        return  database.query(DatabaseHelper.TABLE_CITY, columns, null, null, null, null, null);
    }
    
    @SuppressLint("Range")
    public List<QuestionCity> getQuestionCityes(){
        ArrayList<QuestionCity> questionCities = new ArrayList<>();
        Cursor cursor = getAllEntries();
        
        while (cursor.moveToNext()){
            QuestionCity questionCity = new QuestionCity();
            questionCity.setId(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID_QUESTION)));
            questionCity.setQuestion(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_QUESTION)));
            questionCity.setRightAnswer(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_RIGHT_ANSWER)));
            questionCity.setWrongAnswer1(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_1)));
            questionCity.setWrongAnswer2(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_2)));
            questionCity.setWrongAnswer3(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_3)));
            questionCity.setLink(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_LINK_QUESTION)));
            questionCity.setLevel(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_LEVEL_QUESTION)));
            
            questionCity.setCity(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_CITY_QUESTION)));
            questionCity.setLinkHistoryOneStreet(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_LINK_HISTORY_ONE_STREET)));
            questionCity.setLabel(cursor.getBlob(cursor.getColumnIndex(DatabaseHelper.COLUMN_LABEL_QUESTION_CITY)));
            
            questionCities.add(questionCity);
        }
        cursor.close();
        return  questionCities;
    }
    
    public long getCount(){
        return DatabaseUtils.queryNumEntries(database, DatabaseHelper.TABLE_CITY);
    }
    
    @SuppressLint("Range")
    public QuestionCity getCityById(int id){
        QuestionCity questionCity = new QuestionCity();
        String query = String.format("SELECT * FROM %s WHERE %s=?",DatabaseHelper.TABLE_CITY, DatabaseHelper.COLUMN_ID_QUESTION);
        Cursor cursor = database.rawQuery(query, new String[]{ String.valueOf(id)});
        if(cursor.moveToFirst()){
            questionCity.setId(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID_QUESTION)));
            questionCity.setQuestion(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_QUESTION)));
            questionCity.setRightAnswer(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_RIGHT_ANSWER)));
            questionCity.setWrongAnswer1(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_1)));
            questionCity.setWrongAnswer2(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_2)));
            questionCity.setWrongAnswer3(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_3)));
            questionCity.setLink(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_LINK_QUESTION)));
            questionCity.setLevel(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_LEVEL_QUESTION)));
            
            questionCity.setCity(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_CITY_QUESTION)));
            questionCity.setLinkHistoryOneStreet(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_LINK_HISTORY_ONE_STREET)));
            questionCity.setLabel(cursor.getBlob(cursor.getColumnIndex(DatabaseHelper.COLUMN_LABEL_QUESTION_CITY)));
        }
        cursor.close();
        return  questionCity;
    }
    
    public Integer insert(QuestionCity questionCity){
        
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.COLUMN_ID_QUESTION, questionCity.getId());
        cv.put(DatabaseHelper.COLUMN_QUESTION, questionCity.getQuestion());
        cv.put(DatabaseHelper.COLUMN_RIGHT_ANSWER, questionCity.getRightAnswer());
        cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_1, questionCity.getWrongAnswer1());
        cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_2, questionCity.getWrongAnswer2());
        cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_3, questionCity.getWrongAnswer3());
        cv.put(DatabaseHelper.COLUMN_LINK_QUESTION, questionCity.getLink());
        cv.put(DatabaseHelper.COLUMN_LEVEL_QUESTION, questionCity.getLevel());
        
        cv.put(DatabaseHelper.COLUMN_CITY_QUESTION, questionCity.getCity());
        cv.put(DatabaseHelper.COLUMN_LINK_HISTORY_ONE_STREET, questionCity.getLinkHistoryOneStreet());
        cv.put(DatabaseHelper.COLUMN_LABEL_QUESTION_CITY, questionCity.getLabel());
        
        return Math.toIntExact(database.insert(DatabaseHelper.TABLE_CITY, null, cv));
    }
    public boolean setList(List<QuestionCity> questionCities){
        for (QuestionCity questionCity : questionCities) {
            ContentValues cv = new ContentValues();
            cv.put(DatabaseHelper.COLUMN_ID_QUESTION, questionCity.getId());
            cv.put(DatabaseHelper.COLUMN_QUESTION, questionCity.getQuestion());
            cv.put(DatabaseHelper.COLUMN_RIGHT_ANSWER, questionCity.getRightAnswer());
            cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_1, questionCity.getWrongAnswer1());
            cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_2, questionCity.getWrongAnswer2());
            cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_3, questionCity.getWrongAnswer3());
            cv.put(DatabaseHelper.COLUMN_LINK_QUESTION, questionCity.getLink());
            cv.put(DatabaseHelper.COLUMN_LEVEL_QUESTION, questionCity.getLevel());
            
            cv.put(DatabaseHelper.COLUMN_CITY_QUESTION, questionCity.getCity());
            cv.put(DatabaseHelper.COLUMN_LINK_HISTORY_ONE_STREET, questionCity.getLinkHistoryOneStreet());
            cv.put(DatabaseHelper.COLUMN_LABEL_QUESTION_CITY, questionCity.getLabel());
            database.insert(DatabaseHelper.TABLE_CITY, null, cv);
        }
        return true;
    }
    public Integer deleteCityById(Integer cityId){
        
        String whereClause = "id = ?";
        String[] whereArgs = new String[]{String.valueOf(cityId)};
        return database.delete(DatabaseHelper.TABLE_CITY, whereClause, whereArgs);
    }
    
    public Integer update(QuestionCity questionCity){
        
        String whereClause = DatabaseHelper.COLUMN_ID_QUESTION + "=" + questionCity.getId();
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.COLUMN_QUESTION, questionCity.getQuestion());
        cv.put(DatabaseHelper.COLUMN_RIGHT_ANSWER, questionCity.getRightAnswer());
        cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_1, questionCity.getWrongAnswer1());
        cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_2, questionCity.getWrongAnswer2());
        cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_3, questionCity.getWrongAnswer3());
        cv.put(DatabaseHelper.COLUMN_LINK_QUESTION, questionCity.getLink());
        cv.put(DatabaseHelper.COLUMN_LEVEL_QUESTION, questionCity.getLevel());
        
        cv.put(DatabaseHelper.COLUMN_CITY_QUESTION, questionCity.getCity());
        cv.put(DatabaseHelper.COLUMN_LINK_HISTORY_ONE_STREET, questionCity.getLinkHistoryOneStreet());
        cv.put(DatabaseHelper.COLUMN_LABEL_QUESTION_CITY, questionCity.getLabel());
        
        return database.update(DatabaseHelper.TABLE_CITY, cv, whereClause, null);
    }
    public void clearTable(){
        database.delete(DatabaseHelper.TABLE_CITY, null, null);
    }
}
