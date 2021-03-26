package mtopsdk.mtop.intf;

import anetwork.network.cache.Cache;
import java.util.HashMap;
import java.util.Map;
import mtopsdk.common.config.MtopConfigListener;
import mtopsdk.common.log.LogAdapter;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.common.util.d;
import mtopsdk.mtop.antiattack.AntiAttackHandler;
import mtopsdk.mtop.common.a;
import mtopsdk.mtop.domain.EnvModeEnum;
import mtopsdk.mtop.features.MtopFeatureManager;
import mtopsdk.mtop.global.MtopConfig;
import mtopsdk.mtop.global.SwitchConfig;
import mtopsdk.mtop.stat.IUploadStats;
import mtopsdk.mtop.util.MtopSDKThreadPoolExecutorFactory;
import mtopsdk.network.Call;
import mtopsdk.security.ISign;

public final class MtopSetting {
    protected static final Map<String, MtopConfig> a = new HashMap();

    @Deprecated
    public static void setSecurityAppKey(String str) {
    }

    private MtopSetting() {
    }

    static MtopConfig a(String str) {
        MtopConfig mtopConfig;
        if (!StringUtils.isNotBlank(str)) {
            str = "INNER";
        }
        Mtop mtop = Mtop.a.get(str);
        if (mtop == null) {
            synchronized (Mtop.class) {
                mtop = Mtop.a.get(str);
                if (mtop == null) {
                    Map<String, MtopConfig> map = a;
                    MtopConfig mtopConfig2 = map.get(str);
                    if (mtopConfig2 == null) {
                        synchronized (MtopSetting.class) {
                            mtopConfig = map.get(str);
                            if (mtopConfig == null) {
                                mtopConfig = new MtopConfig(str);
                                map.put(str, mtopConfig);
                            }
                        }
                        mtopConfig2 = mtopConfig;
                    }
                    return mtopConfig2;
                }
            }
        }
        return mtop.getMtopConfig();
    }

    public static void setAppKeyIndex(String str, int i, int i2) {
        MtopConfig a2 = a(str);
        a2.onlineAppKeyIndex = i;
        a2.dailyAppkeyIndex = i2;
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i("mtopsdk.MtopSetting", a2.instanceId + " [setAppKeyIndex] onlineAppKeyIndex=" + i + ",dailyAppkeyIndex=" + i2);
        }
    }

    @Deprecated
    public static void setAppKeyIndex(int i, int i2) {
        setAppKeyIndex(null, i, i2);
    }

    public static void setAuthCode(String str, String str2) {
        MtopConfig a2 = a(str);
        a2.authCode = str2;
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i("mtopsdk.MtopSetting", a2.instanceId + " [setAuthCode] authCode=" + str2);
        }
    }

    @Deprecated
    public static void setAuthCode(String str) {
        setAuthCode(null, str);
    }

    public static void setWuaAuthCode(String str, String str2) {
        MtopConfig a2 = a(str);
        a2.wuaAuthCode = str2;
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i("mtopsdk.MtopSetting", a2.instanceId + " [setWuaAuthCode] wuaAuthCode=" + str2);
        }
    }

    public static void setAppVersion(String str, String str2) {
        MtopConfig a2 = a(str);
        a2.appVersion = str2;
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i("mtopsdk.MtopSetting", a2.instanceId + " [setAppVersion] appVersion=" + str2);
        }
    }

    public static void setAppKey(String str, String str2) {
        MtopConfig a2 = a(str);
        a2.appKey = str2;
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i("mtopsdk.MtopSetting", a2.instanceId + " [setAppKey] appKey=" + str2);
        }
    }

    @Deprecated
    public static void setAppVersion(String str) {
        setAppVersion(null, str);
    }

    public static void setMtopDomain(String str, String str2, String str3, String str4) {
        MtopConfig a2 = a(str);
        if (StringUtils.isNotBlank(str2)) {
            a2.mtopDomain.updateDomain(EnvModeEnum.ONLINE, str2);
        }
        if (StringUtils.isNotBlank(str3)) {
            a2.mtopDomain.updateDomain(EnvModeEnum.PREPARE, str3);
        }
        if (StringUtils.isNotBlank(str4)) {
            a2.mtopDomain.updateDomain(EnvModeEnum.TEST, str4);
        }
    }

    @Deprecated
    public static void setMtopDomain(String str, String str2, String str3) {
        setMtopDomain(null, str, str2, str3);
    }

    @Deprecated
    public static void setMtopFeatureFlag(MtopFeatureManager.MtopFeatureEnum mtopFeatureEnum, boolean z) {
        setMtopFeatureFlag(null, MtopFeatureManager.getMtopFeatureByFeatureEnum(mtopFeatureEnum), z);
    }

    public static void setMtopFeatureFlag(String str, int i, boolean z) {
        if (i > 0) {
            MtopConfig a2 = a(str);
            if (z) {
                a2.mtopFeatures.add(Integer.valueOf(i));
            } else {
                a2.mtopFeatures.remove(Integer.valueOf(i));
            }
        }
    }

    public static void setAntiAttackHandler(String str, AntiAttackHandler antiAttackHandler) {
        MtopConfig a2 = a(str);
        a2.antiAttackHandler = antiAttackHandler;
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i("mtopsdk.MtopSetting", a2.instanceId + " [setAntiAttackHandler] set antiAttackHandler succeed.");
        }
    }

    @Deprecated
    public static void setXOrangeQ(String str) {
        setXOrangeQ(null, str);
    }

    public static void setXOrangeQ(String str, String str2) {
        if (StringUtils.isNotBlank(str2)) {
            MtopConfig a2 = a(str);
            a2.xOrangeQ = str2;
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i("mtopsdk.MtopSetting", a2.instanceId + " [setXOrangeQ] set xOrangeQ succeed.xOrangeQ=" + str2);
            }
        }
    }

    public static void setMtopConfigListener(MtopConfigListener mtopConfigListener) {
        SwitchConfig.getInstance().setMtopConfigListener(mtopConfigListener);
        d.a(mtopConfigListener);
        TBSdkLog.i("mtopsdk.MtopSetting", "[setMtopConfigListener] set MtopConfigListener succeed.");
        MtopSDKThreadPoolExecutorFactory.submit(new h(mtopConfigListener));
    }

    public static void setLogAdapterImpl(LogAdapter logAdapter) {
        if (logAdapter != null) {
            MtopConfig.logAdapterImpl = logAdapter;
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i("mtopsdk.MtopSetting", "[setLogAdapterImpl] set logAdapter succeed.logAdapterImpl=" + logAdapter);
            }
        }
    }

    @Deprecated
    public static void setCacheImpl(Cache cache) {
        setCacheImpl(null, cache);
    }

    public static void setCacheImpl(String str, Cache cache) {
        if (cache != null) {
            MtopConfig a2 = a(str);
            a2.cacheImpl = cache;
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i("mtopsdk.MtopSetting", a2.instanceId + " [setCacheImpl] set CacheImpl succeed.cacheImpl=" + cache);
            }
        }
    }

    public static void setISignImpl(String str, ISign iSign) {
        MtopConfig a2 = a(str);
        a2.sign = iSign;
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i("mtopsdk.MtopSetting", a2.instanceId + "[setISignImpl] set ISign succeed.signImpl=" + iSign);
        }
    }

    public static void setUploadStats(String str, IUploadStats iUploadStats) {
        MtopConfig a2 = a(str);
        a2.uploadStats = iUploadStats;
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i("mtopsdk.MtopSetting", a2.instanceId + "[setUploadStats] set IUploadStats succeed.uploadStats=" + iUploadStats);
        }
    }

    public static void setCallFactoryImpl(String str, Call.Factory factory) {
        if (factory != null) {
            MtopConfig a2 = a(str);
            a2.callFactory = factory;
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i("mtopsdk.MtopSetting", a2.instanceId + "[setCallFactoryImpl] set CallFactoryImpl succeed.callFactory=" + factory);
            }
        }
    }

    public static void setEnableProperty(String str, String str2, boolean z) {
        if (str2 != null) {
            MtopConfig a2 = a(str);
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i("mtopsdk.MtopSetting", a2.instanceId + "[setEnableProperty] set enableProperty succeed.property=" + str2 + ",enable=" + z);
            }
            str2.hashCode();
            char c = 65535;
            switch (str2.hashCode()) {
                case -514993282:
                    if (str2.equals("ENABLE_NOTIFY_SESSION_RET")) {
                        c = 0;
                        break;
                    }
                    break;
                case -309052356:
                    if (str2.equals("ENABLE_HEADER_URL_ENCODE")) {
                        c = 1;
                        break;
                    }
                    break;
                case 1971193321:
                    if (str2.equals("ENABLE_NEW_DEVICE_ID")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    a2.notifySessionResult = z;
                    return;
                case 1:
                    a2.enableHeaderUrlEncode = z;
                    return;
                case 2:
                    a2.enableNewDeviceId = z;
                    return;
                default:
                    return;
            }
        }
    }

    public static void setParam(String str, String str2, String str3, String str4) {
        if (str2 != null && str3 != null && str4 != null) {
            MtopConfig a2 = a(str);
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i("mtopsdk.MtopSetting", a2.instanceId + "[setParam] set Param succeed.mtopParamType=" + str2 + ",key=" + str3 + ",value=" + str4);
            }
            str2.hashCode();
            char c = 65535;
            switch (str2.hashCode()) {
                case 77406376:
                    if (str2.equals("QUERY")) {
                        c = 0;
                        break;
                    }
                    break;
                case 1924418611:
                    if (str2.equals("ABTEST")) {
                        c = 1;
                        break;
                    }
                    break;
                case 2127025805:
                    if (str2.equals("HEADER")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    a2.mtopGlobalQuerys.put(str3, str4);
                    return;
                case 1:
                    a2.mtopGlobalABTestParams.put(str3, str4);
                    return;
                case 2:
                    a2.mtopGlobalHeaders.put(str3, str4);
                    return;
                default:
                    return;
            }
        }
    }

    public static void removeParam(String str, String str2, String str3) {
        if (str2 != null && str3 != null) {
            MtopConfig a2 = a(str);
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i("mtopsdk.MtopSetting", a2.instanceId + "[removeParam] remove Param succeed.mtopParamType=" + str2 + ",key=" + str3);
            }
            str2.hashCode();
            char c = 65535;
            switch (str2.hashCode()) {
                case 77406376:
                    if (str2.equals("QUERY")) {
                        c = 0;
                        break;
                    }
                    break;
                case 1924418611:
                    if (str2.equals("ABTEST")) {
                        c = 1;
                        break;
                    }
                    break;
                case 2127025805:
                    if (str2.equals("HEADER")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    a2.mtopGlobalQuerys.remove(str3);
                    return;
                case 1:
                    a2.mtopGlobalABTestParams.remove(str3);
                    return;
                case 2:
                    a2.mtopGlobalHeaders.remove(str3);
                    return;
                default:
                    return;
            }
        }
    }

    public static void addMtopStatisListener(String str, a aVar) {
        MtopConfig a2 = a(str);
        a2.mtopStatsListener = aVar;
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i("mtopsdk.MtopSetting", a2.instanceId + " [addMtopStatisListener] set MtopStatsListener succeed.");
        }
    }

    public static void setRouterId(String str, String str2) {
        if (!StringUtils.isEmpty(str2)) {
            MtopConfig a2 = a(str);
            a2.routerId = str2;
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i("mtopsdk.MtopSetting", a2.instanceId + "[setRouterId] set routerId succeed.routerId=" + str2);
            }
        }
    }

    public static void setPlaceId(String str, String str2) {
        if (!StringUtils.isEmpty(str2)) {
            MtopConfig a2 = a(str);
            a2.placeId = str2;
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i("mtopsdk.MtopSetting", a2.instanceId + "[setPlaceId] set placeId succeed.placeId=" + str2);
            }
        }
    }
}
