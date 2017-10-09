package com.xm.study.components;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.xm.study.R;
import com.xm.study.base.BaseActivity;
import com.xm.study.components.presenter.ComplComponentsPre;
import com.xm.study.components.service.MsgService;
import com.xm.study.components.view.IComponentsView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FourComponentsActivity extends BaseActivity implements IComponentsView {

    @Bind(R.id.tv_by_binder)
    TextView tvByBinder;
    @Bind(R.id.pb_by_binder)
    ProgressBar pbByBinder;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four_components);
        ButterKnife.bind(this);

        iPresenter = new ComplComponentsPre(this, this);

        Intent intent = new Intent("components.service.ByBinder");
        bindService(intent, conn, Context.BIND_AUTO_CREATE);
    }

    @Override
    public void byBinderDone() {

    }

    @OnClick(R.id.tv_by_binder)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_by_binder:
                //开始下载
                msgService.startDownLoad();
                //监听进度
                listenProgress();
                break;
        }
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
                    pbByBinder.setProgress(progress);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();
    }

    @Override
    protected void onDestroy() {
        unbindService(conn);
        super.onDestroy();
    }
}
