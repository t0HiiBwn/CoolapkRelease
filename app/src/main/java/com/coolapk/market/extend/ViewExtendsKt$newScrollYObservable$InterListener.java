package com.coolapk.market.extend;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.Emitter;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"com/coolapk/market/extend/ViewExtendsKt$newScrollYObservable$InterListener", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "subscriber", "Lrx/Emitter;", "", "(Lrx/Emitter;)V", "getSubscriber", "()Lrx/Emitter;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "dy", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ViewExtends.kt */
public final class ViewExtendsKt$newScrollYObservable$InterListener extends RecyclerView.OnScrollListener {
    private final Emitter<Integer> subscriber;

    public ViewExtendsKt$newScrollYObservable$InterListener(Emitter<Integer> emitter) {
        Intrinsics.checkNotNullParameter(emitter, "subscriber");
        this.subscriber = emitter;
    }

    public final Emitter<Integer> getSubscriber() {
        return this.subscriber;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        this.subscriber.onNext(Integer.valueOf(i2));
    }
}
