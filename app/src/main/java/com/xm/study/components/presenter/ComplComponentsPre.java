package com.xm.study.components.presenter;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;

import com.xm.study.base.ComplPresenter;
import com.xm.study.base.IView;
import com.xm.study.components.model.OnProgressListener;
import com.xm.study.components.service.MsgServiceByBinder;
import com.xm.study.components.service.MsgServiceByBroadcast;
import com.xm.study.components.service.MsgServiceByInterface;
import com.xm.study.components.view.IComponentsView;
import com.xm.utils.IntentUtils;

/**
 * @author: xm on 2017/10/9.
 * @describe:
 */

public class ComplComponentsPre extends ComplPresenter implements IComponentsPresenter {

    private MsgServiceByBinder msgServiceByBinder;
    private MsgServiceByInterface msgServiceByInterface;
    private MsgServiceByBroadcast msgServiceByBroadcast;
    private MsgReceiverByBroadcast msgReceiverByBroadcast;
    private Intent intentByBroadcast;
    private int progressByBinder = 0;

    ServiceConnection connByBinder = new ServiceConnection() {
        @Override
        public void onServiceDisconnected(ComponentName name) {

        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            //返回一个MsgService对象
            msgServiceByBinder = ((MsgServiceByBinder.MsgBinder) service).getService();

        }
    };

    ServiceConnection connByInterface = new ServiceConnection() {
        @Override
        public void onServiceDisconnected(ComponentName name) {

        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            //返回一个MsgService对象
            msgServiceByInterface = ((MsgServiceByInterface.MsgBinder) service).getService();
            //注册回调接口来接收下载进度的变化
            msgServiceByInterface.setOnProgressListener(new OnProgressListener() {

                @Override
                public void onProgress(int progress) {
                    ((IComponentsView) iView).byInterfaceShowProgress(progress);
                }
            });
        }
    };

    public ComplComponentsPre(Context context, IView iView) {
        super(context, iView);

    }

    @Override
    public void byBinderInit() {
        IntentUtils.intentService(context, "components.service.ByBinder", connByBinder);
        ((IComponentsView) iView).byBinderInitDone();
    }

    @Override
    public void byBinderDonwload() {
        //开始下载
        msgServiceByBinder.startDownLoad();
        //监听进度
        listenProgress();
        ((IComponentsView) iView).byBinderDonwloadDone();
    }

    @Override
    public void byInterfaceInit() {
        IntentUtils.intentService(context, "components.service.ByInterface", connByInterface);
        ((IComponentsView) iView).byInterfaceInitDone();
    }

    @Override
    public void byInterfaceDonwload() {
        //开始下载
        msgServiceByInterface.startDownLoad();
        ((IComponentsView) iView).byInterfaceDonwloadDone();
    }

    @Override
    public void byBroadcastInit() {
        //动态注册广播接收器
        msgReceiverByBroadcast = new MsgReceiverByBroadcast();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(MsgReceiverByBroadcast.ACTION);
        context.registerReceiver(msgReceiverByBroadcast, intentFilter);
        ((IComponentsView) iView).byBroadcastInitDone();
    }

    @Override
    public void byBroadcastDownload() {
        intentByBroadcast = new Intent(MsgServiceByBroadcast.ACTION);
        context.startService(intentByBroadcast);
        ((IComponentsView) iView).byBroadcastDownloadDone();
    }

    @Override
    public void stop() {
        context.unbindService(connByBinder);
        context.unbindService(connByInterface);
        //停止服务
        context.stopService(intentByBroadcast);
        //注销广播
        context.unregisterReceiver(msgReceiverByBroadcast);
        ((IComponentsView) iView).stopDone();
    }

    /**
     * 监听进度，每秒钟获取调用MsgService的getProgress()方法来获取进度，更新UI
     */
    public void listenProgress() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                while (progressByBinder < MsgServiceByBinder.MAX_PROGRESS) {
                    progressByBinder = msgServiceByBinder.getProgress();
                    ((IComponentsView) iView).byBinderShowProgress(progressByBinder);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();
    }


   public class MsgReceiverByBroadcast extends BroadcastReceiver {

       public static final int BY_BROADCAST = 1;
       public static final String WHAT = "what";
       public static final String PROGRESS = "progress";
       public static final String ACTION="com.xm.study.components.RECEIVER";

       @Override
       public void onReceive(Context context, Intent intent) {
           Bundle bundle=intent.getExtras();
           int what=bundle.getInt(WHAT,0);
           switch (what){
               case BY_BROADCAST:
                   ((IComponentsView)iView).byBroadcastShowProgress(bundle.getInt("progress", 0));
                   break;
           }
       }
   }
}
