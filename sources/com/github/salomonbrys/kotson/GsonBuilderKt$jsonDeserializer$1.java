package com.github.salomonbrys.kotson;

import com.github.salomonbrys.kotson.DeserializerArg;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 0}, d1 = {"\u0000 \n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\u000e\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00042\u000e\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00070\u00072\u000e\u0010\b\u001a\n \u0005*\u0004\u0018\u00010\t0\tH\n¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"<anonymous>", "T", "", "json", "Lcom/google/gson/JsonElement;", "kotlin.jvm.PlatformType", "type", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 1})
/* compiled from: GsonBuilder.kt */
final class GsonBuilderKt$jsonDeserializer$1<T> implements JsonDeserializer<T> {
    final /* synthetic */ Function1 $deserializer;

    GsonBuilderKt$jsonDeserializer$1(Function1 function1) {
        this.$deserializer = function1;
    }

    @Override // com.google.gson.JsonDeserializer
    public final T deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        Function1 function1 = this.$deserializer;
        Intrinsics.checkExpressionValueIsNotNull(jsonElement, "json");
        Intrinsics.checkExpressionValueIsNotNull(type, "type");
        Intrinsics.checkExpressionValueIsNotNull(jsonDeserializationContext, "context");
        return (T) function1.invoke(new DeserializerArg(jsonElement, type, new DeserializerArg.Context(jsonDeserializationContext)));
    }
}
