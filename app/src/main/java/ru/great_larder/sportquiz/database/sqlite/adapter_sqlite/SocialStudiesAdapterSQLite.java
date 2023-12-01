package ru.great_larder.sportquiz.database.sqlite.adapter_sqlite;


import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import ru.great_larder.sportquiz.database.sqlite.DatabaseHelper;
import ru.great_larder.sportquiz.domain.QuestionSocialStudies;

import java.util.ArrayList;
import java.util.List;

public class SocialStudiesAdapterSQLite {
	private final DatabaseHelper dbHelper;
	private SQLiteDatabase database;
	
	public SocialStudiesAdapterSQLite(Context context){
		dbHelper = new DatabaseHelper(context.getApplicationContext());
	}
	
	public SocialStudiesAdapterSQLite open(){
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
		return  database.query(DatabaseHelper.TABLE_SOCIAL_STUDIES, columns, null, null, null, null, null);
	}
	
	@SuppressLint("Range")
	public List<QuestionSocialStudies> getQuestionSocialStudies(){
		ArrayList<QuestionSocialStudies> questionsSocialStudies = new ArrayList<>();
		Cursor cursor = getAllEntries();
		
		while (cursor.moveToNext()){
			QuestionSocialStudies questionSocialStudies = new QuestionSocialStudies();
			questionSocialStudies.setId(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID_QUESTION)));
			questionSocialStudies.setQuestion(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_QUESTION)));
			questionSocialStudies.setRightAnswer(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_RIGHT_ANSWER)));
			questionSocialStudies.setWrongAnswer1(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_1)));
			questionSocialStudies.setWrongAnswer2(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_2)));
			questionSocialStudies.setWrongAnswer3(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_3)));
			questionSocialStudies.setLink(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_LINK_QUESTION)));
			questionSocialStudies.setLevel(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_LEVEL_QUESTION)));
			questionsSocialStudies.add(questionSocialStudies);
		}
		cursor.close();
		return  questionsSocialStudies;
	}
	
	public long getCount(){
		return DatabaseUtils.queryNumEntries(database, DatabaseHelper.TABLE_SOCIAL_STUDIES);
	}
	
	@SuppressLint("Range")
	public QuestionSocialStudies getSocialStudiesById(int id){
		QuestionSocialStudies questionSocialStudies = new QuestionSocialStudies();
		String query = String.format("SELECT * FROM %s WHERE %s=?",DatabaseHelper.TABLE_SOCIAL_STUDIES, DatabaseHelper.COLUMN_ID_QUESTION);
		Cursor cursor = database.rawQuery(query, new String[]{ String.valueOf(id)});
		if(cursor.moveToFirst()){
			questionSocialStudies.setId(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID_QUESTION)));
			questionSocialStudies.setQuestion(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_QUESTION)));
			questionSocialStudies.setRightAnswer(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_RIGHT_ANSWER)));
			questionSocialStudies.setWrongAnswer1(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_1)));
			questionSocialStudies.setWrongAnswer2(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_2)));
			questionSocialStudies.setWrongAnswer3(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WRONG_ANSWER_3)));
			questionSocialStudies.setLink(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_LINK_QUESTION)));
			questionSocialStudies.setLevel(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_LEVEL_QUESTION)));
		}
		cursor.close();
		return  questionSocialStudies;
	}
	
	public Integer insert(QuestionSocialStudies questionSocialStudies){
		
		ContentValues cv = new ContentValues();
		cv.put(DatabaseHelper.COLUMN_QUESTION, questionSocialStudies.getQuestion());
		cv.put(DatabaseHelper.COLUMN_RIGHT_ANSWER, questionSocialStudies.getRightAnswer());
		cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_1, questionSocialStudies.getWrongAnswer1());
		cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_2, questionSocialStudies.getWrongAnswer2());
		cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_3, questionSocialStudies.getWrongAnswer3());
		cv.put(DatabaseHelper.COLUMN_LINK_QUESTION, questionSocialStudies.getLink());
		cv.put(DatabaseHelper.COLUMN_LEVEL_QUESTION, questionSocialStudies.getLevel());
		
		return Math.toIntExact(database.insert(DatabaseHelper.TABLE_SOCIAL_STUDIES, null, cv));
	}
	public boolean setList(List<QuestionSocialStudies> questionSocialStudies){
		for (QuestionSocialStudies questionsSocialStudies : questionSocialStudies) {
			ContentValues cv = new ContentValues();
			cv.put(DatabaseHelper.COLUMN_QUESTION, questionsSocialStudies.getQuestion());
			cv.put(DatabaseHelper.COLUMN_RIGHT_ANSWER, questionsSocialStudies.getRightAnswer());
			cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_1, questionsSocialStudies.getWrongAnswer1());
			cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_2, questionsSocialStudies.getWrongAnswer2());
			cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_3, questionsSocialStudies.getWrongAnswer3());
			cv.put(DatabaseHelper.COLUMN_LINK_QUESTION, questionsSocialStudies.getLink());
			cv.put(DatabaseHelper.COLUMN_LEVEL_QUESTION, questionsSocialStudies.getLevel());
			database.insert(DatabaseHelper.TABLE_SOCIAL_STUDIES, null, cv);
		}
		return true;
	}
	public Integer deleteSocialStudiesById(Integer socialStudiesId){
		
		String whereClause = "id = ?";
		String[] whereArgs = new String[]{String.valueOf(socialStudiesId)};
		return database.delete(DatabaseHelper.TABLE_SOCIAL_STUDIES, whereClause, whereArgs);
	}
	
	public Integer update(QuestionSocialStudies questionSocialStudies){
		
		String whereClause = DatabaseHelper.COLUMN_ID_QUESTION + "=" + questionSocialStudies.getId();
		ContentValues cv = new ContentValues();
		cv.put(DatabaseHelper.COLUMN_QUESTION, questionSocialStudies.getQuestion());
		cv.put(DatabaseHelper.COLUMN_RIGHT_ANSWER, questionSocialStudies.getRightAnswer());
		cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_1, questionSocialStudies.getWrongAnswer1());
		cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_2, questionSocialStudies.getWrongAnswer2());
		cv.put(DatabaseHelper.COLUMN_WRONG_ANSWER_3, questionSocialStudies.getWrongAnswer3());
		cv.put(DatabaseHelper.COLUMN_LINK_QUESTION, questionSocialStudies.getLink());
		cv.put(DatabaseHelper.COLUMN_LEVEL_QUESTION, questionSocialStudies.getLevel());
		
		return database.update(DatabaseHelper.TABLE_SOCIAL_STUDIES, cv, whereClause, null);
	}
	public void clearTable(){
		database.delete(DatabaseHelper.TABLE_SOCIAL_STUDIES, null, null);
	}
}
