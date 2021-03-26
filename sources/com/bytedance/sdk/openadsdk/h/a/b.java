package com.bytedance.sdk.openadsdk.h.a;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import com.bytedance.sdk.adnet.core.l;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.openadsdk.h.a.a;
import com.bytedance.sdk.openadsdk.h.a.c;
import com.bytedance.sdk.openadsdk.j.e;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: GifLoader */
public class b {
    public static volatile int a;
    public static boolean b;
    private final l c;
    private final Handler d = new Handler(Looper.getMainLooper());
    private final Map<String, d> e = Collections.synchronizedMap(new HashMap());

    /* renamed from: com.bytedance.sdk.openadsdk.h.a.b$b  reason: collision with other inner class name */
    /* compiled from: GifLoader */
    public interface AbstractC0054b {
        void a();

        void a(c cVar);

        void a(String str, byte[] bArr);

        void b(c cVar);
    }

    public b(l lVar) {
        this.c = lVar;
    }

    public void a(String str, AbstractC0054b bVar, int i, int i2, boolean z) {
        b = z;
        a(str, bVar, i, i2, ImageView.ScaleType.CENTER_INSIDE);
    }

    public void a(final String str, final AbstractC0054b bVar, final int i, final int i2, final ImageView.ScaleType scaleType) {
        if (bVar != null) {
            this.d.post(new Runnable() {
                /* class com.bytedance.sdk.openadsdk.h.a.b.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    AbstractC0054b bVar = bVar;
                    if (bVar != null) {
                        bVar.a();
                    }
                }
            });
        }
        e.a(new Runnable() {
            /* class com.bytedance.sdk.openadsdk.h.a.b.AnonymousClass2 */

            @Override // java.lang.Runnable
            public void run() {
                b.this.b(str, bVar, i, i2, scaleType);
            }
        }, 5);
    }

    /* access modifiers changed from: private */
    public void b(final String str, final AbstractC0054b bVar, int i, int i2, ImageView.ScaleType scaleType) {
        final a.C0053a aVar;
        u.f("splashLoadAd", " GiftLoader doTask requestUrl " + str);
        String a2 = a.a().a(str, i, i2, scaleType);
        u.f("splashLoadAd", " GiftLoader doTask cacheKey " + a2);
        if (b) {
            aVar = a.a().b(a2);
        } else {
            aVar = a.a().a(a2);
        }
        if (aVar == null || aVar.a == null) {
            d dVar = this.e.get(a2);
            if (dVar != null) {
                dVar.a(bVar);
                return;
            }
            u.f("splashLoadAd", " GiftLoader doTask 缓存不存在 网络请求图片 requestUrl " + str);
            c a3 = a(str, i, i2, scaleType, a2);
            d dVar2 = new d(a3, bVar);
            this.c.a(a3);
            this.e.put(a2, dVar2);
            return;
        }
        final c cVar = new c(aVar.a, bVar, a2, str);
        this.d.post(new Runnable() {
            /* class com.bytedance.sdk.openadsdk.h.a.b.AnonymousClass3 */

            @Override // java.lang.Runnable
            public void run() {
                if (bVar != null) {
                    u.f("splashLoadAd", " GiftLoader doTask  缓存存在，直接返回缓存数据");
                    b.a = 1;
                    bVar.a(str, aVar.a);
                }
                AbstractC0054b bVar = bVar;
                if (bVar != null) {
                    bVar.a(cVar);
                }
            }
        });
    }

    private c a(final String str, int i, int i2, ImageView.ScaleType scaleType, final String str2) {
        return new c(str, new c.a() {
            /* class com.bytedance.sdk.openadsdk.h.a.b.AnonymousClass4 */

            @Override // com.bytedance.sdk.openadsdk.h.a.c.a
            public void a(String str, byte[] bArr) {
                d dVar = (d) b.this.e.get(str2);
                if (dVar != null) {
                    for (AbstractC0054b bVar : dVar.c) {
                        if (bVar != null) {
                            b.a = 2;
                            bVar.a(str, bArr);
                        }
                    }
                }
            }

            @Override // com.bytedance.sdk.adnet.core.m.a
            public void a(m<byte[]> mVar) {
                d dVar = (d) b.this.e.remove(str2);
                if (dVar != null) {
                    dVar.b = mVar;
                    dVar.e = (byte[]) mVar.a;
                    b.this.a(str2, str, dVar);
                }
            }

            @Override // com.bytedance.sdk.adnet.core.m.a
            public void b(m<byte[]> mVar) {
                d dVar = (d) b.this.e.remove(str2);
                if (dVar != null) {
                    dVar.b = mVar;
                    dVar.d = mVar.c;
                    b.this.a(str2, str, dVar);
                }
            }
        }, i, i2, scaleType, Bitmap.Config.RGB_565);
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2, d dVar) {
        if (dVar != null) {
            boolean a2 = dVar.a();
            if (dVar.c != null) {
                for (AbstractC0054b bVar : dVar.c) {
                    if (bVar != null) {
                        if (a2) {
                            bVar.a(new c(dVar.e, bVar, str, str2));
                        } else {
                            bVar.b(new c(dVar.d, bVar, str, str2));
                        }
                    }
                }
                dVar.c.clear();
            }
        }
    }

    /* compiled from: GifLoader */
    static class d {
        c a;
        m b;
        List<AbstractC0054b> c = new CopyOnWriteArrayList();
        VAdError d;
        byte[] e;

        public d(c cVar, AbstractC0054b bVar) {
            this.a = cVar;
            a(bVar);
        }

        void a(AbstractC0054b bVar) {
            if (bVar != null) {
                this.c.add(bVar);
            }
        }

        boolean a() {
            return this.d == null && this.e != null;
        }
    }

    /* compiled from: GifLoader */
    public static class c {
        private final byte[] a;
        private final AbstractC0054b b;
        private final String c;
        private final String d;
        private final VAdError e;

        public c(byte[] bArr, AbstractC0054b bVar, String str, String str2) {
            this.a = bArr;
            this.b = bVar;
            this.c = str;
            this.d = str2;
            this.e = null;
        }

        public c(VAdError vAdError, AbstractC0054b bVar, String str, String str2) {
            this.e = vAdError;
            this.b = bVar;
            this.c = str;
            this.d = str2;
            this.a = null;
        }
    }

    public static a a() {
        return new a();
    }

    /* compiled from: GifLoader */
    static class a implements AbstractC0054b {
        @Override // com.bytedance.sdk.openadsdk.h.a.b.AbstractC0054b
        public void a() {
        }

        @Override // com.bytedance.sdk.openadsdk.h.a.b.AbstractC0054b
        public void a(c cVar) {
        }

        @Override // com.bytedance.sdk.openadsdk.h.a.b.AbstractC0054b
        public void a(String str, byte[] bArr) {
        }

        @Override // com.bytedance.sdk.openadsdk.h.a.b.AbstractC0054b
        public void b(c cVar) {
        }

        a() {
        }
    }
}
