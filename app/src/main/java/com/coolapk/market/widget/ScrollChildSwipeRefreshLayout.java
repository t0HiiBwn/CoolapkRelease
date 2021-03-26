package com.coolapk.market.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class ScrollChildSwipeRefreshLayout extends SwipeRefreshLayout {
    private View mScrollUpChild;

    public ScrollChildSwipeRefreshLayout(Context context) {
        super(context);
    }

    public ScrollChildSwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout
    public boolean canChildScrollUp() {
        View view = this.mScrollUpChild;
        if (view != null) {
            return ViewCompat.canScrollVertically(view, -1);
        }
        return super.canChildScrollUp();
    }

    public void setScrollUpChild(View view) {
        this.mScrollUpChild = view;
    }
}
