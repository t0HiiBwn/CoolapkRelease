package mtopsdk.a.a.b;

import com.taobao.tao.remotebusiness.b.e;
import java.util.HashMap;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.stat.a;
import mtopsdk.network.Call;

/* compiled from: ExecuteCallBeforeFilter */
public final class b implements mtopsdk.a.a.b {
    @Override // mtopsdk.a.a.c
    public final String a() {
        return "mtopsdk.ExecuteCallBeforeFilter";
    }

    @Override // mtopsdk.a.a.b
    public final String b(e eVar) {
        try {
            if (a.a() != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("key_data_request", eVar.b.getRequestLog());
                hashMap.put("key_data_seq", eVar.h);
                a.a();
            }
            eVar.g.netSendStartTime = eVar.g.currentTimeMillis();
            Call.Factory factory = eVar.a.getMtopConfig().callFactory;
            if (factory == null) {
                String str = eVar.h;
                TBSdkLog.e("mtopsdk.ExecuteCallBeforeFilter", str, "call Factory of mtopInstance is null.instanceId=" + eVar.a.getInstanceId());
                MtopResponse mtopResponse = new MtopResponse("ANDROID_SYS_MTOP_MISS_CALL_FACTORY", "Mtop实例没有设置Call Factory");
                mtopResponse.setApi(eVar.b.getApiName());
                mtopResponse.setV(eVar.b.getVersion());
                eVar.c = mtopResponse;
                mtopsdk.a.c.a.a(eVar);
                return "STOP";
            }
            Call newCall = factory.newCall(eVar.j);
            newCall.enqueue(new mtopsdk.mtop.network.a(eVar));
            if (eVar.f == null) {
                return "CONTINUE";
            }
            eVar.f.setCall(newCall);
            return "CONTINUE";
        } catch (Exception e) {
            TBSdkLog.e("mtopsdk.ExecuteCallBeforeFilter", eVar.h, "invoke call.enqueue of mtopInstance error,apiKey=" + eVar.b.getKey(), e);
            return "STOP";
        }
    }
}
