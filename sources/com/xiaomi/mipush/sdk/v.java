package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import android.text.TextUtils;
import com.xiaomi.a.a.a.c;
import com.xiaomi.push.aa;
import com.xiaomi.push.ah;
import com.xiaomi.push.gn;
import com.xiaomi.push.iz;
import com.xiaomi.push.j;
import com.xiaomi.push.service.l;
import java.lang.Thread;

class v implements Thread.UncaughtExceptionHandler {
    private static final Object a = new Object();

    /* renamed from: a  reason: collision with other field name */
    private static final String[] f161a = {"com.xiaomi.channel.commonutils", "com.xiaomi.common.logger", "com.xiaomi.measite.smack", "com.xiaomi.metoknlp", "com.xiaomi.mipush.sdk", "com.xiaomi.network", "com.xiaomi.push", "com.xiaomi.slim", "com.xiaomi.smack", "com.xiaomi.stats", "com.xiaomi.tinyData", "com.xiaomi.xmpush.thrift", "com.xiaomi.clientreport"};

    /* renamed from: a  reason: collision with other field name */
    private Context f162a;

    /* renamed from: a  reason: collision with other field name */
    private SharedPreferences f163a;

    /* renamed from: a  reason: collision with other field name */
    private Thread.UncaughtExceptionHandler f164a;

    public v(Context context) {
        this(context, Thread.getDefaultUncaughtExceptionHandler());
    }

    public v(Context context, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f162a = context;
        this.f164a = uncaughtExceptionHandler;
    }

    private String a(Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Math.min(3, stackTrace.length); i++) {
            sb.append(stackTrace[i].toString() + "\r\n");
        }
        String sb2 = sb.toString();
        return TextUtils.isEmpty(sb2) ? "" : ah.a(sb2);
    }

    private void a() {
        j.a(this.f162a).a(new w(this));
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m78a(Throwable th) {
        String b = b(th);
        if (!TextUtils.isEmpty(b)) {
            String a2 = a(th);
            if (!TextUtils.isEmpty(a2)) {
                s.a(this.f162a).a(b, a2);
                if (m79a()) {
                    a();
                }
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m79a() {
        this.f163a = this.f162a.getSharedPreferences("mipush_extra", 4);
        if (aa.f(this.f162a)) {
            if (!l.a(this.f162a).a(gn.Crash4GUploadSwitch.a(), true)) {
                return false;
            }
            return ((float) Math.abs((System.currentTimeMillis() / 1000) - this.f163a.getLong("last_crash_upload_time_stamp", 0))) >= ((float) Math.max(3600, l.a(this.f162a).a(gn.Crash4GUploadFrequency.a(), 3600))) * 0.9f;
        } else if (!aa.e(this.f162a)) {
            return true;
        } else {
            return Math.abs((System.currentTimeMillis() / 1000) - this.f163a.getLong("last_crash_upload_time_stamp", 0)) >= ((long) Math.max(60, l.a(this.f162a).a(gn.CrashWIFIUploadFrequency.a(), 1800)));
        }
    }

    private boolean a(boolean z, String str) {
        for (String str2 : f161a) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return z;
    }

    private String b(Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        StringBuilder sb = new StringBuilder(th.toString());
        sb.append("\r\n");
        boolean z = false;
        for (StackTraceElement stackTraceElement : stackTrace) {
            String stackTraceElement2 = stackTraceElement.toString();
            z = a(z, stackTraceElement2);
            sb.append(stackTraceElement2);
            sb.append("\r\n");
        }
        return z ? sb.toString() : "";
    }

    private void b() {
        SharedPreferences sharedPreferences = this.f162a.getSharedPreferences("mipush_extra", 4);
        this.f163a = sharedPreferences;
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putLong("last_crash_upload_time_stamp", System.currentTimeMillis() / 1000);
        iz.a(edit);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        m78a(th);
        Object obj = a;
        synchronized (obj) {
            try {
                obj.wait(3000);
            } catch (InterruptedException e) {
                c.a(e);
            }
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f164a;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
            return;
        }
        Process.killProcess(Process.myPid());
        System.exit(1);
    }
}
