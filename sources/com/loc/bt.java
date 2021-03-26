package com.loc;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: AbstractBuilder */
public abstract class bt {
    bv a = new bv(this.b);
    private ByteBuffer b;

    bt(int i) {
        ByteBuffer allocate = ByteBuffer.allocate(i);
        this.b = allocate;
        allocate.order(ByteOrder.LITTLE_ENDIAN);
    }

    public final bt a() {
        this.a.a(this.b);
        return this;
    }
}
