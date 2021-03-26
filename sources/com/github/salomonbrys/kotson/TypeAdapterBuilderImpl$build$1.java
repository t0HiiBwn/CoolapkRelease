package com.github.salomonbrys.kotson;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 0}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00028\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u0006J\u001d\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"com/github/salomonbrys/kotson/TypeAdapterBuilderImpl$build$1", "Lcom/google/gson/TypeAdapter;", "(Lcom/github/salomonbrys/kotson/TypeAdapterBuilderImpl;)V", "read", "reader", "Lcom/google/gson/stream/JsonReader;", "(Lcom/google/gson/stream/JsonReader;)Ljava/lang/Object;", "write", "", "writer", "Lcom/google/gson/stream/JsonWriter;", "value", "(Lcom/google/gson/stream/JsonWriter;Ljava/lang/Object;)V", "kotson_main"}, k = 1, mv = {1, 1, 1})
/* compiled from: GsonBuilder.kt */
public final class TypeAdapterBuilderImpl$build$1 extends TypeAdapter<T> {
    final /* synthetic */ TypeAdapterBuilderImpl this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    TypeAdapterBuilderImpl$build$1(TypeAdapterBuilderImpl typeAdapterBuilderImpl) {
        this.this$0 = typeAdapterBuilderImpl;
    }

    @Override // com.google.gson.TypeAdapter
    public R read(JsonReader jsonReader) {
        Intrinsics.checkParameterIsNotNull(jsonReader, "reader");
        Function1 function1 = this.this$0._readFunction;
        if (function1 == null) {
            Intrinsics.throwNpe();
        }
        return (R) function1.invoke(jsonReader);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, T t) {
        Intrinsics.checkParameterIsNotNull(jsonWriter, "writer");
        Intrinsics.checkParameterIsNotNull(t, "value");
        Function2 function2 = this.this$0._writeFunction;
        if (function2 == null) {
            Intrinsics.throwNpe();
        }
        function2.invoke(jsonWriter, t);
    }
}
