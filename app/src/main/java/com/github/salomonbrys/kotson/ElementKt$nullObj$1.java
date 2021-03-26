package com.github.salomonbrys.kotson;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 0}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/google/gson/JsonObject;", "Lcom/google/gson/JsonElement;", "invoke"}, k = 3, mv = {1, 1, 1})
/* compiled from: Element.kt */
final class ElementKt$nullObj$1 extends Lambda implements Function1<JsonElement, JsonObject> {
    public static final ElementKt$nullObj$1 INSTANCE = new ElementKt$nullObj$1();

    ElementKt$nullObj$1() {
        super(1);
    }

    public final JsonObject invoke(JsonElement jsonElement) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return ElementKt.getObj(jsonElement);
    }
}
