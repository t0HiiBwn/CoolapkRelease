package com.bytedance.sdk.openadsdk.core.video.a.a;

import com.bytedance.sdk.a.b.aa;
import com.bytedance.sdk.a.b.ab;
import com.bytedance.sdk.a.b.v;
import com.bytedance.sdk.a.b.y;
import com.bytedance.sdk.openadsdk.core.video.a.a;
import com.bytedance.sdk.openadsdk.j.e;
import com.bytedance.sdk.openadsdk.j.g;
import com.bytedance.sdk.openadsdk.utils.u;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

/* compiled from: VideoCacheImpl */
public class b implements a {
    public File a;
    private RandomAccessFile b;
    private volatile long c = -2147483648L;
    private String d;
    private final Object e = new Object();
    private long f = 0;
    private volatile boolean g = false;
    private volatile boolean h = false;
    private volatile boolean i = false;
    private boolean j;
    private String k;

    public b(String str, String str2, File file) {
        this.d = str;
        this.k = str2;
        try {
            this.a = file;
            boolean f2 = f();
            this.j = this.j;
            this.b = new RandomAccessFile(this.a, f2 ? "r" : "rw");
            this.f = e();
            if (!f2) {
                this.h = true;
                d();
            }
        } catch (IOException unused) {
            u.c("VideoCacheImpl", "Error using file " + file + " as disc cache");
        }
    }

    public void d() {
        e.a(new g() {
            /* class com.bytedance.sdk.openadsdk.core.video.a.a.b.AnonymousClass1 */

            /* JADX WARNING: Removed duplicated region for block: B:130:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
            /* JADX WARNING: Removed duplicated region for block: B:78:0x017f  */
            /* JADX WARNING: Removed duplicated region for block: B:81:0x0187  */
            /* JADX WARNING: Removed duplicated region for block: B:83:0x018c  */
            /* JADX WARNING: Removed duplicated region for block: B:86:0x0197  */
            /* JADX WARNING: Removed duplicated region for block: B:92:0x01bf  */
            @Override // java.lang.Runnable
            public void run() {
                ab abVar;
                aa aaVar;
                Throwable th;
                InputStream inputStream = null;
                try {
                    long e = b.this.e();
                    aaVar = new v().a(new y.a().a("RANGE", "bytes=" + e + "-").a(b.this.d).a().d()).a();
                    try {
                        b.this.i = aaVar.d();
                        abVar = aaVar.h();
                    } catch (Throwable th2) {
                        th = th2;
                        abVar = null;
                        try {
                            th.printStackTrace();
                            a.b(b.this.k);
                            if (0 != 0) {
                            }
                            if (abVar != null) {
                            }
                            if (aaVar != null) {
                            }
                            if (b.this.i) {
                            }
                            b.this.g();
                            b.this.h = false;
                            if (!b.this.g) {
                                return;
                            }
                        } catch (Throwable th3) {
                            a.b(b.this.k);
                            if (0 != 0) {
                                try {
                                    inputStream.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                    throw th3;
                                }
                            }
                            if (abVar != null) {
                                abVar.close();
                            }
                            if (aaVar != null) {
                                aaVar.close();
                            }
                            if (!b.this.i || b.this.e() != b.this.c) {
                                b.this.g();
                            } else {
                                b.this.h();
                            }
                            b.this.h = false;
                            if (b.this.g && b.this.b != null) {
                                b.this.b.close();
                            }
                            throw th3;
                        }
                    }
                    try {
                        if (b.this.i && abVar != null) {
                            b.this.c = abVar.b() + e;
                            inputStream = abVar.c();
                        }
                        if (inputStream == null) {
                            a.b(b.this.k);
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                    return;
                                }
                            }
                            if (abVar != null) {
                                abVar.close();
                            }
                            if (aaVar != null) {
                                aaVar.close();
                            }
                            if (!b.this.i || b.this.e() != b.this.c) {
                                b.this.g();
                            } else {
                                b.this.h();
                            }
                            b.this.h = false;
                            if (b.this.g && b.this.b != null) {
                                b.this.b.close();
                                return;
                            }
                            return;
                        }
                        byte[] bArr = new byte[16384];
                        long j = 0;
                        while (true) {
                            int i = 0;
                            do {
                                int read = inputStream.read(bArr, i, 16384 - i);
                                if (read != -1) {
                                    i += read;
                                    j += (long) read;
                                    if (j % 16384 == 0) {
                                        break;
                                    }
                                } else {
                                    a.b(b.this.k);
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException e4) {
                                            e4.printStackTrace();
                                            return;
                                        }
                                    }
                                    if (abVar != null) {
                                        abVar.close();
                                    }
                                    if (aaVar != null) {
                                        aaVar.close();
                                    }
                                    if (!b.this.i || b.this.e() != b.this.c) {
                                        b.this.g();
                                    } else {
                                        b.this.h();
                                    }
                                    b.this.h = false;
                                    if (b.this.g && b.this.b != null) {
                                        b.this.b.close();
                                        return;
                                    }
                                    return;
                                }
                            } while (j != b.this.c - b.this.f);
                            synchronized (b.this.e) {
                                b.this.a(bArr, i);
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        th.printStackTrace();
                        a.b(b.this.k);
                        if (0 != 0) {
                            inputStream.close();
                        }
                        if (abVar != null) {
                            abVar.close();
                        }
                        if (aaVar != null) {
                            aaVar.close();
                        }
                        if (b.this.i || b.this.e() != b.this.c) {
                            b.this.g();
                        } else {
                            b.this.h();
                        }
                        b.this.h = false;
                        if (!b.this.g && b.this.b != null) {
                            b.this.b.close();
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                    aaVar = null;
                    abVar = null;
                    th.printStackTrace();
                    a.b(b.this.k);
                    if (0 != 0) {
                    }
                    if (abVar != null) {
                    }
                    if (aaVar != null) {
                    }
                    if (b.this.i) {
                    }
                    b.this.g();
                    b.this.h = false;
                    if (!b.this.g) {
                    }
                }
            }
        });
    }

    public long e() throws IOException {
        try {
            return this.b.length();
        } catch (IOException e2) {
            throw new IOException("Error reading length of file " + this.a, e2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.a.a.a
    public int a(long j2, byte[] bArr, int i2, int i3) throws IOException {
        try {
            if (j2 == this.c) {
                return -1;
            }
            int i4 = 0;
            while (!this.g) {
                synchronized (this.e) {
                    if (j2 < e()) {
                        u.c("VideoCacheImpl", "read:  read " + j2 + " success");
                        this.b.seek(j2);
                        i4 = this.b.read(bArr, i2, i3);
                    } else {
                        u.c("VideoCacheImpl", "read: wait at " + j2 + "  file size = " + e());
                        this.e.wait(33);
                    }
                }
                if (i4 > 0) {
                    return i4;
                }
            }
            return -1;
        } catch (IOException e2) {
            throw new IOException(String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", Integer.valueOf(i3), Integer.valueOf(i2), Long.valueOf(e()), Integer.valueOf(bArr.length)), e2);
        } catch (InterruptedException e3) {
            e3.printStackTrace();
        }
    }

    public void a(byte[] bArr, int i2) throws IOException {
        try {
            this.b.seek(e());
            this.b.write(bArr, 0, i2);
            this.e.notifyAll();
            u.c("VideoCacheImpl", "append:  pisition =" + e() + "  length =" + i2);
        } catch (IOException e2) {
            throw new IOException(String.format("Error writing %d bytes to %s from buffer with size %d", Integer.valueOf(i2), this.b, Integer.valueOf(bArr.length)), e2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.a.a.a
    public void a() throws IOException {
        try {
            if (!this.h) {
                this.b.close();
            }
            this.g = true;
        } catch (IOException e2) {
            throw new IOException("Error closing file " + this.a, e2);
        }
    }

    /* access modifiers changed from: private */
    public void g() throws IOException {
        if (!f()) {
            try {
                synchronized (this.e) {
                    this.a.delete();
                    RandomAccessFile randomAccessFile = this.b;
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                    }
                    this.b = new RandomAccessFile(this.a, "r");
                }
            } catch (IOException e2) {
                throw new IOException("Error downloadFail " + this.a, e2);
            }
        }
    }

    /* access modifiers changed from: private */
    public void h() throws IOException {
        if (!f()) {
            try {
                synchronized (this.e) {
                    File file = new File(this.a.getParentFile(), this.a.getName().substring(0, this.a.getName().length() - 9));
                    if (this.a.renameTo(file)) {
                        this.a = file;
                        RandomAccessFile randomAccessFile = this.b;
                        if (randomAccessFile != null) {
                            randomAccessFile.close();
                        }
                        this.b = new RandomAccessFile(this.a, "r");
                    } else {
                        throw new IOException("Error renaming file " + this.a + " to " + file + " for completion!");
                    }
                }
            } catch (IOException e2) {
                throw new IOException("Error opening " + this.a + " as disc cache", e2);
            }
        }
    }

    public boolean f() {
        return !this.a.getName().endsWith(".download");
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.a.a.a
    public long b() throws IOException {
        if (f()) {
            this.c = e();
        } else {
            synchronized (this.e) {
                while (this.c == -2147483648L) {
                    try {
                        u.c("VideoCacheImpl", "length: wait");
                        this.e.wait(5);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        throw new IOException("total length InterruptException");
                    }
                }
            }
        }
        return this.c;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.a.a.a
    public boolean c() {
        return this.h;
    }
}
