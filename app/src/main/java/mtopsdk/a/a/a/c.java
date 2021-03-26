package mtopsdk.a.a.a;

import android.text.TextUtils;
import com.taobao.tao.remotebusiness.MtopBusiness;
import com.taobao.tao.remotebusiness.b;
import com.taobao.tao.remotebusiness.b.e;
import java.util.HashMap;
import mtopsdk.a.a.a;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.common.MtopCallback;
import mtopsdk.mtop.common.MtopFinishEvent;
import mtopsdk.mtop.common.MtopListener;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.util.MtopStatistics;

/* compiled from: ExecuteCallbackAfterFilter */
public final class c implements a {
    @Override // mtopsdk.a.a.c
    public final String a() {
        return "mtopsdk.ExecuteCallbackAfterFilter";
    }

    @Override // mtopsdk.a.a.a
    public final String a(e eVar) {
        MtopStatistics mtopStatistics = eVar.g;
        MtopResponse mtopResponse = eVar.c;
        mtopStatistics.rspCbDispatch = System.currentTimeMillis();
        String str = eVar.h;
        MtopFinishEvent mtopFinishEvent = new MtopFinishEvent(mtopResponse);
        mtopFinishEvent.seqNo = str;
        mtopStatistics.serverTraceId = b.a(mtopResponse.getHeaderFields(), "x-s-traceid");
        mtopStatistics.eagleEyeTraceId = b.a(mtopResponse.getHeaderFields(), "eagleeye-traceid");
        mtopStatistics.retCode = mtopResponse.getRetCode();
        mtopStatistics.statusCode = mtopResponse.getResponseCode();
        mtopStatistics.mappingCode = mtopResponse.getMappingCode();
        mtopStatistics.onEndAndCommit();
        MtopListener mtopListener = eVar.e;
        try {
            boolean z = !(eVar.k instanceof MtopBusiness);
            if (z) {
                mtopStatistics.rspCbStart = System.currentTimeMillis();
            }
            if (mtopListener instanceof MtopCallback.MtopFinishListener) {
                ((MtopCallback.MtopFinishListener) mtopListener).onFinished(mtopFinishEvent, eVar.d.reqContext);
            }
            if (mtopsdk.mtop.stat.a.a() != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("key_data_response", eVar.c.getResponseLog());
                hashMap.put("key_data_seq", eVar.h);
                mtopsdk.mtop.stat.a.a();
            }
            if (mtopsdk.mtop.stat.a.b() != null) {
                String a = b.a(eVar.c.getHeaderFields(), "MTOP-x-ali-ab");
                if (!TextUtils.isEmpty(a)) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("MTOP-x-ali-ab", a);
                    hashMap2.put("key_data_seq", eVar.h);
                    mtopsdk.mtop.stat.a.b();
                }
            }
            if (!z) {
                return "CONTINUE";
            }
            mtopStatistics.rspCbEnd = System.currentTimeMillis();
            mtopStatistics.commitFullTrace();
            return "CONTINUE";
        } catch (Throwable th) {
            TBSdkLog.e("mtopsdk.ExecuteCallbackAfterFilter", str, "call MtopFinishListener error,apiKey=" + eVar.b.getKey(), th);
            return "CONTINUE";
        }
    }
}
