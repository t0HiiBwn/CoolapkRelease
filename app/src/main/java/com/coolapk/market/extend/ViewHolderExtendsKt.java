package com.coolapk.market.extend;

import android.view.View;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.model.Entity;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"findParentEntity", "Lcom/coolapk/market/model/Entity;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "presentation_coolapkAppRelease"}, k = 2, mv = {1, 4, 2})
/* compiled from: ViewHolderExtends.kt */
public final class ViewHolderExtendsKt {
    public static final Entity findParentEntity(BindingViewHolder bindingViewHolder) {
        Intrinsics.checkNotNullParameter(bindingViewHolder, "$this$findParentEntity");
        View view = bindingViewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "this.itemView");
        Entity entity = null;
        if (!view.isAttachedToWindow()) {
            return null;
        }
        View view2 = bindingViewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(view2, "this.itemView");
        ViewParent parent = view2.getParent();
        if (!(parent instanceof RecyclerView)) {
            return null;
        }
        Sequence filter = SequencesKt.filter(SequencesKt.filter(SequencesKt.take(SequencesKt.asSequence(ViewExtents2Kt.iteratorParent((View) parent)), 5), ViewHolderExtendsKt$findParentEntity$parentItemView$1.INSTANCE), ViewHolderExtendsKt$findParentEntity$$inlined$filterIsInstance$1.INSTANCE);
        Objects.requireNonNull(filter, "null cannot be cast to non-null type kotlin.sequences.Sequence<R>");
        View view3 = (View) SequencesKt.firstOrNull(filter);
        if (view3 == null) {
            return null;
        }
        ViewParent parent2 = view3.getParent();
        Objects.requireNonNull(parent2, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) parent2;
        RecyclerView.ViewHolder findContainingViewHolder = recyclerView.findContainingViewHolder(view3);
        if (findContainingViewHolder == null) {
            return null;
        }
        Intrinsics.checkNotNullExpressionValue(findContainingViewHolder, "parentRecyclerView.findC…           ?: return null");
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (!(adapter instanceof BaseMultiTypeAdapter)) {
            adapter = null;
        }
        BaseMultiTypeAdapter baseMultiTypeAdapter = (BaseMultiTypeAdapter) adapter;
        if (baseMultiTypeAdapter == null) {
            return null;
        }
        Object item = baseMultiTypeAdapter.getItem(findContainingViewHolder.getAdapterPosition());
        if (item instanceof Entity) {
            entity = item;
        }
        return entity;
    }
}
