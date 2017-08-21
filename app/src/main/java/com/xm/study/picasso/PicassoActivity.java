package com.xm.study.picasso;

import android.os.Bundle;
import android.widget.ListView;

import com.xm.study.R;
import com.xm.study.base.BaseActivity;
import com.xm.study.picasso.adapter.ImagelistAdapter;
import com.xm.study.picasso.presenter.PicassoComplPresenter;
import com.xm.study.picasso.view.IPicassoView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by zhangxiumei on 2017/5/2.
 */

public class PicassoActivity extends BaseActivity implements IPicassoView {

    @Bind(R.id.lv_show)
    ListView lvShow;
    //放图片资源的集合
    private ArrayList<String> listImageUrls = new ArrayList<>();
    private ImagelistAdapter imagelistAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picasso);
        ButterKnife.bind(this);
        iPresenter = new PicassoComplPresenter(this, this);
        init();
        ((PicassoComplPresenter) iPresenter).getImageUrls();
    }

    private void init() {
        imagelistAdapter = new ImagelistAdapter(this, listImageUrls);
        lvShow.setAdapter(imagelistAdapter);
    }

    @Override
    public void getImageUrls(ArrayList<String> listImageUrls) {
        if (listImageUrls != null) {
            this.listImageUrls.clear();
            this.listImageUrls.addAll(listImageUrls);
        }
        imagelistAdapter.notifyDataSetChanged();
    }
}
