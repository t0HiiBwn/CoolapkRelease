package com.coolapk.market.view.feedv8.draft;

import com.google.android.material.snackbar.Snackbar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/coolapk/market/view/feedv8/draft/DraftListFragment$FeedRoughDraftViewHolder$showDeleteSnackBar$3", "Lcom/google/android/material/snackbar/Snackbar$Callback;", "onDismissed", "", "transientBottomBar", "Lcom/google/android/material/snackbar/Snackbar;", "event", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: DraftListFragment.kt */
public final class DraftListFragment$FeedRoughDraftViewHolder$showDeleteSnackBar$3 extends Snackbar.Callback {
    final /* synthetic */ RoughDraft $draft;
    final /* synthetic */ DraftListFragment $fragment;

    DraftListFragment$FeedRoughDraftViewHolder$showDeleteSnackBar$3(RoughDraft roughDraft, DraftListFragment draftListFragment) {
        this.$draft = roughDraft;
        this.$fragment = draftListFragment;
    }

    @Override // com.google.android.material.snackbar.Snackbar.Callback
    public void onDismissed(Snackbar snackbar, int i) {
        super.onDismissed(snackbar, i);
        RoughDraftHelper instance = RoughDraftHelper.Companion.getInstance();
        RoughDraft roughDraft = this.$draft;
        Intrinsics.checkNotNullExpressionValue(roughDraft, "draft");
        instance.remove(roughDraft);
        this.$fragment.setShowingSnackBar(null);
    }
}
