package com.huawei.hms.stats;

import android.text.TextUtils;
import com.huawei.hms.stats.e;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

public class ae {
    private static ae a = new ae();
    private a b = new a();

    class a {
        String a;
        String b;
        String c;
        long d = 0;

        a() {
        }

        void a(long j) {
            ae.this.b.d = j;
        }

        void a(String str) {
            ae.this.b.a = str;
        }

        void b(String str) {
            ae.this.b.b = str;
        }

        void c(String str) {
            ae.this.b.c = str;
        }
    }

    public static ae a() {
        return a;
    }

    private String f() {
        InputStream inputStream;
        Throwable th;
        try {
            inputStream = b.j().getResources().getAssets().open("hianalytics_njjn");
            try {
                String a2 = ba.a(inputStream);
                ba.a((Closeable) inputStream);
                return a2;
            } catch (IOException unused) {
                try {
                    af.c("hmsSdk", "read pubKey error,the file is corrupted");
                    ba.a((Closeable) inputStream);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    ba.a((Closeable) inputStream);
                    throw th;
                }
            }
        } catch (IOException unused2) {
            inputStream = null;
            af.c("hmsSdk", "read pubKey error,the file is corrupted");
            ba.a((Closeable) inputStream);
            return null;
        } catch (Throwable th3) {
            inputStream = null;
            th = th3;
            ba.a((Closeable) inputStream);
            throw th;
        }
    }

    public void b() {
        long e = e();
        if (e == 0) {
            long currentTimeMillis = System.currentTimeMillis();
            String f = f();
            if (TextUtils.isEmpty(f)) {
                af.c("hmsSdk", "get rsa pubkey config error");
                return;
            }
            String b2 = e.a().b(e.a.AES);
            String b3 = e.a().a(e.a.RSA).b(f, b2);
            this.b.a(f);
            this.b.a(currentTimeMillis);
            this.b.b(b2);
            this.b.c(b3);
            return;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (currentTimeMillis2 - e > 43200000) {
            String str = this.b.a;
            String b4 = e.a().b(e.a.AES);
            String b5 = e.a().a(e.a.RSA).b(str, b4);
            this.b.a(currentTimeMillis2);
            this.b.b(b4);
            this.b.c(b5);
        }
    }

    public String c() {
        return this.b.b;
    }

    public String d() {
        return this.b.c;
    }

    public long e() {
        return this.b.d;
    }
}
