package mtopsdk.a.a.b;

import android.text.TextUtils;
import com.taobao.tao.remotebusiness.b.e;
import mtopsdk.a.a.b;
import mtopsdk.mtop.a.b.a;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.network.domain.Request;

/* compiled from: NetworkConvertBeforeFilter */
public final class c implements b {
    private a a;

    @Override // mtopsdk.a.a.c
    public final String a() {
        return "mtopsdk.NetworkConvertBeforeFilter";
    }

    public c(a aVar) {
        this.a = aVar;
    }

    @Override // mtopsdk.a.a.b
    public final String b(e eVar) {
        Request a2 = this.a.a(eVar);
        a2.fullTraceId = eVar.g.fullTraceId;
        String launchInfoValue = eVar.g.launchInfoValue();
        if (!TextUtils.isEmpty(launchInfoValue)) {
            a2.headers.put("c-launch-info", launchInfoValue);
        }
        eVar.j = a2;
        eVar.g.url = a2.url;
        if (a2 != null) {
            return "CONTINUE";
        }
        eVar.c = new MtopResponse(eVar.b.getApiName(), eVar.b.getVersion(), "ANDROID_SYS_NETWORK_REQUEST_CONVERT_ERROR", "网络Request转换失败");
        mtopsdk.a.c.a.a(eVar);
        return "STOP";
    }
}
