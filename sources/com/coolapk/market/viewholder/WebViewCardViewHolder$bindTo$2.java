package com.coolapk.market.viewholder;

import android.view.View;
import android.webkit.WebView;
import com.coolapk.market.view.webview.VideoWebViewFragment;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/coolapk/market/viewholder/WebViewCardViewHolder$bindTo$2", "Landroid/view/View$OnAttachStateChangeListener;", "onViewAttachedToWindow", "", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: WebViewCardViewHolder.kt */
public final class WebViewCardViewHolder$bindTo$2 implements View.OnAttachStateChangeListener {
    final /* synthetic */ VideoWebViewFragment $childFragment;
    final /* synthetic */ boolean $isFixTop;
    final /* synthetic */ WebViewCardViewHolder this$0;

    WebViewCardViewHolder$bindTo$2(WebViewCardViewHolder webViewCardViewHolder, boolean z, VideoWebViewFragment videoWebViewFragment) {
        this.this$0 = webViewCardViewHolder;
        this.$isFixTop = z;
        this.$childFragment = videoWebViewFragment;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        if (this.this$0.isResumed() && !this.$isFixTop) {
            this.this$0.setResumed(false);
            WebView webView = this.$childFragment.getWebView();
            if (webView != null) {
                webView.onPause();
            }
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        if (!this.this$0.isResumed() && !this.$isFixTop) {
            this.this$0.setResumed(true);
            WebView webView = this.$childFragment.getWebView();
            if (webView != null) {
                webView.onResume();
            }
        }
    }
}
