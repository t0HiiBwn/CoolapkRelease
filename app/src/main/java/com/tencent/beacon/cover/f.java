package com.tencent.beacon.cover;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ShareElfFile */
public final class f implements Closeable {
    private final FileInputStream a;
    private final Map<String, c> b = new HashMap();
    private a c = null;
    private b[] d = null;
    private c[] e = null;

    public f(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        this.a = fileInputStream;
        FileChannel channel = fileInputStream.getChannel();
        this.c = new a(channel, (byte) 0);
        ByteBuffer allocate = ByteBuffer.allocate(128);
        allocate.limit(this.c.d);
        allocate.order(this.c.a[5] == 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
        channel.position(this.c.b);
        this.d = new b[this.c.e];
        for (int i = 0; i < this.d.length; i++) {
            a(channel, allocate, "failed to read phdr.");
            this.d[i] = new b(allocate, this.c.a[4], (byte) 0);
        }
        channel.position(this.c.c);
        allocate.limit(this.c.f);
        this.e = new c[this.c.g];
        for (int i2 = 0; i2 < this.e.length; i2++) {
            a(channel, allocate, "failed to read shdr.");
            this.e[i2] = new c(allocate, this.c.a[4], (byte) 0);
        }
        if (this.c.h > 0) {
            c cVar = this.e[this.c.h];
            ByteBuffer allocate2 = ByteBuffer.allocate((int) cVar.c);
            this.a.getChannel().position(cVar.b);
            a(this.a.getChannel(), allocate2, "failed to read section: " + cVar.d);
            c[] cVarArr = this.e;
            for (c cVar2 : cVarArr) {
                allocate2.position(cVar2.a);
                cVar2.d = a(allocate2);
                this.b.put(cVar2.d, cVar2);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0053 A[SYNTHETIC, Splitter:B:36:0x0053] */
    public static int a(File file) throws IOException {
        Throwable th;
        FileInputStream fileInputStream = null;
        try {
            byte[] bArr = new byte[4];
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                fileInputStream2.read(bArr);
                if (bArr[0] == 100 && bArr[1] == 101 && bArr[2] == 121 && bArr[3] == 10) {
                    try {
                        fileInputStream2.close();
                    } catch (Throwable unused) {
                    }
                    return 0;
                } else if (bArr[0] == Byte.MAX_VALUE && bArr[1] == 69 && bArr[2] == 76 && bArr[3] == 70) {
                    try {
                        fileInputStream2.close();
                    } catch (Throwable unused2) {
                    }
                    return 1;
                } else {
                    try {
                        fileInputStream2.close();
                        return -1;
                    } catch (Throwable unused3) {
                        return -1;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Throwable unused4) {
                }
            }
            throw th;
        }
    }

    public static void a(FileChannel fileChannel, ByteBuffer byteBuffer, String str) throws IOException {
        byteBuffer.rewind();
        int read = fileChannel.read(byteBuffer);
        if (read == byteBuffer.limit()) {
            byteBuffer.flip();
            return;
        }
        throw new IOException(str + " Rest bytes insufficient, expect to read " + byteBuffer.limit() + " bytes but only " + read + " bytes were read.");
    }

    private static String a(ByteBuffer byteBuffer) {
        byte[] array = byteBuffer.array();
        int position = byteBuffer.position();
        while (byteBuffer.hasRemaining() && array[byteBuffer.position()] != 0) {
            byteBuffer.position(byteBuffer.position() + 1);
        }
        byteBuffer.position(byteBuffer.position() + 1);
        return new String(array, position, (byteBuffer.position() - position) - 1, Charset.forName("ASCII"));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.a.close();
        this.b.clear();
        this.d = null;
        this.e = null;
    }

    /* compiled from: ShareElfFile */
    public static class a {
        public final byte[] a;
        public final long b;
        public final long c;
        public final short d;
        public final short e;
        public final short f;
        public final short g;
        public final short h;
        private int i;

        /* synthetic */ a(FileChannel fileChannel, byte b2) throws IOException {
            this(fileChannel);
        }

        private a(FileChannel fileChannel) throws IOException {
            byte[] bArr = new byte[16];
            this.a = bArr;
            fileChannel.position(0L);
            fileChannel.read(ByteBuffer.wrap(bArr));
            if (bArr[0] == Byte.MAX_VALUE && bArr[1] == 69 && bArr[2] == 76 && bArr[3] == 70) {
                byte b2 = bArr[4];
                f.a(b2, 2, "bad elf class: " + ((int) bArr[4]));
                byte b3 = bArr[5];
                f.a(b3, 2, "bad elf data encoding: " + ((int) bArr[5]));
                ByteBuffer allocate = ByteBuffer.allocate(bArr[4] == 1 ? 36 : 48);
                allocate.order(bArr[5] == 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
                f.a(fileChannel, allocate, "failed to read rest part of ehdr.");
                allocate.getShort();
                allocate.getShort();
                int i2 = allocate.getInt();
                this.i = i2;
                f.a(i2, 1, "bad elf version: " + this.i);
                byte b4 = bArr[4];
                if (b4 == 1) {
                    allocate.getInt();
                    this.b = (long) allocate.getInt();
                    this.c = (long) allocate.getInt();
                } else if (b4 == 2) {
                    allocate.getLong();
                    this.b = allocate.getLong();
                    this.c = allocate.getLong();
                } else {
                    throw new IOException("Unexpected elf class: " + ((int) bArr[4]));
                }
                allocate.getInt();
                allocate.getShort();
                this.d = allocate.getShort();
                this.e = allocate.getShort();
                this.f = allocate.getShort();
                this.g = allocate.getShort();
                this.h = allocate.getShort();
                return;
            }
            throw new IOException(String.format("bad elf magic: %x %x %x %x.", Byte.valueOf(bArr[0]), Byte.valueOf(bArr[1]), Byte.valueOf(bArr[2]), Byte.valueOf(bArr[3])));
        }
    }

    /* compiled from: ShareElfFile */
    public static class b {
        /* synthetic */ b(ByteBuffer byteBuffer, int i, byte b) throws IOException {
            this(byteBuffer, i);
        }

        private b(ByteBuffer byteBuffer, int i) throws IOException {
            if (i == 1) {
                byteBuffer.getInt();
                byteBuffer.getInt();
                byteBuffer.getInt();
                byteBuffer.getInt();
                byteBuffer.getInt();
                byteBuffer.getInt();
                byteBuffer.getInt();
                byteBuffer.getInt();
            } else if (i == 2) {
                byteBuffer.getInt();
                byteBuffer.getInt();
                byteBuffer.getLong();
                byteBuffer.getLong();
                byteBuffer.getLong();
                byteBuffer.getLong();
                byteBuffer.getLong();
                byteBuffer.getLong();
            } else {
                throw new IOException("Unexpected elf class: " + i);
            }
        }
    }

    /* compiled from: ShareElfFile */
    public static class c {
        public final int a;
        public final long b;
        public final long c;
        public String d;

        /* synthetic */ c(ByteBuffer byteBuffer, int i, byte b2) throws IOException {
            this(byteBuffer, i);
        }

        private c(ByteBuffer byteBuffer, int i) throws IOException {
            if (i == 1) {
                this.a = byteBuffer.getInt();
                byteBuffer.getInt();
                byteBuffer.getInt();
                byteBuffer.getInt();
                this.b = (long) byteBuffer.getInt();
                this.c = (long) byteBuffer.getInt();
                byteBuffer.getInt();
                byteBuffer.getInt();
                byteBuffer.getInt();
                byteBuffer.getInt();
            } else if (i == 2) {
                this.a = byteBuffer.getInt();
                byteBuffer.getInt();
                byteBuffer.getLong();
                byteBuffer.getLong();
                this.b = byteBuffer.getLong();
                this.c = byteBuffer.getLong();
                byteBuffer.getInt();
                byteBuffer.getInt();
                byteBuffer.getLong();
                byteBuffer.getLong();
            } else {
                throw new IOException("Unexpected elf class: " + i);
            }
            this.d = null;
        }
    }

    static /* synthetic */ void a(int i, int i2, String str) throws IOException {
        if (i <= 0 || i > i2) {
            throw new IOException(str);
        }
    }
}
