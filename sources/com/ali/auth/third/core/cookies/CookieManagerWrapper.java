package com.ali.auth.third.core.cookies;

import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import com.ali.auth.third.core.context.KernelContext;
import com.ali.auth.third.core.service.impl.CredentialManager;
import com.ali.auth.third.core.trace.SDKLogger;
import com.ali.auth.third.core.util.FileUtils;
import java.util.ArrayList;

public class CookieManagerWrapper {
    public static final CookieManagerWrapper INSTANCE = new CookieManagerWrapper();
    private static final String a = "CookieManagerWrapper";
    private String[] b;

    private CookieManagerWrapper() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x00dc  */
    public void clearCookies() {
        String[] strArr;
        Object obj;
        SDKLogger.e("clearCookies", "into clearCookies ");
        CookieSyncManager.createInstance(KernelContext.getApplicationContext());
        SDKLogger.e("clearCookies", "into clearCookies removeSessionCookie finish");
        if (this.b == null) {
            String readFileData = FileUtils.readFileData(KernelContext.getApplicationContext(), "cookies");
            if (!TextUtils.isEmpty(readFileData)) {
                SDKLogger.d(a, "get cookie from storage:" + readFileData);
                this.b = TextUtils.split(readFileData, "\u0005");
            }
        }
        SDKLogger.e("clearCookies", "into clearCookies readFileData finish");
        if (this.b != null) {
            ArrayList<c> arrayList = new ArrayList();
            String[] strArr2 = this.b;
            for (String str : strArr2) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        c parseCookie = LoginCookieUtils.parseCookie(str);
                        if (!"munb".equals(parseCookie.c)) {
                            String httpDomin = LoginCookieUtils.getHttpDomin(parseCookie);
                            LoginCookieUtils.expiresCookies(parseCookie);
                            a.a().setCookie(httpDomin, parseCookie.toString());
                            if (TextUtils.equals(parseCookie.a, ".taobao.com")) {
                                arrayList.add(parseCookie);
                            }
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
            try {
                if (!(CredentialManager.INSTANCE.getInternalSession().otherInfo == null || (obj = CredentialManager.INSTANCE.getInternalSession().otherInfo.get("ssoDomainList")) == null || !(obj instanceof ArrayList))) {
                    strArr = (String[]) ((ArrayList) obj).toArray(new String[0]);
                    if (strArr != null && strArr.length > 0 && !arrayList.isEmpty()) {
                        for (c cVar : arrayList) {
                            String str2 = cVar.a;
                            for (String str3 : strArr) {
                                if (!"munb".equals(cVar.c)) {
                                    cVar.a = str3;
                                    String httpDomin2 = LoginCookieUtils.getHttpDomin(cVar);
                                    LoginCookieUtils.expiresCookies(cVar);
                                    a.a().setCookie(httpDomin2, cVar.toString());
                                }
                            }
                            cVar.a = str2;
                        }
                    }
                    SDKLogger.d(a, "injectCookie cookies is null");
                    this.b = null;
                    FileUtils.writeFileData(KernelContext.getApplicationContext(), "cookies", "");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            strArr = null;
            while (r1.hasNext()) {
            }
            SDKLogger.d(a, "injectCookie cookies is null");
            this.b = null;
            FileUtils.writeFileData(KernelContext.getApplicationContext(), "cookies", "");
        }
        SDKLogger.e("clearCookies", "into clearCookies reset cookie finish");
        a.a().removeExpiredCookie();
        SDKLogger.e("clearCookies", "into clearCookies removeExpiredCookie finish");
        a.a().flush();
        SDKLogger.e("clearCookies", "into clearCookies  finish");
    }

    public synchronized void injectCookie(String[] strArr, String[] strArr2) {
        this.b = strArr;
        if (KernelContext.context != null) {
            if (strArr != null) {
                SDKLogger.d(a, "injectCookie cookies != null");
                ArrayList<c> arrayList = new ArrayList();
                for (String str : strArr) {
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            c parseCookie = LoginCookieUtils.parseCookie(str);
                            String httpDomin = LoginCookieUtils.getHttpDomin(parseCookie);
                            String cVar = parseCookie.toString();
                            SDKLogger.d(a, "add cookie: " + cVar);
                            a.a().setCookie(httpDomin, cVar);
                            if (TextUtils.equals(parseCookie.a, ".taobao.com")) {
                                arrayList.add(parseCookie);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }
                if (strArr2 != null && strArr2.length > 0 && !arrayList.isEmpty()) {
                    for (c cVar2 : arrayList) {
                        String str2 = cVar2.a;
                        for (String str3 : strArr2) {
                            cVar2.a = str3;
                            String httpDomin2 = LoginCookieUtils.getHttpDomin(cVar2);
                            String cVar3 = cVar2.toString();
                            SDKLogger.d(a, "add cookies to domain:" + str3 + ", cookie = " + cVar3);
                            a.a().setCookie(httpDomin2, cVar3);
                        }
                        cVar2.a = str2;
                    }
                }
                a.a().flush();
                if (this.b != null) {
                    FileUtils.writeFileData(KernelContext.context, "cookies", TextUtils.join("\u0005", strArr));
                }
            } else {
                clearCookies();
            }
        }
    }

    public synchronized void refreshCookie() {
        if (this.b == null) {
            try {
                String readFileData = FileUtils.readFileData(KernelContext.getApplicationContext(), "cookies");
                if (!TextUtils.isEmpty(readFileData)) {
                    String str = a;
                    SDKLogger.d(str, "get cookie from storage:" + readFileData);
                    this.b = TextUtils.split(readFileData, "\u0005");
                }
            } catch (Throwable unused) {
            }
        }
        String[] strArr = this.b;
        if (strArr != null) {
            injectCookie(strArr, null);
        }
    }
}
