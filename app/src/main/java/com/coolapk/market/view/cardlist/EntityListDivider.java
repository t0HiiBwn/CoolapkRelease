package com.coolapk.market.view.cardlist;

import android.content.Context;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.widget.decoration.PaddingDividerItemDecoration;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0002\u0010\u0006R\u001e\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/coolapk/market/view/cardlist/EntityListDivider;", "Lcom/coolapk/market/widget/decoration/PaddingDividerItemDecoration;", "context", "Landroid/content/Context;", "dataList", "", "(Landroid/content/Context;Ljava/util/List;)V", "getDataList", "()Ljava/util/List;", "setDataList", "(Ljava/util/List;)V", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: EntityListDivider.kt */
public final class EntityListDivider extends PaddingDividerItemDecoration {
    private List<?> dataList;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EntityListDivider(Context context, final List<?> list) {
        super(new PaddingDividerItemDecoration.SimpleCallBack(context, context) {
            /* class com.coolapk.market.view.cardlist.EntityListDivider.AnonymousClass1 */
            final /* synthetic */ Context $context;

            {
                this.$context = r2;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r7v2, resolved type: java.lang.Object */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.SimpleCallBack, com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.CallBack
            public int getDividerHeight(int i) {
                Integer entityFixed;
                Object obj = list.get(i);
                Entity entity = null;
                if (!(obj instanceof Entity)) {
                    obj = null;
                }
                Entity entity2 = (Entity) obj;
                boolean z = true;
                Object orNull = CollectionsKt.getOrNull(list, i + 1);
                if (orNull != 0) {
                    if (orNull instanceof Entity) {
                        entity = orNull;
                    }
                    entity = entity;
                }
                if (entity2 == null || entity == null) {
                    return 0;
                }
                int cardDividerBottom = EntityExtendsKt.getCardDividerBottom(entity2);
                int cardDividerTop = EntityExtendsKt.getCardDividerTop(entity);
                if (cardDividerBottom != Integer.MIN_VALUE) {
                    return cardDividerBottom;
                }
                if (cardDividerTop != Integer.MIN_VALUE) {
                    return cardDividerTop;
                }
                if ((entity2 instanceof HolderItem) || (entity instanceof HolderItem)) {
                    return 0;
                }
                Integer entityFixed2 = entity2.getEntityFixed();
                if ((entityFixed2 != null && entityFixed2.intValue() == 1 && (entityFixed = entity.getEntityFixed()) != null && entityFixed.intValue() == 1) || Intrinsics.areEqual(entity2.getEntityTemplate(), "refreshCard") || Intrinsics.areEqual(entity.getEntityTemplate(), "refreshCard")) {
                    return 0;
                }
                if (Intrinsics.areEqual(entity2.getEntityTemplate(), "imageTextCard")) {
                    return this.m8dp;
                }
                if (Intrinsics.areEqual(entity.getEntityTemplate(), "imageTextCard")) {
                    return this.m8dp;
                }
                if (Intrinsics.areEqual(entity2.getEntityTemplate(), "iconLargeScrollCard")) {
                    return this.m8dp;
                }
                if (Intrinsics.areEqual(entity.getEntityTemplate(), "iconLargeScrollCard")) {
                    return this.m8dp;
                }
                if (Intrinsics.areEqual(entity2.getEntityTemplate(), "headCard")) {
                    return this.m8dp;
                }
                if (Intrinsics.areEqual(entity.getEntityTemplate(), "headCard")) {
                    return this.m8dp;
                }
                if (Intrinsics.areEqual(entity2.getEntityTemplate(), "feedListCard")) {
                    return this.m8dp;
                }
                if (Intrinsics.areEqual(entity.getEntityTemplate(), "feedListCard")) {
                    return this.m8dp;
                }
                if (Intrinsics.areEqual(entity.getEntityTemplate(), "titleCard")) {
                    return this.m8dp;
                }
                if (Intrinsics.areEqual(entity.getEntityTemplate(), "smallFeedRating")) {
                    return 0;
                }
                if (Intrinsics.areEqual(entity2.getEntityTemplate(), "titleCard")) {
                    String description = entity2.getDescription();
                    if (!(description == null || description.length() == 0)) {
                        z = false;
                    }
                    if (!z) {
                        return this.m8dp;
                    }
                }
                if (Intrinsics.areEqual(entity2.getEntityTemplate(), "iconTabLinkGridCard") || Intrinsics.areEqual(entity2.getEntityTemplate(), "titleCard")) {
                    return 0;
                }
                if (Intrinsics.areEqual(entity2.getEntityType(), "feed")) {
                    return this.m8dp;
                }
                if (Intrinsics.areEqual(entity.getEntityType(), "feed")) {
                    return this.m8dp;
                }
                if (Intrinsics.areEqual(entity2.getEntityTemplate(), "feedReplyCard")) {
                    return this.m8dp;
                }
                if (Intrinsics.areEqual(entity.getEntityTemplate(), "feedReplyCard")) {
                    return this.m8dp;
                }
                if (Intrinsics.areEqual(entity2.getEntityTemplate(), "albumExpandCard")) {
                    return this.m12dp;
                }
                if (Intrinsics.areEqual(entity.getEntityTemplate(), "albumExpandCard")) {
                    return this.m12dp;
                }
                if (Intrinsics.areEqual(entity2.getEntityTemplate(), "feedCoolPictureGridCard") || Intrinsics.areEqual(entity.getEntityTemplate(), "feedCoolPictureGridCard")) {
                    return 0;
                }
                if (Intrinsics.areEqual(entity.getEntityTemplate(), "articleListCard")) {
                    return this.m8dp;
                }
                if (Intrinsics.areEqual(entity2.getEntityTemplate(), "articleListCard")) {
                    return this.m8dp;
                }
                if (Intrinsics.areEqual(entity.getEntityTemplate(), "dyhArticle")) {
                    return this.m8dp;
                }
                if (Intrinsics.areEqual(entity2.getEntityTemplate(), "dyhArticle")) {
                    return this.m8dp;
                }
                if (Intrinsics.areEqual(entity.getEntityTemplate(), "articleFeed")) {
                    return this.m8dp;
                }
                if (Intrinsics.areEqual(entity2.getEntityTemplate(), "articleFeed")) {
                    return this.m8dp;
                }
                if (Intrinsics.areEqual(entity.getEntityTemplate(), "articleNews")) {
                    return this.m8dp;
                }
                if (Intrinsics.areEqual(entity2.getEntityTemplate(), "articleNews")) {
                    return this.m8dp;
                }
                if (Intrinsics.areEqual(entity.getEntityTemplate(), "articleItem")) {
                    return this.m8dp;
                }
                if (Intrinsics.areEqual(entity2.getEntityTemplate(), "articleItem")) {
                    return this.m8dp;
                }
                return this.m1dp;
            }

            @Override // com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.SimpleCallBack, com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.CallBack
            public int getFirstHeight() {
                Object orNull = CollectionsKt.getOrNull(list, 0);
                if (!(orNull instanceof Entity)) {
                    orNull = null;
                }
                Entity entity = (Entity) orNull;
                if (entity == null) {
                    return 0;
                }
                int cardDividerTop = EntityExtendsKt.getCardDividerTop(entity);
                if (cardDividerTop != Integer.MIN_VALUE) {
                    return cardDividerTop;
                }
                return 0;
            }

            @Override // com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.SimpleCallBack, com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.CallBack
            public int getLastHeight() {
                List list = list;
                Object orNull = CollectionsKt.getOrNull(list, CollectionsKt.getLastIndex(list));
                if (!(orNull instanceof Entity)) {
                    orNull = null;
                }
                Entity entity = (Entity) orNull;
                if (entity == null) {
                    return 0;
                }
                int cardDividerBottom = EntityExtendsKt.getCardDividerBottom(entity);
                if (cardDividerBottom != Integer.MIN_VALUE) {
                    return cardDividerBottom;
                }
                return 0;
            }

            @Override // com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.CallBack
            public int getItemCount() {
                return list.size();
            }

            @Override // com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.SimpleCallBack, com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.CallBack
            public boolean hasPadding(int i) {
                return i != getItemCount() - 1 && getDividerHeight(i) == this.m1dp;
            }

            @Override // com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.SimpleCallBack, com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.CallBack
            public int getPaddingLeft() {
                return this.m12dp;
            }

            @Override // com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.SimpleCallBack, com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.CallBack
            public int getPaddingRight() {
                return this.m12dp;
            }
        });
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list, "dataList");
        this.dataList = list;
    }

    public final List<?> getDataList() {
        return this.dataList;
    }

    public final void setDataList(List<?> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.dataList = list;
    }
}
