package ru.great_larder.sportquiz.database.sqlite.adapter_sqlite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import ru.great_larder.sportquiz.database.sqlite.DatabaseHelper;
import ru.great_larder.sportquiz.domain.QuestionTatarLanguage;

import java.util.ArrayList;
import java.util.List;

public class LanguageTatarAdapterSQLite {
	private final DatabaseHelper dbHelper;
	private SQLiteDatabase database;
	
	public LanguageTatarAdapterSQLite(Context context){
		dbHelper = new DatabaseHelper(context.getApplicationContext());
	}
	
	public LanguageTatarAdapterSQLite open(){
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
		return  database.query(DatabaseHelper.TABLE_LANGUAGE_TATAR, columns, null, null, null, null, null);
	}
	
	@SuppressLint("Range")
	public List<QuestionTatarLanguage> getQuestionTatarLanquage(){
		ArrayList<QuestionTatarLanguage> questionTatarLanguageList = new ArrayList<>();
		Cursor cursor = getAllEntries();
		
		while (cursor.moveToNext()){
			QuestionTatarLanguage questionTatarLanguage = new QuestionTatarLanguage();
			questionTatarLanguage.setId(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID_QUESTION)));
			questionTatarLanguage.setQuestion(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_QUESTION)));
			questionTatarLanguage.setRightAnswer(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_RIGHT_ANSWER)));
			questionTatarLanguage.setWrongAnswer1(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_1)));
			questionTatarLanguage.setWrongAnswer2(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_2)));
			questionTatarLanguage.setWrongAnswer3(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_3)));
			questionTatarLanguage.setLink(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_LINK_QUESTION)));
			questionTatarLanguage.setLevel(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_LEVEL_QUESTION)));
			questionTatarLanguageList.add(questionTatarLanguage);
		}
		cursor.close();
		return  questionTatarLanguageList;
	}
	
	public long getCount(){
		return DatabaseUtils.queryNumEntries(database, DatabaseHelper.TABLE_LANGUAGE_TATAR);
	}
	
	@SuppressLint("Range")
	public QuestionTatarLanguage getTatarLanguageById(int id){
		QuestionTatarLanguage questionTatarLanguage = new QuestionTatarLanguage();
		String query = String.format("SELECT * FROM %s WHERE %s=?",DatabaseHelper.TABLE_LANGUAGE_TATAR, DatabaseHelper.COLUMN_ID_QUESTION);
		Cursor cursor = database.rawQuery(query, new String[]{ String.valueOf(id)});
		if(cursor.moveToFirst()){
			questionTatarLanguage.setId(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID_QUESTION)));
			questionTatarLanguage.setQuestion(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_QUESTION)));
			questionTatarLanguage.setRightAnswer(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_RIGHT_ANSWER)));
			questionTatarLanguage.setWrongAnswer1(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_1)));
			questionTatarLanguage.setWrongAnswer2(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_2)));
			questionTatarLanguage.setWrongAnswer3(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_3)));
			questionTatarLanguage.setLink(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_LINK_QUESTION)));
			questionTatarLanguage.setLevel(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_LEVEL_QUESTION)));
		}
		cursor.close();
		return  questionTatarLanguage;
	}
	
	public Integer insert(QuestionTatarLanguage questionTatarLanguage){
		
		ContentValues cv = new ContentValues();
		cv.put(DatabaseHelper.COLUMN_QUESTION, questionTatarLanguage.getQuestion());
		cv.put(DatabaseHelper.COLUMN_RIGHT_ANSWER, questionTatarLanguage.getRightAnswer());
		cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_1, questionTatarLanguage.getWrongAnswer1());
		cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_2, questionTatarLanguage.getWrongAnswer2());
		cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_3, questionTatarLanguage.getWrongAnswer3());
		cv.put(DatabaseHelper.COLUMN_LINK_QUESTION, questionTatarLanguage.getLink());
		cv.put(DatabaseHelper.COLUMN_LEVEL_QUESTION, questionTatarLanguage.getLevel());
		
		return Math.toIntExact(database.insert(DatabaseHelper.TABLE_LANGUAGE_TATAR, null, cv));
	}
	public boolean setList(List<QuestionTatarLanguage> questionTatarLanguageList){
		for (QuestionTatarLanguage questionTatarLanguage : questionTatarLanguageList) {
			ContentValues cv = new ContentValues();
			cv.put(DatabaseHelper.COLUMN_QUESTION, questionTatarLanguage.getQuestion());
			cv.put(DatabaseHelper.COLUMN_RIGHT_ANSWER, questionTatarLanguage.getRightAnswer());
			cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_1, questionTatarLanguage.getWrongAnswer1());
			cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_2, questionTatarLanguage.getWrongAnswer2());
			cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_3, questionTatarLanguage.getWrongAnswer3());
			cv.put(DatabaseHelper.COLUMN_LINK_QUESTION, questionTatarLanguage.getLink());
			cv.put(DatabaseHelper.COLUMN_LEVEL_QUESTION, questionTatarLanguage.getLevel());
			database.insert(DatabaseHelper.TABLE_LANGUAGE_TATAR, null, cv);
		}
		return true;
	}
	public Integer deleteTatarLanguageById(Integer tatarLanguageId){
		
		String whereClause = "id = ?";
		String[] whereArgs = new String[]{String.valueOf(tatarLanguageId)};
		return database.delete(DatabaseHelper.TABLE_LANGUAGE_TATAR, whereClause, whereArgs);
	}
	
	public Integer update(QuestionTatarLanguage questionTatarLanguage){
		
		String whereClause = DatabaseHelper.COLUMN_ID_QUESTION + "=" + questionTatarLanguage.getId();
		ContentValues cv = new ContentValues();
		cv.put(DatabaseHelper.COLUMN_QUESTION, questionTatarLanguage.getQuestion());
		cv.put(DatabaseHelper.COLUMN_RIGHT_ANSWER, questionTatarLanguage.getRightAnswer());
		cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_1, questionTatarLanguage.getWrongAnswer1());
		cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_2, questionTatarLanguage.getWrongAnswer2());
		cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_3, questionTatarLanguage.getWrongAnswer3());
		cv.put(DatabaseHelper.COLUMN_LINK_QUESTION, questionTatarLanguage.getLink());
		cv.put(DatabaseHelper.COLUMN_LEVEL_QUESTION, questionTatarLanguage.getLevel());
		
		return database.update(DatabaseHelper.TABLE_LANGUAGE_TATAR, cv, whereClause, null);
	}
	public void clearTable(){
		database.delete(DatabaseHelper.TABLE_LANGUAGE_TATAR, null, null);
	}
}
