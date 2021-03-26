package com.amap.api.mapcore2d;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.View;
import java.io.InputStream;

/* compiled from: WaterMarkerView */
class cd extends View {
    private Bitmap a;
    private Bitmap b;
    private Bitmap c;
    private Bitmap d;
    private Paint e = new Paint();
    private boolean f = false;
    private int g = 0;
    private int h = 0;
    private int i = 0;
    private int j = 10;
    private int k = 0;
    private int l = 0;
    private int m = 10;
    private int n = 8;
    private int o = 0;
    private boolean p = false;
    private float q = 0.0f;
    private float r = 0.0f;
    private boolean s = true;

    public int a() {
        return this.i;
    }

    public void b() {
        try {
            Bitmap bitmap = this.a;
            if (bitmap != null) {
                bitmap.recycle();
            }
            Bitmap bitmap2 = this.b;
            if (bitmap2 != null) {
                bitmap2.recycle();
            }
            this.a = null;
            this.b = null;
            Bitmap bitmap3 = this.c;
            if (bitmap3 != null) {
                bitmap3.recycle();
                this.c = null;
            }
            Bitmap bitmap4 = this.d;
            if (bitmap4 != null) {
                bitmap4.recycle();
                this.d = null;
            }
            this.e = null;
        } catch (Throwable th) {
            Cdo.c(th, "WaterMarkerView", "destory");
            th.printStackTrace();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x00a9 A[SYNTHETIC, Splitter:B:21:0x00a9] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    public cd(Context context, y yVar) {
        super(context);
        InputStream inputStream;
        Throwable th;
        AssetManager assets = context.getResources().getAssets();
        InputStream inputStream2 = null;
        try {
            InputStream open = assets.open("ap2d.data");
            try {
                Bitmap decodeStream = BitmapFactory.decodeStream(open);
                this.c = decodeStream;
                this.a = cm.a(decodeStream, q.a);
                open.close();
                inputStream2 = assets.open("ap12d.data");
                Bitmap decodeStream2 = BitmapFactory.decodeStream(inputStream2);
                this.d = decodeStream2;
                this.b = cm.a(decodeStream2, q.a);
                inputStream2.close();
                this.h = this.b.getWidth();
                this.g = this.b.getHeight();
                this.e.setAntiAlias(true);
                this.e.setColor(-16777216);
                this.e.setStyle(Paint.Style.STROKE);
                if (open != null) {
                    try {
                        open.close();
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                        return;
                    } catch (Throwable th3) {
                        th3.printStackTrace();
                        return;
                    }
                } else {
                    return;
                }
            } catch (Throwable th4) {
                th = th4;
                inputStream = inputStream2;
                inputStream2 = open;
                try {
                    Cdo.c(th, "WaterMarkerView", "create");
                    th.printStackTrace();
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (Throwable th5) {
                            th5.printStackTrace();
                        }
                    }
                    if (inputStream == null) {
                        inputStream.close();
                        return;
                    }
                    return;
                } catch (Throwable th6) {
                    th6.printStackTrace();
                }
            }
        } catch (Throwable th7) {
            th = th7;
            inputStream = null;
            Cdo.c(th, "WaterMarkerView", "create");
            th.printStackTrace();
            if (inputStream2 != null) {
            }
            if (inputStream == null) {
            }
        }
        throw th;
        if (inputStream != null) {
            inputStream.close();
        }
        throw th;
    }

    public Bitmap c() {
        if (this.f) {
            return this.b;
        }
        return this.a;
    }

    public void a(boolean z) {
        try {
            this.f = z;
            if (z) {
                this.e.setColor(-1);
            } else {
                this.e.setColor(-16777216);
            }
            invalidate();
        } catch (Throwable th) {
            Cdo.c(th, "WaterMarkerView", "changeBitmap");
            th.printStackTrace();
        }
    }

    public Point d() {
        return new Point(this.j, this.k - 2);
    }

    public void a(int i2) {
        this.l = 0;
        this.i = i2;
        e();
    }

    public void b(int i2) {
        this.l = 1;
        this.n = i2;
        e();
    }

    public void c(int i2) {
        this.l = 1;
        this.m = i2;
        e();
    }

    public void e() {
        if (getWidth() != 0 && getHeight() != 0) {
            f();
            postInvalidate();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        try {
            if (getWidth() == 0) {
                return;
            }
            if (getHeight() != 0) {
                if (this.b != null) {
                    if (!this.p) {
                        f();
                        this.p = true;
                    }
                    canvas.drawBitmap(c(), (float) this.j, (float) this.k, this.e);
                }
            }
        } catch (Throwable th) {
            Cdo.c(th, "WaterMarkerView", "onDraw");
            th.printStackTrace();
        }
    }

    private void f() {
        int i2 = this.l;
        if (i2 == 0) {
            h();
        } else if (i2 == 2) {
            g();
        }
        this.j = this.m;
        int height = (getHeight() - this.n) - this.g;
        this.k = height;
        if (this.j < 0) {
            this.j = 0;
        }
        if (height < 0) {
            this.k = 0;
        }
    }

    private void g() {
        if (this.s) {
            this.m = (int) (((float) getWidth()) * this.q);
        } else {
            this.m = (int) ((((float) getWidth()) * this.q) - ((float) this.h));
        }
        this.n = (int) (((float) getHeight()) * this.r);
    }

    private void h() {
        int i2 = this.i;
        if (i2 == 1) {
            this.m = (getWidth() - this.h) / 2;
        } else if (i2 == 2) {
            this.m = (getWidth() - this.h) - 10;
        } else {
            this.m = 10;
        }
        this.n = 8;
    }

    public void a(int i2, int i3, int i4, int i5) {
        int i6 = this.h / 2;
        int i7 = this.g / 2;
        int i8 = i4 - i6;
        if (i2 > i8) {
            i2 = i8;
        }
        if (i2 < i6) {
            i2 = i6;
        }
        if (i3 < i7) {
            i3 = i7;
        }
        int i9 = i5 - i7;
        if (i3 > i9) {
            i3 = i9;
        }
        c(i2 - i6);
        b((i5 - i3) - i7);
    }
}
