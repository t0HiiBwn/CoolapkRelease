package com.bytedance.sdk.openadsdk.preload.geckox.f.a;

import com.bytedance.sdk.openadsdk.preload.geckox.h.b;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: NormalFileLoader */
public class c extends a {
    public c(File file) {
        super(file);
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.f.a.a
    protected InputStream a(File file, String str) throws IOException {
        File file2 = new File(file, "res" + File.separator + str);
        if (file2.getCanonicalPath().startsWith(file.getCanonicalPath())) {
            b.a("gecko-debug-tag", "NormalFileLoader, file:", file2.getAbsolutePath());
            return new FileInputStream(file2.getCanonicalFile());
        }
        throw new IOException("file not found");
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.f.a.a
    protected boolean b(File file, String str) throws IOException {
        return new File(file, "res" + File.separator + str).exists();
    }
}
