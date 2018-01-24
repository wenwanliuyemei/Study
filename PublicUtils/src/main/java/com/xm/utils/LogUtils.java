package com.xm.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Log工具，类似android.util.Log。
 * tag自动产生，格式: customTagPrefix:className.methodName(L:lineNumber),
 * customTagPrefix为空时只输出：className.methodName(L:lineNumber)。
 */
public class LogUtils {

    private static final int MAX_LOG_FILE_SIZE = 1024 * 1024;
    private static final Object mutex = new Object();
    private static SimpleDateFormat fileNameSDF = new SimpleDateFormat("yyyy_MM_dd_HH_mm");
    private static SimpleDateFormat currentMillionsSDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static final String DEFAULT_ROOT_FOLDER = "/LinkAge/Log";
    public static final String DEFAULT_LOG_FILE_PATH = "/log.txt";

    public static String customTagPrefix = "";
    private static String rootFolder = DEFAULT_ROOT_FOLDER;
    private static String logFileName = DEFAULT_LOG_FILE_PATH;

    private LogUtils() {
    }

    private static final boolean allowLogOnDisk = true;
    public static boolean allowD = true;
    public static boolean allowE = true;
    public static boolean allowI = true;
    public static boolean allowV = true;
    public static boolean allowW = true;
    public static boolean allowWtf = true;

    private static String generateTag(StackTraceElement caller) {
        String tag = "%s.%s(L:%d)";
        String callerClazzName = caller.getClassName();
        callerClazzName = callerClazzName.substring(callerClazzName.lastIndexOf(".") + 1);
        tag = String.format(tag, callerClazzName, caller.getMethodName(), caller.getLineNumber());
        tag = TextUtils.isEmpty(customTagPrefix) ? tag : customTagPrefix + ":" + tag;
        return tag;
    }

    public static CustomLogger customLogger;

    public interface CustomLogger {
        void d(String tag, String content);

        void d(String tag, String content, Throwable tr);

        void e(String tag, String content);

        void e(String tag, String content, Throwable tr);

        void i(String tag, String content);

        void i(String tag, String content, Throwable tr);

        void v(String tag, String content);

        void v(String tag, String content, Throwable tr);

        void w(String tag, String content);

        void w(String tag, String content, Throwable tr);

        void w(String tag, Throwable tr);

        void wtf(String tag, String content);

        void wtf(String tag, String content, Throwable tr);

        void wtf(String tag, Throwable tr);
    }

    public  static void d(String tag, String content, Throwable tr) {
        logFile(content, tr);

        if (!allowD) return;

        if (tag == null) {
            StackTraceElement caller = OtherUtils.getCallerStackTraceElement();
            tag = generateTag(caller);
        }

        if (customLogger != null) {
            customLogger.d(tag, content, tr);
        } else {
            Log.d(tag, content, tr);
        }
    }

    public static void d(Throwable tr) {
        d(null, null, tr);
    }

    public static void d(String content) {
        d(null, content, null);
    }

    public static void d(String content, Throwable tr) {
        d(null, content, tr);
    }

    public static void d(String tag, String content) {
        if (content == null || content == "") {
            d(null, tag, null);
        } else {
            d(tag, content, null);
        }
    }

    public static void e(String tag, String content, Throwable tr) {
        logFile(content, tr);

        if (!allowE) return;

        if (tag == null) {
            StackTraceElement caller = OtherUtils.getCallerStackTraceElement();
            tag = generateTag(caller);
        }

        if (customLogger != null) {
            customLogger.e(tag, content, tr);
        } else {
            Log.e(tag, content, tr);
        }
    }

    public static void e(Throwable tr) {
        e(null, null, tr);
    }

    public static void e(String content) {
        e(null, content, null);
    }

    public static void e(String content, Throwable tr) {
        e(null, content, tr);
    }

    public static void e(String tag, String content) {
        if (content == null || content == "") {
            e(null, tag, null);
        } else {
            e(tag, content, null);
        }
    }

    public  static void i(String tag, String content, Throwable tr) {
        logFile(content, tr);

        if (!allowI) return;

        if (tag == null) {
            StackTraceElement caller = OtherUtils.getCallerStackTraceElement();
            tag = generateTag(caller);
        }

        if (customLogger != null) {
            customLogger.i(tag, content, tr);
        } else {
            Log.i(tag, content, tr);
        }
    }

    public static void i(Throwable tr) {
        i(null, null, tr);
    }

    public static void i(String content) {
        i(null, content, null);
    }

    public static void i(String content, Throwable tr) {
        i(null, content, tr);
    }

    public static void i(String tag, String content) {
        if (content == null || content == "") {
            i(null, tag, null);
        } else {
            i(tag, content, null);
        }
    }

    public  static void v(String tag, String content, Throwable tr) {
        logFile(content, tr);

        if (!allowV) return;

        if (tag == null) {
            StackTraceElement caller = OtherUtils.getCallerStackTraceElement();
            tag = generateTag(caller);
        }

        if (customLogger != null) {
            customLogger.v(tag, content, tr);
        } else {
            Log.v(tag, content, tr);
        }
    }

    public static void v(Throwable tr) {
        v(null, null, tr);
    }

    public static void v(String content) {
        v(null, content, null);
    }

    public static void v(String content, Throwable tr) {
        v(null, content, tr);
    }

    public static void v(String tag, String content) {
        if (content == null || content == "") {
            e(null, tag, null);
        } else {
            e(tag, content, null);
        }
    }

    public  static void w(String tag, String content, Throwable tr) {
        logFile(content, tr);

        if (!allowW) return;

        if (tag == null) {
            StackTraceElement caller = OtherUtils.getCallerStackTraceElement();
            tag = generateTag(caller);
        }

        if (customLogger != null) {
            customLogger.w(tag, content, tr);
        } else {
            Log.w(tag, content, tr);
        }
    }

    public static void w(Throwable tr) {
        w(null, null, tr);
    }

    public static void w(String content) {
        w(null, content, null);
    }

    public static void w(String content, Throwable tr) {
        w(null, content, tr);
    }

    public static void w(String tag, String content) {
        if (content == null || content == "") {
            w(null, tag, null);
        } else {
            w(tag, content, null);
        }
    }

    public  static void wtf(String tag, String content, Throwable tr) {
        logFile(content, tr);

        if (!allowWtf) return;

        if (tag == null) {
            StackTraceElement caller = OtherUtils.getCallerStackTraceElement();
            tag = generateTag(caller);
        }

        if (customLogger != null) {
            customLogger.wtf(tag, content, tr);
        } else {
            Log.wtf(tag, content, tr);
        }
    }

    public static void wtf(Throwable tr) {
        wtf(null, null, tr);
    }

    public static void wtf(String content) {
        wtf(null, content, null);
    }

    public static void wtf(String content, Throwable tr) {
        wtf(null, content, tr);
    }

    public static void wtf(String tag, String content) {
        if (content == null || content == "") {
            wtf(null, tag, null);
        } else {
            wtf(tag, content, null);
        }
    }

    /**
     * 自定义LOG文件夹与临时LOG文件名 若不设置 则路径为默认 参见LogUtils.DEFAULT_ROOT_FOLDER LogUtils.DEFAULT_LOG_FILE_PATH
     * @param rootFolder
     * @param logFileName
     */
    public static void initLocalLogPath(String rootFolder, String logFileName)
    {
        if (!TextUtils.isEmpty(rootFolder)) {
            LogUtils.rootFolder = rootFolder;
        }
        if (!TextUtils.isEmpty(logFileName)) {
            LogUtils.logFileName = logFileName;
        }
    };


    public static void logFile(String content, Throwable tr)
    {
        if (allowLogOnDisk) {
            Date date = new Date();
            String dateNowStr = currentMillionsSDF.format(date);
            StringBuffer buffer = new StringBuffer(dateNowStr);
            buffer.append("    ");
            if (content != null) {
                buffer.append(content);
                buffer.append("\r\n");
            }
            if (tr != null) {
                buffer.append("Caused by: ");
                try {
                    printStackTrace(buffer, "", tr, tr.getStackTrace());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            printLogFile(buffer);
        }
    }

    private static void printLogFile(StringBuffer buffer)
    {
        if (MoblieUtils.isSdPresent()) {
            File logFile = getLogFile();
            if (logFile != null) {
                synchronized (mutex)
                {
                    try {
                        FileOutputStream fos = new FileOutputStream(logFile, true);
                        fos.write(buffer.toString().getBytes());
                        fos.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private static File getLogFile()
    {
        String rootPathString = MoblieUtils.getSdPath() + rootFolder;
        File rootFolder = new File(rootPathString);
        if (!rootFolder.exists()) {
            rootFolder.mkdirs();
        }
        File logFile = new File(rootPathString + logFileName);
        if (!logFile.exists()) {
            try {
                logFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        else {
            checkFileSize(logFile);
        }
        return logFile;
    }

    /**
     * @param indent additional indentation on each line of the stack trace.
     *     This is the empty string for all but suppressed throwables.
     * @param parentStack the parent stack trace to suppress duplicates from, or
     *     null if this stack trace has no parent.
     */
    public static void printStackTrace(Appendable err, String indent, Throwable tr, StackTraceElement[] parentStack)
            throws IOException {
        err.append(tr.toString());
        err.append("\n");

        if (parentStack != null) {
            for (int i = 0; i < parentStack.length; i++) {
                err.append(indent);
                err.append("\tat ");
                err.append(parentStack[i].toString());
                err.append("\n");
            }
        }
    }

    public static void checkFileSize(File logFile) {
        if (logFile.length() > MAX_LOG_FILE_SIZE) {
            markingCurrentLog();
            doUpload();
        }
    }

    private static String mobileInfo()
    {
        String handSetInfo=
                "手机型号:" + android.os.Build.MODEL +
                        ",SDK版本:" + android.os.Build.VERSION.SDK +
                        ",系统版本:" + android.os.Build.VERSION.RELEASE;
        return handSetInfo;
    }

    private static void markingCurrentLog()
    {
        File logFile = new File(MoblieUtils.getSdPath() + rootFolder + logFileName);
        if (logFile.exists()) {
            synchronized (mutex)
            {
                try {
                    FileOutputStream fos = new FileOutputStream(logFile, true);
                    fos.write(mobileInfo().getBytes());
                    fos.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String newPathString = MoblieUtils.getSdPath() + rootFolder + "/log" + fileNameSDF.format(new Date()) + ".txt";
                logFile.renameTo(new File(newPathString));
            }
        }
    }

    private static void doUpload() {

    }

    public static void logNull(Context context) {
        LogUtils.e(context.getResources().getString(R.string.public_hint_null));
    }
}