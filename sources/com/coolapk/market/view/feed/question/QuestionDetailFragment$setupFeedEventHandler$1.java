package com.coolapk.market.view.feed.question;

import com.coolapk.market.model.Feed;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Lcom/coolapk/market/model/Feed;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: QuestionDetailFragment.kt */
final /* synthetic */ class QuestionDetailFragment$setupFeedEventHandler$1 extends FunctionReferenceImpl implements Function1<Feed, Unit> {
    QuestionDetailFragment$setupFeedEventHandler$1(QuestionDetailFragment questionDetailFragment) {
        super(1, questionDetailFragment, QuestionDetailFragment.class, "onFeedUpdate", "onFeedUpdate(Lcom/coolapk/market/model/Feed;)V", 0);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Feed feed) {
        invoke(feed);
        return Unit.INSTANCE;
    }

    public final void invoke(Feed feed) {
        Intrinsics.checkNotNullParameter(feed, "p1");
        ((QuestionDetailFragment) this.receiver).onFeedUpdate(feed);
    }
}
