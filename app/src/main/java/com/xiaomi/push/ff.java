package com.xiaomi.push;

import java.nio.ByteBuffer;

public final class ff extends fb {
    public ff() {
        a("PING", (String) null);
        a("0");
        a(0);
    }

    @Override // com.xiaomi.push.fb
    /* renamed from: a */
    ByteBuffer mo318a(ByteBuffer byteBuffer) {
        return a().length == 0 ? byteBuffer : super.mo318a(byteBuffer);
    }

    @Override // com.xiaomi.push.fb
    public int c() {
        if (a().length == 0) {
            return 0;
        }
        return super.c();
    }
}
