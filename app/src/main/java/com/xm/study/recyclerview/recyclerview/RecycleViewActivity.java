package com.xm.study.recyclerview.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.xm.study.R;
import com.xm.study.base.BaseActivity;
import com.xm.study.recyclerview.recyclerview.adapter.AllAdapter;
import com.xm.study.recyclerview.recyclerview.adapter.ShortcutAdapter;
import com.xm.study.recyclerview.recyclerview.adapter.UpdateAdapter;
import com.xm.study.recyclerview.recyclerview.model.AppInfo;
import com.xm.study.recyclerview.recyclerview.presenter.ComplPresenterRecyclerView;
import com.xm.study.recyclerview.recyclerview.view.IViewRecyclerView;
import com.xm.study.recyclerview.recyclerview.widget.ItemDivider;
import com.xm.study.recyclerview.xrecyclerview.XRecycleViewActivity;
import com.xm.utils.IntentUtils;
import com.xm.utils.LogUtils;
import com.xm.utils.ToastUtil;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RecycleViewActivity extends BaseActivity implements IViewRecyclerView, RadioGroup.OnCheckedChangeListener {

    @Bind(R.id.rv_shortcut)
    RecyclerView rvShortcut;
    @Bind(R.id.rb_top)
    RadioButton rbTop;
    @Bind(R.id.rb_middle)
    RadioButton rbMiddle;
    @Bind(R.id.rb_bottom)
    RadioButton rbBottom;
    @Bind(R.id.rg)
    RadioGroup rg;
    @Bind(R.id.rv_main)
    RecyclerView rvMain;

    public ArrayList<AppInfo> appInfos = new ArrayList<>();
    private AllAdapter allAdapter;
    private UpdateAdapter updateAdapter;
    private ShortcutAdapter shortcutAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);
        ButterKnife.bind(this);

        iPresenter = new ComplPresenterRecyclerView(this, this);

        ((ComplPresenterRecyclerView) iPresenter).getAppInfos(appInfos, 20);

        LinearLayoutManager lm = new LinearLayoutManager(this);
        lm.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvShortcut.setLayoutManager(lm);
        ItemDivider divider = new ItemDivider();
        divider.setWidth(17);
        shortcutAdapter = new ShortcutAdapter();
        rvShortcut.setAdapter(shortcutAdapter);
        shortcutAdapter.setOnItemClickListener(new ShortcutAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                XRecycleViewActivity.intent(RecycleViewActivity.this);
            }
        });


        rbTop.setChecked(true);
        rg.setOnCheckedChangeListener(this);


        GridLayoutManager gm = new GridLayoutManager(this, 2);
        gm.setOrientation(GridLayoutManager.HORIZONTAL);
        rvMain.setLayoutManager(gm);
        allAdapter = new AllAdapter();
        updateAdapter = new UpdateAdapter(appInfos);
        rvMain.setAdapter(allAdapter);
        allAdapter.setOnItemClickListener(new AllAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                XRecycleViewActivity.intent(RecycleViewActivity.this);
            }
        });
        allAdapter.OnBtnInstallClickListener(new AllAdapter.OnBtnInstallClickListener() {
            @Override
            public void onBtnInstallClick(int position) {
                ToastUtil.toast(RecycleViewActivity.this, "allAdapter--Install:" + position);
            }
        });
        updateAdapter.setOnItemClickListener(new UpdateAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                XRecycleViewActivity.intent(RecycleViewActivity.this);
            }
        });
        updateAdapter.OnIvSelClickListener(new UpdateAdapter.OnIvSelClickListener() {
            @Override
            public void onSelClick(int position) {
                ToastUtil.toast(RecycleViewActivity.this, "updateAdapter--Sel:" + position);
            }
        });
        updateAdapter.OnBtnInstallClickListener(new UpdateAdapter.OnBtnInstallClickListener() {
            @Override
            public void onBtnInstallClick(int position) {
                ToastUtil.toast(RecycleViewActivity.this, "updateAdapter--Install" + position);
            }
        });
    }

    @Override
    public void getAppInfosDoen() {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId) {
            case R.id.rb_top:
                LogUtils.e("==", "全部应用");
                rvMain.setAdapter(allAdapter);
                break;
            case R.id.rb_middle:
                LogUtils.e("==", "升级应用");
                rvMain.setAdapter(updateAdapter);
                break;
            case R.id.rb_bottom:
                LogUtils.e("==", "管理应用");
                rvMain.setAdapter(allAdapter);
                break;
        }
    }
}
