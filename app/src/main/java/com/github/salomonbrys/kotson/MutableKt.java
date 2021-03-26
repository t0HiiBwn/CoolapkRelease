package com.github.salomonbrys.kotson;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

@Metadata(bv = {1, 0, 0}, d1 = {"\u0000\\\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010&\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0002\b\u0005\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u001a'\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0016\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040\u0007\"\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\b\u001a\u001a\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\t\u001a\u001a\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\n\u001a\u0015\u0010\u000b\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\fH\u0002\u001a \u0010\u000b\u001a\u00020\u0002*\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\f0\u0007H\u0002¢\u0006\u0002\u0010\r\u001a\u001b\u0010\u000b\u001a\u00020\u0002*\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\f0\tH\u0002\u001a\u001b\u0010\u000b\u001a\u00020\u0002*\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\f0\nH\u0002\u001a \u0010\u000b\u001a\u00020\u000e*\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007H\u0002¢\u0006\u0002\u0010\u0011\u001a\u0015\u0010\u000b\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0010H\u0002\u001a\u001b\u0010\u000b\u001a\u00020\u000e*\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\tH\u0002\u001a\u001b\u0010\u000b\u001a\u00020\u000e*\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\nH\u0002\u001a\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\fH\u0002\u001a \u0010\u0013\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\f0\u0007H\u0002¢\u0006\u0002\u0010\u0014\u001a\u001b\u0010\u0013\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\f0\tH\u0002\u001a\u001b\u0010\u0013\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\f0\nH\u0002\u001a \u0010\u0013\u001a\u00020\u0001*\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007H\u0002¢\u0006\u0002\u0010\u0015\u001a\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0010H\u0002\u001a\u001b\u0010\u0013\u001a\u00020\u0001*\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\tH\u0002\u001a\u001b\u0010\u0013\u001a\u00020\u0001*\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\nH\u0002\u001a\u0017\u0010\u0016\u001a\u00020\u0002*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0002\u001a\"\u0010\u0016\u001a\u00020\u0002*\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0007H\u0002¢\u0006\u0002\u0010\u0017\u001a\u001d\u0010\u0016\u001a\u00020\u0002*\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\tH\u0002\u001a\u001d\u0010\u0016\u001a\u00020\u0002*\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\nH\u0002\u001a\u0015\u0010\u0016\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u000eH\u0002\u001a.\u0010\u0016\u001a\u00020\u000e*\u00020\u000e2\u001a\u0010\u0019\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001a0\u0007H\u0002¢\u0006\u0002\u0010\u001b\u001a.\u0010\u0016\u001a\u00020\u000e*\u00020\u000e2\u001a\u0010\u001c\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001d0\u0007H\u0002¢\u0006\u0002\u0010\u001e\u001a#\u0010\u0016\u001a\u00020\u000e*\u00020\u000e2\u0014\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001aH\u0002\u001a#\u0010\u0016\u001a\u00020\u000e*\u00020\u000e2\u0014\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001dH\u0002\u001a#\u0010\u0016\u001a\u00020\u000e*\u00020\u000e2\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00040\"H\u0002\u001a\u0017\u0010#\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0002\u001a\"\u0010#\u001a\u00020\u0001*\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0007H\u0002¢\u0006\u0002\u0010\b\u001a\u001d\u0010#\u001a\u00020\u0001*\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\tH\u0002\u001a\u001d\u0010#\u001a\u00020\u0001*\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\nH\u0002\u001a\u0015\u0010#\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u000eH\u0002\u001a.\u0010#\u001a\u00020\u0001*\u00020\u000e2\u001a\u0010\u0019\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001a0\u0007H\u0002¢\u0006\u0002\u0010$\u001a.\u0010#\u001a\u00020\u0001*\u00020\u000e2\u001a\u0010\u001c\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001d0\u0007H\u0002¢\u0006\u0002\u0010%\u001a#\u0010#\u001a\u00020\u0001*\u00020\u000e2\u0014\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001aH\u0002\u001a#\u0010#\u001a\u00020\u0001*\u00020\u000e2\u0014\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001dH\u0002\u001a#\u0010#\u001a\u00020\u0001*\u00020\u000e2\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00040\"H\u0002\u001a \u0010&\u001a\u00020\u0001*\u00020\u000e2\u0014\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001a\u001a \u0010&\u001a\u00020\u0001*\u00020\u000e2\u0014\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001d\u001a\u0012\u0010'\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u000e\u001a?\u0010'\u001a\u00020\u0001*\u00020\u000e2.\u0010\u0019\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001a0\u0007\"\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001a¢\u0006\u0002\u0010$\u001a?\u0010'\u001a\u00020\u0001*\u00020\u000e2.\u0010\u001c\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001d0\u0007\"\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001d¢\u0006\u0002\u0010%\u001a&\u0010'\u001a\u00020\u0001*\u00020\u000e2\u001a\u0010\u0019\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001a0\t\u001a \u0010'\u001a\u00020\u0001*\u00020\u000e2\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00040\"\u001a&\u0010'\u001a\u00020\u0001*\u00020\u000e2\u001a\u0010\u0019\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001a0\n\u001a&\u0010(\u001a\u00020\u0001*\u00020\u000e2\u001a\u0010\u001c\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001d0\t\u001a&\u0010(\u001a\u00020\u0001*\u00020\u000e2\u001a\u0010\u001c\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001d0\n\u001a#\u0010)\u001a\u00020\u0001*\u00020\u00022\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u0007\"\u00020\f¢\u0006\u0002\u0010\u0014\u001a\u0018\u0010)\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\f0\t\u001a\u0018\u0010)\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\f0\n\u001a#\u0010)\u001a\u00020\u0001*\u00020\u000e2\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u0007\"\u00020\u0010¢\u0006\u0002\u0010\u0015\u001a\u0018\u0010)\u001a\u00020\u0001*\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\t\u001a\u0018\u0010)\u001a\u00020\u0001*\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\n\u001a\u0016\u0010*\u001a\u00020\u0001*\u00020\u00022\n\u0010+\u001a\u00020,\"\u00020-\u001a\u0018\u0010*\u001a\u00020\u0001*\u00020\u00022\f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0\t\u001a\u0018\u0010*\u001a\u00020\u0001*\u00020\u00022\f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0\n\u001a#\u0010.\u001a\u00020\u0001*\u00020\u000e2\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u0007\"\u00020\f¢\u0006\u0002\u0010/\u001a\u0018\u0010.\u001a\u00020\u0001*\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\t\u001a\u0018\u0010.\u001a\u00020\u0001*\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\n\u001a'\u00100\u001a\n 1*\u0004\u0018\u00010\f0\f*\u00020\f2\u0006\u0010\u0012\u001a\u00020-2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0002\u001a\u001f\u00100\u001a\u00020\u0001*\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0002¨\u00062"}, d2 = {"add", "", "Lcom/google/gson/JsonArray;", "value", "", "addAll", "values", "", "(Lcom/google/gson/JsonArray;[Ljava/lang/Object;)V", "", "Lkotlin/sequences/Sequence;", "minus", "Lcom/google/gson/JsonElement;", "(Lcom/google/gson/JsonArray;[Lcom/google/gson/JsonElement;)Lcom/google/gson/JsonArray;", "Lcom/google/gson/JsonObject;", "keys", "", "(Lcom/google/gson/JsonObject;[Ljava/lang/String;)Lcom/google/gson/JsonObject;", "key", "minusAssign", "(Lcom/google/gson/JsonArray;[Lcom/google/gson/JsonElement;)V", "(Lcom/google/gson/JsonObject;[Ljava/lang/String;)V", "plus", "(Lcom/google/gson/JsonArray;[Ljava/lang/Object;)Lcom/google/gson/JsonArray;", "obj", "pairs", "Lkotlin/Pair;", "(Lcom/google/gson/JsonObject;[Lkotlin/Pair;)Lcom/google/gson/JsonObject;", "entries", "", "(Lcom/google/gson/JsonObject;[Ljava/util/Map$Entry;)Lcom/google/gson/JsonObject;", "pair", "entry", "map", "", "plusAssign", "(Lcom/google/gson/JsonObject;[Lkotlin/Pair;)V", "(Lcom/google/gson/JsonObject;[Ljava/util/Map$Entry;)V", "put", "putAll", "putAllEntries", "removeAll", "removeAllIndexes", "indexes", "", "", "removeAllJsonKeys", "(Lcom/google/gson/JsonObject;[Lcom/google/gson/JsonElement;)V", "set", "kotlin.jvm.PlatformType", "kotson_main"}, k = 2, mv = {1, 1, 1})
/* compiled from: Mutable.kt */
public final class MutableKt {
    public static final void set(JsonElement jsonElement, String str, Object obj) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        Intrinsics.checkParameterIsNotNull(str, "key");
        ElementKt.getObj(jsonElement).add(str, BuilderKt.toJsonElement(obj));
    }

    public static final JsonElement set(JsonElement jsonElement, int i, Object obj) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return ElementKt.getArray(jsonElement).set(i, BuilderKt.toJsonElement(obj));
    }

    public static final void put(JsonObject jsonObject, Pair<String, ? extends Object> pair) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        Intrinsics.checkParameterIsNotNull(pair, "pair");
        jsonObject.add(pair.getFirst(), BuilderKt.toJsonElement(pair.getSecond()));
    }

    public static final void put(JsonObject jsonObject, Map.Entry<String, ? extends Object> entry) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        Intrinsics.checkParameterIsNotNull(entry, "entry");
        jsonObject.add(entry.getKey(), BuilderKt.toJsonElement(entry.getValue()));
    }

    public static final void putAll(JsonObject jsonObject, Pair<String, ? extends Object>... pairArr) {
        Pair<String, ? extends Object>[] pairArr2;
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        Intrinsics.checkParameterIsNotNull(pairArr, "pairs");
        for (Pair<String, ? extends Object> pair : pairArr) {
            put(jsonObject, pair);
        }
    }

    public static final void putAll(JsonObject jsonObject, Map.Entry<String, ? extends Object>... entryArr) {
        Map.Entry<String, ? extends Object>[] entryArr2;
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        Intrinsics.checkParameterIsNotNull(entryArr, "entries");
        for (Map.Entry<String, ? extends Object> entry : entryArr) {
            put(jsonObject, entry);
        }
    }

    public static final void putAll(JsonObject jsonObject, Map<String, ? extends Object> map) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        Intrinsics.checkParameterIsNotNull(map, "map");
        Iterator<T> it2 = map.entrySet().iterator();
        while (it2.hasNext()) {
            put(jsonObject, (Map.Entry<String, ? extends Object>) it2.next());
        }
    }

    public static final void putAll(JsonObject jsonObject, JsonObject jsonObject2) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        Intrinsics.checkParameterIsNotNull(jsonObject2, "obj");
        for (T t : jsonObject2.entrySet()) {
            Intrinsics.checkExpressionValueIsNotNull(t, "it");
            put(jsonObject, (Map.Entry<String, ? extends Object>) t);
        }
    }

    public static final JsonObject plus(JsonObject jsonObject, Pair<String, ? extends Object> pair) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        Intrinsics.checkParameterIsNotNull(pair, "pair");
        JsonObject shallowCopy = BuilderKt.shallowCopy(jsonObject);
        put(shallowCopy, pair);
        return shallowCopy;
    }

    public static final JsonObject plus(JsonObject jsonObject, Map.Entry<String, ? extends Object> entry) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        Intrinsics.checkParameterIsNotNull(entry, "entry");
        JsonObject shallowCopy = BuilderKt.shallowCopy(jsonObject);
        put(shallowCopy, entry);
        return shallowCopy;
    }

    public static final JsonObject plus(JsonObject jsonObject, Pair<String, Object>[] pairArr) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        Intrinsics.checkParameterIsNotNull(pairArr, "pairs");
        JsonObject shallowCopy = BuilderKt.shallowCopy(jsonObject);
        putAll(shallowCopy, (Pair[]) Arrays.copyOf(pairArr, pairArr.length));
        return shallowCopy;
    }

    public static final JsonObject plus(JsonObject jsonObject, Map.Entry<String, Object>[] entryArr) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        Intrinsics.checkParameterIsNotNull(entryArr, "entries");
        JsonObject shallowCopy = BuilderKt.shallowCopy(jsonObject);
        putAll(shallowCopy, (Map.Entry[]) Arrays.copyOf(entryArr, entryArr.length));
        return shallowCopy;
    }

    public static final JsonObject plus(JsonObject jsonObject, Map<String, ? extends Object> map) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        Intrinsics.checkParameterIsNotNull(map, "map");
        JsonObject shallowCopy = BuilderKt.shallowCopy(jsonObject);
        putAll(shallowCopy, map);
        return shallowCopy;
    }

    public static final JsonObject plus(JsonObject jsonObject, JsonObject jsonObject2) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        Intrinsics.checkParameterIsNotNull(jsonObject2, "obj");
        JsonObject shallowCopy = BuilderKt.shallowCopy(jsonObject);
        putAll(shallowCopy, jsonObject2);
        return shallowCopy;
    }

    public static final void plusAssign(JsonObject jsonObject, Pair<String, ? extends Object> pair) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        Intrinsics.checkParameterIsNotNull(pair, "pair");
        put(jsonObject, pair);
    }

    public static final void plusAssign(JsonObject jsonObject, Map.Entry<String, ? extends Object> entry) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        Intrinsics.checkParameterIsNotNull(entry, "entry");
        put(jsonObject, entry);
    }

    public static final void plusAssign(JsonObject jsonObject, Pair<String, Object>[] pairArr) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        Intrinsics.checkParameterIsNotNull(pairArr, "pairs");
        putAll(jsonObject, (Pair[]) Arrays.copyOf(pairArr, pairArr.length));
    }

    public static final void plusAssign(JsonObject jsonObject, Map.Entry<String, Object>[] entryArr) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        Intrinsics.checkParameterIsNotNull(entryArr, "entries");
        putAll(jsonObject, (Map.Entry[]) Arrays.copyOf(entryArr, entryArr.length));
    }

    public static final void plusAssign(JsonObject jsonObject, Map<String, ? extends Object> map) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        Intrinsics.checkParameterIsNotNull(map, "map");
        putAll(jsonObject, map);
    }

    public static final void plusAssign(JsonObject jsonObject, JsonObject jsonObject2) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        Intrinsics.checkParameterIsNotNull(jsonObject2, "obj");
        putAll(jsonObject, jsonObject2);
    }

    public static final void removeAll(JsonObject jsonObject, String... strArr) {
        String[] strArr2;
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        Intrinsics.checkParameterIsNotNull(strArr, "keys");
        for (String str : strArr) {
            jsonObject.remove(str);
        }
    }

    public static final void removeAllJsonKeys(JsonObject jsonObject, JsonElement... jsonElementArr) {
        JsonElement[] jsonElementArr2;
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        Intrinsics.checkParameterIsNotNull(jsonElementArr, "keys");
        for (JsonElement jsonElement : jsonElementArr) {
            jsonObject.remove(ElementKt.getString(jsonElement));
        }
    }

    public static final JsonObject minus(JsonObject jsonObject, String str) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        Intrinsics.checkParameterIsNotNull(str, "key");
        JsonObject shallowCopy = BuilderKt.shallowCopy(jsonObject);
        shallowCopy.remove(str);
        return shallowCopy;
    }

    public static final JsonObject minus(JsonObject jsonObject, String[] strArr) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        Intrinsics.checkParameterIsNotNull(strArr, "keys");
        JsonObject shallowCopy = BuilderKt.shallowCopy(jsonObject);
        removeAll(shallowCopy, (String[]) Arrays.copyOf(strArr, strArr.length));
        return shallowCopy;
    }

    public static final JsonObject minus(JsonObject jsonObject, Iterable<String> iterable) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        Intrinsics.checkParameterIsNotNull(iterable, "keys");
        JsonObject shallowCopy = BuilderKt.shallowCopy(jsonObject);
        removeAll(shallowCopy, iterable);
        return shallowCopy;
    }

    public static final JsonObject minus(JsonObject jsonObject, Sequence<String> sequence) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        Intrinsics.checkParameterIsNotNull(sequence, "keys");
        JsonObject shallowCopy = BuilderKt.shallowCopy(jsonObject);
        removeAll(shallowCopy, sequence);
        return shallowCopy;
    }

    public static final void minusAssign(JsonObject jsonObject, String str) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        Intrinsics.checkParameterIsNotNull(str, "key");
        jsonObject.remove(str);
    }

    public static final void minusAssign(JsonObject jsonObject, String[] strArr) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        Intrinsics.checkParameterIsNotNull(strArr, "keys");
        removeAll(jsonObject, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public static final void minusAssign(JsonObject jsonObject, Iterable<String> iterable) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        Intrinsics.checkParameterIsNotNull(iterable, "keys");
        removeAll(jsonObject, iterable);
    }

    public static final void minusAssign(JsonObject jsonObject, Sequence<String> sequence) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        Intrinsics.checkParameterIsNotNull(sequence, "keys");
        removeAll(jsonObject, sequence);
    }

    public static final void add(JsonArray jsonArray, Object obj) {
        Intrinsics.checkParameterIsNotNull(jsonArray, "$receiver");
        jsonArray.add(BuilderKt.toJsonElement(obj));
    }

    public static final JsonArray plus(JsonArray jsonArray, Object obj) {
        Intrinsics.checkParameterIsNotNull(jsonArray, "$receiver");
        JsonArray shallowCopy = BuilderKt.shallowCopy(jsonArray);
        add(shallowCopy, obj);
        return shallowCopy;
    }

    public static final JsonArray plus(JsonArray jsonArray, Object[] objArr) {
        Intrinsics.checkParameterIsNotNull(jsonArray, "$receiver");
        Intrinsics.checkParameterIsNotNull(objArr, "values");
        JsonArray shallowCopy = BuilderKt.shallowCopy(jsonArray);
        addAll(shallowCopy, objArr);
        return shallowCopy;
    }

    public static final JsonArray plus(JsonArray jsonArray, Iterable<? extends Object> iterable) {
        Intrinsics.checkParameterIsNotNull(jsonArray, "$receiver");
        Intrinsics.checkParameterIsNotNull(iterable, "values");
        JsonArray shallowCopy = BuilderKt.shallowCopy(jsonArray);
        addAll(shallowCopy, iterable);
        return shallowCopy;
    }

    public static final JsonArray plus(JsonArray jsonArray, Sequence<? extends Object> sequence) {
        Intrinsics.checkParameterIsNotNull(jsonArray, "$receiver");
        Intrinsics.checkParameterIsNotNull(sequence, "values");
        JsonArray shallowCopy = BuilderKt.shallowCopy(jsonArray);
        addAll(shallowCopy, sequence);
        return shallowCopy;
    }

    public static final void plusAssign(JsonArray jsonArray, Object obj) {
        Intrinsics.checkParameterIsNotNull(jsonArray, "$receiver");
        add(jsonArray, obj);
    }

    public static final void plusAssign(JsonArray jsonArray, Object[] objArr) {
        Intrinsics.checkParameterIsNotNull(jsonArray, "$receiver");
        Intrinsics.checkParameterIsNotNull(objArr, "values");
        addAll(jsonArray, objArr);
    }

    public static final void plusAssign(JsonArray jsonArray, Iterable<? extends Object> iterable) {
        Intrinsics.checkParameterIsNotNull(jsonArray, "$receiver");
        Intrinsics.checkParameterIsNotNull(iterable, "values");
        addAll(jsonArray, iterable);
    }

    public static final void plusAssign(JsonArray jsonArray, Sequence<? extends Object> sequence) {
        Intrinsics.checkParameterIsNotNull(jsonArray, "$receiver");
        Intrinsics.checkParameterIsNotNull(sequence, "values");
        addAll(jsonArray, sequence);
    }

    public static final void removeAll(JsonArray jsonArray, JsonElement... jsonElementArr) {
        JsonElement[] jsonElementArr2;
        Intrinsics.checkParameterIsNotNull(jsonArray, "$receiver");
        Intrinsics.checkParameterIsNotNull(jsonElementArr, "values");
        for (JsonElement jsonElement : jsonElementArr) {
            jsonArray.remove(jsonElement);
        }
    }

    public static final JsonArray minus(JsonArray jsonArray, JsonElement jsonElement) {
        Intrinsics.checkParameterIsNotNull(jsonArray, "$receiver");
        Intrinsics.checkParameterIsNotNull(jsonElement, "value");
        JsonArray shallowCopy = BuilderKt.shallowCopy(jsonArray);
        shallowCopy.remove(jsonElement);
        return shallowCopy;
    }

    public static final JsonArray minus(JsonArray jsonArray, JsonElement[] jsonElementArr) {
        Intrinsics.checkParameterIsNotNull(jsonArray, "$receiver");
        Intrinsics.checkParameterIsNotNull(jsonElementArr, "values");
        JsonArray shallowCopy = BuilderKt.shallowCopy(jsonArray);
        removeAll(shallowCopy, (JsonElement[]) Arrays.copyOf(jsonElementArr, jsonElementArr.length));
        return shallowCopy;
    }

    public static final JsonArray minus(JsonArray jsonArray, Iterable<? extends JsonElement> iterable) {
        Intrinsics.checkParameterIsNotNull(jsonArray, "$receiver");
        Intrinsics.checkParameterIsNotNull(iterable, "values");
        JsonArray shallowCopy = BuilderKt.shallowCopy(jsonArray);
        removeAll(shallowCopy, iterable);
        return shallowCopy;
    }

    public static final JsonArray minus(JsonArray jsonArray, Sequence<? extends JsonElement> sequence) {
        Intrinsics.checkParameterIsNotNull(jsonArray, "$receiver");
        Intrinsics.checkParameterIsNotNull(sequence, "values");
        JsonArray shallowCopy = BuilderKt.shallowCopy(jsonArray);
        removeAll(shallowCopy, sequence);
        return shallowCopy;
    }

    public static final void minusAssign(JsonArray jsonArray, JsonElement jsonElement) {
        Intrinsics.checkParameterIsNotNull(jsonArray, "$receiver");
        Intrinsics.checkParameterIsNotNull(jsonElement, "value");
        jsonArray.remove(jsonElement);
    }

    public static final void minusAssign(JsonArray jsonArray, JsonElement[] jsonElementArr) {
        Intrinsics.checkParameterIsNotNull(jsonArray, "$receiver");
        Intrinsics.checkParameterIsNotNull(jsonElementArr, "values");
        removeAll(jsonArray, (JsonElement[]) Arrays.copyOf(jsonElementArr, jsonElementArr.length));
    }

    public static final void minusAssign(JsonArray jsonArray, Iterable<? extends JsonElement> iterable) {
        Intrinsics.checkParameterIsNotNull(jsonArray, "$receiver");
        Intrinsics.checkParameterIsNotNull(iterable, "values");
        removeAll(jsonArray, iterable);
    }

    public static final void minusAssign(JsonArray jsonArray, Sequence<? extends JsonElement> sequence) {
        Intrinsics.checkParameterIsNotNull(jsonArray, "$receiver");
        Intrinsics.checkParameterIsNotNull(sequence, "values");
        removeAll(jsonArray, sequence);
    }

    public static final void putAll(JsonObject jsonObject, Sequence<? extends Pair<String, ? extends Object>> sequence) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        Intrinsics.checkParameterIsNotNull(sequence, "pairs");
        Iterator<? extends Pair<String, ? extends Object>> it2 = sequence.iterator();
        while (it2.hasNext()) {
            put(jsonObject, (Pair) it2.next());
        }
    }

    public static final void putAll(JsonObject jsonObject, Iterable<? extends Pair<String, ? extends Object>> iterable) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        Intrinsics.checkParameterIsNotNull(iterable, "pairs");
        Iterator<? extends Pair<String, ? extends Object>> it2 = iterable.iterator();
        while (it2.hasNext()) {
            put(jsonObject, (Pair) it2.next());
        }
    }

    public static final void putAllEntries(JsonObject jsonObject, Sequence<? extends Map.Entry<String, ? extends Object>> sequence) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        Intrinsics.checkParameterIsNotNull(sequence, "entries");
        Iterator<? extends Map.Entry<String, ? extends Object>> it2 = sequence.iterator();
        while (it2.hasNext()) {
            put(jsonObject, (Map.Entry) it2.next());
        }
    }

    public static final void putAllEntries(JsonObject jsonObject, Iterable<? extends Map.Entry<String, ? extends Object>> iterable) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        Intrinsics.checkParameterIsNotNull(iterable, "entries");
        Iterator<? extends Map.Entry<String, ? extends Object>> it2 = iterable.iterator();
        while (it2.hasNext()) {
            put(jsonObject, (Map.Entry) it2.next());
        }
    }

    public static final void removeAll(JsonObject jsonObject, Iterable<String> iterable) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        Intrinsics.checkParameterIsNotNull(iterable, "keys");
        for (String str : iterable) {
            jsonObject.remove(str);
        }
    }

    public static final void removeAll(JsonObject jsonObject, Sequence<String> sequence) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        Intrinsics.checkParameterIsNotNull(sequence, "keys");
        for (String str : sequence) {
            jsonObject.remove(str);
        }
    }

    public static final void removeAllJsonKeys(JsonObject jsonObject, Iterable<? extends JsonElement> iterable) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        Intrinsics.checkParameterIsNotNull(iterable, "keys");
        for (JsonElement jsonElement : iterable) {
            jsonObject.remove(ElementKt.getString(jsonElement));
        }
    }

    public static final void removeAllJsonKeys(JsonObject jsonObject, Sequence<? extends JsonElement> sequence) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        Intrinsics.checkParameterIsNotNull(sequence, "keys");
        for (JsonElement jsonElement : sequence) {
            jsonObject.remove(ElementKt.getString(jsonElement));
        }
    }

    public static final void addAll(JsonArray jsonArray, Object... objArr) {
        Intrinsics.checkParameterIsNotNull(jsonArray, "$receiver");
        Intrinsics.checkParameterIsNotNull(objArr, "values");
        for (Object obj : objArr) {
            add(jsonArray, obj);
        }
    }

    public static final void addAll(JsonArray jsonArray, Iterable<? extends Object> iterable) {
        Intrinsics.checkParameterIsNotNull(jsonArray, "$receiver");
        Intrinsics.checkParameterIsNotNull(iterable, "values");
        for (Object obj : iterable) {
            add(jsonArray, obj);
        }
    }

    public static final void addAll(JsonArray jsonArray, Sequence<? extends Object> sequence) {
        Intrinsics.checkParameterIsNotNull(jsonArray, "$receiver");
        Intrinsics.checkParameterIsNotNull(sequence, "values");
        for (Object obj : sequence) {
            add(jsonArray, obj);
        }
    }

    public static final void removeAll(JsonArray jsonArray, Iterable<? extends JsonElement> iterable) {
        Intrinsics.checkParameterIsNotNull(jsonArray, "$receiver");
        Intrinsics.checkParameterIsNotNull(iterable, "values");
        for (JsonElement jsonElement : iterable) {
            jsonArray.remove(jsonElement);
        }
    }

    public static final void removeAll(JsonArray jsonArray, Sequence<? extends JsonElement> sequence) {
        Intrinsics.checkParameterIsNotNull(jsonArray, "$receiver");
        Intrinsics.checkParameterIsNotNull(sequence, "values");
        for (JsonElement jsonElement : sequence) {
            jsonArray.remove(jsonElement);
        }
    }

    public static final void removeAllIndexes(JsonArray jsonArray, int... iArr) {
        Intrinsics.checkParameterIsNotNull(jsonArray, "$receiver");
        Intrinsics.checkParameterIsNotNull(iArr, "indexes");
        for (int i : iArr) {
            jsonArray.remove(i);
        }
    }

    public static final void removeAllIndexes(JsonArray jsonArray, Iterable<Integer> iterable) {
        Intrinsics.checkParameterIsNotNull(jsonArray, "$receiver");
        Intrinsics.checkParameterIsNotNull(iterable, "indexes");
        for (Integer num : iterable) {
            jsonArray.remove(num.intValue());
        }
    }

    public static final void removeAllIndexes(JsonArray jsonArray, Sequence<Integer> sequence) {
        Intrinsics.checkParameterIsNotNull(jsonArray, "$receiver");
        Intrinsics.checkParameterIsNotNull(sequence, "indexes");
        for (Integer num : sequence) {
            jsonArray.remove(num.intValue());
        }
    }
}
