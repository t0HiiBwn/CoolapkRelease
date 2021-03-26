package com.alibaba.baichuan.trade.biz.auth;

import android.text.TextUtils;
import com.alibaba.baichuan.trade.common.adapter.ut.AlibcUserTracker;
import com.alibaba.baichuan.trade.common.adapter.ut.AlibcUserTradeHelper;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import com.taobao.tao.remotebusiness.auth.AuthListener;
import com.taobao.tao.remotebusiness.auth.IRemoteAuth;
import java.util.List;

public class b implements IRemoteAuth {
    private boolean a;

    private static class a {
        public static b a = new b();
    }

    /* renamed from: com.alibaba.baichuan.trade.biz.auth.b$b  reason: collision with other inner class name */
    class C0011b implements AlibcAuthListener {
        AuthListener a;

        C0011b(AuthListener authListener) {
            this.a = authListener;
        }

        @Override // com.alibaba.baichuan.trade.biz.auth.AlibcAuthListener
        public void onCancel() {
            b.this.a(false);
            AuthListener authListener = this.a;
            if (authListener != null) {
                authListener.onAuthCancel("FAIL_SYS_ACCESS_TOKEN_CANCEL", "用户取消授权");
            }
        }

        @Override // com.alibaba.baichuan.trade.biz.auth.AlibcAuthListener
        public void onError(String str, String str2) {
            b.this.a(false);
            AuthListener authListener = this.a;
            if (authListener != null) {
                authListener.onAuthFail(str, str2);
            }
        }

        @Override // com.alibaba.baichuan.trade.biz.auth.AlibcAuthListener
        public void onReTry() {
            b.this.a(true);
        }

        @Override // com.alibaba.baichuan.trade.biz.auth.AlibcAuthListener
        public void onSuccess() {
            b.this.a(false);
            AuthListener authListener = this.a;
            if (authListener != null) {
                authListener.onAuthSuccess();
            }
        }
    }

    private b() {
        this.a = false;
    }

    public static b a() {
        return a.a;
    }

    /* access modifiers changed from: private */
    public synchronized void a(boolean z) {
        this.a = z;
    }

    @Override // com.taobao.tao.remotebusiness.auth.IRemoteAuth
    public void authorize(String str, String str2, String str3, boolean z, AuthListener authListener) {
        AlibcLogger.d("Alibc", "call authorize authParam = " + str + " api_v = " + str2 + " errorInfo = " + str3);
        a(true);
        if (!TextUtils.isEmpty(str)) {
            List<String> a2 = AlibcAuth.a(str);
            AlibcAuth.postHintList(str, str3);
            AlibcAuth.auth(a2, str3, z, new C0011b(authListener));
        } else {
            AlibcAuth.auth(str2, str3, z, new C0011b(authListener));
        }
        if (!TextUtils.isEmpty(str3)) {
            AlibcUserTracker.getInstance().sendUsabilityFailure("BCPCSDK", "Hint_List_Error", AlibcUserTradeHelper.getArgs(), "190101", "权限列表配置错误");
        }
    }

    @Override // com.taobao.tao.remotebusiness.auth.IRemoteAuth
    public String getAuthToken() {
        String authToken = AlibcAuthInfo.getInstance().getAuthToken();
        AlibcLogger.d("Alibc", "getAuthToken = " + authToken);
        return authToken;
    }

    @Override // com.taobao.tao.remotebusiness.auth.IRemoteAuth
    public boolean isAuthInfoValid() {
        boolean checkAuthToken = AlibcAuthInfo.getInstance().checkAuthToken();
        AlibcLogger.d("Alibc", "isAuthInfoValid = " + checkAuthToken);
        return checkAuthToken;
    }

    @Override // com.taobao.tao.remotebusiness.auth.IRemoteAuth
    public synchronized boolean isAuthorizing() {
        AlibcLogger.d("Alibc", "isAuthorizing = " + this.a);
        return this.a;
    }
}
