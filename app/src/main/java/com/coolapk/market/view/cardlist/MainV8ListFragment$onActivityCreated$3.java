package com.coolapk.market.view.cardlist;

import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "key", "", "onSharedPreferenceChanged"}, k = 3, mv = {1, 4, 2})
/* compiled from: MainV8ListFragment.kt */
final class MainV8ListFragment$onActivityCreated$3 implements SharedPreferences.OnSharedPreferenceChangeListener {
    final /* synthetic */ MainV8ListFragment this$0;

    MainV8ListFragment$onActivityCreated$3(MainV8ListFragment mainV8ListFragment) {
        this.this$0 = mainV8ListFragment;
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (Intrinsics.areEqual(str, "disable_show_upgrade_app_card") && MainV8ListFragment.access$disableShowUpgradeAppCard(this.this$0)) {
            this.this$0.removeUpgradeCard();
        }
    }
}
