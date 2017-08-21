package com.xm.study.pattern.proxy.utils;

import com.xm.study.pattern.proxy.model.User;

/**
 * @author: xm on 2017/7/31.
 * @describe:
 */

public class AccessValidator {

    public static boolean validateUser(String userName, String password) {
        User user = new User("001", "001");
        if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }
}
