package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.b.a.b;
import com.xiaomi.b.a.c;
import com.xiaomi.b.a.d;
import com.xiaomi.b.b.a;

public class dv {
    private static volatile dv a;
    private Context b;

    private dv(Context context) {
        this.b = context;
    }

    public static dv a(Context context) {
        if (a == null) {
            synchronized (dv.class) {
                if (a == null) {
                    a = new dv(context);
                }
            }
        }
        return a;
    }

    private void a(d dVar) {
        if (dVar instanceof c) {
            a.a(this.b, (c) dVar);
        } else if (dVar instanceof b) {
            a.a(this.b, (b) dVar);
        }
    }

    public void a(String str, int i, long j, long j2) {
        if (i >= 0 && j2 >= 0 && j > 0) {
            c a2 = du.a(this.b, i, j, j2);
            a2.a(str);
            a2.b("3_7_5");
            a(a2);
        }
    }

    public void a(String str, Intent intent, int i, String str2) {
        if (intent != null) {
            a(str, du.a(intent.getIntExtra("eventMessageType", -1)), intent.getStringExtra("messageId"), i, System.currentTimeMillis(), str2);
        }
    }

    public void a(String str, Intent intent, String str2) {
        if (intent != null) {
            a(str, du.a(intent.getIntExtra("eventMessageType", -1)), intent.getStringExtra("messageId"), 5001, System.currentTimeMillis(), str2);
        }
    }

    public void a(String str, String str2, String str3, int i, long j, String str4) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            b a2 = du.a(this.b, str2, str3, i, j, str4);
            a2.a(str);
            a2.b("3_7_5");
            a(a2);
        }
    }

    public void a(String str, String str2, String str3, int i, String str4) {
        a(str, str2, str3, i, System.currentTimeMillis(), str4);
    }

    public void a(String str, String str2, String str3, String str4) {
        a(str, str2, str3, 5002, System.currentTimeMillis(), str4);
    }

    public void b(String str, String str2, String str3, String str4) {
        a(str, str2, str3, 5001, System.currentTimeMillis(), str4);
    }

    public void c(String str, String str2, String str3, String str4) {
        a(str, str2, str3, 4002, System.currentTimeMillis(), str4);
    }
}
