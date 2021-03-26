package com.coolapk.market.extend;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import rx.Emitter;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "subscriber", "Lrx/Emitter;", "", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: ViewExtends.kt */
final class ViewExtendsKt$newScrollYObservable$1<T> implements Action1<Emitter<Integer>> {
    final /* synthetic */ Ref.ObjectRef $listener;
    final /* synthetic */ RecyclerView $this_newScrollYObservable;

    ViewExtendsKt$newScrollYObservable$1(RecyclerView recyclerView, Ref.ObjectRef objectRef) {
        this.$this_newScrollYObservable = recyclerView;
        this.$listener = objectRef;
    }

    public final void call(Emitter<Integer> emitter) {
        Ref.ObjectRef objectRef = this.$listener;
        Intrinsics.checkNotNullExpressionValue(emitter, "subscriber");
        objectRef.element = (T) new ViewExtendsKt$newScrollYObservable$InterListener(emitter);
        RecyclerView recyclerView = this.$this_newScrollYObservable;
        T t = this.$listener.element;
        Intrinsics.checkNotNull(t);
        recyclerView.addOnScrollListener(t);
    }
}
