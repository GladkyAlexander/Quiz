package ru.great_larder.sportquiz.database.sqlite.adapter_sqlite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import ru.great_larder.sportquiz.database.sqlite.DatabaseHelper;
import ru.great_larder.sportquiz.domain.Author;

import java.util.ArrayList;
import java.util.List;

public class AuthorAdapterSQLite {
    private final DatabaseHelper dbHelper;
    private SQLiteDatabase database;
    
    public AuthorAdapterSQLite(Context context){
        dbHelper = new DatabaseHelper(context.getApplicationContext());
    }
    
    public AuthorAdapterSQLite open(){
        database = dbHelper.getWritableDatabase();
        return this;
    }
    
    public void close(){
        dbHelper.close();
    }
    
    private Cursor getAllEntries(){
        String[] columns = new String[] {DatabaseHelper.COLUMN_ID_AUTHOR, DatabaseHelper.COLUMN_LASTNAME_AUTHOR, DatabaseHelper.COLUMN_FIRSTNAME_AUTHOR
            , DatabaseHelper.COLUMN_ABOUT_ME_AUTHOR, DatabaseHelper.COLUMN_LINK_AUTHOR, DatabaseHelper.COLUMN_PHOTO_AUTHOR};
        return  database.query(DatabaseHelper.TABLE_AUTHOR, columns, null, null, null, null, null);
    }
    
    @SuppressLint("Range")
    public List<Author> getAuthors(){
        ArrayList<Author> authors = new ArrayList<>();
        Cursor cursor = getAllEntries();
        while (cursor.moveToNext()){
            Author author = new Author();
            author.setId(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID_AUTHOR)));
            author.setFirstNameAuthor(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_FIRSTNAME_AUTHOR)));
            author.setLastNameAuthor(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_LASTNAME_AUTHOR)));
            author.setAboutMe(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_ABOUT_ME_AUTHOR)));
            author.setLink(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_LINK_AUTHOR)));
            author.setPhoto(cursor.getBlob(cursor.getColumnIndex(DatabaseHelper.COLUMN_PHOTO_AUTHOR)));
            authors.add(author);
        }
        cursor.close();
        return  authors;
    }
    
    public long getCount(){
        return DatabaseUtils.queryNumEntries(database, DatabaseHelper.TABLE_AUTHOR);
    }
    
    @SuppressLint("Range")
    public Author getAuthorById(int id){
        Author author = new Author();
        String query = String.format("SELECT * FROM %s WHERE %s=?",DatabaseHelper.TABLE_AUTHOR, DatabaseHelper.COLUMN_ID_AUTHOR);
        Cursor cursor = database.rawQuery(query, new String[]{ String.valueOf(id)});
        if(cursor.moveToFirst()){
            author.setId(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID_AUTHOR)));
            author.setFirstNameAuthor(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_FIRSTNAME_AUTHOR)));
            author.setLastNameAuthor(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_LASTNAME_AUTHOR)));
            author.setAboutMe(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_ABOUT_ME_AUTHOR)));
            author.setLink(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_LINK_AUTHOR)));
            author.setPhoto(cursor.getBlob(cursor.getColumnIndex(DatabaseHelper.COLUMN_PHOTO_AUTHOR)));
        }
        cursor.close();
        return  author;
    }
    
    public Integer insert(Author author){
        
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.COLUMN_ID_AUTHOR, author.getId());
        cv.put(DatabaseHelper.COLUMN_FIRSTNAME_AUTHOR, author.getFirstNameAuthor());
        cv.put(DatabaseHelper.COLUMN_LASTNAME_AUTHOR, author.getLastNameAuthor());
        cv.put(DatabaseHelper.COLUMN_ABOUT_ME_AUTHOR, author.getAboutMe());
        cv.put(DatabaseHelper.COLUMN_LINK_AUTHOR, author.getLink());
        cv.put(DatabaseHelper.COLUMN_PHOTO_AUTHOR, author.getPhoto());
        
        return Math.toIntExact(database.insert(DatabaseHelper.TABLE_AUTHOR, null, cv));
    }
    
    public Integer deleteUserById(long authorId){
        
        String whereClause = "id = ?";
        String[] whereArgs = new String[]{String.valueOf(authorId)};
        return database.delete(DatabaseHelper.TABLE_AUTHOR, whereClause, whereArgs);
    }
    
    public Integer update(Author author){
        
        String whereClause = DatabaseHelper.COLUMN_ID_AUTHOR + "=" + author.getId();
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.COLUMN_FIRSTNAME_AUTHOR, author.getFirstNameAuthor());
        cv.put(DatabaseHelper.COLUMN_LASTNAME_AUTHOR, author.getLastNameAuthor());
        cv.put(DatabaseHelper.COLUMN_ABOUT_ME_AUTHOR, author.getAboutMe());
        cv.put(DatabaseHelper.COLUMN_LINK_AUTHOR, author.getLink());
        cv.put(DatabaseHelper.COLUMN_PHOTO_AUTHOR, author.getPhoto());
        
        return database.update(DatabaseHelper.TABLE_AUTHOR, cv, whereClause, null);
    }
    public void clearTable(){
        database.delete(DatabaseHelper.TABLE_AUTHOR, null, null);
    }
}
