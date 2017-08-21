package com.xm.study.pattern.proxy;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.xm.study.R;
import com.xm.study.base.BaseActivity;
import com.xm.study.pattern.proxy.presenter.ComplProxySearcherPresenter;
import com.xm.study.pattern.proxy.presenter.IPresenterProxySearcher;
import com.xm.study.pattern.proxy.view.IViewProxySearcher;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author: xm on 2017/7/31.
 * @describe: 搜索功能。
 * http://blog.csdn.net/why_2012_gogo/article/details/45367867
 * 1、代理设计模式是对象的结构模式。
 * 2、原理：是给某个对象提供一个代理对象，并由代理对象来控制对原对象的引用。
 * 3、在有些情况下，一方不能或不想直接引用一个对象，而代理对象可以在双方之间起到中介的作用，这样可以大大降低彼此的耦合关系，提高彼此的灵活性。
 * 4、抽象角色：声明了代理角色和具体角色的共用接口，促使可以使用具体实角色的地方都可使用代理角色。
 * 5、具体角色：定义代理角色所要代表的具体角色。
 * 6、代理角色：包含对具体角色的引用，从而可以在任何时候操作具体角色对象；代理角色提供了与具体角色相同的接口，可以方便在任何时候替代具体角色对象。
 * 要实现一个搜索功能。
 * 1、搜索数据之前，需要先验证用户是否为登录或会员，如果不是会员，那么提示并返回不准即系查询；
 * 2、还需要记录会员的搜索记录次数，这样可以帮助运营的后期推广统计哦！记录的次数显示为搜索的次数（每次搜索记录即可）。
 * 3、最终搜出的结果，直接显示为搜索的关键字（正常不是这样的哦）。
 */
public class ProxySearcherActivity extends BaseActivity implements IViewProxySearcher {

    @Bind(R.id.edt_searcher_key)
    EditText edtSearcherKey;
    @Bind(R.id.tv_do_search)
    TextView tvDoSearch;
    @Bind(R.id.tv_search_result)
    TextView tvSearchResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proxy_searcher);
        ButterKnife.bind(this);

        iPresenter = new ComplProxySearcherPresenter(this, this);
    }

    @Override
    public void doSearchDone(String result) {
        tvSearchResult.setText(result);
    }

    @OnClick(R.id.tv_do_search)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_do_search:
                ((IPresenterProxySearcher) iPresenter).doSearch(edtSearcherKey.getText().toString());
                break;
        }
    }
}
