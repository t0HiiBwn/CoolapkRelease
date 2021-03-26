package com.coolapk.market.view.ad;

import android.os.Parcelable;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.view.ad.EntityAdHelper;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"com/coolapk/market/view/ad/EntityAdHelper$modifyData$1", "Lcom/coolapk/market/view/ad/EntityAdHelper$AdViewHolderCallback;", "onAdBan", "", "adInfo", "Lcom/coolapk/market/view/ad/AdInfo;", "onAdLoadSuccess", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: EntityAdHelper.kt */
public final class EntityAdHelper$modifyData$1 implements EntityAdHelper.AdViewHolderCallback {
    final /* synthetic */ Entity $card;
    final /* synthetic */ EntityAdHelper this$0;

    @Override // com.coolapk.market.view.ad.EntityAdHelper.AdViewHolderCallback
    public void onAdLoadSuccess() {
    }

    EntityAdHelper$modifyData$1(EntityAdHelper entityAdHelper, Entity entity) {
        this.this$0 = entityAdHelper;
        this.$card = entity;
    }

    @Override // com.coolapk.market.view.ad.EntityAdHelper.AdViewHolderCallback
    public int getPositionInDataList() {
        return EntityAdHelper.AdViewHolderCallback.DefaultImpls.getPositionInDataList(this);
    }

    @Override // com.coolapk.market.view.ad.EntityAdHelper.AdViewHolderCallback
    public void onAdClose() {
        EntityAdHelper.AdViewHolderCallback.DefaultImpls.onAdClose(this);
    }

    @Override // com.coolapk.market.view.ad.EntityAdHelper.AdViewHolderCallback
    public void onAdLoadFail() {
        EntityAdHelper.AdViewHolderCallback.DefaultImpls.onAdLoadFail(this);
    }

    @Override // com.coolapk.market.view.ad.EntityAdHelper.AdViewHolderCallback
    public void onAdBan(AdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        String entityUniqueId = EntityExtendsKt.entityUniqueId(this.$card);
        Iterator<Parcelable> it2 = EntityAdHelper.access$getFragment$p(this.this$0).getDataList().iterator();
        int i = 0;
        while (true) {
            if (!it2.hasNext()) {
                i = -1;
                break;
            }
            Parcelable next = it2.next();
            if ((next instanceof EntityCard) && Intrinsics.areEqual(((EntityCard) next).getEntityTemplate(), "sponsorCard") && Intrinsics.areEqual(EntityExtendsKt.entityUniqueId((Entity) next), entityUniqueId)) {
                break;
            }
            i++;
        }
        if (i >= 0) {
            this.this$0.requestCloseAd(entityUniqueId, i);
        }
    }
}
