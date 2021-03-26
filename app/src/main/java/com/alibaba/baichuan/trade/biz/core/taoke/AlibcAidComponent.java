package com.alibaba.baichuan.trade.biz.core.taoke;

import android.text.TextUtils;
import com.alibaba.baichuan.trade.biz.context.AlibcTradeTaokeParam;
import com.alibaba.baichuan.trade.biz.core.taoke.a.a;
import com.alibaba.baichuan.trade.common.AlibcTradeCommon;
import com.alibaba.baichuan.trade.common.adapter.mtop.NetworkClient;
import com.alibaba.baichuan.trade.common.adapter.mtop.NetworkResponse;
import com.alibaba.baichuan.trade.common.adapter.ut.AlibcUserTradeHelper;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import com.alibaba.baichuan.trade.common.utils.ExecutorServiceUtils;
import java.util.HashMap;
import java.util.Map;

public class AlibcAidComponent {
    private static Map<String, String> a(Map<String, String> map, String str, AlibcTradeTaokeParam alibcTradeTaokeParam) {
        HashMap hashMap = new HashMap();
        Map<String, String> map2 = alibcTradeTaokeParam.extraParams;
        hashMap.put("appkey", AlibcTradeCommon.getAppKey());
        hashMap.put("adzoneid", alibcTradeTaokeParam.adzoneid);
        hashMap.put("subpid", alibcTradeTaokeParam.subPid);
        hashMap.put("deviceModel", AlibcTradeCommon.getBuildModel());
        hashMap.put("os", "android" + AlibcTradeCommon.getSDKVersion());
        hashMap.put("pcv", "1.0");
        hashMap.put("sdkVersion", "");
        hashMap.put("mcid", "");
        hashMap.put("unid", alibcTradeTaokeParam.unionId);
        if (map2 != null) {
            if (!TextUtils.isEmpty(map2.get("taokeAppkey"))) {
                hashMap.put("taokeAppkey", map2.get("taokeAppkey"));
            }
            String str2 = map2.get("sellerId");
            if (str.contains("shop_id")) {
                str = str.replaceFirst("shop_id=\\d+", "user_id=" + str2);
            }
        }
        hashMap.put("url", str);
        return hashMap;
    }

    /* access modifiers changed from: private */
    public static void b(String str) {
        AlibcUserTradeHelper.sendUsabilitySuccess(str);
    }

    /* access modifiers changed from: private */
    public static void b(String str, String str2) {
        AlibcUserTradeHelper.sendUsabilityFailure("Taoke_Trace", str, str2);
    }

    public static void genTaokeUrl(boolean z, Map<String, String> map, final String str, AlibcTradeTaokeParam alibcTradeTaokeParam, final AlibcTaokeTraceCallback alibcTaokeTraceCallback) {
        if (alibcTradeTaokeParam != null && !TextUtils.isEmpty(str)) {
            final a aVar = new a();
            final Map<String, String> a = a(map, str, alibcTradeTaokeParam);
            ExecutorServiceUtils.getInstance().postHandlerTask(new Runnable() {
                /* class com.alibaba.baichuan.trade.biz.core.taoke.AlibcAidComponent.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    aVar.sendRequest(new HashMap(a), new NetworkClient.NetworkRequestListener() {
                        /* class com.alibaba.baichuan.trade.biz.core.taoke.AlibcAidComponent.AnonymousClass1.AnonymousClass1 */

                        @Override // com.alibaba.baichuan.trade.common.adapter.mtop.NetworkClient.NetworkRequestListener
                        public void onError(int i, NetworkResponse networkResponse) {
                            AlibcLogger.e("AlibcAidComponent", "网络请求失败::淘客同步打点失败");
                            alibcTaokeTraceCallback.getTaokeUrl(1, str);
                        }

                        @Override // com.alibaba.baichuan.trade.common.adapter.mtop.NetworkClient.NetworkRequestListener
                        public void onSuccess(int i, NetworkResponse networkResponse) {
                            String a2 = a.a(networkResponse);
                            if (!TextUtils.isEmpty(a2)) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("淘客同步打点：转链成功,sclickUrl = ");
                                sb.append(networkResponse == null ? "" : networkResponse.data);
                                AlibcLogger.d("AlibcAidComponent", sb.toString());
                                AlibcAidComponent.b("Taoke_Trace");
                                alibcTaokeTraceCallback.getTaokeUrl(1, a2);
                                return;
                            }
                            AlibcLogger.e("AlibcAidComponent", "淘客同步打点：转链失败");
                            String str = "NetworkResponse_is_null";
                            String str2 = networkResponse == null ? str : networkResponse.errorMsg;
                            if (networkResponse != null) {
                                str = networkResponse.errorCode;
                            }
                            AlibcAidComponent.b(str2, "1702" + str);
                            alibcTaokeTraceCallback.getTaokeUrl(1, str);
                        }
                    });
                }
            });
        }
    }
}
