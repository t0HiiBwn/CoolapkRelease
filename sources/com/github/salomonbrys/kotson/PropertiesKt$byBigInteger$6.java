package com.github.salomonbrys.kotson;

import com.google.gson.JsonPrimitive;
import java.math.BigInteger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 0}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/google/gson/JsonPrimitive;", "it", "Ljava/math/BigInteger;", "invoke"}, k = 3, mv = {1, 1, 1})
/* compiled from: Properties.kt */
final class PropertiesKt$byBigInteger$6 extends Lambda implements Function1<BigInteger, JsonPrimitive> {
    public static final PropertiesKt$byBigInteger$6 INSTANCE = new PropertiesKt$byBigInteger$6();

    PropertiesKt$byBigInteger$6() {
        super(1);
    }

    public final JsonPrimitive invoke(BigInteger bigInteger) {
        Intrinsics.checkParameterIsNotNull(bigInteger, "it");
        return BuilderKt.toJson(bigInteger);
    }
}
