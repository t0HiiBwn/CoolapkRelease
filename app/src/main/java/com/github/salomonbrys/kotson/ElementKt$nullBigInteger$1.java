package com.github.salomonbrys.kotson;

import com.google.gson.JsonElement;
import java.math.BigInteger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 0}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Ljava/math/BigInteger;", "Lcom/google/gson/JsonElement;", "invoke"}, k = 3, mv = {1, 1, 1})
/* compiled from: Element.kt */
final class ElementKt$nullBigInteger$1 extends Lambda implements Function1<JsonElement, BigInteger> {
    public static final ElementKt$nullBigInteger$1 INSTANCE = new ElementKt$nullBigInteger$1();

    ElementKt$nullBigInteger$1() {
        super(1);
    }

    public final BigInteger invoke(JsonElement jsonElement) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return ElementKt.getBigInteger(jsonElement);
    }
}
