package com.bytedance.sdk.openadsdk.core.dynamic.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.openadsdk.c.p;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.dynamic.b.f;
import com.bytedance.sdk.openadsdk.core.dynamic.d.b;
import com.bytedance.sdk.openadsdk.core.dynamic.d.c;
import com.bytedance.sdk.openadsdk.core.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.openadsdk.core.dynamic.dynamicview.DynamicBaseWidgetImp;
import com.bytedance.sdk.openadsdk.core.dynamic.dynamicview.DynamicRootView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.j;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import com.bytedance.sdk.openadsdk.utils.aj;
import java.util.List;
import org.json.JSONObject;

/* compiled from: DynamicClient */
public class a implements b {
    private String a;
    private String b;
    private int c;
    private String d;
    private l e;
    private JSONObject f;
    private DynamicRootView g;
    private com.bytedance.sdk.openadsdk.core.dynamic.c.a h = new com.bytedance.sdk.openadsdk.core.dynamic.c.a(this.i);
    private Context i;

    @Override // com.bytedance.sdk.openadsdk.core.dynamic.d.b
    public b a(p pVar) {
        return this;
    }

    public b a(SSWebView sSWebView) {
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.dynamic.d.b
    public b b(SSWebView sSWebView) {
        return this;
    }

    public a(Context context) {
        this.i = context;
        this.g = new DynamicRootView(context);
    }

    @Override // com.bytedance.sdk.openadsdk.core.dynamic.d.b
    public b a(j jVar) {
        this.g.setRenderListener(jVar);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.dynamic.d.b
    public b a(l lVar) {
        this.e = lVar;
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.dynamic.d.b
    public b a(String str) {
        this.a = str;
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.dynamic.d.b
    public b b(String str) {
        this.b = str;
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.dynamic.d.b
    public b a(int i2) {
        this.c = i2;
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.dynamic.d.b
    public b c(String str) {
        this.d = str;
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.dynamic.d.b
    public b a(JSONObject jSONObject) {
        this.f = jSONObject;
        return this;
    }

    public void a() {
        this.h.a(new c() {
            /* class com.bytedance.sdk.openadsdk.core.dynamic.a.a.AnonymousClass1 */

            @Override // com.bytedance.sdk.openadsdk.core.dynamic.d.c
            public void a(final f fVar) {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    /* class com.bytedance.sdk.openadsdk.core.dynamic.a.a.AnonymousClass1.AnonymousClass1 */

                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.a(fVar);
                    }
                });
            }
        });
        this.h.b(c());
    }

    /* access modifiers changed from: private */
    public void a(f fVar) {
        if (fVar == null) {
            this.g.b();
            return;
        }
        try {
            DynamicBaseWidgetImp dynamicBaseWidgetImp = new DynamicBaseWidgetImp(this.i, this.g, fVar);
            a(fVar, dynamicBaseWidgetImp);
            this.g.setDynamicBaseWidget(dynamicBaseWidgetImp);
            this.g.a();
        } catch (Exception unused) {
            this.g.b();
        }
    }

    private void a(f fVar, DynamicBaseWidget dynamicBaseWidget) {
        List<f> f2;
        if (!(fVar == null || dynamicBaseWidget == null || (f2 = fVar.f()) == null || f2.size() <= 0)) {
            for (f fVar2 : fVar.f()) {
                if (fVar2 != null) {
                    DynamicBaseWidget a2 = b.a(this.i, this.g, fVar2);
                    a(fVar2, a2);
                    dynamicBaseWidget.a(a2);
                }
            }
        }
    }

    public DynamicRootView b() {
        return this.g;
    }

    private String c() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = this.f;
            if (jSONObject2 != null) {
                jSONObject2.put("setting", d());
            }
            jSONObject.put("templateInfo", this.f);
            jSONObject.put("adInfo", new com.bytedance.sdk.openadsdk.core.dynamic.b.a(this.e).a());
            jSONObject.put("appInfo", new com.bytedance.sdk.openadsdk.core.dynamic.b.b().a());
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    private JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        if (com.bytedance.sdk.openadsdk.core.p.h() != null) {
            try {
                int d2 = aj.d(this.b);
                int g2 = com.bytedance.sdk.openadsdk.core.p.h().g(String.valueOf(d2));
                boolean b2 = com.bytedance.sdk.openadsdk.core.p.h().b(String.valueOf(d2));
                jSONObject.put("voice_control", com.bytedance.sdk.openadsdk.core.p.h().b(d2));
                jSONObject.put("rv_skip_time", g2);
                jSONObject.put("fv_skip_show", b2);
                l lVar = this.e;
                int i2 = 0;
                jSONObject.put("show_dislike", lVar != null && lVar.aD());
                l lVar2 = this.e;
                if (lVar2 != null) {
                    i2 = lVar2.l();
                }
                jSONObject.put("video_adaptation", i2);
            } catch (Exception unused) {
            }
        }
        return jSONObject;
    }
}
