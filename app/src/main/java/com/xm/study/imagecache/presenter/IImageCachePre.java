package com.xm.study.imagecache.presenter;

import com.xm.study.base.IPresenter;

/**
 * @author: xm on 2017/9/4.
 * @describe:
 */

public interface IImageCachePre extends IPresenter {

    public void getImageFromJson();

    public void getImageFromInternet();

    public void getDataFromXML();

    public void getImageFromCache();
}
