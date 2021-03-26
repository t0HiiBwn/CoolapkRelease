package com.alibaba.baichuan.trade.biz.core.a;

import android.text.TextUtils;
import com.alibaba.baichuan.trade.biz.core.jsbridge.AlibcJsCallbackContext;
import com.alibaba.baichuan.trade.biz.core.jsbridge.AlibcJsResult;
import com.alibaba.baichuan.trade.biz.core.jsbridge.plugin.AlibcApiPlugin;
import com.alibaba.baichuan.trade.common.adapter.ut.AlibcUserTracker;
import com.alibaba.fastjson.JSONObject;
import com.taobao.statistic.TBS;
import com.ut.mini.internal.UTTeamWork;
import java.util.HashMap;
import java.util.Set;

public class e extends AlibcApiPlugin {
    private void a(AlibcJsCallbackContext alibcJsCallbackContext) {
        try {
            UTTeamWork.getInstance().turnOffRealTimeDebug();
            alibcJsCallbackContext.success();
        } catch (Exception unused) {
            AlibcJsResult alibcJsResult = new AlibcJsResult();
            alibcJsResult.setResultCode("3");
            alibcJsCallbackContext.error(alibcJsResult);
        }
    }

    private void a(String str, AlibcJsCallbackContext alibcJsCallbackContext) {
        try {
            TBS.h5UT(str, alibcJsCallbackContext.getWebview());
            alibcJsCallbackContext.success();
        } catch (Exception unused) {
            AlibcJsResult alibcJsResult = new AlibcJsResult();
            alibcJsResult.setResultCode("3");
            alibcJsCallbackContext.error(alibcJsResult);
        }
    }

    private void b(AlibcJsCallbackContext alibcJsCallbackContext) {
        try {
            UTTeamWork.getInstance().turnOffRealTimeDebug();
            alibcJsCallbackContext.success();
        } catch (Exception unused) {
            AlibcJsResult alibcJsResult = new AlibcJsResult();
            alibcJsResult.setResultCode("3");
            alibcJsCallbackContext.error(alibcJsResult);
        }
    }

    private void b(String str, AlibcJsCallbackContext alibcJsCallbackContext) {
        if (TextUtils.isEmpty(str)) {
            AlibcJsResult alibcJsResult = new AlibcJsResult();
            alibcJsResult.setResultCode("2");
            alibcJsCallbackContext.error(alibcJsResult);
            return;
        }
        try {
            JSONObject parseObject = JSONObject.parseObject(str);
            Set<String> keySet = parseObject.keySet();
            HashMap hashMap = new HashMap();
            if (keySet != null && keySet.size() > 0) {
                for (String str2 : keySet) {
                    hashMap.put(str2, parseObject.get(str2).toString());
                }
                UTTeamWork.getInstance().turnOnRealTimeDebug(hashMap);
            }
            alibcJsCallbackContext.success();
        } catch (Exception unused) {
            AlibcJsResult alibcJsResult2 = new AlibcJsResult();
            alibcJsResult2.setResultCode("3");
            alibcJsCallbackContext.error(alibcJsResult2);
        }
    }

    private void c(String str, AlibcJsCallbackContext alibcJsCallbackContext) {
        if (TextUtils.isEmpty(str)) {
            AlibcJsResult alibcJsResult = new AlibcJsResult();
            alibcJsResult.setResultCode("2");
            alibcJsCallbackContext.error(alibcJsResult);
            return;
        }
        try {
            JSONObject parseObject = JSONObject.parseObject(str);
            Set<String> keySet = parseObject.keySet();
            HashMap hashMap = new HashMap();
            if (keySet != null && keySet.size() > 0) {
                for (String str2 : keySet) {
                    hashMap.put(str2, parseObject.get(str2).toString());
                }
                UTTeamWork.getInstance().turnOnRealTimeDebug(hashMap);
            }
            alibcJsCallbackContext.success();
        } catch (Exception unused) {
            AlibcJsResult alibcJsResult2 = new AlibcJsResult();
            alibcJsResult2.setResultCode("3");
            alibcJsCallbackContext.error(alibcJsResult2);
        }
    }

    @Override // com.alibaba.baichuan.trade.biz.core.jsbridge.plugin.AlibcApiPlugin
    public boolean execute(String str, String str2, AlibcJsCallbackContext alibcJsCallbackContext) {
        if (AlibcUserTracker.getInstance().isThirdVersion()) {
            AlibcJsResult alibcJsResult = new AlibcJsResult();
            alibcJsResult.setResultCode("6");
            alibcJsCallbackContext.error(alibcJsResult);
            return false;
        } else if ("toUT".equals(str)) {
            a(str2, alibcJsCallbackContext);
            return true;
        } else if ("turnOnUTRealtimeDebug".equals(str)) {
            b(str2, alibcJsCallbackContext);
            return true;
        } else if ("turnOffUTRealtimeDebug".equals(str)) {
            a(alibcJsCallbackContext);
            return true;
        } else if ("turnOnRealtimeDebug".equals(str)) {
            c(str2, alibcJsCallbackContext);
            return true;
        } else if (!"turnOffRealtimeDebug".equals(str)) {
            return false;
        } else {
            b(alibcJsCallbackContext);
            return true;
        }
    }
}
