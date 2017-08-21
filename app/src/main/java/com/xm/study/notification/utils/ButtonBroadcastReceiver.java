package com.xm.study.notification.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.xm.study.notification.notification.CustomNotification;
import com.xm.study.notification.notification.ICustomNotification;
import com.xm.study.notification.notification.INotification;

/**
 * Created by zhangxiumei on 2017/5/31.
 */

public class ButtonBroadcastReceiver extends BroadcastReceiver {

    private final String TAG = this.getClass().getSimpleName();

    private INotification mINotification;

    public ButtonBroadcastReceiver(INotification iNotification) {
        mINotification = iNotification;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO Auto-generated method stub
        String action = intent.getAction();
        if (action.equals(CustomNotification.ACTION_BUTTON)) {
            //通过传递过来的ID判断按钮点击属性或者通过getResultCode()获得相应点击事件
            int buttonId = intent.getIntExtra(CustomNotification.INTENT_BUTTONID_TAG, 0);
            switch (buttonId) {
                case CustomNotification.BUTTON_PREV_ID:
                    ((ICustomNotification) mINotification).pre();
                    break;
                case CustomNotification.BUTTON_PALY_ID:
                    ((ICustomNotification) mINotification).play();
                    break;
                case CustomNotification.BUTTON_NEXT_ID:
                    ((ICustomNotification) mINotification).next();
                    break;
                default:
                    break;
            }
        }
    }
}
