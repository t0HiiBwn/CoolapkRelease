package com.coolapk.market.view.feed.question;

import com.coolapk.market.app.EmptySubscriber;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"com/coolapk/market/view/feed/question/QuestionPresenter$inviteUser$2", "Lcom/coolapk/market/app/EmptySubscriber;", "", "onError", "", "e", "", "onNext", "t", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: QuestionPresenter.kt */
public final class QuestionPresenter$inviteUser$2 extends EmptySubscriber<String> {
    final /* synthetic */ QuestionPresenter this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    QuestionPresenter$inviteUser$2(QuestionPresenter questionPresenter) {
        this.this$0 = questionPresenter;
    }

    @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
    public void onError(Throwable th) {
        super.onError(th);
        this.this$0.setPostingFollow(false);
        this.this$0.getView().onInviteResult("", th);
    }

    public void onNext(String str) {
        Intrinsics.checkNotNullParameter(str, "t");
        super.onNext((QuestionPresenter$inviteUser$2) str);
        this.this$0.setPostingFollow(false);
        this.this$0.getView().onInviteResult(str, null);
    }
}
