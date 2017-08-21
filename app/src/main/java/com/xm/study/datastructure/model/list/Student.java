package com.xm.study.datastructure.model.list;

import android.support.annotation.NonNull;

import java.util.Comparator;

/**
 * @author: xm on 2017/7/24.
 * @describe: 利用set，不是按自然顺序排序，按学生的英语分数排序。
 */
public class Student implements Comparable{

    private String mName;
    private int mCodeEnglish;

    public Student(String name,int codeEnglish){
        mName=name;
        mCodeEnglish=codeEnglish;
    }

    @Override
    public int compareTo(@NonNull Object another) {
        Student student=(Student)another;
        int result=this.mCodeEnglish-student.mCodeEnglish;
//        if(result==0){//允许成绩相同的学生
//           result= 1;
//        }
        return result;
    }
}
