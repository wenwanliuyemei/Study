package com.xm.study.genericity.model.method;

import com.xm.study.genericity.model.ThreeTuple;
import com.xm.study.genericity.model.TwoTuple;
import com.xm.study.genericity.model.coffee.Coffee;

/**
 * 作者：xm on 2017/1/19 16:07
 * 描述：
 */
public class TupleNewTest {

    public static TwoTuple<String,Integer> twoTuple(){
        return TupleNew.tuple("one",1);
    }

    public static TwoTuple twoTuple2(){
        return TupleNew.tuple("two",2);
    }

    public static ThreeTuple<Coffee,String,Integer> threeTuple(){
        return TupleNew.tuple(new Coffee(),"three",3);
    }
}
