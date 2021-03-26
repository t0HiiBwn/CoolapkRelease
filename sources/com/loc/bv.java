package com.loc;

import java.nio.ByteBuffer;

/* compiled from: RobustFlatBufferBuilder */
public final class bv extends er {
    bv(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    @Override // com.loc.er
    public final int a(CharSequence charSequence) {
        try {
            return super.a(charSequence);
        } catch (Throwable th) {
            dg.a(th);
            return super.a("");
        }
    }
}
