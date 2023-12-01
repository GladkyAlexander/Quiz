package ru.great_larder.sportquiz.database.sqlite.adapter_sqlite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import ru.great_larder.sportquiz.database.sqlite.DatabaseHelper;
import ru.great_larder.sportquiz.domain.QuestionChechenLanguage;

import java.util.ArrayList;
import java.util.List;

public class LanguageChechenAdapterSQLite {
	private final DatabaseHelper dbHelper;
	private SQLiteDatabase database;
	
	public LanguageChechenAdapterSQLite(Context context){
		dbHelper = new DatabaseHelper(context.getApplicationContext());
	}
	
	public LanguageChechenAdapterSQLite open(){
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
		return  database.query(DatabaseHelper.TABLE_LANGUAGE_CHECHEN, columns, null, null, null, null, null);
	}
	
	@SuppressLint("Range")
	public List<QuestionChechenLanguage> getQuestionChechenLanquage(){
		ArrayList<QuestionChechenLanguage> questionChechenLanguageList = new ArrayList<>();
		Cursor cursor = getAllEntries();
		
		while (cursor.moveToNext()){
			QuestionChechenLanguage questionChechenLanquage = new QuestionChechenLanguage();
			questionChechenLanquage.setId(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID_QUESTION)));
			questionChechenLanquage.setQuestion(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_QUESTION)));
			questionChechenLanquage.setRightAnswer(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_RIGHT_ANSWER)));
			questionChechenLanquage.setWrongAnswer1(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_1)));
			questionChechenLanquage.setWrongAnswer2(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_2)));
			questionChechenLanquage.setWrongAnswer3(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_3)));
			questionChechenLanquage.setLink(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_LINK_QUESTION)));
			questionChechenLanquage.setLevel(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_LEVEL_QUESTION)));
			questionChechenLanguageList.add(questionChechenLanquage);
		}
		cursor.close();
		return  questionChechenLanguageList;
	}
	
	public long getCount(){
		return DatabaseUtils.queryNumEntries(database, DatabaseHelper.TABLE_LANGUAGE_CHECHEN);
	}
	
	@SuppressLint("Range")
	public QuestionChechenLanguage getChechenLanquageById(int id){
		QuestionChechenLanguage questionChechenLanquage = new QuestionChechenLanguage();
		String query = String.format("SELECT * FROM %s WHERE %s=?",DatabaseHelper.TABLE_LANGUAGE_CHECHEN, DatabaseHelper.COLUMN_ID_QUESTION);
		Cursor cursor = database.rawQuery(query, new String[]{ String.valueOf(id)});
		if(cursor.moveToFirst()){
			questionChechenLanquage.setId(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID_QUESTION)));
			questionChechenLanquage.setQuestion(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_QUESTION)));
			questionChechenLanquage.setRightAnswer(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_RIGHT_ANSWER)));
			questionChechenLanquage.setWrongAnswer1(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_1)));
			questionChechenLanquage.setWrongAnswer2(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_2)));
			questionChechenLanquage.setWrongAnswer3(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_3)));
			questionChechenLanquage.setLink(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_LINK_QUESTION)));
			questionChechenLanquage.setLevel(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_LEVEL_QUESTION)));
		}
		cursor.close();
		return  questionChechenLanquage;
	}
	
	public Integer insert(QuestionChechenLanguage questionChechenLanquage){
		
		ContentValues cv = new ContentValues();
		cv.put(DatabaseHelper.COLUMN_QUESTION, questionChechenLanquage.getQuestion());
		cv.put(DatabaseHelper.COLUMN_RIGHT_ANSWER, questionChechenLanquage.getRightAnswer());
		cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_1, questionChechenLanquage.getWrongAnswer1());
		cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_2, questionChechenLanquage.getWrongAnswer2());
		cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_3, questionChechenLanquage.getWrongAnswer3());
		cv.put(DatabaseHelper.COLUMN_LINK_QUESTION, questionChechenLanquage.getLink());
		cv.put(DatabaseHelper.COLUMN_LEVEL_QUESTION, questionChechenLanquage.getLevel());
		
		return Math.toIntExact(database.insert(DatabaseHelper.TABLE_LANGUAGE_CHECHEN, null, cv));
	}
	public boolean setList(List<QuestionChechenLanguage> questionChechenLanquageList){
		for (QuestionChechenLanguage questionChechenLanquage : questionChechenLanquageList) {
			ContentValues cv = new ContentValues();
			cv.put(DatabaseHelper.COLUMN_QUESTION, questionChechenLanquage.getQuestion());
			cv.put(DatabaseHelper.COLUMN_RIGHT_ANSWER, questionChechenLanquage.getRightAnswer());
			cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_1, questionChechenLanquage.getWrongAnswer1());
			cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_2, questionChechenLanquage.getWrongAnswer2());
			cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_3, questionChechenLanquage.getWrongAnswer3());
			cv.put(DatabaseHelper.COLUMN_LINK_QUESTION, questionChechenLanquage.getLink());
			cv.put(DatabaseHelper.COLUMN_LEVEL_QUESTION, questionChechenLanquage.getLevel());
			database.insert(DatabaseHelper.TABLE_LANGUAGE_CHECHEN, null, cv);
		}
		return true;
	}
	public Integer deleteChechenLanquageById(Integer chechenLanquageId){
		
		String whereClause = "id = ?";
		String[] whereArgs = new String[]{String.valueOf(chechenLanquageId)};
		return database.delete(DatabaseHelper.TABLE_LANGUAGE_CHECHEN, whereClause, whereArgs);
	}
	
	public Integer update(QuestionChechenLanguage questionChechenLanquage){
		
		String whereClause = DatabaseHelper.COLUMN_ID_QUESTION + "=" + questionChechenLanquage.getId();
		ContentValues cv = new ContentValues();
		cv.put(DatabaseHelper.COLUMN_QUESTION, questionChechenLanquage.getQuestion());
		cv.put(DatabaseHelper.COLUMN_RIGHT_ANSWER, questionChechenLanquage.getRightAnswer());
		cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_1, questionChechenLanquage.getWrongAnswer1());
		cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_2, questionChechenLanquage.getWrongAnswer2());
		cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_3, questionChechenLanquage.getWrongAnswer3());
		cv.put(DatabaseHelper.COLUMN_LINK_QUESTION, questionChechenLanquage.getLink());
		cv.put(DatabaseHelper.COLUMN_LEVEL_QUESTION, questionChechenLanquage.getLevel());
		
		return database.update(DatabaseHelper.TABLE_LANGUAGE_CHECHEN, cv, whereClause, null);
	}
	public void clearTable(){
		database.delete(DatabaseHelper.TABLE_LANGUAGE_CHECHEN, null, null);
	}
}
