package com.amap.api.mapcore2d;

import android.content.Context;
import android.os.Build;
import java.io.ByteArrayOutputStream;

/* compiled from: StatisticsHeaderDataStrategy */
public class fm extends fo {
    public static int a = 13;
    public static int b = 6;
    private Context e;

    public fm(Context context, fo foVar) {
        super(foVar);
        this.e = context;
    }

    @Override // com.amap.api.mapcore2d.fo
    protected byte[] a(byte[] bArr) {
        byte[] a2 = a(this.e);
        byte[] bArr2 = new byte[(a2.length + bArr.length)];
        System.arraycopy(a2, 0, bArr2, 0, a2.length);
        System.arraycopy(bArr, 0, bArr2, a2.length, bArr.length);
        return bArr2;
    }

    private byte[] a(Context context) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[0];
        try {
            db.a(byteArrayOutputStream, "1.2." + a + "." + b);
            db.a(byteArrayOutputStream, "Android");
            db.a(byteArrayOutputStream, cu.v(context));
            db.a(byteArrayOutputStream, cu.m(context));
            db.a(byteArrayOutputStream, cu.h(context));
            db.a(byteArrayOutputStream, Build.MANUFACTURER);
            db.a(byteArrayOutputStream, Build.MODEL);
            db.a(byteArrayOutputStream, Build.DEVICE);
            db.a(byteArrayOutputStream, cu.x(context));
            db.a(byteArrayOutputStream, cq.c(context));
            db.a(byteArrayOutputStream, cq.d(context));
            db.a(byteArrayOutputStream, cq.f(context));
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
