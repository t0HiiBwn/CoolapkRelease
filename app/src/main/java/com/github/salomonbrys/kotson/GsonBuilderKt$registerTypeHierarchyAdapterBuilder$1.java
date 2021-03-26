package com.github.salomonbrys.kotson;

import com.google.gson.GsonBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 0}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "", "it", "invoke"}, k = 3, mv = {1, 1, 1})
/* compiled from: GsonBuilder.kt */
final class GsonBuilderKt$registerTypeHierarchyAdapterBuilder$1 extends Lambda implements Function1<Object, Unit> {
    final /* synthetic */ Class $type;
    final /* synthetic */ GsonBuilder receiver$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GsonBuilderKt$registerTypeHierarchyAdapterBuilder$1(GsonBuilder gsonBuilder, Class cls) {
        super(1);
        this.receiver$0 = gsonBuilder;
        this.$type = cls;
    }

    @Override // kotlin.jvm.functions.Function1
    public final void invoke(Object obj) {
        Intrinsics.checkParameterIsNotNull(obj, "it");
        this.receiver$0.registerTypeHierarchyAdapter(this.$type, obj);
    }
}
