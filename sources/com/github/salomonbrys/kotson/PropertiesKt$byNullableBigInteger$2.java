package com.github.salomonbrys.kotson;

import com.google.gson.JsonElement;
import java.math.BigInteger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 0}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/google/gson/JsonElement;", "it", "Ljava/math/BigInteger;", "invoke"}, k = 3, mv = {1, 1, 1})
/* compiled from: Properties.kt */
final class PropertiesKt$byNullableBigInteger$2 extends Lambda implements Function1<BigInteger, JsonElement> {
    public static final PropertiesKt$byNullableBigInteger$2 INSTANCE = new PropertiesKt$byNullableBigInteger$2();

    PropertiesKt$byNullableBigInteger$2() {
        super(1);
    }

    public final JsonElement invoke(BigInteger bigInteger) {
        JsonElement jsonElement;
        if (bigInteger == null || (jsonElement = BuilderKt.toJson(bigInteger)) == null) {
            jsonElement = ElementKt.getJsonNull();
        }
        return jsonElement;
    }
}
