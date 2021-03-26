package com.coolapk.market.view.live;

import android.text.TextUtils;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.model.Entity;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.view.cardlist.EntityDataFilter;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"Lcom/coolapk/market/view/live/LiveUpdateTabHelper;", "Lcom/coolapk/market/view/cardlist/EntityDataFilter;", "()V", "modifyData", "", "Lcom/coolapk/market/model/Entity;", "list", "isRefresh", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: LiveUpdateTabHelper.kt */
public final class LiveUpdateTabHelper extends EntityDataFilter {
    public static final Companion Companion = new Companion(null);

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
            if (Intrinsics.areEqual(((Entity) obj).getEntityType(), "liveMessage")) {
                break;
            }
        }
        if (obj != null) {
            Companion.onLiveUpdateTab((Entity) obj);
        }
        return list;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/view/live/LiveUpdateTabHelper$Companion;", "", "()V", "onLiveUpdateTab", "", "entity", "Lcom/coolapk/market/model/Entity;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: LiveUpdateTabHelper.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void onLiveUpdateTab(Entity entity) {
            Intrinsics.checkNotNullParameter(entity, "entity");
            int intExtraData = EntityExtendsKt.getIntExtraData(entity, "follow_num", -1);
            int intExtraData2 = EntityExtendsKt.getIntExtraData(entity, "visit_num", -1);
            int intExtraData3 = EntityExtendsKt.getIntExtraData(entity, "discuss_num", -1);
            String stringExtraData = EntityExtendsKt.getStringExtraData(entity, "follow_num_format", "");
            String stringExtraData2 = EntityExtendsKt.getStringExtraData(entity, "visit_num_format", "");
            String stringExtraData3 = EntityExtendsKt.getStringExtraData(entity, "discuss_num_format", "");
            if (intExtraData != -1 && intExtraData2 != -1 && intExtraData3 != -1 && !TextUtils.isEmpty(stringExtraData) && !TextUtils.isEmpty(stringExtraData2) && !TextUtils.isEmpty(stringExtraData3)) {
                LogUtils.d("followNumFormt " + stringExtraData + " visitNumFormat " + stringExtraData2 + " discussNumFormat " + stringExtraData3, new Object[0]);
                EventBus.getDefault().post(new LiveNumEvent(intExtraData, intExtraData2, intExtraData3, stringExtraData, stringExtraData2, stringExtraData3));
            }
        }
    }
}
