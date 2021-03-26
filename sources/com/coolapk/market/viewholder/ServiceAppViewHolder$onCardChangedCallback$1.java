package com.coolapk.market.viewholder;

import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.model.Entity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "id", "", "card", "Lcom/coolapk/market/model/Entity;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: ServiceAppViewHolder.kt */
final class ServiceAppViewHolder$onCardChangedCallback$1 extends Lambda implements Function2<String, Entity, Unit> {
    final /* synthetic */ ServiceAppViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ServiceAppViewHolder$onCardChangedCallback$1(ServiceAppViewHolder serviceAppViewHolder) {
        super(2);
        this.this$0 = serviceAppViewHolder;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(String str, Entity entity) {
        invoke(str, entity);
        return Unit.INSTANCE;
    }

    public final void invoke(String str, Entity entity) {
        if (!Intrinsics.areEqual(str, EntityExtendsKt.entityUniqueId(ServiceAppViewHolder.access$getServiceApp$p(this.this$0))) || entity == null) {
            this.this$0.sceneRelatedAppsViewPartHotPlug.onRecycled();
        } else {
            this.this$0.sceneRelatedAppsViewPartHotPlug.bindTo(ServiceAppViewHolder.access$getServiceApp$p(this.this$0));
        }
    }
}
