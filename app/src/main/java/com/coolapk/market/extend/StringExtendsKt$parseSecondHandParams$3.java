package com.coolapk.market.extend;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\n¢\u0006\u0002\b\u0006"}, d2 = {"getStringList", "", "", "json", "Lcom/google/gson/JsonObject;", "key", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: StringExtends.kt */
final class StringExtendsKt$parseSecondHandParams$3 extends Lambda implements Function2<JsonObject, String, List<? extends String>> {
    public static final StringExtendsKt$parseSecondHandParams$3 INSTANCE = new StringExtendsKt$parseSecondHandParams$3();

    StringExtendsKt$parseSecondHandParams$3() {
        super(2);
    }

    public final List<String> invoke(JsonObject jsonObject, String str) {
        Intrinsics.checkNotNullParameter(jsonObject, "json");
        Intrinsics.checkNotNullParameter(str, "key");
        ArrayList arrayList = new ArrayList();
        JsonElement jsonElement = jsonObject.get(str);
        Intrinsics.checkNotNullExpressionValue(jsonElement, "json.get(key)");
        JsonArray<JsonElement> asJsonArray = jsonElement.getAsJsonArray();
        Intrinsics.checkNotNullExpressionValue(asJsonArray, "jsonArray");
        for (JsonElement jsonElement2 : asJsonArray) {
            Intrinsics.checkNotNullExpressionValue(jsonElement2, "it");
            arrayList.add(jsonElement2.getAsString());
        }
        return arrayList;
    }
}
