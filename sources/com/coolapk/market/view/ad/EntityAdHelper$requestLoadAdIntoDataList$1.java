package com.coolapk.market.view.ad;

import android.os.Parcelable;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.view.ad.EntityAdHelper;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/coolapk/market/view/ad/EntityAdHelper$requestLoadAdIntoDataList$1", "Lcom/coolapk/market/view/ad/EntityAdHelper$AdViewHolderCallback;", "onAdLoadSuccess", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: EntityAdHelper.kt */
public final class EntityAdHelper$requestLoadAdIntoDataList$1 implements EntityAdHelper.AdViewHolderCallback {
    final /* synthetic */ Parcelable $anchor;
    final /* synthetic */ Entity $card;
    final /* synthetic */ Parcelable $nextAnchor;
    final /* synthetic */ EntityAdHelper this$0;

    EntityAdHelper$requestLoadAdIntoDataList$1(EntityAdHelper entityAdHelper, Parcelable parcelable, Entity entity, Parcelable parcelable2) {
        this.this$0 = entityAdHelper;
        this.$anchor = parcelable;
        this.$card = entity;
        this.$nextAnchor = parcelable2;
    }

    @Override // com.coolapk.market.view.ad.EntityAdHelper.AdViewHolderCallback
    public int getPositionInDataList() {
        return EntityAdHelper.AdViewHolderCallback.DefaultImpls.getPositionInDataList(this);
    }

    @Override // com.coolapk.market.view.ad.EntityAdHelper.AdViewHolderCallback
    public void onAdBan(AdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        EntityAdHelper.AdViewHolderCallback.DefaultImpls.onAdBan(this, adInfo);
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
    public void onAdLoadSuccess() {
        int indexOf;
        List<Parcelable> dataList = EntityAdHelper.access$getFragment$p(this.this$0).getDataList();
        int indexOf2 = dataList.indexOf(this.$anchor);
        Iterator<Parcelable> it2 = dataList.iterator();
        boolean z = false;
        int i = 0;
        while (true) {
            if (!it2.hasNext()) {
                i = -1;
                break;
            }
            Parcelable next = it2.next();
            if ((next instanceof EntityCard) && Intrinsics.areEqual(((EntityCard) next).getEntityTemplate(), this.$card.getEntityTemplate()) && Intrinsics.areEqual(EntityExtendsKt.entityUniqueId((Entity) next), EntityExtendsKt.entityUniqueId(this.$card))) {
                break;
            }
            i++;
        }
        Integer valueOf = Integer.valueOf(i);
        if (valueOf.intValue() >= 0) {
            z = true;
        }
        if (!z) {
            valueOf = null;
        }
        if (indexOf2 < 0) {
            Parcelable parcelable = this.$nextAnchor;
            if (parcelable == null || (indexOf = dataList.indexOf(parcelable)) <= 0) {
                return;
            }
            if (valueOf == null) {
                dataList.add(indexOf, this.$card);
            } else if (valueOf.intValue() == indexOf) {
                dataList.set(valueOf.intValue(), this.$card);
            } else {
                dataList.remove(valueOf.intValue());
                if (dataList.indexOf(this.$nextAnchor) >= 0) {
                    dataList.add(indexOf, this.$card);
                }
            }
        } else if (valueOf == null) {
            dataList.add(indexOf2 + 1, this.$card);
        } else if (valueOf.intValue() == indexOf2 + 1) {
            dataList.set(valueOf.intValue(), this.$card);
        } else {
            dataList.remove(valueOf.intValue());
            int indexOf3 = dataList.indexOf(this.$anchor);
            if (indexOf3 >= 0) {
                dataList.add(indexOf3 + 1, this.$card);
            }
        }
    }
}
