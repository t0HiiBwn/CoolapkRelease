package com.amap.api.mapcore2d;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import java.util.List;

/* compiled from: MemoryTileManager */
class ba {
    protected final a[] a;
    protected final int b;
    protected final int c;
    protected final a[] d;
    private boolean e = false;
    private long f = 0;
    private an g;
    private Paint h = null;
    private Path i = null;

    public ba(int i2, int i3, boolean z, long j, an anVar) {
        this.b = i2;
        this.c = i3;
        this.g = anVar;
        this.e = z;
        this.f = j * 1000000;
        if (i2 > 0) {
            this.a = new a[i2];
            this.d = new a[i3];
            return;
        }
        this.a = null;
        this.d = null;
    }

    protected int a(String str) {
        if (!(str == null || str.equals(""))) {
            for (int i2 = 0; i2 < this.b; i2++) {
                a[] aVarArr = this.a;
                if (aVarArr[i2] != null && aVarArr[i2].b != null && this.a[i2].b.equals(str)) {
                    if (!this.a[i2].c) {
                        return -1;
                    } else {
                        if (this.e && d() - this.a[i2].f > this.f) {
                            this.a[i2].c = false;
                            return -1;
                        } else if (this.a[i2].a == null) {
                            return -1;
                        } else {
                            this.a[i2].d = d();
                            return i2;
                        }
                    }
                }
            }
        }
        return -1;
    }

    protected Bitmap a(int i2) {
        if (i2 < 0 || i2 >= this.b) {
            return null;
        }
        a[] aVarArr = this.a;
        if (aVarArr[i2] == null) {
            return null;
        }
        return aVarArr[i2].a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x008b, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x008c, code lost:
        com.amap.api.mapcore2d.cm.a(r6, "BitmapManager", "setBitmapData");
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:34:0x0066, B:40:0x007f] */
    /* JADX WARNING: Removed duplicated region for block: B:38:? A[ExcHandler: OutOfMemoryError (unused java.lang.OutOfMemoryError), SYNTHETIC, Splitter:B:34:0x0066] */
    protected synchronized int a(byte[] bArr, byte[] bArr2, boolean z, List<bx> list, String str) {
        int i2;
        Throwable th;
        int i3;
        int i4 = -1;
        if (bArr == null && bArr2 == null && list == null) {
            return -1;
        }
        try {
            i2 = b();
            if (i2 < 0) {
                try {
                    i2 = a();
                } catch (Throwable th2) {
                    th = th2;
                    i4 = i3;
                }
            }
            if (i2 < 0) {
                return -1;
            }
            a[] aVarArr = this.a;
            if (aVarArr == null) {
                return -1;
            }
            if (!(aVarArr[i2] == null || aVarArr[i2].a == null || this.a[i2].a.isRecycled())) {
                this.a[i2].a.recycle();
                this.a[i2].a = null;
            }
            if (this.a[i2].g != null) {
                this.a[i2].g.clear();
                this.a[i2].g = null;
            }
            if (z && bArr != null) {
                try {
                    this.a[i2].a = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                } catch (OutOfMemoryError unused) {
                } catch (Throwable th3) {
                    cm.a(th3, "BitmapManager", "setBitmapData");
                }
            } else if (bArr2 != null) {
                this.a[i2].a = BitmapFactory.decodeByteArray(bArr2, 0, bArr2.length);
            }
            if (list != null) {
                this.a[i2].a = Bitmap.createBitmap(this.g.a.a, this.g.a.a, Bitmap.Config.ARGB_4444);
                a(this.a[i2].a, list);
            }
            if (this.a[i2].a == null && this.a[i2].g == null) {
                return -1;
            }
            a[] aVarArr2 = this.a;
            if (aVarArr2[i2] != null) {
                aVarArr2[i2].c = true;
                this.a[i2].b = str;
                this.a[i2].d = d();
                if (this.e) {
                    this.a[i2].f = d();
                }
            }
            return i2;
        } catch (Throwable th4) {
            th = th4;
            cm.a(th, "BitmapManager", "setBitmapData");
            i2 = i4;
            return i2;
        }
    }

    private long d() {
        return System.nanoTime();
    }

    protected int a() {
        for (int i2 = 0; i2 < this.c; i2++) {
            this.d[i2] = null;
        }
        for (int i3 = 0; i3 < this.b; i3++) {
            a aVar = this.a[i3];
            int i4 = 0;
            while (true) {
                if (i4 >= this.c) {
                    break;
                }
                a[] aVarArr = this.d;
                if (aVarArr[i4] == null) {
                    aVarArr[i4] = aVar;
                    break;
                }
                if (aVarArr[i4].d > aVar.d) {
                    a[] aVarArr2 = this.d;
                    a aVar2 = aVarArr2[i4];
                    aVarArr2[i4] = aVar;
                    aVar = aVar2;
                }
                i4++;
            }
        }
        int i5 = -1;
        for (int i6 = 0; i6 < this.c; i6++) {
            a[] aVarArr3 = this.d;
            if (aVarArr3[i6] != null) {
                aVarArr3[i6].c = false;
                if (i5 < 0) {
                    i5 = this.d[i6].e;
                }
            }
        }
        return i5;
    }

    protected int b() {
        int i2 = -1;
        for (int i3 = 0; i3 < this.b; i3++) {
            a[] aVarArr = this.a;
            if (aVarArr[i3] == null) {
                aVarArr[i3] = new a();
                this.a[i3].e = i3;
                return i3;
            }
            if (!aVarArr[i3].c && i2 < 0) {
                i2 = i3;
            }
        }
        return i2;
    }

    protected void c() {
        for (int i2 = 0; i2 < this.b; i2++) {
            a[] aVarArr = this.a;
            if (aVarArr[i2] != null) {
                if (aVarArr[i2].a != null && !this.a[i2].a.isRecycled()) {
                    this.a[i2].a.recycle();
                }
                this.a[i2].a = null;
            }
        }
    }

    private void a(Bitmap bitmap, final List<bx> list) {
        AnonymousClass1 r0 = new j() {
            /* class com.amap.api.mapcore2d.ba.AnonymousClass1 */

            @Override // com.amap.api.mapcore2d.j
            public void a(Canvas canvas) {
                if (ba.this.h == null) {
                    ba.this.h = new Paint();
                    ba.this.h.setStyle(Paint.Style.STROKE);
                    ba.this.h.setDither(true);
                    ba.this.h.setAntiAlias(true);
                    ba.this.h.setStrokeJoin(Paint.Join.ROUND);
                    ba.this.h.setStrokeCap(Paint.Cap.ROUND);
                }
                if (ba.this.i == null) {
                    ba.this.i = new Path();
                }
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    bx bxVar = (bx) list.get(i);
                    if (bxVar != null) {
                        ba.this.h.setStrokeWidth(3.0f);
                        int b2 = bxVar.b();
                        if (b2 == 1) {
                            ba.this.h.setColor(-65536);
                        } else if (b2 == 2) {
                            ba.this.h.setColor(-256);
                        } else if (b2 == 3) {
                            ba.this.h.setColor(-16711936);
                        }
                        List<PointF> a2 = bxVar.a();
                        int size2 = a2.size();
                        boolean z = true;
                        for (int i2 = 0; i2 < size2; i2++) {
                            PointF pointF = a2.get(i2);
                            if (pointF != null) {
                                if (z) {
                                    ba.this.i.moveTo(pointF.x, pointF.y);
                                    z = false;
                                } else {
                                    ba.this.i.lineTo(pointF.x, pointF.y);
                                }
                            }
                        }
                        canvas.drawPath(ba.this.i, ba.this.h);
                        ba.this.i.reset();
                    }
                }
            }
        };
        i iVar = new i(null);
        iVar.a(bitmap);
        iVar.a(r0);
    }

    /* compiled from: MemoryTileManager */
    private class a {
        Bitmap a = null;
        String b = "";
        boolean c = false;
        long d = 0;
        int e = -1;
        long f = 0;
        List<bx> g = null;

        public a() {
        }
    }
}
