package com.xm.utils;


import android.content.Context;
import android.os.Environment;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;


public class ObjectCache {
    private static DiskLruCache mDiskLruCache = null;
    public static void setCache(Context context, String key, String content) {
        try {
            File cacheDir = getDiskCacheDir(context);
            if (!cacheDir.exists()) {
                cacheDir.mkdirs();
            }
            mDiskLruCache = DiskLruCache.open(cacheDir, Integer.decode(PackageUtils.getAppVersionCode(context)+""), 1, 10 * 1024 * 1024);
        } catch (IOException e) {
            e.printStackTrace();
        }
        DiskLruCache.Editor editor = null;
        try {
            if (mDiskLruCache != null)
                editor = mDiskLruCache.edit(key);
            if (editor != null) {
                OutputStream outputStream = editor.newOutputStream(0);
                outputStream.write(content.getBytes());
                editor.commit();
            }
            if (mDiskLruCache != null)
                mDiskLruCache.flush();
        } catch (IOException e1) {
            e1.printStackTrace();
        }


    }


    public static String getCache(Context context, String key) {
        try {
            File cacheDir = getDiskCacheDir(context);
            if (!cacheDir.exists()) {
                cacheDir.mkdirs();
            }
            mDiskLruCache = DiskLruCache.open(cacheDir, Integer.decode(PackageUtils.getAppVersionCode(context)+""), 1, 10 * 1024 * 1024);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String str = null;
        try {
            DiskLruCache.Snapshot snapShot = null;
            if (mDiskLruCache != null) {
                snapShot = mDiskLruCache.get(key);
            }
            if (snapShot != null) {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                int i;
                while ((i = snapShot.getInputStream(0).read()) != -1) {
                    baos.write(i);
                }
                str = baos.toString();
            }

            return str;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static File getDiskCacheDir(Context context) {
        StringBuilder sb = new StringBuilder();
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
                || !Environment.isExternalStorageRemovable()) {
            File file = context.getExternalCacheDir();
            if (file != null) {
                sb.append(file.getAbsolutePath()).append(File.separator);
            } else {
                sb.append(Environment.getExternalStorageDirectory().getPath()).append("/Android/data/").append(context.getPackageName())
                        .append("/cache/").append(File.separator).toString();
            }
        } else {
            sb.append(context.getCacheDir().getPath());
        }
        return new File(sb.toString());
    }
}
