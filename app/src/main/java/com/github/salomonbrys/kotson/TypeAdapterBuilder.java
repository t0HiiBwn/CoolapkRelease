package com.github.salomonbrys.kotson;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(bv = {1, 0, 0}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\n\b\u0001\u0010\u0003*\u0004\u0018\u0001H\u00012\u00020\u0002J!\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u00010\u0007¢\u0006\u0002\b\tH&J'\u0010\n\u001a\u00020\u00052\u001d\u0010\u0006\u001a\u0019\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\u0002\b\tH&¨\u0006\r"}, d2 = {"Lcom/github/salomonbrys/kotson/TypeAdapterBuilder;", "T", "", "R", "read", "", "function", "Lkotlin/Function1;", "Lcom/google/gson/stream/JsonReader;", "Lkotlin/ExtensionFunctionType;", "write", "Lkotlin/Function2;", "Lcom/google/gson/stream/JsonWriter;", "kotson_main"}, k = 1, mv = {1, 1, 1})
/* compiled from: GsonBuilder.kt */
public interface TypeAdapterBuilder<T, R extends T> {
    void read(Function1<? super JsonReader, ? extends R> function1);

    void write(Function2<? super JsonWriter, ? super T, Unit> function2);
}
