package com.github.salomonbrys.kotson;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 0}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "", "Lcom/github/salomonbrys/kotson/TypeAdapterBuilder;", "invoke"}, k = 3, mv = {1, 1, 1})
/* compiled from: GsonBuilder.kt */
final class RegistrationBuilderImpl$_registerTypeAdapter$1 extends Lambda implements Function1<TypeAdapterBuilder<T, T>, Unit> {
    final /* synthetic */ Function1 $readFunction;
    final /* synthetic */ Function2 $writeFunction;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RegistrationBuilderImpl$_registerTypeAdapter$1(Function1 function1, Function2 function2) {
        super(1);
        this.$readFunction = function1;
        this.$writeFunction = function2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
        invoke((TypeAdapterBuilder) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(TypeAdapterBuilder<T, T> typeAdapterBuilder) {
        Intrinsics.checkParameterIsNotNull(typeAdapterBuilder, "$receiver");
        typeAdapterBuilder.read(this.$readFunction);
        typeAdapterBuilder.write(this.$writeFunction);
    }
}
