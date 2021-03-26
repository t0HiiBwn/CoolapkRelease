package com.xiaomi.push;

import java.nio.ByteBuffer;

public final class ej extends ef {
    public ej() {
        a("PING", (String) null);
        a("0");
        a(0);
    }

    @Override // com.xiaomi.push.ef
    ByteBuffer a(ByteBuffer byteBuffer) {
        return k().length == 0 ? byteBuffer : super.a(byteBuffer);
    }

    @Override // com.xiaomi.push.ef
    public int l() {
        if (k().length == 0) {
            return 0;
        }
        return super.l();
    }
}
