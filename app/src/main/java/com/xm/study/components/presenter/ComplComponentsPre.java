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

/**
 * @author: xm on 2017/10/9.
 * @describe:
 */

public class ComplComponentsPre extends ComplPresenter implements IComponentsPresenter {

    private MsgService msgService;
    private int progress = 0;
    private ProgressBar mProgressBar;

    ServiceConnection conn = new ServiceConnection() {

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            //返回一个MsgService对象
            msgService = ((MsgService.MsgBinder)service).getService();

        }
    };

    public ComplComponentsPre(Context context, IView iView) {
        super(context, iView);

    }

    @Override
    public void byBinder() {
        Intent intent = new Intent("components.service.ByBinder");
        context.bindService(intent, conn, Context.BIND_AUTO_CREATE);
    }



}
