package mtopsdk.a.a.a;

import com.taobao.tao.remotebusiness.b.e;
import mtopsdk.mtop.domain.MtopResponse;

/* compiled from: BusinessErrorAfterFilter */
public final class a implements mtopsdk.a.a.a {
    @Override // mtopsdk.a.a.c
    public final String a() {
        return "mtopsdk.BusinessErrorAfterFilter";
    }

    @Override // mtopsdk.a.a.a
    public final String a(e eVar) {
        MtopResponse mtopResponse = eVar.c;
        mtopResponse.getResponseCode();
        if (mtopResponse.getBytedata() == null) {
            mtopResponse.setRetCode("ANDROID_SYS_JSONDATA_BLANK");
            mtopResponse.setRetMsg("返回JSONDATA为空");
            mtopsdk.a.c.a.a(eVar);
            return "STOP";
        }
        mtopsdk.a.c.a.a(mtopResponse);
        return "CONTINUE";
    }
}
