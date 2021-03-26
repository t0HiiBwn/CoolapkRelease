package com.taobao.tao.remotebusiness;

import android.content.Context;
import android.os.Handler;
import com.taobao.tao.remotebusiness.b.e;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import mtopsdk.common.util.MtopUtils;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.common.ApiID;
import mtopsdk.mtop.common.MtopListener;
import mtopsdk.mtop.domain.ApiTypeEnum;
import mtopsdk.mtop.domain.BaseOutDo;
import mtopsdk.mtop.domain.IMTOPDataObject;
import mtopsdk.mtop.domain.JsonTypeEnum;
import mtopsdk.mtop.domain.MethodEnum;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.domain.ProtocolEnum;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.mtop.intf.MtopBuilder;
import mtopsdk.mtop.intf.f;
import mtopsdk.mtop.stat.a;
import mtopsdk.mtop.util.MtopStatistics;

public class MtopBusiness extends MtopBuilder {
    public static final int MAX_RETRY_TIMES = 3;
    private static AtomicInteger n = new AtomicInteger(0);
    public String authParam = null;
    public Class<?> clazz;
    private boolean d = false;
    private ApiID e;
    private int f = 0;
    private int g = 0;
    private boolean h = true;
    private boolean i = false;
    public boolean isCached = false;
    private boolean j = false;
    private MtopResponse k = null;

    /* renamed from: l  reason: collision with root package name */
    private boolean f1421l = false;
    public MtopListener listener;
    private final String m = c();
    public long onBgFinishTime = 0;
    public long reqStartTime = 0;
    @Deprecated
    public Object requestContext = null;
    public long sendStartTime = 0;
    public boolean showAuthUI = true;

    protected MtopBusiness(Mtop mtop, IMTOPDataObject iMTOPDataObject, String str) {
        super(mtop, iMTOPDataObject, str);
    }

    protected MtopBusiness(Mtop mtop, MtopRequest mtopRequest, String str) {
        super(mtop, mtopRequest, str);
    }

    private String c() {
        StringBuilder sb = new StringBuilder(16);
        sb.append("MB");
        sb.append(n.incrementAndGet());
        sb.append('.');
        sb.append(this.a.seqNo);
        return sb.toString();
    }

    public static MtopBusiness build(Mtop mtop, IMTOPDataObject iMTOPDataObject, String str) {
        return new MtopBusiness(mtop, iMTOPDataObject, str);
    }

    public static MtopBusiness build(Mtop mtop, IMTOPDataObject iMTOPDataObject) {
        return build(mtop, iMTOPDataObject, (String) null);
    }

    @Deprecated
    public static MtopBusiness build(IMTOPDataObject iMTOPDataObject, String str) {
        return build(Mtop.instance((Context) null, str), iMTOPDataObject, str);
    }

    @Deprecated
    public static MtopBusiness build(IMTOPDataObject iMTOPDataObject) {
        return build(Mtop.instance(null), iMTOPDataObject);
    }

    public static MtopBusiness build(Mtop mtop, MtopRequest mtopRequest, String str) {
        return new MtopBusiness(mtop, mtopRequest, str);
    }

    public static MtopBusiness build(Mtop mtop, MtopRequest mtopRequest) {
        return build(mtop, mtopRequest, (String) null);
    }

    @Deprecated
    public static MtopBusiness build(MtopRequest mtopRequest, String str) {
        return build(Mtop.instance((Context) null, str), mtopRequest, str);
    }

    @Deprecated
    public static MtopBusiness build(MtopRequest mtopRequest) {
        return build(Mtop.instance(null), mtopRequest, (String) null);
    }

    @Deprecated
    public MtopBusiness registerListener(MtopListener mtopListener) {
        this.listener = mtopListener;
        return this;
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    @Deprecated
    public MtopBusiness addListener(MtopListener mtopListener) {
        this.listener = mtopListener;
        return this;
    }

    public MtopBusiness registerListener(IRemoteListener iRemoteListener) {
        this.listener = iRemoteListener;
        return this;
    }

    public String getSeqNo() {
        return this.m;
    }

    public void startRequest() {
        startRequest(0, null);
    }

    public void startRequest(Class<?> cls) {
        startRequest(0, cls);
    }

    public void startRequest(int i2, Class<?> cls) {
        if (this.request == null) {
            TBSdkLog.e("mtopsdk.MtopBusiness", this.m, "MtopRequest is null!");
            return;
        }
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            String str = this.m;
            TBSdkLog.i("mtopsdk.MtopBusiness", str, "startRequest " + this.request);
        }
        this.reqStartTime = System.currentTimeMillis();
        this.d = false;
        this.isCached = false;
        this.clazz = cls;
        this.g = i2;
        Object obj = this.requestContext;
        if (obj != null) {
            reqContext(obj);
        }
        MtopListener mtopListener = this.listener;
        if (mtopListener != null && !this.d) {
            super.addListener(e.a(this, mtopListener));
        }
        a(false);
        this.sendStartTime = System.currentTimeMillis();
        this.e = super.asyncRequest();
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopResponse syncRequest() {
        String key = this.request != null ? this.request.getKey() : "";
        if (MtopUtils.isMainThread()) {
            TBSdkLog.e("mtopsdk.MtopBusiness", this.m, "do syncRequest in UI main thread!");
        }
        this.f1421l = true;
        if (this.listener == null) {
            this.listener = new a(this);
        }
        startRequest();
        synchronized (this.listener) {
            try {
                if (this.k == null) {
                    this.listener.wait(60000);
                }
            } catch (InterruptedException unused) {
                String str = this.m;
                TBSdkLog.e("mtopsdk.MtopBusiness", str, "syncRequest InterruptedException. apiKey=" + key);
            } catch (Exception unused2) {
                String str2 = this.m;
                TBSdkLog.e("mtopsdk.MtopBusiness", str2, "syncRequest do wait Exception. apiKey=" + key);
            }
        }
        if (this.k == null) {
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.ErrorEnable)) {
                String str3 = this.m;
                TBSdkLog.w("mtopsdk.MtopBusiness", str3, "syncRequest timeout. apiKey=" + key);
            }
            cancelRequest();
        }
        MtopResponse mtopResponse = this.k;
        return mtopResponse != null ? mtopResponse : b();
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    @Deprecated
    public ApiID asyncRequest() {
        startRequest();
        return this.e;
    }

    public int getRequestType() {
        return this.g;
    }

    public boolean isTaskCanceled() {
        return this.d;
    }

    public int getRetryTime() {
        return this.f;
    }

    public void cancelRequest() {
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i("mtopsdk.MtopBusiness", this.m, a("cancelRequest.", this));
        }
        this.d = true;
        ApiID apiID = this.e;
        if (apiID != null) {
            try {
                apiID.cancelApiCall();
            } catch (Throwable th) {
                TBSdkLog.w("mtopsdk.MtopBusiness", this.m, a("cancelRequest failed.", this), th);
            }
        }
    }

    final void a() {
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i("mtopsdk.MtopBusiness", this.m, a("retryRequest.", this));
        }
        if (this.f >= 3) {
            this.f = 0;
            doFinish(this.c.c, null);
            return;
        }
        cancelRequest();
        startRequest(this.g, this.clazz);
        this.f++;
    }

    public MtopBusiness showLoginUI(boolean z) {
        this.h = z;
        return this;
    }

    public boolean isShowLoginUI() {
        return this.h;
    }

    public MtopBusiness setNeedAuth(String str, boolean z) {
        this.authParam = str;
        this.showAuthUI = z;
        this.j = true;
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.DebugEnable)) {
            StringBuilder sb = new StringBuilder(64);
            sb.append("[setNeedAuth] authParam=");
            sb.append(str);
            sb.append(", showAuthUI=");
            sb.append(z);
            sb.append(", needAuth=");
            sb.append(this.j);
            TBSdkLog.d("mtopsdk.MtopBusiness", this.m, sb.toString());
        }
        return this;
    }

    public MtopBusiness setNeedAuth(String str, String str2, boolean z) {
        this.mtopProp.apiType = ApiTypeEnum.ISV_OPEN_API;
        this.mtopProp.isInnerOpen = true;
        if (StringUtils.isNotBlank(str)) {
            this.mtopProp.openAppKey = str;
        }
        this.authParam = str2;
        this.showAuthUI = z;
        this.j = true;
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.DebugEnable)) {
            StringBuilder sb = new StringBuilder(64);
            sb.append("[setNeedAuth] openAppKey=");
            sb.append(str);
            sb.append(", bizParam=");
            sb.append(str2);
            sb.append(", showAuthUI=");
            sb.append(z);
            sb.append(", needAuth=");
            sb.append(this.j);
            sb.append(", isInnerOpen=true");
            TBSdkLog.d("mtopsdk.MtopBusiness", this.m, sb.toString());
        }
        return this;
    }

    public boolean isNeedAuth() {
        return this.j || this.authParam != null;
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopBusiness addOpenApiParams(String str, String str2) {
        return (MtopBusiness) super.addOpenApiParams(str, str2);
    }

    public MtopBusiness setErrorNotifyAfterCache(boolean z) {
        this.i = z;
        return this;
    }

    @Deprecated
    public void setErrorNotifyNeedAfterCache(boolean z) {
        setErrorNotifyAfterCache(z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0191 A[SYNTHETIC, Splitter:B:78:0x0191] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01b0 A[Catch:{ all -> 0x01c7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x01d9  */
    public void doFinish(MtopResponse mtopResponse, BaseOutDo baseOutDo) {
        if (this.f1421l) {
            this.k = mtopResponse;
            synchronized (this.listener) {
                try {
                    this.listener.notify();
                } catch (Exception e2) {
                    String str = this.m;
                    StringBuilder sb = new StringBuilder("[doFinish]syncRequest do notify Exception. apiKey=");
                    sb.append(mtopResponse != null ? mtopResponse.getFullKey() : "");
                    TBSdkLog.e("mtopsdk.MtopBusiness", str, sb.toString(), e2);
                }
            }
        }
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            StringBuilder sb2 = new StringBuilder(32);
            sb2.append("doFinish request=");
            sb2.append(this.request);
            if (mtopResponse != null) {
                sb2.append(", retCode=");
                sb2.append(mtopResponse.getRetCode());
            }
            TBSdkLog.i("mtopsdk.MtopBusiness", this.m, sb2.toString());
        }
        if (this.d) {
            TBSdkLog.w("mtopsdk.MtopBusiness", this.m, "request is cancelled,don't callback listener.");
            return;
        }
        MtopListener mtopListener = this.listener;
        if (!(mtopListener instanceof IRemoteListener)) {
            String str2 = this.m;
            StringBuilder sb3 = new StringBuilder("listener did't implement IRemoteBaseListener.apiKey=");
            sb3.append(mtopResponse != null ? mtopResponse.getFullKey() : "");
            TBSdkLog.e("mtopsdk.MtopBusiness", str2, sb3.toString());
            return;
        }
        IRemoteListener iRemoteListener = (IRemoteListener) mtopListener;
        boolean z = false;
        if (mtopResponse != null && mtopResponse.isApiSuccess()) {
            long currentTimeMillis = this.a.currentTimeMillis();
            this.a.callbackPocTime = currentTimeMillis - this.a.netSendEndTime;
            this.a.allTime = currentTimeMillis - this.a.startTime;
            MtopStatistics mtopStatistics = this.a;
            if (this.c.d.handler != null) {
                z = true;
            }
            mtopStatistics.handler = z;
            try {
                iRemoteListener.onSuccess(this.g, mtopResponse, baseOutDo, getReqContext());
                if (a.a() != null) {
                    new HashMap().put("key_data_response", mtopResponse.getApi());
                    a.a();
                }
            } catch (Throwable th) {
                TBSdkLog.e("mtopsdk.MtopBusiness", this.m, "listener onSuccess callback error", th);
            }
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i("mtopsdk.MtopBusiness", this.m, "listener onSuccess callback.");
            }
        } else if (!this.isCached || this.i) {
            if (mtopResponse == null) {
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.ErrorEnable)) {
                    String str3 = this.m;
                    TBSdkLog.i("mtopsdk.MtopBusiness", str3, "mtopResponse is null." + this.request);
                }
            } else if (!mtopResponse.isSessionInvalid()) {
                if (mtopResponse.isMtopServerError() || mtopResponse.isMtopSdkError()) {
                    if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                        String str4 = this.m;
                        TBSdkLog.i("mtopsdk.MtopBusiness", str4, "mtopServerError or mtopSdkError." + this.request);
                    }
                }
                if (z) {
                    try {
                        if (iRemoteListener instanceof IRemoteBaseListener) {
                            ((IRemoteBaseListener) iRemoteListener).onSystemError(this.g, mtopResponse, getReqContext());
                            if (a.a() != null) {
                                new HashMap().put("key_data_response", mtopResponse != null ? mtopResponse.getApi() : "response null");
                                a.a();
                            }
                            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                                String str5 = this.m;
                                StringBuilder sb4 = new StringBuilder("listener onError callback, ");
                                sb4.append(z ? "sys error" : "biz error");
                                TBSdkLog.i("mtopsdk.MtopBusiness", str5, sb4.toString());
                                return;
                            }
                            return;
                        }
                    } catch (Throwable th2) {
                        TBSdkLog.e("mtopsdk.MtopBusiness", this.m, "listener onError callback error", th2);
                    }
                }
                iRemoteListener.onError(this.g, mtopResponse, getReqContext());
                if (a.a() != null) {
                }
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                }
            } else if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                String str6 = this.m;
                TBSdkLog.i("mtopsdk.MtopBusiness", str6, "session invalid error." + this.request);
            }
            z = true;
            if (z) {
            }
            iRemoteListener.onError(this.g, mtopResponse, getReqContext());
            if (a.a() != null) {
            }
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            }
        } else {
            TBSdkLog.i("mtopsdk.MtopBusiness", this.m, "listener onCached callback,doNothing in doFinish()");
        }
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    @Deprecated
    public MtopBusiness setBizId(int i2) {
        return (MtopBusiness) super.setBizId(i2);
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopBusiness setBizId(String str) {
        return (MtopBusiness) super.setBizId(str);
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopBusiness ttid(String str) {
        return (MtopBusiness) super.ttid(str);
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopBusiness useCache() {
        return (MtopBusiness) super.useCache();
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopBusiness useWua() {
        return (MtopBusiness) super.useWua();
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    @Deprecated
    public MtopBusiness useWua(int i2) {
        return (MtopBusiness) super.useWua(i2);
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopBusiness addHttpQueryParameter(String str, String str2) {
        return (MtopBusiness) super.addHttpQueryParameter(str, str2);
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopBusiness addCacheKeyParamBlackList(List<String> list) {
        return (MtopBusiness) super.addCacheKeyParamBlackList(list);
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopBusiness addMteeUa(String str) {
        return (MtopBusiness) super.addMteeUa(str);
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopBusiness enableProgressListener() {
        return (MtopBusiness) super.enableProgressListener();
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopBusiness forceRefreshCache() {
        return (MtopBusiness) super.forceRefreshCache();
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopBusiness handler(Handler handler) {
        return (MtopBusiness) super.handler(handler);
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopBusiness headers(Map<String, String> map) {
        return (MtopBusiness) super.headers(map);
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopBusiness protocol(ProtocolEnum protocolEnum) {
        return (MtopBusiness) super.protocol(protocolEnum);
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopBusiness reqContext(Object obj) {
        return (MtopBusiness) super.reqContext(obj);
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopBusiness reqMethod(MethodEnum methodEnum) {
        return (MtopBusiness) super.reqMethod(methodEnum);
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopBusiness retryTime(int i2) {
        return (MtopBusiness) super.retryTime(i2);
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopBusiness setCacheControlNoCache() {
        return (MtopBusiness) super.setCacheControlNoCache();
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopBusiness setConnectionTimeoutMilliSecond(int i2) {
        return (MtopBusiness) super.setConnectionTimeoutMilliSecond(i2);
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopBusiness setCustomDomain(String str) {
        return (MtopBusiness) super.setCustomDomain(str);
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopBusiness setCustomDomain(String str, String str2, String str3) {
        return (MtopBusiness) super.setCustomDomain(str, str2, str3);
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopBusiness setUnitStrategy(String str) {
        return (MtopBusiness) super.setUnitStrategy(str);
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopBusiness setJsonType(JsonTypeEnum jsonTypeEnum) {
        return (MtopBusiness) super.setJsonType(jsonTypeEnum);
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopBusiness setNetInfo(int i2) {
        return (MtopBusiness) super.setNetInfo(i2);
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopBusiness setPageUrl(String str) {
        return (MtopBusiness) super.setPageUrl(str);
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopBusiness setPageName(String str) {
        return (MtopBusiness) super.setPageName(str);
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopBusiness setReqAppKey(String str, String str2) {
        return (MtopBusiness) super.setReqAppKey(str, str2);
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopBusiness setReqBizExt(String str) {
        return (MtopBusiness) super.setReqBizExt(str);
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopBusiness setReqSource(int i2) {
        return (MtopBusiness) super.setReqSource(i2);
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopBusiness setReqUserId(String str) {
        return (MtopBusiness) super.setReqUserId(str);
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopBusiness setSocketTimeoutMilliSecond(int i2) {
        return (MtopBusiness) super.setSocketTimeoutMilliSecond(i2);
    }

    public MtopBusiness setPriorityFlag(boolean z) {
        this.mtopProp.priorityFlag = z;
        return this;
    }

    public MtopBusiness setPriorityData(Map<String, String> map) {
        this.mtopProp.priorityData = map;
        return this;
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopBusiness setUserInfo(String str) {
        return (MtopBusiness) super.setUserInfo(str);
    }

    private static String a(String str, MtopBusiness mtopBusiness) {
        StringBuilder sb = new StringBuilder(32);
        sb.append(str);
        sb.append(" [");
        if (mtopBusiness != null) {
            sb.append("apiName=");
            sb.append(mtopBusiness.request.getApiName());
            sb.append(";version=");
            sb.append(mtopBusiness.request.getVersion());
            sb.append(";requestType=");
            sb.append(mtopBusiness.getRequestType());
        }
        sb.append("]");
        return sb.toString();
    }

    /* renamed from: prefetch$6c9f0993 */
    public MtopBusiness prefetch$551ae013(long j2, List<String> list, mtopsdk.mtop.common.a aVar) {
        return (MtopBusiness) super.prefetch$551ae013(j2, list, aVar);
    }

    /* renamed from: prefetch$2649811c */
    public MtopBusiness prefetch$45a45afc(long j2, mtopsdk.mtop.common.a aVar) {
        return (MtopBusiness) super.prefetch$45a45afc(j2, aVar);
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopBusiness prefetch() {
        return (MtopBusiness) super.prefetch$45a45afc(0, null);
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopBusiness prefetchComparator(f.a aVar) {
        return (MtopBusiness) super.prefetchComparator(aVar);
    }
}
