package com.xm.study.okhttp2.utils.network;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;

import com.xm.study.okhttp2.model.Data;
import com.xm.utils.LogUtils;
import com.xm.utils.PackageUtils;
import com.xm.utils.encrypt.AESCrypt;
import com.xm.utils.encrypt.MD5Util;
import com.xm.utils.encrypt.RSAUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Administrator on 2016/9/26.
 */
public class HttpParameUtils {



    public static Map<String, String> POST(Map<String, String> map, Context context) {
        if (map == null) {
            map = new HashMap<>();
        }
        map.put("device", PackageUtils.getPhone(context));
        map.put("udid", PackageUtils.getUUID(context));
        int l = (int) (System.currentTimeMillis() / 1000);
        map.put("timestamp", l + "");
        map.put("version", PackageUtils.getAppVersionCode(context) + "");
        map.put("sign", MD5Util.string2MD5(getUrlParamsByMap(sortMapByKey(map), false)));
        JSONObject object = new JSONObject();
        for (String key1 : map.keySet()) {
            try {
                object.put(key1, map.get(key1));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        String waitEncrypt = object.toString();
        map.clear();
        if (TextUtils.isEmpty(Data.TOKEN)) {
            map.put("json", waitEncrypt);
            LogUtils.e(waitEncrypt);
        } else {
            try {
                AESCrypt aesCrypt = new AESCrypt(Data.TOKEN);
                waitEncrypt = aesCrypt.encrypt(object.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
            map.put("aesjson", waitEncrypt);
            try {
                map.put("rsatoken", new String(Base64.encode(RSAUtils.encryptByPublicKey(Data.TOKEN.getBytes()), Base64.DEFAULT)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return map;
    }


    public static Map<String, String> postNoAes(Map<String, String> map, Context context) {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("device", PackageUtils.getPhone(context));
        map.put("udid", PackageUtils.getUUID(context));
        int l = (int) (System.currentTimeMillis() / 1000);
        map.put("timestamp", l + "");
        map.put("version", PackageUtils.getAppVersionCode(context) + "");
        map.put("sign", MD5Util.string2MD5(getUrlParamsByMap(sortMapByKey(map), false)));
        JSONObject object = new JSONObject();
        for (String key1 : map.keySet()) {
            try {
                object.put(key1, map.get(key1));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        String waitEncrypt = object.toString();
        map.clear();
        map.put("json", waitEncrypt);
        return map;
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
     * 比较器类
     */
    public static class MapKeyComparator implements Comparator<String> {
        public int compare(String str1, String str2) {
            return str1.compareTo(str2);
        }
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
        StringBuilder sb = new StringBuilder();
        List<String> keys = new ArrayList<>(map.keySet());
        if (isSort) {
            Collections.sort(keys);
        }
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            if (map.get(key) == null) {
                sb.append(key).append("=");
            } else {
                sb.append(key).append("=").append(map.get(key));
            }
            sb.append("&");
        }
        String s = sb.toString();
        sb = null;
        if (s.endsWith("&")) {
            s = s.substring(0, s.lastIndexOf("&"));
        }
        return s;
    }

}
