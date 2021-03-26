package com.coolapk.market.view.feed.reply;

import com.coolapk.market.AppHolder;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.view.cardlist.divider.DividerData;
import com.coolapk.market.view.cardlist.divider.DividerRule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\r\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0005R\u0017\u0010\b\u001a\u00020\t*\u0004\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\b\b\u0010\u000bR\u0017\u0010\f\u001a\u00020\t*\u0004\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\b\f\u0010\u000b¨\u0006\u0012"}, d2 = {"com/coolapk/market/view/feed/reply/FeedArticleDetailFragment$onActivityCreated$12", "Lcom/coolapk/market/view/cardlist/divider/DividerRule;", "divider", "Lcom/coolapk/market/view/cardlist/divider/DividerData;", "getDivider", "()Lcom/coolapk/market/view/cardlist/divider/DividerData;", "largerDivider", "getLargerDivider", "isArticleModelButNotText", "", "", "(Ljava/lang/Object;)Z", "isArticleModelText", "getDividerData", "rawPosition", "", "current", "next", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedArticleDetailFragment.kt */
public final class FeedArticleDetailFragment$onActivityCreated$12 implements DividerRule {
    private final DividerData divider = DividerData.Companion.createImmutable(0, 0, NumberExtendsKt.getDp((Number) 12), Integer.valueOf(AppHolder.getAppTheme().getContentBackgroundColor()));
    private final DividerData largerDivider = DividerData.Companion.createImmutable(0, 0, NumberExtendsKt.getDp((Number) 24), Integer.valueOf(AppHolder.getAppTheme().getContentBackgroundColor()));

    FeedArticleDetailFragment$onActivityCreated$12() {
    }

    public final boolean isArticleModelButNotText(Object obj) {
        if (obj instanceof HolderItem) {
            HolderItem holderItem = (HolderItem) obj;
            String entityType = holderItem.getEntityType();
            Intrinsics.checkNotNullExpressionValue(entityType, "this.entityType");
            if (StringsKt.startsWith$default(entityType, "article", false, 2, (Object) null) && (!Intrinsics.areEqual(holderItem.getEntityType(), "article_text"))) {
                return true;
            }
        }
        return false;
    }

    public final boolean isArticleModelText(Object obj) {
        return (obj instanceof HolderItem) && Intrinsics.areEqual(((HolderItem) obj).getEntityType(), "article_text");
    }

    public final DividerData getDivider() {
        return this.divider;
    }

    public final DividerData getLargerDivider() {
        return this.largerDivider;
    }

    @Override // com.coolapk.market.view.cardlist.divider.DividerRule
    public DividerData getDividerData(int i, Object obj, Object obj2) {
        if (isArticleModelButNotText(obj) && isArticleModelButNotText(obj2)) {
            return this.largerDivider;
        }
        if (isArticleModelButNotText(obj) && isArticleModelText(obj2)) {
            return this.divider;
        }
        if (!isArticleModelText(obj) || !isArticleModelButNotText(obj2)) {
            return null;
        }
        return this.divider;
    }
}
