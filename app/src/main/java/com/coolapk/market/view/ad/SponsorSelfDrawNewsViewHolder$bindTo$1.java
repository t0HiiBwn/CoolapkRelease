package com.coolapk.market.view.ad;

import android.view.View;
import com.coolapk.market.model.Entity;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: SponsorSelfDrawNewsViewHolder.kt */
final class SponsorSelfDrawNewsViewHolder$bindTo$1 implements View.OnClickListener {
    final /* synthetic */ Object $data;
    final /* synthetic */ SponsorSelfDrawNewsViewHolder this$0;

    SponsorSelfDrawNewsViewHolder$bindTo$1(SponsorSelfDrawNewsViewHolder sponsorSelfDrawNewsViewHolder, Object obj) {
        this.this$0 = sponsorSelfDrawNewsViewHolder;
        this.$data = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        EntityAdHelper access$getEntityAdHelper$p = SponsorSelfDrawNewsViewHolder.access$getEntityAdHelper$p(this.this$0);
        String entityId = ((Entity) this.$data).getEntityId();
        if (entityId == null) {
            entityId = "";
        }
        access$getEntityAdHelper$p.requestCloseAd(entityId, this.this$0.getAdapterPosition());
    }
}
