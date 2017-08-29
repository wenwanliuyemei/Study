package com.xm.study.lvheadfixed;

import android.content.Context;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.xm.study.R;
import com.xm.study.base.BaseActivity;
import com.xm.study.lvheadfixed.presenter.LVHeadFixedPresenterCompl;
import com.xm.study.lvheadfixed.widget.MyScrollView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LVHeadFixedActivity extends BaseActivity implements MyScrollView.OnScrollListener {

    private WindowManager mWindowManager;
    /**
     * 手机屏幕宽度
     */
    private int screenWidth;
    /**
     * 悬浮框View
     */
    private static View suspendView;
    /**
     * 悬浮框的参数
     */
    private static WindowManager.LayoutParams suspendLayoutParams;
    /**
     * 购买布局的高度
     */
    private int buyLayoutHeight;
    /**
     * myScrollView与其父类布局的顶部距离
     */
    private int svShowTop;

    /**
     * 购买布局与其父类布局的顶部距离
     */
    private int buyLayoutTop;

    @Bind(R.id.iv_title)
    ImageView ivTitle;
    @Bind(R.id.iv_bunner)
    ImageView ivBunner;
    @Bind(R.id.buy_layout)
    ImageView buyLayout;
    @Bind(R.id.sv_show)
    MyScrollView svShow;
    @Bind(R.id.lay_buy)
    LinearLayout layBuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lvhead_fixed);
        ButterKnife.bind(this);

        iPresenter = new LVHeadFixedPresenterCompl(this, this);

        svShow.setOnScrollListener(this);
        mWindowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        screenWidth = mWindowManager.getDefaultDisplay().getWidth();
    }

    /**
     * 窗口有焦点的时候，即所有的布局绘制完毕的时候，我们来获取购买布局的高度和myScrollView距离父类布局的顶部位置
     */
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            buyLayoutHeight = layBuy.getHeight();
            buyLayoutTop = layBuy.getTop();
            svShowTop = svShow.getTop();
        }
    }

    /**
     * 滚动的回调方法，当滚动的Y距离大于或者等于 购买布局距离父类布局顶部的位置，就显示购买的悬浮框
     * 当滚动的Y的距离小于 购买布局距离父类布局顶部的位置加上购买布局的高度就移除购买的悬浮框
     */
    @Override
    public void onScroll(int scrollY) {
        if (scrollY >= buyLayoutTop) {
            if (suspendView == null) {
                showSuspend();
            }
        } else if (scrollY <= buyLayoutTop + buyLayoutHeight) {
            if (suspendView != null) {
                removeSuspend();
            }
        }
    }

    @OnClick({R.id.iv_title, R.id.iv_bunner, R.id.buy_layout, R.id.sv_show})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_title:
                break;
            case R.id.iv_bunner:
                break;
            case R.id.buy_layout:
                break;
            case R.id.sv_show:
                break;
        }
    }

    /**
     * 显示购买的悬浮框
     */
    private void showSuspend() {
        if (suspendView == null) {
            suspendView = LayoutInflater.from(this).inflate(R.layout.layout_lv_head_fixed_buy, null);
            if (suspendLayoutParams == null) {
                suspendLayoutParams = new WindowManager.LayoutParams();
                suspendLayoutParams.type = WindowManager.LayoutParams.TYPE_PHONE;
                suspendLayoutParams.format = PixelFormat.RGBA_8888;
                suspendLayoutParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                        | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
                suspendLayoutParams.gravity = Gravity.TOP;
                suspendLayoutParams.width = screenWidth;
                suspendLayoutParams.height = buyLayoutHeight;
                suspendLayoutParams.x = 0;
                suspendLayoutParams.y = svShowTop;
            }
        }

        mWindowManager.addView(suspendView, suspendLayoutParams);
    }

    /**
     * 移除购买的悬浮框
     */
    private void removeSuspend() {
        if (suspendView != null) {
            mWindowManager.removeView(suspendView);
            suspendView = null;
        }
    }
}
