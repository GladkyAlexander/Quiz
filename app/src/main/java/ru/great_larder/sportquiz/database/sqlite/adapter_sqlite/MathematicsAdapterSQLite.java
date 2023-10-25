package ru.great_larder.sportquiz.database.sqlite.adapter_sqlite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import ru.great_larder.sportquiz.database.sqlite.DatabaseHelper;
import ru.great_larder.sportquiz.domain.QuestionMathematics;

import java.util.ArrayList;
import java.util.List;

public class MathematicsAdapterSQLite {
    
    private final DatabaseHelper dbHelper;
    private SQLiteDatabase database;
    
    public MathematicsAdapterSQLite(Context context){
        dbHelper = new DatabaseHelper(context.getApplicationContext());
    }
    
    public MathematicsAdapterSQLite open(){
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
        return  database.query(DatabaseHelper.TABLE_MATHEMATICS, columns, null, null, null, null, null);
    }
    
    @SuppressLint("Range")
    public List<QuestionMathematics> getQuestionMathematics(){
        ArrayList<QuestionMathematics> questionMathematics1 = new ArrayList<>();
        Cursor cursor = getAllEntries();
        
        while (cursor.moveToNext()){
            QuestionMathematics questionMathematics = new QuestionMathematics();
            questionMathematics.setId(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID_QUESTION)));
            questionMathematics.setQuestion(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_QUESTION)));
            questionMathematics.setRightAnswer(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_RIGHT_ANSWER)));
            questionMathematics.setWrongAnswer1(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_1)));
            questionMathematics.setWrongAnswer2(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_2)));
            questionMathematics.setWrongAnswer3(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_3)));
            questionMathematics.setLink(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_LINK_QUESTION)));
            questionMathematics.setLevel(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_LEVEL_QUESTION)));
            questionMathematics1.add(questionMathematics);
        }
        cursor.close();
        return  questionMathematics1;
    }
    
    public long getCount(){
        return DatabaseUtils.queryNumEntries(database, DatabaseHelper.TABLE_MATHEMATICS);
    }
    
    @SuppressLint("Range")
    public QuestionMathematics getMathematicsById(int id){
        QuestionMathematics questionMathematics = new QuestionMathematics();
        String query = String.format("SELECT * FROM %s WHERE %s=?",DatabaseHelper.TABLE_MATHEMATICS, DatabaseHelper.COLUMN_ID_QUESTION);
        Cursor cursor = database.rawQuery(query, new String[]{ String.valueOf(id)});
        if(cursor.moveToFirst()){
            questionMathematics.setId(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID_QUESTION)));
            questionMathematics.setQuestion(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_QUESTION)));
            questionMathematics.setRightAnswer(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_RIGHT_ANSWER)));
            questionMathematics.setWrongAnswer1(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_1)));
            questionMathematics.setWrongAnswer2(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_2)));
            questionMathematics.setWrongAnswer3(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_3)));
            questionMathematics.setLink(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_LINK_QUESTION)));
            questionMathematics.setLevel(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_LEVEL_QUESTION)));
        }
        cursor.close();
        return  questionMathematics;
    }
    
    public Integer insert(QuestionMathematics questionMathematics){
        
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.COLUMN_QUESTION, questionMathematics.getQuestion());
        cv.put(DatabaseHelper.COLUMN_RIGHT_ANSWER, questionMathematics.getRightAnswer());
        cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_1, questionMathematics.getWrongAnswer1());
        cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_2, questionMathematics.getWrongAnswer2());
        cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_3, questionMathematics.getWrongAnswer3());
        cv.put(DatabaseHelper.COLUMN_LINK_QUESTION, questionMathematics.getLink());
        cv.put(DatabaseHelper.COLUMN_LEVEL_QUESTION, questionMathematics.getLevel());
        
        return Math.toIntExact(database.insert(DatabaseHelper.TABLE_MATHEMATICS, null, cv));
    }
    
    public Integer deleteMathematicsById(Integer mathematicsId){
        
        String whereClause = "id = ?";
        String[] whereArgs = new String[]{String.valueOf(mathematicsId)};
        return database.delete(DatabaseHelper.TABLE_MATHEMATICS, whereClause, whereArgs);
    }
    
    public Integer update(QuestionMathematics questionMathematics){
        
        String whereClause = DatabaseHelper.COLUMN_ID_QUESTION + "=" + questionMathematics.getId();
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.COLUMN_QUESTION, questionMathematics.getQuestion());
        cv.put(DatabaseHelper.COLUMN_RIGHT_ANSWER, questionMathematics.getRightAnswer());
        cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_1, questionMathematics.getWrongAnswer1());
        cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_2, questionMathematics.getWrongAnswer2());
        cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_3, questionMathematics.getWrongAnswer3());
        cv.put(DatabaseHelper.COLUMN_LINK_QUESTION, questionMathematics.getLink());
        cv.put(DatabaseHelper.COLUMN_LEVEL_QUESTION, questionMathematics.getLevel());
        
        return database.update(DatabaseHelper.TABLE_MATHEMATICS, cv, whereClause, null);
    }
    public void clearTable(){
        database.delete(DatabaseHelper.TABLE_MATHEMATICS, null, null);
    }

}
