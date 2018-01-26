package com.xm.study.database;

import android.content.Context;
import android.database.Cursor;

import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteOpenHelper;

import com.xm.study.base.MyApplication;
import com.xm.utils.LogUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author: xm on 2018/1/25.
 * @describe: 数据库 教材设置
 */

public class TextbookSettingDB3 extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "screeningcondition33.sqlite";
    public static final int DATABASE_VERSION = 1;
    public static final String CREATE_TABLE = "CREATE table IF NOT EXISTS ";
    public static final String DROP_TABLE = "DROP TABLE IF EXISTS ";
    private Context mContext;

    public TextbookSettingDB3(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(table1.CREATE_TABLE_SQL);
        db.execSQL(table2.CREATE_TABLE_SQL);
        db.execSQL(table3.CREATE_TABLE_SQL);
        db.execSQL(table4.CREATE_TABLE_SQL);
    }

    public void insert(String fileName) {
        SQLiteDatabase db = getWritableDatabase(MyApplication.PASSWORD_DB);
        InputStream inputStream = null;
        try {
            inputStream = mContext.getAssets().open(fileName);
            if (inputStream != null) {
                InputStreamReader inputreader = new InputStreamReader(inputStream);
                BufferedReader buffreader = new BufferedReader(inputreader);
                String line;
                //分行读取
                while ((line = buffreader.readLine()) != null) {
                    db.execSQL(line);
                }
                inputStream.close();
            }
        } catch (java.io.FileNotFoundException e) {
            LogUtils.e("The File doesn't not exist.");
        } catch (IOException e) {
            LogUtils.e(e.getMessage());
        }
    }

    public String select() {
        SQLiteDatabase db = getWritableDatabase(MyApplication.PASSWORD_DB);
        Cursor c = null;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            String sql = "SELECT * from table1 where ID=2110";
            System.out.println(sql);
            c = db.rawQuery(sql, null);
            while (c.moveToNext()) {
                stringBuffer.append(c.getString(c.getColumnIndex("LABLE_NAME")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != c) {
                c.close();
                c = null;
                if (db != null) {
                    db.close();
                }
            }
        }
        return stringBuffer.toString();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(table1.DROP_TABLE_SQL);
        db.execSQL(table2.DROP_TABLE_SQL);
        db.execSQL(table3.DROP_TABLE_SQL);
        db.execSQL(table4.DROP_TABLE_SQL);
        onCreate(db);
    }

    public interface table1 {
        String TABLE_NAME = "table1";
        String DROP_TABLE_SQL = DROP_TABLE + TABLE_NAME;
        String CREATE_TABLE_SQL = CREATE_TABLE + TABLE_NAME + " (ID NUMERIC, LABLE_ID NUMERIC, " +
                "LABLE_NAME TEXT, PARENT_ID NUMERIC, PARENT_LABLE_ID NUMERIC, PARENT_LABLE_NAME TEXT);";
    }

    public interface table2 {
        String TABLE_NAME = "table2";
        String DROP_TABLE_SQL = DROP_TABLE + TABLE_NAME;
        String CREATE_TABLE_SQL = CREATE_TABLE + TABLE_NAME + " (ID NUMERIC, LABLE_ID NUMERIC, " +
                "LABLE_NAME TEXT, PARENT_ID NUMERIC, PARENT_LABLE_ID NUMERIC, PARENT_LABLE_NAME TEXT);";
    }

    public interface table3 {
        String TABLE_NAME = "table3";
        String DROP_TABLE_SQL = DROP_TABLE + TABLE_NAME;
        String CREATE_TABLE_SQL = CREATE_TABLE + TABLE_NAME + " (ID NUMERIC, LABLE_ID NUMERIC, " +
                "LABLE_NAME TEXT, PARENT_ID NUMERIC, PARENT_LABLE_ID NUMERIC, PARENT_LABLE_NAME TEXT);";
    }

    public interface table4 {
        String TABLE_NAME = "table4";
        String DROP_TABLE_SQL = DROP_TABLE + TABLE_NAME;
        String CREATE_TABLE_SQL = CREATE_TABLE + TABLE_NAME + " (ID NUMERIC, LABLE_ID NUMERIC, " +
                "LABLE_NAME TEXT, PARENT_ID NUMERIC, PARENT_LABLE_ID NUMERIC, PARENT_LABLE_NAME TEXT);";
    }
}
