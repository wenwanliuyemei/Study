package com.xm.study.okhttp.model;


import java.util.ArrayList;

/**
 * Created by Administrator on 2016/5/28.
 */
public class AD {
    private ArrayList<ADetails> data=new ArrayList<>();

    public ArrayList<ADetails> getData() {
        return data;
    }

    public void setData(ArrayList<ADetails> data) {
        this.data = data;
    }

    public class ADetails{
        String banner_id,banner_name,image,banner_url,status;

        public String getBanner_id() {
            return banner_id;
        }

        public void setBanner_id(String banner_id) {
            this.banner_id = banner_id;
        }

        public String getBanner_name() {
            return banner_name;
        }

        public void setBanner_name(String banner_name) {
            this.banner_name = banner_name;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getBanner_url() {
            return banner_url;
        }

        public void setBanner_url(String banner_url) {
            this.banner_url = banner_url;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}
