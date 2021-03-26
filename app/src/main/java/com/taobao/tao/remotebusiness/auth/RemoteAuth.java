package com.taobao.tao.remotebusiness.auth;

import com.taobao.tao.remotebusiness.c;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.xstate.XState;

public class RemoteAuth {
    private static final String TAG = "mtopsdk.RemoteAuth";
    private static Map<String, IRemoteAuth> mtopAuthMap = new ConcurrentHashMap();

    @Deprecated
    public static void setAuthImpl(IRemoteAuth iRemoteAuth) {
        setAuthImpl(null, iRemoteAuth);
    }

    public static void setAuthImpl(Mtop mtop, IRemoteAuth iRemoteAuth) {
        if (iRemoteAuth != null) {
            String instanceId = mtop == null ? "OPEN" : mtop.getInstanceId();
            mtopAuthMap.put(instanceId, iRemoteAuth);
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i("mtopsdk.RemoteAuth", instanceId + " [setAuthImpl] set remoteAuthImpl=" + iRemoteAuth);
            }
        }
    }

    private static IRemoteAuth getAuth(Mtop mtop) {
        String instanceId = mtop == null ? "OPEN" : mtop.getInstanceId();
        IRemoteAuth iRemoteAuth = mtopAuthMap.get(instanceId);
        if (iRemoteAuth == null) {
            TBSdkLog.e("mtopsdk.RemoteAuth", instanceId + " [getAuth]remoteAuthImpl is null");
        }
        return iRemoteAuth;
    }

    public static void authorize(Mtop mtop, AuthParam authParam) {
        if (authParam == null) {
            TBSdkLog.e("mtopsdk.RemoteAuth", "[authorize] authParam is null");
            return;
        }
        IRemoteAuth auth = getAuth(mtop);
        if (auth != null) {
            IMtopRemoteAuth iMtopRemoteAuth = null;
            if (auth instanceof IMtopRemoteAuth) {
                iMtopRemoteAuth = (IMtopRemoteAuth) auth;
            }
            if (!(iMtopRemoteAuth != null ? iMtopRemoteAuth.isAuthorizing(authParam) : auth.isAuthorizing())) {
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                    TBSdkLog.i("mtopsdk.RemoteAuth", "call authorize. " + authParam);
                }
                a aVar = new a(mtop, authParam);
                if (iMtopRemoteAuth != null) {
                    iMtopRemoteAuth.authorize(authParam, aVar);
                } else {
                    auth.authorize(authParam.bizParam, authParam.apiInfo, authParam.failInfo, authParam.showAuthUI, aVar);
                }
            }
        } else if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i("mtopsdk.RemoteAuth", "didn't set IRemoteAuth implement. remoteAuth=null");
        }
    }

    public static boolean isAuthInfoValid(Mtop mtop, AuthParam authParam) {
        if (authParam == null) {
            TBSdkLog.e("mtopsdk.RemoteAuth", "[isAuthInfoValid] authParam is null");
            return true;
        }
        IRemoteAuth auth = getAuth(mtop);
        if (auth == null) {
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i("mtopsdk.RemoteAuth", "didn't set IRemoteAuth implement. remoteAuth=null");
            }
            return true;
        }
        IMtopRemoteAuth iMtopRemoteAuth = null;
        if (auth instanceof IMtopRemoteAuth) {
            iMtopRemoteAuth = (IMtopRemoteAuth) auth;
        }
        if (iMtopRemoteAuth != null ? iMtopRemoteAuth.isAuthorizing(authParam) : auth.isAuthorizing()) {
            return false;
        }
        return iMtopRemoteAuth != null ? iMtopRemoteAuth.isAuthInfoValid(authParam) : auth.isAuthInfoValid();
    }

    public static String getAuthToken(Mtop mtop, AuthParam authParam) {
        IMtopRemoteAuth iMtopRemoteAuth = null;
        if (authParam == null) {
            TBSdkLog.e("mtopsdk.RemoteAuth", "[getAuthToken] authParam is null");
            return null;
        }
        IRemoteAuth auth = getAuth(mtop);
        if (auth == null) {
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i("mtopsdk.RemoteAuth", "didn't set IRemoteAuth implement. remoteAuth=null");
            }
            return null;
        }
        if (auth instanceof IMtopRemoteAuth) {
            iMtopRemoteAuth = (IMtopRemoteAuth) auth;
        }
        return iMtopRemoteAuth != null ? iMtopRemoteAuth.getAuthToken(authParam) : auth.getAuthToken();
    }

    static class a implements AuthListener {
        private Mtop a;
        private AuthParam b;

        public a(Mtop mtop, AuthParam authParam) {
            this.a = mtop;
            this.b = authParam;
        }

        @Override // com.taobao.tao.remotebusiness.auth.AuthListener
        public final void onAuthSuccess() {
            String str = this.b.openAppKey != null ? this.b.openAppKey : "DEFAULT_AUTH";
            String concatStr = StringUtils.concatStr(this.a.getInstanceId(), str);
            String authToken = RemoteAuth.getAuthToken(this.a, this.b);
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i("mtopsdk.RemoteAuth", "auth success.authToken=" + authToken + ",key=" + concatStr);
            }
            XState.setValue(concatStr, "accessToken", authToken);
            c.a("AUTH").a(this.a, str);
        }

        @Override // com.taobao.tao.remotebusiness.auth.AuthListener
        public final void onAuthFail(String str, String str2) {
            String str3 = this.b.openAppKey != null ? this.b.openAppKey : "DEFAULT_AUTH";
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.ErrorEnable)) {
                StringBuilder sb = new StringBuilder(64);
                sb.append("[onAuthFail] auth fail,key=");
                sb.append(StringUtils.concatStr(this.a.getInstanceId(), str3));
                sb.append(",code=");
                sb.append(str);
                sb.append(",msg=");
                sb.append(str2);
                TBSdkLog.e("mtopsdk.RemoteAuth", sb.toString());
            }
            c.a("AUTH").a(this.a, str3, str, str2);
        }

        @Override // com.taobao.tao.remotebusiness.auth.AuthListener
        public final void onAuthCancel(String str, String str2) {
            String str3 = this.b.openAppKey != null ? this.b.openAppKey : "DEFAULT_AUTH";
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.ErrorEnable)) {
                StringBuilder sb = new StringBuilder(64);
                sb.append("[onAuthCancel] auth cancel,key=");
                sb.append(StringUtils.concatStr(this.a.getInstanceId(), str3));
                sb.append(",code=");
                sb.append(str);
                sb.append(",msg=");
                sb.append(str2);
                TBSdkLog.e("mtopsdk.RemoteAuth", sb.toString());
            }
            c.a("AUTH").a(this.a, str3, str, str2);
        }
    }
}
