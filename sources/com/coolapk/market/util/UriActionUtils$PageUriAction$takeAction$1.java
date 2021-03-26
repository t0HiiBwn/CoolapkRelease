package com.coolapk.market.util;

import android.app.Activity;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.FeedGoods;
import com.coolapk.market.model.FeedMultiPart;
import com.coolapk.market.view.feedv8.FeedArgsFactory;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"gotoGoodsActivity", "", "feedGoods", "Lcom/coolapk/market/model/FeedGoods;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: UriActionUtils.kt */
final class UriActionUtils$PageUriAction$takeAction$1 extends Lambda implements Function1<FeedGoods, Unit> {
    final /* synthetic */ Activity $activity;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UriActionUtils$PageUriAction$takeAction$1(Activity activity) {
        super(1);
        this.$activity = activity;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(FeedGoods feedGoods) {
        invoke(feedGoods);
        return Unit.INSTANCE;
    }

    public final void invoke(FeedGoods feedGoods) {
        FeedMultiPart multiPartForGoods = FeedArgsFactory.multiPartForGoods(feedGoods);
        ActionManager.startSubmitFeedV8Activity(this.$activity, FeedArgsFactory.uiConfigForForwardGoods(this.$activity, feedGoods), multiPartForGoods);
    }
}
