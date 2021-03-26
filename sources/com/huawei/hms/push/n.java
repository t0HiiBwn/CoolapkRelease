package com.huawei.hms.push;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;
import com.huawei.hms.utils.Util;
import java.util.ArrayList;

/* compiled from: SelfShowType */
public class n {
    private static final String[] a = {"url", "app", "cosa", "rp"};
    private Context b;
    private o c;

    public n(Context context, o oVar) {
        this.b = context;
        this.c = oVar;
    }

    public static boolean a(String str) {
        for (String str2 : a) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public void a() {
        o oVar;
        HMSLog.d("PushSelfShowLog", "enter launchNotify()");
        if (this.b == null || (oVar = this.c) == null) {
            HMSLog.d("PushSelfShowLog", "launchNotify  context or msg is null");
        } else if ("app".equals(oVar.j())) {
            b();
        } else if ("cosa".equals(this.c.j())) {
            e();
        } else if ("rp".equals(this.c.j())) {
            HMSLog.w("PushSelfShowLog", this.c.j() + " not support rich message.");
        } else if ("url".equals(this.c.j())) {
            HMSLog.w("PushSelfShowLog", this.c.j() + " not support URL.");
        } else {
            HMSLog.d("PushSelfShowLog", this.c.j() + " is not exist in hShowType");
        }
    }

    private void b() {
        try {
            HMSLog.i("PushSelfShowLog", "enter launchApp, appPackageName =" + this.c.m() + ",and msg.intentUri is " + this.c.g());
            if (u.c(this.b, this.c.m())) {
                e();
            } else {
                c();
            }
        } catch (Exception e) {
            HMSLog.e("PushSelfShowLog", "launchApp error:" + e.toString());
        }
    }

    private String b(String str) {
        try {
            int indexOf = str.indexOf(63);
            if (indexOf == -1) {
                return str;
            }
            int i = indexOf + 1;
            String[] split = str.substring(i).split("&");
            ArrayList arrayList = new ArrayList();
            for (String str2 : split) {
                if (!str2.startsWith("h_w_hiapp_referrer") && !str2.startsWith("h_w_gp_referrer")) {
                    arrayList.add(str2);
                }
            }
            StringBuilder sb = new StringBuilder();
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                sb.append((String) arrayList.get(i2));
                if (i2 < arrayList.size() - 1) {
                    sb.append("&");
                }
            }
            String substring = arrayList.size() == 0 ? str.substring(0, indexOf) : str.substring(0, i) + sb.toString();
            HMSLog.d("PushSelfShowLog", "after delete referrer, the new IntentUri is:" + substring);
            return substring;
        } catch (Exception e) {
            HMSLog.e("PushSelfShowLog", "delete referrer exception" + e.toString());
            return str;
        }
    }

    private void c() {
        try {
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(this.c.g())) {
                sb.append("&referrer=");
                sb.append(Uri.encode(b(this.c.g())));
            }
            String str = "market://details?id=" + this.c.m() + ((Object) sb);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            intent.setPackage("com.huawei.appmarket");
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setData(Uri.parse(str));
            intent2.setPackage("com.android.vending");
            if (u.a(this.b, "com.android.vending", intent2).booleanValue()) {
                intent2.setFlags(402653184);
                HMSLog.i("PushSelfShowLog", "open google play store's app detail, IntentUrl is:" + intent2.toURI());
                this.b.startActivity(intent2);
            } else if (u.a(this.b, "com.huawei.appmarket", intent).booleanValue()) {
                intent.setFlags(402653184);
                HMSLog.i("PushSelfShowLog", "open HiApp's app detail, IntentUrl is:" + intent.toURI());
                this.b.startActivity(intent);
            } else {
                HMSLog.i("PushSelfShowLog", "open app detail by browser.");
                d();
            }
        } catch (Exception e) {
            HMSLog.e("PushSelfShowLog", "open market app detail failed,exception:" + e);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a2  */
    private void d() {
        String str;
        String str2;
        Exception e;
        String str3 = "";
        try {
            Uri parse = Uri.parse(Uri.decode(this.c.g()));
            try {
                str = parse.getQueryParameter("h_w_hiapp_referrer");
            } catch (Exception unused) {
                HMSLog.i("PushSelfShowLog", "parse h_w_hiapp_referrer faied");
                str = str3;
            }
            try {
                str3 = parse.getQueryParameter("h_w_gp_referrer");
            } catch (Exception unused2) {
                try {
                    HMSLog.i("PushSelfShowLog", "parse h_w_hiapp_referrer faied");
                } catch (Exception e2) {
                    e = e2;
                }
            }
        } catch (Exception e3) {
            e = e3;
            str = str3;
            HMSLog.w("PushSelfShowLog", "parse intentUri error" + e.toString());
            str2 = null;
            if (Util.isEMUI()) {
            }
            HMSLog.i("PushSelfShowLog", "not EMUI system or not in China, open google play web, referrer: " + str3);
            str2 = Uri.decode(str3);
            if (!URLUtil.isValidUrl(str2)) {
            }
            HMSLog.i("PushSelfShowLog", "open the URL by browser: " + str2);
            u.d(this.b, str2);
        }
        str2 = null;
        if (Util.isEMUI() || !Util.isChinaROM()) {
            HMSLog.i("PushSelfShowLog", "not EMUI system or not in China, open google play web, referrer: " + str3);
            str2 = Uri.decode(str3);
            if (!URLUtil.isValidUrl(str2)) {
                ResourceLoaderUtil.setmContext(this.b);
                str2 = ResourceLoaderUtil.getString("hms_push_google") + this.c.m();
            }
        } else {
            HMSLog.i("PushSelfShowLog", "It is China device, open Huawei market web, referrer: " + str);
            String decode = Uri.decode(str);
            if (URLUtil.isValidUrl(decode)) {
                str2 = decode;
            } else {
                Context context = this.b;
                if (context != null) {
                    ResourceLoaderUtil.setmContext(context);
                    str2 = ResourceLoaderUtil.getString("hms_push_vmall");
                }
            }
        }
        HMSLog.i("PushSelfShowLog", "open the URL by browser: " + str2);
        u.d(this.b, str2);
    }

    private void e() {
        HMSLog.i("PushSelfShowLog", "run into launchCosaApp ");
        try {
            HMSLog.i("PushSelfShowLog", "enter launchExistApp cosa, appPackageName =" + this.c.m() + ",and msg.intentUri is " + this.c.g());
            Intent b2 = u.b(this.b, this.c.m());
            boolean z = false;
            if (this.c.g() != null) {
                try {
                    Intent parseUri = Intent.parseUri(this.c.g(), 0);
                    HMSLog.i("PushSelfShowLog", "Intent.parseUri(msg.intentUri, 0)," + parseUri.getAction());
                    z = u.a(this.b, this.c.m(), parseUri).booleanValue();
                    if (z) {
                        b2 = parseUri;
                    }
                } catch (Exception e) {
                    HMSLog.w("PushSelfShowLog", "intentUri error" + e.toString());
                }
            } else {
                if (this.c.n() != null) {
                    Intent intent = new Intent(this.c.n());
                    if (u.a(this.b, this.c.m(), intent).booleanValue()) {
                        b2 = intent;
                    }
                }
                b2.setPackage(this.c.m());
            }
            if (b2 == null) {
                HMSLog.i("PushSelfShowLog", "launchCosaApp,intent == null");
            } else if (!u.a(this.b, b2)) {
                HMSLog.w("PushSelfShowLog", "no permission to start Activity");
            } else {
                if (z) {
                    b2.addFlags(268435456);
                } else {
                    b2.setFlags(805437440);
                }
                HMSLog.i("PushSelfShowLog", "start " + b2.toURI());
                this.b.startActivity(b2);
            }
        } catch (Exception e2) {
            HMSLog.e("PushSelfShowLog", "launch Cosa App exception" + e2.toString());
        }
    }
}
