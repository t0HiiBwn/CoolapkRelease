package com.coolapk.market.extend;

import com.github.salomonbrys.kotson.ElementKt;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"getValue", "", "json", "Lcom/google/gson/JsonObject;", "key", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: StringExtends.kt */
final class StringExtendsKt$parseSecondHandParams$1 extends Lambda implements Function2<JsonObject, String, String> {
    public static final StringExtendsKt$parseSecondHandParams$1 INSTANCE = new StringExtendsKt$parseSecondHandParams$1();

    StringExtendsKt$parseSecondHandParams$1() {
        super(2);
    }

    public final String invoke(JsonObject jsonObject, String str) {
        Intrinsics.checkNotNullParameter(jsonObject, "json");
        Intrinsics.checkNotNullParameter(str, "key");
        if (ElementKt.isEmpty(jsonObject)) {
            return "";
        }
        JsonElement jsonElement = jsonObject.get(str);
        Intrinsics.checkNotNullExpressionValue(jsonElement, "json.get(key)");
        String asString = jsonElement.getAsString();
        if (asString != null) {
            return asString;
        }
        return "";
    }
}
