package com.umeng.analytics.pro;

import java.io.ByteArrayOutputStream;

/* compiled from: TByteArrayOutputStream */
public class bk extends ByteArrayOutputStream {
    public bk(int i) {
        super(i);
    }

    public bk() {
    }

    public byte[] a() {
        return this.buf;
    }

    public int b() {
        return this.count;
    }
}
