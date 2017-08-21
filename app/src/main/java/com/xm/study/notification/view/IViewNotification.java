package com.xm.study.notification.view;

import com.xm.study.base.IView;

/**
 * Created by zhangxiumei on 2017/5/31.
 */

public interface IViewNotification extends IView {

    public void initNotifyDone();

    public void showCustomNotifyDone();

    public void showCustomButtonNotifyDone();

    public void registerCustomDone();

    public void unregisterCustomDone();

    public void showNotifyDone();

    public void showBigStyleNotifyDone();

    public void showCzNotifyDone();

    public void showIntentActivityNotifyDone();

    public void showIntentApkNotifyDone();

    public void showProgressNotifyDone();

    public void showProgressNotifyUnsureDone();

    public void showCustomProgressNotifyDone();

    public void startDownloadNotifyDone();

    public void pauseDownloadNotifyDone();

    public void stopDownloadNotifyDone();

    public void clearNotifyDone();

    public void clearAllNotifyDone();
}
