package com.xm.study.cardview;

import android.app.Activity;
import android.os.Bundle;

import com.xm.study.R;
import com.xm.study.base.BaseActivity;
import com.xm.study.cardview.view.IViewCardView;

public class CardViewActivity extends BaseActivity implements IViewCardView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);
    }
}
