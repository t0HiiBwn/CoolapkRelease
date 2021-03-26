package com.tencent.android.tpush.common;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* compiled from: ProGuard */
public class f {
    public static String a(Serializable serializable) {
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        ObjectOutputStream objectOutputStream;
        if (serializable == null) {
            return "";
        }
        ObjectOutputStream objectOutputStream2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            } catch (Throwable th2) {
                th = th2;
                try {
                    throw th;
                } catch (Throwable th3) {
                    if (objectOutputStream2 != null) {
                        objectOutputStream2.close();
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    throw th3;
                }
            }
            try {
                objectOutputStream.writeObject(serializable);
                String a = a(byteArrayOutputStream.toByteArray());
                objectOutputStream.close();
                byteArrayOutputStream.close();
                return a;
            } catch (Throwable th4) {
                th = th4;
                objectOutputStream2 = objectOutputStream;
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            byteArrayOutputStream = null;
            throw th;
        }
    }

    public static Object a(String str) {
        ObjectInputStream objectInputStream;
        ByteArrayInputStream byteArrayInputStream;
        Throwable th;
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            byteArrayInputStream = new ByteArrayInputStream(b(str));
            try {
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
            } catch (Throwable th2) {
                th = th2;
                objectInputStream = null;
                try {
                    throw th;
                } catch (Throwable th3) {
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    if (byteArrayInputStream != null) {
                        byteArrayInputStream.close();
                    }
                    throw th3;
                }
            }
            try {
                Object readObject = objectInputStream.readObject();
                objectInputStream.close();
                byteArrayInputStream.close();
                return readObject;
            } catch (Throwable th4) {
                th = th4;
                throw th;
            }
        } catch (Throwable th5) {
            byteArrayInputStream = null;
            th = th5;
            objectInputStream = null;
            throw th;
        }
    }

    public static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < bArr.length; i++) {
            stringBuffer.append((char) (((bArr[i] >> 4) & 15) + 97));
            stringBuffer.append((char) ((bArr[i] & 15) + 97));
        }
        return stringBuffer.toString();
    }

    public static byte[] b(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < str.length(); i += 2) {
            char charAt = str.charAt(i);
            int i2 = i / 2;
            if (i2 < length) {
                bArr[i2] = (byte) ((charAt - 'a') << 4);
                bArr[i2] = (byte) (bArr[i2] + (str.charAt(i + 1) - 'a'));
            }
        }
        return bArr;
    }
}
