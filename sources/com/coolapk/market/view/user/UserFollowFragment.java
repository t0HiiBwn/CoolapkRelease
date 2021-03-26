package com.coolapk.market.view.user;

import com.coolapk.market.view.cardlist.EntityListFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/view/user/UserFollowFragment;", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "()V", "onEntityFollowEvent", "", "event", "Lcom/coolapk/market/view/user/EntityFollowEvent;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: UserFollowAppForumFragment.kt */
public abstract class UserFollowFragment extends EntityListFragment {
    @Subscribe
    public final void onEntityFollowEvent(EntityFollowEvent entityFollowEvent) {
        Intrinsics.checkNotNullParameter(entityFollowEvent, "event");
        if (!entityFollowEvent.isFollowing()) {
            changeDataListAndAutoCalculateDiff(new UserFollowFragment$onEntityFollowEvent$1(this, entityFollowEvent));
        }
    }
}
