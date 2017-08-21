package com.xm.study.downlaod.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.hardware.camera2.DngCreator;

import java.util.HashMap;
import java.util.Map;

/**
 * 作者：xm on 2017/3/10 10:07
 * 描述：
 */
public class FileService {

    private DBOpenHelper dbOpenHelper;

    public FileService(Context context) {
        dbOpenHelper = new DBOpenHelper(context);
    }

    /**
     * 获取每条线程已经下载的文件长度
     *
     * @param path
     * @return
     */
    public Map<Integer, Integer> getData(String path) {
        SQLiteDatabase sqLiteDatabase = dbOpenHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(dbOpenHelper.select, new String[]{path});
        Map<Integer, Integer> data = new HashMap<>();
        while (cursor.moveToNext()) {
            data.put(cursor.getInt(0), cursor.getInt(1));
        }
        cursor.close();
        dbOpenHelper.close();
        return data;
    }

    /**
     * 保存每条线程已经下载的文件长度
     *
     * @param path
     * @param map
     */
    public void save(String path, Map<Integer, Integer> map) {
        SQLiteDatabase sqLiteDatabase = dbOpenHelper.getWritableDatabase();
        sqLiteDatabase.beginTransaction();
        try {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                sqLiteDatabase.execSQL(dbOpenHelper.insert, new Object[]{path, entry.getKey(), entry.getValue()});
            }
            sqLiteDatabase.setTransactionSuccessful();
        } finally {
            sqLiteDatabase.endTransaction();
        }
        sqLiteDatabase.close();
    }

    /**
     * 实时更新每条线程已经下载的文件长度
     *
     * @param path
     * @param map
     */
    public void update(String path, Map<Integer, Integer> map) {
        SQLiteDatabase sqLiteDatabase = dbOpenHelper.getWritableDatabase();
        sqLiteDatabase.beginTransaction();
        try {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                sqLiteDatabase.execSQL(dbOpenHelper.update, new Object[]{entry.getValue(), path, entry.getKey()});
            }
            sqLiteDatabase.setTransactionSuccessful();
        } finally {
            sqLiteDatabase.endTransaction();
        }
        sqLiteDatabase.close();
    }

    /**
     * 当文件下载完成后，删除对应的下载记录
     *
     * @param path
     */
    public void delete(String path) {
        SQLiteDatabase sqLiteDatabase = dbOpenHelper.getWritableDatabase();
        sqLiteDatabase.execSQL(dbOpenHelper.delete, new Object[]{path});
        sqLiteDatabase.close();
    }
}
