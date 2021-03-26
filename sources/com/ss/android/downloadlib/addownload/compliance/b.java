package com.ss.android.downloadlib.addownload.compliance;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import com.ss.android.a.a.a.p;
import com.ss.android.a.a.b.c;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.b.e;
import com.ss.android.downloadlib.addownload.f;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.downloadlib.h.c;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: AdLpComplianceManager */
public class b {
    private SoftReference<Activity> a;

    /* compiled from: AdLpComplianceManager */
    private static class a {
        private static b a = new b();
    }

    public static b a() {
        return a.a;
    }

    private b() {
    }

    public void a(long j) {
        TTDelegateActivity.a(j);
    }

    public boolean a(c cVar) {
        if (!cVar.t() || k.i().optInt("ad_lp_show_app_dialog") == 0) {
            return false;
        }
        String a2 = cVar.x() == null ? null : cVar.x().a();
        if (!TextUtils.isEmpty(a2) && !Pattern.compile(k.i().optString("ad_allow_web_url_regex", ".+(www.chengzijianzhan.com|www.toutiaopage.com/tetris/page|ad.toutiao.com/tetris/page).+")).matcher(a2).matches()) {
            return true;
        }
        return false;
    }

    public boolean a(e eVar) {
        final long j;
        long j2;
        if (!TextUtils.isEmpty(eVar.b.u())) {
            try {
                j2 = com.ss.android.downloadlib.h.k.a(new JSONObject(eVar.b.u()), "convert_id");
            } catch (Exception e) {
                e.printStackTrace();
                j2 = 0;
            }
            if (j2 <= 0) {
                e.a(3, eVar);
            }
            j = j2;
        } else {
            e.a(9, eVar);
            com.ss.android.downloadlib.f.a.a();
            j = 0;
        }
        final long j3 = eVar.a;
        com.ss.android.downloadlib.addownload.b.b a2 = c.a().a(j, j3);
        if (a2 != null) {
            d.a().a(a2.a(), j3, a2.d);
            a(a2.a());
            e.a("lp_app_dialog_try_show", eVar);
            return true;
        } else if (k.e() == null) {
            com.ss.android.downloadlib.f.a.a();
            e.a(1, eVar);
            return false;
        } else {
            StringBuilder sb = new StringBuilder();
            if (j > 0) {
                sb.append("convert_id=");
                sb.append(j);
            }
            if (!TextUtils.isEmpty(eVar.b.v())) {
                if (sb.length() > 0) {
                    sb.append("&");
                }
                sb.append("package_name=");
                sb.append(eVar.b.v());
            }
            if (sb.length() <= 0) {
                e.a(6, eVar);
                return false;
            }
            com.ss.android.downloadlib.h.c.a(new c.a<String, Boolean>() {
                /* class com.ss.android.downloadlib.addownload.compliance.b.AnonymousClass2 */

                public Boolean a(String str) {
                    final boolean[] zArr = {false};
                    k.e().a("GET", str, new HashMap(), new p() {
                        /* class com.ss.android.downloadlib.addownload.compliance.b.AnonymousClass2.AnonymousClass1 */

                        @Override // com.ss.android.a.a.a.p
                        public void a(String str) {
                            zArr[0] = b.this.a(j, j3, str);
                        }

                        @Override // com.ss.android.a.a.a.p
                        public void a(Throwable th) {
                            com.ss.android.downloadlib.f.a.a(th);
                            e.a(2, j3);
                            zArr[0] = false;
                        }
                    });
                    return Boolean.valueOf(zArr[0]);
                }
            }, "https://apps.oceanengine.com/customer/api/app/pkg_info?" + sb.toString()).a(new c.a<Boolean, Object>() {
                /* class com.ss.android.downloadlib.addownload.compliance.b.AnonymousClass1 */

                public Object a(Boolean bool) {
                    if (bool.booleanValue()) {
                        b.this.a(com.ss.android.downloadlib.addownload.b.b.a(j, j3));
                        e.b("lp_app_dialog_try_show", j3);
                        return null;
                    }
                    b.this.b(j3);
                    return null;
                }
            }).a();
            return true;
        }
    }

    /* access modifiers changed from: private */
    public boolean a(long j, long j2, String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("package");
            if (optJSONObject != null) {
                if (optJSONObject.length() != 0) {
                    com.ss.android.downloadlib.addownload.b.b bVar = new com.ss.android.downloadlib.addownload.b.b();
                    bVar.a = j;
                    bVar.b = j2;
                    bVar.d = optJSONObject.optString("icon_url");
                    bVar.e = optJSONObject.optString("app_name");
                    bVar.c = optJSONObject.optString("package_name");
                    bVar.f = optJSONObject.optString("version_name");
                    bVar.g = optJSONObject.optString("developer_name");
                    bVar.i = optJSONObject.optString("policy_url");
                    JSONArray optJSONArray = optJSONObject.optJSONArray("permissions");
                    if (optJSONArray != null) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            JSONObject jSONObject = (JSONObject) optJSONArray.get(i);
                            bVar.h.add(new Pair<>(jSONObject.optString("permission_name"), jSONObject.optString("permission_desc")));
                        }
                    }
                    c.a().a(bVar);
                    d.a().a(bVar.a(), j2, bVar.d);
                    return true;
                }
            }
            e.a(7, j2);
            return false;
        } catch (Exception e) {
            com.ss.android.downloadlib.f.a.a(e);
            e.a(7, j2);
            return false;
        }
    }

    public void b(long j) {
        f a2 = com.ss.android.downloadlib.f.a().a(com.ss.android.downloadlib.addownload.b.f.a().e(j).b.a());
        if (a2 != null) {
            a2.b(false);
            return;
        }
        e.a(11, j);
        com.ss.android.downloadlib.f.a.a();
    }

    public void a(Activity activity) {
        this.a = new SoftReference<>(activity);
    }

    public Activity b() {
        Activity activity = this.a.get();
        this.a = null;
        return activity;
    }
}
