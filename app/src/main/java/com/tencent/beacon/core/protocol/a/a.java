package com.tencent.beacon.core.protocol.a;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipInputStream;

/* compiled from: CompressUtil */
public final class a {
    private static byte[] a(byte[] bArr) throws Exception {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        byte[] bArr2 = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = gZIPInputStream.read(bArr2, 0, 1024);
            if (read != -1) {
                byteArrayOutputStream.write(bArr2, 0, read);
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                gZIPInputStream.close();
                byteArrayInputStream.close();
                return byteArray;
            }
        }
    }

    public static byte[] a(int i, byte[] bArr) throws Exception {
        byte[] bArr2 = null;
        if (i == 1) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ZipInputStream zipInputStream = new ZipInputStream(byteArrayInputStream);
            while (zipInputStream.getNextEntry() != null) {
                byte[] bArr3 = new byte[1024];
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    int read = zipInputStream.read(bArr3, 0, 1024);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr3, 0, read);
                }
                bArr2 = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
            }
            zipInputStream.close();
            byteArrayInputStream.close();
            return bArr2;
        } else if (i == 2) {
            return a(bArr);
        } else {
            return null;
        }
    }
}
