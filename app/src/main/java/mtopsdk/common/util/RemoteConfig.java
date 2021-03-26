package mtopsdk.common.util;

import android.content.Context;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.intf.Mtop;

public class RemoteConfig {
    public static final String TB_SPEED_TS_ENABLE = "tsEnable";
    public static final String TB_SPEED_U_LAND = "preUland";
    private static RemoteConfig a;
    private static Map<String, Integer> c;
    public long antiAttackWaitInterval = 20;
    public long apiLockInterval = 10;
    private Map<String, String> b = null;
    public long bizErrorMappingCodeLength = 24;
    public String degradeApiCacheList = "";
    public String degradeBizErrorMappingApiList = "";
    public final Set<String> degradeBizcodeSets = new HashSet();
    public boolean degradeToSQLite = false;
    public boolean enableArupTlog = true;
    public boolean enableBizErrorCodeMapping = false;
    public boolean enableCache = true;
    public boolean enableErrorCodeMapping = true;
    public boolean enableNewExecutor = true;
    public boolean enableProperty = false;
    public boolean enableSpdy = true;
    public boolean enableSsl = true;
    @Deprecated
    public boolean enableUnit = true;
    public String errorMappingMsg = "";
    public String individualApiLockInterval = "";
    public boolean prefetch = false;
    public String removeCacheBlockList = "";
    public int segmentRetryTimes = -1;
    public int uploadThreadNums = -1;
    public final Set<String> useHttpsBizcodeSets = new HashSet();
    public int useSecurityAdapter = 2;

    public static RemoteConfig getInstance() {
        if (a == null) {
            synchronized (RemoteConfig.class) {
                if (a == null) {
                    a = new RemoteConfig();
                }
            }
        }
        return a;
    }

    static {
        HashMap hashMap = new HashMap();
        c = hashMap;
        hashMap.put("2G", 32768);
        c.put("3G", 65536);
        c.put("4G", 524288);
        c.put("WIFI", 524288);
        c.put("UNKONWN", 131072);
        c.put("NET_NO", 131072);
    }

    public Integer getSegmentSize(String str) {
        if (StringUtils.isBlank(str)) {
            return null;
        }
        return c.get(str);
    }

    public void setSegmentSize(String str, int i) {
        if (!StringUtils.isBlank(str) && i > 0) {
            c.put(str, Integer.valueOf(i));
        }
    }

    public void updateRemoteConfig() {
        this.b = d.a("mtopsdk_android_switch");
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i("mtopsdk.RemoteConfig", "[updateRemoteConfig] configItemsMap=" + this.b);
        }
        if (this.b != null) {
            String a2 = a("enableErrorCodeMapping", "true");
            this.enableErrorCodeMapping = "true".equals(a2);
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i("mtopsdk.RemoteConfig", "[setEnableErrorCodeMapping]remote enableErrorCodeMappingConfig=" + a2 + ",enableErrorCodeMapping=" + this.enableErrorCodeMapping);
            }
            String a3 = a("enableBizErrorCodeMapping", "false");
            this.enableBizErrorCodeMapping = "true".equals(a3);
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i("mtopsdk.RemoteConfig", "[setEnableBizErrorCodeMapping]remote enableBizErrorCodeMappingConfig=" + a3 + ",enableBizErrorCodeMapping=" + this.enableBizErrorCodeMapping);
            }
            String a4 = a("enableSpdy", "true");
            this.enableSpdy = "true".equals(a4);
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i("mtopsdk.RemoteConfig", "[setEnableSpdy]remote spdySwitchConfig=" + a4 + ",enableSpdy=" + this.enableSpdy);
            }
            String a5 = a("enableSsl", "true");
            this.enableSsl = "true".equals(a5);
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i("mtopsdk.RemoteConfig", "[setEnableSsl]remote spdySslSwitchConfig=" + a5 + ",enableSsl=" + this.enableSsl);
            }
            String a6 = a("enableCache", "true");
            this.enableCache = "true".equalsIgnoreCase(a6);
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i("mtopsdk.RemoteConfig", "[setEnableCache]remote cacheSwitchConfig=" + a6 + ",enableCache=" + this.enableCache);
            }
            String a7 = a("enableProperty", "false");
            this.enableProperty = !"false".equalsIgnoreCase(a7);
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i("mtopsdk.RemoteConfig", "[setEnableProperty]remote mtopsdkPropertySwitchConfig=" + a7 + ",enableProperty=" + this.enableProperty);
            }
            String a8 = a("degradeToSQLite", "false");
            this.degradeToSQLite = !"false".equalsIgnoreCase(a8);
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i("mtopsdk.RemoteConfig", "[setDegradeToSQLite]remote degradeToSQLiteConfig=" + a8 + ",degradeToSQLite=" + this.degradeToSQLite);
            }
            String a9 = a("enableNewExecutor", "true");
            this.enableNewExecutor = "true".equalsIgnoreCase(a9);
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i("mtopsdk.RemoteConfig", "[setEnableNewExecutor]remote enableNewExecutorConfig=" + a9 + ",enableNewExecutor=" + this.enableNewExecutor);
            }
            String a10 = a("apiLockInterval", null);
            if (StringUtils.isNotBlank(a10)) {
                try {
                    this.apiLockInterval = Long.parseLong(a10);
                } catch (Exception unused) {
                    TBSdkLog.e("mtopsdk.RemoteConfig", "[setApiLockInterval]parse apiLockIntervalConfig error,apiLockIntervalConfig=" + a10);
                }
            }
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i("mtopsdk.RemoteConfig", "[setApiLockInterval]remote apiLockIntervalConfig=" + a10 + ",apiLockInterval=" + this.apiLockInterval);
            }
            String a11 = a("openPrefetch", "false");
            this.prefetch = "true".equalsIgnoreCase(a11);
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i("mtopsdk.RemoteConfig", "[setPrefetch]remote openPrefetchConfig=" + a11 + ",prefetch=" + this.prefetch);
            }
            try {
                Mtop instance = Mtop.instance("INNER", (Context) null);
                if (instance.getMtopConfig().context != null) {
                    b.a();
                    b.a(instance.getMtopConfig().context, "MtopConfigStore", "", "openPrefetch", a11);
                } else {
                    TBSdkLog.e("mtopsdk.RemoteConfig", "[prefetch]context can't be null.wait INNER mtopInstance init.");
                }
            } catch (Exception unused2) {
                TBSdkLog.e("mtopsdk.RemoteConfig", "[prefetch]parse useSecAdapterConfig error,openPrefetchConfig=" + a11);
            }
            String a12 = a("antiAttackWaitInterval", null);
            if (StringUtils.isNotBlank(a12)) {
                try {
                    this.antiAttackWaitInterval = Long.parseLong(a12);
                } catch (Exception unused3) {
                    TBSdkLog.e("mtopsdk.RemoteConfig", "[setAntiAttackWaitInterval]parse antiAttackWaitIntervalConfig error,antiAttackWaitIntervalConfig=" + a12);
                }
            }
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i("mtopsdk.RemoteConfig", "[setAntiAttackWaitInterval]remote antiAttackWaitIntervalConfig=" + a12 + ",antiAttackWaitInterval=" + this.antiAttackWaitInterval);
            }
            String a13 = a("bizErrorMappingCodeLength", null);
            if (StringUtils.isNotBlank(a13)) {
                try {
                    this.bizErrorMappingCodeLength = Long.parseLong(a13);
                } catch (Exception unused4) {
                    TBSdkLog.e("mtopsdk.RemoteConfig", "[setBizErrorMappingCodeLength]parse bizErrorMappingCodeLengthConfig error,bizErrorMappingCodeLengthConfig=" + a13);
                }
            }
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i("mtopsdk.RemoteConfig", "[setBizErrorMappingCodeLength]remote bizErrorMappingCodeLengthConfig=" + a13 + ",bizErrorMappingCodeLength=" + this.bizErrorMappingCodeLength);
            }
            this.individualApiLockInterval = a("individualApiLockInterval", "");
            this.degradeApiCacheList = a("degradeApiCacheList", "");
            this.removeCacheBlockList = a("removeCacheBlockList", "");
            this.degradeBizErrorMappingApiList = a("degradeBizErrorMappingApiList", "");
            this.errorMappingMsg = a("errorMappingMsg", "");
            String a14 = a("useSecurityAdapter", "");
            if (StringUtils.isNotBlank(a14)) {
                try {
                    int parseInt = Integer.parseInt(a14);
                    if (parseInt != this.useSecurityAdapter) {
                        this.useSecurityAdapter = parseInt;
                        Mtop instance2 = Mtop.instance("INNER", (Context) null);
                        if (instance2.getMtopConfig().context != null) {
                            b.a();
                            b.a(instance2.getMtopConfig().context, "MtopConfigStore", "", "useSecurityAdapter", a14);
                        } else {
                            TBSdkLog.e("mtopsdk.RemoteConfig", "[useSecurityAdapter]context can't be null.wait INNER mtopInstance init.");
                        }
                    }
                } catch (Exception unused5) {
                    TBSdkLog.e("mtopsdk.RemoteConfig", "[useSecurityAdapter]parse useSecAdapterConfig error,useSecAdapterConfig=" + a14);
                }
            }
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i("mtopsdk.RemoteConfig", "[useSecurityAdapter]remote useSecurityAdapterSwitchConfig=" + a14 + ",useSecurityAdapter=" + this.useSecurityAdapter);
            }
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                StringBuilder sb = new StringBuilder(128);
                sb.append("[setOtherConfigItemKey] individualApiLockInterval =");
                sb.append(this.individualApiLockInterval);
                sb.append(", degradeApiCacheList =");
                sb.append(this.degradeApiCacheList);
                sb.append(", removeCacheBlockList =");
                sb.append(this.removeCacheBlockList);
                sb.append(", degradeBizErrorMappingApiList =");
                sb.append(this.degradeBizErrorMappingApiList);
                sb.append(", errorMappingMsg =");
                sb.append(this.errorMappingMsg);
                TBSdkLog.i("mtopsdk.RemoteConfig", sb.toString());
            }
        }
    }

    public void updateUploadRemoteConfig() {
        Map<String, String> a2 = d.a("mtopsdk_upload_switch");
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i("mtopsdk.RemoteConfig", "[updateUploadRemoteConfig] uploadConfigItemsMap=" + a2);
        }
        if (a2 != null) {
            String str = a2.get("segmentRetryTimes");
            if (StringUtils.isNotBlank(str)) {
                try {
                    int parseInt = Integer.parseInt(str);
                    if (parseInt >= 0) {
                        this.segmentRetryTimes = parseInt;
                    }
                } catch (Exception unused) {
                    TBSdkLog.w("mtopsdk.RemoteConfig", "[updateUploadRemoteConfig]parse segmentRetryTimes error,segmentRetryTimesStr=" + str);
                }
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                    TBSdkLog.i("mtopsdk.RemoteConfig", "[updateUploadRemoteConfig]remote segmentRetryTimesStr=" + str + ",segmentRetryTimes=" + this.segmentRetryTimes);
                }
            }
            String str2 = a2.get("uploadThreadNums");
            if (StringUtils.isNotBlank(str)) {
                try {
                    int parseInt2 = Integer.parseInt(str2);
                    if (parseInt2 >= 0) {
                        this.uploadThreadNums = parseInt2;
                    }
                } catch (Exception unused2) {
                    TBSdkLog.w("mtopsdk.RemoteConfig", "[updateUploadRemoteConfig]parse uploadThreadNums error,uploadThreadNumsStr=" + str2);
                }
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                    TBSdkLog.i("mtopsdk.RemoteConfig", "[updateUploadRemoteConfig]remote uploadThreadNumsStr=" + str2 + ",uploadThreadNums=" + this.uploadThreadNums);
                }
            }
        }
    }

    private String a(String str, String str2) {
        String str3 = null;
        try {
            Map<String, String> map = this.b;
            if (map != null) {
                str3 = map.get(str);
            }
        } catch (Exception e) {
            TBSdkLog.w("mtopsdk.RemoteConfig", "[getConfigItemByKey] get config item error; key=" + str, e);
        }
        return str3 == null ? str2 : str3;
    }

    public void loadLocalConfig(Context context) {
        String str = "";
        try {
            b.a();
            String a2 = b.a(context, "MtopConfigStore", str, "useSecurityAdapter");
            try {
                if (StringUtils.isNotBlank(a2)) {
                    this.useSecurityAdapter = Integer.parseInt(a2);
                    if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                        TBSdkLog.i("mtopsdk.RemoteConfig", "[loadLocalConfig]local useSecurityAdapterSwitchConfig=" + a2 + ",useSecurityAdapter=" + this.useSecurityAdapter);
                    }
                }
                b.a();
                String a3 = b.a(context, "MtopConfigStore", str, "openPrefetch");
                if (StringUtils.isNotBlank(a3)) {
                    this.prefetch = Boolean.parseBoolean(a3);
                    if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                        TBSdkLog.i("mtopsdk.RemoteConfig", "[loadLocalConfig]local openPrefetchStr=" + a3 + ",prefetch=" + this.prefetch);
                    }
                }
            } catch (Throwable unused) {
                str = a2;
                TBSdkLog.e("mtopsdk.RemoteConfig", "[loadLocalConfig]parse local useSecurityAdapter error, useSecAdapterStr=" + str);
            }
        } catch (Throwable unused2) {
            TBSdkLog.e("mtopsdk.RemoteConfig", "[loadLocalConfig]parse local useSecurityAdapter error, useSecAdapterStr=" + str);
        }
    }
}
