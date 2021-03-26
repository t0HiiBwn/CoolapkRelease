package com.coolapk.market.view.feed.goods;

import android.app.Activity;
import android.view.LayoutInflater;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.FeedGoods;
import com.coolapk.market.view.feed.FeedDetailActivityV8;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\"\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00040\u000b¨\u0006\r"}, d2 = {"Lcom/coolapk/market/view/feed/goods/FeedBindGoodsHelper;", "", "()V", "showBindGoodsDialog", "", "activity", "Landroid/app/Activity;", "feed", "Lcom/coolapk/market/model/Feed;", "showCreateGoodsDialog", "successCallback", "Lkotlin/Function1;", "Lcom/coolapk/market/model/FeedGoods;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedBindGoodsHelper.kt */
public final class FeedBindGoodsHelper {
    public static final FeedBindGoodsHelper INSTANCE = new FeedBindGoodsHelper();

    private FeedBindGoodsHelper() {
    }

    public final void showBindGoodsDialog(Activity activity, Feed feed) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(feed, "feed");
        if (activity instanceof FeedDetailActivityV8) {
            ((FeedDetailActivityV8) activity).showEditBindGoodsView(feed);
            return;
        }
        Activity activity2 = activity;
        String id = feed.getId();
        if (id == null) {
            id = "";
        }
        ActionManagerCompat.startFeedDetailActivity$default(activity2, id, null, null, null, 64, null, null, 220, null);
    }

    public final void showCreateGoodsDialog(Activity activity, Function1<? super FeedGoods, Unit> function1) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(function1, "successCallback");
        CreateGoodsViewPart createGoodsViewPart = new CreateGoodsViewPart();
        LayoutInflater from = LayoutInflater.from(activity);
        Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(activity)");
        createGoodsViewPart.createView(from, null);
        createGoodsViewPart.showAsBottomSheetDialog(activity, function1);
    }
}
