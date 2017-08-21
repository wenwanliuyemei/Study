package com.xm.study.okhttp2.presenter;

import android.content.Context;

import com.xm.study.R;
import com.xm.study.base.IView;
import com.xm.study.base.ComplPresenter;
import com.xm.study.okhttp2.model.LoginModel;
import com.xm.study.okhttp2.model.LoginModelCompl;
import com.xm.study.okhttp2.model.bean.HttpResult;
import com.xm.study.okhttp2.model.bean.LoginBean;
import com.xm.study.okhttp2.model.bean.UpdateBean;
import com.xm.study.okhttp2.utils.network.HttpResultSubscriber;
import com.xm.study.okhttp2.view.IOkHttp2View;
import com.xm.study.utils.DialogUtils;
import com.xm.utils.dialog.DialogUtilsProgress;

import rx.Observable;

/**
 * Created by xm on 2017/6/28.
 */

public class OkHttp2ComplPresenter extends ComplPresenter implements IOkHttp2IPresenter {

    private LoginModel loginModel;

    public OkHttp2ComplPresenter(Context context, IView iView) {
        super(context, iView);
        loginModel = new LoginModelCompl();
    }

    @Override
    public void login(String account, String password) {
        DialogUtils.showProgressDialog(context, R.string.public_dialog_loading);
        Observable<HttpResult<LoginBean>> userInfo = loginModel.getUserInfo(account, password, context);
        userInfo.subscribe(new HttpResultSubscriber<LoginBean>(context) {
            @Override
            public void onSuccess(LoginBean loginBean) {
                DialogUtilsProgress.dismissProgressBar();
                if (loginBean != null) {
                    ((IOkHttp2View) iView).login("onSuccess--ok");
                }
            }


            @Override
            public void _onError(String msg) {
                DialogUtilsProgress.dismissProgressBar();
                ((IOkHttp2View) iView).login("_onError--msg=" + msg);
            }

            @Override
            public void onSuccessNoData() {
                DialogUtilsProgress.dismissProgressBar();
                ((IOkHttp2View) iView).login("onSuccessNoData");
            }
        });
    }

    @Override
    public void update() {
        DialogUtils.showProgressDialog(context, R.string.public_dialog_loading);
        Observable<UpdateBean> updateBeanObservable = loginModel.update(context);
//        updateBeanObservable.subscribe(new HttpResultSubscriber<UpdateBean>(context){
//
//            @Override
//            public void onSuccess(UpdateBean updateBean) {
//
//            }
//
//            @Override
//            public void _onError(String msg) {
//
//            }
//
//            @Override
//            public void onSuccessNoData() {
//
//            }
//        });
    }
}
