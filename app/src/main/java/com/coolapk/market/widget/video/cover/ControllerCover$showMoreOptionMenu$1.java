package com.coolapk.market.widget.video.cover;

import android.view.MenuItem;
import androidx.appcompat.widget.PopupMenu;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "item", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: ControllerCover.kt */
final class ControllerCover$showMoreOptionMenu$1 implements PopupMenu.OnMenuItemClickListener {
    final /* synthetic */ ControllerCover this$0;

    ControllerCover$showMoreOptionMenu$1(ControllerCover controllerCover) {
        this.this$0 = controllerCover;
    }

    @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        Intrinsics.checkNotNullExpressionValue(menuItem, "item");
        int itemId = menuItem.getItemId();
        if (itemId == 2131361884) {
            this.this$0.notifyReceiverEvent(-123, null);
            return true;
        } else if (itemId != 2131361981) {
            return true;
        } else {
            this.this$0.notifyReceiverEvent(-122, null);
            return true;
        }
    }
}
