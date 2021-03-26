package com.alibaba.baichuan.trade.biz.context;

import android.util.LruCache;
import android.webkit.WebView;
import com.alibaba.baichuan.trade.common.AlibcTradeCommon;
import com.alibaba.baichuan.trade.common.utils.ResourceUtils;
import java.util.Map;

public class AlibcTradeContextManager {
    private static LruCache<String, AlibcTradeContext> a = new LruCache<>(30);

    private static Integer a() {
        if (AlibcTradeCommon.context != null) {
            return Integer.valueOf(ResourceUtils.getRLayout(AlibcTradeCommon.context, "com_alibaba_bc_layout"));
        }
        return null;
    }

    public static void cleanMap() {
        for (Map.Entry<String, AlibcTradeContext> entry : a.snapshot().entrySet()) {
            AlibcTradeContext value = entry.getValue();
            if (value != null && !value.isValid()) {
                a.remove(entry.getKey());
            }
        }
    }

    public static AlibcTradeContext getContext(WebView webView) {
        Object tag;
        if (webView == null || (tag = webView.getTag(a().intValue())) == null) {
            return null;
        }
        return a.get(tag.toString());
    }

    public static void removeContext(WebView webView) {
        Object tag;
        if (webView != null && (tag = webView.getTag(a().intValue())) != null) {
            a.remove(tag.toString());
        }
    }

    public static void setContext(AlibcTradeContext alibcTradeContext) {
        WebView webView;
        if (alibcTradeContext != null && (webView = alibcTradeContext.webview.get()) != null) {
            webView.setTag(a().intValue(), Integer.valueOf(webView.hashCode()));
            a.put(String.valueOf(webView.hashCode()), alibcTradeContext);
        }
    }
}
