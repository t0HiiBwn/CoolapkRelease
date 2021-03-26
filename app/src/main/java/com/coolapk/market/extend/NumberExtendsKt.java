package com.coolapk.market.extend;

import android.app.Application;
import android.content.res.Resources;
import android.util.TypedValue;
import com.blankj.utilcode.util.ConvertUtils;
import com.coolapk.market.AppHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u0015\u0010\t\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\n\u0010\u0004¨\u0006\u000b"}, d2 = {"dp", "", "", "getDp", "(Ljava/lang/Number;)I", "dpf", "", "getDpf", "(Ljava/lang/Number;)F", "sp", "getSp", "presentation_coolapkAppRelease"}, k = 2, mv = {1, 4, 2})
/* compiled from: NumberExtends.kt */
public final class NumberExtendsKt {
    public static final int getDp(Number number) {
        Intrinsics.checkNotNullParameter(number, "$this$dp");
        return ConvertUtils.dp2px(number.floatValue());
    }

    public static final float getDpf(Number number) {
        Intrinsics.checkNotNullParameter(number, "$this$dpf");
        float floatValue = number.floatValue();
        Application application = AppHolder.getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "AppHolder.getApplication()");
        Resources resources = application.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "AppHolder.getApplication().resources");
        return TypedValue.applyDimension(1, floatValue, resources.getDisplayMetrics());
    }

    public static final int getSp(Number number) {
        Intrinsics.checkNotNullParameter(number, "$this$sp");
        return ConvertUtils.sp2px(number.floatValue());
    }
}
