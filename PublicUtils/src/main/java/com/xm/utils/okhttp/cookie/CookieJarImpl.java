package com.xm.utils.okhttp.cookie;


import com.xm.utils.okhttp.cookie.store.CookieStore;
import com.xm.utils.okhttp.cookie.store.HasCookieStore;
import com.xm.utils.okhttp.cookie.store.MemoryCookieStore;
import com.xm.utils.okhttp.utils.Exceptions;

import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;


public class CookieJarImpl implements CookieJar, HasCookieStore {
    private CookieStore cookieStore;

    public CookieJarImpl(MemoryCookieStore cookieStore) {
        if (cookieStore == null) Exceptions.illegalArgument("cookieStore can not be null.");
        this.cookieStore = cookieStore;
    }

    @Override
    public synchronized void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
        cookieStore.add(url, cookies);
    }

    @Override
    public synchronized List<Cookie> loadForRequest(HttpUrl url) {
        return cookieStore.get(url);
    }

    @Override
    public CookieStore getCookieStore() {
        return cookieStore;
    }
}
