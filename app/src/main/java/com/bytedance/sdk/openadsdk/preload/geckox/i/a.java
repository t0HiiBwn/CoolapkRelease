package com.bytedance.sdk.openadsdk.preload.geckox.i;

import com.bytedance.sdk.a.b.aa;
import com.bytedance.sdk.a.b.r;
import com.bytedance.sdk.a.b.u;
import com.bytedance.sdk.a.b.v;
import com.bytedance.sdk.a.b.y;
import com.bytedance.sdk.a.b.z;
import com.bytedance.sdk.openadsdk.preload.geckox.buffer.a.b;
import java.io.BufferedInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* compiled from: DefaultNetWork */
public class a implements b {
    protected v a = new v.a().a(10, TimeUnit.SECONDS).b(10, TimeUnit.SECONDS).c(10, TimeUnit.SECONDS).a();
    protected v b = new v.a().a(10, TimeUnit.SECONDS).b(30, TimeUnit.SECONDS).c(30, TimeUnit.SECONDS).a();

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.i.b
    public c a(String str, String str2) throws Exception {
        aa a2 = this.a.a(new y.a().a(str).a(z.a(u.a("application/json; charset=utf-8"), str2)).d()).a();
        return new c(a(a2.g()), a2.c() == 200 ? a2.h().e() : null, a2.c(), a2.e());
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.i.b
    public void a(String str, long j, b bVar) throws Exception {
        Throwable th;
        Exception e;
        int i;
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            aa a2 = this.b.a(new y.a().a().a(str).d()).a();
            i = a2.c();
            try {
                bufferedInputStream = new BufferedInputStream(a2.h().c());
            } catch (Exception e2) {
                e = e2;
                try {
                    throw new RuntimeException("downloadFile failed, code: " + i + ", url:" + str + ", caused by:" + e.getMessage(), e);
                } catch (Throwable th2) {
                    th = th2;
                    com.bytedance.sdk.openadsdk.preload.geckox.utils.b.a(bufferedInputStream2);
                    throw th;
                }
            }
            try {
                byte[] bArr = new byte[2048];
                while (true) {
                    int read = bufferedInputStream.read(bArr, 0, 2048);
                    if (read != -1) {
                        bVar.write(bArr, 0, read);
                    } else {
                        com.bytedance.sdk.openadsdk.preload.geckox.utils.b.a(bufferedInputStream);
                        return;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                bufferedInputStream2 = bufferedInputStream;
                throw new RuntimeException("downloadFile failed, code: " + i + ", url:" + str + ", caused by:" + e.getMessage(), e);
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream2 = bufferedInputStream;
                com.bytedance.sdk.openadsdk.preload.geckox.utils.b.a(bufferedInputStream2);
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            i = 0;
            throw new RuntimeException("downloadFile failed, code: " + i + ", url:" + str + ", caused by:" + e.getMessage(), e);
        }
    }

    private Map<String, String> a(r rVar) {
        if (rVar == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String str : rVar.b()) {
            hashMap.put(str, rVar.a(str));
        }
        return hashMap;
    }
}
