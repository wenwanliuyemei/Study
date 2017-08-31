package com.xm.study.utils;

import android.os.Environment;

import com.xm.study.base.Consts;

import java.io.File;

/**
 * @author: xm on 2017/8/31.
 * @describe:
 */

public class FileUtils {

    public static boolean isSDCardAvailable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }


    public static File getWorkspace() {
        File file = Environment.getExternalStorageDirectory();
        File workspace = new File(file, Consts.PATH_APP);
        if (!workspace.exists()) {
            workspace.mkdirs();
        }
        return workspace;
    }

    public static File getPatch() {
        File workspace = getWorkspace();
        File patchWorkspace = new File(workspace, Consts.PATH_PATCH);
        if (!patchWorkspace.exists()) {
            patchWorkspace.mkdirs();
        }
        return patchWorkspace;
    }
}
