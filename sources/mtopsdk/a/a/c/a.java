package mtopsdk.a.a.c;

import com.taobao.tao.remotebusiness.MtopBusiness;
import com.taobao.tao.remotebusiness.auth.AuthParam;
import com.taobao.tao.remotebusiness.auth.RemoteAuth;
import com.taobao.tao.remotebusiness.b.e;
import com.taobao.tao.remotebusiness.c;
import mtopsdk.a.a.b;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.global.SwitchConfig;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.mtop.intf.MtopBuilder;
import mtopsdk.xstate.XState;

/* compiled from: CheckAuthDuplexFilter */
public final class a implements mtopsdk.a.a.a, b {
    @Override // mtopsdk.a.a.c
    public final String a() {
        return "mtopsdk.CheckAuthDuplexFilter";
    }

    @Override // mtopsdk.a.a.b
    public final String b(e eVar) {
        MtopBuilder mtopBuilder = eVar.k;
        if (!(mtopBuilder instanceof MtopBusiness)) {
            return "CONTINUE";
        }
        MtopBusiness mtopBusiness = (MtopBusiness) mtopBuilder;
        MtopRequest mtopRequest = eVar.b;
        Mtop mtop = eVar.a;
        boolean isNeedEcode = mtopRequest.isNeedEcode();
        boolean isNeedAuth = mtopBusiness.isNeedAuth();
        if (isNeedEcode && isNeedAuth) {
            try {
                if (mtopBusiness.getRetryTime() < 3) {
                    AuthParam authParam = new AuthParam(mtopBusiness.mtopProp.openAppKey, mtopBusiness.authParam, mtopBusiness.showAuthUI);
                    if (!RemoteAuth.isAuthInfoValid(mtop, authParam)) {
                        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                            TBSdkLog.i("mtopsdk.CheckAuthDuplexFilter", eVar.h, " execute CheckAuthBeforeFilter.isAuthInfoValid = false");
                        }
                        c.a("AUTH").a(mtop, authParam.openAppKey, mtopBusiness);
                        RemoteAuth.authorize(mtop, authParam);
                        return "STOP";
                    }
                    String concatStr = StringUtils.concatStr(mtop.getInstanceId(), authParam.openAppKey);
                    if (StringUtils.isBlank(XState.getValue(concatStr, "accessToken"))) {
                        String authToken = RemoteAuth.getAuthToken(mtop, authParam);
                        if (StringUtils.isNotBlank(authToken)) {
                            XState.setValue(concatStr, "accessToken", authToken);
                        } else {
                            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                                TBSdkLog.i("mtopsdk.CheckAuthDuplexFilter", eVar.h, " execute CheckAuthBeforeFilter.isAuthInfoValid = true,getAuthToken is null.");
                            }
                            c.a("AUTH").a(mtop, authParam.openAppKey, mtopBusiness);
                            RemoteAuth.authorize(mtop, authParam);
                            return "STOP";
                        }
                    }
                }
            } catch (Exception e) {
                TBSdkLog.e("mtopsdk.CheckAuthDuplexFilter", eVar.h, " execute CheckAuthBeforeFilter error.", e);
            }
        }
        return "CONTINUE";
    }

    @Override // mtopsdk.a.a.a
    public final String a(e eVar) {
        MtopBuilder mtopBuilder = eVar.k;
        if (!(mtopBuilder instanceof MtopBusiness)) {
            return "CONTINUE";
        }
        MtopBusiness mtopBusiness = (MtopBusiness) mtopBuilder;
        Mtop mtop = eVar.a;
        MtopResponse mtopResponse = eVar.c;
        String retCode = mtopResponse.getRetCode();
        try {
            if (mtopBusiness.isNeedAuth() && mtopBusiness.getRetryTime() < 3 && SwitchConfig.authErrorCodeSet.contains(retCode)) {
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                    TBSdkLog.i("mtopsdk.CheckAuthDuplexFilter", eVar.h, " execute CheckAuthAfterFilter.");
                }
                AuthParam authParam = new AuthParam(mtopBusiness.mtopProp.openAppKey, mtopBusiness.authParam, mtopBusiness.showAuthUI);
                authParam.apiInfo = mtopBusiness.request.getKey();
                if (mtopBusiness.mtopProp.isInnerOpen) {
                    authParam.failInfo = retCode;
                } else {
                    authParam.failInfo = com.taobao.tao.remotebusiness.b.a(mtopResponse.getHeaderFields(), "x-act-hint");
                }
                c.a("AUTH").a(mtop, authParam.openAppKey, mtopBusiness);
                RemoteAuth.authorize(mtop, authParam);
                return "STOP";
            }
        } catch (Exception e) {
            TBSdkLog.e("mtopsdk.CheckAuthDuplexFilter", eVar.h, " execute CheckAuthAfterFilter error.", e);
        }
        return "CONTINUE";
    }
}
