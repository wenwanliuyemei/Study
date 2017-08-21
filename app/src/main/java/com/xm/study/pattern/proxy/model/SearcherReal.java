package com.xm.study.pattern.proxy.model;

/**
 * @author: xm on 2017/7/31.
 * @describe:
 */

public class SearcherReal implements IBaseSearcher {

    public SearcherReal() {
        super();
    }

    @Override
    public String doSearch(String userName, String password, String key) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(userName);
        stringBuffer.append(password);
        stringBuffer.append(key);
//        asyncTask(stringBuffer.toString());
        return key + "：：";//演示
    }

    private void asyncTask(String params) {
        //网络请求
        //TODO
    }
}
