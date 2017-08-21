package com.xm.study.genericity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.xm.study.base.BaseActivity;
import com.xm.study.R;
import com.xm.study.genericity.model.TwoTuple;
import com.xm.study.genericity.presenter.GenericityPresenterCompl;
import com.xm.study.genericity.presenter.IGenericityPresenter;
import com.xm.study.genericity.view.IGenericityView;

import java.util.Collection;
import java.util.Set;

public class GenericityActivity extends BaseActivity implements IGenericityView {

    private final String TAG = this.getClass().getSimpleName();
    private IGenericityPresenter mIGenericityPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.genericity_activity_genericity);

        //find view、set listener
        int[] ids = new int[]{R.id.tv_get_animal, R.id.tv_get_two_tuple_string_int
                , R.id.tv_get_linked_stack, R.id.tv_get_random_list
                , R.id.tv_get_coffee, R.id.tv_get_fibonacci
                , R.id.tv_get_fibonacci_int, R.id.tv_method
                , R.id.tv_method_new, R.id.tv_method_varargs
                , R.id.tv_method_generator, R.id.tv_method_generator_base
                , R.id.tv_method_tuple, R.id.tv_method_enum
                , R.id.tv_method_enum_2, R.id.tv_method_inner_class
                , R.id.tv_method_complex_model
        };
        TextView[] views = new TextView[ids.length];
        initViewAndSetListener(views, ids);
        //init
        mIGenericityPresenter = new GenericityPresenterCompl(this, this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_get_animal:
                mIGenericityPresenter.getAnimal();
                break;
            case R.id.tv_get_two_tuple_string_int:
                mIGenericityPresenter.getTwoTuple("name0", 0);
                break;
            case R.id.tv_get_linked_stack:
                mIGenericityPresenter.getLinkedStackCompl();
                break;
            case R.id.tv_get_random_list:
                mIGenericityPresenter.getRandomList();
                break;
            case R.id.tv_get_coffee:
                mIGenericityPresenter.getCoffee();
                break;
            case R.id.tv_get_fibonacci:
                mIGenericityPresenter.getFibonacci();
                break;
            case R.id.tv_get_fibonacci_int:
                mIGenericityPresenter.getIterableFibonacci();
                break;
            case R.id.tv_method:
                mIGenericityPresenter.getGenericMethod();
                break;
            case R.id.tv_method_new:
                mIGenericityPresenter.getGenericMethodNew();
                break;
            case R.id.tv_method_varargs:
                mIGenericityPresenter.getGenericVarargs();
                break;
            case R.id.tv_method_generator:
                mIGenericityPresenter.getMethodGenerators();
                break;
            case R.id.tv_method_generator_base:
                mIGenericityPresenter.getBaseGenerator();
                break;
            case R.id.tv_method_tuple:
                mIGenericityPresenter.getTupleNew();
                break;
            case R.id.tv_method_enum:
                mIGenericityPresenter.getWatercolors();
                break;
            case R.id.tv_method_enum_2:
                mIGenericityPresenter.getSetNew(Set.class, Collection.class);
                break;
            case R.id.tv_method_inner_class:
                mIGenericityPresenter.innerClass();
                break;
            case R.id.tv_method_complex_model:
                mIGenericityPresenter.complexmodel();
                break;
        }
    }

    @Override
    public void getAnimalDone() {
        Log.e(TAG, "getAnimalDone");
    }

    @Override
    public void getTwoTupleDone(Object o) {
        Log.e(TAG, "getTwoTupleDone--o=" + o);
        TwoTuple twoTuple = (TwoTuple) o;
        Log.e(TAG, "getTwoTupleDone--twoTuple=" + twoTuple);
        Log.e(TAG, "getTwoTupleDone--twoTuple.toString=" + twoTuple.toString());
        //getTwoTupleDone--o=(name0,0)
        //getTwoTupleDone--twoTuple=(name0,0)
        //getTwoTupleDone--twoTuple.toString=(name0,0)
    }

    @Override
    public void getLinkedStackComplDone() {
        Log.e(TAG, "getLinkedStackComplDone");
    }

    @Override
    public void getRandomListDone() {
        Log.e(TAG, "getRandomListDone");
    }

    @Override
    public void getCoffeeDone() {
        Log.e(TAG, "getCoffeeDone");
    }

    @Override
    public void getFibonacciDone() {
        Log.e(TAG, "getFibonacciDone");
    }

    @Override
    public void getIterableFibonacciDone() {
        Log.e(TAG, "getIterableFibonacciDone");
    }

    @Override
    public void getGenericMethodDone() {
        Log.e(TAG, "getGenericMethodDone");
    }

    @Override
    public void getGenericMethodNewDone() {
        Log.e(TAG, "getGenericMethodNewDone");
    }

    @Override
    public void getGenericVarargsDone() {
        Log.e(TAG, "getGenericVarargsDone");
    }

    @Override
    public void getMethodGeneratorsDone() {
        Log.e(TAG, "getMethodGeneratorsDone");
    }

    @Override
    public void getBaseGeneratorDone() {
        Log.e(TAG, "getBaseGeneratorDone");
    }

    @Override
    public void getTupleNewDone() {
        Log.e(TAG, "getTupleNewDone");
    }

    @Override
    public void getWatercolorsDone() {
        Log.e(TAG, "getWatercolorsDone");
    }

    @Override
    public void getSetNewDone() {
        Log.e(TAG, "getSetNewDone");
    }

    @Override
    public void innerClassDone() {
        Log.e(TAG, "innerClassDone");
    }

    @Override
    public void complexmodelDone() {
        Log.e(TAG, "complexmodelDone");
    }
}
