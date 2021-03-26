package mtopsdk.mtop.intf;

import mtopsdk.common.util.TBSdkLog;

/* compiled from: Mtop */
final class b implements Runnable {
    private /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.a.a.d.executeExtraTask(this.a.a.c);
        } catch (Throwable th) {
            TBSdkLog.e("mtopsdk.Mtop", this.a.a.b + " [init] executeExtraTask error.", th);
        }
    }
}
