package com.github.salomonbrys.kotson;

import com.google.gson.JsonElement;
import java.math.BigInteger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 0}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Ljava/math/BigInteger;", "it", "Lcom/google/gson/JsonElement;", "invoke"}, k = 3, mv = {1, 1, 1})
/* compiled from: Properties.kt */
final class PropertiesKt$byNullableBigInteger$3 extends Lambda implements Function1<JsonElement, BigInteger> {
    public static final PropertiesKt$byNullableBigInteger$3 INSTANCE = new PropertiesKt$byNullableBigInteger$3();

    PropertiesKt$byNullableBigInteger$3() {
        super(1);
    }

    public final BigInteger invoke(JsonElement jsonElement) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "it");
        return ElementKt.getBigInteger(jsonElement);
    }
}