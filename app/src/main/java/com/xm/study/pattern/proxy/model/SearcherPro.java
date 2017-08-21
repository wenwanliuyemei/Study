package com.xm.study.pattern.proxy.model;

import com.xm.study.pattern.proxy.utils.AccessValidator;

/**
 * @author: xm on 2017/7/31.
 * @describe:
 */

public class SearcherPro implements IBaseSearcher {
    private SearcherReal searcherReal=null;
    private SearcherRecorder searcherRecorder=null;

    public SearcherPro(){
        searcherReal=new SearcherReal();
    }

    @Override
    public String doSearch(String userName, String password, String key) {
        if(AccessValidator.validateUser(userName,password)){
            StringBuffer stringBuffer=new StringBuffer();
            stringBuffer.append(searcherReal.doSearch(userName,password,key));
            return stringBuffer.toString();
        }
        return null;
    }

    private void logUserRecord(String userName,String password ) {
        SearcherRecorder searcherRecorder = new SearcherRecorder();
        searcherRecorder.setUser(new User(userName,password));
//        searcherRecorder.save(a);
    }
}
