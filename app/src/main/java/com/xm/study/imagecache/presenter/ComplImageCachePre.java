package com.xm.study.imagecache.presenter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.xm.study.R;
import com.xm.study.base.ComplPresenter;
import com.xm.study.base.IView;
import com.xm.study.imagecache.utils.Consts;
import com.xm.study.imagecache.utils.DialogUtil;
import com.xm.study.imagecache.view.IImageCacheView;
import com.xm.utils.LogUtils;
import com.xm.utils.ToastUtil;
import com.xm.utils.volley.VolleyController;
import com.xm.utils.volley.VolleyErrorHelper;
import com.xm.utils.volley.VolleyUtils;
import com.xm.utils.volley.request.XMLRequest;
import com.xm.utils.volley.utils.ImageCacheManager;

import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: xm on 2017/9/4.
 * @describe:
 */
public class ComplImageCachePre extends ComplPresenter implements IImageCachePre {

    public ComplImageCachePre(Context context, IView iView) {
        super(context, iView);
    }


    @Override
    public void getImageFromJson() {
        getImageFromJson(context, Consts.FROM_JSON);
    }

    @Override
    public void getImageFromInternet() {
        getImageFromInternet(context, Consts.FROM_INTERNET);
        ((IImageCacheView) iView).getImageFromInternetDone();
    }

    @Override
    public void getDataFromXML() {
        getDataFromXML(context, Consts.FROM_XML);
        ((IImageCacheView) iView).getDataFromXMLDone();
    }

    @Override
    public void getImageFromCache() {
        getImageFromCache(context, Consts.FROM_INTERNET);
    }

    private void getImageFromJson(final Context context, String url) {
        //优先级有LOW，NORMAL,HIGH,IMMEDIATE
        //设置请求的优先级别通过覆写getPrioriity()方法
        final Request.Priority priority = Request.Priority.HIGH;
        //用来保存post参数
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("userId", "123189283");
        JsonObjectRequest req = new JsonObjectRequest(url, new JSONObject(params), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                //正确响应时回调此函数
                ((IImageCacheView) iView).getImageFromJsonSuccess(response.toString());
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                //正确响应时回调此函数
                LogUtils.e(VolleyErrorHelper.getMessage(error, context));
                ((IImageCacheView) iView).getImageFromJsonError(VolleyErrorHelper.getMessage(error, context));
            }
        }) {
            //设置请求级别
            @Override
            public Priority getPriority() {
                return priority;
            }

            //设置请求头
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return super.getHeaders();
            }
        };
        //第一个代表超时时间：即超过20S认为超时，第三个参数代表最大重试次数，这里设置为1.0f代表如果超时，则不重试
        req.setRetryPolicy(new DefaultRetryPolicy(20 * 1000, 1, 1.0f));
        //可以通过setTag方法为每一个Request添加tag
        req.setTag(TAG);
        //也可以在我们实现的添加进RequestQueue的时候设置
        VolleyController.getInstance(context).addToRequestQueue(req, TAG);
        //取消Request
//    	VolleyController.getInstance(this).getRequestQueue().cancelAll("My Tag");
        //或者我们前面实现的方法
//    	VolleyController.getInstance(this).cancelPendingRequests("My Tag");
    }

    public void getImageFromInternet(final Context context, String rul) {

        VolleyUtils.ImageView(context, rul, new VolleyUtils.MyImageListener() {
            @Override
            public void setImageBitmap(final Bitmap bitmap) {
                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
//                        showDialog(context, bitmap);
                        showAnyDialog(context, bitmap);
                    }
                }, 1000 * 10);
            }
        });
    }

    private void showDialog(final Context context, Bitmap bitmap) {
        DialogUtil.showDialog(context, bitmap, new DialogUtil.ItemOnListener() {
            @Override
            public void itemOnListener(View view) {
                ToastUtil.toast(context, "itemOnListener");
            }

            @Override
            public void closeOnListener(View view) {
                ToastUtil.toast(context, "closeOnListener");
            }
        });
    }

    private void showAnyDialog(final Context context, Bitmap bitmap) {
        DialogUtil.showAnyDialog(context, R.layout.image_cache_dialog, bitmap, new DialogUtil.ItemOnListener() {
            @Override
            public void itemOnListener(View view) {
                ToastUtil.toast(context, "itemOnListener");
            }

            @Override
            public void closeOnListener(View view) {
                ToastUtil.toast(context, "closeOnListener");
            }
        });
    }

    public void getDataFromXML(final Context context, String url) {
        XMLRequest xmlRequest = new XMLRequest(url, new Response.Listener<XmlPullParser>() {
            @Override
            public void onResponse(XmlPullParser response) {
                try {
                    int eventType = response.getEventType();
                    while (eventType != XmlPullParser.END_DOCUMENT) {
                        switch (eventType) {
                            case XmlPullParser.START_TAG:
                                String nodeName = response.getName();
                                if ("city".equals(nodeName)) {
                                    String pName = response.getAttributeValue(0);
                                    Log.e(TAG, "pName is " + pName);
                                }
                                break;
                        }
                        eventType = response.next();
                    }
                } catch (XmlPullParserException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                LogUtils.e(VolleyErrorHelper.getMessage(error, context));
            }
        });
        VolleyController.getInstance(context).addToRequestQueue(xmlRequest, TAG);
    }

    public void getImageFromCache(Context context, String url) {
        Bitmap defaultImage = BitmapFactory.decodeResource(context.getResources(), R.mipmap.image_cache_loading);
        Bitmap errorImage = BitmapFactory.decodeResource(context.getResources(), R.mipmap.image_cache_load_error);
        ((IImageCacheView) iView).getImageFromCacheDone(url, defaultImage, errorImage);
    }
}
