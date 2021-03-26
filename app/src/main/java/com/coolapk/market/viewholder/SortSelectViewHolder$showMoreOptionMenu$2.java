package com.coolapk.market.viewholder;

import android.view.MenuItem;
import androidx.appcompat.widget.PopupMenu;
import com.coolapk.market.model.Entity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "item", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: SortSelectViewHolder.kt */
final class SortSelectViewHolder$showMoreOptionMenu$2 implements PopupMenu.OnMenuItemClickListener {
    final /* synthetic */ List $entities;
    final /* synthetic */ SortSelectViewHolder this$0;

    SortSelectViewHolder$showMoreOptionMenu$2(SortSelectViewHolder sortSelectViewHolder, List list) {
        this.this$0 = sortSelectViewHolder;
        this.$entities = list;
    }

    @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        SortSelectViewHolder sortSelectViewHolder = this.this$0;
        List list = this.$entities;
        Intrinsics.checkNotNullExpressionValue(menuItem, "item");
        Object obj = list.get(menuItem.getItemId());
        Intrinsics.checkNotNullExpressionValue(obj, "entities.get(item.itemId)");
        sortSelectViewHolder.onItemClick((Entity) obj);
        return true;
    }
}
