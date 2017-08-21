package com.xm.study.handler;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.xm.study.R;
import com.xm.study.base.BaseActivity;
import com.xm.study.handler.presenter.HandlerPreCom;
import com.xm.study.handler.utils.MessageUtils;
import com.xm.study.handler.view.IHandlerView;
import com.xm.utils.LogUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.umeng.socialize.utils.DeviceConfig.context;

public class HandlerActivity extends BaseActivity implements IHandlerView {

    @Bind(R.id.tv_main)
    TextView tvMain;
    @Bind(R.id.tv_child)
    TextView tvChild;
    @Bind(R.id.tv_h_post)
    TextView tvHPost;
    @Bind(R.id.tv_view_post)
    TextView tvViewPost;
    @Bind(R.id.tv_main_ui)
    TextView tvMainUi;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        ButterKnife.bind(this);
        iPresenter = new HandlerPreCom(this, this);
    }


    @OnClick({R.id.tv_main, R.id.tv_child, R.id.tv_h_post, R.id.tv_view_post, R.id.tv_main_ui})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_main:
                ((HandlerPreCom) iPresenter).main(tvMain.getText().toString());
                break;
            case R.id.tv_child:
                ((HandlerPreCom) iPresenter).child(tvChild.getText().toString());
                handlerChild(tvChild.getText().toString());
                break;
            case R.id.tv_h_post:

                break;
            case R.id.tv_view_post:
                break;
            case R.id.tv_main_ui:
                break;
        }
    }

    @Override
    public void mainDone(String str) {
        tvMain.setText(str);
    }

    @Override
    public void childDone(String str) {
//        tvChild.setText(str);//子线程不能更新ui

        LogUtils.e(TAG,"childDone="+str);
    }

    @Override
    public void hPostDone(String str) {

    }

    @Override
    public void viewPostDone(String str) {

    }

    @Override
    public void mainUIDone(String str) {

    }


    private void handlerChild(final String str) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();
                Handler  mHandlerChild = new Handler() {
                    @Override
                    public void handleMessage(Message msg) {
                        super.handleMessage(msg);
                        switch (msg.what) {
                            case 1:
                                //可以获取到msg.obj，但不能给textview设置数据，子线程不能更新ui
                                LogUtils.e(TAG, "handlerChild=" + msg.obj.toString());
//                                tvChild.setText(str);//子线程不能更新ui
                                break;
                        }
                    }
                };
                MessageUtils.sendMessageMsg(HandlerActivity.this,str, 1, mHandlerChild);
                Looper.loop();
            }
        }).start();
    }

}
