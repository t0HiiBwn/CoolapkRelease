package com.bytedance.sdk.a.b;

import com.bytedance.sdk.a.a.d;
import com.bytedance.sdk.a.b.a.c;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;

/* compiled from: RequestBody */
public abstract class z {
    public abstract u a();

    public abstract void a(d dVar) throws IOException;

    public long b() throws IOException {
        return -1;
    }

    public static z a(u uVar, String str) {
        Charset charset = c.e;
        if (uVar != null && (charset = uVar.a()) == null) {
            charset = c.e;
            uVar = u.a(uVar + "; charset=utf-8");
        }
        return a(uVar, str.getBytes(charset));
    }

    public static z a(u uVar, byte[] bArr) {
        return a(uVar, bArr, 0, bArr.length);
    }

    public static z a(final u uVar, final byte[] bArr, final int i, final int i2) {
        Objects.requireNonNull(bArr, "content == null");
        c.a((long) bArr.length, (long) i, (long) i2);
        return new z() {
            /* class com.bytedance.sdk.a.b.z.AnonymousClass1 */

            @Override // com.bytedance.sdk.a.b.z
            public u a() {
                return uVar;
            }

            @Override // com.bytedance.sdk.a.b.z
            public long b() {
                return (long) i2;
            }

            @Override // com.bytedance.sdk.a.b.z
            public void a(d dVar) throws IOException {
                dVar.c(bArr, i, i2);
            }
        };
    }
}
