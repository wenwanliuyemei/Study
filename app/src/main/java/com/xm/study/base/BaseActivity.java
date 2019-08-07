package com.xm.study.base;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.xm.study.base.IView;
import com.xm.utils.CookieUtils;
import com.xm.utils.LogUtils;

import java.util.Observable;
import java.util.Observer;

public class BaseActivity extends AppCompatActivity implements IView, View.OnClickListener ,Observer{

    public final String TAG = this.getClass().getSimpleName();
    public IPresenter iPresenter;
    public MyApplication mMyApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMyApplication= (MyApplication) this.getApplication();
        mMyApplication.getmApplicationObservable().addObserver(this);
        LogUtils.e(TAG,"master--1");
    }


    @Override
    public void update(Observable observable, Object data) {
        this.finish();
        if(observable.countObservers()==0){
            LogUtils.e(TAG,"observable.countObservers()==0");
            CookieUtils.clearCookies(BaseActivity.this);
        }
    }

    @Override
    public void finish() {
        mMyApplication.getmApplicationObservable().deleteObserver(this);
        super.finish();
    }

    public void initViewAndSetListener(View[] views, int[] ids) {
        for (int i = 0; i < views.length; i++) {
            initViewAndSetListener(views[i], ids[i]);
        }
    }

    private void initViewAndSetListener(View v, int id) {
        v = (View) findViewById(id);
        v.setOnClickListener(this);
    }

    public void initView(View[] views, int[] ids) {
        for (int i = 0; i < views.length; i++) {
            initView(views[i], ids[i]);
        }
    }

    public View initView(View v, int id) {
        v = (View) findViewById(id);
        return v;
    }

    @Override
    public void onClick(View v) {

    }


    /**
     * 为fragment设置functions，具体实现子类来做
     *
     * @param fragmentId
     */
    public void setFunctionsForFragment(int fragmentId) {

    }
}
