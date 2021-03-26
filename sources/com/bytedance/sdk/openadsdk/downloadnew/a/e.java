package com.bytedance.sdk.openadsdk.downloadnew.a;

import android.app.Activity;
import android.content.Context;
import android.os.Environment;
import android.view.View;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.h.h;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.utils.g;
import com.ss.android.a.a.b.b;
import com.ss.android.a.a.b.c;
import com.ss.android.a.a.b.d;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* compiled from: DMLibWebManager */
public class e implements a {
    private WeakReference<Context> a;
    private String b;
    private c c;
    private final l d;
    private String e;
    private com.ss.android.a.a.b.a f;
    private b g;

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void a(int i, a.AbstractC0050a aVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void a(Activity activity) {
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void a(View view) {
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void a(TTAppDownloadListener tTAppDownloadListener) {
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void a(TTAppDownloadListener tTAppDownloadListener, boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public boolean a(boolean z) {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public boolean b(boolean z) {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void c() {
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void g() {
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public boolean h() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public boolean i() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public boolean j() {
        return false;
    }

    public e(Context context, String str, l lVar, String str2) {
        this.a = new WeakReference<>(context);
        this.d = lVar;
        this.e = str2;
        this.b = str;
        this.c = com.bytedance.sdk.openadsdk.downloadnew.a.b.b.a(str, str2, lVar, null).a();
        this.f = com.bytedance.sdk.openadsdk.downloadnew.a.b.b.a(lVar).a();
        this.g = com.bytedance.sdk.openadsdk.downloadnew.a.b.b.a(lVar, this.e).a();
        a();
    }

    private Context k() {
        WeakReference<Context> weakReference = this.a;
        return (weakReference == null || weakReference.get() == null) ? p.a() : this.a.get();
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void a() {
        m();
    }

    private synchronized void l() {
        g.d().a(this.b, hashCode());
    }

    private synchronized void m() {
        if (n()) {
            g.d().e().a(k(), this.c.d(), this.c.u(), (d) null, hashCode());
        } else {
            g.d().a(k(), hashCode(), null, this.c);
        }
    }

    private boolean n() {
        h h = p.h();
        if (h != null) {
            return h.q();
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void b() {
        m();
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void d() {
        l();
        WeakReference<Context> weakReference = this.a;
        if (weakReference != null) {
            weakReference.clear();
            this.a = null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void e() {
        if (a(this.d)) {
            b(this.d);
        } else {
            p();
        }
    }

    private boolean a(l lVar) {
        if (lVar == null) {
            return true;
        }
        return !(lVar.L() == 0);
    }

    private void b(final l lVar) {
        if (lVar != null) {
            String Q = lVar.Q();
            String a2 = f.a(lVar);
            k U = lVar.U();
            String a3 = U != null ? U.a() : "";
            boolean z = lVar.T() == 4;
            com.bytedance.sdk.openadsdk.c.d.b(p.a(), lVar, this.e, "pop_up", o());
            g.a(lVar.ag(), Q, new g.a() {
                /* class com.bytedance.sdk.openadsdk.downloadnew.a.e.AnonymousClass1 */

                @Override // com.bytedance.sdk.openadsdk.utils.g.a
                public void b() {
                }

                @Override // com.bytedance.sdk.openadsdk.utils.g.a
                public void a() {
                    e.this.p();
                    com.bytedance.sdk.openadsdk.c.d.b(p.a(), lVar, e.this.e, "pop_up_download", e.this.o());
                }

                @Override // com.bytedance.sdk.openadsdk.utils.g.a
                public void c() {
                    com.bytedance.sdk.openadsdk.c.d.b(p.a(), lVar, e.this.e, "pop_up_cancel", e.this.o());
                }
            }, a2, a3, z);
        }
    }

    /* access modifiers changed from: private */
    public JSONObject o() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("download_type", 3);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    /* access modifiers changed from: private */
    public void p() {
        TTCustomController e2 = i.d().e();
        if (e2 != null && !e2.isCanUseWriteExternal()) {
            try {
                String str = g.a;
                String absolutePath = Environment.getDataDirectory().getAbsolutePath();
                if (str != null && !str.startsWith(absolutePath)) {
                    return;
                }
            } catch (Throwable unused) {
            }
        }
        if (n()) {
            g.d().e().a(k(), null, true, this.c, this.g, this.f, null, hashCode());
        } else {
            g.d().a(this.b, this.c.d(), 2, this.g, this.f);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void f() {
        a(0);
    }

    public void a(long j) {
        g.d().a(this.b, true);
    }
}
