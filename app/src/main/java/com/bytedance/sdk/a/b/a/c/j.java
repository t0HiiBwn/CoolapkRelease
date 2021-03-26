package com.bytedance.sdk.a.b.a.c;

import com.bytedance.sdk.a.b.a.b.g;
import com.bytedance.sdk.a.b.a.c;
import com.bytedance.sdk.a.b.a.e.a;
import com.bytedance.sdk.a.b.aa;
import com.bytedance.sdk.a.b.ab;
import com.bytedance.sdk.a.b.ac;
import com.bytedance.sdk.a.b.e;
import com.bytedance.sdk.a.b.p;
import com.bytedance.sdk.a.b.s;
import com.bytedance.sdk.a.b.t;
import com.bytedance.sdk.a.b.v;
import com.bytedance.sdk.a.b.y;
import com.bytedance.sdk.a.b.z;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: RetryAndFollowUpInterceptor */
public final class j implements t {
    private final v a;
    private final boolean b;
    private g c;
    private Object d;
    private volatile boolean e;

    public j(v vVar, boolean z) {
        this.a = vVar;
        this.b = z;
    }

    public boolean a() {
        return this.e;
    }

    public void a(Object obj) {
        this.d = obj;
    }

    @Override // com.bytedance.sdk.a.b.t
    public aa a(t.a aVar) throws IOException {
        y a2 = aVar.a();
        g gVar = (g) aVar;
        e h = gVar.h();
        p i = gVar.i();
        this.c = new g(this.a.o(), a(a2.a()), h, i, this.d);
        aa aaVar = null;
        int i2 = 0;
        while (!this.e) {
            try {
                aa a3 = gVar.a(a2, this.c, null, null);
                if (aaVar != null) {
                    a3 = a3.i().c(aaVar.i().a((ab) null).a()).a();
                }
                y a4 = a(a3);
                if (a4 == null) {
                    if (!this.b) {
                        this.c.c();
                    }
                    return a3;
                }
                c.a(a3.h());
                int i3 = i2 + 1;
                if (i3 > 20) {
                    this.c.c();
                    throw new ProtocolException("Too many follow-up requests: " + i3);
                } else if (!(a4.d() instanceof l)) {
                    if (!a(a3, a4.a())) {
                        this.c.c();
                        this.c = new g(this.a.o(), a(a4.a()), h, i, this.d);
                    } else if (this.c.a() != null) {
                        throw new IllegalStateException("Closing the body of " + a3 + " didn't close its backing stream. Bad interceptor?");
                    }
                    aaVar = a3;
                    a2 = a4;
                    i2 = i3;
                } else {
                    this.c.c();
                    throw new HttpRetryException("Cannot retry streamed HTTP body", a3.c());
                }
            } catch (com.bytedance.sdk.a.b.a.b.e e2) {
                if (!a(e2.a(), false, a2)) {
                    throw e2.a();
                }
            } catch (IOException e3) {
                if (!a(e3, !(e3 instanceof a), a2)) {
                    throw e3;
                }
            } catch (Throwable th) {
                this.c.a((IOException) null);
                this.c.c();
                throw th;
            }
        }
        this.c.c();
        throw new IOException("Canceled");
    }

    private com.bytedance.sdk.a.b.a a(s sVar) {
        com.bytedance.sdk.a.b.g gVar;
        HostnameVerifier hostnameVerifier;
        SSLSocketFactory sSLSocketFactory;
        if (sVar.c()) {
            SSLSocketFactory j = this.a.j();
            hostnameVerifier = this.a.k();
            sSLSocketFactory = j;
            gVar = this.a.l();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            gVar = null;
        }
        return new com.bytedance.sdk.a.b.a(sVar.f(), sVar.g(), this.a.h(), this.a.i(), sSLSocketFactory, hostnameVerifier, gVar, this.a.n(), this.a.d(), this.a.t(), this.a.u(), this.a.e());
    }

    private boolean a(IOException iOException, boolean z, y yVar) {
        this.c.a(iOException);
        if (!this.a.r()) {
            return false;
        }
        if ((!z || !(yVar.d() instanceof l)) && a(iOException, z) && this.c.e()) {
            return true;
        }
        return false;
    }

    private boolean a(IOException iOException, boolean z) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        if (iOException instanceof InterruptedIOException) {
            if (!(iOException instanceof SocketTimeoutException) || z) {
                return false;
            }
            return true;
        } else if ((!(iOException instanceof SSLHandshakeException) || !(iOException.getCause() instanceof CertificateException)) && !(iOException instanceof SSLPeerUnverifiedException)) {
            return true;
        } else {
            return false;
        }
    }

    private y a(aa aaVar) throws IOException {
        String a2;
        s c2;
        Proxy proxy;
        if (aaVar != null) {
            com.bytedance.sdk.a.b.a.b.c b2 = this.c.b();
            z zVar = null;
            ac a3 = b2 != null ? b2.a() : null;
            int c3 = aaVar.c();
            String b3 = aaVar.a().b();
            if (c3 == 307 || c3 == 308) {
                if (!b3.equals("GET") && !b3.equals("HEAD")) {
                    return null;
                }
            } else if (c3 == 401) {
                return this.a.m().a(a3, aaVar);
            } else {
                if (c3 == 407) {
                    if (a3 != null) {
                        proxy = a3.b();
                    } else {
                        proxy = this.a.d();
                    }
                    if (proxy.type() == Proxy.Type.HTTP) {
                        return this.a.n().a(a3, aaVar);
                    }
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                } else if (c3 != 408) {
                    switch (c3) {
                        case 300:
                        case 301:
                        case 302:
                        case 303:
                            break;
                        default:
                            return null;
                    }
                } else if (!this.a.r() || (aaVar.a().d() instanceof l)) {
                    return null;
                } else {
                    if (aaVar.j() == null || aaVar.j().c() != 408) {
                        return aaVar.a();
                    }
                    return null;
                }
            }
            if (!this.a.q() || (a2 = aaVar.a("Location")) == null || (c2 = aaVar.a().a().c(a2)) == null) {
                return null;
            }
            if (!c2.b().equals(aaVar.a().a().b()) && !this.a.p()) {
                return null;
            }
            y.a e2 = aaVar.a().e();
            if (f.c(b3)) {
                boolean d2 = f.d(b3);
                if (f.e(b3)) {
                    e2.a("GET", (z) null);
                } else {
                    if (d2) {
                        zVar = aaVar.a().d();
                    }
                    e2.a(b3, zVar);
                }
                if (!d2) {
                    e2.b("Transfer-Encoding");
                    e2.b("Content-Length");
                    e2.b("Content-Type");
                }
            }
            if (!a(aaVar, c2)) {
                e2.b("Authorization");
            }
            return e2.a(c2).d();
        }
        throw new IllegalStateException();
    }

    private boolean a(aa aaVar, s sVar) {
        s a2 = aaVar.a().a();
        return a2.f().equals(sVar.f()) && a2.g() == sVar.g() && a2.b().equals(sVar.b());
    }
}
