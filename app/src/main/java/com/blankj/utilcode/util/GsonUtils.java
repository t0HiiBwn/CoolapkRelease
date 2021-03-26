package com.blankj.utilcode.util;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class GsonUtils {
    private static final Map<String, Gson> GSONS = new ConcurrentHashMap();
    private static final String KEY_DEFAULT = "defaultGson";
    private static final String KEY_DELEGATE = "delegateGson";
    private static final String KEY_LOG_UTILS = "logUtilsGson";

    private GsonUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void setGsonDelegate(Gson gson) {
        if (gson != null) {
            GSONS.put("delegateGson", gson);
        }
    }

    public static void setGson(String str, Gson gson) {
        if (!TextUtils.isEmpty(str) && gson != null) {
            GSONS.put(str, gson);
        }
    }

    public static Gson getGson(String str) {
        return GSONS.get(str);
    }

    public static Gson getGson() {
        Map<String, Gson> map = GSONS;
        Gson gson = map.get("delegateGson");
        if (gson != null) {
            return gson;
        }
        Gson gson2 = map.get("defaultGson");
        if (gson2 != null) {
            return gson2;
        }
        Gson createGson = createGson();
        map.put("defaultGson", createGson);
        return createGson;
    }

    public static String toJson(Object obj) {
        return toJson(getGson(), obj);
    }

    public static String toJson(Object obj, Type type) {
        Objects.requireNonNull(type, "Argument 'typeOfSrc' of type Type (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return toJson(getGson(), obj, type);
    }

    public static String toJson(Gson gson, Object obj) {
        Objects.requireNonNull(gson, "Argument 'gson' of type Gson (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return gson.toJson(obj);
    }

    public static String toJson(Gson gson, Object obj, Type type) {
        Objects.requireNonNull(gson, "Argument 'gson' of type Gson (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(type, "Argument 'typeOfSrc' of type Type (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return gson.toJson(obj, type);
    }

    public static <T> T fromJson(String str, Class<T> cls) {
        Objects.requireNonNull(cls, "Argument 'type' of type Class<T> (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return (T) fromJson(getGson(), str, (Class<Object>) cls);
    }

    public static <T> T fromJson(String str, Type type) {
        Objects.requireNonNull(type, "Argument 'type' of type Type (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return (T) fromJson(getGson(), str, type);
    }

    public static <T> T fromJson(Reader reader, Class<T> cls) {
        Objects.requireNonNull(reader, "Argument 'reader' of type Reader (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cls, "Argument 'type' of type Class<T> (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return (T) fromJson(getGson(), reader, (Class<Object>) cls);
    }

    public static <T> T fromJson(Reader reader, Type type) {
        Objects.requireNonNull(reader, "Argument 'reader' of type Reader (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(type, "Argument 'type' of type Type (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return (T) fromJson(getGson(), reader, type);
    }

    public static <T> T fromJson(Gson gson, String str, Class<T> cls) {
        Objects.requireNonNull(gson, "Argument 'gson' of type Gson (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cls, "Argument 'type' of type Class<T> (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return (T) gson.fromJson(str, (Class<Object>) cls);
    }

    public static <T> T fromJson(Gson gson, String str, Type type) {
        Objects.requireNonNull(gson, "Argument 'gson' of type Gson (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(type, "Argument 'type' of type Type (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return (T) gson.fromJson(str, type);
    }

    public static <T> T fromJson(Gson gson, Reader reader, Class<T> cls) {
        Objects.requireNonNull(gson, "Argument 'gson' of type Gson (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cls, "Argument 'type' of type Class<T> (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return (T) gson.fromJson(reader, (Class<Object>) cls);
    }

    public static <T> T fromJson(Gson gson, Reader reader, Type type) {
        Objects.requireNonNull(gson, "Argument 'gson' of type Gson (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(type, "Argument 'type' of type Type (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return (T) gson.fromJson(reader, type);
    }

    public static Type getListType(Type type) {
        Objects.requireNonNull(type, "Argument 'type' of type Type (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return TypeToken.getParameterized(List.class, type).getType();
    }

    public static Type getSetType(Type type) {
        Objects.requireNonNull(type, "Argument 'type' of type Type (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return TypeToken.getParameterized(Set.class, type).getType();
    }

    public static Type getMapType(Type type, Type type2) {
        Objects.requireNonNull(type, "Argument 'keyType' of type Type (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(type2, "Argument 'valueType' of type Type (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return TypeToken.getParameterized(Map.class, type, type2).getType();
    }

    public static Type getArrayType(Type type) {
        Objects.requireNonNull(type, "Argument 'type' of type Type (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return TypeToken.getArray(type).getType();
    }

    public static Type getType(Type type, Type... typeArr) {
        Objects.requireNonNull(type, "Argument 'rawType' of type Type (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(typeArr, "Argument 'typeArguments' of type Type[] (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return TypeToken.getParameterized(type, typeArr).getType();
    }

    static Gson getGson4LogUtils() {
        Map<String, Gson> map = GSONS;
        Gson gson = map.get("logUtilsGson");
        if (gson != null) {
            return gson;
        }
        Gson create = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
        map.put("logUtilsGson", create);
        return create;
    }

    private static Gson createGson() {
        return new GsonBuilder().serializeNulls().disableHtmlEscaping().create();
    }
}
