package org.apache.commons.io.output;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.SequenceInputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.io.input.ClosedInputStream;

public class ByteArrayOutputStream extends OutputStream {
    static final int DEFAULT_SIZE = 1024;
    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    private final List<byte[]> buffers;
    private int count;
    private byte[] currentBuffer;
    private int currentBufferIndex;
    private int filledBufferSum;
    private boolean reuseBuffers;

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    public ByteArrayOutputStream() {
        this(1024);
    }

    public ByteArrayOutputStream(int i) {
        this.buffers = new ArrayList();
        this.reuseBuffers = true;
        if (i >= 0) {
            synchronized (this) {
                needNewBuffer(i);
            }
            return;
        }
        throw new IllegalArgumentException("Negative initial size: " + i);
    }

    private void needNewBuffer(int i) {
        if (this.currentBufferIndex < this.buffers.size() - 1) {
            this.filledBufferSum += this.currentBuffer.length;
            int i2 = this.currentBufferIndex + 1;
            this.currentBufferIndex = i2;
            this.currentBuffer = this.buffers.get(i2);
            return;
        }
        byte[] bArr = this.currentBuffer;
        if (bArr == null) {
            this.filledBufferSum = 0;
        } else {
            i = Math.max(bArr.length << 1, i - this.filledBufferSum);
            this.filledBufferSum += this.currentBuffer.length;
        }
        this.currentBufferIndex++;
        byte[] bArr2 = new byte[i];
        this.currentBuffer = bArr2;
        this.buffers.add(bArr2);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        int i3;
        if (i < 0 || i > bArr.length || i2 < 0 || (i3 = i + i2) > bArr.length || i3 < 0) {
            throw new IndexOutOfBoundsException();
        } else if (i2 != 0) {
            synchronized (this) {
                int i4 = this.count;
                int i5 = i4 + i2;
                int i6 = i4 - this.filledBufferSum;
                while (i2 > 0) {
                    int min = Math.min(i2, this.currentBuffer.length - i6);
                    System.arraycopy(bArr, i3 - i2, this.currentBuffer, i6, min);
                    i2 -= min;
                    if (i2 > 0) {
                        needNewBuffer(i5);
                        i6 = 0;
                    }
                }
                this.count = i5;
            }
        }
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i) {
        int i2 = this.count;
        int i3 = i2 - this.filledBufferSum;
        if (i3 == this.currentBuffer.length) {
            needNewBuffer(i2 + 1);
            i3 = 0;
        }
        this.currentBuffer[i3] = (byte) i;
        this.count++;
    }

    public synchronized int write(InputStream inputStream) throws IOException {
        int i;
        int i2 = this.count - this.filledBufferSum;
        byte[] bArr = this.currentBuffer;
        int read = inputStream.read(bArr, i2, bArr.length - i2);
        i = 0;
        while (read != -1) {
            i += read;
            i2 += read;
            this.count += read;
            byte[] bArr2 = this.currentBuffer;
            if (i2 == bArr2.length) {
                needNewBuffer(bArr2.length);
                i2 = 0;
            }
            byte[] bArr3 = this.currentBuffer;
            read = inputStream.read(bArr3, i2, bArr3.length - i2);
        }
        return i;
    }

    public synchronized int size() {
        return this.count;
    }

    public synchronized void reset() {
        this.count = 0;
        this.filledBufferSum = 0;
        this.currentBufferIndex = 0;
        if (this.reuseBuffers) {
            this.currentBuffer = this.buffers.get(0);
        } else {
            this.currentBuffer = null;
            int length = this.buffers.get(0).length;
            this.buffers.clear();
            needNewBuffer(length);
            this.reuseBuffers = true;
        }
    }

    public synchronized void writeTo(OutputStream outputStream) throws IOException {
        int i = this.count;
        for (byte[] bArr : this.buffers) {
            int min = Math.min(bArr.length, i);
            outputStream.write(bArr, 0, min);
            i -= min;
            if (i == 0) {
                break;
            }
        }
    }

    public static InputStream toBufferedInputStream(InputStream inputStream) throws IOException {
        return toBufferedInputStream(inputStream, 1024);
    }

    public static InputStream toBufferedInputStream(InputStream inputStream, int i) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i);
        byteArrayOutputStream.write(inputStream);
        return byteArrayOutputStream.toInputStream();
    }

    public synchronized InputStream toInputStream() {
        int i = this.count;
        if (i == 0) {
            return new ClosedInputStream();
        }
        ArrayList arrayList = new ArrayList(this.buffers.size());
        for (byte[] bArr : this.buffers) {
            int min = Math.min(bArr.length, i);
            arrayList.add(new ByteArrayInputStream(bArr, 0, min));
            i -= min;
            if (i == 0) {
                break;
            }
        }
        this.reuseBuffers = false;
        return new SequenceInputStream(Collections.enumeration(arrayList));
    }

    public synchronized byte[] toByteArray() {
        int i = this.count;
        if (i == 0) {
            return EMPTY_BYTE_ARRAY;
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        for (byte[] bArr2 : this.buffers) {
            int min = Math.min(bArr2.length, i);
            System.arraycopy(bArr2, 0, bArr, i2, min);
            i2 += min;
            i -= min;
            if (i == 0) {
                break;
            }
        }
        return bArr;
    }

    @Override // java.lang.Object
    @Deprecated
    public String toString() {
        return new String(toByteArray(), Charset.defaultCharset());
    }

    public String toString(String str) throws UnsupportedEncodingException {
        return new String(toByteArray(), str);
    }

    public String toString(Charset charset) {
        return new String(toByteArray(), charset);
    }
}
