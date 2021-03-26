package com.alibaba.baichuan.trade.biz.core.a;

import android.text.TextUtils;
import com.alibaba.baichuan.trade.biz.context.AlibcTradeContext;
import com.alibaba.baichuan.trade.biz.context.AlibcTradeContextManager;
import com.alibaba.baichuan.trade.biz.core.jsbridge.AlibcJsCallbackContext;
import com.alibaba.baichuan.trade.biz.core.jsbridge.AlibcJsResult;
import com.alibaba.baichuan.trade.biz.core.jsbridge.plugin.AlibcApiPlugin;
import com.alibaba.baichuan.trade.biz.utils.AlibcTradeHelper;
import com.alibaba.baichuan.trade.common.utils.StringUtils;
import com.alibaba.fastjson.JSON;
import java.util.Map;

public class f extends AlibcApiPlugin {
    public static String a = "AliBCWebView";

    public void a(AlibcJsCallbackContext alibcJsCallbackContext, String str) {
        Map<String, String> createUrlParams;
        AlibcTradeContext context;
        Map<String, String> obj2MapString = StringUtils.obj2MapString(JSON.parseObject(str));
        if (!(obj2MapString == null || (createUrlParams = AlibcTradeHelper.createUrlParams(obj2MapString)) == null || createUrlParams.size() <= 0 || (context = AlibcTradeContextManager.getContext(this.mWebView)) == null)) {
            for (Map.Entry<String, String> entry : createUrlParams.entrySet()) {
                context.urlParam.put(entry.getKey(), entry.getValue());
            }
        }
        AlibcJsResult alibcJsResult = new AlibcJsResult();
        alibcJsResult.setResultCode("0");
        alibcJsCallbackContext.success(alibcJsResult);
    }

    @Override // com.alibaba.baichuan.trade.biz.core.jsbridge.plugin.AlibcApiPlugin
    public boolean execute(String str, String str2, AlibcJsCallbackContext alibcJsCallbackContext) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || alibcJsCallbackContext == null) {
            AlibcJsResult alibcJsResult = new AlibcJsResult("6");
            alibcJsResult.setResultCode("2");
            if (alibcJsCallbackContext == null) {
                return false;
            }
            alibcJsCallbackContext.error(alibcJsResult);
            return false;
        } else if (!"setYbhpss".equals(str)) {
            return true;
        } else {
            a(alibcJsCallbackContext, str2);
            return true;
        }
    }
}
