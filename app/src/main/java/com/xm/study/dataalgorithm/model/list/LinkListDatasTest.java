package com.xm.study.dataalgorithm.model.list;

import android.content.Context;

import com.xm.utils.LogUtils;

/**
 * @author: xm on 2018/1/29.
 * @describe:
 */

public class LinkListDatasTest {

    private boolean myResult;
    private Context context;
    private int[] arrInt;
    private double[] arrDou;
    private int length;

    public LinkListDatasTest(Context context, int[] arrInt, double... arrDou) {
        this.context = context;
        this.arrInt = arrInt;
        this.arrDou = arrDou;
    }

    public boolean is() {
        return myResult;
    }

    public int getLength() {
        return length;
    }

    public LinkListDatasTest invoke() {
        if (arrInt == null || arrInt.length < 1) {
            LogUtils.logNull(context);
            myResult = true;
            return this;
        }
        if (arrDou == null || arrDou.length < 1) {
            LogUtils.logNull(context);
            myResult = true;
            return this;
        }
        length = Math.min(arrInt.length, arrDou.length);
        myResult = false;
        return this;
    }
}
