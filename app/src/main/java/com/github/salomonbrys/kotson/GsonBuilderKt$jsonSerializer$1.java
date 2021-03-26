package com.github.salomonbrys.kotson;

import com.github.salomonbrys.kotson.SerializerArg;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 0}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0005*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00070\u00072\u000e\u0010\b\u001a\n \u0005*\u0004\u0018\u00010\t0\tH\n¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"<anonymous>", "Lcom/google/gson/JsonElement;", "T", "", "src", "kotlin.jvm.PlatformType", "type", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonSerializationContext;", "serialize", "(Ljava/lang/Object;Ljava/lang/reflect/Type;Lcom/google/gson/JsonSerializationContext;)Lcom/google/gson/JsonElement;"}, k = 3, mv = {1, 1, 1})
/* compiled from: GsonBuilder.kt */
final class GsonBuilderKt$jsonSerializer$1<T> implements JsonSerializer<T> {
    final /* synthetic */ Function1 $serializer;

    GsonBuilderKt$jsonSerializer$1(Function1 function1) {
        this.$serializer = function1;
    }

    @Override // com.google.gson.JsonSerializer
    public final JsonElement serialize(T t, Type type, JsonSerializationContext jsonSerializationContext) {
        Function1 function1 = this.$serializer;
        Intrinsics.checkExpressionValueIsNotNull(t, "src");
        Intrinsics.checkExpressionValueIsNotNull(type, "type");
        Intrinsics.checkExpressionValueIsNotNull(jsonSerializationContext, "context");
        return (JsonElement) function1.invoke(new SerializerArg(t, type, new SerializerArg.Context(jsonSerializationContext)));
    }
}
