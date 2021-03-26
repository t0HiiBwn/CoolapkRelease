package com.coolapk.market.widget;

import android.view.ViewGroup;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.main.MainActivity;

public class NavigationClipViewHelper {
    private boolean addPadding;
    private ViewGroup viewGroup;

    public NavigationClipViewHelper(ViewGroup viewGroup2) {
        this.viewGroup = viewGroup2;
        restoreAndResetTag();
    }

    private void restoreAndResetTag() {
        NavigationClipViewHelper navigationClipViewHelper = (NavigationClipViewHelper) this.viewGroup.getTag(2131363005);
        if (navigationClipViewHelper != null) {
            this.addPadding = navigationClipViewHelper.addPadding;
        }
        this.viewGroup.setTag(2131363005, this);
    }

    public void adapterToNavigationBar() {
        checkAndPostAddPadding();
    }

    private void checkAndPostAddPadding() {
        if (!this.addPadding && (UiUtils.getActivity(this.viewGroup.getContext()) instanceof MainActivity)) {
            setFixedPadding();
        }
    }

    private void setFixedPadding() {
        if (!this.addPadding) {
            this.viewGroup.setClipToPadding(false);
            ViewGroup viewGroup2 = this.viewGroup;
            viewGroup2.setPadding(viewGroup2.getPaddingLeft(), this.viewGroup.getPaddingTop(), this.viewGroup.getPaddingRight(), DisplayUtils.dp2px(this.viewGroup.getContext(), 48.0f) + this.viewGroup.getPaddingBottom());
            this.addPadding = true;
        }
    }

    private int getNavigationBarHeight() {
        return UiUtils.getNavigationBarHeight(this.viewGroup.getContext());
    }
}
