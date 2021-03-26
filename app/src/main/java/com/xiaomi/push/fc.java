package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.dw;
import com.xiaomi.push.service.as;
import com.xiaomi.push.service.bb;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.zip.Adler32;

class fc {
    private fe a;

    /* renamed from: a  reason: collision with other field name */
    private fg f443a;

    /* renamed from: a  reason: collision with other field name */
    private InputStream f444a;

    /* renamed from: a  reason: collision with other field name */
    private ByteBuffer f445a = ByteBuffer.allocate(2048);

    /* renamed from: a  reason: collision with other field name */
    private Adler32 f446a = new Adler32();

    /* renamed from: a  reason: collision with other field name */
    private volatile boolean f447a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f448a;
    private ByteBuffer b = ByteBuffer.allocate(4);

    fc(InputStream inputStream, fg fgVar) {
        this.f444a = new BufferedInputStream(inputStream);
        this.f443a = fgVar;
        this.a = new fe();
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00cf  */
    private ByteBuffer a() {
        int i;
        ByteBuffer allocate;
        this.f445a.clear();
        a(this.f445a, 8);
        short s = this.f445a.getShort(0);
        short s2 = this.f445a.getShort(2);
        if (s == -15618 && s2 == 5) {
            int i2 = this.f445a.getInt(4);
            int position = this.f445a.position();
            if (i2 <= 32768) {
                if (i2 + 4 > this.f445a.remaining()) {
                    allocate = ByteBuffer.allocate(i2 + 2048);
                    allocate.put(this.f445a.array(), 0, this.f445a.arrayOffset() + this.f445a.position());
                } else {
                    if (this.f445a.capacity() > 4096 && i2 < 2048) {
                        allocate = ByteBuffer.allocate(2048);
                        allocate.put(this.f445a.array(), 0, this.f445a.arrayOffset() + this.f445a.position());
                    }
                    a(this.f445a, i2);
                    this.b.clear();
                    a(this.b, 4);
                    this.b.position(0);
                    i = this.b.getInt();
                    this.f446a.reset();
                    this.f446a.update(this.f445a.array(), 0, this.f445a.position());
                    if (i != ((int) this.f446a.getValue())) {
                        byte[] bArr = this.f448a;
                        if (bArr != null) {
                            bb.a(bArr, this.f445a.array(), true, position, i2);
                        }
                        return this.f445a;
                    }
                    b.m41a("CRC = " + ((int) this.f446a.getValue()) + " and " + i);
                    throw new IOException("Corrupted Blob bad CRC");
                }
                this.f445a = allocate;
                a(this.f445a, i2);
                this.b.clear();
                a(this.b, 4);
                this.b.position(0);
                i = this.b.getInt();
                this.f446a.reset();
                this.f446a.update(this.f445a.array(), 0, this.f445a.position());
                if (i != ((int) this.f446a.getValue())) {
                }
            } else {
                throw new IOException("Blob size too large");
            }
        } else {
            throw new IOException("Malformed Input");
        }
    }

    private void a(ByteBuffer byteBuffer, int i) {
        int position = byteBuffer.position();
        do {
            int read = this.f444a.read(byteBuffer.array(), position, i);
            if (read != -1) {
                i -= read;
                position += read;
            } else {
                throw new EOFException();
            }
        } while (i > 0);
        byteBuffer.position(position);
    }

    private void c() {
        fb a2;
        StringBuilder sb;
        String sb2;
        boolean z = false;
        this.f447a = false;
        fb a3 = m325a();
        if ("CONN".equals(a3.m317a())) {
            dw.f a4 = dw.f.a(a3.m321a());
            if (a4.mo262a()) {
                this.f443a.a(a4.mo261a());
                z = true;
            }
            if (a4.c()) {
                dw.b a5 = a4.mo260a();
                fb fbVar = new fb();
                fbVar.a("SYNC", "CONF");
                fbVar.a(a5.mo211a(), (String) null);
                this.f443a.a(fbVar);
            }
            b.m41a("[Slim] CONN: host = " + a4.mo263b());
        }
        if (z) {
            this.f448a = this.f443a.mo328a();
            while (!this.f447a) {
                a2 = m325a();
                this.f443a.c();
                short a6 = a2.m319a();
                if (a6 != 1) {
                    if (a6 != 2) {
                        if (a6 != 3) {
                            sb2 = "[Slim] unknow blob type " + ((int) a2.m319a());
                        } else {
                            try {
                                this.f443a.b(this.a.a(a2.m321a(), this.f443a));
                            } catch (Exception e) {
                                e = e;
                                sb = new StringBuilder();
                            }
                        }
                    } else if ("SECMSG".equals(a2.m317a()) && ((a2.a() == 2 || a2.a() == 3) && TextUtils.isEmpty(a2.m323b()))) {
                        try {
                            this.f443a.b(this.a.a(a2.m322a(as.a().a(Integer.valueOf(a2.a()).toString(), a2.g()).h), this.f443a));
                        } catch (Exception e2) {
                            e = e2;
                            sb = new StringBuilder();
                        }
                    }
                    b.m41a(sb2);
                }
                this.f443a.a(a2);
            }
            return;
        }
        b.m41a("[Slim] Invalid CONN");
        throw new IOException("Invalid Connection");
        sb.append("[Slim] Parse packet from Blob chid=");
        sb.append(a2.a());
        sb.append("; Id=");
        sb.append(a2.e());
        sb.append(" failure:");
        sb.append(e.getMessage());
        sb2 = sb.toString();
        b.m41a(sb2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0073  */
    /* renamed from: a  reason: collision with other method in class */
    fb m325a() {
        int i;
        IOException e;
        try {
            ByteBuffer a2 = a();
            i = a2.position();
            try {
                a2.flip();
                a2.position(8);
                fb ffVar = i == 8 ? new ff() : fb.a(a2.slice());
                b.c("[Slim] Read {cmd=" + ffVar.m317a() + ";chid=" + ffVar.a() + ";len=" + i + "}");
                return ffVar;
            } catch (IOException e2) {
                e = e2;
                if (i == 0) {
                }
                StringBuilder sb = new StringBuilder();
                sb.append("[Slim] read Blob [");
                byte[] array = this.f445a.array();
                if (i > 128) {
                }
                sb.append(af.a(array, 0, i));
                sb.append("] Err:");
                sb.append(e.getMessage());
                b.m41a(sb.toString());
                throw e;
            }
        } catch (IOException e3) {
            e = e3;
            i = 0;
            if (i == 0) {
                i = this.f445a.position();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("[Slim] read Blob [");
            byte[] array = this.f445a.array();
            if (i > 128) {
                i = 128;
            }
            sb.append(af.a(array, 0, i));
            sb.append("] Err:");
            sb.append(e.getMessage());
            b.m41a(sb.toString());
            throw e;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    void m326a() {
        try {
            c();
        } catch (IOException e) {
            if (!this.f447a) {
                throw e;
            }
        }
    }

    void b() {
        this.f447a = true;
    }
}
