package com.bytedance.sdk.openadsdk.e.a;

import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.e.a.d;
import java.util.ArrayList;
import java.util.List;

/* compiled from: JsBridge2 */
public class q {
    static v a;
    private final a b;
    private final WebView c;
    private final j d;
    private final List<n> e;
    private o f;
    private volatile boolean g = false;

    public static j a(WebView webView) {
        return new j(webView);
    }

    public <T> void a(String str, T t) {
        a();
        this.b.a(str, (String) t);
    }

    public q a(String str, e<?, ?> eVar) {
        return a(str, (String) null, eVar);
    }

    public q a(String str, String str2, e<?, ?> eVar) {
        a();
        this.b.g.a(str, eVar);
        o oVar = this.f;
        if (oVar != null) {
            oVar.a(str);
        }
        return this;
    }

    public q a(String str, d.b bVar) {
        return a(str, (String) null, bVar);
    }

    public q a(String str, String str2, d.b bVar) {
        a();
        this.b.g.a(str, bVar);
        o oVar = this.f;
        if (oVar != null) {
            oVar.a(str);
        }
        return this;
    }

    q(j jVar) {
        v vVar;
        ArrayList arrayList = new ArrayList();
        this.e = arrayList;
        this.d = jVar;
        u a2 = (!jVar.h || (vVar = a) == null) ? null : vVar.a(jVar.k);
        if (jVar.a != null) {
            y yVar = new y();
            this.b = yVar;
            yVar.a(jVar, a2);
        } else {
            a aVar = jVar.b;
            this.b = aVar;
            aVar.a(jVar, a2);
        }
        this.c = jVar.a;
        arrayList.add(jVar.j);
        i.a(jVar.f);
        x.a(jVar.g);
    }

    private void a() {
        if (this.g) {
            i.a(new IllegalStateException("JsBridge2 is already released!!!"));
        }
    }
}
