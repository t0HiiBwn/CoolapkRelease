package com.github.salomonbrys.kotson;

import com.google.gson.JsonElement;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 0}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/google/gson/JsonElement;", "invoke"}, k = 3, mv = {1, 1, 1})
/* compiled from: Properties.kt */
final class PropertiesKt$byLong$1 extends Lambda implements Function1<JsonElement, Long> {
    public static final PropertiesKt$byLong$1 INSTANCE = new PropertiesKt$byLong$1();

    PropertiesKt$byLong$1() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Long invoke(JsonElement jsonElement) {
        return Long.valueOf(invoke(jsonElement));
    }

    public final long invoke(JsonElement jsonElement) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "it");
        return ElementKt.getLong(jsonElement);
    }
}
