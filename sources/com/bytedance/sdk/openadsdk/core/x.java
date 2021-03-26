package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.activity.base.TTMiddlePageActivity;
import com.bytedance.sdk.openadsdk.c.p;
import com.bytedance.sdk.openadsdk.core.d.j;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.d.m;
import com.bytedance.sdk.openadsdk.core.d.o;
import com.bytedance.sdk.openadsdk.core.nativeexpress.g;
import com.bytedance.sdk.openadsdk.core.nativeexpress.j;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import com.bytedance.sdk.openadsdk.d.b;
import com.bytedance.sdk.openadsdk.d.c;
import com.bytedance.sdk.openadsdk.d.d;
import com.bytedance.sdk.openadsdk.e.a.q;
import com.bytedance.sdk.openadsdk.e.b.f;
import com.bytedance.sdk.openadsdk.e.b.i;
import com.bytedance.sdk.openadsdk.f.e;
import com.bytedance.sdk.openadsdk.f.h;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.al;
import com.bytedance.sdk.openadsdk.utils.r;
import com.bytedance.sdk.openadsdk.utils.t;
import com.bytedance.sdk.openadsdk.utils.u;
import java.lang.ref.WeakReference;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: TTAndroidObject */
public class x implements b, al.a {
    private static final Map<String, Boolean> f;
    private boolean A = true;
    private List<l> B;
    private HashMap<String, j> C;
    private boolean D = false;
    private boolean E = false;
    private p F;
    private q G;
    private String H;
    protected Map<String, Object> a;
    boolean b;
    boolean c = false;
    private WeakReference<SSWebView> d;
    private al e;
    private WeakReference<Context> g;
    private c h;
    private String i;
    private WeakReference<View> j;
    private String k;
    private int l;
    private String m;
    private l n;
    private boolean o = true;
    private j p;
    private g q;
    private JSONObject r;
    private d s;
    private com.bytedance.sdk.openadsdk.f.a t;
    private e u;
    private com.bytedance.sdk.openadsdk.f.d v;
    private JSONObject w;
    private com.bytedance.sdk.openadsdk.core.a.d x;
    private com.bytedance.sdk.openadsdk.f.b y;
    private h z;

    /* compiled from: TTAndroidObject */
    public static class a {
        public String a;
        public String b;
        public String c;
        public JSONObject d;
        public int e;
    }

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        f = concurrentHashMap;
        concurrentHashMap.put("log_event", Boolean.TRUE);
        concurrentHashMap.put("private", Boolean.TRUE);
        concurrentHashMap.put("dispatch_message", Boolean.TRUE);
        concurrentHashMap.put("custom_event", Boolean.TRUE);
        concurrentHashMap.put("log_event_v3", Boolean.TRUE);
    }

    public x(Context context) {
        this.g = new WeakReference<>(context);
        this.e = new al(Looper.getMainLooper(), this);
    }

    public x a(String str) {
        this.H = str;
        return this;
    }

    public x a(SSWebView sSWebView) {
        q b2 = q.a(sSWebView).a("ToutiaoJSBridge").a(new com.bytedance.sdk.openadsdk.e.a.l() {
            /* class com.bytedance.sdk.openadsdk.core.x.AnonymousClass1 */

            @Override // com.bytedance.sdk.openadsdk.e.a.l
            public <T> T a(String str, Type type) {
                return null;
            }

            @Override // com.bytedance.sdk.openadsdk.e.a.l
            public <T> String a(T t) {
                return null;
            }
        }).a(i.d().v()).b(true).a().b();
        this.G = b2;
        f.a(b2, this);
        com.bytedance.sdk.openadsdk.e.b.b.a(this.G, this);
        com.bytedance.sdk.openadsdk.e.b.h.a(this.G);
        com.bytedance.sdk.openadsdk.e.b.e.a(this.G);
        com.bytedance.sdk.openadsdk.e.b.g.a(this.G, sSWebView);
        com.bytedance.sdk.openadsdk.e.b.c.a(this.G, this);
        com.bytedance.sdk.openadsdk.e.b.d.a(this.G, this);
        i.a(this.G, this);
        com.bytedance.sdk.openadsdk.e.b.a.a(this.G, this);
        return this;
    }

    public q a() {
        return this.G;
    }

    private WebView p() {
        WeakReference<SSWebView> weakReference = this.d;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public x b(SSWebView sSWebView) {
        this.d = new WeakReference<>(sSWebView);
        return this;
    }

    public x a(p pVar) {
        this.F = pVar;
        return this;
    }

    public x a(boolean z2) {
        this.b = z2;
        return this;
    }

    public x b(boolean z2) {
        this.E = z2;
        return this;
    }

    public x b(String str) {
        this.i = str;
        return this;
    }

    public x a(View view) {
        this.j = new WeakReference<>(view);
        return this;
    }

    private JSONObject q() {
        try {
            View view = this.j.get();
            SSWebView sSWebView = this.d.get();
            if (view != null) {
                if (sSWebView != null) {
                    int[] b2 = ak.b(view);
                    int[] b3 = ak.b((View) sSWebView);
                    if (b2 != null) {
                        if (b3 != null) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("x", ak.b(p.a(), (float) (b2[0] - b3[0])));
                            jSONObject.put("y", ak.b(p.a(), (float) (b2[1] - b3[1])));
                            jSONObject.put("w", ak.b(p.a(), (float) view.getWidth()));
                            jSONObject.put("h", ak.b(p.a(), (float) view.getHeight()));
                            jSONObject.put("isExist", ak.e(view));
                            return jSONObject;
                        }
                    }
                    u.f("TTAndroidObject", "setCloseButtonInfo error position or webViewPosition is null");
                    return null;
                }
            }
            u.f("TTAndroidObject", "setCloseButtonInfo error closeButton is null");
            return null;
        } catch (Throwable th) {
            u.a("TTAndroidObject", "setCloseButtonInfo error", th);
            return null;
        }
    }

    public x a(l lVar) {
        this.n = lVar;
        return this;
    }

    public x a(com.bytedance.sdk.openadsdk.f.b bVar) {
        this.y = bVar;
        return this;
    }

    public void b() {
        WeakReference<Context> weakReference = this.g;
        if (weakReference != null && weakReference.get() != null && (this.g.get() instanceof TTMiddlePageActivity)) {
            ((Activity) this.g.get()).finish();
        }
    }

    public x a(h hVar) {
        this.z = hVar;
        return this;
    }

    public l c() {
        return this.n;
    }

    public boolean d() {
        l lVar = this.n;
        return lVar != null && lVar.f();
    }

    public x c(String str) {
        this.k = str;
        return this;
    }

    public x a(int i2) {
        this.l = i2;
        return this;
    }

    public x d(String str) {
        this.m = str;
        return this;
    }

    public x a(j jVar) {
        this.p = jVar;
        return this;
    }

    public x a(g gVar) {
        this.q = gVar;
        return this;
    }

    public x a(d dVar) {
        this.s = dVar;
        return this;
    }

    public x a(com.bytedance.sdk.openadsdk.core.a.d dVar) {
        this.x = dVar;
        return this;
    }

    public x c(boolean z2) {
        this.A = z2;
        return this;
    }

    public x a(JSONObject jSONObject) {
        this.r = jSONObject;
        return this;
    }

    public x b(JSONObject jSONObject) {
        this.w = jSONObject;
        return this;
    }

    public x a(Map<String, Object> map) {
        this.a = map;
        return this;
    }

    public x a(com.bytedance.sdk.openadsdk.f.a aVar) {
        this.t = aVar;
        return this;
    }

    public x a(e eVar) {
        this.u = eVar;
        return this;
    }

    public x a(com.bytedance.sdk.openadsdk.f.d dVar) {
        this.v = dVar;
        return this;
    }

    public x a(List<l> list) {
        this.B = list;
        return this;
    }

    public boolean e() {
        return this.c;
    }

    private List<String> r() {
        return Arrays.asList("appInfo", "adInfo", "getTemplateInfo", "getTeMaiAds");
    }

    private void a(JSONObject jSONObject, int i2) throws Exception {
        JSONArray jSONArray = new JSONArray();
        for (String str : r()) {
            jSONArray.put(str);
        }
        jSONObject.put("appName", com.bytedance.sdk.openadsdk.a.a.a());
        jSONObject.put("innerAppName", com.bytedance.sdk.openadsdk.a.a.e());
        jSONObject.put("aid", com.bytedance.sdk.openadsdk.a.a.b());
        jSONObject.put("sdkEdition", com.bytedance.sdk.openadsdk.a.a.c());
        jSONObject.put("appVersion", com.bytedance.sdk.openadsdk.a.a.d());
        jSONObject.put("netType", com.bytedance.sdk.openadsdk.a.a.f());
        jSONObject.put("supportList", jSONArray);
        jSONObject.put("deviceId", com.bytedance.sdk.openadsdk.a.a.a(p.a()));
    }

    private void d(JSONObject jSONObject) throws Exception {
        if (!TextUtils.isEmpty(this.i)) {
            jSONObject.put("cid", this.i);
        }
        if (!TextUtils.isEmpty(this.k)) {
            jSONObject.put("log_extra", this.k);
        }
        if (!TextUtils.isEmpty(this.m)) {
            jSONObject.put("download_url", this.m);
        }
    }

    private void e(JSONObject jSONObject) throws Exception {
        l lVar = this.n;
        if (lVar != null && !TextUtils.isEmpty(lVar.j())) {
            jSONObject.put("playable_style", this.n.j());
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x02bd, code lost:
        if (r5 != null) goto L_0x02fb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x02f9, code lost:
        if (r5 != null) goto L_0x02fb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x02fb, code lost:
        r3 = r5;
     */
    public JSONObject a(a aVar, int i2) throws Exception {
        char c2;
        Context context;
        JSONObject jSONObject;
        WeakReference<Context> weakReference;
        Context context2;
        Context context3;
        if (!"call".equals(aVar.a)) {
            return null;
        }
        if (i.d().v()) {
            StringBuilder sb = new StringBuilder();
            sb.append("[JSB-REQ] version:");
            sb.append(i2);
            sb.append(" method:");
            sb.append(aVar.c);
            sb.append(" params=");
            sb.append(aVar.d != null ? aVar.d.toString() : "");
            Log.d("TTAndroidObject", sb.toString());
        }
        JSONObject jSONObject2 = new JSONObject();
        String str = aVar.c;
        str.hashCode();
        boolean z2 = false;
        int i3 = -1;
        switch (str.hashCode()) {
            case -2036781162:
                if (str.equals("subscribe_app_ad")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case -1423303823:
                if (str.equals("adInfo")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case -1330994877:
                if (str.equals("pauseWebView")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case -1169135450:
                if (str.equals("changeVideoState")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case -844321441:
                if (str.equals("webview_time_track")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case -800853518:
                if (str.equals("clickEvent")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            case -794273169:
                if (str.equals("appInfo")) {
                    c2 = 6;
                    break;
                }
                c2 = 65535;
                break;
            case -715147645:
                if (str.equals("getScreenSize")) {
                    c2 = 7;
                    break;
                }
                c2 = 65535;
                break;
            case -489318846:
                if (str.equals("getMaterialMeta")) {
                    c2 = '\b';
                    break;
                }
                c2 = 65535;
                break;
            case -278382602:
                if (str.equals("send_temai_product_ids")) {
                    c2 = '\t';
                    break;
                }
                c2 = 65535;
                break;
            case -173752734:
                if (str.equals("getTeMaiAds")) {
                    c2 = '\n';
                    break;
                }
                c2 = 65535;
                break;
            case 27837080:
                if (str.equals("download_app_ad")) {
                    c2 = 11;
                    break;
                }
                c2 = 65535;
                break;
            case 105049135:
                if (str.equals("unsubscribe_app_ad")) {
                    c2 = '\f';
                    break;
                }
                c2 = 65535;
                break;
            case 352242576:
                if (str.equals("getDownloadStatus")) {
                    c2 = '\r';
                    break;
                }
                c2 = 65535;
                break;
            case 399543522:
                if (str.equals("getCloseButtonInfo")) {
                    c2 = 14;
                    break;
                }
                c2 = 65535;
                break;
            case 402955465:
                if (str.equals("isViewable")) {
                    c2 = 15;
                    break;
                }
                c2 = 65535;
                break;
            case 442647767:
                if (str.equals("sendReward")) {
                    c2 = 16;
                    break;
                }
                c2 = 65535;
                break;
            case 571273292:
                if (str.equals("dynamicTrack")) {
                    c2 = 17;
                    break;
                }
                c2 = 65535;
                break;
            case 650209982:
                if (str.equals("getTemplateInfo")) {
                    c2 = 18;
                    break;
                }
                c2 = 65535;
                break;
            case 672928467:
                if (str.equals("cancel_download_app_ad")) {
                    c2 = 19;
                    break;
                }
                c2 = 65535;
                break;
            case 711635577:
                if (str.equals("getCurrentVideoState")) {
                    c2 = 20;
                    break;
                }
                c2 = 65535;
                break;
            case 885131792:
                if (str.equals("getVolume")) {
                    c2 = 21;
                    break;
                }
                c2 = 65535;
                break;
            case 1107374321:
                if (str.equals("pauseWebViewTimers")) {
                    c2 = 22;
                    break;
                }
                c2 = 65535;
                break;
            case 1151744482:
                if (str.equals("muteVideo")) {
                    c2 = 23;
                    break;
                }
                c2 = 65535;
                break;
            case 1237100796:
                if (str.equals("renderDidFinish")) {
                    c2 = 24;
                    break;
                }
                c2 = 65535;
                break;
            case 1532142616:
                if (str.equals("removeLoading")) {
                    c2 = 25;
                    break;
                }
                c2 = 65535;
                break;
            case 1634511418:
                if (str.equals("endcard_load")) {
                    c2 = 26;
                    break;
                }
                c2 = 65535;
                break;
            case 1713585602:
                if (str.equals("getNetworkData")) {
                    c2 = 27;
                    break;
                }
                c2 = 65535;
                break;
            case 1731806400:
                if (str.equals("playable_style")) {
                    c2 = 28;
                    break;
                }
                c2 = 65535;
                break;
            case 2086000188:
                if (str.equals("skipVideo")) {
                    c2 = 29;
                    break;
                }
                c2 = 65535;
                break;
            case 2105008900:
                if (str.equals("landscape_click")) {
                    c2 = 30;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
                y();
                WeakReference<Context> weakReference2 = this.g;
                if (!(weakReference2 == null || (context = weakReference2.get()) == null)) {
                    this.h.a(context, aVar.d, this.k, this.l, this.o);
                    break;
                }
            case 1:
                d(jSONObject2);
                break;
            case 2:
                s();
                break;
            case 3:
                i(aVar.d);
                break;
            case 4:
                f(aVar.d);
                break;
            case 5:
                k(aVar.d);
                break;
            case 6:
                a(jSONObject2, aVar.e);
                break;
            case 7:
                com.bytedance.sdk.openadsdk.f.a aVar2 = this.t;
                if (aVar2 != null) {
                    int b2 = aVar2.b();
                    int a2 = this.t.a();
                    jSONObject2.put("width", b2);
                    jSONObject2.put("height", a2);
                    break;
                }
                break;
            case '\b':
                o(jSONObject2);
                break;
            case '\t':
                n(aVar.d);
                break;
            case '\n':
                jSONObject = this.w;
                break;
            case 11:
                com.bytedance.sdk.openadsdk.core.a.d dVar = this.x;
                if (dVar == null) {
                    if (!(this.h == null || (weakReference = this.g) == null || (context2 = weakReference.get()) == null)) {
                        this.h.a(context2, aVar.d);
                        break;
                    }
                } else {
                    dVar.a(this.A);
                    break;
                }
            case '\f':
                c cVar = this.h;
                if (cVar != null) {
                    cVar.a(aVar.d);
                    break;
                }
                break;
            case '\r':
                jSONObject2 = com.bytedance.sdk.openadsdk.e.b.e.a(aVar.d);
                break;
            case 14:
                jSONObject = q();
                break;
            case 15:
                jSONObject2.put("viewStatus", this.E ? 1 : 0);
                break;
            case 16:
                this.c = true;
                e eVar = this.u;
                if (eVar != null) {
                    eVar.a();
                    break;
                }
                break;
            case 17:
                m(aVar.d);
                break;
            case 18:
                JSONObject jSONObject3 = this.r;
                if (jSONObject3 != null) {
                    jSONObject3.put("setting", v());
                }
                jSONObject2 = this.r;
                break;
            case 19:
                this.h.b(aVar.d);
                break;
            case 20:
                j(jSONObject2);
                break;
            case 21:
                AudioManager audioManager = (AudioManager) p.a().getSystemService("audio");
                if (audioManager != null) {
                    i3 = audioManager.getStreamVolume(3);
                    u.b("TTAndroidObject", "音乐音量 >>>> AudioManager-->currentVolume=" + i3);
                }
                if (i3 <= 0) {
                    z2 = true;
                }
                jSONObject2.put("endcard_mute", z2);
                break;
            case 22:
                t();
                break;
            case 23:
                h(aVar.d);
                break;
            case 24:
                l(aVar.d);
                break;
            case 25:
                com.bytedance.sdk.openadsdk.f.d dVar2 = this.v;
                if (dVar2 != null) {
                    dVar2.a();
                    break;
                }
                break;
            case 26:
                g(aVar.d);
                break;
            case 27:
                a(aVar, jSONObject2);
                break;
            case 28:
                e(jSONObject2);
                break;
            case 29:
                u();
                break;
            case 30:
                WeakReference<Context> weakReference3 = this.g;
                if (!(weakReference3 == null || (context3 = weakReference3.get()) == null || !(context3 instanceof com.bytedance.sdk.openadsdk.core.video.c.b))) {
                    ((com.bytedance.sdk.openadsdk.core.video.c.b) context3).W();
                    break;
                }
        }
        if (i2 == 1 && !TextUtils.isEmpty(aVar.b)) {
            c(aVar.b, jSONObject2);
            if (i.d().v()) {
                Log.d("TTAndroidObject", "[JSB-RSP] version:" + i2 + " data=" + jSONObject2);
            }
        }
        return jSONObject2;
    }

    private void f(JSONObject jSONObject) {
        p pVar;
        if (jSONObject != null && (pVar = this.F) != null) {
            pVar.b(jSONObject);
        }
    }

    private void a(String str, boolean z2) {
        if (this.F != null && !TextUtils.isEmpty(str)) {
            if (z2) {
                this.F.a(str);
            } else {
                this.F.b(str);
            }
        }
    }

    private void s() {
        h hVar = this.z;
        if (hVar != null) {
            hVar.a();
        }
    }

    private void t() {
        h hVar = this.z;
        if (hVar != null) {
            hVar.b();
        }
    }

    private void g(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.f.b bVar = this.y;
        if (bVar != null && jSONObject != null) {
            bVar.a(jSONObject.optBoolean("isRenderSuc", false), jSONObject.optInt("code", -1), jSONObject.optString("msg", ""));
        }
    }

    @JavascriptInterface
    public String adInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            d(jSONObject);
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    @JavascriptInterface
    public String appInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            a(jSONObject, 0);
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    @JavascriptInterface
    public String getTemplateInfo() {
        a("getTemplateInfo", true);
        try {
            JSONObject jSONObject = this.r;
            if (jSONObject != null) {
                jSONObject.put("setting", v());
            }
            a("getTemplateInfo", false);
            return this.r.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    @JavascriptInterface
    public void renderDidFinish(String str) {
        try {
            l(new JSONObject(str));
        } catch (Exception unused) {
        }
    }

    @JavascriptInterface
    public void muteVideo(String str) {
        try {
            final JSONObject jSONObject = new JSONObject(str);
            if (Looper.myLooper() == Looper.getMainLooper()) {
                h(jSONObject);
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    /* class com.bytedance.sdk.openadsdk.core.x.AnonymousClass2 */

                    @Override // java.lang.Runnable
                    public void run() {
                        x.this.h(jSONObject);
                    }
                });
            }
        } catch (Exception unused) {
            u.f("TTAndroidObject", "");
        }
    }

    @JavascriptInterface
    public void dynamicTrack(String str) {
        try {
            m(new JSONObject(str));
        } catch (Exception unused) {
        }
    }

    @JavascriptInterface
    public void changeVideoState(String str) {
        try {
            final JSONObject jSONObject = new JSONObject(str);
            if (Looper.myLooper() == Looper.getMainLooper()) {
                i(jSONObject);
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    /* class com.bytedance.sdk.openadsdk.core.x.AnonymousClass3 */

                    @Override // java.lang.Runnable
                    public void run() {
                        x.this.i(jSONObject);
                    }
                });
            }
        } catch (Exception unused) {
        }
    }

    @JavascriptInterface
    public void clickEvent(String str) {
        try {
            final JSONObject jSONObject = new JSONObject(str);
            if (Looper.myLooper() == Looper.getMainLooper()) {
                k(jSONObject);
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    /* class com.bytedance.sdk.openadsdk.core.x.AnonymousClass4 */

                    @Override // java.lang.Runnable
                    public void run() {
                        x.this.k(jSONObject);
                    }
                });
            }
        } catch (Exception unused) {
        }
    }

    @JavascriptInterface
    public void skipVideo() {
        u();
    }

    @JavascriptInterface
    public String getCurrentVideoState() {
        JSONObject jSONObject = new JSONObject();
        j(jSONObject);
        return jSONObject.toString();
    }

    private void u() {
        g gVar = this.q;
        if (gVar != null) {
            gVar.Q();
        }
    }

    /* access modifiers changed from: private */
    public void h(JSONObject jSONObject) {
        if (this.q != null && jSONObject != null) {
            try {
                this.q.f(jSONObject.optBoolean("mute", false));
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    public void i(JSONObject jSONObject) {
        if (this.q != null && jSONObject != null) {
            try {
                this.q.d(jSONObject.optInt("stateType", -1));
            } catch (Exception unused) {
            }
        }
    }

    private boolean j(JSONObject jSONObject) {
        g gVar = this.q;
        if (!(gVar == null || jSONObject == null)) {
            double R = (double) gVar.R();
            int S = this.q.S();
            try {
                jSONObject.put("currentTime", R / 1000.0d);
                jSONObject.put("state", S);
                u.b("TTAndroidObject", "currentTime,state:" + S);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x007d A[Catch:{ Exception -> 0x0084 }] */
    private JSONObject v() {
        boolean z2;
        l lVar;
        JSONObject jSONObject = new JSONObject();
        if (p.h() != null) {
            try {
                int d2 = aj.d(this.k);
                int c2 = aj.c(this.k);
                int g2 = p.h().g(String.valueOf(d2));
                int e2 = p.h().e(d2);
                boolean b2 = p.h().b(String.valueOf(d2));
                if (c2 != 7) {
                    if (c2 != 8) {
                        z2 = p.h().a(d2);
                        jSONObject.put("voice_control", z2);
                        jSONObject.put("rv_skip_time", g2);
                        jSONObject.put("fv_skip_show", b2);
                        jSONObject.put("iv_skip_time", e2);
                        l lVar2 = this.n;
                        int i2 = 0;
                        jSONObject.put("show_dislike", lVar2 == null && lVar2.aD());
                        lVar = this.n;
                        if (lVar != null) {
                            i2 = lVar.l();
                        }
                        jSONObject.put("video_adaptation", i2);
                    }
                }
                z2 = p.h().b(d2);
                jSONObject.put("voice_control", z2);
                jSONObject.put("rv_skip_time", g2);
                jSONObject.put("fv_skip_show", b2);
                jSONObject.put("iv_skip_time", e2);
                l lVar2 = this.n;
                int i2 = 0;
                jSONObject.put("show_dislike", lVar2 == null && lVar2.aD());
                lVar = this.n;
                if (lVar != null) {
                }
                jSONObject.put("video_adaptation", i2);
            } catch (Exception unused) {
            }
        }
        return jSONObject;
    }

    public void c(JSONObject jSONObject) {
        double d2;
        double d3;
        double d4;
        double d5;
        double d6;
        double d7;
        double d8;
        double d9;
        String str;
        double d10;
        if (jSONObject != null) {
            u.b("TTAndroidObject", "TTAndroidObject handleNewClickEvent");
            try {
                String optString = jSONObject.optString("adId");
                int optInt = jSONObject.optInt("areaType", 1);
                boolean z2 = jSONObject.optInt("downloadDialogStatus", 2) == 1;
                JSONObject optJSONObject = jSONObject.optJSONObject("clickInfo");
                double d11 = 0.0d;
                if (optJSONObject != null) {
                    double optDouble = optJSONObject.optDouble("down_x", 0.0d);
                    d8 = optJSONObject.optDouble("down_y", 0.0d);
                    d7 = optJSONObject.optDouble("up_x", 0.0d);
                    double optDouble2 = optJSONObject.optDouble("up_y", 0.0d);
                    double optDouble3 = optJSONObject.optDouble("down_time", 0.0d);
                    double optDouble4 = optJSONObject.optDouble("up_time", 0.0d);
                    double optDouble5 = optJSONObject.optDouble("button_x", 0.0d);
                    double optDouble6 = optJSONObject.optDouble("button_y", 0.0d);
                    double optDouble7 = optJSONObject.optDouble("button_width", 0.0d);
                    str = optString;
                    d2 = optJSONObject.optDouble("button_height", 0.0d);
                    d11 = optDouble;
                    d9 = optDouble2;
                    d10 = optDouble3;
                    d6 = optDouble4;
                    d5 = optDouble5;
                    d4 = optDouble6;
                    d3 = optDouble7;
                } else {
                    str = optString;
                    d10 = 0.0d;
                    d9 = 0.0d;
                    d8 = 0.0d;
                    d7 = 0.0d;
                    d6 = 0.0d;
                    d5 = 0.0d;
                    d4 = 0.0d;
                    d3 = 0.0d;
                    d2 = 0.0d;
                }
                com.bytedance.sdk.openadsdk.core.d.j a2 = new j.a().d((int) d11).c((int) d8).b((int) d7).a((int) d9).b((long) d10).a((long) d6).e((int) d5).f((int) d4).g((int) d3).h((int) d2).a();
                com.bytedance.sdk.openadsdk.core.nativeexpress.j jVar = this.p;
                if (jVar != null) {
                    jVar.a(optInt, a2, !z2);
                }
                a(str, optInt, a2);
            } catch (Exception unused) {
                com.bytedance.sdk.openadsdk.core.nativeexpress.j jVar2 = this.p;
                if (jVar2 != null) {
                    jVar2.a(-1, null, true);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    public void k(JSONObject jSONObject) {
        x xVar;
        com.bytedance.sdk.openadsdk.core.nativeexpress.j jVar;
        double d2;
        double d3;
        double d4;
        int i2;
        String str;
        double d5;
        double d6;
        double d7;
        double d8;
        double d9;
        double d10;
        com.bytedance.sdk.openadsdk.core.nativeexpress.j jVar2;
        if (jSONObject != null) {
            u.b("TTAndroidObject", "TTAndroidObject handleClickEvent");
            try {
                String optString = jSONObject.optString("adId");
                int optInt = jSONObject.optInt("areaType", 1);
                JSONObject optJSONObject = jSONObject.optJSONObject("clickInfo");
                double d11 = 0.0d;
                if (optJSONObject != null) {
                    double optDouble = optJSONObject.optDouble("down_x", 0.0d);
                    d8 = optJSONObject.optDouble("down_y", 0.0d);
                    d7 = optJSONObject.optDouble("up_x", 0.0d);
                    d6 = optJSONObject.optDouble("up_y", 0.0d);
                    d5 = optJSONObject.optDouble("down_time", 0.0d);
                    double optDouble2 = optJSONObject.optDouble("up_time", 0.0d);
                    double optDouble3 = optJSONObject.optDouble("button_x", 0.0d);
                    double optDouble4 = optJSONObject.optDouble("button_y", 0.0d);
                    double optDouble5 = optJSONObject.optDouble("button_width", 0.0d);
                    d2 = optJSONObject.optDouble("button_height", 0.0d);
                    d11 = optDouble;
                    d9 = optDouble2;
                    d10 = optDouble3;
                    d4 = optDouble4;
                    d3 = optDouble5;
                    str = optString;
                    i2 = optInt;
                } else {
                    str = optString;
                    i2 = optInt;
                    d10 = 0.0d;
                    d9 = 0.0d;
                    d8 = 0.0d;
                    d7 = 0.0d;
                    d6 = 0.0d;
                    d5 = 0.0d;
                    d4 = 0.0d;
                    d3 = 0.0d;
                    d2 = 0.0d;
                }
                try {
                    com.bytedance.sdk.openadsdk.core.d.j a2 = new j.a().d((int) d11).c((int) d8).b((int) d7).a((int) d6).b((long) d5).a((long) d9).e((int) d10).f((int) d4).g((int) d3).h((int) d2).a();
                    xVar = this;
                    try {
                        if (!xVar.a(str, i2, a2) && (jVar2 = xVar.p) != null) {
                            jVar2.a(i2, a2);
                        }
                    } catch (Exception unused) {
                        jVar = xVar.p;
                        if (jVar != null) {
                            jVar.a(-1, null);
                        }
                    }
                } catch (Exception unused2) {
                    xVar = this;
                    jVar = xVar.p;
                    if (jVar != null) {
                    }
                }
            } catch (Exception unused3) {
                xVar = this;
                jVar = xVar.p;
                if (jVar != null) {
                }
            }
        }
    }

    private void l(JSONObject jSONObject) {
        double d2;
        boolean z2;
        if (this.p != null && jSONObject != null) {
            o oVar = new o();
            oVar.a(1);
            try {
                boolean optBoolean = jSONObject.optBoolean("isRenderSuc");
                JSONObject optJSONObject = jSONObject.optJSONObject("AdSize");
                double d3 = 0.0d;
                if (optJSONObject != null) {
                    d3 = optJSONObject.optDouble("width");
                    d2 = optJSONObject.optDouble("height");
                } else {
                    d2 = 0.0d;
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("videoInfo");
                if (optJSONObject2 != null) {
                    double optDouble = optJSONObject2.optDouble("x");
                    double optDouble2 = optJSONObject2.optDouble("y");
                    z2 = optBoolean;
                    double optDouble3 = optJSONObject2.optDouble("width");
                    double optDouble4 = optJSONObject2.optDouble("height");
                    oVar.c(optDouble);
                    oVar.d(optDouble2);
                    oVar.e(optDouble3);
                    oVar.f(optDouble4);
                } else {
                    z2 = optBoolean;
                }
                String optString = jSONObject.optString("message", h.a(101));
                int optInt = jSONObject.optInt("code", 101);
                oVar.a(z2);
                oVar.a(d3);
                oVar.b(d2);
                oVar.a(optString);
                oVar.b(optInt);
                this.p.a(oVar);
            } catch (Exception unused) {
                oVar.b(101);
                oVar.a(h.a(101));
                this.p.a(oVar);
            }
        }
    }

    private void m(JSONObject jSONObject) {
        if (jSONObject != null) {
            u.b("TTAndroidObject", "TTAndroidObject handlerDynamicTrack");
            try {
                Uri parse = Uri.parse(jSONObject.optString("trackData"));
                if ("bytedance".equals(parse.getScheme().toLowerCase())) {
                    r.a(parse, this);
                }
            } catch (Exception unused) {
            }
        }
    }

    private void n(JSONObject jSONObject) {
        if (jSONObject != null && this.s != null) {
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("temaiProductIds");
                if (optJSONArray == null || optJSONArray.length() <= 0) {
                    this.s.a(false, null);
                } else {
                    this.s.a(true, optJSONArray);
                }
            } catch (Exception unused) {
                this.s.a(false, null);
            }
        }
    }

    private boolean o(JSONObject jSONObject) {
        try {
            jSONObject.put("creatives", b(this.B));
        } catch (Exception unused) {
        }
        return true;
    }

    private void a(final a aVar, final JSONObject jSONObject) {
        if (aVar != null) {
            try {
                a(aVar.d, new com.bytedance.sdk.openadsdk.f.c() {
                    /* class com.bytedance.sdk.openadsdk.core.x.AnonymousClass5 */

                    @Override // com.bytedance.sdk.openadsdk.f.c
                    public void a(boolean z, List<l> list) {
                        if (z) {
                            try {
                                jSONObject.put("creatives", x.b(list));
                                x.this.c(aVar.b, jSONObject);
                            } catch (Exception unused) {
                            }
                        } else {
                            x.this.c(aVar.b, jSONObject);
                        }
                    }
                });
            } catch (Exception unused) {
            }
        }
    }

    public void f() {
        a((JSONObject) null, new com.bytedance.sdk.openadsdk.f.c() {
            /* class com.bytedance.sdk.openadsdk.core.x.AnonymousClass6 */

            @Override // com.bytedance.sdk.openadsdk.f.c
            public void a(boolean z, List<l> list) {
                x.this.B = list;
                x.this.w();
                x.this.g();
            }
        });
    }

    /* access modifiers changed from: private */
    public void w() {
        Context context;
        List<l> list = this.B;
        if (list != null && list.size() > 0) {
            this.C = new HashMap<>();
            SSWebView sSWebView = null;
            WeakReference<SSWebView> weakReference = this.d;
            if (weakReference != null) {
                sSWebView = weakReference.get();
            }
            WeakReference<Context> weakReference2 = this.g;
            if (!(weakReference2 == null || (context = weakReference2.get()) == null)) {
                for (l lVar : this.B) {
                    this.C.put(lVar.ag(), new j(context, lVar, sSWebView, this.H));
                }
            }
        }
    }

    private boolean a(String str, int i2, com.bytedance.sdk.openadsdk.core.d.j jVar) {
        HashMap<String, j> hashMap;
        j jVar2;
        if (TextUtils.isEmpty(str) || (hashMap = this.C) == null || (jVar2 = hashMap.get(str)) == null) {
            return false;
        }
        jVar2.a(i2, jVar);
        return true;
    }

    public void a(JSONObject jSONObject, com.bytedance.sdk.openadsdk.f.c cVar) {
        a(jSONObject, cVar, (AdSlot) null);
    }

    public void a(JSONObject jSONObject, final com.bytedance.sdk.openadsdk.f.c cVar, AdSlot adSlot) {
        if (cVar != null) {
            try {
                if (this.n != null) {
                    if (!TextUtils.isEmpty(this.k)) {
                        int c2 = aj.c(this.k);
                        AdSlot p2 = this.n.p();
                        if (p2 != null) {
                            adSlot = p2;
                        }
                        m mVar = new m();
                        if (this.n.M() != null) {
                            mVar.e = 2;
                        }
                        JSONObject at = this.n.at();
                        if (at == null) {
                            at = new JSONObject();
                        }
                        if (jSONObject != null) {
                            Iterator<String> keys = jSONObject.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                at.put(next, jSONObject.opt(next));
                            }
                        }
                        mVar.j = at;
                        p.f().a(adSlot, mVar, c2, new q.b() {
                            /* class com.bytedance.sdk.openadsdk.core.x.AnonymousClass7 */

                            @Override // com.bytedance.sdk.openadsdk.core.q.b
                            public void a(int i, String str) {
                                cVar.a(false, null);
                            }

                            @Override // com.bytedance.sdk.openadsdk.core.q.b
                            public void a(com.bytedance.sdk.openadsdk.core.d.a aVar) {
                                if (aVar.c() == null || aVar.c().isEmpty()) {
                                    cVar.a(false, null);
                                } else {
                                    cVar.a(true, aVar.c());
                                }
                            }
                        });
                        return;
                    }
                }
                cVar.a(false, null);
            } catch (Exception e2) {
                u.c("TTAndroidObject", "get ads error", e2);
            }
        }
    }

    public void g() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("material", b(this.B));
            a("materialMeta", jSONObject);
        } catch (Exception unused) {
        }
    }

    public static JSONArray b(List<l> list) {
        JSONArray jSONArray = new JSONArray();
        if (list == null) {
            return jSONArray;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            jSONArray.put(list.get(i2).aF());
        }
        return jSONArray;
    }

    private boolean x() {
        l lVar = this.n;
        if (lVar == null || lVar.at() == null || this.n.C() || this.D || this.n.at().optInt("parent_type") != 2) {
            return false;
        }
        int c2 = aj.c(this.k);
        if (c2 != 8 && c2 != 7) {
            return false;
        }
        this.D = true;
        return true;
    }

    public void a(AdSlot adSlot) {
        a((JSONObject) null, new com.bytedance.sdk.openadsdk.f.c() {
            /* class com.bytedance.sdk.openadsdk.core.x.AnonymousClass8 */

            @Override // com.bytedance.sdk.openadsdk.f.c
            public void a(boolean z, List<l> list) {
                x.this.B = list;
                x.this.w();
                x.this.g();
            }
        }, adSlot);
    }

    /* access modifiers changed from: private */
    public void c(String str, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("__msg_type", "callback");
            jSONObject2.put("__callback_id", str);
            if (jSONObject != null) {
                jSONObject2.put("__params", jSONObject);
            }
            p(jSONObject2);
        } catch (Exception unused) {
        }
    }

    private void p(JSONObject jSONObject) {
        WebView p2;
        if (jSONObject != null && (p2 = p()) != null) {
            String str = "javascript:ToutiaoJSBridge._handleMessageFromToutiao(" + jSONObject.toString() + ")";
            t.a(p2, str);
            if (u.a()) {
                u.a("TTAndroidObject", "js_msg " + str);
            }
        }
    }

    private void d(String str, JSONObject jSONObject) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("__msg_type", "event");
                jSONObject2.put("__event_id", str);
                if (jSONObject != null) {
                    jSONObject2.put("__params", jSONObject);
                }
                p(jSONObject2);
            }
        } catch (Exception unused) {
        }
    }

    private void e(String str) {
        try {
            String str2 = new String(Base64.decode(str, 2));
            u.b("TTAndroidObject", str2);
            JSONArray jSONArray = new JSONArray(str2);
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                a aVar = new a();
                try {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        aVar.a = optJSONObject.optString("__msg_type", null);
                        aVar.b = optJSONObject.optString("__callback_id", null);
                        aVar.c = optJSONObject.optString("func");
                        aVar.d = optJSONObject.optJSONObject("params");
                        aVar.e = optJSONObject.optInt("JSSDK");
                    }
                } catch (Throwable unused) {
                }
                if (!TextUtils.isEmpty(aVar.a) && !TextUtils.isEmpty(aVar.c)) {
                    Message obtainMessage = this.e.obtainMessage(11);
                    obtainMessage.obj = aVar;
                    this.e.sendMessage(obtainMessage);
                }
            }
        } catch (Exception unused2) {
            if (u.a()) {
                u.d("TTAndroidObject", "failed to parse jsbridge msg queue " + str);
                return;
            }
            u.d("TTAndroidObject", "failed to parse jsbridge msg queue");
        }
    }

    public boolean a(Uri uri) {
        if (uri == null) {
            return false;
        }
        try {
            if (!"bytedance".equals(uri.getScheme())) {
                return false;
            }
            if (f.containsKey(uri.getHost())) {
                return true;
            }
            return false;
        } catch (Exception unused) {
        }
    }

    public void b(Uri uri) {
        long j2;
        try {
            String host = uri.getHost();
            if (!"log_event".equals(host) && !"custom_event".equals(host)) {
                if (!"log_event_v3".equals(host)) {
                    if (!"private".equals(host)) {
                        if (!"dispatch_message".equals(host)) {
                            u.d("TTAndroidObject", "handlrUir: not match schema host");
                            return;
                        }
                    }
                    h(uri.toString());
                    return;
                }
            }
            String queryParameter = uri.getQueryParameter("category");
            String queryParameter2 = uri.getQueryParameter("tag");
            String queryParameter3 = uri.getQueryParameter("label");
            if (f(queryParameter3)) {
                long j3 = 0;
                try {
                    j2 = Long.parseLong(uri.getQueryParameter("value"));
                } catch (Exception unused) {
                    j2 = 0;
                }
                try {
                    j3 = Long.parseLong(uri.getQueryParameter("ext_value"));
                } catch (Exception unused2) {
                }
                JSONObject jSONObject = null;
                String queryParameter4 = uri.getQueryParameter("extra");
                if (!TextUtils.isEmpty(queryParameter4)) {
                    try {
                        jSONObject = new JSONObject(queryParameter4);
                    } catch (Exception unused3) {
                    }
                }
                com.bytedance.sdk.openadsdk.c.d.a(queryParameter, g(queryParameter2), queryParameter3, j2, j3, "click".equals(queryParameter3) ? q(jSONObject) : jSONObject);
            }
        } catch (Exception e2) {
            u.b("TTAndroidObject", "handleUri exception: ", e2);
        }
    }

    private boolean f(String str) {
        if (!TextUtils.isEmpty(str) && "click_other".equals(str) && !h()) {
            return false;
        }
        return true;
    }

    boolean h() {
        l lVar = this.n;
        if (lVar != null && lVar.I() == 1) {
            return true;
        }
        return false;
    }

    private JSONObject q(JSONObject jSONObject) {
        if (this.a != null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                String optString = jSONObject.optString("ad_extra_data", null);
                if (optString != null) {
                    jSONObject2 = new JSONObject(optString);
                }
                for (Map.Entry<String, Object> entry : this.a.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            } catch (Exception e2) {
                u.b(e2.toString());
            }
        }
        return jSONObject;
    }

    public void i() {
        l lVar = this.n;
        if (lVar != null) {
            com.bytedance.sdk.openadsdk.utils.g.a(lVar.Q());
        }
    }

    public void j() {
        com.bytedance.sdk.openadsdk.utils.g.a(this.n, this.g.get(), l());
    }

    public JSONObject k() {
        JSONObject jSONObject = new JSONObject();
        l lVar = this.n;
        if (lVar == null) {
            return jSONObject;
        }
        String Q = lVar.Q();
        if (TextUtils.isEmpty(Q)) {
            return jSONObject;
        }
        try {
            return new JSONObject(Q);
        } catch (Exception e2) {
            e2.printStackTrace();
            return jSONObject;
        }
    }

    public String l() {
        return aj.a(this.l);
    }

    private String g(String str) {
        return this.p == null ? aj.a(this.l) : str;
    }

    private void h(String str) {
        int indexOf;
        if (str != null && str.startsWith("bytedance://")) {
            try {
                if (str.equals("bytedance://dispatch_message/")) {
                    WebView p2 = p();
                    if (p2 != null) {
                        t.a(p2, "javascript:ToutiaoJSBridge._fetchQueue()");
                    }
                } else if (str.startsWith("bytedance://private/setresult/") && (indexOf = str.indexOf(38, 30)) > 0) {
                    String substring = str.substring(30, indexOf);
                    String substring2 = str.substring(indexOf + 1);
                    if (substring.equals("SCENE_FETCHQUEUE") && substring2.length() > 0) {
                        e(substring2);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public void m() {
        c cVar = this.h;
        if (cVar != null) {
            cVar.a();
        }
        if (x()) {
            f();
        }
    }

    public void n() {
        c cVar = this.h;
        if (cVar != null) {
            cVar.b();
        }
    }

    public void o() {
        c cVar = this.h;
        if (cVar != null) {
            cVar.c();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.utils.al.a
    public void a(Message message) {
        if (message != null && message.what == 11 && (message.obj instanceof a)) {
            try {
                a((a) message.obj, 1);
            } catch (Exception unused) {
            }
        }
    }

    private void y() {
        if (this.h == null) {
            this.h = com.bytedance.sdk.openadsdk.d.a.a(this, this.n);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.d.b
    public void a(String str, JSONObject jSONObject) {
        d(str, jSONObject);
    }

    public void b(String str, JSONObject jSONObject) {
        try {
            com.bytedance.sdk.openadsdk.e.a.q qVar = this.G;
            if (qVar != null) {
                qVar.a(str, (String) jSONObject);
            }
        } catch (Throwable th) {
            Log.e("TTAndroidObject", "sendJsMsg2020 error", th);
        }
    }
}
