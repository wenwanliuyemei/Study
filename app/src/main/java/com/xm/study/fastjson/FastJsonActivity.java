package com.xm.study.fastjson;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.xm.study.R;
import com.xm.study.base.BaseActivity;
import com.xm.study.fastjson.presenter.FastJsonComplPresenter;
import com.xm.study.fastjson.presenter.IFastJsonPresenter;
import com.xm.study.fastjson.view.IFastJsonView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FastJsonActivity extends BaseActivity implements IFastJsonView {

    @Bind(R.id.tv_fast_json_student)
    TextView tvFastJsonStudent;
    @Bind(R.id.tv_fast_json_teacher)
    TextView tvFastJsonTeacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fast_json);
        ButterKnife.bind(this);
        iPresenter = new FastJsonComplPresenter(this, this);
    }

    @OnClick({R.id.tv_fast_json_student, R.id.tv_fast_json_teacher})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_fast_json_student:
                ((IFastJsonPresenter) iPresenter).student2Json();
                break;
            case R.id.tv_fast_json_teacher:
                ((IFastJsonPresenter) iPresenter).teacher2Json();
                break;
        }
    }

    @Override
    public void student2Json() {
        Log.e(TAG, "student2Json");
    }

    @Override
    public void teacher2Json() {
        Log.e(TAG, "teacher2Json");

    }
}
