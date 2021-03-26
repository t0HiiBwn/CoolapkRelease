package com.alibaba.baichuan.trade.biz.core.taoke;

import android.text.TextUtils;
import com.alibaba.baichuan.trade.biz.context.AlibcTradeTaokeParam;
import com.alibaba.baichuan.trade.biz.core.config.AlibcConfigService;
import com.alibaba.baichuan.trade.biz.core.taoke.a.b;
import com.alibaba.baichuan.trade.biz.core.taoke.a.c;
import com.alibaba.baichuan.trade.common.AlibcTradeCommon;
import com.alibaba.baichuan.trade.common.adapter.mtop.NetworkResponse;
import com.alibaba.baichuan.trade.common.adapter.ut.AlibcUserTradeHelper;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import com.alibaba.baichuan.trade.common.utils.ExecutorServiceUtils;
import com.alibaba.baichuan.trade.common.utils.network.NetworkUtils;
import java.util.HashMap;
import java.util.Map;

public class AlibcPidTaokeComponent {
    public static final int ASYNC_TAOKE_TYPE = 0;
    public static final int ERRCODE_NO_NETWORK = -1;
    public static final int ERRCODE_PARAM_ERROR = -2;
    public static final String ERRMSG_NO_NETWORK = "没有网络,淘客打点失败";
    public static final String ERRMSG_PARAM_ERROR = "参数错误,淘客打点失败";
    public static final AlibcPidTaokeComponent INSTANCE = new AlibcPidTaokeComponent();
    public static final int SYNC_TAOKE_TYPE = 1;

    private AlibcPidTaokeComponent() {
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        AlibcUserTradeHelper.sendUsabilitySuccess(str);
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2) {
        AlibcUserTradeHelper.sendUsabilityFailure("Taoke_Trace", str, str2);
    }

    /* access modifiers changed from: private */
    public void a(HashMap<String, String> hashMap, String str, AlibcTradeTaokeParam alibcTradeTaokeParam, String str2) {
        c(hashMap, str, alibcTradeTaokeParam, str2);
    }

    private void a(Map<String, String> map, AlibcTradeTaokeParam alibcTradeTaokeParam, String str) {
        AlibcLogger.d("taoke", "添加淘客参数");
        if (map != null) {
            if (str == null) {
                str = "";
            }
            map.put("url", str);
            map.put("appKey", AlibcTradeCommon.getAppKey());
            map.put("utdid", AlibcTradeCommon.getUtdid());
            if (!TextUtils.isEmpty(alibcTradeTaokeParam.subPid)) {
                map.put("subPid", alibcTradeTaokeParam.subPid);
            } else {
                map.put("subPid", null);
            }
            if (!TextUtils.isEmpty(alibcTradeTaokeParam.unionId)) {
                map.put("unionId", alibcTradeTaokeParam.unionId);
            } else {
                map.put("unionId", null);
            }
            map.put("pid", alibcTradeTaokeParam.pid);
            AlibcLogger.d("taoke", "淘客参数设置后 taokeInfo" + map.toString());
        }
    }

    /* access modifiers changed from: private */
    public NetworkResponse b(HashMap<String, String> hashMap, String str, AlibcTradeTaokeParam alibcTradeTaokeParam, String str2) {
        if (alibcTradeTaokeParam == null) {
            return null;
        }
        b bVar = new b();
        if (alibcTradeTaokeParam.pid == null || !alibcTradeTaokeParam.pid.startsWith("mm_")) {
            AlibcLogger.d("taoke", "淘客pid参数错误");
        }
        NetworkResponse sendRequest = bVar.sendRequest(new HashMap(hashMap));
        if (sendRequest != null && !sendRequest.isSuccess()) {
            String str3 = sendRequest.errorMsg;
            a(str3, "1701" + sendRequest.errorCode);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("淘客打点rpc请求结果: ");
        sb.append(sendRequest == null ? "" : sendRequest.data);
        AlibcLogger.d("taoke", sb.toString());
        return sendRequest;
    }

    private void c(final HashMap<String, String> hashMap, final String str, final AlibcTradeTaokeParam alibcTradeTaokeParam, final String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("淘客异步打点,具体参数 taokeInfo = ");
        sb.append(hashMap != null ? hashMap.toString() : null);
        sb.append("\n url=");
        sb.append(str);
        sb.append("\n rpcReferer=");
        sb.append(str2);
        AlibcLogger.d("taoke", sb.toString());
        ExecutorServiceUtils.getInstance().postHandlerTask(new Runnable() {
            /* class com.alibaba.baichuan.trade.biz.core.taoke.AlibcPidTaokeComponent.AnonymousClass3 */

            @Override // java.lang.Runnable
            public void run() {
                String str;
                NetworkResponse b2 = AlibcPidTaokeComponent.this.b(hashMap, str, alibcTradeTaokeParam, str2);
                if (b2 == null || !b2.isSuccess) {
                    if (b2 == null) {
                        str = "null taokeTrace response";
                    } else {
                        str = "code: " + b2.errorCode + " msg: " + b2.errorMsg;
                    }
                    AlibcLogger.e("taoke", "淘客异步打点失败:" + str);
                    return;
                }
                AlibcPidTaokeComponent.this.a("Taoke_Trace");
                AlibcLogger.d("taoke", "淘客异步打点成功");
            }
        });
    }

    public void asyncTaokeTrace(final HashMap<String, String> hashMap, final AlibcTradeTaokeParam alibcTradeTaokeParam, final AlibcTaokeAsyncCallback alibcTaokeAsyncCallback) {
        if (hashMap != null && alibcTradeTaokeParam != null) {
            String str = null;
            a(hashMap, alibcTradeTaokeParam, (String) null);
            StringBuilder sb = new StringBuilder();
            sb.append("taoke异步打点开始，参数为：");
            if (hashMap != null) {
                str = hashMap.toString();
            }
            sb.append(str);
            AlibcLogger.d("taoke", sb.toString());
            ExecutorServiceUtils.getInstance().postHandlerTask(new Runnable() {
                /* class com.alibaba.baichuan.trade.biz.core.taoke.AlibcPidTaokeComponent.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    String str;
                    String str2;
                    String str3 = null;
                    NetworkResponse b2 = AlibcPidTaokeComponent.this.b(hashMap, null, alibcTradeTaokeParam, null);
                    if (b2 == null || !b2.isSuccess) {
                        if (b2 == null) {
                            str = "null taokeTrace response";
                        } else {
                            str = "code: " + b2.errorCode + " msg: " + b2.errorMsg;
                        }
                        if (str != null) {
                            str3 = str;
                        }
                        AlibcLogger.e("taoke", str3);
                        AlibcTaokeAsyncCallback alibcTaokeAsyncCallback = alibcTaokeAsyncCallback;
                        if (alibcTaokeAsyncCallback != null) {
                            alibcTaokeAsyncCallback.onFailure(0, "淘客打点失败，错误信息:" + str);
                        }
                        str2 = "taoke异步打点失败";
                    } else {
                        AlibcTaokeAsyncCallback alibcTaokeAsyncCallback2 = alibcTaokeAsyncCallback;
                        if (alibcTaokeAsyncCallback2 != null) {
                            alibcTaokeAsyncCallback2.onSuccess();
                        }
                        str2 = "taoke异步打点成功";
                    }
                    AlibcLogger.d("taoke", str2);
                }
            });
        }
    }

    public void genUrlAndTaokeTrace(final HashMap<String, String> hashMap, final String str, boolean z, final AlibcTradeTaokeParam alibcTradeTaokeParam, final String str2, final AlibcTaokeTraceCallback alibcTaokeTraceCallback) {
        AlibcLogger.d("taoke", "淘客打点流程,传入参数为 taokeInfo = " + hashMap + "\n url = " + str + "\n isGenSclick = " + z + "\n taokeParams = " + alibcTradeTaokeParam + "\n rpcReferer = " + str2 + "\n taokeTraceCallback = " + alibcTaokeTraceCallback);
        if (!NetworkUtils.isNetworkAvailable(AlibcTradeCommon.context)) {
            AlibcLogger.e("taoke", "网络无连接，请连接网络后再试");
            alibcTaokeTraceCallback.getTaokeUrl(0, str);
        } else if (hashMap == null || alibcTradeTaokeParam == null) {
            AlibcLogger.e("taoke", "淘客参数不存在");
            alibcTaokeTraceCallback.getTaokeUrl(0, str);
        } else {
            a(hashMap, alibcTradeTaokeParam, str);
            if (!z) {
                AlibcLogger.d("taoke", "不需要换sclick,走rpc发送淘客请求");
                a(hashMap, str, alibcTradeTaokeParam, str2);
                alibcTaokeTraceCallback.getTaokeUrl(0, str);
                return;
            }
            ExecutorServiceUtils.getInstance().postHandlerTask(new Runnable() {
                /* class com.alibaba.baichuan.trade.biz.core.taoke.AlibcPidTaokeComponent.AnonymousClass2 */

                @Override // java.lang.Runnable
                public void run() {
                    AlibcTaokeTraceCallback alibcTaokeTraceCallback;
                    String str;
                    int i = 1;
                    boolean isSyncForTaoke = AlibcConfigService.getInstance().getIsSyncForTaoke(true);
                    AlibcLogger.d("taoke", "isSyncForTaoke状态值为 = " + isSyncForTaoke);
                    if (isSyncForTaoke) {
                        AlibcLogger.d("taoke", "淘客同步打点");
                        NetworkResponse sendRequest = new c().sendRequest(new HashMap(hashMap));
                        str = c.a(sendRequest);
                        if (!TextUtils.isEmpty(str)) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("淘客同步打点成功,sclickUrl = ");
                            sb.append(sendRequest == null ? "" : sendRequest.data);
                            AlibcLogger.d("taoke", sb.toString());
                            AlibcPidTaokeComponent.this.a("Taoke_Trace");
                            alibcTaokeTraceCallback = alibcTaokeTraceCallback;
                            alibcTaokeTraceCallback.getTaokeUrl(i, str);
                        }
                        AlibcLogger.e("taoke", "淘客同步打点失败");
                        String str2 = "NetworkResponse_is_null";
                        String str3 = sendRequest == null ? str2 : sendRequest.errorMsg;
                        if (sendRequest != null) {
                            str2 = sendRequest.errorCode;
                        }
                        AlibcPidTaokeComponent alibcPidTaokeComponent = AlibcPidTaokeComponent.this;
                        alibcPidTaokeComponent.a(str3, "1702" + str2);
                    }
                    AlibcLogger.d("taoke", "淘客异步打点流程");
                    AlibcPidTaokeComponent.this.a(hashMap, str, alibcTradeTaokeParam, str2);
                    alibcTaokeTraceCallback = alibcTaokeTraceCallback;
                    i = 0;
                    str = str;
                    alibcTaokeTraceCallback.getTaokeUrl(i, str);
                }
            });
        }
    }
}
