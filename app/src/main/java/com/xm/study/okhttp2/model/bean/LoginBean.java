package com.xm.study.okhttp2.model.bean;


/**
 * Created by YanWei on 2017/4/5.
 */

public class LoginBean {
    private String token;
    private String user_name;
    private String is_audit;
    private String is_pay_password;
    private String is_bind_bank_card;
    private String photo;
    private String phone;
    private String psd;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    private String version;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPsd() {
        return psd;
    }

    public void setPsd(String psd) {
        this.psd = psd;
    }

    public String getToken() {

        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getIs_audit() {
        return is_audit;
    }

    public void setIs_audit(String is_audit) {
        this.is_audit = is_audit;
    }

    public String getIs_pay_password() {
        return is_pay_password;
    }

    public void setIs_pay_password(String is_pay_password) {
        this.is_pay_password = is_pay_password;
    }

    public String getIs_bind_bank_card() {
        return is_bind_bank_card;
    }

    public void setIs_bind_bank_card(String is_bind_bank_card) {
        this.is_bind_bank_card = is_bind_bank_card;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }


    @Override
    public String toString() {
        return "LoginBean{" +
                "token='" + token + '\'' +
                ", user_name='" + user_name + '\'' +
                ", is_audit='" + is_audit + '\'' +
                ", is_pay_password='" + is_pay_password + '\'' +
                ", is_bind_bank_card='" + is_bind_bank_card + '\'' +
                ", photo='" + photo + '\'' +
                ", phone='" + phone + '\'' +
                ", psd='" + psd + '\'' +
                '}';
    }
}
