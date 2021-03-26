package com.coolapk.market.viewholder;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.view.base.FullScreenActivity;
import com.coolapk.market.view.webview.VideoWebViewFragment;
import com.coolapk.market.widget.ActivityLifecycleCallbacksAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"com/coolapk/market/viewholder/WebViewCardViewHolder$bindTo$3", "Lcom/coolapk/market/widget/ActivityLifecycleCallbacksAdapter;", "handler", "Landroid/os/Handler;", "onActivityDestroyed", "", "activity", "Landroid/app/Activity;", "onActivityPaused", "onActivityResumed", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: WebViewCardViewHolder.kt */
public final class WebViewCardViewHolder$bindTo$3 extends ActivityLifecycleCallbacksAdapter {
    final /* synthetic */ VideoWebViewFragment $childFragment;
    final /* synthetic */ Activity $itsActivity;
    private final Handler handler = new Handler(Looper.getMainLooper());
    final /* synthetic */ WebViewCardViewHolder this$0;

    WebViewCardViewHolder$bindTo$3(WebViewCardViewHolder webViewCardViewHolder, Activity activity, VideoWebViewFragment videoWebViewFragment) {
        this.this$0 = webViewCardViewHolder;
        this.$itsActivity = activity;
        this.$childFragment = videoWebViewFragment;
    }

    @Override // com.coolapk.market.widget.ActivityLifecycleCallbacksAdapter, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onActivityDestroyed(activity);
        if (Intrinsics.areEqual(activity, this.$itsActivity)) {
            this.handler.removeCallbacksAndMessages(null);
            WebView webView = this.$childFragment.getWebView();
            if (webView != null) {
                ViewExtendsKt.detachFromParent(webView);
            }
            WebView webView2 = this.$childFragment.getWebView();
            if (webView2 != null) {
                webView2.destroy();
            }
            AppHolder.getApplication().unregisterActivityLifecycleCallbacks(this);
        }
    }

    @Override // com.coolapk.market.widget.ActivityLifecycleCallbacksAdapter, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onActivityResumed(activity);
        this.handler.removeCallbacksAndMessages(null);
        if (AppHolder.getActivityStackManager().indexOfInstance(FullScreenActivity.class) >= 0 && this.this$0.isResumed()) {
            this.this$0.setResumed(false);
            WebView webView = this.$childFragment.getWebView();
            if (webView != null) {
                webView.onPause();
            }
        } else if (!this.this$0.isResumed()) {
            this.this$0.setResumed(true);
            WebView webView2 = this.$childFragment.getWebView();
            if (webView2 != null) {
                webView2.onResume();
            }
        }
    }

    @Override // com.coolapk.market.widget.ActivityLifecycleCallbacksAdapter, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onActivityPaused(activity);
        if (Intrinsics.areEqual(activity, this.$itsActivity) && this.this$0.isResumed()) {
            this.handler.postDelayed(new WebViewCardViewHolder$bindTo$3$onActivityPaused$1(this), 400);
        }
    }
}
