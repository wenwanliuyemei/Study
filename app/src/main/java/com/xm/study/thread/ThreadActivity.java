package com.xm.study.thread;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.xm.study.base.BaseActivity;
import com.xm.study.R;
import com.xm.study.thread.presenter.IThreadPresenter;
import com.xm.study.thread.presenter.ThreadPresenterCompl;
import com.xm.study.thread.view.IThreadView;

public class ThreadActivity extends BaseActivity implements IThreadView {

    private final String TAG = this.getClass().getSimpleName();
    private IThreadPresenter iThreadPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);

        //init view、set listener
        int[] ids = new int[]{R.id.tv_thread_extends_ticket
                , R.id.tv_thread_implements_ticket, R.id.tv_thread_implements_ticket_2
                , R.id.tv_thread_extends_implements_test, R.id.tv_thread_callable_test
                , R.id.tv_thread_stop, R.id.tv_thread_volatile
                , R.id.tv_thread_pool
// ,R.id.tv_proxy,R.id.tv_int_list_put_string,R.id.tv_update_array,
//                R.id.tv_update_array_size,R.id.tv_fruit_factory
        };
        TextView[] textViews = new TextView[ids.length];
        initViewAndSetListener(textViews, ids);

        //init
        iThreadPresenter = new ThreadPresenterCompl(this, this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tv_thread_extends_ticket:
                iThreadPresenter.threadExtendsTicket();
                break;
            case R.id.tv_thread_implements_ticket:
                iThreadPresenter.threadImplementsTicket();
                break;
            case R.id.tv_thread_implements_ticket_2:
                iThreadPresenter.threadImplementsTicket2();
                break;
            case R.id.tv_thread_extends_implements_test:
                iThreadPresenter.threadExtendsImplementsTest();
                break;
            case R.id.tv_thread_callable_test:
                iThreadPresenter.threadCallableTest();
                break;
            case R.id.tv_thread_stop:
                iThreadPresenter.threadStop();
                break;
            case R.id.tv_thread_volatile:
                iThreadPresenter.threadVolatile();
                break;
            case R.id.tv_thread_pool:
                iThreadPresenter.threadPoolTest();
                break;
//            case R.id.tv_proxy:
//                mITestFelectPresneter.proxy();
//                break;
//            case R.id.tv_int_list_put_string:
//                mITestFelectPresneter.intListPutString();
//                break;
//            case R.id.tv_update_array:
//                mITestFelectPresneter.updateArray();
//                break;
//            case R.id.tv_update_array_size:
//                mITestFelectPresneter.upaateArraySize();
//                break;
//            case R.id.tv_fruit_factory:
//                mITestFelectPresneter.fruitFactory();
//                break;
        }
    }

    @Override
    public void threadExtendsTicketDone() {
        Log.e(TAG, "threadExtendsTicketDone");
    }

    @Override
    public void threadImplementsTicketDone() {
        Log.e(TAG, "threadImplementsTicketDone");
    }

    @Override
    public void threadImplementsTicketDone2() {
        Log.e(TAG, "threadImplementsTicketDone2");
    }

    @Override
    public void threadExtendsImplementsTestDone() {
        Log.e(TAG, "threadExtendsImplementsTestDone");
    }

    @Override
    public void threadCallableTestDone() {
        Log.e(TAG, "threadCallableTestDone");
    }

    @Override
    public void threadStopDone() {
        Log.e(TAG, "threadStopDone");
    }

    @Override
    public void threadVolatileDone() {
        Log.e(TAG, "threadVolatileDone");
    }

    @Override
    public void threadPoolTestDone() {
        Log.e(TAG, "threadPoolTestDone");
    }
}
