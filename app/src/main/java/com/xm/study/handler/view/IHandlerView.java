package com.xm.study.handler.view;

import com.xm.study.base.IView;

/**
 * @author: xm on 2017/8/10.
 * @describe:
 */

public interface IHandlerView extends IView {
    public void mainDone(String str);

    public void childDone(String str);

    public void hPostDone(String str);

    public void viewPostDone(String str);

    public void mainUIDone(String str);
}
