package com.coolapk.market.view.base.asynclist;

import androidx.databinding.ObservableList;
import com.coolapk.market.widget.AdapterListChangedCallback;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lcom/coolapk/market/widget/AdapterListChangedCallback;", "Landroidx/databinding/ObservableList;", "DATA", "Landroid/os/Parcelable;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: ShortAsyncListFragment.kt */
final class ShortAsyncListFragment$onListChangeCallback$2 extends Lambda implements Function0<AdapterListChangedCallback<ObservableList<DATA>>> {
    final /* synthetic */ ShortAsyncListFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ShortAsyncListFragment$onListChangeCallback$2(ShortAsyncListFragment shortAsyncListFragment) {
        super(0);
        this.this$0 = shortAsyncListFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public final AdapterListChangedCallback<ObservableList<DATA>> invoke() {
        return new AdapterListChangedCallback<>(this.this$0.getAdapter());
    }
}
