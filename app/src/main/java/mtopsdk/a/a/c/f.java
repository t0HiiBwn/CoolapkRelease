package mtopsdk.a.a.c;

import com.taobao.tao.remotebusiness.b.e;
import mtopsdk.a.a.a;
import mtopsdk.a.a.b;
import mtopsdk.common.util.MtopUtils;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.global.SDKUtils;

/* compiled from: FlowLimitDuplexFilter */
public final class f implements a, b {
    @Override // mtopsdk.a.a.c
    public final String a() {
        return "mtopsdk.FlowLimitDuplexFilter";
    }

    @Override // mtopsdk.a.a.b
    public final String b(e eVar) {
        if (eVar.d != null && eVar.d.priorityFlag) {
            return "CONTINUE";
        }
        MtopRequest mtopRequest = eVar.b;
        String key = mtopRequest.getKey();
        if (MtopUtils.apiWhiteList.contains(key) || !mtopsdk.mtop.antiattack.a.a(key, SDKUtils.getCorrectionTime())) {
            return "CONTINUE";
        }
        eVar.c = new MtopResponse(mtopRequest.getApiName(), mtopRequest.getVersion(), "ANDROID_SYS_API_FLOW_LIMIT_LOCKED", "哎哟喂,被挤爆啦,请稍后重试(420)");
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.WarnEnable)) {
            String str = eVar.h;
            TBSdkLog.w("mtopsdk.FlowLimitDuplexFilter", str, "[doBefore] execute FlowLimitDuplexFilter apiKey=" + key);
        }
        mtopsdk.a.c.a.a(eVar);
        return "STOP";
    }

    @Override // mtopsdk.a.a.a
    public final String a(e eVar) {
        MtopResponse mtopResponse = eVar.c;
        if (420 != mtopResponse.getResponseCode()) {
            return "CONTINUE";
        }
        String key = eVar.b.getKey();
        mtopsdk.mtop.antiattack.a.a(key, SDKUtils.getCorrectionTime(), 0);
        mtopsdk.a.c.a.a(mtopResponse);
        if (StringUtils.isBlank(mtopResponse.getRetCode())) {
            eVar.c.setRetCode("ANDROID_SYS_API_FLOW_LIMIT_LOCKED");
            eVar.c.setRetMsg("哎哟喂,被挤爆啦,请稍后重试(420)");
        }
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.WarnEnable)) {
            String str = eVar.h;
            TBSdkLog.w("mtopsdk.FlowLimitDuplexFilter", str, "[doAfter] execute FlowLimitDuplexFilter apiKey=" + key + " ,retCode=" + mtopResponse.getRetCode());
        }
        mtopsdk.a.c.a.a(eVar);
        return "STOP";
    }
}
