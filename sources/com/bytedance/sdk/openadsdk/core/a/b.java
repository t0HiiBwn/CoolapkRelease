package com.bytedance.sdk.openadsdk.core.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.core.d.f;
import com.bytedance.sdk.openadsdk.core.d.j;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.core.z;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.ak;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ClickListener */
public class b extends c {
    protected Context c;
    protected final l d;
    protected final String e;
    protected final int f;
    protected WeakReference<View> g;
    protected WeakReference<View> h;
    protected f i;
    protected a j;
    protected TTNativeAd k;

    /* renamed from: l  reason: collision with root package name */
    protected c f1298l;
    protected boolean m = false;
    protected com.bytedance.sdk.openadsdk.downloadnew.core.a n;
    protected Map<String, Object> o;
    protected TTNativeExpressAd p;
    protected com.bytedance.sdk.openadsdk.core.nativeexpress.a q;
    protected boolean r = false;

    /* compiled from: ClickListener */
    public interface a {
        void a(View view, int i);
    }

    public void d(boolean z) {
        this.r = z;
    }

    public void a(com.bytedance.sdk.openadsdk.downloadnew.core.a aVar) {
        this.n = aVar;
    }

    public com.bytedance.sdk.openadsdk.downloadnew.core.a d() {
        return this.n;
    }

    public void a(com.bytedance.sdk.openadsdk.core.nativeexpress.a aVar) {
        this.q = aVar;
    }

    public void a(TTNativeAd tTNativeAd) {
        this.k = tTNativeAd;
    }

    public void a(TTNativeExpressAd tTNativeExpressAd) {
        this.p = tTNativeExpressAd;
    }

    public void e(boolean z) {
        this.m = z;
    }

    public void a(c cVar) {
        this.f1298l = cVar;
    }

    public b(Context context, l lVar, String str, int i2) {
        this.c = context;
        this.d = lVar;
        this.e = str;
        this.f = i2;
        this.o = new HashMap();
    }

    public void a(a aVar) {
        this.j = aVar;
    }

    public void a(View view) {
        this.g = new WeakReference<>(view);
    }

    public void b(View view) {
        this.h = new WeakReference<>(view);
    }

    public void a(Map<String, Object> map) {
        Map<String, Object> map2 = this.o;
        if (map2 == null) {
            this.o = map;
        } else {
            map2.putAll(map);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.a.c
    public void a(View view, int i2, int i3, int i4, int i5) {
        View view2;
        l lVar;
        if (!a(1)) {
            if (this.c == null) {
                this.c = p.a();
            }
            if (this.c != null) {
                long j2 = this.w;
                long j3 = this.x;
                WeakReference<View> weakReference = this.g;
                if (weakReference == null) {
                    view2 = null;
                } else {
                    view2 = weakReference.get();
                }
                WeakReference<View> weakReference2 = this.h;
                this.i = a(i2, i3, i4, i5, j2, j3, view2, weakReference2 == null ? null : weakReference2.get());
                a aVar = this.j;
                if (aVar != null) {
                    aVar.a(view, -1);
                }
                boolean C = this.d.C();
                boolean a2 = z.a(this.c, this.d, this.f, this.k, this.p, C ? this.e : aj.a(this.f), this.n, C, this.o, this.r, a(this.e));
                if (a2 || (lVar = this.d) == null || lVar.ai() == null || this.d.ai().c() != 2) {
                    d.a(this.c, "click", this.d, this.i, this.e, a2, this.o);
                }
            }
        }
    }

    public void e() {
        l lVar = this.d;
        if (lVar != null) {
            boolean C = lVar.C();
            z.a(this.c, this.d, this.f, this.k, this.p, C ? this.e : aj.a(this.f), this.n, C, this.o, this.r, a(this.e));
        }
    }

    private boolean a(String str) {
        if (!TextUtils.isEmpty(str) && str.equals("feed_video_middle_page")) {
            return true;
        }
        return false;
    }

    protected f a(int i2, int i3, int i4, int i5, long j2, long j3, View view, View view2) {
        return new f.a().e(i2).d(i3).c(i4).b(i5).b(j2).a(j3).b(ak.a(view)).a(ak.a(view2)).c(ak.c(view)).d(ak.c(view2)).f(this.y).g(this.z).h(this.A).a(this.C).a(i.d().b() ? 1 : 2).a();
    }

    protected boolean a(int i2) {
        if (this.q == null) {
            return false;
        }
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        WeakReference<View> weakReference = this.h;
        if (weakReference != null) {
            iArr = ak.a(weakReference.get());
            iArr2 = ak.c(this.h.get());
        }
        this.q.a(i2, new j.a().d(this.s).c(this.t).b(this.u).a(this.v).b(this.w).a(this.x).e(iArr[0]).f(iArr[1]).g(iArr2[0]).h(iArr2[1]).a());
        return true;
    }
}
