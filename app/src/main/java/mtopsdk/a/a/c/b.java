package mtopsdk.a.a.c;

import android.os.Bundle;
import com.taobao.tao.remotebusiness.MtopBusiness;
import com.taobao.tao.remotebusiness.b.e;
import com.taobao.tao.remotebusiness.c;
import com.taobao.tao.remotebusiness.login.LoginContext;
import com.taobao.tao.remotebusiness.login.RemoteLogin;
import mtopsdk.a.a.a;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.mtop.intf.MtopBuilder;

/* compiled from: CheckSessionDuplexFilter */
public final class b implements a, mtopsdk.a.a.b {
    @Override // mtopsdk.a.a.c
    public final String a() {
        return "mtopsdk.CheckSessionDuplexFilter";
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
        try {
            String str = mtopBusiness.mtopProp.userInfo;
            if (!isNeedEcode || RemoteLogin.isSessionValid(mtop, str)) {
                if (isNeedEcode && StringUtils.isBlank(mtop.getMultiAccountSid(str))) {
                    LoginContext loginContext = RemoteLogin.getLoginContext(mtop, str);
                    if (loginContext == null || StringUtils.isBlank(loginContext.sid)) {
                        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.ErrorEnable)) {
                            TBSdkLog.e("mtopsdk.CheckSessionDuplexFilter", eVar.h, "execute CheckSessionBeforeFilter.isSessionInvalid = true,getLoginContext = null");
                        }
                        c.a("SESSION").a(mtop, str, mtopBusiness);
                        RemoteLogin.login(mtop, str, mtopBusiness.isShowLoginUI(), mtopRequest);
                        return "STOP";
                    }
                    if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.ErrorEnable)) {
                        TBSdkLog.e("mtopsdk.CheckSessionDuplexFilter", eVar.h, "session in loginContext is valid but mtopInstance's sid is null");
                    }
                    mtop.registerMultiAccountSession(str, loginContext.sid, loginContext.userId);
                }
                return "CONTINUE";
            }
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.ErrorEnable)) {
                TBSdkLog.e("mtopsdk.CheckSessionDuplexFilter", eVar.h, "execute CheckSessionBeforeFilter.isSessionInvalid = false");
            }
            c.a("SESSION").a(mtop, str, mtopBusiness);
            RemoteLogin.login(mtop, str, mtopBusiness.isShowLoginUI(), mtopRequest);
            return "STOP";
        } catch (Exception e) {
            TBSdkLog.e("mtopsdk.CheckSessionDuplexFilter", eVar.h, " execute CheckSessionBeforeFilter error.", e);
        }
    }

    @Override // mtopsdk.a.a.a
    public final String a(e eVar) {
        MtopBuilder mtopBuilder = eVar.k;
        if (!(mtopBuilder instanceof MtopBusiness)) {
            return "CONTINUE";
        }
        MtopBusiness mtopBusiness = (MtopBusiness) mtopBuilder;
        MtopRequest mtopRequest = eVar.b;
        Mtop mtop = eVar.a;
        MtopResponse mtopResponse = eVar.c;
        if (mtop.getMtopConfig().notifySessionResult) {
            String a = com.taobao.tao.remotebusiness.b.a(mtopResponse.getHeaderFields(), "x-session-ret");
            if (StringUtils.isNotBlank(a)) {
                Bundle bundle = new Bundle();
                bundle.putString("x-session-ret", a);
                bundle.putString("Date", com.taobao.tao.remotebusiness.b.a(mtopResponse.getHeaderFields(), "Date"));
                RemoteLogin.setSessionInvalid(mtop, bundle);
            }
        }
        if (!mtopResponse.isSessionInvalid() || !mtopRequest.isNeedEcode() || mtopBusiness.getRetryTime() != 0) {
            return "CONTINUE";
        }
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.ErrorEnable)) {
            TBSdkLog.e("mtopsdk.CheckSessionDuplexFilter", eVar.h, "execute CheckSessionAfterFilter.");
        }
        String str = mtopBusiness.mtopProp.userInfo;
        c.a("SESSION").a(mtop, str, mtopBusiness);
        RemoteLogin.login(mtop, str, mtopBusiness.isShowLoginUI(), mtopResponse);
        return "STOP";
    }
}
