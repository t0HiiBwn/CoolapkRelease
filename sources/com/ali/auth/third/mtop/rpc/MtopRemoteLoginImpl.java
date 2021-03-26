package com.ali.auth.third.mtop.rpc;

import com.ali.auth.third.core.callback.LoginCallback;
import com.ali.auth.third.core.context.KernelContext;
import com.ali.auth.third.core.model.Session;
import com.ali.auth.third.core.util.ReflectionUtils;
import com.taobao.tao.remotebusiness.login.IRemoteLogin;
import com.taobao.tao.remotebusiness.login.LoginContext;
import com.taobao.tao.remotebusiness.login.onLoginListener;

public class MtopRemoteLoginImpl implements IRemoteLogin {
    @Override // com.taobao.tao.remotebusiness.login.IRemoteLogin
    public LoginContext getLoginContext() {
        LoginContext loginContext = new LoginContext();
        try {
            loginContext.nickname = KernelContext.credentialService.getSession().nick;
        } catch (Exception unused) {
        }
        return loginContext;
    }

    @Override // com.taobao.tao.remotebusiness.login.IRemoteLogin
    public boolean isLogining() {
        try {
            Object invoke = ReflectionUtils.invoke("com.ali.auth.third.login.util.LoginStatus", "isLogining", null, Class.forName("com.ali.auth.third.login.util.LoginStatus").newInstance(), null);
            if (invoke == null || !(invoke instanceof Boolean)) {
                return false;
            }
            return ((Boolean) invoke).booleanValue();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.taobao.tao.remotebusiness.login.IRemoteLogin
    public boolean isSessionValid() {
        return KernelContext.credentialService.isSessionValid();
    }

    @Override // com.taobao.tao.remotebusiness.login.IRemoteLogin
    public void login(final onLoginListener onloginlistener, boolean z) {
        try {
            ReflectionUtils.invoke("com.ali.auth.third.login.LoginServiceImpl", "auth", new String[]{"com.ali.auth.third.core.callback.LoginCallback"}, Class.forName("com.ali.auth.third.login.LoginServiceImpl").newInstance(), new Object[]{new LoginCallback() {
                /* class com.ali.auth.third.mtop.rpc.MtopRemoteLoginImpl.AnonymousClass1 */

                @Override // com.ali.auth.third.core.callback.FailureCallback
                public void onFailure(int i, String str) {
                    onLoginListener onloginlistener = onloginlistener;
                    if (onloginlistener == null) {
                        return;
                    }
                    if (i == 10003) {
                        onloginlistener.onLoginCancel();
                    } else {
                        onloginlistener.onLoginFail();
                    }
                }

                @Override // com.ali.auth.third.core.callback.LoginCallback
                public void onSuccess(Session session) {
                    onLoginListener onloginlistener = onloginlistener;
                    if (onloginlistener != null) {
                        onloginlistener.onLoginSuccess();
                    }
                }
            }});
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InstantiationException e3) {
            e3.printStackTrace();
        }
    }
}
