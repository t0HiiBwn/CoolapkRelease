package com.coolapk.market.view.feed.reply;

import android.view.MenuItem;
import androidx.appcompat.widget.PopupMenu;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "item", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: CommentCountViewPart.kt */
final class CommentCountViewPart$showFilterPopMenu$3 implements PopupMenu.OnMenuItemClickListener {
    final /* synthetic */ CommentCountViewPart this$0;

    CommentCountViewPart$showFilterPopMenu$3(CommentCountViewPart commentCountViewPart) {
        this.this$0 = commentCountViewPart;
    }

    /* renamed from: invoke */
    public final boolean onMenuItemClick(MenuItem menuItem) {
        FilterArgs filterArgs;
        FilterArgs[] values = FilterArgs.values();
        int length = values.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                filterArgs = null;
                break;
            }
            filterArgs = values[i];
            int validId = filterArgs.validId();
            Intrinsics.checkNotNullExpressionValue(menuItem, "item");
            if (validId == menuItem.getItemId()) {
                break;
            }
            i++;
        }
        if (filterArgs == null) {
            return false;
        }
        this.this$0.getPresenter().switchFilterArgs(filterArgs);
        return true;
    }
}
