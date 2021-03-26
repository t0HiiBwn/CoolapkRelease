package com.coolapk.market.view.cardlist.divider;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J \u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/coolapk/market/view/cardlist/divider/SimpleAdapterDataObserver;", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "onAnyChanged", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "invokeOnChanged", "onChanged", "onItemRangeChanged", "positionStart", "", "itemCount", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SimpleAdapterDataObserver.kt */
public final class SimpleAdapterDataObserver extends RecyclerView.AdapterDataObserver {
    private final Function0<Unit> onAnyChanged;

    public SimpleAdapterDataObserver(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "onAnyChanged");
        this.onAnyChanged = function0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public void onChanged() {
        invokeOnChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public void onItemRangeChanged(int i, int i2) {
        invokeOnChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public void onItemRangeInserted(int i, int i2) {
        invokeOnChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public void onItemRangeRemoved(int i, int i2) {
        invokeOnChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public void onItemRangeMoved(int i, int i2, int i3) {
        invokeOnChanged();
    }

    private final void invokeOnChanged() {
        this.onAnyChanged.invoke();
    }
}
