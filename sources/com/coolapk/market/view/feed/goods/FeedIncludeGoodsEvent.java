package com.coolapk.market.view.feed.goods;

import com.coolapk.market.model.FeedGoods;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/coolapk/market/view/feed/goods/FeedIncludeGoodsEvent;", "", "id", "", "goods", "", "Lcom/coolapk/market/model/FeedGoods;", "(Ljava/lang/String;Ljava/util/List;)V", "getGoods", "()Ljava/util/List;", "getId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedBindGoodsViewPart.kt */
public final class FeedIncludeGoodsEvent {
    private final List<FeedGoods> goods;
    private final String id;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.coolapk.market.view.feed.goods.FeedIncludeGoodsEvent */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FeedIncludeGoodsEvent copy$default(FeedIncludeGoodsEvent feedIncludeGoodsEvent, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = feedIncludeGoodsEvent.id;
        }
        if ((i & 2) != 0) {
            list = feedIncludeGoodsEvent.goods;
        }
        return feedIncludeGoodsEvent.copy(str, list);
    }

    public final String component1() {
        return this.id;
    }

    public final List<FeedGoods> component2() {
        return this.goods;
    }

    public final FeedIncludeGoodsEvent copy(String str, List<? extends FeedGoods> list) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(list, "goods");
        return new FeedIncludeGoodsEvent(str, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeedIncludeGoodsEvent)) {
            return false;
        }
        FeedIncludeGoodsEvent feedIncludeGoodsEvent = (FeedIncludeGoodsEvent) obj;
        return Intrinsics.areEqual(this.id, feedIncludeGoodsEvent.id) && Intrinsics.areEqual(this.goods, feedIncludeGoodsEvent.goods);
    }

    public int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<FeedGoods> list = this.goods;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "FeedIncludeGoodsEvent(id=" + this.id + ", goods=" + this.goods + ")";
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends com.coolapk.market.model.FeedGoods> */
    /* JADX WARN: Multi-variable type inference failed */
    public FeedIncludeGoodsEvent(String str, List<? extends FeedGoods> list) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(list, "goods");
        this.id = str;
        this.goods = list;
    }

    public final List<FeedGoods> getGoods() {
        return this.goods;
    }

    public final String getId() {
        return this.id;
    }
}
