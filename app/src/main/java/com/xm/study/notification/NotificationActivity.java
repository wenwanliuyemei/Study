package com.xm.study.notification;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.xm.study.R;
import com.xm.study.base.BaseActivity;
import com.xm.study.home.HomeActivity;
import com.xm.study.notification.presenter.ComplPresenterNotification;
import com.xm.study.notification.view.IViewNotification;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NotificationActivity extends BaseActivity implements IViewNotification {

    @Bind(R.id.tv_notification_custom)
    TextView tvNotificationCustom;
    @Bind(R.id.tv_notification_custom_button)
    TextView tvNotificationCustomButton;
    @Bind(R.id.tv_notification_native_show)
    TextView tvNotificationNativeShow;
    @Bind(R.id.tv_notification_native_show_big_style)
    TextView tvNotificationNativeShowBigStyle;
    @Bind(R.id.tv_notification_native_show_permanent)
    TextView tvNotificationNativeShowPermanent;
    @Bind(R.id.tv_notification_native_show_intent_activity)
    TextView tvNotificationNativeShowIntentActivity;
    @Bind(R.id.tv_notification_native_show_intent_app)
    TextView tvNotificationNativeShowIntentApp;
    @Bind(R.id.tv_notification_native_clear)
    TextView tvNotificationNativeClear;
    @Bind(R.id.tv_notification_native_clear_all)
    TextView tvNotificationNativeClearAll;
    @Bind(R.id.tv_notification_progress_default)
    TextView tvNotificationProgressDefault;
    @Bind(R.id.tv_notification_progress_default_unsure)
    TextView tvNotificationProgressDefaultUnsure;
    @Bind(R.id.tv_notification_progress_custom)
    TextView tvNotificationProgressCustom;
    @Bind(R.id.tv_notification_progress_download_start)
    TextView tvNotificationProgressDownloadStart;
    @Bind(R.id.tv_notification_progress_download_pause)
    TextView tvNotificationProgressDownloadPause;
    @Bind(R.id.tv_notification_progress_download_cancel)
    TextView tvNotificationProgressDownloadCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        ButterKnife.bind(this);
        initNotification();
    }

    private void initNotification() {
        iPresenter = new ComplPresenterNotification(this, this);
        ((ComplPresenterNotification) iPresenter).initNotify();
    }

    @Override
    protected void onStop() {
        super.onStop();
        ((ComplPresenterNotification) iPresenter).unregisterCustom();
    }

    @OnClick({R.id.tv_notification_custom, R.id.tv_notification_custom_button, R.id.tv_notification_native_show,
            R.id.tv_notification_native_show_big_style, R.id.tv_notification_native_show_permanent,
            R.id.tv_notification_native_show_intent_activity, R.id.tv_notification_native_show_intent_app,
            R.id.tv_notification_native_clear, R.id.tv_notification_native_clear_all, R.id.tv_notification_progress_default,
            R.id.tv_notification_progress_default_unsure, R.id.tv_notification_progress_custom, R.id.tv_notification_progress_download_start,
            R.id.tv_notification_progress_download_pause, R.id.tv_notification_progress_download_cancel})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_notification_custom:
                ((ComplPresenterNotification) iPresenter).showCustomNotify();
                break;
            case R.id.tv_notification_custom_button:
                ((ComplPresenterNotification) iPresenter).showCustomButtonNotify();
                break;
            case R.id.tv_notification_native_show:
                ((ComplPresenterNotification) iPresenter).showNotify();
                break;
            case R.id.tv_notification_native_show_big_style:
                ((ComplPresenterNotification) iPresenter).showBigStyleNotify();
                break;
            case R.id.tv_notification_native_show_permanent:
                ((ComplPresenterNotification) iPresenter).showCzNotify();
                break;
            case R.id.tv_notification_native_show_intent_activity:
                ((ComplPresenterNotification) iPresenter).showIntentActivityNotify(HomeActivity.class);
                break;
            case R.id.tv_notification_native_show_intent_app:
                ((ComplPresenterNotification) iPresenter).showIntentApkNotify();
                break;
            case R.id.tv_notification_native_clear:
                ((ComplPresenterNotification) iPresenter).clearNotify();
                break;
            case R.id.tv_notification_native_clear_all:
                ((ComplPresenterNotification) iPresenter).clearAllNotify();
                break;
            case R.id.tv_notification_progress_default:
                ((ComplPresenterNotification) iPresenter).showProgressNotify();
                break;
            case R.id.tv_notification_progress_default_unsure:
                ((ComplPresenterNotification) iPresenter).showProgressNotifyUnsure();
                break;
            case R.id.tv_notification_progress_custom:
                ((ComplPresenterNotification) iPresenter).showCustomProgressNotify();
                break;
            case R.id.tv_notification_progress_download_start:
                ((ComplPresenterNotification) iPresenter).startDownloadNotify();
                break;
            case R.id.tv_notification_progress_download_pause:
                ((ComplPresenterNotification) iPresenter).pauseDownloadNotify();
                break;
            case R.id.tv_notification_progress_download_cancel:
                ((ComplPresenterNotification) iPresenter).stopDownloadNotify();
                break;
        }
    }

    @Override
    public void initNotifyDone() {
        Log.e(TAG, "initCustomNotifyDone");
    }

    @Override
    public void showCustomNotifyDone() {
        Log.e(TAG, "showCustomNotifyDone");
    }

    @Override
    public void showCustomButtonNotifyDone() {
        Log.e(TAG, "showCustomButtonNotifyDone");
    }

    @Override
    public void registerCustomDone() {
        Log.e(TAG, "registerCustomDone");
    }

    @Override
    public void unregisterCustomDone() {
        Log.e(TAG, "unregisterCustomDone");
    }

    @Override
    public void showNotifyDone() {
        Log.e(TAG, "showNotifyDone");
    }

    @Override
    public void showBigStyleNotifyDone() {
        Log.e(TAG, "showBigStyleNotifyDone");
    }

    @Override
    public void showCzNotifyDone() {
        Log.e(TAG, "showCzNotifyDone");
    }

    @Override
    public void showIntentActivityNotifyDone() {
        Log.e(TAG, "showIntentActivityNotifyDone");
    }

    @Override
    public void showIntentApkNotifyDone() {
        Log.e(TAG, "showIntentApkNotifyDone");
    }

    @Override
    public void showProgressNotifyDone() {
        Log.e(TAG, "showProgressNotifyDone");
    }

    @Override
    public void showProgressNotifyUnsureDone() {
        Log.e(TAG, "showProgressNotifyUnsureDone");
    }

    @Override
    public void showCustomProgressNotifyDone() {
        Log.e(TAG, "showCustomProgressNotifyDone");
    }

    @Override
    public void startDownloadNotifyDone() {
        Log.e(TAG, "startDownloadNotifyDone");
    }

    @Override
    public void pauseDownloadNotifyDone() {
        Log.e(TAG, "pauseDownloadNotifyDone");
    }

    @Override
    public void stopDownloadNotifyDone() {
        Log.e(TAG, "stopDownloadNotifyDone");
    }

    @Override
    public void clearNotifyDone() {
        Log.e(TAG, "clearNotifyDone");
    }

    @Override
    public void clearAllNotifyDone() {
        Log.e(TAG, "clearAllNotifyDone");
    }
}
