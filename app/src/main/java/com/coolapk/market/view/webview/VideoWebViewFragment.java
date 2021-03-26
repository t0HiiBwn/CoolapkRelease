package com.coolapk.market.view.webview;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.fragment.app.FragmentActivity;
import com.blankj.utilcode.util.ScreenUtils;
import com.coolapk.market.view.base.FullScreenActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 &2\u00020\u0001:\u0001&B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0002J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0014J\u0012\u0010\u0017\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J8\u0010\u0018\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u001c\u0010\u001f\u001a\u00020\u00122\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u0016J\u001a\u0010\"\u001a\u00020\u00122\u0006\u0010 \u001a\u00020#2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001c\u0010$\u001a\u00020\u00162\b\u0010%\u001a\u0004\u0018\u00010!2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006'"}, d2 = {"Lcom/coolapk/market/view/webview/VideoWebViewFragment;", "Lcom/coolapk/market/view/webview/WebViewFragment;", "()V", "initJS", "", "getInitJS", "()Ljava/lang/String;", "setInitJS", "(Ljava/lang/String;)V", "initUA", "getInitUA", "setInitUA", "initUrl", "getInitUrl", "setInitUrl", "getWrapperJS", "js", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onBackEvent", "", "onCreate", "onDownloadStart", "url", "userAgent", "contentDisposition", "mimetype", "contentLength", "", "onPageFinished", "view", "Landroid/webkit/WebView;", "onViewCreated", "Landroid/view/View;", "shouldOverrideUrlLoading", "webView", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: VideoWebViewFragment.kt */
public final class VideoWebViewFragment extends WebViewFragment {
    public static final Companion Companion = new Companion(null);
    public static final String EXTRA_JAVA_SCRIPT = "JAVA_SCRIPT";
    public static final String EXTRA_USER_AGENT = "USER_AGENT";
    private String initJS = "";
    private String initUA = "";
    private String initUrl = "";

    @JvmStatic
    public static final VideoWebViewFragment newInstance(String str, String str2, String str3) {
        return Companion.newInstance(str, str2, str3);
    }

    @Override // com.coolapk.market.view.webview.WebViewFragment
    protected boolean onBackEvent() {
        return false;
    }

    @Override // com.coolapk.market.view.webview.WebViewFragment, android.webkit.DownloadListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
    }

    public final String getInitUrl() {
        return this.initUrl;
    }

    public final void setInitUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.initUrl = str;
    }

    public final String getInitJS() {
        return this.initJS;
    }

    public final void setInitJS(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.initJS = str;
    }

    public final String getInitUA() {
        return this.initUA;
    }

    public final void setInitUA(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.initUA = str;
    }

    private final String getWrapperJS(String str) {
        return "javascript:void(function(){" + str + "})()";
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/coolapk/market/view/webview/VideoWebViewFragment$Companion;", "", "()V", "EXTRA_JAVA_SCRIPT", "", "EXTRA_USER_AGENT", "newInstance", "Lcom/coolapk/market/view/webview/VideoWebViewFragment;", "url", "js", "ua", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: VideoWebViewFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ VideoWebViewFragment newInstance$default(Companion companion, String str, String str2, String str3, int i, Object obj) {
            if ((i & 2) != 0) {
                str2 = "";
            }
            if ((i & 4) != 0) {
                str3 = "";
            }
            return companion.newInstance(str, str2, str3);
        }

        @JvmStatic
        public final VideoWebViewFragment newInstance(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "url");
            Intrinsics.checkNotNullParameter(str2, "js");
            Intrinsics.checkNotNullParameter(str3, "ua");
            VideoWebViewFragment videoWebViewFragment = new VideoWebViewFragment();
            Bundle bundle = new Bundle();
            bundle.putString("JAVA_SCRIPT", str2);
            bundle.putString("USER_AGENT", str3);
            bundle.putString("external_url", str);
            Unit unit = Unit.INSTANCE;
            videoWebViewFragment.setArguments(bundle);
            return videoWebViewFragment;
        }
    }

    @Override // com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String string = requireArguments().getString("external_url");
        Intrinsics.checkNotNull(string);
        this.initUrl = string;
        String string2 = requireArguments().getString("USER_AGENT", "");
        Intrinsics.checkNotNullExpressionValue(string2, "requireArguments().getString(EXTRA_USER_AGENT, \"\")");
        this.initUA = string2;
        String string3 = requireArguments().getString("JAVA_SCRIPT", "");
        Intrinsics.checkNotNullExpressionValue(string3, "requireArguments().getSt…ng(EXTRA_JAVA_SCRIPT, \"\")");
        this.initJS = string3;
    }

    @Override // com.coolapk.market.view.webview.WebViewFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        WebSettings settings;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        if (this.initUA.length() > 0) {
            WebView webView = getWebView();
            if (!(webView == null || (settings = webView.getSettings()) == null)) {
                settings.setUserAgentString(this.initUA);
            }
            WebView webView2 = getWebView();
            if (webView2 != null) {
                webView2.loadUrl(this.initUrl);
            }
        }
        setHasOptionsMenu(false);
    }

    @Override // com.coolapk.market.view.webview.WebViewFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (getActivity() instanceof FullScreenActivity) {
            FragmentActivity activity = getActivity();
            Intrinsics.checkNotNull(activity);
            ScreenUtils.setLandscape(activity);
        }
    }

    @Override // com.coolapk.market.view.webview.WebViewFragment, com.coolapk.market.view.webview.CoolWebViewCallback
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        if ((this.initJS.length() > 0) && webView != null) {
            webView.loadUrl(getWrapperJS(this.initJS));
        }
    }

    @Override // com.coolapk.market.view.webview.WebViewFragment, com.coolapk.market.view.webview.CoolWebViewCallback
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return str != null && !StringsKt.startsWith$default(str, "http", false, 2, null);
    }
}
