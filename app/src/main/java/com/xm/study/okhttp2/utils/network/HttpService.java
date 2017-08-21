package com.xm.study.okhttp2.utils.network;


import com.xm.study.okhttp2.model.bean.HttpResult;
import com.xm.study.okhttp2.model.bean.LoginBean;
import com.xm.study.okhttp2.model.bean.UpdateBean;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by Administrator on 2016/9/26.
 */
public interface HttpService {
    //测试地址
    public static final String BASE_URL_1 = "https://121.40.118.13:666/index.php/api/";
    public static final String BASE_URL_2 = "https://121.40.118.13:666/index.php/api/";
    public static final String BASE_H5 = "http://121.40.118.13:8089/mingyuan_m/";
    //生产地址
//    public static final String BASE_URL = "https://118.178.174.26:443/mingyuan/index.php/api/";
//    public static final String BASE_H5 = "http://118.178.174.26/m/";
    //正式环境
//    public static final String BASE_URL = "https://app.shangfangsuo.com:443/mingyuan/index.php/api/";
//    public static final String BASE_H5 = "http://app.shangfangsuo.com/m/";

    /**
     * 密码登录
     **/
    @FormUrlEncoded
    @POST("loginByPassword")
    Observable<HttpResult<LoginBean>> getToken(@FieldMap Map<String, String> map);

    @FormUrlEncoded
    @GET("cc")
    Observable<UpdateBean> update(@FieldMap Map<String, String> map);
}
