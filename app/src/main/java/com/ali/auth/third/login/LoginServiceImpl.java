package com.ali.auth.third.login;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.ali.auth.third.core.WebViewProxy;
import com.ali.auth.third.core.broadcast.LoginAction;
import com.ali.auth.third.core.callback.CommonCallback;
import com.ali.auth.third.core.callback.LoginCallback;
import com.ali.auth.third.core.callback.NQrCodeLoginCallback;
import com.ali.auth.third.core.config.ConfigManager;
import com.ali.auth.third.core.context.KernelContext;
import com.ali.auth.third.core.cookies.CookieManagerWrapper;
import com.ali.auth.third.core.model.Constants;
import com.ali.auth.third.core.model.ResultCode;
import com.ali.auth.third.core.model.Session;
import com.ali.auth.third.core.service.UserTrackerService;
import com.ali.auth.third.core.service.impl.CredentialManager;
import com.ali.auth.third.core.service.impl.ExecutorServiceImpl;
import com.ali.auth.third.core.trace.SDKLogger;
import com.ali.auth.third.core.util.CommonUtils;
import com.ali.auth.third.core.util.JSONUtils;
import com.ali.auth.third.core.util.ResourceUtils;
import com.ali.auth.third.login.callback.LogoutCallback;
import com.ali.auth.third.login.task.LoginByReTokenTask;
import com.ali.auth.third.login.task.LogoutTask;
import com.ali.auth.third.login.util.LoginStatus;
import com.ali.auth.third.ui.LoginActivity;
import com.ali.auth.third.ui.context.CallbackContext;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class LoginServiceImpl implements LoginService {
    private transient Pattern[] a;
    private transient Pattern[] b;

    class a extends AsyncTask<Object, Void, Void> {
        CommonCallback a;

        a(CommonCallback commonCallback) {
            this.a = commonCallback;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(Object... objArr) {
            CookieManagerWrapper.INSTANCE.refreshCookie();
            return null;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(Void r1) {
            this.a.onSuccess();
        }
    }

    /* access modifiers changed from: private */
    public void a(Activity activity, LoginCallback loginCallback) {
        SDKLogger.d("login", "auth goLogin");
        CallbackContext.loginCallback = loginCallback;
        Intent intent = new Intent();
        if (activity == null) {
            intent.setClass(KernelContext.getApplicationContext(), LoginActivity.class);
            intent.setFlags(268435456);
            KernelContext.getApplicationContext().startActivity(intent);
            return;
        }
        intent.setClass(activity, LoginActivity.class);
        activity.startActivity(intent);
    }

    private void a(String str, LoginCallback loginCallback) {
        SDKLogger.d("login", "goSsoTokenLogin start");
        CallbackContext.loginCallback = loginCallback;
        Intent intent = new Intent();
        intent.setClass(KernelContext.getApplicationContext(), LoginActivity.class);
        intent.setFlags(268435456);
        intent.putExtra("login_type", 5);
        intent.putExtra("token", str);
        KernelContext.getApplicationContext().startActivity(intent);
    }

    /* access modifiers changed from: private */
    public void a(Map<String, String> map, LoginCallback loginCallback) {
        SDKLogger.d("login", "goQrCodeLogin start");
        CallbackContext.loginCallback = loginCallback;
        Intent intent = new Intent();
        intent.setClass(KernelContext.getApplicationContext(), LoginActivity.class);
        intent.setFlags(268435456);
        intent.putExtra("login_type", 4);
        intent.putExtra("params", map == null ? "" : JSONUtils.toJsonObject(map).toString());
        KernelContext.getApplicationContext().startActivity(intent);
    }

    private boolean a(LoginCallback loginCallback) {
        if (!KernelContext.checkServiceValid()) {
            SDKLogger.d("login", "auth static field is null");
            if (loginCallback != null) {
                loginCallback.onFailure(10098, "NullPointException");
            }
            return false;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("withNoActivity", "true");
            ((UserTrackerService) KernelContext.getService(UserTrackerService.class)).send("auth".toUpperCase(), hashMap);
        } catch (Exception unused) {
        }
        if (!LoginStatus.compareAndSetLogining(false, true)) {
            if (System.currentTimeMillis() - LoginStatus.getLastLoginTime() >= 60000) {
                LoginStatus.resetLoginFlag();
            }
            SDKLogger.e("login", "auth sdk is Logining, return");
            return false;
        } else if (CommonUtils.isNetworkAvailable()) {
            return true;
        } else {
            SDKLogger.d("login", "auth network not available");
            loginCallback.onFailure(10099, ResourceUtils.getString("com_taobao_tae_sdk_network_not_available_message"));
            LoginStatus.resetLoginFlag();
            return false;
        }
    }

    @Override // com.ali.auth.third.login.LoginService
    public void auth(final Activity activity, final LoginCallback loginCallback) {
        SDKLogger.d("login", "auth start");
        if (!a(loginCallback)) {
            SDKLogger.d("login", "AutnEnvriment invalid");
        } else if (System.currentTimeMillis() - Constants.mBusyControl >= 10000) {
            autoLogin(new LoginCallback() {
                /* class com.ali.auth.third.login.LoginServiceImpl.AnonymousClass1 */

                @Override // com.ali.auth.third.core.callback.FailureCallback
                public void onFailure(int i, String str) {
                    LoginServiceImpl.this.a(activity, loginCallback);
                }

                @Override // com.ali.auth.third.core.callback.LoginCallback
                public void onSuccess(Session session) {
                    LoginCallback loginCallback = loginCallback;
                    if (loginCallback != null) {
                        loginCallback.onSuccess(LoginServiceImpl.this.getSession());
                    }
                }
            });
        } else if (loginCallback != null) {
            loginCallback.onFailure(ResultCode.BUSY_CONTROL.code, ResultCode.BUSY_CONTROL.message);
        }
    }

    @Override // com.ali.auth.third.login.LoginService
    public void auth(LoginCallback loginCallback) {
        auth(null, loginCallback);
    }

    @Override // com.ali.auth.third.login.LoginService
    public void autoLogin(final LoginCallback loginCallback) {
        if (!TextUtils.isEmpty(CredentialManager.INSTANCE.getInternalSession().autoLoginToken) && CredentialManager.INSTANCE.getInternalSession().user != null && !TextUtils.isEmpty(CredentialManager.INSTANCE.getInternalSession().user.userId)) {
            SDKLogger.d("login", "auth auto login");
            new LoginByReTokenTask(null, new LoginCallback() {
                /* class com.ali.auth.third.login.LoginServiceImpl.AnonymousClass3 */

                @Override // com.ali.auth.third.core.callback.FailureCallback
                public void onFailure(int i, String str) {
                    SDKLogger.d("login", "auth auto login success");
                    LoginCallback loginCallback = loginCallback;
                    if (loginCallback != null) {
                        loginCallback.onFailure(i, str);
                    }
                }

                @Override // com.ali.auth.third.core.callback.LoginCallback
                public void onSuccess(Session session) {
                    SDKLogger.d("login", "auth auto login success");
                    LoginCallback loginCallback = loginCallback;
                    if (loginCallback != null) {
                        loginCallback.onSuccess(LoginServiceImpl.this.getSession());
                    }
                    if (CallbackContext.mGlobalLoginCallback != null) {
                        CallbackContext.mGlobalLoginCallback.onSuccess(LoginServiceImpl.this.getSession());
                    }
                    CommonUtils.sendBroadcast(LoginAction.NOTIFY_LOGIN_SUCCESS);
                }
            }).executeOnExecutor(ExecutorServiceImpl.mExecutor == null ? AsyncTask.THREAD_POOL_EXECUTOR : ExecutorServiceImpl.mExecutor, new String[0]);
        } else if (loginCallback != null) {
            loginCallback.onFailure(-1, "auto login token is empty");
        }
    }

    @Override // com.ali.auth.third.login.LoginService
    public boolean checkSessionValid() {
        return com.ali.auth.third.login.a.a.b.isSessionValid();
    }

    @Override // com.ali.auth.third.login.LoginService
    public void clear() {
        CallbackContext.loginCallback = null;
    }

    @Override // com.ali.auth.third.login.LoginService
    public void createQrCodeAndLogin(Map<String, String> map, NQrCodeLoginCallback nQrCodeLoginCallback) {
        QRComponent.start(Integer.parseInt(map.get("width")), Integer.parseInt(map.get("height")), nQrCodeLoginCallback);
    }

    @Override // com.ali.auth.third.login.LoginService
    public Session getSession() {
        return com.ali.auth.third.login.a.a.b.getSession();
    }

    @Override // com.ali.auth.third.login.LoginService
    public boolean isLoginUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.a == null && !TextUtils.isEmpty(ConfigManager.LOGIN_URLS)) {
            String[] split = ConfigManager.LOGIN_URLS.split("[,]");
            Pattern[] patternArr = new Pattern[split.length];
            this.a = patternArr;
            int length = patternArr.length;
            for (int i = 0; i < length; i++) {
                this.a[i] = Pattern.compile(split[i]);
            }
        }
        for (Pattern pattern : this.a) {
            if (pattern.matcher(str).matches()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.ali.auth.third.login.LoginService
    public boolean isLogoutUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.b == null && !TextUtils.isEmpty(ConfigManager.LOGOUT_URLS)) {
            String[] split = ConfigManager.LOGOUT_URLS.split("[,]");
            Pattern[] patternArr = new Pattern[split.length];
            this.b = patternArr;
            int length = patternArr.length;
            for (int i = 0; i < length; i++) {
                this.b[i] = Pattern.compile(split[i]);
            }
        }
        for (Pattern pattern : this.b) {
            if (pattern.matcher(str).matches()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.ali.auth.third.login.LoginService
    public void loginBySsoToken(String str, LoginCallback loginCallback) {
        if (!TextUtils.isEmpty(str)) {
            a(str, loginCallback);
        } else if (loginCallback != null) {
            loginCallback.onFailure(-1, "sso token is empty");
        }
    }

    @Override // com.ali.auth.third.login.LoginService
    public void logout(Activity activity, LogoutCallback logoutCallback) {
        Constants.mBusyControl = 0;
        ((UserTrackerService) KernelContext.getService(UserTrackerService.class)).send("logout".toUpperCase(), null);
        new LogoutTask(activity, logoutCallback).executeOnExecutor(ExecutorServiceImpl.mExecutor == null ? AsyncTask.THREAD_POOL_EXECUTOR : ExecutorServiceImpl.mExecutor, new Void[0]);
    }

    @Override // com.ali.auth.third.login.LoginService
    public void logout(LogoutCallback logoutCallback) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("withNoActivity", "true");
            ((UserTrackerService) KernelContext.getService(UserTrackerService.class)).send("logout".toUpperCase(), hashMap);
        } catch (Exception unused) {
        }
        logout(null, logoutCallback);
    }

    @Override // com.ali.auth.third.login.LoginService
    public void refreshCookie(CommonCallback commonCallback) {
        new a(commonCallback).executeOnExecutor(ExecutorServiceImpl.mExecutor == null ? AsyncTask.THREAD_POOL_EXECUTOR : ExecutorServiceImpl.mExecutor, new Object[0]);
    }

    @Override // com.ali.auth.third.login.LoginService
    public void setLoginCallback(LoginCallback loginCallback) {
        CallbackContext.mGlobalLoginCallback = loginCallback;
    }

    @Override // com.ali.auth.third.login.LoginService
    public void setWebViewProxy(WebViewProxy webViewProxy) {
        KernelContext.mWebViewProxy = webViewProxy;
    }

    @Override // com.ali.auth.third.login.LoginService
    public void showQrCodeLogin(final Map<String, String> map, final LoginCallback loginCallback) {
        if (a(loginCallback)) {
            autoLogin(new LoginCallback() {
                /* class com.ali.auth.third.login.LoginServiceImpl.AnonymousClass2 */

                @Override // com.ali.auth.third.core.callback.FailureCallback
                public void onFailure(int i, String str) {
                    LoginServiceImpl.this.a(map, loginCallback);
                }

                @Override // com.ali.auth.third.core.callback.LoginCallback
                public void onSuccess(Session session) {
                    LoginCallback loginCallback = loginCallback;
                    if (loginCallback != null) {
                        loginCallback.onSuccess(LoginServiceImpl.this.getSession());
                    }
                }
            });
        }
    }
}
