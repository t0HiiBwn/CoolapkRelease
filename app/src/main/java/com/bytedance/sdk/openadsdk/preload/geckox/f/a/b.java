package com.bytedance.sdk.openadsdk.preload.geckox.f.a;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: MyArchiveFileLoader */
public class b extends a {
    public b(File file) {
        super(file);
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.f.a.a
    protected InputStream a(File file, String str) throws IOException {
        com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "MyArchiveFileLoader, file:", new File(str).getCanonicalPath());
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.f.a.a
    protected boolean b(File file, String str) throws IOException {
        new File(str).getCanonicalPath();
        return false;
    }
}
