package com.xm.study.ndk;

import android.graphics.Typeface;
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
        ((TextView)findViewById(R.id.tv_test_2)).setText((new JniText()).getCLangString2());

        setTypeFace(R.id.tv_test_3, "Roboto-Bold.ttf");
        setTypeFace(R.id.tv_test_4, "Roboto-Medium.ttf");
        setTypeFace(R.id.tv_test_5, "Roboto-Regular.ttf");
    }

    private void setTypeFace(int tv_test_32, String s) {
        TextView tv_test_3 = (TextView) findViewById(tv_test_32);
        Typeface typeface3 = Typeface.createFromAsset(getAssets(), s); // create a typeface from the raw ttf
        tv_test_3.setTypeface(typeface3);
    }
}
