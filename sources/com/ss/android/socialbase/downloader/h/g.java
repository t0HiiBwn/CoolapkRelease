package com.ss.android.socialbase.downloader.h;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* compiled from: WeakDownloadHandler */
public class g extends Handler {
    private final WeakReference<a> a;

    /* compiled from: WeakDownloadHandler */
    public interface a {
        void a(Message message);
    }

    public g(Looper looper, a aVar) {
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
