package com.xm.study.notification.presenter;

import com.xm.study.base.IPresenter;

/**
 * Created by zhangxiumei on 2017/5/31.
 */

public interface IPresenterNotification extends IPresenter {

    public void initNotify();

    public void showCustomNotify();

    public void showCustomButtonNotify();

    public void registerCustom();

    public void unregisterCustom();

    public void showNotify();

    public void showBigStyleNotify();

    public void showCzNotify();

    public void showIntentActivityNotify(Class<?> cls);

    public void showIntentApkNotify();

    public void showProgressNotify();

    public void showProgressNotifyUnsure();

    public void showCustomProgressNotify();

    public void startDownloadNotify();

    public void pauseDownloadNotify();

    public void stopDownloadNotify();

    public void clearNotify();

    public void clearAllNotify();

}
