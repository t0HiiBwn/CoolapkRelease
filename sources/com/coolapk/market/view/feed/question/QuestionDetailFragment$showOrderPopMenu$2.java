package com.coolapk.market.view.feed.question;

import android.view.MenuItem;
import androidx.appcompat.widget.PopupMenu;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "item", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: QuestionDetailFragment.kt */
final class QuestionDetailFragment$showOrderPopMenu$2 implements PopupMenu.OnMenuItemClickListener {
    final /* synthetic */ QuestionDetailFragment this$0;

    QuestionDetailFragment$showOrderPopMenu$2(QuestionDetailFragment questionDetailFragment) {
        this.this$0 = questionDetailFragment;
    }

    @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        Intrinsics.checkNotNullExpressionValue(menuItem, "item");
        int itemId = menuItem.getItemId();
        if (itemId != 2131887194) {
            switch (itemId) {
                case 2131886609:
                    QuestionDetailFragment.access$getPresenter$p(this.this$0).setOrderType("dateline");
                    return true;
                case 2131886610:
                    QuestionDetailFragment.access$getPresenter$p(this.this$0).setOrderType("reply");
                    return true;
                case 2131886611:
                    QuestionDetailFragment.access$getPresenter$p(this.this$0).setOrderType("like");
                    return true;
                default:
                    return true;
            }
        } else {
            QuestionDetailFragment.access$getPresenter$p(this.this$0).setOrderType("block");
            return true;
        }
    }
}
