package com.coolapk.market.widget.recyclerviewdivider.manager.inset;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u0019\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0017J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0017R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/coolapk/market/widget/recyclerviewdivider/manager/inset/DefaultInsetManager;", "Lcom/coolapk/market/widget/recyclerviewdivider/manager/inset/InsetManager;", "()V", "insetBefore", "", "insetAfter", "(II)V", "itemInsetAfter", "groupCount", "groupIndex", "itemInsetBefore", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: DefaultInsetManager.kt */
public final class DefaultInsetManager implements InsetManager {
    private final int insetAfter;
    private final int insetBefore;

    public DefaultInsetManager(int i, int i2) {
        this.insetBefore = i;
        this.insetAfter = i2;
    }

    public DefaultInsetManager() {
        this(0, 0);
    }

    @Override // com.coolapk.market.widget.recyclerviewdivider.manager.inset.InsetManager
    public int itemInsetBefore(int i, int i2) {
        return this.insetBefore;
    }

    @Override // com.coolapk.market.widget.recyclerviewdivider.manager.inset.InsetManager
    public int itemInsetAfter(int i, int i2) {
        return this.insetAfter;
    }
}
