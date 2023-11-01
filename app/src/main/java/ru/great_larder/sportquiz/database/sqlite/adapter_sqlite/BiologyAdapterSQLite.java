package ru.great_larder.sportquiz.database.sqlite.adapter_sqlite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import ru.great_larder.sportquiz.database.sqlite.DatabaseHelper;
import ru.great_larder.sportquiz.domain.QuestionBiology;

import java.util.ArrayList;
import java.util.List;

public class BiologyAdapterSQLite {
    private final DatabaseHelper dbHelper;
    private SQLiteDatabase database;
    
    public BiologyAdapterSQLite(Context context){
        dbHelper = new DatabaseHelper(context.getApplicationContext());
    }
    
    public BiologyAdapterSQLite open(){
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
        return  database.query(DatabaseHelper.TABLE_BIOLOGY, columns, null, null, null, null, null);
    }
    
    @SuppressLint("Range")
    public List<QuestionBiology> getQuestionBiology(){
        ArrayList<QuestionBiology> questionBiologies = new ArrayList<>();
        Cursor cursor = getAllEntries();
        
        while (cursor.moveToNext()){
            QuestionBiology questionBiology = new QuestionBiology();
            questionBiology.setId(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID_QUESTION)));
            questionBiology.setQuestion(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_QUESTION)));
            questionBiology.setRightAnswer(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_RIGHT_ANSWER)));
            questionBiology.setWrongAnswer1(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_1)));
            questionBiology.setWrongAnswer2(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_2)));
            questionBiology.setWrongAnswer3(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_3)));
            questionBiology.setLink(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_LINK_QUESTION)));
            questionBiology.setLevel(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_LEVEL_QUESTION)));
            questionBiologies.add(questionBiology);
        }
        cursor.close();
        return  questionBiologies;
    }
    
    public long getCount(){
        return DatabaseUtils.queryNumEntries(database, DatabaseHelper.TABLE_BIOLOGY);
    }
    
    @SuppressLint("Range")
    public QuestionBiology getBiologyById(int id){
        QuestionBiology questionBiology = new QuestionBiology();
        String query = String.format("SELECT * FROM %s WHERE %s=?",DatabaseHelper.TABLE_BIOLOGY, DatabaseHelper.COLUMN_ID_QUESTION);
        Cursor cursor = database.rawQuery(query, new String[]{ String.valueOf(id)});
        if(cursor.moveToFirst()){
            questionBiology.setId(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID_QUESTION)));
            questionBiology.setQuestion(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_QUESTION)));
            questionBiology.setRightAnswer(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_RIGHT_ANSWER)));
            questionBiology.setWrongAnswer1(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_1)));
            questionBiology.setWrongAnswer2(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_2)));
            questionBiology.setWrongAnswer3(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_3)));
            questionBiology.setLink(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_LINK_QUESTION)));
            questionBiology.setLevel(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_LEVEL_QUESTION)));
        }
        cursor.close();
        return  questionBiology;
    }
    
    public Integer insert(QuestionBiology questionBiology){
        
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.COLUMN_QUESTION, questionBiology.getQuestion());
        cv.put(DatabaseHelper.COLUMN_RIGHT_ANSWER, questionBiology.getRightAnswer());
        cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_1, questionBiology.getWrongAnswer1());
        cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_2, questionBiology.getWrongAnswer2());
        cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_3, questionBiology.getWrongAnswer3());
        cv.put(DatabaseHelper.COLUMN_LINK_QUESTION, questionBiology.getLink());
        cv.put(DatabaseHelper.COLUMN_LEVEL_QUESTION, questionBiology.getLevel());
        
        return Math.toIntExact(database.insert(DatabaseHelper.TABLE_BIOLOGY, null, cv));
    }
    public boolean setList(List<QuestionBiology> questionBiologies){
        for (QuestionBiology questionBiology : questionBiologies) {
            ContentValues cv = new ContentValues();
            cv.put(DatabaseHelper.COLUMN_QUESTION, questionBiology.getQuestion());
            cv.put(DatabaseHelper.COLUMN_RIGHT_ANSWER, questionBiology.getRightAnswer());
            cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_1, questionBiology.getWrongAnswer1());
            cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_2, questionBiology.getWrongAnswer2());
            cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_3, questionBiology.getWrongAnswer3());
            cv.put(DatabaseHelper.COLUMN_LINK_QUESTION, questionBiology.getLink());
            cv.put(DatabaseHelper.COLUMN_LEVEL_QUESTION, questionBiology.getLevel());
            database.insert(DatabaseHelper.TABLE_BIOLOGY, null, cv);
        }
        return true;
    }
    public Integer deleteBiologyById(Integer biologyId){
        
        String whereClause = "id = ?";
        String[] whereArgs = new String[]{String.valueOf(biologyId)};
        return database.delete(DatabaseHelper.TABLE_BIOLOGY, whereClause, whereArgs);
    }
    
    public Integer update(QuestionBiology questionBiology){
        
        String whereClause = DatabaseHelper.COLUMN_ID_QUESTION + "=" + questionBiology.getId();
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.COLUMN_QUESTION, questionBiology.getQuestion());
        cv.put(DatabaseHelper.COLUMN_RIGHT_ANSWER, questionBiology.getRightAnswer());
        cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_1, questionBiology.getWrongAnswer1());
        cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_2, questionBiology.getWrongAnswer2());
        cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_3, questionBiology.getWrongAnswer3());
        cv.put(DatabaseHelper.COLUMN_LINK_QUESTION, questionBiology.getLink());
        cv.put(DatabaseHelper.COLUMN_LEVEL_QUESTION, questionBiology.getLevel());
        
        return database.update(DatabaseHelper.TABLE_BIOLOGY, cv, whereClause, null);
    }
    public void clearTable(){
        database.delete(DatabaseHelper.TABLE_BIOLOGY, null, null);
    }
}
