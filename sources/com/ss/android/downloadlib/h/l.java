package com.ss.android.downloadlib.h;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* compiled from: WeakHandler */
public class l extends Handler {
    WeakReference<a> a;

    /* compiled from: WeakHandler */
    public interface a {
        void a(Message message);
    }

    public l(Looper looper, a aVar) {
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
