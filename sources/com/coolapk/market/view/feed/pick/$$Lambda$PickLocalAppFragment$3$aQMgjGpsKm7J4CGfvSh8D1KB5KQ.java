package com.coolapk.market.view.feed.pick;

import com.coolapk.market.model.MobileApp;
import java.util.Comparator;

/* renamed from: com.coolapk.market.view.feed.pick.-$$Lambda$PickLocalAppFragment$3$aQMgjGpsKm7J4CGfvSh8D1KB5KQ  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$PickLocalAppFragment$3$aQMgjGpsKm7J4CGfvSh8D1KB5KQ implements Comparator {
    public static final /* synthetic */ $$Lambda$PickLocalAppFragment$3$aQMgjGpsKm7J4CGfvSh8D1KB5KQ INSTANCE = new $$Lambda$PickLocalAppFragment$3$aQMgjGpsKm7J4CGfvSh8D1KB5KQ();

    private /* synthetic */ $$Lambda$PickLocalAppFragment$3$aQMgjGpsKm7J4CGfvSh8D1KB5KQ() {
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return Long.signum(((MobileApp) obj2).getLastUpdateTime() - ((MobileApp) obj).getLastUpdateTime());
    }
}
