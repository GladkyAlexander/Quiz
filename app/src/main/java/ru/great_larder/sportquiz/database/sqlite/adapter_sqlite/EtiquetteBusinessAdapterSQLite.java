package ru.great_larder.sportquiz.database.sqlite.adapter_sqlite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import ru.great_larder.sportquiz.database.sqlite.DatabaseHelper;
import ru.great_larder.sportquiz.domain.QuestionEtiquetteBusiness;

import java.util.ArrayList;
import java.util.List;

public class EtiquetteBusinessAdapterSQLite {
    private final DatabaseHelper dbHelper;
    private SQLiteDatabase database;
    
    public EtiquetteBusinessAdapterSQLite(Context context){
        dbHelper = new DatabaseHelper(context.getApplicationContext());
    }
    
    public EtiquetteBusinessAdapterSQLite open(){
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
        return  database.query(DatabaseHelper.TABLE_ETIQUETTE_BUSINESS, columns, null, null, null, null, null);
    }
    
    @SuppressLint("Range")
    public List<QuestionEtiquetteBusiness> getQuestionEtiquetteBusiness(){
        ArrayList<QuestionEtiquetteBusiness> questionListEtiquetteBusiness = new ArrayList<>();
        Cursor cursor = getAllEntries();
        
        while (cursor.moveToNext()){
            QuestionEtiquetteBusiness questionEtiquetteBusiness = new QuestionEtiquetteBusiness();
            questionEtiquetteBusiness.setId(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID_QUESTION)));
            questionEtiquetteBusiness.setQuestion(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_QUESTION)));
            questionEtiquetteBusiness.setRightAnswer(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_RIGHT_ANSWER)));
            questionEtiquetteBusiness.setWrongAnswer1(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_1)));
            questionEtiquetteBusiness.setWrongAnswer2(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_2)));
            questionEtiquetteBusiness.setWrongAnswer3(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_3)));
            questionEtiquetteBusiness.setLink(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_LINK_QUESTION)));
            questionEtiquetteBusiness.setLevel(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_LEVEL_QUESTION)));
            questionListEtiquetteBusiness.add(questionEtiquetteBusiness);
        }
        cursor.close();
        return  questionListEtiquetteBusiness;
    }
    
    public long getCount(){
        return DatabaseUtils.queryNumEntries(database, DatabaseHelper.TABLE_ETIQUETTE_BUSINESS);
    }
    
    @SuppressLint("Range")
    public QuestionEtiquetteBusiness getEtiquetteBusinessById(int id){
        QuestionEtiquetteBusiness questionEtiquetteBusiness = new QuestionEtiquetteBusiness();
        String query = String.format("SELECT * FROM %s WHERE %s=?",DatabaseHelper.TABLE_ETIQUETTE_BUSINESS, DatabaseHelper.COLUMN_ID_QUESTION);
        Cursor cursor = database.rawQuery(query, new String[]{ String.valueOf(id)});
        if(cursor.moveToFirst()){
            questionEtiquetteBusiness.setId(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID_QUESTION)));
            questionEtiquetteBusiness.setQuestion(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_QUESTION)));
            questionEtiquetteBusiness.setRightAnswer(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_RIGHT_ANSWER)));
            questionEtiquetteBusiness.setWrongAnswer1(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_1)));
            questionEtiquetteBusiness.setWrongAnswer2(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_2)));
            questionEtiquetteBusiness.setWrongAnswer3(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_3)));
            questionEtiquetteBusiness.setLink(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_LINK_QUESTION)));
            questionEtiquetteBusiness.setLevel(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_LEVEL_QUESTION)));
        }
        cursor.close();
        return  questionEtiquetteBusiness;
    }
    
    public Integer insert(QuestionEtiquetteBusiness questionEtiquetteBusiness){
        
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.COLUMN_QUESTION, questionEtiquetteBusiness.getQuestion());
        cv.put(DatabaseHelper.COLUMN_RIGHT_ANSWER, questionEtiquetteBusiness.getRightAnswer());
        cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_1, questionEtiquetteBusiness.getWrongAnswer1());
        cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_2, questionEtiquetteBusiness.getWrongAnswer2());
        cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_3, questionEtiquetteBusiness.getWrongAnswer3());
        cv.put(DatabaseHelper.COLUMN_LINK_QUESTION, questionEtiquetteBusiness.getLink());
        cv.put(DatabaseHelper.COLUMN_LEVEL_QUESTION, questionEtiquetteBusiness.getLevel());
        
        return Math.toIntExact(database.insert(DatabaseHelper.TABLE_ETIQUETTE_BUSINESS, null, cv));
    }
    public boolean setList(List<QuestionEtiquetteBusiness> questionEtiquetteBusinessList){
        for (QuestionEtiquetteBusiness questionEtiquetteBusiness : questionEtiquetteBusinessList) {
            ContentValues cv = new ContentValues();
            cv.put(DatabaseHelper.COLUMN_QUESTION, questionEtiquetteBusiness.getQuestion());
            cv.put(DatabaseHelper.COLUMN_RIGHT_ANSWER, questionEtiquetteBusiness.getRightAnswer());
            cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_1, questionEtiquetteBusiness.getWrongAnswer1());
            cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_2, questionEtiquetteBusiness.getWrongAnswer2());
            cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_3, questionEtiquetteBusiness.getWrongAnswer3());
            cv.put(DatabaseHelper.COLUMN_LINK_QUESTION, questionEtiquetteBusiness.getLink());
            cv.put(DatabaseHelper.COLUMN_LEVEL_QUESTION, questionEtiquetteBusiness.getLevel());
            database.insert(DatabaseHelper.TABLE_ETIQUETTE_BUSINESS, null, cv);
        }
        return true;
    }
    public Integer deleteEtiquetteBusinessById(Integer etiquetteBusinessId){
        
        String whereClause = "id = ?";
        String[] whereArgs = new String[]{String.valueOf(etiquetteBusinessId)};
        return database.delete(DatabaseHelper.TABLE_ETIQUETTE_BUSINESS, whereClause, whereArgs);
    }
    
    public Integer update(QuestionEtiquetteBusiness questionEtiquetteBusiness){
        
        String whereClause = DatabaseHelper.COLUMN_ID_QUESTION + "=" + questionEtiquetteBusiness.getId();
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.COLUMN_QUESTION, questionEtiquetteBusiness.getQuestion());
        cv.put(DatabaseHelper.COLUMN_RIGHT_ANSWER, questionEtiquetteBusiness.getRightAnswer());
        cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_1, questionEtiquetteBusiness.getWrongAnswer1());
        cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_2, questionEtiquetteBusiness.getWrongAnswer2());
        cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_3, questionEtiquetteBusiness.getWrongAnswer3());
        cv.put(DatabaseHelper.COLUMN_LINK_QUESTION, questionEtiquetteBusiness.getLink());
        cv.put(DatabaseHelper.COLUMN_LEVEL_QUESTION, questionEtiquetteBusiness.getLevel());
        
        return database.update(DatabaseHelper.TABLE_ETIQUETTE_BUSINESS, cv, whereClause, null);
    }
    public void clearTable(){
        database.delete(DatabaseHelper.TABLE_ETIQUETTE_BUSINESS, null, null);
    }
}
