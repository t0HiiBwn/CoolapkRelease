package com.coolapk.market.manager;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.coolapk.market.util.PackageUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u000eH\u0007J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u000e\u0010\u0018\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u0019\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/coolapk/market/manager/BearStoryHelper;", "", "()V", "JD_HOST", "", "TB_HOST", "TB_PACKAGE", "TM_PACKAGE", "UL_HOST", "bearStoreUrlJump", "", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "checkBearStoryAutoJump", "", "activity", "Landroid/app/Activity;", "originUrl", "notHttpUri", "isBearStoryUrl", "isInnerBrowserUrl", "isOuterBrowserUrl", "isPearProgram", "isTBJDSpecialUri", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: BearStoryHelper.kt */
public final class BearStoryHelper {
    public static final BearStoryHelper INSTANCE = new BearStoryHelper();
    public static final String JD_HOST = "union-click.jd.com";
    public static final String TB_HOST = "s.click.taobao.com";
    public static final String TB_PACKAGE = "com.taobao.taobao";
    public static final String TM_PACKAGE = "com.tmall.wireless";
    public static final String UL_HOST = "uland.taobao.com";

    private BearStoryHelper() {
    }

    @JvmStatic
    public static final boolean isInnerBrowserUrl(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        String host = uri.getHost();
        if (host != null) {
            Intrinsics.checkNotNullExpressionValue(host, "uri.host ?: return false");
            if (uri.isOpaque()) {
                return false;
            }
            if ((StringsKt.endsWith$default(host, ".coolapk.com", false, 2, (Object) null) || Intrinsics.areEqual(host, "coolapk.com")) && Intrinsics.areEqual(uri.getQueryParameter("innerbrowser"), "1")) {
                return true;
            }
        }
        return false;
    }

    @JvmStatic
    public static final boolean isOuterBrowserUrl(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        String host = uri.getHost();
        if (host != null) {
            Intrinsics.checkNotNullExpressionValue(host, "uri.host ?: return false");
            if (uri.isOpaque()) {
                return false;
            }
            if ((StringsKt.endsWith$default(host, ".coolapk.com", false, 2, (Object) null) || Intrinsics.areEqual(host, "coolapk.com")) && Intrinsics.areEqual(uri.getQueryParameter("outerbrowser"), "1")) {
                return true;
            }
        }
        return false;
    }

    @JvmStatic
    public static final boolean isBearStoryUrl(Uri uri) {
        String queryParameter;
        Intrinsics.checkNotNullParameter(uri, "uri");
        if (!uri.isOpaque() && (queryParameter = uri.getQueryParameter("frombear")) != null) {
            if (!(queryParameter.length() == 0)) {
                String uri2 = uri.toString();
                Intrinsics.checkNotNullExpressionValue(uri2, "uri.toString()");
                String replace$default = StringsKt.replace$default(uri2, queryParameter, "1", false, 4, (Object) null);
                return Intrinsics.areEqual(String.valueOf(StringsKt.replace$default(replace$default, "&title=" + uri.getQueryParameter("title"), "", false, 4, (Object) null).hashCode()), queryParameter);
            }
        }
        return false;
    }

    public final boolean isPearProgram(Uri uri) {
        String queryParameter;
        Intrinsics.checkNotNullParameter(uri, "uri");
        if (!uri.isOpaque() && (queryParameter = uri.getQueryParameter("pearid")) != null) {
            if (!(queryParameter.length() == 0)) {
                String uri2 = uri.toString();
                Intrinsics.checkNotNullExpressionValue(uri2, "uri.toString()");
                return Intrinsics.areEqual(String.valueOf(StringsKt.replace$default(uri2, "&pearid=" + queryParameter, "", false, 4, (Object) null).hashCode()), queryParameter);
            }
        }
        return false;
    }

    public final void bearStoreUrlJump(Context context, Uri uri) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        intent.addFlags(268435456);
        String host = uri.getHost();
        if (host != null) {
            int hashCode = host.hashCode();
            if (hashCode != -1632194302) {
                if (hashCode == -290457551) {
                    host.equals("union-click.jd.com");
                }
            } else if (host.equals("s.click.taobao.com")) {
                if (PackageUtils.isInstalled(context, "com.taobao.taobao")) {
                    intent.setComponent(new ComponentName("com.taobao.taobao", "com.taobao.browser.BrowserActivity"));
                    try {
                        context.startActivity(intent);
                        return;
                    } catch (Exception unused) {
                    }
                } else if (PackageUtils.isInstalled(context, "com.tmall.wireless")) {
                    intent.setComponent(new ComponentName("com.tmall.wireless", "com.tmall.wireless.splash.TMSplashActivity"));
                    context.startActivity(intent);
                    return;
                }
            }
        }
        ActionManager.startWebViewActivity(context, uri.toString());
    }

    @JvmStatic
    public static final boolean checkBearStoryAutoJump(Activity activity, String str, Uri uri) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(str, "originUrl");
        Intrinsics.checkNotNullParameter(uri, "notHttpUri");
        Uri parse = Uri.parse(str);
        Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(originUrl)");
        if (!isBearStoryUrl(parse)) {
            return false;
        }
        try {
            ActionManager.startRawView(activity, uri, null);
            activity.finish();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private final boolean isTBJDSpecialUri(Uri uri) {
        return Intrinsics.areEqual(uri.getScheme(), "openapp.jdmobile") || Intrinsics.areEqual(uri.getScheme(), "tbopen");
    }
}
