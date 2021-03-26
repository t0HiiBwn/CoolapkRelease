package com.coolapk.market.view.feed.vote;

import android.content.Context;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.Vote;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0016\u001a\u00020\u0005J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\bJ\u000e\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000b\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000bR\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001c"}, d2 = {"Lcom/coolapk/market/view/feed/vote/FeedVoteViewModel;", "", "context", "Landroid/content/Context;", "feed", "Lcom/coolapk/market/model/Feed;", "(Landroid/content/Context;Lcom/coolapk/market/model/Feed;)V", "showModifyView", "", "userCommented", "getUserCommented", "()Z", "userVoteCommentInLifecycle", "getUserVoteCommentInLifecycle", "setUserVoteCommentInLifecycle", "(Z)V", "userVotedAndNotModifying", "getUserVotedAndNotModifying", "vote", "Lcom/coolapk/market/model/Vote;", "getVote", "()Lcom/coolapk/market/model/Vote;", "getFeed", "setShowModifyingStatus", "", "modifying", "updateFeed", "Feed", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedVotePresenter.kt */
public final class FeedVoteViewModel {
    private final Context context;
    private Feed feed;
    private boolean showModifyView;
    private boolean userVoteCommentInLifecycle;

    public FeedVoteViewModel(Context context2, Feed feed2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(feed2, "feed");
        this.context = context2;
        this.feed = feed2;
    }

    public final Feed getFeed() {
        return this.feed;
    }

    public final void updateFeed(Feed feed2) {
        Intrinsics.checkNotNullParameter(feed2, "Feed");
        this.feed = feed2;
    }

    public final Vote getVote() {
        Vote vote = this.feed.getVote();
        Intrinsics.checkNotNull(vote);
        Intrinsics.checkNotNullExpressionValue(vote, "feed.vote!!");
        return vote;
    }

    public final boolean getUserVoteCommentInLifecycle() {
        return this.userVoteCommentInLifecycle;
    }

    public final void setUserVoteCommentInLifecycle(boolean z) {
        this.userVoteCommentInLifecycle = z;
    }

    public final void setShowModifyingStatus(boolean z) {
        this.showModifyView = z;
    }

    public final boolean getUserCommented() {
        return EntityExtendsKt.isUserCommented(getVote()) || this.userVoteCommentInLifecycle;
    }

    public final boolean getUserVotedAndNotModifying() {
        return EntityExtendsKt.isUserVoted(getVote()) && !this.showModifyView;
    }
}
