package com.xm.study.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.xm.study.R;
import com.xm.study.base.BaseActivity;
import com.xm.study.home.presenter.HomePresenterCompl;
import com.xm.study.home.presenter.IHomePresenter;
import com.xm.study.home.view.IHomeView;
import com.xm.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：xm on 2017/1/3 11:04
 * 描述：主页  MVP
 */
public class HomeActivity extends BaseActivity implements AdapterView.OnItemClickListener, IHomeView {

    private ListView lv_home;
    private RelativeLayout rl_home;
    private List<String> mDataList = new ArrayList<>();
    private BaseAdapter mBaseAdapter;
    private IHomePresenter mIHomePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity_home);

        //find view
        lv_home = (ListView) findViewById(R.id.lv_home);
        rl_home = (RelativeLayout) findViewById(R.id.rl_home);

        //set listener
        lv_home.setOnItemClickListener(this);

        //init
        mBaseAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mDataList);
        lv_home.setAdapter(mBaseAdapter);
        mIHomePresenter = new HomePresenterCompl(this, this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIHomePresenter.itemEmptyView();
        mIHomePresenter.loadDatas();
    }

    @Override
    public void onGetDataList(List<String> dataList) {
        if (dataList != null && dataList.size() > 0) {
            mDataList.clear();
            mDataList.addAll(dataList);
            mBaseAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void toast(String msg) {
        ToastUtil.toast(HomeActivity.this, msg);
    }

    @Override
    public void itemEmptyView(View loadingView, RelativeLayout.LayoutParams layoutParams) {
        rl_home.addView(loadingView, layoutParams);
        lv_home.setEmptyView(loadingView);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        mIHomePresenter.onItemClick(i);
    }
}
