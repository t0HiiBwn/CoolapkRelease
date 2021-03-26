package com.coolapk.market.widget.recyclerviewdivider.manager.tint;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/coolapk/market/widget/recyclerviewdivider/manager/tint/DefaultTintManager;", "Lcom/coolapk/market/widget/recyclerviewdivider/manager/tint/TintManager;", "tint", "", "(I)V", "itemTint", "groupCount", "groupIndex", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: DefaultTintManager.kt */
public final class DefaultTintManager implements TintManager {
    private final int tint;

    public DefaultTintManager(int i) {
        this.tint = i;
    }

    @Override // com.coolapk.market.widget.recyclerviewdivider.manager.tint.TintManager
    public int itemTint(int i, int i2) {
        return this.tint;
    }
}
