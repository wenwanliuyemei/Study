package com.xm.study.fix.nuwa.utils;

/**
 * @author: xm on 2017/8/31.
 * @describe:
 */

public class NuwaFileUtils {

    public static boolean initPatch(){
        if(com.xm.study.utils.FileUtils.isSDCardAvailable()){
            com.xm.study.utils.FileUtils.getWorkspace();
            com.xm.study.utils.FileUtils.getPatch();
            return true;
        }
        return false;
    }
}
