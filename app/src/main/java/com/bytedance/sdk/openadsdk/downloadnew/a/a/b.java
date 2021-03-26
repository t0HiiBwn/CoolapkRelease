package com.bytedance.sdk.openadsdk.downloadnew.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTDownloadEventLogger;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.downloadnew.a.g;
import com.bytedance.sdk.openadsdk.j.e;
import com.bytedance.sdk.openadsdk.utils.u;
import com.ss.android.a.a.a.f;
import com.ss.android.a.a.c.d;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: LibEventLogger */
public class b implements f {
    private final WeakReference<Context> a;

    public b(Context context) {
        this.a = new WeakReference<>(context);
    }

    @Override // com.ss.android.a.a.a.f
    public void a(d dVar) {
        u.b("LibEventLogger", "onV3Event: " + String.valueOf(dVar));
        a(dVar, true);
    }

    @Override // com.ss.android.a.a.a.f
    public void b(d dVar) {
        u.b("LibEventLogger", "onEvent: " + String.valueOf(dVar));
        a(dVar, false);
        d(dVar);
    }

    private void d(d dVar) {
        if (dVar != null) {
            e.a(a.a(dVar), 5);
        }
    }

    /* compiled from: LibEventLogger */
    private static class a implements Runnable {
        private final d a;
        private com.bytedance.sdk.openadsdk.downloadnew.a.b.a b;
        private l c;

        public static a a(d dVar) {
            return new a(dVar);
        }

        private a(d dVar) {
            this.a = dVar;
            if (dVar != null && dVar.d() != null) {
                String optString = dVar.d().optString("ad_extra_data");
                if (!TextUtils.isEmpty(optString)) {
                    try {
                        com.bytedance.sdk.openadsdk.downloadnew.a.b.a a2 = com.bytedance.sdk.openadsdk.downloadnew.a.b.a.a(new JSONObject(optString).optJSONObject("open_ad_sdk_download_extra"));
                        this.b = a2;
                        a2.b(dVar.b());
                        com.bytedance.sdk.openadsdk.downloadnew.a.b.a aVar = this.b;
                        if (aVar != null) {
                            this.c = aVar.a;
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }

        private Context a() {
            return p.a();
        }

        private boolean a(String str) {
            return !TextUtils.isEmpty(str) && ("embeded_ad".equals(this.a.a()) || "draw_ad".equals(this.a.a()) || "draw_ad_landingpage".equals(this.a.a()) || "banner_ad".equals(this.a.a()) || "banner_call".equals(this.a.a()) || "banner_ad_landingpage".equals(this.a.a()) || "feed_call".equals(this.a.a()) || "embeded_ad_landingpage".equals(this.a.a()) || "interaction".equals(this.a.a()) || "interaction_call".equals(this.a.a()) || "interaction_landingpage".equals(this.a.a()) || "slide_banner_ad".equals(this.a.a()) || "splash_ad".equals(this.a.a()) || "fullscreen_interstitial_ad".equals(this.a.a()) || "splash_ad_landingpage".equals(this.a.a()) || "rewarded_video".equals(this.a.a()) || "rewarded_video_landingpage".equals(this.a.a()) || "openad_sdk_download_complete_tag".equals(this.a.a()) || "download_notification".equals(this.a.a()) || "landing_h5_download_ad_button".equals(this.a.a()) || "fullscreen_interstitial_ad_landingpage".equals(this.a.a()) || "feed_video_middle_page".equals(this.a.a()) || "stream".equals(this.a.a()));
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d dVar = this.a;
                if (dVar != null) {
                    String a2 = dVar.a();
                    u.f("LibEventLogger", "tag " + a2);
                    u.f("LibEventLogger", "label " + this.a.b());
                    com.bytedance.sdk.openadsdk.downloadnew.a.b.a aVar = this.b;
                    if (aVar != null && !TextUtils.isEmpty(aVar.b)) {
                        a2 = this.b.b;
                    }
                    if (g.a(a2, this.a.b(), this.c, new HashMap()) || this.b == null || this.c == null || TextUtils.isEmpty(this.a.a())) {
                        return;
                    }
                    if (!TextUtils.isEmpty(this.a.b())) {
                        JSONObject e = b.e(this.a);
                        String str = this.b.b;
                        if (a(this.a.a()) && !"click".equals(this.a.b())) {
                            com.bytedance.sdk.openadsdk.c.d.b(a(), this.c, str, this.a.b(), e);
                        }
                    }
                }
            } catch (Throwable th) {
                u.a("LibEventLogger", "upload event log error", th);
            }
        }
    }

    /* access modifiers changed from: private */
    public static JSONObject e(d dVar) {
        JSONObject d;
        if (dVar == null || (d = dVar.d()) == null) {
            return null;
        }
        String optString = d.optString("ad_extra_data");
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        try {
            return new JSONObject(optString);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void a(d dVar, boolean z) {
        TTDownloadEventLogger m = i.d().m();
        if (m != null && dVar != null) {
            if (m.shouldFilterOpenSdkLog() && f(dVar)) {
                return;
            }
            if (z) {
                m.onV3Event(dVar);
            } else {
                m.onEvent(dVar);
            }
        }
    }

    private boolean f(d dVar) {
        dVar.c();
        if (dVar == null) {
            return false;
        }
        String dVar2 = dVar.toString();
        if (!TextUtils.isEmpty(dVar2)) {
            return dVar2.contains("open_ad_sdk_download_extra");
        }
        return false;
    }
}
