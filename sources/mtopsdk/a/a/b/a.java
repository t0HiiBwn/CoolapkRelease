package mtopsdk.a.a.b;

import com.taobao.tao.remotebusiness.b.e;
import mtopsdk.a.a.b;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.common.MtopNetworkProp;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.domain.ProtocolEnum;
import mtopsdk.mtop.global.SwitchConfig;

/* compiled from: CheckRequestParamBeforeFilter */
public final class a implements b {
    @Override // mtopsdk.a.a.c
    public final String a() {
        return "mtopsdk.CheckRequestParamBeforeFilter";
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00ae A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b1 A[RETURN] */
    @Override // mtopsdk.a.a.b
    public final String b(e eVar) {
        String str;
        String str2;
        MtopResponse mtopResponse;
        MtopRequest mtopRequest = eVar.b;
        MtopNetworkProp mtopNetworkProp = eVar.d;
        String str3 = eVar.h;
        MtopResponse mtopResponse2 = null;
        if (mtopRequest == null) {
            str2 = "mtopRequest is invalid.mtopRequest=null";
            mtopResponse = new MtopResponse("ANDROID_SYS_MTOPCONTEXT_INIT_ERROR", str2);
        } else if (!mtopRequest.isLegalRequest()) {
            str2 = "mtopRequest is invalid. " + mtopRequest.toString();
            mtopResponse = new MtopResponse(mtopRequest.getApiName(), mtopRequest.getVersion(), "ANDROID_SYS_MTOPCONTEXT_INIT_ERROR", str2);
        } else if (mtopNetworkProp == null) {
            str2 = "MtopNetworkProp is invalid.property=null";
            mtopResponse = new MtopResponse(mtopRequest.getApiName(), mtopRequest.getVersion(), "ANDROID_SYS_MTOPCONTEXT_INIT_ERROR", str2);
        } else {
            str = null;
            eVar.c = mtopResponse2;
            if (StringUtils.isNotBlank(str) && TBSdkLog.isLogEnable(TBSdkLog.LogEnable.ErrorEnable)) {
                TBSdkLog.e("mtopsdk.CheckRequestParamBeforeFilter", str3, "[checkRequiredParam]" + str);
            }
            if (mtopRequest != null && TBSdkLog.isLogEnable(TBSdkLog.LogEnable.DebugEnable)) {
                TBSdkLog.d("mtopsdk.CheckRequestParamBeforeFilter", str3, "[checkRequiredParam]" + mtopRequest.toString());
            }
            mtopsdk.a.c.a.a(eVar);
            if (!SwitchConfig.getInstance().isGlobalSpdySslSwitchOpen()) {
                TBSdkLog.w("mtopsdk.CheckRequestParamBeforeFilter", str3, "[checkRequiredParam]MTOP SSL switch is false");
                eVar.d.protocol = ProtocolEnum.HTTP;
            }
            return !(mtopResponse2 != null) ? "CONTINUE" : "STOP";
        }
        mtopResponse2 = mtopResponse;
        str = str2;
        eVar.c = mtopResponse2;
        TBSdkLog.e("mtopsdk.CheckRequestParamBeforeFilter", str3, "[checkRequiredParam]" + str);
        TBSdkLog.d("mtopsdk.CheckRequestParamBeforeFilter", str3, "[checkRequiredParam]" + mtopRequest.toString());
        mtopsdk.a.c.a.a(eVar);
        if (!SwitchConfig.getInstance().isGlobalSpdySslSwitchOpen()) {
        }
        if (!(mtopResponse2 != null)) {
        }
    }
}
