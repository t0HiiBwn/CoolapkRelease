package com.github.salomonbrys.kotson;

import com.google.gson.JsonElement;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 0}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "Lcom/google/gson/JsonElement;", "it", "", "invoke", "(Ljava/lang/Character;)Lcom/google/gson/JsonElement;"}, k = 3, mv = {1, 1, 1})
/* compiled from: Properties.kt */
final class PropertiesKt$byNullableChar$4 extends Lambda implements Function1<Character, JsonElement> {
    public static final PropertiesKt$byNullableChar$4 INSTANCE = new PropertiesKt$byNullableChar$4();

    PropertiesKt$byNullableChar$4() {
        super(1);
    }

    public final JsonElement invoke(Character ch) {
        JsonElement jsonElement;
        if (ch == null || (jsonElement = BuilderKt.toJson(ch.charValue())) == null) {
            jsonElement = ElementKt.getJsonNull();
        }
        return jsonElement;
    }
}
