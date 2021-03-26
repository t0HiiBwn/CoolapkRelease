package com.github.salomonbrys.kotson;

import com.google.gson.InstanceCreator;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 0}, d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\u000e\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "T", "", "it", "Ljava/lang/reflect/Type;", "kotlin.jvm.PlatformType", "createInstance", "(Ljava/lang/reflect/Type;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 1})
/* compiled from: GsonBuilder.kt */
final class GsonBuilderKt$instanceCreator$1<T> implements InstanceCreator<T> {
    final /* synthetic */ Function1 $creator;

    GsonBuilderKt$instanceCreator$1(Function1 function1) {
        this.$creator = function1;
    }

    @Override // com.google.gson.InstanceCreator
    public final T createInstance(Type type) {
        Function1 function1 = this.$creator;
        Intrinsics.checkExpressionValueIsNotNull(type, "it");
        return (T) function1.invoke(type);
    }
}
