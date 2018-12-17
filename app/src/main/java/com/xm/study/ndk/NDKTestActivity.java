package com.xm.study.ndk;

import android.os.Bundle;
import android.widget.TextView;

import com.xm.study.R;
import com.xm.study.base.BaseActivity;

public class NDKTestActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ndktest);
        ((TextView)findViewById(R.id.tv_test)).setText((new JniText()).getCLangString());
    }
}
