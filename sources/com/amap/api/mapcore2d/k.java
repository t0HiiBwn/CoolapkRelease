package com.amap.api.mapcore2d;

import android.content.Context;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

/* compiled from: CameraAnimator */
class k {
    private static float I = ((float) (Math.log(0.78d) / Math.log(0.9d)));
    private static final float[] J = new float[101];
    private static final float[] K = new float[101];
    private static float O = 8.0f;
    private static float P;
    private float A;
    private float B;
    private boolean C;
    private Interpolator D;
    private boolean E;
    private float F;
    private int G;
    private float H;
    private float L;
    private final float M;
    private float N;
    private int a;
    private int b;
    private int c;
    private float d;
    private float e;
    private float f;
    private int g;
    private int h;
    private float i;
    private float j;
    private float k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private float r;
    private float s;
    private float t;
    private long u;
    private long v;
    private float w;
    private float x;
    private float y;
    private float z;

    static {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12 = 0.0f;
        float f13 = 0.0f;
        for (int i2 = 0; i2 < 100; i2++) {
            float f14 = ((float) i2) / 100.0f;
            float f15 = 1.0f;
            while (true) {
                f2 = 2.0f;
                f3 = ((f15 - f12) / 2.0f) + f12;
                f4 = 3.0f;
                f5 = 1.0f - f3;
                f6 = f3 * 3.0f * f5;
                f7 = f3 * f3 * f3;
                float f16 = (((f5 * 0.175f) + (f3 * 0.35000002f)) * f6) + f7;
                if (((double) Math.abs(f16 - f14)) < 1.0E-5d) {
                    break;
                } else if (f16 > f14) {
                    f15 = f3;
                } else {
                    f12 = f3;
                }
            }
            J[i2] = (f6 * ((f5 * 0.5f) + f3)) + f7;
            float f17 = 1.0f;
            while (true) {
                f8 = ((f17 - f13) / f2) + f13;
                f9 = 1.0f - f8;
                f10 = f8 * f4 * f9;
                f11 = f8 * f8 * f8;
                float f18 = (((f9 * 0.5f) + f8) * f10) + f11;
                if (((double) Math.abs(f18 - f14)) < 1.0E-5d) {
                    break;
                }
                if (f18 > f14) {
                    f17 = f8;
                } else {
                    f13 = f8;
                }
                f2 = 2.0f;
                f4 = 3.0f;
            }
            K[i2] = (f10 * ((f9 * 0.175f) + (f8 * 0.35000002f))) + f11;
        }
        float[] fArr = J;
        K[100] = 1.0f;
        fArr[100] = 1.0f;
        P = 1.0f;
        P = 1.0f / a(1.0f);
    }

    public k(Context context) {
        this(context, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    private k(Context context, Interpolator interpolator) {
        this(context, interpolator, context.getApplicationInfo().targetSdkVersion >= 11);
    }

    private k(Context context, Interpolator interpolator, boolean z2) {
        this.H = ViewConfiguration.getScrollFriction();
        this.C = true;
        this.D = interpolator;
        this.M = context.getResources().getDisplayMetrics().density * 160.0f;
        this.L = b(ViewConfiguration.getScrollFriction());
        this.E = z2;
        this.N = b(0.84f);
    }

    private float b(float f2) {
        return this.M * 386.0878f * f2;
    }

    public final boolean a() {
        return this.C;
    }

    public final void a(boolean z2) {
        this.C = z2;
    }

    public final int b() {
        return this.p;
    }

    public final int c() {
        return this.q;
    }

    public final float d() {
        return this.r;
    }

    public final float e() {
        return this.s;
    }

    public final float f() {
        return this.t;
    }

    public boolean g() {
        float f2;
        if (this.C) {
            return false;
        }
        int currentAnimationTimeMillis = (int) (AnimationUtils.currentAnimationTimeMillis() - this.u);
        long j2 = this.v;
        if (((long) currentAnimationTimeMillis) < j2) {
            int i2 = this.a;
            if (i2 == 1) {
                float f3 = ((float) currentAnimationTimeMillis) / ((float) j2);
                int i3 = (int) (f3 * 100.0f);
                float f4 = 1.0f;
                float f5 = 0.0f;
                if (i3 < 100) {
                    float f6 = ((float) i3) / 100.0f;
                    int i4 = i3 + 1;
                    float[] fArr = J;
                    float f7 = fArr[i3];
                    f5 = (fArr[i4] - f7) / ((((float) i4) / 100.0f) - f6);
                    f4 = f7 + ((f3 - f6) * f5);
                }
                this.F = ((f5 * ((float) this.G)) / ((float) j2)) * 1000.0f;
                int i5 = this.b;
                int round = i5 + Math.round(((float) (this.g - i5)) * f4);
                this.p = round;
                int min = Math.min(round, this.m);
                this.p = min;
                this.p = Math.max(min, this.l);
                int i6 = this.c;
                int round2 = i6 + Math.round(f4 * ((float) (this.h - i6)));
                this.q = round2;
                int min2 = Math.min(round2, this.o);
                this.q = min2;
                int max = Math.max(min2, this.n);
                this.q = max;
                if (this.p == this.g && max == this.h) {
                    this.C = true;
                }
            } else if (i2 == 2) {
                float f8 = ((float) currentAnimationTimeMillis) * this.w;
                Interpolator interpolator = this.D;
                if (interpolator == null) {
                    f2 = a(f8);
                } else {
                    f2 = interpolator.getInterpolation(f8);
                }
                this.p = this.b + Math.round(this.x * f2);
                this.q = this.c + Math.round(this.y * f2);
                this.r = this.d + (this.z * f2);
                this.s = this.e + (this.A * f2);
                this.t = this.f + (f2 * this.B);
            }
        } else {
            this.p = this.g;
            this.q = this.h;
            this.r = this.i;
            this.s = this.j;
            this.t = this.k;
            this.C = true;
        }
        return true;
    }

    static float a(float f2) {
        float f3;
        float f4 = f2 * O;
        if (f4 < 1.0f) {
            f3 = f4 - (1.0f - ((float) Math.exp((double) (-f4))));
        } else {
            f3 = ((1.0f - ((float) Math.exp((double) (1.0f - f4)))) * 0.63212055f) + 0.36787945f;
        }
        return f3 * P;
    }

    public final int h() {
        return this.a;
    }
}
