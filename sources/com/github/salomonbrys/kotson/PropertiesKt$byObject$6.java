package com.github.salomonbrys.kotson;

import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 0}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/google/gson/JsonObject;", "it", "invoke"}, k = 3, mv = {1, 1, 1})
/* compiled from: Properties.kt */
final class PropertiesKt$byObject$6 extends Lambda implements Function1<JsonObject, JsonObject> {
    public static final PropertiesKt$byObject$6 INSTANCE = new PropertiesKt$byObject$6();

    PropertiesKt$byObject$6() {
        super(1);
    }

    public final JsonObject invoke(JsonObject jsonObject) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "it");
        return jsonObject;
    }
}
