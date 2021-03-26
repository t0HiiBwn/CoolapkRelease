package com.bytedance.sdk.openadsdk.downloadnew.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.c.k;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.aj;

/* compiled from: AndroidRDMLicManager */
public class b extends d {
    public b(Context context, l lVar, String str) {
        super(context, lVar, str);
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.a.d
    public boolean k() {
        if (this.c.ai() == null) {
            return false;
        }
        String a = this.c.ai().a();
        if (!TextUtils.isEmpty(a)) {
            Uri parse = Uri.parse(a);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(parse);
            if (this.h) {
                d.a(m(), this.c, this.d, "lp_open_dpl", a(a));
            }
            try {
                Context m = m();
                if (!(m instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                if (!a(this.d, "open_url_app", this.c)) {
                    d.i(m(), this.c, this.d, "open_url_app", null);
                }
                n();
                m.startActivity(intent);
                k.a().a(this.c, this.d, this.h);
                if (this.h) {
                    d.b(m(), this.c, this.d, "lp_openurl");
                    d.b(p.a(), this.c, this.d, "lp_deeplink_success_realtime");
                } else {
                    d.b(p.a(), this.c, this.d, "deeplink_success_realtime");
                }
                return true;
            } catch (Throwable unused) {
                d.b(m(), this.c, this.d, "open_fallback_download");
                if (this.h) {
                    d.b(m(), this.c, this.d, "lp_openurl_failed");
                    d.b(p.a(), this.c, this.d, "lp_deeplink_fail_realtime");
                } else {
                    d.b(p.a(), this.c, this.d, "deeplink_fail_realtime");
                }
            }
        }
        if (this.e.get() == 4 || this.e.get() == 3) {
            return false;
        }
        if (this.g && !this.f.get()) {
            return false;
        }
        this.g = true;
        if (a(this.d, "open_fallback_url", this.c)) {
            return false;
        }
        d.i(m(), this.c, this.d, "open_fallback_url", null);
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.a.d, com.bytedance.sdk.openadsdk.downloadnew.core.a
    public boolean j() {
        boolean z = false;
        if (this.b == null) {
            return false;
        }
        String d = this.b.d();
        if (!TextUtils.isEmpty(d) && b(m(), d)) {
            z = true;
            this.f.set(true);
            if (!a(this.d, "click_open", this.c)) {
                d.j(m(), this.c, this.d, aj.h(this.c), null);
            }
        }
        return z;
    }

    private boolean b(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                Intent b = aj.b(context, str);
                if (b == null) {
                    return false;
                }
                if (this.h) {
                    d.a(m(), this.c, this.d, "lp_open_dpl", str);
                }
                n();
                b.putExtra("START_ONLY_FOR_ANDROID", true);
                context.startActivity(b);
                if (this.h) {
                    d.b(m(), this.c, this.d, "lp_openurl");
                }
                if (this.h) {
                    k.a().a(this.c, this.d, true);
                }
                return true;
            } catch (Exception unused) {
                if (this.h) {
                    d.b(m(), this.c, this.d, "lp_openurl_failed");
                }
            } catch (Throwable unused2) {
            }
        }
        return false;
    }
}
