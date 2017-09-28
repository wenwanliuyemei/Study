package com.xm.study.handler.presenter;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.xm.study.R;
import com.xm.study.base.ComplPresenter;
import com.xm.study.base.IView;
import com.xm.study.handler.utils.MessageUtils;
import com.xm.study.handler.view.IHandlerView;
import com.xm.utils.LogUtils;

/**
 * @author: xm on 2017/8/10.
 * @describe:
 */

public class HandlerPreCom extends ComplPresenter implements IHandlerPre {

    private final int MAIN = 1;
    private final int CHILD = 2;
    private Handler mHandlerMain;

    public HandlerPreCom(Context context, final IView iView) {
        super(context, iView);
        handlerMain();
    }

    private void handlerMain() {
        mHandlerMain = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what) {
                    case MAIN:
                        LogUtils.e(TAG, "main=" + msg.obj.toString());
                        ((IHandlerView) iView).mainDone(msg.obj.toString());
                        break;
                }
            }
        };
    }

    private void handlerChild(final String str) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();
                Handler handlerChild = new Handler() {
                    @Override
                    public void handleMessage(Message msg) {
                        super.handleMessage(msg);
                        switch (msg.what) {
                            case CHILD:
                                //可以获取到msg.obj，但不能给textview设置数据，子线程不能更新ui
                                LogUtils.e(TAG, "child=" + msg.obj.toString());
                                ((IHandlerView) iView).childDone(msg.obj.toString());
                                break;
                        }
                    }
                };
                MessageUtils.sendMessageMsg(context, str, CHILD, handlerChild);
                Looper.loop();
            }
        }).start();
    }


    @Override
    public void main(final String str) {
//        MessageUtils.sendMessageMsg(context, str, MAIN, mHandlerMain);

        new Thread(new Runnable() {
            @Override
            public void run() {
                MessageUtils.sendMessageMsg(context, str, MAIN, mHandlerMain);
            }
        }).start();
    }

    @Override
    public void child(final String str) {
        handlerChild(str);
    }

    @Override
    public void hPost(String str) {

    }

    @Override
    public void viewPost(String str) {

    }

    @Override
    public void mainUI(String str) {

    }
}
