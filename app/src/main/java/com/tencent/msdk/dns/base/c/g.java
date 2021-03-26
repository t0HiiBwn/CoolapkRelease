package com.tencent.msdk.dns.base.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import com.tencent.msdk.dns.base.log.b;

/* compiled from: NetworkChangeObservableV21Impl */
final class g extends a {
    g(Context context) {
        super(context);
        if (context != null) {
            final Context applicationContext = context.getApplicationContext();
            ConnectivityManager connectivityManager = (ConnectivityManager) applicationContext.getSystemService("connectivity");
            if (connectivityManager != null) {
                connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().addTransportType(0).addTransportType(1).addTransportType(2).addTransportType(3).build(), new ConnectivityManager.NetworkCallback() {
                    /* class com.tencent.msdk.dns.base.c.g.AnonymousClass1 */

                    @Override // android.net.ConnectivityManager.NetworkCallback
                    public void onAvailable(Network network) {
                        super.onAvailable(network);
                        b.b("Network onAvailable(%s)", network);
                        g.this.a(applicationContext);
                    }

                    @Override // android.net.ConnectivityManager.NetworkCallback
                    public void onLosing(Network network, int i) {
                        super.onLosing(network, i);
                        b.b("Network onLosing(%s)", network);
                    }

                    @Override // android.net.ConnectivityManager.NetworkCallback
                    public void onLost(Network network) {
                        super.onLost(network);
                        b.b("Network onLost(%s)", network);
                        g.this.a(applicationContext);
                    }

                    @Override // android.net.ConnectivityManager.NetworkCallback
                    public void onUnavailable() {
                        super.onUnavailable();
                        b.b("Network onUnavailable", new Object[0]);
                    }

                    @Override // android.net.ConnectivityManager.NetworkCallback
                    public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
                        super.onCapabilitiesChanged(network, networkCapabilities);
                        b.b("Network onCapabilitiesChanged(%s)", network);
                    }

                    @Override // android.net.ConnectivityManager.NetworkCallback
                    public void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
                        super.onLinkPropertiesChanged(network, linkProperties);
                        b.b("Network onLinkPropertiesChanged(%s)", network);
                    }
                });
            }
        }
    }
}
