package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.a.a.a.c;
import com.xiaomi.push.dd;
import com.xiaomi.push.service.q;
import com.xiaomi.push.service.z;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.zip.Adler32;

class eg {
    private ByteBuffer a = ByteBuffer.allocate(2048);
    private ByteBuffer b = ByteBuffer.allocate(4);
    private Adler32 c = new Adler32();
    private ei d;
    private InputStream e;
    private ek f;
    private volatile boolean g;
    private byte[] h;

    eg(InputStream inputStream, ek ekVar) {
        this.e = new BufferedInputStream(inputStream);
        this.f = ekVar;
        this.d = new ei();
    }

    private void a(ByteBuffer byteBuffer, int i) {
        int position = byteBuffer.position();
        do {
            int read = this.e.read(byteBuffer.array(), position, i);
            if (read != -1) {
                i -= read;
                position += read;
            } else {
                throw new EOFException();
            }
        } while (i > 0);
        byteBuffer.position(position);
    }

    private void d() {
        ef c2;
        StringBuilder sb;
        String sb2;
        boolean z = false;
        this.g = false;
        ef c3 = c();
        if ("CONN".equals(c3.a())) {
            dd.f b2 = dd.f.b(c3.k());
            if (b2.e()) {
                this.f.a(b2.d());
                z = true;
            }
            if (b2.h()) {
                dd.b i = b2.i();
                ef efVar = new ef();
                efVar.a("SYNC", "CONF");
                efVar.a(i.c(), (String) null);
                this.f.a(efVar);
            }
            c.a("[Slim] CONN: host = " + b2.f());
        }
        if (z) {
            this.h = this.f.a();
            while (!this.g) {
                c2 = c();
                this.f.m();
                short m = c2.m();
                if (m != 1) {
                    if (m != 2) {
                        if (m != 3) {
                            sb2 = "[Slim] unknow blob type " + ((int) c2.m());
                        } else {
                            try {
                                this.f.b(this.d.a(c2.k(), this.f));
                            } catch (Exception e2) {
                                e = e2;
                                sb = new StringBuilder();
                            }
                        }
                    } else if ("SECMSG".equals(c2.a()) && ((c2.c() == 2 || c2.c() == 3) && TextUtils.isEmpty(c2.b()))) {
                        try {
                            this.f.b(this.d.a(c2.d(q.a().b(Integer.valueOf(c2.c()).toString(), c2.j()).i), this.f));
                        } catch (Exception e3) {
                            e = e3;
                            sb = new StringBuilder();
                        }
                    }
                    c.a(sb2);
                }
                this.f.a(c2);
            }
            return;
        }
        c.a("[Slim] Invalid CONN");
        throw new IOException("Invalid Connection");
        sb.append("[Slim] Parse packet from Blob chid=");
        sb.append(c2.c());
        sb.append("; Id=");
        sb.append(c2.h());
        sb.append(" failure:");
        sb.append(e.getMessage());
        sb2 = sb.toString();
        c.a(sb2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00cf  */
    private ByteBuffer e() {
        int i;
        ByteBuffer allocate;
        this.a.clear();
        a(this.a, 8);
        short s = this.a.getShort(0);
        short s2 = this.a.getShort(2);
        if (s == -15618 && s2 == 5) {
            int i2 = this.a.getInt(4);
            int position = this.a.position();
            if (i2 <= 32768) {
                if (i2 + 4 > this.a.remaining()) {
                    allocate = ByteBuffer.allocate(i2 + 2048);
                    allocate.put(this.a.array(), 0, this.a.arrayOffset() + this.a.position());
                } else {
                    if (this.a.capacity() > 4096 && i2 < 2048) {
                        allocate = ByteBuffer.allocate(2048);
                        allocate.put(this.a.array(), 0, this.a.arrayOffset() + this.a.position());
                    }
                    a(this.a, i2);
                    this.b.clear();
                    a(this.b, 4);
                    this.b.position(0);
                    i = this.b.getInt();
                    this.c.reset();
                    this.c.update(this.a.array(), 0, this.a.position());
                    if (i != ((int) this.c.getValue())) {
                        byte[] bArr = this.h;
                        if (bArr != null) {
                            z.a(bArr, this.a.array(), true, position, i2);
                        }
                        return this.a;
                    }
                    c.a("CRC = " + ((int) this.c.getValue()) + " and " + i);
                    throw new IOException("Corrupted Blob bad CRC");
                }
                this.a = allocate;
                a(this.a, i2);
                this.b.clear();
                a(this.b, 4);
                this.b.position(0);
                i = this.b.getInt();
                this.c.reset();
                this.c.update(this.a.array(), 0, this.a.position());
                if (i != ((int) this.c.getValue())) {
                }
            } else {
                throw new IOException("Blob size too large");
            }
        } else {
            throw new IOException("Malformed Input");
        }
    }

    void a() {
        try {
            d();
        } catch (IOException e2) {
            if (!this.g) {
                throw e2;
            }
        }
    }

    void b() {
        this.g = true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0074  */
    ef c() {
        int i;
        IOException e2;
        try {
            ByteBuffer e3 = e();
            i = e3.position();
            try {
                e3.flip();
                e3.position(8);
                ef ejVar = i == 8 ? new ej() : ef.b(e3.slice());
                c.c("[Slim] Read {cmd=" + ejVar.a() + ";chid=" + ejVar.c() + ";len=" + i + "}");
                return ejVar;
            } catch (IOException e4) {
                e2 = e4;
                if (i == 0) {
                }
                StringBuilder sb = new StringBuilder();
                sb.append("[Slim] read Blob [");
                byte[] array = this.a.array();
                if (i > 128) {
                }
                sb.append(g.a(array, 0, i));
                sb.append("] Err:");
                sb.append(e2.getMessage());
                c.a(sb.toString());
                throw e2;
            }
        } catch (IOException e5) {
            e2 = e5;
            i = 0;
            if (i == 0) {
                i = this.a.position();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("[Slim] read Blob [");
            byte[] array = this.a.array();
            if (i > 128) {
                i = 128;
            }
            sb.append(g.a(array, 0, i));
            sb.append("] Err:");
            sb.append(e2.getMessage());
            c.a(sb.toString());
            throw e2;
        }
    }
}
