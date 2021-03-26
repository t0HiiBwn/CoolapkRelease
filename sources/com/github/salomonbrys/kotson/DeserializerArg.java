package com.github.salomonbrys.kotson;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 0}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001:\u0001\u0013B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/github/salomonbrys/kotson/DeserializerArg;", "", "json", "Lcom/google/gson/JsonElement;", "type", "Ljava/lang/reflect/Type;", "context", "Lcom/github/salomonbrys/kotson/DeserializerArg$Context;", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/github/salomonbrys/kotson/DeserializerArg$Context;)V", "getContext", "()Lcom/github/salomonbrys/kotson/DeserializerArg$Context;", "getJson", "()Lcom/google/gson/JsonElement;", "getType", "()Ljava/lang/reflect/Type;", "component1", "component2", "component3", "copy", "Context", "kotson_main"}, k = 1, mv = {1, 1, 1})
/* compiled from: GsonBuilder.kt */
public final class DeserializerArg {
    private final Context context;
    private final JsonElement json;
    private final Type type;

    public static /* bridge */ /* synthetic */ DeserializerArg copy$default(DeserializerArg deserializerArg, JsonElement jsonElement, Type type2, Context context2, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                jsonElement = deserializerArg.json;
            }
            if ((i & 2) != 0) {
                type2 = deserializerArg.type;
            }
            if ((i & 4) != 0) {
                context2 = deserializerArg.context;
            }
            return deserializerArg.copy(jsonElement, type2, context2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copy");
    }

    public final JsonElement component1() {
        return this.json;
    }

    public final Type component2() {
        return this.type;
    }

    public final Context component3() {
        return this.context;
    }

    public final DeserializerArg copy(JsonElement jsonElement, Type type2, Context context2) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "json");
        Intrinsics.checkParameterIsNotNull(type2, "type");
        Intrinsics.checkParameterIsNotNull(context2, "context");
        return new DeserializerArg(jsonElement, type2, context2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeserializerArg)) {
            return false;
        }
        DeserializerArg deserializerArg = (DeserializerArg) obj;
        return Intrinsics.areEqual(this.json, deserializerArg.json) && Intrinsics.areEqual(this.type, deserializerArg.type) && Intrinsics.areEqual(this.context, deserializerArg.context);
    }

    public int hashCode() {
        JsonElement jsonElement = this.json;
        int i = 0;
        int hashCode = (jsonElement != null ? jsonElement.hashCode() : 0) * 31;
        Type type2 = this.type;
        int hashCode2 = (hashCode + (type2 != null ? type2.hashCode() : 0)) * 31;
        Context context2 = this.context;
        if (context2 != null) {
            i = context2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "DeserializerArg(json=" + this.json + ", type=" + this.type + ", context=" + this.context + ")";
    }

    public DeserializerArg(JsonElement jsonElement, Type type2, Context context2) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "json");
        Intrinsics.checkParameterIsNotNull(type2, "type");
        Intrinsics.checkParameterIsNotNull(context2, "context");
        this.json = jsonElement;
        this.type = type2;
        this.context = context2;
    }

    public final JsonElement getJson() {
        return this.json;
    }

    public final Type getType() {
        return this.type;
    }

    public final Context getContext() {
        return this.context;
    }

    @Metadata(bv = {1, 0, 0}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J*\u0010\u0006\u001a\n \b*\u0004\u0018\u0001H\u0007H\u0007\"\n\b\u0000\u0010\u0007\u0018\u0001*\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\b¢\u0006\u0002\u0010\fJH\u0010\u0006\u001a\n \b*\u0004\u0018\u0001H\u0007H\u0007\"\u0010\b\u0000\u0010\u0007*\n \b*\u0004\u0018\u00010\t0\t2\u000e\u0010\r\u001a\n \b*\u0004\u0018\u00010\u000b0\u000b2\u000e\u0010\u000e\u001a\n \b*\u0004\u0018\u00010\u000f0\u000fH\u0001¢\u0006\u0002\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0011"}, d2 = {"Lcom/github/salomonbrys/kotson/DeserializerArg$Context;", "Lcom/google/gson/JsonDeserializationContext;", "gsonContext", "(Lcom/google/gson/JsonDeserializationContext;)V", "getGsonContext", "()Lcom/google/gson/JsonDeserializationContext;", "deserialize", "T", "kotlin.jvm.PlatformType", "", "json", "Lcom/google/gson/JsonElement;", "(Lcom/google/gson/JsonElement;)Ljava/lang/Object;", "p0", "p1", "Ljava/lang/reflect/Type;", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;)Ljava/lang/Object;", "kotson_main"}, k = 1, mv = {1, 1, 1})
    /* compiled from: GsonBuilder.kt */
    public static final class Context implements JsonDeserializationContext {
        private final JsonDeserializationContext gsonContext;

        @Override // com.google.gson.JsonDeserializationContext
        public <T> T deserialize(JsonElement jsonElement, Type type) {
            return (T) this.gsonContext.deserialize(jsonElement, type);
        }

        public Context(JsonDeserializationContext jsonDeserializationContext) {
            Intrinsics.checkParameterIsNotNull(jsonDeserializationContext, "gsonContext");
            this.gsonContext = jsonDeserializationContext;
        }

        public final JsonDeserializationContext getGsonContext() {
            return this.gsonContext;
        }

        private final <T> T deserialize(JsonElement jsonElement) {
            Type type;
            JsonDeserializationContext gsonContext2 = getGsonContext();
            Intrinsics.needClassReification();
            Type type2 = new DeserializerArg$Context$deserialize$$inlined$typeToken$1().getType();
            Intrinsics.checkExpressionValueIsNotNull(type2, "object : TypeToken<T>() {} .type");
            if (type2 instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type2;
                if (GsonBuilderKt.isWildcard(parameterizedType)) {
                    type = parameterizedType.getRawType();
                    Intrinsics.checkExpressionValueIsNotNull(type, "type.rawType");
                    return (T) gsonContext2.deserialize(jsonElement, type);
                }
            }
            type = GsonBuilderKt.removeTypeWildcards(type2);
            return (T) gsonContext2.deserialize(jsonElement, type);
        }
    }
}
