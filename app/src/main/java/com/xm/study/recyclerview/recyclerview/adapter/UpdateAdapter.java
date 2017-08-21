package com.xm.study.recyclerview.recyclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.xm.study.R;
import com.xm.study.recyclerview.recyclerview.model.AppInfo;

import java.util.List;

/**
 * 主界面升级应用适配器.
 */
public class UpdateAdapter extends RecyclerView.Adapter {

    private List<AppInfo> mAppInfos;

    public UpdateAdapter(List<AppInfo> infos) {
        mAppInfos = infos;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item_update, parent, false);
        RecyclerView.ViewHolder holder = new RecyclerView.ViewHolder(view) {
        };
        return holder;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        final int pos = holder.getLayoutPosition();
        final CheckBox cbSel = (CheckBox) holder.itemView.findViewById(R.id.cb_sel);
        cbSel.setChecked(mAppInfos.get(position).getChecked());
        ImageView icon = (ImageView) holder.itemView.findViewById(R.id.iv_icon);
        TextView tvName = (TextView) holder.itemView.findViewById(R.id.tv_name);
        Button btnInstall = (Button) holder.itemView.findViewById(R.id.btn_install);
        tvName.setText(mAppInfos.get(position).getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onItemClick(pos);
            }
        });
        cbSel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mAppInfos.get(position).getChecked()) {
                    mAppInfos.get(position).setChecked(false);
                } else {
                    mAppInfos.get(position).setChecked(true);
                }
                mSelListener.onSelClick(pos);
            }
        });
        btnInstall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mInstallListener.onBtnInstallClick(pos);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mAppInfos.size();
    }

    private OnItemClickListener mListener;

    public void setOnItemClickListener(OnItemClickListener li) {
        mListener = li;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    private OnIvSelClickListener mSelListener;

    public void OnIvSelClickListener(OnIvSelClickListener li) {
        mSelListener = li;
    }

    public interface OnIvSelClickListener {
        void onSelClick(int position);
    }

    private OnBtnInstallClickListener mInstallListener;

    public void OnBtnInstallClickListener(OnBtnInstallClickListener li) {
        mInstallListener = li;
    }

    public interface OnBtnInstallClickListener {
        void onBtnInstallClick(int position);
    }
}
