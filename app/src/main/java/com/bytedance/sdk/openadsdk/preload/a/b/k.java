package com.bytedance.sdk.openadsdk.preload.a.b;

import java.lang.reflect.Type;

/* compiled from: Primitives */
public final class k {
    public static boolean a(Type type) {
        return (type instanceof Class) && ((Class) type).isPrimitive();
    }
}
