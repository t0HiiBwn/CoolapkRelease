package com.coolapk.market.widget;

import com.coolapk.market.network.CoolApkRuntimeException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0001*\n\u0010\u0002\"\u00020\u00032\u00020\u0003¨\u0006\u0004"}, d2 = {"getMayBeCause", "", "AndroidToast", "Landroid/widget/Toast;", "presentation_coolapkAppRelease"}, k = 2, mv = {1, 4, 2})
/* compiled from: Toast.kt */
public final class ToastKt {
    public static final Throwable getMayBeCause(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "$this$getMayBeCause");
        Throwable cause = th.getCause();
        if (cause == null || !Intrinsics.areEqual(th.getClass(), RuntimeException.class) || !(!Intrinsics.areEqual(cause, th)) || !(!Intrinsics.areEqual(cause.getClass(), RuntimeException.class))) {
            return th;
        }
        String message = cause.getMessage();
        if (message == null) {
            message = "";
        }
        return StringsKt.contains$default(message, "OnError while", false, 2, null) ? new CoolApkRuntimeException(th.getMessage()) : cause;
    }
}
