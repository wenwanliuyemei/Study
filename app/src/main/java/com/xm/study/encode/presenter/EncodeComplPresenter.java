package com.xm.study.encode.presenter;

import android.content.Context;

import com.xm.study.base.IView;
import com.xm.study.base.ComplPresenter;
import com.xm.study.encode.model.AESUtils;
import com.xm.study.encode.model.Des3Utils;
import com.xm.study.encode.model.MD5Utils;
import com.xm.study.encode.model.RSAUtils;
import com.xm.study.encode.view.IEncodeView;

/**
 * Created by zhangxiumei on 2017/4/27.
 */

public class EncodeComplPresenter extends ComplPresenter implements IEncodePresenter {

    public EncodeComplPresenter(Context context, IView iView) {
        super(context, iView);
    }

    @Override
    public String encodeAes(String strEndcode) {
        try {
            strEndcode = AESUtils.encode(strEndcode);
            ((IEncodeView) iView).encodeAes(strEndcode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strEndcode;
    }

    @Override
    public String decodeAes(String strDecode) {
        try {
            strDecode = AESUtils.decode(strDecode);
            ((IEncodeView) iView).decodeAes(strDecode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strDecode;
    }

    @Override
    public String encodeAes2(String strEndcode) {
        try {
            strEndcode = AESUtils.AESEncode(strEndcode);
            ((IEncodeView) iView).encodeAes2(strEndcode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strEndcode;
    }

    @Override
    public String decodeAes2(String strDecode) {
        try {
            strDecode = AESUtils.AESDncode(strDecode);
            ((IEncodeView) iView).decodeAes2(strDecode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strDecode;
    }

    @Override
    public String encodeDes3(String strEncode) {
        try {
            strEncode = Des3Utils.encode(strEncode);
            ((IEncodeView) iView).encodeDes3(strEncode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strEncode;
    }

    @Override
    public String decodeDes3(String strDecode) {
        try {
            strDecode = Des3Utils.decode(strDecode);
            ((IEncodeView) iView).decodeDes3(strDecode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strDecode;
    }

    @Override
    public String encodeMd5(String strEncode) {
        try {
            strEncode = MD5Utils.encode(strEncode);
            ((IEncodeView) iView).encodeMd5(strEncode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strEncode;
    }

    @Override
    public String decodeMd5(String strDecode) {
        ((IEncodeView) iView).decodeMd5(strDecode);
        return strDecode;
    }

    @Override
    public String encodeRsa(String strEncode) {
        strEncode = RSAUtils.encode(context, strEncode);
        ((IEncodeView) iView).encodeRsa(strEncode);
        return strEncode;
    }

    @Override
    public String decodeRsa(String strDecode) {
        strDecode = RSAUtils.decode(context, strDecode);
        ((IEncodeView) iView).decodeRsa(strDecode);
        return strDecode;
    }
}
