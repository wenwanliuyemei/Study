package com.xm.study.pattern.proxy.model;

/**
 * @author: xm on 2017/7/31.
 * @describe:
 */

public class SearcherRecorder {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long save(long records){
        return save(user.getUserName()+"count："+records,records);
    }

    private long save(String record,long records){
       records ++;
        //TODO
        //传递记录到服务器
        return records;
    }
}

