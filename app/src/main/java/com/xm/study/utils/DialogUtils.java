package com.xm.study.utils;

import android.content.Context;

import com.xm.utils.dialog.DialogUtilsProgress;
import com.xm.study.R;

/**
 * Created by zhangxiumei on 2017/6/27.
 */

public class DialogUtils {

    public static void showProgressDialog(Context context,int id) {
        DialogUtilsProgress.showProgressDialog(context,id);
    }
}
