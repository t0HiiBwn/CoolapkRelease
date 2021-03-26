package com.tencent.msdk.dns.base.jni;

import com.tencent.msdk.dns.base.log.b;

/* compiled from: JniWrapper */
public final class a {
    static {
        try {
            System.loadLibrary("httpdns");
        } catch (Throwable unused) {
            b.c("Load dns so failed", new Object[0]);
        }
    }

    public static int a() {
        try {
            return Jni.getNetworkStack();
        } catch (Throwable unused) {
            b.c("Get cur network stack failed", new Object[0]);
            return 0;
        }
    }

    public static byte[] a(byte[] bArr, String str, int i) {
        try {
            return Jni.desCrypt(bArr, str, i);
        } catch (Throwable unused) {
            b.c("dnsCrypt failed", new Object[0]);
            return null;
        }
    }

    public static byte[] a(byte[] bArr, String str, int i, byte[] bArr2) {
        try {
            return Jni.aesCrypt(bArr, str, i, bArr2);
        } catch (Throwable unused) {
            b.c("dnsCrypt failed", new Object[0]);
            return null;
        }
    }
}
