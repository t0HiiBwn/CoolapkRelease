package com.github.salomonbrys.kotson;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 0}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/google/gson/JsonElement;", "it", "Lcom/google/gson/JsonArray;", "invoke"}, k = 3, mv = {1, 1, 1})
/* compiled from: Properties.kt */
final class PropertiesKt$byNullableArray$4 extends Lambda implements Function1<JsonArray, JsonElement> {
    public static final PropertiesKt$byNullableArray$4 INSTANCE = new PropertiesKt$byNullableArray$4();

    PropertiesKt$byNullableArray$4() {
        super(1);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:0:0x0000 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.google.gson.JsonArray] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v3, types: [com.google.gson.JsonNull] */
    public final JsonElement invoke(JsonArray jsonArray) {
        if (jsonArray == 0) {
            jsonArray = ElementKt.getJsonNull();
        }
        return (JsonElement) jsonArray;
    }
}