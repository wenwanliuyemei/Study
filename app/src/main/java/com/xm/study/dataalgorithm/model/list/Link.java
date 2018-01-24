package com.xm.study.dataalgorithm.model.list;

import com.xm.utils.LogUtils;

/**
 * @author: xm on 2018/1/24.
 * @describe:
 */

public class Link {

    public int iData;
    public double dData;
    public Link next;

    public Link(int id, double dd) {
        iData = id;
        dData = dd;
    }

    public void displayLink() {
        LogUtils.e("iData=" + iData + ",dData=" + dData);
    }
}
