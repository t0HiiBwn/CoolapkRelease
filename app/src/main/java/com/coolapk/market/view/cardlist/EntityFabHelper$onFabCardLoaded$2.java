package com.coolapk.market.view.cardlist;

import android.content.Context;
import android.view.View;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.model.Entity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: EntityFabHelper.kt */
final class EntityFabHelper$onFabCardLoaded$2 implements View.OnClickListener {
    final /* synthetic */ Context $context;
    final /* synthetic */ Entity $entity;

    EntityFabHelper$onFabCardLoaded$2(Context context, Entity entity) {
        this.$context = context;
        this.$entity = entity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context = this.$context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Entity entity = this.$entity;
        Intrinsics.checkNotNullExpressionValue(entity, "entity");
        String url = entity.getUrl();
        Entity entity2 = this.$entity;
        Intrinsics.checkNotNullExpressionValue(entity2, "entity");
        String title = entity2.getTitle();
        Entity entity3 = this.$entity;
        Intrinsics.checkNotNullExpressionValue(entity3, "entity");
        ActionManagerCompat.startActivityByUrl(context, url, title, entity3.getSubTitle());
    }
}
