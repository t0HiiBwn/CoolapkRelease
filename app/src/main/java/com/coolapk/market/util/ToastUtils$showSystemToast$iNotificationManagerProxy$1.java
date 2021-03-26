package com.coolapk.market.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0004\u001a\n \u0002*\u0004\u0018\u00010\u00050\u00052,\u0010\u0006\u001a(\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001 \u0002*\u0014\u0012\u000e\b\u0001\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\u00070\u0007H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "proxy", "method", "Ljava/lang/reflect/Method;", "args", "", "invoke", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
/* compiled from: ToastUtils.kt */
final class ToastUtils$showSystemToast$iNotificationManagerProxy$1 implements InvocationHandler {
    public static final ToastUtils$showSystemToast$iNotificationManagerProxy$1 INSTANCE = new ToastUtils$showSystemToast$iNotificationManagerProxy$1();

    ToastUtils$showSystemToast$iNotificationManagerProxy$1() {
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        Intrinsics.checkNotNullExpressionValue(method, "method");
        if (Intrinsics.areEqual("enqueueToast", method.getName()) || Intrinsics.areEqual("enqueueToastEx", method.getName())) {
            objArr[0] = "android";
        }
        return method.invoke(ToastUtils.access$getINotificationManagerObj$p(ToastUtils.INSTANCE), Arrays.copyOf(objArr, objArr.length));
    }
}
