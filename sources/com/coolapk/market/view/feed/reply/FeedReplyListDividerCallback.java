package com.coolapk.market.view.feed.reply;

import android.graphics.Rect;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.model.Entity;
import com.coolapk.market.view.cardlist.EntityListDividerCallback;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/coolapk/market/view/feed/reply/FeedReplyListDividerCallback;", "Lcom/coolapk/market/view/cardlist/EntityListDividerCallback;", "dataList", "", "(Ljava/util/List;)V", "m44dp", "", "getM44dp", "()I", "getDrawRect", "", "outRect", "Landroid/graphics/Rect;", "position", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedReplyListDividerCallback.kt */
public class FeedReplyListDividerCallback extends EntityListDividerCallback {
    private final int m44dp = NumberExtendsKt.getDp((Number) 44);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedReplyListDividerCallback(List<?> list) {
        super(list);
        Intrinsics.checkNotNullParameter(list, "dataList");
    }

    public final int getM44dp() {
        return this.m44dp;
    }

    @Override // com.coolapk.market.view.cardlist.EntityListDividerCallback, com.coolapk.market.widget.decoration.CustomizedItemDecoration.Callback
    public void getDrawRect(Rect rect, int i) {
        Intrinsics.checkNotNullParameter(rect, "outRect");
        Object orNull = CollectionsKt.getOrNull(getDataList$presentation_coolapkAppRelease(), i);
        Entity entity = null;
        if (!(orNull instanceof Entity)) {
            orNull = null;
        }
        Entity entity2 = (Entity) orNull;
        if (entity2 != null) {
            Object orNull2 = CollectionsKt.getOrNull(getDataList$presentation_coolapkAppRelease(), i + 1);
            if (orNull2 instanceof Entity) {
                entity = orNull2;
            }
            Entity entity3 = entity;
            if (entity3 == null) {
                super.getDrawRect(rect, i);
            } else if (EntityExtendsKt.getCardDividerBottom(entity2) != Integer.MIN_VALUE) {
                super.getDrawRect(rect, i);
            } else if (EntityExtendsKt.getCardDividerTop(entity3) != Integer.MIN_VALUE) {
                super.getDrawRect(rect, i);
            } else {
                String uniqueType = EntityExtendsKt.uniqueType(entity2);
                String uniqueType2 = EntityExtendsKt.uniqueType(entity3);
                if (Intrinsics.areEqual(uniqueType, "user") && Intrinsics.areEqual(uniqueType2, "user")) {
                    rect.set(this.m44dp, 0, 0, getM1dp());
                } else if (Intrinsics.areEqual(uniqueType, "forwardFeed") && Intrinsics.areEqual(uniqueType2, "forwardFeed")) {
                    rect.set(this.m44dp, 0, 0, getM1dp());
                } else if (Intrinsics.areEqual(uniqueType, "feed_reply") && Intrinsics.areEqual(uniqueType2, "feed_reply")) {
                    rect.set(getM16dp(), 0, getM16dp(), getM1dp());
                } else if (Intrinsics.areEqual(uniqueType, "sponsorCard")) {
                    rect.set(0, 0, 0, getM8dp());
                } else if (Intrinsics.areEqual(uniqueType2, "sponsorCard")) {
                    rect.set(0, 0, 0, getM8dp());
                } else if (Intrinsics.areEqual(uniqueType2, "NO_MORE_DATA")) {
                    rect.set(0, 0, 0, getM1dp());
                } else if (Intrinsics.areEqual(uniqueType, "COMMENT_COUNT")) {
                    rect.set(0, 0, 0, getM8dp());
                } else if (Intrinsics.areEqual(uniqueType2, "COMMENT_COUNT")) {
                    rect.set(0, 0, 0, getM8dp());
                } else if (Intrinsics.areEqual(uniqueType2, "SMALL_HOT_TITLE")) {
                    rect.set(0, 0, 0, getM8dp());
                } else if (Intrinsics.areEqual(uniqueType2, "SMALL_CURRENT_TITLE")) {
                    rect.set(0, 0, 0, getM8dp());
                } else if (Intrinsics.areEqual(uniqueType2, "SMALL_NEWEST_TITLE")) {
                    rect.set(0, 0, 0, getM8dp());
                } else if (Intrinsics.areEqual(uniqueType2, "ENTITY_TYPE_SHARE_ACTION")) {
                    rect.set(getM16dp(), 0, getM16dp(), getM1dp());
                } else if (Intrinsics.areEqual(uniqueType2, "REPLY_HOT_ACTION")) {
                    rect.set(0, 0, 0, getM1dp());
                } else if (Intrinsics.areEqual(uniqueType, "SMALL_HOT_TITLE")) {
                    rect.set(0, 0, 0, getM1dp());
                } else if (Intrinsics.areEqual(uniqueType, "SMALL_CURRENT_TITLE")) {
                    rect.set(0, 0, 0, getM1dp());
                } else if (Intrinsics.areEqual(uniqueType, "SMALL_NEWEST_TITLE")) {
                    rect.set(0, 0, 0, getM1dp());
                } else if (Intrinsics.areEqual(uniqueType, "REPLY_HOT_ACTION")) {
                    rect.set(0, 0, 0, getM8dp());
                } else if (Intrinsics.areEqual(uniqueType, "ARTICLE_FEED_TOP")) {
                    rect.set(0, 0, 0, 0);
                } else if (Intrinsics.areEqual(uniqueType, "ARTICLE_ANSWER_TOP")) {
                    rect.set(0, 0, 0, 0);
                } else {
                    super.getDrawRect(rect, i);
                }
            }
        } else {
            super.getDrawRect(rect, i);
        }
    }
}
