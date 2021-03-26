package com.coolapk.market.view.cardlist;

import androidx.fragment.app.FragmentActivity;
import com.coolapk.market.viewholder.ItemActionHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/cardlist/EntityItemActionUtils;", "", "()V", "serviceApk", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "fragment", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "tabGroupCard", "topGroupCard", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: EntityItemActionUtils.kt */
public final class EntityItemActionUtils {
    public static final EntityItemActionUtils INSTANCE = new EntityItemActionUtils();

    private EntityItemActionUtils() {
    }

    public final ItemActionHandler tabGroupCard(EntityListFragment entityListFragment) {
        Intrinsics.checkNotNullParameter(entityListFragment, "fragment");
        FragmentActivity requireActivity = entityListFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "fragment.requireActivity()");
        return new EntityItemActionUtils$tabGroupCard$1(entityListFragment, requireActivity);
    }

    public final ItemActionHandler topGroupCard(EntityListFragment entityListFragment) {
        Intrinsics.checkNotNullParameter(entityListFragment, "fragment");
        FragmentActivity requireActivity = entityListFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "fragment.requireActivity()");
        return new EntityItemActionUtils$topGroupCard$1(entityListFragment, requireActivity);
    }

    public final ItemActionHandler serviceApk(EntityListFragment entityListFragment) {
        Intrinsics.checkNotNullParameter(entityListFragment, "fragment");
        FragmentActivity requireActivity = entityListFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "fragment.requireActivity()");
        return new EntityItemActionUtils$serviceApk$1(requireActivity, entityListFragment);
    }
}
