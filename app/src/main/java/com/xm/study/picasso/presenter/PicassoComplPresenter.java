package com.xm.study.picasso.presenter;

import android.content.Context;

import com.xm.study.base.IView;
import com.xm.study.base.ComplPresenter;
import com.xm.study.picasso.view.IPicassoView;

import java.util.ArrayList;

/**
 * Created by zhangxiumei on 2017/5/3.
 */

public class PicassoComplPresenter extends ComplPresenter implements IPicassoPresenter {

    public PicassoComplPresenter(Context context, IView iView) {
        super(context, iView);
    }

    @Override
    public void getImageUrls() {
        ArrayList<String> listImageUrls=new ArrayList<>();
        listImageUrls.add("http://h.hiphotos.baidu.com/image/w%3D310/sign=53d5f82103e9390156028b3f4bec54f9/574e9258d109b3deb38ea469cebf6c81800a4cf9.jpg");
        listImageUrls.add("http://c.hiphotos.baidu.com/image/w%3D310/sign=1214242166380cd7e61ea4ec9145ad14/ae51f3deb48f8c5436841ebe39292df5e1fe7fc8.jpg");
        listImageUrls.add("http://c.hiphotos.baidu.com/image/w%3D310/sign=4bebf5c06e81800a6ee58f0f813433d6/7c1ed21b0ef41bd537dde4bb53da81cb38db3df6.jpg");
        ((IPicassoView) iView).getImageUrls(listImageUrls);
    }
}
