package com.tencent.msdk.dns.base.jni;

public final class Jni {
    public static native byte[] aesCrypt(byte[] bArr, String str, int i, byte[] bArr2);

    public static native byte[] desCrypt(byte[] bArr, String str, int i);

    public static native int getNetworkStack();
}
