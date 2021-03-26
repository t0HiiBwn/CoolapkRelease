package mtopsdk.a.c;

import com.taobao.tao.remotebusiness.MtopBusiness;
import com.taobao.tao.remotebusiness.b.e;
import mtopsdk.mtop.common.MtopCallback;
import mtopsdk.mtop.common.MtopFinishEvent;
import mtopsdk.mtop.domain.MtopResponse;

/* compiled from: FilterUtils */
final class b implements Runnable {
    private /* synthetic */ e a;
    private /* synthetic */ MtopResponse b;
    private /* synthetic */ MtopFinishEvent c;

    b(e eVar, MtopResponse mtopResponse, MtopFinishEvent mtopFinishEvent) {
        this.a = eVar;
        this.b = mtopResponse;
        this.c = mtopFinishEvent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.a.g.serverTraceId = com.taobao.tao.remotebusiness.b.a(this.b.getHeaderFields(), "x-s-traceid");
            this.a.g.eagleEyeTraceId = com.taobao.tao.remotebusiness.b.a(this.b.getHeaderFields(), "eagleeye-traceid");
            this.a.g.statusCode = this.b.getResponseCode();
            this.a.g.retCode = this.b.getRetCode();
            this.a.g.mappingCode = this.b.getMappingCode();
            if (this.b.isApiSuccess() && 3 == this.a.g.cacheHitType) {
                this.a.g.statusCode = 304;
            }
            boolean z = !(this.a.k instanceof MtopBusiness);
            if (z) {
                this.a.g.rspCbStart = System.currentTimeMillis();
            }
            ((MtopCallback.MtopFinishListener) this.a.e).onFinished(this.c, this.a.d.reqContext);
            this.a.g.onEndAndCommit();
            if (z) {
                this.a.g.rspCbEnd = System.currentTimeMillis();
                this.a.g.commitFullTrace();
            }
        } catch (Exception unused) {
        }
    }
}
