package com.huawei.updatesdk.a.a.a;

import java.util.ArrayDeque;
import java.util.Queue;

public final class a {
    private static final a a = new a();
    private final Queue<byte[]> b = new ArrayDeque(0);

    private a() {
    }

    public static a a() {
        return a;
    }

    public void a(byte[] bArr) {
        if (bArr.length == 65536) {
            synchronized (this.b) {
                if (this.b.size() < 32 && !this.b.offer(bArr)) {
                    com.huawei.updatesdk.a.a.b.a.a.a.a("ByteArrayPool", "releaseBytes false");
                }
            }
        }
    }

    public byte[] b() {
        byte[] poll;
        synchronized (this.b) {
            poll = this.b.poll();
        }
        return poll == null ? new byte[65536] : poll;
    }
}
