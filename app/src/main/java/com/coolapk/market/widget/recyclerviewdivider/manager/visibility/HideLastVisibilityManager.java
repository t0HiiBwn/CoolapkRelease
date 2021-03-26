package com.coolapk.market.widget.recyclerviewdivider.manager.visibility;

import com.coolapk.market.widget.recyclerviewdivider.manager.visibility.VisibilityManager;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/coolapk/market/widget/recyclerviewdivider/manager/visibility/HideLastVisibilityManager;", "Lcom/coolapk/market/widget/recyclerviewdivider/manager/visibility/VisibilityManager;", "()V", "itemVisibility", "Lcom/coolapk/market/widget/recyclerviewdivider/manager/visibility/VisibilityManager$VisibilityType;", "groupCount", "", "groupIndex", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: HideLastVisibilityManager.kt */
public final class HideLastVisibilityManager implements VisibilityManager {
    @Override // com.coolapk.market.widget.recyclerviewdivider.manager.visibility.VisibilityManager
    public VisibilityManager.VisibilityType itemVisibility(int i, int i2) {
        if (i2 == i - 1) {
            return VisibilityManager.VisibilityType.ITEMS_ONLY;
        }
        return VisibilityManager.VisibilityType.ALL;
    }
}
