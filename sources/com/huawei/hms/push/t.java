package com.huawei.hms.push;

import android.content.Context;
import android.content.Intent;
import com.huawei.hms.support.log.HMSLog;

/* compiled from: PushSelfShowThread */
public class t extends Thread {
    private Context a;
    private o b;

    public t(Context context, o oVar) {
        this.a = context;
        this.b = oVar;
    }

    private static Intent a(Context context, o oVar) {
        if (oVar == null) {
            return null;
        }
        Intent b2 = u.b(context, oVar.m());
        if (oVar.g() != null) {
            try {
                Intent parseUri = Intent.parseUri(oVar.g(), 0);
                HMSLog.d("PushSelfShowLog", "Intent.parseUri(msg.intentUri, 0)，" + parseUri.getAction());
                return u.a(context, oVar.m(), parseUri).booleanValue() ? parseUri : b2;
            } catch (Exception e) {
                HMSLog.w("PushSelfShowLog", "intentUri error" + e.toString());
                return b2;
            }
        } else {
            if (oVar.n() != null) {
                Intent intent = new Intent(oVar.n());
                if (u.a(context, oVar.m(), intent).booleanValue()) {
                    b2 = intent;
                }
            }
            b2.setPackage(oVar.m());
            return b2;
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        HMSLog.i("PushSelfShowLog", "enter run()");
        try {
            if (a(this.a) && !b(this.a, this.b)) {
                s.a(this.a, this.b);
            }
        } catch (Exception e) {
            HMSLog.e("PushSelfShowLog", e.toString());
        }
    }

    private boolean a(Context context) {
        if ("cosa".equals(this.b.j())) {
            return b(context);
        }
        return true;
    }

    private boolean b(Context context) {
        return u.c(context, this.b.m());
    }

    private boolean b(Context context, o oVar) {
        boolean z = false;
        if (!"cosa".equals(oVar.j())) {
            return false;
        }
        Intent a2 = a(context, oVar);
        if (a2 == null) {
            HMSLog.d("PushSelfShowLog", "launchCosaApp,intent == null");
            z = true;
        }
        if (u.a(context, a2)) {
            return z;
        }
        HMSLog.i("PushSelfShowLog", "no permission to start activity");
        return true;
    }
}
