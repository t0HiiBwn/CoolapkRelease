package com.coolapk.market.widget;

import android.app.Activity;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: CoolCodeHelper.kt */
final class CoolCodeHelper$init$1$onActivityResumed$1 implements Runnable {
    final /* synthetic */ Activity $activity;

    CoolCodeHelper$init$1$onActivityResumed$1(Activity activity) {
        this.$activity = activity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CoolCodeHelper.INSTANCE.checkLastClipboardCode(this.$activity);
    }
}
