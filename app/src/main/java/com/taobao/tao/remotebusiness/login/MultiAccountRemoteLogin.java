package com.taobao.tao.remotebusiness.login;

public abstract class MultiAccountRemoteLogin implements IRemoteLogin {
    public abstract LoginContext getLoginContext(String str);

    public abstract boolean isLogining(String str);

    public abstract boolean isSessionValid(String str);

    public abstract void login(String str, onLoginListener onloginlistener, boolean z);

    @Override // com.taobao.tao.remotebusiness.login.IRemoteLogin
    @Deprecated
    public void login(onLoginListener onloginlistener, boolean z) {
        login(null, onloginlistener, z);
    }

    @Override // com.taobao.tao.remotebusiness.login.IRemoteLogin
    @Deprecated
    public boolean isSessionValid() {
        return isSessionValid(null);
    }

    @Override // com.taobao.tao.remotebusiness.login.IRemoteLogin
    @Deprecated
    public boolean isLogining() {
        return isLogining(null);
    }

    @Override // com.taobao.tao.remotebusiness.login.IRemoteLogin
    @Deprecated
    public LoginContext getLoginContext() {
        return getLoginContext(null);
    }
}
