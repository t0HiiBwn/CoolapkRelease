package com.bytedance.sdk.openadsdk.preload.geckox.f;

import com.bytedance.sdk.openadsdk.preload.geckox.f.a.b;
import com.bytedance.sdk.openadsdk.preload.geckox.f.a.c;
import com.bytedance.sdk.openadsdk.preload.geckox.utils.k;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: ChannelVerLoader */
class a {
    private String a;
    private String b;
    private volatile File c;
    private volatile Long d;
    private volatile com.bytedance.sdk.openadsdk.preload.geckox.f.a.a e;
    private AtomicBoolean f = new AtomicBoolean(false);

    a(String str, String str2, String str3) {
        this.a = str2;
        this.b = str3;
    }

    final InputStream a(String str) throws Exception {
        return c(this.b).a(a(this.b, str));
    }

    final boolean b(String str) throws Exception {
        return c(this.b).b(a(this.b, str));
    }

    private synchronized com.bytedance.sdk.openadsdk.preload.geckox.f.a.a c(String str) throws Exception {
        if (this.e != null) {
            return this.e;
        }
        File d2 = d(str);
        if (d2 != null) {
            File file = new File(d2, "res.macv");
            File file2 = new File(d2, "res");
            if (file2.exists() && file2.isDirectory()) {
                this.e = new c(d2);
            } else if (!file.exists() || !file.isFile()) {
                throw new RuntimeException("can not find res, dir:" + d2.getAbsolutePath());
            } else {
                this.e = new b(d2);
            }
            return this.e;
        }
        throw new FileNotFoundException("channel no exist，channel:" + str);
    }

    private String a(String str, String str2) {
        return str2.substring(str.length() + 1);
    }

    private synchronized File d(String str) throws Exception {
        if (this.c != null) {
            return this.c;
        } else if (this.d != null && this.d.longValue() == -1) {
            return null;
        } else {
            com.bytedance.sdk.openadsdk.preload.geckox.g.b a2 = com.bytedance.sdk.openadsdk.preload.geckox.g.b.a(this.a + File.separator + str + File.separator + "select.lock");
            try {
                if (this.d == null) {
                    this.d = k.a(new File(this.a, str));
                }
                if (this.d == null) {
                    this.d = -1L;
                    return null;
                }
                String str2 = this.a;
                File file = new File(str2, File.separator + str + File.separator + this.d + File.separator + "using.lock");
                this.c = file.getParentFile();
                com.bytedance.sdk.openadsdk.preload.geckox.g.c.a(file.getAbsolutePath());
                File file2 = this.c;
                a2.a();
                return file2;
            } finally {
                a2.a();
            }
        }
    }

    private void b() throws Exception {
        com.bytedance.sdk.openadsdk.preload.geckox.g.b a2 = com.bytedance.sdk.openadsdk.preload.geckox.g.b.a(this.a + File.separator + this.b + File.separator + "select.lock");
        com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-file-lock", "channel version loader clean");
        try {
            if (this.c != null) {
                com.bytedance.sdk.openadsdk.preload.geckox.g.c.b(this.c.getAbsolutePath() + File.separator + "using.lock");
                a2.a();
                com.bytedance.sdk.openadsdk.preload.geckox.a.c.a(this.a + File.separator + this.b);
            }
        } finally {
            a2.a();
        }
    }

    void a() throws Exception {
        if (!this.f.getAndSet(true)) {
            b();
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
        try {
            a();
        } catch (Exception e2) {
            com.bytedance.sdk.openadsdk.preload.geckox.utils.c.a(e2);
        }
    }
}
