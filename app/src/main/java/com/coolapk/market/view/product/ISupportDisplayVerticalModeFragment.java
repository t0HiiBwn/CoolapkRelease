package com.coolapk.market.view.product;

/* compiled from: BaseLeftCategoryFragment.kt */
public interface ISupportDisplayVerticalModeFragment {
    void setDisplayInVerticalMode(boolean z, boolean z2);

    /* compiled from: BaseLeftCategoryFragment.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void setDisplayInVerticalMode$default(ISupportDisplayVerticalModeFragment iSupportDisplayVerticalModeFragment, boolean z, boolean z2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z2 = false;
                }
                iSupportDisplayVerticalModeFragment.setDisplayInVerticalMode(z, z2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setDisplayInVerticalMode");
        }
    }
}
