package com.coolapk.market.view.cardlist;

import android.graphics.Rect;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.widget.decoration.CustomizedItemDecoration;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0013\u001a\u00020\bH\u0016J\u0018\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0014J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\bH\u0016J\b\u0010\u001d\u001a\u00020\bH\u0016R\u0018\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\r\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u0011\u0010\u000f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\nR\u0011\u0010\u0011\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\n¨\u0006\u001e"}, d2 = {"Lcom/coolapk/market/view/cardlist/EntityListDividerCallback;", "Lcom/coolapk/market/widget/decoration/CustomizedItemDecoration$SimpleCallback;", "dataList", "", "(Ljava/util/List;)V", "getDataList$presentation_coolapkAppRelease", "()Ljava/util/List;", "m10dp", "", "getM10dp", "()I", "m12dp", "getM12dp", "m16dp", "getM16dp", "m1dp", "getM1dp", "m8dp", "getM8dp", "getBottomDividerHeight", "getDividerHeight", "entity", "Lcom/coolapk/market/model/Entity;", "nextEntity", "getDrawRect", "", "outRect", "Landroid/graphics/Rect;", "position", "getTopDividerHeight", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: EntityListDividerCallback.kt */
public class EntityListDividerCallback extends CustomizedItemDecoration.SimpleCallback {
    private final List<?> dataList;
    private final int m10dp = NumberExtendsKt.getDp((Number) 10);
    private final int m12dp = NumberExtendsKt.getDp((Number) 12);
    private final int m16dp = NumberExtendsKt.getDp((Number) 16);
    private final int m1dp = getThinDividerHeight();
    private final int m8dp = getNormalDividerHeight();

    public EntityListDividerCallback(List<?> list) {
        Intrinsics.checkNotNullParameter(list, "dataList");
        this.dataList = list;
    }

    public final List<?> getDataList$presentation_coolapkAppRelease() {
        return this.dataList;
    }

    public final int getM8dp() {
        return this.m8dp;
    }

    public final int getM1dp() {
        return this.m1dp;
    }

    public final int getM12dp() {
        return this.m12dp;
    }

    public final int getM10dp() {
        return this.m10dp;
    }

    public final int getM16dp() {
        return this.m16dp;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.coolapk.market.widget.decoration.CustomizedItemDecoration.Callback
    public void getDrawRect(Rect rect, int i) {
        Intrinsics.checkNotNullParameter(rect, "outRect");
        Object obj = this.dataList.get(i);
        Entity entity = null;
        if (!(obj instanceof Entity)) {
            obj = null;
        }
        Entity entity2 = (Entity) obj;
        Object orNull = CollectionsKt.getOrNull(this.dataList, i + 1);
        if (orNull != 0) {
            if (orNull instanceof Entity) {
                entity = orNull;
            }
            entity = entity;
        }
        if (entity2 == null || entity == null) {
            rect.set(0, 0, 0, 0);
        } else if (Intrinsics.areEqual(entity.getEntityType(), "NO_MORE_DATA")) {
            rect.set(0, 0, 0, this.m1dp);
        } else {
            int dividerHeight = getDividerHeight(entity2, entity);
            int i2 = i != CollectionsKt.getLastIndex(this.dataList) && dividerHeight == this.m1dp ? this.m12dp : 0;
            rect.set(i2, 0, i2, dividerHeight);
        }
    }

    @Override // com.coolapk.market.widget.decoration.CustomizedItemDecoration.SimpleCallback, com.coolapk.market.widget.decoration.CustomizedItemDecoration.Callback
    public int getBottomDividerHeight() {
        List<?> list = this.dataList;
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

    @Override // com.coolapk.market.widget.decoration.CustomizedItemDecoration.SimpleCallback, com.coolapk.market.widget.decoration.CustomizedItemDecoration.Callback
    public int getTopDividerHeight() {
        Object orNull = CollectionsKt.getOrNull(this.dataList, 0);
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

    protected int getDividerHeight(Entity entity, Entity entity2) {
        Integer entityFixed;
        Intrinsics.checkNotNullParameter(entity, "entity");
        Intrinsics.checkNotNullParameter(entity2, "nextEntity");
        int cardDividerBottom = EntityExtendsKt.getCardDividerBottom(entity);
        int cardDividerTop = EntityExtendsKt.getCardDividerTop(entity2);
        if (cardDividerBottom != Integer.MIN_VALUE) {
            return cardDividerBottom;
        }
        if (cardDividerTop != Integer.MIN_VALUE) {
            return cardDividerTop;
        }
        if (Intrinsics.areEqual(entity2.getEntityTemplate(), "sponsorCard")) {
            return this.m8dp;
        }
        if (Intrinsics.areEqual(entity.getEntityTemplate(), "sponsorCard")) {
            return this.m8dp;
        }
        if ((entity instanceof HolderItem) || (entity2 instanceof HolderItem)) {
            return 0;
        }
        Integer entityFixed2 = entity.getEntityFixed();
        if ((entityFixed2 != null && entityFixed2.intValue() == 1 && (entityFixed = entity2.getEntityFixed()) != null && entityFixed.intValue() == 1) || Intrinsics.areEqual(entity.getEntityTemplate(), "refreshCard") || Intrinsics.areEqual(entity2.getEntityTemplate(), "refreshCard")) {
            return 0;
        }
        if (Intrinsics.areEqual(entity.getEntityTemplate(), "imageTextCard")) {
            return this.m8dp;
        }
        if (Intrinsics.areEqual(entity2.getEntityTemplate(), "imageTextCard")) {
            return this.m8dp;
        }
        if (Intrinsics.areEqual(entity.getEntityTemplate(), "iconLargeScrollCard")) {
            return this.m8dp;
        }
        if (Intrinsics.areEqual(entity2.getEntityTemplate(), "iconLargeScrollCard")) {
            return this.m8dp;
        }
        if (Intrinsics.areEqual(entity.getEntityTemplate(), "headCard")) {
            return this.m8dp;
        }
        if (Intrinsics.areEqual(entity2.getEntityTemplate(), "headCard")) {
            return this.m8dp;
        }
        if (Intrinsics.areEqual(entity.getEntityTemplate(), "feedListCard")) {
            return this.m8dp;
        }
        if (Intrinsics.areEqual(entity2.getEntityTemplate(), "feedListCard")) {
            return this.m8dp;
        }
        if (Intrinsics.areEqual(entity.getEntityType(), "liveTopic") && Intrinsics.areEqual(entity2.getEntityTemplate(), "titleCard")) {
            return this.m12dp;
        }
        if (Intrinsics.areEqual(entity2.getEntityTemplate(), "titleCard")) {
            return this.m8dp;
        }
        if (Intrinsics.areEqual(entity.getEntityTemplate(), "titleCard")) {
            String description = entity.getDescription();
            if (!(description == null || description.length() == 0)) {
                return this.m8dp;
            }
        }
        if (Intrinsics.areEqual(entity.getEntityTemplate(), "iconTabLinkGridCard") || Intrinsics.areEqual(entity.getEntityTemplate(), "titleCard")) {
            return 0;
        }
        if (Intrinsics.areEqual(entity.getEntityTemplate(), "feedErshouSearch")) {
            return this.m1dp;
        }
        if (Intrinsics.areEqual(entity.getEntityType(), "feed")) {
            return this.m8dp;
        }
        if (Intrinsics.areEqual(entity2.getEntityType(), "feed")) {
            return this.m8dp;
        }
        if (Intrinsics.areEqual(entity.getEntityTemplate(), "feedReplyCard")) {
            return this.m8dp;
        }
        if (Intrinsics.areEqual(entity2.getEntityTemplate(), "feedReplyCard")) {
            return this.m8dp;
        }
        if (Intrinsics.areEqual(entity.getEntityTemplate(), "albumExpandCard")) {
            return this.m12dp;
        }
        if (Intrinsics.areEqual(entity2.getEntityTemplate(), "albumExpandCard")) {
            return this.m12dp;
        }
        if (Intrinsics.areEqual(entity.getEntityTemplate(), "feedCoolPictureGridCard") || Intrinsics.areEqual(entity2.getEntityTemplate(), "feedCoolPictureGridCard")) {
            return 0;
        }
        if (Intrinsics.areEqual(entity2.getEntityTemplate(), "articleListCard")) {
            return this.m8dp;
        }
        if (Intrinsics.areEqual(entity.getEntityTemplate(), "articleListCard")) {
            return this.m8dp;
        }
        if (Intrinsics.areEqual(entity2.getEntityTemplate(), "dyhArticle")) {
            return this.m8dp;
        }
        if (Intrinsics.areEqual(entity.getEntityTemplate(), "dyhArticle")) {
            return this.m8dp;
        }
        if (Intrinsics.areEqual(entity2.getEntityTemplate(), "articleFeed")) {
            return this.m8dp;
        }
        if (Intrinsics.areEqual(entity.getEntityTemplate(), "articleFeed")) {
            return this.m8dp;
        }
        if (Intrinsics.areEqual(entity2.getEntityTemplate(), "articleNews")) {
            return this.m8dp;
        }
        if (Intrinsics.areEqual(entity.getEntityTemplate(), "articleNews")) {
            return this.m8dp;
        }
        if (Intrinsics.areEqual(entity2.getEntityTemplate(), "articleItem")) {
            return this.m8dp;
        }
        if (Intrinsics.areEqual(entity.getEntityTemplate(), "articleItem")) {
            return this.m8dp;
        }
        if (Intrinsics.areEqual(entity.getEntityType(), "itemPlaceHolder")) {
            return this.m8dp;
        }
        if (Intrinsics.areEqual(entity2.getEntityType(), "itemPlaceHolder")) {
            return this.m8dp;
        }
        if (!Intrinsics.areEqual(entity.getEntityType(), "liveTopic") || EntityExtendsKt.getIntExtraData(entity, "cols", 1) != 1) {
            return this.m12dp;
        }
        return this.m10dp;
    }
}
