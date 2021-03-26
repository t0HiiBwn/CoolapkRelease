package com.ali.auth.third.core.service.impl;

import android.text.TextUtils;
import com.ali.auth.third.core.context.KernelContext;
import com.ali.auth.third.core.cookies.CookieManagerWrapper;
import com.ali.auth.third.core.history.AccountHistoryManager;
import com.ali.auth.third.core.model.AccountContract;
import com.ali.auth.third.core.model.Constants;
import com.ali.auth.third.core.model.HistoryAccount;
import com.ali.auth.third.core.model.InternalSession;
import com.ali.auth.third.core.model.LoginDataModel;
import com.ali.auth.third.core.model.LoginReturnData;
import com.ali.auth.third.core.model.ResultCode;
import com.ali.auth.third.core.model.Session;
import com.ali.auth.third.core.model.User;
import com.ali.auth.third.core.registry.a;
import com.ali.auth.third.core.service.CredentialService;
import com.ali.auth.third.core.service.RpcService;
import com.ali.auth.third.core.service.StorageService;
import com.ali.auth.third.core.trace.SDKLogger;
import com.ali.auth.third.core.util.JSONUtils;
import com.ali.auth.third.core.util.ReflectionUtils;
import com.ali.auth.third.core.util.SystemUtils;
import java.net.URLDecoder;
import java.util.ArrayList;
import org.json.JSONObject;

public class CredentialManager implements CredentialService {
    public static final CredentialManager INSTANCE = new CredentialManager();
    private static final String a = "CredentialManager";
    private volatile InternalSession b;
    public String internalSessionStoreKey = "internal_session";

    public CredentialManager() {
        try {
            a();
        } catch (Throwable unused) {
            this.b = new InternalSession();
            this.b.user = new User();
        }
    }

    private Object a(String str, String[] strArr, Object[] objArr) {
        try {
            return ReflectionUtils.newInstance(str, strArr, objArr);
        } catch (NoSuchMethodError e) {
            e.printStackTrace();
            return null;
        }
    }

    private void a() {
        if (KernelContext.storageService == null) {
            a(KernelContext.serviceRegistry);
        }
        String str = a;
        SDKLogger.d(str, "CredentialManager init step 1");
        String value = KernelContext.storageService.getValue("loginEnvironmentIndex", true);
        SDKLogger.d(str, "CredentialManager init step 2");
        String valueOf = String.valueOf(KernelContext.getEnvironment().ordinal());
        if (value == null || value.equals(valueOf)) {
            SDKLogger.d(str, "CredentialManager init step 3");
            String value2 = KernelContext.storageService.getValue(this.internalSessionStoreKey, true);
            SDKLogger.d(str, "CredentialManager init step 4");
            if (TextUtils.isEmpty(value2)) {
                value2 = KernelContext.storageService.getValue(this.internalSessionStoreKey, true);
            }
            if (!TextUtils.isEmpty(value2)) {
                this.b = createInternalSession(value2);
            } else {
                this.b = new InternalSession();
                this.b.user = new User();
            }
            SDKLogger.d(str, "CredentialManager init step 5");
            return;
        }
        KernelContext.storageService.putValue("loginEnvironmentIndex", valueOf, true);
        KernelContext.storageService.removeValue(this.internalSessionStoreKey, true);
        this.b = new InternalSession();
        this.b.user = new User();
    }

    private void a(InternalSession internalSession) {
        this.b = internalSession;
        KernelContext.storageService.putValue(this.internalSessionStoreKey, SystemUtils.toInternalSessionJSON(internalSession), true);
    }

    private void a(a aVar) {
        boolean z;
        String str = "com.ali.auth.third.securityguard.SecurityGuardWrapper";
        try {
            Class.forName(str);
            try {
                KernelContext.isMini = false;
                KernelContext.sdkVersion = KernelContext.SDK_VERSION_STD;
            } catch (Throwable unused) {
            }
            z = true;
        } catch (Throwable unused2) {
            z = false;
        }
        if (!z) {
            str = "com.ali.auth.third.core.storage.CommonStorageServiceImpl";
        }
        try {
            aVar.a(new Class[]{StorageService.class}, a(str, null, null), null);
            KernelContext.storageService = (StorageService) aVar.a(StorageService.class, null);
        } catch (NoSuchMethodError e) {
            e.printStackTrace();
        }
    }

    public long adjustSessionExpireTime(long j, long j2) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        return currentTimeMillis > j2 ? j > 0 ? j + (currentTimeMillis - j2) : 86400 + currentTimeMillis : j;
    }

    public InternalSession createInternalSession(String str) {
        InternalSession internalSession = new InternalSession();
        try {
            JSONObject jSONObject = new JSONObject(str);
            internalSession.sid = JSONUtils.optString(jSONObject, "sid");
            internalSession.expireIn = (long) JSONUtils.optInteger(jSONObject, "expireIn").intValue();
            User user = new User();
            JSONObject optJSONObject = jSONObject.optJSONObject("user");
            if (optJSONObject != null) {
                user.avatarUrl = optJSONObject.optString("avatarUrl");
                user.userId = optJSONObject.optString("userId");
                user.nick = optJSONObject.optString("nick");
                user.openId = optJSONObject.optString("openId");
                user.openSid = optJSONObject.optString("openSid");
                user.deviceTokenKey = optJSONObject.optString("deviceTokenKey");
                user.deviceTokenSalt = optJSONObject.optString("deviceTokenSalt");
                if (!TextUtils.isEmpty(internalSession.sid) && !TextUtils.isEmpty(user.userId)) {
                    ((RpcService) KernelContext.getService(RpcService.class)).registerSessionInfo(internalSession.sid, user.userId);
                }
            }
            internalSession.user = user;
            internalSession.loginTime = JSONUtils.optLong(jSONObject, "loginTime").longValue();
            internalSession.mobile = JSONUtils.optString(jSONObject, "mobile");
            internalSession.loginId = JSONUtils.optString(jSONObject, "loginId");
            internalSession.autoLoginToken = JSONUtils.optString(jSONObject, "autoLoginToken");
            internalSession.topAccessToken = JSONUtils.optString(jSONObject, "topAccessToken");
            internalSession.topExpireTime = JSONUtils.optString(jSONObject, "topExpireTime");
            internalSession.topAuthCode = JSONUtils.optString(jSONObject, "topAuthCode");
            internalSession.otherInfo = JSONUtils.toMap(jSONObject.optJSONObject("otherInfo"));
            internalSession.ssoToken = JSONUtils.optString(jSONObject, "ssoToken");
            internalSession.havanaSsoToken = JSONUtils.optString(jSONObject, "havanaSsoToken");
        } catch (Exception e) {
            SDKLogger.e(a, e.getMessage(), e);
        }
        return internalSession;
    }

    public InternalSession getInternalSession() {
        return this.b;
    }

    @Override // com.ali.auth.third.core.service.CredentialService
    public Session getSession() {
        Session session = new Session();
        String str = "";
        session.userid = (this.b == null || this.b.user == null) ? str : this.b.user.userId;
        session.nick = (this.b == null || this.b.user == null) ? str : this.b.user.nick;
        session.avatarUrl = (this.b == null || this.b.user == null) ? str : this.b.user.avatarUrl;
        session.openId = (this.b == null || this.b.user == null) ? str : this.b.user.openId;
        session.openSid = (this.b == null || this.b.user == null) ? str : this.b.user.openSid;
        session.topAccessToken = this.b == null ? str : this.b.topAccessToken;
        session.topAuthCode = this.b == null ? str : this.b.topAuthCode;
        session.topExpireTime = this.b == null ? str : this.b.topExpireTime;
        session.ssoToken = this.b == null ? str : this.b.ssoToken;
        if (this.b != null) {
            str = this.b.havanaSsoToken;
        }
        session.havanaSsoToken = str;
        return session;
    }

    @Override // com.ali.auth.third.core.service.CredentialService
    public boolean isSessionValid() {
        String str;
        String str2 = a;
        SDKLogger.d(str2, "func isSessionValid");
        if (this.b == null) {
            str = "isSessionValid()  internalSession is null";
        } else if (this.b.loginTime == 0 || this.b.expireIn == 0) {
            str = "isSessionValid()  loginTime is 0 or expireIn is 0";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("isSessionValid()  ");
            sb.append(System.currentTimeMillis() / 1000 < this.b.expireIn);
            SDKLogger.d(str2, sb.toString());
            return System.currentTimeMillis() / 1000 < this.b.expireIn;
        }
        SDKLogger.d(str2, str);
        return false;
    }

    @Override // com.ali.auth.third.core.service.CredentialService
    public ResultCode logout() {
        CookieManagerWrapper.INSTANCE.clearCookies();
        InternalSession internalSession = new InternalSession();
        internalSession.user = new User();
        a(internalSession);
        return ResultCode.SUCCESS;
    }

    @Override // com.ali.auth.third.core.service.CredentialService
    public void refreshWhenLogin(LoginReturnData loginReturnData) {
        if (loginReturnData != null && !TextUtils.isEmpty(loginReturnData.data)) {
            Constants.mBusyControl = System.currentTimeMillis();
            InternalSession internalSession = new InternalSession();
            try {
                LoginDataModel loginDataModel = (LoginDataModel) JSONUtils.toPOJO(new JSONObject(loginReturnData.data), LoginDataModel.class);
                internalSession.externalCookies = loginDataModel.externalCookies;
                User user = new User();
                user.userId = loginDataModel.userId;
                if (loginDataModel.nick != null) {
                    try {
                        user.nick = URLDecoder.decode(loginDataModel.nick, "UTF-8");
                    } catch (Exception e) {
                        SDKLogger.e(a, e.getMessage(), e);
                    }
                }
                user.openId = loginDataModel.openId;
                user.openSid = loginDataModel.openSid;
                user.avatarUrl = loginDataModel.headPicLink;
                user.email = loginDataModel.email;
                if (loginDataModel.loginServiceExt != null && !TextUtils.isEmpty(loginDataModel.loginServiceExt.get("1688ext"))) {
                    try {
                        JSONObject jSONObject = new JSONObject(loginDataModel.loginServiceExt.get("1688ext"));
                        user.cbuLoginId = jSONObject.optString("loginId");
                        user.memberId = jSONObject.optString("memberId");
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                if (loginReturnData.deviceToken != null) {
                    user.deviceTokenSalt = loginReturnData.deviceToken.salt;
                    user.deviceTokenKey = loginReturnData.deviceToken.key;
                }
                AccountHistoryManager.getInstance().putLoginHistory(new HistoryAccount(loginDataModel.userId, user.deviceTokenKey, loginDataModel.nick, loginDataModel.phone, loginDataModel.email), user.deviceTokenSalt);
                internalSession.user = user;
                internalSession.loginTime = loginDataModel.loginTime;
                internalSession.sid = loginDataModel.sid;
                internalSession.expireIn = adjustSessionExpireTime(loginDataModel.expires, loginDataModel.loginTime);
                internalSession.mobile = loginDataModel.loginPhone;
                internalSession.loginId = loginReturnData.showLoginId;
                internalSession.autoLoginToken = loginDataModel.autoLoginToken;
                internalSession.topAccessToken = loginDataModel.topAccessToken;
                internalSession.topAuthCode = loginDataModel.topAuthCode;
                internalSession.topExpireTime = loginDataModel.topExpireTime;
                internalSession.otherInfo = loginDataModel.extendAttribute;
                internalSession.ssoToken = loginReturnData.ssoToken;
                internalSession.havanaSsoToken = loginDataModel.havanaSsoToken;
                ((RpcService) KernelContext.getService(RpcService.class)).registerSessionInfo(loginDataModel.sid, loginDataModel.userId);
                String[] strArr = null;
                try {
                    Object obj = loginDataModel.extendAttribute.get("ssoDomainList");
                    if (obj != null && (obj instanceof ArrayList)) {
                        strArr = (String[]) ((ArrayList) obj).toArray(new String[0]);
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                CookieManagerWrapper.INSTANCE.injectCookie(loginDataModel.cookies, strArr);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            SDKLogger.e("session", "session = " + internalSession.toString());
            a(internalSession);
        }
    }

    @Override // com.ali.auth.third.core.service.CredentialService
    public void refreshWhenOfflineLogin(AccountContract accountContract) {
        InternalSession internalSession = new InternalSession();
        User user = new User();
        user.nick = KernelContext.storageService.decrypt(accountContract.getNick());
        user.openId = accountContract.getOpenid();
        user.userId = KernelContext.storageService.decrypt(accountContract.getUserid());
        internalSession.user = user;
        if (this.b == null || this.b.user == null || !TextUtils.equals(user.userId, this.b.user.userId)) {
            ((RpcService) KernelContext.getService(RpcService.class)).logout();
        } else {
            internalSession.autoLoginToken = this.b.autoLoginToken;
        }
        a(internalSession);
    }
}
