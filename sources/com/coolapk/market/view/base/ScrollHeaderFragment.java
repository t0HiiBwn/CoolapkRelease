package com.coolapk.market.view.base;

import android.os.Bundle;
import android.view.View;

public abstract class ScrollHeaderFragment extends BaseFragment {
    private OnScrollRatioChangeListener mScrollRatioChangeListener;

    public interface OnScrollRatioChangeListener {
        void onScrollRationChange(float f);
    }

    protected abstract void addOnOffsetListener(OnScrollRatioChangeListener onScrollRatioChangeListener);

    public void setScrollRatioChangeListener(OnScrollRatioChangeListener onScrollRatioChangeListener) {
        this.mScrollRatioChangeListener = onScrollRatioChangeListener;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.mScrollRatioChangeListener = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        addOnOffsetListener(this.mScrollRatioChangeListener);
    }
}
