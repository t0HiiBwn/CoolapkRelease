package com.bytedance.sdk.openadsdk.core.video.a;

import android.content.Context;
import android.media.MediaDataSource;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.video.a.a.a;
import com.bytedance.sdk.openadsdk.core.video.a.a.c;
import com.bytedance.sdk.openadsdk.utils.u;
import java.io.IOException;

/* compiled from: SdkMediaDataSource */
public class b extends MediaDataSource {
    private String a;
    private String b;
    private a c = null;
    private long d = -2147483648L;
    private Context e;

    public b(Context context, String str, String str2) {
        this.e = context;
        this.a = str;
        if (TextUtils.isEmpty(str2)) {
            this.b = com.bytedance.sdk.openadsdk.i.g.b.a(str);
        } else {
            this.b = str2;
        }
    }

    @Override // android.media.MediaDataSource
    public int readAt(long j, byte[] bArr, int i, int i2) throws IOException {
        b();
        int a2 = this.c.a(j, bArr, i, i2);
        u.c("SdkMediaDataSource", "readAt: position = " + j + "  buffer.length =" + bArr.length + "  offset = " + i + " size =" + a2 + "  current = " + Thread.currentThread());
        return a2;
    }

    private void b() {
        if (this.c == null) {
            String str = this.a;
            String str2 = this.b;
            this.c = new com.bytedance.sdk.openadsdk.core.video.a.a.b(str, str2, c.a(this.e, str2));
        }
    }

    @Override // android.media.MediaDataSource
    public long getSize() throws IOException {
        b();
        if (this.d == -2147483648L) {
            if (this.e == null || TextUtils.isEmpty(this.a)) {
                return -1;
            }
            this.d = this.c.b();
            u.c("SdkMediaDataSource", "getSize: " + this.d);
        }
        return this.d;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        u.c("SdkMediaDataSource", "close: " + this.a);
        a aVar = this.c;
        if (aVar != null) {
            aVar.a();
        }
    }

    public boolean a() {
        b();
        return this.c.c();
    }
}
