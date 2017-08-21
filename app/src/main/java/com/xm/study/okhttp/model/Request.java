package com.xm.study.okhttp.model;

import android.content.Context;

import com.alibaba.fastjson.JSON;

import com.xm.utils.LogUtils;
import com.xm.utils.NetworkUtils;
import com.xm.utils.ObjectCache;
import com.xm.utils.ToastUtil;
import com.xm.study.R;

import com.xm.utils.encrypt.MD5Util;
import com.xm.utils.okhttp.OkHttpUtils;
import com.xm.utils.okhttp.callback.StringCallback;
import com.xm.utils.PackageUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import okhttp3.Call;


public class Request {
    private static final String TAG="Request";
    public static String data = null;
    private static Request single = null;

    private Request() {

    }

    //静态工厂方法
    public static Request getInstance() {
        if (single == null) {
            single = new Request();
        }
        return single;
    }

    /**
     * post请求
     *
     * @param urlString       URL地址  (global/Constant类中)
     * @param map             参数列表  （network/RequestParams类中）
     * @param context         上下文环境
     * @param cls             data数据所转换的实体类
     * @param isCache         是否缓存  （暂未实现）
     * @param requestListener 回调  （使用泛型 可直接得到实体类）
     */

    public static void post(final String urlString, Map<String, String> map, final Context context, final Class<?> cls, final boolean isCache, final RequestListener requestListener) {
        String s = System.currentTimeMillis() / 1000 + "";
        if (map == null) {
            map = new HashMap<>();
        }
        final String cache = getCacheString(map);
        map.put("timestamp", s);
        map.put("version", "" + PackageUtils.getAppVersionCode(context));
        LogUtils.e(TAG,"version="+ PackageUtils.getAppVersionCode(context));
        Map<String, String> stringMap = sortMapByKey(map);
        String strParams = getUrlParamsByMap(stringMap, false);
        map.put("sign", MD5Util.string2MD5(strParams));
        JSONObject object = new JSONObject();
        for (String key1 : map.keySet()) {
            try {
                object.put(key1, map.get(key1));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        String waitEncrypt = object.toString();
        OkHttpUtils.post().url(urlString).addParams("json", waitEncrypt).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e) {

//                ToastUtil.toast(context,R.string.public_toast_error);
                if (requestListener != null)
                    requestListener.error(RequestState.NETWOEK_NO, context.getResources().getString(R.string.public_network_no));
                if (!NetworkUtils.isNetworkAvailable(context)) {
                    ToastUtil.toast(context, R.string.public_network_no);
                    String response = null;
                    if (isCache) {
                        try {
                            response = ObjectCache.getCache(context, MD5Util.string2MD5(URLEncoder.encode(urlString + cache, "utf-8")));
                        } catch (UnsupportedEncodingException e1) {
                            e1.printStackTrace();
                        }
                        parse(response);
                    }
                }
            }

            @Override
            public Object onResponse(String response) {
                if (isCache) {
                    try {
                        ObjectCache.setCache(context, MD5Util.string2MD5(URLEncoder.encode(urlString + cache, "utf-8")), response);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
                parse(response);
                return null;
            }

            private void parse(String response) {
                LogUtils.e("response", response);
                try {
                    JSONObject o1 = new JSONObject(response);
                    String status = String.valueOf(o1.get("status"));
                    if (status.equals("1")) {
                        if (response.contains("data")) {
                            data = String.valueOf(o1.get("data"));
                            if (data.startsWith("[")) {
                                String s = "{\"data\":" + data + "}";
                                if (requestListener != null)
                                    requestListener.success(parseJSON(s, cls));
                            } else if (data.startsWith("{")) {
                                if (requestListener != null)
                                    requestListener.success(parseJSON(data, cls));
                            } else {
                                if (requestListener != null)
                                    requestListener.successNoData(data.substring(1, data.length() - 1));
                            }
                        } else {
                            if (requestListener != null)
                                requestListener.successNoData("");
                        }
                    } else {
                        if (requestListener != null)
                            requestListener.error(status, String.valueOf(o1.get("msg")));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    if (requestListener != null)
                        requestListener.error("", String.valueOf(e.getMessage()));
                }
            }
        });
    }

    private static String getCacheString(Map<String, String> map) {
        JSONObject object = new JSONObject();
        for (String key1 : map.keySet()) {
            try {
                object.put(key1, map.get(key1));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return object.toString();
    }

    /**
     * 使用 Map按key进行排序
     *
     * @param map
     * @return
     */
    public static Map<String, String> sortMapByKey(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        Map<String, String> sortMap = new TreeMap<>(new MapKeyComparator());
        sortMap.putAll(map);
        return sortMap;
    }

    /**
     * 将map 转为 string
     *
     * @param map
     * @return
     */
    private static String getUrlParamsByMap(Map<String, String> map,
                                            boolean isSort) {
        if (map == null) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        List<String> keys = new ArrayList<>(map.keySet());
        if (isSort) {
            Collections.sort(keys);
        }
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            if (map.get(key) == null) {
                sb.append(key + "=" + "");
            } else {
                sb.append(key + "=" + map.get(key).toString());
            }
            sb.append("&");
        }
        String s = sb.toString();
        if (s.endsWith("&")) {
            s = s.substring(0, s.lastIndexOf("&"));
        }
        return s;
    }

    public static Object parseJSON(String data, Class<?> obj)
            throws JSONException {
        if (data != null && data.length() > 0 && !data.equals("null")) {
            if (data.startsWith("["))
                return JSON.parseArray(data, obj);
            else if (data.startsWith("{")) {
                return JSON.parseObject(data, obj);
            } else
                return null;
        }
        throw new JSONException("format error");
    }

    public interface RequestListener<T> {
        void success(T data);

        void successNoData(String data);

        void error(String status, String msg);
    }

    /**
     * 比较器类
     */
    public static class MapKeyComparator implements Comparator<String> {
        public int compare(String str1, String str2) {
            return str1.compareTo(str2);
        }
    }
}
