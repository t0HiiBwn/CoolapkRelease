package mtopsdk.mtop.intf;

import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.util.MtopSDKThreadPoolExecutorFactory;

/* compiled from: Mtop */
final class a implements Runnable {
    final /* synthetic */ Mtop a;

    a(Mtop mtop) {
        this.a = mtop;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            synchronized (this.a.f) {
                long currentTimeMillis = System.currentTimeMillis();
                boolean z = true;
                try {
                    this.a.a();
                    this.a.d.executeCoreTask(this.a.c);
                    MtopSDKThreadPoolExecutorFactory.submit(new b(this));
                } finally {
                    TBSdkLog.i("mtopsdk.Mtop", this.a.b + " [init]do executeCoreTask cost[ms]: " + (System.currentTimeMillis() - currentTimeMillis));
                    this.a.e = z;
                    this.a.f.notifyAll();
                }
            }
        } catch (Exception e) {
            TBSdkLog.e("mtopsdk.Mtop", this.a.b + " [init] executeCoreTask error.", e);
        }
    }
}
