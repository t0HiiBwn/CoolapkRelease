package com.coolapk.market.view.app;

import android.text.TextUtils;
import com.coolapk.market.event.AppEvent;
import com.coolapk.market.event.Event;
import com.coolapk.market.util.StateEventChangedAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\u0006"}, d2 = {"com/coolapk/market/view/app/AppViewV8Activity$stateEventChangedAdapter$1", "Lcom/coolapk/market/util/StateEventChangedAdapter;", "notifyEventChanged", "", "event", "Lcom/coolapk/market/event/Event;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AppViewV8Activity.kt */
public final class AppViewV8Activity$stateEventChangedAdapter$1 extends StateEventChangedAdapter {
    final /* synthetic */ AppViewV8Activity this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    AppViewV8Activity$stateEventChangedAdapter$1(AppViewV8Activity appViewV8Activity) {
        this.this$0 = appViewV8Activity;
    }

    @Override // com.coolapk.market.util.StateEventChangedAdapter
    protected void notifyEventChanged(Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        AppViewV8Activity.access$getViewModel$p(this.this$0).updateAction();
        if ((event instanceof AppEvent) && TextUtils.equals(((AppEvent) event).packageName, AppViewV8Activity.access$getAppPackageName$p(this.this$0))) {
            this.this$0.invalidateOptionsMenu();
            AppViewV8Activity.access$getBinding$p(this.this$0).toolbar.post(new AppViewV8Activity$stateEventChangedAdapter$1$notifyEventChanged$1(this));
        }
    }
}
