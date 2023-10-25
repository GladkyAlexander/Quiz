package ru.great_larder.sportquiz.database.sqlite.adapter_sqlite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import ru.great_larder.sportquiz.database.sqlite.DatabaseHelper;
import ru.great_larder.sportquiz.domain.CompanyPartners;

import java.util.ArrayList;
import java.util.List;

public class CompanyPartnersAdapterSQLite {
    private final DatabaseHelper dbHelper;
    private SQLiteDatabase database;
    
    public CompanyPartnersAdapterSQLite(Context context){
        dbHelper = new DatabaseHelper(context.getApplicationContext());
    }
    
    public CompanyPartnersAdapterSQLite open(){
        database = dbHelper.getWritableDatabase();
        return this;
    }
    
    public void close(){
        dbHelper.close();
    }
    
    private Cursor getAllEntries(){
        String[] columns = new String[] {DatabaseHelper.COLUMN_ID_COMPANY_PARTNERS, DatabaseHelper.COLUMN_NAME_COMPANY_PARTNERS
            , DatabaseHelper.COLUMN_ABOUT_ME_COMPANY_PARTNERS, DatabaseHelper.COLUMN_LINK_COMPANY_PARTNERS
            , DatabaseHelper.COLUMN_LOGO_COMPANY_PARTNERS};
        return  database.query(DatabaseHelper.TABLE_COMPANY, columns, null, null, null, null, null);
    }
    
    @SuppressLint("Range")
    public List<CompanyPartners> getCompanyPartners(){
        ArrayList<CompanyPartners> companyPartners = new ArrayList<>();
        Cursor cursor = getAllEntries();
        
        while (cursor.moveToNext()){
            CompanyPartners companyPartners1 = new CompanyPartners();
            companyPartners1.setId(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID_COMPANY_PARTNERS)));
            companyPartners1.setNameCompany(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_NAME_COMPANY_PARTNERS)));
            companyPartners1.setAboutMe(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_ABOUT_ME_COMPANY_PARTNERS)));
            companyPartners1.setLink(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_LINK_COMPANY_PARTNERS)));
            companyPartners1.setLogo(cursor.getBlob(cursor.getColumnIndex(DatabaseHelper.COLUMN_LOGO_COMPANY_PARTNERS)));
            companyPartners.add(companyPartners1);
        }
        cursor.close();
        return  companyPartners;
    }
    
    public long getCount(){
        return DatabaseUtils.queryNumEntries(database, DatabaseHelper.TABLE_COMPANY);
    }
    
    @SuppressLint("Range")
    public CompanyPartners getCompanyPartnersById(int id){
        CompanyPartners companyPartners = new CompanyPartners();
        String query = String.format("SELECT * FROM %s WHERE %s=?",DatabaseHelper.TABLE_COMPANY, DatabaseHelper.COLUMN_ID_COMPANY_PARTNERS);
        Cursor cursor = database.rawQuery(query, new String[]{ String.valueOf(id)});
        if(cursor.moveToFirst()){
            companyPartners.setId(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID_COMPANY_PARTNERS)));
            companyPartners.setNameCompany(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_NAME_COMPANY_PARTNERS)));
            companyPartners.setAboutMe(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_ABOUT_ME_COMPANY_PARTNERS)));
            companyPartners.setLink(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_LINK_COMPANY_PARTNERS)));
            companyPartners.setLogo(cursor.getBlob(cursor.getColumnIndex(DatabaseHelper.COLUMN_LOGO_COMPANY_PARTNERS)));
        }
        cursor.close();
        return  companyPartners;
    }
    
    public Integer insert(CompanyPartners companyPartners){
        
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.COLUMN_ID_COMPANY_PARTNERS, companyPartners.getId());
        cv.put(DatabaseHelper.COLUMN_NAME_COMPANY_PARTNERS, companyPartners.getNameCompany());
        cv.put(DatabaseHelper.COLUMN_ABOUT_ME_COMPANY_PARTNERS, companyPartners.getAboutMe());
        cv.put(DatabaseHelper.COLUMN_LINK_COMPANY_PARTNERS, companyPartners.getLink());
        cv.put(DatabaseHelper.COLUMN_LOGO_COMPANY_PARTNERS, companyPartners.getLogo());
        
        return Math.toIntExact(database.insert(DatabaseHelper.TABLE_COMPANY, null, cv));
    }
    
    public Integer deleteUserById(Integer companyId){
        
        String whereClause = "id = ?";
        String[] whereArgs = new String[]{String.valueOf(companyId)};
        return database.delete(DatabaseHelper.TABLE_COMPANY, whereClause, whereArgs);
    }
    
    public Integer update(CompanyPartners companyPartners){
        
        String whereClause = DatabaseHelper.COLUMN_ID_COMPANY_PARTNERS + "=" + companyPartners.getId();
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.COLUMN_NAME_COMPANY_PARTNERS, companyPartners.getNameCompany());
        cv.put(DatabaseHelper.COLUMN_ABOUT_ME_COMPANY_PARTNERS, companyPartners.getAboutMe());
        cv.put(DatabaseHelper.COLUMN_LINK_COMPANY_PARTNERS, companyPartners.getLink());
        cv.put(DatabaseHelper.COLUMN_LOGO_COMPANY_PARTNERS, companyPartners.getLogo());
        
        return database.update(DatabaseHelper.TABLE_COMPANY, cv, whereClause, null);
    }
    public void clearTable(){
        database.delete(DatabaseHelper.TABLE_COMPANY, null, null);
    }
}
