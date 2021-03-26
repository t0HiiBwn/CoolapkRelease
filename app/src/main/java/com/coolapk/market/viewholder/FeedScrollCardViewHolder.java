package com.coolapk.market.viewholder;

import android.view.View;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.event.Event;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Feed;
import com.coolapk.market.util.EntityUtils;
import com.coolapk.market.util.RVStateEventChangedAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u00012\u00020\u0002:\u0001\fB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/coolapk/market/viewholder/FeedScrollCardViewHolder;", "Lcom/coolapk/market/viewholder/TitleRecycleViewCardViewHolder;", "Lcom/coolapk/market/util/RVStateEventChangedAdapter$IStateViewHolder;", "itemView", "Landroid/view/View;", "bindingComponent", "Landroidx/databinding/DataBindingComponent;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;)V", "onStateEventChanged", "", "event", "Lcom/coolapk/market/event/Event;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedScrollCardViewHolder.kt */
public final class FeedScrollCardViewHolder extends TitleRecycleViewCardViewHolder implements RVStateEventChangedAdapter.IStateViewHolder {
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedScrollCardViewHolder(View view, DataBindingComponent dataBindingComponent) {
        super(view, dataBindingComponent, new ItemActionHandler(), Companion.createCallback());
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "bindingComponent");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0013\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0003*\u0001\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\u0003\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/coolapk/market/viewholder/FeedScrollCardViewHolder$Companion;", "", "()V", "createCallback", "com/coolapk/market/viewholder/FeedScrollCardViewHolder$Companion$createCallback$1", "()Lcom/coolapk/market/viewholder/FeedScrollCardViewHolder$Companion$createCallback$1;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedScrollCardViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final FeedScrollCardViewHolder$Companion$createCallback$1 createCallback() {
            return new FeedScrollCardViewHolder$Companion$createCallback$1();
        }
    }

    @Override // com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder, com.coolapk.market.viewholder.StateViewHolder, com.coolapk.market.util.RVStateEventChangedAdapter.IStateViewHolder
    public boolean onStateEventChanged(Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        List<Entity> entities = getCard().getEntities();
        Intrinsics.checkNotNull(entities);
        for (Entity entity : entities) {
            Intrinsics.checkNotNullExpressionValue(entity, "entity");
            if (EntityUtils.isFeedType(entity.getEntityType()) && StateViewHolder.isEventBelongTo(event, (Feed) entity)) {
                return true;
            }
        }
        return false;
    }
}
