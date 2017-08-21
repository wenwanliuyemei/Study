package com.xm.study.notification.notification;

import android.app.Activity;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.NotificationCompat;

import com.xm.study.R;
import com.xm.study.notification.utils.Utils;

import java.io.File;

/**
 * Created by zhangxiumei on 2017/6/1.
 */

public class NativeNotification extends MyNotification implements INativeNotification {

    public int notifyId = 100;//Notification的ID

    public NativeNotification(Context context) {
        super(context);
        initNotify();
    }

    /**
     * 初始化通知栏
     */
    private void initNotify() {
        mBuilder.setContentTitle("测试标题")
                .setContentText("测试内容")
                .setContentIntent(Utils.getDefalutIntent(mContext, Notification.FLAG_AUTO_CANCEL))
//				.setNumber(number)//显示数量
                .setTicker("测试通知来啦")//通知首次出现在通知栏，带上升动画效果的
                .setWhen(System.currentTimeMillis())//通知产生的时间，会在通知信息里显示
                .setPriority(Notification.PRIORITY_DEFAULT)//设置该通知优先级
//				.setAutoCancel(true)//设置这个标志当用户单击面板就可以让通知将自动取消
                //ture，设置他为一个正在进行的通知。
                // 他们通常是用来表示一个后台任务,用户积极参与(如播放音乐)或以某种方式正在等待,因此占用设备(如一个文件下载,同步操作,主动网络连接)
                .setOngoing(false)
                .setDefaults(Notification.DEFAULT_VIBRATE)//向通知添加声音、闪灯和振动效果的最简单、最一致的方式是使用当前的用户默认设置，使用defaults属性，可以组合：
                //Notification.DEFAULT_ALL  Notification.DEFAULT_SOUND 添加声音 // requires VIBRATE permission
                .setSmallIcon(R.mipmap.ic_launcher);
    }

    /**
     * 显示通知栏
     */
    public void showNotify() {
        mBuilder.setContentTitle("测试标题")
                .setContentText("测试内容")
//				.setNumber(number)//显示数量
                .setTicker("测试通知来啦");//通知首次出现在通知栏，带上升动画效果的
        mMyNotificationManager.mNotificationManager.notify(notifyId, mBuilder.build());
//		mNotification.notify(getResources().getString(R.string.app_name), notiId, mBuilder.build());
    }

    /**
     * 显示大视图风格通知栏
     */
    public void showBigStyleNotify() {
        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
        String[] events = new String[5];
        // Sets a title for the Inbox style big view
        inboxStyle.setBigContentTitle("大视图内容:");
        // Moves events into the big view
        for (int i = 0; i < events.length; i++) {
            inboxStyle.addLine(events[i]);
        }
        mBuilder.setContentTitle("测试标题")
                .setContentText("测试内容")
//				.setNumber(number)//显示数量
                .setStyle(inboxStyle)//设置风格
                .setTicker("测试通知来啦");// 通知首次出现在通知栏，带上升动画效果的
        mMyNotificationManager.mNotificationManager.notify(notifyId, mBuilder.build());
        // mNotification.notify(getResources().getString(R.string.app_name),
        // notiId, mBuilder.build());
    }

    /**
     * 显示常驻通知栏
     */
    public void showCzNotify() {
//		Notification mNotification = new Notification();//为了兼容问题，不用该方法，所以都采用BUILD方式建立
//		Notification mNotification  = new Notification.Builder(this).getNotification();//这种方式已经过时
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(mContext);
//		//PendingIntent 跳转动作
        PendingIntent pendingIntent = PendingIntent.getActivity(mContext, 0, ((Activity) mContext).getIntent(), 0);
        mBuilder.setSmallIcon(R.mipmap.ic_launcher)
                .setTicker("常驻通知来了")
                .setContentTitle("常驻测试")
                .setContentText("使用cancel()方法才可以把我去掉哦")
                .setContentIntent(pendingIntent);
        Notification mNotification = mBuilder.build();
        //设置通知  消息  图标
        mNotification.icon = R.mipmap.ic_launcher;
        //在通知栏上点击此通知后自动清除此通知
        mNotification.flags = Notification.FLAG_ONGOING_EVENT;//FLAG_ONGOING_EVENT 在顶部常驻，可以调用下面的清除方法去除  FLAG_AUTO_CANCEL  点击和清理可以去调
        //设置显示通知时的默认的发声、震动、Light效果
        mNotification.defaults = Notification.DEFAULT_VIBRATE;
        //设置发出消息的内容
        mNotification.tickerText = "通知来了";
        //设置发出通知的时间
        mNotification.when = System.currentTimeMillis();
//		mNotification.flags = Notification.FLAG_AUTO_CANCEL; //在通知栏上点击此通知后自动清除此通知
//		mNotification.setLatestEventInfo(this, "常驻测试", "使用cancel()方法才可以把我去掉哦", null); //设置详细的信息  ,这个方法现在已经不用了
        mMyNotificationManager.mNotificationManager.notify(notifyId, mNotification);
    }

    /**
     * 显示通知栏点击跳转到指定Activity
     */
    public void showIntentActivityNotify(Class<?> cls) {
        // Notification.FLAG_ONGOING_EVENT --设置常驻 Flag;Notification.FLAG_AUTO_CANCEL 通知栏上点击此通知后自动清除此通知
//		notification.flags = Notification.FLAG_AUTO_CANCEL; //在通知栏上点击此通知后自动清除此通知
        mBuilder.setAutoCancel(true)//点击后让通知将消失
                .setContentTitle("测试标题")
                .setContentText("点击跳转")
                .setTicker("点我");
        //点击的意图ACTION是跳转到Intent
        Intent resultIntent = new Intent(mContext, cls);
        resultIntent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(mContext, 0, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(pendingIntent);
        mMyNotificationManager.mNotificationManager.notify(notifyId, mBuilder.build());
    }

    /**
     * 显示通知栏点击打开Apk
     */
    public void showIntentApkNotify() {
        // Notification.FLAG_ONGOING_EVENT --设置常驻 Flag;Notification.FLAG_AUTO_CANCEL 通知栏上点击此通知后自动清除此通知
//		notification.flags = Notification.FLAG_AUTO_CANCEL; //在通知栏上点击此通知后自动清除此通知
        mBuilder.setAutoCancel(true)//点击后让通知将消失
                .setContentTitle("下载完成")
                .setContentText("点击安装")
                .setTicker("下载完成！");
        //我们这里需要做的是打开一个安装包
        Intent apkIntent = new Intent();
        apkIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        apkIntent.setAction(Intent.ACTION_VIEW);
        //注意：这里的这个APK是放在assets文件夹下，获取路径不能直接读取的，要通过COYP出去在读或者直接读取自己本地的PATH，这边只是做一个跳转APK，实际打不开的
        String apk_path = "file:///android_asset/cs.apk";
//		Uri uri = Uri.parse(apk_path);
        Uri uri = Uri.fromFile(new File(apk_path));
        apkIntent.setDataAndType(uri, "application/vnd.android.package-archive");
        // context.startActivity(intent);
        PendingIntent contextIntent = PendingIntent.getActivity(mContext, 0, apkIntent, 0);
        mBuilder.setContentIntent(contextIntent);
        mMyNotificationManager.mNotificationManager.notify(notifyId, mBuilder.build());
    }
}
