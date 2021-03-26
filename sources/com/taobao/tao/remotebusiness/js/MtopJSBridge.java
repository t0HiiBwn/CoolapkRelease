package com.taobao.tao.remotebusiness.js;

import android.text.TextUtils;
import com.taobao.tao.remotebusiness.IRemoteBaseListener;
import com.taobao.tao.remotebusiness.IRemoteCacheListener;
import com.taobao.tao.remotebusiness.IRemoteListener;
import com.taobao.tao.remotebusiness.MtopBusiness;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.common.MtopCacheEvent;
import mtopsdk.mtop.domain.BaseOutDo;
import mtopsdk.mtop.domain.JsonTypeEnum;
import mtopsdk.mtop.domain.MethodEnum;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;
import org.json.JSONArray;
import org.json.JSONObject;

public class MtopJSBridge {
    private static volatile ScheduledExecutorService a;

    public static void sendMtopRequest(Map<String, Object> map, IRemoteBaseListener iRemoteBaseListener) {
        if (iRemoteBaseListener == null) {
            TBSdkLog.e("mtopsdk.MtopJSBridge", "illegal param listener.");
        } else if (map == null || map.isEmpty()) {
            TBSdkLog.e("mtopsdk.MtopJSBridge", "illegal param jsParamMap.");
            iRemoteBaseListener.onSystemError(0, new MtopResponse("ANDROID_SYS_ILLEGAL_JSPARAM_ERROR", "MTOP JSBridge 参数错误"), null);
        } else {
            MtopBusiness a2 = a(map);
            if (a2 == null) {
                iRemoteBaseListener.onSystemError(0, new MtopResponse("ANDROID_SYS_PARSE_JSPARAM_ERROR", "MTOP JSBridge 参数解析错误"), null);
                return;
            }
            int i = 20000;
            try {
                int intValue = ((Integer) map.get("timeout")).intValue();
                if (intValue >= 0) {
                    i = intValue > 60000 ? 60000 : intValue;
                }
            } catch (Exception unused) {
                TBSdkLog.e("mtopsdk.MtopJSBridge", "parse timeout (jsParam field) error.");
            }
            a aVar = new a(a2, iRemoteBaseListener);
            a2.registerListener((IRemoteListener) aVar);
            a2.startRequest();
            a().schedule(new a(aVar), (long) i, TimeUnit.MILLISECONDS);
        }
    }

    private static MtopBusiness a(Map<String, Object> map) {
        Exception e;
        HashMap hashMap;
        MtopBusiness mtopBusiness = null;
        HashMap hashMap2 = null;
        try {
            JSONObject jSONObject = new JSONObject(map);
            String string = jSONObject.getString("api");
            String optString = jSONObject.optString("v", "*");
            String str = "{}";
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                HashMap hashMap3 = new HashMap();
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    Object obj = optJSONObject.get(next);
                    hashMap3.put(next, obj.toString());
                    if (!(obj instanceof JSONArray) && !(obj instanceof JSONObject)) {
                        optJSONObject.put(next, obj.toString());
                    }
                }
                String jSONObject2 = optJSONObject.toString();
                hashMap = hashMap3;
                str = jSONObject2;
            } else {
                hashMap = null;
            }
            boolean optBoolean = jSONObject.optBoolean("needLogin", false);
            String optString2 = jSONObject.optString("sessionOption", "AutoLoginAndManualLogin");
            MtopRequest mtopRequest = new MtopRequest();
            mtopRequest.setApiName(string);
            mtopRequest.setVersion(optString);
            mtopRequest.setNeedEcode(optBoolean);
            mtopRequest.setData(str);
            mtopRequest.dataParams = hashMap;
            MtopBusiness build = MtopBusiness.build(mtopRequest);
            try {
                build.showLoginUI(!"AutoLoginOnly".equalsIgnoreCase(optString2));
                if (MethodEnum.POST.getMethod().equalsIgnoreCase(jSONObject.optString("method", "GET"))) {
                    build.reqMethod(MethodEnum.POST);
                }
                String optString3 = jSONObject.optString("mpHost", "");
                if (StringUtils.isNotBlank(optString3)) {
                    build.setCustomDomain(optString3);
                }
                if (jSONObject.optInt("secType", 0) > 0) {
                    build.useWua();
                }
                String optString4 = jSONObject.optString("dataType", "");
                if (!StringUtils.isBlank(optString4) && ("json".equals(optString4) || "originaljson".equals(optString4))) {
                    build.setJsonType(JsonTypeEnum.valueOf(optString4.toUpperCase(Locale.US)));
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("ext_headers");
                if (optJSONObject2 != null) {
                    hashMap2 = new HashMap();
                    Iterator<String> keys2 = optJSONObject2.keys();
                    while (keys2.hasNext()) {
                        String next2 = keys2.next();
                        String string2 = optJSONObject2.getString(next2);
                        if (!TextUtils.isEmpty(next2) && !TextUtils.isEmpty(string2)) {
                            hashMap2.put(next2, string2);
                        }
                    }
                }
                String optString5 = jSONObject.optString("x-ua");
                if (!StringUtils.isBlank(optString5)) {
                    if (hashMap2 == null) {
                        hashMap2 = new HashMap();
                    }
                    hashMap2.put("x-ua", URLEncoder.encode(optString5, "utf-8"));
                }
                build.headers((Map<String, String>) hashMap2);
                JSONObject optJSONObject3 = jSONObject.optJSONObject("ext_querys");
                if (optJSONObject3 != null) {
                    Iterator<String> keys3 = optJSONObject3.keys();
                    while (keys3.hasNext()) {
                        String next3 = keys3.next();
                        String string3 = optJSONObject3.getString(next3);
                        if (!TextUtils.isEmpty(next3) && !TextUtils.isEmpty(string3)) {
                            build.addHttpQueryParameter(next3, string3);
                        }
                    }
                }
                String optString6 = jSONObject.optString("ttid");
                if (!StringUtils.isBlank(optString6)) {
                    build.ttid(optString6);
                }
                String optString7 = jSONObject.optString("pageUrl");
                if (!StringUtils.isBlank(optString7)) {
                    build.setPageUrl(optString7);
                }
                build.setReqSource(1);
                return build;
            } catch (Exception e2) {
                e = e2;
                mtopBusiness = build;
                TBSdkLog.e("mtopsdk.MtopJSBridge", "parse mtop jsParamMap error, jsParamMap=" + map, e);
                return mtopBusiness;
            }
        } catch (Exception e3) {
            e = e3;
            TBSdkLog.e("mtopsdk.MtopJSBridge", "parse mtop jsParamMap error, jsParamMap=" + map, e);
            return mtopBusiness;
        }
    }

    static ScheduledExecutorService a() {
        if (a == null) {
            synchronized (MtopJSBridge.class) {
                if (a == null) {
                    a = Executors.newScheduledThreadPool(1);
                }
            }
        }
        return a;
    }

    static class a implements IRemoteBaseListener, IRemoteCacheListener {
        final IRemoteBaseListener a;
        private final MtopBusiness b;
        private MtopResponse c;
        private AtomicBoolean d = new AtomicBoolean(false);

        public a(MtopBusiness mtopBusiness, IRemoteBaseListener iRemoteBaseListener) {
            this.b = mtopBusiness;
            this.a = iRemoteBaseListener;
        }

        public final void a() {
            if (this.d.compareAndSet(false, true)) {
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.DebugEnable)) {
                    TBSdkLog.d("mtopsdk.MtopJSBridge", "callback onTimeOut");
                }
                this.b.cancelRequest();
                try {
                    MtopResponse mtopResponse = this.c;
                    if (mtopResponse != null) {
                        this.a.onSuccess(0, mtopResponse, null, null);
                    } else {
                        this.a.onSystemError(0, null, null);
                    }
                } catch (Exception e) {
                    TBSdkLog.e("mtopsdk.MtopJSBridge", "do onTimeOut callback error.", e);
                }
            }
        }

        @Override // com.taobao.tao.remotebusiness.IRemoteListener
        public final void onSuccess(int i, MtopResponse mtopResponse, BaseOutDo baseOutDo, Object obj) {
            if (this.d.compareAndSet(false, true)) {
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.DebugEnable)) {
                    TBSdkLog.d("mtopsdk.MtopJSBridge", "callback onSuccess");
                }
                MtopJSBridge.a().submit(new b(this, i, mtopResponse, baseOutDo, obj));
            }
        }

        @Override // com.taobao.tao.remotebusiness.IRemoteListener
        public final void onError(int i, MtopResponse mtopResponse, Object obj) {
            if (this.d.compareAndSet(false, true)) {
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.DebugEnable)) {
                    TBSdkLog.d("mtopsdk.MtopJSBridge", "callback onError");
                }
                MtopJSBridge.a().submit(new c(this, i, mtopResponse, obj));
            }
        }

        @Override // com.taobao.tao.remotebusiness.IRemoteCacheListener
        public final void onCached(MtopCacheEvent mtopCacheEvent, BaseOutDo baseOutDo, Object obj) {
            if (mtopCacheEvent != null) {
                this.c = mtopCacheEvent.getMtopResponse();
            }
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.DebugEnable)) {
                TBSdkLog.d("mtopsdk.MtopJSBridge", "callback onCached");
            }
        }

        @Override // com.taobao.tao.remotebusiness.IRemoteBaseListener
        public final void onSystemError(int i, MtopResponse mtopResponse, Object obj) {
            if (this.d.compareAndSet(false, true)) {
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.DebugEnable)) {
                    TBSdkLog.d("mtopsdk.MtopJSBridge", "callback onSystemError");
                }
                MtopJSBridge.a().submit(new d(this, i, mtopResponse, obj));
            }
        }
    }
}
