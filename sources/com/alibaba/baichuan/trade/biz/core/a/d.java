package com.alibaba.baichuan.trade.biz.core.a;

import android.text.TextUtils;
import com.alibaba.baichuan.trade.biz.AlibcTradeBiz;
import com.alibaba.baichuan.trade.biz.core.jsbridge.AlibcJsCallbackContext;
import com.alibaba.baichuan.trade.biz.core.jsbridge.AlibcJsResult;
import com.alibaba.baichuan.trade.biz.core.jsbridge.plugin.AlibcApiPlugin;
import com.alibaba.baichuan.trade.common.AlibcMiniTradeCommon;
import com.alibaba.baichuan.trade.common.adapter.mtop.AlibcMtop;
import com.alibaba.baichuan.trade.common.adapter.mtop.JSNetworkResponse;
import com.alibaba.baichuan.trade.common.adapter.mtop.NetworkClient;
import com.alibaba.baichuan.trade.common.adapter.mtop.NetworkRequest;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import com.alibaba.baichuan.trade.common.utils.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.util.HashMap;
import java.util.Map;

public class d extends AlibcApiPlugin {
    private NetworkRequest a(Map<String, Object> map) {
        NetworkRequest networkRequest = new NetworkRequest();
        if (map == null) {
            return networkRequest;
        }
        String obj2String = StringUtils.obj2String(map.get("ttid"));
        networkRequest.apiName = StringUtils.obj2String(map.get("api"));
        networkRequest.apiVersion = StringUtils.obj2String(map.get("version"));
        networkRequest.needLogin = StringUtils.obj2Boolean(map.get("needLogin"));
        networkRequest.needWua = StringUtils.obj2Boolean(map.get("needWua"));
        networkRequest.needAuth = StringUtils.obj2Boolean(map.get("needAuth"));
        networkRequest.isPost = StringUtils.obj2Boolean(map.get("isPost") == null ? "true" : map.get("isPost"));
        networkRequest.extHeaders = StringUtils.obj2MapString(map.get("ext_headers"));
        networkRequest.timeOut = StringUtils.obj2Long(map.get("timeout")).intValue();
        networkRequest.requestType = networkRequest.hashCode();
        networkRequest.ttid = a(obj2String);
        networkRequest.showAuthUI = StringUtils.obj2Boolean(map.get("autoLogin"));
        networkRequest.extQueries = StringUtils.obj2MapString(map.get("extQueries"));
        AlibcMtop.getInstance().setTTID(networkRequest.ttid);
        JSONObject parseObject = JSONObject.parseObject(StringUtils.obj2String(map.get("params")));
        if (parseObject != null) {
            HashMap hashMap = new HashMap();
            for (String str : parseObject.keySet()) {
                Object obj = parseObject.get(str);
                if (obj != null) {
                    hashMap.put(str, obj.toString());
                }
            }
            networkRequest.paramMap = hashMap;
        }
        return networkRequest;
    }

    private String a(String str) {
        return TextUtils.isEmpty(str) ? String.format("2014_%s_%s@baichuan_android_%s", AlibcTradeBiz.channel, AlibcMiniTradeCommon.getAppKey(), AlibcTradeBiz.systemVersion) : str;
    }

    /* access modifiers changed from: private */
    public void a(AlibcJsCallbackContext alibcJsCallbackContext, JSNetworkResponse jSNetworkResponse) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("data", JSON.parse(jSNetworkResponse.jsonData));
            jSONObject.put("ret", (Object) jSNetworkResponse.ret);
        } catch (Exception e) {
            AlibcLogger.e("AlibcNetworkPlugin", e.getMessage());
        }
        alibcJsCallbackContext.success(JSON.toJSONString(jSONObject, SerializerFeature.WRITE_MAP_NULL_FEATURES | SerializerFeature.QuoteFieldNames.mask, new SerializerFeature[0]));
    }

    @Override // com.alibaba.baichuan.trade.biz.core.jsbridge.plugin.AlibcApiPlugin
    public boolean execute(String str, String str2, final AlibcJsCallbackContext alibcJsCallbackContext) {
        Map<String, Object> map;
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || alibcJsCallbackContext == null) {
            AlibcJsResult alibcJsResult = new AlibcJsResult("6");
            alibcJsResult.setResultCode("2");
            if (alibcJsCallbackContext != null) {
                alibcJsCallbackContext.error(alibcJsResult);
            }
            return false;
        }
        try {
            map = StringUtils.obj2MapObject(JSON.parseObject(str2));
        } catch (Exception unused) {
            AlibcLogger.e("AliBCNetWork", "isInstall parse params error, params: " + str2);
            int length = str2.length();
            if ("} bc_hybrid:".equals(str2.substring(length - 12, length))) {
                String substring = str2.substring(0, length - 11);
                try {
                    map = StringUtils.obj2MapObject(JSON.parseObject(substring));
                } catch (Exception unused2) {
                    AlibcLogger.e("AliBCNetWork", "isInstall parse params error, params: " + substring);
                    return false;
                }
            }
            return false;
        }
        NetworkRequest a = a(map);
        if (a == null || !a.check()) {
            AlibcJsResult alibcJsResult2 = new AlibcJsResult("6");
            alibcJsResult2.setResultCode("2");
            alibcJsCallbackContext.error(alibcJsResult2);
            return false;
        }
        AlibcMtop.getInstance().sendRequest(new NetworkClient.JSNetworkRequestListener() {
            /* class com.alibaba.baichuan.trade.biz.core.a.d.AnonymousClass1 */

            @Override // com.alibaba.baichuan.trade.common.adapter.mtop.NetworkClient.JSNetworkRequestListener
            public void onError(int i, JSNetworkResponse jSNetworkResponse) {
                d.this.a(alibcJsCallbackContext, jSNetworkResponse);
            }

            @Override // com.alibaba.baichuan.trade.common.adapter.mtop.NetworkClient.JSNetworkRequestListener
            public void onSuccess(int i, JSNetworkResponse jSNetworkResponse) {
                d.this.a(alibcJsCallbackContext, jSNetworkResponse);
            }
        }, a);
        return true;
    }
}
