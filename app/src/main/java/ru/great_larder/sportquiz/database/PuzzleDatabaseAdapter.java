package ru.great_larder.sportquiz.database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import ru.great_larder.sportquiz.domain.Puzzle;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class PuzzleDatabaseAdapter {
    private DatabaseHelper dbHelper;
    private SQLiteDatabase database;
    
    public PuzzleDatabaseAdapter(Context context) {
        dbHelper = new DatabaseHelper(context.getApplicationContext());
    }
    public PuzzleDatabaseAdapter open(){
        database = dbHelper.getWritableDatabase();
        return this;
    }
    public void close(){
        dbHelper.close();
    }
    private Cursor getAllEntries(){
        String[] columns = new String[] {DatabaseHelper.COLUMN_ID_PUZZLE, DatabaseHelper.COLUMN_ID_DRAWABLE_RESOURCE
            , DatabaseHelper.COLUMN_ID_USER
            , DatabaseHelper.COLUMN_PRICE_1
            , DatabaseHelper.COLUMN_PUZZLE_1
            , DatabaseHelper.COLUMN_PRICE_2
            , DatabaseHelper.COLUMN_PUZZLE_2
            , DatabaseHelper.COLUMN_PRICE_3
            , DatabaseHelper.COLUMN_PUZZLE_3
            , DatabaseHelper.COLUMN_PRICE_4
            , DatabaseHelper.COLUMN_PUZZLE_4
            , DatabaseHelper.COLUMN_PRICE_5
            , DatabaseHelper.COLUMN_PUZZLE_5
            , DatabaseHelper.COLUMN_PRICE_6
            , DatabaseHelper.COLUMN_PUZZLE_6
            , DatabaseHelper.COLUMN_PRICE_7
            , DatabaseHelper.COLUMN_PUZZLE_7
            , DatabaseHelper.COLUMN_PRICE_8
            , DatabaseHelper.COLUMN_PUZZLE_8
            , DatabaseHelper.COLUMN_PRICE_9
            , DatabaseHelper.COLUMN_PUZZLE_9
            , DatabaseHelper.COLUMN_PRICE_10
            , DatabaseHelper.COLUMN_PUZZLE_10
            , DatabaseHelper.COLUMN_PRICE_11
            , DatabaseHelper.COLUMN_PUZZLE_11
            , DatabaseHelper.COLUMN_PRICE_12
            , DatabaseHelper.COLUMN_PUZZLE_12
            , DatabaseHelper.COLUMN_PRICE_13
            , DatabaseHelper.COLUMN_PUZZLE_13
            , DatabaseHelper.COLUMN_PRICE_14
            , DatabaseHelper.COLUMN_PUZZLE_14
            , DatabaseHelper.COLUMN_PRICE_15
            , DatabaseHelper.COLUMN_PUZZLE_15
            , DatabaseHelper.COLUMN_PRICE_16
            , DatabaseHelper.COLUMN_PUZZLE_16
            , DatabaseHelper.COLUMN_PRICE_17
            , DatabaseHelper.COLUMN_PUZZLE_17
            , DatabaseHelper.COLUMN_PRICE_18
            , DatabaseHelper.COLUMN_PUZZLE_18
            , DatabaseHelper.COLUMN_PRICE_19
            , DatabaseHelper.COLUMN_PUZZLE_19
            , DatabaseHelper.COLUMN_PRICE_20
            , DatabaseHelper.COLUMN_PUZZLE_20
            , DatabaseHelper.COLUMN_PRICE_21
            , DatabaseHelper.COLUMN_PUZZLE_21
            , DatabaseHelper.COLUMN_PRICE_22
            , DatabaseHelper.COLUMN_PUZZLE_22
            , DatabaseHelper.COLUMN_PRICE_23
            , DatabaseHelper.COLUMN_PUZZLE_23
            , DatabaseHelper.COLUMN_PRICE_24
            , DatabaseHelper.COLUMN_PUZZLE_24
            , DatabaseHelper.COLUMN_PRICE_25
            , DatabaseHelper.COLUMN_PUZZLE_25
            , DatabaseHelper.COLUMN_PRICE_26
            , DatabaseHelper.COLUMN_PUZZLE_26
            , DatabaseHelper.COLUMN_PRICE_27
            , DatabaseHelper.COLUMN_PUZZLE_27
            , DatabaseHelper.COLUMN_PRICE_28
            , DatabaseHelper.COLUMN_PUZZLE_28
            , DatabaseHelper.COLUMN_PRICE_29
            , DatabaseHelper.COLUMN_PUZZLE_29
            , DatabaseHelper.COLUMN_PRICE_30
            , DatabaseHelper.COLUMN_PUZZLE_30
            };
        return  database.query(DatabaseHelper.TABLE_PUZZLE, columns, null, null, null, null, null);
    }
    @SuppressLint("Range")
    public List<Puzzle> getPuzzles(){
        List<Puzzle> puzzles = new ArrayList<>();
        Cursor cursor = getAllEntries();
        
        while (cursor.moveToNext()){
            Puzzle puzzle = new Puzzle();
            puzzle.setId(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID_PUZZLE)));
            puzzle.setId_drawable_resource(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID_DRAWABLE_RESOURCE)));
            puzzle.setId_user(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID_USER)));
            puzzle.setPrice1(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PRICE_1)));
            puzzle.setPuzzle1(getP(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PUZZLE_1))));
            puzzle.setPrice2(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PRICE_2)));
            puzzle.setPuzzle2(getP(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PUZZLE_2))));
            puzzle.setPrice3(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PRICE_3)));
            puzzle.setPuzzle3(getP(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PUZZLE_3))));
            puzzle.setPrice4(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PRICE_4)));
            puzzle.setPuzzle4(getP(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PUZZLE_4))));
            puzzle.setPrice5(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PRICE_5)));
            puzzle.setPuzzle5(getP(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PUZZLE_5))));
            puzzle.setPrice6(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PRICE_6)));
            puzzle.setPuzzle6(getP(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PUZZLE_6))));
            puzzle.setPrice7(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PRICE_7)));
            puzzle.setPuzzle7(getP(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PUZZLE_7))));
            puzzle.setPrice8(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PRICE_8)));
            puzzle.setPuzzle8(getP(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PUZZLE_8))));
            puzzle.setPrice9(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PRICE_9)));
            puzzle.setPuzzle9(getP(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PUZZLE_9))));
            puzzle.setPrice10(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PRICE_10)));
            puzzle.setPuzzle10(getP(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PUZZLE_10))));
            puzzle.setPrice11(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PRICE_11)));
            puzzle.setPuzzle11(getP(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PUZZLE_11))));
            puzzle.setPrice12(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PRICE_12)));
            puzzle.setPuzzle12(getP(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PUZZLE_12))));
            puzzle.setPrice13(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PRICE_13)));
            puzzle.setPuzzle13(getP(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PUZZLE_13))));
            puzzle.setPrice14(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PRICE_14)));
            puzzle.setPuzzle14(getP(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PUZZLE_14))));
            puzzle.setPrice15(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PRICE_15)));
            puzzle.setPuzzle15(getP(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PUZZLE_15))));
            puzzle.setPrice16(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PRICE_16)));
            puzzle.setPuzzle16(getP(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PUZZLE_16))));
            puzzle.setPrice17(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PRICE_17)));
            puzzle.setPuzzle17(getP(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PUZZLE_17))));
            puzzle.setPrice18(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PRICE_18)));
            puzzle.setPuzzle18(getP(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PUZZLE_18))));
            puzzle.setPrice19(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PRICE_19)));
            puzzle.setPuzzle19(getP(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PUZZLE_19))));
            puzzle.setPrice20(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PRICE_20)));
            puzzle.setPuzzle20(getP(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PUZZLE_20))));
            puzzle.setPrice21(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PRICE_21)));
            puzzle.setPuzzle21(getP(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PUZZLE_21))));
            puzzle.setPrice22(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PRICE_22)));
            puzzle.setPuzzle22(getP(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PUZZLE_22))));
            puzzle.setPrice23(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PRICE_23)));
            puzzle.setPuzzle23(getP(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PUZZLE_23))));
            puzzle.setPrice24(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PRICE_24)));
            puzzle.setPuzzle24(getP(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PUZZLE_24))));
            puzzle.setPrice25(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PRICE_25)));
            puzzle.setPuzzle25(getP(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PUZZLE_25))));
            puzzle.setPrice26(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PRICE_26)));
            puzzle.setPuzzle26(getP(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PUZZLE_26))));
            puzzle.setPrice27(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PRICE_27)));
            puzzle.setPuzzle27(getP(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PUZZLE_27))));
            puzzle.setPrice28(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PRICE_28)));
            puzzle.setPuzzle28(getP(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PUZZLE_28))));
            puzzle.setPrice29(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PRICE_29)));
            puzzle.setPuzzle29(getP(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PUZZLE_29))));
            puzzle.setPrice30(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PRICE_30)));
            puzzle.setPuzzle30(getP(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PUZZLE_30))));
            puzzles.add(puzzle);
        }
        cursor.close();
        return puzzles;
    }
    private boolean getP(Integer value){
        return value != 0;
    }
    public Integer insert(Puzzle puzzle){
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.COLUMN_ID_PUZZLE, puzzle.getId());
        cv.put(DatabaseHelper.COLUMN_ID_DRAWABLE_RESOURCE, puzzle.getId_drawable_resource());
        cv.put(DatabaseHelper.COLUMN_ID_USER, puzzle.getId_user());
        cv.put(DatabaseHelper.COLUMN_PRICE_1, puzzle.getPrice1());
        cv.put(DatabaseHelper.COLUMN_PUZZLE_1, getPI(puzzle.isPuzzle1()));
        cv.put(DatabaseHelper.COLUMN_PRICE_2, puzzle.getPrice2());
        cv.put(DatabaseHelper.COLUMN_PUZZLE_2, getPI(puzzle.isPuzzle2()));
        cv.put(DatabaseHelper.COLUMN_PRICE_3, puzzle.getPrice3());
        cv.put(DatabaseHelper.COLUMN_PUZZLE_3, getPI(puzzle.isPuzzle3()));
        cv.put(DatabaseHelper.COLUMN_PRICE_4, puzzle.getPrice4());
        cv.put(DatabaseHelper.COLUMN_PUZZLE_4, getPI(puzzle.isPuzzle4()));
        cv.put(DatabaseHelper.COLUMN_PRICE_5, puzzle.getPrice5());
        cv.put(DatabaseHelper.COLUMN_PUZZLE_5, getPI(puzzle.isPuzzle5()));
        cv.put(DatabaseHelper.COLUMN_PRICE_6, puzzle.getPrice6());
        cv.put(DatabaseHelper.COLUMN_PUZZLE_6, getPI(puzzle.isPuzzle6()));
        cv.put(DatabaseHelper.COLUMN_PRICE_7, puzzle.getPrice7());
        cv.put(DatabaseHelper.COLUMN_PUZZLE_7, getPI(puzzle.isPuzzle7()));
        cv.put(DatabaseHelper.COLUMN_PRICE_8, puzzle.getPrice8());
        cv.put(DatabaseHelper.COLUMN_PUZZLE_8, getPI(puzzle.isPuzzle8()));
        cv.put(DatabaseHelper.COLUMN_PRICE_9, puzzle.getPrice9());
        cv.put(DatabaseHelper.COLUMN_PUZZLE_9, getPI(puzzle.isPuzzle9()));
        cv.put(DatabaseHelper.COLUMN_PRICE_10, puzzle.getPrice10());
        cv.put(DatabaseHelper.COLUMN_PUZZLE_10, getPI(puzzle.isPuzzle10()));
        cv.put(DatabaseHelper.COLUMN_PRICE_11, puzzle.getPrice11());
        cv.put(DatabaseHelper.COLUMN_PUZZLE_11, getPI(puzzle.isPuzzle11()));
        cv.put(DatabaseHelper.COLUMN_PRICE_12, puzzle.getPrice12());
        cv.put(DatabaseHelper.COLUMN_PUZZLE_12, getPI(puzzle.isPuzzle12()));
        cv.put(DatabaseHelper.COLUMN_PRICE_13, puzzle.getPrice13());
        cv.put(DatabaseHelper.COLUMN_PUZZLE_13, getPI(puzzle.isPuzzle13()));
        cv.put(DatabaseHelper.COLUMN_PRICE_14, puzzle.getPrice14());
        cv.put(DatabaseHelper.COLUMN_PUZZLE_14, getPI(puzzle.isPuzzle14()));
        cv.put(DatabaseHelper.COLUMN_PRICE_15, puzzle.getPrice15());
        cv.put(DatabaseHelper.COLUMN_PUZZLE_15, getPI(puzzle.isPuzzle15()));
        cv.put(DatabaseHelper.COLUMN_PRICE_16, puzzle.getPrice16());
        cv.put(DatabaseHelper.COLUMN_PUZZLE_16, getPI(puzzle.isPuzzle16()));
        cv.put(DatabaseHelper.COLUMN_PRICE_17, puzzle.getPrice17());
        cv.put(DatabaseHelper.COLUMN_PUZZLE_17, getPI(puzzle.isPuzzle17()));
        cv.put(DatabaseHelper.COLUMN_PRICE_18, puzzle.getPrice18());
        cv.put(DatabaseHelper.COLUMN_PUZZLE_18, getPI(puzzle.isPuzzle18()));
        cv.put(DatabaseHelper.COLUMN_PRICE_19, puzzle.getPrice19());
        cv.put(DatabaseHelper.COLUMN_PUZZLE_19, getPI(puzzle.isPuzzle19()));
        cv.put(DatabaseHelper.COLUMN_PRICE_20, puzzle.getPrice20());
        cv.put(DatabaseHelper.COLUMN_PUZZLE_20, getPI(puzzle.isPuzzle20()));
        cv.put(DatabaseHelper.COLUMN_PRICE_21, puzzle.getPrice21());
        cv.put(DatabaseHelper.COLUMN_PUZZLE_21, getPI(puzzle.isPuzzle21()));
        cv.put(DatabaseHelper.COLUMN_PRICE_22, puzzle.getPrice22());
        cv.put(DatabaseHelper.COLUMN_PUZZLE_22, getPI(puzzle.isPuzzle22()));
        cv.put(DatabaseHelper.COLUMN_PRICE_23, puzzle.getPrice23());
        cv.put(DatabaseHelper.COLUMN_PUZZLE_23, getPI(puzzle.isPuzzle23()));
        cv.put(DatabaseHelper.COLUMN_PRICE_24, puzzle.getPrice24());
        cv.put(DatabaseHelper.COLUMN_PUZZLE_24, getPI(puzzle.isPuzzle24()));
        cv.put(DatabaseHelper.COLUMN_PRICE_25, puzzle.getPrice25());
        cv.put(DatabaseHelper.COLUMN_PUZZLE_25, getPI(puzzle.isPuzzle25()));
        cv.put(DatabaseHelper.COLUMN_PRICE_26, puzzle.getPrice26());
        cv.put(DatabaseHelper.COLUMN_PUZZLE_26, getPI(puzzle.isPuzzle26()));
        cv.put(DatabaseHelper.COLUMN_PRICE_27, puzzle.getPrice27());
        cv.put(DatabaseHelper.COLUMN_PUZZLE_27, getPI(puzzle.isPuzzle27()));
        cv.put(DatabaseHelper.COLUMN_PRICE_28, puzzle.getPrice28());
        cv.put(DatabaseHelper.COLUMN_PUZZLE_28, getPI(puzzle.isPuzzle28()));
        cv.put(DatabaseHelper.COLUMN_PRICE_29, puzzle.getPrice29());
        cv.put(DatabaseHelper.COLUMN_PUZZLE_29, getPI(puzzle.isPuzzle29()));
        cv.put(DatabaseHelper.COLUMN_PRICE_30, puzzle.getPrice30());
        cv.put(DatabaseHelper.COLUMN_PUZZLE_30, getPI(puzzle.isPuzzle30()));
        return Math.toIntExact(database.insert(DatabaseHelper.TABLE_PUZZLE, null, cv));
    }
    private Integer getPI(boolean v){
        if(!v){ return 0;} else return 1;
    }
    public Integer update(Puzzle puzzle){
        String whereClause = DatabaseHelper.COLUMN_ID_PUZZLE + "=" + puzzle.getId();
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.COLUMN_ID_PUZZLE, puzzle.getId());
        cv.put(DatabaseHelper.COLUMN_ID_DRAWABLE_RESOURCE, puzzle.getId_drawable_resource());
        cv.put(DatabaseHelper.COLUMN_ID_USER, puzzle.getId_user());
        cv.put(DatabaseHelper.COLUMN_PRICE_1, puzzle.getPrice1());
        cv.put(DatabaseHelper.COLUMN_PUZZLE_1, getPI(puzzle.isPuzzle1()));
        cv.put(DatabaseHelper.COLUMN_PRICE_2, puzzle.getPrice2());
        cv.put(DatabaseHelper.COLUMN_PUZZLE_2, getPI(puzzle.isPuzzle2()));
        cv.put(DatabaseHelper.COLUMN_PRICE_3, puzzle.getPrice3());
        cv.put(DatabaseHelper.COLUMN_PUZZLE_3, getPI(puzzle.isPuzzle3()));
        cv.put(DatabaseHelper.COLUMN_PRICE_4, puzzle.getPrice4());
        cv.put(DatabaseHelper.COLUMN_PUZZLE_4, getPI(puzzle.isPuzzle4()));
        cv.put(DatabaseHelper.COLUMN_PRICE_5, puzzle.getPrice5());
        cv.put(DatabaseHelper.COLUMN_PUZZLE_5, getPI(puzzle.isPuzzle5()));
        cv.put(DatabaseHelper.COLUMN_PRICE_6, puzzle.getPrice6());
        cv.put(DatabaseHelper.COLUMN_PUZZLE_6, getPI(puzzle.isPuzzle6()));
        cv.put(DatabaseHelper.COLUMN_PRICE_7, puzzle.getPrice7());
        cv.put(DatabaseHelper.COLUMN_PUZZLE_7, getPI(puzzle.isPuzzle7()));
        cv.put(DatabaseHelper.COLUMN_PRICE_8, puzzle.getPrice8());
        cv.put(DatabaseHelper.COLUMN_PUZZLE_8, getPI(puzzle.isPuzzle8()));
        cv.put(DatabaseHelper.COLUMN_PRICE_9, puzzle.getPrice9());
        cv.put(DatabaseHelper.COLUMN_PUZZLE_9, getPI(puzzle.isPuzzle9()));
        cv.put(DatabaseHelper.COLUMN_PRICE_10, puzzle.getPrice10());
        cv.put(DatabaseHelper.COLUMN_PUZZLE_10, getPI(puzzle.isPuzzle10()));
        cv.put(DatabaseHelper.COLUMN_PRICE_11, puzzle.getPrice11());
        cv.put(DatabaseHelper.COLUMN_PUZZLE_11, getPI(puzzle.isPuzzle11()));
        cv.put(DatabaseHelper.COLUMN_PRICE_12, puzzle.getPrice12());
        cv.put(DatabaseHelper.COLUMN_PUZZLE_12, getPI(puzzle.isPuzzle12()));
        cv.put(DatabaseHelper.COLUMN_PRICE_13, puzzle.getPrice13());
        cv.put(DatabaseHelper.COLUMN_PUZZLE_13, getPI(puzzle.isPuzzle13()));
        cv.put(DatabaseHelper.COLUMN_PRICE_14, puzzle.getPrice14());
        cv.put(DatabaseHelper.COLUMN_PUZZLE_14, getPI(puzzle.isPuzzle14()));
        cv.put(DatabaseHelper.COLUMN_PRICE_15, puzzle.getPrice15());
        cv.put(DatabaseHelper.COLUMN_PUZZLE_15, getPI(puzzle.isPuzzle15()));
        cv.put(DatabaseHelper.COLUMN_PRICE_16, puzzle.getPrice16());
        cv.put(DatabaseHelper.COLUMN_PUZZLE_16, getPI(puzzle.isPuzzle16()));
        cv.put(DatabaseHelper.COLUMN_PRICE_17, puzzle.getPrice17());
        cv.put(DatabaseHelper.COLUMN_PUZZLE_17, getPI(puzzle.isPuzzle17()));
        cv.put(DatabaseHelper.COLUMN_PRICE_18, puzzle.getPrice18());
        cv.put(DatabaseHelper.COLUMN_PUZZLE_18, getPI(puzzle.isPuzzle18()));
        cv.put(DatabaseHelper.COLUMN_PRICE_19, puzzle.getPrice19());
        cv.put(DatabaseHelper.COLUMN_PUZZLE_19, getPI(puzzle.isPuzzle19()));
        cv.put(DatabaseHelper.COLUMN_PRICE_20, puzzle.getPrice20());
        cv.put(DatabaseHelper.COLUMN_PUZZLE_20, getPI(puzzle.isPuzzle20()));
        cv.put(DatabaseHelper.COLUMN_PRICE_21, puzzle.getPrice21());
        cv.put(DatabaseHelper.COLUMN_PUZZLE_21, getPI(puzzle.isPuzzle21()));
        cv.put(DatabaseHelper.COLUMN_PRICE_22, puzzle.getPrice22());
        cv.put(DatabaseHelper.COLUMN_PUZZLE_22, getPI(puzzle.isPuzzle22()));
        cv.put(DatabaseHelper.COLUMN_PRICE_23, puzzle.getPrice23());
        cv.put(DatabaseHelper.COLUMN_PUZZLE_23, getPI(puzzle.isPuzzle23()));
        cv.put(DatabaseHelper.COLUMN_PRICE_24, puzzle.getPrice24());
        cv.put(DatabaseHelper.COLUMN_PUZZLE_24, getPI(puzzle.isPuzzle24()));
        cv.put(DatabaseHelper.COLUMN_PRICE_25, puzzle.getPrice25());
        cv.put(DatabaseHelper.COLUMN_PUZZLE_25, getPI(puzzle.isPuzzle25()));
        cv.put(DatabaseHelper.COLUMN_PRICE_26, puzzle.getPrice26());
        cv.put(DatabaseHelper.COLUMN_PUZZLE_26, getPI(puzzle.isPuzzle26()));
        cv.put(DatabaseHelper.COLUMN_PRICE_27, puzzle.getPrice27());
        cv.put(DatabaseHelper.COLUMN_PUZZLE_27, getPI(puzzle.isPuzzle27()));
        cv.put(DatabaseHelper.COLUMN_PRICE_28, puzzle.getPrice28());
        cv.put(DatabaseHelper.COLUMN_PUZZLE_28, getPI(puzzle.isPuzzle28()));
        cv.put(DatabaseHelper.COLUMN_PRICE_29, puzzle.getPrice29());
        cv.put(DatabaseHelper.COLUMN_PUZZLE_29, getPI(puzzle.isPuzzle29()));
        cv.put(DatabaseHelper.COLUMN_PRICE_30, puzzle.getPrice30());
        cv.put(DatabaseHelper.COLUMN_PUZZLE_30, getPI(puzzle.isPuzzle30()));
        
        return Math.toIntExact(database.update(DatabaseHelper.TABLE_PUZZLE, cv, whereClause, null));
    }
    @SuppressLint("Range")
    public Puzzle getPuzzleById(Integer id){
       /* for (Puzzle p : getPuzzles()){
            if(Objects.equals(p.getId(), id)){
                return p;
            }
        }
        return null;*/
        
        String query = String.format("SELECT * FROM %s WHERE %s=?",DatabaseHelper.TABLE_PUZZLE, DatabaseHelper.COLUMN_ID_PUZZLE);
        Cursor cursor = database.rawQuery(query, new String[]{ String.valueOf(id)});
        Puzzle puzzle = new Puzzle();
        if(cursor.moveToFirst()){
            puzzle.setId(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID_PUZZLE)));
            puzzle.setId_drawable_resource(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID_DRAWABLE_RESOURCE)));
            puzzle.setId_user(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID_USER)));
            puzzle.setPrice1(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PRICE_1)));
            puzzle.setPuzzle1(getP(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PUZZLE_1))));
            puzzle.setPrice2(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PRICE_2)));
            puzzle.setPuzzle2(getP(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PUZZLE_2))));
            puzzle.setPrice3(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PRICE_3)));
            puzzle.setPuzzle3(getP(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PUZZLE_3))));
            puzzle.setPrice4(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PRICE_4)));
            puzzle.setPuzzle4(getP(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PUZZLE_4))));
            puzzle.setPrice5(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PRICE_5)));
            puzzle.setPuzzle5(getP(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PUZZLE_5))));
            puzzle.setPrice6(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PRICE_6)));
            puzzle.setPuzzle6(getP(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PUZZLE_6))));
            puzzle.setPrice7(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PRICE_7)));
            puzzle.setPuzzle7(getP(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PUZZLE_7))));
            puzzle.setPrice8(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PRICE_8)));
            puzzle.setPuzzle8(getP(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PUZZLE_8))));
            puzzle.setPrice9(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PRICE_9)));
            puzzle.setPuzzle9(getP(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PUZZLE_9))));
            puzzle.setPrice10(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PRICE_10)));
            puzzle.setPuzzle10(getP(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PUZZLE_10))));
            puzzle.setPrice11(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PRICE_11)));
            puzzle.setPuzzle11(getP(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PUZZLE_11))));
            puzzle.setPrice12(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PRICE_12)));
            puzzle.setPuzzle12(getP(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PUZZLE_12))));
            puzzle.setPrice13(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PRICE_13)));
            puzzle.setPuzzle13(getP(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PUZZLE_13))));
            puzzle.setPrice14(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PRICE_14)));
            puzzle.setPuzzle14(getP(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PUZZLE_14))));
            puzzle.setPrice15(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PRICE_15)));
            puzzle.setPuzzle15(getP(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PUZZLE_15))));
            puzzle.setPrice16(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PRICE_16)));
            puzzle.setPuzzle16(getP(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PUZZLE_16))));
            puzzle.setPrice17(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PRICE_17)));
            puzzle.setPuzzle17(getP(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PUZZLE_17))));
            puzzle.setPrice18(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PRICE_18)));
            puzzle.setPuzzle18(getP(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PUZZLE_18))));
            puzzle.setPrice19(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PRICE_19)));
            puzzle.setPuzzle19(getP(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PUZZLE_19))));
            puzzle.setPrice20(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PRICE_20)));
            puzzle.setPuzzle20(getP(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PUZZLE_20))));
            puzzle.setPrice21(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PRICE_21)));
            puzzle.setPuzzle21(getP(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PUZZLE_21))));
            puzzle.setPrice22(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PRICE_22)));
            puzzle.setPuzzle22(getP(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PUZZLE_22))));
            puzzle.setPrice23(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PRICE_23)));
            puzzle.setPuzzle23(getP(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PUZZLE_23))));
            puzzle.setPrice24(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PRICE_24)));
            puzzle.setPuzzle24(getP(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PUZZLE_24))));
            puzzle.setPrice25(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PRICE_25)));
            puzzle.setPuzzle25(getP(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PUZZLE_25))));
            puzzle.setPrice26(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PRICE_26)));
            puzzle.setPuzzle26(getP(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PUZZLE_26))));
            puzzle.setPrice27(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PRICE_27)));
            puzzle.setPuzzle27(getP(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PUZZLE_27))));
            puzzle.setPrice28(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PRICE_28)));
            puzzle.setPuzzle28(getP(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PUZZLE_28))));
            puzzle.setPrice29(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PRICE_29)));
            puzzle.setPuzzle29(getP(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PUZZLE_29))));
            puzzle.setPrice30(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PRICE_30)));
            puzzle.setPuzzle30(getP(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PUZZLE_30))));
        }
        cursor.close();
        return  puzzle;
        
    }
}
