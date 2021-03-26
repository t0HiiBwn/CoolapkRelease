package com.taobao.tao.remotebusiness.login;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.taobao.tao.remotebusiness.c;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.intf.Mtop;

/* compiled from: LoginHandler */
class d extends Handler implements onLoginListener {
    private static Map<String, d> a = new ConcurrentHashMap();
    private static HandlerThread b;
    private Mtop c;
    private String d;

    private d(Mtop mtop, String str, Looper looper) {
        super(looper);
        this.c = mtop;
        this.d = str;
    }

    public static d a(Mtop mtop, String str) {
        Mtop instance = mtop == null ? Mtop.instance(null) : mtop;
        if (StringUtils.isBlank(str)) {
            str = "DEFAULT";
        }
        String b2 = b(mtop, str);
        d dVar = a.get(b2);
        if (dVar == null) {
            synchronized (d.class) {
                dVar = a.get(b2);
                if (dVar == null) {
                    if (b == null) {
                        HandlerThread handlerThread = new HandlerThread("mtopsdk.LoginHandler");
                        b = handlerThread;
                        handlerThread.start();
                    }
                    dVar = new d(instance, str, b.getLooper());
                    a.put(b2, dVar);
                }
            }
        }
        return dVar;
    }

    @Deprecated
    public static d a() {
        return a(Mtop.instance(null), null);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        String b2 = b(this.c, this.d);
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.ErrorEnable)) {
            TBSdkLog.e("mtopsdk.LoginHandler", b2 + " [handleMessage]The MtopBusiness LoginHandler receive message .");
        }
        switch (message.what) {
            case 911101:
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.ErrorEnable)) {
                    TBSdkLog.e("mtopsdk.LoginHandler", b2 + " [handleMessage]onReceive: NOTIFY_LOGIN_SUCCESS.");
                }
                a(b2);
                c.a("SESSION").a(this.c, this.d);
                removeMessages(911104);
                return;
            case 911102:
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.ErrorEnable)) {
                    TBSdkLog.e("mtopsdk.LoginHandler", b2 + "[handleMessage]onReceive: NOTIFY_LOGIN_FAILED.");
                }
                c.a("SESSION").a(this.c, this.d, "ANDROID_SYS_LOGIN_FAIL", "登录失败");
                removeMessages(911104);
                return;
            case 911103:
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.ErrorEnable)) {
                    TBSdkLog.e("mtopsdk.LoginHandler", b2 + "[handleMessage]onReceive: NOTIFY_LOGIN_CANCEL.");
                }
                c.a("SESSION").a(this.c, this.d, "ANDROID_SYS_LOGIN_CANCEL", "登录被取消");
                removeMessages(911104);
                return;
            case 911104:
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.ErrorEnable)) {
                    TBSdkLog.e("mtopsdk.LoginHandler", b2 + "[handleMessage]onReceive: NOTIFY_LOGIN_TIMEOUT.");
                }
                if (RemoteLogin.isSessionValid(this.c, this.d)) {
                    if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.ErrorEnable)) {
                        TBSdkLog.e("mtopsdk.LoginHandler", "Session valid, Broadcast may missed!");
                    }
                    a(b2);
                    c.a("SESSION").a(this.c, this.d);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void a(String str) {
        LoginContext loginContext = RemoteLogin.getLoginContext(this.c, this.d);
        if (loginContext == null) {
            TBSdkLog.e("mtopsdk.LoginHandler", str + " [updateXStateSessionInfo] LoginContext is null.");
            return;
        }
        try {
            if (StringUtils.isNotBlank(loginContext.sid) && !loginContext.sid.equals(this.c.getMultiAccountSid(this.d))) {
                this.c.registerMultiAccountSession(this.d, loginContext.sid, loginContext.userId);
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.ErrorEnable)) {
                    TBSdkLog.e("mtopsdk.LoginHandler", str + " [updateXStateSessionInfo] invoked.");
                }
            }
        } catch (Exception e) {
            TBSdkLog.e("mtopsdk.LoginHandler", str + " [updateXStateSessionInfo] error.", e);
        }
    }

    private static String b(Mtop mtop, String str) {
        if (StringUtils.isBlank(str)) {
            str = "DEFAULT";
        }
        return StringUtils.concatStr(mtop.getInstanceId(), str);
    }

    @Override // com.taobao.tao.remotebusiness.login.onLoginListener
    public void onLoginSuccess() {
        sendEmptyMessage(911101);
    }

    @Override // com.taobao.tao.remotebusiness.login.onLoginListener
    public void onLoginFail() {
        sendEmptyMessage(911102);
    }

    @Override // com.taobao.tao.remotebusiness.login.onLoginListener
    public void onLoginCancel() {
        sendEmptyMessage(911103);
    }
}
