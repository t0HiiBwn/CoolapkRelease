package com.github.salomonbrys.kotson;

import com.google.gson.JsonPrimitive;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 0}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/google/gson/JsonPrimitive;", "it", "", "invoke"}, k = 3, mv = {1, 1, 1})
/* compiled from: Properties.kt */
final class PropertiesKt$byChar$2 extends Lambda implements Function1<Character, JsonPrimitive> {
    public static final PropertiesKt$byChar$2 INSTANCE = new PropertiesKt$byChar$2();

    PropertiesKt$byChar$2() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ JsonPrimitive invoke(Character ch) {
        return invoke(ch.charValue());
    }

    public final JsonPrimitive invoke(char c) {
        return BuilderKt.toJson(c);
    }
}
