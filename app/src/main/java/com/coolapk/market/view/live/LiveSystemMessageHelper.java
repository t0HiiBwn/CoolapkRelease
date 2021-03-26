package com.coolapk.market.view.live;

import android.view.View;
import com.coolapk.market.model.Entity;
import com.coolapk.market.view.cardlist.EntityDataFilter;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0010B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0002R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/coolapk/market/view/live/LiveSystemMessageHelper;", "Lcom/coolapk/market/view/cardlist/EntityDataFilter;", "callback", "Lcom/coolapk/market/view/live/LiveSystemMessageHelper$Callback;", "(Lcom/coolapk/market/view/live/LiveSystemMessageHelper$Callback;)V", "getCallback", "()Lcom/coolapk/market/view/live/LiveSystemMessageHelper$Callback;", "modifyData", "", "Lcom/coolapk/market/model/Entity;", "list", "isRefresh", "", "onLiveMessageCardLoaded", "", "entity", "Callback", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: LiveSystemMessageHelper.kt */
public final class LiveSystemMessageHelper extends EntityDataFilter {
    private final Callback callback;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/coolapk/market/view/live/LiveSystemMessageHelper$Callback;", "", "onFloatViewClick", "", "view", "Landroid/view/View;", "num", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: LiveSystemMessageHelper.kt */
    public interface Callback {
        void onFloatViewClick(View view, int i);
    }

    public LiveSystemMessageHelper() {
        this(null, 1, null);
    }

    public LiveSystemMessageHelper(Callback callback2) {
        this.callback = callback2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LiveSystemMessageHelper(Callback callback2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : callback2);
    }

    public final Callback getCallback() {
        return this.callback;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<? extends com.coolapk.market.model.Entity> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.coolapk.market.view.cardlist.EntityDataFilter
    public List<Entity> modifyData(List<? extends Entity> list, boolean z) {
        Object obj;
        Intrinsics.checkNotNullParameter(list, "list");
        Iterator it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj = null;
                break;
            }
            obj = it2.next();
            if (Intrinsics.areEqual(((Entity) obj).getEntityType(), "messageUnRead")) {
                break;
            }
        }
        if (obj == null) {
            return list;
        }
        Entity entity = (Entity) obj;
        onLiveMessageCardLoaded(entity);
        return removeData$presentation_coolapkAppRelease(list, entity);
    }

    private final void onLiveMessageCardLoaded(Entity entity) {
        String title = entity.getTitle();
        Intrinsics.checkNotNull(title);
        Intrinsics.checkNotNullExpressionValue(title, "entity.title!!");
        Integer.parseInt(title);
    }
}
