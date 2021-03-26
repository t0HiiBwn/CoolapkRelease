package com.kepler.sdk;

import android.content.Context;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ai {
    private ExecutorService a;
    private String b;
    private Context c;
    private String d;

    public void a(String str) {
        this.b = str;
    }

    public void a(Context context) {
        this.c = context;
    }

    public void b(String str) {
        this.d = str;
    }

    void a() {
        if (this.c != null) {
            String str = this.b;
            if (str == null || str.length() == 0) {
                throw new IllegalStateException("app key is null");
            }
            String str2 = this.d;
            if (str2 == null || !al.a(str2)) {
                throw new IllegalStateException("server URL is null");
            }
            return;
        }
        throw new IllegalStateException("context is null ");
    }

    public void b() {
        if (aj.a()) {
            a();
            c("_appkey=" + this.b + "&_sv=" + al.a + "&_av=" + ak.c(this.c) + "&_m=" + ak.d(this.c) + "&start=" + ak.e(this.c));
        }
    }

    void c() {
        if (this.a == null) {
            this.a = Executors.newSingleThreadExecutor();
        }
    }

    void c(String str) {
        c();
        this.a.submit(new ah(this.d, str, this.c));
    }
}
