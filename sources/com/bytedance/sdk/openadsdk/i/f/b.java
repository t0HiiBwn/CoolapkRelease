package com.bytedance.sdk.openadsdk.i.f;

import java.io.Serializable;

/* compiled from: VideoUrlModel */
public class b implements Serializable {
    public String a;
    public int b = 204800;
    public String c;

    public b a(String str) {
        this.a = str;
        return this;
    }

    public b a(int i) {
        if (i > 0) {
            this.b = i;
        }
        return this;
    }

    public b b(String str) {
        this.c = str;
        return this;
    }

    @Override // java.lang.Object
    public String toString() {
        return "VideoUrlModel{url='" + this.a + "', maxPreloadSize=" + this.b + ", fileNameKey='" + this.c + "'}";
    }
}
