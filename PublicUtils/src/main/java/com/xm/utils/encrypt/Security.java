package com.xm.utils.encrypt;

import android.util.Base64;


/**
 * Created by Administrator on 2016/5/19.
 */
public class Security {
    /**
     * 解密
     * 先base64解码  在进行ＲＳＡ公钥解密
     *
     * @param data
     * @return
     */

    public static String decryptByBase64andRSA(String data) {
        String s1 = null;
        byte[] b;//对数据进行base64解码
        try {
            b = Base64.decode(data, Base64.DEFAULT);
            byte[] bytes = RSAUtils.decryptByPublicKey(b);
            s1 = new String(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s1;

    }

    /**
     * 加密
     * 先进行RSA加密  在base64编码
     *
     * @param data
     * @return
     */

    public static String encryptByBase64andRSA(String data) {
        String s = null;
        try {
            s = new String(Base64.encode(RSAUtils.encryptByPublicKey(data.getBytes()), Base64.DEFAULT));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

}
