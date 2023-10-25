package ru.great_larder.sportquiz.database.sqlite.adapter_sqlite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import ru.great_larder.sportquiz.database.sqlite.DatabaseHelper;
import ru.great_larder.sportquiz.domain.QuestionPhysics;

import java.util.ArrayList;
import java.util.List;

public class PhysicsAdapterSQLite {
    private final DatabaseHelper dbHelper;
    private SQLiteDatabase database;
    
    public PhysicsAdapterSQLite(Context context){
        dbHelper = new DatabaseHelper(context.getApplicationContext());
    }
    
    public PhysicsAdapterSQLite open(){
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
        return  database.query(DatabaseHelper.TABLE_PHYSICS, columns, null, null, null, null, null);
    }
    
    @SuppressLint("Range")
    public List<QuestionPhysics> getQuestionPhysics(){
        ArrayList<QuestionPhysics> questionPhysics1 = new ArrayList<>();
        Cursor cursor = getAllEntries();
        
        while (cursor.moveToNext()){
            QuestionPhysics questionPhysics = new QuestionPhysics();
            questionPhysics.setId(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID_QUESTION)));
            questionPhysics.setQuestion(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_QUESTION)));
            questionPhysics.setRightAnswer(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_RIGHT_ANSWER)));
            questionPhysics.setWrongAnswer1(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_1)));
            questionPhysics.setWrongAnswer2(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_2)));
            questionPhysics.setWrongAnswer3(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_3)));
            questionPhysics.setLink(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_LINK_QUESTION)));
            questionPhysics.setLevel(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_LEVEL_QUESTION)));
            questionPhysics1.add(questionPhysics);
        }
        cursor.close();
        return  questionPhysics1;
    }
    
    public long getCount(){
        return DatabaseUtils.queryNumEntries(database, DatabaseHelper.TABLE_PHYSICS);
    }
    
    @SuppressLint("Range")
    public QuestionPhysics getPhysicsById(int id){
        QuestionPhysics questionPhysics = new QuestionPhysics();
        String query = String.format("SELECT * FROM %s WHERE %s=?",DatabaseHelper.TABLE_PHYSICS, DatabaseHelper.COLUMN_ID_QUESTION);
        Cursor cursor = database.rawQuery(query, new String[]{ String.valueOf(id)});
        if(cursor.moveToFirst()){
            questionPhysics.setId(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID_QUESTION)));
            questionPhysics.setQuestion(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_QUESTION)));
            questionPhysics.setRightAnswer(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_RIGHT_ANSWER)));
            questionPhysics.setWrongAnswer1(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_1)));
            questionPhysics.setWrongAnswer2(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_2)));
            questionPhysics.setWrongAnswer3(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_3)));
            questionPhysics.setLink(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_LINK_QUESTION)));
            questionPhysics.setLevel(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_LEVEL_QUESTION)));
        }
        cursor.close();
        return  questionPhysics;
    }
    
    public Integer insert(QuestionPhysics questionPhysics){
        
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.COLUMN_QUESTION, questionPhysics.getQuestion());
        cv.put(DatabaseHelper.COLUMN_RIGHT_ANSWER, questionPhysics.getRightAnswer());
        cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_1, questionPhysics.getWrongAnswer1());
        cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_2, questionPhysics.getWrongAnswer2());
        cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_3, questionPhysics.getWrongAnswer3());
        cv.put(DatabaseHelper.COLUMN_LINK_QUESTION, questionPhysics.getLink());
        cv.put(DatabaseHelper.COLUMN_LEVEL_QUESTION, questionPhysics.getLevel());
        
        return Math.toIntExact(database.insert(DatabaseHelper.TABLE_PHYSICS, null, cv));
    }
    
    public Integer deletePhysicsById(Integer physicsId){
        
        String whereClause = "id = ?";
        String[] whereArgs = new String[]{String.valueOf(physicsId)};
        return database.delete(DatabaseHelper.TABLE_PHYSICS, whereClause, whereArgs);
    }
    
    public Integer update(QuestionPhysics questionPhysics){
        
        String whereClause = DatabaseHelper.COLUMN_ID_QUESTION + "=" + questionPhysics.getId();
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.COLUMN_QUESTION, questionPhysics.getQuestion());
        cv.put(DatabaseHelper.COLUMN_RIGHT_ANSWER, questionPhysics.getRightAnswer());
        cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_1, questionPhysics.getWrongAnswer1());
        cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_2, questionPhysics.getWrongAnswer2());
        cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_3, questionPhysics.getWrongAnswer3());
        cv.put(DatabaseHelper.COLUMN_LINK_QUESTION, questionPhysics.getLink());
        cv.put(DatabaseHelper.COLUMN_LEVEL_QUESTION, questionPhysics.getLevel());
        
        return database.update(DatabaseHelper.TABLE_PHYSICS, cv, whereClause, null);
    }
    public void clearTable(){
        database.delete(DatabaseHelper.TABLE_PHYSICS, null, null);
    }
}
