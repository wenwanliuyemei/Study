package com.xm.study.dynamic1.presenter;

import android.content.Context;

import com.xm.study.base.ComplPresenter;
import com.xm.study.base.IView;
import com.xm.study.dynamic.Dynamic;
import com.xm.study.dynamic1.untils.FileUtils;
import com.xm.study.dynamic1.view.IDynamicView;
import com.xm.utils.ToastUtil;

import java.io.File;
import java.io.IOException;

import dalvik.system.DexClassLoader;

/**
 * @author: xm on 2017/8/23.
 * @describe:
 */

public class ComplDynamicPresenter extends ComplPresenter implements IDynamicPresenter {

    public ComplDynamicPresenter(Context context, IView iView) {
        super(context, iView);
    }

    @Override
    public void loadDexClass() {
        File cacheFile = FileUtils.getCacheDir(context);
        String internalPath = cacheFile.getAbsolutePath() + File.separator + "dynamic_dex.jar";
        File desFile = new File(internalPath);
        try {
            if (!desFile.exists()) {
                desFile.createNewFile();
                FileUtils.copyFiles(context, "dynamic_dex.jar", desFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //下面开始加载dex class
        DexClassLoader dexClassLoader = new DexClassLoader(internalPath, cacheFile.getAbsolutePath(),
                null, context.getClassLoader());
        try {
            Class libClazz = dexClassLoader.loadClass("com.xm.study.dynamic.impl.DynamicImpl");
            Dynamic dynamic = (Dynamic) libClazz.newInstance();
            if (dynamic != null)
                ToastUtil.toast(context, dynamic.sayHello());
        } catch (Exception e) {
            e.printStackTrace();
        }
        ((IDynamicView) iView).loadDexClassDone();
    }
}
