package ru.great_larder.sportquiz.database.sqlite.adapter_sqlite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import ru.great_larder.sportquiz.database.sqlite.DatabaseHelper;
import ru.great_larder.sportquiz.domain.QuestionGeography;

import java.util.ArrayList;
import java.util.List;

public class GeographyAdapterSQLite {
    private final DatabaseHelper dbHelper;
    private SQLiteDatabase database;
    
    public GeographyAdapterSQLite(Context context){
        dbHelper = new DatabaseHelper(context.getApplicationContext());
    }
    
    public GeographyAdapterSQLite open(){
        database = dbHelper.getWritableDatabase();
        return this;
    }
    
    public void close(){
        dbHelper.close();
    }
    
    private Cursor getAllEntries(){
        String[] columns = new String[] {DatabaseHelper.COLUMN_ID_QUESTION, DatabaseHelper.COLUMN_QUESTION
            , DatabaseHelper.COLUMN_RIGHT_ANSWER, DatabaseHelper.COLUMN_WRONG_ANSWER_1, DatabaseHelper.COLUMN_WRONG_ANSWER_2
            , DatabaseHelper.COLUMN_WRONG_ANSWER_3, DatabaseHelper.COLUMN_LINK_QUESTION, DatabaseHelper.COLUMN_LEVEL_QUESTION};
        return  database.query(DatabaseHelper.TABLE_GEOGRAPHY, columns, null, null, null, null, null);
    }
    
    @SuppressLint("Range")
    public List<QuestionGeography> getQuestionGeography(){
        ArrayList<QuestionGeography> questionListGeography = new ArrayList<>();
        Cursor cursor = getAllEntries();
        
        while (cursor.moveToNext()){
            QuestionGeography questionGeography = new QuestionGeography();
            questionGeography.setId(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID_QUESTION)));
            questionGeography.setQuestion(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_QUESTION)));
            questionGeography.setRightAnswer(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_RIGHT_ANSWER)));
            questionGeography.setWrongAnswer1(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_1)));
            questionGeography.setWrongAnswer2(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_2)));
            questionGeography.setWrongAnswer3(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_3)));
            questionGeography.setLink(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_LINK_QUESTION)));
            questionGeography.setLevel(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_LEVEL_QUESTION)));
            questionListGeography.add(questionGeography);
        }
        cursor.close();
        return  questionListGeography;
    }
    
    public long getCount(){
        return DatabaseUtils.queryNumEntries(database, DatabaseHelper.TABLE_GEOGRAPHY);
    }
    
    @SuppressLint("Range")
    public QuestionGeography getGeographyById(int id){
        QuestionGeography questionGeography = new QuestionGeography();
        String query = String.format("SELECT * FROM %s WHERE %s=?",DatabaseHelper.TABLE_GEOGRAPHY, DatabaseHelper.COLUMN_ID_QUESTION);
        Cursor cursor = database.rawQuery(query, new String[]{ String.valueOf(id)});
        if(cursor.moveToFirst()){
            questionGeography.setId(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID_QUESTION)));
            questionGeography.setQuestion(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_QUESTION)));
            questionGeography.setRightAnswer(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_RIGHT_ANSWER)));
            questionGeography.setWrongAnswer1(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_1)));
            questionGeography.setWrongAnswer2(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_2)));
            questionGeography.setWrongAnswer3(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_3)));
            questionGeography.setLink(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_LINK_QUESTION)));
            questionGeography.setLevel(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_LEVEL_QUESTION)));
        }
        cursor.close();
        return  questionGeography;
    }
    
    public Integer insert(QuestionGeography questionGeography){
        
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.COLUMN_QUESTION, questionGeography.getQuestion());
        cv.put(DatabaseHelper.COLUMN_RIGHT_ANSWER, questionGeography.getRightAnswer());
        cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_1, questionGeography.getWrongAnswer1());
        cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_2, questionGeography.getWrongAnswer2());
        cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_3, questionGeography.getWrongAnswer3());
        cv.put(DatabaseHelper.COLUMN_LINK_QUESTION, questionGeography.getLink());
        cv.put(DatabaseHelper.COLUMN_LEVEL_QUESTION, questionGeography.getLevel());
        
        return Math.toIntExact(database.insert(DatabaseHelper.TABLE_GEOGRAPHY, null, cv));
    }
    
    public Integer deleteGeographyById(Integer geographyId){
        
        String whereClause = "id = ?";
        String[] whereArgs = new String[]{String.valueOf(geographyId)};
        return database.delete(DatabaseHelper.TABLE_GEOGRAPHY, whereClause, whereArgs);
    }
    
    public Integer update(QuestionGeography questionGeography){
        
        String whereClause = DatabaseHelper.COLUMN_ID_QUESTION + "=" + questionGeography.getId();
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.COLUMN_QUESTION, questionGeography.getQuestion());
        cv.put(DatabaseHelper.COLUMN_RIGHT_ANSWER, questionGeography.getRightAnswer());
        cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_1, questionGeography.getWrongAnswer1());
        cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_2, questionGeography.getWrongAnswer2());
        cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_3, questionGeography.getWrongAnswer3());
        cv.put(DatabaseHelper.COLUMN_LINK_QUESTION, questionGeography.getLink());
        cv.put(DatabaseHelper.COLUMN_LEVEL_QUESTION, questionGeography.getLevel());
        
        return database.update(DatabaseHelper.TABLE_GEOGRAPHY, cv, whereClause, null);
    }
    public void clearTable(){
        database.delete(DatabaseHelper.TABLE_GEOGRAPHY, null, null);
    }
}
