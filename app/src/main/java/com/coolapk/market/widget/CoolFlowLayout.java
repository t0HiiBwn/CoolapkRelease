package com.coolapk.market.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u0000 +2\u00020\u0001:\u0001+B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u001f\u001a\u00020 J0\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u000eH\u0014J\u0018\u0010'\u001a\u00020 2\u0006\u0010(\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020\u000eH\u0014J\b\u0010*\u001a\u00020 H\u0002R(\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u000e@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u0014@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R$\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u000e@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0011\"\u0004\b\u001e\u0010\u0013¨\u0006,"}, d2 = {"Lcom/coolapk/market/widget/CoolFlowLayout;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "value", "Landroid/widget/Adapter;", "adapter", "getAdapter", "()Landroid/widget/Adapter;", "setAdapter", "(Landroid/widget/Adapter;)V", "", "horizontalDividerWidth", "getHorizontalDividerWidth", "()I", "setHorizontalDividerWidth", "(I)V", "", "layoutMode", "getLayoutMode", "()Ljava/lang/String;", "setLayoutMode", "(Ljava/lang/String;)V", "needUpdateView", "", "verticalDividerHeight", "getVerticalDividerHeight", "setVerticalDividerHeight", "executePendingUpdate", "", "onLayout", "changed", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "updateChildViews", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CoolFlowLayout.kt */
public final class CoolFlowLayout extends ViewGroup {
    public static final Companion Companion = new Companion(null);
    public static final String LAYOUT_MODE_EQUAL = "EQUAL";
    public static final String LAYOUT_MODE_FLEX = "FLEX";
    public static final String LAYOUT_MODE_GRID = "GRID";
    public static final String LAYOUT_MODE_SCROLL = "SCROLL";
    private Adapter adapter;
    private int horizontalDividerWidth;
    private String layoutMode;
    private boolean needUpdateView;
    private int verticalDividerHeight;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoolFlowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.layoutMode = "FLEX";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CoolFlowLayout(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/coolapk/market/widget/CoolFlowLayout$Companion;", "", "()V", "LAYOUT_MODE_EQUAL", "", "LAYOUT_MODE_FLEX", "LAYOUT_MODE_GRID", "LAYOUT_MODE_SCROLL", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: CoolFlowLayout.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final int getHorizontalDividerWidth() {
        return this.horizontalDividerWidth;
    }

    public final void setHorizontalDividerWidth(int i) {
        this.horizontalDividerWidth = i;
        requestLayout();
    }

    public final int getVerticalDividerHeight() {
        return this.verticalDividerHeight;
    }

    public final void setVerticalDividerHeight(int i) {
        this.verticalDividerHeight = i;
        requestLayout();
    }

    @Override // android.view.ViewGroup
    public final String getLayoutMode() {
        return this.layoutMode;
    }

    public final void setLayoutMode(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        this.layoutMode = str;
        requestLayout();
    }

    public final Adapter getAdapter() {
        return this.adapter;
    }

    public final void setAdapter(Adapter adapter2) {
        this.adapter = adapter2;
        this.needUpdateView = true;
        requestLayout();
    }

    public final void executePendingUpdate() {
        if (this.needUpdateView) {
            updateChildViews();
            this.needUpdateView = false;
        }
    }

    private final void updateChildViews() {
        Adapter adapter2 = this.adapter;
        if (adapter2 == null) {
            removeAllViews();
            return;
        }
        ArrayList arrayList = new ArrayList();
        int count = adapter2.getCount();
        int i = 0;
        for (int i2 = 0; i2 < count; i2++) {
            View view = adapter2.getView(i2, getChildAt(i2), this);
            Intrinsics.checkNotNullExpressionValue(view, "convertView");
            arrayList.add(view);
        }
        removeAllViewsInLayout();
        for (Object obj : arrayList) {
            int i3 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            View view2 = (View) obj;
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
            }
            addViewInLayout(view2, i, layoutParams);
            i = i3;
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        executePendingUpdate();
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int paddingTop = (size2 - getPaddingTop()) - getPaddingBottom();
        String str = this.layoutMode;
        int i4 = 0;
        switch (str.hashCode()) {
            case -1854350643:
                if (str.equals("SCROLL")) {
                    int childCount = getChildCount();
                    for (int i5 = 0; i5 < childCount; i5++) {
                        getChildAt(i5).measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, 0), View.MeasureSpec.makeMeasureSpec(paddingTop, 0));
                    }
                    int childCount2 = getChildCount();
                    i3 = 0;
                    for (int i6 = 0; i6 < childCount2; i6++) {
                        View childAt = getChildAt(i6);
                        Intrinsics.checkNotNullExpressionValue(childAt, "child");
                        if (childAt.getVisibility() != 8) {
                            i4 += childAt.getMeasuredWidth() + this.horizontalDividerWidth;
                            i3 = Math.max(i3, childAt.getMeasuredHeight());
                        }
                    }
                    paddingLeft = getChildCount() > 0 ? i4 - this.horizontalDividerWidth : i4;
                    i4 = i3;
                    break;
                }
                paddingLeft = 0;
                break;
            case 2160633:
                if (str.equals("FLEX")) {
                    int childCount3 = getChildCount();
                    for (int i7 = 0; i7 < childCount3; i7++) {
                        getChildAt(i7).measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(paddingTop, 0));
                    }
                    int childCount4 = getChildCount();
                    int i8 = paddingLeft;
                    i3 = 0;
                    int i9 = 0;
                    while (i4 < childCount4) {
                        View childAt2 = getChildAt(i4);
                        Intrinsics.checkNotNullExpressionValue(childAt2, "child");
                        if (childAt2.getVisibility() != 8) {
                            if (childAt2.getMeasuredWidth() + this.horizontalDividerWidth <= i8) {
                                i8 -= childAt2.getMeasuredWidth() + this.horizontalDividerWidth;
                                i9 = Math.max(i9, childAt2.getMeasuredHeight());
                            } else if (childAt2.getMeasuredWidth() <= i8) {
                                i8 -= childAt2.getMeasuredWidth();
                                i9 = Math.max(i9, childAt2.getMeasuredHeight());
                            } else if (childAt2.getMeasuredWidth() > i8) {
                                i8 = paddingLeft - (childAt2.getMeasuredWidth() + this.horizontalDividerWidth);
                                i3 += i9 + this.verticalDividerHeight;
                                i9 = childAt2.getMeasuredHeight();
                            }
                        }
                        i4++;
                    }
                    if (getChildCount() > 0) {
                        i3 += i9;
                    }
                    i4 = i3;
                    break;
                }
                paddingLeft = 0;
                break;
            case 2196294:
                if (str.equals("GRID")) {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec((paddingLeft - (this.horizontalDividerWidth * 3)) / 4, 1073741824);
                    int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(paddingTop, 0);
                    int childCount5 = getChildCount();
                    for (int i10 = 0; i10 < childCount5; i10++) {
                        getChildAt(i10).measure(makeMeasureSpec, makeMeasureSpec2);
                    }
                    int childCount6 = getChildCount();
                    int i11 = 0;
                    int i12 = 0;
                    while (i4 < childCount6) {
                        View childAt3 = getChildAt(i4);
                        Intrinsics.checkNotNullExpressionValue(childAt3, "child");
                        if (childAt3.getVisibility() != 8) {
                            i11++;
                            i12 = Math.max(i12, childAt3.getMeasuredHeight());
                        }
                        i4++;
                    }
                    int ceil = (int) Math.ceil(((double) i11) / ((double) 4));
                    i4 = (i12 * ceil) + (this.verticalDividerHeight * (ceil - 1));
                    break;
                }
                paddingLeft = 0;
                break;
            case 66219796:
                if (str.equals("EQUAL")) {
                    int childCount7 = getChildCount();
                    for (int i13 = 0; i13 < childCount7; i13++) {
                        getChildAt(i13).measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, 0), View.MeasureSpec.makeMeasureSpec(paddingTop, 0));
                    }
                    int childCount8 = getChildCount();
                    int i14 = 0;
                    int i15 = 0;
                    int i16 = 0;
                    while (i4 < childCount8) {
                        View childAt4 = getChildAt(i4);
                        Intrinsics.checkNotNullExpressionValue(childAt4, "child");
                        if (childAt4.getVisibility() != 8) {
                            i15++;
                            i14 += childAt4.getMeasuredWidth();
                            i16 = Math.max(i16, childAt4.getMeasuredHeight());
                        }
                        i4++;
                    }
                    int i17 = this.horizontalDividerWidth;
                    if (i14 >= paddingLeft - (i15 * i17)) {
                        paddingLeft = i14 + (i15 * i17);
                    }
                    i4 = i16;
                    break;
                }
                paddingLeft = 0;
                break;
            default:
                paddingLeft = 0;
                break;
        }
        setMeasuredDimension(View.resolveSize(paddingLeft + getPaddingLeft() + getPaddingRight(), i), View.resolveSize(i4 + getPaddingTop() + getPaddingBottom(), i2));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        String str = this.layoutMode;
        int i5 = 0;
        switch (str.hashCode()) {
            case -1854350643:
                if (str.equals("SCROLL")) {
                    int paddingLeft = getPaddingLeft();
                    int paddingTop = getPaddingTop();
                    int childCount = getChildCount();
                    while (i5 < childCount) {
                        View childAt = getChildAt(i5);
                        Intrinsics.checkNotNullExpressionValue(childAt, "child");
                        if (childAt.getVisibility() != 8) {
                            childAt.layout(paddingLeft, paddingTop, childAt.getMeasuredWidth() + paddingLeft, childAt.getMeasuredHeight() + paddingTop);
                            paddingLeft += childAt.getMeasuredWidth() + this.horizontalDividerWidth;
                        }
                        i5++;
                    }
                    return;
                }
                return;
            case 2160633:
                if (str.equals("FLEX")) {
                    int paddingLeft2 = getPaddingLeft();
                    int paddingTop2 = getPaddingTop();
                    int childCount2 = getChildCount();
                    int i6 = width;
                    int i7 = 0;
                    for (int i8 = 0; i8 < childCount2; i8++) {
                        View childAt2 = getChildAt(i8);
                        Intrinsics.checkNotNullExpressionValue(childAt2, "child");
                        if (childAt2.getVisibility() != 8) {
                            if (childAt2.getMeasuredWidth() + this.horizontalDividerWidth <= i6) {
                                childAt2.layout(paddingLeft2, paddingTop2, childAt2.getMeasuredWidth() + paddingLeft2, childAt2.getMeasuredHeight() + paddingTop2);
                                i6 -= childAt2.getMeasuredWidth() + this.horizontalDividerWidth;
                                paddingLeft2 += childAt2.getMeasuredWidth() + this.horizontalDividerWidth;
                                i7 = Math.max(i7, childAt2.getMeasuredHeight());
                            } else if (childAt2.getMeasuredWidth() <= i6) {
                                childAt2.layout(paddingLeft2, paddingTop2, childAt2.getMeasuredWidth() + paddingLeft2, childAt2.getMeasuredHeight() + paddingTop2);
                                paddingLeft2 = getPaddingLeft();
                                paddingTop2 += Math.max(i7, childAt2.getMeasuredHeight()) + this.verticalDividerHeight;
                                i6 = width;
                                i7 = 0;
                            } else if (childAt2.getMeasuredWidth() > i6) {
                                paddingTop2 += i7 + this.verticalDividerHeight;
                                int paddingLeft3 = getPaddingLeft();
                                childAt2.layout(paddingLeft3, paddingTop2, childAt2.getMeasuredWidth() + paddingLeft3, childAt2.getMeasuredHeight() + paddingTop2);
                                i6 = (width - childAt2.getMeasuredWidth()) - this.horizontalDividerWidth;
                                paddingLeft2 = paddingLeft3 + childAt2.getMeasuredWidth() + this.horizontalDividerWidth;
                                i7 = Math.max(0, childAt2.getMeasuredHeight());
                            }
                        }
                    }
                    return;
                }
                return;
            case 2196294:
                if (str.equals("GRID")) {
                    int childCount3 = getChildCount();
                    int i9 = 0;
                    while (i5 < childCount3) {
                        View childAt3 = getChildAt(i5);
                        Intrinsics.checkNotNullExpressionValue(childAt3, "child");
                        if (childAt3.getVisibility() != 8) {
                            int i10 = i9 / 4;
                            int paddingLeft4 = getPaddingLeft() + ((childAt3.getMeasuredWidth() + this.horizontalDividerWidth) * (i9 - (i10 * 4)));
                            int paddingTop3 = getPaddingTop() + ((childAt3.getMeasuredHeight() + this.verticalDividerHeight) * i10);
                            childAt3.layout(paddingLeft4, paddingTop3, childAt3.getMeasuredWidth() + paddingLeft4, childAt3.getMeasuredHeight() + paddingTop3);
                            i9++;
                        }
                        i5++;
                    }
                    return;
                }
                return;
            case 66219796:
                if (str.equals("EQUAL")) {
                    int paddingTop4 = getPaddingTop();
                    int childCount4 = getChildCount();
                    int i11 = 0;
                    int i12 = 0;
                    for (int i13 = 0; i13 < childCount4; i13++) {
                        View childAt4 = getChildAt(i13);
                        Intrinsics.checkNotNullExpressionValue(childAt4, "child");
                        if (childAt4.getVisibility() != 8) {
                            i12++;
                            i11 += childAt4.getMeasuredWidth();
                        }
                    }
                    int i14 = ((i3 - i) - i11) / (i12 + 1);
                    int paddingLeft5 = getPaddingLeft() + i14;
                    int childCount5 = getChildCount();
                    while (i5 < childCount5) {
                        View childAt5 = getChildAt(i5);
                        Intrinsics.checkNotNullExpressionValue(childAt5, "child");
                        if (childAt5.getVisibility() != 8) {
                            childAt5.layout(paddingLeft5, paddingTop4, childAt5.getMeasuredWidth() + paddingLeft5, childAt5.getMeasuredHeight() + paddingTop4);
                            paddingLeft5 += childAt5.getMeasuredWidth() + i14;
                        }
                        i5++;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }
}
