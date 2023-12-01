package ru.great_larder.sportquiz.database.sqlite.adapter_sqlite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import ru.great_larder.sportquiz.database.sqlite.DatabaseHelper;
import ru.great_larder.sportquiz.domain.QuestionAviationTransport;

import java.util.ArrayList;
import java.util.List;

public class AviationTransportAdapterSQLite {
	private final DatabaseHelper dbHelper;
	private SQLiteDatabase database;
	
	public AviationTransportAdapterSQLite(Context context){
		dbHelper = new DatabaseHelper(context.getApplicationContext());
	}
	
	public AviationTransportAdapterSQLite open(){
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
		return  database.query(DatabaseHelper.TABLE_AVIATION_TRANSPORT, columns, null, null, null, null, null);
	}
	
	@SuppressLint("Range")
	public List<QuestionAviationTransport> getQuestionAviationTransport(){
		ArrayList<QuestionAviationTransport> questionAviationTransportList = new ArrayList<>();
		Cursor cursor = getAllEntries();
		
		while (cursor.moveToNext()){
			QuestionAviationTransport questionAviationTransport = new QuestionAviationTransport();
			questionAviationTransport.setId(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID_QUESTION)));
			questionAviationTransport.setQuestion(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_QUESTION)));
			questionAviationTransport.setRightAnswer(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_RIGHT_ANSWER)));
			questionAviationTransport.setWrongAnswer1(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_1)));
			questionAviationTransport.setWrongAnswer2(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_2)));
			questionAviationTransport.setWrongAnswer3(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_3)));
			questionAviationTransport.setLink(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_LINK_QUESTION)));
			questionAviationTransport.setLevel(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_LEVEL_QUESTION)));
			questionAviationTransportList.add(questionAviationTransport);
		}
		cursor.close();
		return  questionAviationTransportList;
	}
	
	public long getCount(){
		return DatabaseUtils.queryNumEntries(database, DatabaseHelper.TABLE_AVIATION_TRANSPORT);
	}
	
	@SuppressLint("Range")
	public QuestionAviationTransport getAviationTransportById(int id){
		QuestionAviationTransport questionAviationTransport = new QuestionAviationTransport();
		String query = String.format("SELECT * FROM %s WHERE %s=?",DatabaseHelper.TABLE_AVIATION_TRANSPORT, DatabaseHelper.COLUMN_ID_QUESTION);
		Cursor cursor = database.rawQuery(query, new String[]{ String.valueOf(id)});
		if(cursor.moveToFirst()){
			questionAviationTransport.setId(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID_QUESTION)));
			questionAviationTransport.setQuestion(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_QUESTION)));
			questionAviationTransport.setRightAnswer(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_RIGHT_ANSWER)));
			questionAviationTransport.setWrongAnswer1(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_1)));
			questionAviationTransport.setWrongAnswer2(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_2)));
			questionAviationTransport.setWrongAnswer3(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_3)));
			questionAviationTransport.setLink(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_LINK_QUESTION)));
			questionAviationTransport.setLevel(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_LEVEL_QUESTION)));
		}
		cursor.close();
		return  questionAviationTransport;
	}
	
	public Integer insert(QuestionAviationTransport questionAviationTransport){
		
		ContentValues cv = new ContentValues();
		cv.put(DatabaseHelper.COLUMN_QUESTION, questionAviationTransport.getQuestion());
		cv.put(DatabaseHelper.COLUMN_RIGHT_ANSWER, questionAviationTransport.getRightAnswer());
		cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_1, questionAviationTransport.getWrongAnswer1());
		cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_2, questionAviationTransport.getWrongAnswer2());
		cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_3, questionAviationTransport.getWrongAnswer3());
		cv.put(DatabaseHelper.COLUMN_LINK_QUESTION, questionAviationTransport.getLink());
		cv.put(DatabaseHelper.COLUMN_LEVEL_QUESTION, questionAviationTransport.getLevel());
		
		return Math.toIntExact(database.insert(DatabaseHelper.TABLE_AVIATION_TRANSPORT, null, cv));
	}
	public boolean setList(List<QuestionAviationTransport> questionAviationTransportList){
		for (QuestionAviationTransport questionAviationTransport : questionAviationTransportList) {
			ContentValues cv = new ContentValues();
			cv.put(DatabaseHelper.COLUMN_QUESTION, questionAviationTransport.getQuestion());
			cv.put(DatabaseHelper.COLUMN_RIGHT_ANSWER, questionAviationTransport.getRightAnswer());
			cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_1, questionAviationTransport.getWrongAnswer1());
			cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_2, questionAviationTransport.getWrongAnswer2());
			cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_3, questionAviationTransport.getWrongAnswer3());
			cv.put(DatabaseHelper.COLUMN_LINK_QUESTION, questionAviationTransport.getLink());
			cv.put(DatabaseHelper.COLUMN_LEVEL_QUESTION, questionAviationTransport.getLevel());
			database.insert(DatabaseHelper.TABLE_AVIATION_TRANSPORT, null, cv);
		}
		return true;
	}
	public Integer deleteAviationTransportById(Integer aviationTransporttId){
		
		String whereClause = "id = ?";
		String[] whereArgs = new String[]{String.valueOf(aviationTransporttId)};
		return database.delete(DatabaseHelper.TABLE_AVIATION_TRANSPORT, whereClause, whereArgs);
	}
	
	public Integer update(QuestionAviationTransport questionAviationTransport){
		
		String whereClause = DatabaseHelper.COLUMN_ID_QUESTION + "=" + questionAviationTransport.getId();
		ContentValues cv = new ContentValues();
		cv.put(DatabaseHelper.COLUMN_QUESTION, questionAviationTransport.getQuestion());
		cv.put(DatabaseHelper.COLUMN_RIGHT_ANSWER, questionAviationTransport.getRightAnswer());
		cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_1, questionAviationTransport.getWrongAnswer1());
		cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_2, questionAviationTransport.getWrongAnswer2());
		cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_3, questionAviationTransport.getWrongAnswer3());
		cv.put(DatabaseHelper.COLUMN_LINK_QUESTION, questionAviationTransport.getLink());
		cv.put(DatabaseHelper.COLUMN_LEVEL_QUESTION, questionAviationTransport.getLevel());
		
		return database.update(DatabaseHelper.TABLE_AVIATION_TRANSPORT, cv, whereClause, null);
	}
	public void clearTable(){
		database.delete(DatabaseHelper.TABLE_AVIATION_TRANSPORT, null, null);
	}
}

