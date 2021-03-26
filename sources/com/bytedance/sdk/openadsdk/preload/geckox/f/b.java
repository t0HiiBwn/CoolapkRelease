package com.bytedance.sdk.openadsdk.preload.geckox.f;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: VersionedResLoader */
public class b {
    private final Map<String, a> a = new HashMap();
    private String b;
    private AtomicBoolean c = new AtomicBoolean(false);
    private String d;

    public b(Context context, String str, File file) {
        if (!TextUtils.isEmpty(str)) {
            this.b = str;
            if (file == null) {
                File filesDir = context.getFilesDir();
                this.d = new File(filesDir, "gecko_offline_res_x" + File.separator + str).getAbsolutePath();
                return;
            }
            this.d = new File(file, str).getAbsolutePath();
            return;
        }
        throw new RuntimeException("access key empty");
    }

    public InputStream a(String str) throws Exception {
        if (this.c.get()) {
            throw new RuntimeException("released");
        } else if (!TextUtils.isEmpty(str)) {
            return c(str.trim()).a(str);
        } else {
            throw new RuntimeException("relativePath empty");
        }
    }

    public boolean b(String str) throws Exception {
        if (this.c.get()) {
            throw new RuntimeException("released");
        } else if (!TextUtils.isEmpty(str)) {
            return c(str.trim()).b(str);
        } else {
            throw new RuntimeException("relativePath empty");
        }
    }

    private a c(String str) {
        a aVar;
        int indexOf = str.indexOf("/");
        if (indexOf == -1) {
            new RuntimeException("缺少channel：" + str);
        }
        String substring = str.substring(0, indexOf);
        synchronized (this.a) {
            aVar = this.a.get(substring);
            if (aVar == null) {
                aVar = new a(this.b, this.d, substring);
                this.a.put(substring, aVar);
            }
        }
        return aVar;
    }

    public void a() throws Exception {
        if (!this.c.getAndSet(true)) {
            com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("Loader", "release version res loader");
            b();
        }
    }

    private void b() throws Exception {
        synchronized (this.a) {
            for (a aVar : this.a.values()) {
                aVar.a();
            }
            this.a.clear();
        }
    }
}
