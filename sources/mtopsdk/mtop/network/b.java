package mtopsdk.mtop.network;

import java.io.IOException;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.common.MtopHeaderEvent;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.network.domain.Response;

/* compiled from: NetworkCallbackAdapter */
final class b implements Runnable {
    private /* synthetic */ boolean a;
    private /* synthetic */ Response b;
    private /* synthetic */ Object c;
    private /* synthetic */ a d;

    b(a aVar, boolean z, Response response, Object obj) {
        this.d = aVar;
        this.a = z;
        this.b = response;
        this.c = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.a) {
                a aVar = this.d;
                Response response = this.b;
                Object obj = this.c;
                try {
                    if (aVar.a != null) {
                        MtopHeaderEvent mtopHeaderEvent = new MtopHeaderEvent(response.code, response.headers);
                        mtopHeaderEvent.seqNo = aVar.b.h;
                        aVar.a.onHeader(mtopHeaderEvent, obj);
                    }
                } catch (Throwable th) {
                    TBSdkLog.e("mtopsdk.NetworkCallbackAdapter", aVar.b.h, "onHeader failed.", th);
                }
            }
            this.d.b.g.startCallbackTime = this.d.b.g.currentTimeMillis();
            this.d.b.g.bizRspProcessStart = System.currentTimeMillis();
            this.d.b.g.netStats = this.b.stat;
            MtopResponse mtopResponse = new MtopResponse(this.d.b.b.getApiName(), this.d.b.b.getVersion(), null, null);
            mtopResponse.setResponseCode(this.b.code);
            mtopResponse.setHeaderFields(this.b.headers);
            mtopResponse.setMtopStat(this.d.b.g);
            if (this.b.body != null) {
                try {
                    mtopResponse.setBytedata(this.b.body.getBytes());
                } catch (IOException e) {
                    TBSdkLog.e("mtopsdk.NetworkCallbackAdapter", this.d.b.h, "call getBytes of response.body() error.", e);
                }
            }
            this.d.b.c = mtopResponse;
            this.d.c.b(null, this.d.b);
        } catch (Throwable th2) {
            TBSdkLog.e("mtopsdk.NetworkCallbackAdapter", this.d.b.h, "onFinish failed.", th2);
        }
    }
}
