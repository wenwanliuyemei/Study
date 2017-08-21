package com.xm.study.crashreport.presenter;

import android.content.Context;

import com.tencent.bugly.crashreport.CrashReport;
import com.xm.study.base.IView;
import com.xm.study.base.ComplPresenter;
import com.xm.study.crashreport.view.IViewCrashReport;

/**
 * Created by zhangxiumei on 2017/5/23.
 */

public class ComplPresenterCrashReport extends ComplPresenter implements IPresenterCrashReport {
    public ComplPresenterCrashReport(Context context, IView iView) {
        super(context, iView);
    }

    @Override
    public void crashReportTest() {
        CrashReport.testJavaCrash();
        ((IViewCrashReport)iView).crashReportTestDone();
    }
}
