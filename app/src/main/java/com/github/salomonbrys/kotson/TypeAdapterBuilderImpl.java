package com.github.salomonbrys.kotson;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 0}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\n\b\u0001\u0010\u0003*\u0004\u0018\u0001H\u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004B*\u0012#\u0010\u0005\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\b¢\u0006\u0002\u0010\tJ\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010J!\u0010\u0011\u001a\u00020\u00072\u0017\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0002\b\bH\u0016J'\u0010\u0013\u001a\u00020\u00072\u001d\u0010\u0012\u001a\u0019\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\r¢\u0006\u0002\b\bH\u0016R!\u0010\n\u001a\u0015\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0006¢\u0006\u0002\b\bX\u000e¢\u0006\u0002\n\u0000R'\u0010\f\u001a\u001b\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0007\u0018\u00010\r¢\u0006\u0002\b\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/github/salomonbrys/kotson/TypeAdapterBuilderImpl;", "T", "", "R", "Lcom/github/salomonbrys/kotson/TypeAdapterBuilder;", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;)V", "_readFunction", "Lcom/google/gson/stream/JsonReader;", "_writeFunction", "Lkotlin/Function2;", "Lcom/google/gson/stream/JsonWriter;", "build", "Lcom/google/gson/TypeAdapter;", "read", "function", "write", "kotson_main"}, k = 1, mv = {1, 1, 1})
/* compiled from: GsonBuilder.kt */
public final class TypeAdapterBuilderImpl<T, R extends T> implements TypeAdapterBuilder<T, R> {
    private Function1<? super JsonReader, ? extends R> _readFunction;
    private Function2<? super JsonWriter, ? super T, Unit> _writeFunction;

    public TypeAdapterBuilderImpl(Function1<? super TypeAdapterBuilder<T, R>, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "init");
        function1.invoke(this);
        if (this._readFunction == null || this._writeFunction == null) {
            throw new IllegalArgumentException("You must define both a read and a write function");
        }
    }

    @Override // com.github.salomonbrys.kotson.TypeAdapterBuilder
    public void read(Function1<? super JsonReader, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "function");
        this._readFunction = function1;
    }

    @Override // com.github.salomonbrys.kotson.TypeAdapterBuilder
    public void write(Function2<? super JsonWriter, ? super T, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(function2, "function");
        this._writeFunction = function2;
    }

    public final TypeAdapter<T> build() {
        return new TypeAdapterBuilderImpl$build$1(this);
    }
}
