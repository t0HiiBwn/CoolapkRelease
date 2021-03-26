package com.github.salomonbrys.kotson;

import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 0}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0015B\u001d\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u0010\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J2\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/github/salomonbrys/kotson/SerializerArg;", "T", "", "src", "type", "Ljava/lang/reflect/Type;", "context", "Lcom/github/salomonbrys/kotson/SerializerArg$Context;", "(Ljava/lang/Object;Ljava/lang/reflect/Type;Lcom/github/salomonbrys/kotson/SerializerArg$Context;)V", "getContext", "()Lcom/github/salomonbrys/kotson/SerializerArg$Context;", "getSrc", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getType", "()Ljava/lang/reflect/Type;", "component1", "component2", "component3", "copy", "(Ljava/lang/Object;Ljava/lang/reflect/Type;Lcom/github/salomonbrys/kotson/SerializerArg$Context;)Lcom/github/salomonbrys/kotson/SerializerArg;", "Context", "kotson_main"}, k = 1, mv = {1, 1, 1})
/* compiled from: GsonBuilder.kt */
public final class SerializerArg<T> {
    private final Context context;
    private final T src;
    private final Type type;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.github.salomonbrys.kotson.SerializerArg */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* bridge */ /* synthetic */ SerializerArg copy$default(SerializerArg serializerArg, Object obj, Type type2, Context context2, int i, Object obj2) {
        if (obj2 == null) {
            if ((i & 1) != 0) {
                obj = serializerArg.src;
            }
            if ((i & 2) != 0) {
                type2 = serializerArg.type;
            }
            if ((i & 4) != 0) {
                context2 = serializerArg.context;
            }
            return serializerArg.copy(obj, type2, context2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copy");
    }

    public final T component1() {
        return this.src;
    }

    public final Type component2() {
        return this.type;
    }

    public final Context component3() {
        return this.context;
    }

    public final SerializerArg<T> copy(T t, Type type2, Context context2) {
        Intrinsics.checkParameterIsNotNull(type2, "type");
        Intrinsics.checkParameterIsNotNull(context2, "context");
        return new SerializerArg<>(t, type2, context2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SerializerArg)) {
            return false;
        }
        SerializerArg serializerArg = (SerializerArg) obj;
        return Intrinsics.areEqual(this.src, serializerArg.src) && Intrinsics.areEqual(this.type, serializerArg.type) && Intrinsics.areEqual(this.context, serializerArg.context);
    }

    public int hashCode() {
        T t = this.src;
        int i = 0;
        int hashCode = (t != null ? t.hashCode() : 0) * 31;
        Type type2 = this.type;
        int hashCode2 = (hashCode + (type2 != null ? type2.hashCode() : 0)) * 31;
        Context context2 = this.context;
        if (context2 != null) {
            i = context2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "SerializerArg(src=" + ((Object) this.src) + ", type=" + this.type + ", context=" + this.context + ")";
    }

    public SerializerArg(T t, Type type2, Context context2) {
        Intrinsics.checkParameterIsNotNull(type2, "type");
        Intrinsics.checkParameterIsNotNull(context2, "context");
        this.src = t;
        this.type = type2;
        this.context = context2;
    }

    public final T getSrc() {
        return this.src;
    }

    public final Type getType() {
        return this.type;
    }

    public final Context getContext() {
        return this.context;
    }

    @Metadata(bv = {1, 0, 0}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J!\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u00072\u000e\u0010\t\u001a\n \b*\u0004\u0018\u00010\n0\nH\u0001J1\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u00072\u000e\u0010\t\u001a\n \b*\u0004\u0018\u00010\n0\n2\u000e\u0010\u000b\u001a\n \b*\u0004\u0018\u00010\f0\fH\u0001J*\u0010\r\u001a\n \b*\u0004\u0018\u00010\u00070\u0007\"\n\b\u0001\u0010\u000e\u0018\u0001*\u00020\n2\u0006\u0010\u000f\u001a\u0002H\u000eH\b¢\u0006\u0002\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0011"}, d2 = {"Lcom/github/salomonbrys/kotson/SerializerArg$Context;", "Lcom/google/gson/JsonSerializationContext;", "gsonContext", "(Lcom/google/gson/JsonSerializationContext;)V", "getGsonContext", "()Lcom/google/gson/JsonSerializationContext;", "serialize", "Lcom/google/gson/JsonElement;", "kotlin.jvm.PlatformType", "p0", "", "p1", "Ljava/lang/reflect/Type;", "typedSerialize", "T", "src", "(Ljava/lang/Object;)Lcom/google/gson/JsonElement;", "kotson_main"}, k = 1, mv = {1, 1, 1})
    /* compiled from: GsonBuilder.kt */
    public static final class Context implements JsonSerializationContext {
        private final JsonSerializationContext gsonContext;

        @Override // com.google.gson.JsonSerializationContext
        public JsonElement serialize(Object obj) {
            return this.gsonContext.serialize(obj);
        }

        @Override // com.google.gson.JsonSerializationContext
        public JsonElement serialize(Object obj, Type type) {
            return this.gsonContext.serialize(obj, type);
        }

        public Context(JsonSerializationContext jsonSerializationContext) {
            Intrinsics.checkParameterIsNotNull(jsonSerializationContext, "gsonContext");
            this.gsonContext = jsonSerializationContext;
        }

        public final JsonSerializationContext getGsonContext() {
            return this.gsonContext;
        }

        private final <T> JsonElement typedSerialize(T t) {
            Type type;
            JsonSerializationContext gsonContext2 = getGsonContext();
            Intrinsics.needClassReification();
            Type type2 = new SerializerArg$Context$typedSerialize$$inlined$typeToken$1().getType();
            Intrinsics.checkExpressionValueIsNotNull(type2, "object : TypeToken<T>() {} .type");
            if (type2 instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type2;
                if (GsonBuilderKt.isWildcard(parameterizedType)) {
                    type = parameterizedType.getRawType();
                    Intrinsics.checkExpressionValueIsNotNull(type, "type.rawType");
                    return gsonContext2.serialize(t, type);
                }
            }
            type = GsonBuilderKt.removeTypeWildcards(type2);
            return gsonContext2.serialize(t, type);
        }
    }
}
