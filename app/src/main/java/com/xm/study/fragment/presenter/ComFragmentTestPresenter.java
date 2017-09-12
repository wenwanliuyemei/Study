package com.xm.study.fragment.presenter;

import android.content.Context;
import android.os.Bundle;

import com.xm.study.R;
import com.xm.study.base.ComplPresenter;
import com.xm.study.base.IView;
import com.xm.study.fragment.fragment.FuncName;
import com.xm.utils.ToastUtil;
import com.xm.utils.function.Functions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: xm on 2017/9/12.
 * @describe:
 */

public class ComFragmentTestPresenter extends ComplPresenter implements IFragmentTestPresenter {

    public ComFragmentTestPresenter(Context context, IView iView) {
        super(context, iView);
    }

    @Override
    public Functions setFunctions() {
        Functions functions = new Functions().addFunction(new Functions.FunctionNoParamAndResult(FuncName.FUNCTION_NO_PARAM_NO_RESULT) {
            @Override
            public void function() {
                ToastUtil.toast(context, R.string.fragment_test_no_param_no_result);
            }
        }).addFunction(new Functions.FunctionWithResult<String>(FuncName.FUNCTION_NO_PARAM_HAS_RESULT) {
            @Override
            public String function() {
                ToastUtil.toast(context, R.string.fragment_test_no_param_has_result);
                return context.getString(R.string.fragment_test_no_param_has_result);
            }
        }).addFunction(new Functions.FunctionWithParam<Integer>(FuncName.FUNCTION_HAS_PARAM_NO_RESULT) {
            @Override
            public void function(Integer o) {
                ToastUtil.toast(context, context.getString(R.string.fragment_test_has_param_no_result) + o);
            }
        }).addFunction(new Functions.FunctionWithParamAndResult<List, Integer>(FuncName.EVENT_HAS_PARAM_HAS_RESULT) {
            @Override
            public List function(Integer data) {
                ToastUtil.toast(context, context.getString(R.string.fragment_test_has_param_has_result) + data);
                List<String> result = new ArrayList<String>();
                result.add(context.getString(R.string.fragment_test_param_1));
                result.add(context.getString(R.string.fragment_test_param_2));
                result.add(context.getString(R.string.fragment_test_param_3));
                return result;
            }
        }).addFunction(new Functions.FunctionWithParam<Functions.FunctionParams>(FuncName.FUNCTION_HAS_MORE_PARAM) {
            @Override
            public void function(Functions.FunctionParams functionParams) {
                if (functionParams != null) {
                    ToastUtil.toast(context, context.getString(R.string.fragment_test_has_param_more) + functionParams.getString()
                            + context.getString(R.string.fragment_test_has_param_more_1) + functionParams.getString()
                            + context.getString(R.string.fragment_test_has_param_more_2) + functionParams.getInt());
                }
            }
        }).addFunction(new Functions.FunctionWithParam<Bundle>(FuncName.FUNCTION_HAS_MORE_PARAM_Bundle) {

            @Override
            public void function(Bundle bundle) {
                if (bundle != null) {
                    ToastUtil.toast(context, context.getString(R.string.fragment_test_has_param_more)
                            + bundle.getString("p")
                            + context.getString(R.string.fragment_test_has_param_more_1)
                            + bundle.getString("p1")
                            + context.getString(R.string.fragment_test_has_param_more_2)
                            + bundle.getInt("p2"));
                }
            }
        });
        return functions;
    }
}
