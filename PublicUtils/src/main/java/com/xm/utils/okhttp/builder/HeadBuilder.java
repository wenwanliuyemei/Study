package com.xm.utils.okhttp.builder;


import com.xm.utils.okhttp.OkHttpUtils;
import com.xm.utils.okhttp.request.OtherRequest;
import com.xm.utils.okhttp.request.RequestCall;

public class HeadBuilder extends GetBuilder {
    @Override
    public RequestCall build() {
        return new OtherRequest(null, null, OkHttpUtils.METHOD.HEAD, url, tag, params, headers).build();
    }
}
