package com.xm.utils.okhttp2;

import com.xm.utils.okhttp.https.HttpsUtils;

import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2016/9/21.
 */
public class HttpServiceFactory {
    private final static long DEFAULT_TIMEOUT = 10;
    //    private String baseUrl = HttpService.BASE_URL;
    private OkHttpClient.Builder httpClientBuilder;
    private Retrofit mRetrofit;
    private static HttpServiceFactory helper;

    //单例 保证对象唯一
    public static HttpServiceFactory getInstance() {
        if (helper == null) {
            synchronized (HttpServiceFactory.class) {
                if (helper == null) {
                    helper = new HttpServiceFactory();
                }
            }
        }
        return helper;
    }

    /**
     * create a service
     *
     * @param serviceClass
     * @param baseUrl
     * @param <S>
     * @return
     */
    public <S> S createService(Class<S> serviceClass, String baseUrl) {
        //添加OkHttpClient对象,.client(getOkHttpClient())
        //如果要Retrofit直接将json转换为为Dao对象。那么我们就要通过addConverterFactory来配置 ，
        // 需要compile'com.squareup.retrofit2:converter-gson:2.0.2'
        //需要Retrofit支持RxJava，添加.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        if (mRetrofit == null) {
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(getOkHttpClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
        }
        return mRetrofit.create(serviceClass);
    }


    private OkHttpClient getOkHttpClient() {
        //定制OkHttp
        if (httpClientBuilder == null) {
            httpClientBuilder = new OkHttpClient.Builder();
            //设置超时时间
            httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
            httpClientBuilder.writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
            httpClientBuilder.readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
            //拦截器，添加公共参数
            // httpClientBuilder.addInterceptor(new CommonInterceptor());
            //https
            httpClientBuilder.sslSocketFactory(HttpsUtils.getSslSocketFactory(null, null, null));
            httpClientBuilder.hostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
            //设置缓存
//        File httpCacheDirectory = com.my.mingyuan.utils.FileUtils.getDiskCacheDir(context, "HttpCache");
//        httpClientBuilder.cache(new Cache(httpCacheDirectory, 10 * 1024 * 1024));
        }
        return httpClientBuilder.build();
    }
}
