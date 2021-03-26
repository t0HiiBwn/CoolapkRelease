package com.bytedance.sdk.openadsdk.core.dynamic.c;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.bytedance.sdk.openadsdk.core.aa;
import com.bytedance.sdk.openadsdk.core.dynamic.b.f;
import com.bytedance.sdk.openadsdk.core.dynamic.d.c;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.t;
import com.bytedance.sdk.openadsdk.utils.u;
import org.json.JSONObject;

/* compiled from: TemplateToModelParser */
public class a {
    private static String e;
    private Context a;
    private SSWebView b = new SSWebView(this.a);
    private String c;
    private c d;

    public a(Context context) {
        this.a = context;
        if (Build.VERSION.SDK_INT >= 19) {
            this.b.addJavascriptInterface(new C0041a(), "JS_DYNAMIC_LAYOUT_OBJ");
        }
        this.b.loadUrl("about:blank");
        a();
    }

    public static void a(String str) {
        e = str;
    }

    private void a() {
        String c2 = c();
        if (!TextUtils.isEmpty(c2)) {
            t.a(this.b, c2);
        }
    }

    public void a(c cVar) {
        this.d = cVar;
    }

    public void b(String str) {
        c cVar;
        this.c = str;
        if (TextUtils.isEmpty(e) && (cVar = this.d) != null) {
            cVar.a(null);
            d();
        }
        b();
    }

    private void b() {
        t.a(this.b, "javascript:var res = getLayoutInfo(" + this.c + ");window.JS_DYNAMIC_LAYOUT_OBJ.calculateResult(JSON.stringify(res));");
    }

    private static String c() {
        if (TextUtils.isEmpty(e)) {
            return null;
        }
        return "javascript:" + ("var global = Function('return this')();global.jsCoreGlobal = {width:" + ak.b(p.a(), (float) ak.c(p.a())) + ",height:" + ak.b(p.a(), (float) ak.d(p.a())) + ",os:'Android'};global.systemFontSizeRatioNative = 1.2;") + ("(function () {var JS_TTDYNAMIC_URL = '" + e + "';var xhrObj = new XMLHttpRequest();xhrObj.open('GET', JS_TTDYNAMIC_URL, false);xhrObj.send('');var se = document.createElement('script');se.type = 'text/javascript';se.text = xhrObj.responseText;document.getElementsByTagName('head')[0].appendChild(se);})();");
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.dynamic.c.a$a  reason: collision with other inner class name */
    /* compiled from: TemplateToModelParser */
    private class C0041a {
        @JavascriptInterface
        public double systemFontSizeRatioNative() {
            return 1.2d;
        }

        private C0041a() {
        }

        @JavascriptInterface
        public String jsCoreGlobal() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("width", ak.b(p.a(), (float) ak.c(a.this.a)));
                jSONObject.put("height", ak.b(p.a(), (float) ak.d(a.this.a)));
                jSONObject.put("os", "Android");
            } catch (Exception unused) {
            }
            return jSONObject.toString();
        }

        @JavascriptInterface
        public String getDomSizeFromNative(String str, String str2, String str3, boolean z, boolean z2, int i) {
            double d;
            double d2;
            int i2;
            JSONObject jSONObject = new JSONObject();
            u.f("DynamicBaseWidget", "getDomSizeFromNative String brickType==" + str2);
            u.f("DynamicBaseWidget", "getDomSizeFromNative String str==" + str);
            try {
                if (str.startsWith("<svg") || "dislike".equals(str2)) {
                    jSONObject.put("width", 10.0d);
                    jSONObject.put("height", 10.0d);
                    return jSONObject.toString();
                } else if ("logo".equals(str2)) {
                    jSONObject.put("width", "union".equals(str) ? 10.0d : 20.0d);
                    jSONObject.put("height", 10.0d);
                    return jSONObject.toString();
                } else {
                    JSONObject jSONObject2 = new JSONObject(str3);
                    int length = str.length();
                    float optDouble = (float) jSONObject2.optDouble("fontSize");
                    float optDouble2 = (float) jSONObject2.optDouble("letterSpacing");
                    float optDouble3 = (float) jSONObject2.optDouble("lineHeight");
                    float optDouble4 = (float) jSONObject2.optDouble("maxWidth");
                    double d3 = (double) ((((float) length) * (optDouble + optDouble2)) - optDouble2);
                    u.f("DynamicBaseWidget", "getDomSizeFromNative letterSpacing==" + optDouble2 + ",lineHeight==" + optDouble3 + ",maxWidth ==" + optDouble4 + ",totalStrLength" + d3);
                    if (z) {
                        d2 = (double) optDouble4;
                        int i3 = ((int) (d3 / d2)) + 1;
                        if (!z2 || i3 < (i2 = i)) {
                            i2 = i3;
                        }
                        d = ((double) (optDouble3 * optDouble * ((float) i2))) * 1.2d;
                    } else {
                        d = ((double) (optDouble3 * optDouble)) * 1.2d;
                        double d4 = (double) optDouble4;
                        if (d3 > d4) {
                            d3 = d4;
                        }
                        d2 = d3;
                    }
                    jSONObject.put("width", d2);
                    jSONObject.put("height", d);
                    u.f("DynamicBaseWidget", "getDomSizeFromNative fontSize==" + optDouble + ",width==" + d2 + ",height ==" + d);
                    return jSONObject.toString();
                }
            } catch (Exception unused) {
            }
        }

        @JavascriptInterface
        public void calculateResult(String str) {
            a.this.c(str);
        }
    }

    /* access modifiers changed from: private */
    public void c(String str) {
        f fVar = new f();
        try {
            f.a(new JSONObject(str), fVar);
        } catch (Exception unused) {
            fVar = null;
        }
        c cVar = this.d;
        if (cVar != null) {
            cVar.a(fVar);
        }
        d();
    }

    private void d() {
        aa.a(this.a, this.b);
        aa.a(this.b);
        this.b = null;
    }
}
