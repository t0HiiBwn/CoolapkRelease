package com.bytedance.sdk.openadsdk.core.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.ac;

/* compiled from: TTCustomShadowBackground */
public class f extends Drawable {
    private int a;
    private int b;
    private int[] c;
    private float[] d;
    private LinearGradient e;
    private int f;
    private int g;
    private int h;
    private int i;
    private RectF j;
    private Paint k;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public f(int i2, int[] iArr, float[] fArr, int i3, LinearGradient linearGradient, int i4, int i5, int i6, int i7) {
        this.a = i2;
        this.c = iArr;
        this.d = fArr;
        this.b = i3;
        this.e = linearGradient;
        this.f = i4;
        this.g = i5;
        this.h = i6;
        this.i = i7;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.j == null) {
            Rect bounds = getBounds();
            this.j = new RectF((float) ((bounds.left + this.g) - this.h), (float) ((bounds.top + this.g) - this.i), (float) ((bounds.right - this.g) - this.h), (float) ((bounds.bottom - this.g) - this.i));
        }
        if (this.k == null) {
            a();
        }
        RectF rectF = this.j;
        int i2 = this.f;
        canvas.drawRoundRect(rectF, (float) i2, (float) i2, this.k);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        Paint paint = this.k;
        if (paint != null) {
            paint.setAlpha(i2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Paint paint = this.k;
        if (paint != null) {
            paint.setColorFilter(colorFilter);
        }
    }

    private void a() {
        int[] iArr;
        Paint paint = new Paint();
        this.k = paint;
        boolean z = true;
        paint.setAntiAlias(true);
        this.k.setShadowLayer((float) this.g, (float) this.h, (float) this.i, this.b);
        if (this.j == null || (iArr = this.c) == null || iArr.length <= 1) {
            this.k.setColor(this.a);
            return;
        }
        float[] fArr = this.d;
        if (fArr == null || fArr.length <= 0 || fArr.length != iArr.length) {
            z = false;
        }
        Paint paint2 = this.k;
        LinearGradient linearGradient = this.e;
        if (linearGradient == null) {
            linearGradient = new LinearGradient(this.j.left, 0.0f, this.j.right, 0.0f, this.c, z ? this.d : null, Shader.TileMode.CLAMP);
        }
        paint2.setShader(linearGradient);
    }

    public static void a(View view, a aVar) {
        if (view != null && aVar != null) {
            view.setLayerType(1, null);
            ViewCompat.setBackground(view, aVar.a());
        }
    }

    /* compiled from: TTCustomShadowBackground */
    public static class a {
        private int a;
        private int b;
        private int[] c;
        private float[] d;
        private LinearGradient e;
        private int f;
        private int g;
        private int h;
        private int i;

        public a() {
            this.h = 0;
            this.i = 0;
            this.a = ac.j(p.a(), "tt_ssxinmian8");
            this.b = ac.j(p.a(), "tt_ssxinxian3");
            this.f = 10;
            this.g = 16;
            this.h = 0;
            this.i = 0;
        }

        public a a(int i2) {
            this.a = i2;
            return this;
        }

        public a b(int i2) {
            this.b = i2;
            return this;
        }

        public a a(int[] iArr) {
            this.c = iArr;
            return this;
        }

        public a c(int i2) {
            this.f = i2;
            return this;
        }

        public a d(int i2) {
            this.h = i2;
            return this;
        }

        public a e(int i2) {
            this.i = i2;
            return this;
        }

        public f a() {
            return new f(this.a, this.c, this.d, this.b, this.e, this.f, this.g, this.h, this.i);
        }
    }
}
