package com.xm.study.encode.presenter;

import com.xm.study.base.IPresenter;

/**
 * Created by zhangxiumei on 2017/4/25.
 */

public interface IEncodePresenter extends IPresenter {

    public String encodeAes(String strEndcode);

    public String decodeAes(String strDecode);

    public String encodeAes2(String strEndcode);

    public String decodeAes2(String strDecode);

    public String encodeDes3(String strEncode);

    public String decodeDes3(String strDecode);

    public String encodeMd5(String strEncode);

    public String decodeMd5(String strDecode);

    public String encodeRsa(String strEncode);

    public String decodeRsa(String strDecode);


}
