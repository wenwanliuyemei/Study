package com.xm.study.fastjson.model.schoolman;

import java.util.List;

/**
 * Created by zhangxiumei on 2017/5/4.
 */

public class Teacher extends SchoolMan {

    private List<Student> listStudents;

    public Teacher() {
    }

    public Teacher(int id, String name) {
        super(id, name);
    }

    public List<Student> getListStudents() {
        return listStudents;
    }

    public void setListStudents(List<Student> listStudents) {
        this.listStudents = listStudents;
    }

    @Override
    public String toString() {
        return "Teacher [id=" + id + ",name=" + name + ",listStudents=" + listStudents.toString() + "]";
    }
}
