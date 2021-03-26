package com.sina.weibo.sdk.web.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;

public class WbSdkProgressBar extends View {
    private boolean addStart;
    private double growTime;
    private double growTimeMax;
    private Handler handler;
    private long lastTime;
    private float length;
    private final int maxLength;
    private final int minLength;
    private int miniSize;
    private int padding;
    private Paint paint;
    private int paintWidth;
    private float progress;
    private RectF rect;
    private boolean showView;
    private float speed;
    private long stopGrowTime;
    private long stopGrowTimeMax;
    int stopNum;

    public WbSdkProgressBar(Context context) {
        this(context, null);
    }

    public WbSdkProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WbSdkProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.minLength = 20;
        this.maxLength = 300;
        this.lastTime = 0;
        this.speed = 200.0f;
        this.stopGrowTimeMax = 180;
        this.stopGrowTime = 0;
        this.growTimeMax = 490.0d;
        this.addStart = false;
        this.showView = true;
        this.stopNum = 0;
        this.handler = new Handler() {
            /* class com.sina.weibo.sdk.web.view.WbSdkProgressBar.AnonymousClass1 */

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what == 0) {
                    WbSdkProgressBar.this.showView = false;
                }
            }
        };
        this.miniSize = dip2px(context, 50);
        this.paintWidth = dip2px(context, 5);
        this.padding = dip2px(context, 3);
        Paint paint2 = new Paint();
        this.paint = paint2;
        paint2.setAntiAlias(true);
        this.paint.setColor(-48861);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth((float) this.paintWidth);
        int i2 = this.padding;
        int i3 = this.miniSize;
        this.rect = new RectF((float) i2, (float) i2, (float) (i3 - i2), (float) (i3 - i2));
    }

    private int dip2px(Context context, int i) {
        return (int) (context.getResources().getDisplayMetrics().density * ((float) i));
    }

    @Override // android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        long abs = Math.abs(SystemClock.uptimeMillis() - this.lastTime) % 360;
        calculateProgress(abs);
        this.lastTime = SystemClock.uptimeMillis();
        float f = this.progress + ((this.speed * ((float) abs)) / 1000.0f);
        this.progress = f;
        if (f >= 360.0f) {
            this.progress = f - 360.0f;
        }
        canvas.drawArc(this.rect, this.progress - 90.0f, this.length + 20.0f, false, this.paint);
        if (this.showView) {
            if (Build.VERSION.SDK_INT >= 21) {
                postInvalidate();
            } else {
                invalidate();
            }
        }
    }

    public void setProgressColor(int i) {
        this.paint.setColor(i);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 8) {
            this.handler.sendEmptyMessageDelayed(0, 1000);
        } else if (i == 0 && getVisibility() == 0) {
            this.handler.removeMessages(0);
            this.showView = true;
            invalidate();
        }
    }

    private void calculateProgress(long j) {
        long j2 = this.stopGrowTime;
        if (j2 >= this.stopGrowTimeMax) {
            double d = this.growTime + ((double) j);
            this.growTime = d;
            double d2 = this.growTimeMax;
            if (d >= d2) {
                this.growTime = d - d2;
                this.stopGrowTime = 0;
                this.addStart = !this.addStart;
            }
            float cos = (((float) Math.cos(((this.growTime / d2) + 1.0d) * 3.141592653589793d)) / 2.0f) + 0.5f;
            if (!this.addStart) {
                this.length = cos * ((float) 280);
                return;
            }
            float f = ((float) 280) * (1.0f - cos);
            this.progress += this.length - f;
            this.length = f;
            return;
        }
        this.stopGrowTime = j2 + j;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = this.miniSize;
        setMeasuredDimension(i3, i3);
    }
}
