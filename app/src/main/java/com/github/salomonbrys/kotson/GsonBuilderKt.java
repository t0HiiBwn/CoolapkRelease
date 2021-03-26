package com.github.salomonbrys.kotson;

import com.google.gson.GsonBuilder;
import com.google.gson.InstanceCreator;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(bv = {1, 0, 0}, d1 = {"\u0000l\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0015\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\b\u001a*\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002H\u00020\u0007\u001a,\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\t\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0007\u001a0\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00020\r\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0018\u0010\u000e\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u0007\u001a=\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0012\"\b\b\u0000\u0010\u0002*\u00020\u00032%\u0010\u0013\u001a!\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0007¢\u0006\u0002\b\u0016\u001a\u000e\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0001\u001a;\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0012\"\b\b\u0000\u0010\u0002*\u00020\u00032#\u0010\u0013\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0007¢\u0006\u0002\b\u0016\u001a\u0015\u0010\u001a\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\b\u001a\n\u0010\u001b\u001a\u00020\u001c*\u00020\u001d\u001aB\u0010\u001e\u001a\u00020\u001f\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u001f2'\b\b\u0010\u0013\u001a!\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0007¢\u0006\u0002\b\u0016H\b\u001aC\u0010 \u001a\u00020\u001f\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\u00012%\u0010\u0013\u001a!\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0007¢\u0006\u0002\b\u0016\u001aB\u0010!\u001a\u00020\u001f\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u001f2'\b\b\u0010\u0013\u001a!\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0007¢\u0006\u0002\b\u0016H\b\u001aI\u0010\"\u001a\u00020\u001f\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u001f2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00020#2%\u0010\u0013\u001a!\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0007¢\u0006\u0002\b\u0016\u001a@\u0010$\u001a\u00020\u001f\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u001f2%\b\b\u0010\u0013\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00020%\u0012\u0004\u0012\u00020\u00150\u0007¢\u0006\u0002\b\u0016H\b\u001a'\u0010$\u001a\u00020\u001f\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u001f2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\tH\b\u001a'\u0010$\u001a\u00020\u001f\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u001f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\rH\b\u001a!\u0010$\u001a\u00020\u001f\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u001f2\u0006\u0010\u0019\u001a\u00020\u0003H\b\u001aA\u0010&\u001a\u00020\u001f\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\u00012#\u0010\u0013\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00020%\u0012\u0004\u0012\u00020\u00150\u0007¢\u0006\u0002\b\u0016\u001a@\u0010'\u001a\u00020\u001f\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u001f2%\b\b\u0010\u0013\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00020%\u0012\u0004\u0012\u00020\u00150\u0007¢\u0006\u0002\b\u0016H\b\u001a!\u0010'\u001a\u00020\u001f\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u001f2\u0006\u0010\u0019\u001a\u00020\u0003H\b\u001aG\u0010(\u001a\u00020\u001f\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u001f2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00020#2#\u0010\u0013\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00020%\u0012\u0004\u0012\u00020\u00150\u0007¢\u0006\u0002\b\u0016¨\u0006)"}, d2 = {"gsonTypeToken", "Ljava/lang/reflect/Type;", "T", "", "instanceCreator", "Lcom/google/gson/InstanceCreator;", "creator", "Lkotlin/Function1;", "jsonDeserializer", "Lcom/google/gson/JsonDeserializer;", "deserializer", "Lcom/github/salomonbrys/kotson/DeserializerArg;", "jsonSerializer", "Lcom/google/gson/JsonSerializer;", "serializer", "Lcom/github/salomonbrys/kotson/SerializerArg;", "Lcom/google/gson/JsonElement;", "nullableTypeAdapter", "Lcom/google/gson/TypeAdapter;", "init", "Lcom/github/salomonbrys/kotson/TypeAdapterBuilder;", "", "Lkotlin/ExtensionFunctionType;", "removeTypeWildcards", "type", "typeAdapter", "typeToken", "isWildcard", "", "Ljava/lang/reflect/ParameterizedType;", "registerNullableTypeAdapter", "Lcom/google/gson/GsonBuilder;", "registerNullableTypeAdapterBuilder", "registerNullableTypeHierarchyAdapter", "registerNullableTypeHierarchyAdapterBuilder", "Ljava/lang/Class;", "registerTypeAdapter", "Lcom/github/salomonbrys/kotson/RegistrationBuilder;", "registerTypeAdapterBuilder", "registerTypeHierarchyAdapter", "registerTypeHierarchyAdapterBuilder", "kotson_main"}, k = 2, mv = {1, 1, 1})
/* compiled from: GsonBuilder.kt */
public final class GsonBuilderKt {
    private static final <T> Type gsonTypeToken() {
        Intrinsics.needClassReification();
        Type type = new GsonBuilderKt$gsonTypeToken$1().getType();
        Intrinsics.checkExpressionValueIsNotNull(type, "object : TypeToken<T>() {} .type");
        return type;
    }

    public static final boolean isWildcard(ParameterizedType parameterizedType) {
        Type type;
        Intrinsics.checkParameterIsNotNull(parameterizedType, "$receiver");
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = false;
        Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
        booleanRef2.element = false;
        Ref.BooleanRef booleanRef3 = new Ref.BooleanRef();
        booleanRef3.element = false;
        Type rawType = parameterizedType.getRawType();
        if (rawType != null) {
            TypeVariable[] typeParameters = ((Class) rawType).getTypeParameters();
            int i = 0;
            int i2 = 0;
            while (i < typeParameters.length) {
                int i3 = i2 + 1;
                TypeVariable typeVariable = typeParameters[i];
                Type type2 = parameterizedType.getActualTypeArguments()[i2];
                if (type2 instanceof WildcardType) {
                    Type[] bounds = typeVariable.getBounds();
                    int i4 = 0;
                    while (true) {
                        if (i4 >= bounds.length) {
                            type = null;
                            break;
                        }
                        type = bounds[i4];
                        if (ArraysKt.contains(((WildcardType) type2).getUpperBounds(), type)) {
                            break;
                        }
                        i4++;
                    }
                    Type type3 = type;
                    if (type3 == null) {
                        booleanRef3.element = true;
                    } else if (Intrinsics.areEqual(type3, Object.class)) {
                        booleanRef.element = true;
                    } else {
                        booleanRef2.element = true;
                    }
                } else {
                    booleanRef3.element = true;
                }
                i++;
                i2 = i3;
            }
            if (booleanRef.element && booleanRef3.element) {
                throw new IllegalArgumentException("Either none or all type parameters can be wildcard in " + parameterizedType);
            } else if (booleanRef.element || (booleanRef2.element && !booleanRef3.element)) {
                return true;
            } else {
                return false;
            }
        } else {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<*>");
        }
    }

    public static final Type removeTypeWildcards(Type type) {
        Intrinsics.checkParameterIsNotNull(type, "type");
        if (!(type instanceof ParameterizedType)) {
            return type;
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        ArrayList arrayList = new ArrayList(actualTypeArguments.length);
        for (Type type2 : actualTypeArguments) {
            if (type2 instanceof WildcardType) {
                type2 = ((WildcardType) type2).getUpperBounds()[0];
            }
            arrayList.add(type2);
        }
        ArrayList<Type> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (Type type3 : arrayList2) {
            Intrinsics.checkExpressionValueIsNotNull(type3, "it");
            arrayList3.add(removeTypeWildcards(type3));
        }
        ArrayList arrayList4 = arrayList3;
        Object[] array = arrayList4.toArray(new Type[arrayList4.size()]);
        if (array != null) {
            Type[] typeArr = (Type[]) array;
            Type type4 = TypeToken.getParameterized(parameterizedType.getRawType(), (Type[]) Arrays.copyOf(typeArr, typeArr.length)).getType();
            Intrinsics.checkExpressionValueIsNotNull(type4, "TypeToken.getParameteriz…rawType, *arguments).type");
            return type4;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public static final <T> JsonSerializer<T> jsonSerializer(Function1<? super SerializerArg<T>, ? extends JsonElement> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "serializer");
        return new GsonBuilderKt$jsonSerializer$1(function1);
    }

    public static final <T> JsonDeserializer<T> jsonDeserializer(Function1<? super DeserializerArg, ? extends T> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "deserializer");
        return new GsonBuilderKt$jsonDeserializer$1(function1);
    }

    public static final <T> InstanceCreator<T> instanceCreator(Function1<? super Type, ? extends T> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "creator");
        return new GsonBuilderKt$instanceCreator$1(function1);
    }

    public static final <T> TypeAdapter<T> typeAdapter(Function1<? super TypeAdapterBuilder<T, T>, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "init");
        return new TypeAdapterBuilderImpl(function1).build();
    }

    public static final <T> TypeAdapter<T> nullableTypeAdapter(Function1<? super TypeAdapterBuilder<T, T>, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "init");
        TypeAdapter<T> nullSafe = new TypeAdapterBuilderImpl(function1).build().nullSafe();
        Intrinsics.checkExpressionValueIsNotNull(nullSafe, "TypeAdapterBuilderImpl<T…(init).build().nullSafe()");
        return nullSafe;
    }

    private static final <T> GsonBuilder registerTypeAdapter(GsonBuilder gsonBuilder, JsonSerializer<T> jsonSerializer) {
        Type type;
        if (jsonSerializer != null) {
            JsonSerializer<T> jsonSerializer2 = jsonSerializer;
            Intrinsics.needClassReification();
            Type type2 = new GsonBuilderKt$registerTypeAdapter$$inlined$registerTypeAdapter$1().getType();
            Intrinsics.checkExpressionValueIsNotNull(type2, "object : TypeToken<T>() {} .type");
            if (type2 instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type2;
                if (isWildcard(parameterizedType)) {
                    type = parameterizedType.getRawType();
                    Intrinsics.checkExpressionValueIsNotNull(type, "type.rawType");
                    GsonBuilder registerTypeAdapter = gsonBuilder.registerTypeAdapter(type, jsonSerializer2);
                    Intrinsics.checkExpressionValueIsNotNull(registerTypeAdapter, "this.registerTypeAdapter…eToken<T>(), typeAdapter)");
                    return registerTypeAdapter;
                }
            }
            type = removeTypeWildcards(type2);
            GsonBuilder registerTypeAdapter = gsonBuilder.registerTypeAdapter(type, jsonSerializer2);
            Intrinsics.checkExpressionValueIsNotNull(registerTypeAdapter, "this.registerTypeAdapter…eToken<T>(), typeAdapter)");
            return registerTypeAdapter;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Any");
    }

    private static final <T> GsonBuilder registerTypeAdapter(GsonBuilder gsonBuilder, JsonDeserializer<T> jsonDeserializer) {
        Type type;
        if (jsonDeserializer != null) {
            JsonDeserializer<T> jsonDeserializer2 = jsonDeserializer;
            Intrinsics.needClassReification();
            Type type2 = new GsonBuilderKt$registerTypeAdapter$$inlined$registerTypeAdapter$2().getType();
            Intrinsics.checkExpressionValueIsNotNull(type2, "object : TypeToken<T>() {} .type");
            if (type2 instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type2;
                if (isWildcard(parameterizedType)) {
                    type = parameterizedType.getRawType();
                    Intrinsics.checkExpressionValueIsNotNull(type, "type.rawType");
                    GsonBuilder registerTypeAdapter = gsonBuilder.registerTypeAdapter(type, jsonDeserializer2);
                    Intrinsics.checkExpressionValueIsNotNull(registerTypeAdapter, "this.registerTypeAdapter…eToken<T>(), typeAdapter)");
                    return registerTypeAdapter;
                }
            }
            type = removeTypeWildcards(type2);
            GsonBuilder registerTypeAdapter = gsonBuilder.registerTypeAdapter(type, jsonDeserializer2);
            Intrinsics.checkExpressionValueIsNotNull(registerTypeAdapter, "this.registerTypeAdapter…eToken<T>(), typeAdapter)");
            return registerTypeAdapter;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Any");
    }

    private static final <T> GsonBuilder registerTypeHierarchyAdapter(GsonBuilder gsonBuilder, Object obj) {
        Intrinsics.reifiedOperationMarker(4, "T");
        GsonBuilder registerTypeHierarchyAdapter = gsonBuilder.registerTypeHierarchyAdapter(Object.class, obj);
        Intrinsics.checkExpressionValueIsNotNull(registerTypeHierarchyAdapter, "this.registerTypeHierarc…:class.java, typeAdapter)");
        return registerTypeHierarchyAdapter;
    }

    public static final <T> GsonBuilder registerTypeAdapterBuilder(GsonBuilder gsonBuilder, Type type, Function1<? super RegistrationBuilder<T, T>, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(gsonBuilder, "$receiver");
        Intrinsics.checkParameterIsNotNull(type, "type");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        new RegistrationBuilderImpl(type, function1, new GsonBuilderKt$registerTypeAdapterBuilder$1(gsonBuilder, type));
        return gsonBuilder;
    }

    public static final <T> GsonBuilder registerNullableTypeAdapterBuilder(GsonBuilder gsonBuilder, Type type, Function1<? super TypeAdapterBuilder<T, T>, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(gsonBuilder, "$receiver");
        Intrinsics.checkParameterIsNotNull(type, "type");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        gsonBuilder.registerTypeAdapter(type, nullableTypeAdapter(function1));
        return gsonBuilder;
    }

    public static final <T> GsonBuilder registerTypeHierarchyAdapterBuilder(GsonBuilder gsonBuilder, Class<T> cls, Function1<? super RegistrationBuilder<T, T>, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(gsonBuilder, "$receiver");
        Intrinsics.checkParameterIsNotNull(cls, "type");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        new RegistrationBuilderImpl(cls, function1, new GsonBuilderKt$registerTypeHierarchyAdapterBuilder$1(gsonBuilder, cls));
        return gsonBuilder;
    }

    private static final <T> GsonBuilder registerTypeHierarchyAdapter(GsonBuilder gsonBuilder, Function1<? super RegistrationBuilder<T, T>, Unit> function1) {
        Intrinsics.reifiedOperationMarker(4, "T");
        return registerTypeHierarchyAdapterBuilder(gsonBuilder, Object.class, function1);
    }

    public static final <T> GsonBuilder registerNullableTypeHierarchyAdapterBuilder(GsonBuilder gsonBuilder, Class<T> cls, Function1<? super TypeAdapterBuilder<T, T>, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(gsonBuilder, "$receiver");
        Intrinsics.checkParameterIsNotNull(cls, "type");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        gsonBuilder.registerTypeHierarchyAdapter(cls, nullableTypeAdapter(function1));
        return gsonBuilder;
    }

    private static final <T> GsonBuilder registerNullableTypeHierarchyAdapter(GsonBuilder gsonBuilder, Function1<? super TypeAdapterBuilder<T, T>, Unit> function1) {
        Intrinsics.reifiedOperationMarker(4, "T");
        return registerNullableTypeHierarchyAdapterBuilder(gsonBuilder, Object.class, function1);
    }

    private static final <T> Type typeToken() {
        Intrinsics.needClassReification();
        Type type = new GsonBuilderKt$typeToken$$inlined$gsonTypeToken$1().getType();
        Intrinsics.checkExpressionValueIsNotNull(type, "object : TypeToken<T>() {} .type");
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            if (isWildcard(parameterizedType)) {
                Type rawType = parameterizedType.getRawType();
                Intrinsics.checkExpressionValueIsNotNull(rawType, "type.rawType");
                return rawType;
            }
        }
        return removeTypeWildcards(type);
    }

    private static final <T> GsonBuilder registerTypeAdapter(GsonBuilder gsonBuilder, Object obj) {
        Type type;
        Intrinsics.needClassReification();
        Type type2 = new GsonBuilderKt$registerTypeAdapter$$inlined$typeToken$1().getType();
        Intrinsics.checkExpressionValueIsNotNull(type2, "object : TypeToken<T>() {} .type");
        if (type2 instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type2;
            if (isWildcard(parameterizedType)) {
                type = parameterizedType.getRawType();
                Intrinsics.checkExpressionValueIsNotNull(type, "type.rawType");
                GsonBuilder registerTypeAdapter = gsonBuilder.registerTypeAdapter(type, obj);
                Intrinsics.checkExpressionValueIsNotNull(registerTypeAdapter, "this.registerTypeAdapter…eToken<T>(), typeAdapter)");
                return registerTypeAdapter;
            }
        }
        type = removeTypeWildcards(type2);
        GsonBuilder registerTypeAdapter = gsonBuilder.registerTypeAdapter(type, obj);
        Intrinsics.checkExpressionValueIsNotNull(registerTypeAdapter, "this.registerTypeAdapter…eToken<T>(), typeAdapter)");
        return registerTypeAdapter;
    }

    private static final <T> GsonBuilder registerTypeAdapter(GsonBuilder gsonBuilder, Function1<? super RegistrationBuilder<T, T>, Unit> function1) {
        Type type;
        Intrinsics.needClassReification();
        Type type2 = new GsonBuilderKt$registerTypeAdapter$$inlined$typeToken$4().getType();
        Intrinsics.checkExpressionValueIsNotNull(type2, "object : TypeToken<T>() {} .type");
        if (type2 instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type2;
            if (isWildcard(parameterizedType)) {
                type = parameterizedType.getRawType();
                Intrinsics.checkExpressionValueIsNotNull(type, "type.rawType");
                return registerTypeAdapterBuilder(gsonBuilder, type, function1);
            }
        }
        type = removeTypeWildcards(type2);
        return registerTypeAdapterBuilder(gsonBuilder, type, function1);
    }

    private static final <T> GsonBuilder registerNullableTypeAdapter(GsonBuilder gsonBuilder, Function1<? super TypeAdapterBuilder<T, T>, Unit> function1) {
        Type type;
        Intrinsics.needClassReification();
        Type type2 = new GsonBuilderKt$registerNullableTypeAdapter$$inlined$typeToken$1().getType();
        Intrinsics.checkExpressionValueIsNotNull(type2, "object : TypeToken<T>() {} .type");
        if (type2 instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type2;
            if (isWildcard(parameterizedType)) {
                type = parameterizedType.getRawType();
                Intrinsics.checkExpressionValueIsNotNull(type, "type.rawType");
                return registerNullableTypeAdapterBuilder(gsonBuilder, type, function1);
            }
        }
        type = removeTypeWildcards(type2);
        return registerNullableTypeAdapterBuilder(gsonBuilder, type, function1);
    }
}
