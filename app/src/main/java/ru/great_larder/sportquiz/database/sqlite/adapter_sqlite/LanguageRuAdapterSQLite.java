package ru.great_larder.sportquiz.database.sqlite.adapter_sqlite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import ru.great_larder.sportquiz.database.sqlite.DatabaseHelper;
import ru.great_larder.sportquiz.domain.QuestionRuLanguage;

import java.util.ArrayList;
import java.util.List;

public class LanguageRuAdapterSQLite {
    private final DatabaseHelper dbHelper;
    private SQLiteDatabase database;
    
    public LanguageRuAdapterSQLite(Context context){
        dbHelper = new DatabaseHelper(context.getApplicationContext());
    }
    
    public LanguageRuAdapterSQLite open(){
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
        return  database.query(DatabaseHelper.TABLE_LANGUAGE_RU, columns, null, null, null, null, null);
    }
    
    @SuppressLint("Range")
    public List<QuestionRuLanguage> getQuestionRuLanguage(){
        ArrayList<QuestionRuLanguage> questionListRuLanguage = new ArrayList<>();
        Cursor cursor = getAllEntries();
        
        while (cursor.moveToNext()){
            QuestionRuLanguage questionRuLanguage = new QuestionRuLanguage();
            questionRuLanguage.setId(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID_QUESTION)));
            questionRuLanguage.setQuestion(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_QUESTION)));
            questionRuLanguage.setRightAnswer(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_RIGHT_ANSWER)));
            questionRuLanguage.setWrongAnswer1(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_1)));
            questionRuLanguage.setWrongAnswer2(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_2)));
            questionRuLanguage.setWrongAnswer3(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_3)));
            questionRuLanguage.setLink(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_LINK_QUESTION)));
            questionRuLanguage.setLevel(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_LEVEL_QUESTION)));
            questionListRuLanguage.add(questionRuLanguage);
        }
        cursor.close();
        return  questionListRuLanguage;
    }
    
    public long getCount(){
        return DatabaseUtils.queryNumEntries(database, DatabaseHelper.TABLE_LANGUAGE_RU);
    }
    
    @SuppressLint("Range")
    public QuestionRuLanguage getRuLanguageById(int id){
        QuestionRuLanguage questionRuLanguage = new QuestionRuLanguage();
        String query = String.format("SELECT * FROM %s WHERE %s=?",DatabaseHelper.TABLE_LANGUAGE_RU, DatabaseHelper.COLUMN_ID_QUESTION);
        Cursor cursor = database.rawQuery(query, new String[]{ String.valueOf(id)});
        if(cursor.moveToFirst()){
            questionRuLanguage.setId(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID_QUESTION)));
            questionRuLanguage.setQuestion(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_QUESTION)));
            questionRuLanguage.setRightAnswer(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_RIGHT_ANSWER)));
            questionRuLanguage.setWrongAnswer1(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_1)));
            questionRuLanguage.setWrongAnswer2(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_2)));
            questionRuLanguage.setWrongAnswer3(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_3)));
            questionRuLanguage.setLink(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_LINK_QUESTION)));
            questionRuLanguage.setLevel(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_LEVEL_QUESTION)));
        }
        cursor.close();
        return  questionRuLanguage;
    }
    
    public Integer insert(QuestionRuLanguage questionRuLanguage){
        
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.COLUMN_QUESTION, questionRuLanguage.getQuestion());
        cv.put(DatabaseHelper.COLUMN_RIGHT_ANSWER, questionRuLanguage.getRightAnswer());
        cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_1, questionRuLanguage.getWrongAnswer1());
        cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_2, questionRuLanguage.getWrongAnswer2());
        cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_3, questionRuLanguage.getWrongAnswer3());
        cv.put(DatabaseHelper.COLUMN_LINK_QUESTION, questionRuLanguage.getLink());
        cv.put(DatabaseHelper.COLUMN_LEVEL_QUESTION, questionRuLanguage.getLevel());
        
        return Math.toIntExact(database.insert(DatabaseHelper.TABLE_LANGUAGE_RU, null, cv));
    }
    public boolean setList(List<QuestionRuLanguage> ruLanguages){
        for (QuestionRuLanguage questionRuLanguage : ruLanguages) {
            ContentValues cv = new ContentValues();
            cv.put(DatabaseHelper.COLUMN_QUESTION, questionRuLanguage.getQuestion());
            cv.put(DatabaseHelper.COLUMN_RIGHT_ANSWER, questionRuLanguage.getRightAnswer());
            cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_1, questionRuLanguage.getWrongAnswer1());
            cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_2, questionRuLanguage.getWrongAnswer2());
            cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_3, questionRuLanguage.getWrongAnswer3());
            cv.put(DatabaseHelper.COLUMN_LINK_QUESTION, questionRuLanguage.getLink());
            cv.put(DatabaseHelper.COLUMN_LEVEL_QUESTION, questionRuLanguage.getLevel());
            database.insert(DatabaseHelper.TABLE_LANGUAGE_RU, null, cv);
        }
        return true;
    }
    public Integer deleteRuLanguageById(Integer enLanguageId){
        
        String whereClause = "id = ?";
        String[] whereArgs = new String[]{String.valueOf(enLanguageId)};
        return database.delete(DatabaseHelper.TABLE_LANGUAGE_RU, whereClause, whereArgs);
    }
    
    public Integer update(QuestionRuLanguage questionRuLanguage){
        
        String whereClause = DatabaseHelper.COLUMN_ID_QUESTION + "=" + questionRuLanguage.getId();
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.COLUMN_QUESTION, questionRuLanguage.getQuestion());
        cv.put(DatabaseHelper.COLUMN_RIGHT_ANSWER, questionRuLanguage.getRightAnswer());
        cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_1, questionRuLanguage.getWrongAnswer1());
        cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_2, questionRuLanguage.getWrongAnswer2());
        cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_3, questionRuLanguage.getWrongAnswer3());
        cv.put(DatabaseHelper.COLUMN_LINK_QUESTION, questionRuLanguage.getLink());
        cv.put(DatabaseHelper.COLUMN_LEVEL_QUESTION, questionRuLanguage.getLevel());
        
        return database.update(DatabaseHelper.TABLE_LANGUAGE_RU, cv, whereClause, null);
    }
    public void clearTable(){
        database.delete(DatabaseHelper.TABLE_LANGUAGE_RU, null, null);
    }
}
