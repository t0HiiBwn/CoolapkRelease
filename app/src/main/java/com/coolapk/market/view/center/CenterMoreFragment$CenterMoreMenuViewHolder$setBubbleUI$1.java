package com.coolapk.market.view.center;

import android.view.View;
import com.coolapk.market.view.center.CenterMoreFragment;
import com.coolapk.market.widget.bubble.DragAndDropHelper;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onTargetDrop"}, k = 3, mv = {1, 4, 2})
/* compiled from: CenterMoreFragment.kt */
final class CenterMoreFragment$CenterMoreMenuViewHolder$setBubbleUI$1 implements DragAndDropHelper.DragAndDrawListener {
    final /* synthetic */ UserMenu $userMenu;
    final /* synthetic */ CenterMoreFragment.CenterMoreMenuViewHolder this$0;

    CenterMoreFragment$CenterMoreMenuViewHolder$setBubbleUI$1(CenterMoreFragment.CenterMoreMenuViewHolder centerMoreMenuViewHolder, UserMenu userMenu) {
        this.this$0 = centerMoreMenuViewHolder;
        this.$userMenu = userMenu;
    }

    @Override // com.coolapk.market.widget.bubble.DragAndDropHelper.DragAndDrawListener
    public final void onTargetDrop(View view) {
        this.this$0.getPresenter().getMenuPresenter().onDotDragAway(this.$userMenu.getType());
    }
}
