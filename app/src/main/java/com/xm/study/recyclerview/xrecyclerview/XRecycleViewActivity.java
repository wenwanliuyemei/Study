package com.xm.study.recyclerview.xrecyclerview;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;

import com.xlibs.xrv.LayoutManager.XLinearLayoutManager;
import com.xlibs.xrv.listener.OnLoadMoreListener;
import com.xlibs.xrv.listener.OnRefreshListener;
import com.xlibs.xrv.view.XRecyclerView;
import com.xm.study.R;
import com.xm.study.base.BaseActivity;
import com.xm.study.recyclerview.recyclerview.RecycleViewActivity;
import com.xm.study.recyclerview.xrecyclerview.adapter.MyAdapter;
import com.xm.study.recyclerview.xrecyclerview.presenter.XRecycleviewComplPresenter;
import com.xm.study.recyclerview.xrecyclerview.view.IViewXRecycleview;
import com.xm.utils.IntentUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class XRecycleViewActivity extends BaseActivity implements IViewXRecycleview {

    @Bind(R.id.xr_test)
    XRecyclerView xrTest;
    private View mHeaderView;
    private View mFooterView;
    private MyAdapter mMyAdapter;
    private List<List<String>> mLists = new ArrayList<>();

    public static void intent(Context context){
        IntentUtils.intent(context, XRecycleViewActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xrecycle_view);

        ButterKnife.bind(this);
        iPresenter = new XRecycleviewComplPresenter(this, this);

        initView();
        ((XRecycleviewComplPresenter) iPresenter).initData();
    }

    private void initView() {
        // 请勿使用系统本身的 LayoutManager ，而是需要使用以下三种 LayoutManager
        XLinearLayoutManager xLinearLayoutManager = new XLinearLayoutManager(this);
        // XGridLayoutManager xGridLayoutManager = new XGridLayoutManager(this,2);
        // XStaggeredGridLayoutManager xStaggeredGridLayoutManager =
        //new XStaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        xrTest.setLayoutManager(xLinearLayoutManager);
        // 添加下拉刷新的头部 和 加载更多的底部，如果不加，默认含有下拉刷新的头部，而没有加载更多的底部
        mHeaderView = LayoutInflater.from(this).inflate(R.layout.recycle_view_custom_header_view, null);
        mFooterView = LayoutInflater.from(this).inflate(R.layout.recycle_view_footer_view, null);

        xrTest.addHeaderView(mHeaderView, 50);
        xrTest.addFootView(mFooterView, 50);

        // 设置adapter
        mMyAdapter = new MyAdapter(mLists);
        xrTest.setAdapter(mMyAdapter);

        // 添加下拉刷新
        xrTest.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshData(0);
            }
        });
        // 加载更多（如果没有添加加载更多的布局，下面那LoadMore不会执行）
        xrTest.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                refreshData(1);
            }
        });
    }

    private void refreshData(final int which) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (which) {
                    case 0:
                        ((XRecycleviewComplPresenter) iPresenter).initRefreshData();
                        break;
                    case 1:
                        ((XRecycleviewComplPresenter) iPresenter).initLoadMoreData();
                        break;
                }
            }
        }, 2000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        xrTest.destroyHandler();
    }

    @Override
    public void initData(List<List<String>> lists) {
        initList(lists);
    }

    @Override
    public void initRefreshData(List<List<String>> lists) {
        initList(lists);
    }

    @Override
    public void initLoadMoreData(List<List<String>> lists) {
        mLists.addAll(lists);
        xrTest.refreshComplate();
//        mMyAdapter.notifyDataSetChanged();
    }

    private void initList(List<List<String>> lists) {
        mLists.clear();
        mLists.addAll(lists);
        xrTest.refreshComplate();
//        mMyAdapter.notifyDataSetChanged();
    }
}
