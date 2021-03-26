package com.bytedance.sdk.openadsdk.i;

import com.bytedance.sdk.openadsdk.i.g.d;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* compiled from: RandomAccessFileWrapper */
class h {
    private final RandomAccessFile a;

    h(File file, String str) throws a {
        try {
            this.a = new RandomAccessFile(file, str);
        } catch (FileNotFoundException e) {
            throw new a(e);
        }
    }

    void a(long j) throws a {
        try {
            this.a.seek(j);
        } catch (IOException e) {
            throw new a(e);
        }
    }

    void a(byte[] bArr, int i, int i2) throws a {
        try {
            this.a.write(bArr, i, i2);
        } catch (IOException e) {
            throw new a(e);
        }
    }

    int a(byte[] bArr) throws a {
        try {
            return this.a.read(bArr);
        } catch (IOException e) {
            throw new a(e);
        }
    }

    void a() {
        d.a(this.a);
    }

    /* compiled from: RandomAccessFileWrapper */
    static class a extends Exception {
        a(Throwable th) {
            super(th);
        }
    }
}
