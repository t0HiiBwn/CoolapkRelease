package mtopsdk.security;

import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.SecurityGuardParamContext;
import com.alibaba.wireless.security.open.middletier.IUnifiedSecurityComponent;
import com.alibaba.wireless.security.open.middletier.fc.IFCComponent;
import com.alibaba.wireless.security.open.securitybody.ISecurityBodyComponent;
import com.taobao.tao.remotebusiness.b;
import java.util.HashMap;
import java.util.Map;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.domain.EnvModeEnum;
import mtopsdk.mtop.global.MtopConfig;
import mtopsdk.security.ISign;

/* compiled from: OpenSignImpl */
public final class c extends a {
    private SecurityGuardManager b = null;
    private IUnifiedSecurityComponent c;

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00ac, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00ad, code lost:
        mtopsdk.common.util.TBSdkLog.e("mtopsdk.OpenSignImpl", c() + " [initMiddleTier]init middleTier failed with unknown exception, appKeyIndex=" + r11.appKeyIndex + ",authCode=" + r11.authCode, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00d3, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00d4, code lost:
        mtopsdk.common.util.TBSdkLog.e("mtopsdk.OpenSignImpl", c() + " [initMiddleTier]init middleTier failed with errorCode " + r5.getErrorCode() + ",appKeyIndex=" + r11.appKeyIndex + ",authCode=" + r11.authCode, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x012a, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x012b, code lost:
        mtopsdk.common.util.TBSdkLog.e("mtopsdk.OpenSignImpl", r2 + " [init]init securityguard error.", r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x013f, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x012a A[ExcHandler: all (r11v2 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:1:0x000b] */
    @Override // mtopsdk.security.a, mtopsdk.security.ISign
    public final void init(MtopConfig mtopConfig) {
        super.init(mtopConfig);
        String c2 = c();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            this.b = SecurityGuardManager.getInstance(this.a.context);
            if (mtopConfig != null) {
                long currentTimeMillis2 = System.currentTimeMillis();
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("authCode", b());
                if (this.c == null) {
                    IUnifiedSecurityComponent iUnifiedSecurityComponent = (IUnifiedSecurityComponent) SecurityGuardManager.getInstance(mtopConfig.context).getInterface(IUnifiedSecurityComponent.class);
                    this.c = iUnifiedSecurityComponent;
                    if (iUnifiedSecurityComponent != null) {
                        iUnifiedSecurityComponent.init(hashMap);
                    } else if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                        TBSdkLog.e("mtopsdk.OpenSignImpl", c() + " [initMiddleTier]init sign failed");
                    }
                }
                HashMap hashMap2 = new HashMap();
                boolean z = false;
                try {
                    Class.forName("com.ali.auth.third.core.MemberSDK");
                    z = true;
                } catch (Throwable unused) {
                }
                hashMap2.put("key_login_module", Boolean.valueOf(z));
                IFCComponent iFCComponent = (IFCComponent) SecurityGuardManager.getInstance(mtopConfig.context).getInterface(IFCComponent.class);
                if (iFCComponent != null) {
                    iFCComponent.setUp(mtopConfig.context, hashMap2);
                    mtopConfig.mtopGlobalHeaders.put("x-bx-version", iFCComponent.getFCPluginVersion());
                }
                TBSdkLog.e("mtopsdk.OpenSignImpl", "[initMiddleTier] execute initMiddleTier cost time ", String.valueOf(System.currentTimeMillis() - currentTimeMillis2));
            }
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i("mtopsdk.OpenSignImpl", c2 + " [init]ISign init succeed.init time=" + (System.currentTimeMillis() - currentTimeMillis));
            }
        } catch (SecException e) {
            TBSdkLog.e("mtopsdk.OpenSignImpl", c2 + " [init]init securityguard error.errorCode=" + e.getErrorCode(), e);
        } catch (Throwable th) {
        }
    }

    @Override // mtopsdk.security.ISign
    public final String getAppKey(ISign.a aVar) {
        String str = null;
        if (aVar == null) {
            return null;
        }
        String c2 = c();
        try {
            str = this.b.getStaticDataStoreComp().getAppKeyByIndex(aVar.a, aVar.b);
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i("mtopsdk.OpenSignImpl", c2 + " [getAppKey]ISign getAppKey.index=" + aVar.a + ",authCode=" + aVar.b + ",appKey=" + str);
            }
        } catch (SecException e) {
            TBSdkLog.e("mtopsdk.OpenSignImpl", c2 + " [getAppKey]ISign getAppKey error.errorCode=" + e.getErrorCode() + ",index=" + aVar.a + ",authCode=" + aVar.b, e);
        } catch (Exception e2) {
            TBSdkLog.e("mtopsdk.OpenSignImpl", c2 + " [getAppKey]ISign getAppKey error.index=" + aVar.a + ",authCode=" + aVar.b, e2);
        }
        return str;
    }

    @Override // mtopsdk.security.ISign
    public final String getMtopApiSign(HashMap<String, String> hashMap, String str, String str2) {
        String c2 = c();
        if (hashMap == null) {
            TBSdkLog.e("mtopsdk.OpenSignImpl", c2 + " [getMtopApiSign] params is null.appkey=" + str);
            return null;
        } else if (str == null) {
            hashMap.put("SG_ERROR_CODE", "AppKey is null");
            TBSdkLog.e("mtopsdk.OpenSignImpl", c2 + " [getMtopApiSign] AppKey is null.");
            return null;
        } else if (this.b == null) {
            hashMap.put("SG_ERROR_CODE", "SGManager is null");
            TBSdkLog.e("mtopsdk.OpenSignImpl", c2 + " [getMtopApiSign]SecurityGuardManager is null,please call ISign init()");
            return null;
        } else {
            try {
                SecurityGuardParamContext securityGuardParamContext = new SecurityGuardParamContext();
                securityGuardParamContext.appKey = str;
                securityGuardParamContext.requestType = 7;
                Map<String, String> a = a(hashMap, str);
                a.put("ATLAS", "a");
                securityGuardParamContext.paramMap = a;
                return this.b.getSecureSignatureComp().signRequest(securityGuardParamContext, b());
            } catch (SecException e) {
                int errorCode = e.getErrorCode();
                hashMap.put("SG_ERROR_CODE", String.valueOf(errorCode));
                TBSdkLog.e("mtopsdk.OpenSignImpl", c2 + " [getMtopApiSign] ISecureSignatureComponent signRequest error,errorCode=" + errorCode, e);
                return null;
            } catch (Throwable th) {
                TBSdkLog.e("mtopsdk.OpenSignImpl", c2 + " [getMtopApiSign] ISecureSignatureComponent signRequest error", th);
                return null;
            }
        }
    }

    private static Map<String, String> a(Map<String, String> map, String str) {
        if (map == null || map.size() <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder(64);
        sb.append(map.get("api"));
        sb.append("&");
        sb.append(map.get("v"));
        sb.append("&");
        sb.append(b.c(map.get("data")));
        sb.append("&");
        sb.append(str);
        sb.append("&");
        sb.append(b.b(map.get("accessToken")));
        sb.append("&");
        sb.append(map.get("t"));
        sb.append("&");
        sb.append(b.b(map.get("utdid")));
        sb.append("&");
        sb.append(b.b(map.get("pv")));
        sb.append("&");
        sb.append(b.b(map.get("x-features")));
        sb.append("&");
        sb.append(b.b(map.get("ttid")));
        sb.append("&");
        sb.append(b.b(map.get("sid")));
        sb.append("&");
        sb.append(b.b(map.get("wua")));
        sb.append("&");
        sb.append(b.b(map.get("open-biz")));
        sb.append("&");
        sb.append(b.b(map.get("mini-appkey")));
        sb.append("&");
        sb.append(b.b(map.get("req-appkey")));
        sb.append("&");
        sb.append(b.b(map.get("open-biz-data")));
        HashMap hashMap = new HashMap(2);
        hashMap.put("INPUT", sb.toString());
        return hashMap;
    }

    @Override // mtopsdk.security.ISign
    public final String getCommonHmacSha1Sign(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        String c2 = c();
        if (this.b == null) {
            TBSdkLog.e("mtopsdk.OpenSignImpl", c2 + " [getCommonHmacSha1Sign]SecurityGuardManager is null,please call ISign init()");
            return null;
        }
        try {
            HashMap hashMap = new HashMap(1);
            hashMap.put("INPUT", str);
            SecurityGuardParamContext securityGuardParamContext = new SecurityGuardParamContext();
            securityGuardParamContext.appKey = str2;
            securityGuardParamContext.requestType = 3;
            securityGuardParamContext.paramMap = hashMap;
            return this.b.getSecureSignatureComp().signRequest(securityGuardParamContext, b());
        } catch (Throwable th) {
            TBSdkLog.e("mtopsdk.OpenSignImpl", c2 + " [getCommonHmacSha1Sign] ISecureSignatureComponent signRequest error", th);
            return null;
        }
    }

    @Override // mtopsdk.security.a, mtopsdk.security.ISign
    public final String getSecBodyDataEx(String str, String str2, String str3, HashMap<String, String> hashMap, int i) {
        if (StringUtils.isBlank(str2) || StringUtils.isBlank(str)) {
            return null;
        }
        try {
            return ((ISecurityBodyComponent) this.b.getInterface(ISecurityBodyComponent.class)).getSecurityBodyDataEx(str, str2, str3, null, i, a());
        } catch (Throwable th) {
            TBSdkLog.e("mtopsdk.OpenSignImpl", c() + "[getSecBodyDataEx] ISecurityBodyComponent getSecurityBodyDataEx  error,flag=" + i, th);
            return null;
        }
    }

    @Override // mtopsdk.security.a, mtopsdk.security.ISign
    public final HashMap<String, String> getUnifiedSign(HashMap<String, String> hashMap, HashMap<String, String> hashMap2, String str, String str2, boolean z) {
        String c2 = c();
        if (str == null) {
            hashMap.put("SG_ERROR_CODE", "AppKey is null");
            TBSdkLog.e("mtopsdk.OpenSignImpl", c2 + " [getUnifiedSign] AppKey is null.");
            return null;
        } else if (hashMap == null) {
            TBSdkLog.e("mtopsdk.OpenSignImpl", c2 + " [getUnifiedSign] params is null.appKey=" + str);
            return null;
        } else if (this.c == null) {
            hashMap.put("SG_ERROR_CODE", "unified is null");
            TBSdkLog.e("mtopsdk.OpenSignImpl", c2 + " [getUnifiedSign]sg unified sign is null, please call ISign init()");
            return null;
        } else {
            try {
                HashMap<String, Object> hashMap3 = new HashMap<>();
                String str3 = a(hashMap, str).get("INPUT");
                if (StringUtils.isBlank(str3)) {
                    TBSdkLog.e("mtopsdk.OpenSignImpl", c() + " [getUnifiedSign]get sign failed with sign data empty ", "appKeyIndex=" + this.a.appKeyIndex + ",authCode=" + this.a.authCode);
                    return null;
                }
                hashMap3.put("appkey", str);
                hashMap3.put("data", str3);
                hashMap3.put("useWua", Boolean.valueOf(z));
                int i = 0;
                if (a() == EnvModeEnum.PREPARE.getEnvMode()) {
                    i = 1;
                } else if (a() == EnvModeEnum.TEST.getEnvMode() || a() == EnvModeEnum.TEST_SANDBOX.getEnvMode()) {
                    i = 2;
                }
                hashMap3.put("env", Integer.valueOf(i));
                hashMap3.put("authCode", str2);
                hashMap3.put("extendParas", hashMap2);
                hashMap3.put("api", hashMap.get("api"));
                HashMap<String, String> securityFactors = this.c.getSecurityFactors(hashMap3);
                if (securityFactors != null && !securityFactors.isEmpty()) {
                    return securityFactors;
                }
                TBSdkLog.e("mtopsdk.OpenSignImpl", c() + " [getUnifiedSign]get sign failed with no output ", "appKeyIndex=" + this.a.appKeyIndex + ",authCode=" + this.a.authCode);
                return null;
            } catch (SecException e) {
                TBSdkLog.e("mtopsdk.OpenSignImpl", c() + " [getUnifiedSign]get sign failed and SecException errorCode " + e.getErrorCode() + ",appKeyIndex=" + this.a.appKeyIndex + ",authCode=" + this.a.authCode, e);
                return null;
            } catch (Throwable th) {
                TBSdkLog.e("mtopsdk.OpenSignImpl", c() + " [getUnifiedSign]get sign failed exception ,appKeyIndex=" + this.a.appKeyIndex + ",authCode=" + this.a.authCode, th);
                return null;
            }
        }
    }
}
