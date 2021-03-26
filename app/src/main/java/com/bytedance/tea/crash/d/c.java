package com.bytedance.tea.crash.d;

import android.content.Context;
import com.bytedance.tea.crash.c.a;
import com.bytedance.tea.crash.e.a.e;
import com.bytedance.tea.crash.g.d;

/* compiled from: JavaCrash */
public class c implements b {
    private Context a;

    @Override // com.bytedance.tea.crash.d.b
    public boolean a(Throwable th) {
        return true;
    }

    @Override // com.bytedance.tea.crash.d.b
    public void a(long j, Thread thread, Throwable th) {
        a a2 = a.a(j, this.a, thread, th);
        d.a(this.a, com.bytedance.tea.crash.c.JAVA.a(), Thread.currentThread().getName());
        com.bytedance.tea.crash.upload.a.a().a(e.a().a(com.bytedance.tea.crash.c.JAVA, a2).a());
    }

    public c(Context context) {
        this.a = context;
    }
}
