package com.coolapk.market.widget.view;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: SourceWebView.kt */
final class SourceWebView$loadSourceRunnable$1 implements Runnable {
    final /* synthetic */ SourceWebView this$0;

    SourceWebView$loadSourceRunnable$1(SourceWebView sourceWebView) {
        this.this$0 = sourceWebView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.this$0.getCallback() != null && this.this$0.loadStartCount <= this.this$0.loadFinishCount) {
            this.this$0.loadUrl("javascript:window.local_obj.showSource('<html>'+document.getElementsByTagName('html')[0].innerHTML+'</html>');");
        }
    }
}
