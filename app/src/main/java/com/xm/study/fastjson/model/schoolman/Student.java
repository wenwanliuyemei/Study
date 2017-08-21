package com.xm.study.fastjson.model.schoolman;

/**
 * Created by zhangxiumei on 2017/5/3.
 */

public class Student extends SchoolMan {

    private int age;

    public Student() {
    }

    public Student(int id, String name, int age) {
        super(id, name);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student[id=" + id + ",name=" + name + ",age=" + age + "]";
    }
}
