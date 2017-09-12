package com.xm.study.fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.widget.Toast;

import com.xm.study.R;
import com.xm.study.base.BaseActivity;
import com.xm.study.base.BaseFragment;
import com.xm.study.fragment.fragment.FragmentTestFragment;
import com.xm.study.fragment.fragment.FuncName;
import com.xm.study.fragment.presenter.ComFragmentTestPresenter;
import com.xm.study.fragment.view.IFragmentTestView;
import com.xm.utils.LogUtils;
import com.xm.utils.function.Functions;

import java.util.ArrayList;
import java.util.List;

public class FragmentTestActivity extends BaseActivity implements IFragmentTestView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_test);
        iPresenter = new ComFragmentTestPresenter(this, this);
    }

    @Override
    public void setFunctionsForFragment(int fragmentId) {
        super.setFunctionsForFragment(fragmentId);
        switch (fragmentId) {
            case R.id.fragment_main:
//                FragmentManager fm = getSupportFragmentManager();
//                BaseFragment fragment = (BaseFragment) fm.findFragmentById(fragmentId);
//                fragment.setFunctions(((ComFragmentTestPresenter) iPresenter).setFunctions());
                setFunctions(fragmentId);
                break;
        }
    }

    @Override
    public void setFunctionsDone() {
        LogUtils.e("setFunctionsDone");
    }

    private void setFunctions(int fragmentId){
        FragmentManager fm = getSupportFragmentManager();
        BaseFragment fragment = (BaseFragment) fm.findFragmentById(fragmentId);
        fragment.setFunctions(new Functions().addFunction(new Functions.FunctionNoParamAndResult(FuncName.FUNCTION_NO_PARAM_NO_RESULT) {
            @Override
            public void function() {
                Toast.makeText(FragmentTestActivity.this, "成功调用无参无返回值方法", Toast.LENGTH_LONG).show();
            }
        }).addFunction(new Functions.FunctionWithResult<String>(FuncName.FUNCTION_NO_PARAM_HAS_RESULT) {
            @Override
            public String function() {
                Toast.makeText(FragmentTestActivity.this, "成功调用无参有返回值方法", Toast.LENGTH_LONG).show();
                return "恭喜你，调我成功！";
            }
        }).addFunction(new Functions.FunctionWithParam<Integer>(FuncName.FUNCTION_HAS_PARAM_NO_RESULT) {
            @Override
            public void function(Integer o) {
                Toast.makeText(FragmentTestActivity.this, "成功调用有参无返回值方法 参数值=" + o, Toast.LENGTH_LONG).show();
            }
        }).addFunction(new Functions.FunctionWithParamAndResult<List, Integer>(FuncName.EVENT_HAS_PARAM_HAS_RESULT) {

            @Override
            public List function(Integer data) {
                Toast.makeText(FragmentTestActivity.this, "成功调用有参有返回值方法 参数值=" + data, Toast.LENGTH_LONG).show();
                List<String> result = new ArrayList<String>();
                result.add("1");
                result.add("2");
                result.add("3");
                return result;
            }
        }).addFunction(new Functions.FunctionWithParam<Functions.FunctionParams>(FuncName.FUNCTION_HAS_MORE_PARAM) {

            @Override
            public void function(Functions.FunctionParams functionParams) {
                if (functionParams != null) {

                    Toast.makeText(FragmentTestActivity.this, "成功调用多个参数的方法 参数值=" + functionParams.getString() + " 参数1=" + functionParams.getString() + " 参数2=" + functionParams.getInt(), Toast.LENGTH_LONG).show();
                }
            }
        }).addFunction(new Functions.FunctionWithParam<Bundle>(FuncName.FUNCTION_HAS_MORE_PARAM_Bundle) {

            @Override
            public void function(Bundle bundle) {
                if (bundle != null) {
                    Toast.makeText(FragmentTestActivity.this, "成功调用多个参数的方法 参数值=" + bundle.getString("p") + " 参数1=" + bundle.getString("p1") + " 参数2=" + bundle.getInt("p2"), Toast.LENGTH_LONG).show();

                }
            }
        }));
    }
}
