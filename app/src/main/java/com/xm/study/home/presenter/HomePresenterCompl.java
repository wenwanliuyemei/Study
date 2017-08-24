package com.xm.study.home.presenter;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.xm.study.R;
import com.xm.study.cardview.CardViewActivity;
import com.xm.study.crashreport.CrashReportActivity;
import com.xm.study.dataalgorithm.DataAlgorithmActivity;
import com.xm.study.datastructure.DataStructureActivity;
import com.xm.study.dynamic1.DynamicActivity;
import com.xm.study.encode.EncodeActivity;
import com.xm.study.downlaod.DownloadActivity;
import com.xm.study.easechat.login.ECLoginActivity;
import com.xm.study.fastjson.FastJsonActivity;
import com.xm.study.fix.andfix.AndFixActivity;
import com.xm.study.genericity.GenericityActivity;
import com.xm.study.handler.HandlerActivity;
import com.xm.study.home.utils.ActivityHolder;
import com.xm.study.home.view.IHomeView;
import com.xm.study.linechart.LineChartActivity;
import com.xm.study.notification.NotificationActivity;
import com.xm.study.okhttp.OkHttpActivity;
import com.xm.study.okhttp2.OkHttp2Activity;
import com.xm.study.pattern.observer.exit.ObserverExitActivity;
import com.xm.study.pattern.proxy.ProxySearcherActivity;
import com.xm.study.picasso.PicassoActivity;
import com.xm.study.recyclerview.recyclerview.RecycleViewActivity;
import com.xm.study.recyclerview.xrecyclerview.XRecycleViewActivity;
import com.xm.study.reflect.TestReflectActivity;
import com.xm.study.staticmethod.StaticMethodActivity;
import com.xm.study.thread.ThreadActivity;
import com.xm.study.upwardtransiton.UpwardTransitonActivity;

/**
 * 作者：xm on 2017/1/3 11:33
 * 描述：
 */
public class HomePresenterCompl implements IHomePresenter {

    public static ActivityHolder mActivityHolder;
    private Context mContext;
    private IHomeView mIHomeView;

    static {
        mActivityHolder = new ActivityHolder();
        mActivityHolder.addActivity("TestReflectActivity", TestReflectActivity.class);
        mActivityHolder.addActivity("GenericityActivity", GenericityActivity.class);
        mActivityHolder.addActivity("DataStructureActivity", DataStructureActivity.class);
        mActivityHolder.addActivity("LineChartActivity", LineChartActivity.class);
        mActivityHolder.addActivity("ThreadActivity", ThreadActivity.class);
        mActivityHolder.addActivity("DownloadActivity", DownloadActivity.class);
        mActivityHolder.addActivity("DataAlgorithmActivity", DataAlgorithmActivity.class);
        mActivityHolder.addActivity("StaticMethodActivity", StaticMethodActivity.class);
        mActivityHolder.addActivity("UpwardTransitonActivity", UpwardTransitonActivity.class);
        mActivityHolder.addActivity("ECLoginActivity", ECLoginActivity.class);
        mActivityHolder.addActivity("EncodeActivity", EncodeActivity.class);
        mActivityHolder.addActivity("PicassoActivity", PicassoActivity.class);
        mActivityHolder.addActivity("FastJsonActivity", FastJsonActivity.class);
        mActivityHolder.addActivity("XRecycleViewActivity", XRecycleViewActivity.class);
        mActivityHolder.addActivity("RecycleViewActivity", RecycleViewActivity.class);
        mActivityHolder.addActivity("CardViewActivity", CardViewActivity.class);
        mActivityHolder.addActivity("CrashReportActivity", CrashReportActivity.class);
        mActivityHolder.addActivity("NotificationActivity", NotificationActivity.class);
        mActivityHolder.addActivity("OkHttpActivity", OkHttpActivity.class);
        mActivityHolder.addActivity("OkHttp2Activity", OkHttp2Activity.class);
        mActivityHolder.addActivity("ObserverExitActivity", ObserverExitActivity.class);
        mActivityHolder.addActivity("ProxySearcherActivity", ProxySearcherActivity.class);
        mActivityHolder.addActivity("HandlerActivity", HandlerActivity.class);
        mActivityHolder.addActivity("DynamicActivity", DynamicActivity.class);
        mActivityHolder.addActivity("AndFixActivity", AndFixActivity.class);
    }

    public HomePresenterCompl(Context context, IHomeView iHomeView) {
        mContext = context;
        mIHomeView = iHomeView;
    }

    @Override
    public void loadDatas() {
        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mIHomeView.onGetDataList(mActivityHolder.getmNaneList());
            }
        }, 2000);
    }

    @Override
    public void onItemClick(int position) {
        Class activity = mActivityHolder.getActivity(mActivityHolder.getmNaneList().get(position));
        if (activity != null) {
            mContext.startActivity(new Intent(mContext, activity));
        }
    }

    @Override
    public void itemEmptyView() {
        View loadingView = LayoutInflater.from(mContext).inflate(R.layout.home_item_empty_view, null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);
        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        mIHomeView.itemEmptyView(loadingView, layoutParams);
    }
}
