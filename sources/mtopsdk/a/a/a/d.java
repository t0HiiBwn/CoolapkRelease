package mtopsdk.a.a.a;

import com.taobao.tao.remotebusiness.b.e;
import mtopsdk.a.a.a;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.network.AbstractCallImpl;

/* compiled from: NetworkErrorAfterFilter */
public final class d implements a {
    @Override // mtopsdk.a.a.c
    public final String a() {
        return "mtopsdk.NetworkErrorAfterFilter";
    }

    @Override // mtopsdk.a.a.a
    public final String a(e eVar) {
        MtopResponse mtopResponse = eVar.c;
        if (mtopResponse.getResponseCode() >= 0) {
            return "CONTINUE";
        }
        if (eVar.f == null || eVar.f.getCall() == null || !(eVar.f.getCall() instanceof AbstractCallImpl) || !((AbstractCallImpl) eVar.f.getCall()).isNoNetworkError(mtopResponse.getResponseCode())) {
            mtopResponse.setRetCode("ANDROID_SYS_NETWORK_ERROR");
            mtopResponse.setRetMsg("网络错误");
        } else {
            mtopResponse.setRetCode("ANDROID_SYS_NO_NETWORK");
            mtopResponse.setRetMsg("无网络");
        }
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.ErrorEnable)) {
            StringBuilder sb = new StringBuilder(128);
            sb.append("api=");
            sb.append(mtopResponse.getApi());
            sb.append(",v=");
            sb.append(mtopResponse.getV());
            sb.append(",retCode =");
            sb.append(mtopResponse.getRetCode());
            sb.append(",responseCode =");
            sb.append(mtopResponse.getResponseCode());
            sb.append(",responseHeader=");
            sb.append(mtopResponse.getHeaderFields());
            TBSdkLog.e("mtopsdk.NetworkErrorAfterFilter", eVar.h, sb.toString());
        }
        mtopsdk.a.c.a.a(eVar);
        return "STOP";
    }
}
