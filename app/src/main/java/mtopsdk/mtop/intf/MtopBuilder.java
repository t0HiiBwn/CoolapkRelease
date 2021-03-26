package mtopsdk.mtop.intf;

import android.os.Handler;
import android.text.TextUtils;
import com.taobao.analysis.fulltrace.FullTraceAnalysis;
import com.taobao.tao.remotebusiness.b.e;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mtopsdk.common.util.MtopUtils;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.common.ApiID;
import mtopsdk.mtop.common.DefaultMtopCallback;
import mtopsdk.mtop.common.MtopCallback;
import mtopsdk.mtop.common.MtopListener;
import mtopsdk.mtop.common.MtopNetworkProp;
import mtopsdk.mtop.common.a;
import mtopsdk.mtop.domain.ApiTypeEnum;
import mtopsdk.mtop.domain.IMTOPDataObject;
import mtopsdk.mtop.domain.JsonTypeEnum;
import mtopsdk.mtop.domain.MethodEnum;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.domain.ProtocolEnum;
import mtopsdk.mtop.intf.f;
import mtopsdk.mtop.stat.b;
import mtopsdk.mtop.util.ErrorConstant;
import mtopsdk.mtop.util.MtopConvert;
import mtopsdk.mtop.util.MtopSDKThreadPoolExecutorFactory;
import mtopsdk.mtop.util.MtopStatistics;
import mtopsdk.xstate.XState;

public class MtopBuilder {
    protected MtopStatistics a;
    protected Mtop b;
    protected e c;
    private f d;
    public MtopListener listener;
    public final MtopNetworkProp mtopProp;
    public MtopRequest request;
    @Deprecated
    public Object requestContext;

    public MtopBuilder(Mtop mtop, IMTOPDataObject iMTOPDataObject, String str) {
        this(mtop, MtopConvert.inputDoToMtopRequest(iMTOPDataObject), str);
    }

    public MtopBuilder(Mtop mtop, MtopRequest mtopRequest, String str) {
        MtopNetworkProp mtopNetworkProp = new MtopNetworkProp();
        this.mtopProp = mtopNetworkProp;
        this.listener = null;
        this.requestContext = null;
        this.a = null;
        this.b = mtop;
        this.request = mtopRequest;
        mtopNetworkProp.ttid = str;
        mtopNetworkProp.pageName = XState.getValue("PageName");
        mtopNetworkProp.pageUrl = XState.getValue("PageUrl");
        mtopNetworkProp.backGround = XState.isAppBackground();
        this.a = new MtopStatistics(mtop.getMtopConfig().uploadStats, mtop.getMtopConfig().mtopStatsListener, mtopNetworkProp);
    }

    @Deprecated
    public MtopBuilder(Mtop mtop, Object obj, String str) {
        this(mtop, MtopConvert.inputDoToMtopRequest(obj), str);
    }

    @Deprecated
    public MtopBuilder(IMTOPDataObject iMTOPDataObject, String str) {
        this(Mtop.instance(null), iMTOPDataObject, str);
    }

    @Deprecated
    public MtopBuilder(MtopRequest mtopRequest, String str) {
        this(Mtop.instance(null), mtopRequest, str);
    }

    @Deprecated
    public MtopBuilder(Object obj, String str) {
        this(Mtop.instance(null), obj, str);
    }

    public MtopBuilder ttid(String str) {
        this.mtopProp.ttid = str;
        return this;
    }

    public MtopBuilder reqContext(Object obj) {
        this.mtopProp.reqContext = obj;
        return this;
    }

    public Object getReqContext() {
        return this.mtopProp.reqContext;
    }

    public Mtop getMtopInstance() {
        return this.b;
    }

    public e getMtopContext$6e9e401a() {
        return this.c;
    }

    public f getMtopPrefetch() {
        return this.d;
    }

    public MtopBuilder retryTime(int i) {
        this.mtopProp.retryTimes = i;
        return this;
    }

    public MtopBuilder headers(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            if (this.mtopProp.requestHeaders != null) {
                this.mtopProp.requestHeaders.putAll(map);
            } else {
                this.mtopProp.requestHeaders = map;
            }
        }
        return this;
    }

    public MtopBuilder setCacheControlNoCache() {
        Map<String, String> map = this.mtopProp.requestHeaders;
        if (map == null) {
            map = new HashMap<>();
        }
        map.put("cache-control", "no-cache");
        this.mtopProp.requestHeaders = map;
        return this;
    }

    public MtopBuilder protocol(ProtocolEnum protocolEnum) {
        if (protocolEnum != null) {
            this.mtopProp.protocol = protocolEnum;
        }
        return this;
    }

    public MtopBuilder setRouterId(String str) {
        this.mtopProp.routerId = str;
        return this;
    }

    public MtopBuilder setPlaceId(String str) {
        this.mtopProp.placeId = str;
        return this;
    }

    public MtopBuilder setCustomDomain(String str) {
        if (str != null) {
            this.mtopProp.customDomain = str;
        }
        return this;
    }

    public MtopBuilder setCustomDomain(String str, String str2, String str3) {
        if (StringUtils.isNotBlank(str)) {
            this.mtopProp.customOnlineDomain = str;
        }
        if (StringUtils.isNotBlank(str2)) {
            this.mtopProp.customPreDomain = str2;
        }
        if (StringUtils.isNotBlank(str3)) {
            this.mtopProp.customDailyDomain = str3;
        }
        return this;
    }

    public MtopBuilder setUnitStrategy(String str) {
        if (str != null) {
            str.hashCode();
            if (str.equals("UNIT_GUIDE")) {
                setCustomDomain("guide-acs.m.taobao.com", "guide-acs.wapa.taobao.com", "guide-acs.waptest.taobao.com");
            } else if (str.equals("UNIT_TRADE")) {
                setCustomDomain("trade-acs.m.taobao.com", "trade-acs.wapa.taobao.com", "trade-acs.waptest.taobao.com");
            }
        }
        return this;
    }

    public MtopBuilder addListener(MtopListener mtopListener) {
        this.listener = mtopListener;
        return this;
    }

    public MtopBuilder setNetInfo(int i) {
        this.mtopProp.netParam = i;
        return this;
    }

    public MtopBuilder addMteeUa(String str) {
        addHttpQueryParameter("ua", str);
        return this;
    }

    public MtopBuilder addHttpQueryParameter(String str, String str2) {
        if (StringUtils.isBlank(str) || StringUtils.isBlank(str2)) {
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.DebugEnable)) {
                TBSdkLog.d("mtopsdk.MtopBuilder", "[addHttpQueryParameter]add HttpQueryParameter error,key=" + str + ",value=" + str2);
            }
            return this;
        }
        if (this.mtopProp.queryParameterMap == null) {
            this.mtopProp.queryParameterMap = new HashMap();
        }
        this.mtopProp.queryParameterMap.put(str, str2);
        return this;
    }

    public MtopBuilder handler(Handler handler) {
        this.mtopProp.handler = handler;
        return this;
    }

    public MtopBuilder useCache() {
        this.mtopProp.useCache = true;
        return this;
    }

    public MtopBuilder forceRefreshCache() {
        this.mtopProp.forceRefreshCache = true;
        return this;
    }

    public MtopBuilder useWua() {
        return useWua(4);
    }

    @Deprecated
    public MtopBuilder useWua(int i) {
        this.mtopProp.wuaFlag = i;
        return this;
    }

    public MtopBuilder reqMethod(MethodEnum methodEnum) {
        if (methodEnum != null) {
            this.mtopProp.method = methodEnum;
        }
        return this;
    }

    public MtopBuilder addCacheKeyParamBlackList(List<String> list) {
        if (list != null) {
            this.mtopProp.cacheKeyBlackList = list;
        }
        return this;
    }

    public MtopBuilder setJsonType(JsonTypeEnum jsonTypeEnum) {
        if (jsonTypeEnum != null) {
            addHttpQueryParameter("type", jsonTypeEnum.getJsonType());
        }
        return this;
    }

    public MtopBuilder addOpenApiParams(String str, String str2) {
        this.mtopProp.apiType = ApiTypeEnum.ISV_OPEN_API;
        this.mtopProp.openAppKey = str;
        this.mtopProp.accessToken = str2;
        return this;
    }

    public MtopBuilder setConnectionTimeoutMilliSecond(int i) {
        if (i > 0) {
            this.mtopProp.connTimeout = i;
        }
        return this;
    }

    public MtopBuilder setSocketTimeoutMilliSecond(int i) {
        if (i > 0) {
            this.mtopProp.socketTimeout = i;
        }
        return this;
    }

    @Deprecated
    public MtopBuilder setBizId(int i) {
        this.mtopProp.bizId = i;
        return this;
    }

    public MtopBuilder setBizId(String str) {
        this.mtopProp.bizIdStr = str;
        return this;
    }

    public MtopBuilder setReqBizExt(String str) {
        this.mtopProp.reqBizExt = str;
        return this;
    }

    public MtopBuilder setReqUserId(String str) {
        this.mtopProp.reqUserId = str;
        return this;
    }

    public MtopBuilder setReqAppKey(String str, String str2) {
        this.mtopProp.reqAppKey = str;
        this.mtopProp.authCode = str2;
        return this;
    }

    public MtopBuilder setPageUrl(String str) {
        if (str != null) {
            this.mtopProp.pageUrl = str;
            this.a.pageUrl = this.mtopProp.pageUrl;
        }
        return this;
    }

    public MtopBuilder setPageName(String str) {
        if (str != null) {
            this.mtopProp.pageName = str;
            this.a.pageName = this.mtopProp.pageName;
        }
        return this;
    }

    public MtopBuilder setReqSource(int i) {
        this.mtopProp.reqSource = i;
        return this;
    }

    public MtopBuilder enableProgressListener() {
        this.mtopProp.enableProgressListener = true;
        return this;
    }

    public MtopBuilder setOpenBiz(String str) {
        if (str != null) {
            this.mtopProp.openBiz = str;
        }
        return this;
    }

    public MtopBuilder setMiniAppKey(String str) {
        if (str != null) {
            this.mtopProp.miniAppKey = str;
        }
        return this;
    }

    public MtopBuilder setRequestSourceAppKey(String str) {
        if (str != null) {
            this.mtopProp.requestSourceAppKey = str;
        }
        return this;
    }

    public MtopBuilder setOpenBizData(String str) {
        if (str != null) {
            this.mtopProp.openBizData = str;
        }
        return this;
    }

    public MtopBuilder prefetch$551ae013(long j, List<String> list, a aVar) {
        prefetch$45a45afc(j, aVar);
        return this;
    }

    public MtopBuilder prefetch$45a45afc(long j, a aVar) {
        if (this.d == null) {
            this.d = new f(new b(this.b.getMtopConfig().uploadStats));
        }
        if (j > 0) {
            f fVar = this.d;
            if (j > 15000) {
                j = 15000;
            }
            fVar.a(j);
        }
        this.d.a(aVar);
        if (this.d.a() == null) {
            this.d.a(new f.a());
        }
        return this;
    }

    public MtopBuilder prefetch() {
        return prefetch$45a45afc(0, null);
    }

    public MtopBuilder prefetchComparator(f.a aVar) {
        if (this.d == null) {
            this.d = new f(new b(this.b.getMtopConfig().uploadStats));
        }
        this.d.a(aVar);
        return this;
    }

    public MtopResponse syncRequest() {
        mtopsdk.mtop.common.a.a aVar;
        mtopsdk.mtop.common.a.a aVar2;
        this.a.isReqSync = true;
        MtopListener mtopListener = this.listener;
        if (mtopListener == null) {
            aVar = new mtopsdk.mtop.common.a.a(new DefaultMtopCallback());
        } else {
            if (mtopListener instanceof MtopCallback.MtopCacheListener) {
                aVar2 = new mtopsdk.mtop.common.a.b(mtopListener);
            } else {
                aVar2 = new mtopsdk.mtop.common.a.a(mtopListener);
            }
            aVar = aVar2;
        }
        a(aVar);
        synchronized (aVar) {
            try {
                if (aVar.b == null) {
                    aVar.wait(60000);
                }
            } catch (Exception e) {
                TBSdkLog.e("mtopsdk.MtopBuilder", "[syncRequest] callback wait error", e);
            }
        }
        MtopResponse mtopResponse = aVar.b;
        if (aVar.c != null) {
            this.mtopProp.reqContext = aVar.c;
        }
        if (mtopResponse != null) {
            return mtopResponse;
        }
        return b();
    }

    protected final MtopResponse b() {
        MtopResponse mtopResponse = new MtopResponse(this.request.getApiName(), this.request.getVersion(), "ANDROID_SYS_MTOP_APICALL_ASYNC_TIMEOUT", "服务竟然出错了");
        mtopResponse.mappingCodeSuffix = ErrorConstant.getMappingCodeByErrorCode(mtopResponse.getRetCode());
        mtopResponse.mappingCode = ErrorConstant.appendMappingCode(mtopResponse.getResponseCode(), mtopResponse.mappingCodeSuffix);
        this.a.retCode = mtopResponse.getRetCode();
        this.a.mappingCode = mtopResponse.getMappingCode();
        this.a.retType = 2;
        mtopResponse.setMtopStat(this.a);
        this.a.onEndAndCommit();
        this.a.commitFullTrace();
        return mtopResponse;
    }

    private ApiID a(MtopListener mtopListener) {
        MtopStatistics mtopStatistics = this.a;
        mtopStatistics.startTime = mtopStatistics.currentTimeMillis();
        e createMtopContext$643c68d3 = createMtopContext$643c68d3(mtopListener);
        createMtopContext$643c68d3.g.bizReqStart = System.currentTimeMillis();
        this.c = createMtopContext$643c68d3;
        createMtopContext$643c68d3.f = new ApiID(null, createMtopContext$643c68d3);
        try {
            if (Mtop.mIsFullTrackValid) {
                String createRequest = FullTraceAnalysis.getInstance().createRequest("mtop");
                if (!TextUtils.isEmpty(createRequest)) {
                    createMtopContext$643c68d3.g.fullTraceId = createRequest;
                    if (!TextUtils.isEmpty(this.mtopProp.bizIdStr)) {
                        createMtopContext$643c68d3.g.bizIdStr = this.mtopProp.bizIdStr;
                    } else {
                        createMtopContext$643c68d3.g.bizId = this.mtopProp.bizId;
                    }
                    createMtopContext$643c68d3.g.isReqMain = MtopUtils.isMainThread();
                    createMtopContext$643c68d3.g.formatStartLog();
                }
            }
            if (!MtopUtils.isMainThread()) {
                if (this.b.isInited()) {
                    createMtopContext$643c68d3.g.startExecuteTime = this.a.currentTimeMillis();
                    createMtopContext$643c68d3.g.bizReqProcessStart = System.currentTimeMillis();
                    mtopsdk.a.b.a aVar = this.b.getMtopConfig().filterManager;
                    if (aVar != null) {
                        aVar.a(null, createMtopContext$643c68d3);
                    }
                    mtopsdk.a.c.a.a(aVar, createMtopContext$643c68d3);
                    return createMtopContext$643c68d3.f;
                }
            }
            MtopSDKThreadPoolExecutorFactory.getRequestThreadPoolExecutor().submit(new e(this, createMtopContext$643c68d3));
            return createMtopContext$643c68d3.f;
        } catch (Throwable unused) {
            return createMtopContext$643c68d3.f;
        }
    }

    public ApiID asyncRequest() {
        this.a.isReqSync = false;
        return a(this.listener);
    }

    public e createMtopContext$643c68d3(MtopListener mtopListener) {
        e eVar = new e();
        eVar.a = this.b;
        eVar.g = this.a;
        eVar.h = this.a.seqNo;
        eVar.b = this.request;
        eVar.d = this.mtopProp;
        eVar.e = mtopListener;
        eVar.k = this;
        MtopRequest mtopRequest = this.request;
        if (mtopRequest != null) {
            this.a.apiKey = mtopRequest.getKey();
            this.a.reqSource = this.mtopProp.reqSource;
        }
        if (StringUtils.isBlank(eVar.d.ttid)) {
            eVar.d.ttid = this.b.getTtid();
        }
        Object obj = this.requestContext;
        if (obj != null) {
            reqContext(obj);
        }
        return eVar;
    }

    protected final void a(boolean z) {
        this.a.commitStat = false;
    }

    public MtopBuilder setUserInfo(String str) {
        MtopNetworkProp mtopNetworkProp = this.mtopProp;
        if (StringUtils.isBlank(str)) {
            str = "DEFAULT";
        }
        mtopNetworkProp.userInfo = str;
        return this;
    }
}
