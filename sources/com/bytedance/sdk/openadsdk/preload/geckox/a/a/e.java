package com.bytedance.sdk.openadsdk.preload.geckox.a.a;

import com.bytedance.sdk.openadsdk.preload.geckox.a.c;
import com.bytedance.sdk.openadsdk.preload.geckox.utils.d;
import java.io.File;
import java.util.List;

/* compiled from: FIFOCachePolicy */
class e extends b {
    e() {
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.a.a.b
    public void a(a aVar, File file, List<String> list) {
        super.a(aVar, file, list);
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.a.a.b
    public void a() {
        for (String str : this.f) {
            List<File> b = d.b(new File(this.e, str));
            if (b != null && b.size() > this.d.b()) {
                for (File file : b.subList(0, b.size() - this.d.b())) {
                    boolean b2 = c.b(file.getAbsolutePath());
                    if (this.d.c() != null) {
                        this.d.c().a(file.getName(), b2);
                    }
                }
            }
        }
    }
}
