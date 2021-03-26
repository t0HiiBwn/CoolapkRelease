package com.github.salomonbrys.kotson;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 0}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u0002H\u00010\u0003B=\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00028\u00000\t\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\fJ$\u0010\r\u001a\u00028\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0002¢\u0006\u0002\u0010\u0011J,\u0010\u0012\u001a\u00020\u00132\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u00102\u0006\u0010\u0014\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00028\u00000\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/github/salomonbrys/kotson/JsonArrayDelegate;", "T", "", "Lkotlin/properties/ReadWriteProperty;", "_array", "Lcom/google/gson/JsonArray;", "_index", "", "_get", "Lkotlin/Function1;", "Lcom/google/gson/JsonElement;", "_set", "(Lcom/google/gson/JsonArray;ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "", "value", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "kotson_main"}, k = 1, mv = {1, 1, 1})
/* compiled from: Properties.kt */
public final class JsonArrayDelegate<T> implements ReadWriteProperty<Object, T> {
    private final JsonArray _array;
    private final Function1<JsonElement, T> _get;
    private final int _index;
    private final Function1<T, JsonElement> _set;

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function1<? super com.google.gson.JsonElement, ? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.functions.Function1<? super T, ? extends com.google.gson.JsonElement> */
    /* JADX WARN: Multi-variable type inference failed */
    public JsonArrayDelegate(JsonArray jsonArray, int i, Function1<? super JsonElement, ? extends T> function1, Function1<? super T, ? extends JsonElement> function12) {
        Intrinsics.checkParameterIsNotNull(jsonArray, "_array");
        Intrinsics.checkParameterIsNotNull(function1, "_get");
        Intrinsics.checkParameterIsNotNull(function12, "_set");
        this._array = jsonArray;
        this._index = i;
        this._get = function1;
        this._set = function12;
    }

    @Override // kotlin.properties.ReadWriteProperty, kotlin.properties.ReadOnlyProperty
    public T getValue(Object obj, KProperty<?> kProperty) {
        Intrinsics.checkParameterIsNotNull(kProperty, "property");
        Function1<JsonElement, T> function1 = this._get;
        JsonElement jsonElement = this._array.get(this._index);
        Intrinsics.checkExpressionValueIsNotNull(jsonElement, "_array[_index]");
        return function1.invoke(jsonElement);
    }

    @Override // kotlin.properties.ReadWriteProperty
    public void setValue(Object obj, KProperty<?> kProperty, T t) {
        Intrinsics.checkParameterIsNotNull(kProperty, "property");
        Intrinsics.checkParameterIsNotNull(t, "value");
        this._array.set(this._index, this._set.invoke(t));
    }
}
