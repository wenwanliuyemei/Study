package com.xm.study.picasso.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.xm.study.R;

import java.util.ArrayList;

public class ImagelistAdapter extends BaseAdapter {
    private Context mcontext;
    ArrayList<String> list = new ArrayList<>();

    public ImagelistAdapter(Context context, ArrayList<String> getlist) {
        this.mcontext = context;
        this.list = getlist;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (view == null) {
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(mcontext).inflate(R.layout.item_picasso, null);
            viewHolder.iv_show = (ImageView) view.findViewById(R.id.iv_show);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        //最简单的加载方式，load里面为图片的url（当然也可以是本地资源啊什么的），into进image控件里面去。
//        Picasso.with(mcontext).load(list.get(i)).into(viewHolder.iv_show);
//        //将图片切成长宽都是100 加载到控件上，适合确定控件长宽
//        Picasso.with(mcontext).load(list.get(i)).resize(100, 100).centerCrop().into(viewHolder.iv_show);
//        //添加空白和占位图片。加载图片中有一个占位图片，加载失败错误显示另一张图片
//        Picasso.with(mcontext).load(list.get(i)).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(viewHolder.iv_show);
        //汇总常用的方法,直接拿这个用就行了
        Picasso.with(mcontext).load(list.get(i)).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).
                resize(100, 100).centerCrop().into(viewHolder.iv_show);
        return view;
    }

    class ViewHolder {
        ImageView iv_show;
    }
}
