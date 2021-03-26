package com.coolapk.market.view.cardlist;

import androidx.recyclerview.widget.GridLayoutManager;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.model.Entity;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/coolapk/market/view/cardlist/EntityListFragment$onActivityCreated$1", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "getSpanSize", "", "position", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: EntityListFragment.kt */
public final class EntityListFragment$onActivityCreated$1 extends GridLayoutManager.SpanSizeLookup {
    final /* synthetic */ EntityListFragment this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    EntityListFragment$onActivityCreated$1(EntityListFragment entityListFragment) {
        this.this$0 = entityListFragment;
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
    public int getSpanSize(int i) {
        Object item = this.this$0.getAdapter$presentation_coolapkAppRelease().getItem(i);
        if (!(item instanceof Entity)) {
            return this.this$0.getConfigHelper().getSpanCount();
        }
        Entity entity = (Entity) item;
        String entityType = entity.getEntityType();
        if (entityType == null || entityType.hashCode() != 998694819 || !entityType.equals("liveTopic")) {
            return this.this$0.getConfigHelper().getSpanCount();
        }
        return (int) Math.ceil(((double) this.this$0.getConfigHelper().getSpanCount()) / ((double) EntityExtendsKt.getIntExtraData(entity, "cols", 1)));
    }
}
