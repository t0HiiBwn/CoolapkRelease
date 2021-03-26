package com.coolapk.market.view.ad;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/coolapk/market/view/ad/AdConst;", "", "()V", "NAME_COOLAPK_SPLASH", "", "NAME_NONE", "NAME_QQ_FEED", "NAME_QQ_FEED2", "NAME_QQ_SELF_DRAW", "NAME_QQ_SPLASH", "NAME_TT_FEED", "NAME_TT_SELF_DRAW", "NAME_TT_SPLASH", "isQQPlatform", "", "name", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AdConst.kt */
public final class AdConst {
    public static final AdConst INSTANCE = new AdConst();
    public static final String NAME_COOLAPK_SPLASH = "COOLAPK_SPLASH";
    public static final String NAME_NONE = "NONE";
    public static final String NAME_QQ_FEED = "QQ_FEED";
    public static final String NAME_QQ_FEED2 = "QQ_FEED2";
    public static final String NAME_QQ_SELF_DRAW = "QQ_SELF_DRAW";
    public static final String NAME_QQ_SPLASH = "QQ_SPLASH";
    public static final String NAME_TT_FEED = "TT_FEED";
    public static final String NAME_TT_SELF_DRAW = "TT_SELF_DRAW";
    public static final String NAME_TT_SPLASH = "TT_SPLASH";

    private AdConst() {
    }

    @JvmStatic
    public static final boolean isQQPlatform(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        return Intrinsics.areEqual(str, "QQ_SPLASH") || Intrinsics.areEqual(str, "QQ_FEED");
    }
}
