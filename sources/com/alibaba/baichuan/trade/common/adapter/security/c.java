package com.alibaba.baichuan.trade.common.adapter.security;

import com.alibaba.baichuan.trade.common.AlibcTradeCommon;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.dynamicdataencrypt.IDynamicDataEncryptComponent;
import com.alibaba.wireless.security.open.opensdk.IOpenSDKComponent;

public class c extends a {
    private static final String c = "c";
    private SecurityGuardManager a;
    private String b;

    private Long a(String str, byte[] bArr) {
        IOpenSDKComponent openSDKComp;
        SecurityGuardManager securityGuardManager = this.a;
        if (securityGuardManager == null || (openSDKComp = securityGuardManager.getOpenSDKComp()) == null) {
            return null;
        }
        try {
            return openSDKComp.analyzeOpenId(str, "AppIDKey", "OpenIDSaltKey", bArr, null);
        } catch (SecException e) {
            AlibcLogger.e(c, "analyzeOpenId ", e);
            return null;
        }
    }

    @Override // com.alibaba.baichuan.trade.common.adapter.security.a
    public String a(String str) {
        IDynamicDataEncryptComponent dynamicDataEncryptComp;
        SecurityGuardManager securityGuardManager = this.a;
        if (securityGuardManager == null || (dynamicDataEncryptComp = securityGuardManager.getDynamicDataEncryptComp()) == null) {
            return str;
        }
        try {
            return dynamicDataEncryptComp.dynamicEncrypt(str);
        } catch (SecException e) {
            AlibcLogger.e(c, "dynamicEncrypt", e);
            return str;
        }
    }

    @Override // com.alibaba.baichuan.trade.common.adapter.security.a
    public synchronized boolean a() {
        String str = c;
        AlibcLogger.d(str, "security init satrt");
        try {
            int initialize = SecurityGuardManager.getInitializer().initialize(AlibcTradeCommon.context);
            SecurityGuardManager instance = SecurityGuardManager.getInstance(AlibcTradeCommon.context);
            this.a = instance;
            String appKeyByIndex = instance.getStaticDataStoreComp().getAppKeyByIndex(0, "baichuan");
            this.b = appKeyByIndex;
            if (initialize != 0 || appKeyByIndex == null) {
                AlibcLogger.e(str, "SecurityGuard init = fail /n security init end");
                return false;
            }
            AlibcLogger.e(str, "SecurityGuard init = success /n security init end");
            return true;
        } catch (SecException e) {
            AlibcLogger.e(c, "AlibcSecurity init ", e);
            return false;
        }
    }

    @Override // com.alibaba.baichuan.trade.common.adapter.security.a
    public String b() {
        return this.b;
    }

    @Override // com.alibaba.baichuan.trade.common.adapter.security.a
    public String b(String str) {
        IDynamicDataEncryptComponent dynamicDataEncryptComp;
        SecurityGuardManager securityGuardManager = this.a;
        if (securityGuardManager == null || (dynamicDataEncryptComp = securityGuardManager.getDynamicDataEncryptComp()) == null) {
            return str;
        }
        try {
            return dynamicDataEncryptComp.dynamicDecrypt(str);
        } catch (SecException e) {
            AlibcLogger.e(c, "dynamicDecrypt ", e);
            return str;
        }
    }

    @Override // com.alibaba.baichuan.trade.common.adapter.security.a
    public Long c(String str) {
        return a(str, IOpenSDKComponent.OPEN_BIZ_IID);
    }
}
