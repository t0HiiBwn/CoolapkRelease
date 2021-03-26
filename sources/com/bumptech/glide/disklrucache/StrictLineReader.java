package com.bumptech.glide.disklrucache;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

class StrictLineReader implements Closeable {
    private static final byte CR = 13;
    private static final byte LF = 10;
    private byte[] buf;
    private final Charset charset;
    private int end;
    private final InputStream in;
    private int pos;

    public StrictLineReader(InputStream inputStream, Charset charset2) {
        this(inputStream, 8192, charset2);
    }

    public StrictLineReader(InputStream inputStream, int i, Charset charset2) {
        if (inputStream == null || charset2 == null) {
            throw null;
        } else if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        } else if (charset2.equals(Util.US_ASCII)) {
            this.in = inputStream;
            this.charset = charset2;
            this.buf = new byte[i];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.in) {
            if (this.buf != null) {
                this.buf = null;
                this.in.close();
            }
        }
    }

    public String readLine() throws IOException {
        int i;
        byte[] bArr;
        int i2;
        synchronized (this.in) {
            if (this.buf != null) {
                if (this.pos >= this.end) {
                    fillBuf();
                }
                for (int i3 = this.pos; i3 != this.end; i3++) {
                    byte[] bArr2 = this.buf;
                    if (bArr2[i3] == 10) {
                        if (i3 != this.pos) {
                            i2 = i3 - 1;
                            if (bArr2[i2] == 13) {
                                byte[] bArr3 = this.buf;
                                int i4 = this.pos;
                                String str = new String(bArr3, i4, i2 - i4, this.charset.name());
                                this.pos = i3 + 1;
                                return str;
                            }
                        }
                        i2 = i3;
                        byte[] bArr3 = this.buf;
                        int i4 = this.pos;
                        String str = new String(bArr3, i4, i2 - i4, this.charset.name());
                        this.pos = i3 + 1;
                        return str;
                    }
                }
                AnonymousClass1 r1 = new ByteArrayOutputStream((this.end - this.pos) + 80) {
                    /* class com.bumptech.glide.disklrucache.StrictLineReader.AnonymousClass1 */

                    @Override // java.io.ByteArrayOutputStream, java.lang.Object
                    public String toString() {
                        try {
                            return new String(this.buf, 0, (this.count <= 0 || this.buf[this.count + -1] != 13) ? this.count : this.count - 1, StrictLineReader.this.charset.name());
                        } catch (UnsupportedEncodingException e) {
                            throw new AssertionError(e);
                        }
                    }
                };
                loop1:
                while (true) {
                    byte[] bArr4 = this.buf;
                    int i5 = this.pos;
                    r1.write(bArr4, i5, this.end - i5);
                    this.end = -1;
                    fillBuf();
                    i = this.pos;
                    while (true) {
                        if (i != this.end) {
                            bArr = this.buf;
                            if (bArr[i] == 10) {
                                break loop1;
                            }
                            i++;
                        }
                    }
                }
                int i6 = this.pos;
                if (i != i6) {
                    r1.write(bArr, i6, i - i6);
                }
                this.pos = i + 1;
                return r1.toString();
            }
            throw new IOException("LineReader is closed");
        }
    }

    public boolean hasUnterminatedLine() {
        return this.end == -1;
    }

    private void fillBuf() throws IOException {
        InputStream inputStream = this.in;
        byte[] bArr = this.buf;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.pos = 0;
            this.end = read;
            return;
        }
        throw new EOFException();
    }
}
