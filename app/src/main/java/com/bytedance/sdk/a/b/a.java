package com.bytedance.sdk.a.b;

import com.bytedance.sdk.a.b.a.c;
import com.bytedance.sdk.a.b.s;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: Address */
public final class a {
    final s a;
    final o b;
    final SocketFactory c;
    final b d;
    final List<w> e;
    final List<k> f;
    final ProxySelector g;
    final Proxy h;
    final SSLSocketFactory i;
    final HostnameVerifier j;
    final g k;

    public a(String str, int i2, o oVar, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, g gVar, b bVar, Proxy proxy, List<w> list, List<k> list2, ProxySelector proxySelector) {
        this.a = new s.a().a(sSLSocketFactory != null ? "https" : "http").d(str).a(i2).c();
        Objects.requireNonNull(oVar, "dns == null");
        this.b = oVar;
        Objects.requireNonNull(socketFactory, "socketFactory == null");
        this.c = socketFactory;
        Objects.requireNonNull(bVar, "proxyAuthenticator == null");
        this.d = bVar;
        Objects.requireNonNull(list, "protocols == null");
        this.e = c.a(list);
        Objects.requireNonNull(list2, "connectionSpecs == null");
        this.f = c.a(list2);
        Objects.requireNonNull(proxySelector, "proxySelector == null");
        this.g = proxySelector;
        this.h = proxy;
        this.i = sSLSocketFactory;
        this.j = hostnameVerifier;
        this.k = gVar;
    }

    public s a() {
        return this.a;
    }

    public o b() {
        return this.b;
    }

    public SocketFactory c() {
        return this.c;
    }

    public b d() {
        return this.d;
    }

    public List<w> e() {
        return this.e;
    }

    public List<k> f() {
        return this.f;
    }

    public ProxySelector g() {
        return this.g;
    }

    public Proxy h() {
        return this.h;
    }

    public SSLSocketFactory i() {
        return this.i;
    }

    public HostnameVerifier j() {
        return this.j;
    }

    public g k() {
        return this.k;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.a.equals(aVar.a) && a(aVar)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (((((((((((527 + this.a.hashCode()) * 31) + this.b.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31;
        Proxy proxy = this.h;
        int i2 = 0;
        int hashCode2 = (hashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
        SSLSocketFactory sSLSocketFactory = this.i;
        int hashCode3 = (hashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier = this.j;
        int hashCode4 = (hashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        g gVar = this.k;
        if (gVar != null) {
            i2 = gVar.hashCode();
        }
        return hashCode4 + i2;
    }

    boolean a(a aVar) {
        return this.b.equals(aVar.b) && this.d.equals(aVar.d) && this.e.equals(aVar.e) && this.f.equals(aVar.f) && this.g.equals(aVar.g) && c.a(this.h, aVar.h) && c.a(this.i, aVar.i) && c.a(this.j, aVar.j) && c.a(this.k, aVar.k) && a().g() == aVar.a().g();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Address{");
        sb.append(this.a.f());
        sb.append(":");
        sb.append(this.a.g());
        if (this.h != null) {
            sb.append(", proxy=");
            sb.append(this.h);
        } else {
            sb.append(", proxySelector=");
            sb.append(this.g);
        }
        sb.append("}");
        return sb.toString();
    }
}
