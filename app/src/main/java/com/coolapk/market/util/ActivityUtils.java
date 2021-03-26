package com.coolapk.market.util;

import android.app.Activity;
import android.app.ActivityOptions;
import android.os.Build;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\n"}, d2 = {"Lcom/coolapk/market/util/ActivityUtils;", "", "()V", "convertActivityFromTranslucent", "", "activity", "Landroid/app/Activity;", "convertActivityToTranslucent", "convertActivityToTranslucentAfterL", "convertActivityToTranslucentBeforeL", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ActivityUtils.kt */
public final class ActivityUtils {
    public static final ActivityUtils INSTANCE = new ActivityUtils();

    private ActivityUtils() {
    }

    public final void convertActivityFromTranslucent(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        try {
            Method declaredMethod = Activity.class.getDeclaredMethod("convertFromTranslucent", new Class[0]);
            Intrinsics.checkNotNullExpressionValue(declaredMethod, "method");
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(activity, new Object[0]);
        } catch (Throwable unused) {
        }
    }

    public final void convertActivityToTranslucent(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (Build.VERSION.SDK_INT >= 21) {
            convertActivityToTranslucentAfterL(activity);
        } else {
            convertActivityToTranslucentBeforeL(activity);
        }
    }

    public final void convertActivityToTranslucentBeforeL(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        try {
            Class<?>[] declaredClasses = Activity.class.getDeclaredClasses();
            Class<?> cls = null;
            for (Class<?> cls2 : declaredClasses) {
                Intrinsics.checkNotNullExpressionValue(cls2, "clazz");
                String simpleName = cls2.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "clazz.simpleName");
                if (StringsKt.contains$default((CharSequence) simpleName, (CharSequence) "TranslucentConversionListener", false, 2, (Object) null)) {
                    cls = cls2;
                }
            }
            Method declaredMethod = Activity.class.getDeclaredMethod("convertToTranslucent", cls);
            Intrinsics.checkNotNullExpressionValue(declaredMethod, "method");
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(activity, new Object[]{null});
        } catch (Throwable unused) {
        }
    }

    private final void convertActivityToTranslucentAfterL(Activity activity) {
        try {
            Method declaredMethod = Activity.class.getDeclaredMethod("getActivityOptions", new Class[0]);
            Intrinsics.checkNotNullExpressionValue(declaredMethod, "getActivityOptions");
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(activity, new Object[0]);
            Class<?>[] declaredClasses = Activity.class.getDeclaredClasses();
            Class<?> cls = null;
            for (Class<?> cls2 : declaredClasses) {
                Intrinsics.checkNotNullExpressionValue(cls2, "clazz");
                String simpleName = cls2.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "clazz.simpleName");
                if (StringsKt.contains$default((CharSequence) simpleName, (CharSequence) "TranslucentConversionListener", false, 2, (Object) null)) {
                    cls = cls2;
                }
            }
            Method declaredMethod2 = Activity.class.getDeclaredMethod("convertToTranslucent", cls, ActivityOptions.class);
            Intrinsics.checkNotNullExpressionValue(declaredMethod2, "convertToTranslucent");
            declaredMethod2.setAccessible(true);
            declaredMethod2.invoke(activity, null, invoke);
        } catch (Throwable unused) {
        }
    }
}
