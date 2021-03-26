package com.coolapk.market.view.cardlist;

import android.text.TextUtils;
import com.coolapk.market.model.DyhArticle;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.UserAction;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"doAction", "Lcom/coolapk/market/model/Entity;", "entity", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: EntityListFragment.kt */
final class EntityListFragment$changeDyhArticle$1 extends Lambda implements Function1<Entity, Entity> {
    final /* synthetic */ int $action;
    final /* synthetic */ int $actionNum;
    final /* synthetic */ int $actionType;
    final /* synthetic */ String $id;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EntityListFragment$changeDyhArticle$1(String str, int i, int i2, int i3) {
        super(1);
        this.$id = str;
        this.$actionType = i;
        this.$action = i2;
        this.$actionNum = i3;
    }

    public final Entity invoke(Entity entity) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        if (!(entity instanceof DyhArticle)) {
            return null;
        }
        DyhArticle dyhArticle = (DyhArticle) entity;
        if (!TextUtils.equals(dyhArticle.getId(), this.$id)) {
            return null;
        }
        DyhArticle.Builder newBuilder = DyhArticle.newBuilder(dyhArticle);
        UserAction.Builder newBuilder2 = UserAction.newBuilder(dyhArticle.getUserAction());
        int i = this.$actionType;
        if (i == 0) {
            newBuilder2.like(this.$action);
            newBuilder.likeNum(this.$actionNum);
        } else if (i == 1) {
            newBuilder2.collect(this.$action);
            newBuilder.favNum(this.$actionNum);
        }
        return newBuilder.userAction(newBuilder2.build()).build();
    }
}
