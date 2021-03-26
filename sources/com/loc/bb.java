package com.loc;

import android.content.Context;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;

/* compiled from: StatisticsEntity */
public final class bb {
    private Context a;
    private String b;
    private String c;
    private String d;
    private String e;

    public bb(Context context, String str, String str2, String str3) throws j {
        if (TextUtils.isEmpty(str3) || str3.length() > 256) {
            throw new j("无效的参数 - IllegalArgumentException");
        }
        this.a = context.getApplicationContext();
        this.c = str;
        this.d = str2;
        this.b = str3;
    }

    public final void a(String str) throws j {
        if (TextUtils.isEmpty(str) || str.length() > 65536) {
            throw new j("无效的参数 - IllegalArgumentException");
        }
        this.e = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x009b  */
    public final byte[] a() {
        Throwable th;
        int i;
        byte[] bArr;
        byte[] bArr2 = new byte[0];
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                u.a(byteArrayOutputStream2, this.c);
                u.a(byteArrayOutputStream2, this.d);
                u.a(byteArrayOutputStream2, this.b);
                u.a(byteArrayOutputStream2, String.valueOf(n.q(this.a)));
                try {
                    i = (int) (System.currentTimeMillis() / 1000);
                } catch (Throwable unused) {
                    i = 0;
                }
                byteArrayOutputStream2.write(new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)});
                if (TextUtils.isEmpty(this.e)) {
                    bArr = new byte[]{0, 0};
                } else {
                    byte[] a2 = u.a(this.e);
                    bArr = a2 == null ? new byte[]{0, 0} : u.a(a2.length);
                }
                byteArrayOutputStream2.write(bArr);
                byteArrayOutputStream2.write(u.a(this.e));
                bArr2 = byteArrayOutputStream2.toByteArray();
                try {
                    byteArrayOutputStream2.close();
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream = byteArrayOutputStream2;
                try {
                    ab.b(th, "se", "tds");
                    if (byteArrayOutputStream != null) {
                    }
                    return bArr2;
                } catch (Throwable th4) {
                    th4.printStackTrace();
                }
            }
        } catch (Throwable th5) {
            th = th5;
            ab.b(th, "se", "tds");
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            return bArr2;
        }
        return bArr2;
        throw th;
    }
}
