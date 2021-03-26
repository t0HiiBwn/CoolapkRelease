package com.xiaomi.push;

import java.io.ByteArrayOutputStream;

public class iq extends ByteArrayOutputStream {
    public iq() {
    }

    public iq(int i) {
        super(i);
    }

    public int a() {
        return this.count;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m531a() {
        return this.buf;
    }
}
