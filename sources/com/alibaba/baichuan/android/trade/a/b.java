package com.alibaba.baichuan.android.trade.a;

import android.webkit.WebView;
import com.alibaba.baichuan.android.trade.page.AlibcMyOrdersPage;
import com.alibaba.baichuan.trade.common.AlibcTradeCommon;
import com.alibaba.baichuan.trade.common.messagebus.AlibcMessageListener;
import com.alibaba.baichuan.trade.common.utils.ResourceUtils;

public class b extends AlibcMessageListener {
    public b() {
        super(6002, true);
    }

    @Override // com.alibaba.baichuan.trade.common.messagebus.AlibcMessageListener
    public void onMessageEvent(int i, Object obj) {
        if (obj != null && (obj instanceof WebView)) {
            WebView webView = (WebView) obj;
            AlibcMyOrdersPage alibcMyOrdersPage = new AlibcMyOrdersPage(0, true);
            webView.setTag(ResourceUtils.getIdentifier(AlibcTradeCommon.context, "id", "webviewload_monitor_cancel_point"), true);
            webView.loadUrl(alibcMyOrdersPage.genOpenUrl());
        }
    }
}
