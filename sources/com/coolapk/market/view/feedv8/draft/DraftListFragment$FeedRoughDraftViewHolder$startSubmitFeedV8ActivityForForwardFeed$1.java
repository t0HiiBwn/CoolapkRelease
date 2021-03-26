package com.coolapk.market.view.feedv8.draft;

import android.app.ProgressDialog;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.FeedUIConfig;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"com/coolapk/market/view/feedv8/draft/DraftListFragment$FeedRoughDraftViewHolder$startSubmitFeedV8ActivityForForwardFeed$1", "Lrx/Subscriber;", "Lcom/coolapk/market/model/Entity;", "onCompleted", "", "onError", "e", "", "onNext", "s", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: DraftListFragment.kt */
public final class DraftListFragment$FeedRoughDraftViewHolder$startSubmitFeedV8ActivityForForwardFeed$1 extends Subscriber<Entity> {
    final /* synthetic */ ProgressDialog $dialog;
    final /* synthetic */ DraftListFragment $fragment;
    final /* synthetic */ RoughDraft $roughDraft;

    DraftListFragment$FeedRoughDraftViewHolder$startSubmitFeedV8ActivityForForwardFeed$1(ProgressDialog progressDialog, DraftListFragment draftListFragment, RoughDraft roughDraft) {
        this.$dialog = progressDialog;
        this.$fragment = draftListFragment;
        this.$roughDraft = roughDraft;
    }

    @Override // rx.Observer
    public void onCompleted() {
        this.$dialog.dismiss();
    }

    @Override // rx.Observer
    public void onError(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "e");
        Toast.error(this.$fragment.requireActivity(), th);
        this.$dialog.dismiss();
    }

    public void onNext(Entity entity) {
        Intrinsics.checkNotNullParameter(entity, "s");
        FeedUIConfig build = FeedUIConfig.builder(this.$roughDraft.getUiConfig()).forwardEntity(entity).build();
        int indexOf = RoughDraftHelper.Companion.getInstance().getRoughDraftList().indexOf(this.$roughDraft);
        RoughDraft roughDraft = this.$roughDraft;
        Intrinsics.checkNotNullExpressionValue(build, "uiConfig");
        RoughDraft copy$default = RoughDraft.copy$default(roughDraft, null, 0, null, build, 7, null);
        if (indexOf >= 0) {
            RoughDraftHelper.Companion.getInstance().getRoughDraftList().set(indexOf, copy$default);
        }
        ActionManager.startSubmitFeedV8Activity(this.$fragment.requireActivity(), copy$default);
    }
}
