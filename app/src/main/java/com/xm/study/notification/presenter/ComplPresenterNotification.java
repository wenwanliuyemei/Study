package com.xm.study.notification.presenter;

import android.content.Context;

import com.xm.study.R;
import com.xm.study.base.IView;
import com.xm.study.base.ComplPresenter;
import com.xm.study.notification.notification.CustomNotification;
import com.xm.study.notification.notification.MyNotification;
import com.xm.study.notification.notification.NativeNotification;
import com.xm.study.notification.notification.ProgressNotification;
import com.xm.study.notification.view.IViewNotification;

/**
 * Created by zhangxiumei on 2017/5/31.
 */

public class ComplPresenterNotification extends ComplPresenter implements IPresenterNotification {

    //    private MyNotification mMyNotification;
    private CustomNotification mCustomNotification;
    private NativeNotification mNativeNotification;
    private ProgressNotification mProgressNotification;

    public ComplPresenterNotification(Context context, IView iView) {
        super(context, iView);
    }

    @Override
    public void initNotify() {
        mCustomNotification = new CustomNotification(context);
        mNativeNotification = new NativeNotification(context);
        mProgressNotification = new ProgressNotification(context);
        ((IViewNotification) iView).initNotifyDone();
    }

    @Override
    public void showCustomNotify() {
        mCustomNotification.showCustomNotify();
        ((IViewNotification) iView).showCustomNotifyDone();
    }

    @Override
    public void showCustomButtonNotify() {
        mCustomNotification.showCustomButtonNotify();
        ((IViewNotification) iView).showCustomButtonNotifyDone();
    }

    @Override
    public void registerCustom() {
        mCustomNotification.register();
        ((IViewNotification) iView).registerCustomDone();
    }

    @Override
    public void unregisterCustom() {
        mCustomNotification.unregister();
        ((IViewNotification) iView).unregisterCustomDone();
    }

    @Override
    public void showNotify() {
        mNativeNotification.showNotify();
        ((IViewNotification) iView).showNotifyDone();
    }

    @Override
    public void showBigStyleNotify() {
        mNativeNotification.showBigStyleNotify();
        ((IViewNotification) iView).showBigStyleNotifyDone();
    }

    @Override
    public void showCzNotify() {
        mNativeNotification.showCzNotify();
        ((IViewNotification) iView).showCzNotifyDone();
    }

    @Override
    public void showIntentActivityNotify(Class<?> cls) {
        mNativeNotification.showIntentActivityNotify(cls);
        ((IViewNotification) iView).showIntentActivityNotifyDone();
    }

    @Override
    public void showIntentApkNotify() {
        mNativeNotification.showIntentApkNotify();
        ((IViewNotification) iView).showIntentApkNotifyDone();
    }

    @Override
    public void showProgressNotify() {
        mProgressNotification.downloadThread = null;
        mProgressNotification.isCustom = false;
        mProgressNotification.indeterminate = false;
        mProgressNotification.showProgressNotify();
        ((IViewNotification) iView).showProgressNotifyDone();
    }

    @Override
    public void showProgressNotifyUnsure() {
        mProgressNotification.downloadThread = null;
        mProgressNotification.isCustom = false;
        mProgressNotification.indeterminate = true;
        mProgressNotification.showProgressNotify();
        ((IViewNotification) iView).showProgressNotifyUnsureDone();
    }

    @Override
    public void showCustomProgressNotify() {
        mProgressNotification.downloadThread = null;
        mProgressNotification.isCustom = true;
        mProgressNotification.indeterminate = false;
        mProgressNotification.showCustomProgressNotify(context.getResources().getString(R.string.notification_progress_download_wait));
        ((IViewNotification) iView).showCustomProgressNotifyDone();
    }

    @Override
    public void startDownloadNotify() {
        mProgressNotification.startDownloadNotify();
        ((IViewNotification) iView).startDownloadNotifyDone();
    }

    @Override
    public void pauseDownloadNotify() {
        mProgressNotification.pauseDownloadNotify();
        ((IViewNotification) iView).pauseDownloadNotifyDone();
    }

    @Override
    public void stopDownloadNotify() {
        mProgressNotification.stopDownloadNotify();
        ((IViewNotification) iView).stopDownloadNotifyDone();
    }

    @Override
    public void clearNotify() {
        MyNotification.mMyNotificationManager.clearNotify(mCustomNotification.notifyId);
        MyNotification.mMyNotificationManager.clearNotify(mNativeNotification.notifyId);
        MyNotification.mMyNotificationManager.clearNotify(mProgressNotification.notifyId);
        ((IViewNotification) iView).clearNotifyDone();
    }

    @Override
    public void clearAllNotify() {
        MyNotification.mMyNotificationManager.clearAllNotify();
        ((IViewNotification) iView).clearAllNotifyDone();
    }
}
