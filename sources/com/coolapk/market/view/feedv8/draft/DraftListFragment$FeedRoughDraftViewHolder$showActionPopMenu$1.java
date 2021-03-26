package com.coolapk.market.view.feedv8.draft;

import android.view.MenuItem;
import androidx.appcompat.widget.PopupMenu;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.view.feedv8.draft.DraftListFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "item", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: DraftListFragment.kt */
final class DraftListFragment$FeedRoughDraftViewHolder$showActionPopMenu$1 implements PopupMenu.OnMenuItemClickListener {
    final /* synthetic */ DraftListFragment $fragment;
    final /* synthetic */ RoughDraft $roughDraft;
    final /* synthetic */ DraftListFragment.FeedRoughDraftViewHolder this$0;

    DraftListFragment$FeedRoughDraftViewHolder$showActionPopMenu$1(DraftListFragment.FeedRoughDraftViewHolder feedRoughDraftViewHolder, DraftListFragment draftListFragment, RoughDraft roughDraft) {
        this.this$0 = feedRoughDraftViewHolder;
        this.$fragment = draftListFragment;
        this.$roughDraft = roughDraft;
    }

    /* renamed from: invoke */
    public final boolean onMenuItemClick(MenuItem menuItem) {
        Intrinsics.checkNotNullExpressionValue(menuItem, "item");
        int itemId = menuItem.getItemId();
        if (itemId == 101) {
            if (this.this$0.getAdapterPosition() >= 0) {
                this.this$0.showDeleteSnackBar();
            }
            return true;
        } else if (itemId != 102) {
            return false;
        } else {
            ActionManager.startQuestionDetailActivity(this.$fragment.requireActivity(), this.$roughDraft.getMultiPart().feedId());
            return true;
        }
    }
}
