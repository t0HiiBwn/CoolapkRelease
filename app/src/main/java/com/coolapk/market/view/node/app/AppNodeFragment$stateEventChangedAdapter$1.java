package com.coolapk.market.view.node.app;

import android.text.TextUtils;
import com.coolapk.market.databinding.TopicNodePageBinding;
import com.coolapk.market.event.AppEvent;
import com.coolapk.market.event.Event;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.util.StateEventChangedAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\u0006"}, d2 = {"com/coolapk/market/view/node/app/AppNodeFragment$stateEventChangedAdapter$1", "Lcom/coolapk/market/util/StateEventChangedAdapter;", "notifyEventChanged", "", "event", "Lcom/coolapk/market/event/Event;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AppNodeFragment.kt */
public final class AppNodeFragment$stateEventChangedAdapter$1 extends StateEventChangedAdapter {
    final /* synthetic */ AppNodeFragment this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    AppNodeFragment$stateEventChangedAdapter$1(AppNodeFragment appNodeFragment) {
        this.this$0 = appNodeFragment;
    }

    @Override // com.coolapk.market.util.StateEventChangedAdapter
    protected void notifyEventChanged(Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.this$0.getViewModel().getServiceApp().notifyChange();
        if (event instanceof AppEvent) {
            ServiceApp serviceApp = this.this$0.getViewModel().getServiceApp().get();
            if (TextUtils.equals(((AppEvent) event).packageName, serviceApp != null ? serviceApp.getPackageName() : null)) {
                this.this$0.requireActivity().invalidateOptionsMenu();
                TopicNodePageBinding binding$presentation_coolapkAppRelease = this.this$0.getNodeActivity().getBinding$presentation_coolapkAppRelease();
                binding$presentation_coolapkAppRelease.toolbar.post(new AppNodeFragment$stateEventChangedAdapter$1$notifyEventChanged$1(binding$presentation_coolapkAppRelease));
            }
        }
    }
}
