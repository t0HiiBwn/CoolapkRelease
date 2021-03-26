package cn.lankton.flowlayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class FlowLayout extends ViewGroup {
    List<View> childList;
    List<Integer> lineNumList;
    private int lineSpacing;
    private Context mContext;
    private int usefulWidth;

    public FlowLayout(Context context) {
        this(context, null);
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lineSpacing = 0;
        this.childList = new ArrayList();
        this.lineNumList = new ArrayList();
        this.mContext = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FlowLayout);
        this.lineSpacing = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlowLayout_lineSpacing, 0);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        View view;
        int i3;
        int i4;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        int i5 = paddingLeft + paddingRight;
        int i6 = paddingTop;
        int i7 = i5;
        int i8 = 0;
        for (int i9 = 0; i9 < getChildCount(); i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    view = childAt;
                    measureChildWithMargins(childAt, i, 0, i2, i6);
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    int i10 = marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                    i4 = i10;
                    i3 = marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
                } else {
                    view = childAt;
                    measureChild(view, i, i2);
                    i4 = 0;
                    i3 = 0;
                }
                int measuredWidth = i4 + view.getMeasuredWidth();
                int measuredHeight = i3 + view.getMeasuredHeight();
                if (i7 + measuredWidth > size) {
                    i6 += i8 + this.lineSpacing;
                    i7 = i5;
                    i8 = 0;
                }
                if (measuredHeight > i8) {
                    i8 = measuredHeight;
                }
                i7 += measuredWidth;
            }
        }
        if (mode != 1073741824) {
            size2 = i6 + i8 + paddingBottom;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int i21 = i3 - i;
        this.usefulWidth = (i21 - paddingLeft) - paddingRight;
        int i22 = paddingRight + paddingLeft;
        this.lineNumList.clear();
        int i23 = paddingLeft;
        int i24 = i22;
        int i25 = 0;
        int i26 = 0;
        int i27 = 0;
        while (i25 < getChildCount()) {
            View childAt = getChildAt(i25);
            if (childAt.getVisibility() == 8) {
                i6 = i22;
                i5 = i25;
            } else {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                boolean z2 = layoutParams instanceof ViewGroup.MarginLayoutParams;
                if (z2) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i6 = i22;
                    i5 = i25;
                    int i28 = marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                    int i29 = marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
                    int i30 = marginLayoutParams.leftMargin + i23;
                    i9 = marginLayoutParams.topMargin + paddingTop;
                    i8 = marginLayoutParams.topMargin + paddingTop + measuredHeight;
                    i7 = i29;
                    i11 = i30;
                    i10 = marginLayoutParams.leftMargin + i23 + measuredWidth;
                    i12 = i28;
                } else {
                    i6 = i22;
                    i5 = i25;
                    i10 = i23 + measuredWidth;
                    i9 = paddingTop;
                    i8 = paddingTop + measuredHeight;
                    i11 = i23;
                    i12 = 0;
                    i7 = 0;
                }
                int i31 = i12 + measuredWidth;
                int i32 = i7 + measuredHeight;
                if (i24 + i31 > i21) {
                    this.lineNumList.add(Integer.valueOf(i26));
                    paddingTop += i27 + this.lineSpacing;
                    if (z2) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
                        i20 = marginLayoutParams2.leftMargin + paddingLeft;
                        int i33 = paddingTop + marginLayoutParams2.topMargin;
                        i19 = marginLayoutParams2.leftMargin + paddingLeft + measuredWidth;
                        int i34 = marginLayoutParams2.topMargin + paddingTop + measuredHeight;
                        i16 = i6;
                        i17 = paddingLeft;
                        i14 = i33;
                        i13 = i34;
                        i18 = 0;
                        i15 = 0;
                    } else {
                        int i35 = paddingTop + measuredHeight;
                        i16 = i6;
                        i17 = paddingLeft;
                        i14 = paddingTop;
                        i19 = paddingLeft + measuredWidth;
                        i13 = i35;
                        i18 = 0;
                        i15 = 0;
                        i20 = i17;
                    }
                } else {
                    i20 = i11;
                    i15 = i27;
                    i14 = i9;
                    i13 = i8;
                    i16 = i24;
                    i17 = i23;
                    i18 = i26;
                    i19 = i10;
                }
                childAt.layout(i20, i14, i19, i13);
                i26 = i18 + 1;
                if (i32 > i15) {
                    i15 = i32;
                }
                i23 = i17 + i31;
                i24 = i16 + i31;
                i27 = i15;
            }
            i25 = i5 + 1;
            i22 = i6;
        }
        this.lineNumList.add(Integer.valueOf(i26));
    }

    public void relayoutToCompress() {
        post(new Runnable() {
            /* class cn.lankton.flowlayout.FlowLayout.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                FlowLayout.this.compress();
            }
        });
    }

    /* access modifiers changed from: private */
    public void compress() {
        int childCount = getChildCount();
        if (childCount != 0) {
            int i = 0;
            for (int i2 = 0; i2 < childCount; i2++) {
                if (!(getChildAt(i2) instanceof BlankView)) {
                    i++;
                }
            }
            View[] viewArr = new View[i];
            int[] iArr = new int[i];
            int i3 = 0;
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (!(childAt instanceof BlankView)) {
                    viewArr[i3] = childAt;
                    ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        iArr[i3] = marginLayoutParams.leftMargin + measuredWidth + marginLayoutParams.rightMargin;
                    } else {
                        iArr[i3] = measuredWidth;
                    }
                    i3++;
                }
            }
            int[] iArr2 = new int[i];
            for (int i5 = 0; i5 < i; i5++) {
                int i6 = iArr[i5];
                int i7 = this.usefulWidth;
                if (i6 <= i7) {
                    i7 = iArr[i5];
                }
                iArr2[i5] = i7;
            }
            sortToCompress(viewArr, iArr2);
            removeAllViews();
            for (View view : this.childList) {
                addView(view);
            }
            this.childList.clear();
        }
    }

    private void sortToCompress(View[] viewArr, int[] iArr) {
        int length = viewArr.length;
        int i = length + 1;
        int[] iArr2 = new int[2];
        iArr2[1] = this.usefulWidth + 1;
        iArr2[0] = i;
        int[][] iArr3 = (int[][]) Array.newInstance(int.class, iArr2);
        for (int i2 = 0; i2 < i; i2++) {
            for (int i3 = 0; i3 < this.usefulWidth; i3++) {
                iArr3[i2][i3] = 0;
            }
        }
        boolean[] zArr = new boolean[length];
        for (int i4 = 0; i4 < length; i4++) {
            zArr[i4] = false;
        }
        for (int i5 = 1; i5 <= length; i5++) {
            int i6 = i5 - 1;
            for (int i7 = iArr[i6]; i7 <= this.usefulWidth; i7++) {
                iArr3[i5][i7] = iArr3[i6][i7] > iArr3[i6][i7 - iArr[i6]] + iArr[i6] ? iArr3[i6][i7] : iArr3[i6][i7 - iArr[i6]] + iArr[i6];
            }
        }
        int i8 = this.usefulWidth;
        for (int i9 = length; i9 > 0; i9--) {
            int i10 = i9 - 1;
            if (i8 < iArr[i10]) {
                break;
            }
            if (iArr3[i9][i8] == iArr3[i10][i8 - iArr[i10]] + iArr[i10]) {
                zArr[i10] = true;
                i8 -= iArr[i10];
            }
        }
        int i11 = length;
        for (int i12 = 0; i12 < length; i12++) {
            if (zArr[i12]) {
                this.childList.add(viewArr[i12]);
                i11--;
            }
        }
        if (i11 != 0) {
            View[] viewArr2 = new View[i11];
            int[] iArr4 = new int[i11];
            int i13 = 0;
            for (int i14 = 0; i14 < length; i14++) {
                if (!zArr[i14]) {
                    viewArr2[i13] = viewArr[i14];
                    iArr4[i13] = iArr[i14];
                    i13++;
                }
            }
            sortToCompress(viewArr2, iArr4);
        }
    }

    public void relayoutToAlign() {
        post(new Runnable() {
            /* class cn.lankton.flowlayout.FlowLayout.AnonymousClass2 */

            @Override // java.lang.Runnable
            public void run() {
                FlowLayout.this.align();
            }
        });
    }

    /* access modifiers changed from: private */
    public void align() {
        int i;
        int childCount = getChildCount();
        if (childCount != 0) {
            int i2 = 0;
            for (int i3 = 0; i3 < childCount; i3++) {
                if (!(getChildAt(i3) instanceof BlankView)) {
                    i2++;
                }
            }
            View[] viewArr = new View[i2];
            int[] iArr = new int[i2];
            int i4 = 0;
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                if (!(childAt instanceof BlankView)) {
                    viewArr[i4] = childAt;
                    ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        iArr[i4] = marginLayoutParams.leftMargin + measuredWidth + marginLayoutParams.rightMargin;
                    } else {
                        iArr[i4] = measuredWidth;
                    }
                    i4++;
                }
            }
            removeAllViews();
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            while (i6 < i2) {
                int i9 = iArr[i6] + i8;
                int i10 = this.usefulWidth;
                if (i9 > i10) {
                    int i11 = i10 - i8;
                    int i12 = i6 - 1;
                    int i13 = i12 - i7;
                    if (i13 >= 0) {
                        if (i13 > 0) {
                            ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(i11 / i13, 0);
                            while (i7 < i12) {
                                addView(viewArr[i7]);
                                addView(new BlankView(this.mContext), marginLayoutParams2);
                                i7++;
                            }
                        }
                        addView(viewArr[i12]);
                        i = i6 - 1;
                    } else {
                        addView(viewArr[i6]);
                        i = i6;
                        i6++;
                    }
                    i8 = 0;
                    i7 = i6;
                    i6 = i;
                } else {
                    i8 += iArr[i6];
                }
                i6++;
            }
            while (i7 < i2) {
                addView(viewArr[i7]);
                i7++;
            }
        }
    }

    public void relayoutToCompressAndAlign() {
        post(new Runnable() {
            /* class cn.lankton.flowlayout.FlowLayout.AnonymousClass3 */

            @Override // java.lang.Runnable
            public void run() {
                FlowLayout.this.compress();
                FlowLayout.this.align();
            }
        });
    }

    public void specifyLines(final int i) {
        post(new Runnable() {
            /* class cn.lankton.flowlayout.FlowLayout.AnonymousClass4 */

            @Override // java.lang.Runnable
            public void run() {
                int i = i;
                if (i > FlowLayout.this.lineNumList.size()) {
                    i = FlowLayout.this.lineNumList.size();
                }
                int i2 = 0;
                for (int i3 = 0; i3 < i; i3++) {
                    i2 += FlowLayout.this.lineNumList.get(i3).intValue();
                }
                ArrayList<View> arrayList = new ArrayList();
                for (int i4 = 0; i4 < i2; i4++) {
                    arrayList.add(FlowLayout.this.getChildAt(i4));
                }
                FlowLayout.this.removeAllViews();
                for (View view : arrayList) {
                    FlowLayout.this.addView(view);
                }
            }
        });
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ViewGroup.MarginLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(super.generateDefaultLayoutParams());
    }

    class BlankView extends View {
        public BlankView(Context context) {
            super(context);
        }
    }
}
