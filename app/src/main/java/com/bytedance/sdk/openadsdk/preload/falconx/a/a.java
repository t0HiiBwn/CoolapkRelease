package com.bytedance.sdk.openadsdk.preload.falconx.a;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.preload.geckox.f.b;
import java.io.File;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: GeckoResLoader */
public class a {
    private b a;
    private AtomicBoolean b = new AtomicBoolean(false);

    public a(Context context, String str, File file) {
        if (context == null) {
            throw new RuntimeException("context == null");
        } else if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("access key empty");
        } else if (file != null) {
            this.a = new b(context, str, file);
        } else {
            throw new RuntimeException("resRootDir == null");
        }
    }

    public InputStream a(String str) throws Exception {
        if (!this.b.get()) {
            com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("WebOffline-falcon", "GeckoResLoader ready to load, file:", str);
            return this.a.a(str);
        }
        throw new RuntimeException("released!");
    }

    public boolean b(String str) throws Exception {
        if (!this.b.get()) {
            return this.a.b(str);
        }
        throw new RuntimeException("released!");
    }

    public void a() throws Exception {
        if (!this.b.getAndSet(true)) {
            this.a.a();
        }
    }
}
