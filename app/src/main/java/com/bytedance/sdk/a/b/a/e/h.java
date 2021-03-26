package com.bytedance.sdk.a.b.a.e;

import com.bytedance.sdk.a.a.e;
import com.bytedance.sdk.a.a.f;
import com.bytedance.sdk.a.a.s;
import com.bytedance.sdk.a.a.t;
import com.bytedance.sdk.a.b.a.c;
import com.bytedance.sdk.a.b.a.e.d;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: Http2Reader */
final class h implements Closeable {
    static final Logger a = Logger.getLogger(e.class.getName());
    final d.a b;
    private final e c;
    private final a d;
    private final boolean e;

    /* compiled from: Http2Reader */
    interface b {
        void a();

        void a(int i, int i2, int i3, boolean z);

        void a(int i, int i2, List<c> list) throws IOException;

        void a(int i, long j);

        void a(int i, b bVar);

        void a(int i, b bVar, f fVar);

        void a(boolean z, int i, int i2);

        void a(boolean z, int i, int i2, List<c> list);

        void a(boolean z, int i, e eVar, int i2) throws IOException;

        void a(boolean z, n nVar);
    }

    h(e eVar, boolean z) {
        this.c = eVar;
        this.e = z;
        a aVar = new a(eVar);
        this.d = aVar;
        this.b = new d.a(4096, aVar);
    }

    public void a(b bVar) throws IOException {
        if (!this.e) {
            f c2 = this.c.c((long) e.a.g());
            Logger logger = a;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(c.a("<< CONNECTION %s", c2.e()));
            }
            if (!e.a.equals(c2)) {
                throw e.b("Expected a connection header but was %s", c2.a());
            }
        } else if (!a(true, bVar)) {
            throw e.b("Required SETTINGS preface not received", new Object[0]);
        }
    }

    public boolean a(boolean z, b bVar) throws IOException {
        try {
            this.c.a(9);
            int a2 = a(this.c);
            if (a2 < 0 || a2 > 16384) {
                throw e.b("FRAME_SIZE_ERROR: %s", Integer.valueOf(a2));
            }
            byte h = (byte) (this.c.h() & 255);
            if (!z || h == 4) {
                byte h2 = (byte) (this.c.h() & 255);
                int j = this.c.j() & Integer.MAX_VALUE;
                Logger logger = a;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(e.a(true, j, a2, h, h2));
                }
                switch (h) {
                    case 0:
                        b(bVar, a2, h2, j);
                        break;
                    case 1:
                        a(bVar, a2, h2, j);
                        break;
                    case 2:
                        c(bVar, a2, h2, j);
                        break;
                    case 3:
                        d(bVar, a2, h2, j);
                        break;
                    case 4:
                        e(bVar, a2, h2, j);
                        break;
                    case 5:
                        f(bVar, a2, h2, j);
                        break;
                    case 6:
                        g(bVar, a2, h2, j);
                        break;
                    case 7:
                        h(bVar, a2, h2, j);
                        break;
                    case 8:
                        i(bVar, a2, h2, j);
                        break;
                    default:
                        this.c.h((long) a2);
                        break;
                }
                return true;
            }
            throw e.b("Expected a SETTINGS frame but was %s", Byte.valueOf(h));
        } catch (IOException unused) {
            return false;
        }
    }

    private void a(b bVar, int i, byte b2, int i2) throws IOException {
        short s = 0;
        if (i2 != 0) {
            boolean z = (b2 & 1) != 0;
            if ((b2 & 8) != 0) {
                s = (short) (this.c.h() & 255);
            }
            if ((b2 & 32) != 0) {
                a(bVar, i2);
                i -= 5;
            }
            bVar.a(z, i2, -1, a(a(i, b2, s), s, b2, i2));
            return;
        }
        throw e.b("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
    }

    private List<c> a(int i, short s, byte b2, int i2) throws IOException {
        a aVar = this.d;
        aVar.d = i;
        aVar.a = i;
        this.d.e = s;
        this.d.b = b2;
        this.d.c = i2;
        this.b.a();
        return this.b.b();
    }

    private void b(b bVar, int i, byte b2, int i2) throws IOException {
        short s = 0;
        if (i2 != 0) {
            boolean z = true;
            boolean z2 = (b2 & 1) != 0;
            if ((b2 & 32) == 0) {
                z = false;
            }
            if (!z) {
                if ((b2 & 8) != 0) {
                    s = (short) (this.c.h() & 255);
                }
                bVar.a(z2, i2, this.c, a(i, b2, s));
                this.c.h((long) s);
                return;
            }
            throw e.b("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }
        throw e.b("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
    }

    private void c(b bVar, int i, byte b2, int i2) throws IOException {
        if (i != 5) {
            throw e.b("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i));
        } else if (i2 != 0) {
            a(bVar, i2);
        } else {
            throw e.b("TYPE_PRIORITY streamId == 0", new Object[0]);
        }
    }

    private void a(b bVar, int i) throws IOException {
        int j = this.c.j();
        bVar.a(i, j & Integer.MAX_VALUE, (this.c.h() & 255) + 1, (Integer.MIN_VALUE & j) != 0);
    }

    private void d(b bVar, int i, byte b2, int i2) throws IOException {
        if (i != 4) {
            throw e.b("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i));
        } else if (i2 != 0) {
            int j = this.c.j();
            b a2 = b.a(j);
            if (a2 != null) {
                bVar.a(i2, a2);
                return;
            }
            throw e.b("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(j));
        } else {
            throw e.b("TYPE_RST_STREAM streamId == 0", new Object[0]);
        }
    }

    private void e(b bVar, int i, byte b2, int i2) throws IOException {
        if (i2 != 0) {
            throw e.b("TYPE_SETTINGS streamId != 0", new Object[0]);
        } else if ((b2 & 1) != 0) {
            if (i == 0) {
                bVar.a();
                return;
            }
            throw e.b("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
        } else if (i % 6 == 0) {
            n nVar = new n();
            for (int i3 = 0; i3 < i; i3 += 6) {
                short i4 = this.c.i();
                int j = this.c.j();
                if (i4 != 2) {
                    if (i4 == 3) {
                        i4 = 4;
                    } else if (i4 == 4) {
                        i4 = 7;
                        if (j < 0) {
                            throw e.b("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                        }
                    } else if (i4 == 5 && (j < 16384 || j > 16777215)) {
                        throw e.b("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(j));
                    }
                } else if (!(j == 0 || j == 1)) {
                    throw e.b("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                }
                nVar.a(i4, j);
            }
            bVar.a(false, nVar);
        } else {
            throw e.b("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i));
        }
    }

    private void f(b bVar, int i, byte b2, int i2) throws IOException {
        short s = 0;
        if (i2 != 0) {
            if ((b2 & 8) != 0) {
                s = (short) (this.c.h() & 255);
            }
            bVar.a(i2, this.c.j() & Integer.MAX_VALUE, a(a(i - 4, b2, s), s, b2, i2));
            return;
        }
        throw e.b("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
    }

    private void g(b bVar, int i, byte b2, int i2) throws IOException {
        boolean z = false;
        if (i != 8) {
            throw e.b("TYPE_PING length != 8: %s", Integer.valueOf(i));
        } else if (i2 == 0) {
            int j = this.c.j();
            int j2 = this.c.j();
            if ((b2 & 1) != 0) {
                z = true;
            }
            bVar.a(z, j, j2);
        } else {
            throw e.b("TYPE_PING streamId != 0", new Object[0]);
        }
    }

    private void h(b bVar, int i, byte b2, int i2) throws IOException {
        if (i < 8) {
            throw e.b("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i));
        } else if (i2 == 0) {
            int j = this.c.j();
            int j2 = this.c.j();
            int i3 = i - 8;
            b a2 = b.a(j2);
            if (a2 != null) {
                f fVar = f.b;
                if (i3 > 0) {
                    fVar = this.c.c((long) i3);
                }
                bVar.a(j, a2, fVar);
                return;
            }
            throw e.b("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(j2));
        } else {
            throw e.b("TYPE_GOAWAY streamId != 0", new Object[0]);
        }
    }

    private void i(b bVar, int i, byte b2, int i2) throws IOException {
        if (i == 4) {
            long j = ((long) this.c.j()) & 2147483647L;
            if (j != 0) {
                bVar.a(i2, j);
                return;
            }
            throw e.b("windowSizeIncrement was 0", Long.valueOf(j));
        }
        throw e.b("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.c.close();
    }

    /* compiled from: Http2Reader */
    static final class a implements s {
        int a;
        byte b;
        int c;
        int d;
        short e;
        private final e f;

        @Override // com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        a(e eVar) {
            this.f = eVar;
        }

        @Override // com.bytedance.sdk.a.a.s
        public long a(com.bytedance.sdk.a.a.c cVar, long j) throws IOException {
            while (true) {
                int i = this.d;
                if (i == 0) {
                    this.f.h((long) this.e);
                    this.e = 0;
                    if ((this.b & 4) != 0) {
                        return -1;
                    }
                    b();
                } else {
                    long a2 = this.f.a(cVar, Math.min(j, (long) i));
                    if (a2 == -1) {
                        return -1;
                    }
                    this.d = (int) (((long) this.d) - a2);
                    return a2;
                }
            }
        }

        @Override // com.bytedance.sdk.a.a.s
        public t a() {
            return this.f.a();
        }

        private void b() throws IOException {
            int i = this.c;
            int a2 = h.a(this.f);
            this.d = a2;
            this.a = a2;
            byte h = (byte) (this.f.h() & 255);
            this.b = (byte) (this.f.h() & 255);
            if (h.a.isLoggable(Level.FINE)) {
                h.a.fine(e.a(true, this.c, this.a, h, this.b));
            }
            int j = this.f.j() & Integer.MAX_VALUE;
            this.c = j;
            if (h != 9) {
                throw e.b("%s != TYPE_CONTINUATION", Byte.valueOf(h));
            } else if (j != i) {
                throw e.b("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }
    }

    static int a(e eVar) throws IOException {
        return (eVar.h() & 255) | ((eVar.h() & 255) << 16) | ((eVar.h() & 255) << 8);
    }

    static int a(int i, byte b2, short s) throws IOException {
        if ((b2 & 8) != 0) {
            i--;
        }
        if (s <= i) {
            return (short) (i - s);
        }
        throw e.b("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i));
    }
}
