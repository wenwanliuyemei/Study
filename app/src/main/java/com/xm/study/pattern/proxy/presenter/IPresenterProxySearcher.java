package com.xm.study.pattern.proxy.presenter;

import com.xm.study.base.IPresenter;

/**
 * @author: xm on 2017/7/31.
 * @describe:
 */

public interface IPresenterProxySearcher extends IPresenter {

    public void doSearch(String key);

}
