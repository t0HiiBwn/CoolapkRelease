package com.coolapk.market.view.feedv8.draft;

import android.view.View;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: DraftListFragment.kt */
final class DraftListFragment$FeedRoughDraftViewHolder$showDeleteSnackBar$2 implements View.OnClickListener {
    final /* synthetic */ RoughDraft $draft;
    final /* synthetic */ DraftListFragment $fragment;
    final /* synthetic */ int $position;

    DraftListFragment$FeedRoughDraftViewHolder$showDeleteSnackBar$2(DraftListFragment draftListFragment, int i, RoughDraft roughDraft) {
        this.$fragment = draftListFragment;
        this.$position = i;
        this.$draft = roughDraft;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.$fragment.getDataList().add(this.$position, this.$draft);
    }
}
