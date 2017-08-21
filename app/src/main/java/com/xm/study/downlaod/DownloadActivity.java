package com.xm.study.downlaod;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.xm.study.base.BaseActivity;
import com.xm.study.R;
import com.xm.study.downlaod.presenter.DownloadPresenterCompl;
import com.xm.study.downlaod.presenter.IDownloadPresenter;
import com.xm.study.downlaod.utils.MessageWhat;
import com.xm.study.downlaod.view.IDownloadView;
import com.xm.utils.ToastUtil;

/**
 * http://www.cnblogs.com/hanyonglu/archive/2012/02/20/2358801.html
 */
public class DownloadActivity extends BaseActivity implements IDownloadView {

    private final String TAG = this.getClass().getSimpleName();
    private IDownloadPresenter iDownloadPresenter;
    private TextView tv_path;
    private TextView tv_result;
    private ProgressBar pb_downloadbar;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case MessageWhat.error:
                    ToastUtil.toast(DownloadActivity.this, R.string.download_error);
                    break;
                case MessageWhat.progressBarMax:
                    pb_downloadbar.setMax((Integer) msg.obj);//设置进度条的最大刻度为文件的长度
                    break;
                case MessageWhat.downloadedProgress:
                    pb_downloadbar.setProgress((Integer) msg.obj);
                    float num = (float) pb_downloadbar.getProgress() / (float) pb_downloadbar.getMax();
                    int result = (int) (num * 100);
                    tv_result.setText(result + "%");

                    if (pb_downloadbar.getProgress() == pb_downloadbar.getMax()) {
                        ToastUtil.toast(DownloadActivity.this, R.string.download_success);
                    }
                    break;

            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);

        //init view 、set listener
        int[] ids = new int[]{R.id.btn_doownload_button};
        View[] views = new View[ids.length];
        initViewAndSetListener(views, ids);

        tv_path = (TextView) initView(tv_path, R.id.tv_path);
        tv_result = (TextView) initView(tv_result, R.id.tv_result);
        pb_downloadbar = (ProgressBar) initView(pb_downloadbar, R.id.pb_downloadbar);

        //init
        iDownloadPresenter = new DownloadPresenterCompl(this, this, handler);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.btn_doownload_button:
                StringBuffer stringBufferPath = new StringBuffer(tv_path.getText().toString());
                Log.e(TAG, "path=" + stringBufferPath.toString());
                iDownloadPresenter.download(stringBufferPath.toString());
                break;
        }
    }

    @Override
    public void downloadDone() {
        Log.e(TAG, "downloadDone");
    }
}
