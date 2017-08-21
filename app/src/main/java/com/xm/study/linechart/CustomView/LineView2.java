package com.xm.study.linechart.CustomView;

import android.content.Context;
import android.graphics.BitmapFactory;
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
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2017/2/10.
 */

public class LineView2 extends View {
    private float width;
    private float spaceX = 100;//x轴到手机两边距离
    private float startY = 600;//y轴起点
    private float widthY = 700;//y轴高度
    private float widY = 80;//y轴线间距
    private Paint paint = new Paint();
    private double startRate = 7.00;
    private double growthRate = 0.2;
    private int textX[] = new int[]{1, 6, 11, 16, 21};//x轴文字（天数）
    private double textY[] = new double[5];//y轴数字
    private List<Double> number = new ArrayList<>();//点的集合
    private List<Point> circle = new ArrayList<>();//点坐标集合
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
            } else {
                Thread.currentThread().interrupt();
            }
        }
    };

    public LineView2(Context context) {
        super(context);
        init(context);
    }

    public LineView2(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public LineView2(Context context, AttributeSet attrs, int defStyleAttr) {
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
            canvas.drawLine(spaceX, startY - (i + 1) * widY, width - spaceX, startY - (i + 1) * widY, paint);
        }
        //画竖向网格
        for (int i = 0; i < 4; i++) {
            canvas.drawLine((float) (spaceX + (i + 1) * ((width - 2 * spaceX) / 4.5)), startY - widthY, (float) (spaceX + (i + 1) * ((width - 2 * spaceX) / 4.5)), startY, paint);
        }
        //画横向文字
        for (int i = 0; i < 5; i++) {
            canvas.drawText(textX[i] + "天",(float) (spaceX + (i) * ((width - 2 * spaceX) / 4.5)) - 15,startY + 30, paint);//x轴文字
        }
        //获取Y轴文字
        for (int i = 0; i < 5; i++) {
            textY[i] = startRate + i;
        }
        //画竖向文字
        for (int i = 0; i < 5; i++) {
            canvas.drawText(textY[i] + "", spaceX - 50, startY - (i + 1) * widY, paint);
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
            Point p = new Point();
            p.setX((float) (spaceX + (i) * ((width - 2 * spaceX) / 4.5)));
            p.setY((float) (startY - widY * (number.get(i) - startRate + 1)));
            circle.add(p);
            canvas.drawCircle(p.getX(),p.getY() , 6, paint);
            if (i==4){
                Point p1 = new Point();
                p1.setX((float) (spaceX + (4.5) * ((width - 2 * spaceX) / 4.5)));
                p1.setY((float) (startY - widY * (number.get(i) - startRate + 1)));
                circle.add(p1);
            }
        }
        paint.setColor(Color.parseColor("#98ACD0EF"));
        paint.setStyle(Paint.Style.FILL);
        path.moveTo(spaceX, startY);
        if (x >= spaceX && x <= circle.get(1).getX()) {
            path.lineTo(circle.get(0).getX(), circle.get(0).getY());
            path.lineTo(x, getXY(circle.get(0).getX(), circle.get(0).getY(), circle.get(1).getX(), circle.get(1).getY(), x));
            path.lineTo(x,startY);
        } else if (x >= circle.get(1).getX() && x < circle.get(2).getX()) {
            path.lineTo(circle.get(0).getX(), circle.get(0).getY());
            path.lineTo(circle.get(1).getX(), circle.get(1).getY());
            path.lineTo(x, getXY(circle.get(1).getX(), circle.get(1).getY(), circle.get(2).getX(), circle.get(2).getY(), x));
            path.lineTo(x,startY);
        } else if (x >= circle.get(2).getX() && x < circle.get(3).getX()) {
            path.lineTo(circle.get(0).getX(), circle.get(0).getY());
            path.lineTo(circle.get(1).getX(), circle.get(1).getY());
            path.lineTo(circle.get(2).getX(), circle.get(2).getY());
            path.lineTo(x, getXY(circle.get(2).getX(), circle.get(2).getY(), circle.get(3).getX(), circle.get(3).getY(), x));
            path.lineTo(x,startY);
        } else if (x >= circle.get(3).getX() && x < circle.get(4).getX()) {
            path.lineTo(circle.get(0).getX(), circle.get(0).getY());
            path.lineTo(circle.get(1).getX(), circle.get(1).getY());
            path.lineTo(circle.get(2).getX(), circle.get(2).getY());
            path.lineTo(circle.get(3).getX(), circle.get(3).getY());
            path.lineTo(x, getXY(circle.get(3).getX(), circle.get(3).getY(), circle.get(4).getX(), circle.get(4).getY(), x));
            path.lineTo(x,startY);
        } else if (x >= circle.get(4).getX() && x < circle.get(5).getX()) {
            path.lineTo(circle.get(0).getX(), circle.get(0).getY());
            path.lineTo(circle.get(1).getX(), circle.get(1).getY());
            path.lineTo(circle.get(2).getX(), circle.get(2).getY());
            path.lineTo(circle.get(3).getX(), circle.get(3).getY());
            path.lineTo(circle.get(4).getX(), circle.get(4).getY());
            path.lineTo(x, getXY(circle.get(4).getX(), circle.get(4).getY(), circle.get(5).getX(), circle.get(5).getY(), x));
            path.lineTo(x,startY);
        }
        path.close();
        canvas.drawPath(path, paint);

        new Timer().schedule(new TimerTask() {

            @Override
            public void run() {
                if (!Thread.currentThread().isInterrupted()) {
                    if (x - (width - spaceX) >= 0) {
                        handler.sendEmptyMessage(0);
                    } else {
                        handler.sendEmptyMessage(1);
                    }
                }
            }
        }, 100, 100);
    }

    private float getXY(float x1, float y1, float x2, float y2, float x) {
        return y1 - (x - x1) * (y1 - y2) / (x2 - x1);
    }

}
