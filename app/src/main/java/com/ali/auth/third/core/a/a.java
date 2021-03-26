package com.ali.auth.third.core.a;

import android.os.Build;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.ali.auth.third.core.WebViewProxy;
import com.ali.auth.third.core.context.KernelContext;

public class a implements WebViewProxy {
    private static volatile a a;

    private a() {
    }

    public static a a() {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a();
                }
            }
        }
        return a;
    }

    @Override // com.ali.auth.third.core.WebViewProxy
    public void flush() {
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                CookieManager.getInstance().flush();
            } else {
                CookieSyncManager.createInstance(KernelContext.getApplicationContext()).sync();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.ali.auth.third.core.WebViewProxy
    public String getCookie(String str) {
        CookieManager instance = CookieManager.getInstance();
        instance.setAcceptCookie(true);
        return instance.getCookie(".taobao.com");
    }

    @Override // com.ali.auth.third.core.WebViewProxy
    public void removeAllCookie() {
        CookieManager.getInstance().removeAllCookie();
    }

    @Override // com.ali.auth.third.core.WebViewProxy
    public void removeExpiredCookie() {
        CookieManager.getInstance().removeExpiredCookie();
    }

    @Override // com.ali.auth.third.core.WebViewProxy
    public void removeSessionCookie() {
        CookieManager.getInstance().removeSessionCookie();
    }

    @Override // com.ali.auth.third.core.WebViewProxy
    public void setAcceptCookie(boolean z) {
        CookieManager.getInstance().setAcceptCookie(z);
    }

    @Override // com.ali.auth.third.core.WebViewProxy
    public void setCookie(String str, String str2) {
        CookieManager.getInstance().setCookie(str, str2);
    }
}
