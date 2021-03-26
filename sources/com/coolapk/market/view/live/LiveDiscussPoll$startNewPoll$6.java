package com.coolapk.market.view.live;

import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.LiveMessage;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "result", "", "Lcom/coolapk/market/model/Entity;", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: LiveDiscussPoll.kt */
final class LiveDiscussPoll$startNewPoll$6<T> implements Action1<List<? extends Entity>> {
    final /* synthetic */ LiveDiscussPoll this$0;

    LiveDiscussPoll$startNewPoll$6(LiveDiscussPoll liveDiscussPoll) {
        this.this$0 = liveDiscussPoll;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0058 A[SYNTHETIC] */
    public final void call(List<? extends Entity> list) {
        boolean z;
        LiveDiscussPollKt.liveDiscussPollLogI("一次轮询完成, Size: " + list.size());
        this.this$0.isPolling.set(false);
        LiveDiscussPoll liveDiscussPoll = this.this$0;
        Intrinsics.checkNotNullExpressionValue(list, "result");
        Entity entity = liveDiscussPoll.findFirstLiveEntity(list);
        if (entity != null) {
            this.this$0.latestLiveEntity = entity;
        }
        this.this$0.setLatestDataList(list);
        LiveDiscussPollCallback callback = this.this$0.getCallback();
        if (callback != null) {
            callback.onDataLoaded(list);
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        ArrayList arrayList = new ArrayList();
        for (T t : list) {
            T t2 = t;
            if (t2 instanceof LiveMessage) {
                Long dateline = t2.getDateline();
                if (dateline == null) {
                    dateline = 0L;
                }
                Intrinsics.checkNotNullExpressionValue(dateline, "it.dateline ?: 0");
                if (currentTimeMillis - dateline.longValue() <= ((long) 15)) {
                    z = true;
                    if (!z) {
                        arrayList.add(t);
                    }
                }
            }
            z = false;
            if (!z) {
            }
        }
        HashSet hashSet = new HashSet();
        ArrayList arrayList2 = new ArrayList();
        for (T t3 : arrayList) {
            if (hashSet.add(EntityExtendsKt.entityUniqueId(t3))) {
                arrayList2.add(t3);
            }
        }
        this.this$0.bubbleMessenger.input(CollectionsKt.reversed(arrayList2));
    }
}
