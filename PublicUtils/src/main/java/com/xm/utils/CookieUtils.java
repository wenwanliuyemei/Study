package com.xm.utils;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;

import org.apache.http.client.HttpClient;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.AbstractHttpClient;

import java.util.List;

/**
 * 类名称: CookieUtils
 * 类描述: 获取Cookie工具类
 * 创建人: 陈书东
 * 创建时间: 2016/7/26 14:59
 * 修改人: 无
 * 修改时间: 无
 * 修改备注: 无
 */
public class CookieUtils {

    private static String shareCookie;

    public static String getShareCookie() {
        return shareCookie;
    }

    public static void setShareCookie(String shareCookie) {
        CookieUtils.shareCookie = shareCookie;
    }

//    public static void setShareCookie(HttpClient httpClient) {
//        CookieUtils.shareCookie = getCookieFromHttpClient(httpClient);
//        BaseApplication.getInstance().setLoginCookie(CookieUtils.shareCookie);
//    }

    public static String getCookieFromHttpClient(HttpClient httpClient) {
        List cookies = ((AbstractHttpClient) httpClient).getCookieStore().getCookies();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < cookies.size(); i++) {
            Cookie cookie = (Cookie) cookies.get(i);
            String cookieName = cookie.getName();
            String cookieValue = cookie.getValue();
            if (!TextUtils.isEmpty(cookieName)
                    && !TextUtils.isEmpty(cookieValue)) {
                sb.append(cookieName + "=");
                sb.append(cookieValue);
            }
        }
        String cookie = sb.toString();
        return cookie;
    }

    /**
     * 清除cookie
     */
    public static void clearCookies(Context context) {
        CookieSyncManager.createInstance(context);
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        cookieManager.removeAllCookie();
        cookieManager.removeSessionCookie();
        CookieSyncManager.getInstance().sync();
    }
}
