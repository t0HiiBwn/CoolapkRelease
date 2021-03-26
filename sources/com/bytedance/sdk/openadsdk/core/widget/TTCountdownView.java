package com.bytedance.sdk.openadsdk.core.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.LinearInterpolator;
import java.util.concurrent.atomic.AtomicBoolean;

public class TTCountdownView extends View {
    private boolean A;
    private AtomicBoolean B;
    private int a;
    private int b;
    private int c;
    private int d;
    private float e;
    private float f;
    private float g;
    private int h;
    private boolean i;
    private float j;
    private float k;
    private float l;
    private String m;
    private boolean n;
    private Paint o;
    private Paint p;
    private Paint q;
    private Paint r;
    private float s;
    private float t;
    private RectF u;
    private a v;
    private AnimatorSet w;
    private ValueAnimator x;
    private ValueAnimator y;
    private ValueAnimator z;

    public interface a {
        void a();

        void b();

        void c();
    }

    public float a(float f2, float f3) {
        return f2 * f3;
    }

    public float a(float f2, int i2) {
        return ((float) i2) * f2;
    }

    public TTCountdownView(Context context) {
        this(context, null);
    }

    public TTCountdownView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TTCountdownView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = Color.parseColor("#fce8b6");
        this.b = Color.parseColor("#f0f0f0");
        this.c = Color.parseColor("#ffffff");
        this.d = Color.parseColor("#7c7c7c");
        this.e = 2.0f;
        this.f = 12.0f;
        this.g = 18.0f;
        this.h = 270;
        this.i = false;
        this.j = 5.0f;
        this.k = 5.0f;
        this.l = 0.8f;
        this.m = "跳过";
        this.n = false;
        this.s = 1.0f;
        this.t = 1.0f;
        this.A = false;
        this.B = new AtomicBoolean(true);
        this.e = a(2.0f);
        this.g = a(18.0f);
        this.f = b(12.0f);
        this.h %= 360;
        e();
        f();
    }

    private void e() {
        Paint paint = new Paint(1);
        this.o = paint;
        paint.setColor(this.a);
        this.o.setStrokeWidth(this.e);
        this.o.setAntiAlias(true);
        this.o.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint(1);
        this.p = paint2;
        paint2.setColor(this.c);
        this.p.setAntiAlias(true);
        this.p.setStrokeWidth(this.e);
        this.p.setStyle(Paint.Style.FILL);
        Paint paint3 = new Paint(1);
        this.q = paint3;
        paint3.setColor(this.b);
        this.q.setAntiAlias(true);
        this.q.setStrokeWidth(this.e / 2.0f);
        this.q.setStyle(Paint.Style.STROKE);
        Paint paint4 = new Paint(1);
        this.r = paint4;
        paint4.setColor(this.d);
        this.q.setAntiAlias(true);
        this.r.setTextSize(this.f);
        this.r.setTextAlign(Paint.Align.CENTER);
    }

    private void f() {
        float f2 = this.g;
        this.u = new RectF(-f2, -f2, f2, f2);
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int size = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i3);
        if (mode != 1073741824) {
            size = g();
        }
        if (mode2 != 1073741824) {
            size2 = g();
        }
        setMeasuredDimension(size, size2);
    }

    private int g() {
        return (int) ((((this.e / 2.0f) + this.g) * 2.0f) + a(4.0f));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(((float) getMeasuredWidth()) / 2.0f, ((float) getMeasuredHeight()) / 2.0f);
        b(canvas);
        a(canvas);
    }

    private void a(Canvas canvas) {
        String str;
        canvas.save();
        Paint.FontMetrics fontMetrics = this.r.getFontMetrics();
        if (this.n) {
            str = "" + ((int) Math.ceil((double) a(this.t, this.k)));
        } else {
            str = this.m;
        }
        if (TextUtils.isEmpty(str)) {
            str = "跳过";
        }
        canvas.drawText(str, 0.0f, 0.0f - ((fontMetrics.ascent + fontMetrics.descent) / 2.0f), this.r);
        canvas.restore();
    }

    private void b(Canvas canvas) {
        float f2;
        canvas.save();
        float a2 = a(this.s, 360);
        if (this.i) {
            f2 = ((float) this.h) - a2;
        } else {
            f2 = (float) this.h;
        }
        canvas.drawCircle(0.0f, 0.0f, this.g, this.p);
        canvas.drawCircle(0.0f, 0.0f, this.g, this.q);
        canvas.drawArc(this.u, f2, a2, false, this.o);
        canvas.restore();
    }

    public void a() {
        AnimatorSet animatorSet = this.w;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.w.cancel();
            this.w = null;
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.w = animatorSet2;
        animatorSet2.playTogether(getNumAnim(), getArcAnim());
        this.w.setInterpolator(new LinearInterpolator());
        this.w.addListener(new AnimatorListenerAdapter() {
            /* class com.bytedance.sdk.openadsdk.core.widget.TTCountdownView.AnonymousClass1 */

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                TTCountdownView.this.A = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (TTCountdownView.this.A) {
                    TTCountdownView.this.A = false;
                } else if (TTCountdownView.this.v != null) {
                    TTCountdownView.this.v.b();
                }
            }
        });
        this.w.start();
        if (!this.B.get()) {
            c();
        }
    }

    private ValueAnimator getNumAnim() {
        ValueAnimator valueAnimator = this.x;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.x = null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.t, 0.0f);
        this.x = ofFloat;
        ofFloat.setInterpolator(new LinearInterpolator());
        this.x.setDuration((long) (a(this.t, this.k) * 1000.0f));
        this.x.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.bytedance.sdk.openadsdk.core.widget.TTCountdownView.AnonymousClass2 */

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                TTCountdownView.this.t = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                TTCountdownView.this.postInvalidate();
            }
        });
        return this.x;
    }

    private ValueAnimator getArcAnim() {
        ValueAnimator valueAnimator = this.y;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.y = null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.s, 0.0f);
        this.y = ofFloat;
        ofFloat.setInterpolator(new LinearInterpolator());
        this.y.setDuration((long) (a(this.s, this.j) * 1000.0f));
        this.y.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.bytedance.sdk.openadsdk.core.widget.TTCountdownView.AnonymousClass3 */

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                TTCountdownView.this.s = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                TTCountdownView.this.postInvalidate();
            }
        });
        return this.y;
    }

    public void b() {
        AnimatorSet animatorSet = this.w;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.w = null;
        }
        ValueAnimator valueAnimator = this.z;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.z = null;
        }
        ValueAnimator valueAnimator2 = this.x;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
            this.x = null;
        }
        ValueAnimator valueAnimator3 = this.y;
        if (valueAnimator3 != null) {
            valueAnimator3.cancel();
            this.y = null;
        }
        this.s = 1.0f;
        this.t = 1.0f;
        invalidate();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        b();
        super.onDetachedFromWindow();
    }

    public void setCountDownTime(int i2) {
        float f2 = (float) i2;
        this.k = f2;
        this.j = f2;
        b();
    }

    private float a(float f2) {
        return TypedValue.applyDimension(1, f2, getResources().getDisplayMetrics());
    }

    private float b(float f2) {
        return TypedValue.applyDimension(2, f2, getResources().getDisplayMetrics());
    }

    public a getCountdownListener() {
        return this.v;
    }

    public void setCountdownListener(a aVar) {
        this.v = aVar;
        if (!this.B.get() && aVar != null) {
            aVar.c();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        this.B.set(z2);
        if (!this.B.get()) {
            c();
            a aVar = this.v;
            if (aVar != null) {
                aVar.c();
                return;
            }
            return;
        }
        d();
        a aVar2 = this.v;
        if (aVar2 != null) {
            aVar2.a();
        }
    }

    public void c() {
        try {
            if (this.w != null && Build.VERSION.SDK_INT >= 19) {
                this.w.pause();
            }
        } catch (Throwable unused) {
        }
    }

    public void d() {
        try {
            if (this.w != null && Build.VERSION.SDK_INT >= 19) {
                this.w.resume();
            }
        } catch (Throwable unused) {
        }
    }
}
