package com.xm.study.datastructure;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.xm.study.base.BaseActivity;
import com.xm.study.R;
import com.xm.study.datastructure.model.list.MyLinkedList;
import com.xm.study.datastructure.presenter.DataStructurePresenterCompl;
import com.xm.study.datastructure.presenter.IDataStructurePresenter;
import com.xm.study.datastructure.view.IDataStructureView;

public class DataStructureActivity extends BaseActivity implements IDataStructureView {

    private final String TAG = this.getClass().getSimpleName();
    private IDataStructurePresenter mIDataStructurePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_structure);

        //find view、set listener
        int[] ids = new int[]{R.id.tv_string_upcase, R.id.tv_string_for_circle_compare
                , R.id.tv_string_memory_address, R.id.tv_string_format_output
                , R.id.tv_string_format_output_formatter, R.id.tv_string_format_output_specifier
                , R.id.tv_string_format_output_hex, R.id.tv_data_structure_set_student
                , R.id.tv_data_structure_map_tree_table
// , R.id.tv_method_varargs
//                , R.id.tv_method_generator, R.id.tv_method_generator_base
//                , R.id.tv_method_tuple, R.id.tv_method_enum
//                , R.id.tv_method_enum_2, R.id.tv_method_inner_class
//                , R.id.tv_method_complex_model
        };
        TextView[] textViews = new TextView[ids.length];
        initViewAndSetListener(textViews, ids);

        //init
        mIDataStructurePresenter = new DataStructurePresenterCompl(this, this);
        MyLinkedList.a();
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tv_string_upcase:
                mIDataStructurePresenter.upCase();
                break;
            case R.id.tv_string_for_circle_compare:
                mIDataStructurePresenter.forCircleCompare(new String[]{"aaa", "bbb", "ccc", "ddd", "eee",
                        "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee",
                        "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee",
                        "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee",
                        "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee",
                        "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee",
                        "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee",
                        "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee",
                        "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee",
                        "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee",
                        "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee",
                        "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee",
                        "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee",
                        "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee",
                        "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee",
                        "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee",
                        "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee",
                        "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee",
                        "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee",
                        "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee",
                        "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee",
                        "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee",
                        "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee",
                        "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee",
                        "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee",
                        "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee",
                        "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee",
                        "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee",
                        "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee",
                        "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee",
                        "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee",
                        "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee",
                        "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee",
                        "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee",
                        "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee",
                        "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee",
                        "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee",
                        "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee",
                        "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee",
                        "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee",
                        "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee",
                        "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee",
                        "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee", "aaa", "bbb", "ccc", "ddd", "eee"});
                break;
            case R.id.tv_string_memory_address:
                mIDataStructurePresenter.memoryAddress();
                break;
            case R.id.tv_string_format_output:
                mIDataStructurePresenter.formatOutput();
                break;
            case R.id.tv_string_format_output_formatter:
                mIDataStructurePresenter.formatOutputFormatter();
                break;
            case R.id.tv_string_format_output_specifier:
                mIDataStructurePresenter.formatSpeciifier();
                break;
            case R.id.tv_string_format_output_hex:
                mIDataStructurePresenter.hexOutput(("CAFEBA0000003100520A00052207" +
                        "CAFEBA0000003100520A00052207CAFEBA0000003100520A00052207CAFEBA0000003100520A00052207").getBytes());
                break;
            case R.id.tv_data_structure_set_student:
                mIDataStructurePresenter.treeSetStudent();
                break;
            case R.id.tv_data_structure_map_tree_table:
                mIDataStructurePresenter.treeTable();
                mIDataStructurePresenter.reverseLinkedList1(new int[]{0, 1, 2, 3});
                break;
//            case R.id.tv_method_varargs:
//                mIGenericityPresenter.getGenericVarargs();
//                break;
//            case R.id.tv_method_generator:
//                mIGenericityPresenter.getMethodGenerators();
//                break;
//            case R.id.tv_method_generator_base:
//                mIGenericityPresenter.getBaseGenerator();
//                break;
//            case R.id.tv_method_tuple:
//                mIGenericityPresenter.getTupleNew();
//                break;
//            case R.id.tv_method_enum:
//                mIGenericityPresenter.getWatercolors();
//                break;
//            case R.id.tv_method_enum_2:
//                mIGenericityPresenter.getSetNew(Set.class, Collection.class);
//                break;
//            case R.id.tv_method_inner_class:
//                mIGenericityPresenter.innerClass();
//                break;
//            case R.id.tv_method_complex_model:
//                mIGenericityPresenter.complexmodel();
//                break;
        }
    }

    @Override
    public void upCaseDone() {
        Log.e(TAG, "upCaseDone");
    }

    @Override
    public void forCircleCompareDone() {
        Log.e(TAG, "forCircleCompareDone");
    }

    @Override
    public void memoryAddressDone() {
        Log.e(TAG, "memoryAddressDone");
    }

    @Override
    public void formatOutputDone() {
        Log.e(TAG, "formatOutputDone");
    }

    @Override
    public void formatOutputFormatterDone() {
        Log.e(TAG, "formatOutputFormatterDone");
    }

    @Override
    public void formatSpeciifierDone() {
        Log.e(TAG, "formatSpeciifierDone");
    }

    @Override
    public void hexOutputDone() {
        Log.e(TAG, "hexOutputDone");
    }

    @Override
    public void treeSetStudentDone() {
        Log.e(TAG, "treeSetStudentDone");
    }

    @Override
    public void treeTableDone() {
        Log.e(TAG, "treeTableDone");
    }

    @Override
    public void reverseLinkedList1Done() {
        Log.e(TAG, "reverseLinkedList1Done");
    }
}
