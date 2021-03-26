package com.coolapk.market.manager;

import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.model.Entity;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/coolapk/market/manager/MainInitHelper$loadMainInitInfo$1", "Lcom/coolapk/market/app/EmptySubscriber;", "", "Lcom/coolapk/market/model/Entity;", "onNext", "", "t", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: MainInitHelper.kt */
public final class MainInitHelper$loadMainInitInfo$1 extends EmptySubscriber<List<? extends Entity>> {
    MainInitHelper$loadMainInitInfo$1() {
    }

    public void onNext(List<? extends Entity> list) {
        super.onNext((MainInitHelper$loadMainInitInfo$1) list);
        if (list != null) {
            MainInitHelper.INSTANCE.onMainInitDataLoaded(list);
        }
    }
}
