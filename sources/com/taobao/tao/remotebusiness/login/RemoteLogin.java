package com.taobao.tao.remotebusiness.login;

import android.content.Context;
import android.os.Bundle;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.intf.Mtop;

public class RemoteLogin {
    private static final String DEFAULT_USERINFO = "DEFAULT";
    public static final String TAG = "mtopsdk.RemoteLogin";
    private static Map<String, IRemoteLogin> mtopLoginMap = new ConcurrentHashMap();

    public static IRemoteLogin getLogin(Mtop mtop) {
        Context context;
        String instanceId = mtop == null ? "INNER" : mtop.getInstanceId();
        IRemoteLogin iRemoteLogin = mtopLoginMap.get(instanceId);
        if (iRemoteLogin == null) {
            synchronized (RemoteLogin.class) {
                iRemoteLogin = mtopLoginMap.get(instanceId);
                if (iRemoteLogin == null) {
                    if (mtop == null) {
                        context = null;
                    } else {
                        context = mtop.getMtopConfig().context;
                    }
                    a a = a.a(context);
                    if (a != null) {
                        mtopLoginMap.put(instanceId, a);
                        iRemoteLogin = a;
                    } else {
                        TBSdkLog.e("mtopsdk.RemoteLogin", instanceId + " [getLogin]loginImpl is null");
                        throw new e(instanceId + " [getLogin] Login Not Implement!");
                    }
                }
            }
        }
        return iRemoteLogin;
    }

    public static void setLoginImpl(Mtop mtop, IRemoteLogin iRemoteLogin) {
        if (iRemoteLogin != null) {
            String instanceId = mtop == null ? "INNER" : mtop.getInstanceId();
            mtopLoginMap.put(instanceId, iRemoteLogin);
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i("mtopsdk.RemoteLogin", instanceId + " [setLoginImpl] set loginImpl=" + iRemoteLogin);
            }
        }
    }

    public static void login(Mtop mtop, String str, boolean z, Object obj) {
        String str2;
        IRemoteLogin login = getLogin(mtop);
        if (mtop == null) {
            str2 = "INNER";
        } else {
            str2 = mtop.getInstanceId();
        }
        String concatStr = StringUtils.concatStr(str2, StringUtils.isBlank(str) ? "DEFAULT" : str);
        String str3 = null;
        MultiAccountRemoteLogin multiAccountRemoteLogin = login instanceof MultiAccountRemoteLogin ? (MultiAccountRemoteLogin) login : null;
        if (!"DEFAULT".equals(str)) {
            str3 = str;
        }
        if (!(multiAccountRemoteLogin != null ? multiAccountRemoteLogin.isLogining(str3) : login.isLogining())) {
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.ErrorEnable)) {
                TBSdkLog.e("mtopsdk.RemoteLogin", concatStr + " [login]call login");
            }
            if (obj != null && (login instanceof a)) {
                ((a) login).a(obj);
            }
            d a = d.a(mtop, str);
            if (multiAccountRemoteLogin != null) {
                multiAccountRemoteLogin.login(str3, a, z);
            } else {
                login.login(a, z);
            }
            a.sendEmptyMessageDelayed(911104, 20000);
        } else if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.ErrorEnable)) {
            TBSdkLog.e("mtopsdk.RemoteLogin", concatStr + " [login] loginsdk is logining");
        }
    }

    public static void setSessionInvalid(Mtop mtop, Bundle bundle) {
        String str;
        IRemoteLogin login = getLogin(mtop);
        if (login instanceof IRemoteLoginAdapter) {
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                if (mtop == null) {
                    str = "INNER";
                } else {
                    str = mtop.getInstanceId();
                }
                TBSdkLog.i("mtopsdk.RemoteLogin", str + " [setSessionInvalid] bundle=" + bundle);
            }
            ((IRemoteLoginAdapter) login).setSessionInvalid(bundle);
        }
    }

    public static boolean isSessionValid(Mtop mtop, String str) {
        IRemoteLogin login = getLogin(mtop);
        MultiAccountRemoteLogin multiAccountRemoteLogin = login instanceof MultiAccountRemoteLogin ? (MultiAccountRemoteLogin) login : null;
        if ("DEFAULT".equals(str)) {
            str = null;
        }
        if (multiAccountRemoteLogin != null ? multiAccountRemoteLogin.isLogining(str) : login.isLogining()) {
            return false;
        }
        return multiAccountRemoteLogin != null ? multiAccountRemoteLogin.isSessionValid(str) : login.isSessionValid();
    }

    public static LoginContext getLoginContext(Mtop mtop, String str) {
        IRemoteLogin login = getLogin(mtop);
        if (!(login instanceof MultiAccountRemoteLogin)) {
            return login.getLoginContext();
        }
        if ("DEFAULT".equals(str)) {
            str = null;
        }
        return ((MultiAccountRemoteLogin) login).getLoginContext(str);
    }

    @Deprecated
    public static IRemoteLogin getLogin() {
        return getLogin(null);
    }

    @Deprecated
    public static void setLoginImpl(IRemoteLogin iRemoteLogin) {
        setLoginImpl(null, iRemoteLogin);
    }

    @Deprecated
    public static void login(boolean z) {
        login(null, null, z, null);
    }

    @Deprecated
    public static void login(boolean z, Object obj) {
        login(null, null, z, obj);
    }

    @Deprecated
    public static boolean isSessionValid() {
        return isSessionValid(null, null);
    }

    @Deprecated
    public static LoginContext getLoginContext() {
        return getLoginContext(null, null);
    }
}
