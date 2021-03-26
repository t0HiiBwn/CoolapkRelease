package com.amap.api.mapcore2d;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.view.MotionEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: MultiTouchGestureDetector */
abstract class bb {
    static float j = 1.0f;
    private static Method p;
    private static Method q;
    private static boolean r;
    private static boolean s;
    b a;
    int b = 0;
    Matrix c = new Matrix();
    Matrix d = new Matrix();
    PointF e = new PointF();
    PointF f = new PointF();
    PointF g = new PointF();
    float h = 1.0f;
    float i = 1.0f;
    boolean k = false;

    /* renamed from: l  reason: collision with root package name */
    boolean f1222l = false;
    boolean m = false;
    public int n = 0;
    public long o = 0;

    /* compiled from: MultiTouchGestureDetector */
    public interface b {
        boolean a(float f, float f2);

        boolean a(float f, PointF pointF);

        boolean a(Matrix matrix);

        boolean a(PointF pointF);

        boolean b(float f, PointF pointF);
    }

    bb() {
    }

    public static a a(Context context, b bVar) {
        a aVar = new a();
        aVar.a = bVar;
        return aVar;
    }

    /* access modifiers changed from: private */
    public static void b(MotionEvent motionEvent) {
        if (!s) {
            s = true;
            try {
                p = motionEvent.getClass().getMethod("getX", Integer.TYPE);
                Method method = motionEvent.getClass().getMethod("getY", Integer.TYPE);
                q = method;
                if (p != null && method != null) {
                    r = true;
                }
            } catch (Exception e2) {
                cm.a(e2, "MutiTouchGestureDetector", "checkSDKForMuti");
            }
        }
    }

    /* compiled from: MultiTouchGestureDetector */
    protected static class a extends bb {
        float p;
        float q;
        float r;
        float s;
        long t = 0;
        int u = 0;
        int v = 0;
        private long w = 0;

        protected a() {
        }

        public boolean a(MotionEvent motionEvent, int i, int i2) {
            this.u = i;
            this.v = i2;
            bb.b(motionEvent);
            if (!bb.r) {
                return false;
            }
            int action = motionEvent.getAction() & 255;
            if (action == 0) {
                this.t = motionEvent.getEventTime();
                this.p = motionEvent.getX();
                this.q = motionEvent.getY();
                this.d.set(this.c);
                this.e.set(this.p, this.q);
                this.b = 1;
                return false;
            } else if (action == 1) {
                this.o = motionEvent.getEventTime();
                this.k = false;
                this.b = 0;
                return false;
            } else if (action != 2) {
                if (action != 3) {
                    if (action == 5) {
                        this.n++;
                        if (this.n != 1) {
                            return false;
                        }
                        this.m = true;
                        j = 1.0f;
                        this.h = b(motionEvent);
                        if (this.h <= 10.0f) {
                            return false;
                        }
                        this.c.reset();
                        this.d.reset();
                        this.d.set(this.c);
                        a(this.f, motionEvent);
                        this.b = 2;
                        this.k = true;
                        boolean a = false | this.a.a(this.e);
                        this.r = this.f.x;
                        this.s = this.f.y;
                        return a;
                    } else if (action != 6) {
                        return false;
                    }
                }
                this.n--;
                if (this.n < 0) {
                    this.n = 0;
                }
                if (this.n == 1) {
                    this.m = true;
                    this.b = 2;
                }
                if (this.n != 0) {
                    return false;
                }
                a(this.f, motionEvent);
                this.f1222l = false;
                this.m = false;
                if (!this.k) {
                    return false;
                }
                boolean b = this.a.b(this.i, this.f) | false;
                this.b = 0;
                return b;
            } else if (this.b == 1) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                this.c.set(this.d);
                this.c.postTranslate(motionEvent.getX() - this.e.x, motionEvent.getY() - this.e.y);
                this.p = x;
                this.q = y;
                boolean a2 = this.a.a(this.c) | false | this.a.a(x - this.p, y - this.q);
                if (motionEvent.getEventTime() - this.t < 30) {
                    return true;
                }
                return a2;
            } else if (this.b != 2) {
                return false;
            } else {
                float b2 = b(motionEvent);
                this.i = 1.0f;
                long eventTime = motionEvent.getEventTime();
                if (b2 <= 10.0f || Math.abs(b2 - this.h) <= 5.0f || eventTime - this.w <= 10) {
                    return false;
                }
                this.w = eventTime;
                this.i = b2 / this.h;
                j = 1.0f;
                this.h = b2;
                a(this.g, motionEvent);
                this.r = this.g.x;
                this.s = this.g.y;
                boolean a3 = this.a.a(this.g.x - this.r, this.g.y - this.s) | false | this.a.a(this.i, this.f);
                this.f1222l = true;
                return a3;
            }
        }

        private float b(MotionEvent motionEvent) {
            float f;
            float f2 = 0.0f;
            try {
                f = ((Float) bb.p.invoke(motionEvent, 0)).floatValue() - ((Float) bb.p.invoke(motionEvent, 1)).floatValue();
            } catch (IllegalArgumentException e) {
                cm.a(e, "MutiTouchGestureDetector", "distance");
                f = 0.0f;
                f2 = ((Float) bb.q.invoke(motionEvent, 0)).floatValue() - ((Float) bb.q.invoke(motionEvent, 1)).floatValue();
                return (float) Math.sqrt((double) ((f * f) + (f2 * f2)));
            } catch (IllegalAccessException e2) {
                cm.a(e2, "MutiTouchGestureDetector", "distance");
                f = 0.0f;
                f2 = ((Float) bb.q.invoke(motionEvent, 0)).floatValue() - ((Float) bb.q.invoke(motionEvent, 1)).floatValue();
                return (float) Math.sqrt((double) ((f * f) + (f2 * f2)));
            } catch (InvocationTargetException e3) {
                cm.a(e3, "MutiTouchGestureDetector", "distance");
                f = 0.0f;
                f2 = ((Float) bb.q.invoke(motionEvent, 0)).floatValue() - ((Float) bb.q.invoke(motionEvent, 1)).floatValue();
                return (float) Math.sqrt((double) ((f * f) + (f2 * f2)));
            }
            try {
                f2 = ((Float) bb.q.invoke(motionEvent, 0)).floatValue() - ((Float) bb.q.invoke(motionEvent, 1)).floatValue();
            } catch (IllegalArgumentException e4) {
                cm.a(e4, "MutiTouchGestureDetector", "distance");
            } catch (IllegalAccessException e5) {
                cm.a(e5, "MutiTouchGestureDetector", "distance");
            } catch (InvocationTargetException e6) {
                cm.a(e6, "MutiTouchGestureDetector", "distance");
            }
            return (float) Math.sqrt((double) ((f * f) + (f2 * f2)));
        }

        private void a(PointF pointF, MotionEvent motionEvent) {
            float f;
            int i;
            int i2;
            float f2 = 0.0f;
            try {
                f = ((Float) bb.p.invoke(motionEvent, 0)).floatValue() + ((Float) bb.p.invoke(motionEvent, 1)).floatValue();
            } catch (IllegalArgumentException e) {
                cm.a(e, "MutiTouchGestureDetector", "midPoint");
                f = 0.0f;
                f2 = ((Float) bb.q.invoke(motionEvent, 0)).floatValue() + ((Float) bb.q.invoke(motionEvent, 1)).floatValue();
                i = this.u;
                f = (float) i;
                f2 = (float) i2;
                pointF.set(f / 2.0f, f2 / 2.0f);
            } catch (IllegalAccessException e2) {
                cm.a(e2, "MutiTouchGestureDetector", "midPoint");
                f = 0.0f;
                f2 = ((Float) bb.q.invoke(motionEvent, 0)).floatValue() + ((Float) bb.q.invoke(motionEvent, 1)).floatValue();
                i = this.u;
                f = (float) i;
                f2 = (float) i2;
                pointF.set(f / 2.0f, f2 / 2.0f);
            } catch (InvocationTargetException e3) {
                cm.a(e3, "MutiTouchGestureDetector", "midPoint");
                f = 0.0f;
                f2 = ((Float) bb.q.invoke(motionEvent, 0)).floatValue() + ((Float) bb.q.invoke(motionEvent, 1)).floatValue();
                i = this.u;
                f = (float) i;
                f2 = (float) i2;
                pointF.set(f / 2.0f, f2 / 2.0f);
            }
            try {
                f2 = ((Float) bb.q.invoke(motionEvent, 0)).floatValue() + ((Float) bb.q.invoke(motionEvent, 1)).floatValue();
            } catch (Throwable th) {
                cm.a(th, "MutiTouchGestureDetector", "midPoint");
            }
            i = this.u;
            if (!(i == 0 || (i2 = this.v) == 0)) {
                f = (float) i;
                f2 = (float) i2;
            }
            pointF.set(f / 2.0f, f2 / 2.0f);
        }
    }
}
