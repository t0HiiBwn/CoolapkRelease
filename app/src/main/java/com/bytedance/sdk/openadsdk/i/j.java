package com.bytedance.sdk.openadsdk.i;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Collections;
import java.util.List;

/* compiled from: SkipProxySelector */
class j extends ProxySelector {
    private static final List<Proxy> a = Collections.singletonList(Proxy.NO_PROXY);
    private final ProxySelector b = ProxySelector.getDefault();
    private final String c;
    private final int d;

    private j(String str, int i) {
        this.c = str;
        this.d = i;
    }

    @Override // java.net.ProxySelector
    public List<Proxy> select(URI uri) {
        if (uri != null) {
            return (!this.c.equalsIgnoreCase(uri.getHost()) || this.d != uri.getPort()) ? this.b.select(uri) : a;
        }
        throw new IllegalArgumentException("URI can't be null");
    }

    @Override // java.net.ProxySelector
    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.b.connectFailed(uri, socketAddress, iOException);
    }

    static void a(String str, int i) {
        ProxySelector.setDefault(new j(str, i));
    }
}
