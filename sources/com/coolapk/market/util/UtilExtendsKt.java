package com.coolapk.market.util;

import android.app.Activity;
import android.net.Uri;
import android.view.View;
import com.coolapk.market.AppHolder;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.Ads;
import com.coolapk.market.model.User;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\bø\u0001\u0000\u001a\u001e\u0010\u0004\u001a\u00020\u0001*\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t\u001a\n\u0010\n\u001a\u00020\u000b*\u00020\u000b\u0002\u0007\n\u0005\b20\u0001¨\u0006\f"}, d2 = {"checkLogin", "", "action", "Lkotlin/Function0;", "clipViewByData", "Landroid/view/View;", "any", "", "radiusSize", "", "toSafeFileUri", "Landroid/net/Uri;", "presentation_coolapkAppRelease"}, k = 2, mv = {1, 4, 2})
/* compiled from: UtilExtends.kt */
public final class UtilExtendsKt {
    public static /* synthetic */ void clipViewByData$default(View view, Object obj, int i, int i2, Object obj2) {
        if ((i2 & 2) != 0) {
            i = 8;
        }
        clipViewByData(view, obj, i);
    }

    public static final void clipViewByData(View view, Object obj, int i) {
        Intrinsics.checkNotNullParameter(view, "$this$clipViewByData");
        if ((obj instanceof User) || ((obj instanceof Ads) && Intrinsics.areEqual(((Ads) obj).getAdsType(), "user"))) {
            ViewExtendsKt.clipView$default(view, 1, 0.0f, 2, null);
        } else {
            ViewExtendsKt.clipView$default(view, 0, (float) NumberExtendsKt.getDp(Integer.valueOf(i)), 1, null);
        }
    }

    public static final void checkLogin(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "action");
        Activity currentActivity = AppHolder.getCurrentActivity();
        if (currentActivity != null) {
            Boolean checkLogin = ActionManager.checkLogin(currentActivity);
            Intrinsics.checkNotNullExpressionValue(checkLogin, "ActionManager.checkLogin(it)");
            if (checkLogin.booleanValue()) {
                function0.invoke();
            }
        }
    }

    public static final Uri toSafeFileUri(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "$this$toSafeFileUri");
        if (!Intrinsics.areEqual(uri.getScheme(), "file")) {
            return uri;
        }
        Uri fromFile = Uri.fromFile(CoolFileUtils.unwrapToFile(uri));
        Intrinsics.checkNotNullExpressionValue(fromFile, "Uri.fromFile(CoolFileUtils.unwrapToFile(this))");
        return fromFile;
    }
}
