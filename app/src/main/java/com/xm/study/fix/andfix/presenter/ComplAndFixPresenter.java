package com.xm.study.fix.andfix.presenter;

import android.content.Context;
import android.os.Environment;

import com.xm.study.base.ComplPresenter;
import com.xm.study.base.IView;
import com.xm.study.base.MyApplication;
import com.xm.study.fix.andfix.view.IAndFixView;
import com.xm.utils.ToastUtil;

import java.io.IOException;

/**
 * @author: xm on 2017/8/23.
 * @describe:
 */

public class ComplAndFixPresenter extends ComplPresenter implements IAndFixPresenter {
    private static final String APATCH_PATH = "/fix.apatch"; // 补丁文件名

    public ComplAndFixPresenter(Context context, IView iView) {
        super(context, iView);
    }

    @Override
    public void setText(String string) {
        ((IAndFixView) iView).setTextDone(string);
    }

    @Override
    public void showToast(int string) {
        ToastUtil.toast(context, string);
        ((IAndFixView) iView).showToastDone();
    }

    @Override
    public void update() {
        String patchFileStr = Environment.getExternalStorageDirectory().getAbsolutePath() + APATCH_PATH;
        try {
            MyApplication.mPatchManager.addPatch(patchFileStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ((IAndFixView) iView).updateDone();
    }
}
