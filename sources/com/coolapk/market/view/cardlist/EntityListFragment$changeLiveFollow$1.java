package com.coolapk.market.view.cardlist;

import android.text.TextUtils;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Live;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"doAction", "Lcom/coolapk/market/model/Entity;", "entity", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: EntityListFragment.kt */
final class EntityListFragment$changeLiveFollow$1 extends Lambda implements Function1<Entity, Entity> {
    final /* synthetic */ boolean $isFollow;
    final /* synthetic */ String $liveId;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EntityListFragment$changeLiveFollow$1(String str, boolean z) {
        super(1);
        this.$liveId = str;
        this.$isFollow = z;
    }

    public final Entity invoke(Entity entity) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        if (!(entity instanceof Live)) {
            return null;
        }
        Live live = (Live) entity;
        if (!TextUtils.equals(live.getId(), this.$liveId) || live.isFollow() == this.$isFollow) {
            return null;
        }
        return Live.builder(live).setIsFollow(this.$isFollow ? 1 : 0).build();
    }
}
