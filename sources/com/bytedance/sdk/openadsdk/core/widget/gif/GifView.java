package com.bytedance.sdk.openadsdk.core.widget.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ImageDecoder;
import android.graphics.Movie;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.l;
import com.bytedance.sdk.openadsdk.utils.u;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class GifView extends ImageView {
    private Movie a;
    private long b;
    private int c;
    private AnimatedImageDrawable d;
    private boolean e;
    private boolean f;
    private float g;
    private float h;
    private float i;
    private int j;
    private int k;

    /* renamed from: l  reason: collision with root package name */
    private volatile boolean f1327l;
    private boolean m;

    public GifView(Context context) {
        super(context);
        this.e = Build.VERSION.SDK_INT >= 28;
        this.f = false;
        this.m = true;
        a();
    }

    public GifView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = Build.VERSION.SDK_INT >= 28;
        this.f = false;
        this.m = true;
        a();
    }

    public GifView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.e = Build.VERSION.SDK_INT >= 28;
        this.f = false;
        this.m = true;
        a();
    }

    public GifView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.e = Build.VERSION.SDK_INT >= 28;
        this.f = false;
        this.m = true;
        a();
    }

    void a() {
        if (!this.e) {
            setLayerType(1, null);
            return;
        }
        this.f = ab.a();
        u.b("GifView", "android p 反射解锁：exempt result: " + this.f);
    }

    public void a(byte[] bArr, boolean z) {
        this.f1327l = z;
        if (bArr == null) {
            return;
        }
        if (!this.e) {
            this.a = a(bArr);
        } else {
            this.d = b(bArr);
        }
    }

    private Movie a(byte[] bArr) {
        try {
            return Movie.decodeByteArray(bArr, 0, bArr.length);
        } catch (Throwable th) {
            u.a("GifView", "createMovieWithByteArrayBySafely error1", th);
            return null;
        }
    }

    private AnimatedImageDrawable b(byte[] bArr) {
        ImageDecoder.Source source = null;
        if (bArr == null) {
            return null;
        }
        if (this.f) {
            try {
                source = (ImageDecoder.Source) ImageDecoder.class.getMethod("createSource", Resources.class, InputStream.class).invoke(null, getResources(), new ByteArrayInputStream(bArr));
            } catch (Throwable th) {
                u.c("GifView", "GifView android P  : Use Reflection fail : ", th);
            }
        }
        if (source == null) {
            source = c(bArr);
        }
        return a(source);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0035 A[SYNTHETIC, Splitter:B:21:0x0035] */
    private ImageDecoder.Source c(byte[] bArr) {
        Throwable th;
        FileOutputStream fileOutputStream;
        try {
            File a2 = a(getContext(), b.b() ? "GIF_AD_CACHE/" : "/GIF_CACHE/", "TT_GIF_FILE");
            fileOutputStream = new FileOutputStream(a2);
            try {
                fileOutputStream.write(bArr, 0, bArr.length);
                ImageDecoder.Source createSource = ImageDecoder.createSource(a2);
                try {
                    fileOutputStream.close();
                } catch (Throwable unused) {
                }
                return createSource;
            } catch (Throwable th2) {
                th = th2;
                try {
                    u.c("GifView", "GifView  getSourceByFile fail : ", th);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable unused2) {
                        }
                    }
                    return null;
                } catch (Throwable unused3) {
                }
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            u.c("GifView", "GifView  getSourceByFile fail : ", th);
            if (fileOutputStream != null) {
            }
            return null;
        }
        throw th;
    }

    private AnimatedImageDrawable a(ImageDecoder.Source source) {
        try {
            Drawable decodeDrawable = ImageDecoder.decodeDrawable(source);
            setImageDrawable(decodeDrawable);
            if (!(decodeDrawable instanceof AnimatedImageDrawable)) {
                return null;
            }
            AnimatedImageDrawable animatedImageDrawable = (AnimatedImageDrawable) decodeDrawable;
            if (!this.f1327l) {
                animatedImageDrawable.start();
            }
            return animatedImageDrawable;
        } catch (Throwable th) {
            u.a("GifView", "getAnimatedImageDrawable error", th);
            return null;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i2, int i3) {
        Movie movie;
        int size;
        int size2;
        super.onMeasure(i2, i3);
        if (!this.e && (movie = this.a) != null) {
            int width = movie.width();
            int height = this.a.height();
            float max = 1.0f / Math.max((View.MeasureSpec.getMode(i2) == 0 || width <= (size2 = View.MeasureSpec.getSize(i2))) ? 1.0f : ((float) width) / ((float) size2), (View.MeasureSpec.getMode(i3) == 0 || height <= (size = View.MeasureSpec.getSize(i3))) ? 1.0f : ((float) height) / ((float) size));
            this.i = max;
            int i4 = (int) (((float) width) * max);
            this.j = i4;
            int i5 = (int) (((float) height) * max);
            this.k = i5;
            setMeasuredDimension(i4, i5);
        }
    }

    private File a(Context context, String str, String str2) {
        if (context == null) {
            return null;
        }
        return l.a(context, b.b(), str, str2);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (this.a != null && !this.e) {
            this.g = ((float) (getWidth() - this.j)) / 2.0f;
            this.h = ((float) (getHeight() - this.k)) / 2.0f;
        }
        this.m = getVisibility() == 0;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.a == null || this.e) {
            super.onDraw(canvas);
            return;
        }
        try {
            if (!this.f1327l) {
                c();
                a(canvas);
                b();
                return;
            }
            a(canvas);
        } catch (Throwable th) {
            u.c("GifView", "onDraw->Throwable->", th);
        }
    }

    private void b() {
        if (this.a != null && !this.e && this.m) {
            if (Build.VERSION.SDK_INT >= 16) {
                postInvalidateOnAnimation();
            } else {
                invalidate();
            }
        }
    }

    private void c() {
        if (this.a != null) {
            long uptimeMillis = SystemClock.uptimeMillis();
            if (this.b == 0) {
                this.b = uptimeMillis;
            }
            int duration = this.a.duration();
            if (duration == 0) {
                duration = 1000;
            }
            this.c = (int) ((uptimeMillis - this.b) % ((long) duration));
        }
    }

    private void a(Canvas canvas) {
        Movie movie = this.a;
        if (movie != null) {
            movie.setTime(this.c);
            float f2 = this.i;
            canvas.scale(f2, f2);
            Movie movie2 = this.a;
            float f3 = this.g;
            float f4 = this.i;
            movie2.draw(canvas, f3 / f4, this.h / f4);
            canvas.restore();
        }
    }

    @Override // android.view.View
    public void onScreenStateChanged(int i2) {
        super.onScreenStateChanged(i2);
        if (this.a != null) {
            boolean z = true;
            if (i2 != 1) {
                z = false;
            }
            this.m = z;
            b();
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i2) {
        super.onVisibilityChanged(view, i2);
        if (this.a != null) {
            this.m = i2 == 0;
            b();
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        if (this.a != null) {
            this.m = i2 == 0;
            b();
        }
    }
}
