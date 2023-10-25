package ru.great_larder.sportquiz.database.sqlite.adapter_sqlite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import ru.great_larder.sportquiz.database.sqlite.DatabaseHelper;
import ru.great_larder.sportquiz.domain.QuestionEtiquetteSecular;

import java.util.ArrayList;
import java.util.List;

public class EtiquetteSecularAdapterSQLite {
    private final DatabaseHelper dbHelper;
    private SQLiteDatabase database;
    
    public EtiquetteSecularAdapterSQLite(Context context){
        dbHelper = new DatabaseHelper(context.getApplicationContext());
    }
    
    public EtiquetteSecularAdapterSQLite open(){
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
        return  database.query(DatabaseHelper.TABLE_ETIQUETTE_SECULAR, columns, null, null, null, null, null);
    }
    
    @SuppressLint("Range")
    public List<QuestionEtiquetteSecular> getQuestionEtiquetteSecular(){
        ArrayList<QuestionEtiquetteSecular> questionListEtiquetteSecular = new ArrayList<>();
        Cursor cursor = getAllEntries();
        
        while (cursor.moveToNext()){
            QuestionEtiquetteSecular questionEtiquetteSecular = new QuestionEtiquetteSecular();
            questionEtiquetteSecular.setId(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID_QUESTION)));
            questionEtiquetteSecular.setQuestion(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_QUESTION)));
            questionEtiquetteSecular.setRightAnswer(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_RIGHT_ANSWER)));
            questionEtiquetteSecular.setWrongAnswer1(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_1)));
            questionEtiquetteSecular.setWrongAnswer2(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_2)));
            questionEtiquetteSecular.setWrongAnswer3(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_3)));
            questionEtiquetteSecular.setLink(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_LINK_QUESTION)));
            questionEtiquetteSecular.setLevel(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_LEVEL_QUESTION)));
            questionListEtiquetteSecular.add(questionEtiquetteSecular);
        }
        cursor.close();
        return  questionListEtiquetteSecular;
    }
    
    public long getCount(){
        return DatabaseUtils.queryNumEntries(database, DatabaseHelper.TABLE_ETIQUETTE_SECULAR);
    }
    
    @SuppressLint("Range")
    public QuestionEtiquetteSecular getEtiquetteSecularById(int id){
        QuestionEtiquetteSecular questionEtiquetteSecular = new QuestionEtiquetteSecular();
        String query = String.format("SELECT * FROM %s WHERE %s=?",DatabaseHelper.TABLE_ETIQUETTE_SECULAR, DatabaseHelper.COLUMN_ID_QUESTION);
        Cursor cursor = database.rawQuery(query, new String[]{ String.valueOf(id)});
        if(cursor.moveToFirst()){
            questionEtiquetteSecular.setId(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID_QUESTION)));
            questionEtiquetteSecular.setQuestion(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_QUESTION)));
            questionEtiquetteSecular.setRightAnswer(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_RIGHT_ANSWER)));
            questionEtiquetteSecular.setWrongAnswer1(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_1)));
            questionEtiquetteSecular.setWrongAnswer2(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_2)));
            questionEtiquetteSecular.setWrongAnswer3(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_3)));
            questionEtiquetteSecular.setLink(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_LINK_QUESTION)));
            questionEtiquetteSecular.setLevel(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_LEVEL_QUESTION)));
        }
        cursor.close();
        return  questionEtiquetteSecular;
    }
    
    public Integer insert(QuestionEtiquetteSecular questionEtiquetteSecular){
        
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.COLUMN_QUESTION, questionEtiquetteSecular.getQuestion());
        cv.put(DatabaseHelper.COLUMN_RIGHT_ANSWER, questionEtiquetteSecular.getRightAnswer());
        cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_1, questionEtiquetteSecular.getWrongAnswer1());
        cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_2, questionEtiquetteSecular.getWrongAnswer2());
        cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_3, questionEtiquetteSecular.getWrongAnswer3());
        cv.put(DatabaseHelper.COLUMN_LINK_QUESTION, questionEtiquetteSecular.getLink());
        cv.put(DatabaseHelper.COLUMN_LEVEL_QUESTION, questionEtiquetteSecular.getLevel());
        
        return Math.toIntExact(database.insert(DatabaseHelper.TABLE_ETIQUETTE_SECULAR, null, cv));
    }
    
    public Integer deleteEtiquetteSecularById(Integer etiquetteSecularId){
        
        String whereClause = "id = ?";
        String[] whereArgs = new String[]{String.valueOf(etiquetteSecularId)};
        return database.delete(DatabaseHelper.TABLE_ETIQUETTE_SECULAR, whereClause, whereArgs);
    }
    
    public Integer update(QuestionEtiquetteSecular questionEtiquetteSecular){
        
        String whereClause = DatabaseHelper.COLUMN_ID_QUESTION + "=" + questionEtiquetteSecular.getId();
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.COLUMN_QUESTION, questionEtiquetteSecular.getQuestion());
        cv.put(DatabaseHelper.COLUMN_RIGHT_ANSWER, questionEtiquetteSecular.getRightAnswer());
        cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_1, questionEtiquetteSecular.getWrongAnswer1());
        cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_2, questionEtiquetteSecular.getWrongAnswer2());
        cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_3, questionEtiquetteSecular.getWrongAnswer3());
        cv.put(DatabaseHelper.COLUMN_LINK_QUESTION, questionEtiquetteSecular.getLink());
        cv.put(DatabaseHelper.COLUMN_LEVEL_QUESTION, questionEtiquetteSecular.getLevel());
        
        return database.update(DatabaseHelper.TABLE_ETIQUETTE_SECULAR, cv, whereClause, null);
    }
    public void clearTable(){
        database.delete(DatabaseHelper.TABLE_ETIQUETTE_SECULAR, null, null);
    }
}
