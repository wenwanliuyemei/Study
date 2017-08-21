package com.xm.study.datastructure.model.string;

import java.util.Formatter;

/**
 * 作者：xm on 2017/2/9 11:08
 * 描述：
 */
public class FormatOutputFormatter {
    private String name;
    private Formatter formatter;

    public FormatOutputFormatter(String name, java.util.Formatter formatter){
        this.name=name;
        this.formatter=formatter;
    }

    public void move(int x,int y){
        formatter.format("%s The FormatOutputFormatter is at(%d,%d)\n",name,x,y);
    }

    public void move(int x,float y){
        formatter.format("%s The FormatOutputFormatter is at(%d,%f)\n",name,x,y);
    }
}
