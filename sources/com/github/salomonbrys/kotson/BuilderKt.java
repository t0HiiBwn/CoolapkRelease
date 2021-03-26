package com.github.salomonbrys.kotson;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonWriter;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

@Metadata(bv = {1, 0, 0}, d1 = {"\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\f\n\u0002\u0010\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003H\u0002\u001a \u0010\u0005\u001a\u00020\u00062\u0016\u0010\u0002\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\b\u0012\u0002\b\u00030\u00070\u0003H\u0002\u001a#\u0010\t\u001a\u00020\u00012\u0016\u0010\u0002\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040\n\"\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u000b\u001a\u0012\u0010\t\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\f\u001a\u0012\u0010\t\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\r\u001a3\u0010\u000e\u001a\u00020\u00062&\u0010\u0002\u001a\u0014\u0012\u0010\b\u0001\u0012\f\u0012\u0004\u0012\u00020\b\u0012\u0002\b\u00030\u00070\n\"\f\u0012\u0004\u0012\u00020\b\u0012\u0002\b\u00030\u0007¢\u0006\u0002\u0010\u000f\u001a\u001e\u0010\u000e\u001a\u00020\u00062\u0016\u0010\u0002\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\b\u0012\u0002\b\u00030\u00070\f\u001a\u001e\u0010\u000e\u001a\u00020\u00062\u0016\u0010\u0002\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\b\u0012\u0002\b\u00030\u00070\r\u001a\f\u0010\u0010\u001a\u00020\u0011*\u00020\u0011H\u0002\u001a\n\u0010\u0012\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u0012\u001a\u00020\u0006*\u00020\u0006\u001a\n\u0010\u0013\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u0013\u001a\u00020\u0006*\u00020\u0006\u001a\n\u0010\u0014\u001a\u00020\u0015*\u00020\u0016\u001a\n\u0010\u0014\u001a\u00020\u0015*\u00020\u0017\u001a\n\u0010\u0014\u001a\u00020\u0015*\u00020\u0018\u001a\n\u0010\u0014\u001a\u00020\u0015*\u00020\b\u001a\u000e\u0010\u0019\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\f\u001a\u000e\u0010\u0019\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\r\u001a\u000e\u0010\u001a\u001a\u00020\u0011*\u0004\u0018\u00010\u0004H\u0000\u001a\u001a\u0010\u001b\u001a\u00020\u0006*\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\b\u0012\u0002\b\u00030\u00070\f\u001a\u001a\u0010\u001b\u001a\u00020\u0006*\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\b\u0012\u0002\b\u00030\u00070\r\u001a\u0012\u0010\u001c\u001a\u00020\u001d*\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u0004¨\u0006\u001e"}, d2 = {"_jsonArray", "Lcom/google/gson/JsonArray;", "values", "", "", "_jsonObject", "Lcom/google/gson/JsonObject;", "Lkotlin/Pair;", "", "jsonArray", "", "([Ljava/lang/Object;)Lcom/google/gson/JsonArray;", "", "Lkotlin/sequences/Sequence;", "jsonObject", "([Lkotlin/Pair;)Lcom/google/gson/JsonObject;", "_deepCopy", "Lcom/google/gson/JsonElement;", "deepCopy", "shallowCopy", "toJson", "Lcom/google/gson/JsonPrimitive;", "", "", "", "toJsonArray", "toJsonElement", "toJsonObject", "value", "Lcom/google/gson/stream/JsonWriter;", "kotson_main"}, k = 2, mv = {1, 1, 1})
/* compiled from: Builder.kt */
public final class BuilderKt {
    public static final JsonPrimitive toJson(Number number) {
        Intrinsics.checkParameterIsNotNull(number, "$receiver");
        return new JsonPrimitive(number);
    }

    public static final JsonPrimitive toJson(char c) {
        return new JsonPrimitive(Character.valueOf(c));
    }

    public static final JsonPrimitive toJson(boolean z) {
        return new JsonPrimitive(Boolean.valueOf(z));
    }

    public static final JsonPrimitive toJson(String str) {
        Intrinsics.checkParameterIsNotNull(str, "$receiver");
        return new JsonPrimitive(str);
    }

    public static final JsonElement toJsonElement(Object obj) {
        if (obj == null) {
            return ElementKt.getJsonNull();
        }
        if (obj instanceof JsonElement) {
            return (JsonElement) obj;
        }
        if (obj instanceof String) {
            return toJson((String) obj);
        }
        if (obj instanceof Number) {
            return toJson((Number) obj);
        }
        if (obj instanceof Character) {
            return toJson(((Character) obj).charValue());
        }
        if (obj instanceof Boolean) {
            return toJson(((Boolean) obj).booleanValue());
        }
        throw new IllegalArgumentException(obj + " cannot be converted to JSON");
    }

    private static final JsonArray _jsonArray(Iterator<? extends Object> it2) {
        JsonArray jsonArray = new JsonArray();
        while (it2.hasNext()) {
            jsonArray.add(toJsonElement(it2.next()));
        }
        return jsonArray;
    }

    public static final JsonArray jsonArray(Object... objArr) {
        Intrinsics.checkParameterIsNotNull(objArr, "values");
        return _jsonArray(ArrayIteratorKt.iterator(objArr));
    }

    public static final JsonArray jsonArray(Iterable<?> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "values");
        return _jsonArray(iterable.iterator());
    }

    public static final JsonArray jsonArray(Sequence<?> sequence) {
        Intrinsics.checkParameterIsNotNull(sequence, "values");
        return _jsonArray(sequence.iterator());
    }

    public static final JsonArray toJsonArray(Iterable<?> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "$receiver");
        return jsonArray(iterable);
    }

    public static final JsonArray toJsonArray(Sequence<?> sequence) {
        Intrinsics.checkParameterIsNotNull(sequence, "$receiver");
        return jsonArray(sequence);
    }

    private static final JsonObject _jsonObject(Iterator<? extends Pair<String, ?>> it2) {
        JsonObject jsonObject = new JsonObject();
        while (it2.hasNext()) {
            Pair pair = (Pair) it2.next();
            jsonObject.add((String) pair.component1(), toJsonElement(pair.component2()));
        }
        return jsonObject;
    }

    public static final JsonObject jsonObject(Pair<String, ?>... pairArr) {
        Intrinsics.checkParameterIsNotNull(pairArr, "values");
        return _jsonObject(ArrayIteratorKt.iterator(pairArr));
    }

    public static final JsonObject jsonObject(Iterable<? extends Pair<String, ?>> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "values");
        return _jsonObject(iterable.iterator());
    }

    public static final JsonObject jsonObject(Sequence<? extends Pair<String, ?>> sequence) {
        Intrinsics.checkParameterIsNotNull(sequence, "values");
        return _jsonObject(sequence.iterator());
    }

    public static final JsonObject toJsonObject(Iterable<? extends Pair<String, ?>> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "$receiver");
        return jsonObject(iterable);
    }

    public static final JsonObject toJsonObject(Sequence<? extends Pair<String, ?>> sequence) {
        Intrinsics.checkParameterIsNotNull(sequence, "$receiver");
        return jsonObject(sequence);
    }

    public static final JsonObject shallowCopy(JsonObject jsonObject) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        JsonObject jsonObject2 = new JsonObject();
        for (T t : jsonObject.entrySet()) {
            Intrinsics.checkExpressionValueIsNotNull(t, "it");
            MutableKt.put(jsonObject2, (Map.Entry<String, ? extends Object>) t);
        }
        return jsonObject2;
    }

    public static final JsonArray shallowCopy(JsonArray jsonArray) {
        Intrinsics.checkParameterIsNotNull(jsonArray, "$receiver");
        JsonArray jsonArray2 = new JsonArray();
        jsonArray2.addAll(jsonArray);
        return jsonArray2;
    }

    private static final JsonElement _deepCopy(JsonElement jsonElement) {
        if ((jsonElement instanceof JsonNull) || (jsonElement instanceof JsonPrimitive)) {
            return jsonElement;
        }
        if (jsonElement instanceof JsonObject) {
            return deepCopy((JsonObject) jsonElement);
        }
        if (jsonElement instanceof JsonArray) {
            return deepCopy((JsonArray) jsonElement);
        }
        throw new IllegalArgumentException("Unknown JsonElement: " + jsonElement);
    }

    public static final JsonObject deepCopy(JsonObject jsonObject) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        JsonObject jsonObject2 = new JsonObject();
        for (T t : jsonObject.entrySet()) {
            jsonObject2.add((String) t.getKey(), _deepCopy((JsonElement) t.getValue()));
        }
        return jsonObject2;
    }

    public static final JsonArray deepCopy(JsonArray jsonArray) {
        Intrinsics.checkParameterIsNotNull(jsonArray, "$receiver");
        JsonArray jsonArray2 = new JsonArray();
        Iterator it2 = jsonArray.iterator();
        while (it2.hasNext()) {
            jsonArray2.add(_deepCopy((JsonElement) it2.next()));
        }
        return jsonArray2;
    }

    public static final JsonWriter value(JsonWriter jsonWriter, Object obj) {
        Intrinsics.checkParameterIsNotNull(jsonWriter, "$receiver");
        Intrinsics.checkParameterIsNotNull(obj, "value");
        if (obj instanceof Boolean) {
            JsonWriter value = jsonWriter.value(((Boolean) obj).booleanValue());
            Intrinsics.checkExpressionValueIsNotNull(value, "value(value)");
            return value;
        } else if (obj instanceof Double) {
            JsonWriter value2 = jsonWriter.value(((Number) obj).doubleValue());
            Intrinsics.checkExpressionValueIsNotNull(value2, "value(value)");
            return value2;
        } else if (obj instanceof Long) {
            JsonWriter value3 = jsonWriter.value(((Number) obj).longValue());
            Intrinsics.checkExpressionValueIsNotNull(value3, "value(value)");
            return value3;
        } else if (obj instanceof Number) {
            JsonWriter value4 = jsonWriter.value((Number) obj);
            Intrinsics.checkExpressionValueIsNotNull(value4, "value(value)");
            return value4;
        } else if (obj instanceof String) {
            JsonWriter value5 = jsonWriter.value((String) obj);
            Intrinsics.checkExpressionValueIsNotNull(value5, "value(value)");
            return value5;
        } else {
            throw new IllegalArgumentException(jsonWriter + " cannot be written on JsonWriter");
        }
    }
}
