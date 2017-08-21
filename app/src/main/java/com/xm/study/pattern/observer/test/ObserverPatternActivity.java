package com.xm.study.pattern.observer.test;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.xm.study.base.BaseActivity;
import com.xm.study.R;
import com.xm.study.pattern.observer.test.presenter.IObserverPatternPresenter;
import com.xm.study.pattern.observer.test.presenter.ObserverPatternPresenterCompl;
import com.xm.study.pattern.observer.test.view.IObserverPatternView;

public class ObserverPatternActivity extends BaseActivity implements IObserverPatternView {

    private final String TAG = this.getClass().getSimpleName();
    private IObserverPatternPresenter iObserverPatternPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observer_pattern);

        //init view、set listener
        int[] ids = new int[]{R.id.tv_observer_coder
//                , R.id.tv_simple_phone
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
        iObserverPatternPresenter = new ObserverPatternPresenterCompl(this, this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tv_observer_coder:
                iObserverPatternPresenter.observerDevTechFrontier();
                break;
//            case R.id.tv_simple_phone:
//                iFactoryPatternPresenter.simplePhone();
//                break;
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
    public void observerDevTechFrontierDone() {
        Log.e(TAG,"observerDevTechFrontierDone");
    }
}
