package com.coolapk.market.view.cardlist.divider;

import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.model.Entity;
import com.coolapk.market.view.cardlist.divider.DividerData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0018\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f¨\u0006\u000e"}, d2 = {"Lcom/coolapk/market/view/cardlist/divider/FeedListDividerRule;", "Lcom/coolapk/market/view/cardlist/divider/DividerRule;", "()V", "getDividerData", "Lcom/coolapk/market/view/cardlist/divider/DividerData;", "rawPosition", "", "current", "", "next", "getDividerHeight", "entity", "Lcom/coolapk/market/model/Entity;", "nextEntity", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: EntityListDividerRule.kt */
public final class FeedListDividerRule implements DividerRule {
    @Override // com.coolapk.market.view.cardlist.divider.DividerRule
    public DividerData getDividerData(int i, Object obj, Object obj2) {
        if (!(obj instanceof Entity) || !(obj2 instanceof Entity)) {
            return null;
        }
        return getDividerHeight((Entity) obj, (Entity) obj2);
    }

    public final DividerData getDividerHeight(Entity entity, Entity entity2) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        Intrinsics.checkNotNullParameter(entity2, "nextEntity");
        int cardDividerBottom = EntityExtendsKt.getCardDividerBottom(entity);
        int cardDividerTop = EntityExtendsKt.getCardDividerTop(entity2);
        String uniqueType = EntityExtendsKt.uniqueType(entity);
        String uniqueType2 = EntityExtendsKt.uniqueType(entity2);
        if (cardDividerBottom != Integer.MIN_VALUE) {
            return DividerData.Companion.obtain$default(DividerData.Companion, 0, 0, cardDividerBottom, null, 11, null);
        }
        if (cardDividerTop != Integer.MIN_VALUE) {
            return DividerData.Companion.obtain$default(DividerData.Companion, 0, 0, cardDividerTop, null, 11, null);
        }
        if (Intrinsics.areEqual(uniqueType, "user") && Intrinsics.areEqual(uniqueType2, "user")) {
            return DividerData.Companion.getL44H1DP();
        }
        if (Intrinsics.areEqual(uniqueType, "forwardFeed") && Intrinsics.areEqual(uniqueType2, "forwardFeed")) {
            return DividerData.Companion.getL44H1DP();
        }
        if (Intrinsics.areEqual(uniqueType, "feed_reply") && Intrinsics.areEqual(uniqueType2, "feed_reply")) {
            return DividerData.Companion.getEMPTY();
        }
        if (Intrinsics.areEqual(uniqueType, "sponsorCard")) {
            return DividerData.H8DP;
        }
        if (Intrinsics.areEqual(uniqueType2, "sponsorCard")) {
            return DividerData.H8DP;
        }
        if (Intrinsics.areEqual(uniqueType2, "NO_MORE_DATA")) {
            return DividerData.Companion.getH1DP();
        }
        if (Intrinsics.areEqual(uniqueType, "COMMENT_COUNT")) {
            return DividerData.H8DP;
        }
        if (Intrinsics.areEqual(uniqueType2, "COMMENT_COUNT")) {
            return DividerData.H8DP;
        }
        if (Intrinsics.areEqual(uniqueType2, "SMALL_HOT_TITLE")) {
            return DividerData.H8DP;
        }
        if (Intrinsics.areEqual(uniqueType2, "SMALL_CURRENT_TITLE")) {
            return DividerData.H8DP;
        }
        if (Intrinsics.areEqual(uniqueType2, "SMALL_NEWEST_TITLE")) {
            return DividerData.H8DP;
        }
        if (Intrinsics.areEqual(uniqueType2, "ENTITY_TYPE_SHARE_ACTION")) {
            return DividerData.Companion.getEMPTY();
        }
        if (Intrinsics.areEqual(uniqueType2, "REPLY_HOT_ACTION")) {
            return DividerData.Companion.getEMPTY();
        }
        if (Intrinsics.areEqual(uniqueType, "SMALL_HOT_TITLE")) {
            return DividerData.Companion.getEMPTY();
        }
        if (Intrinsics.areEqual(uniqueType, "SMALL_CURRENT_TITLE")) {
            return DividerData.Companion.getEMPTY();
        }
        if (Intrinsics.areEqual(uniqueType, "SMALL_NEWEST_TITLE")) {
            return DividerData.Companion.getEMPTY();
        }
        if (Intrinsics.areEqual(uniqueType, "REPLY_HOT_ACTION")) {
            return DividerData.H8DP;
        }
        if (Intrinsics.areEqual(uniqueType, "ARTICLE_FEED_TOP")) {
            return DividerData.Companion.getEMPTY();
        }
        if (Intrinsics.areEqual(uniqueType, "ARTICLE_ANSWER_TOP")) {
            return DividerData.Companion.getEMPTY();
        }
        return null;
    }
}
