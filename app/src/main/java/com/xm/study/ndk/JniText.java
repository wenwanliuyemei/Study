package com.xm.study.ndk;

public class JniText {

    static {
        System.loadLibrary("jnitext");   //defaultConfig.ndk.moduleName
    }

    public native String getCLangString();
}
