package com.coolapk.market.view.feed.reply;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.view.cardlist.EntityListFixTopHelper;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/coolapk/market/view/feed/reply/CommentCountViewPart;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedReplyListFragmentV8.kt */
final class FeedReplyListFragmentV8$commentCountViewPart$2 extends Lambda implements Function0<CommentCountViewPart> {
    final /* synthetic */ FeedReplyListFragmentV8 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedReplyListFragmentV8$commentCountViewPart$2(FeedReplyListFragmentV8 feedReplyListFragmentV8) {
        super(0);
        this.this$0 = feedReplyListFragmentV8;
    }

    @Override // kotlin.jvm.functions.Function0
    public final CommentCountViewPart invoke() {
        FeedReplyPresenter presenter = this.this$0.getPresenter();
        EntityListFixTopHelper entityListFixTopHelper$presentation_coolapkAppRelease = this.this$0.getEntityListFixTopHelper$presentation_coolapkAppRelease();
        HolderItem commentCountHolder = FeedReplyViewModel.Companion.getCommentCountHolder();
        Intrinsics.checkNotNullExpressionValue(commentCountHolder, "FeedReplyViewModel.commentCountHolder");
        CommentCountViewPart commentCountViewPart = new CommentCountViewPart(presenter, entityListFixTopHelper$presentation_coolapkAppRelease, commentCountHolder);
        LayoutInflater from = LayoutInflater.from(this.this$0.getActivity());
        Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(activity)");
        View view = this.this$0.getView();
        Objects.requireNonNull(view, "null cannot be cast to non-null type android.view.ViewGroup");
        commentCountViewPart.createView(from, (ViewGroup) view);
        return commentCountViewPart;
    }
}
