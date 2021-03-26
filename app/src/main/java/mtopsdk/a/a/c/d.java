package mtopsdk.a.a.c;

import com.alibaba.wireless.security.open.middletier.fc.FCAction;
import com.alibaba.wireless.security.open.middletier.fc.IFCActionCallback;
import com.taobao.tao.remotebusiness.b.e;
import java.util.HashMap;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.mtop.intf.MtopBuilder;
import mtopsdk.mtop.util.MtopSDKThreadPoolExecutorFactory;

/* compiled from: FCDuplexFilter */
final class d implements IFCActionCallback {
    final /* synthetic */ e a;
    final /* synthetic */ MtopBuilder b;
    final /* synthetic */ Mtop c;
    final /* synthetic */ MtopResponse d;

    d(c cVar, e eVar, MtopBuilder mtopBuilder, Mtop mtop, MtopResponse mtopResponse) {
        this.a = eVar;
        this.b = mtopBuilder;
        this.c = mtop;
        this.d = mtopResponse;
    }

    @Override // com.alibaba.wireless.security.open.middletier.fc.IFCActionCallback
    public final void onPreAction(long j, boolean z) {
        this.a.g.bxSessionId = String.valueOf(j);
        this.a.g.bxUI = z;
    }

    @Override // com.alibaba.wireless.security.open.middletier.fc.IFCActionCallback
    public final void onAction(long j, FCAction.FCMainAction fCMainAction, long j2, HashMap hashMap) {
        MtopSDKThreadPoolExecutorFactory.submitCallbackTask(this.a.h != null ? this.a.h.hashCode() : hashCode(), new e(this, j, fCMainAction, j2, hashMap));
    }
}
