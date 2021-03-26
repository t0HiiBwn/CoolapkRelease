package com.coolapk.market.view.goodsList;

import com.coolapk.market.widget.touchhelper.ItemTouchHelperAdapter;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\n"}, d2 = {"com/coolapk/market/view/goodsList/GoodGoodsEditListFragment$onActivityCreated$callback$1", "Lcom/coolapk/market/widget/touchhelper/ItemTouchHelperAdapter;", "canMove", "", "position", "", "canSwipe", "onItemMove", "fromPosition", "toPosition", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: GoodGoodsEditListFragment.kt */
public final class GoodGoodsEditListFragment$onActivityCreated$callback$1 implements ItemTouchHelperAdapter {
    final /* synthetic */ GoodGoodsEditListFragment this$0;

    @Override // com.coolapk.market.widget.touchhelper.ItemTouchHelperAdapter
    public boolean canSwipe(int i) {
        return false;
    }

    /* JADX WARN: Incorrect args count in method signature: ()V */
    GoodGoodsEditListFragment$onActivityCreated$callback$1(GoodGoodsEditListFragment goodGoodsEditListFragment) {
        this.this$0 = goodGoodsEditListFragment;
    }

    @Override // com.coolapk.market.widget.touchhelper.ItemTouchHelperAdapter
    public boolean onItemMove(int i, int i2) {
        this.this$0.moveItem(i, i2);
        return true;
    }

    @Override // com.coolapk.market.widget.touchhelper.ItemTouchHelperAdapter
    public boolean canMove(int i) {
        return this.this$0.getAdapter$presentation_coolapkAppRelease().getItemViewType(i) == 2131558692;
    }
}
