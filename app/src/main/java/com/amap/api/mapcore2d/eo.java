package com.amap.api.mapcore2d;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* compiled from: StrictLineReader */
public class eo implements Closeable {
    private final InputStream a;
    private final Charset b;
    private byte[] c;
    private int d;
    private int e;

    public eo(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    public eo(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        } else if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        } else if (charset.equals(ep.a)) {
            this.a = inputStream;
            this.b = charset;
            this.c = new byte[i];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.a) {
            if (this.c != null) {
                this.c = null;
                this.a.close();
            }
        }
    }

    public String a() throws IOException {
        int i;
        byte[] bArr;
        int i2;
        synchronized (this.a) {
            if (this.c != null) {
                if (this.d >= this.e) {
                    b();
                }
                for (int i3 = this.d; i3 != this.e; i3++) {
                    byte[] bArr2 = this.c;
                    if (bArr2[i3] == 10) {
                        if (i3 != this.d) {
                            i2 = i3 - 1;
                            if (bArr2[i2] == 13) {
                                byte[] bArr3 = this.c;
                                int i4 = this.d;
                                String str = new String(bArr3, i4, i2 - i4, this.b.name());
                                this.d = i3 + 1;
                                return str;
                            }
                        }
                        i2 = i3;
                        byte[] bArr3 = this.c;
                        int i4 = this.d;
                        String str = new String(bArr3, i4, i2 - i4, this.b.name());
                        this.d = i3 + 1;
                        return str;
                    }
                }
                AnonymousClass1 r1 = new ByteArrayOutputStream((this.e - this.d) + 80) {
                    /* class com.amap.api.mapcore2d.eo.AnonymousClass1 */

                    @Override // java.io.ByteArrayOutputStream, java.lang.Object
                    public String toString() {
                        try {
                            return new String(this.buf, 0, (this.count <= 0 || this.buf[this.count + -1] != 13) ? this.count : this.count - 1, eo.this.b.name());
                        } catch (UnsupportedEncodingException e) {
                            throw new AssertionError(e);
                        }
                    }
                };
                loop1:
                while (true) {
                    byte[] bArr4 = this.c;
                    int i5 = this.d;
                    r1.write(bArr4, i5, this.e - i5);
                    this.e = -1;
                    b();
                    i = this.d;
                    while (true) {
                        if (i != this.e) {
                            bArr = this.c;
                            if (bArr[i] == 10) {
                                break loop1;
                            }
                            i++;
                        }
                    }
                }
                int i6 = this.d;
                if (i != i6) {
                    r1.write(bArr, i6, i - i6);
                }
                this.d = i + 1;
                return r1.toString();
            }
            throw new IOException("LineReader is closed");
        }
    }

    private void b() throws IOException {
        InputStream inputStream = this.a;
        byte[] bArr = this.c;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.d = 0;
            this.e = read;
            return;
        }
        throw new EOFException();
    }
}
