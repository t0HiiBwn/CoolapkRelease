package com.coolapk.market.view.feed.vote;

import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.Feed;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "optionId", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedVoteHeaderViewPart.kt */
final class FeedVoteHeaderViewPart$populateRunningPKVote$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ Feed $data;
    final /* synthetic */ FeedVoteHeaderViewPart this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedVoteHeaderViewPart$populateRunningPKVote$1(FeedVoteHeaderViewPart feedVoteHeaderViewPart, Feed feed) {
        super(1);
        this.this$0 = feedVoteHeaderViewPart;
        this.$data = feed;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke(str);
        return Unit.INSTANCE;
    }

    public final void invoke(String str) {
        Intrinsics.checkNotNullParameter(str, "optionId");
        Boolean checkLogin = ActionManager.checkLogin(this.this$0.getContext());
        Intrinsics.checkNotNullExpressionValue(checkLogin, "ActionManager.checkLogin(context)");
        if (checkLogin.booleanValue()) {
            FeedVotePresenter presenter = this.this$0.getPresenter();
            String id = this.$data.getId();
            Intrinsics.checkNotNull(id);
            Intrinsics.checkNotNullExpressionValue(id, "data.id!!");
            presenter.voteOptions(id, CollectionsKt.mutableListOf(str), this.this$0.didUserCheckAnonymous);
        }
    }
}
