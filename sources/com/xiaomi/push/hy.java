package com.xiaomi.push;

import java.io.ByteArrayOutputStream;

public class hy extends ByteArrayOutputStream {
    public hy() {
    }

    public hy(int i) {
        super(i);
    }

    public byte[] a() {
        return this.buf;
    }

    public int b() {
        return this.count;
    }
}
