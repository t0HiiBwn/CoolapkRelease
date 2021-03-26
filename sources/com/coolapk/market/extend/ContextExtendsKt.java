package com.coolapk.market.extend;

import android.app.Activity;
import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import com.coolapk.market.util.UiUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0002\u001a\u001e\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\bø\u0001\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\t"}, d2 = {"getActivity", "Landroid/app/Activity;", "Landroid/content/Context;", "requireAppCompatActivity", "Landroidx/appcompat/app/AppCompatActivity;", "runIfNotDestroy", "", "block", "Lkotlin/Function0;", "presentation_coolapkAppRelease"}, k = 2, mv = {1, 4, 2})
/* compiled from: ContextExtends.kt */
public final class ContextExtendsKt {
    public static final Activity getActivity(Context context) {
        Intrinsics.checkNotNullParameter(context, "$this$getActivity");
        return UiUtils.getActivityNullable(context);
    }

    public static final AppCompatActivity requireAppCompatActivity(Context context) {
        Intrinsics.checkNotNullParameter(context, "$this$requireAppCompatActivity");
        Activity activity = getActivity(context);
        if (activity != null) {
            if (!(activity instanceof AppCompatActivity)) {
                activity = null;
            }
            AppCompatActivity appCompatActivity = (AppCompatActivity) activity;
            if (appCompatActivity != null) {
                return appCompatActivity;
            }
        }
        throw new RuntimeException("Can not find AppCompatActivity");
    }

    public static final void runIfNotDestroy(Context context, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(context, "$this$runIfNotDestroy");
        Intrinsics.checkNotNullParameter(function0, "block");
        Activity activityNullable = UiUtils.getActivityNullable(context);
        if (activityNullable == null || !activityNullable.isDestroyed()) {
            function0.invoke();
        }
    }
}
