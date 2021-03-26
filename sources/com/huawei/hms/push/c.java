package com.huawei.hms.push;

import android.content.Context;
import android.content.Intent;
import java.util.concurrent.Callable;

/* compiled from: IntentCallable */
public class c implements Callable<Void> {
    private Context a;
    private Intent b;
    private String c;

    public c(Context context, Intent intent, String str) {
        this.a = context;
        this.b = intent;
        this.c = str;
    }

    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        this.a.sendBroadcast(this.b);
        g.a(this.a, "push.setNotifyFlag", this.c, a.SUCCESS);
        return null;
    }
}
