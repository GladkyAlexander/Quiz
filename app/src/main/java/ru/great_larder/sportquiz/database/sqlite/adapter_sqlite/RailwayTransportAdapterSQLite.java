package ru.great_larder.sportquiz.database.sqlite.adapter_sqlite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import ru.great_larder.sportquiz.database.sqlite.DatabaseHelper;
import ru.great_larder.sportquiz.domain.QuestionRailwayTransport;

import java.util.ArrayList;
import java.util.List;

public class RailwayTransportAdapterSQLite {
	private final DatabaseHelper dbHelper;
	private SQLiteDatabase database;
	
	public RailwayTransportAdapterSQLite(Context context){
		dbHelper = new DatabaseHelper(context.getApplicationContext());
	}
	
	public RailwayTransportAdapterSQLite open(){
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
		return  database.query(DatabaseHelper.TABLE_RAILWAY_TRANSPORT, columns, null, null, null, null, null);
	}
	
	@SuppressLint("Range")
	public List<QuestionRailwayTransport> getQuestionRailwayTransport(){
		ArrayList<QuestionRailwayTransport> questionRailwayTransportList = new ArrayList<>();
		Cursor cursor = getAllEntries();
		
		while (cursor.moveToNext()){
			QuestionRailwayTransport questionRailwayTransport = new QuestionRailwayTransport();
			questionRailwayTransport.setId(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID_QUESTION)));
			questionRailwayTransport.setQuestion(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_QUESTION)));
			questionRailwayTransport.setRightAnswer(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_RIGHT_ANSWER)));
			questionRailwayTransport.setWrongAnswer1(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_1)));
			questionRailwayTransport.setWrongAnswer2(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_2)));
			questionRailwayTransport.setWrongAnswer3(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_3)));
			questionRailwayTransport.setLink(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_LINK_QUESTION)));
			questionRailwayTransport.setLevel(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_LEVEL_QUESTION)));
			questionRailwayTransportList.add(questionRailwayTransport);
		}
		cursor.close();
		return  questionRailwayTransportList;
	}
	
	public long getCount(){
		return DatabaseUtils.queryNumEntries(database, DatabaseHelper.TABLE_RAILWAY_TRANSPORT);
	}
	
	@SuppressLint("Range")
	public QuestionRailwayTransport getRailwayTransportById(int id){
		QuestionRailwayTransport questionRailwayTransport = new QuestionRailwayTransport();
		String query = String.format("SELECT * FROM %s WHERE %s=?",DatabaseHelper.TABLE_RAILWAY_TRANSPORT, DatabaseHelper.COLUMN_ID_QUESTION);
		Cursor cursor = database.rawQuery(query, new String[]{ String.valueOf(id)});
		if(cursor.moveToFirst()){
			questionRailwayTransport.setId(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID_QUESTION)));
			questionRailwayTransport.setQuestion(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_QUESTION)));
			questionRailwayTransport.setRightAnswer(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_RIGHT_ANSWER)));
			questionRailwayTransport.setWrongAnswer1(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_1)));
			questionRailwayTransport.setWrongAnswer2(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_2)));
			questionRailwayTransport.setWrongAnswer3(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_3)));
			questionRailwayTransport.setLink(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_LINK_QUESTION)));
			questionRailwayTransport.setLevel(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_LEVEL_QUESTION)));
		}
		cursor.close();
		return  questionRailwayTransport;
	}
	
	public Integer insert(QuestionRailwayTransport questionRailwayTransport){
		
		ContentValues cv = new ContentValues();
		cv.put(DatabaseHelper.COLUMN_QUESTION, questionRailwayTransport.getQuestion());
		cv.put(DatabaseHelper.COLUMN_RIGHT_ANSWER, questionRailwayTransport.getRightAnswer());
		cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_1, questionRailwayTransport.getWrongAnswer1());
		cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_2, questionRailwayTransport.getWrongAnswer2());
		cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_3, questionRailwayTransport.getWrongAnswer3());
		cv.put(DatabaseHelper.COLUMN_LINK_QUESTION, questionRailwayTransport.getLink());
		cv.put(DatabaseHelper.COLUMN_LEVEL_QUESTION, questionRailwayTransport.getLevel());
		
		return Math.toIntExact(database.insert(DatabaseHelper.TABLE_RAILWAY_TRANSPORT, null, cv));
	}
	public boolean setList(List<QuestionRailwayTransport> questionRailwayTransportList){
		for (QuestionRailwayTransport questionRailwayTransport : questionRailwayTransportList) {
			ContentValues cv = new ContentValues();
			cv.put(DatabaseHelper.COLUMN_QUESTION, questionRailwayTransport.getQuestion());
			cv.put(DatabaseHelper.COLUMN_RIGHT_ANSWER, questionRailwayTransport.getRightAnswer());
			cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_1, questionRailwayTransport.getWrongAnswer1());
			cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_2, questionRailwayTransport.getWrongAnswer2());
			cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_3, questionRailwayTransport.getWrongAnswer3());
			cv.put(DatabaseHelper.COLUMN_LINK_QUESTION, questionRailwayTransport.getLink());
			cv.put(DatabaseHelper.COLUMN_LEVEL_QUESTION, questionRailwayTransport.getLevel());
			database.insert(DatabaseHelper.TABLE_RAILWAY_TRANSPORT, null, cv);
		}
		return true;
	}
	public Integer deleteRailwayTransportById(Integer railwayTransportId){
		
		String whereClause = "id = ?";
		String[] whereArgs = new String[]{String.valueOf(railwayTransportId)};
		return database.delete(DatabaseHelper.TABLE_RAILWAY_TRANSPORT, whereClause, whereArgs);
	}
	
	public Integer update(QuestionRailwayTransport questionRailwayTransport){
		
		String whereClause = DatabaseHelper.COLUMN_ID_QUESTION + "=" + questionRailwayTransport.getId();
		ContentValues cv = new ContentValues();
		cv.put(DatabaseHelper.COLUMN_QUESTION, questionRailwayTransport.getQuestion());
		cv.put(DatabaseHelper.COLUMN_RIGHT_ANSWER, questionRailwayTransport.getRightAnswer());
		cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_1, questionRailwayTransport.getWrongAnswer1());
		cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_2, questionRailwayTransport.getWrongAnswer2());
		cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_3, questionRailwayTransport.getWrongAnswer3());
		cv.put(DatabaseHelper.COLUMN_LINK_QUESTION, questionRailwayTransport.getLink());
		cv.put(DatabaseHelper.COLUMN_LEVEL_QUESTION, questionRailwayTransport.getLevel());
		
		return database.update(DatabaseHelper.TABLE_RAILWAY_TRANSPORT, cv, whereClause, null);
	}
	public void clearTable(){
		database.delete(DatabaseHelper.TABLE_RAILWAY_TRANSPORT, null, null);
	}
}