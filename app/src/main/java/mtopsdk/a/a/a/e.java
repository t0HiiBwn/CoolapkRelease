package mtopsdk.a.a.a;

import com.taobao.tao.remotebusiness.b;
import mtopsdk.a.a.a;
import mtopsdk.a.a.b.d;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.common.MtopNetworkProp;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.xstate.XState;

/* compiled from: TimeCalibrationAfterFilter */
public final class e implements a {
    @Override // mtopsdk.a.a.c
    public final String a() {
        return "mtopsdk.TimeCalibrationAfterFilter";
    }

    @Override // mtopsdk.a.a.a
    public final String a(com.taobao.tao.remotebusiness.b.e eVar) {
        MtopResponse mtopResponse = eVar.c;
        MtopNetworkProp mtopNetworkProp = eVar.d;
        if (!mtopResponse.isExpiredRequest() || mtopNetworkProp.timeCalibrated) {
            return "CONTINUE";
        }
        mtopNetworkProp.timeCalibrated = true;
        mtopNetworkProp.skipCacheCallback = true;
        try {
            String a = b.a(mtopResponse.getHeaderFields(), "x-systime");
            if (!StringUtils.isNotBlank(a)) {
                return "CONTINUE";
            }
            XState.setValue("t_offset", String.valueOf(Long.parseLong(a) - (System.currentTimeMillis() / 1000)));
            mtopsdk.a.b.a aVar = eVar.a.getMtopConfig().filterManager;
            if (aVar == null) {
                return "CONTINUE";
            }
            new d(null);
            aVar.a("mtopsdk.ProtocolParamBuilderBeforeFilter", eVar);
            return "STOP";
        } catch (Exception e) {
            TBSdkLog.e("mtopsdk.TimeCalibrationAfterFilter", eVar.h, "parse x-systime from mtop response header error", e);
            return "CONTINUE";
        }
    }
}
