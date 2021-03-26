package com.bytedance.tea.crash.upload;

import android.content.Context;
import com.bytedance.tea.crash.f.c;
import com.bytedance.tea.crash.g.i;
import com.bytedance.tea.crash.h;

/* compiled from: LaunchScanner */
public final class d implements Runnable {
    private Context a;

    private d(Context context) {
        this.a = context;
    }

    public static void a(Context context, int i) {
        try {
            if (!h.a().d().equals(context.getPackageName())) {
                return;
            }
        } catch (Exception unused) {
        }
        com.bytedance.tea.crash.e.h.b().postDelayed(new d(context), (long) i);
    }

    public static void a(Context context) {
        a(context, 0);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            new com.bytedance.tea.crash.e.d(this.a).a(i.b(this.a));
        } catch (Throwable th) {
            c.a(com.bytedance.tea.crash.e.h.b(), this.a).a();
            throw th;
        }
        c.a(com.bytedance.tea.crash.e.h.b(), this.a).a();
    }
}
