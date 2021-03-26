package com.qq.e.comm.net.rr;

import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public final class a {
    private static final byte[] a = {91, -62};
    private static Cipher b = null;
    private static Cipher c = null;
    private static String d = String.format("AES/%s/PKCS7Padding", "ECB");
    private static byte[] e = Base64.decode("4M3PpUC4Vu1uMp+Y0Mxd+vfc6v4ggJAINfgTlH74pis=", 0);

    /* renamed from: com.qq.e.comm.net.rr.a$a  reason: collision with other inner class name */
    static class C0077a extends Exception {
        public C0077a(String str, Throwable th) {
            super(str, th);
        }
    }

    public static class b extends Exception {
        public b(String str, Throwable th) {
            super(str, th);
        }
    }

    private static synchronized Cipher a() throws C0077a {
        synchronized (a.class) {
            Cipher cipher = b;
            if (cipher != null) {
                return cipher;
            }
            try {
                Cipher instance = Cipher.getInstance(d);
                instance.init(1, new SecretKeySpec(e, "AES"));
                b = instance;
                return instance;
            } catch (Exception e2) {
                throw new C0077a("Fail To Init Cipher", e2);
            }
        }
    }

    public static byte[] a(byte[] bArr) throws b {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.write(a);
            dataOutputStream.writeByte(1);
            dataOutputStream.writeByte(2);
            dataOutputStream.write(c(com.qq.e.comm.a.a(bArr)));
            dataOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e2) {
            throw new b("Exception while packaging byte array", e2);
        }
    }

    private static synchronized Cipher b() throws C0077a {
        synchronized (a.class) {
            Cipher cipher = c;
            if (cipher != null) {
                return cipher;
            }
            try {
                Cipher instance = Cipher.getInstance(d);
                instance.init(2, new SecretKeySpec(e, "AES"));
                c = instance;
                return instance;
            } catch (Exception e2) {
                throw new C0077a("Fail To Init Cipher", e2);
            }
        }
    }

    public static byte[] b(byte[] bArr) throws b {
        if (bArr == null || bArr.length < 4) {
            throw new b("S2SS Package FormatError", null);
        }
        try {
            byte[] bArr2 = new byte[4];
            new DataInputStream(new ByteArrayInputStream(bArr)).read(bArr2);
            byte[] bArr3 = a;
            if (bArr3[0] == bArr2[0] && bArr3[1] == bArr2[1] && 1 == bArr2[2] && 2 == bArr2[3]) {
                return com.qq.e.comm.a.b(d(Arrays.copyOfRange(bArr, 4, bArr.length)));
            }
            throw new b("S2SS Package Magic/Version FormatError", null);
        } catch (Exception e2) {
            throw new b("Exception while packaging byte array", e2);
        }
    }

    private static byte[] c(byte[] bArr) throws C0077a {
        try {
            return a().doFinal(bArr);
        } catch (Exception e2) {
            throw new C0077a("Exception While encrypt byte array", e2);
        }
    }

    private static byte[] d(byte[] bArr) throws C0077a {
        try {
            return b().doFinal(bArr);
        } catch (Exception e2) {
            throw new C0077a("Exception While dencrypt byte array", e2);
        }
    }
}
