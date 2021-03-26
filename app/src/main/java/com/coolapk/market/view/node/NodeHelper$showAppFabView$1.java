package com.coolapk.market.view.node;

import android.app.Activity;
import com.blankj.utilcode.util.ToastUtils;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.FeedMultiPart;
import com.coolapk.market.model.FeedUIConfig;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.view.feedv8.FeedArgsFactory;
import com.coolapk.market.view.feedv8.FeedArgsFactoryKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"doComment", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: NodeHelper.kt */
final class NodeHelper$showAppFabView$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ ServiceApp $app;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NodeHelper$showAppFabView$1(ServiceApp serviceApp, Activity activity) {
        super(0);
        this.$app = serviceApp;
        this.$activity = activity;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        if (this.$app.getCommentStatus() == -1) {
            ToastUtils.showShort("此应用禁止讨论", new Object[0]);
            return;
        }
        FeedMultiPart build = FeedArgsFactoryKt.applyServiceApp(FeedArgsFactory.multiPartForFeed(), this.$app).build();
        FeedUIConfig build2 = FeedArgsFactoryKt.applyServiceApp(FeedArgsFactory.uiConfigForFeed(this.$activity), this.$app).title("发讨论").build();
        StatisticHelper.Companion.getInstance().recordPhoneBarPostEvent("讨论");
        ActionManager.startSubmitFeedV8Activity(this.$activity, build2, build);
    }
}
