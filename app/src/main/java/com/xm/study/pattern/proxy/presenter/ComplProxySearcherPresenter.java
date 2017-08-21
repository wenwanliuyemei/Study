package com.xm.study.pattern.proxy.presenter;

import android.content.Context;
import android.text.TextUtils;

import com.xm.study.R;
import com.xm.study.base.IView;
import com.xm.study.base.ComplPresenter;
import com.xm.study.pattern.proxy.model.SearcherPro;
import com.xm.study.pattern.proxy.model.User;
import com.xm.study.pattern.proxy.view.IViewProxySearcher;

/**
 * @author: xm on 2017/7/31.
 * @describe:
 */

public class ComplProxySearcherPresenter extends ComplPresenter implements IPresenterProxySearcher {

    public ComplProxySearcherPresenter(Context context, IView iView) {
        super(context, iView);
    }

    @Override
    public void doSearch(String key) {
        StringBuffer stringBuffer = new StringBuffer();
        if (TextUtils.isEmpty(key)) {
            stringBuffer.append(context.getString(R.string.pattern_proxy_searcher_do_search_not_null));
        }
        SearcherPro searcher = new SearcherPro();
        User user = new User("001", "001");
        stringBuffer.append(context.getString(R.string.pattern_proxy_searcher_do_search_result));
        stringBuffer.append(searcher.doSearch(user.getUserName(), user.getPassword(), key));
        ((IViewProxySearcher) iView).doSearchDone(stringBuffer.toString());
    }
}
