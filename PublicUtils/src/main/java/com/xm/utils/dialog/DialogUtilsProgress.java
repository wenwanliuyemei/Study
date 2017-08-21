package com.xm.utils.dialog;

import android.app.ProgressDialog;
import android.content.Context;

public class DialogUtilsProgress {
    private static ProgressDialog proDialog;

    public static void showProgressDialog(Context context, int resId) {
        showProgressDialog(context, context.getString(resId), false);
    }

    public static void showProgressDialog(Context context, String msg, Boolean cancelable) {
        proDialog = new ProgressDialog(context);
        proDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);// 设置风格为圆形进度条
        proDialog.setMessage(msg);
        proDialog.setIndeterminate(false);// 设置进度条是否为不明确
        proDialog.setCancelable(cancelable);// 设置进度条是否可以按退回键取消
        proDialog.show();
    }

    public static void dismissProgressBar() {
        if (proDialog != null) {
            proDialog.dismiss();
        }
    }

}
