package com.github.salomonbrys.kotson;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(bv = {1, 0, 0}, d1 = {"\u0000¶\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u001e\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\u001a8\u0010a\u001a\u0004\u0018\u0001Hb\"\b\b\u0000\u0010b*\u00020c*\u0004\u0018\u00010\u00062\u0017\u0010d\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002Hb0e¢\u0006\u0002\bfH\u0002¢\u0006\u0002\u0010g\u001a\u001c\u0010h\u001a\u00020i*\u00020M2\u0006\u0010j\u001a\u00020U2\b\u0010k\u001a\u0004\u0018\u00010\u0006\u001a$\u0010h\u001a\u00020i*\u00020M2\u0006\u0010j\u001a\u00020U2\b\u0010k\u001a\u0004\u0018\u00010c2\u0006\u0010l\u001a\u00020m\u001a#\u0010n\u001a\u0004\u0018\u00010i*\u00020M2\u0006\u0010j\u001a\u00020U2\b\u0010k\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010o\u001a+\u0010n\u001a\u0004\u0018\u00010i*\u00020M2\u0006\u0010j\u001a\u00020U2\b\u0010k\u001a\u0004\u0018\u00010c2\u0006\u0010l\u001a\u00020m¢\u0006\u0002\u0010p\u001a#\u0010n\u001a\u0004\u0018\u00010i*\u00020M2\u0006\u0010j\u001a\u00020U2\b\u0010k\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010q\u001a#\u0010n\u001a\u0004\u0018\u00010i*\u00020M2\u0006\u0010j\u001a\u00020U2\b\u0010k\u001a\u0004\u0018\u00010\u001a¢\u0006\u0002\u0010r\u001a#\u0010n\u001a\u0004\u0018\u00010i*\u00020M2\u0006\u0010j\u001a\u00020U2\b\u0010k\u001a\u0004\u0018\u00010I¢\u0006\u0002\u0010s\u001a#\u0010n\u001a\u0004\u0018\u00010i*\u00020M2\u0006\u0010j\u001a\u00020U2\b\u0010k\u001a\u0004\u0018\u00010U¢\u0006\u0002\u0010t\u001a\u0015\u0010u\u001a\u00020\u0012*\u00020\u00052\u0006\u0010k\u001a\u00020cH\u0002\u001a\u0015\u0010u\u001a\u00020\u0012*\u00020M2\u0006\u0010v\u001a\u00020UH\u0002\u001a$\u0010w\u001a\u00020i*\u00020M2\u0018\u0010x\u001a\u0014\u0012\u0004\u0012\u00020U\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020i0y\u001a\u0015\u0010z\u001a\u00020\u0006*\u00020\u00062\u0006\u0010{\u001a\u00020&H\u0002\u001a\u0015\u0010z\u001a\u00020\u0006*\u00020\u00062\u0006\u0010v\u001a\u00020UH\u0002\u001a\u0012\u0010d\u001a\u00020\u0006*\u00020M2\u0006\u0010v\u001a\u00020U\u001a\n\u0010|\u001a\u00020\u0012*\u00020M\u001a\n\u0010}\u001a\u00020\u0012*\u00020M\u001a\u0010\u0010~\u001a\b\u0012\u0004\u0012\u00020U0*\u00020M\u001a\u000b\u0010\u0001\u001a\u00020&*\u00020M\u001a\u0018\u0010\u0001\u001a\u000f\u0012\u0004\u0012\u00020U\u0012\u0004\u0012\u00020\u00060\u0001*\u00020M\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0015\u0010\u0004\u001a\u00020\u0005*\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u0015\u0010\t\u001a\u00020\n*\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\"\u0015\u0010\r\u001a\u00020\u000e*\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u0015\u0010\u0011\u001a\u00020\u0012*\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\"\u0015\u0010\u0015\u001a\u00020\u0016*\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018\"\u0015\u0010\u0019\u001a\u00020\u001a*\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\"\u0015\u0010\u001d\u001a\u00020\u001e*\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 \"\u0015\u0010!\u001a\u00020\"*\u00020\u00068F¢\u0006\u0006\u001a\u0004\b#\u0010$\"\u0015\u0010%\u001a\u00020&*\u00020\u00068F¢\u0006\u0006\u001a\u0004\b'\u0010(\"\u0015\u0010)\u001a\u00020**\u00020\u00068F¢\u0006\u0006\u001a\u0004\b+\u0010,\"\u0019\u0010-\u001a\u0004\u0018\u00010\u0005*\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b.\u0010\b\"\u0019\u0010/\u001a\u0004\u0018\u00010\n*\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b0\u0010\f\"\u0019\u00101\u001a\u0004\u0018\u00010\u000e*\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b2\u0010\u0010\"\u0019\u00103\u001a\u0004\u0018\u00010\u0012*\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b4\u00105\"\u0019\u00106\u001a\u0004\u0018\u00010\u0016*\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b7\u00108\"\u0019\u00109\u001a\u0004\u0018\u00010\u001a*\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b:\u0010;\"\u0019\u0010<\u001a\u0004\u0018\u00010\u001e*\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b=\u0010>\"\u0019\u0010?\u001a\u0004\u0018\u00010\"*\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b@\u0010A\"\u0019\u0010B\u001a\u0004\u0018\u00010&*\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\bC\u0010D\"\u0019\u0010E\u001a\u0004\u0018\u00010**\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\bF\u0010G\"\u0019\u0010H\u001a\u0004\u0018\u00010I*\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\bJ\u0010K\"\u0019\u0010L\u001a\u0004\u0018\u00010M*\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\bN\u0010O\"\u0019\u0010P\u001a\u0004\u0018\u00010Q*\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\bR\u0010S\"\u0019\u0010T\u001a\u0004\u0018\u00010U*\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\bV\u0010W\"\u0015\u0010X\u001a\u00020I*\u00020\u00068F¢\u0006\u0006\u001a\u0004\bY\u0010K\"\u0015\u0010Z\u001a\u00020M*\u00020\u00068F¢\u0006\u0006\u001a\u0004\b[\u0010O\"\u0015\u0010\\\u001a\u00020Q*\u00020\u00068F¢\u0006\u0006\u001a\u0004\b]\u0010^\"\u0015\u0010_\u001a\u00020U*\u00020\u00068F¢\u0006\u0006\u001a\u0004\b`\u0010W¨\u0006\u0001"}, d2 = {"jsonNull", "Lcom/google/gson/JsonNull;", "getJsonNull", "()Lcom/google/gson/JsonNull;", "array", "Lcom/google/gson/JsonArray;", "Lcom/google/gson/JsonElement;", "getArray", "(Lcom/google/gson/JsonElement;)Lcom/google/gson/JsonArray;", "bigDecimal", "Ljava/math/BigDecimal;", "getBigDecimal", "(Lcom/google/gson/JsonElement;)Ljava/math/BigDecimal;", "bigInteger", "Ljava/math/BigInteger;", "getBigInteger", "(Lcom/google/gson/JsonElement;)Ljava/math/BigInteger;", "bool", "", "getBool", "(Lcom/google/gson/JsonElement;)Z", "byte", "", "getByte", "(Lcom/google/gson/JsonElement;)B", "char", "", "getChar", "(Lcom/google/gson/JsonElement;)C", "double", "", "getDouble", "(Lcom/google/gson/JsonElement;)D", "float", "", "getFloat", "(Lcom/google/gson/JsonElement;)F", "int", "", "getInt", "(Lcom/google/gson/JsonElement;)I", "long", "", "getLong", "(Lcom/google/gson/JsonElement;)J", "nullArray", "getNullArray", "nullBigDecimal", "getNullBigDecimal", "nullBigInteger", "getNullBigInteger", "nullBool", "getNullBool", "(Lcom/google/gson/JsonElement;)Ljava/lang/Boolean;", "nullByte", "getNullByte", "(Lcom/google/gson/JsonElement;)Ljava/lang/Byte;", "nullChar", "getNullChar", "(Lcom/google/gson/JsonElement;)Ljava/lang/Character;", "nullDouble", "getNullDouble", "(Lcom/google/gson/JsonElement;)Ljava/lang/Double;", "nullFloat", "getNullFloat", "(Lcom/google/gson/JsonElement;)Ljava/lang/Float;", "nullInt", "getNullInt", "(Lcom/google/gson/JsonElement;)Ljava/lang/Integer;", "nullLong", "getNullLong", "(Lcom/google/gson/JsonElement;)Ljava/lang/Long;", "nullNumber", "", "getNullNumber", "(Lcom/google/gson/JsonElement;)Ljava/lang/Number;", "nullObj", "Lcom/google/gson/JsonObject;", "getNullObj", "(Lcom/google/gson/JsonElement;)Lcom/google/gson/JsonObject;", "nullShort", "", "getNullShort", "(Lcom/google/gson/JsonElement;)Ljava/lang/Short;", "nullString", "", "getNullString", "(Lcom/google/gson/JsonElement;)Ljava/lang/String;", "number", "getNumber", "obj", "getObj", "short", "getShort", "(Lcom/google/gson/JsonElement;)S", "string", "getString", "_nullOr", "T", "", "getNotNull", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Lcom/google/gson/JsonElement;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "addProperty", "", "property", "value", "context", "Lcom/google/gson/JsonSerializationContext;", "addPropertyIfNotNull", "(Lcom/google/gson/JsonObject;Ljava/lang/String;Lcom/google/gson/JsonElement;)Lkotlin/Unit;", "(Lcom/google/gson/JsonObject;Ljava/lang/String;Ljava/lang/Object;Lcom/google/gson/JsonSerializationContext;)Lkotlin/Unit;", "(Lcom/google/gson/JsonObject;Ljava/lang/String;Ljava/lang/Boolean;)Lkotlin/Unit;", "(Lcom/google/gson/JsonObject;Ljava/lang/String;Ljava/lang/Character;)Lkotlin/Unit;", "(Lcom/google/gson/JsonObject;Ljava/lang/String;Ljava/lang/Number;)Lkotlin/Unit;", "(Lcom/google/gson/JsonObject;Ljava/lang/String;Ljava/lang/String;)Lkotlin/Unit;", "contains", "key", "forEach", "operation", "Lkotlin/Function2;", "get", "index", "isEmpty", "isNotEmpty", "keys", "", "size", "toMap", "", "kotson_main"}, k = 2, mv = {1, 1, 1})
/* compiled from: Element.kt */
public final class ElementKt {
    private static final JsonNull jsonNull;

    private static final <T> T _nullOr(JsonElement jsonElement, Function1<? super JsonElement, ? extends T> function1) {
        if (jsonElement == null || jsonElement.isJsonNull()) {
            return null;
        }
        return (T) function1.invoke(jsonElement);
    }

    public static final String getString(JsonElement jsonElement) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        String asString = jsonElement.getAsString();
        Intrinsics.checkExpressionValueIsNotNull(asString, "asString");
        return asString;
    }

    public static final String getNullString(JsonElement jsonElement) {
        return (String) _nullOr(jsonElement, ElementKt$nullString$1.INSTANCE);
    }

    public static final boolean getBool(JsonElement jsonElement) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return jsonElement.getAsBoolean();
    }

    public static final Boolean getNullBool(JsonElement jsonElement) {
        return (Boolean) _nullOr(jsonElement, ElementKt$nullBool$1.INSTANCE);
    }

    public static final byte getByte(JsonElement jsonElement) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return jsonElement.getAsByte();
    }

    public static final Byte getNullByte(JsonElement jsonElement) {
        return (Byte) _nullOr(jsonElement, ElementKt$nullByte$1.INSTANCE);
    }

    public static final char getChar(JsonElement jsonElement) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return jsonElement.getAsCharacter();
    }

    public static final Character getNullChar(JsonElement jsonElement) {
        return (Character) _nullOr(jsonElement, ElementKt$nullChar$1.INSTANCE);
    }

    public static final short getShort(JsonElement jsonElement) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return jsonElement.getAsShort();
    }

    public static final Short getNullShort(JsonElement jsonElement) {
        return (Short) _nullOr(jsonElement, ElementKt$nullShort$1.INSTANCE);
    }

    public static final int getInt(JsonElement jsonElement) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return jsonElement.getAsInt();
    }

    public static final Integer getNullInt(JsonElement jsonElement) {
        return (Integer) _nullOr(jsonElement, ElementKt$nullInt$1.INSTANCE);
    }

    public static final long getLong(JsonElement jsonElement) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return jsonElement.getAsLong();
    }

    public static final Long getNullLong(JsonElement jsonElement) {
        return (Long) _nullOr(jsonElement, ElementKt$nullLong$1.INSTANCE);
    }

    public static final float getFloat(JsonElement jsonElement) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return jsonElement.getAsFloat();
    }

    public static final Float getNullFloat(JsonElement jsonElement) {
        return (Float) _nullOr(jsonElement, ElementKt$nullFloat$1.INSTANCE);
    }

    public static final double getDouble(JsonElement jsonElement) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return jsonElement.getAsDouble();
    }

    public static final Double getNullDouble(JsonElement jsonElement) {
        return (Double) _nullOr(jsonElement, ElementKt$nullDouble$1.INSTANCE);
    }

    public static final Number getNumber(JsonElement jsonElement) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        Number asNumber = jsonElement.getAsNumber();
        Intrinsics.checkExpressionValueIsNotNull(asNumber, "asNumber");
        return asNumber;
    }

    public static final Number getNullNumber(JsonElement jsonElement) {
        return (Number) _nullOr(jsonElement, ElementKt$nullNumber$1.INSTANCE);
    }

    public static final BigInteger getBigInteger(JsonElement jsonElement) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        BigInteger asBigInteger = jsonElement.getAsBigInteger();
        Intrinsics.checkExpressionValueIsNotNull(asBigInteger, "asBigInteger");
        return asBigInteger;
    }

    public static final BigInteger getNullBigInteger(JsonElement jsonElement) {
        return (BigInteger) _nullOr(jsonElement, ElementKt$nullBigInteger$1.INSTANCE);
    }

    public static final BigDecimal getBigDecimal(JsonElement jsonElement) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        BigDecimal asBigDecimal = jsonElement.getAsBigDecimal();
        Intrinsics.checkExpressionValueIsNotNull(asBigDecimal, "asBigDecimal");
        return asBigDecimal;
    }

    public static final BigDecimal getNullBigDecimal(JsonElement jsonElement) {
        return (BigDecimal) _nullOr(jsonElement, ElementKt$nullBigDecimal$1.INSTANCE);
    }

    public static final JsonArray getArray(JsonElement jsonElement) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        JsonArray asJsonArray = jsonElement.getAsJsonArray();
        Intrinsics.checkExpressionValueIsNotNull(asJsonArray, "asJsonArray");
        return asJsonArray;
    }

    public static final JsonArray getNullArray(JsonElement jsonElement) {
        return (JsonArray) _nullOr(jsonElement, ElementKt$nullArray$1.INSTANCE);
    }

    public static final JsonObject getObj(JsonElement jsonElement) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        Intrinsics.checkExpressionValueIsNotNull(asJsonObject, "asJsonObject");
        return asJsonObject;
    }

    public static final JsonObject getNullObj(JsonElement jsonElement) {
        return (JsonObject) _nullOr(jsonElement, ElementKt$nullObj$1.INSTANCE);
    }

    static {
        JsonNull jsonNull2 = JsonNull.INSTANCE;
        Intrinsics.checkExpressionValueIsNotNull(jsonNull2, "JsonNull.INSTANCE");
        jsonNull = jsonNull2;
    }

    public static final JsonNull getJsonNull() {
        return jsonNull;
    }

    public static final JsonElement get(JsonElement jsonElement, String str) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        Intrinsics.checkParameterIsNotNull(str, "key");
        return getNotNull(getObj(jsonElement), str);
    }

    public static final JsonElement get(JsonElement jsonElement, int i) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        JsonElement jsonElement2 = getArray(jsonElement).get(i);
        Intrinsics.checkExpressionValueIsNotNull(jsonElement2, "array.get(index)");
        return jsonElement2;
    }

    public static final JsonElement getNotNull(JsonObject jsonObject, String str) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        Intrinsics.checkParameterIsNotNull(str, "key");
        JsonElement jsonElement = jsonObject.get(str);
        if (jsonElement != null) {
            return jsonElement;
        }
        throw new NoSuchElementException("'" + str + "' is not found");
    }

    public static final boolean contains(JsonObject jsonObject, String str) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        Intrinsics.checkParameterIsNotNull(str, "key");
        return jsonObject.has(str);
    }

    public static final int size(JsonObject jsonObject) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        return jsonObject.entrySet().size();
    }

    public static final boolean isEmpty(JsonObject jsonObject) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        return jsonObject.entrySet().isEmpty();
    }

    public static final boolean isNotEmpty(JsonObject jsonObject) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        return !jsonObject.entrySet().isEmpty();
    }

    public static final Collection<String> keys(JsonObject jsonObject) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        Set<Map.Entry<String, JsonElement>> entrySet = jsonObject.entrySet();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(entrySet, 10));
        Iterator<T> it2 = entrySet.iterator();
        while (it2.hasNext()) {
            arrayList.add((String) it2.next().getKey());
        }
        return arrayList;
    }

    public static final void forEach(JsonObject jsonObject, Function2<? super String, ? super JsonElement, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        Intrinsics.checkParameterIsNotNull(function2, "operation");
        for (T t : jsonObject.entrySet()) {
            Object key = t.getKey();
            Intrinsics.checkExpressionValueIsNotNull(key, "it.key");
            Object value = t.getValue();
            Intrinsics.checkExpressionValueIsNotNull(value, "it.value");
            function2.invoke(key, value);
        }
    }

    public static final Map<String, JsonElement> toMap(JsonObject jsonObject) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        Set<Map.Entry<String, JsonElement>> entrySet = jsonObject.entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(entrySet, 10)), 16));
        for (T t : entrySet) {
            linkedHashMap.put((String) t.getKey(), (JsonElement) t.getValue());
        }
        return linkedHashMap;
    }

    public static final void addProperty(JsonObject jsonObject, String str, JsonElement jsonElement) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        Intrinsics.checkParameterIsNotNull(str, "property");
        jsonObject.add(str, jsonElement);
    }

    public static final void addProperty(JsonObject jsonObject, String str, Object obj, JsonSerializationContext jsonSerializationContext) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        Intrinsics.checkParameterIsNotNull(str, "property");
        Intrinsics.checkParameterIsNotNull(jsonSerializationContext, "context");
        jsonObject.add(str, jsonSerializationContext.serialize(obj));
    }

    public static final Unit addPropertyIfNotNull(JsonObject jsonObject, String str, String str2) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        Intrinsics.checkParameterIsNotNull(str, "property");
        if (str2 == null) {
            return null;
        }
        jsonObject.addProperty(str, str2);
        return Unit.INSTANCE;
    }

    public static final Unit addPropertyIfNotNull(JsonObject jsonObject, String str, Character ch) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        Intrinsics.checkParameterIsNotNull(str, "property");
        if (ch == null) {
            return null;
        }
        ch.charValue();
        jsonObject.addProperty(str, ch);
        return Unit.INSTANCE;
    }

    public static final Unit addPropertyIfNotNull(JsonObject jsonObject, String str, Boolean bool) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        Intrinsics.checkParameterIsNotNull(str, "property");
        if (bool == null) {
            return null;
        }
        bool.booleanValue();
        jsonObject.addProperty(str, bool);
        return Unit.INSTANCE;
    }

    public static final Unit addPropertyIfNotNull(JsonObject jsonObject, String str, Number number) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        Intrinsics.checkParameterIsNotNull(str, "property");
        if (number == null) {
            return null;
        }
        jsonObject.addProperty(str, number);
        return Unit.INSTANCE;
    }

    public static final Unit addPropertyIfNotNull(JsonObject jsonObject, String str, JsonElement jsonElement) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        Intrinsics.checkParameterIsNotNull(str, "property");
        if (jsonElement == null) {
            return null;
        }
        addProperty(jsonObject, str, jsonElement);
        return Unit.INSTANCE;
    }

    public static final Unit addPropertyIfNotNull(JsonObject jsonObject, String str, Object obj, JsonSerializationContext jsonSerializationContext) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        Intrinsics.checkParameterIsNotNull(str, "property");
        Intrinsics.checkParameterIsNotNull(jsonSerializationContext, "context");
        if (obj == null) {
            return null;
        }
        addProperty(jsonObject, str, obj, jsonSerializationContext);
        return Unit.INSTANCE;
    }

    public static final boolean contains(JsonArray jsonArray, Object obj) {
        Intrinsics.checkParameterIsNotNull(jsonArray, "$receiver");
        Intrinsics.checkParameterIsNotNull(obj, "value");
        return jsonArray.contains(BuilderKt.toJsonElement(obj));
    }
}
