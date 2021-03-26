package com.bytedance.sdk.openadsdk.dislike;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public class FlowLayout extends ViewGroup {
    private List<List<View>> a;
    private List<Integer> b;

    public FlowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new ArrayList();
        this.b = new ArrayList();
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlowLayout(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            measureChild(childAt, i, i2);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            int measuredWidth = childAt.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
            int measuredHeight = childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
            int i8 = i4 + measuredWidth;
            if (i8 - marginLayoutParams.rightMargin > (size - getPaddingLeft()) - getPaddingRight()) {
                i3 = Math.max(i3, i4);
                i6 += i5;
                i5 = measuredHeight;
                i4 = measuredWidth;
            } else {
                i5 = Math.max(i5, measuredHeight);
                i4 = i8;
            }
            if (i7 == childCount - 1) {
                i3 = Math.max(i4, i3);
                i6 += i5;
            }
        }
        Log.e("TAG", "sizeWidth = " + size + "|sizeHeight = " + size2);
        StringBuilder sb = new StringBuilder();
        sb.append("width = ");
        sb.append(i3);
        Log.e("TAG", sb.toString());
        if (mode != 1073741824) {
            size = getPaddingRight() + i3 + getPaddingLeft();
        }
        if (mode2 != 1073741824) {
            size2 = i6 + getPaddingTop() + getPaddingBottom();
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Log.e("TAG", "onLayout");
        this.a.clear();
        this.b.clear();
        int width = getWidth();
        ArrayList arrayList = new ArrayList();
        int childCount = getChildCount();
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            i6++;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            if ((measuredWidth * i6) + ((marginLayoutParams.leftMargin + marginLayoutParams.rightMargin) * (i6 - 1)) > (width - getPaddingLeft()) - getPaddingRight()) {
                this.b.add(Integer.valueOf(i5));
                this.a.add(arrayList);
                i5 = marginLayoutParams.bottomMargin + marginLayoutParams.topMargin + measuredHeight;
                arrayList = new ArrayList();
                i6 = 0;
            }
            int i8 = marginLayoutParams.leftMargin;
            int i9 = marginLayoutParams.rightMargin;
            i5 = Math.max(i5, measuredHeight + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin);
            arrayList.add(childAt);
        }
        this.b.add(Integer.valueOf(i5));
        this.a.add(arrayList);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int size = this.a.size();
        for (int i10 = 0; i10 < size; i10++) {
            List<View> list = this.a.get(i10);
            int intValue = this.b.get(i10).intValue();
            for (int i11 = 0; i11 < list.size(); i11++) {
                View view = list.get(i11);
                if (view.getVisibility() != 8) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                    int i12 = marginLayoutParams2.leftMargin + paddingLeft;
                    int i13 = marginLayoutParams2.topMargin + paddingTop;
                    view.layout(i12, i13, view.getMeasuredWidth() + i12, view.getMeasuredHeight() + i13);
                    paddingLeft += view.getMeasuredWidth() + marginLayoutParams2.leftMargin + marginLayoutParams2.rightMargin;
                }
            }
            paddingLeft = getPaddingLeft();
            paddingTop += intValue;
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }
}
