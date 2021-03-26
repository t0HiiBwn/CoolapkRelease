package com.coolapk.market.view.main;

import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.ServiceApp;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00060\u0003H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "ret", "", "Lcom/coolapk/market/model/Entity;", "kotlin.jvm.PlatformType", "", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: SceneRelatedAppsHelper.kt */
final class SceneRelatedAppsHelper$loadCard$1<T> implements Action1<List<Entity>> {
    final /* synthetic */ ServiceApp $app;
    final /* synthetic */ SceneRelatedAppsHelper this$0;

    SceneRelatedAppsHelper$loadCard$1(SceneRelatedAppsHelper sceneRelatedAppsHelper, ServiceApp serviceApp) {
        this.this$0 = sceneRelatedAppsHelper;
        this.$app = serviceApp;
    }

    public final void call(List<Entity> list) {
        this.this$0.currentEntityUniqueId = EntityExtendsKt.entityUniqueId(this.$app);
        SceneRelatedAppsHelper sceneRelatedAppsHelper = this.this$0;
        Intrinsics.checkNotNullExpressionValue(list, "ret");
        sceneRelatedAppsHelper.setCard((Entity) CollectionsKt.firstOrNull((List<? extends Object>) list));
    }
}
