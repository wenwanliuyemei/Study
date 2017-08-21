package com.xm.study.okhttp2.model;

import android.content.Context;
import android.text.TextUtils;

import com.xm.study.okhttp2.model.bean.HttpResult;
import com.xm.study.okhttp2.model.bean.LoginBean;
import com.xm.study.okhttp2.model.bean.UpdateBean;
import com.xm.study.okhttp2.utils.network.HttpParameUtils;
import com.xm.study.okhttp2.utils.network.HttpService;
import com.xm.utils.encrypt.Security;
import com.xm.utils.okhttp2.HttpServiceFactory;

import java.util.HashMap;
import java.util.Map;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by YanWei on 2017/4/10.
 */

public class LoginModelCompl implements LoginModel {

    @Override
    public Observable<HttpResult<LoginBean>> getUserInfo(String name, String psd, Context context) {
        Map<String, String> map = new HashMap<>();
        map.put("user_mobile", name);
        map.put("password", Security.encryptByBase64andRSA(psd));
        if (!TextUtils.isEmpty(Data.TOKEN_DEVICE))
            map.put("device_token", Data.TOKEN_DEVICE);
        map = HttpParameUtils.POST(map, context);
        Observable<HttpResult<LoginBean>> subscribe = HttpServiceFactory.getInstance().createService(HttpService.class,HttpService.BASE_URL_1)
                .getToken(map)
                .subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        return subscribe;
    }

    @Override
    public Observable<UpdateBean> update(Context context) {
        Map<String, String> map = new HashMap<>();
        //http://112.33.5.40:10002/api/update?org=a&verNo=V1.7.9
        map.put("org", "a");
        map.put("verNo", "1.7.9");
        Observable<UpdateBean> subscribe = HttpServiceFactory.getInstance().createService(HttpService.class,HttpService.BASE_URL_2)
                .update(map)
                .subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        return subscribe;
    }


}
