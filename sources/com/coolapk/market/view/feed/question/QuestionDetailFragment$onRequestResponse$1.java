package com.coolapk.market.view.feed.question;

import com.coolapk.market.manager.ActionManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: QuestionDetailFragment.kt */
final class QuestionDetailFragment$onRequestResponse$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ QuestionDetailFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    QuestionDetailFragment$onRequestResponse$1(QuestionDetailFragment questionDetailFragment) {
        super(0);
        this.this$0 = questionDetailFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        ActionManager.startAnswerFeedActivity(this.this$0.getActivity(), QuestionDetailFragment.access$getPresenter$p(this.this$0).getFeed());
    }
}
