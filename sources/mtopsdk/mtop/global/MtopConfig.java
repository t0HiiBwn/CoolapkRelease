package mtopsdk.mtop.global;

import android.content.Context;
import anetwork.network.cache.Cache;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import mtopsdk.a.b.a;
import mtopsdk.common.log.LogAdapter;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.antiattack.AntiAttackHandler;
import mtopsdk.mtop.domain.EntranceEnum;
import mtopsdk.mtop.domain.EnvModeEnum;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.mtop.network.NetworkPropertyService;
import mtopsdk.mtop.stat.IUploadStats;
import mtopsdk.network.Call;
import mtopsdk.security.ISign;

public class MtopConfig {
    public static LogAdapter logAdapterImpl;
    private Map<String, String> a = new ConcurrentHashMap();
    public AntiAttackHandler antiAttackHandler;
    public String appKey;
    public int appKeyIndex;
    public String appVersion;
    public String authCode;
    private AtomicBoolean b = new AtomicBoolean(false);
    public Cache cacheImpl;
    public Call.Factory callFactory = null;
    public Context context;
    public int dailyAppkeyIndex = 0;
    public String deviceId;
    public volatile boolean enableHeaderUrlEncode = false;
    public volatile boolean enableNewDeviceId = true;
    public EntranceEnum entrance = EntranceEnum.GW_INNER;
    public EnvModeEnum envMode = EnvModeEnum.ONLINE;
    public a filterManager = null;
    public final String instanceId;
    public AtomicBoolean isAllowSwitchEnv = new AtomicBoolean(true);
    public final byte[] lock = new byte[0];
    public final MtopDomain mtopDomain = new MtopDomain();
    public final Set<Integer> mtopFeatures = new CopyOnWriteArraySet();
    public final Map<String, String> mtopGlobalABTestParams = new ConcurrentHashMap();
    public final Map<String, String> mtopGlobalHeaders = new ConcurrentHashMap();
    public final Map<String, String> mtopGlobalQuerys = new ConcurrentHashMap();
    public Mtop mtopInstance;
    public mtopsdk.mtop.common.a mtopStatsListener;
    public NetworkPropertyService networkPropertyService;
    public volatile boolean notifySessionResult = false;
    public int onlineAppKeyIndex = 0;
    public String placeId;
    public int processId;
    public String routerId;
    public volatile ISign sign;
    public String ttid;
    public IUploadStats uploadStats;
    public String utdid;
    public String wuaAuthCode;
    public volatile long xAppConfigVersion;
    public String xOrangeQ;

    public MtopConfig(String str) {
        this.instanceId = str;
    }

    public static class MtopDomain {
        public static final int FOR_DAILY = 2;
        public static final int FOR_DAILY_2ND = 3;
        public static final int FOR_ONLINE = 0;
        public static final int FOR_PREPARED = 1;
        private String[] a;

        MtopDomain() {
            String[] strArr = new String[4];
            this.a = strArr;
            strArr[0] = "acs.m.taobao.com";
            strArr[1] = "acs.wapa.taobao.com";
            strArr[2] = "acs.waptest.taobao.com";
            strArr[3] = "api.waptest2nd.taobao.com";
        }

        public String getDomain(EnvModeEnum envModeEnum) {
            int i = a.a[envModeEnum.ordinal()];
            if (i == 1) {
                return this.a[0];
            }
            if (i == 2) {
                return this.a[1];
            }
            if (i == 3) {
                return this.a[2];
            }
            if (i != 4) {
                return this.a[0];
            }
            return this.a[3];
        }

        public void updateDomain(EnvModeEnum envModeEnum, String str) {
            int i = a.a[envModeEnum.ordinal()];
            if (i == 1) {
                this.a[0] = str;
            } else if (i == 2) {
                this.a[1] = str;
            } else if (i == 3) {
                this.a[2] = str;
            } else if (i == 4) {
                this.a[3] = str;
            }
        }
    }

    public void registerMtopSdkProperty(String str, String str2) {
        if (StringUtils.isNotBlank(str) && StringUtils.isNotBlank(str2)) {
            getMtopProperties().put(str, str2);
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.DebugEnable)) {
                TBSdkLog.d("mtopsdk.MtopConfig", "[registerMtopSdkProperty]register MtopSdk Property succeed,key=" + str + ",value=" + str2);
            }
        }
    }

    public Map<String, String> getMtopProperties() {
        if (this.b.compareAndSet(false, true)) {
            try {
                InputStream open = this.context.getAssets().open("mtopsdk.property");
                Properties properties = new Properties();
                properties.load(open);
                if (!properties.isEmpty()) {
                    for (Map.Entry entry : properties.entrySet()) {
                        try {
                            Object key = entry.getKey();
                            Object value = entry.getValue();
                            if (key == null || value == null) {
                                TBSdkLog.e("mtopsdk.MtopConfig", "invalid mtopsdk property,key=" + key + ",value=" + value);
                            } else {
                                this.a.put(key.toString(), value.toString());
                            }
                        } catch (Exception e) {
                            TBSdkLog.e("mtopsdk.MtopConfig", "load mtopsdk.property in android assets directory error.", e);
                        }
                    }
                }
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                    TBSdkLog.i("mtopsdk.MtopConfig", " load mtopsdk.property file in android assets directory succeed");
                }
            } catch (Exception unused) {
                TBSdkLog.e("mtopsdk.MtopConfig", "load mtopsdk.property in android assets directory failed!");
            }
        }
        return this.a;
    }
}
