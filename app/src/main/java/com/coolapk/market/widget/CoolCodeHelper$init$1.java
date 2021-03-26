package com.coolapk.market.widget;

import android.app.Activity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/coolapk/market/widget/CoolCodeHelper$init$1", "Lcom/coolapk/market/widget/ActivityLifecycleCallbacksAdapter;", "onActivityPaused", "", "activity", "Landroid/app/Activity;", "onActivityResumed", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CoolCodeHelper.kt */
public final class CoolCodeHelper$init$1 extends ActivityLifecycleCallbacksAdapter {
    CoolCodeHelper$init$1() {
    }

    @Override // com.coolapk.market.widget.ActivityLifecycleCallbacksAdapter, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onActivityResumed(activity);
        CoolCodeHelper coolCodeHelper = CoolCodeHelper.INSTANCE;
        CoolCodeHelper.handler.postDelayed(new CoolCodeHelper$init$1$onActivityResumed$1(activity), 500);
    }

    @Override // com.coolapk.market.widget.ActivityLifecycleCallbacksAdapter, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onActivityPaused(activity);
        CoolCodeHelper coolCodeHelper = CoolCodeHelper.INSTANCE;
        CoolCodeHelper.handler.removeCallbacksAndMessages(null);
    }
}
