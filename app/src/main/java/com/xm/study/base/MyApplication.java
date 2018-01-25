package com.xm.study.base;

import android.app.ActivityManager;
import android.app.Application;
import android.content.pm.PackageManager;
//import android.support.multidex.MultiDexApplication;
import android.os.Environment;
import android.util.Log;

import com.alipay.euler.andfix.patch.PatchManager;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMOptions;
import com.tencent.bugly.crashreport.CrashReport;
import com.xm.study.pattern.observer.exit.model.ApplicationObservable;
import com.xm.study.utils.FileUtils;
import com.xm.utils.LogUtils;

import java.util.Iterator;
import java.util.List;

import cn.jiajixin.nuwa.Nuwa;
import com.xm.study.fix.nuwa.utils.*;

import net.sqlcipher.database.SQLiteDatabase;

/**
 * 作者：xm on 2017/1/3 11:25
 * 描述：
 */
public class MyApplication extends Application {

    private final String TAG = this.getClass().getSimpleName();//反射
    private final boolean isDebug = true;
    private static ApplicationObservable mApplicationObservable;
    public static PatchManager mPatchManager;
    public static final String PASSWORD_DB = "gdhjydb";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "onCreate");
        SQLiteDatabase.loadLibs(this);
//        initEaseChat();
        initFresco();
        initCrashReport();
        initPatchManager();
        initNuwa();
    }

    public ApplicationObservable getmApplicationObservable() {
        if (mApplicationObservable == null) {
            mApplicationObservable = new ApplicationObservable();
        }
        return mApplicationObservable;
    }

    private void initEaseChat() {

        EMOptions options = new EMOptions();

        // 默认添加好友时，是不需要验证的，改成需要验证
        options.setAcceptInvitationAlways(false);


        int pid = android.os.Process.myPid();
        String processAppName = getAppName(pid);
        // 如果APP启用了远程的service，此application:onCreate会被调用2次
        // 为了防止环信SDK被初始化2次，加此判断会保证SDK被初始化1次
        // 默认的APP会在以包名为默认的process name下运行，如果查到的process name不是APP的process name就立即返回
        if (processAppName == null || !processAppName.equalsIgnoreCase(this.getPackageName())) {
            Log.e(TAG, "enter the service process!");
            // 则此application::onCreate 是被service 调用的，直接返回
            return;
        }


        //初始化
        EMClient.getInstance().init(this, options);
        //在做打包混淆时，关闭debug模式，避免消耗不必要的资源
        EMClient.getInstance().setDebugMode(true);
    }


    private String getAppName(int pID) {
        String processName = null;
        ActivityManager am = (ActivityManager) this.getSystemService(ACTIVITY_SERVICE);
        List l = am.getRunningAppProcesses();
        Iterator i = l.iterator();
        PackageManager pm = this.getPackageManager();
        while (i.hasNext()) {
            ActivityManager.RunningAppProcessInfo info = (ActivityManager.RunningAppProcessInfo) (i.next());
            try {
                if (info.pid == pID) {
                    processName = info.processName;
                    return processName;
                }
            } catch (Exception e) {
                Log.d(TAG, "getAppName--Error--:" + e.toString());
            }
        }
        return processName;
    }

    private void initFresco() {
        Fresco.initialize(this);
    }

    private void initCrashReport() {
        CrashReport.initCrashReport(getApplicationContext(), "7fe69ffb75", isDebug);

//        Context context = getApplicationContext();
//        // 获取当前包名
//        String packageName = context.getPackageName();
//        // 获取当前进程名
//        String processName = getProcessName(android.os.Process.myPid());
//        // 设置是否为上报进程
//        CrashReport.UserStrategy strategy = new CrashReport.UserStrategy(context);
//        strategy.setUploadProcess(processName == null || processName.equals(packageName));
//        // 初始化Bugly
//        CrashReport.initCrashReport(context, "7fe69ffb75", isDebug, strategy);
//        // 如果通过“AndroidManifest.xml”来配置APP信息，初始化方法如下
//        // CrashReport.initCrashReport(context, strategy);
    }

    private void initPatchManager() {
        mPatchManager = new PatchManager(this);
//        mPatchManager.init("1.0");
        try {
            mPatchManager.init(getPackageManager().getPackageInfo(getPackageName(), 0).versionName);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        mPatchManager.loadPatch();
        LogUtils.e("initPatchManager");
    }

    private void initNuwa() {
        Nuwa.init(this);
//        if (NuwaFileUtils.initPatch()) {
//            Nuwa.loadPatch(this, FileUtils.getPatch().getAbsolutePath() + Consts.PATH_PATCH_NUWA);
//        }
        Nuwa.loadPatch(this, Environment.getExternalStorageDirectory().getAbsolutePath().concat("/patch.jar"));
    }
}
