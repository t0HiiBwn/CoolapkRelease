package mtopsdk.mtop.network;

import com.taobao.tao.remotebusiness.b.e;
import mtopsdk.mtop.common.MtopCallback;
import mtopsdk.mtop.common.MtopListener;
import mtopsdk.network.Call;
import mtopsdk.network.NetworkCallback;
import mtopsdk.network.domain.Response;

/* compiled from: NetworkCallbackAdapter */
public final class a implements NetworkCallback {
    public MtopCallback.MtopHeaderListener a;
    final e b;
    mtopsdk.a.b.a c;

    public a(e eVar) {
        this.b = eVar;
        if (eVar != null) {
            if (eVar.a != null) {
                this.c = eVar.a.getMtopConfig().filterManager;
            }
            MtopListener mtopListener = eVar.e;
            if (mtopListener instanceof MtopCallback.MtopHeaderListener) {
                this.a = (MtopCallback.MtopHeaderListener) mtopListener;
            }
        }
    }

    private void a(Response response, Object obj, boolean z) {
        this.b.g.netSendEndTime = this.b.g.currentTimeMillis();
        this.b.d.reqContext = obj;
        mtopsdk.a.c.a.a(this.b.d.handler, new b(this, z, response, obj), this.b.h.hashCode());
    }

    @Override // mtopsdk.network.NetworkCallback
    public final void onFailure(Call call, Exception exc) {
        Response build = new Response.Builder().request(call.request()).code(-7).message(exc.getMessage()).build();
        a(build, build.request.reqContext, false);
    }

    @Override // mtopsdk.network.NetworkCallback
    public final void onResponse(Call call, Response response) {
        a(response, response.request.reqContext, true);
    }

    @Override // mtopsdk.network.NetworkCallback
    public final void onCancel(Call call) {
        Response build = new Response.Builder().request(call.request()).code(-8).build();
        a(build, build.request.reqContext, false);
    }
}
