package com.bytedance.sdk.openadsdk.h.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.core.e;
import com.bytedance.sdk.adnet.core.i;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.adnet.d.b;
import com.bytedance.sdk.openadsdk.utils.f;
import com.bytedance.sdk.openadsdk.utils.u;

/* compiled from: GifRequest */
public class c extends Request<byte[]> {
    private static final Object i = new Object();
    private final Object c = new Object();
    private a d;
    private final Bitmap.Config e;
    private final int f;
    private final int g;
    private final ImageView.ScaleType h;

    /* compiled from: GifRequest */
    public interface a extends m.a<byte[]> {
        void a(String str, byte[] bArr);
    }

    public c(String str, a aVar, int i2, int i3, ImageView.ScaleType scaleType, Bitmap.Config config) {
        super(0, str, aVar);
        setRetryPolicy(new e(1000, 2, 2.0f));
        this.d = aVar;
        this.e = config;
        this.f = i2;
        this.g = i3;
        this.h = scaleType;
        setShouldCache(false);
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public Request.b getPriority() {
        return Request.b.LOW;
    }

    private static int a(int i2, int i3, int i4, int i5, ImageView.ScaleType scaleType) {
        if (i2 == 0 && i3 == 0) {
            return i4;
        }
        if (scaleType == ImageView.ScaleType.FIT_XY) {
            return i2 == 0 ? i4 : i2;
        }
        if (i2 == 0) {
            return (int) (((double) i4) * (((double) i3) / ((double) i5)));
        } else if (i3 == 0) {
            return i2;
        } else {
            double d2 = ((double) i5) / ((double) i4);
            if (scaleType == ImageView.ScaleType.CENTER_CROP) {
                double d3 = (double) i3;
                return ((double) i2) * d2 < d3 ? (int) (d3 / d2) : i2;
            }
            double d4 = (double) i3;
            return ((double) i2) * d2 > d4 ? (int) (d4 / d2) : i2;
        }
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    protected m<byte[]> a(i iVar) {
        m<byte[]> b;
        synchronized (i) {
            try {
                b = b(iVar);
            } catch (OutOfMemoryError e2) {
                u.c("GifRequest", "Caught OOM for byte image", e2);
                return m.a(new com.bytedance.sdk.adnet.err.e(e2));
            } catch (Throwable th) {
                throw th;
            }
        }
        return b;
    }

    private m<byte[]> b(i iVar) {
        Bitmap bitmap;
        final byte[] bArr = iVar.b;
        String a2 = a.a().a(getUrl(), this.f, this.g, this.h);
        if (bArr.length >= 3 && bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70) {
            try {
                a.a().a(a2, bArr);
                if (this.d != null) {
                    this.b.post(new Runnable() {
                        /* class com.bytedance.sdk.openadsdk.h.a.c.AnonymousClass1 */

                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.d != null) {
                                c.this.d.a(c.this.getUrl(), bArr);
                            }
                        }
                    });
                }
                return m.a(bArr, b.a(iVar));
            } catch (Exception unused) {
            }
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (this.f == 0 && this.g == 0) {
            options.inPreferredConfig = this.e;
            bitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } else {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            int i2 = options.outWidth;
            int i3 = options.outHeight;
            int a3 = a(this.f, this.g, i2, i3, this.h);
            int a4 = a(this.g, this.f, i3, i2, this.h);
            options.inJustDecodeBounds = false;
            options.inSampleSize = a(i2, i3, a3, a4);
            bitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (bitmap != null && (bitmap.getWidth() > a3 || bitmap.getHeight() > a4)) {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, a3, a4, true);
                bitmap.recycle();
                bitmap = createScaledBitmap;
            }
        }
        if (bitmap == null) {
            return m.a(new com.bytedance.sdk.adnet.err.e(iVar));
        }
        final byte[] b = f.b(bitmap);
        a.a().a(a2, b);
        if (this.d != null) {
            this.b.post(new Runnable() {
                /* class com.bytedance.sdk.openadsdk.h.a.c.AnonymousClass2 */

                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.d != null) {
                        c.this.d.a(c.this.getUrl(), b);
                    }
                }
            });
        }
        return m.a(b, b.a(iVar));
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public void cancel() {
        super.cancel();
        synchronized (this.c) {
            this.d = null;
        }
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    protected void a(m<byte[]> mVar) {
        a aVar;
        synchronized (this.c) {
            aVar = this.d;
        }
        if (aVar != null) {
            aVar.a(mVar);
        }
    }

    static int a(int i2, int i3, int i4, int i5) {
        double min = Math.min(((double) i2) / ((double) i4), ((double) i3) / ((double) i5));
        float f2 = 1.0f;
        while (true) {
            float f3 = 2.0f * f2;
            if (((double) f3) > min) {
                return (int) f2;
            }
            f2 = f3;
        }
    }
}
