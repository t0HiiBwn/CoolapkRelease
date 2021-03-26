package com.github.salomonbrys.kotson;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 0}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u0002H\u00010\u0003BS\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ$\u0010\u000f\u001a\u00028\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0012H\u0002¢\u0006\u0002\u0010\u0013J,\u0010\u0014\u001a\u00020\u00152\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u00122\u0006\u0010\u0016\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0017R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\rX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/github/salomonbrys/kotson/JsonObjectDelegate;", "T", "", "Lkotlin/properties/ReadWriteProperty;", "_obj", "Lcom/google/gson/JsonObject;", "_get", "Lkotlin/Function1;", "Lcom/google/gson/JsonElement;", "_set", "_key", "", "_default", "Lkotlin/Function0;", "(Lcom/google/gson/JsonObject;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "", "value", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "kotson_main"}, k = 1, mv = {1, 1, 1})
/* compiled from: Properties.kt */
public final class JsonObjectDelegate<T> implements ReadWriteProperty<Object, T> {
    private final Function0<T> _default;
    private final Function1<JsonElement, T> _get;
    private final String _key;
    private final JsonObject _obj;
    private final Function1<T, JsonElement> _set;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<? super com.google.gson.JsonElement, ? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function1<? super T, ? extends com.google.gson.JsonElement> */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: kotlin.jvm.functions.Function0<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public JsonObjectDelegate(JsonObject jsonObject, Function1<? super JsonElement, ? extends T> function1, Function1<? super T, ? extends JsonElement> function12, String str, Function0<? extends T> function0) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "_obj");
        Intrinsics.checkParameterIsNotNull(function1, "_get");
        Intrinsics.checkParameterIsNotNull(function12, "_set");
        this._obj = jsonObject;
        this._get = function1;
        this._set = function12;
        this._key = str;
        this._default = function0;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ JsonObjectDelegate(JsonObject jsonObject, Function1 function1, Function1 function12, String str, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(jsonObject, function1, function12, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : function0);
    }

    @Override // kotlin.properties.ReadWriteProperty, kotlin.properties.ReadOnlyProperty
    public T getValue(Object obj, KProperty<?> kProperty) {
        Intrinsics.checkParameterIsNotNull(kProperty, "property");
        JsonObject jsonObject = this._obj;
        String str = this._key;
        if (str == null) {
            str = kProperty.getName();
        }
        JsonElement jsonElement = jsonObject.get(str);
        if (jsonElement != null) {
            return this._get.invoke(jsonElement);
        }
        Function0<T> function0 = this._default;
        if (function0 != null) {
            return function0.invoke();
        }
        throw new NoSuchElementException("'" + this._key + "' not found");
    }

    @Override // kotlin.properties.ReadWriteProperty
    public void setValue(Object obj, KProperty<?> kProperty, T t) {
        Intrinsics.checkParameterIsNotNull(kProperty, "property");
        Intrinsics.checkParameterIsNotNull(t, "value");
        JsonObject jsonObject = this._obj;
        String str = this._key;
        if (str == null) {
            str = kProperty.getName();
        }
        MutableKt.set(jsonObject, str, this._set.invoke(t));
    }
}
