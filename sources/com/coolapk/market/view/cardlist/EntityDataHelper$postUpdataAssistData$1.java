package com.coolapk.market.view.cardlist;

import com.coolapk.market.model.Feed;
import com.coolapk.market.widget.PausableTask;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/coolapk/market/view/cardlist/EntityDataHelper$postUpdataAssistData$1", "Lcom/coolapk/market/widget/PausableTask;", "run", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: EntityDataHelper.kt */
public final class EntityDataHelper$postUpdataAssistData$1 extends PausableTask {
    final /* synthetic */ EntityDataHelper this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    EntityDataHelper$postUpdataAssistData$1(EntityDataHelper entityDataHelper) {
        this.this$0 = entityDataHelper;
    }

    @Override // java.lang.Runnable
    public void run() {
        for (T t : this.this$0.getFragment().getDataList()) {
            if (this.this$0.obtainAssistData(t) == null && (t instanceof Feed)) {
                EntityDataHelper.access$generateAssistDataFor(this.this$0, t);
                if (PausableTask.checkNeedPause$default(this, false, 1, null)) {
                    return;
                }
            }
        }
    }
}
