package com.coolapk.market.view.user;

import com.coolapk.market.model.Entity;
import com.coolapk.market.util.EntityUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00040\u00012*\u0010\u0005\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00040\u0001H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "Lcom/coolapk/market/model/Entity;", "kotlin.jvm.PlatformType", "", "it", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: UserFollowAppForumFragment.kt */
final class UserFollowAppFragment$onCreateRequest$1<T, R> implements Func1<List<Entity>, List<Entity>> {
    public static final UserFollowAppFragment$onCreateRequest$1 INSTANCE = new UserFollowAppFragment$onCreateRequest$1();

    UserFollowAppFragment$onCreateRequest$1() {
    }

    public final List<Entity> call(List<Entity> list) {
        Intrinsics.checkNotNullExpressionValue(list, "it");
        int size = list.size();
        while (true) {
            size--;
            if (size < 0) {
                return list;
            }
            Entity entity = list.get(size);
            Intrinsics.checkNotNullExpressionValue(entity, "entity");
            if (!EntityUtils.isApkType(entity.getEntityType())) {
                list.remove(size);
            }
        }
    }
}
