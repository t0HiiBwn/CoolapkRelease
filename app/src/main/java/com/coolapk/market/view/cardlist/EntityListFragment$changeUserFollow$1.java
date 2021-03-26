package com.coolapk.market.view.cardlist;

import android.text.TextUtils;
import com.coolapk.market.model.Ads;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.User;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"doAction", "Lcom/coolapk/market/model/Entity;", "entity", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: EntityListFragment.kt */
final class EntityListFragment$changeUserFollow$1 extends Lambda implements Function1<Entity, Entity> {
    final /* synthetic */ int $follow;
    final /* synthetic */ String $uid;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EntityListFragment$changeUserFollow$1(String str, int i) {
        super(1);
        this.$uid = str;
        this.$follow = i;
    }

    public final Entity invoke(Entity entity) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        if (entity instanceof Ads) {
            Ads ads = (Ads) entity;
            if (!Intrinsics.areEqual("user", ads.getAdsType()) || !TextUtils.equals(ads.getUid(), this.$uid)) {
                return null;
            }
            return Ads.builder(ads).setFollow(this.$follow).build();
        } else if (!(entity instanceof User)) {
            return null;
        } else {
            User user = (User) entity;
            if (TextUtils.equals(user.getUid(), this.$uid)) {
                return User.builder(user).setIsFollow(this.$follow).build();
            }
            return null;
        }
    }
}
