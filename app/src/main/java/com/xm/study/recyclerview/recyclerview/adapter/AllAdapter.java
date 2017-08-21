package com.xm.study.recyclerview.recyclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.xm.study.R;

/**
 * 主界面全部应用适配器.管理应用适配器
 */
public class AllAdapter extends RecyclerView.Adapter {

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item_all, parent, false);
        RecyclerView.ViewHolder holder = new RecyclerView.ViewHolder(view) {
        };
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final int pos = holder.getLayoutPosition();
        ImageView icon = (ImageView) holder.itemView.findViewById(R.id.iv_icon);
        Button btnInstall = (Button) holder.itemView.findViewById(R.id.btn_install);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onItemClick(pos);//item的点击
            }
        });
        btnInstall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mInstallListener.onBtnInstallClick(pos);//item内的按钮
            }
        });
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    private OnItemClickListener mListener;

    public void setOnItemClickListener(OnItemClickListener li) {
        mListener = li;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    private OnBtnInstallClickListener mInstallListener;

    public void OnBtnInstallClickListener(OnBtnInstallClickListener li) {
        mInstallListener = li;
    }

    public interface OnBtnInstallClickListener {
        void onBtnInstallClick(int position);
    }
}
