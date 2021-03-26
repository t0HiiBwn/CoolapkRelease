package com.coolapk.market.view.feed.reply;

import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.model.Entity;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/coolapk/market/model/Entity;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedReplyPresenter.kt */
final class FeedReplyPresenter$markDataResult$1$1$1 extends Lambda implements Function1<Entity, Boolean> {
    final /* synthetic */ Map $dataMap;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedReplyPresenter$markDataResult$1$1$1(Map map) {
        super(1);
        this.$dataMap = map;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Entity entity) {
        return Boolean.valueOf(invoke(entity));
    }

    public final boolean invoke(Entity entity) {
        Intrinsics.checkNotNullParameter(entity, "it");
        return this.$dataMap.containsKey(EntityExtendsKt.entityUniqueId(entity));
    }
}
