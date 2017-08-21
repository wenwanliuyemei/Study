package com.xm.study.linechart.CustomView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2017/2/10.
 */

public class LineView extends View {
    private float width;
    private float spaceX = 100;//x轴到手机两边距离
    private float startY = 600;//y轴起点
    private float widthY = 700;//y轴高度
    private float widY = 80;//y轴线间距
    private Paint paint = new Paint();
    private double startRate = 8.00;
    private double growthRate = 0.2;
    private int textX[] = new int[]{1, 6, 11, 16, 21};//x轴文字（天数）
    private double textY[] = new double[5];//y轴数字
    private List<Double> number = new ArrayList<>();//点的集合
    private double maxRate = 10.8;
    private float x = spaceX;
    private Path path = new Path();
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                x = x + 1;
                postInvalidate();
            }else {
                Thread.currentThread().interrupt();
            }
        }
    };

    public LineView(Context context) {
        super(context);
        init(context);
    }

    public LineView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public LineView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {

        paint.setStrokeWidth(1);
        paint.setTextSize(20);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        width = windowManager.getDefaultDisplay().getWidth();// 手机屏幕的宽度
    }

    @Override
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.GRAY);
        //画x轴线
        canvas.drawLine(spaceX, startY, width - spaceX, startY, paint);
        //画y轴线
        canvas.drawLine(spaceX, startY, spaceX, startY - widthY, paint);
        //画横向网格
        for (int i = 0; i < 5; i++) {
            canvas.drawLine(spaceX, startY - 50 - i * widY, width - spaceX, startY - 50 - i * widY, paint);
        }
        //画竖向网格
        for (int i = 0; i < 4; i++) {
            canvas.drawLine((float) (spaceX + (i + 1) * ((width - 2 * spaceX) / 4.5)), startY - widthY, (float) (spaceX + (i + 1) * ((width - 2 * spaceX) / 4.5)), startY, paint);
        }
        //画横向文字
        for (int i = 0; i < 5; i++) {
            canvas.drawText(textX[i] + "天", (float) (spaceX + (i) * ((width - 2 * spaceX) / 4.5)) - 15, startY + 30, paint);//x轴文字
        }
        //获取Y轴文字
        for (int i = 0; i < 5; i++) {
            textY[i] = startRate + i;
        }
        //画竖向文字
        for (int i = 0; i < 5; i++) {
            canvas.drawText(textY[i] + "", spaceX - 50, startY - 50 - i * widY, paint);
        }
        //获取几个点的数值
        for (int i = 0; i < 5; i++) {
            if (startRate + growthRate * (textX[i] - 1) <= maxRate)
                number.add(i, startRate + growthRate * (textX[i] - 1));
            else number.add(i, maxRate);
        }
        //画点
        paint.setStrokeWidth(3);
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        for (int i = 0; i < 5; i++) {
            canvas.drawCircle((float) (spaceX + (i) * ((width - 2 * spaceX) / 4.5)), (float) (startY - 50 - widY * (number.get(i) - startRate)), 6, paint);
        }
        paint.setStyle(Paint.Style.FILL);
        path.moveTo(spaceX, startY);
        if (x >= spaceX && x <= (spaceX + (1) * ((width - 2 * spaceX) / 4.5))) {
            path.lineTo((float) (spaceX + (0) * ((width - 2 * spaceX) / 4.5)), (float) (startY - 50 - widY * (number.get(0) - startRate)));
            path.lineTo(x, (float) (startY - (x * (startY - 50 - widY * (number.get(0) - startRate) - (startY - 50 - widY * (number.get(1) - startRate))) / ((width - 2 * spaceX) / 4.5))));
            path.lineTo(x, startY);
        }
//        if (x >= spaceX && x <= (spaceX + (1) * ((width - 2 * spaceX) / 4.5))) {
//            path.lineTo((float) (spaceX + (0) * ((width - 2 * spaceX) / 4.5)), (float) (startY - 50 - widY * (number.get(0) - startRate)));
//            path.lineTo(x, (float) (startY - (x * (startY - 50 - widY * (number.get(0) - startRate) - (startY - 50 - widY * (number.get(1) - startRate))) / ((width - 2 * spaceX) / 4.5))));
//            path.lineTo(x, startY);
//        } else if (x >= (spaceX + (1) * ((width - 2 * spaceX) / 4.5)) && x < (spaceX + (2) * ((width - 2 * spaceX) / 4.5))) {
//            path.lineTo((float) (spaceX + (0) * ((width - 2 * spaceX) / 4.5)), (float) (startY - 50 - widY * (number.get(0) - startRate)));
//            path.lineTo((float) (spaceX + (1) * ((width - 2 * spaceX) / 4.5)), (float) (startY - 50 - widY * (number.get(1) - startRate)));
//            path.lineTo(x, (float) (startY - (x * (startY - 50 - widY * (number.get(1) - startRate) - (startY - 50 - widY * (number.get(2) - startRate))) / ((width - 2 * spaceX) / 4.5))));
//            path.lineTo(x, startY);
//        } else if (x >= (spaceX + (2) * ((width - 2 * spaceX) / 4.5)) && x < (spaceX + (3) * ((width - 2 * spaceX) / 4.5))) {
//            path.lineTo((float) (spaceX + (0) * ((width - 2 * spaceX) / 4.5)), (float) (startY - 50 - widY * (number.get(0) - startRate)));
//            path.lineTo((float) (spaceX + (1) * ((width - 2 * spaceX) / 4.5)), (float) (startY - 50 - widY * (number.get(1) - startRate)));
//            path.lineTo((float) (spaceX + (2) * ((width - 2 * spaceX) / 4.5)), (float) (startY - 50 - widY * (number.get(2) - startRate)));
//            path.lineTo(x, (float) (startY - (x * (startY - 50 - widY * (number.get(2) - startRate) - (startY - 50 - widY * (number.get(3) - startRate))) / ((width - 2 * spaceX) / 4.5))));
//            path.lineTo(x, startY);
//        } else if (x >= (spaceX + (3) * ((width - 2 * spaceX) / 4.5)) && x < (spaceX + (4) * ((width - 2 * spaceX) / 4.5))) {
//            path.lineTo((float) (spaceX + (0) * ((width - 2 * spaceX) / 4.5)), (float) (startY - 50 - widY * (number.get(0) - startRate)));
//            path.lineTo((float) (spaceX + (1) * ((width - 2 * spaceX) / 4.5)), (float) (startY - 50 - widY * (number.get(1) - startRate)));
//            path.lineTo((float) (spaceX + (2) * ((width - 2 * spaceX) / 4.5)), (float) (startY - 50 - widY * (number.get(2) - startRate)));
//            path.lineTo((float) (spaceX + (3) * ((width - 2 * spaceX) / 4.5)), (float) (startY - 50 - widY * (number.get(3) - startRate)));
//            path.lineTo(x, (float) (startY - (x * (startY - 50 - widY * (number.get(3) - startRate) - (startY - 50 - widY * (number.get(4) - startRate))) / ((width - 2 * spaceX) / 4.5))));
//            path.lineTo(x, startY);
//        } else if (x >= (spaceX + (4) * ((width - 2 * spaceX) / 4.5)) && x < (spaceX + (4.5) * ((width - 2 * spaceX) / 4.5))) {
//            path.lineTo((float) (spaceX + (0) * ((width - 2 * spaceX) / 4.5)), (float) (startY - 50 - widY * (number.get(0) - startRate)));
//            path.lineTo((float) (spaceX + (1) * ((width - 2 * spaceX) / 4.5)), (float) (startY - 50 - widY * (number.get(1) - startRate)));
//            path.lineTo((float) (spaceX + (2) * ((width - 2 * spaceX) / 4.5)), (float) (startY - 50 - widY * (number.get(2) - startRate)));
//            path.lineTo((float) (spaceX + (3) * ((width - 2 * spaceX) / 4.5)), (float) (startY - 50 - widY * (number.get(3) - startRate)));
//            path.lineTo((float) (spaceX + (4) * ((width - 2 * spaceX) / 4.5)), (float) (startY - 50 - widY * (number.get(4) - startRate)));
//            path.lineTo(x, (float) (startY - 50 - widY * (number.get(4) - startRate)));
//            path.lineTo(x, startY);
//        }

        path.close();
        canvas.drawPath(path, paint);
        new Timer().schedule(new TimerTask() {

            @Override
            public void run() {
                if (!Thread.currentThread().isInterrupted()) {
                    if (x-(width-spaceX)>=0){
                        handler.sendEmptyMessage(0);
                    }else {
                        handler.sendEmptyMessage(1);
                    }
                }
            }
        }, 100, 100);
    }
}
