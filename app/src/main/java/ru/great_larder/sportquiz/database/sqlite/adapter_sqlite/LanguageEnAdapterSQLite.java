package ru.great_larder.sportquiz.database.sqlite.adapter_sqlite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import ru.great_larder.sportquiz.database.sqlite.DatabaseHelper;
import ru.great_larder.sportquiz.domain.QuestionEnLanguage;

import java.util.ArrayList;
import java.util.List;

public class LanguageEnAdapterSQLite {
    private final DatabaseHelper dbHelper;
    private SQLiteDatabase database;
    
    public LanguageEnAdapterSQLite(Context context){
        dbHelper = new DatabaseHelper(context.getApplicationContext());
    }
    
    public LanguageEnAdapterSQLite open(){
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
        return  database.query(DatabaseHelper.TABLE_LANGUAGE_EN, columns, null, null, null, null, null);
    }
    
    @SuppressLint("Range")
    public List<QuestionEnLanguage> getQuestionEnLanguage(){
        ArrayList<QuestionEnLanguage> questionListEnLanguage = new ArrayList<>();
        Cursor cursor = getAllEntries();
        
        while (cursor.moveToNext()){
            QuestionEnLanguage questionEnLanguage = new QuestionEnLanguage();
            questionEnLanguage.setId(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID_QUESTION)));
            questionEnLanguage.setQuestion(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_QUESTION)));
            questionEnLanguage.setRightAnswer(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_RIGHT_ANSWER)));
            questionEnLanguage.setWrongAnswer1(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_1)));
            questionEnLanguage.setWrongAnswer2(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_2)));
            questionEnLanguage.setWrongAnswer3(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_3)));
            questionEnLanguage.setLink(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_LINK_QUESTION)));
            questionEnLanguage.setLevel(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_LEVEL_QUESTION)));
            questionListEnLanguage.add(questionEnLanguage);
        }
        cursor.close();
        return  questionListEnLanguage;
    }
    
    public long getCount(){
        return DatabaseUtils.queryNumEntries(database, DatabaseHelper.TABLE_LANGUAGE_EN);
    }
    
    @SuppressLint("Range")
    public QuestionEnLanguage getEnLanguageById(int id){
        QuestionEnLanguage questionEnLanguage = new QuestionEnLanguage();
        String query = String.format("SELECT * FROM %s WHERE %s=?",DatabaseHelper.TABLE_LANGUAGE_EN, DatabaseHelper.COLUMN_ID_QUESTION);
        Cursor cursor = database.rawQuery(query, new String[]{ String.valueOf(id)});
        if(cursor.moveToFirst()){
            questionEnLanguage.setId(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID_QUESTION)));
            questionEnLanguage.setQuestion(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_QUESTION)));
            questionEnLanguage.setRightAnswer(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_RIGHT_ANSWER)));
            questionEnLanguage.setWrongAnswer1(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_1)));
            questionEnLanguage.setWrongAnswer2(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_2)));
            questionEnLanguage.setWrongAnswer3(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_3)));
            questionEnLanguage.setLink(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_LINK_QUESTION)));
            questionEnLanguage.setLevel(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_LEVEL_QUESTION)));
        }
        cursor.close();
        return  questionEnLanguage;
    }
    
    public Integer insert(QuestionEnLanguage questionEnLanguage){
        
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.COLUMN_QUESTION, questionEnLanguage.getQuestion());
        cv.put(DatabaseHelper.COLUMN_RIGHT_ANSWER, questionEnLanguage.getRightAnswer());
        cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_1, questionEnLanguage.getWrongAnswer1());
        cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_2, questionEnLanguage.getWrongAnswer2());
        cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_3, questionEnLanguage.getWrongAnswer3());
        cv.put(DatabaseHelper.COLUMN_LINK_QUESTION, questionEnLanguage.getLink());
        cv.put(DatabaseHelper.COLUMN_LEVEL_QUESTION, questionEnLanguage.getLevel());
        
        return Math.toIntExact(database.insert(DatabaseHelper.TABLE_LANGUAGE_EN, null, cv));
    }
    public boolean setList(List<QuestionEnLanguage> enLanguages){
        for (QuestionEnLanguage questionEnLanguage : enLanguages) {
            ContentValues cv = new ContentValues();
            cv.put(DatabaseHelper.COLUMN_QUESTION, questionEnLanguage.getQuestion());
            cv.put(DatabaseHelper.COLUMN_RIGHT_ANSWER, questionEnLanguage.getRightAnswer());
            cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_1, questionEnLanguage.getWrongAnswer1());
            cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_2, questionEnLanguage.getWrongAnswer2());
            cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_3, questionEnLanguage.getWrongAnswer3());
            cv.put(DatabaseHelper.COLUMN_LINK_QUESTION, questionEnLanguage.getLink());
            cv.put(DatabaseHelper.COLUMN_LEVEL_QUESTION, questionEnLanguage.getLevel());
            database.insert(DatabaseHelper.TABLE_LANGUAGE_EN, null, cv);
        }
        return true;
    }
    public Integer deleteEnLanguageById(Integer enLanguageId){
        
        String whereClause = "id = ?";
        String[] whereArgs = new String[]{String.valueOf(enLanguageId)};
        return database.delete(DatabaseHelper.TABLE_LANGUAGE_EN, whereClause, whereArgs);
    }
    
    public Integer update(QuestionEnLanguage questionEnLanguage){
        
        String whereClause = DatabaseHelper.COLUMN_ID_QUESTION + "=" + questionEnLanguage.getId();
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.COLUMN_QUESTION, questionEnLanguage.getQuestion());
        cv.put(DatabaseHelper.COLUMN_RIGHT_ANSWER, questionEnLanguage.getRightAnswer());
        cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_1, questionEnLanguage.getWrongAnswer1());
        cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_2, questionEnLanguage.getWrongAnswer2());
        cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_3, questionEnLanguage.getWrongAnswer3());
        cv.put(DatabaseHelper.COLUMN_LINK_QUESTION, questionEnLanguage.getLink());
        cv.put(DatabaseHelper.COLUMN_LEVEL_QUESTION, questionEnLanguage.getLevel());
        
        return database.update(DatabaseHelper.TABLE_LANGUAGE_EN, cv, whereClause, null);
    }
    public void clearTable(){
        database.delete(DatabaseHelper.TABLE_LANGUAGE_EN, null, null);
    }
}
