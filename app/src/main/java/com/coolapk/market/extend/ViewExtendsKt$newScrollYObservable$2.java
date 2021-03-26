package com.coolapk.market.extend;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import rx.functions.Action0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: ViewExtends.kt */
final class ViewExtendsKt$newScrollYObservable$2 implements Action0 {
    final /* synthetic */ Ref.ObjectRef $listener;
    final /* synthetic */ RecyclerView $this_newScrollYObservable;

    ViewExtendsKt$newScrollYObservable$2(RecyclerView recyclerView, Ref.ObjectRef objectRef) {
        this.$this_newScrollYObservable = recyclerView;
        this.$listener = objectRef;
    }

    @Override // rx.functions.Action0
    public final void call() {
        RecyclerView recyclerView = this.$this_newScrollYObservable;
        T t = this.$listener.element;
        Intrinsics.checkNotNull(t);
        recyclerView.removeOnScrollListener(t);
    }
}
