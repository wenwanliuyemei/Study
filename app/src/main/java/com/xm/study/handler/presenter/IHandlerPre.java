package com.xm.study.handler.presenter;

import com.xm.study.base.IPresenter;

/**
 * @author: xm on 2017/8/10.
 * @describe:
 */

public interface IHandlerPre extends IPresenter {

    public void main(String str);

    public void child(String str);

    public void hPost(String str);

    public void viewPost(String str);

    public void mainUI(String str);
}
