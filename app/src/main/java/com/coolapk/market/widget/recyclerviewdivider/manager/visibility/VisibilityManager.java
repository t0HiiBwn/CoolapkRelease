package com.coolapk.market.widget.recyclerviewdivider.manager.visibility;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0007J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Lcom/coolapk/market/widget/recyclerviewdivider/manager/visibility/VisibilityManager;", "", "itemVisibility", "Lcom/coolapk/market/widget/recyclerviewdivider/manager/visibility/VisibilityManager$VisibilityType;", "groupCount", "", "groupIndex", "VisibilityType", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: VisibilityManager.kt */
public interface VisibilityManager {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/widget/recyclerviewdivider/manager/visibility/VisibilityManager$VisibilityType;", "", "(Ljava/lang/String;I)V", "NONE", "ITEMS_ONLY", "GROUP_ONLY", "ALL", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: VisibilityManager.kt */
    public enum VisibilityType {
        NONE,
        ITEMS_ONLY,
        GROUP_ONLY,
        ALL
    }

    VisibilityType itemVisibility(int i, int i2);
}
