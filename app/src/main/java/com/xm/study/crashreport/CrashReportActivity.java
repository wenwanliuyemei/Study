package com.xm.study.crashreport;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.xm.study.R;
import com.xm.study.base.BaseActivity;
import com.xm.study.crashreport.presenter.ComplPresenterCrashReport;
import com.xm.study.crashreport.view.IViewCrashReport;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CrashReportActivity extends BaseActivity implements IViewCrashReport {


    @Bind(R.id.tv_crash_report_test)
    TextView tvCrashReportTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crash_report);
        ButterKnife.bind(this);
        iPresenter = new ComplPresenterCrashReport(this, this);
    }

    @OnClick(R.id.tv_crash_report_test)
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_crash_report_test:
                ((ComplPresenterCrashReport) iPresenter).crashReportTest();
                break;
        }
    }

    @Override
    public void crashReportTestDone() {
        Log.e(TAG, "crashReportTestDone");
    }
}
