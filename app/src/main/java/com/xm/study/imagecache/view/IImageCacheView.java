package com.xm.study.imagecache.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.xm.study.base.IView;

/**
 * @author: xm on 2017/9/4.
 * @describe:
 */

public interface IImageCacheView extends IView {

    public void getImageFromJsonSuccess(String result);

    public void getImageFromJsonError(String result);

    public void getImageFromInternetDone();

    public void getDataFromXMLDone();

    public void getImageFromCacheDone(String url, Bitmap defaultImage, Bitmap errorImage);
}
