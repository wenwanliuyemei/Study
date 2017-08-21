package com.xm.utils.dialog;

//import com.xm.publicutils.R;


/**
 * Created by Administrator on 2016/5/12.
 */
public class DialogUtilsLayout {
   /* private static DialogUtilsLayout single = null;
    public Dialog dlg3 = null;
    private Dialog dlg22, dlg2, dlg4, dlg5, dlg31 = null;
    private boolean isGoOn = true;
    private TextView getcode_text;
    private Thread thread = null;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what > 0) {
                if (getcode_text != null) {
                    getcode_text.setEnabled(false);
                    getcode_text.setBackgroundResource(R.drawable.code_bg);
                    getcode_text.setText(msg.what + "s后重新获取");
                }

            }
            if (msg.what <= 0) {
                if (getcode_text != null) {
                    getcode_text.setText("获取验证码");
                    getcode_text.setEnabled(true);
                    getcode_text.setBackgroundResource(R.drawable.bg_edittext);
                }

            }
        }
    };
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            int i = 60;
            while (isGoOn) {
                i--;
                if (i >= 0) {
                    handler.sendEmptyMessage(i);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    };

    private DialogUtilsLayout() {

    }

    //静态工厂方法
    public static DialogUtilsLayout getInstance() {
        if (single == null) {
            single = new DialogUtilsLayout();
        }
        return single;
    }


    *//**
     * 提示框
     *
     * @param context         上下文环境
     * @param type            类型 1、提示框无按键  2、有确认和取消按钮  3、只有确认按钮
     * @param title           提示框标题
     * @param content         提示框内容
     * @param listenerForSure 确认按钮点击事件
     *//*
    public void showHint(final Context context, int type, String title, String content, final View.OnClickListener listenerForSure) {

        if (dlg3 == null) {
            LayoutInflater localinflater = (LayoutInflater) context.getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);
            View layout = localinflater.inflate(R.layout.dialog_hint, null);
            dlg3 = new Dialog(context, R.style.theme_dialog);
            TextView hint_title = (TextView) layout.findViewById(R.id.hint_title);
            TextView hint_content = (TextView) layout.findViewById(R.id.hint_content);
            final TextView hint_content2 = (TextView) layout.findViewById(R.id.hint_content2);
            TextView hint_cancle = (TextView) layout.findViewById(R.id.hint_cancle);
            TextView hint_sure = (TextView) layout.findViewById(R.id.hint_sure);
            TextView hint_single_sure = (TextView) layout.findViewById(R.id.hint_single_sure);
            LinearLayout hint_double = (LinearLayout) layout.findViewById(R.id.hint_double);
            RelativeLayout buzaitanchu = (RelativeLayout) layout.findViewById(R.id.buzaitanchu);
            final CheckBox check = (CheckBox) layout.findViewById(R.id.check);
            View hint_line = layout.findViewById(R.id.hint_line);
            if (title.equals("投资提示")) {
                buzaitanchu.setVisibility(View.VISIBLE);
            } else {
                buzaitanchu.setVisibility(View.GONE);
            }
            dlg3.setCancelable(true);
            if (context != null && !((Activity) context).isFinishing())
                dlg3.show();
            dlg3.setContentView(layout);
            hint_title.setText(title);

            if (type == 1) {

                hint_content2.setVisibility(View.GONE);
                if (content.toLowerCase().contains("failed to connect to"))
                    content = context.getString(R.string.no_network);
                hint_content.setText(content);
                hint_line.setVisibility(View.GONE);
                hint_double.setVisibility(View.GONE);
                hint_single_sure.setVisibility(View.GONE);
                hint_content.setBackgroundResource(R.drawable.hint_bg_low);
            } else if (type == 2) {
                if (content.toLowerCase().contains("failed to connect to"))
                    content = context.getString(R.string.no_network);
                hint_content2.setText(content);
                hint_content.setVisibility(View.GONE);
                hint_content2.setBackgroundResource(R.drawable.base_wuyuajiao_bg);
                hint_double.setBackgroundResource(R.drawable.hint_bg_low);
                hint_content.setBackgroundColor(Color.WHITE);
                hint_single_sure.setVisibility(View.GONE);
            } else if (type == 3) {
                if (content.toLowerCase().contains("failed to connect to"))
                    content = context.getString(R.string.no_network);
                hint_content2.setText(content);
                hint_content.setVisibility(View.GONE);
                hint_content2.setBackgroundResource(R.drawable.base_wuyuajiao_bg);
                hint_single_sure.setBackgroundResource(R.drawable.hint_bg_low);
                hint_content.setBackgroundColor(Color.WHITE);
                hint_double.setVisibility(View.GONE);
            }
            hint_cancle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    killDld3(context);

                }
            });
            final String finalContent = content;
            hint_sure.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listenerForSure != null) {
                        listenerForSure.onClick(v);
                    }
                    if (!TextUtils.isEmpty(finalContent))
                        if (finalContent.contains("请重新登录"))
                            IntentUtils.startActvity(context, LoginActivity.class);
                    killDld3(context);
                    if (check.isChecked()) {
                        SharedPrefrenceUtil.putAgin(context, "ss");
                    }
                }
            });
            hint_single_sure.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listenerForSure != null) {
                        listenerForSure.onClick(v);
                    }
                    if (!TextUtils.isEmpty(finalContent))
                        if (finalContent.contains("请重新登录"))
                            IntentUtils.startActvity(context, LoginActivity.class);
                    killDld3(context);
                    if (check.isChecked()) {
                        SharedPrefrenceUtil.putAgin(context, "ss");
                    }
                }
            });
            dlg3.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                    killDld3(context);
                    if (!TextUtils.isEmpty(finalContent))
                        if (finalContent.contains("请重新登录"))
                            IntentUtils.startActvity(context, LoginActivity.class);
                }
            });
            Window w = dlg3.getWindow();
            WindowManager.LayoutParams lp = w.getAttributes();
            lp.width = (int) (PackageUtils.getScreenDispaly(context)[0] * 0.8);
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
            if (context != null && !((Activity) context).isFinishing())
                w.setAttributes(lp);
            dlg3.setCanceledOnTouchOutside(true);
        } else {
            killDld3(context);
        }
    }

    public void showHint2(final Context context) {

        if (dlg22 == null) {
            LayoutInflater localinflater = (LayoutInflater) context.getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);
            View layout = localinflater.inflate(R.layout.dialog_main, null);
            dlg22 = new Dialog(context, R.style.theme_dialog);
            ImageView close = (ImageView) layout.findViewById(R.id.close);
            ImageView dialog = (ImageView) layout.findViewById(R.id.dialog);
            close.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    killDld(context);
                }
            });
            dialog.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    killDld(context);
                    IntentUtils.startActvityWithFlag(context, SigninActivity.class, 38);
                }
            });
            dlg22.setCancelable(true);
            if (context != null && !((Activity) context).isFinishing())
                dlg22.show();
            dlg22.setContentView(layout);
            Window w = dlg22.getWindow();
            WindowManager.LayoutParams lp = w.getAttributes();
            lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
            if (context != null && !((Activity) context).isFinishing())
                w.setAttributes(lp);
        } else {
            killDld(context);
        }
    }

    private void killDld(Context context) {
        if (context != null) {
            dlg22.dismiss();
            dlg22 = null;
        }
    }

    public void showHint(final Context context, int type, String content, final View.OnClickListener listenerForSure, boolean isDismiss) {

        if (dlg31 == null) {
            LayoutInflater localinflater = (LayoutInflater) context.getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);
            View layout = localinflater.inflate(R.layout.hint, null);
            dlg31 = new Dialog(context, R.style.theme_dialog);
            TextView hint_title = (TextView) layout.findViewById(R.id.hint_title);
            TextView hint_content = (TextView) layout.findViewById(R.id.hint_content);
            TextView hint_content2 = (TextView) layout.findViewById(R.id.hint_content2);
            TextView hint_cancle = (TextView) layout.findViewById(R.id.hint_cancle);
            TextView hint_sure = (TextView) layout.findViewById(R.id.hint_sure);
            TextView hint_single_sure = (TextView) layout.findViewById(R.id.hint_single_sure);
            LinearLayout hint_double = (LinearLayout) layout.findViewById(R.id.hint_double);
            View hint_line = layout.findViewById(R.id.hint_line);
            dlg31.setCancelable(true);
            if (context != null && !((Activity) context).isFinishing())
                dlg31.show();
            dlg31.setContentView(layout);
            hint_title.setText("温馨提示");

            if (type == 1) {
                hint_content2.setVisibility(View.GONE);
                if (content.toLowerCase().contains("failed to connect to"))
                    content = context.getString(R.string.no_network);
                hint_content.setText(content);
                hint_line.setVisibility(View.GONE);
                hint_double.setVisibility(View.GONE);
                hint_single_sure.setVisibility(View.GONE);
                hint_content.setBackgroundResource(R.drawable.hint_bg_low);
            } else if (type == 2) {
                if (content.toLowerCase().contains("failed to connect to"))
                    content = context.getString(R.string.no_network);
                hint_content2.setText(content);
                hint_content.setVisibility(View.GONE);
                hint_content2.setBackgroundResource(R.drawable.base_wuyuajiao_bg);
                hint_double.setBackgroundResource(R.drawable.hint_bg_low);
                hint_content.setBackgroundColor(Color.WHITE);
                hint_single_sure.setVisibility(View.GONE);
            } else if (type == 3) {
                if (content.toLowerCase().contains("failed to connect to"))
                    content = context.getString(R.string.no_network);
                hint_content2.setText(content);
                hint_content.setVisibility(View.GONE);
                hint_content2.setBackgroundResource(R.drawable.base_wuyuajiao_bg);
                hint_single_sure.setBackgroundResource(R.drawable.hint_bg_low);
                hint_content.setBackgroundColor(Color.WHITE);
                hint_double.setVisibility(View.GONE);
            }
            final String finalContent = content;
            hint_cancle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    killDld31(context);
                }
            });
            hint_sure.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listenerForSure != null) {
                        listenerForSure.onClick(v);
                    }
                    if (!TextUtils.isEmpty(finalContent))
                        if (finalContent.contains("请重新登录"))
                            IntentUtils.startActvity(context, LoginActivity.class);
                    killDld31(context);
                }
            });
            hint_single_sure.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listenerForSure != null) {
                        listenerForSure.onClick(v);
                    }
                    if (!TextUtils.isEmpty(finalContent))
                        if (finalContent.contains("请重新登录"))
                            IntentUtils.startActvity(context, LoginActivity.class);
                    killDld31(context);
                }
            });
            dlg31.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                    if (!TextUtils.isEmpty(finalContent))
                        if (finalContent.contains("请重新登录"))
                            IntentUtils.startActvity(context, LoginActivity.class);
                    killDld31(context);
                }
            });
            Window w = dlg31.getWindow();
            WindowManager.LayoutParams lp = w.getAttributes();
            lp.width = (int) (PackageUtils.getScreenDispaly(context)[0] * 0.8);
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
            if (context != null && !((Activity) context).isFinishing())
                w.setAttributes(lp);
            dlg31.setCanceledOnTouchOutside(isDismiss);
        } else {
            killDld31(context);
        }
    }

    public void showHint3(final Context context, int type, String content, final View.OnClickListener listenerForSure, boolean isDismiss,final View.OnClickListener listenerForSure1) {

        if (dlg31 == null) {
            LayoutInflater localinflater = (LayoutInflater) context.getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);
            View layout = localinflater.inflate(R.layout.hint, null);
            dlg31 = new Dialog(context, R.style.theme_dialog);
            TextView hint_title = (TextView) layout.findViewById(R.id.hint_title);
            TextView hint_content = (TextView) layout.findViewById(R.id.hint_content);
            TextView hint_content2 = (TextView) layout.findViewById(R.id.hint_content2);
            TextView hint_cancle = (TextView) layout.findViewById(R.id.hint_cancle);
            TextView hint_sure = (TextView) layout.findViewById(R.id.hint_sure);
            TextView hint_single_sure = (TextView) layout.findViewById(R.id.hint_single_sure);
            LinearLayout hint_double = (LinearLayout) layout.findViewById(R.id.hint_double);
            View hint_line = layout.findViewById(R.id.hint_line);
            dlg31.setCancelable(true);
            if (context != null && !((Activity) context).isFinishing())
                dlg31.show();
            dlg31.setContentView(layout);
            hint_title.setText("温馨提示");

            if (type == 1) {
                hint_content2.setVisibility(View.GONE);
                if (content.toLowerCase().contains("failed to connect to"))
                    content = context.getString(R.string.no_network);
                hint_content.setText(content);
                hint_line.setVisibility(View.GONE);
                hint_double.setVisibility(View.GONE);
                hint_single_sure.setVisibility(View.GONE);
                hint_content.setBackgroundResource(R.drawable.hint_bg_low);
            } else if (type == 2) {
                if (content.toLowerCase().contains("failed to connect to"))
                    content = context.getString(R.string.no_network);
                hint_content2.setText(content);
                hint_content.setVisibility(View.GONE);
                hint_content2.setBackgroundResource(R.drawable.base_wuyuajiao_bg);
                hint_double.setBackgroundResource(R.drawable.hint_bg_low);
                hint_content.setBackgroundColor(Color.WHITE);
                hint_single_sure.setVisibility(View.GONE);
            } else if (type == 3) {
                if (content.toLowerCase().contains("failed to connect to"))
                    content = context.getString(R.string.no_network);
                hint_content2.setText(content);
                hint_content.setVisibility(View.GONE);
                hint_content2.setBackgroundResource(R.drawable.base_wuyuajiao_bg);
                hint_single_sure.setBackgroundResource(R.drawable.hint_bg_low);
                hint_content.setBackgroundColor(Color.WHITE);
                hint_double.setVisibility(View.GONE);
            }
            hint_cancle.setText("不再提示");
            final String finalContent = content;
            hint_cancle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listenerForSure1 != null) {
                        listenerForSure1.onClick(v);
                    }
                    killDld31(context);
                }
            });
            hint_sure.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listenerForSure != null) {
                        listenerForSure.onClick(v);
                    }
                    if (!TextUtils.isEmpty(finalContent))
                        if (finalContent.contains("请重新登录"))
                            IntentUtils.startActvity(context, LoginActivity.class);
                    killDld31(context);
                }
            });
            hint_single_sure.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listenerForSure != null) {
                        listenerForSure.onClick(v);
                    }
                    if (!TextUtils.isEmpty(finalContent))
                        if (finalContent.contains("请重新登录"))
                            IntentUtils.startActvity(context, LoginActivity.class);
                    killDld31(context);
                }
            });
            dlg31.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                    if (!TextUtils.isEmpty(finalContent))
                        if (finalContent.contains("请重新登录"))
                            IntentUtils.startActvity(context, LoginActivity.class);
                    killDld31(context);
                }
            });
            Window w = dlg31.getWindow();
            WindowManager.LayoutParams lp = w.getAttributes();
            lp.width = (int) (PackageUtils.getScreenDispaly(context)[0] * 0.8);
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
            if (context != null && !((Activity) context).isFinishing())
                w.setAttributes(lp);
            dlg31.setCanceledOnTouchOutside(isDismiss);
        } else {
            killDld31(context);
        }
    }

    public void showHint(final Context context, int type, String content, final View.OnClickListener listenerForSure, boolean isDismiss, final DialogInterface.OnDismissListener onDismissListener) {

        if (dlg31 == null) {
            LayoutInflater localinflater = (LayoutInflater) context.getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);
            View layout = localinflater.inflate(R.layout.dialog_hint, null);
            dlg31 = new Dialog(context, R.style.theme_dialog);
            TextView hint_title = (TextView) layout.findViewById(R.id.hint_title);
            TextView hint_content = (TextView) layout.findViewById(R.id.hint_content);
            TextView hint_content2 = (TextView) layout.findViewById(R.id.hint_content2);
            TextView hint_cancle = (TextView) layout.findViewById(R.id.hint_cancle);
            TextView hint_sure = (TextView) layout.findViewById(R.id.hint_sure);
            TextView hint_single_sure = (TextView) layout.findViewById(R.id.hint_single_sure);
            LinearLayout hint_double = (LinearLayout) layout.findViewById(R.id.hint_double);
            View hint_line = layout.findViewById(R.id.hint_line);
            dlg31.setCancelable(true);
            if (context != null && !((Activity) context).isFinishing())
                dlg31.show();
            dlg31.setContentView(layout);
            hint_title.setText("温馨提示");

            if (type == 1) {
                hint_content2.setVisibility(View.GONE);
                if (content.toLowerCase().contains("failed to connect to"))
                    content = context.getString(R.string.no_network);
                hint_content.setText(content);
                hint_line.setVisibility(View.GONE);
                hint_double.setVisibility(View.GONE);
                hint_single_sure.setVisibility(View.GONE);
                hint_content.setBackgroundResource(R.drawable.hint_bg_low);
            } else if (type == 2) {
                if (content.toLowerCase().contains("failed to connect to"))
                    content = context.getString(R.string.no_network);
                hint_content2.setText(content);
                hint_content.setVisibility(View.GONE);
                hint_content2.setBackgroundResource(R.drawable.base_wuyuajiao_bg);
                hint_double.setBackgroundResource(R.drawable.hint_bg_low);
                hint_content.setBackgroundColor(Color.WHITE);
                hint_single_sure.setVisibility(View.GONE);
            } else if (type == 3) {
                if (content.toLowerCase().contains("failed to connect to"))
                    content = context.getString(R.string.no_network);
                hint_content2.setText(content);
                hint_content.setVisibility(View.GONE);
                hint_content2.setBackgroundResource(R.drawable.base_wuyuajiao_bg);
                hint_single_sure.setBackgroundResource(R.drawable.hint_bg_low);
                hint_content.setBackgroundColor(Color.WHITE);
                hint_double.setVisibility(View.GONE);
            }
            final String finalContent = content;
            hint_cancle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    killDld31(context);
                }
            });
            hint_sure.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listenerForSure != null) {
                        listenerForSure.onClick(v);
                    }
                    if (!TextUtils.isEmpty(finalContent))
                        if (finalContent.contains("请重新登录"))
                            IntentUtils.startActvity(context, LoginActivity.class);
                    killDld31(context);
                }
            });
            hint_single_sure.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listenerForSure != null) {
                        listenerForSure.onClick(v);
                    }
                    if (!TextUtils.isEmpty(finalContent))
                        if (finalContent.contains("请重新登录"))
                            IntentUtils.startActvity(context, LoginActivity.class);
                    killDld31(context);
                }
            });
            dlg31.setOnDismissListener(onDismissListener);
            Window w = dlg31.getWindow();
            WindowManager.LayoutParams lp = w.getAttributes();
            lp.width = (int) (PackageUtils.getScreenDispaly(context)[0] * 0.8);
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
            if (context != null && !((Activity) context).isFinishing())
                w.setAttributes(lp);
            dlg31.setCanceledOnTouchOutside(isDismiss);
        } else {
            killDld31(context);
        }
    }

    public void killDld3(Context context) {
        if (dlg3 != null) {
            dlg3.dismiss();
            dlg3 = null;
        }
    }

    public void killDld31(Context context) {
        if (dlg31 != null) {
            dlg31.dismiss();
            dlg31 = null;
        }
    }

    public void showPhoto(Context context, final View.OnClickListener fromGallery, final View.OnClickListener fromCamera) {

        if (dlg4 == null) {
            LayoutInflater localinflater = (LayoutInflater) context.getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);
            View layout = localinflater.inflate(R.layout.photo, null);
            TextView photo_cancle = (TextView) layout.findViewById(R.id.photo_cancle);
            TextView photo_zhaopian = (TextView) layout.findViewById(R.id.photo_zhaopian);
            TextView photo_getphoto = (TextView) layout.findViewById(R.id.photo_getphoto);
            photo_cancle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    killDld4();
                }
            });
            photo_zhaopian.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    killDld4();
                    if (fromGallery != null) {
                        fromGallery.onClick(v);
                    }
                }
            });
            photo_getphoto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //拍照
                    killDld4();
                    if (fromCamera != null) {
                        fromCamera.onClick(v);
                    }
                }
            });
            dlg4 = new Dialog(context, R.style.theme_dialog);
            dlg4.setCancelable(true);
            if (context != null && !((Activity) context).isFinishing())
                dlg4.show();
            dlg4.setContentView(layout);
            dlg4.setCanceledOnTouchOutside(true);
            dlg4.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                    killDld4();
                }
            });
            Window w = dlg4.getWindow();
            WindowManager.LayoutParams lp = w.getAttributes();
            lp.width = WindowManager.LayoutParams.MATCH_PARENT;
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
            if (context != null && !((Activity) context).isFinishing())
                w.setAttributes(lp);

        } else {
            killDld4();
        }
    }

    public void killDld4() {
        if (dlg4 != null) {
            dlg4.dismiss();
            dlg4 = null;
        }
    }

    AnimationDrawable animationDrawable;

    public void showLoading(Context context) {
        if (dlg5 == null) {
            LayoutInflater localinflater = (LayoutInflater) context.getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);
            View layout = localinflater.inflate(R.layout.dialog_loading, null);

            dlg5 = new Dialog(context, R.style.theme_dialog1);
            dlg5.setCancelable(true);
            if (context != null && !((Activity) context).isFinishing())
                dlg5.show();
            dlg5.setContentView(layout);
            ImageView imageView = (ImageView) layout.findViewById(R.id.load);
            imageView.setImageResource(R.drawable.loading);
            animationDrawable = (AnimationDrawable) imageView.getDrawable();
            animationDrawable.start();
            dlg5.setCanceledOnTouchOutside(true);
            dlg5.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                    dlg5 = null;
                    animationDrawable.stop();
                }
            });
            Window w = dlg5.getWindow();
            WindowManager.LayoutParams lp = w.getAttributes();
            lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
            if (context != null && !((Activity) context).isFinishing())
                w.setAttributes(lp);

        }
    }

    public void showLoading(Context context, String s) {
        if (dlg5 == null) {
            LayoutInflater localinflater = (LayoutInflater) context.getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);
            View layout = localinflater.inflate(R.layout.dialog_loading, null);

            dlg5 = new Dialog(context, R.style.theme_dialog1);
            dlg5.setCancelable(true);
            if (context != null && !((Activity) context).isFinishing())
                dlg5.show();
            dlg5.setContentView(layout);
            ImageView imageView = (ImageView) layout.findViewById(R.id.load);
            imageView.setImageResource(R.drawable.loading);
            animationDrawable = (AnimationDrawable) imageView.getDrawable();
            animationDrawable.start();
            dlg5.setCanceledOnTouchOutside(true);
            dlg5.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                    dlg5 = null;
                    animationDrawable.stop();
                }
            });
            Window w = dlg5.getWindow();
            WindowManager.LayoutParams lp = w.getAttributes();
            lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
            if (context != null && !((Activity) context).isFinishing())
                w.setAttributes(lp);

        }
    }

    public void killLoading() {
        if (dlg5 != null) {
            if (animationDrawable != null)
                animationDrawable.stop();
            dlg5.dismiss();
            dlg5 = null;
        }
    }*/
}
