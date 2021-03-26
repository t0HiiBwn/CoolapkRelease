package com.coolapk.market.viewholder;

import com.coolapk.market.model.Feed;
import com.coolapk.market.model.FeedGoods;
import com.coolapk.market.model.FeedGoodsAction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0003¨\u0006\u0004"}, d2 = {"toGoodsSimpleInfo", "Lcom/coolapk/market/viewholder/GoodsSimpleInfo;", "Lcom/coolapk/market/model/Feed;", "Lcom/coolapk/market/model/FeedGoods;", "presentation_coolapkAppRelease"}, k = 2, mv = {1, 4, 2})
/* compiled from: FeedGoodsInfoViewPart.kt */
public final class FeedGoodsInfoViewPartKt {
    public static final GoodsSimpleInfo toGoodsSimpleInfo(Feed feed) {
        String str;
        String str2;
        String str3;
        String str4;
        Intrinsics.checkNotNullParameter(feed, "$this$toGoodsSimpleInfo");
        String extraTitle = feed.getExtraTitle();
        String str5 = extraTitle != null ? extraTitle : "";
        String extraPic = feed.getExtraPic();
        String str6 = extraPic != null ? extraPic : "";
        FeedGoodsAction goodsAction = feed.getGoodsAction();
        String str7 = null;
        String price = goodsAction != null ? goodsAction.getPrice() : null;
        String str8 = price != null ? price : "";
        FeedGoodsAction goodsAction2 = feed.getGoodsAction();
        String categoryName = goodsAction2 != null ? goodsAction2.getCategoryName() : null;
        if (categoryName != null) {
            str = categoryName;
        } else {
            str = "";
        }
        FeedGoodsAction goodsAction3 = feed.getGoodsAction();
        String mallName = goodsAction3 != null ? goodsAction3.getMallName() : null;
        if (mallName != null) {
            str2 = mallName;
        } else {
            str2 = "";
        }
        String extraUrl = feed.getExtraUrl();
        if (extraUrl != null) {
            str3 = extraUrl;
        } else {
            str3 = "";
        }
        FeedGoodsAction goodsAction4 = feed.getGoodsAction();
        if (goodsAction4 != null) {
            str7 = goodsAction4.getSellUrl();
        }
        if (str7 != null) {
            str4 = str7;
        } else {
            str4 = "";
        }
        return new GoodsSimpleInfo(str5, str6, str8, str, str2, str3, str4);
    }

    public static final GoodsSimpleInfo toGoodsSimpleInfo(FeedGoods feedGoods) {
        String str;
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(feedGoods, "$this$toGoodsSimpleInfo");
        String title = feedGoods.getTitle();
        String str4 = title != null ? title : "";
        String cover = feedGoods.getCover();
        String str5 = cover != null ? cover : "";
        String price = feedGoods.getPrice();
        String str6 = price != null ? price : "";
        String categoryName = feedGoods.getCategoryName();
        if (categoryName != null) {
            str = categoryName;
        } else {
            str = "";
        }
        String mallName = feedGoods.getMallName();
        if (mallName != null) {
            str2 = mallName;
        } else {
            str2 = "";
        }
        String url = feedGoods.getUrl();
        if (url != null) {
            str3 = url;
        } else {
            str3 = "";
        }
        String sellUrl = feedGoods.getSellUrl();
        if (sellUrl == null) {
            sellUrl = "";
        }
        return new GoodsSimpleInfo(str4, str5, str6, str, str2, str3, sellUrl);
    }
}
