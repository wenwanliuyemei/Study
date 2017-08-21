package com.xm.study.reflect;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.xm.study.base.BaseActivity;
import com.xm.study.R;
import com.xm.study.reflect.presenter.ITestFelectPresenter;
import com.xm.study.reflect.presenter.TestFelectPresenterCompl;
import com.xm.study.reflect.view.ITestReflectView;

/**
 * 作者：xm on 2017/1/3 11:04
 * 描述：反射
 * http://www.cnblogs.com/lzq198754/p/5780331.html
 */
public class TestReflectActivity extends BaseActivity implements ITestReflectView {

    private final String TAG = this.getClass().getSimpleName();
    private ITestFelectPresenter mITestFelectPresneter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reflect_activity_test_reflect);

        //find view、set listener
        int[] ids=new int[]{R.id.tv_reflect,R.id.tv_init,R.id.tv_get_super_class_interface,
                R.id.tv_get_object,R.id.tv_get_attribute,R.id.tv_get_all_method,R.id.tv_get_one_method,
                R.id.tv_get_one_attribute,R.id.tv_proxy,R.id.tv_int_list_put_string,R.id.tv_update_array,
                R.id.tv_update_array_size,R.id.tv_fruit_factory};
        TextView [] views=new TextView[ids.length];
        initViewAndSetListener(views,ids);
        //init
        mITestFelectPresneter = new TestFelectPresenterCompl(this, this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_reflect:
                mITestFelectPresneter.reflect();
                break;
            case R.id.tv_init:
                mITestFelectPresneter.init();
                break;
            case R.id.tv_get_super_class_interface:
                mITestFelectPresneter.getSuperClassInterface();
                break;
            case R.id.tv_get_object:
                mITestFelectPresneter.getObject();
                break;
            case R.id.tv_get_attribute:
                mITestFelectPresneter.getAttribute();
                break;
            case R.id.tv_get_all_method:
                mITestFelectPresneter.getAllMethod();
                break;
            case R.id.tv_get_one_method:
                mITestFelectPresneter.getOneMethod();
                break;
            case R.id.tv_get_one_attribute:
                mITestFelectPresneter.getOneAttribute();
                break;
            case R.id.tv_proxy:
                mITestFelectPresneter.proxy();
                break;
            case R.id.tv_int_list_put_string:
                mITestFelectPresneter.intListPutString();
                break;
            case R.id.tv_update_array:
                mITestFelectPresneter.updateArray();
                break;
            case R.id.tv_update_array_size:
                mITestFelectPresneter.upaateArraySize();
                break;
            case R.id.tv_fruit_factory:
                mITestFelectPresneter.fruitFactory();
                break;
        }
    }

    @Override
    public void reflectDone() {
        Log.e(TAG, "reflectDone");
    }

    @Override
    public void initDone() {
        Log.e(TAG, "initDone");
    }

    @Override
    public void getSuperClassInterfaceDone() {
        Log.e(TAG, "getSuperClassInterfaceDone");
    }

    @Override
    public void getObjectDone() {
        Log.e(TAG, "getObjectDone");
    }

    @Override
    public void getAttributeDone() {
        Log.e(TAG, "getAttributeDone");
    }

    @Override
    public void getAllMethodDone() {
        Log.e(TAG, "getAllMethodDone");
    }

    @Override
    public void getOneMethodDone() {
        Log.e(TAG, "getOneMethodDone");
    }

    @Override
    public void getOneAttributeDone() {
        Log.e(TAG, "getOneAttributeDone");
    }

    @Override
    public void proxyDone() {
        Log.e(TAG, "proxyDone");
    }

    @Override
    public void intListPutStringDone() {
        Log.e(TAG, "intListPutStringDone");
    }

    @Override
    public void updateArrayDone() {
        Log.e(TAG, "updateArrayDone");
    }

    @Override
    public void fruitFactoryDone() {
        Log.e(TAG, "fruitFactoryDone");
    }

}
