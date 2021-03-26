package com.bytedance.sdk.openadsdk.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* compiled from: WeakHandler */
public class al extends Handler {
    private final WeakReference<a> a;

    /* compiled from: WeakHandler */
    public interface a {
        void a(Message message);
    }

    public al(a aVar) {
        this.a = new WeakReference<>(aVar);
    }

    public al(Looper looper, a aVar) {
        super(looper);
        this.a = new WeakReference<>(aVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        a aVar = this.a.get();
        if (aVar != null && message != null) {
            aVar.a(message);
        }
    }
}
