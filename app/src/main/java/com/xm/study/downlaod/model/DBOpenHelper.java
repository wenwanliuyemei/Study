package com.xm.study.downlaod.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 作者：xm on 2017/3/10 10:07
 * 描述：
 */
public class DBOpenHelper extends SQLiteOpenHelper {

    private static final String DBNAME = "down.db";
    private static final int VERSION = 1;
    public final String tableFileDownLog = "fileDownLog";
    public final String downPath = "downPath";
    public final String threadId = "threadId";
    public final String downLength = "downLength";
    private String strFileDownLog = "CREATE TABLE IF NOT EXISTS " + tableFileDownLog +
            "(id integer primary key autoincrement," + downPath + " varchar(100)," +
            threadId + " INTERGER," + downLength + " INTEGER)";
    public final String select = "select " + threadId + "," + downLength + " from " + tableFileDownLog +
            " where " + downPath + "=?";
    public final String insert = "insert into " + tableFileDownLog + " (" + downPath + ","
            + threadId + "," + downLength + ")" + " values(?,?,?)";
    public final String update = "update " + tableFileDownLog + " set " + downLength +
            "=? where " + downPath + "=? and " + threadId + "=?";
    public final String delete = "delete from " + tableFileDownLog + " where " + downPath + "=?";

    public DBOpenHelper(Context context) {
        super(context, DBNAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(strFileDownLog);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + tableFileDownLog);
        onCreate(db);
    }
}
