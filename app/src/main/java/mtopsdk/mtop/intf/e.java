package mtopsdk.mtop.intf;

import mtopsdk.a.b.a;

/* compiled from: MtopBuilder */
final class e implements Runnable {
    private /* synthetic */ com.taobao.tao.remotebusiness.b.e a;
    private /* synthetic */ MtopBuilder b;

    e(MtopBuilder mtopBuilder, com.taobao.tao.remotebusiness.b.e eVar) {
        this.b = mtopBuilder;
        this.a = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.g.bizReqProcessStart = System.currentTimeMillis();
        this.a.g.startExecuteTime = this.b.a.currentTimeMillis();
        this.b.b.checkMtopSDKInit();
        a aVar = this.b.b.getMtopConfig().filterManager;
        if (aVar != null) {
            aVar.a(null, this.a);
        }
        mtopsdk.a.c.a.a(aVar, this.a);
    }
}
