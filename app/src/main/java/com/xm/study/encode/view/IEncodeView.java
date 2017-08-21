package com.xm.study.encode.view;

import com.xm.study.base.IView;

/**
 * Created by zhangxiumei on 2017/4/25.
 */

public interface IEncodeView extends IView {

    public void encodeAes(String strEndcode);

    public void decodeAes(String strDecode);

    public void encodeAes2(String strEndcode);

    public void decodeAes2(String strDecode);

    public void encodeDes3(String strEncode);

    public void decodeDes3(String strDecode);

    public void encodeMd5(String strEncode);

    public void decodeMd5(String strDecode);

    public void encodeRsa(String strEncode);

    public void decodeRsa(String strDecode);
}
