package com.alibaba.baichuan.trade.common.adapter.mtop.a;

import android.text.TextUtils;
import com.alibaba.baichuan.trade.common.AlibcTradeCommon;
import com.alibaba.baichuan.trade.common.Environment;
import com.alibaba.baichuan.trade.common.adapter.mtop.AlibcNetWork;
import com.alibaba.baichuan.trade.common.adapter.mtop.JSNetworkResponse;
import com.alibaba.baichuan.trade.common.adapter.mtop.NetworkClient;
import com.alibaba.baichuan.trade.common.adapter.mtop.NetworkRequest;
import com.alibaba.baichuan.trade.common.adapter.mtop.NetworkResponse;
import com.alibaba.baichuan.trade.common.adapter.security.AlibcSecurityGuard;
import com.alibaba.baichuan.trade.common.adapter.ut.AlibcUserTradeHelper;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import com.alibaba.baichuan.trade.common.utils.JSONUtils;
import com.taobao.tao.remotebusiness.IRemoteBaseListener;
import com.taobao.tao.remotebusiness.IRemoteListener;
import com.taobao.tao.remotebusiness.MtopBusiness;
import java.io.Serializable;
import java.util.Map;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.domain.BaseOutDo;
import mtopsdk.mtop.domain.EnvModeEnum;
import mtopsdk.mtop.domain.MethodEnum;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.mtop.intf.MtopSetting;
import org.json.JSONObject;

public class b implements AlibcNetWork {
    private MtopBusiness a(NetworkRequest networkRequest) {
        MtopBusiness build = MtopBusiness.build(Mtop.getMtopInstance("OPEN"), b(networkRequest), TextUtils.isEmpty(networkRequest.ttid) ? AlibcTradeCommon.ttid : networkRequest.ttid);
        if (networkRequest.needWua) {
            build.useWua();
        }
        if (networkRequest.needAuth && !networkRequest.isVip) {
            build.setNeedAuth(networkRequest.authParams, true);
        }
        if (networkRequest.isPost) {
            build.reqMethod(MethodEnum.POST);
        }
        if (networkRequest.extHeaders != null && networkRequest.extHeaders.size() > 0) {
            build.headers(networkRequest.extHeaders);
        }
        if (!networkRequest.showAuthUI) {
            build.showAuthUI = networkRequest.showAuthUI;
        }
        Map<String, String> map = networkRequest.extQueries;
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                    build.addHttpQueryParameter(key, value);
                }
            }
        }
        build.setSocketTimeoutMilliSecond(15000);
        build.setConnectionTimeoutMilliSecond(15000);
        build.setOpenBiz("baichuan");
        return build;
    }

    /* access modifiers changed from: private */
    public void a(MtopResponse mtopResponse) {
        StringBuilder sb;
        String str;
        if (mtopResponse.isApiSuccess()) {
            AlibcLogger.d("AlibcMtop", "网络请求成功");
            return;
        }
        if (mtopResponse.isSessionInvalid()) {
            sb = new StringBuilder();
            str = "session 失效， do autologin or login business msg = ";
        } else if (mtopResponse.isSystemError() || mtopResponse.isNetworkError() || mtopResponse.isExpiredRequest() || mtopResponse.is41XResult() || mtopResponse.isApiLockedResult() || mtopResponse.isMtopSdkError()) {
            sb = new StringBuilder();
            str = "系统错误，网络错误，防刷，防雪崩 msg =";
        } else {
            sb = new StringBuilder();
            str = "业务错误 msg =";
        }
        sb.append(str);
        sb.append(mtopResponse.getRetMsg());
        AlibcLogger.e("AlibcMtop", sb.toString());
    }

    /* access modifiers changed from: private */
    public void a(MtopResponse mtopResponse, String str, String str2) {
        AlibcUserTradeHelper.sendUsabilityFailure("InvokeMtop", (mtopResponse.isSessionInvalid() ? "session 失效， do autologin or login business" : (mtopResponse.isSystemError() || mtopResponse.isNetworkError() || mtopResponse.isExpiredRequest() || mtopResponse.is41XResult() || mtopResponse.isApiLockedResult() || mtopResponse.isMtopSdkError()) ? "系统错误，网络错误，防刷，防雪崩 " : "业务错误 ") + str2, "1501" + str);
    }

    /* access modifiers changed from: private */
    public NetworkResponse b(MtopResponse mtopResponse) {
        NetworkResponse networkResponse = new NetworkResponse();
        if (mtopResponse == null) {
            return networkResponse;
        }
        networkResponse.byteData = mtopResponse.getBytedata();
        networkResponse.httpCode = mtopResponse.getResponseCode() + "";
        networkResponse.errorCode = mtopResponse.getRetCode();
        networkResponse.errorMsg = mtopResponse.getRetMsg();
        networkResponse.isSuccess = mtopResponse.isApiSuccess();
        if (mtopResponse.getDataJsonObject() != null) {
            String jSONObject = mtopResponse.getDataJsonObject().toString();
            networkResponse.data = (Map) JSONUtils.parseStringValue(jSONObject, Map.class);
            networkResponse.jsonData = jSONObject;
        }
        return networkResponse;
    }

    private MtopRequest b(NetworkRequest networkRequest) {
        if (TextUtils.isEmpty(networkRequest.apiVersion)) {
            networkRequest.apiVersion = "1.0";
        }
        MtopRequest mtopRequest = new MtopRequest();
        mtopRequest.setApiName(networkRequest.apiName);
        mtopRequest.setVersion(networkRequest.apiVersion);
        mtopRequest.setNeedEcode(networkRequest.needLogin);
        mtopRequest.setNeedSession(true);
        if (networkRequest.paramMap != null) {
            JSONObject jsonObject = JSONUtils.getJsonObject(mtopRequest.getData());
            if (jsonObject == null) {
                jsonObject = new JSONObject();
            }
            for (Map.Entry<String, Serializable> entry : networkRequest.paramMap.entrySet()) {
                if (entry.getValue() != null) {
                    try {
                        jsonObject.put(entry.getKey(), entry.getValue().toString());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            mtopRequest.setData(jsonObject.toString());
        }
        return mtopRequest;
    }

    /* access modifiers changed from: private */
    public JSNetworkResponse c(MtopResponse mtopResponse) {
        JSNetworkResponse jSNetworkResponse = new JSNetworkResponse();
        if (mtopResponse == null) {
            return jSNetworkResponse;
        }
        jSNetworkResponse.byteData = mtopResponse.getBytedata();
        jSNetworkResponse.httpCode = mtopResponse.getResponseCode() + "";
        jSNetworkResponse.errorCode = mtopResponse.getRetCode();
        jSNetworkResponse.errorMsg = mtopResponse.getRetMsg();
        jSNetworkResponse.isSuccess = mtopResponse.isApiSuccess();
        jSNetworkResponse.ret = mtopResponse.getRet();
        if (mtopResponse.getDataJsonObject() != null) {
            String jSONObject = mtopResponse.getDataJsonObject().toString();
            jSNetworkResponse.data = (Map) JSONUtils.parseStringValue(jSONObject, Map.class);
            jSNetworkResponse.jsonData = jSONObject;
        }
        return jSNetworkResponse;
    }

    @Override // com.alibaba.baichuan.trade.common.adapter.mtop.AlibcNetWork
    public void changeEnvMode(Environment environment) {
        Mtop mtopInstance;
        EnvModeEnum envModeEnum;
        if (environment == Environment.ONLINE) {
            mtopInstance = Mtop.getMtopInstance("OPEN");
            envModeEnum = EnvModeEnum.ONLINE;
        } else if (environment == Environment.PRE) {
            mtopInstance = Mtop.getMtopInstance("OPEN");
            envModeEnum = EnvModeEnum.PREPARE;
        } else if (environment == Environment.TEST) {
            mtopInstance = Mtop.getMtopInstance("OPEN");
            envModeEnum = EnvModeEnum.TEST;
        } else {
            mtopInstance = Mtop.getMtopInstance("OPEN");
            envModeEnum = EnvModeEnum.TEST_SANDBOX;
        }
        mtopInstance.switchEnvMode(envModeEnum);
    }

    @Override // com.alibaba.baichuan.trade.common.adapter.mtop.AlibcNetWork
    public int init() {
        AlibcLogger.d("AlibcMtop", "mtop init start");
        if (!AlibcTradeCommon.checkCommon() || !AlibcSecurityGuard.getInstance().isInitialized()) {
            return 1;
        }
        MtopSetting.setAuthCode("OPEN", "baichuan");
        MtopSetting.setAppKeyIndex("OPEN", 0, 0);
        MtopSetting.setAppVersion("OPEN", AlibcTradeCommon.systemVersion);
        MtopSetting.setMtopDomain("OPEN", "acs4baichuan.m.taobao.com", "acs4baichuan.wapa.taobao.com", "acs.waptest.taobao.com");
        Mtop.instance("OPEN", AlibcTradeCommon.context, AlibcTradeCommon.ttid);
        changeEnvMode(AlibcTradeCommon.getEnvironment());
        AlibcLogger.d("AlibcMtop", "mtop init end");
        return 0;
    }

    @Override // com.alibaba.baichuan.trade.common.adapter.mtop.NetworkClient
    public NetworkResponse sendRequest(NetworkRequest networkRequest) {
        if (networkRequest == null) {
            return null;
        }
        MtopBusiness build = MtopBusiness.build(Mtop.getMtopInstance("OPEN"), b(networkRequest), AlibcTradeCommon.ttid);
        if (networkRequest.needWua) {
            build.useWua();
        }
        if (networkRequest.needAuth && !networkRequest.isVip) {
            build.setNeedAuth(networkRequest.authParams, true);
        }
        if (networkRequest.isPost) {
            build.reqMethod(MethodEnum.POST);
        }
        build.setOpenBiz("baichuan");
        MtopResponse syncRequest = build.syncRequest();
        a(syncRequest);
        if (!syncRequest.isApiSuccess()) {
            String retCode = syncRequest.getRetCode();
            a(syncRequest, retCode, "errMsg = " + syncRequest.getRetMsg() + " ,api = " + syncRequest.getApi());
        } else {
            AlibcUserTradeHelper.sendUsabilitySuccess("InvokeMtop");
        }
        return b(syncRequest);
    }

    @Override // com.alibaba.baichuan.trade.common.adapter.mtop.NetworkClient
    public boolean sendRequest(final NetworkClient.JSNetworkRequestListener jSNetworkRequestListener, final NetworkRequest networkRequest) {
        if (networkRequest == null) {
            if (jSNetworkRequestListener != null) {
                jSNetworkRequestListener.onError(0, null);
            } else {
                AlibcLogger.e("AlibcMtop", "sendRequest 失败，request & listener 为 null");
            }
            return false;
        }
        a(networkRequest).registerListener((IRemoteListener) new IRemoteBaseListener() {
            /* class com.alibaba.baichuan.trade.common.adapter.mtop.a.b.AnonymousClass2 */

            @Override // com.taobao.tao.remotebusiness.IRemoteListener
            public void onError(int i, MtopResponse mtopResponse, Object obj) {
                b.this.a(mtopResponse);
                jSNetworkRequestListener.onError(networkRequest.requestType, b.this.c(mtopResponse));
                b bVar = b.this;
                String retCode = mtopResponse.getRetCode();
                bVar.a(mtopResponse, retCode, "errMsg = " + mtopResponse.getRetMsg() + " ,api = " + mtopResponse.getApi());
            }

            @Override // com.taobao.tao.remotebusiness.IRemoteListener
            public void onSuccess(int i, MtopResponse mtopResponse, BaseOutDo baseOutDo, Object obj) {
                b.this.a(mtopResponse);
                jSNetworkRequestListener.onSuccess(networkRequest.requestType, b.this.c(mtopResponse));
                AlibcUserTradeHelper.sendUsabilitySuccess("InvokeMtop");
            }

            @Override // com.taobao.tao.remotebusiness.IRemoteBaseListener
            public void onSystemError(int i, MtopResponse mtopResponse, Object obj) {
                b.this.a(mtopResponse);
                jSNetworkRequestListener.onError(networkRequest.requestType, b.this.c(mtopResponse));
                b bVar = b.this;
                String retCode = mtopResponse.getRetCode();
                bVar.a(mtopResponse, retCode, "errMsg = " + mtopResponse.getRetMsg() + " ,api = " + mtopResponse.getApi());
            }
        }).startRequest();
        return false;
    }

    @Override // com.alibaba.baichuan.trade.common.adapter.mtop.NetworkClient
    public boolean sendRequest(final NetworkClient.NetworkRequestListener networkRequestListener, final NetworkRequest networkRequest) {
        if (networkRequest == null) {
            if (networkRequestListener != null) {
                networkRequestListener.onError(0, null);
            } else {
                AlibcLogger.e("AlibcMtop", "sendRequest 失败，request & listener 为 null");
            }
            return false;
        }
        a(networkRequest).registerListener((IRemoteListener) new IRemoteBaseListener() {
            /* class com.alibaba.baichuan.trade.common.adapter.mtop.a.b.AnonymousClass1 */

            @Override // com.taobao.tao.remotebusiness.IRemoteListener
            public void onError(int i, MtopResponse mtopResponse, Object obj) {
                b.this.a(mtopResponse);
                networkRequestListener.onError(networkRequest.requestType, b.this.b(mtopResponse));
                b bVar = b.this;
                String retCode = mtopResponse.getRetCode();
                bVar.a(mtopResponse, retCode, "errMsg = " + mtopResponse.getRetMsg() + " ,api = " + mtopResponse.getApi());
            }

            @Override // com.taobao.tao.remotebusiness.IRemoteListener
            public void onSuccess(int i, MtopResponse mtopResponse, BaseOutDo baseOutDo, Object obj) {
                b.this.a(mtopResponse);
                networkRequestListener.onSuccess(networkRequest.requestType, b.this.b(mtopResponse));
                AlibcUserTradeHelper.sendUsabilitySuccess("InvokeMtop");
            }

            @Override // com.taobao.tao.remotebusiness.IRemoteBaseListener
            public void onSystemError(int i, MtopResponse mtopResponse, Object obj) {
                b.this.a(mtopResponse);
                networkRequestListener.onError(networkRequest.requestType, b.this.b(mtopResponse));
                b bVar = b.this;
                String retCode = mtopResponse.getRetCode();
                bVar.a(mtopResponse, retCode, "errMsg = " + mtopResponse.getRetMsg() + " ,api = " + mtopResponse.getApi());
            }
        }).startRequest();
        return true;
    }

    @Override // com.alibaba.baichuan.trade.common.adapter.mtop.AlibcNetWork
    public void setTTID(String str) {
        Mtop.getMtopInstance("OPEN").registerTtid(str);
    }

    @Override // com.alibaba.baichuan.trade.common.adapter.mtop.AlibcNetWork
    public void turnOffDebug() {
        TBSdkLog.setTLogEnabled(false);
        TBSdkLog.setPrintLog(false);
    }

    @Override // com.alibaba.baichuan.trade.common.adapter.mtop.AlibcNetWork
    public void turnOnDebug() {
        TBSdkLog.setTLogEnabled(true);
        TBSdkLog.setPrintLog(true);
    }
}
