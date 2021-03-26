package com.github.salomonbrys.kotson;

import com.google.gson.JsonArray;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 0}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/google/gson/JsonArray;", "it", "invoke"}, k = 3, mv = {1, 1, 1})
/* compiled from: Properties.kt */
final class PropertiesKt$byArray$4 extends Lambda implements Function1<JsonArray, JsonArray> {
    public static final PropertiesKt$byArray$4 INSTANCE = new PropertiesKt$byArray$4();

    PropertiesKt$byArray$4() {
        super(1);
    }

    public final JsonArray invoke(JsonArray jsonArray) {
        Intrinsics.checkParameterIsNotNull(jsonArray, "it");
        return jsonArray;
    }
}
