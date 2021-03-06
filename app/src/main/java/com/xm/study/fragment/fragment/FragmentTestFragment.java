package com.xm.study.fragment.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.xm.study.R;
import com.xm.study.base.BaseFragment;
import com.xm.utils.function.FunctionException;
import com.xm.utils.function.Functions;

import java.util.List;

import com.xm.study.fragment.fragment.FuncName;

public class FragmentTestFragment extends BaseFragment {

    public static FragmentTestFragment newInstance() {
        return new FragmentTestFragment();
    }

    private Button mBut1, mBut2, mBut3, mBut4;
    private TextView mResult;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_test_fragment_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBut1 = (Button) getView().findViewById(R.id.click1);
        mBut2 = (Button) getView().findViewById(R.id.click2);
        mBut3 = (Button) getView().findViewById(R.id.click3);
        mBut4 = (Button) getView().findViewById(R.id.click4);
        mResult = (TextView) getView().findViewById(R.id.result);

        mBut1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mFunctions.invokeFunc(FuncName.FUNCTION_NO_PARAM_NO_RESULT);
                } catch (FunctionException e) {
                    e.printStackTrace();
                }
            }
        });

        mBut2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = null;
                try {
                    result = mFunctions.invokeFuncWithResult(FuncName.FUNCTION_NO_PARAM_HAS_RESULT, String.class);
                } catch (FunctionException e) {
                    e.printStackTrace();
                }
                mResult.setText(result);
            }
        });
        mBut3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mFunctions.invokeFunc(FuncName.FUNCTION_HAS_PARAM_NO_RESULT, 100);
                } catch (FunctionException e) {
                    e.printStackTrace();
                }
            }
        });
        mBut4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> re = null;
                try {
                    re = mFunctions.invokeFuncWithResult(FuncName.EVENT_HAS_PARAM_HAS_RESULT, 100, List.class);
                } catch (FunctionException e) {
                    e.printStackTrace();
                }
                if (re != null) {
                    String st = "";
                    for (int i = 0; i < re.size(); i++) {
                        st += re.get(i) + " ";
                    }
                    mResult.setText(st);
                }
            }
        });

        getView().findViewById(R.id.click5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mFunctions.invokeFunc(FuncName.FUNCTION_HAS_MORE_PARAM,
                            new Functions.FunctionParams.FunctionParamsBuilder()
                                    .putString("你好")
                                    .putString("我是fragment").putInt(200).create());
                } catch (FunctionException e) {
                    e.printStackTrace();
                }
            }
        });

        getView().findViewById(R.id.click6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Bundle b = new Bundle();
                    b.putString("p", "你好activity");
                    b.putString("p1", "我是fragment");
                    b.putInt("p2", 200);
                    mFunctions.invokeFunc(FuncName.FUNCTION_HAS_MORE_PARAM_Bundle, b);
                } catch (FunctionException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
