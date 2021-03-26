package com.coolapk.market.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class AutoMeasureRecyclerView extends RecyclerView {
    private static final int DIVIDE_WIDTH_DP = 4;
    private static final int MAX_CHILD_WIDTH_DP = 160;
    private int divider;
    private int maxChildWidth;
    private int numColumns = 3;
    private int numRows = 3;

    public AutoMeasureRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        this.divider = (int) (TypedValue.applyDimension(1, 4.0f, displayMetrics) + 0.5f);
        this.maxChildWidth = (int) (TypedValue.applyDimension(1, 160.0f, displayMetrics) + 0.5f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    protected void onMeasure(int i, int i2) {
        View.MeasureSpec.getMode(i);
        View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        View.MeasureSpec.getSize(i2);
        int i3 = this.divider;
        int i4 = (size - (i3 * 2)) / 3;
        int i5 = this.maxChildWidth;
        if (i4 > i5) {
            i4 = i5;
        }
        int i6 = this.numColumns;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec((i4 * i6) + ((i6 - 1) * i3), 1073741824);
        int i7 = this.numRows;
        super.onMeasure(makeMeasureSpec, View.MeasureSpec.makeMeasureSpec((i4 * i7) + ((i7 - 1) * this.divider), 1073741824));
    }

    public int getNumColumns() {
        return this.numColumns;
    }

    public void setNumColumns(int i) {
        if (i <= 0) {
            i = 1;
        }
        this.numColumns = i;
    }

    public int getNumRows() {
        return this.numRows;
    }

    public void setNumRows(int i) {
        this.numRows = i;
        requestLayout();
    }

    public int getDividerWidth() {
        return this.divider;
    }
}
