package ru.great_larder.sportquiz.database.sqlite.adapter_sqlite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import ru.great_larder.sportquiz.database.sqlite.DatabaseHelper;
import ru.great_larder.sportquiz.domain.QuestionHistory;

import java.util.ArrayList;
import java.util.List;

public class HistoryAdapterSQLite {
    private final DatabaseHelper dbHelper;
    private SQLiteDatabase database;
    
    public HistoryAdapterSQLite(Context context){
        dbHelper = new DatabaseHelper(context.getApplicationContext());
    }
    
    public HistoryAdapterSQLite open(){
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
        return  database.query(DatabaseHelper.TABLE_HISTORY, columns, null, null, null, null, null);
    }
    
    @SuppressLint("Range")
    public List<QuestionHistory> getQuestionHistory(){
        ArrayList<QuestionHistory> questionListHistoryList = new ArrayList<>();
        Cursor cursor = getAllEntries();
        
        while (cursor.moveToNext()){
            QuestionHistory questionHistory = new QuestionHistory();
            questionHistory.setId(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID_QUESTION)));
            questionHistory.setQuestion(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_QUESTION)));
            questionHistory.setRightAnswer(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_RIGHT_ANSWER)));
            questionHistory.setWrongAnswer1(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_1)));
            questionHistory.setWrongAnswer2(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_2)));
            questionHistory.setWrongAnswer3(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_3)));
            questionHistory.setLink(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_LINK_QUESTION)));
            questionHistory.setLevel(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_LEVEL_QUESTION)));
            questionListHistoryList.add(questionHistory);
        }
        cursor.close();
        return  questionListHistoryList;
    }
    
    public long getCount(){
        return DatabaseUtils.queryNumEntries(database, DatabaseHelper.TABLE_HISTORY);
    }
    
    @SuppressLint("Range")
    public QuestionHistory getHistoryById(int id){
        QuestionHistory questionHistory = new QuestionHistory();
        String query = String.format("SELECT * FROM %s WHERE %s=?",DatabaseHelper.TABLE_HISTORY, DatabaseHelper.COLUMN_ID_QUESTION);
        Cursor cursor = database.rawQuery(query, new String[]{ String.valueOf(id)});
        if(cursor.moveToFirst()){
            questionHistory.setId(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID_QUESTION)));
            questionHistory.setQuestion(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_QUESTION)));
            questionHistory.setRightAnswer(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_RIGHT_ANSWER)));
            questionHistory.setWrongAnswer1(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_1)));
            questionHistory.setWrongAnswer2(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_2)));
            questionHistory.setWrongAnswer3(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_3)));
            questionHistory.setLink(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_LINK_QUESTION)));
            questionHistory.setLevel(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_LEVEL_QUESTION)));
        }
        cursor.close();
        return  questionHistory;
    }
    
    public Integer insert(QuestionHistory questionHistory){
        
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.COLUMN_QUESTION, questionHistory.getQuestion());
        cv.put(DatabaseHelper.COLUMN_RIGHT_ANSWER, questionHistory.getRightAnswer());
        cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_1, questionHistory.getWrongAnswer1());
        cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_2, questionHistory.getWrongAnswer2());
        cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_3, questionHistory.getWrongAnswer3());
        cv.put(DatabaseHelper.COLUMN_LINK_QUESTION, questionHistory.getLink());
        cv.put(DatabaseHelper.COLUMN_LEVEL_QUESTION, questionHistory.getLevel());
        
        return Math.toIntExact(database.insert(DatabaseHelper.TABLE_HISTORY, null, cv));
    }
    public boolean setList(List<QuestionHistory> histories){
        for (QuestionHistory questionHistory : histories) {
            ContentValues cv = new ContentValues();
            cv.put(DatabaseHelper.COLUMN_QUESTION, questionHistory.getQuestion());
            cv.put(DatabaseHelper.COLUMN_RIGHT_ANSWER, questionHistory.getRightAnswer());
            cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_1, questionHistory.getWrongAnswer1());
            cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_2, questionHistory.getWrongAnswer2());
            cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_3, questionHistory.getWrongAnswer3());
            cv.put(DatabaseHelper.COLUMN_LINK_QUESTION, questionHistory.getLink());
            cv.put(DatabaseHelper.COLUMN_LEVEL_QUESTION, questionHistory.getLevel());
            database.insert(DatabaseHelper.TABLE_HISTORY, null, cv);
        }
        return true;
    }
    public Integer deleteHistoryById(Integer historyId){
        
        String whereClause = "id = ?";
        String[] whereArgs = new String[]{String.valueOf(historyId)};
        return database.delete(DatabaseHelper.TABLE_HISTORY, whereClause, whereArgs);
    }
    
    public Integer update(QuestionHistory questionHistory){
        
        String whereClause = DatabaseHelper.COLUMN_ID_QUESTION + "=" + questionHistory.getId();
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.COLUMN_QUESTION, questionHistory.getQuestion());
        cv.put(DatabaseHelper.COLUMN_RIGHT_ANSWER, questionHistory.getRightAnswer());
        cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_1, questionHistory.getWrongAnswer1());
        cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_2, questionHistory.getWrongAnswer2());
        cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_3, questionHistory.getWrongAnswer3());
        cv.put(DatabaseHelper.COLUMN_LINK_QUESTION, questionHistory.getLink());
        cv.put(DatabaseHelper.COLUMN_LEVEL_QUESTION, questionHistory.getLevel());
        
        return database.update(DatabaseHelper.TABLE_HISTORY, cv, whereClause, null);
    }
    public void clearTable(){
        database.delete(DatabaseHelper.TABLE_HISTORY, null, null);
    }
}
