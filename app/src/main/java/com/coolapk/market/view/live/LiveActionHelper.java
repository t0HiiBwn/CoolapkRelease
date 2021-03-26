package com.coolapk.market.view.live;

import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.LiveMessage;
import com.coolapk.market.view.cardlist.EntityDataFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0016\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¨\u0006\f"}, d2 = {"Lcom/coolapk/market/view/live/LiveActionHelper;", "Lcom/coolapk/market/view/cardlist/EntityDataFilter;", "()V", "modifyData", "", "Lcom/coolapk/market/model/Entity;", "list", "isRefresh", "", "onLiveAction", "", "data", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: LiveActionHelper.kt */
public final class LiveActionHelper extends EntityDataFilter {
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.util.List<? extends com.coolapk.market.model.Entity> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.coolapk.market.view.cardlist.EntityDataFilter
    public List<Entity> modifyData(List<? extends Entity> list, boolean z) {
        Intrinsics.checkNotNullParameter(list, "list");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (Intrinsics.areEqual(((Entity) obj).getEntityType(), "liveSystemMessage")) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (!arrayList2.isEmpty()) {
            onLiveAction(arrayList2);
        }
        return list;
    }

    private final void onLiveAction(List<? extends Entity> list) {
        for (int lastIndex = CollectionsKt.getLastIndex(list); lastIndex >= 0; lastIndex--) {
            Object obj = list.get(lastIndex);
            Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.model.LiveMessage");
            LiveMessage liveMessage = (LiveMessage) obj;
            String messageSource = liveMessage.getMessageSource();
            EventBus eventBus = EventBus.getDefault();
            String entityUniqueId = EntityExtendsKt.entityUniqueId(liveMessage);
            Intrinsics.checkNotNullExpressionValue(messageSource, "action");
            eventBus.post(new LiveActionEvent(entityUniqueId, messageSource));
        }
    }
}
