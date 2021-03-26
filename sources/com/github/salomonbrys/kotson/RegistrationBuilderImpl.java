package com.github.salomonbrys.kotson;

import com.google.gson.JsonElement;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 0}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001&BF\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012#\u0010\u0006\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\b\t\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\rH\u0002J\b\u0010\u0019\u001a\u00020\bH\u0002J\u001c\u0010\u001a\u001a\u00020\b2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u0007H\u0016J\u001e\u0010\u001c\u001a\u00020\b2\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0007H\u0016J!\u0010\u001f\u001a\u00020\b2\u0017\u0010 \u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0002\b\tH\u0016J\"\u0010!\u001a\u00020\b2\u0018\u0010\"\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000#\u0012\u0004\u0012\u00020$0\u0007H\u0016J'\u0010%\u001a\u00020\b2\u001d\u0010 \u001a\u0019\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u0011¢\u0006\u0002\b\tH\u0016R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R!\u0010\u000e\u001a\u0015\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007¢\u0006\u0002\b\tX\u000e¢\u0006\u0002\n\u0000R'\u0010\u0010\u001a\u001b\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b\u0018\u00010\u0011¢\u0006\u0002\b\tX\u000e¢\u0006\u0002\n\u0000R \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006'"}, d2 = {"Lcom/github/salomonbrys/kotson/RegistrationBuilderImpl;", "T", "", "Lcom/github/salomonbrys/kotson/RegistrationBuilder;", "registeredType", "Ljava/lang/reflect/Type;", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "register", "(Ljava/lang/reflect/Type;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "_api", "Lcom/github/salomonbrys/kotson/RegistrationBuilderImpl$_API;", "_readFunction", "Lcom/google/gson/stream/JsonReader;", "_writeFunction", "Lkotlin/Function2;", "Lcom/google/gson/stream/JsonWriter;", "getRegister", "()Lkotlin/jvm/functions/Function1;", "getRegisteredType", "()Ljava/lang/reflect/Type;", "_checkApi", "api", "_registerTypeAdapter", "createInstances", "creator", "deserialize", "deserializer", "Lcom/github/salomonbrys/kotson/DeserializerArg;", "read", "function", "serialize", "serializer", "Lcom/github/salomonbrys/kotson/SerializerArg;", "Lcom/google/gson/JsonElement;", "write", "_API", "kotson_main"}, k = 1, mv = {1, 1, 1})
/* compiled from: GsonBuilder.kt */
public final class RegistrationBuilderImpl<T> implements RegistrationBuilder<T, T> {
    private _API _api;
    private Function1<? super JsonReader, ? extends T> _readFunction;
    private Function2<? super JsonWriter, ? super T, Unit> _writeFunction;
    private final Function1<Object, Unit> register;
    private final Type registeredType;

    @Metadata(bv = {1, 0, 0}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/github/salomonbrys/kotson/RegistrationBuilderImpl$_API;", "", "(Ljava/lang/String;I)V", "SD", "RW", "kotson_main"}, k = 1, mv = {1, 1, 1})
    /* compiled from: GsonBuilder.kt */
    protected enum _API {
        SD,
        RW
    }

    public RegistrationBuilderImpl(Type type, Function1<? super RegistrationBuilder<T, T>, Unit> function1, Function1<Object, Unit> function12) {
        Intrinsics.checkParameterIsNotNull(type, "registeredType");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Intrinsics.checkParameterIsNotNull(function12, "register");
        this.registeredType = type;
        this.register = function12;
        function1.invoke(this);
        if (this._readFunction != null) {
            throw new IllegalArgumentException("You cannot define a read function without a write function");
        } else if (this._writeFunction != null) {
            throw new IllegalArgumentException("You cannot define a write function without a read function");
        }
    }

    public final Type getRegisteredType() {
        return this.registeredType;
    }

    protected final Function1<Object, Unit> getRegister() {
        return this.register;
    }

    private final void _checkApi(_API _api2) {
        _API _api3 = this._api;
        if (_api3 == null || !(!Intrinsics.areEqual(_api3, _api2))) {
            this._api = _api2;
            return;
        }
        throw new IllegalArgumentException("You cannot use serialize/deserialize and read/write for the same type");
    }

    @Override // com.github.salomonbrys.kotson.RegistrationBuilder
    public void serialize(Function1<? super SerializerArg<T>, ? extends JsonElement> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "serializer");
        _checkApi(_API.SD);
        this.register.invoke(GsonBuilderKt.jsonSerializer(function1));
    }

    @Override // com.github.salomonbrys.kotson.RegistrationBuilder
    public void deserialize(Function1<? super DeserializerArg, ? extends T> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "deserializer");
        _checkApi(_API.SD);
        this.register.invoke(GsonBuilderKt.jsonDeserializer(function1));
    }

    @Override // com.github.salomonbrys.kotson.RegistrationBuilder
    public void createInstances(Function1<? super Type, ? extends T> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "creator");
        this.register.invoke(GsonBuilderKt.instanceCreator(function1));
    }

    private final void _registerTypeAdapter() {
        _checkApi(_API.RW);
        Function1<? super JsonReader, ? extends T> function1 = this._readFunction;
        Function2<? super JsonWriter, ? super T, Unit> function2 = this._writeFunction;
        if (function1 != null && function2 != null) {
            this.register.invoke(GsonBuilderKt.typeAdapter(new RegistrationBuilderImpl$_registerTypeAdapter$1(function1, function2)));
            this._readFunction = null;
            this._writeFunction = null;
        }
    }

    @Override // com.github.salomonbrys.kotson.TypeAdapterBuilder
    public void read(Function1<? super JsonReader, ? extends T> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "function");
        this._readFunction = function1;
        _registerTypeAdapter();
    }

    @Override // com.github.salomonbrys.kotson.TypeAdapterBuilder
    public void write(Function2<? super JsonWriter, ? super T, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(function2, "function");
        this._writeFunction = function2;
        _registerTypeAdapter();
    }
}
