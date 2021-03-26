package com.alibaba.baichuan.trade.biz.login;

import com.ali.auth.third.core.MemberSDK;
import com.ali.auth.third.core.callback.InitResultCallback;
import com.ali.auth.third.core.callback.LoginCallback;
import com.ali.auth.third.core.config.ConfigManager;
import com.ali.auth.third.core.model.Session;
import com.ali.auth.third.login.LoginService;
import com.ali.auth.third.login.callback.LogoutCallback;
import com.alibaba.baichuan.trade.biz.AlibcTradeBiz;
import com.alibaba.baichuan.trade.biz.core.usertracker.UserTrackerConstants;
import com.alibaba.baichuan.trade.biz.webview.AlibcUrlBus;
import com.alibaba.baichuan.trade.common.AlibcTradeCommon;
import com.alibaba.baichuan.trade.common.Environment;
import com.alibaba.baichuan.trade.common.adapter.ut.AlibcUserTracker;
import com.alibaba.baichuan.trade.common.adapter.ut.AlibcUserTradeHelper;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import java.util.HashMap;

public class AlibcLogin {
    public static final int LOGIN_INIT_AD = 1;
    public static final int LOGIN_INIT_SUCCESS = 0;
    public static final int LOGIN_SUCCESS = 2;
    public static final int LOGOUT_SUCCESS = 3;
    private int a;
    private String b;
    private int c;
    private String d;
    private boolean e;
    private LoginService f;

    private static class a {
        public static AlibcLogin a = new AlibcLogin();
    }

    private AlibcLogin() {
        this.a = -1;
        this.b = "context对象为空导致失败";
        this.c = -2;
        this.d = "loginService对象为空导致失败";
    }

    private void a() {
        if (AlibcTradeCommon.getEnvironment() != null) {
            MemberSDK.setEnvironment(AlibcTradeCommon.getEnvironment() == Environment.TEST ? com.ali.auth.third.core.config.Environment.TEST : AlibcTradeCommon.getEnvironment() == Environment.PRE ? com.ali.auth.third.core.config.Environment.PRE : com.ali.auth.third.core.config.Environment.ONLINE);
        }
    }

    /* access modifiers changed from: private */
    public void a(int i) {
        String str;
        String str2;
        if (i == 10004 || i == 10003) {
            str = "登录取消";
            str2 = "140102";
        } else {
            str = "登录失败";
            str2 = "140101";
        }
        AlibcUserTradeHelper.sendUsabilityFailure("Login", str, str2);
    }

    /* access modifiers changed from: private */
    public void a(String str, boolean z, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("appkey", AlibcTradeCommon.getAppKey());
        if (getInstance().getSession() != null) {
            hashMap.put("userId", getInstance().getSession().openId);
        }
        hashMap.put("utdid", AlibcTradeCommon.getUtdid());
        hashMap.put("ttid", AlibcTradeBiz.getTTID());
        hashMap.put("isSuccess", z ? "1" : "0");
        hashMap.put("errorCode", String.valueOf(i));
        AlibcUserTracker.getInstance().sendCustomHit(str, "", hashMap);
    }

    /* access modifiers changed from: private */
    public void b() {
        AlibcUserTradeHelper.sendUsabilitySuccess("Login");
    }

    public static AlibcLogin getInstance() {
        return a.a;
    }

    public Session getSession() {
        LoginService loginService = this.f;
        if (loginService == null || !this.e) {
            return null;
        }
        return loginService.getSession();
    }

    public synchronized void init(final AlibcLoginCallback alibcLoginCallback) {
        AlibcLogger.d("AlibcLogin", "初始化AlibcLogin");
        if (alibcLoginCallback != null) {
            if (this.e) {
                AlibcLogger.d("AlibcLogin", "AlibcLogin 已经初始化过了");
                alibcLoginCallback.onSuccess(1, "", "");
            }
            if (AlibcTradeCommon.context == null) {
                AlibcLogger.e("AlibcLogin", "AlibcTradeCommon.context 为空,导致初始化失败");
                alibcLoginCallback.onFailure(this.a, this.b);
            }
            a();
            ConfigManager.POSTFIX_OF_SECURITY_JPG_USER_SET = "baichuan";
            AlibcLogger.d("AlibcLogin", "初始化 MemberSDK");
            MemberSDK.init(AlibcTradeCommon.context, new InitResultCallback() {
                /* class com.alibaba.baichuan.trade.biz.login.AlibcLogin.AnonymousClass1 */

                @Override // com.ali.auth.third.core.callback.FailureCallback
                public void onFailure(int i, String str) {
                    AlibcLogger.e("AlibcLogin", "MemberSDK init error, code: " + i + " message: " + str);
                    alibcLoginCallback.onFailure(i, str);
                    AlibcLogin.this.e = false;
                }

                @Override // com.ali.auth.third.core.callback.InitResultCallback
                public void onSuccess() {
                    AlibcLogger.d("AlibcLogin", "MemberSDK init success");
                    AlibcLogin.this.f = (LoginService) MemberSDK.getService(LoginService.class);
                    if (AlibcLogin.this.f != null) {
                        alibcLoginCallback.onSuccess(0, "", "");
                    } else {
                        alibcLoginCallback.onFailure(AlibcLogin.this.c, AlibcLogin.this.d);
                    }
                    AlibcLogin.this.e = true;
                }
            });
            AlibcUrlBus.registInterceptor(a.a());
        }
    }

    public boolean isLogin() {
        LoginService loginService = this.f;
        if (loginService == null || !this.e) {
            return false;
        }
        return loginService.checkSessionValid();
    }

    public void logout(final AlibcLoginCallback alibcLoginCallback) {
        AlibcLogger.d("AlibcLogin", "登出操作");
        if (alibcLoginCallback != null) {
            if (!this.e || this.f == null) {
                AlibcLogger.e("AlibcLogin", "没有初始化成功或者loginService=null,导致调用失败");
                alibcLoginCallback.onFailure(this.c, this.d);
                return;
            }
            AlibcLogger.d("AlibcLogin", "调用loginService.logout进行登出");
            this.f.logout(new LogoutCallback() {
                /* class com.alibaba.baichuan.trade.biz.login.AlibcLogin.AnonymousClass3 */

                @Override // com.ali.auth.third.core.callback.FailureCallback
                public void onFailure(int i, String str) {
                    AlibcLogger.d("AlibcLogin", "logout失败");
                    alibcLoginCallback.onFailure(i, str);
                }

                @Override // com.ali.auth.third.login.callback.LogoutCallback
                public void onSuccess() {
                    AlibcLogger.d("AlibcLogin", "logout成功");
                    alibcLoginCallback.onSuccess(3, "", "");
                }
            });
        }
    }

    public void showLogin(final AlibcLoginCallback alibcLoginCallback) {
        AlibcLogger.d("AlibcLogin", "登录操作");
        if (alibcLoginCallback != null) {
            if (!this.e || this.f == null) {
                AlibcLogger.e("AlibcLogin", "没有初始化成功或者loginService=null,导致调用失败");
                alibcLoginCallback.onFailure(this.c, this.d);
                return;
            }
            AlibcLogger.d("AlibcLogin", "调用loginService.auth进行授权");
            this.f.auth(new LoginCallback() {
                /* class com.alibaba.baichuan.trade.biz.login.AlibcLogin.AnonymousClass2 */

                @Override // com.ali.auth.third.core.callback.FailureCallback
                public void onFailure(int i, String str) {
                    AlibcLogger.d("AlibcLogin", "auth失败: code = " + i + ", msg = " + str);
                    AlibcLogin.this.a(i);
                    AlibcLogin.this.a(UserTrackerConstants.E_SHOWLOGIN_FAIL, false, i);
                    alibcLoginCallback.onFailure(i, str);
                }

                @Override // com.ali.auth.third.core.callback.LoginCallback
                public void onSuccess(Session session) {
                    AlibcLogger.d("AlibcLogin", "auth成功");
                    AlibcLogin.this.b();
                    AlibcLogin.this.a(UserTrackerConstants.E_SHOWLOGIN_SUCCESS, true, 0);
                    alibcLoginCallback.onSuccess(2, session.openId, session.nick);
                }
            });
        }
    }

    public void turnOffDebug() {
        MemberSDK.turnOffDebug();
    }

    public void turnOnDebug() {
        MemberSDK.turnOnDebug();
    }
}
