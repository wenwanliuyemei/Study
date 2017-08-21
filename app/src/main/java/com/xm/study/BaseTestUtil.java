package com.xm.study;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.HashMap;

/**
 * 作者：xm on 2017/1/11 17:30
 * 描述：
 */
public class BaseTestUtil {

    /**
     * 聊天中监测链接是否安全的接口
     */
    public static void WDSafeStringRequest(final String urlName, final String url, HashMap<String, String> params) {
        final long endTime[] = new long[1];
        final long startTime = System.currentTimeMillis();
        //网络请求
//        WDSafeStringRequest mRequest = new WDSafeStringRequest(
//                url,
//                Request.Method.POST, params, false,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        endTime[0] = System.currentTimeMillis();
//                        Log.d("shijianerror", (endTime[0] - startTime) + "...");
//                        writeTxtToFile(urlName + "..." + startTime + "..." + endTime[0] + "..." + (endTime[0] - startTime) + "...失败..." + url);
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError arg0) {
//                endTime[0] = System.currentTimeMillis();
//                Log.d("shijianerror", (endTime[0] - startTime) + "...");
//                writeTxtToFile(urlName + "..." + startTime + "..." + endTime[0] + "..." + (endTime[0] - startTime) + "...失败..." + url);
//            }
//        });
//        BaseApplication.getInstance().addToRequestQueue(mRequest, TAG);
        //保证在所有子线程运行完后，主线程再结束
        while (true) {
            if (endTime[0] > 0) {
                break;
            }
        }
    }
    // 将返回的数据写入到文本中
    public static void writeTxtToFile(String result) {
        //换行操作
        String strContent = result + "\r\n";
        try {
            File file = new File("log.txt");
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            //移动到文件末尾处
            raf.seek(file.length());
            raf.write(strContent.getBytes());
            raf.close();
        } catch (Exception e) {
        }
    }
}
