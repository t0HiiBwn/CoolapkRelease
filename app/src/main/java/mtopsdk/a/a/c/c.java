package mtopsdk.a.a.c;

import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.middletier.fc.IFCComponent;
import com.taobao.tao.remotebusiness.MtopBusiness;
import com.taobao.tao.remotebusiness.b.e;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mtopsdk.a.a.a;
import mtopsdk.a.a.b;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.mtop.intf.MtopBuilder;

/* compiled from: FCDuplexFilter */
public final class c implements a, b {
    private f a = new f();

    @Override // mtopsdk.a.a.c
    public final String a() {
        return "mtopsdk.FCDuplexFilter";
    }

    @Override // mtopsdk.a.a.a
    public final String a(e eVar) {
        MtopResponse mtopResponse = eVar.c;
        int responseCode = mtopResponse.getResponseCode();
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i("mtopsdk.FCDuplexFilter", " [doAfter]response code " + responseCode);
        }
        Map<String, List<String>> headerFields = mtopResponse.getHeaderFields();
        if (headerFields == null) {
            return "CONTINUE";
        }
        try {
            HashMap hashMap = new HashMap(headerFields);
            IFCComponent iFCComponent = (IFCComponent) SecurityGuardManager.getInstance(eVar.a.getMtopConfig().context).getInterface(IFCComponent.class);
            eVar.g.fcProcessCheckStartTime = eVar.g.currentTimeMillis();
            if (iFCComponent == null || !iFCComponent.needFCProcessOrNot(responseCode, hashMap, IFCComponent.ResponseHeaderType.KVL)) {
                eVar.g.fcProcessCheckEndTime = eVar.g.currentTimeMillis();
                return "CONTINUE";
            }
            eVar.g.fcProcessCheckEndTime = eVar.g.currentTimeMillis();
            MtopBuilder mtopBuilder = eVar.k;
            Mtop mtop = eVar.a;
            com.taobao.tao.remotebusiness.c.a("ANTI").a(mtop, "", (MtopBusiness) mtopBuilder);
            d dVar = new d(this, eVar, mtopBuilder, mtop, mtopResponse);
            eVar.g.fcProcessStartTime = eVar.g.currentTimeMillis();
            TBSdkLog.e("mtopsdk.FCDuplexFilter", "[IFCActionCallback]start process fc ", eVar.h);
            iFCComponent.processFCContent(responseCode, hashMap, dVar, IFCComponent.ResponseHeaderType.KVL);
            return "STOP";
        } catch (SecException e) {
            TBSdkLog.e("mtopsdk.FCDuplexFilter", "[IFCActionCallback] fc component exception , err code = " + e.getErrorCode());
            return "CONTINUE";
        }
    }

    @Override // mtopsdk.a.a.b
    public final String b(e eVar) {
        f fVar = this.a;
        if (fVar == null) {
            return "CONTINUE";
        }
        fVar.b(eVar);
        return "CONTINUE";
    }
}
