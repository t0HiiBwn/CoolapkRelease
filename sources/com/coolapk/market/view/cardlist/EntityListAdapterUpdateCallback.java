package com.coolapk.market.view.cardlist;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ListUpdateCallback;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\bH\u0016J\u0018\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\bH\u0016J\u0018\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\bH\u0016J\u0010\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8BX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/coolapk/market/view/cardlist/EntityListAdapterUpdateCallback;", "Landroidx/recyclerview/widget/ListUpdateCallback;", "fragment", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "(Lcom/coolapk/market/view/cardlist/EntityListFragment;)V", "adapter", "Lcom/coolapk/market/widget/multitype/BaseMultiTypeAdapter;", "needUpdateCount", "", "getNeedUpdateCount", "()I", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "kotlin.jvm.PlatformType", "onChanged", "", "position", "count", "payload", "", "onInserted", "onMoved", "fromPosition", "toPosition", "onRemoved", "updateDivider", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: EntityListAdapterUpdateCallback.kt */
public final class EntityListAdapterUpdateCallback implements ListUpdateCallback {
    private final BaseMultiTypeAdapter adapter;
    private final RecyclerView recyclerView;

    public EntityListAdapterUpdateCallback(EntityListFragment entityListFragment) {
        Intrinsics.checkNotNullParameter(entityListFragment, "fragment");
        this.adapter = entityListFragment.getAdapter$presentation_coolapkAppRelease();
        this.recyclerView = entityListFragment.getRecyclerView();
    }

    private final int getNeedUpdateCount() {
        RecyclerView recyclerView2 = this.recyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "recyclerView");
        RecyclerView.LayoutManager layoutManager = recyclerView2.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            return ((GridLayoutManager) layoutManager).getSpanCount();
        }
        return layoutManager instanceof StaggeredGridLayoutManager ? 0 : 1;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onInserted(int i, int i2) {
        updateDivider(i);
        this.adapter.notifyItemRangeInserted(i, i2);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onRemoved(int i, int i2) {
        updateDivider(i);
        this.adapter.notifyItemRangeRemoved(i, i2);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onMoved(int i, int i2) {
        this.adapter.notifyItemMoved(i, i2);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onChanged(int i, int i2, Object obj) {
        this.adapter.notifyItemRangeChanged(i, i2, obj);
    }

    private final void updateDivider(int i) {
        for (int needUpdateCount = i - getNeedUpdateCount(); needUpdateCount < i; needUpdateCount++) {
            if (needUpdateCount >= 0) {
                this.adapter.notifyItemChanged(needUpdateCount);
            }
        }
    }
}
