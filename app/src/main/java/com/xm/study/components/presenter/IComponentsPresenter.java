package com.xm.study.components.presenter;

import com.xm.study.base.IPresenter;

/**
 * @author: xm on 2017/10/9.
 * @describe:
 */

public interface IComponentsPresenter extends IPresenter {

    void byBinderInit();

    void byBinderDonwload();

    void byBinderUnbind();
}
