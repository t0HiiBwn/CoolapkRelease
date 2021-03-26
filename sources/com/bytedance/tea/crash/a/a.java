package com.bytedance.tea.crash.a;

import android.os.FileObserver;
import android.os.SystemClock;
import android.text.TextUtils;

/* compiled from: ANRFileObserver */
public class a extends FileObserver {
    private final c a;
    private final int b = 5000;
    private volatile boolean c = true;

    public a(c cVar, String str, int i) {
        super(str, i);
        if (cVar == null || TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("params is not right path is null or ANRManager is null");
        }
        this.a = cVar;
    }

    @Override // android.os.FileObserver
    public void onEvent(int i, String str) {
        if (this.c && i == 8 && !TextUtils.isEmpty(str) && str.contains("trace") && this.a != null) {
            this.c = false;
            c cVar = this.a;
            cVar.a(200, "/data/anr/" + str, 80);
            new C0068a(5000).start();
        }
    }

    /* renamed from: com.bytedance.tea.crash.a.a$a  reason: collision with other inner class name */
    /* compiled from: ANRFileObserver */
    private final class C0068a extends Thread {
        private int b;

        C0068a(int i) {
            this.b = i;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            SystemClock.sleep((long) this.b);
            a.this.c = true;
        }
    }
}
