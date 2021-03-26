package com.amap.api.col.s;

import android.content.Context;
import android.os.Build;
import java.io.ByteArrayOutputStream;

/* compiled from: StatisticsHeaderDataStrategy */
public final class dl extends dn {
    public static int a = 13;
    public static int b = 6;
    private Context e;

    public dl(Context context, dn dnVar) {
        super(dnVar);
        this.e = context;
    }

    @Override // com.amap.api.col.s.dn
    protected final byte[] a(byte[] bArr) {
        byte[] a2 = a(this.e);
        byte[] bArr2 = new byte[(a2.length + bArr.length)];
        System.arraycopy(a2, 0, bArr2, 0, a2.length);
        System.arraycopy(bArr, 0, bArr2, a2.length, bArr.length);
        return bArr2;
    }

    private static byte[] a(Context context) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[0];
        try {
            bs.a(byteArrayOutputStream, "1.2." + a + "." + b);
            bs.a(byteArrayOutputStream, "Android");
            bs.a(byteArrayOutputStream, bm.t(context));
            bs.a(byteArrayOutputStream, bm.m(context));
            bs.a(byteArrayOutputStream, bm.h(context));
            bs.a(byteArrayOutputStream, Build.MANUFACTURER);
            bs.a(byteArrayOutputStream, Build.MODEL);
            bs.a(byteArrayOutputStream, Build.DEVICE);
            bs.a(byteArrayOutputStream, bm.v(context));
            bs.a(byteArrayOutputStream, bi.c(context));
            bs.a(byteArrayOutputStream, bi.d(context));
            bs.a(byteArrayOutputStream, bi.f(context));
            byteArrayOutputStream.write(new byte[]{0});
            bArr = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } catch (Throwable th2) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
            throw th2;
        }
        return bArr;
    }
}
