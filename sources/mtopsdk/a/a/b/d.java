package mtopsdk.a.a.b;

import com.taobao.tao.remotebusiness.b.e;
import java.util.Map;
import mtopsdk.a.a.b;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.a.a.a;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;

/* compiled from: ProtocolParamBuilderBeforeFilter */
public final class d implements b {
    private a a;

    @Override // mtopsdk.a.a.c
    public final String a() {
        return "mtopsdk.ProtocolParamBuilderBeforeFilter";
    }

    public d(a aVar) {
        this.a = aVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0089  */
    @Override // mtopsdk.a.a.b
    public final String b(e eVar) {
        Map<String, String> map;
        Throwable th;
        MtopRequest mtopRequest = eVar.b;
        MtopResponse mtopResponse = null;
        try {
            map = this.a.a(eVar);
            if (map == null) {
                try {
                    mtopResponse = new MtopResponse(mtopRequest.getApiName(), mtopRequest.getVersion(), "ANDROID_SYS_INIT_MTOP_ISIGN_ERROR", "初始化Mtop签名类ISign失败");
                } catch (Throwable th2) {
                    th = th2;
                    TBSdkLog.e("mtopsdk.ProtocolParamBuilderBeforeFilter", eVar.h, "[deBefore]execute ProtocolParamBuilder buildParams error.", th);
                    mtopResponse = new MtopResponse(mtopRequest.getApiName(), mtopRequest.getVersion(), "ANDROID_SYS_BUILD_PROTOCOL_PARAMS_ERROR", "组装MTOP协议参数错误");
                    if (mtopResponse != null) {
                    }
                }
            } else if (map.get("sign") == null) {
                String str = map.get("SG_ERROR_CODE");
                StringBuilder sb = new StringBuilder(48);
                sb.append("ANDROID_SYS_GENERATE_MTOP_SIGN_ERROR");
                if (str != null) {
                    sb.append("(");
                    sb.append(str);
                    sb.append(")");
                }
                mtopResponse = new MtopResponse(mtopRequest.getApiName(), mtopRequest.getVersion(), sb.toString(), "生成Mtop签名sign失败");
            }
        } catch (Throwable th3) {
            map = null;
            th = th3;
            TBSdkLog.e("mtopsdk.ProtocolParamBuilderBeforeFilter", eVar.h, "[deBefore]execute ProtocolParamBuilder buildParams error.", th);
            mtopResponse = new MtopResponse(mtopRequest.getApiName(), mtopRequest.getVersion(), "ANDROID_SYS_BUILD_PROTOCOL_PARAMS_ERROR", "组装MTOP协议参数错误");
            if (mtopResponse != null) {
            }
        }
        if (mtopResponse != null) {
            eVar.c = mtopResponse;
            mtopsdk.a.c.a.a(eVar);
            return "STOP";
        }
        eVar.i = map;
        return "CONTINUE";
    }
}
