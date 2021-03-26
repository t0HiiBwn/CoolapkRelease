package mtopsdk.mtop.util;

import android.text.TextUtils;
import anetwork.channel.statist.StatisticData;
import com.taobao.analysis.abtest.ABTestCenter;
import com.taobao.analysis.fulltrace.FullTraceAnalysis;
import com.taobao.analysis.fulltrace.RequestInfo;
import com.taobao.analysis.scene.SceneIdentifier;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;
import mtopsdk.common.util.MtopUtils;
import mtopsdk.common.util.RemoteConfig;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.common.MtopNetworkProp;
import mtopsdk.mtop.common.a;
import mtopsdk.mtop.global.SwitchConfig;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.mtop.stat.IUploadStats;
import mtopsdk.network.domain.NetworkStats;

public class MtopStatistics implements Cloneable {
    private static volatile AtomicBoolean d = new AtomicBoolean(false);
    private long a;
    public long allTime;
    public String apiKey;
    private String b;
    public boolean backGround;
    @Deprecated
    public int bizId;
    public String bizIdStr;
    public long bizReqProcessStart;
    public long bizReqStart;
    public long bizRspProcessStart;
    public long buildParams2NetworkTime;
    public long buildParamsEndTime;
    public long buildParamsStartTime;
    public long buildParamsTime;
    public int bxMainAction;
    public int bxRetry;
    public String bxSessionId;
    public long bxSleep;
    public long bxSubAction;
    public boolean bxUI;
    private RbStatisticData c;
    public long cacheCostTime;
    public int cacheHitType;
    public long cacheResponseParseEndTime;
    public long cacheResponseParseStartTime;
    public long cacheResponseParseTime;
    public long cacheReturnTime;
    public int cacheSwitch;
    public long callbackPocTime;
    public String clientTraceId;
    public boolean commitStat;
    public long computeMiniWuaTime;
    public long computeSignTime;
    public long computeWuaTime;
    public String domain;
    private IUploadStats e;
    public String eagleEyeTraceId;
    private a f;
    public long fcProcessCallbackTime;
    public long fcProcessCheckEndTime;
    public long fcProcessCheckStartTime;
    public long fcProcessStartTime;
    public String fullTraceId;
    public boolean handler;
    public int intSeqNo;
    public boolean isMain;
    public boolean isNoNetwork;
    public boolean isPrefetch;
    public boolean isReqMain;
    public boolean isReqSync;
    public String mappingCode;
    public long netSendEndTime;
    public long netSendStartTime;
    public NetworkStats netStats;
    public long netTotalTime;
    public String pageName;
    public String pageUrl;
    public int reqSource;
    public long requestPocTime;
    public String retCode;
    public int retType;
    public long rspCbDispatch;
    public long rspCbEnd;
    public long rspCbStart;
    public final String seqNo;
    public String serverTraceId;
    public long startCallBack2EndTime;
    public long startCallbackTime;
    public long startExecuteTime;
    public long startTime;
    public int statusCode;
    public long totalTime;
    public String url;
    public long waitCallbackTime;
    public long waitExecute2BuildParamTime;
    public long waitExecuteTime;

    public interface RetType {
        public static final int BIZ_ERROR = 3;
        public static final int NETWORK_ERROR = 1;
        public static final int SUCCESS = 0;
        public static final int SYSTEM_ERROR = 2;

        @Retention(RetentionPolicy.SOURCE)
        public @interface Definition {
        }
    }

    public MtopStatistics(IUploadStats iUploadStats, a aVar) {
        this.commitStat = true;
        this.cacheHitType = 0;
        this.retType = 0;
        this.b = "";
        this.apiKey = "";
        this.isMain = true;
        this.bxSessionId = "";
        this.bxUI = false;
        this.bxRetry = 0;
        this.bxSleep = -1;
        this.isPrefetch = false;
        this.e = iUploadStats;
        this.f = aVar;
        this.intSeqNo = MtopUtils.createIntSeqNo();
        this.seqNo = "MTOP" + this.intSeqNo;
    }

    public MtopStatistics(IUploadStats iUploadStats, a aVar, MtopNetworkProp mtopNetworkProp) {
        this(iUploadStats, aVar);
        if (mtopNetworkProp != null) {
            this.pageName = mtopNetworkProp.pageName;
            this.pageUrl = MtopUtils.convertUrl(mtopNetworkProp.pageUrl);
            this.backGround = mtopNetworkProp.backGround;
        }
    }

    public long currentTimeMillis() {
        return System.nanoTime() / 1000000;
    }

    public String launchInfoValue() {
        if (!Mtop.mIsFullTrackValid) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SceneIdentifier.getStartType());
        sb.append(",");
        sb.append(SceneIdentifier.isUrlLaunch() ? "1" : "0");
        sb.append(",");
        sb.append(this.bizReqStart);
        sb.append(",");
        sb.append(SceneIdentifier.getAppLaunchTime());
        sb.append(",");
        sb.append(SceneIdentifier.getDeviceLevel());
        return sb.toString();
    }

    public void onEndAndCommit() {
        long currentTimeMillis = currentTimeMillis();
        this.a = currentTimeMillis;
        long j = this.startTime;
        this.totalTime = currentTimeMillis - j;
        long j2 = this.startExecuteTime;
        long j3 = 0;
        this.waitExecuteTime = j2 > j ? j2 - j : 0;
        long j4 = this.cacheReturnTime;
        this.cacheCostTime = j4 > 0 ? j4 - j : 0;
        this.cacheResponseParseTime = this.cacheResponseParseEndTime - this.cacheResponseParseStartTime;
        if (this.netSendEndTime == 0) {
            this.netSendEndTime = currentTimeMillis();
        }
        long j5 = this.netSendEndTime;
        long j6 = this.netSendStartTime;
        this.netTotalTime = j5 - j6;
        long j7 = this.startCallbackTime;
        if (j7 > j5) {
            j3 = j7 - j5;
        }
        this.waitCallbackTime = j3;
        this.waitExecute2BuildParamTime = this.buildParamsStartTime - this.startExecuteTime;
        this.buildParams2NetworkTime = j6 - this.buildParamsEndTime;
        this.startCallBack2EndTime = this.a - j7;
        this.requestPocTime = j6 - this.startTime;
        StringBuilder sb = new StringBuilder(128);
        sb.append("apiKey=");
        sb.append(this.apiKey);
        sb.append(",httpResponseStatus=");
        sb.append(this.statusCode);
        sb.append(",retCode=");
        sb.append(this.retCode);
        sb.append(",retType=");
        sb.append(this.retType);
        sb.append(",reqSource=");
        sb.append(this.reqSource);
        sb.append(",mappingCode=");
        sb.append(this.mappingCode);
        sb.append(",isCbMain=");
        sb.append(this.isMain);
        sb.append(",isReqMain=");
        sb.append(this.isReqMain);
        sb.append(",isReqSync=");
        sb.append(this.isReqSync);
        sb.append(",mtopTotalTime=");
        sb.append(this.totalTime);
        sb.append(",waitExecuteTime=");
        sb.append(this.waitExecuteTime);
        sb.append(",waitExecute2BuildParamTime=");
        sb.append(this.waitExecute2BuildParamTime);
        sb.append(",buildParamsTime=");
        sb.append(this.buildParamsTime);
        sb.append(",buildParams2NetworkTime=");
        sb.append(this.buildParams2NetworkTime);
        sb.append(",networkTotalTime=");
        sb.append(this.netTotalTime);
        sb.append(",waitCallbackTime=");
        sb.append(this.waitCallbackTime);
        sb.append(",startCallBack2EndTime=");
        sb.append(this.startCallBack2EndTime);
        sb.append(",computeSignTime=");
        sb.append(this.computeSignTime);
        sb.append(",computeMiniWuaTime=");
        sb.append(this.computeMiniWuaTime);
        sb.append(",computeWuaTime=");
        sb.append(this.computeWuaTime);
        sb.append(",cacheSwitch=");
        sb.append(this.cacheSwitch);
        sb.append(",cacheHitType=");
        sb.append(this.cacheHitType);
        sb.append(",cacheCostTime=");
        sb.append(this.cacheCostTime);
        sb.append(",cacheResponseParseTime=");
        sb.append(this.cacheResponseParseTime);
        sb.append(",useSecurityAdapter=");
        sb.append(SwitchConfig.getInstance().getUseSecurityAdapter());
        sb.append(",isPrefetch=");
        sb.append(this.isPrefetch);
        if (this.netStats != null) {
            sb.append(",");
            if (StringUtils.isBlank(this.netStats.netStatSum)) {
                sb.append(this.netStats.sumNetStat());
            } else {
                sb.append(this.netStats.netStatSum);
            }
        }
        this.b = sb.toString();
        if (this.commitStat && !this.isNoNetwork) {
            if (MtopUtils.isMainThread()) {
                MtopSDKThreadPoolExecutorFactory.submit(new Runnable() {
                    /* class mtopsdk.mtop.util.MtopStatistics.AnonymousClass1 */

                    @Override // java.lang.Runnable
                    public void run() {
                        MtopStatistics.this.a();
                    }
                });
            } else {
                a();
            }
        }
        TBSdkLog.logTraceId(this.clientTraceId, this.serverTraceId);
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i("mtopsdk.MtopStatistics", this.seqNo, toString());
        }
    }

    public NetworkStats getNetworkStats() {
        return this.netStats;
    }

    @Deprecated
    public StatisticData getNetStat() {
        if (this.netStats == null) {
            return null;
        }
        StatisticData statisticData = new StatisticData();
        statisticData.isRequestSuccess = this.netStats.isRequestSuccess;
        statisticData.connectionType = this.netStats.connectionType;
        statisticData.oneWayTime_ANet = this.netStats.oneWayTime_ANet;
        statisticData.serverRT = this.netStats.serverRT;
        statisticData.totalSize = this.netStats.recvSize;
        return statisticData;
    }

    public long getTotalTime() {
        return this.totalTime;
    }

    public String getStatSum() {
        if (this.c == null) {
            return this.b;
        }
        if ("".equals(this.b)) {
            return this.c.getStatSum();
        }
        return this.b + "," + this.c.getStatSum();
    }

    public void commitStatData(boolean z) {
        this.commitStat = z;
        if (z && !this.isNoNetwork) {
            if (MtopUtils.isMainThread()) {
                MtopSDKThreadPoolExecutorFactory.submit(new Runnable() {
                    /* class mtopsdk.mtop.util.MtopStatistics.AnonymousClass2 */

                    @Override // java.lang.Runnable
                    public void run() {
                        MtopStatistics.this.a();
                    }
                });
            } else {
                a();
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x033d A[Catch:{ all -> 0x0731 }] */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x033f A[Catch:{ all -> 0x0731 }] */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x034d A[Catch:{ all -> 0x0731 }] */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x034f A[Catch:{ all -> 0x0731 }] */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0370 A[Catch:{ all -> 0x072f }] */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0372 A[Catch:{ all -> 0x072f }] */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0386 A[Catch:{ all -> 0x072f }] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0388 A[Catch:{ all -> 0x072f }] */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0398  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x03c4  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x03ce  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x044c  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x051a  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x0574  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x05ca  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x05d7  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x0695  */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x0698  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x0726  */
    public void a() {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        Object obj7;
        Object obj8;
        MtopStatistics mtopStatistics;
        String str;
        String str2;
        Throwable th;
        HashMap hashMap;
        NetworkStats networkStats;
        Object obj9;
        String str3;
        Object obj10;
        Object obj11;
        Object obj12;
        RbStatisticData rbStatisticData;
        IUploadStats iUploadStats;
        IUploadStats iUploadStats2;
        Object obj13;
        Throwable th2;
        Throwable th3;
        HashSet hashSet;
        Object obj14;
        HashSet hashSet2;
        String str4;
        if (this.e != null) {
            obj = "processTime";
            obj2 = "isPrefetch";
            obj3 = "isMain";
            if (d.compareAndSet(false, true)) {
                try {
                    if (this.e == null) {
                        try {
                            TBSdkLog.e("mtopsdk.MtopStatistics", this.seqNo, "[registerMtopStats]register MtopStats error, uploadStats=null");
                            obj5 = "pageUrl";
                            obj4 = "securityFeature";
                            obj6 = "backGround";
                            obj7 = "cacheHitType";
                            obj8 = "cacheSwitch";
                            str = "mtopsdk.MtopStatistics";
                            mtopStatistics = this;
                        } catch (Throwable th4) {
                            th2 = th4;
                            obj4 = "securityFeature";
                            obj13 = "backGround";
                            obj7 = "cacheHitType";
                            obj8 = "cacheSwitch";
                            str = "mtopsdk.MtopStatistics";
                            mtopStatistics = this;
                            String str5 = mtopStatistics.seqNo;
                            obj6 = obj13;
                            obj5 = "pageUrl";
                            TBSdkLog.e(str, str5, "[registerMtopStats] register MtopStats error ---" + th2.toString());
                            hashMap = new HashMap();
                            hashMap.put("api", mtopStatistics.apiKey);
                            hashMap.put("ret", mtopStatistics.retCode);
                            hashMap.put("retType", String.valueOf(mtopStatistics.retType));
                            hashMap.put("httpResponseStatus", String.valueOf(mtopStatistics.statusCode));
                            hashMap.put("domain", mtopStatistics.domain);
                            hashMap.put("reqSource", String.valueOf(mtopStatistics.reqSource));
                            hashMap.put(obj8, String.valueOf(mtopStatistics.cacheSwitch));
                            hashMap.put(obj7, String.valueOf(mtopStatistics.cacheHitType));
                            hashMap.put("clientTraceId", mtopStatistics.clientTraceId);
                            hashMap.put("serverTraceId", mtopStatistics.serverTraceId);
                            hashMap.put("pageName", mtopStatistics.pageName);
                            hashMap.put(obj5, mtopStatistics.pageUrl);
                            hashMap.put(obj6, String.valueOf(mtopStatistics.backGround ? 1 : 0));
                            str2 = str;
                            hashMap.put(obj3, String.valueOf(mtopStatistics.isMain ? 1 : 0));
                            hashMap.put(obj4, String.valueOf(RemoteConfig.getInstance().useSecurityAdapter));
                            hashMap.put(obj2, String.valueOf(mtopStatistics.isPrefetch ? 1 : 0));
                            hashMap.put("handler", String.valueOf(mtopStatistics.handler ? 1 : 0));
                            networkStats = getNetworkStats();
                            if (networkStats != null) {
                            }
                            if (Mtop.mIsFullTrackValid) {
                            }
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put("totalTime", Double.valueOf((double) mtopStatistics.totalTime));
                            hashMap2.put("networkExeTime", Double.valueOf((double) mtopStatistics.netTotalTime));
                            hashMap2.put("cacheCostTime", Double.valueOf((double) mtopStatistics.cacheCostTime));
                            hashMap2.put("cacheResponseParseTime", Double.valueOf((double) mtopStatistics.cacheResponseParseTime));
                            hashMap2.put("waitExecuteTime", Double.valueOf((double) mtopStatistics.waitExecuteTime));
                            hashMap2.put("waitCallbackTime", Double.valueOf((double) mtopStatistics.waitCallbackTime));
                            hashMap2.put("waitExecute2BuildParamTime", Double.valueOf((double) mtopStatistics.waitExecute2BuildParamTime));
                            hashMap2.put("buildParamsTime", Double.valueOf((double) mtopStatistics.buildParamsTime));
                            hashMap2.put("buildParams2NetworkTime", Double.valueOf((double) mtopStatistics.buildParams2NetworkTime));
                            hashMap2.put("startCallBack2EndTime", Double.valueOf((double) mtopStatistics.startCallBack2EndTime));
                            hashMap2.put("signTime", Double.valueOf((double) mtopStatistics.computeSignTime));
                            hashMap2.put("wuaTime", Double.valueOf((double) mtopStatistics.computeWuaTime));
                            hashMap2.put("miniWuaTime", Double.valueOf((double) mtopStatistics.computeMiniWuaTime));
                            hashMap2.put("callbackPocTime", Double.valueOf((double) mtopStatistics.callbackPocTime));
                            hashMap2.put("allTime", Double.valueOf((double) mtopStatistics.allTime));
                            hashMap2.put("requestPocTime", Double.valueOf((double) mtopStatistics.requestPocTime));
                            if (networkStats != null) {
                            }
                            rbStatisticData = mtopStatistics.c;
                            if (rbStatisticData != null) {
                            }
                            iUploadStats = mtopStatistics.e;
                            if (iUploadStats != null) {
                            }
                            if (!ErrorConstant.isSuccess(mtopStatistics.retCode)) {
                            }
                            HashMap hashMap3 = new HashMap();
                            hashMap3.put("bizId", !TextUtils.isEmpty(mtopStatistics.bizIdStr) ? mtopStatistics.bizIdStr : String.valueOf(mtopStatistics.bizId));
                            hashMap3.put("api", mtopStatistics.apiKey);
                            hashMap3.put("version", mtopStatistics.apiKey);
                            hashMap3.put("domain", mtopStatistics.domain);
                            hashMap3.put("httpResponseStatus", String.valueOf(mtopStatistics.statusCode));
                            hashMap3.put("ret", mtopStatistics.retCode);
                            hashMap3.put("bxSessionId", mtopStatistics.bxSessionId);
                            hashMap3.put("bxUI", String.valueOf(mtopStatistics.bxUI));
                            hashMap3.put("bxMainAction", String.valueOf(mtopStatistics.bxMainAction));
                            hashMap3.put("bxSubAction", String.valueOf(mtopStatistics.bxSubAction));
                            hashMap3.put("bxRetry", String.valueOf(mtopStatistics.bxRetry));
                            HashMap hashMap4 = new HashMap();
                            hashMap4.put("bxSleep", Double.valueOf((double) mtopStatistics.bxSleep));
                            hashMap4.put("checkTime", Double.valueOf((double) (mtopStatistics.fcProcessCheckEndTime - mtopStatistics.fcProcessCheckStartTime)));
                            hashMap4.put(obj, Double.valueOf((double) (mtopStatistics.fcProcessCallbackTime - mtopStatistics.fcProcessStartTime)));
                            iUploadStats2 = mtopStatistics.e;
                            if (iUploadStats2 != null) {
                            }
                            mtopStatistics.commitStat = false;
                        }
                    } else {
                        try {
                            hashSet = new HashSet();
                            hashSet.add("api");
                            hashSet.add("domain");
                            hashSet.add("httpResponseStatus");
                            hashSet.add("ret");
                            hashSet.add("retType");
                            hashSet.add("reqSource");
                            hashSet.add("cacheSwitch");
                            hashSet.add("cacheHitType");
                            hashSet.add("clientTraceId");
                            hashSet.add("serverTraceId");
                            hashSet.add("connType");
                            hashSet.add("isSSL");
                            hashSet.add("retryTimes");
                            hashSet.add("ip_port");
                            hashSet.add("pageName");
                            hashSet.add("pageUrl");
                            obj13 = "backGround";
                        } catch (Throwable th5) {
                            th3 = th5;
                            obj4 = "securityFeature";
                            obj13 = "backGround";
                            obj7 = "cacheHitType";
                            obj8 = "cacheSwitch";
                            str = "mtopsdk.MtopStatistics";
                            mtopStatistics = this;
                            th2 = th3;
                            String str5 = mtopStatistics.seqNo;
                            obj6 = obj13;
                            obj5 = "pageUrl";
                            TBSdkLog.e(str, str5, "[registerMtopStats] register MtopStats error ---" + th2.toString());
                            hashMap = new HashMap();
                            hashMap.put("api", mtopStatistics.apiKey);
                            hashMap.put("ret", mtopStatistics.retCode);
                            hashMap.put("retType", String.valueOf(mtopStatistics.retType));
                            hashMap.put("httpResponseStatus", String.valueOf(mtopStatistics.statusCode));
                            hashMap.put("domain", mtopStatistics.domain);
                            hashMap.put("reqSource", String.valueOf(mtopStatistics.reqSource));
                            hashMap.put(obj8, String.valueOf(mtopStatistics.cacheSwitch));
                            hashMap.put(obj7, String.valueOf(mtopStatistics.cacheHitType));
                            hashMap.put("clientTraceId", mtopStatistics.clientTraceId);
                            hashMap.put("serverTraceId", mtopStatistics.serverTraceId);
                            hashMap.put("pageName", mtopStatistics.pageName);
                            hashMap.put(obj5, mtopStatistics.pageUrl);
                            hashMap.put(obj6, String.valueOf(mtopStatistics.backGround ? 1 : 0));
                            str2 = str;
                            hashMap.put(obj3, String.valueOf(mtopStatistics.isMain ? 1 : 0));
                            hashMap.put(obj4, String.valueOf(RemoteConfig.getInstance().useSecurityAdapter));
                            hashMap.put(obj2, String.valueOf(mtopStatistics.isPrefetch ? 1 : 0));
                            hashMap.put("handler", String.valueOf(mtopStatistics.handler ? 1 : 0));
                            networkStats = getNetworkStats();
                            if (networkStats != null) {
                            }
                            if (Mtop.mIsFullTrackValid) {
                            }
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put("totalTime", Double.valueOf((double) mtopStatistics.totalTime));
                            hashMap2.put("networkExeTime", Double.valueOf((double) mtopStatistics.netTotalTime));
                            hashMap2.put("cacheCostTime", Double.valueOf((double) mtopStatistics.cacheCostTime));
                            hashMap2.put("cacheResponseParseTime", Double.valueOf((double) mtopStatistics.cacheResponseParseTime));
                            hashMap2.put("waitExecuteTime", Double.valueOf((double) mtopStatistics.waitExecuteTime));
                            hashMap2.put("waitCallbackTime", Double.valueOf((double) mtopStatistics.waitCallbackTime));
                            hashMap2.put("waitExecute2BuildParamTime", Double.valueOf((double) mtopStatistics.waitExecute2BuildParamTime));
                            hashMap2.put("buildParamsTime", Double.valueOf((double) mtopStatistics.buildParamsTime));
                            hashMap2.put("buildParams2NetworkTime", Double.valueOf((double) mtopStatistics.buildParams2NetworkTime));
                            hashMap2.put("startCallBack2EndTime", Double.valueOf((double) mtopStatistics.startCallBack2EndTime));
                            hashMap2.put("signTime", Double.valueOf((double) mtopStatistics.computeSignTime));
                            hashMap2.put("wuaTime", Double.valueOf((double) mtopStatistics.computeWuaTime));
                            hashMap2.put("miniWuaTime", Double.valueOf((double) mtopStatistics.computeMiniWuaTime));
                            hashMap2.put("callbackPocTime", Double.valueOf((double) mtopStatistics.callbackPocTime));
                            hashMap2.put("allTime", Double.valueOf((double) mtopStatistics.allTime));
                            hashMap2.put("requestPocTime", Double.valueOf((double) mtopStatistics.requestPocTime));
                            if (networkStats != null) {
                            }
                            rbStatisticData = mtopStatistics.c;
                            if (rbStatisticData != null) {
                            }
                            iUploadStats = mtopStatistics.e;
                            if (iUploadStats != null) {
                            }
                            if (!ErrorConstant.isSuccess(mtopStatistics.retCode)) {
                            }
                            HashMap hashMap3 = new HashMap();
                            hashMap3.put("bizId", !TextUtils.isEmpty(mtopStatistics.bizIdStr) ? mtopStatistics.bizIdStr : String.valueOf(mtopStatistics.bizId));
                            hashMap3.put("api", mtopStatistics.apiKey);
                            hashMap3.put("version", mtopStatistics.apiKey);
                            hashMap3.put("domain", mtopStatistics.domain);
                            hashMap3.put("httpResponseStatus", String.valueOf(mtopStatistics.statusCode));
                            hashMap3.put("ret", mtopStatistics.retCode);
                            hashMap3.put("bxSessionId", mtopStatistics.bxSessionId);
                            hashMap3.put("bxUI", String.valueOf(mtopStatistics.bxUI));
                            hashMap3.put("bxMainAction", String.valueOf(mtopStatistics.bxMainAction));
                            hashMap3.put("bxSubAction", String.valueOf(mtopStatistics.bxSubAction));
                            hashMap3.put("bxRetry", String.valueOf(mtopStatistics.bxRetry));
                            HashMap hashMap4 = new HashMap();
                            hashMap4.put("bxSleep", Double.valueOf((double) mtopStatistics.bxSleep));
                            hashMap4.put("checkTime", Double.valueOf((double) (mtopStatistics.fcProcessCheckEndTime - mtopStatistics.fcProcessCheckStartTime)));
                            hashMap4.put(obj, Double.valueOf((double) (mtopStatistics.fcProcessCallbackTime - mtopStatistics.fcProcessStartTime)));
                            iUploadStats2 = mtopStatistics.e;
                            if (iUploadStats2 != null) {
                            }
                            mtopStatistics.commitStat = false;
                        }
                        try {
                            hashSet.add(obj13);
                            obj7 = "cacheHitType";
                            try {
                                hashSet.add(obj3);
                                obj3 = obj3;
                                try {
                                    hashSet.add(obj2);
                                    obj2 = obj2;
                                    try {
                                        hashSet.add("handler");
                                        hashSet.add("launchType");
                                        hashSet.add("appLaunchExternal");
                                        hashSet.add("sinceAppLaunchInterval");
                                        hashSet.add("deviceLevel");
                                        hashSet.add("sinceLastLaunchInternal");
                                        obj14 = "securityFeature";
                                    } catch (Throwable th6) {
                                        th3 = th6;
                                        obj4 = "securityFeature";
                                        obj8 = "cacheSwitch";
                                        str = "mtopsdk.MtopStatistics";
                                        mtopStatistics = this;
                                        th2 = th3;
                                        String str5 = mtopStatistics.seqNo;
                                        obj6 = obj13;
                                        obj5 = "pageUrl";
                                        TBSdkLog.e(str, str5, "[registerMtopStats] register MtopStats error ---" + th2.toString());
                                        hashMap = new HashMap();
                                        hashMap.put("api", mtopStatistics.apiKey);
                                        hashMap.put("ret", mtopStatistics.retCode);
                                        hashMap.put("retType", String.valueOf(mtopStatistics.retType));
                                        hashMap.put("httpResponseStatus", String.valueOf(mtopStatistics.statusCode));
                                        hashMap.put("domain", mtopStatistics.domain);
                                        hashMap.put("reqSource", String.valueOf(mtopStatistics.reqSource));
                                        hashMap.put(obj8, String.valueOf(mtopStatistics.cacheSwitch));
                                        hashMap.put(obj7, String.valueOf(mtopStatistics.cacheHitType));
                                        hashMap.put("clientTraceId", mtopStatistics.clientTraceId);
                                        hashMap.put("serverTraceId", mtopStatistics.serverTraceId);
                                        hashMap.put("pageName", mtopStatistics.pageName);
                                        hashMap.put(obj5, mtopStatistics.pageUrl);
                                        hashMap.put(obj6, String.valueOf(mtopStatistics.backGround ? 1 : 0));
                                        str2 = str;
                                        hashMap.put(obj3, String.valueOf(mtopStatistics.isMain ? 1 : 0));
                                        hashMap.put(obj4, String.valueOf(RemoteConfig.getInstance().useSecurityAdapter));
                                        hashMap.put(obj2, String.valueOf(mtopStatistics.isPrefetch ? 1 : 0));
                                        hashMap.put("handler", String.valueOf(mtopStatistics.handler ? 1 : 0));
                                        networkStats = getNetworkStats();
                                        if (networkStats != null) {
                                        }
                                        if (Mtop.mIsFullTrackValid) {
                                        }
                                        HashMap hashMap2 = new HashMap();
                                        hashMap2.put("totalTime", Double.valueOf((double) mtopStatistics.totalTime));
                                        hashMap2.put("networkExeTime", Double.valueOf((double) mtopStatistics.netTotalTime));
                                        hashMap2.put("cacheCostTime", Double.valueOf((double) mtopStatistics.cacheCostTime));
                                        hashMap2.put("cacheResponseParseTime", Double.valueOf((double) mtopStatistics.cacheResponseParseTime));
                                        hashMap2.put("waitExecuteTime", Double.valueOf((double) mtopStatistics.waitExecuteTime));
                                        hashMap2.put("waitCallbackTime", Double.valueOf((double) mtopStatistics.waitCallbackTime));
                                        hashMap2.put("waitExecute2BuildParamTime", Double.valueOf((double) mtopStatistics.waitExecute2BuildParamTime));
                                        hashMap2.put("buildParamsTime", Double.valueOf((double) mtopStatistics.buildParamsTime));
                                        hashMap2.put("buildParams2NetworkTime", Double.valueOf((double) mtopStatistics.buildParams2NetworkTime));
                                        hashMap2.put("startCallBack2EndTime", Double.valueOf((double) mtopStatistics.startCallBack2EndTime));
                                        hashMap2.put("signTime", Double.valueOf((double) mtopStatistics.computeSignTime));
                                        hashMap2.put("wuaTime", Double.valueOf((double) mtopStatistics.computeWuaTime));
                                        hashMap2.put("miniWuaTime", Double.valueOf((double) mtopStatistics.computeMiniWuaTime));
                                        hashMap2.put("callbackPocTime", Double.valueOf((double) mtopStatistics.callbackPocTime));
                                        hashMap2.put("allTime", Double.valueOf((double) mtopStatistics.allTime));
                                        hashMap2.put("requestPocTime", Double.valueOf((double) mtopStatistics.requestPocTime));
                                        if (networkStats != null) {
                                        }
                                        rbStatisticData = mtopStatistics.c;
                                        if (rbStatisticData != null) {
                                        }
                                        iUploadStats = mtopStatistics.e;
                                        if (iUploadStats != null) {
                                        }
                                        if (!ErrorConstant.isSuccess(mtopStatistics.retCode)) {
                                        }
                                        HashMap hashMap3 = new HashMap();
                                        hashMap3.put("bizId", !TextUtils.isEmpty(mtopStatistics.bizIdStr) ? mtopStatistics.bizIdStr : String.valueOf(mtopStatistics.bizId));
                                        hashMap3.put("api", mtopStatistics.apiKey);
                                        hashMap3.put("version", mtopStatistics.apiKey);
                                        hashMap3.put("domain", mtopStatistics.domain);
                                        hashMap3.put("httpResponseStatus", String.valueOf(mtopStatistics.statusCode));
                                        hashMap3.put("ret", mtopStatistics.retCode);
                                        hashMap3.put("bxSessionId", mtopStatistics.bxSessionId);
                                        hashMap3.put("bxUI", String.valueOf(mtopStatistics.bxUI));
                                        hashMap3.put("bxMainAction", String.valueOf(mtopStatistics.bxMainAction));
                                        hashMap3.put("bxSubAction", String.valueOf(mtopStatistics.bxSubAction));
                                        hashMap3.put("bxRetry", String.valueOf(mtopStatistics.bxRetry));
                                        HashMap hashMap4 = new HashMap();
                                        hashMap4.put("bxSleep", Double.valueOf((double) mtopStatistics.bxSleep));
                                        hashMap4.put("checkTime", Double.valueOf((double) (mtopStatistics.fcProcessCheckEndTime - mtopStatistics.fcProcessCheckStartTime)));
                                        hashMap4.put(obj, Double.valueOf((double) (mtopStatistics.fcProcessCallbackTime - mtopStatistics.fcProcessStartTime)));
                                        iUploadStats2 = mtopStatistics.e;
                                        if (iUploadStats2 != null) {
                                        }
                                        mtopStatistics.commitStat = false;
                                    }
                                    try {
                                        hashSet.add(obj14);
                                        obj8 = "cacheSwitch";
                                    } catch (Throwable th7) {
                                        th3 = th7;
                                        obj4 = obj14;
                                        obj8 = "cacheSwitch";
                                        str = "mtopsdk.MtopStatistics";
                                        mtopStatistics = this;
                                        th2 = th3;
                                        String str5 = mtopStatistics.seqNo;
                                        obj6 = obj13;
                                        obj5 = "pageUrl";
                                        TBSdkLog.e(str, str5, "[registerMtopStats] register MtopStats error ---" + th2.toString());
                                        hashMap = new HashMap();
                                        hashMap.put("api", mtopStatistics.apiKey);
                                        hashMap.put("ret", mtopStatistics.retCode);
                                        hashMap.put("retType", String.valueOf(mtopStatistics.retType));
                                        hashMap.put("httpResponseStatus", String.valueOf(mtopStatistics.statusCode));
                                        hashMap.put("domain", mtopStatistics.domain);
                                        hashMap.put("reqSource", String.valueOf(mtopStatistics.reqSource));
                                        hashMap.put(obj8, String.valueOf(mtopStatistics.cacheSwitch));
                                        hashMap.put(obj7, String.valueOf(mtopStatistics.cacheHitType));
                                        hashMap.put("clientTraceId", mtopStatistics.clientTraceId);
                                        hashMap.put("serverTraceId", mtopStatistics.serverTraceId);
                                        hashMap.put("pageName", mtopStatistics.pageName);
                                        hashMap.put(obj5, mtopStatistics.pageUrl);
                                        hashMap.put(obj6, String.valueOf(mtopStatistics.backGround ? 1 : 0));
                                        str2 = str;
                                        hashMap.put(obj3, String.valueOf(mtopStatistics.isMain ? 1 : 0));
                                        hashMap.put(obj4, String.valueOf(RemoteConfig.getInstance().useSecurityAdapter));
                                        hashMap.put(obj2, String.valueOf(mtopStatistics.isPrefetch ? 1 : 0));
                                        hashMap.put("handler", String.valueOf(mtopStatistics.handler ? 1 : 0));
                                        networkStats = getNetworkStats();
                                        if (networkStats != null) {
                                        }
                                        if (Mtop.mIsFullTrackValid) {
                                        }
                                        HashMap hashMap2 = new HashMap();
                                        hashMap2.put("totalTime", Double.valueOf((double) mtopStatistics.totalTime));
                                        hashMap2.put("networkExeTime", Double.valueOf((double) mtopStatistics.netTotalTime));
                                        hashMap2.put("cacheCostTime", Double.valueOf((double) mtopStatistics.cacheCostTime));
                                        hashMap2.put("cacheResponseParseTime", Double.valueOf((double) mtopStatistics.cacheResponseParseTime));
                                        hashMap2.put("waitExecuteTime", Double.valueOf((double) mtopStatistics.waitExecuteTime));
                                        hashMap2.put("waitCallbackTime", Double.valueOf((double) mtopStatistics.waitCallbackTime));
                                        hashMap2.put("waitExecute2BuildParamTime", Double.valueOf((double) mtopStatistics.waitExecute2BuildParamTime));
                                        hashMap2.put("buildParamsTime", Double.valueOf((double) mtopStatistics.buildParamsTime));
                                        hashMap2.put("buildParams2NetworkTime", Double.valueOf((double) mtopStatistics.buildParams2NetworkTime));
                                        hashMap2.put("startCallBack2EndTime", Double.valueOf((double) mtopStatistics.startCallBack2EndTime));
                                        hashMap2.put("signTime", Double.valueOf((double) mtopStatistics.computeSignTime));
                                        hashMap2.put("wuaTime", Double.valueOf((double) mtopStatistics.computeWuaTime));
                                        hashMap2.put("miniWuaTime", Double.valueOf((double) mtopStatistics.computeMiniWuaTime));
                                        hashMap2.put("callbackPocTime", Double.valueOf((double) mtopStatistics.callbackPocTime));
                                        hashMap2.put("allTime", Double.valueOf((double) mtopStatistics.allTime));
                                        hashMap2.put("requestPocTime", Double.valueOf((double) mtopStatistics.requestPocTime));
                                        if (networkStats != null) {
                                        }
                                        rbStatisticData = mtopStatistics.c;
                                        if (rbStatisticData != null) {
                                        }
                                        iUploadStats = mtopStatistics.e;
                                        if (iUploadStats != null) {
                                        }
                                        if (!ErrorConstant.isSuccess(mtopStatistics.retCode)) {
                                        }
                                        HashMap hashMap3 = new HashMap();
                                        hashMap3.put("bizId", !TextUtils.isEmpty(mtopStatistics.bizIdStr) ? mtopStatistics.bizIdStr : String.valueOf(mtopStatistics.bizId));
                                        hashMap3.put("api", mtopStatistics.apiKey);
                                        hashMap3.put("version", mtopStatistics.apiKey);
                                        hashMap3.put("domain", mtopStatistics.domain);
                                        hashMap3.put("httpResponseStatus", String.valueOf(mtopStatistics.statusCode));
                                        hashMap3.put("ret", mtopStatistics.retCode);
                                        hashMap3.put("bxSessionId", mtopStatistics.bxSessionId);
                                        hashMap3.put("bxUI", String.valueOf(mtopStatistics.bxUI));
                                        hashMap3.put("bxMainAction", String.valueOf(mtopStatistics.bxMainAction));
                                        hashMap3.put("bxSubAction", String.valueOf(mtopStatistics.bxSubAction));
                                        hashMap3.put("bxRetry", String.valueOf(mtopStatistics.bxRetry));
                                        HashMap hashMap4 = new HashMap();
                                        hashMap4.put("bxSleep", Double.valueOf((double) mtopStatistics.bxSleep));
                                        hashMap4.put("checkTime", Double.valueOf((double) (mtopStatistics.fcProcessCheckEndTime - mtopStatistics.fcProcessCheckStartTime)));
                                        hashMap4.put(obj, Double.valueOf((double) (mtopStatistics.fcProcessCallbackTime - mtopStatistics.fcProcessStartTime)));
                                        iUploadStats2 = mtopStatistics.e;
                                        if (iUploadStats2 != null) {
                                        }
                                        mtopStatistics.commitStat = false;
                                    }
                                } catch (Throwable th8) {
                                    th3 = th8;
                                    obj2 = obj2;
                                    obj4 = "securityFeature";
                                    obj8 = "cacheSwitch";
                                    str = "mtopsdk.MtopStatistics";
                                    mtopStatistics = this;
                                    th2 = th3;
                                    String str5 = mtopStatistics.seqNo;
                                    obj6 = obj13;
                                    obj5 = "pageUrl";
                                    TBSdkLog.e(str, str5, "[registerMtopStats] register MtopStats error ---" + th2.toString());
                                    hashMap = new HashMap();
                                    hashMap.put("api", mtopStatistics.apiKey);
                                    hashMap.put("ret", mtopStatistics.retCode);
                                    hashMap.put("retType", String.valueOf(mtopStatistics.retType));
                                    hashMap.put("httpResponseStatus", String.valueOf(mtopStatistics.statusCode));
                                    hashMap.put("domain", mtopStatistics.domain);
                                    hashMap.put("reqSource", String.valueOf(mtopStatistics.reqSource));
                                    hashMap.put(obj8, String.valueOf(mtopStatistics.cacheSwitch));
                                    hashMap.put(obj7, String.valueOf(mtopStatistics.cacheHitType));
                                    hashMap.put("clientTraceId", mtopStatistics.clientTraceId);
                                    hashMap.put("serverTraceId", mtopStatistics.serverTraceId);
                                    hashMap.put("pageName", mtopStatistics.pageName);
                                    hashMap.put(obj5, mtopStatistics.pageUrl);
                                    hashMap.put(obj6, String.valueOf(mtopStatistics.backGround ? 1 : 0));
                                    str2 = str;
                                    hashMap.put(obj3, String.valueOf(mtopStatistics.isMain ? 1 : 0));
                                    hashMap.put(obj4, String.valueOf(RemoteConfig.getInstance().useSecurityAdapter));
                                    hashMap.put(obj2, String.valueOf(mtopStatistics.isPrefetch ? 1 : 0));
                                    hashMap.put("handler", String.valueOf(mtopStatistics.handler ? 1 : 0));
                                    networkStats = getNetworkStats();
                                    if (networkStats != null) {
                                    }
                                    if (Mtop.mIsFullTrackValid) {
                                    }
                                    HashMap hashMap2 = new HashMap();
                                    hashMap2.put("totalTime", Double.valueOf((double) mtopStatistics.totalTime));
                                    hashMap2.put("networkExeTime", Double.valueOf((double) mtopStatistics.netTotalTime));
                                    hashMap2.put("cacheCostTime", Double.valueOf((double) mtopStatistics.cacheCostTime));
                                    hashMap2.put("cacheResponseParseTime", Double.valueOf((double) mtopStatistics.cacheResponseParseTime));
                                    hashMap2.put("waitExecuteTime", Double.valueOf((double) mtopStatistics.waitExecuteTime));
                                    hashMap2.put("waitCallbackTime", Double.valueOf((double) mtopStatistics.waitCallbackTime));
                                    hashMap2.put("waitExecute2BuildParamTime", Double.valueOf((double) mtopStatistics.waitExecute2BuildParamTime));
                                    hashMap2.put("buildParamsTime", Double.valueOf((double) mtopStatistics.buildParamsTime));
                                    hashMap2.put("buildParams2NetworkTime", Double.valueOf((double) mtopStatistics.buildParams2NetworkTime));
                                    hashMap2.put("startCallBack2EndTime", Double.valueOf((double) mtopStatistics.startCallBack2EndTime));
                                    hashMap2.put("signTime", Double.valueOf((double) mtopStatistics.computeSignTime));
                                    hashMap2.put("wuaTime", Double.valueOf((double) mtopStatistics.computeWuaTime));
                                    hashMap2.put("miniWuaTime", Double.valueOf((double) mtopStatistics.computeMiniWuaTime));
                                    hashMap2.put("callbackPocTime", Double.valueOf((double) mtopStatistics.callbackPocTime));
                                    hashMap2.put("allTime", Double.valueOf((double) mtopStatistics.allTime));
                                    hashMap2.put("requestPocTime", Double.valueOf((double) mtopStatistics.requestPocTime));
                                    if (networkStats != null) {
                                    }
                                    rbStatisticData = mtopStatistics.c;
                                    if (rbStatisticData != null) {
                                    }
                                    iUploadStats = mtopStatistics.e;
                                    if (iUploadStats != null) {
                                    }
                                    if (!ErrorConstant.isSuccess(mtopStatistics.retCode)) {
                                    }
                                    HashMap hashMap3 = new HashMap();
                                    hashMap3.put("bizId", !TextUtils.isEmpty(mtopStatistics.bizIdStr) ? mtopStatistics.bizIdStr : String.valueOf(mtopStatistics.bizId));
                                    hashMap3.put("api", mtopStatistics.apiKey);
                                    hashMap3.put("version", mtopStatistics.apiKey);
                                    hashMap3.put("domain", mtopStatistics.domain);
                                    hashMap3.put("httpResponseStatus", String.valueOf(mtopStatistics.statusCode));
                                    hashMap3.put("ret", mtopStatistics.retCode);
                                    hashMap3.put("bxSessionId", mtopStatistics.bxSessionId);
                                    hashMap3.put("bxUI", String.valueOf(mtopStatistics.bxUI));
                                    hashMap3.put("bxMainAction", String.valueOf(mtopStatistics.bxMainAction));
                                    hashMap3.put("bxSubAction", String.valueOf(mtopStatistics.bxSubAction));
                                    hashMap3.put("bxRetry", String.valueOf(mtopStatistics.bxRetry));
                                    HashMap hashMap4 = new HashMap();
                                    hashMap4.put("bxSleep", Double.valueOf((double) mtopStatistics.bxSleep));
                                    hashMap4.put("checkTime", Double.valueOf((double) (mtopStatistics.fcProcessCheckEndTime - mtopStatistics.fcProcessCheckStartTime)));
                                    hashMap4.put(obj, Double.valueOf((double) (mtopStatistics.fcProcessCallbackTime - mtopStatistics.fcProcessStartTime)));
                                    iUploadStats2 = mtopStatistics.e;
                                    if (iUploadStats2 != null) {
                                    }
                                    mtopStatistics.commitStat = false;
                                }
                            } catch (Throwable th9) {
                                th3 = th9;
                                obj3 = obj3;
                                obj4 = "securityFeature";
                                obj8 = "cacheSwitch";
                                str = "mtopsdk.MtopStatistics";
                                mtopStatistics = this;
                                th2 = th3;
                                String str5 = mtopStatistics.seqNo;
                                obj6 = obj13;
                                obj5 = "pageUrl";
                                TBSdkLog.e(str, str5, "[registerMtopStats] register MtopStats error ---" + th2.toString());
                                hashMap = new HashMap();
                                hashMap.put("api", mtopStatistics.apiKey);
                                hashMap.put("ret", mtopStatistics.retCode);
                                hashMap.put("retType", String.valueOf(mtopStatistics.retType));
                                hashMap.put("httpResponseStatus", String.valueOf(mtopStatistics.statusCode));
                                hashMap.put("domain", mtopStatistics.domain);
                                hashMap.put("reqSource", String.valueOf(mtopStatistics.reqSource));
                                hashMap.put(obj8, String.valueOf(mtopStatistics.cacheSwitch));
                                hashMap.put(obj7, String.valueOf(mtopStatistics.cacheHitType));
                                hashMap.put("clientTraceId", mtopStatistics.clientTraceId);
                                hashMap.put("serverTraceId", mtopStatistics.serverTraceId);
                                hashMap.put("pageName", mtopStatistics.pageName);
                                hashMap.put(obj5, mtopStatistics.pageUrl);
                                hashMap.put(obj6, String.valueOf(mtopStatistics.backGround ? 1 : 0));
                                str2 = str;
                                hashMap.put(obj3, String.valueOf(mtopStatistics.isMain ? 1 : 0));
                                hashMap.put(obj4, String.valueOf(RemoteConfig.getInstance().useSecurityAdapter));
                                hashMap.put(obj2, String.valueOf(mtopStatistics.isPrefetch ? 1 : 0));
                                hashMap.put("handler", String.valueOf(mtopStatistics.handler ? 1 : 0));
                                networkStats = getNetworkStats();
                                if (networkStats != null) {
                                }
                                if (Mtop.mIsFullTrackValid) {
                                }
                                HashMap hashMap2 = new HashMap();
                                hashMap2.put("totalTime", Double.valueOf((double) mtopStatistics.totalTime));
                                hashMap2.put("networkExeTime", Double.valueOf((double) mtopStatistics.netTotalTime));
                                hashMap2.put("cacheCostTime", Double.valueOf((double) mtopStatistics.cacheCostTime));
                                hashMap2.put("cacheResponseParseTime", Double.valueOf((double) mtopStatistics.cacheResponseParseTime));
                                hashMap2.put("waitExecuteTime", Double.valueOf((double) mtopStatistics.waitExecuteTime));
                                hashMap2.put("waitCallbackTime", Double.valueOf((double) mtopStatistics.waitCallbackTime));
                                hashMap2.put("waitExecute2BuildParamTime", Double.valueOf((double) mtopStatistics.waitExecute2BuildParamTime));
                                hashMap2.put("buildParamsTime", Double.valueOf((double) mtopStatistics.buildParamsTime));
                                hashMap2.put("buildParams2NetworkTime", Double.valueOf((double) mtopStatistics.buildParams2NetworkTime));
                                hashMap2.put("startCallBack2EndTime", Double.valueOf((double) mtopStatistics.startCallBack2EndTime));
                                hashMap2.put("signTime", Double.valueOf((double) mtopStatistics.computeSignTime));
                                hashMap2.put("wuaTime", Double.valueOf((double) mtopStatistics.computeWuaTime));
                                hashMap2.put("miniWuaTime", Double.valueOf((double) mtopStatistics.computeMiniWuaTime));
                                hashMap2.put("callbackPocTime", Double.valueOf((double) mtopStatistics.callbackPocTime));
                                hashMap2.put("allTime", Double.valueOf((double) mtopStatistics.allTime));
                                hashMap2.put("requestPocTime", Double.valueOf((double) mtopStatistics.requestPocTime));
                                if (networkStats != null) {
                                }
                                rbStatisticData = mtopStatistics.c;
                                if (rbStatisticData != null) {
                                }
                                iUploadStats = mtopStatistics.e;
                                if (iUploadStats != null) {
                                }
                                if (!ErrorConstant.isSuccess(mtopStatistics.retCode)) {
                                }
                                HashMap hashMap3 = new HashMap();
                                hashMap3.put("bizId", !TextUtils.isEmpty(mtopStatistics.bizIdStr) ? mtopStatistics.bizIdStr : String.valueOf(mtopStatistics.bizId));
                                hashMap3.put("api", mtopStatistics.apiKey);
                                hashMap3.put("version", mtopStatistics.apiKey);
                                hashMap3.put("domain", mtopStatistics.domain);
                                hashMap3.put("httpResponseStatus", String.valueOf(mtopStatistics.statusCode));
                                hashMap3.put("ret", mtopStatistics.retCode);
                                hashMap3.put("bxSessionId", mtopStatistics.bxSessionId);
                                hashMap3.put("bxUI", String.valueOf(mtopStatistics.bxUI));
                                hashMap3.put("bxMainAction", String.valueOf(mtopStatistics.bxMainAction));
                                hashMap3.put("bxSubAction", String.valueOf(mtopStatistics.bxSubAction));
                                hashMap3.put("bxRetry", String.valueOf(mtopStatistics.bxRetry));
                                HashMap hashMap4 = new HashMap();
                                hashMap4.put("bxSleep", Double.valueOf((double) mtopStatistics.bxSleep));
                                hashMap4.put("checkTime", Double.valueOf((double) (mtopStatistics.fcProcessCheckEndTime - mtopStatistics.fcProcessCheckStartTime)));
                                hashMap4.put(obj, Double.valueOf((double) (mtopStatistics.fcProcessCallbackTime - mtopStatistics.fcProcessStartTime)));
                                iUploadStats2 = mtopStatistics.e;
                                if (iUploadStats2 != null) {
                                }
                                mtopStatistics.commitStat = false;
                            }
                        } catch (Throwable th10) {
                            th3 = th10;
                            obj7 = "cacheHitType";
                            obj4 = "securityFeature";
                            obj8 = "cacheSwitch";
                            str = "mtopsdk.MtopStatistics";
                            mtopStatistics = this;
                            th2 = th3;
                            String str5 = mtopStatistics.seqNo;
                            obj6 = obj13;
                            obj5 = "pageUrl";
                            TBSdkLog.e(str, str5, "[registerMtopStats] register MtopStats error ---" + th2.toString());
                            hashMap = new HashMap();
                            hashMap.put("api", mtopStatistics.apiKey);
                            hashMap.put("ret", mtopStatistics.retCode);
                            hashMap.put("retType", String.valueOf(mtopStatistics.retType));
                            hashMap.put("httpResponseStatus", String.valueOf(mtopStatistics.statusCode));
                            hashMap.put("domain", mtopStatistics.domain);
                            hashMap.put("reqSource", String.valueOf(mtopStatistics.reqSource));
                            hashMap.put(obj8, String.valueOf(mtopStatistics.cacheSwitch));
                            hashMap.put(obj7, String.valueOf(mtopStatistics.cacheHitType));
                            hashMap.put("clientTraceId", mtopStatistics.clientTraceId);
                            hashMap.put("serverTraceId", mtopStatistics.serverTraceId);
                            hashMap.put("pageName", mtopStatistics.pageName);
                            hashMap.put(obj5, mtopStatistics.pageUrl);
                            hashMap.put(obj6, String.valueOf(mtopStatistics.backGround ? 1 : 0));
                            str2 = str;
                            hashMap.put(obj3, String.valueOf(mtopStatistics.isMain ? 1 : 0));
                            hashMap.put(obj4, String.valueOf(RemoteConfig.getInstance().useSecurityAdapter));
                            hashMap.put(obj2, String.valueOf(mtopStatistics.isPrefetch ? 1 : 0));
                            hashMap.put("handler", String.valueOf(mtopStatistics.handler ? 1 : 0));
                            networkStats = getNetworkStats();
                            if (networkStats != null) {
                            }
                            if (Mtop.mIsFullTrackValid) {
                            }
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put("totalTime", Double.valueOf((double) mtopStatistics.totalTime));
                            hashMap2.put("networkExeTime", Double.valueOf((double) mtopStatistics.netTotalTime));
                            hashMap2.put("cacheCostTime", Double.valueOf((double) mtopStatistics.cacheCostTime));
                            hashMap2.put("cacheResponseParseTime", Double.valueOf((double) mtopStatistics.cacheResponseParseTime));
                            hashMap2.put("waitExecuteTime", Double.valueOf((double) mtopStatistics.waitExecuteTime));
                            hashMap2.put("waitCallbackTime", Double.valueOf((double) mtopStatistics.waitCallbackTime));
                            hashMap2.put("waitExecute2BuildParamTime", Double.valueOf((double) mtopStatistics.waitExecute2BuildParamTime));
                            hashMap2.put("buildParamsTime", Double.valueOf((double) mtopStatistics.buildParamsTime));
                            hashMap2.put("buildParams2NetworkTime", Double.valueOf((double) mtopStatistics.buildParams2NetworkTime));
                            hashMap2.put("startCallBack2EndTime", Double.valueOf((double) mtopStatistics.startCallBack2EndTime));
                            hashMap2.put("signTime", Double.valueOf((double) mtopStatistics.computeSignTime));
                            hashMap2.put("wuaTime", Double.valueOf((double) mtopStatistics.computeWuaTime));
                            hashMap2.put("miniWuaTime", Double.valueOf((double) mtopStatistics.computeMiniWuaTime));
                            hashMap2.put("callbackPocTime", Double.valueOf((double) mtopStatistics.callbackPocTime));
                            hashMap2.put("allTime", Double.valueOf((double) mtopStatistics.allTime));
                            hashMap2.put("requestPocTime", Double.valueOf((double) mtopStatistics.requestPocTime));
                            if (networkStats != null) {
                            }
                            rbStatisticData = mtopStatistics.c;
                            if (rbStatisticData != null) {
                            }
                            iUploadStats = mtopStatistics.e;
                            if (iUploadStats != null) {
                            }
                            if (!ErrorConstant.isSuccess(mtopStatistics.retCode)) {
                            }
                            HashMap hashMap3 = new HashMap();
                            hashMap3.put("bizId", !TextUtils.isEmpty(mtopStatistics.bizIdStr) ? mtopStatistics.bizIdStr : String.valueOf(mtopStatistics.bizId));
                            hashMap3.put("api", mtopStatistics.apiKey);
                            hashMap3.put("version", mtopStatistics.apiKey);
                            hashMap3.put("domain", mtopStatistics.domain);
                            hashMap3.put("httpResponseStatus", String.valueOf(mtopStatistics.statusCode));
                            hashMap3.put("ret", mtopStatistics.retCode);
                            hashMap3.put("bxSessionId", mtopStatistics.bxSessionId);
                            hashMap3.put("bxUI", String.valueOf(mtopStatistics.bxUI));
                            hashMap3.put("bxMainAction", String.valueOf(mtopStatistics.bxMainAction));
                            hashMap3.put("bxSubAction", String.valueOf(mtopStatistics.bxSubAction));
                            hashMap3.put("bxRetry", String.valueOf(mtopStatistics.bxRetry));
                            HashMap hashMap4 = new HashMap();
                            hashMap4.put("bxSleep", Double.valueOf((double) mtopStatistics.bxSleep));
                            hashMap4.put("checkTime", Double.valueOf((double) (mtopStatistics.fcProcessCheckEndTime - mtopStatistics.fcProcessCheckStartTime)));
                            hashMap4.put(obj, Double.valueOf((double) (mtopStatistics.fcProcessCallbackTime - mtopStatistics.fcProcessStartTime)));
                            iUploadStats2 = mtopStatistics.e;
                            if (iUploadStats2 != null) {
                            }
                            mtopStatistics.commitStat = false;
                        }
                        try {
                            hashSet.add("speedBucket");
                            hashSet.add("speedBucketId");
                            hashSet2 = new HashSet();
                            try {
                                hashSet2.add("totalTime");
                                hashSet2.add("waitExecuteTime");
                                hashSet2.add("waitExecute2BuildParamTime");
                                hashSet2.add("buildParamsTime");
                                hashSet2.add("buildParams2NetworkTime");
                                hashSet2.add("networkExeTime");
                                hashSet2.add("waitCallbackTime");
                                hashSet2.add("startCallBack2EndTime");
                                hashSet2.add("cacheCostTime");
                                hashSet2.add("cacheResponseParseTime");
                                hashSet2.add("signTime");
                                hashSet2.add("wuaTime");
                                hashSet2.add("miniWuaTime");
                                hashSet2.add("requestPocTime");
                                hashSet2.add("callbackPocTime");
                                hashSet2.add("allTime");
                                hashSet2.add("rbReqTime");
                                hashSet2.add("toMainThTime");
                                hashSet2.add("mtopDispatchTime");
                                hashSet2.add("bizCallbackTime");
                                hashSet2.add("mtopJsonParseTime");
                                hashSet2.add("mtopReqTime");
                            } catch (Throwable th11) {
                                th3 = th11;
                                mtopStatistics = this;
                                obj4 = obj14;
                                str = "mtopsdk.MtopStatistics";
                                th2 = th3;
                                String str5 = mtopStatistics.seqNo;
                                obj6 = obj13;
                                obj5 = "pageUrl";
                                TBSdkLog.e(str, str5, "[registerMtopStats] register MtopStats error ---" + th2.toString());
                                hashMap = new HashMap();
                                hashMap.put("api", mtopStatistics.apiKey);
                                hashMap.put("ret", mtopStatistics.retCode);
                                hashMap.put("retType", String.valueOf(mtopStatistics.retType));
                                hashMap.put("httpResponseStatus", String.valueOf(mtopStatistics.statusCode));
                                hashMap.put("domain", mtopStatistics.domain);
                                hashMap.put("reqSource", String.valueOf(mtopStatistics.reqSource));
                                hashMap.put(obj8, String.valueOf(mtopStatistics.cacheSwitch));
                                hashMap.put(obj7, String.valueOf(mtopStatistics.cacheHitType));
                                hashMap.put("clientTraceId", mtopStatistics.clientTraceId);
                                hashMap.put("serverTraceId", mtopStatistics.serverTraceId);
                                hashMap.put("pageName", mtopStatistics.pageName);
                                hashMap.put(obj5, mtopStatistics.pageUrl);
                                hashMap.put(obj6, String.valueOf(mtopStatistics.backGround ? 1 : 0));
                                str2 = str;
                                hashMap.put(obj3, String.valueOf(mtopStatistics.isMain ? 1 : 0));
                                hashMap.put(obj4, String.valueOf(RemoteConfig.getInstance().useSecurityAdapter));
                                hashMap.put(obj2, String.valueOf(mtopStatistics.isPrefetch ? 1 : 0));
                                hashMap.put("handler", String.valueOf(mtopStatistics.handler ? 1 : 0));
                                networkStats = getNetworkStats();
                                if (networkStats != null) {
                                }
                                if (Mtop.mIsFullTrackValid) {
                                }
                                HashMap hashMap2 = new HashMap();
                                hashMap2.put("totalTime", Double.valueOf((double) mtopStatistics.totalTime));
                                hashMap2.put("networkExeTime", Double.valueOf((double) mtopStatistics.netTotalTime));
                                hashMap2.put("cacheCostTime", Double.valueOf((double) mtopStatistics.cacheCostTime));
                                hashMap2.put("cacheResponseParseTime", Double.valueOf((double) mtopStatistics.cacheResponseParseTime));
                                hashMap2.put("waitExecuteTime", Double.valueOf((double) mtopStatistics.waitExecuteTime));
                                hashMap2.put("waitCallbackTime", Double.valueOf((double) mtopStatistics.waitCallbackTime));
                                hashMap2.put("waitExecute2BuildParamTime", Double.valueOf((double) mtopStatistics.waitExecute2BuildParamTime));
                                hashMap2.put("buildParamsTime", Double.valueOf((double) mtopStatistics.buildParamsTime));
                                hashMap2.put("buildParams2NetworkTime", Double.valueOf((double) mtopStatistics.buildParams2NetworkTime));
                                hashMap2.put("startCallBack2EndTime", Double.valueOf((double) mtopStatistics.startCallBack2EndTime));
                                hashMap2.put("signTime", Double.valueOf((double) mtopStatistics.computeSignTime));
                                hashMap2.put("wuaTime", Double.valueOf((double) mtopStatistics.computeWuaTime));
                                hashMap2.put("miniWuaTime", Double.valueOf((double) mtopStatistics.computeMiniWuaTime));
                                hashMap2.put("callbackPocTime", Double.valueOf((double) mtopStatistics.callbackPocTime));
                                hashMap2.put("allTime", Double.valueOf((double) mtopStatistics.allTime));
                                hashMap2.put("requestPocTime", Double.valueOf((double) mtopStatistics.requestPocTime));
                                if (networkStats != null) {
                                }
                                rbStatisticData = mtopStatistics.c;
                                if (rbStatisticData != null) {
                                }
                                iUploadStats = mtopStatistics.e;
                                if (iUploadStats != null) {
                                }
                                if (!ErrorConstant.isSuccess(mtopStatistics.retCode)) {
                                }
                                HashMap hashMap3 = new HashMap();
                                hashMap3.put("bizId", !TextUtils.isEmpty(mtopStatistics.bizIdStr) ? mtopStatistics.bizIdStr : String.valueOf(mtopStatistics.bizId));
                                hashMap3.put("api", mtopStatistics.apiKey);
                                hashMap3.put("version", mtopStatistics.apiKey);
                                hashMap3.put("domain", mtopStatistics.domain);
                                hashMap3.put("httpResponseStatus", String.valueOf(mtopStatistics.statusCode));
                                hashMap3.put("ret", mtopStatistics.retCode);
                                hashMap3.put("bxSessionId", mtopStatistics.bxSessionId);
                                hashMap3.put("bxUI", String.valueOf(mtopStatistics.bxUI));
                                hashMap3.put("bxMainAction", String.valueOf(mtopStatistics.bxMainAction));
                                hashMap3.put("bxSubAction", String.valueOf(mtopStatistics.bxSubAction));
                                hashMap3.put("bxRetry", String.valueOf(mtopStatistics.bxRetry));
                                HashMap hashMap4 = new HashMap();
                                hashMap4.put("bxSleep", Double.valueOf((double) mtopStatistics.bxSleep));
                                hashMap4.put("checkTime", Double.valueOf((double) (mtopStatistics.fcProcessCheckEndTime - mtopStatistics.fcProcessCheckStartTime)));
                                hashMap4.put(obj, Double.valueOf((double) (mtopStatistics.fcProcessCallbackTime - mtopStatistics.fcProcessStartTime)));
                                iUploadStats2 = mtopStatistics.e;
                                if (iUploadStats2 != null) {
                                }
                                mtopStatistics.commitStat = false;
                            }
                        } catch (Throwable th12) {
                            th3 = th12;
                            obj4 = obj14;
                            str = "mtopsdk.MtopStatistics";
                            mtopStatistics = this;
                            th2 = th3;
                            String str5 = mtopStatistics.seqNo;
                            obj6 = obj13;
                            obj5 = "pageUrl";
                            TBSdkLog.e(str, str5, "[registerMtopStats] register MtopStats error ---" + th2.toString());
                            hashMap = new HashMap();
                            hashMap.put("api", mtopStatistics.apiKey);
                            hashMap.put("ret", mtopStatistics.retCode);
                            hashMap.put("retType", String.valueOf(mtopStatistics.retType));
                            hashMap.put("httpResponseStatus", String.valueOf(mtopStatistics.statusCode));
                            hashMap.put("domain", mtopStatistics.domain);
                            hashMap.put("reqSource", String.valueOf(mtopStatistics.reqSource));
                            hashMap.put(obj8, String.valueOf(mtopStatistics.cacheSwitch));
                            hashMap.put(obj7, String.valueOf(mtopStatistics.cacheHitType));
                            hashMap.put("clientTraceId", mtopStatistics.clientTraceId);
                            hashMap.put("serverTraceId", mtopStatistics.serverTraceId);
                            hashMap.put("pageName", mtopStatistics.pageName);
                            hashMap.put(obj5, mtopStatistics.pageUrl);
                            hashMap.put(obj6, String.valueOf(mtopStatistics.backGround ? 1 : 0));
                            str2 = str;
                            hashMap.put(obj3, String.valueOf(mtopStatistics.isMain ? 1 : 0));
                            hashMap.put(obj4, String.valueOf(RemoteConfig.getInstance().useSecurityAdapter));
                            hashMap.put(obj2, String.valueOf(mtopStatistics.isPrefetch ? 1 : 0));
                            hashMap.put("handler", String.valueOf(mtopStatistics.handler ? 1 : 0));
                            networkStats = getNetworkStats();
                            if (networkStats != null) {
                            }
                            if (Mtop.mIsFullTrackValid) {
                            }
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put("totalTime", Double.valueOf((double) mtopStatistics.totalTime));
                            hashMap2.put("networkExeTime", Double.valueOf((double) mtopStatistics.netTotalTime));
                            hashMap2.put("cacheCostTime", Double.valueOf((double) mtopStatistics.cacheCostTime));
                            hashMap2.put("cacheResponseParseTime", Double.valueOf((double) mtopStatistics.cacheResponseParseTime));
                            hashMap2.put("waitExecuteTime", Double.valueOf((double) mtopStatistics.waitExecuteTime));
                            hashMap2.put("waitCallbackTime", Double.valueOf((double) mtopStatistics.waitCallbackTime));
                            hashMap2.put("waitExecute2BuildParamTime", Double.valueOf((double) mtopStatistics.waitExecute2BuildParamTime));
                            hashMap2.put("buildParamsTime", Double.valueOf((double) mtopStatistics.buildParamsTime));
                            hashMap2.put("buildParams2NetworkTime", Double.valueOf((double) mtopStatistics.buildParams2NetworkTime));
                            hashMap2.put("startCallBack2EndTime", Double.valueOf((double) mtopStatistics.startCallBack2EndTime));
                            hashMap2.put("signTime", Double.valueOf((double) mtopStatistics.computeSignTime));
                            hashMap2.put("wuaTime", Double.valueOf((double) mtopStatistics.computeWuaTime));
                            hashMap2.put("miniWuaTime", Double.valueOf((double) mtopStatistics.computeMiniWuaTime));
                            hashMap2.put("callbackPocTime", Double.valueOf((double) mtopStatistics.callbackPocTime));
                            hashMap2.put("allTime", Double.valueOf((double) mtopStatistics.allTime));
                            hashMap2.put("requestPocTime", Double.valueOf((double) mtopStatistics.requestPocTime));
                            if (networkStats != null) {
                            }
                            rbStatisticData = mtopStatistics.c;
                            if (rbStatisticData != null) {
                            }
                            iUploadStats = mtopStatistics.e;
                            if (iUploadStats != null) {
                            }
                            if (!ErrorConstant.isSuccess(mtopStatistics.retCode)) {
                            }
                            HashMap hashMap3 = new HashMap();
                            hashMap3.put("bizId", !TextUtils.isEmpty(mtopStatistics.bizIdStr) ? mtopStatistics.bizIdStr : String.valueOf(mtopStatistics.bizId));
                            hashMap3.put("api", mtopStatistics.apiKey);
                            hashMap3.put("version", mtopStatistics.apiKey);
                            hashMap3.put("domain", mtopStatistics.domain);
                            hashMap3.put("httpResponseStatus", String.valueOf(mtopStatistics.statusCode));
                            hashMap3.put("ret", mtopStatistics.retCode);
                            hashMap3.put("bxSessionId", mtopStatistics.bxSessionId);
                            hashMap3.put("bxUI", String.valueOf(mtopStatistics.bxUI));
                            hashMap3.put("bxMainAction", String.valueOf(mtopStatistics.bxMainAction));
                            hashMap3.put("bxSubAction", String.valueOf(mtopStatistics.bxSubAction));
                            hashMap3.put("bxRetry", String.valueOf(mtopStatistics.bxRetry));
                            HashMap hashMap4 = new HashMap();
                            hashMap4.put("bxSleep", Double.valueOf((double) mtopStatistics.bxSleep));
                            hashMap4.put("checkTime", Double.valueOf((double) (mtopStatistics.fcProcessCheckEndTime - mtopStatistics.fcProcessCheckStartTime)));
                            hashMap4.put(obj, Double.valueOf((double) (mtopStatistics.fcProcessCallbackTime - mtopStatistics.fcProcessStartTime)));
                            iUploadStats2 = mtopStatistics.e;
                            if (iUploadStats2 != null) {
                            }
                            mtopStatistics.commitStat = false;
                        }
                        try {
                            hashSet2.add(obj);
                            obj = obj;
                            hashSet2.add("firstDataTime");
                            hashSet2.add("recDataTime");
                            hashSet2.add("revSize");
                            hashSet2.add("dataSpeed");
                            hashSet2.add("oneWayTime_ANet");
                            hashSet2.add("serverRT");
                            mtopStatistics = this;
                            obj4 = obj14;
                            try {
                                IUploadStats iUploadStats3 = mtopStatistics.e;
                                if (iUploadStats3 != null) {
                                    try {
                                        iUploadStats3.onRegister("mtopsdk", "mtopStats", hashSet, hashSet2, false);
                                    } catch (Throwable th13) {
                                        th2 = th13;
                                    }
                                }
                                HashSet hashSet3 = new HashSet();
                                hashSet3.add("api");
                                hashSet3.add("domain");
                                hashSet3.add("ret");
                                hashSet3.add("retType");
                                hashSet3.add("reqSource");
                                hashSet3.add("mappingCode");
                                hashSet3.add("httpResponseStatus");
                                hashSet3.add("refer");
                                hashSet3.add("clientTraceId");
                                hashSet3.add("serverTraceId");
                                hashSet3.add("pageName");
                                hashSet3.add("pageUrl");
                                hashSet3.add(obj13);
                                obj14 = obj4;
                                try {
                                    hashSet3.add(obj14);
                                    IUploadStats iUploadStats4 = mtopStatistics.e;
                                    if (iUploadStats4 != null) {
                                        try {
                                            iUploadStats4.onRegister("mtopsdk", "mtopExceptions", hashSet3, null, false);
                                        } catch (Throwable th14) {
                                            th2 = th14;
                                            obj4 = obj14;
                                        }
                                    }
                                    HashSet hashSet4 = new HashSet();
                                    hashSet4.add("bizId");
                                    hashSet4.add("api");
                                    hashSet4.add("version");
                                    hashSet4.add("domain");
                                    hashSet4.add("httpResponseStatus");
                                    hashSet4.add("ret");
                                    hashSet4.add("bxSessionId");
                                    hashSet4.add("bxUI");
                                    hashSet4.add("bxMainAction");
                                    hashSet4.add("bxSubAction");
                                    hashSet4.add("bxRetry");
                                    HashSet hashSet5 = new HashSet();
                                    obj4 = obj14;
                                    hashSet5.add("bxSleep");
                                    hashSet5.add("checkTime");
                                    try {
                                        hashSet5.add(obj);
                                        obj = obj;
                                        IUploadStats iUploadStats5 = mtopStatistics.e;
                                        if (iUploadStats5 != null) {
                                            iUploadStats5.onRegister("mtopsdk", "baxiaAction", hashSet4, hashSet5, false);
                                        }
                                        str4 = mtopStatistics.seqNo;
                                        str = "mtopsdk.MtopStatistics";
                                    } catch (Throwable th15) {
                                        th3 = th15;
                                        obj = obj;
                                        str = "mtopsdk.MtopStatistics";
                                        th2 = th3;
                                        String str5 = mtopStatistics.seqNo;
                                        obj6 = obj13;
                                        obj5 = "pageUrl";
                                        TBSdkLog.e(str, str5, "[registerMtopStats] register MtopStats error ---" + th2.toString());
                                        hashMap = new HashMap();
                                        hashMap.put("api", mtopStatistics.apiKey);
                                        hashMap.put("ret", mtopStatistics.retCode);
                                        hashMap.put("retType", String.valueOf(mtopStatistics.retType));
                                        hashMap.put("httpResponseStatus", String.valueOf(mtopStatistics.statusCode));
                                        hashMap.put("domain", mtopStatistics.domain);
                                        hashMap.put("reqSource", String.valueOf(mtopStatistics.reqSource));
                                        hashMap.put(obj8, String.valueOf(mtopStatistics.cacheSwitch));
                                        hashMap.put(obj7, String.valueOf(mtopStatistics.cacheHitType));
                                        hashMap.put("clientTraceId", mtopStatistics.clientTraceId);
                                        hashMap.put("serverTraceId", mtopStatistics.serverTraceId);
                                        hashMap.put("pageName", mtopStatistics.pageName);
                                        hashMap.put(obj5, mtopStatistics.pageUrl);
                                        hashMap.put(obj6, String.valueOf(mtopStatistics.backGround ? 1 : 0));
                                        str2 = str;
                                        hashMap.put(obj3, String.valueOf(mtopStatistics.isMain ? 1 : 0));
                                        hashMap.put(obj4, String.valueOf(RemoteConfig.getInstance().useSecurityAdapter));
                                        hashMap.put(obj2, String.valueOf(mtopStatistics.isPrefetch ? 1 : 0));
                                        hashMap.put("handler", String.valueOf(mtopStatistics.handler ? 1 : 0));
                                        networkStats = getNetworkStats();
                                        if (networkStats != null) {
                                        }
                                        if (Mtop.mIsFullTrackValid) {
                                        }
                                        HashMap hashMap2 = new HashMap();
                                        hashMap2.put("totalTime", Double.valueOf((double) mtopStatistics.totalTime));
                                        hashMap2.put("networkExeTime", Double.valueOf((double) mtopStatistics.netTotalTime));
                                        hashMap2.put("cacheCostTime", Double.valueOf((double) mtopStatistics.cacheCostTime));
                                        hashMap2.put("cacheResponseParseTime", Double.valueOf((double) mtopStatistics.cacheResponseParseTime));
                                        hashMap2.put("waitExecuteTime", Double.valueOf((double) mtopStatistics.waitExecuteTime));
                                        hashMap2.put("waitCallbackTime", Double.valueOf((double) mtopStatistics.waitCallbackTime));
                                        hashMap2.put("waitExecute2BuildParamTime", Double.valueOf((double) mtopStatistics.waitExecute2BuildParamTime));
                                        hashMap2.put("buildParamsTime", Double.valueOf((double) mtopStatistics.buildParamsTime));
                                        hashMap2.put("buildParams2NetworkTime", Double.valueOf((double) mtopStatistics.buildParams2NetworkTime));
                                        hashMap2.put("startCallBack2EndTime", Double.valueOf((double) mtopStatistics.startCallBack2EndTime));
                                        hashMap2.put("signTime", Double.valueOf((double) mtopStatistics.computeSignTime));
                                        hashMap2.put("wuaTime", Double.valueOf((double) mtopStatistics.computeWuaTime));
                                        hashMap2.put("miniWuaTime", Double.valueOf((double) mtopStatistics.computeMiniWuaTime));
                                        hashMap2.put("callbackPocTime", Double.valueOf((double) mtopStatistics.callbackPocTime));
                                        hashMap2.put("allTime", Double.valueOf((double) mtopStatistics.allTime));
                                        hashMap2.put("requestPocTime", Double.valueOf((double) mtopStatistics.requestPocTime));
                                        if (networkStats != null) {
                                        }
                                        rbStatisticData = mtopStatistics.c;
                                        if (rbStatisticData != null) {
                                        }
                                        iUploadStats = mtopStatistics.e;
                                        if (iUploadStats != null) {
                                        }
                                        if (!ErrorConstant.isSuccess(mtopStatistics.retCode)) {
                                        }
                                        HashMap hashMap3 = new HashMap();
                                        hashMap3.put("bizId", !TextUtils.isEmpty(mtopStatistics.bizIdStr) ? mtopStatistics.bizIdStr : String.valueOf(mtopStatistics.bizId));
                                        hashMap3.put("api", mtopStatistics.apiKey);
                                        hashMap3.put("version", mtopStatistics.apiKey);
                                        hashMap3.put("domain", mtopStatistics.domain);
                                        hashMap3.put("httpResponseStatus", String.valueOf(mtopStatistics.statusCode));
                                        hashMap3.put("ret", mtopStatistics.retCode);
                                        hashMap3.put("bxSessionId", mtopStatistics.bxSessionId);
                                        hashMap3.put("bxUI", String.valueOf(mtopStatistics.bxUI));
                                        hashMap3.put("bxMainAction", String.valueOf(mtopStatistics.bxMainAction));
                                        hashMap3.put("bxSubAction", String.valueOf(mtopStatistics.bxSubAction));
                                        hashMap3.put("bxRetry", String.valueOf(mtopStatistics.bxRetry));
                                        HashMap hashMap4 = new HashMap();
                                        hashMap4.put("bxSleep", Double.valueOf((double) mtopStatistics.bxSleep));
                                        hashMap4.put("checkTime", Double.valueOf((double) (mtopStatistics.fcProcessCheckEndTime - mtopStatistics.fcProcessCheckStartTime)));
                                        hashMap4.put(obj, Double.valueOf((double) (mtopStatistics.fcProcessCallbackTime - mtopStatistics.fcProcessStartTime)));
                                        iUploadStats2 = mtopStatistics.e;
                                        if (iUploadStats2 != null) {
                                        }
                                        mtopStatistics.commitStat = false;
                                    }
                                } catch (Throwable th16) {
                                    th3 = th16;
                                    obj4 = obj14;
                                    str = "mtopsdk.MtopStatistics";
                                    th2 = th3;
                                    String str5 = mtopStatistics.seqNo;
                                    obj6 = obj13;
                                    obj5 = "pageUrl";
                                    TBSdkLog.e(str, str5, "[registerMtopStats] register MtopStats error ---" + th2.toString());
                                    hashMap = new HashMap();
                                    hashMap.put("api", mtopStatistics.apiKey);
                                    hashMap.put("ret", mtopStatistics.retCode);
                                    hashMap.put("retType", String.valueOf(mtopStatistics.retType));
                                    hashMap.put("httpResponseStatus", String.valueOf(mtopStatistics.statusCode));
                                    hashMap.put("domain", mtopStatistics.domain);
                                    hashMap.put("reqSource", String.valueOf(mtopStatistics.reqSource));
                                    hashMap.put(obj8, String.valueOf(mtopStatistics.cacheSwitch));
                                    hashMap.put(obj7, String.valueOf(mtopStatistics.cacheHitType));
                                    hashMap.put("clientTraceId", mtopStatistics.clientTraceId);
                                    hashMap.put("serverTraceId", mtopStatistics.serverTraceId);
                                    hashMap.put("pageName", mtopStatistics.pageName);
                                    hashMap.put(obj5, mtopStatistics.pageUrl);
                                    hashMap.put(obj6, String.valueOf(mtopStatistics.backGround ? 1 : 0));
                                    str2 = str;
                                    hashMap.put(obj3, String.valueOf(mtopStatistics.isMain ? 1 : 0));
                                    hashMap.put(obj4, String.valueOf(RemoteConfig.getInstance().useSecurityAdapter));
                                    hashMap.put(obj2, String.valueOf(mtopStatistics.isPrefetch ? 1 : 0));
                                    hashMap.put("handler", String.valueOf(mtopStatistics.handler ? 1 : 0));
                                    networkStats = getNetworkStats();
                                    if (networkStats != null) {
                                    }
                                    if (Mtop.mIsFullTrackValid) {
                                    }
                                    HashMap hashMap2 = new HashMap();
                                    hashMap2.put("totalTime", Double.valueOf((double) mtopStatistics.totalTime));
                                    hashMap2.put("networkExeTime", Double.valueOf((double) mtopStatistics.netTotalTime));
                                    hashMap2.put("cacheCostTime", Double.valueOf((double) mtopStatistics.cacheCostTime));
                                    hashMap2.put("cacheResponseParseTime", Double.valueOf((double) mtopStatistics.cacheResponseParseTime));
                                    hashMap2.put("waitExecuteTime", Double.valueOf((double) mtopStatistics.waitExecuteTime));
                                    hashMap2.put("waitCallbackTime", Double.valueOf((double) mtopStatistics.waitCallbackTime));
                                    hashMap2.put("waitExecute2BuildParamTime", Double.valueOf((double) mtopStatistics.waitExecute2BuildParamTime));
                                    hashMap2.put("buildParamsTime", Double.valueOf((double) mtopStatistics.buildParamsTime));
                                    hashMap2.put("buildParams2NetworkTime", Double.valueOf((double) mtopStatistics.buildParams2NetworkTime));
                                    hashMap2.put("startCallBack2EndTime", Double.valueOf((double) mtopStatistics.startCallBack2EndTime));
                                    hashMap2.put("signTime", Double.valueOf((double) mtopStatistics.computeSignTime));
                                    hashMap2.put("wuaTime", Double.valueOf((double) mtopStatistics.computeWuaTime));
                                    hashMap2.put("miniWuaTime", Double.valueOf((double) mtopStatistics.computeMiniWuaTime));
                                    hashMap2.put("callbackPocTime", Double.valueOf((double) mtopStatistics.callbackPocTime));
                                    hashMap2.put("allTime", Double.valueOf((double) mtopStatistics.allTime));
                                    hashMap2.put("requestPocTime", Double.valueOf((double) mtopStatistics.requestPocTime));
                                    if (networkStats != null) {
                                    }
                                    rbStatisticData = mtopStatistics.c;
                                    if (rbStatisticData != null) {
                                    }
                                    iUploadStats = mtopStatistics.e;
                                    if (iUploadStats != null) {
                                    }
                                    if (!ErrorConstant.isSuccess(mtopStatistics.retCode)) {
                                    }
                                    HashMap hashMap3 = new HashMap();
                                    hashMap3.put("bizId", !TextUtils.isEmpty(mtopStatistics.bizIdStr) ? mtopStatistics.bizIdStr : String.valueOf(mtopStatistics.bizId));
                                    hashMap3.put("api", mtopStatistics.apiKey);
                                    hashMap3.put("version", mtopStatistics.apiKey);
                                    hashMap3.put("domain", mtopStatistics.domain);
                                    hashMap3.put("httpResponseStatus", String.valueOf(mtopStatistics.statusCode));
                                    hashMap3.put("ret", mtopStatistics.retCode);
                                    hashMap3.put("bxSessionId", mtopStatistics.bxSessionId);
                                    hashMap3.put("bxUI", String.valueOf(mtopStatistics.bxUI));
                                    hashMap3.put("bxMainAction", String.valueOf(mtopStatistics.bxMainAction));
                                    hashMap3.put("bxSubAction", String.valueOf(mtopStatistics.bxSubAction));
                                    hashMap3.put("bxRetry", String.valueOf(mtopStatistics.bxRetry));
                                    HashMap hashMap4 = new HashMap();
                                    hashMap4.put("bxSleep", Double.valueOf((double) mtopStatistics.bxSleep));
                                    hashMap4.put("checkTime", Double.valueOf((double) (mtopStatistics.fcProcessCheckEndTime - mtopStatistics.fcProcessCheckStartTime)));
                                    hashMap4.put(obj, Double.valueOf((double) (mtopStatistics.fcProcessCallbackTime - mtopStatistics.fcProcessStartTime)));
                                    iUploadStats2 = mtopStatistics.e;
                                    if (iUploadStats2 != null) {
                                    }
                                    mtopStatistics.commitStat = false;
                                }
                            } catch (Throwable th17) {
                                th3 = th17;
                                str = "mtopsdk.MtopStatistics";
                                th2 = th3;
                                String str5 = mtopStatistics.seqNo;
                                obj6 = obj13;
                                obj5 = "pageUrl";
                                TBSdkLog.e(str, str5, "[registerMtopStats] register MtopStats error ---" + th2.toString());
                                hashMap = new HashMap();
                                hashMap.put("api", mtopStatistics.apiKey);
                                hashMap.put("ret", mtopStatistics.retCode);
                                hashMap.put("retType", String.valueOf(mtopStatistics.retType));
                                hashMap.put("httpResponseStatus", String.valueOf(mtopStatistics.statusCode));
                                hashMap.put("domain", mtopStatistics.domain);
                                hashMap.put("reqSource", String.valueOf(mtopStatistics.reqSource));
                                hashMap.put(obj8, String.valueOf(mtopStatistics.cacheSwitch));
                                hashMap.put(obj7, String.valueOf(mtopStatistics.cacheHitType));
                                hashMap.put("clientTraceId", mtopStatistics.clientTraceId);
                                hashMap.put("serverTraceId", mtopStatistics.serverTraceId);
                                hashMap.put("pageName", mtopStatistics.pageName);
                                hashMap.put(obj5, mtopStatistics.pageUrl);
                                hashMap.put(obj6, String.valueOf(mtopStatistics.backGround ? 1 : 0));
                                str2 = str;
                                hashMap.put(obj3, String.valueOf(mtopStatistics.isMain ? 1 : 0));
                                hashMap.put(obj4, String.valueOf(RemoteConfig.getInstance().useSecurityAdapter));
                                hashMap.put(obj2, String.valueOf(mtopStatistics.isPrefetch ? 1 : 0));
                                hashMap.put("handler", String.valueOf(mtopStatistics.handler ? 1 : 0));
                                networkStats = getNetworkStats();
                                if (networkStats != null) {
                                }
                                if (Mtop.mIsFullTrackValid) {
                                }
                                HashMap hashMap2 = new HashMap();
                                hashMap2.put("totalTime", Double.valueOf((double) mtopStatistics.totalTime));
                                hashMap2.put("networkExeTime", Double.valueOf((double) mtopStatistics.netTotalTime));
                                hashMap2.put("cacheCostTime", Double.valueOf((double) mtopStatistics.cacheCostTime));
                                hashMap2.put("cacheResponseParseTime", Double.valueOf((double) mtopStatistics.cacheResponseParseTime));
                                hashMap2.put("waitExecuteTime", Double.valueOf((double) mtopStatistics.waitExecuteTime));
                                hashMap2.put("waitCallbackTime", Double.valueOf((double) mtopStatistics.waitCallbackTime));
                                hashMap2.put("waitExecute2BuildParamTime", Double.valueOf((double) mtopStatistics.waitExecute2BuildParamTime));
                                hashMap2.put("buildParamsTime", Double.valueOf((double) mtopStatistics.buildParamsTime));
                                hashMap2.put("buildParams2NetworkTime", Double.valueOf((double) mtopStatistics.buildParams2NetworkTime));
                                hashMap2.put("startCallBack2EndTime", Double.valueOf((double) mtopStatistics.startCallBack2EndTime));
                                hashMap2.put("signTime", Double.valueOf((double) mtopStatistics.computeSignTime));
                                hashMap2.put("wuaTime", Double.valueOf((double) mtopStatistics.computeWuaTime));
                                hashMap2.put("miniWuaTime", Double.valueOf((double) mtopStatistics.computeMiniWuaTime));
                                hashMap2.put("callbackPocTime", Double.valueOf((double) mtopStatistics.callbackPocTime));
                                hashMap2.put("allTime", Double.valueOf((double) mtopStatistics.allTime));
                                hashMap2.put("requestPocTime", Double.valueOf((double) mtopStatistics.requestPocTime));
                                if (networkStats != null) {
                                }
                                rbStatisticData = mtopStatistics.c;
                                if (rbStatisticData != null) {
                                }
                                iUploadStats = mtopStatistics.e;
                                if (iUploadStats != null) {
                                }
                                if (!ErrorConstant.isSuccess(mtopStatistics.retCode)) {
                                }
                                HashMap hashMap3 = new HashMap();
                                hashMap3.put("bizId", !TextUtils.isEmpty(mtopStatistics.bizIdStr) ? mtopStatistics.bizIdStr : String.valueOf(mtopStatistics.bizId));
                                hashMap3.put("api", mtopStatistics.apiKey);
                                hashMap3.put("version", mtopStatistics.apiKey);
                                hashMap3.put("domain", mtopStatistics.domain);
                                hashMap3.put("httpResponseStatus", String.valueOf(mtopStatistics.statusCode));
                                hashMap3.put("ret", mtopStatistics.retCode);
                                hashMap3.put("bxSessionId", mtopStatistics.bxSessionId);
                                hashMap3.put("bxUI", String.valueOf(mtopStatistics.bxUI));
                                hashMap3.put("bxMainAction", String.valueOf(mtopStatistics.bxMainAction));
                                hashMap3.put("bxSubAction", String.valueOf(mtopStatistics.bxSubAction));
                                hashMap3.put("bxRetry", String.valueOf(mtopStatistics.bxRetry));
                                HashMap hashMap4 = new HashMap();
                                hashMap4.put("bxSleep", Double.valueOf((double) mtopStatistics.bxSleep));
                                hashMap4.put("checkTime", Double.valueOf((double) (mtopStatistics.fcProcessCheckEndTime - mtopStatistics.fcProcessCheckStartTime)));
                                hashMap4.put(obj, Double.valueOf((double) (mtopStatistics.fcProcessCallbackTime - mtopStatistics.fcProcessStartTime)));
                                iUploadStats2 = mtopStatistics.e;
                                if (iUploadStats2 != null) {
                                }
                                mtopStatistics.commitStat = false;
                            }
                            try {
                                TBSdkLog.i(str, str4, "[registerMtopStats]register MtopStats executed.uploadStats=" + mtopStatistics.e);
                                obj6 = obj13;
                                obj5 = "pageUrl";
                            } catch (Throwable th18) {
                                th3 = th18;
                                th2 = th3;
                                String str5 = mtopStatistics.seqNo;
                                obj6 = obj13;
                                obj5 = "pageUrl";
                                TBSdkLog.e(str, str5, "[registerMtopStats] register MtopStats error ---" + th2.toString());
                                hashMap = new HashMap();
                                hashMap.put("api", mtopStatistics.apiKey);
                                hashMap.put("ret", mtopStatistics.retCode);
                                hashMap.put("retType", String.valueOf(mtopStatistics.retType));
                                hashMap.put("httpResponseStatus", String.valueOf(mtopStatistics.statusCode));
                                hashMap.put("domain", mtopStatistics.domain);
                                hashMap.put("reqSource", String.valueOf(mtopStatistics.reqSource));
                                hashMap.put(obj8, String.valueOf(mtopStatistics.cacheSwitch));
                                hashMap.put(obj7, String.valueOf(mtopStatistics.cacheHitType));
                                hashMap.put("clientTraceId", mtopStatistics.clientTraceId);
                                hashMap.put("serverTraceId", mtopStatistics.serverTraceId);
                                hashMap.put("pageName", mtopStatistics.pageName);
                                hashMap.put(obj5, mtopStatistics.pageUrl);
                                hashMap.put(obj6, String.valueOf(mtopStatistics.backGround ? 1 : 0));
                                str2 = str;
                                hashMap.put(obj3, String.valueOf(mtopStatistics.isMain ? 1 : 0));
                                hashMap.put(obj4, String.valueOf(RemoteConfig.getInstance().useSecurityAdapter));
                                hashMap.put(obj2, String.valueOf(mtopStatistics.isPrefetch ? 1 : 0));
                                hashMap.put("handler", String.valueOf(mtopStatistics.handler ? 1 : 0));
                                networkStats = getNetworkStats();
                                if (networkStats != null) {
                                }
                                if (Mtop.mIsFullTrackValid) {
                                }
                                HashMap hashMap2 = new HashMap();
                                hashMap2.put("totalTime", Double.valueOf((double) mtopStatistics.totalTime));
                                hashMap2.put("networkExeTime", Double.valueOf((double) mtopStatistics.netTotalTime));
                                hashMap2.put("cacheCostTime", Double.valueOf((double) mtopStatistics.cacheCostTime));
                                hashMap2.put("cacheResponseParseTime", Double.valueOf((double) mtopStatistics.cacheResponseParseTime));
                                hashMap2.put("waitExecuteTime", Double.valueOf((double) mtopStatistics.waitExecuteTime));
                                hashMap2.put("waitCallbackTime", Double.valueOf((double) mtopStatistics.waitCallbackTime));
                                hashMap2.put("waitExecute2BuildParamTime", Double.valueOf((double) mtopStatistics.waitExecute2BuildParamTime));
                                hashMap2.put("buildParamsTime", Double.valueOf((double) mtopStatistics.buildParamsTime));
                                hashMap2.put("buildParams2NetworkTime", Double.valueOf((double) mtopStatistics.buildParams2NetworkTime));
                                hashMap2.put("startCallBack2EndTime", Double.valueOf((double) mtopStatistics.startCallBack2EndTime));
                                hashMap2.put("signTime", Double.valueOf((double) mtopStatistics.computeSignTime));
                                hashMap2.put("wuaTime", Double.valueOf((double) mtopStatistics.computeWuaTime));
                                hashMap2.put("miniWuaTime", Double.valueOf((double) mtopStatistics.computeMiniWuaTime));
                                hashMap2.put("callbackPocTime", Double.valueOf((double) mtopStatistics.callbackPocTime));
                                hashMap2.put("allTime", Double.valueOf((double) mtopStatistics.allTime));
                                hashMap2.put("requestPocTime", Double.valueOf((double) mtopStatistics.requestPocTime));
                                if (networkStats != null) {
                                }
                                rbStatisticData = mtopStatistics.c;
                                if (rbStatisticData != null) {
                                }
                                iUploadStats = mtopStatistics.e;
                                if (iUploadStats != null) {
                                }
                                if (!ErrorConstant.isSuccess(mtopStatistics.retCode)) {
                                }
                                HashMap hashMap3 = new HashMap();
                                hashMap3.put("bizId", !TextUtils.isEmpty(mtopStatistics.bizIdStr) ? mtopStatistics.bizIdStr : String.valueOf(mtopStatistics.bizId));
                                hashMap3.put("api", mtopStatistics.apiKey);
                                hashMap3.put("version", mtopStatistics.apiKey);
                                hashMap3.put("domain", mtopStatistics.domain);
                                hashMap3.put("httpResponseStatus", String.valueOf(mtopStatistics.statusCode));
                                hashMap3.put("ret", mtopStatistics.retCode);
                                hashMap3.put("bxSessionId", mtopStatistics.bxSessionId);
                                hashMap3.put("bxUI", String.valueOf(mtopStatistics.bxUI));
                                hashMap3.put("bxMainAction", String.valueOf(mtopStatistics.bxMainAction));
                                hashMap3.put("bxSubAction", String.valueOf(mtopStatistics.bxSubAction));
                                hashMap3.put("bxRetry", String.valueOf(mtopStatistics.bxRetry));
                                HashMap hashMap4 = new HashMap();
                                hashMap4.put("bxSleep", Double.valueOf((double) mtopStatistics.bxSleep));
                                hashMap4.put("checkTime", Double.valueOf((double) (mtopStatistics.fcProcessCheckEndTime - mtopStatistics.fcProcessCheckStartTime)));
                                hashMap4.put(obj, Double.valueOf((double) (mtopStatistics.fcProcessCallbackTime - mtopStatistics.fcProcessStartTime)));
                                iUploadStats2 = mtopStatistics.e;
                                if (iUploadStats2 != null) {
                                }
                                mtopStatistics.commitStat = false;
                            }
                        } catch (Throwable th19) {
                            th3 = th19;
                            obj4 = obj14;
                            obj = obj;
                            str = "mtopsdk.MtopStatistics";
                            mtopStatistics = this;
                            th2 = th3;
                            String str5 = mtopStatistics.seqNo;
                            obj6 = obj13;
                            obj5 = "pageUrl";
                            TBSdkLog.e(str, str5, "[registerMtopStats] register MtopStats error ---" + th2.toString());
                            hashMap = new HashMap();
                            hashMap.put("api", mtopStatistics.apiKey);
                            hashMap.put("ret", mtopStatistics.retCode);
                            hashMap.put("retType", String.valueOf(mtopStatistics.retType));
                            hashMap.put("httpResponseStatus", String.valueOf(mtopStatistics.statusCode));
                            hashMap.put("domain", mtopStatistics.domain);
                            hashMap.put("reqSource", String.valueOf(mtopStatistics.reqSource));
                            hashMap.put(obj8, String.valueOf(mtopStatistics.cacheSwitch));
                            hashMap.put(obj7, String.valueOf(mtopStatistics.cacheHitType));
                            hashMap.put("clientTraceId", mtopStatistics.clientTraceId);
                            hashMap.put("serverTraceId", mtopStatistics.serverTraceId);
                            hashMap.put("pageName", mtopStatistics.pageName);
                            hashMap.put(obj5, mtopStatistics.pageUrl);
                            hashMap.put(obj6, String.valueOf(mtopStatistics.backGround ? 1 : 0));
                            str2 = str;
                            hashMap.put(obj3, String.valueOf(mtopStatistics.isMain ? 1 : 0));
                            hashMap.put(obj4, String.valueOf(RemoteConfig.getInstance().useSecurityAdapter));
                            hashMap.put(obj2, String.valueOf(mtopStatistics.isPrefetch ? 1 : 0));
                            hashMap.put("handler", String.valueOf(mtopStatistics.handler ? 1 : 0));
                            networkStats = getNetworkStats();
                            if (networkStats != null) {
                            }
                            if (Mtop.mIsFullTrackValid) {
                            }
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put("totalTime", Double.valueOf((double) mtopStatistics.totalTime));
                            hashMap2.put("networkExeTime", Double.valueOf((double) mtopStatistics.netTotalTime));
                            hashMap2.put("cacheCostTime", Double.valueOf((double) mtopStatistics.cacheCostTime));
                            hashMap2.put("cacheResponseParseTime", Double.valueOf((double) mtopStatistics.cacheResponseParseTime));
                            hashMap2.put("waitExecuteTime", Double.valueOf((double) mtopStatistics.waitExecuteTime));
                            hashMap2.put("waitCallbackTime", Double.valueOf((double) mtopStatistics.waitCallbackTime));
                            hashMap2.put("waitExecute2BuildParamTime", Double.valueOf((double) mtopStatistics.waitExecute2BuildParamTime));
                            hashMap2.put("buildParamsTime", Double.valueOf((double) mtopStatistics.buildParamsTime));
                            hashMap2.put("buildParams2NetworkTime", Double.valueOf((double) mtopStatistics.buildParams2NetworkTime));
                            hashMap2.put("startCallBack2EndTime", Double.valueOf((double) mtopStatistics.startCallBack2EndTime));
                            hashMap2.put("signTime", Double.valueOf((double) mtopStatistics.computeSignTime));
                            hashMap2.put("wuaTime", Double.valueOf((double) mtopStatistics.computeWuaTime));
                            hashMap2.put("miniWuaTime", Double.valueOf((double) mtopStatistics.computeMiniWuaTime));
                            hashMap2.put("callbackPocTime", Double.valueOf((double) mtopStatistics.callbackPocTime));
                            hashMap2.put("allTime", Double.valueOf((double) mtopStatistics.allTime));
                            hashMap2.put("requestPocTime", Double.valueOf((double) mtopStatistics.requestPocTime));
                            if (networkStats != null) {
                            }
                            rbStatisticData = mtopStatistics.c;
                            if (rbStatisticData != null) {
                            }
                            iUploadStats = mtopStatistics.e;
                            if (iUploadStats != null) {
                            }
                            if (!ErrorConstant.isSuccess(mtopStatistics.retCode)) {
                            }
                            HashMap hashMap3 = new HashMap();
                            hashMap3.put("bizId", !TextUtils.isEmpty(mtopStatistics.bizIdStr) ? mtopStatistics.bizIdStr : String.valueOf(mtopStatistics.bizId));
                            hashMap3.put("api", mtopStatistics.apiKey);
                            hashMap3.put("version", mtopStatistics.apiKey);
                            hashMap3.put("domain", mtopStatistics.domain);
                            hashMap3.put("httpResponseStatus", String.valueOf(mtopStatistics.statusCode));
                            hashMap3.put("ret", mtopStatistics.retCode);
                            hashMap3.put("bxSessionId", mtopStatistics.bxSessionId);
                            hashMap3.put("bxUI", String.valueOf(mtopStatistics.bxUI));
                            hashMap3.put("bxMainAction", String.valueOf(mtopStatistics.bxMainAction));
                            hashMap3.put("bxSubAction", String.valueOf(mtopStatistics.bxSubAction));
                            hashMap3.put("bxRetry", String.valueOf(mtopStatistics.bxRetry));
                            HashMap hashMap4 = new HashMap();
                            hashMap4.put("bxSleep", Double.valueOf((double) mtopStatistics.bxSleep));
                            hashMap4.put("checkTime", Double.valueOf((double) (mtopStatistics.fcProcessCheckEndTime - mtopStatistics.fcProcessCheckStartTime)));
                            hashMap4.put(obj, Double.valueOf((double) (mtopStatistics.fcProcessCallbackTime - mtopStatistics.fcProcessStartTime)));
                            iUploadStats2 = mtopStatistics.e;
                            if (iUploadStats2 != null) {
                            }
                            mtopStatistics.commitStat = false;
                        }
                    }
                } catch (Throwable th20) {
                    th3 = th20;
                    obj4 = "securityFeature";
                    obj13 = "backGround";
                    obj7 = "cacheHitType";
                    obj8 = "cacheSwitch";
                    str = "mtopsdk.MtopStatistics";
                    mtopStatistics = this;
                    th2 = th3;
                    String str5 = mtopStatistics.seqNo;
                    obj6 = obj13;
                    obj5 = "pageUrl";
                    TBSdkLog.e(str, str5, "[registerMtopStats] register MtopStats error ---" + th2.toString());
                    hashMap = new HashMap();
                    hashMap.put("api", mtopStatistics.apiKey);
                    hashMap.put("ret", mtopStatistics.retCode);
                    hashMap.put("retType", String.valueOf(mtopStatistics.retType));
                    hashMap.put("httpResponseStatus", String.valueOf(mtopStatistics.statusCode));
                    hashMap.put("domain", mtopStatistics.domain);
                    hashMap.put("reqSource", String.valueOf(mtopStatistics.reqSource));
                    hashMap.put(obj8, String.valueOf(mtopStatistics.cacheSwitch));
                    hashMap.put(obj7, String.valueOf(mtopStatistics.cacheHitType));
                    hashMap.put("clientTraceId", mtopStatistics.clientTraceId);
                    hashMap.put("serverTraceId", mtopStatistics.serverTraceId);
                    hashMap.put("pageName", mtopStatistics.pageName);
                    hashMap.put(obj5, mtopStatistics.pageUrl);
                    hashMap.put(obj6, String.valueOf(mtopStatistics.backGround ? 1 : 0));
                    str2 = str;
                    hashMap.put(obj3, String.valueOf(mtopStatistics.isMain ? 1 : 0));
                    hashMap.put(obj4, String.valueOf(RemoteConfig.getInstance().useSecurityAdapter));
                    hashMap.put(obj2, String.valueOf(mtopStatistics.isPrefetch ? 1 : 0));
                    hashMap.put("handler", String.valueOf(mtopStatistics.handler ? 1 : 0));
                    networkStats = getNetworkStats();
                    if (networkStats != null) {
                    }
                    if (Mtop.mIsFullTrackValid) {
                    }
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("totalTime", Double.valueOf((double) mtopStatistics.totalTime));
                    hashMap2.put("networkExeTime", Double.valueOf((double) mtopStatistics.netTotalTime));
                    hashMap2.put("cacheCostTime", Double.valueOf((double) mtopStatistics.cacheCostTime));
                    hashMap2.put("cacheResponseParseTime", Double.valueOf((double) mtopStatistics.cacheResponseParseTime));
                    hashMap2.put("waitExecuteTime", Double.valueOf((double) mtopStatistics.waitExecuteTime));
                    hashMap2.put("waitCallbackTime", Double.valueOf((double) mtopStatistics.waitCallbackTime));
                    hashMap2.put("waitExecute2BuildParamTime", Double.valueOf((double) mtopStatistics.waitExecute2BuildParamTime));
                    hashMap2.put("buildParamsTime", Double.valueOf((double) mtopStatistics.buildParamsTime));
                    hashMap2.put("buildParams2NetworkTime", Double.valueOf((double) mtopStatistics.buildParams2NetworkTime));
                    hashMap2.put("startCallBack2EndTime", Double.valueOf((double) mtopStatistics.startCallBack2EndTime));
                    hashMap2.put("signTime", Double.valueOf((double) mtopStatistics.computeSignTime));
                    hashMap2.put("wuaTime", Double.valueOf((double) mtopStatistics.computeWuaTime));
                    hashMap2.put("miniWuaTime", Double.valueOf((double) mtopStatistics.computeMiniWuaTime));
                    hashMap2.put("callbackPocTime", Double.valueOf((double) mtopStatistics.callbackPocTime));
                    hashMap2.put("allTime", Double.valueOf((double) mtopStatistics.allTime));
                    hashMap2.put("requestPocTime", Double.valueOf((double) mtopStatistics.requestPocTime));
                    if (networkStats != null) {
                    }
                    rbStatisticData = mtopStatistics.c;
                    if (rbStatisticData != null) {
                    }
                    iUploadStats = mtopStatistics.e;
                    if (iUploadStats != null) {
                    }
                    if (!ErrorConstant.isSuccess(mtopStatistics.retCode)) {
                    }
                    HashMap hashMap3 = new HashMap();
                    hashMap3.put("bizId", !TextUtils.isEmpty(mtopStatistics.bizIdStr) ? mtopStatistics.bizIdStr : String.valueOf(mtopStatistics.bizId));
                    hashMap3.put("api", mtopStatistics.apiKey);
                    hashMap3.put("version", mtopStatistics.apiKey);
                    hashMap3.put("domain", mtopStatistics.domain);
                    hashMap3.put("httpResponseStatus", String.valueOf(mtopStatistics.statusCode));
                    hashMap3.put("ret", mtopStatistics.retCode);
                    hashMap3.put("bxSessionId", mtopStatistics.bxSessionId);
                    hashMap3.put("bxUI", String.valueOf(mtopStatistics.bxUI));
                    hashMap3.put("bxMainAction", String.valueOf(mtopStatistics.bxMainAction));
                    hashMap3.put("bxSubAction", String.valueOf(mtopStatistics.bxSubAction));
                    hashMap3.put("bxRetry", String.valueOf(mtopStatistics.bxRetry));
                    HashMap hashMap4 = new HashMap();
                    hashMap4.put("bxSleep", Double.valueOf((double) mtopStatistics.bxSleep));
                    hashMap4.put("checkTime", Double.valueOf((double) (mtopStatistics.fcProcessCheckEndTime - mtopStatistics.fcProcessCheckStartTime)));
                    hashMap4.put(obj, Double.valueOf((double) (mtopStatistics.fcProcessCallbackTime - mtopStatistics.fcProcessStartTime)));
                    iUploadStats2 = mtopStatistics.e;
                    if (iUploadStats2 != null) {
                    }
                    mtopStatistics.commitStat = false;
                }
            } else {
                obj5 = "pageUrl";
                obj4 = "securityFeature";
                obj6 = "backGround";
                obj7 = "cacheHitType";
                obj8 = "cacheSwitch";
                str = "mtopsdk.MtopStatistics";
                mtopStatistics = this;
            }
            try {
                hashMap = new HashMap();
                hashMap.put("api", mtopStatistics.apiKey);
                hashMap.put("ret", mtopStatistics.retCode);
                hashMap.put("retType", String.valueOf(mtopStatistics.retType));
                hashMap.put("httpResponseStatus", String.valueOf(mtopStatistics.statusCode));
                hashMap.put("domain", mtopStatistics.domain);
                hashMap.put("reqSource", String.valueOf(mtopStatistics.reqSource));
                hashMap.put(obj8, String.valueOf(mtopStatistics.cacheSwitch));
                hashMap.put(obj7, String.valueOf(mtopStatistics.cacheHitType));
                hashMap.put("clientTraceId", mtopStatistics.clientTraceId);
                hashMap.put("serverTraceId", mtopStatistics.serverTraceId);
                hashMap.put("pageName", mtopStatistics.pageName);
                hashMap.put(obj5, mtopStatistics.pageUrl);
                hashMap.put(obj6, String.valueOf(mtopStatistics.backGround ? 1 : 0));
                str2 = str;
                try {
                    hashMap.put(obj3, String.valueOf(mtopStatistics.isMain ? 1 : 0));
                    hashMap.put(obj4, String.valueOf(RemoteConfig.getInstance().useSecurityAdapter));
                    hashMap.put(obj2, String.valueOf(mtopStatistics.isPrefetch ? 1 : 0));
                    hashMap.put("handler", String.valueOf(mtopStatistics.handler ? 1 : 0));
                    networkStats = getNetworkStats();
                    if (networkStats != null) {
                        str3 = "0";
                        obj9 = obj6;
                        hashMap.put("connType", networkStats.connectionType);
                        hashMap.put("isSSL", networkStats.isSSL ? "1" : str3);
                        hashMap.put("retryTimes", String.valueOf(networkStats.retryTimes));
                        hashMap.put("ip_port", networkStats.ip_port);
                    } else {
                        str3 = "0";
                        obj9 = obj6;
                    }
                    if (Mtop.mIsFullTrackValid) {
                        obj10 = obj5;
                        hashMap.put("launchType", String.valueOf(SceneIdentifier.getStartType()));
                        hashMap.put("appLaunchExternal", SceneIdentifier.isUrlLaunch() ? "1" : str3);
                        obj12 = "pageName";
                        obj11 = "serverTraceId";
                        hashMap.put("sinceAppLaunchInterval", String.valueOf(mtopStatistics.bizReqStart - SceneIdentifier.getAppLaunchTime()));
                        hashMap.put("deviceLevel", String.valueOf(SceneIdentifier.getDeviceLevel()));
                        if (SceneIdentifier.getStartType() != 1) {
                            hashMap.put("sinceLastLaunchInternal", String.valueOf((int) (SceneIdentifier.getAppLaunchTime() - SceneIdentifier.getLastLaunchTime())));
                        }
                        String tBSpeedBucket = ABTestCenter.getTBSpeedBucket();
                        if (TextUtils.isEmpty(tBSpeedBucket)) {
                            tBSpeedBucket = str3;
                        }
                        hashMap.put("speedBucket", tBSpeedBucket);
                        String uTABTestBucketId = ABTestCenter.getUTABTestBucketId("mtopsdk");
                        if (TextUtils.isEmpty(uTABTestBucketId)) {
                            uTABTestBucketId = str3;
                        }
                        hashMap.put("speedBucketId", uTABTestBucketId);
                    } else {
                        obj10 = obj5;
                        obj12 = "pageName";
                        obj11 = "serverTraceId";
                    }
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("totalTime", Double.valueOf((double) mtopStatistics.totalTime));
                    hashMap2.put("networkExeTime", Double.valueOf((double) mtopStatistics.netTotalTime));
                    hashMap2.put("cacheCostTime", Double.valueOf((double) mtopStatistics.cacheCostTime));
                    hashMap2.put("cacheResponseParseTime", Double.valueOf((double) mtopStatistics.cacheResponseParseTime));
                    hashMap2.put("waitExecuteTime", Double.valueOf((double) mtopStatistics.waitExecuteTime));
                    hashMap2.put("waitCallbackTime", Double.valueOf((double) mtopStatistics.waitCallbackTime));
                    hashMap2.put("waitExecute2BuildParamTime", Double.valueOf((double) mtopStatistics.waitExecute2BuildParamTime));
                    hashMap2.put("buildParamsTime", Double.valueOf((double) mtopStatistics.buildParamsTime));
                    hashMap2.put("buildParams2NetworkTime", Double.valueOf((double) mtopStatistics.buildParams2NetworkTime));
                    hashMap2.put("startCallBack2EndTime", Double.valueOf((double) mtopStatistics.startCallBack2EndTime));
                    hashMap2.put("signTime", Double.valueOf((double) mtopStatistics.computeSignTime));
                    hashMap2.put("wuaTime", Double.valueOf((double) mtopStatistics.computeWuaTime));
                    hashMap2.put("miniWuaTime", Double.valueOf((double) mtopStatistics.computeMiniWuaTime));
                    hashMap2.put("callbackPocTime", Double.valueOf((double) mtopStatistics.callbackPocTime));
                    hashMap2.put("allTime", Double.valueOf((double) mtopStatistics.allTime));
                    hashMap2.put("requestPocTime", Double.valueOf((double) mtopStatistics.requestPocTime));
                    if (networkStats != null) {
                        hashMap2.put(obj, Double.valueOf((double) networkStats.processTime));
                        obj = obj;
                        hashMap2.put("firstDataTime", Double.valueOf((double) networkStats.firstDataTime));
                        hashMap2.put("recDataTime", Double.valueOf((double) networkStats.recDataTime));
                        hashMap2.put("oneWayTime_ANet", Double.valueOf((double) networkStats.oneWayTime_ANet));
                        hashMap2.put("serverRT", Double.valueOf((double) networkStats.serverRT));
                        hashMap2.put("revSize", Double.valueOf((double) networkStats.recvSize));
                        hashMap2.put("dataSpeed", Double.valueOf((double) networkStats.dataSpeed));
                    }
                    rbStatisticData = mtopStatistics.c;
                    if (rbStatisticData != null) {
                        hashMap2.put("rbReqTime", Double.valueOf((double) rbStatisticData.rbReqTime));
                        hashMap2.put("toMainThTime", Double.valueOf((double) mtopStatistics.c.toMainThTime));
                        hashMap2.put("mtopDispatchTime", Double.valueOf((double) mtopStatistics.c.mtopDispatchTime));
                        hashMap2.put("bizCallbackTime", Double.valueOf((double) mtopStatistics.c.bizCallbackTime));
                        hashMap2.put("mtopJsonParseTime", Double.valueOf((double) mtopStatistics.c.jsonParseTime));
                        hashMap2.put("mtopReqTime", Double.valueOf((double) mtopStatistics.c.mtopReqTime));
                    }
                    iUploadStats = mtopStatistics.e;
                    if (iUploadStats != null) {
                        iUploadStats.onCommit("mtopsdk", "mtopStats", hashMap, hashMap2);
                    }
                    if (!ErrorConstant.isSuccess(mtopStatistics.retCode)) {
                        HashMap hashMap5 = new HashMap();
                        hashMap5.put("api", mtopStatistics.apiKey);
                        hashMap5.put("ret", mtopStatistics.retCode);
                        hashMap5.put("retType", String.valueOf(mtopStatistics.retType));
                        hashMap5.put("reqSource", String.valueOf(mtopStatistics.reqSource));
                        hashMap5.put("mappingCode", mtopStatistics.mappingCode);
                        hashMap5.put("httpResponseStatus", String.valueOf(mtopStatistics.statusCode));
                        hashMap5.put("domain", mtopStatistics.domain);
                        hashMap5.put("refer", mtopStatistics.pageUrl);
                        hashMap5.put("clientTraceId", mtopStatistics.clientTraceId);
                        hashMap5.put(obj11, mtopStatistics.serverTraceId);
                        hashMap5.put(obj12, mtopStatistics.pageName);
                        hashMap5.put(obj10, mtopStatistics.pageUrl);
                        hashMap5.put(obj9, String.valueOf(mtopStatistics.backGround ? 1 : 0));
                        hashMap5.put(obj3, String.valueOf(mtopStatistics.isMain ? 1 : 0));
                        hashMap5.put(obj4, String.valueOf(RemoteConfig.getInstance().useSecurityAdapter));
                        hashMap5.put(obj2, String.valueOf(mtopStatistics.isPrefetch ? 1 : 0));
                        IUploadStats iUploadStats6 = mtopStatistics.e;
                        if (iUploadStats6 != null) {
                            iUploadStats6.onCommit("mtopsdk", "mtopExceptions", hashMap5, null);
                        }
                        if (!(mtopStatistics.retType == 0 || mtopStatistics.f == null)) {
                            hashMap5.put("seqNo", mtopStatistics.seqNo);
                        }
                    }
                    HashMap hashMap3 = new HashMap();
                    hashMap3.put("bizId", !TextUtils.isEmpty(mtopStatistics.bizIdStr) ? mtopStatistics.bizIdStr : String.valueOf(mtopStatistics.bizId));
                    hashMap3.put("api", mtopStatistics.apiKey);
                    hashMap3.put("version", mtopStatistics.apiKey);
                    hashMap3.put("domain", mtopStatistics.domain);
                    hashMap3.put("httpResponseStatus", String.valueOf(mtopStatistics.statusCode));
                    hashMap3.put("ret", mtopStatistics.retCode);
                    hashMap3.put("bxSessionId", mtopStatistics.bxSessionId);
                    hashMap3.put("bxUI", String.valueOf(mtopStatistics.bxUI));
                    hashMap3.put("bxMainAction", String.valueOf(mtopStatistics.bxMainAction));
                    hashMap3.put("bxSubAction", String.valueOf(mtopStatistics.bxSubAction));
                    hashMap3.put("bxRetry", String.valueOf(mtopStatistics.bxRetry));
                    HashMap hashMap4 = new HashMap();
                    hashMap4.put("bxSleep", Double.valueOf((double) mtopStatistics.bxSleep));
                    hashMap4.put("checkTime", Double.valueOf((double) (mtopStatistics.fcProcessCheckEndTime - mtopStatistics.fcProcessCheckStartTime)));
                    hashMap4.put(obj, Double.valueOf((double) (mtopStatistics.fcProcessCallbackTime - mtopStatistics.fcProcessStartTime)));
                    iUploadStats2 = mtopStatistics.e;
                    if (iUploadStats2 != null) {
                        iUploadStats2.onCommit("mtopsdk", "baxiaAction", hashMap3, hashMap4);
                    }
                    mtopStatistics.commitStat = false;
                } catch (Throwable th21) {
                    th = th21;
                    try {
                        String str6 = mtopStatistics.seqNo;
                        TBSdkLog.e(str2, str6, "[commitStatData] commit mtopStats error ---" + th.toString());
                        return;
                    } finally {
                        mtopStatistics.commitStat = false;
                    }
                }
            } catch (Throwable th22) {
                th = th22;
                str2 = str;
                String str6 = mtopStatistics.seqNo;
                TBSdkLog.e(str2, str6, "[commitStatData] commit mtopStats error ---" + th.toString());
                return;
            }
        } else {
            return;
        }
        str = "mtopsdk.MtopStatistics";
        String str5 = mtopStatistics.seqNo;
        obj6 = obj13;
        obj5 = "pageUrl";
        TBSdkLog.e(str, str5, "[registerMtopStats] register MtopStats error ---" + th2.toString());
        hashMap = new HashMap();
        hashMap.put("api", mtopStatistics.apiKey);
        hashMap.put("ret", mtopStatistics.retCode);
        hashMap.put("retType", String.valueOf(mtopStatistics.retType));
        hashMap.put("httpResponseStatus", String.valueOf(mtopStatistics.statusCode));
        hashMap.put("domain", mtopStatistics.domain);
        hashMap.put("reqSource", String.valueOf(mtopStatistics.reqSource));
        hashMap.put(obj8, String.valueOf(mtopStatistics.cacheSwitch));
        hashMap.put(obj7, String.valueOf(mtopStatistics.cacheHitType));
        hashMap.put("clientTraceId", mtopStatistics.clientTraceId);
        hashMap.put("serverTraceId", mtopStatistics.serverTraceId);
        hashMap.put("pageName", mtopStatistics.pageName);
        hashMap.put(obj5, mtopStatistics.pageUrl);
        hashMap.put(obj6, String.valueOf(mtopStatistics.backGround ? 1 : 0));
        str2 = str;
        hashMap.put(obj3, String.valueOf(mtopStatistics.isMain ? 1 : 0));
        hashMap.put(obj4, String.valueOf(RemoteConfig.getInstance().useSecurityAdapter));
        hashMap.put(obj2, String.valueOf(mtopStatistics.isPrefetch ? 1 : 0));
        hashMap.put("handler", String.valueOf(mtopStatistics.handler ? 1 : 0));
        networkStats = getNetworkStats();
        if (networkStats != null) {
        }
        if (Mtop.mIsFullTrackValid) {
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("totalTime", Double.valueOf((double) mtopStatistics.totalTime));
        hashMap2.put("networkExeTime", Double.valueOf((double) mtopStatistics.netTotalTime));
        hashMap2.put("cacheCostTime", Double.valueOf((double) mtopStatistics.cacheCostTime));
        hashMap2.put("cacheResponseParseTime", Double.valueOf((double) mtopStatistics.cacheResponseParseTime));
        hashMap2.put("waitExecuteTime", Double.valueOf((double) mtopStatistics.waitExecuteTime));
        hashMap2.put("waitCallbackTime", Double.valueOf((double) mtopStatistics.waitCallbackTime));
        hashMap2.put("waitExecute2BuildParamTime", Double.valueOf((double) mtopStatistics.waitExecute2BuildParamTime));
        hashMap2.put("buildParamsTime", Double.valueOf((double) mtopStatistics.buildParamsTime));
        hashMap2.put("buildParams2NetworkTime", Double.valueOf((double) mtopStatistics.buildParams2NetworkTime));
        hashMap2.put("startCallBack2EndTime", Double.valueOf((double) mtopStatistics.startCallBack2EndTime));
        hashMap2.put("signTime", Double.valueOf((double) mtopStatistics.computeSignTime));
        hashMap2.put("wuaTime", Double.valueOf((double) mtopStatistics.computeWuaTime));
        hashMap2.put("miniWuaTime", Double.valueOf((double) mtopStatistics.computeMiniWuaTime));
        hashMap2.put("callbackPocTime", Double.valueOf((double) mtopStatistics.callbackPocTime));
        hashMap2.put("allTime", Double.valueOf((double) mtopStatistics.allTime));
        hashMap2.put("requestPocTime", Double.valueOf((double) mtopStatistics.requestPocTime));
        if (networkStats != null) {
        }
        rbStatisticData = mtopStatistics.c;
        if (rbStatisticData != null) {
        }
        iUploadStats = mtopStatistics.e;
        if (iUploadStats != null) {
        }
        if (!ErrorConstant.isSuccess(mtopStatistics.retCode)) {
        }
        HashMap hashMap3 = new HashMap();
        hashMap3.put("bizId", !TextUtils.isEmpty(mtopStatistics.bizIdStr) ? mtopStatistics.bizIdStr : String.valueOf(mtopStatistics.bizId));
        hashMap3.put("api", mtopStatistics.apiKey);
        hashMap3.put("version", mtopStatistics.apiKey);
        hashMap3.put("domain", mtopStatistics.domain);
        hashMap3.put("httpResponseStatus", String.valueOf(mtopStatistics.statusCode));
        hashMap3.put("ret", mtopStatistics.retCode);
        hashMap3.put("bxSessionId", mtopStatistics.bxSessionId);
        hashMap3.put("bxUI", String.valueOf(mtopStatistics.bxUI));
        hashMap3.put("bxMainAction", String.valueOf(mtopStatistics.bxMainAction));
        hashMap3.put("bxSubAction", String.valueOf(mtopStatistics.bxSubAction));
        hashMap3.put("bxRetry", String.valueOf(mtopStatistics.bxRetry));
        HashMap hashMap4 = new HashMap();
        hashMap4.put("bxSleep", Double.valueOf((double) mtopStatistics.bxSleep));
        hashMap4.put("checkTime", Double.valueOf((double) (mtopStatistics.fcProcessCheckEndTime - mtopStatistics.fcProcessCheckStartTime)));
        hashMap4.put(obj, Double.valueOf((double) (mtopStatistics.fcProcessCallbackTime - mtopStatistics.fcProcessStartTime)));
        iUploadStats2 = mtopStatistics.e;
        if (iUploadStats2 != null) {
        }
        mtopStatistics.commitStat = false;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("MtopStatistics ");
        sb.append(hashCode());
        sb.append("[SumStat(ms)]:");
        sb.append(this.b);
        if (this.c != null) {
            sb.append(" [rbStatData]:");
            sb.append(this.c);
        }
        return sb.toString();
    }

    public synchronized RbStatisticData getRbStatData() {
        if (this.c == null) {
            this.c = new RbStatisticData(this, (byte) 0);
        }
        return this.c;
    }

    @Override // java.lang.Object
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public class RbStatisticData implements Cloneable {
        public long afterReqTime;
        public long beforeReqTime;
        public long bizCallbackTime;
        public int isCache;
        public long jsonParseTime;
        @Deprecated
        public long jsonTime;
        public long mtopDispatchTime;
        public long mtopReqTime;
        public long parseTime;
        public long rbReqTime;
        public long toMainThTime;
        @Deprecated
        public long totalTime;

        /* synthetic */ RbStatisticData(MtopStatistics mtopStatistics, byte b) {
            this(mtopStatistics);
        }

        private RbStatisticData(MtopStatistics mtopStatistics) {
            this.isCache = 0;
        }

        public String getStatSum() {
            StringBuilder sb = new StringBuilder(32);
            sb.append("rbReqTime=");
            sb.append(this.rbReqTime);
            sb.append(",mtopReqTime=");
            sb.append(this.mtopReqTime);
            sb.append(",mtopJsonParseTime=");
            sb.append(this.jsonParseTime);
            sb.append(",toMainThTime=");
            sb.append(this.toMainThTime);
            sb.append(",mtopDispatchTime=");
            sb.append(this.mtopDispatchTime);
            sb.append(",bizCallbackTime=");
            sb.append(this.bizCallbackTime);
            sb.append(",isCache=");
            sb.append(this.isCache);
            return sb.toString();
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("rbReqTime=");
            sb.append(this.rbReqTime);
            sb.append(",mtopReqTime=");
            sb.append(this.mtopReqTime);
            sb.append(",mtopJsonParseTime=");
            sb.append(this.jsonParseTime);
            sb.append(",toMainThTime=");
            sb.append(this.toMainThTime);
            sb.append(",mtopDispatchTime=");
            sb.append(this.mtopDispatchTime);
            sb.append(",bizCallbackTime=");
            sb.append(this.bizCallbackTime);
            sb.append(",isCache=");
            sb.append(this.isCache);
            sb.append(",beforeReqTime=");
            sb.append(this.beforeReqTime);
            sb.append(",afterReqTime=");
            sb.append(this.afterReqTime);
            sb.append(",parseTime=");
            sb.append(this.parseTime);
            return sb.toString();
        }

        @Override // java.lang.Object
        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    public void formatStartLog() {
        if (this.seqNo != null) {
            TBSdkLog.e("mtopsdk", this.seqNo, "[traceId:" + this.fullTraceId + "] |start");
        }
    }

    public void formatEndLog() {
        if (this.seqNo != null) {
            TBSdkLog.e("mtopsdk", this.seqNo, "[traceId:" + this.fullTraceId + "] |MtopStatistics," + this.b);
        }
    }

    public void commitFullTrace() {
        int i;
        if (Mtop.mIsFullTrackValid) {
            formatEndLog();
            try {
                RequestInfo requestInfo = new RequestInfo();
                requestInfo.url = this.url;
                if (this.statusCode == -8) {
                    i = 2;
                } else {
                    i = this.retType == 0 ? 1 : 0;
                }
                requestInfo.ret = i;
                requestInfo.bizId = !TextUtils.isEmpty(this.bizIdStr) ? this.bizIdStr : String.valueOf(this.bizId);
                requestInfo.bizReqStart = this.bizReqStart;
                requestInfo.bizReqProcessStart = this.bizReqProcessStart;
                requestInfo.bizRspProcessStart = this.bizRspProcessStart;
                requestInfo.bizRspCbDispatch = this.rspCbDispatch;
                requestInfo.bizRspCbStart = this.rspCbStart;
                requestInfo.bizRspCbEnd = this.rspCbEnd;
                requestInfo.serverTraceId = this.eagleEyeTraceId;
                requestInfo.isCbMain = this.isMain;
                requestInfo.isReqMain = this.isReqMain;
                requestInfo.isReqSync = this.isReqSync;
                if (this.cacheHitType == 1) {
                    requestInfo.protocolType = "cache";
                }
                if (getRbStatData() != null) {
                    requestInfo.deserializeTime = getRbStatData().jsonParseTime;
                }
                FullTraceAnalysis.getInstance().commitRequest(this.fullTraceId, "mtop", requestInfo);
            } catch (Throwable unused) {
                TBSdkLog.e("mtopsdk", this.seqNo, "FullTrack sdk version not compatible");
            }
        }
    }
}
