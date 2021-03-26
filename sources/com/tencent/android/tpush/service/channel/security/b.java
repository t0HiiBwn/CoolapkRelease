package com.tencent.android.tpush.service.channel.security;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ProGuard */
public class b extends FilterInputStream {
    private static final char[] a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private static final int[] b = new int[128];
    private int c;
    private int d;

    static {
        for (int i = 0; i < 64; i++) {
            b[a[i]] = i;
        }
    }

    public b(InputStream inputStream) {
        super(inputStream);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        int read;
        do {
            read = this.in.read();
            if (read == -1) {
                return -1;
            }
        } while (Character.isWhitespace((char) read));
        int i = this.c + 1;
        this.c = i;
        if (read == 61) {
            return -1;
        }
        int i2 = b[read];
        int i3 = (i - 1) % 4;
        if (i3 == 0) {
            this.d = i2 & 63;
            return read();
        } else if (i3 == 1) {
            int i4 = ((this.d << 2) + (i2 >> 4)) & 255;
            this.d = i2 & 15;
            return i4;
        } else if (i3 == 2) {
            int i5 = ((this.d << 4) + (i2 >> 2)) & 255;
            this.d = i2 & 3;
            return i5;
        } else if (i3 == 3) {
            return ((this.d << 6) + i2) & 255;
        } else {
            return -1;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        if (bArr.length >= (i2 + i) - 1) {
            int i3 = 0;
            while (i3 < i2) {
                int read = read();
                if (read == -1 && i3 == 0) {
                    return -1;
                }
                if (read == -1) {
                    break;
                }
                bArr[i + i3] = (byte) read;
                i3++;
            }
            return i3;
        }
        throw new IOException("The input buffer is too small: " + i2 + " bytes requested starting at offset " + i + " while the buffer  is only " + bArr.length + " bytes long.");
    }

    public static byte[] a(String str) {
        byte[] bArr = new byte[0];
        try {
            bArr = str.getBytes("UTF-8");
        } catch (Throwable unused) {
        }
        b bVar = new b(new ByteArrayInputStream(bArr));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((int) (((double) bArr.length) * 0.67d));
        try {
            byte[] bArr2 = new byte[4096];
            while (true) {
                int read = bVar.read(bArr2);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                } else {
                    bVar.close();
                    byteArrayOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException unused2) {
            return null;
        }
    }
}
