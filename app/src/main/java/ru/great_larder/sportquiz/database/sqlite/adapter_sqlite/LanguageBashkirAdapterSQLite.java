package ru.great_larder.sportquiz.database.sqlite.adapter_sqlite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import ru.great_larder.sportquiz.database.sqlite.DatabaseHelper;
import ru.great_larder.sportquiz.domain.QuestionBashkirLanguage;

import java.util.ArrayList;
import java.util.List;

public class LanguageBashkirAdapterSQLite {
	private final DatabaseHelper dbHelper;
	private SQLiteDatabase database;
	
	public LanguageBashkirAdapterSQLite(Context context){
		dbHelper = new DatabaseHelper(context.getApplicationContext());
	}
	
	public LanguageBashkirAdapterSQLite open(){
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
		return  database.query(DatabaseHelper.TABLE_LANGUAGE_BASHKIR, columns, null, null, null, null, null);
	}
	
	@SuppressLint("Range")
	public List<QuestionBashkirLanguage> getQuestionBashkirLanguage(){
		ArrayList<QuestionBashkirLanguage> questionBashkirLanguages = new ArrayList<>();
		Cursor cursor = getAllEntries();
 
		while (cursor.moveToNext()){
			QuestionBashkirLanguage questionBashkirLanguage = new QuestionBashkirLanguage();
			questionBashkirLanguage.setId(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID_QUESTION)));
			questionBashkirLanguage.setQuestion(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_QUESTION)));
			questionBashkirLanguage.setRightAnswer(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_RIGHT_ANSWER)));
			questionBashkirLanguage.setWrongAnswer1(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_1)));
			questionBashkirLanguage.setWrongAnswer2(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_2)));
			questionBashkirLanguage.setWrongAnswer3(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_3)));
			questionBashkirLanguage.setLink(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_LINK_QUESTION)));
			questionBashkirLanguage.setLevel(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_LEVEL_QUESTION)));
			questionBashkirLanguages.add(questionBashkirLanguage);
		}
		cursor.close();
		return  questionBashkirLanguages;
	}
	
	public long getCount(){
		return DatabaseUtils.queryNumEntries(database, DatabaseHelper.TABLE_LANGUAGE_BASHKIR);
	}
	
	@SuppressLint("Range")
	public QuestionBashkirLanguage getBashkirLanguageById(int id){
		QuestionBashkirLanguage questionBashkirLanguage = new QuestionBashkirLanguage();
		String query = String.format("SELECT * FROM %s WHERE %s=?",DatabaseHelper.TABLE_LANGUAGE_BASHKIR, DatabaseHelper.COLUMN_ID_QUESTION);
		Cursor cursor = database.rawQuery(query, new String[]{ String.valueOf(id)});
		if(cursor.moveToFirst()){
			questionBashkirLanguage.setId(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID_QUESTION)));
			questionBashkirLanguage.setQuestion(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_QUESTION)));
			questionBashkirLanguage.setRightAnswer(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_RIGHT_ANSWER)));
			questionBashkirLanguage.setWrongAnswer1(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_1)));
			questionBashkirLanguage.setWrongAnswer2(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_2)));
			questionBashkirLanguage.setWrongAnswer3(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_3)));
			questionBashkirLanguage.setLink(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_LINK_QUESTION)));
			questionBashkirLanguage.setLevel(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_LEVEL_QUESTION)));
		}
		cursor.close();
		return  questionBashkirLanguage;
	}
	
	public Integer insert(QuestionBashkirLanguage questionBashkirLanguage){
		
		ContentValues cv = new ContentValues();
		cv.put(DatabaseHelper.COLUMN_QUESTION, questionBashkirLanguage.getQuestion());
		cv.put(DatabaseHelper.COLUMN_RIGHT_ANSWER, questionBashkirLanguage.getRightAnswer());
		cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_1, questionBashkirLanguage.getWrongAnswer1());
		cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_2, questionBashkirLanguage.getWrongAnswer2());
		cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_3, questionBashkirLanguage.getWrongAnswer3());
		cv.put(DatabaseHelper.COLUMN_LINK_QUESTION, questionBashkirLanguage.getLink());
		cv.put(DatabaseHelper.COLUMN_LEVEL_QUESTION, questionBashkirLanguage.getLevel());
		
		return Math.toIntExact(database.insert(DatabaseHelper.TABLE_LANGUAGE_BASHKIR, null, cv));
	}
	public boolean setList(List<QuestionBashkirLanguage> questionLanguageBashkir){
		for (QuestionBashkirLanguage questionBashkirLanguage : questionLanguageBashkir) {
			ContentValues cv = new ContentValues();
			cv.put(DatabaseHelper.COLUMN_QUESTION, questionBashkirLanguage.getQuestion());
			cv.put(DatabaseHelper.COLUMN_RIGHT_ANSWER, questionBashkirLanguage.getRightAnswer());
			cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_1, questionBashkirLanguage.getWrongAnswer1());
			cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_2, questionBashkirLanguage.getWrongAnswer2());
			cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_3, questionBashkirLanguage.getWrongAnswer3());
			cv.put(DatabaseHelper.COLUMN_LINK_QUESTION, questionBashkirLanguage.getLink());
			cv.put(DatabaseHelper.COLUMN_LEVEL_QUESTION, questionBashkirLanguage.getLevel());
			database.insert(DatabaseHelper.TABLE_LANGUAGE_BASHKIR, null, cv);
		}
		return true;
	}
	public Integer deleteLanguageBashkirById(Integer languageBashkirId){
		
		String whereClause = "id = ?";
		String[] whereArgs = new String[]{String.valueOf(languageBashkirId)};
		return database.delete(DatabaseHelper.TABLE_LANGUAGE_BASHKIR, whereClause, whereArgs);
	}
	
	public Integer update(QuestionBashkirLanguage questionBashkirLanguage){
		
		String whereClause = DatabaseHelper.COLUMN_ID_QUESTION + "=" + questionBashkirLanguage.getId();
		ContentValues cv = new ContentValues();
		cv.put(DatabaseHelper.COLUMN_QUESTION, questionBashkirLanguage.getQuestion());
		cv.put(DatabaseHelper.COLUMN_RIGHT_ANSWER, questionBashkirLanguage.getRightAnswer());
		cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_1, questionBashkirLanguage.getWrongAnswer1());
		cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_2, questionBashkirLanguage.getWrongAnswer2());
		cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_3, questionBashkirLanguage.getWrongAnswer3());
		cv.put(DatabaseHelper.COLUMN_LINK_QUESTION, questionBashkirLanguage.getLink());
		cv.put(DatabaseHelper.COLUMN_LEVEL_QUESTION, questionBashkirLanguage.getLevel());
		
		return database.update(DatabaseHelper.TABLE_LANGUAGE_BASHKIR, cv, whereClause, null);
	}
	public void clearTable(){
		database.delete(DatabaseHelper.TABLE_LANGUAGE_BASHKIR, null, null);
	}
}

