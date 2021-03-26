package com.coolapk.market.viewholder;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: WebViewCardViewHolder.kt */
final class WebViewCardViewHolder$bindTo$3$onActivityPaused$1 implements Runnable {
    final /* synthetic */ WebViewCardViewHolder$bindTo$3 this$0;

    WebViewCardViewHolder$bindTo$3$onActivityPaused$1(WebViewCardViewHolder$bindTo$3 webViewCardViewHolder$bindTo$3) {
        this.this$0 = webViewCardViewHolder$bindTo$3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.this$0.this$0.restoreToBlankPage();
    }
}
