package ru.great_larder.sportquiz.database.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import ru.great_larder.sportquiz.database.mysql.sintax_mysql.HistoryMySQL;
import ru.great_larder.sportquiz.database.mysql.sintax_mysql.LanguageRuMySQL;
import ru.great_larder.sportquiz.database.mysql.sintax_mysql.PhysicsMySQL;
import ru.great_larder.sportquiz.database.mysql.sintax_mysql.impl.HistoryMySQLImpl;
import ru.great_larder.sportquiz.database.mysql.sintax_mysql.impl.PhysicsMySQLImpl;
import ru.great_larder.sportquiz.database.sqlite.sintax_sqlite.*;
import ru.great_larder.sportquiz.database.sqlite.sintax_sqlite.impl.*;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String TABLE_USERS = "user";
    public static final String TABLE_PUZZLE = "puzzle";
    public static final String TABLE_FAIRIES = "fairies";
    public static final String TABLE_AUTHOR = "author";
    public static final String TABLE_CITY = "city";
    public static final String TABLE_COMPANY = "company";
    public static final String TABLE_BIOLOGY = "biology";
    public static final String TABLE_ETIQUETTE_BUSINESS = "etiquette_business";
    public static final String TABLE_ETIQUETTE_SECULAR = "etiquette_secular";
    public static final String TABLE_GEOGRAPHY = "geography";
    public static final String TABLE_HISTORY = "history";
    public static final String TABLE_LANGUAGE_EN = "language_en";
    public static final String TABLE_LANGUAGE_RU = "language_ru";
    public static final String TABLE_MATHEMATICS = "mathematics";
    public static final String TABLE_PHYSICS = "physics";
    public static final String TABLE_SPORTS = "sports";
    public static final String TABLE_TRAFFIC_LAWS = "traffic_laws";
    private static final String DATABASE_NAME = "sport.db";
    private static final int SCHEMA = 9;
    
    /*------------------------------------------------ User ------------------------------------------------------*/
    
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name" ;
    /**
     * 'COLUMN_CITY' - The column was added in 2 versions of the database
     */
    public static final String COLUMN_CITY = "city" ;
    public static final String COLUMN_GLASSES = "glasses";
    public static final String COLUMN_THEME_INSTALL = "themeInstalledNow";
    
    /**
     * 'DATE_OF_BIRTH'- The column was added in 4 versions of the database
     */
    public static final String COLUMN_DATE_OF_BIRTH = "birthday" ;
    /**
     * 'AWATAR'- The column was added in 5 versions of the database
     */
    public static final String COLUMN_AWATAR = "awatar";
    /**
     * 'LASTNAME'- The column was added in 7 versions of the database
     */
    public static final String COLUMN_LASTNAME = "lastname";
    /*--------------------------------------------------- Puzzle --------------------------------------------------*/
    public static final String COLUMN_ID_PUZZLE = "id";
    public static final String COLUMN_ID_DRAWABLE_RESOURCE = "id_drawable_resource" ;
    public static final String COLUMN_ID_USER = "id_user";
    public static final String COLUMN_PRICE_1 = "price1" ;
    public static final String COLUMN_PUZZLE_1 = "puzzle1";
    public static final String COLUMN_PRICE_2 = "price2" ;
    public static final String COLUMN_PUZZLE_2 = "puzzle2";
    public static final String COLUMN_PRICE_3 = "price3" ;
    public static final String COLUMN_PUZZLE_3 = "puzzle3";
    public static final String COLUMN_PRICE_4 = "price4" ;
    public static final String COLUMN_PUZZLE_4 = "puzzle4";
    public static final String COLUMN_PRICE_5 = "price5" ;
    public static final String COLUMN_PUZZLE_5 = "puzzle5";
    public static final String COLUMN_PRICE_6 = "price6" ;
    public static final String COLUMN_PUZZLE_6 = "puzzle6";
    public static final String COLUMN_PRICE_7 = "price7" ;
    public static final String COLUMN_PUZZLE_7 = "puzzle7";
    public static final String COLUMN_PRICE_8 = "price8" ;
    public static final String COLUMN_PUZZLE_8 = "puzzle8";
    public static final String COLUMN_PRICE_9 = "price9" ;
    public static final String COLUMN_PUZZLE_9 = "puzzle9";
    public static final String COLUMN_PRICE_10 = "price10" ;
    public static final String COLUMN_PUZZLE_10 = "puzzle10";
    public static final String COLUMN_PRICE_11 = "price11" ;
    public static final String COLUMN_PUZZLE_11 = "puzzle11";
    public static final String COLUMN_PRICE_12 = "price12" ;
    public static final String COLUMN_PUZZLE_12 = "puzzle12";
    public static final String COLUMN_PRICE_13 = "price13" ;
    public static final String COLUMN_PUZZLE_13 = "puzzle13";
    public static final String COLUMN_PRICE_14 = "price14" ;
    public static final String COLUMN_PUZZLE_14 = "puzzle14";
    public static final String COLUMN_PRICE_15 = "price15" ;
    public static final String COLUMN_PUZZLE_15 = "puzzle15";
    public static final String COLUMN_PRICE_16 = "price16" ;
    public static final String COLUMN_PUZZLE_16 = "puzzle16";
    public static final String COLUMN_PRICE_17 = "price17" ;
    public static final String COLUMN_PUZZLE_17 = "puzzle17";
    public static final String COLUMN_PRICE_18 = "price18" ;
    public static final String COLUMN_PUZZLE_18 = "puzzle18";
    public static final String COLUMN_PRICE_19 = "price19" ;
    public static final String COLUMN_PUZZLE_19 = "puzzle19";
    public static final String COLUMN_PRICE_20 = "price20" ;
    public static final String COLUMN_PUZZLE_20 = "puzzle20";
    public static final String COLUMN_PRICE_21 = "price21" ;
    public static final String COLUMN_PUZZLE_21 = "puzzle21";
    public static final String COLUMN_PRICE_22 = "price22" ;
    public static final String COLUMN_PUZZLE_22 = "puzzle22";
    public static final String COLUMN_PRICE_23 = "price23" ;
    public static final String COLUMN_PUZZLE_23 = "puzzle23";
    public static final String COLUMN_PRICE_24 = "price24" ;
    public static final String COLUMN_PUZZLE_24 = "puzzle24";
    public static final String COLUMN_PRICE_25 = "price25" ;
    public static final String COLUMN_PUZZLE_25 = "puzzle25";
    public static final String COLUMN_PRICE_26 = "price26" ;
    public static final String COLUMN_PUZZLE_26 = "puzzle26";
    public static final String COLUMN_PRICE_27 = "price27" ;
    public static final String COLUMN_PUZZLE_27 = "puzzle27";
    public static final String COLUMN_PRICE_28 = "price28" ;
    public static final String COLUMN_PUZZLE_28 = "puzzle28";
    public static final String COLUMN_PRICE_29 = "price29" ;
    public static final String COLUMN_PUZZLE_29 = "puzzle29";
    public static final String COLUMN_PRICE_30 = "price20" ;
    public static final String COLUMN_PUZZLE_30 = "puzzle20";
    
    /*--------------------------------------------------- Fairies --------------------------------------------------*/
    
    public static final String COLUMN_ID_FAIRIES = "id";
    public static final String COLUMN_ID_USER_FAIRIES = "idUser" ;
    public static final String COLUMN_NAME_FAIRIES = "name";
    public static final String COLUMN_PRICE_FAIRIES = "price" ;
    public static final String COLUMN_IMAGE_FAIRIES = "imageI";
    public static final String COLUMN_DATE_START_FAIRIES = "dateStart" ;
    public static final String COLUMN_VALIDITY_PERIOD_FAIRIES = "validity_period";
    public static final String COLUMN_ACTIVITY_FAIRIES = "activity_fairies" ;
    
    /* ----------------------------------------------- Questions ----------------------------------------------------*/
    public static final String COLUMN_ID_QUESTION = "id";
    public static final String COLUMN_QUESTION = "question";
    public static final String COLUMN_RIGHT_ANSWER = "right_answer";
    public static final String COLUMN_WRONG_ANSWER_1 = "wrong_answer_1";
    public static final String COLUMN_WRONG_ANSWER_2 = "wrong_answer_2";
    public static final String COLUMN_WRONG_ANSWER_3 = "wrong_answer_3";
    public static final String COLUMN_LINK_QUESTION = "link";
    public static final String COLUMN_LEVEL_QUESTION = "level";
    public static final String COLUMN_CITY_QUESTION = "city";
    public static final String COLUMN_LINK_HISTORY_ONE_STREET = "linkHistoryOneStreet";
    public static final String COLUMN_LABEL_QUESTION_CITY = "label";
    
    /* ----------------------------------------------- Author ------------------------------------------------------ */
    
    public static final String COLUMN_ID_AUTHOR = "id";
    public static final String COLUMN_LASTNAME_AUTHOR = "lastNameAuthor";
    public static final String COLUMN_FIRSTNAME_AUTHOR = "firstNameAuthor";
    public static final String COLUMN_ABOUT_ME_AUTHOR = "aboutMe";
    public static final String COLUMN_LINK_AUTHOR = "link";
    public static final String COLUMN_PHOTO_AUTHOR = "photo";
    
    /* ----------------------------------------------- Company partners ---------------------------------------------*/
    
    public static final String COLUMN_ID_COMPANY_PARTNERS = "id";
    public static final String COLUMN_NAME_COMPANY_PARTNERS = "name";
    public static final String COLUMN_ABOUT_ME_COMPANY_PARTNERS = "aboutMe";
    public static final String COLUMN_LINK_COMPANY_PARTNERS = "link";
    public static final String COLUMN_LOGO_COMPANY_PARTNERS = "logo";
    
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, SCHEMA);
    }
    
    @Override
    public void onCreate(SQLiteDatabase db) {
        onUpgrade(db, 0, SCHEMA);
        /*db.execSQL(SQLiteUser.CREATE_TABLE_USER);
        db.execSQL(SQLitePuzzle.CREATE_TABLE_PUZZLE);
        db.execSQL(SQLiteFairies.CREATE_TABLE_FAIRIES);*/
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion < 1){
            db.execSQL(SQLiteUser.CREATE_TABLE_USER);
        }
        // add new columns to migrate to version 2
        if (oldVersion < 2) {
            if(existsColumnInTable(db, COLUMN_CITY)){
                db.execSQL("ALTER TABLE " + TABLE_USERS + " ADD COLUMN " + COLUMN_CITY + " TEXT DEFAULT null");
            }
        }
        // add new columns to migrate to version 3
        if (oldVersion < 3) {
            db.execSQL(SQLitePuzzle.CREATE_TABLE_PUZZLE);
            db.execSQL(SQLiteFairies.CREATE_TABLE_FAIRIES);
        }
        // add new columns to migrate to version 4
        if (oldVersion < 6) {
            if (existsColumnInTable(db, COLUMN_DATE_OF_BIRTH)) {
                db.execSQL("ALTER TABLE " + TABLE_USERS + " ADD COLUMN " + COLUMN_DATE_OF_BIRTH + " TEXT DEFAULT null");
            }
            if (existsColumnInTable(db, COLUMN_AWATAR)) {
                db.execSQL("ALTER TABLE " + TABLE_USERS + " ADD COLUMN " + COLUMN_AWATAR + " TEXT DEFAULT null");
            }
        }
        // add new columns to migrate to version 7
        if (oldVersion < 7) {
            if(existsColumnInTable(db, COLUMN_LASTNAME)){
                db.execSQL("ALTER TABLE " + TABLE_USERS + " ADD COLUMN " + COLUMN_LASTNAME + " TEXT DEFAULT null");
            }
        }
        if(oldVersion < 8){
           /* AuthorSQLite authorSQLite = new AuthorSQLiteImpl();
            db.execSQL(authorSQLite.CREATE(TABLE_AUTHOR));*/
        }
        if(oldVersion < 9){
            BiologySQLite biologySQLite = new BiologySQLiteImpl();
            db.execSQL(biologySQLite.CREATE(TABLE_BIOLOGY));
            CitySQLite citySQLite = new CitySQLiteImpl();
            db.execSQL(citySQLite.CREATE(TABLE_CITY));
            AuthorSQLite authorSQLite = new AuthorSQLiteImpl();
            db.execSQL(authorSQLite.CREATE(TABLE_AUTHOR));
            CompanyPartnersSQLite companyPartnersSQLite = new CompanyPartnersSQLiteImpl();
            db.execSQL(companyPartnersSQLite.CREATE(TABLE_COMPANY));
            EtiquetteBusinessSQLite etiquetteBusinessSQLite = new EtiquetteBusinessSQLiteImpl();
            db.execSQL(etiquetteBusinessSQLite.CREATE(TABLE_ETIQUETTE_BUSINESS));
            EtiquetteSecularSQLite etiquetteSecularSQLite = new EtiquetteSecularSQLiteImpl();
            db.execSQL(etiquetteSecularSQLite.CREATE(TABLE_ETIQUETTE_SECULAR));
            GeographySQLite geographySQLite = new GeographySQLiteImpl();
            db.execSQL(geographySQLite.CREATE(TABLE_GEOGRAPHY));
            LanguageEnSQLite languageEnSQLite = new LanguageEnSQLiteImpl();
            db.execSQL(languageEnSQLite.CREATE(TABLE_LANGUAGE_EN));
            LanguageRuSQLite languageRuSQLite = new LanguageRuSQLiteImpl();
            db.execSQL(languageRuSQLite.CREATE(TABLE_LANGUAGE_RU));
            MathematicsSQLite mathematicsSQLite = new MathematicsSQLiteImpl();
            db.execSQL(mathematicsSQLite.CREATE(TABLE_MATHEMATICS));
            PhysicsSQLite physicsSQLite = new PhysicsSQLiteImpl();
            db.execSQL(physicsSQLite.CREATE(TABLE_PHYSICS));
            SportsSQLite sportsSQLite = new SportsSQLiteImpl();
            db.execSQL(sportsSQLite.CREATE(TABLE_SPORTS));
            TrafficLawsSQLite trafficLawsSQLite = new TrafficLawsSQLiteImpl();
            db.execSQL(trafficLawsSQLite.CREATE(TABLE_TRAFFIC_LAWS));
            HistorySQLite historySQLite = new HistorySQLiteImpl();
            db.execSQL(historySQLite.CREATE(TABLE_HISTORY));
        }
    }
    private boolean existsColumnInTable(SQLiteDatabase inDatabase, String columnToCheck) {
        try (Cursor cursor = inDatabase.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_USERS + " LIMIT 0", null)) {
            // Query 1 row
            
            // getColumnIndex() gives us the index (0 to ...) of the column - otherwise we get a -1
            return cursor.getColumnIndex(columnToCheck) == -1;
            
        } catch (Exception Exp) {
            return true;
        }
    }
}