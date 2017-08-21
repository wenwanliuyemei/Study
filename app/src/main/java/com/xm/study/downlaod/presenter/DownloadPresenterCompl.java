package com.xm.study.downlaod.presenter;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;

import com.xm.study.R;
import com.xm.study.downlaod.model.FileDownloader;
import com.xm.study.downlaod.model.IDownloadProgressListener;
import com.xm.study.downlaod.utils.MessageWhat;
import com.xm.study.downlaod.view.IDownloadView;
import com.xm.utils.ToastUtil;

import java.io.File;

/**
 * Created by zhangxiumei on 2017/3/8.
 */

public class DownloadPresenterCompl implements IDownloadPresenter {

    private final String TAG = this.getClass().getSimpleName();
    private IDownloadView iDownloadView;
    private Context context;
    private Handler handler;

    public DownloadPresenterCompl(Context context, IDownloadView iDownloadView, Handler handler) {
        this.context = context;
        this.iDownloadView = iDownloadView;
        this.handler = handler;
    }


    @Override
    public void download(String path) {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            download2(path, Environment.getExternalStorageDirectory(), 3);
        } else {
            ToastUtil.toast(context, R.string.download_sdcard_error);
        }
    }

    private void download2(final String path, final File dir, final int num) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                FileDownloader fileDownloader = new FileDownloader(context, path, dir, num);

                final Message message1 = new Message();
                message1.what = MessageWhat.progressBarMax;
                message1.obj = fileDownloader.getFileSize();
                handler.sendMessage(message1);//设置进度条的最大刻度为文件的长度

                try {
                    fileDownloader.download(new IDownloadProgressListener() {
                        @Override
                        public void onDownloadSize(int size) {
                            //实时获知文件已经下载的数据长度
                            Message message2 = new Message();
                            message2.what = MessageWhat.downloadedProgress;
                            message2.obj = size;
                            handler.sendMessage(message2);
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                    handler.sendEmptyMessage(MessageWhat.error);
                }
            }
        }).start();
    }
}
