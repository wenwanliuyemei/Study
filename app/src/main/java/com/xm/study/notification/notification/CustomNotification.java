package com.xm.study.notification.notification;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import android.view.View;
import android.widget.RemoteViews;

import com.xm.study.R;
import com.xm.study.notification.utils.ButtonBroadcastReceiver;
import com.xm.study.notification.utils.Utils;
import com.xm.utils.PackageUtils;
import com.xm.utils.ToastUtil;

/**
 * Created by zhangxiumei on 2017/5/31.
 */

public class CustomNotification extends MyNotification implements ICustomNotification {

    private final String TAG = this.getClass().getSimpleName();
    public final static String ACTION_BUTTON = "com.notifications.intent.action.ButtonClick";//通知栏按钮点击事件对应的ACTION
    public final static String INTENT_BUTTONID_TAG = "ButtonId";
    public final static int BUTTON_PREV_ID = 1;//上一首 按钮点击 ID
    public final static int BUTTON_PALY_ID = 2;//播放/暂停 按钮点击 ID
    public final static int BUTTON_NEXT_ID = 3;//下一首 按钮点击 ID
    public  int notifyId = 101;//Notification 的ID

    private boolean isPlay = false;//是否在播放
    private ButtonBroadcastReceiver mButtonBroadcastReceiver;//通知栏按钮广播

    public CustomNotification(Context context) {
        super(context);
        register();
    }

    public void showCustomNotify() {
        //先设定RemoteViews
        RemoteViews view_custom = new RemoteViews(mContext.getPackageName(), R.layout.notification_custom);
        //设置对应IMAGEVIEW的ID的资源图片
        view_custom.setImageViewResource(R.id.iv_custom_icon, R.mipmap.notification_custom_icon);
//		view_custom.setInt(R.id.custom_icon,"setBackgroundResource",R.drawable.icon);
        view_custom.setTextViewText(R.id.tv_custom_title, "今日头条");
        view_custom.setTextViewText(R.id.tv_custom_content, "金州勇士官方宣布球队已经解雇了主帅马克-杰克逊，随后宣布了最后的结果。");
//		view_custom.setTextViewText(R.id.tv_custom_time, String.valueOf(System.currentTimeMillis()));
        //设置显示
//		view_custom.setViewVisibility(R.id.tv_custom_time, View.VISIBLE);
//		view_custom.setLong(R.id.tv_custom_time,"setTime", System.currentTimeMillis());//不知道为啥会报错，过会看看日志
        //设置number
//		NumberFormat num = NumberFormat.getIntegerInstance();
//		view_custom.setTextViewText(R.id.tv_custom_num, num.format(this.number));
        mBuilder.setContent(view_custom)
                .setContentIntent(Utils.getDefalutIntent(mContext, Notification.FLAG_AUTO_CANCEL))
                .setWhen(System.currentTimeMillis())// 通知产生的时间，会在通知信息里显示
                .setTicker("有新资讯")
                .setPriority(Notification.PRIORITY_DEFAULT)// 设置该通知优先级
                .setOngoing(false)//不是正在进行的   true为正在进行  效果和.flag一样
                .setSmallIcon(R.mipmap.notification_custom_icon);
//		mNotificationManager.notify(notifyId, mBuilder.build());
        Notification notify = mBuilder.build();
        notify.contentView = view_custom;
//		Notification notify = new Notification();
//		notify.icon = R.drawable.icon;
//		notify.contentView = view_custom;
//		notify.contentIntent = getDefalutIntent(Notification.FLAG_AUTO_CANCEL);
        mMyNotificationManager.mNotificationManager.notify(notifyId, notify);
    }

    /**
     * 带按钮的通知栏
     */
    public void showCustomButtonNotify() {
        RemoteViews mRemoteViews = new RemoteViews(mContext.getPackageName(), R.layout.notification_custom_button);
        mRemoteViews.setImageViewResource(R.id.custom_song_icon, R.mipmap.notification_custom_btn_sing_icon);
        //API3.0 以上的时候显示按钮，否则消失
        mRemoteViews.setTextViewText(R.id.tv_custom_song_singer, "周杰伦");
        mRemoteViews.setTextViewText(R.id.tv_custom_song_name, "七里香");
        //如果版本号低于（3。0），那么不显示按钮
        if (PackageUtils.getSystemVersion() <= 9) {
            mRemoteViews.setViewVisibility(R.id.ll_custom_button, View.GONE);
        } else {
            mRemoteViews.setViewVisibility(R.id.ll_custom_button, View.VISIBLE);
            //
            if (isPlay) {
                mRemoteViews.setImageViewResource(R.id.btn_custom_play, R.mipmap.notification_custom_btn_pause);
            } else {
                mRemoteViews.setImageViewResource(R.id.btn_custom_play, R.mipmap.notification_custom_btn_play);
            }
        }

        //点击的事件处理
        Intent buttonIntent = new Intent(ACTION_BUTTON);
        /* 上一首按钮 */
        buttonIntent.putExtra(INTENT_BUTTONID_TAG, BUTTON_PREV_ID);
        //这里加了广播，所及INTENT的必须用getBroadcast方法
        PendingIntent intent_prev = PendingIntent.getBroadcast(mContext, 1, buttonIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        mRemoteViews.setOnClickPendingIntent(R.id.btn_custom_prev, intent_prev);
        /* 播放/暂停  按钮 */
        buttonIntent.putExtra(INTENT_BUTTONID_TAG, BUTTON_PALY_ID);
        PendingIntent intent_paly = PendingIntent.getBroadcast(mContext, 2, buttonIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        mRemoteViews.setOnClickPendingIntent(R.id.btn_custom_play, intent_paly);
        /* 下一首 按钮  */
        buttonIntent.putExtra(INTENT_BUTTONID_TAG, BUTTON_NEXT_ID);
        PendingIntent intent_next = PendingIntent.getBroadcast(mContext, 3, buttonIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        mRemoteViews.setOnClickPendingIntent(R.id.btn_custom_next, intent_next);

        mBuilder.setContent(mRemoteViews)
                .setContentIntent(Utils.getDefalutIntent(mContext, Notification.FLAG_ONGOING_EVENT))
                .setWhen(System.currentTimeMillis())// 通知产生的时间，会在通知信息里显示
                .setTicker("正在播放")
                .setPriority(Notification.PRIORITY_DEFAULT)// 设置该通知优先级
                .setOngoing(true)
                .setSmallIcon(R.mipmap.notification_custom_btn_sing_icon);
        Notification notify = mBuilder.build();
        notify.flags = Notification.FLAG_ONGOING_EVENT;
        //会报错，还在找解决思路
//		notify.contentView = mRemoteViews;
//		notify.contentIntent = PendingIntent.getActivity(this, 0, new Intent(), 0);
        mMyNotificationManager.mNotificationManager.notify(200, notify);
    }


    @Override
    public void pre() {
        Log.e(TAG, "上一首");
        ToastUtil.toast(mContext, "上一首");
    }

    @Override
    public void play() {
        String play_status = "";
        isPlay = !isPlay;
        if (isPlay) {
            play_status = "开始播放";
        } else {
            play_status = "已暂停";
        }
        showCustomButtonNotify();
        Log.e(TAG, play_status);
        ToastUtil.toast(mContext, play_status);
    }

    @Override
    public void next() {
        Log.e(TAG, "下一首");
        ToastUtil.toast(mContext, "下一首");
    }

    /**
     * 带按钮的通知栏点击广播接收
     */
    @Override
    public void register() {
        mButtonBroadcastReceiver = new ButtonBroadcastReceiver(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_BUTTON);
        mContext.registerReceiver(mButtonBroadcastReceiver, intentFilter);
    }

    @Override
    public void unregister() {
        if (mButtonBroadcastReceiver != null) {
            mContext.unregisterReceiver(mButtonBroadcastReceiver);
        }
    }
}
