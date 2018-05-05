package com.xm.study.implicitstart;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.xm.study.R;
import com.xm.study.base.BaseActivity;

public class ImplicitStartActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_start);
    }

    public void one(View view) {
//        one();
//        four();
//        five();
//        six();
        eight();
//        ten();
    }

    public void two(View view) {
//        two();

//        three();
//        seven();
        nine();
    }


    /**
     * 1、Intent必须设置action。当Intent只设置action时，
     * 有2个Activity的intent-filter有此action，Android弹框提示。
     */
    private void one() {
        Intent intent = new Intent();
        intent.setAction("action.xm.a");
        startActivity(intent);
    }

    /**
     * 2、Intent必须设置action。有2个Activity的intent-filter的
     * action、category相同，Android弹框提示。
     */
    private void two() {
        Intent intent = new Intent();
        intent.setAction("action.xm.a");
        intent.addCategory("category.xm.a");
        startActivity(intent);
    }

    /**
     * 3、Intent必须设置action。Intent可以同时设置2个Action。
     */
    private void three() {
        Intent intent = new Intent();
        intent.setAction("action.xm.a");
        intent.setAction("action.xm.one.a");
        startActivity(intent);
    }

    /**
     * 4、Intent必须设置action。
     * Intent中的每一个action必须与intent-filter匹配。运行停止。
     * No Activity found to handle Intent { act=action.xm.rr }
     */
    private void four() {
        Intent intent = new Intent();
        intent.setAction("action.xm.a");
        intent.setAction("action.xm.one.a");
        intent.setAction("action.xm.rr");
        startActivity(intent);
    }

    /**
     * 5、Intent必须设置action。
     * Intent中的每一个action必须与intent-filter匹配。运行停止。
     * No Activity found to handle Intent
     * { act=action.xm.rr cat=[category.xm.one.a,category.xm.a] }
     */
    private void five() {
        Intent intent = new Intent();
        intent.setAction("action.xm.a");
        intent.setAction("action.xm.one.a");
        intent.setAction("action.xm.rr");
        intent.addCategory("category.xm.a");
        intent.addCategory("category.xm.one.a");
        startActivity(intent);
    }

    /**
     * 6、Intent中可以没有category；
     * 若有，每一个category必须与intent-filter匹配。
     */
    private void six() {
        Intent intent = new Intent();
        intent.setAction("action.xm.a");
        intent.addCategory("category.xm.a");
        intent.addCategory("category.xm.one.a");
        startActivity(intent);
    }

    /**
     * 7、Intent中可以没有category；
     * 若有，每一个category必须与intent-filter匹配。
     * 运行停止。
     * No Activity found to handle Intent { act=action.xm.a
     * cat=[category.xm.one.a,category.xm.a,category.xm.one.rr] }
     */
    private void seven() {
        Intent intent = new Intent();
        intent.setAction("action.xm.a");
        intent.addCategory("category.xm.a");
        intent.addCategory("category.xm.one.a");
        intent.addCategory("category.xm.one.rr");
        startActivity(intent);
    }

    /**
     * 8、Intent只匹配action，不匹配data，失败。
     * intent-filter的data包含Intent的data。
     */
    private void eight() {
        Intent intent = new Intent();
        intent.setAction("action.xm.one.aa");
        intent.setData(Uri.parse("http://www.baidu.com"));
        startActivity(intent);
    }

    /**
     * 9、Intent只匹配action，不匹配data，失败。
     * intent-filter的data包含Intent的data。
     * * 运行停止。
     * No Activity found to handle Intent { act=action.xm.one.aa }
     */
    private void nine() {
        Intent intent = new Intent();
        intent.setAction("action.xm.one.aa");
        startActivity(intent);
    }

    /**
     * 10、Intent只匹配action，不匹配data，失败。
     * intent-filter的data包含Intent的data。
     * * 运行停止。
     * 最后一个setData()有效。
     * No Activity found to handle Intent
     * { act=action.xm.one.aa dat=http://www.baidu.cn }
     */
    private void ten() {
        Intent intent = new Intent();
        intent.setAction("action.xm.one.aa");
        intent.setData(Uri.parse("http://www.baidu.com"));
        intent.setData(Uri.parse("http://www.baidu.cn"));
        startActivity(intent);
    }
}
