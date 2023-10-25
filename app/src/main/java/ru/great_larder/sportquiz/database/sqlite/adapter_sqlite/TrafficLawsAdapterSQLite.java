package ru.great_larder.sportquiz.database.sqlite.adapter_sqlite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import ru.great_larder.sportquiz.database.sqlite.DatabaseHelper;
import ru.great_larder.sportquiz.domain.QuestionTrafficLaws;

import java.util.ArrayList;
import java.util.List;

public class TrafficLawsAdapterSQLite {
    private final DatabaseHelper dbHelper;
    private SQLiteDatabase database;
    
    public TrafficLawsAdapterSQLite(Context context){
        dbHelper = new DatabaseHelper(context.getApplicationContext());
    }
    
    public TrafficLawsAdapterSQLite open(){
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
        return  database.query(DatabaseHelper.TABLE_TRAFFIC_LAWS, columns, null, null, null, null, null);
    }
    
    @SuppressLint("Range")
    public List<QuestionTrafficLaws> getQuestionTrafficLaws(){
        ArrayList<QuestionTrafficLaws> questionTrafficLawsList = new ArrayList<>();
        Cursor cursor = getAllEntries();
        
        while (cursor.moveToNext()){
            QuestionTrafficLaws questionTrafficLaws = new QuestionTrafficLaws();
            questionTrafficLaws.setId(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID_QUESTION)));
            questionTrafficLaws.setQuestion(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_QUESTION)));
            questionTrafficLaws.setRightAnswer(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_RIGHT_ANSWER)));
            questionTrafficLaws.setWrongAnswer1(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_1)));
            questionTrafficLaws.setWrongAnswer2(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_2)));
            questionTrafficLaws.setWrongAnswer3(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_3)));
            questionTrafficLaws.setLink(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_LINK_QUESTION)));
            questionTrafficLaws.setLevel(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_LEVEL_QUESTION)));
            questionTrafficLawsList.add(questionTrafficLaws);
        }
        cursor.close();
        return  questionTrafficLawsList;
    }
    
    public long getCount(){
        return DatabaseUtils.queryNumEntries(database, DatabaseHelper.TABLE_TRAFFIC_LAWS);
    }
    
    @SuppressLint("Range")
    public QuestionTrafficLaws getTrafficLawsById(int id){
        QuestionTrafficLaws questionTrafficLaws = new QuestionTrafficLaws();
        String query = String.format("SELECT * FROM %s WHERE %s=?",DatabaseHelper.TABLE_TRAFFIC_LAWS, DatabaseHelper.COLUMN_ID_QUESTION);
        Cursor cursor = database.rawQuery(query, new String[]{ String.valueOf(id)});
        if(cursor.moveToFirst()){
            questionTrafficLaws.setId(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID_QUESTION)));
            questionTrafficLaws.setQuestion(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_QUESTION)));
            questionTrafficLaws.setRightAnswer(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_RIGHT_ANSWER)));
            questionTrafficLaws.setWrongAnswer1(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_1)));
            questionTrafficLaws.setWrongAnswer2(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_2)));
            questionTrafficLaws.setWrongAnswer3(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_3)));
            questionTrafficLaws.setLink(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_LINK_QUESTION)));
            questionTrafficLaws.setLevel(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_LEVEL_QUESTION)));
        }
        cursor.close();
        return  questionTrafficLaws;
    }
    
    public Integer insert(QuestionTrafficLaws questionTrafficLaws){
        
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.COLUMN_QUESTION, questionTrafficLaws.getQuestion());
        cv.put(DatabaseHelper.COLUMN_RIGHT_ANSWER, questionTrafficLaws.getRightAnswer());
        cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_1, questionTrafficLaws.getWrongAnswer1());
        cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_2, questionTrafficLaws.getWrongAnswer2());
        cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_3, questionTrafficLaws.getWrongAnswer3());
        cv.put(DatabaseHelper.COLUMN_LINK_QUESTION, questionTrafficLaws.getLink());
        cv.put(DatabaseHelper.COLUMN_LEVEL_QUESTION, questionTrafficLaws.getLevel());
        
        return Math.toIntExact(database.insert(DatabaseHelper.TABLE_TRAFFIC_LAWS, null, cv));
    }
    
    public Integer deleteTrafficLawsById(Integer trafficLawsId){
        
        String whereClause = "id = ?";
        String[] whereArgs = new String[]{String.valueOf(trafficLawsId)};
        return database.delete(DatabaseHelper.TABLE_TRAFFIC_LAWS, whereClause, whereArgs);
    }
    
    public Integer update(QuestionTrafficLaws questionTrafficLaws){
        
        String whereClause = DatabaseHelper.COLUMN_ID_QUESTION + "=" + questionTrafficLaws.getId();
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.COLUMN_QUESTION, questionTrafficLaws.getQuestion());
        cv.put(DatabaseHelper.COLUMN_RIGHT_ANSWER, questionTrafficLaws.getRightAnswer());
        cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_1, questionTrafficLaws.getWrongAnswer1());
        cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_2, questionTrafficLaws.getWrongAnswer2());
        cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_3, questionTrafficLaws.getWrongAnswer3());
        cv.put(DatabaseHelper.COLUMN_LINK_QUESTION, questionTrafficLaws.getLink());
        cv.put(DatabaseHelper.COLUMN_LEVEL_QUESTION, questionTrafficLaws.getLevel());
        
        return database.update(DatabaseHelper.TABLE_TRAFFIC_LAWS, cv, whereClause, null);
    }
    public void clearTable(){
        database.delete(DatabaseHelper.TABLE_TRAFFIC_LAWS, null, null);
    }
}
