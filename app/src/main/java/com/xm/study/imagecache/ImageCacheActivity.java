package com.xm.study.imagecache;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.xm.study.R;
import com.xm.study.base.BaseActivity;
import com.xm.study.imagecache.presenter.ComplImageCachePre;
import com.xm.study.imagecache.presenter.IImageCachePre;
import com.xm.utils.image.ImageHandle;
import com.xm.study.imagecache.view.IImageCacheView;
import com.xm.utils.LogUtils;
import com.xm.utils.volley.utils.ImageCacheManager;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ImageCacheActivity extends BaseActivity implements IImageCacheView {

    @Bind(R.id.tv_json)
    TextView tvJson;
    @Bind(R.id.tv_from_internet)
    TextView tvFromInternet;
    @Bind(R.id.tv_from_xml)
    TextView tvFromXml;
    @Bind(R.id.tv_get_from_cache)
    TextView tvGetFromCache;
    @Bind(R.id.tv_content)
    TextView tvContent;
    @Bind(R.id.iv_imgView)
    ImageView ivImgView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_cache);
        ButterKnife.bind(this);
        ivImgView.setImageBitmap(ImageHandle.decodeSampledBitmapFromResource(
                getResources(), R.mipmap.image_cache_dialog_iv_show, 50, 50));
        iPresenter = new ComplImageCachePre(this, this);
    }

    @OnClick({R.id.tv_json, R.id.tv_from_internet, R.id.tv_from_xml, R.id.tv_get_from_cache, R.id.tv_content,
            R.id.iv_imgView})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_json:
                ((IImageCachePre) iPresenter).getImageFromJson();
                break;
            case R.id.tv_from_internet:
                ((IImageCachePre) iPresenter).getImageFromInternet();
                break;
            case R.id.tv_from_xml:
                ((IImageCachePre) iPresenter).getDataFromXML();
                break;
            case R.id.tv_get_from_cache:
                ((IImageCachePre) iPresenter).getImageFromCache();
                break;
            case R.id.tv_content:
                break;
            case R.id.iv_imgView:
                break;
        }
    }

    @Override
    public void getImageFromJsonSuccess(String result) {
        setContent(result, "getImageFromJsonSuccess");
    }


    @Override
    public void getImageFromJsonError(String result) {
        setContent(result, "getImageFromJsonError");
    }

    @Override
    public void getImageFromInternetDone() {
        logE("getImageFromInternetDone");
    }

    @Override
    public void getDataFromXMLDone() {
        logE("getDataFromXMLDone");
    }

    @Override
    public void getImageFromCacheDone(String url, Bitmap defaultImage, Bitmap errorImage) {
        ImageCacheManager.loadImage(this, url, ivImgView, defaultImage, errorImage);
    }

    private void setContent(String result, String log) {
        logE(log);
        tvContent.setText(result);
    }

    private void logE(String log) {
        LogUtils.e(log);
    }
}
