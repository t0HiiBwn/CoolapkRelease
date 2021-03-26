package com.tencent.msdk.dns;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.msdk.dns.base.log.b;

public final class HttpDnsCache {

    public static class ConnectivityChangeReceiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            b.b("Network change.", new Object[0]);
        }
    }
}
