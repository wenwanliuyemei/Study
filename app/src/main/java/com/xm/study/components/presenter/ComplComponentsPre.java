package com.xm.study.components.presenter;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.widget.ProgressBar;

import com.xm.study.base.ComplPresenter;
import com.xm.study.base.IView;
import com.xm.study.components.service.MsgService;
import com.xm.study.components.view.IComponentsView;

/**
 * @author: xm on 2017/10/9.
 * @describe:
 */

public class ComplComponentsPre extends ComplPresenter implements IComponentsPresenter {

    private MsgService msgService;
    private int progress = 0;

    ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceDisconnected(ComponentName name) {

        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            //返回一个MsgService对象
            msgService = ((MsgService.MsgBinder) service).getService();

        }
    };

    public ComplComponentsPre(Context context, IView iView) {
        super(context, iView);

    }

    @Override
    public void byBinderInit() {
        Intent intent = new Intent("components.service.ByBinder");
        context.bindService(intent, conn, Context.BIND_AUTO_CREATE);
        ((IComponentsView) iView).byBinderInitDone();
    }

    @Override
    public void byBinderDonwload() {
        //开始下载
        msgService.startDownLoad();
        //监听进度
        listenProgress();
        ((IComponentsView) iView).byBinderDonwloadDone();
    }

    @Override
    public void byBinderUnbind() {
        context.unbindService(conn);
        ((IComponentsView) iView).byBinderUnbindDone();

    }


    /**
     * 监听进度，每秒钟获取调用MsgService的getProgress()方法来获取进度，更新UI
     */
    public void listenProgress() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                while (progress < MsgService.MAX_PROGRESS) {
                    progress = msgService.getProgress();
                    ((IComponentsView) iView).byBinderShowProgress(progress);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();
    }
}
