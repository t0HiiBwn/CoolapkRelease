package com.bytedance.sdk.a.b;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Objects;

/* compiled from: Route */
public final class ac {
    final a a;
    final Proxy b;
    final InetSocketAddress c;

    public ac(a aVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        Objects.requireNonNull(aVar, "address == null");
        Objects.requireNonNull(proxy, "proxy == null");
        Objects.requireNonNull(inetSocketAddress, "inetSocketAddress == null");
        this.a = aVar;
        this.b = proxy;
        this.c = inetSocketAddress;
    }

    public a a() {
        return this.a;
    }

    public Proxy b() {
        return this.b;
    }

    public InetSocketAddress c() {
        return this.c;
    }

    public boolean d() {
        return this.a.i != null && this.b.type() == Proxy.Type.HTTP;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ac) {
            ac acVar = (ac) obj;
            if (acVar.a.equals(this.a) && acVar.b.equals(this.b) && acVar.c.equals(this.c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((527 + this.a.hashCode()) * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "Route{" + this.c + "}";
    }
}
