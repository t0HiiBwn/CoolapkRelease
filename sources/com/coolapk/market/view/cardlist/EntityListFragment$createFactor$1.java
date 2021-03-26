package com.coolapk.market.view.cardlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.model.Entity;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.widget.multitype.ViewHolderFactor;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00009\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0013"}, d2 = {"com/coolapk/market/view/cardlist/EntityListFragment$createFactor$1", "Lcom/coolapk/market/widget/multitype/ViewHolderFactor;", "itemViewType", "", "getItemViewType", "()I", "isSuitedToViewHolder", "", "item", "", "onBindViewHolder", "", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onCreateViewHolder", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: EntityListFragment.kt */
public final class EntityListFragment$createFactor$1 implements ViewHolderFactor {
    final /* synthetic */ Function1 $block;
    final /* synthetic */ int $layoutId;
    final /* synthetic */ String[] $types;
    final /* synthetic */ EntityListFragment this$0;

    EntityListFragment$createFactor$1(EntityListFragment entityListFragment, Function1 function1, int i, String[] strArr) {
        this.this$0 = entityListFragment;
        this.$block = function1;
        this.$layoutId = i;
        this.$types = strArr;
    }

    @Override // com.coolapk.market.widget.multitype.ViewHolderFactor
    public RecyclerView.ViewHolder onCreateViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        Function1 function1 = this.$block;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(this.$layoutId, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "LayoutInflater.from(pare…(layoutId, parent, false)");
        return (RecyclerView.ViewHolder) function1.invoke(inflate);
    }

    @Override // com.coolapk.market.widget.multitype.ViewHolderFactor
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, Object obj) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        if (viewHolder instanceof BindingViewHolder) {
            ((BindingViewHolder) viewHolder).bindTo(obj);
        }
    }

    @Override // com.coolapk.market.widget.multitype.ViewHolderFactor
    public boolean isSuitedToViewHolder(Object obj) {
        if (!(obj instanceof Entity)) {
            return false;
        }
        Entity entity = (Entity) obj;
        if ((!Intrinsics.areEqual(entity.getEntityType(), "card") || !ArraysKt.contains(this.$types, entity.getEntityTemplate())) && !ArraysKt.contains(this.$types, entity.getEntityType())) {
            return false;
        }
        return true;
    }

    @Override // com.coolapk.market.widget.multitype.ViewHolderFactor
    public int getItemViewType() {
        Integer num = this.this$0.getItemViewTypeByEntityType().get(this.$types[0]);
        Intrinsics.checkNotNull(num);
        return num.intValue();
    }
}
