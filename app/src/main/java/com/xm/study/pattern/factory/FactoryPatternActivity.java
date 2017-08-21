package com.xm.study.pattern.factory;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.xm.study.base.BaseActivity;
import com.xm.study.R;
import com.xm.study.pattern.factory.presenter.FactoryPatternPresenterCompl;
import com.xm.study.pattern.factory.presenter.IFactoryPatternPresenter;
import com.xm.study.pattern.factory.view.IFactoryPatternView;

public class FactoryPatternActivity extends BaseActivity implements IFactoryPatternView {

    private final String TAG=this.getClass().getSimpleName();
    private IFactoryPatternPresenter iFactoryPatternPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factory_pattern);

        //find view、set listener
        int[] ids = new int[]{R.id.tv_standard_phone, R.id.tv_simple_phone
//                , R.id.tv_string_memory_address, R.id.tv_string_format_output
//                , R.id.tv_string_format_output_formatter, R.id.tv_string_format_output_specifier
//                , R.id.tv_string_format_output_hex
//                , R.id.tv_method
//                , R.id.tv_method_new, R.id.tv_method_varargs
//                , R.id.tv_method_generator, R.id.tv_method_generator_base
//                , R.id.tv_method_tuple, R.id.tv_method_enum
//                , R.id.tv_method_enum_2, R.id.tv_method_inner_class
//                , R.id.tv_method_complex_model
        };
        TextView[] textViews = new TextView[ids.length];
        initViewAndSetListener(textViews, ids);

        //init
        iFactoryPatternPresenter = new FactoryPatternPresenterCompl(this, this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tv_standard_phone:
                iFactoryPatternPresenter.standardPhone();
                break;
            case R.id.tv_simple_phone:
                iFactoryPatternPresenter.simplePhone();
                break;
//            case R.id.tv_get_linked_stack:
//                mIGenericityPresenter.getLinkedStackCompl();
//                break;
//            case R.id.tv_get_random_list:
//                mIGenericityPresenter.getRandomList();
//                break;
//            case R.id.tv_get_coffee:
//                mIGenericityPresenter.getCoffee();
//                break;
//            case R.id.tv_get_fibonacci:
//                mIGenericityPresenter.getFibonacci();
//                break;
//            case R.id.tv_get_fibonacci_int:
//                mIGenericityPresenter.getIterableFibonacci();
//                break;
//            case R.id.tv_method:
//                mIGenericityPresenter.getGenericMethod();
//                break;
        }
    }

    @Override
    public void standardPhoneDone() {
        Log.e(TAG,"standardPhoneDone");
    }

    @Override
    public void simplePhoneDone() {
        Log.e(TAG,"simplePhoneDone");
    }
}
