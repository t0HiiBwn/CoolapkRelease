package com.coolapk.market.view.feedv8;

import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.model.Entity;
import com.coolapk.market.widget.Toast;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0001J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¨\u0006\n"}, d2 = {"com/coolapk/market/view/feedv8/QuestionTitleActivity$loadSimilarQuestions$1", "Lcom/coolapk/market/app/EmptySubscriber;", "", "Lcom/coolapk/market/model/Entity;", "onError", "", "e", "", "onNext", "t", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: QuestionTitleActivity.kt */
public final class QuestionTitleActivity$loadSimilarQuestions$1 extends EmptySubscriber<List<? extends Entity>> {
    final /* synthetic */ QuestionTitleActivity this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    QuestionTitleActivity$loadSimilarQuestions$1(QuestionTitleActivity questionTitleActivity) {
        this.this$0 = questionTitleActivity;
    }

    @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
    public void onError(Throwable th) {
        super.onError(th);
        Toast.error(this.this$0.getActivity(), th);
    }

    public void onNext(List<? extends Entity> list) {
        super.onNext((QuestionTitleActivity$loadSimilarQuestions$1) list);
        this.this$0.dataList.clear();
        if (list != null) {
            this.this$0.dataList.addAll(list);
        }
    }
}
