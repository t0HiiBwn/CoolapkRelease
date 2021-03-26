package com.bytedance.sdk.openadsdk.preload.geckox.f.a;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: FileLoader */
public abstract class a {
    private File a;

    protected abstract InputStream a(File file, String str) throws IOException;

    protected abstract boolean b(File file, String str) throws IOException;

    public a(File file) {
        this.a = file;
    }

    public final InputStream a(String str) throws IOException {
        return a(this.a, str);
    }

    public final boolean b(String str) throws IOException {
        return b(this.a, str);
    }
}
