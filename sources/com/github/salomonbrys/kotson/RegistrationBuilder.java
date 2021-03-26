package com.github.salomonbrys.kotson;

import com.google.gson.JsonElement;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(bv = {1, 0, 0}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\n\b\u0001\u0010\u0003*\u0004\u0018\u0001H\u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00028\u00000\bH&J\u001e\u0010\n\u001a\u00020\u00062\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00018\u00000\bH&J\"\u0010\r\u001a\u00020\u00062\u0018\u0010\u000e\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f\u0012\u0004\u0012\u00020\u00100\bH&¨\u0006\u0011"}, d2 = {"Lcom/github/salomonbrys/kotson/RegistrationBuilder;", "T", "", "R", "Lcom/github/salomonbrys/kotson/TypeAdapterBuilder;", "createInstances", "", "creator", "Lkotlin/Function1;", "Ljava/lang/reflect/Type;", "deserialize", "deserializer", "Lcom/github/salomonbrys/kotson/DeserializerArg;", "serialize", "serializer", "Lcom/github/salomonbrys/kotson/SerializerArg;", "Lcom/google/gson/JsonElement;", "kotson_main"}, k = 1, mv = {1, 1, 1})
/* compiled from: GsonBuilder.kt */
public interface RegistrationBuilder<T, R extends T> extends TypeAdapterBuilder<T, R> {
    void createInstances(Function1<? super Type, ? extends T> function1);

    void deserialize(Function1<? super DeserializerArg, ? extends T> function1);

    void serialize(Function1<? super SerializerArg<T>, ? extends JsonElement> function1);
}
