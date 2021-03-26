package mtopsdk.mtop.global;

import android.content.Context;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mtopsdk.common.config.MtopConfigListener;
import mtopsdk.common.util.RemoteConfig;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.common.util.c;

public class SwitchConfig {
    private static final SwitchConfig a = new SwitchConfig();
    public static final HashSet<String> authErrorCodeSet;
    private static final RemoteConfig b = RemoteConfig.getInstance();
    private static final c c = c.a();
    private static MtopConfigListener d = null;
    private static volatile Map<String, String> e = new ConcurrentHashMap(8);
    public static final Map<String, String> errorMappingMsgMap;
    public volatile Set<String> degradeApiCacheSet = null;
    public volatile Set<String> degradeBizErrorMappingApiSet = null;

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(8);
        errorMappingMsgMap = concurrentHashMap;
        HashSet<String> hashSet = new HashSet<>(8);
        authErrorCodeSet = hashSet;
        concurrentHashMap.put("NETWORK_ERROR_MAPPING", "网络竟然崩溃了");
        concurrentHashMap.put("FLOW_LIMIT_ERROR_MAPPING", "前方拥挤，亲稍等再试试");
        concurrentHashMap.put("SERVICE_ERROR_MAPPING", "服务竟然出错了");
        hashSet.add("FAIL_SYS_ACCESS_TOKEN_EXPIRED");
        hashSet.add("FAIL_SYS_ILLEGAL_ACCESS_TOKEN");
    }

    private SwitchConfig() {
    }

    public static SwitchConfig getInstance() {
        return a;
    }

    public void initConfig(Context context) {
        MtopConfigListener mtopConfigListener = d;
        if (mtopConfigListener != null) {
            mtopConfigListener.initConfig(context);
        }
    }

    public void setMtopConfigListener(MtopConfigListener mtopConfigListener) {
        d = mtopConfigListener;
    }

    public static MtopConfigListener getMtopConfigListener() {
        return d;
    }

    public boolean isGlobalErrorCodeMappingOpen() {
        return c.a && b.enableErrorCodeMapping;
    }

    public boolean isBizErrorCodeMappingOpen() {
        return c.b && b.enableBizErrorCodeMapping;
    }

    public boolean isGlobalSpdySwitchOpen() {
        return c.c && b.enableSpdy;
    }

    public SwitchConfig setGlobalSpdySwitchOpen(boolean z) {
        c.c = z;
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i("mtopsdk.SwitchConfig", "[setGlobalSpdySwitchOpen]set local spdySwitchOpen=" + z);
        }
        return this;
    }

    public boolean isGlobalSpdySslSwitchOpen() {
        return c.e && b.enableSsl;
    }

    public SwitchConfig setGlobalSpdySslSwitchOpen(boolean z) {
        c.e = z;
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i("mtopsdk.SwitchConfig", "[setGlobalSpdySslSwitchOpen]set local spdySslSwitchOpen=" + z);
        }
        return this;
    }

    public long getGlobalApiLockInterval() {
        return b.apiLockInterval;
    }

    public long getGlobalAttackAttackWaitInterval() {
        return b.antiAttackWaitInterval;
    }

    public long getGlobalBizErrorMappingCodeLength() {
        return b.bizErrorMappingCodeLength;
    }

    @Deprecated
    public boolean isGlobalUnitSwitchOpen() {
        return c.d && b.enableUnit;
    }

    public boolean isGlobalCacheSwitchOpen() {
        return b.enableCache;
    }

    @Deprecated
    public SwitchConfig setGlobalUnitSwitchOpen(boolean z) {
        c.d = z;
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i("mtopsdk.SwitchConfig", "[setGlobalUnitSwitchOpen]set local unitSwitchOpen=" + z);
        }
        return this;
    }

    public boolean isMtopsdkPropertySwitchOpen() {
        return c.f && b.enableProperty;
    }

    public SwitchConfig setMtopsdkPropertySwitchOpen(boolean z) {
        c.f = z;
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i("mtopsdk.SwitchConfig", "[setMtopsdkPropertySwitchOpen]set local mtopsdkPropertySwitchOpen=" + z);
        }
        return this;
    }

    public Map<String, String> getIndividualApiLockIntervalMap() {
        return e;
    }

    public long getIndividualApiLockInterval(String str) {
        if (StringUtils.isBlank(str)) {
            return 0;
        }
        String str2 = e.get(str);
        if (StringUtils.isBlank(str2)) {
            return 0;
        }
        try {
            return Long.parseLong(str2);
        } catch (Exception e2) {
            TBSdkLog.e("mtopsdk.SwitchConfig", "[getIndividualApiLockInterval]parse individual apiLock interval error.apiKey=" + str + " ---" + e2.toString());
            return 0;
        }
    }

    public int getUseSecurityAdapter() {
        return b.useSecurityAdapter;
    }
}
