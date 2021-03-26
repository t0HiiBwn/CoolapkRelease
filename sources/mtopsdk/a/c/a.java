package mtopsdk.a.c;

import android.os.Handler;
import com.taobao.tao.remotebusiness.b.e;
import mtopsdk.a.a.a.b;
import mtopsdk.common.util.StringUtils;
import mtopsdk.mtop.common.MtopCallback;
import mtopsdk.mtop.common.MtopFinishEvent;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.util.MtopSDKThreadPoolExecutorFactory;

/* compiled from: FilterUtils */
public final class a {
    public static final b a = new b();

    public static void a(e eVar) {
        MtopResponse mtopResponse = eVar.c;
        if (mtopResponse != null && (eVar.e instanceof MtopCallback.MtopFinishListener)) {
            mtopResponse.setMtopStat(eVar.g);
            MtopFinishEvent mtopFinishEvent = new MtopFinishEvent(mtopResponse);
            mtopFinishEvent.seqNo = eVar.h;
            eVar.g.rspCbDispatch = System.currentTimeMillis();
            a.a(eVar);
            a(eVar.d.handler, new b(eVar, mtopResponse, mtopFinishEvent), eVar.h.hashCode());
        }
    }

    public static void a(Handler handler, Runnable runnable, int i) {
        if (handler != null) {
            handler.post(runnable);
        } else {
            MtopSDKThreadPoolExecutorFactory.submitCallbackTask(i, runnable);
        }
    }

    public static void a(MtopResponse mtopResponse) {
        if (mtopResponse != null) {
            String a2 = com.taobao.tao.remotebusiness.b.a(mtopResponse.getHeaderFields(), "x-retcode");
            mtopResponse.mappingCodeSuffix = com.taobao.tao.remotebusiness.b.a(mtopResponse.getHeaderFields(), "x-mapping-code");
            if (StringUtils.isNotBlank(a2)) {
                mtopResponse.setRetCode(a2);
            } else {
                mtopResponse.parseJsonByte();
            }
        }
    }

    public static void a(mtopsdk.a.b.a aVar, e eVar) {
        if (aVar == null) {
            MtopResponse mtopResponse = new MtopResponse("ANDROID_SYS_MTOPSDK_INIT_ERROR", "MTOPSDK初始化失败");
            if (eVar.b != null) {
                mtopResponse.setApi(eVar.b.getApiName());
                mtopResponse.setV(eVar.b.getVersion());
            }
            eVar.c = mtopResponse;
            a(eVar);
        }
    }
}
