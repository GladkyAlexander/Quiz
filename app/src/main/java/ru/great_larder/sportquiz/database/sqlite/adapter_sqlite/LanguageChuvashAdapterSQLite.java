package ru.great_larder.sportquiz.database.sqlite.adapter_sqlite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import ru.great_larder.sportquiz.database.sqlite.DatabaseHelper;
import ru.great_larder.sportquiz.domain.QuestionChuvashLanguage;

import java.util.ArrayList;
import java.util.List;

public class LanguageChuvashAdapterSQLite {
	private final DatabaseHelper dbHelper;
	private SQLiteDatabase database;
	
	public LanguageChuvashAdapterSQLite(Context context){
		dbHelper = new DatabaseHelper(context.getApplicationContext());
	}
	
	public LanguageChuvashAdapterSQLite open(){
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
		return  database.query(DatabaseHelper.TABLE_LANGUAGE_CHUVASH, columns, null, null, null, null, null);
	}
	
	@SuppressLint("Range")
	public List<QuestionChuvashLanguage> getQuestionChuvashLanguage(){
		ArrayList<QuestionChuvashLanguage> questionChuvashLanguages = new ArrayList<>();
		Cursor cursor = getAllEntries();
		
		while (cursor.moveToNext()){
			QuestionChuvashLanguage questionChuvashLanguage = new QuestionChuvashLanguage();
			questionChuvashLanguage.setId(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID_QUESTION)));
			questionChuvashLanguage.setQuestion(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_QUESTION)));
			questionChuvashLanguage.setRightAnswer(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_RIGHT_ANSWER)));
			questionChuvashLanguage.setWrongAnswer1(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_1)));
			questionChuvashLanguage.setWrongAnswer2(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_2)));
			questionChuvashLanguage.setWrongAnswer3(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_3)));
			questionChuvashLanguage.setLink(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_LINK_QUESTION)));
			questionChuvashLanguage.setLevel(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_LEVEL_QUESTION)));
			questionChuvashLanguages.add(questionChuvashLanguage);
		}
		cursor.close();
		return  questionChuvashLanguages;
	}
	
	public long getCount(){
		return DatabaseUtils.queryNumEntries(database, DatabaseHelper.TABLE_LANGUAGE_CHUVASH);
	}
	
	@SuppressLint("Range")
	public QuestionChuvashLanguage getChuvashLanguageById(int id){
		QuestionChuvashLanguage questionChuvashLanguage = new QuestionChuvashLanguage();
		String query = String.format("SELECT * FROM %s WHERE %s=?",DatabaseHelper.TABLE_LANGUAGE_CHUVASH, DatabaseHelper.COLUMN_ID_QUESTION);
		Cursor cursor = database.rawQuery(query, new String[]{ String.valueOf(id)});
		if(cursor.moveToFirst()){
			questionChuvashLanguage.setId(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID_QUESTION)));
			questionChuvashLanguage.setQuestion(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_QUESTION)));
			questionChuvashLanguage.setRightAnswer(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_RIGHT_ANSWER)));
			questionChuvashLanguage.setWrongAnswer1(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_1)));
			questionChuvashLanguage.setWrongAnswer2(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_2)));
			questionChuvashLanguage.setWrongAnswer3(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_3)));
			questionChuvashLanguage.setLink(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_LINK_QUESTION)));
			questionChuvashLanguage.setLevel(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_LEVEL_QUESTION)));
		}
		cursor.close();
		return  questionChuvashLanguage;
	}
	
	public Integer insert(QuestionChuvashLanguage questionChuvashLanguage){
		
		ContentValues cv = new ContentValues();
		cv.put(DatabaseHelper.COLUMN_QUESTION, questionChuvashLanguage.getQuestion());
		cv.put(DatabaseHelper.COLUMN_RIGHT_ANSWER, questionChuvashLanguage.getRightAnswer());
		cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_1, questionChuvashLanguage.getWrongAnswer1());
		cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_2, questionChuvashLanguage.getWrongAnswer2());
		cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_3, questionChuvashLanguage.getWrongAnswer3());
		cv.put(DatabaseHelper.COLUMN_LINK_QUESTION, questionChuvashLanguage.getLink());
		cv.put(DatabaseHelper.COLUMN_LEVEL_QUESTION, questionChuvashLanguage.getLevel());
		
		return Math.toIntExact(database.insert(DatabaseHelper.TABLE_LANGUAGE_CHUVASH, null, cv));
	}
	public boolean setList(List<QuestionChuvashLanguage> questionLanguageChuvash){
		for (QuestionChuvashLanguage questionChuvashLanguage : questionLanguageChuvash) {
			ContentValues cv = new ContentValues();
			cv.put(DatabaseHelper.COLUMN_QUESTION, questionChuvashLanguage.getQuestion());
			cv.put(DatabaseHelper.COLUMN_RIGHT_ANSWER, questionChuvashLanguage.getRightAnswer());
			cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_1, questionChuvashLanguage.getWrongAnswer1());
			cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_2, questionChuvashLanguage.getWrongAnswer2());
			cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_3, questionChuvashLanguage.getWrongAnswer3());
			cv.put(DatabaseHelper.COLUMN_LINK_QUESTION, questionChuvashLanguage.getLink());
			cv.put(DatabaseHelper.COLUMN_LEVEL_QUESTION, questionChuvashLanguage.getLevel());
			database.insert(DatabaseHelper.TABLE_LANGUAGE_CHUVASH, null, cv);
		}
		return true;
	}
	public Integer deleteLanguageChuvashById(Integer languageChuvashId){
		
		String whereClause = "id = ?";
		String[] whereArgs = new String[]{String.valueOf(languageChuvashId)};
		return database.delete(DatabaseHelper.TABLE_LANGUAGE_CHUVASH, whereClause, whereArgs);
	}
	
	public Integer update(QuestionChuvashLanguage questionChuvashLanguage){
		
		String whereClause = DatabaseHelper.COLUMN_ID_QUESTION + "=" + questionChuvashLanguage.getId();
		ContentValues cv = new ContentValues();
		cv.put(DatabaseHelper.COLUMN_QUESTION, questionChuvashLanguage.getQuestion());
		cv.put(DatabaseHelper.COLUMN_RIGHT_ANSWER, questionChuvashLanguage.getRightAnswer());
		cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_1, questionChuvashLanguage.getWrongAnswer1());
		cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_2, questionChuvashLanguage.getWrongAnswer2());
		cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_3, questionChuvashLanguage.getWrongAnswer3());
		cv.put(DatabaseHelper.COLUMN_LINK_QUESTION, questionChuvashLanguage.getLink());
		cv.put(DatabaseHelper.COLUMN_LEVEL_QUESTION, questionChuvashLanguage.getLevel());
		
		return database.update(DatabaseHelper.TABLE_LANGUAGE_CHUVASH, cv, whereClause, null);
	}
	public void clearTable(){
		database.delete(DatabaseHelper.TABLE_LANGUAGE_CHUVASH, null, null);
	}
}
