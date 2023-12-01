package ru.great_larder.sportquiz.database.sqlite.adapter_sqlite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import ru.great_larder.sportquiz.database.sqlite.DatabaseHelper;
import ru.great_larder.sportquiz.domain.QuestionRoadTransport;

import java.util.ArrayList;
import java.util.List;

public class RoadTransportAdapterSQLite {
	private final DatabaseHelper dbHelper;
	private SQLiteDatabase database;
	
	public RoadTransportAdapterSQLite(Context context){
		dbHelper = new DatabaseHelper(context.getApplicationContext());
	}
	
	public RoadTransportAdapterSQLite open(){
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
		return  database.query(DatabaseHelper.TABLE_ROAD_TRANSPORT, columns, null, null, null, null, null);
	}
	
	@SuppressLint("Range")
	public List<QuestionRoadTransport> getQuestionRoadTransport(){
		ArrayList<QuestionRoadTransport> questionRoadTransportList = new ArrayList<>();
		Cursor cursor = getAllEntries();
		
		while (cursor.moveToNext()){
			QuestionRoadTransport questionRoadTransport = new QuestionRoadTransport();
			questionRoadTransport.setId(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID_QUESTION)));
			questionRoadTransport.setQuestion(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_QUESTION)));
			questionRoadTransport.setRightAnswer(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_RIGHT_ANSWER)));
			questionRoadTransport.setWrongAnswer1(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_1)));
			questionRoadTransport.setWrongAnswer2(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_2)));
			questionRoadTransport.setWrongAnswer3(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_3)));
			questionRoadTransport.setLink(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_LINK_QUESTION)));
			questionRoadTransport.setLevel(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_LEVEL_QUESTION)));
			questionRoadTransportList.add(questionRoadTransport);
		}
		cursor.close();
		return  questionRoadTransportList;
	}
	
	public long getCount(){
		return DatabaseUtils.queryNumEntries(database, DatabaseHelper.TABLE_ROAD_TRANSPORT);
	}
	
	@SuppressLint("Range")
	public QuestionRoadTransport getRoadTransportById(int id){
		QuestionRoadTransport questionRoadTransport = new QuestionRoadTransport();
		String query = String.format("SELECT * FROM %s WHERE %s=?",DatabaseHelper.TABLE_ROAD_TRANSPORT, DatabaseHelper.COLUMN_ID_QUESTION);
		Cursor cursor = database.rawQuery(query, new String[]{ String.valueOf(id)});
		if(cursor.moveToFirst()){
			questionRoadTransport.setId(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID_QUESTION)));
			questionRoadTransport.setQuestion(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_QUESTION)));
			questionRoadTransport.setRightAnswer(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_RIGHT_ANSWER)));
			questionRoadTransport.setWrongAnswer1(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_1)));
			questionRoadTransport.setWrongAnswer2(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_2)));
			questionRoadTransport.setWrongAnswer3(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_3)));
			questionRoadTransport.setLink(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_LINK_QUESTION)));
			questionRoadTransport.setLevel(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_LEVEL_QUESTION)));
		}
		cursor.close();
		return  questionRoadTransport;
	}
	
	public Integer insert(QuestionRoadTransport questionRoadTransport){
		
		ContentValues cv = new ContentValues();
		cv.put(DatabaseHelper.COLUMN_QUESTION, questionRoadTransport.getQuestion());
		cv.put(DatabaseHelper.COLUMN_RIGHT_ANSWER, questionRoadTransport.getRightAnswer());
		cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_1, questionRoadTransport.getWrongAnswer1());
		cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_2, questionRoadTransport.getWrongAnswer2());
		cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_3, questionRoadTransport.getWrongAnswer3());
		cv.put(DatabaseHelper.COLUMN_LINK_QUESTION, questionRoadTransport.getLink());
		cv.put(DatabaseHelper.COLUMN_LEVEL_QUESTION, questionRoadTransport.getLevel());
		
		return Math.toIntExact(database.insert(DatabaseHelper.TABLE_ROAD_TRANSPORT, null, cv));
	}
	public boolean setList(List<QuestionRoadTransport> questionRoadTransportList){
		for (QuestionRoadTransport questionRoadTransport : questionRoadTransportList) {
			ContentValues cv = new ContentValues();
			cv.put(DatabaseHelper.COLUMN_QUESTION, questionRoadTransport.getQuestion());
			cv.put(DatabaseHelper.COLUMN_RIGHT_ANSWER, questionRoadTransport.getRightAnswer());
			cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_1, questionRoadTransport.getWrongAnswer1());
			cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_2, questionRoadTransport.getWrongAnswer2());
			cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_3, questionRoadTransport.getWrongAnswer3());
			cv.put(DatabaseHelper.COLUMN_LINK_QUESTION, questionRoadTransport.getLink());
			cv.put(DatabaseHelper.COLUMN_LEVEL_QUESTION, questionRoadTransport.getLevel());
			database.insert(DatabaseHelper.TABLE_RAILWAY_TRANSPORT, null, cv);
		}
		return true;
	}
	public Integer deleteRoadTransportById(Integer roadTransportId){
		
		String whereClause = "id = ?";
		String[] whereArgs = new String[]{String.valueOf(roadTransportId)};
		return database.delete(DatabaseHelper.TABLE_ROAD_TRANSPORT, whereClause, whereArgs);
	}
	
	public Integer update(QuestionRoadTransport questionRoadTransport){
		
		String whereClause = DatabaseHelper.COLUMN_ID_QUESTION + "=" + questionRoadTransport.getId();
		ContentValues cv = new ContentValues();
		cv.put(DatabaseHelper.COLUMN_QUESTION, questionRoadTransport.getQuestion());
		cv.put(DatabaseHelper.COLUMN_RIGHT_ANSWER, questionRoadTransport.getRightAnswer());
		cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_1, questionRoadTransport.getWrongAnswer1());
		cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_2, questionRoadTransport.getWrongAnswer2());
		cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_3, questionRoadTransport.getWrongAnswer3());
		cv.put(DatabaseHelper.COLUMN_LINK_QUESTION, questionRoadTransport.getLink());
		cv.put(DatabaseHelper.COLUMN_LEVEL_QUESTION, questionRoadTransport.getLevel());
		
		return database.update(DatabaseHelper.TABLE_ROAD_TRANSPORT, cv, whereClause, null);
	}
	public void clearTable(){
		database.delete(DatabaseHelper.TABLE_ROAD_TRANSPORT, null, null);
	}
}
