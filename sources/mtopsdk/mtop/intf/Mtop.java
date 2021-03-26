package mtopsdk.mtop.intf;

import android.content.Context;
import anetwork.network.cache.Cache;
import com.taobao.tao.remotebusiness.b;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mtopsdk.common.util.MtopUtils;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.domain.EnvModeEnum;
import mtopsdk.mtop.domain.IMTOPDataObject;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.global.MtopConfig;
import mtopsdk.mtop.global.init.IMtopInitTask;
import mtopsdk.mtop.util.MtopSDKThreadPoolExecutorFactory;
import mtopsdk.xstate.XState;

public class Mtop {
    protected static final Map<String, Mtop> a = new ConcurrentHashMap();
    public static boolean mIsFullTrackValid;
    volatile String b;
    final MtopConfig c;
    final IMtopInitTask d;
    volatile boolean e = false;
    final byte[] f = new byte[0];
    private Map<String, MtopBuilder> g = new ConcurrentHashMap();
    private volatile boolean h = false;
    public volatile long lastPrefetchResponseTime = System.currentTimeMillis();

    public interface Id {
        public static final String INNER = "INNER";
        public static final String OPEN = "OPEN";
        public static final String PRODUCT = "PRODUCT";
    }

    private Mtop(String str, MtopConfig mtopConfig) {
        this.b = str;
        this.c = mtopConfig;
        IMtopInitTask a2 = b.a(str);
        this.d = a2;
        if (a2 != null) {
            try {
                Class.forName("com.taobao.analysis.fulltrace.FullTraceAnalysis");
                mIsFullTrackValid = true;
            } catch (Throwable unused) {
                mIsFullTrackValid = false;
            }
        } else {
            throw new RuntimeException("IMtopInitTask is null,instanceId=" + str);
        }
    }

    @Deprecated
    public static Mtop instance(Context context) {
        return instance(null, context, null);
    }

    @Deprecated
    public static Mtop instance(Context context, String str) {
        return instance(null, context, str);
    }

    public static Mtop instance(String str, Context context) {
        return instance(str, context, null);
    }

    public static Mtop instance(String str, Context context, String str2) {
        if (!StringUtils.isNotBlank(str)) {
            str = "INNER";
        }
        Map<String, Mtop> map = a;
        Mtop mtop = map.get(str);
        if (mtop == null) {
            synchronized (Mtop.class) {
                mtop = map.get(str);
                if (mtop == null) {
                    MtopConfig mtopConfig = MtopSetting.a.get(str);
                    if (mtopConfig == null) {
                        mtopConfig = new MtopConfig(str);
                    }
                    Mtop mtop2 = new Mtop(str, mtopConfig);
                    mtopConfig.mtopInstance = mtop2;
                    map.put(str, mtop2);
                    mtop = mtop2;
                }
            }
        }
        if (!mtop.h) {
            mtop.a(context, str2);
        }
        return mtop;
    }

    public static Mtop getMtopInstance(String str) {
        if (!StringUtils.isNotBlank(str)) {
            str = "INNER";
        }
        return a.get(str);
    }

    public String getInstanceId() {
        return this.b;
    }

    public MtopConfig getMtopConfig() {
        return this.c;
    }

    private synchronized void a(Context context, String str) {
        if (!this.h) {
            if (context == null) {
                TBSdkLog.e("mtopsdk.Mtop", this.b + " [init] The Parameter context can not be null.");
                return;
            }
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i("mtopsdk.Mtop", this.b + " [init] context=" + context + ", ttid=" + str);
            }
            this.c.context = context.getApplicationContext();
            if (StringUtils.isNotBlank(str)) {
                this.c.ttid = str;
            }
            MtopSDKThreadPoolExecutorFactory.submit(new a(this));
            this.h = true;
        }
    }

    public void unInit() {
        this.e = false;
        this.h = false;
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i("mtopsdk.Mtop", this.b + "[unInit] MTOPSDK unInit called");
        }
    }

    final void a() {
        EnvModeEnum envModeEnum = this.c.envMode;
        if (envModeEnum != null) {
            int i = d.a[envModeEnum.ordinal()];
            if (i == 1 || i == 2) {
                MtopConfig mtopConfig = this.c;
                mtopConfig.appKeyIndex = mtopConfig.onlineAppKeyIndex;
            } else if (i == 3 || i == 4) {
                MtopConfig mtopConfig2 = this.c;
                mtopConfig2.appKeyIndex = mtopConfig2.dailyAppkeyIndex;
            }
        }
    }

    public Mtop switchEnvMode(EnvModeEnum envModeEnum) {
        if (!(envModeEnum == null || this.c.envMode == envModeEnum)) {
            if (MtopUtils.isApkDebug(this.c.context) || this.c.isAllowSwitchEnv.compareAndSet(true, false)) {
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                    TBSdkLog.i("mtopsdk.Mtop", this.b + " [switchEnvMode]MtopSDK switchEnvMode called.envMode=" + envModeEnum);
                }
                MtopSDKThreadPoolExecutorFactory.submit(new c(this, envModeEnum));
            } else {
                TBSdkLog.e("mtopsdk.Mtop", this.b + " [switchEnvMode]release package can switch environment only once!");
                return this;
            }
        }
        return this;
    }

    public boolean checkMtopSDKInit() {
        if (this.e) {
            return this.e;
        }
        synchronized (this.f) {
            try {
                if (!this.e) {
                    this.f.wait(60000);
                    if (!this.e) {
                        TBSdkLog.e("mtopsdk.Mtop", this.b + " [checkMtopSDKInit]Didn't call Mtop.instance(...),please execute global init.");
                    }
                }
            } catch (Exception e2) {
                TBSdkLog.e("mtopsdk.Mtop", this.b + " [checkMtopSDKInit] wait Mtop initLock failed---" + e2.toString());
            }
        }
        return this.e;
    }

    public boolean isInited() {
        return this.e;
    }

    @Deprecated
    public Mtop registerSessionInfo(String str, @Deprecated String str2, String str3) {
        return registerMultiAccountSession(null, str, str3);
    }

    @Deprecated
    public static void setAppKeyIndex(int i, int i2) {
        MtopSetting.setAppKeyIndex(i, i2);
    }

    @Deprecated
    public static void setAppVersion(String str) {
        MtopSetting.setAppVersion(str);
    }

    @Deprecated
    public static void setSecurityAppKey(String str) {
        MtopSetting.setSecurityAppKey(str);
    }

    @Deprecated
    public static void setMtopDomain(String str, String str2, String str3) {
        MtopSetting.setMtopDomain(str, str2, str3);
    }

    public Mtop registerSessionInfo(String str, String str2) {
        return registerMultiAccountSession(null, str, str2);
    }

    public Mtop logout() {
        return logoutMultiAccountSession(null);
    }

    public Mtop registerMultiAccountSession(String str, String str2, String str3) {
        String str4 = this.b;
        if (StringUtils.isBlank(str)) {
            str = "DEFAULT";
        }
        String concatStr = StringUtils.concatStr(str4, str);
        XState.setValue(concatStr, "sid", str2);
        XState.setValue(concatStr, "uid", str3);
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            StringBuilder sb = new StringBuilder(64);
            sb.append(concatStr);
            sb.append(" [registerSessionInfo]register sessionInfo succeed: sid=");
            sb.append(str2);
            sb.append(",uid=");
            sb.append(str3);
            TBSdkLog.i("mtopsdk.Mtop", sb.toString());
        }
        if (this.c.networkPropertyService != null) {
            this.c.networkPropertyService.setUserId(str3);
        }
        return this;
    }

    public Mtop logoutMultiAccountSession(String str) {
        String str2 = this.b;
        if (StringUtils.isBlank(str)) {
            str = "DEFAULT";
        }
        String concatStr = StringUtils.concatStr(str2, str);
        XState.removeKey(concatStr, "sid");
        XState.removeKey(concatStr, "uid");
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            StringBuilder sb = new StringBuilder(32);
            sb.append(concatStr);
            sb.append(" [logout] remove sessionInfo succeed.");
            TBSdkLog.i("mtopsdk.Mtop", sb.toString());
        }
        if (this.c.networkPropertyService != null) {
            this.c.networkPropertyService.setUserId(null);
        }
        return this;
    }

    public Mtop registerTtid(String str) {
        if (str != null) {
            this.c.ttid = str;
            XState.setValue(this.b, "ttid", str);
            if (this.c.networkPropertyService != null) {
                this.c.networkPropertyService.setTtid(str);
            }
        }
        return this;
    }

    public Mtop registerUtdid(String str) {
        if (str != null) {
            this.c.utdid = str;
            XState.setValue("utdid", str);
        }
        return this;
    }

    public Mtop registerDeviceId(String str) {
        if (str != null) {
            this.c.deviceId = str;
            XState.setValue(this.b, "deviceId", str);
        }
        return this;
    }

    @Deprecated
    public String getSid() {
        return getMultiAccountSid(null);
    }

    public String getMultiAccountSid(String str) {
        String str2 = this.b;
        if (StringUtils.isBlank(str)) {
            str = "DEFAULT";
        }
        return XState.getValue(StringUtils.concatStr(str2, str), "sid");
    }

    @Deprecated
    public String getUserId() {
        return getMultiAccountUserId(null);
    }

    public String getMultiAccountUserId(String str) {
        String str2 = this.b;
        if (StringUtils.isBlank(str)) {
            str = "DEFAULT";
        }
        return XState.getValue(StringUtils.concatStr(str2, str), "uid");
    }

    public String getTtid() {
        return XState.getValue(this.b, "ttid");
    }

    public String getDeviceId() {
        return XState.getValue(this.b, "deviceId");
    }

    public String getUtdid() {
        return XState.getValue("utdid");
    }

    public Mtop setCoordinates(String str, String str2) {
        XState.setValue("lng", str);
        XState.setValue("lat", str2);
        return this;
    }

    public boolean removeCacheBlock(String str) {
        Cache cache = this.c.cacheImpl;
        return cache != null && cache.remove(str);
    }

    public boolean unintallCacheBlock(String str) {
        Cache cache = this.c.cacheImpl;
        return cache != null && cache.uninstall(str);
    }

    public boolean removeCacheItem(String str, String str2) {
        if (StringUtils.isBlank(str2)) {
            TBSdkLog.e("mtopsdk.Mtop", "[removeCacheItem] remove CacheItem failed,invalid cacheKey=" + str2);
            return false;
        }
        Cache cache = this.c.cacheImpl;
        if (cache == null || !cache.remove(str, str2)) {
            return false;
        }
        return true;
    }

    public Mtop logSwitch(boolean z) {
        TBSdkLog.setPrintLog(z);
        return this;
    }

    public MtopBuilder build(IMTOPDataObject iMTOPDataObject, String str) {
        return new MtopBuilder(this, iMTOPDataObject, str);
    }

    public MtopBuilder build(MtopRequest mtopRequest, String str) {
        return new MtopBuilder(this, mtopRequest, str);
    }

    @Deprecated
    public MtopBuilder build(Object obj, String str) {
        return new MtopBuilder(this, obj, str);
    }

    public Map<String, MtopBuilder> getPrefetchBuilderMap() {
        return this.g;
    }

    public void addPrefetchBuilderToMap(MtopBuilder mtopBuilder, String str) {
        if (this.g.size() >= 50) {
            f.a(mtopBuilder.b);
        }
        if (this.g.size() >= 50) {
            f.a("TYPE_FULL", mtopBuilder.getMtopPrefetch(), mtopBuilder.getMtopContext$6e9e401a(), null);
        }
        this.g.put(str, mtopBuilder);
    }
}
