package com.coolapk.market.widget.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.coolapk.market.AppHolder;
import com.coolapk.market.util.LogUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0014\u0015B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/coolapk/market/widget/view/SourceWebView;", "Landroid/webkit/WebView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "callback", "Lcom/coolapk/market/widget/view/SourceWebView$SourceCallback;", "getCallback", "()Lcom/coolapk/market/widget/view/SourceWebView$SourceCallback;", "setCallback", "(Lcom/coolapk/market/widget/view/SourceWebView$SourceCallback;)V", "lastStartingUrl", "", "loadFinishCount", "", "loadSourceRunnable", "Ljava/lang/Runnable;", "loadStartCount", "JavaScriptLocalObj", "SourceCallback", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SourceWebView.kt */
public final class SourceWebView extends WebView {
    private SourceCallback callback;
    private String lastStartingUrl = "";
    private int loadFinishCount;
    private final Runnable loadSourceRunnable = new SourceWebView$loadSourceRunnable$1(this);
    private int loadStartCount;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/widget/view/SourceWebView$SourceCallback;", "", "showSource", "", "url", "", "html", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SourceWebView.kt */
    public interface SourceCallback {
        void showSource(String str, String str2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SourceWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        WebSettings settings = getSettings();
        Intrinsics.checkNotNullExpressionValue(settings, "settings");
        settings.setJavaScriptEnabled(true);
        WebSettings settings2 = getSettings();
        Intrinsics.checkNotNullExpressionValue(settings2, "settings");
        settings2.setUserAgentString("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.102 Safari/537.36");
        addJavascriptInterface(new JavaScriptLocalObj(new Function1<String, Unit>(this) {
            /* class com.coolapk.market.widget.view.SourceWebView.AnonymousClass1 */
            final /* synthetic */ SourceWebView this$0;

            {
                this.this$0 = r1;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke(str);
                return Unit.INSTANCE;
            }

            public final void invoke(String str) {
                Intrinsics.checkNotNullParameter(str, "it");
                SourceCallback callback = this.this$0.getCallback();
                if (callback != null) {
                    callback.showSource(this.this$0.lastStartingUrl, str);
                }
            }
        }), "local_obj");
        setWebViewClient(new WebViewClient(this) {
            /* class com.coolapk.market.widget.view.SourceWebView.AnonymousClass2 */
            final /* synthetic */ SourceWebView this$0;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.this$0 = r1;
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                Intrinsics.checkNotNullParameter(webView, "view");
                Intrinsics.checkNotNullParameter(str, "url");
                super.onPageStarted(webView, str, bitmap);
                this.this$0.lastStartingUrl = str;
                this.this$0.loadStartCount++;
                LogUtils.d("onPageStarted " + str, new Object[0]);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                Intrinsics.checkNotNullParameter(webView, "view");
                Intrinsics.checkNotNullParameter(str, "url");
                super.onPageFinished(webView, str);
                LogUtils.d("onPageFinished " + str, new Object[0]);
                SourceWebView sourceWebView = this.this$0;
                sourceWebView.loadFinishCount = sourceWebView.loadFinishCount + 1;
                AppHolder.getMainThreadHandler().removeCallbacks(this.this$0.loadSourceRunnable);
                AppHolder.getMainThreadHandler().postDelayed(this.this$0.loadSourceRunnable, 2000);
            }
        });
    }

    public final SourceCallback getCallback() {
        return this.callback;
    }

    public final void setCallback(SourceCallback sourceCallback) {
        this.callback = sourceCallback;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0004H\u0007R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coolapk/market/widget/view/SourceWebView$JavaScriptLocalObj;", "", "callback", "Lkotlin/Function1;", "", "", "(Lkotlin/jvm/functions/Function1;)V", "getCallback", "()Lkotlin/jvm/functions/Function1;", "showSource", "html", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SourceWebView.kt */
    public static final class JavaScriptLocalObj {
        private final Function1<String, Unit> callback;

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> */
        /* JADX WARN: Multi-variable type inference failed */
        public JavaScriptLocalObj(Function1<? super String, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "callback");
            this.callback = function1;
        }

        public final Function1<String, Unit> getCallback() {
            return this.callback;
        }

        @JavascriptInterface
        public final void showSource(String str) {
            Intrinsics.checkNotNullParameter(str, "html");
            this.callback.invoke(str);
        }
    }
}
