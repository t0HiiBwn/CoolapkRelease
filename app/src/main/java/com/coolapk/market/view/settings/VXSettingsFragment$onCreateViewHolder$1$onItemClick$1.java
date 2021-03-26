package com.coolapk.market.view.settings;

import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.DataManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: VXSettingsFragment.kt */
final class VXSettingsFragment$onCreateViewHolder$1$onItemClick$1 implements Runnable {
    final /* synthetic */ VXSettingsFragment$onCreateViewHolder$1 this$0;

    VXSettingsFragment$onCreateViewHolder$1$onItemClick$1(VXSettingsFragment$onCreateViewHolder$1 vXSettingsFragment$onCreateViewHolder$1) {
        this.this$0 = vXSettingsFragment$onCreateViewHolder$1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        loginSession.reset();
        EventBus.getDefault().post(loginSession);
        this.this$0.this$0.requireActivity().finish();
    }
}
