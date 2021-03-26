package com.bytedance.sdk.a.b.a.b;

import com.bytedance.sdk.a.b.a.c;
import com.bytedance.sdk.a.b.ac;
import com.bytedance.sdk.a.b.e;
import com.bytedance.sdk.a.b.p;
import com.bytedance.sdk.a.b.s;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/* compiled from: RouteSelector */
public final class f {
    private final com.bytedance.sdk.a.b.a a;
    private final d b;
    private final e c;
    private final p d;
    private List<Proxy> e = Collections.emptyList();
    private int f;
    private List<InetSocketAddress> g = Collections.emptyList();
    private final List<ac> h = new ArrayList();

    public f(com.bytedance.sdk.a.b.a aVar, d dVar, e eVar, p pVar) {
        this.a = aVar;
        this.b = dVar;
        this.c = eVar;
        this.d = pVar;
        a(aVar.a(), aVar.h());
    }

    public boolean a() {
        return c() || !this.h.isEmpty();
    }

    public a b() throws IOException {
        if (a()) {
            ArrayList arrayList = new ArrayList();
            while (c()) {
                Proxy d2 = d();
                int size = this.g.size();
                for (int i = 0; i < size; i++) {
                    ac acVar = new ac(this.a, d2, this.g.get(i));
                    if (this.b.c(acVar)) {
                        this.h.add(acVar);
                    } else {
                        arrayList.add(acVar);
                    }
                }
                if (!arrayList.isEmpty()) {
                    break;
                }
            }
            if (arrayList.isEmpty()) {
                arrayList.addAll(this.h);
                this.h.clear();
            }
            return new a(arrayList);
        }
        throw new NoSuchElementException();
    }

    public void a(ac acVar, IOException iOException) {
        if (!(acVar.b().type() == Proxy.Type.DIRECT || this.a.g() == null)) {
            this.a.g().connectFailed(this.a.a().a(), acVar.b().address(), iOException);
        }
        this.b.a(acVar);
    }

    private void a(s sVar, Proxy proxy) {
        List<Proxy> list;
        if (proxy != null) {
            this.e = Collections.singletonList(proxy);
        } else {
            List<Proxy> select = this.a.g().select(sVar.a());
            if (select == null || select.isEmpty()) {
                list = c.a(Proxy.NO_PROXY);
            } else {
                list = c.a(select);
            }
            this.e = list;
        }
        this.f = 0;
    }

    private boolean c() {
        return this.f < this.e.size();
    }

    private Proxy d() throws IOException {
        if (c()) {
            List<Proxy> list = this.e;
            int i = this.f;
            this.f = i + 1;
            Proxy proxy = list.get(i);
            a(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.a.a().f() + "; exhausted proxy configurations: " + this.e);
    }

    private void a(Proxy proxy) throws IOException {
        String str;
        int i;
        this.g = new ArrayList();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            str = this.a.a().f();
            i = this.a.a().g();
        } else {
            SocketAddress address = proxy.address();
            if (address instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                str = a(inetSocketAddress);
                i = inetSocketAddress.getPort();
            } else {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + address.getClass());
            }
        }
        if (i < 1 || i > 65535) {
            throw new SocketException("No route to " + str + ":" + i + "; port is out of range");
        } else if (proxy.type() == Proxy.Type.SOCKS) {
            this.g.add(InetSocketAddress.createUnresolved(str, i));
        } else {
            this.d.a(this.c, str);
            List<InetAddress> a2 = this.a.b().a(str);
            if (!a2.isEmpty()) {
                this.d.a(this.c, str, a2);
                int size = a2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.g.add(new InetSocketAddress(a2.get(i2), i));
                }
                return;
            }
            throw new UnknownHostException(this.a.b() + " returned no addresses for " + str);
        }
    }

    static String a(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        if (address == null) {
            return inetSocketAddress.getHostName();
        }
        return address.getHostAddress();
    }

    /* compiled from: RouteSelector */
    public static final class a {
        private final List<ac> a;
        private int b = 0;

        a(List<ac> list) {
            this.a = list;
        }

        public boolean a() {
            return this.b < this.a.size();
        }

        public ac b() {
            if (a()) {
                List<ac> list = this.a;
                int i = this.b;
                this.b = i + 1;
                return list.get(i);
            }
            throw new NoSuchElementException();
        }

        public List<ac> c() {
            return new ArrayList(this.a);
        }
    }
}
