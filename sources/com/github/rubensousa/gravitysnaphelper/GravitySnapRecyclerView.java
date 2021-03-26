package com.github.rubensousa.gravitysnaphelper;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper;

public class GravitySnapRecyclerView extends OrientationAwareRecyclerView {
    private boolean isSnappingEnabled;
    private final GravitySnapHelper snapHelper;

    public GravitySnapRecyclerView(Context context) {
        this(context, null);
    }

    public GravitySnapRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GravitySnapRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isSnappingEnabled = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.GravitySnapRecyclerView, i, 0);
        int i2 = obtainStyledAttributes.getInt(R.styleable.GravitySnapRecyclerView_snapGravity, 0);
        if (i2 == 0) {
            this.snapHelper = new GravitySnapHelper(8388611);
        } else if (i2 == 1) {
            this.snapHelper = new GravitySnapHelper(48);
        } else if (i2 == 2) {
            this.snapHelper = new GravitySnapHelper(8388613);
        } else if (i2 == 3) {
            this.snapHelper = new GravitySnapHelper(80);
        } else if (i2 == 4) {
            this.snapHelper = new GravitySnapHelper(17);
        } else {
            throw new IllegalArgumentException("Invalid gravity value. Use START | END | BOTTOM | TOP | CENTER constants");
        }
        this.snapHelper.setSnapToPadding(obtainStyledAttributes.getBoolean(R.styleable.GravitySnapRecyclerView_snapToPadding, false));
        this.snapHelper.setSnapLastItem(obtainStyledAttributes.getBoolean(R.styleable.GravitySnapRecyclerView_snapLastItem, false));
        this.snapHelper.setMaxFlingSizeFraction(obtainStyledAttributes.getFloat(R.styleable.GravitySnapRecyclerView_snapMaxFlingSizeFraction, -1.0f));
        this.snapHelper.setScrollMsPerInch(obtainStyledAttributes.getFloat(R.styleable.GravitySnapRecyclerView_snapScrollMsPerInch, 100.0f));
        enableSnapping(Boolean.valueOf(obtainStyledAttributes.getBoolean(R.styleable.GravitySnapRecyclerView_snapEnabled, true)));
        obtainStyledAttributes.recycle();
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void smoothScrollToPosition(int i) {
        if (!this.isSnappingEnabled || !this.snapHelper.smoothScrollToPosition(i)) {
            super.smoothScrollToPosition(i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void scrollToPosition(int i) {
        if (!this.isSnappingEnabled || !this.snapHelper.scrollToPosition(i)) {
            super.scrollToPosition(i);
        }
    }

    public GravitySnapHelper getSnapHelper() {
        return this.snapHelper;
    }

    public void enableSnapping(Boolean bool) {
        if (bool.booleanValue()) {
            this.snapHelper.attachToRecyclerView(this);
        } else {
            this.snapHelper.attachToRecyclerView(null);
        }
        this.isSnappingEnabled = bool.booleanValue();
    }

    public boolean isSnappingEnabled() {
        return this.isSnappingEnabled;
    }

    public int getCurrentSnappedPosition() {
        return this.snapHelper.getCurrentSnappedPosition();
    }

    public void snapToNextPosition(Boolean bool) {
        snapTo(true, bool);
    }

    public void snapToPreviousPosition(Boolean bool) {
        snapTo(false, bool);
    }

    public void setSnapListener(GravitySnapHelper.SnapListener snapListener) {
        this.snapHelper.setSnapListener(snapListener);
    }

    private void snapTo(Boolean bool, Boolean bool2) {
        View findSnapView;
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (layoutManager != null && (findSnapView = this.snapHelper.findSnapView(layoutManager, false)) != null) {
            int childAdapterPosition = getChildAdapterPosition(findSnapView);
            if (bool.booleanValue()) {
                if (bool2.booleanValue()) {
                    smoothScrollToPosition(childAdapterPosition + 1);
                } else {
                    scrollToPosition(childAdapterPosition + 1);
                }
            } else if (childAdapterPosition <= 0) {
            } else {
                if (bool2.booleanValue()) {
                    smoothScrollToPosition(childAdapterPosition - 1);
                } else {
                    scrollToPosition(childAdapterPosition - 1);
                }
            }
        }
    }
}
