package com.rodavid20.dbdemo.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class CollegeDbAdapter {
    private CollegeDbHelper collegeDbHelper;
    private SQLiteDatabase collegeDb;
    private final String DBNAME = "College.db";
    private final int DBVERSION = 5;

    public CollegeDbAdapter(Context context) {
        collegeDbHelper = new CollegeDbHelper(context, DBNAME, null, DBVERSION);
    }

    public CollegeDbAdapter open() {
        collegeDb = collegeDbHelper.getWritableDatabase();
        return this;
    }

    public void insertStudent(String name, String regNo, String deptName) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("regNo", regNo);
        contentValues.put("deptName", deptName);
        collegeDb.insert("student", null, contentValues);
    }

    public void close() {
        collegeDb.close();
    }

    public boolean deleteRecord(String regNo) {
        return collegeDb.delete("student", "regNo='"+regNo + "'",null)>0;
    }

    public int updateString(String regNo, String name) {
        ContentValues cv = new ContentValues();
        cv.put("name", name);
        return collegeDb.update("student", cv, "regNo='"+ regNo + "'",null);
    }

    public Cursor getAllStudents() {
        return collegeDb.query("student", null, null, null,
                null, null, null);
    }

    public String getStudents(String deptName) {
        String[] projection = {
                "name"
        };

        String selection = "deptName" + "=?";
        String[] selectionArgs = {deptName};
        // How you want the results sorted in the resulting Cursor
        String sortOrder = "name DESC";

        Cursor cursor = collegeDb.query(
                "student",   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );

        String name = "";
        while (cursor.moveToNext()) {
            name = name + ", " +
                    cursor.getString(
                            cursor.getColumnIndexOrThrow("name"));
        }
        cursor.close();
        return name;
    }
    
    private static class CollegeDbHelper extends SQLiteOpenHelper{
        public CollegeDbHelper(@Nullable Context context, @Nullable String name,
                               @Nullable SQLiteDatabase.CursorFactory factory,
                               int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            //Create the table
            sqLiteDatabase.execSQL("CREATE TABLE student " +
                    "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "name VARCHAR(50), regNo VARCHAR(10), deptName VARCHAR(10))");
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int existing, int newVerson) {
            //modify
            sqLiteDatabase.execSQL("DROP TABLE student");
            onCreate(sqLiteDatabase);
        }

        @Override
        public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            super.onDowngrade(db, oldVersion, newVersion);
        }
    }
}
