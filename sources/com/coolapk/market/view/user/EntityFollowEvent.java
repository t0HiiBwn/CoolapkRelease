package com.coolapk.market.view.user;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/coolapk/market/view/user/EntityFollowEvent;", "", "id", "", "entityType", "isFollowing", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getEntityType", "()Ljava/lang/String;", "getId", "()Z", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: UserFollowAppForumFragment.kt */
public final class EntityFollowEvent {
    private final String entityType;
    private final String id;
    private final boolean isFollowing;

    public EntityFollowEvent(String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "entityType");
        this.id = str;
        this.entityType = str2;
        this.isFollowing = z;
    }

    public final String getEntityType() {
        return this.entityType;
    }

    public final String getId() {
        return this.id;
    }

    public final boolean isFollowing() {
        return this.isFollowing;
    }
}
