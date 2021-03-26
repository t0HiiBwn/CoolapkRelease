package com.coolapk.market.view.webview;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.webkit.WebResourceRequest;
import com.coolapk.market.util.SystemUtils;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bH\u0016J\u0014\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u000eH\u0016J\u0010\u0010\u000f\u001a\n \f*\u0004\u0018\u00010\u00100\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0017R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/coolapk/market/view/webview/CoolWebResourceRequest;", "Landroid/webkit/WebResourceRequest;", "proxy", "context", "Landroid/content/Context;", "(Landroid/webkit/WebResourceRequest;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "getProxy", "()Landroid/webkit/WebResourceRequest;", "getMethod", "", "kotlin.jvm.PlatformType", "getRequestHeaders", "", "getUrl", "Landroid/net/Uri;", "hasGesture", "", "isForMainFrame", "isRedirect", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CoolWebResourceRequest.kt */
public final class CoolWebResourceRequest implements WebResourceRequest {
    public static final Companion Companion = new Companion(null);
    private final Context context;
    private final WebResourceRequest proxy;

    @JvmStatic
    public static final void appendCoolHost(Map<String, String> map, Context context2) {
        Companion.appendCoolHost(map, context2);
    }

    public CoolWebResourceRequest(WebResourceRequest webResourceRequest, Context context2) {
        Intrinsics.checkNotNullParameter(webResourceRequest, "proxy");
        Intrinsics.checkNotNullParameter(context2, "context");
        this.proxy = webResourceRequest;
        this.context = context2;
    }

    public final Context getContext() {
        return this.context;
    }

    public final WebResourceRequest getProxy() {
        return this.proxy;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/coolapk/market/view/webview/CoolWebResourceRequest$Companion;", "", "()V", "appendCoolHost", "", "result", "", "", "context", "Landroid/content/Context;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: CoolWebResourceRequest.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void appendCoolHost(Map<String, String> map, Context context) {
            Intrinsics.checkNotNullParameter(map, "result");
            Intrinsics.checkNotNullParameter(context, "context");
            Locale locale = Locale.getDefault();
            String valueOf = String.valueOf(Build.VERSION.SDK_INT);
            StringBuilder sb = new StringBuilder();
            Intrinsics.checkNotNullExpressionValue(locale, "locale");
            sb.append(locale.getLanguage());
            sb.append("-");
            sb.append(locale.getCountry());
            String sb2 = sb.toString();
            String versionName = SystemUtils.getVersionName(context);
            map.put("X-Sdk-Int", valueOf);
            map.put("X-Sdk-Locale", sb2);
            Intrinsics.checkNotNullExpressionValue(versionName, "version");
            map.put("X-App-Version", versionName);
        }
    }

    @Override // android.webkit.WebResourceRequest
    public boolean isRedirect() {
        return this.proxy.isRedirect();
    }

    @Override // android.webkit.WebResourceRequest
    public Uri getUrl() {
        return this.proxy.getUrl();
    }

    @Override // android.webkit.WebResourceRequest
    public String getMethod() {
        return this.proxy.getMethod();
    }

    @Override // android.webkit.WebResourceRequest
    public boolean hasGesture() {
        return this.proxy.hasGesture();
    }

    @Override // android.webkit.WebResourceRequest
    public boolean isForMainFrame() {
        return this.proxy.isForMainFrame();
    }

    @Override // android.webkit.WebResourceRequest
    public Map<String, String> getRequestHeaders() {
        HashMap hashMap;
        if (this.proxy.getRequestHeaders() == null) {
            hashMap = new HashMap();
        } else {
            hashMap = new HashMap(this.proxy.getRequestHeaders());
        }
        HashMap hashMap2 = hashMap;
        Companion.appendCoolHost(hashMap2, this.context);
        return hashMap2;
    }
}
