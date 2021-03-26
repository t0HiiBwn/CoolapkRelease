package mtopsdk.xstate.a;

import android.content.Context;
import mtopsdk.common.util.TBSdkLog;

/* compiled from: NetworkStateReceiver */
final class b implements Runnable {
    private /* synthetic */ Context a;
    private /* synthetic */ a b;

    b(a aVar, Context context) {
        this.b = aVar;
        this.a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.b.a(this.a);
        } catch (Throwable th) {
            TBSdkLog.e("mtopsdk.NetworkStateReceiver", "[onReceive] updateNetworkStatus error", th);
        }
    }
}
