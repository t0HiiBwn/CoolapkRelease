package com.bumptech.glide.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.atomic.AtomicReference;

public final class ByteBufferUtil {
    private static final AtomicReference<byte[]> BUFFER_REF = new AtomicReference<>();
    private static final int BUFFER_SIZE = 16384;

    private ByteBufferUtil() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0049 A[SYNTHETIC, Splitter:B:25:0x0049] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0050 A[SYNTHETIC, Splitter:B:29:0x0050] */
    public static ByteBuffer fromFile(File file) throws IOException {
        Throwable th;
        RandomAccessFile randomAccessFile;
        FileChannel fileChannel = null;
        try {
            long length = file.length();
            if (length > 2147483647L) {
                throw new IOException("File too large to map into memory");
            } else if (length != 0) {
                randomAccessFile = new RandomAccessFile(file, "r");
                try {
                    fileChannel = randomAccessFile.getChannel();
                    MappedByteBuffer load = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, length).load();
                    if (fileChannel != null) {
                        try {
                            fileChannel.close();
                        } catch (IOException unused) {
                        }
                    }
                    try {
                        randomAccessFile.close();
                    } catch (IOException unused2) {
                    }
                    return load;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileChannel != null) {
                        try {
                            fileChannel.close();
                        } catch (IOException unused3) {
                        }
                    }
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException unused4) {
                        }
                    }
                    throw th;
                }
            } else {
                throw new IOException("File unsuitable for memory mapping");
            }
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile = null;
            if (fileChannel != null) {
            }
            if (randomAccessFile != null) {
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x002b A[SYNTHETIC, Splitter:B:16:0x002b] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0032 A[SYNTHETIC, Splitter:B:20:0x0032] */
    public static void toFile(ByteBuffer byteBuffer, File file) throws IOException {
        Throwable th;
        RandomAccessFile randomAccessFile;
        byteBuffer.position(0);
        FileChannel fileChannel = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                fileChannel = randomAccessFile.getChannel();
                fileChannel.write(byteBuffer);
                fileChannel.force(false);
                fileChannel.close();
                randomAccessFile.close();
                if (fileChannel != null) {
                    try {
                        fileChannel.close();
                    } catch (IOException unused) {
                    }
                }
                try {
                    randomAccessFile.close();
                } catch (IOException unused2) {
                }
            } catch (Throwable th2) {
                th = th2;
                if (fileChannel != null) {
                    try {
                        fileChannel.close();
                    } catch (IOException unused3) {
                    }
                }
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile = null;
            if (fileChannel != null) {
            }
            if (randomAccessFile != null) {
            }
            throw th;
        }
    }

    public static void toStream(ByteBuffer byteBuffer, OutputStream outputStream) throws IOException {
        SafeArray safeArray = getSafeArray(byteBuffer);
        if (safeArray != null) {
            outputStream.write(safeArray.data, safeArray.offset, safeArray.offset + safeArray.limit);
            return;
        }
        byte[] andSet = BUFFER_REF.getAndSet(null);
        if (andSet == null) {
            andSet = new byte[16384];
        }
        while (byteBuffer.remaining() > 0) {
            int min = Math.min(byteBuffer.remaining(), andSet.length);
            byteBuffer.get(andSet, 0, min);
            outputStream.write(andSet, 0, min);
        }
        BUFFER_REF.set(andSet);
    }

    public static byte[] toBytes(ByteBuffer byteBuffer) {
        SafeArray safeArray = getSafeArray(byteBuffer);
        if (safeArray != null && safeArray.offset == 0 && safeArray.limit == safeArray.data.length) {
            return byteBuffer.array();
        }
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        byte[] bArr = new byte[asReadOnlyBuffer.limit()];
        asReadOnlyBuffer.position(0);
        asReadOnlyBuffer.get(bArr);
        return bArr;
    }

    public static InputStream toStream(ByteBuffer byteBuffer) {
        return new ByteBufferStream(byteBuffer);
    }

    public static ByteBuffer fromStream(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        byte[] andSet = BUFFER_REF.getAndSet(null);
        if (andSet == null) {
            andSet = new byte[16384];
        }
        while (true) {
            int read = inputStream.read(andSet);
            if (read >= 0) {
                byteArrayOutputStream.write(andSet, 0, read);
            } else {
                BUFFER_REF.set(andSet);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                return (ByteBuffer) ByteBuffer.allocateDirect(byteArray.length).put(byteArray).position(0);
            }
        }
    }

    private static SafeArray getSafeArray(ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly() || !byteBuffer.hasArray()) {
            return null;
        }
        return new SafeArray(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit());
    }

    static final class SafeArray {
        final byte[] data;
        final int limit;
        final int offset;

        SafeArray(byte[] bArr, int i, int i2) {
            this.data = bArr;
            this.offset = i;
            this.limit = i2;
        }
    }

    private static class ByteBufferStream extends InputStream {
        private static final int UNSET = -1;
        private final ByteBuffer byteBuffer;
        private int markPos = -1;

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        ByteBufferStream(ByteBuffer byteBuffer2) {
            this.byteBuffer = byteBuffer2;
        }

        @Override // java.io.InputStream
        public int available() {
            return this.byteBuffer.remaining();
        }

        @Override // java.io.InputStream
        public int read() {
            if (!this.byteBuffer.hasRemaining()) {
                return -1;
            }
            return this.byteBuffer.get() & 255;
        }

        @Override // java.io.InputStream
        public synchronized void mark(int i) {
            this.markPos = this.byteBuffer.position();
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            if (!this.byteBuffer.hasRemaining()) {
                return -1;
            }
            int min = Math.min(i2, available());
            this.byteBuffer.get(bArr, i, min);
            return min;
        }

        @Override // java.io.InputStream
        public synchronized void reset() throws IOException {
            int i = this.markPos;
            if (i != -1) {
                this.byteBuffer.position(i);
            } else {
                throw new IOException("Cannot reset to unset mark position");
            }
        }

        @Override // java.io.InputStream
        public long skip(long j) throws IOException {
            if (!this.byteBuffer.hasRemaining()) {
                return -1;
            }
            long min = Math.min(j, (long) available());
            ByteBuffer byteBuffer2 = this.byteBuffer;
            byteBuffer2.position((int) (((long) byteBuffer2.position()) + min));
            return min;
        }
    }
}
