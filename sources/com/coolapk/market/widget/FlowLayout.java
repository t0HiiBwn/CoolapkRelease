package com.coolapk.market.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class FlowLayout extends ViewGroup {
    public FlowLayout(Context context) {
        super(context);
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ViewGroup.MarginLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i, i2);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                int measuredHeight = childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
                int i8 = i5 + measuredWidth;
                if (i8 > size) {
                    i3 = Math.max(i5, measuredWidth);
                    i4 += measuredHeight;
                } else {
                    measuredHeight = Math.max(i6, measuredHeight);
                    i4 = Math.max(i4, measuredHeight);
                    measuredWidth = i8;
                }
                if (i7 == childCount - 1) {
                    i3 = Math.max(i3, measuredWidth);
                }
                i6 = measuredHeight;
                i5 = measuredWidth;
            }
        }
        setMeasuredDimension(resolveSize(i3 + getPaddingLeft() + getPaddingRight(), i), resolveSize(i4 + getPaddingTop() + getPaddingBottom(), i2));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width = getWidth();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        int i5 = paddingLeft;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (marginLayoutParams.leftMargin + measuredWidth + marginLayoutParams.rightMargin + i5 > width) {
                    paddingTop += marginLayoutParams.topMargin + measuredHeight;
                    childAt.layout(marginLayoutParams.leftMargin + paddingLeft, marginLayoutParams.topMargin + paddingTop, marginLayoutParams.leftMargin + measuredWidth + paddingLeft, measuredHeight + paddingTop + marginLayoutParams.topMargin);
                    i5 = measuredWidth + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + paddingLeft;
                } else {
                    childAt.layout(marginLayoutParams.leftMargin + i5, marginLayoutParams.topMargin + paddingTop, i5 + measuredWidth + marginLayoutParams.leftMargin, measuredHeight + paddingTop + marginLayoutParams.topMargin);
                    i5 += measuredWidth + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                }
            }
        }
    }
}
