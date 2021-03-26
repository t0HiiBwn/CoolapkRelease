package com.github.salomonbrys.kotson;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.Reader;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 0}, d1 = {"\u0000D\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a&\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\b¢\u0006\u0002\u0010\u0006\u001a&\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0007H\b¢\u0006\u0002\u0010\b\u001a&\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\tH\b¢\u0006\u0002\u0010\n\u001a&\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000bH\b¢\u0006\u0002\u0010\f\u001a\u001f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00010\u000e\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u0003H\b\u001a\u001f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00010\u000e\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u0003H\b\u001a&\u0010\u0010\u001a\u00020\u000b\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u00032\u0006\u0010\u0011\u001a\u0002H\u0001H\b¢\u0006\u0002\u0010\u0012\u001a.\u0010\u0010\u001a\u00020\u0013\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u00032\u0006\u0010\u0011\u001a\u0002H\u00012\u0006\u0010\u0014\u001a\u00020\u0015H\b¢\u0006\u0002\u0010\u0016\u001a.\u0010\u0010\u001a\u00020\u0013\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u00032\u0006\u0010\u0011\u001a\u0002H\u00012\u0006\u0010\u0014\u001a\u00020\u0017H\b¢\u0006\u0002\u0010\u0018\u001a&\u0010\u0019\u001a\u00020\u0005\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u00032\u0006\u0010\u0011\u001a\u0002H\u0001H\b¢\u0006\u0002\u0010\u001a¨\u0006\u001b"}, d2 = {"fromJson", "T", "", "Lcom/google/gson/Gson;", "json", "Lcom/google/gson/JsonElement;", "(Lcom/google/gson/Gson;Lcom/google/gson/JsonElement;)Ljava/lang/Object;", "Lcom/google/gson/stream/JsonReader;", "(Lcom/google/gson/Gson;Lcom/google/gson/stream/JsonReader;)Ljava/lang/Object;", "Ljava/io/Reader;", "(Lcom/google/gson/Gson;Ljava/io/Reader;)Ljava/lang/Object;", "", "(Lcom/google/gson/Gson;Ljava/lang/String;)Ljava/lang/Object;", "getAdapter", "Lcom/google/gson/TypeAdapter;", "getGenericAdapter", "typedToJson", "src", "(Lcom/google/gson/Gson;Ljava/lang/Object;)Ljava/lang/String;", "", "writer", "Lcom/google/gson/stream/JsonWriter;", "(Lcom/google/gson/Gson;Ljava/lang/Object;Lcom/google/gson/stream/JsonWriter;)V", "Ljava/lang/Appendable;", "(Lcom/google/gson/Gson;Ljava/lang/Object;Ljava/lang/Appendable;)V", "typedToJsonTree", "(Lcom/google/gson/Gson;Ljava/lang/Object;)Lcom/google/gson/JsonElement;", "kotson_main"}, k = 2, mv = {1, 1, 1})
/* compiled from: Gson.kt */
public final class GsonKt {
    private static final <T> TypeAdapter<T> getAdapter(Gson gson) {
        Intrinsics.needClassReification();
        TypeAdapter<T> adapter = gson.getAdapter(new GsonKt$getAdapter$1());
        Intrinsics.checkExpressionValueIsNotNull(adapter, "getAdapter(object: TypeToken<T>() {})");
        return adapter;
    }

    private static final <T> TypeAdapter<T> getGenericAdapter(Gson gson) {
        Intrinsics.reifiedOperationMarker(4, "T");
        TypeAdapter<T> adapter = gson.getAdapter(Object.class);
        Intrinsics.checkExpressionValueIsNotNull(adapter, "getAdapter(T::class.java)");
        return adapter;
    }

    private static final <T> T fromJson(Gson gson, String str) {
        Type type;
        Intrinsics.needClassReification();
        Type type2 = new GsonKt$fromJson$$inlined$typeToken$1().getType();
        Intrinsics.checkExpressionValueIsNotNull(type2, "object : TypeToken<T>() {} .type");
        if (type2 instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type2;
            if (GsonBuilderKt.isWildcard(parameterizedType)) {
                type = parameterizedType.getRawType();
                Intrinsics.checkExpressionValueIsNotNull(type, "type.rawType");
                T t = (T) gson.fromJson(str, type);
                Intrinsics.checkExpressionValueIsNotNull(t, "fromJson(json, typeToken<T>())");
                return t;
            }
        }
        type = GsonBuilderKt.removeTypeWildcards(type2);
        T t = (T) gson.fromJson(str, type);
        Intrinsics.checkExpressionValueIsNotNull(t, "fromJson(json, typeToken<T>())");
        return t;
    }

    private static final <T> T fromJson(Gson gson, Reader reader) {
        Type type;
        Intrinsics.needClassReification();
        Type type2 = new GsonKt$fromJson$$inlined$typeToken$2().getType();
        Intrinsics.checkExpressionValueIsNotNull(type2, "object : TypeToken<T>() {} .type");
        if (type2 instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type2;
            if (GsonBuilderKt.isWildcard(parameterizedType)) {
                type = parameterizedType.getRawType();
                Intrinsics.checkExpressionValueIsNotNull(type, "type.rawType");
                T t = (T) gson.fromJson(reader, type);
                Intrinsics.checkExpressionValueIsNotNull(t, "fromJson(json, typeToken<T>())");
                return t;
            }
        }
        type = GsonBuilderKt.removeTypeWildcards(type2);
        T t = (T) gson.fromJson(reader, type);
        Intrinsics.checkExpressionValueIsNotNull(t, "fromJson(json, typeToken<T>())");
        return t;
    }

    private static final <T> T fromJson(Gson gson, JsonReader jsonReader) {
        Type type;
        Intrinsics.needClassReification();
        Type type2 = new GsonKt$fromJson$$inlined$typeToken$3().getType();
        Intrinsics.checkExpressionValueIsNotNull(type2, "object : TypeToken<T>() {} .type");
        if (type2 instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type2;
            if (GsonBuilderKt.isWildcard(parameterizedType)) {
                type = parameterizedType.getRawType();
                Intrinsics.checkExpressionValueIsNotNull(type, "type.rawType");
                T t = (T) gson.fromJson(jsonReader, type);
                Intrinsics.checkExpressionValueIsNotNull(t, "fromJson(json, typeToken<T>())");
                return t;
            }
        }
        type = GsonBuilderKt.removeTypeWildcards(type2);
        T t = (T) gson.fromJson(jsonReader, type);
        Intrinsics.checkExpressionValueIsNotNull(t, "fromJson(json, typeToken<T>())");
        return t;
    }

    private static final <T> T fromJson(Gson gson, JsonElement jsonElement) {
        Type type;
        Intrinsics.needClassReification();
        Type type2 = new GsonKt$fromJson$$inlined$typeToken$4().getType();
        Intrinsics.checkExpressionValueIsNotNull(type2, "object : TypeToken<T>() {} .type");
        if (type2 instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type2;
            if (GsonBuilderKt.isWildcard(parameterizedType)) {
                type = parameterizedType.getRawType();
                Intrinsics.checkExpressionValueIsNotNull(type, "type.rawType");
                T t = (T) gson.fromJson(jsonElement, type);
                Intrinsics.checkExpressionValueIsNotNull(t, "fromJson(json, typeToken<T>())");
                return t;
            }
        }
        type = GsonBuilderKt.removeTypeWildcards(type2);
        T t = (T) gson.fromJson(jsonElement, type);
        Intrinsics.checkExpressionValueIsNotNull(t, "fromJson(json, typeToken<T>())");
        return t;
    }

    private static final <T> String typedToJson(Gson gson, T t) {
        Type type;
        Intrinsics.needClassReification();
        Type type2 = new GsonKt$typedToJson$$inlined$typeToken$1().getType();
        Intrinsics.checkExpressionValueIsNotNull(type2, "object : TypeToken<T>() {} .type");
        if (type2 instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type2;
            if (GsonBuilderKt.isWildcard(parameterizedType)) {
                type = parameterizedType.getRawType();
                Intrinsics.checkExpressionValueIsNotNull(type, "type.rawType");
                String json = gson.toJson(t, type);
                Intrinsics.checkExpressionValueIsNotNull(json, "toJson(src, typeToken<T>())");
                return json;
            }
        }
        type = GsonBuilderKt.removeTypeWildcards(type2);
        String json = gson.toJson(t, type);
        Intrinsics.checkExpressionValueIsNotNull(json, "toJson(src, typeToken<T>())");
        return json;
    }

    private static final <T> void typedToJson(Gson gson, T t, Appendable appendable) {
        Type type;
        Intrinsics.needClassReification();
        Type type2 = new GsonKt$typedToJson$$inlined$typeToken$2().getType();
        Intrinsics.checkExpressionValueIsNotNull(type2, "object : TypeToken<T>() {} .type");
        if (type2 instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type2;
            if (GsonBuilderKt.isWildcard(parameterizedType)) {
                type = parameterizedType.getRawType();
                Intrinsics.checkExpressionValueIsNotNull(type, "type.rawType");
                gson.toJson(t, type, appendable);
            }
        }
        type = GsonBuilderKt.removeTypeWildcards(type2);
        gson.toJson(t, type, appendable);
    }

    private static final <T> void typedToJson(Gson gson, T t, JsonWriter jsonWriter) {
        Type type;
        Intrinsics.needClassReification();
        Type type2 = new GsonKt$typedToJson$$inlined$typeToken$3().getType();
        Intrinsics.checkExpressionValueIsNotNull(type2, "object : TypeToken<T>() {} .type");
        if (type2 instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type2;
            if (GsonBuilderKt.isWildcard(parameterizedType)) {
                type = parameterizedType.getRawType();
                Intrinsics.checkExpressionValueIsNotNull(type, "type.rawType");
                gson.toJson(t, type, jsonWriter);
            }
        }
        type = GsonBuilderKt.removeTypeWildcards(type2);
        gson.toJson(t, type, jsonWriter);
    }

    private static final <T> JsonElement typedToJsonTree(Gson gson, T t) {
        Type type;
        Intrinsics.needClassReification();
        Type type2 = new GsonKt$typedToJsonTree$$inlined$typeToken$1().getType();
        Intrinsics.checkExpressionValueIsNotNull(type2, "object : TypeToken<T>() {} .type");
        if (type2 instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type2;
            if (GsonBuilderKt.isWildcard(parameterizedType)) {
                type = parameterizedType.getRawType();
                Intrinsics.checkExpressionValueIsNotNull(type, "type.rawType");
                JsonElement jsonTree = gson.toJsonTree(t, type);
                Intrinsics.checkExpressionValueIsNotNull(jsonTree, "toJsonTree(src, typeToken<T>())");
                return jsonTree;
            }
        }
        type = GsonBuilderKt.removeTypeWildcards(type2);
        JsonElement jsonTree = gson.toJsonTree(t, type);
        Intrinsics.checkExpressionValueIsNotNull(jsonTree, "toJsonTree(src, typeToken<T>())");
        return jsonTree;
    }
}
