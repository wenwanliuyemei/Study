package com.xm.study.widget;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;

import com.xm.study.base.BaseActivity;
import com.xm.study.R;
import com.xm.study.widget.widget.CustomProgressDialog;

public class WidgetActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget);
    }

    public void aa(View view){
        //文字即为显示的内容
        CustomProgressDialog.createLoadingDialog(this, "正在处理...");
    }

    public void bb(View view){
        CustomProgressDialog.dismissProgressBar();
    }
}
