package com.coolapk.market.widget;

import com.coolapk.market.event.Event;
import com.coolapk.market.util.StateEventChangedAdapter;
import com.coolapk.market.viewholder.StateViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\u0006"}, d2 = {"com/coolapk/market/widget/AppActionHelper$stateEventChanged$1", "Lcom/coolapk/market/util/StateEventChangedAdapter;", "notifyEventChanged", "", "event", "Lcom/coolapk/market/event/Event;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ActionButton.kt */
public final class AppActionHelper$stateEventChanged$1 extends StateEventChangedAdapter {
    final /* synthetic */ AppActionHelper this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    AppActionHelper$stateEventChanged$1(AppActionHelper appActionHelper) {
        this.this$0 = appActionHelper;
    }

    @Override // com.coolapk.market.util.StateEventChangedAdapter
    protected void notifyEventChanged(Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (StateViewHolder.isEventBelongTo(event, this.this$0.getServiceApp())) {
            this.this$0.updateWithApp();
        }
    }
}
