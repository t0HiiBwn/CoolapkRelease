package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.appcompat.R;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class LinearLayoutCompat extends ViewGroup {
    private static final String ACCESSIBILITY_CLASS_NAME = "androidx.appcompat.widget.LinearLayoutCompat";
    public static final int HORIZONTAL = 0;
    private static final int INDEX_BOTTOM = 2;
    private static final int INDEX_CENTER_VERTICAL = 0;
    private static final int INDEX_FILL = 3;
    private static final int INDEX_TOP = 1;
    public static final int SHOW_DIVIDER_BEGINNING = 1;
    public static final int SHOW_DIVIDER_END = 4;
    public static final int SHOW_DIVIDER_MIDDLE = 2;
    public static final int SHOW_DIVIDER_NONE = 0;
    public static final int VERTICAL = 1;
    private static final int VERTICAL_GRAVITY_COUNT = 4;
    private boolean mBaselineAligned;
    private int mBaselineAlignedChildIndex;
    private int mBaselineChildTop;
    private Drawable mDivider;
    private int mDividerHeight;
    private int mDividerPadding;
    private int mDividerWidth;
    private int mGravity;
    private int[] mMaxAscent;
    private int[] mMaxDescent;
    private int mOrientation;
    private int mShowDividers;
    private int mTotalLength;
    private boolean mUseLargestChild;
    private float mWeightSum;

    @Retention(RetentionPolicy.SOURCE)
    public @interface DividerMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface OrientationMode {
    }

    int getChildrenSkipCount(View view, int i) {
        return 0;
    }

    int getLocationOffset(View view) {
        return 0;
    }

    int getNextLocationOffset(View view) {
        return 0;
    }

    int measureNullChild(int i) {
        return 0;
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public LinearLayoutCompat(Context context) {
        this(context, null);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mBaselineAligned = true;
        this.mBaselineAlignedChildIndex = -1;
        this.mBaselineChildTop = 0;
        this.mGravity = 8388659;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.LinearLayoutCompat, i, 0);
        int i2 = obtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_android_orientation, -1);
        if (i2 >= 0) {
            setOrientation(i2);
        }
        int i3 = obtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_android_gravity, -1);
        if (i3 >= 0) {
            setGravity(i3);
        }
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.LinearLayoutCompat_android_baselineAligned, true);
        if (!z) {
            setBaselineAligned(z);
        }
        this.mWeightSum = obtainStyledAttributes.getFloat(R.styleable.LinearLayoutCompat_android_weightSum, -1.0f);
        this.mBaselineAlignedChildIndex = obtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.mUseLargestChild = obtainStyledAttributes.getBoolean(R.styleable.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(obtainStyledAttributes.getDrawable(R.styleable.LinearLayoutCompat_divider));
        this.mShowDividers = obtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_showDividers, 0);
        this.mDividerPadding = obtainStyledAttributes.getDimensionPixelSize(R.styleable.LinearLayoutCompat_dividerPadding, 0);
        obtainStyledAttributes.recycle();
    }

    public void setShowDividers(int i) {
        if (i != this.mShowDividers) {
            requestLayout();
        }
        this.mShowDividers = i;
    }

    public int getShowDividers() {
        return this.mShowDividers;
    }

    public Drawable getDividerDrawable() {
        return this.mDivider;
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable != this.mDivider) {
            this.mDivider = drawable;
            boolean z = false;
            if (drawable != null) {
                this.mDividerWidth = drawable.getIntrinsicWidth();
                this.mDividerHeight = drawable.getIntrinsicHeight();
            } else {
                this.mDividerWidth = 0;
                this.mDividerHeight = 0;
            }
            if (drawable == null) {
                z = true;
            }
            setWillNotDraw(z);
            requestLayout();
        }
    }

    public void setDividerPadding(int i) {
        this.mDividerPadding = i;
    }

    public int getDividerPadding() {
        return this.mDividerPadding;
    }

    public int getDividerWidth() {
        return this.mDividerWidth;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mDivider != null) {
            if (this.mOrientation == 1) {
                drawDividersVertical(canvas);
            } else {
                drawDividersHorizontal(canvas);
            }
        }
    }

    void drawDividersVertical(Canvas canvas) {
        int i;
        int virtualChildCount = getVirtualChildCount();
        for (int i2 = 0; i2 < virtualChildCount; i2++) {
            View virtualChildAt = getVirtualChildAt(i2);
            if (!(virtualChildAt == null || virtualChildAt.getVisibility() == 8 || !hasDividerBeforeChildAt(i2))) {
                drawHorizontalDivider(canvas, (virtualChildAt.getTop() - ((LayoutParams) virtualChildAt.getLayoutParams()).topMargin) - this.mDividerHeight);
            }
        }
        if (hasDividerBeforeChildAt(virtualChildCount)) {
            View virtualChildAt2 = getVirtualChildAt(virtualChildCount - 1);
            if (virtualChildAt2 == null) {
                i = (getHeight() - getPaddingBottom()) - this.mDividerHeight;
            } else {
                i = virtualChildAt2.getBottom() + ((LayoutParams) virtualChildAt2.getLayoutParams()).bottomMargin;
            }
            drawHorizontalDivider(canvas, i);
        }
    }

    void drawDividersHorizontal(Canvas canvas) {
        int i;
        int i2;
        int i3;
        int i4;
        int virtualChildCount = getVirtualChildCount();
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        for (int i5 = 0; i5 < virtualChildCount; i5++) {
            View virtualChildAt = getVirtualChildAt(i5);
            if (!(virtualChildAt == null || virtualChildAt.getVisibility() == 8 || !hasDividerBeforeChildAt(i5))) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (isLayoutRtl) {
                    i4 = virtualChildAt.getRight() + layoutParams.rightMargin;
                } else {
                    i4 = (virtualChildAt.getLeft() - layoutParams.leftMargin) - this.mDividerWidth;
                }
                drawVerticalDivider(canvas, i4);
            }
        }
        if (hasDividerBeforeChildAt(virtualChildCount)) {
            View virtualChildAt2 = getVirtualChildAt(virtualChildCount - 1);
            if (virtualChildAt2 != null) {
                LayoutParams layoutParams2 = (LayoutParams) virtualChildAt2.getLayoutParams();
                if (isLayoutRtl) {
                    i3 = virtualChildAt2.getLeft() - layoutParams2.leftMargin;
                    i2 = this.mDividerWidth;
                } else {
                    i = virtualChildAt2.getRight() + layoutParams2.rightMargin;
                    drawVerticalDivider(canvas, i);
                }
            } else if (isLayoutRtl) {
                i = getPaddingLeft();
                drawVerticalDivider(canvas, i);
            } else {
                i3 = getWidth() - getPaddingRight();
                i2 = this.mDividerWidth;
            }
            i = i3 - i2;
            drawVerticalDivider(canvas, i);
        }
    }

    void drawHorizontalDivider(Canvas canvas, int i) {
        this.mDivider.setBounds(getPaddingLeft() + this.mDividerPadding, i, (getWidth() - getPaddingRight()) - this.mDividerPadding, this.mDividerHeight + i);
        this.mDivider.draw(canvas);
    }

    void drawVerticalDivider(Canvas canvas, int i) {
        this.mDivider.setBounds(i, getPaddingTop() + this.mDividerPadding, this.mDividerWidth + i, (getHeight() - getPaddingBottom()) - this.mDividerPadding);
        this.mDivider.draw(canvas);
    }

    public boolean isBaselineAligned() {
        return this.mBaselineAligned;
    }

    public void setBaselineAligned(boolean z) {
        this.mBaselineAligned = z;
    }

    public boolean isMeasureWithLargestChildEnabled() {
        return this.mUseLargestChild;
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.mUseLargestChild = z;
    }

    @Override // android.view.View
    public int getBaseline() {
        int i;
        if (this.mBaselineAlignedChildIndex < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i2 = this.mBaselineAlignedChildIndex;
        if (childCount > i2) {
            View childAt = getChildAt(i2);
            int baseline = childAt.getBaseline();
            if (baseline != -1) {
                int i3 = this.mBaselineChildTop;
                if (this.mOrientation == 1 && (i = this.mGravity & 112) != 48) {
                    if (i == 16) {
                        i3 += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.mTotalLength) / 2;
                    } else if (i == 80) {
                        i3 = ((getBottom() - getTop()) - getPaddingBottom()) - this.mTotalLength;
                    }
                }
                return i3 + ((LayoutParams) childAt.getLayoutParams()).topMargin + baseline;
            } else if (this.mBaselineAlignedChildIndex == 0) {
                return -1;
            } else {
                throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
            }
        } else {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
    }

    public int getBaselineAlignedChildIndex() {
        return this.mBaselineAlignedChildIndex;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i < 0 || i >= getChildCount()) {
            throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
        }
        this.mBaselineAlignedChildIndex = i;
    }

    View getVirtualChildAt(int i) {
        return getChildAt(i);
    }

    int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.mWeightSum;
    }

    public void setWeightSum(float f) {
        this.mWeightSum = Math.max(0.0f, f);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.mOrientation == 1) {
            measureVertical(i, i2);
        } else {
            measureHorizontal(i, i2);
        }
    }

    protected boolean hasDividerBeforeChildAt(int i) {
        if (i == 0) {
            return (this.mShowDividers & 1) != 0;
        }
        if (i == getChildCount()) {
            if ((this.mShowDividers & 4) != 0) {
                return true;
            }
            return false;
        } else if ((this.mShowDividers & 2) == 0) {
            return false;
        } else {
            for (int i2 = i - 1; i2 >= 0; i2--) {
                if (getChildAt(i2).getVisibility() != 8) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:140:0x0327  */
    void measureVertical(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        View view;
        int i18;
        boolean z2;
        int i19;
        int i20;
        this.mTotalLength = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int i21 = this.mBaselineAlignedChildIndex;
        boolean z3 = this.mUseLargestChild;
        float f = 0.0f;
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        int i26 = 0;
        int i27 = 0;
        boolean z4 = false;
        boolean z5 = true;
        boolean z6 = false;
        while (true) {
            int i28 = 8;
            if (i27 < virtualChildCount) {
                View virtualChildAt = getVirtualChildAt(i27);
                if (virtualChildAt == null) {
                    this.mTotalLength += measureNullChild(i27);
                    i12 = virtualChildCount;
                    i11 = mode2;
                    i25 = i25;
                } else if (virtualChildAt.getVisibility() == 8) {
                    i27 += getChildrenSkipCount(virtualChildAt, i27);
                    i12 = virtualChildCount;
                    i25 = i25;
                    i22 = i22;
                    i11 = mode2;
                } else {
                    if (hasDividerBeforeChildAt(i27)) {
                        this.mTotalLength += this.mDividerHeight;
                    }
                    LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                    float f2 = f + layoutParams.weight;
                    if (mode2 == 1073741824 && layoutParams.height == 0 && layoutParams.weight > 0.0f) {
                        int i29 = this.mTotalLength;
                        this.mTotalLength = Math.max(i29, layoutParams.topMargin + i29 + layoutParams.bottomMargin);
                        i18 = i24;
                        view = virtualChildAt;
                        i13 = i26;
                        i12 = virtualChildCount;
                        i17 = i22;
                        i14 = i23;
                        z4 = true;
                        i16 = i27;
                        i11 = mode2;
                        i15 = i25;
                    } else {
                        if (layoutParams.height != 0 || layoutParams.weight <= 0.0f) {
                            i20 = Integer.MIN_VALUE;
                        } else {
                            layoutParams.height = -2;
                            i20 = 0;
                        }
                        i17 = i22;
                        i14 = i23;
                        i12 = virtualChildCount;
                        i11 = mode2;
                        i15 = i25;
                        i13 = i26;
                        i16 = i27;
                        measureChildBeforeLayout(virtualChildAt, i27, i, 0, i2, f2 == 0.0f ? this.mTotalLength : 0);
                        if (i20 != Integer.MIN_VALUE) {
                            layoutParams.height = i20;
                        }
                        int measuredHeight = virtualChildAt.getMeasuredHeight();
                        int i30 = this.mTotalLength;
                        view = virtualChildAt;
                        this.mTotalLength = Math.max(i30, i30 + measuredHeight + layoutParams.topMargin + layoutParams.bottomMargin + getNextLocationOffset(view));
                        i18 = z3 ? Math.max(measuredHeight, i24) : i24;
                    }
                    if (i21 >= 0 && i21 == i16 + 1) {
                        this.mBaselineChildTop = this.mTotalLength;
                    }
                    if (i16 >= i21 || layoutParams.weight <= 0.0f) {
                        if (mode == 1073741824 || layoutParams.width != -1) {
                            z2 = false;
                        } else {
                            z2 = true;
                            z6 = true;
                        }
                        int i31 = layoutParams.leftMargin + layoutParams.rightMargin;
                        int measuredWidth = view.getMeasuredWidth() + i31;
                        int max = Math.max(i14, measuredWidth);
                        int combineMeasuredStates = View.combineMeasuredStates(i17, view.getMeasuredState());
                        z5 = z5 && layoutParams.width == -1;
                        if (layoutParams.weight > 0.0f) {
                            if (!z2) {
                                i31 = measuredWidth;
                            }
                            i25 = Math.max(i15, i31);
                            i19 = i13;
                        } else {
                            if (!z2) {
                                i31 = measuredWidth;
                            }
                            i19 = Math.max(i13, i31);
                            i25 = i15;
                        }
                        i24 = i18;
                        f = f2;
                        i26 = i19;
                        i22 = combineMeasuredStates;
                        i27 = getChildrenSkipCount(view, i16) + i16;
                        i23 = max;
                    } else {
                        throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                    }
                }
                i27++;
                virtualChildCount = i12;
                mode2 = i11;
            } else {
                int i32 = i23;
                if (this.mTotalLength > 0) {
                    i3 = virtualChildCount;
                    if (hasDividerBeforeChildAt(i3)) {
                        this.mTotalLength += this.mDividerHeight;
                    }
                } else {
                    i3 = virtualChildCount;
                }
                if (z3 && (mode2 == Integer.MIN_VALUE || mode2 == 0)) {
                    this.mTotalLength = 0;
                    int i33 = 0;
                    while (i33 < i3) {
                        View virtualChildAt2 = getVirtualChildAt(i33);
                        if (virtualChildAt2 == null) {
                            this.mTotalLength += measureNullChild(i33);
                        } else if (virtualChildAt2.getVisibility() == i28) {
                            i33 += getChildrenSkipCount(virtualChildAt2, i33);
                        } else {
                            LayoutParams layoutParams2 = (LayoutParams) virtualChildAt2.getLayoutParams();
                            int i34 = this.mTotalLength;
                            this.mTotalLength = Math.max(i34, i34 + i24 + layoutParams2.topMargin + layoutParams2.bottomMargin + getNextLocationOffset(virtualChildAt2));
                        }
                        i33++;
                        i28 = 8;
                    }
                }
                int paddingTop = this.mTotalLength + getPaddingTop() + getPaddingBottom();
                this.mTotalLength = paddingTop;
                int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i2, 0);
                int i35 = (16777215 & resolveSizeAndState) - this.mTotalLength;
                if (z4 || (i35 != 0 && f > 0.0f)) {
                    float f3 = this.mWeightSum;
                    if (f3 > 0.0f) {
                        f = f3;
                    }
                    this.mTotalLength = 0;
                    int i36 = i35;
                    int i37 = i26;
                    i5 = i22;
                    int i38 = 0;
                    while (i38 < i3) {
                        View virtualChildAt3 = getVirtualChildAt(i38);
                        if (virtualChildAt3.getVisibility() == 8) {
                            i7 = i36;
                        } else {
                            LayoutParams layoutParams3 = (LayoutParams) virtualChildAt3.getLayoutParams();
                            float f4 = layoutParams3.weight;
                            if (f4 > 0.0f) {
                                int i39 = (int) ((((float) i36) * f4) / f);
                                float f5 = f - f4;
                                i7 = i36 - i39;
                                int childMeasureSpec = getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + layoutParams3.leftMargin + layoutParams3.rightMargin, layoutParams3.width);
                                if (layoutParams3.height == 0) {
                                    i10 = 1073741824;
                                    if (mode2 == 1073741824) {
                                        if (i39 <= 0) {
                                            i39 = 0;
                                        }
                                        virtualChildAt3.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(i39, 1073741824));
                                        i5 = View.combineMeasuredStates(i5, virtualChildAt3.getMeasuredState() & -256);
                                        f = f5;
                                    }
                                } else {
                                    i10 = 1073741824;
                                }
                                int measuredHeight2 = virtualChildAt3.getMeasuredHeight() + i39;
                                if (measuredHeight2 < 0) {
                                    measuredHeight2 = 0;
                                }
                                virtualChildAt3.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(measuredHeight2, i10));
                                i5 = View.combineMeasuredStates(i5, virtualChildAt3.getMeasuredState() & -256);
                                f = f5;
                            } else {
                                i7 = i36;
                            }
                            int i40 = layoutParams3.leftMargin + layoutParams3.rightMargin;
                            int measuredWidth2 = virtualChildAt3.getMeasuredWidth() + i40;
                            i32 = Math.max(i32, measuredWidth2);
                            if (mode != 1073741824) {
                                i8 = i5;
                                i9 = -1;
                                if (layoutParams3.width == -1) {
                                    z = true;
                                    if (!z) {
                                        i40 = measuredWidth2;
                                    }
                                    int max2 = Math.max(i37, i40);
                                    boolean z7 = !z5 && layoutParams3.width == i9;
                                    int i41 = this.mTotalLength;
                                    this.mTotalLength = Math.max(i41, virtualChildAt3.getMeasuredHeight() + i41 + layoutParams3.topMargin + layoutParams3.bottomMargin + getNextLocationOffset(virtualChildAt3));
                                    z5 = z7;
                                    i5 = i8;
                                    i37 = max2;
                                    f = f;
                                }
                            } else {
                                i8 = i5;
                                i9 = -1;
                            }
                            z = false;
                            if (!z) {
                            }
                            int max2 = Math.max(i37, i40);
                            if (!z5) {
                            }
                            int i41 = this.mTotalLength;
                            this.mTotalLength = Math.max(i41, virtualChildAt3.getMeasuredHeight() + i41 + layoutParams3.topMargin + layoutParams3.bottomMargin + getNextLocationOffset(virtualChildAt3));
                            z5 = z7;
                            i5 = i8;
                            i37 = max2;
                            f = f;
                        }
                        i38++;
                        i36 = i7;
                    }
                    i4 = i;
                    this.mTotalLength += getPaddingTop() + getPaddingBottom();
                    i6 = i37;
                } else {
                    i6 = Math.max(i26, i25);
                    if (z3 && mode2 != 1073741824) {
                        for (int i42 = 0; i42 < i3; i42++) {
                            View virtualChildAt4 = getVirtualChildAt(i42);
                            if (!(virtualChildAt4 == null || virtualChildAt4.getVisibility() == 8 || ((LayoutParams) virtualChildAt4.getLayoutParams()).weight <= 0.0f)) {
                                virtualChildAt4.measure(View.MeasureSpec.makeMeasureSpec(virtualChildAt4.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(i24, 1073741824));
                            }
                        }
                    }
                    i4 = i;
                    i5 = i22;
                }
                if (z5 || mode == 1073741824) {
                    i6 = i32;
                }
                setMeasuredDimension(View.resolveSizeAndState(Math.max(i6 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i4, i5), resolveSizeAndState);
                if (z6) {
                    forceUniformWidth(i3, i2);
                    return;
                }
                return;
            }
        }
    }

    private void forceUniformWidth(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View virtualChildAt = getVirtualChildAt(i3);
            if (virtualChildAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (layoutParams.width == -1) {
                    int i4 = layoutParams.height;
                    layoutParams.height = virtualChildAt.getMeasuredHeight();
                    measureChildWithMargins(virtualChildAt, makeMeasureSpec, 0, i2, 0);
                    layoutParams.height = i4;
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:187:0x0454  */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x0457  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0199  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x019c  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01d0  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01db  */
    void measureHorizontal(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        float f;
        int i12;
        boolean z;
        int baseline;
        int i13;
        int i14;
        boolean z2;
        boolean z3;
        int i15;
        int i16;
        View view;
        int i17;
        boolean z4;
        int measuredHeight;
        int baseline2;
        int i18;
        this.mTotalLength = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (this.mMaxAscent == null || this.mMaxDescent == null) {
            this.mMaxAscent = new int[4];
            this.mMaxDescent = new int[4];
        }
        int[] iArr = this.mMaxAscent;
        int[] iArr2 = this.mMaxDescent;
        iArr[3] = -1;
        iArr[2] = -1;
        iArr[1] = -1;
        iArr[0] = -1;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        boolean z5 = this.mBaselineAligned;
        boolean z6 = this.mUseLargestChild;
        int i19 = 1073741824;
        boolean z7 = mode == 1073741824;
        float f2 = 0.0f;
        int i20 = 0;
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        boolean z8 = false;
        int i25 = 0;
        boolean z9 = true;
        boolean z10 = false;
        while (i20 < virtualChildCount) {
            View virtualChildAt = getVirtualChildAt(i20);
            if (virtualChildAt == null) {
                this.mTotalLength += measureNullChild(i20);
            } else if (virtualChildAt.getVisibility() == 8) {
                i20 += getChildrenSkipCount(virtualChildAt, i20);
            } else {
                if (hasDividerBeforeChildAt(i20)) {
                    this.mTotalLength += this.mDividerWidth;
                }
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                float f3 = f2 + layoutParams.weight;
                if (mode == i19 && layoutParams.width == 0 && layoutParams.weight > 0.0f) {
                    if (z7) {
                        this.mTotalLength += layoutParams.leftMargin + layoutParams.rightMargin;
                    } else {
                        int i26 = this.mTotalLength;
                        this.mTotalLength = Math.max(i26, layoutParams.leftMargin + i26 + layoutParams.rightMargin);
                    }
                    if (z5) {
                        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                        virtualChildAt.measure(makeMeasureSpec, makeMeasureSpec);
                        i16 = i20;
                        z3 = z6;
                        z2 = z5;
                        view = virtualChildAt;
                    } else {
                        i16 = i20;
                        z3 = z6;
                        z2 = z5;
                        view = virtualChildAt;
                        i17 = 1073741824;
                        z8 = true;
                        if (mode2 == i17 && layoutParams.height == -1) {
                            z4 = true;
                            z10 = true;
                        } else {
                            z4 = false;
                        }
                        int i27 = layoutParams.topMargin + layoutParams.bottomMargin;
                        measuredHeight = view.getMeasuredHeight() + i27;
                        i25 = View.combineMeasuredStates(i25, view.getMeasuredState());
                        if (z2 && (baseline2 = view.getBaseline()) != -1) {
                            int i28 = ((((layoutParams.gravity >= 0 ? this.mGravity : layoutParams.gravity) & 112) >> 4) & -2) >> 1;
                            iArr[i28] = Math.max(iArr[i28], baseline2);
                            iArr2[i28] = Math.max(iArr2[i28], measuredHeight - baseline2);
                        }
                        i22 = Math.max(i22, measuredHeight);
                        z9 = !z9 && layoutParams.height == -1;
                        if (layoutParams.weight <= 0.0f) {
                            if (!z4) {
                                i27 = measuredHeight;
                            }
                            i24 = Math.max(i24, i27);
                        } else {
                            if (!z4) {
                                i27 = measuredHeight;
                            }
                            i23 = Math.max(i23, i27);
                            i24 = i24;
                        }
                        i15 = getChildrenSkipCount(view, i16) + i16;
                        f2 = f3;
                        i20 = i15 + 1;
                        iArr2 = iArr2;
                        z6 = z3;
                        z5 = z2;
                        i19 = 1073741824;
                    }
                } else {
                    if (layoutParams.width != 0 || layoutParams.weight <= 0.0f) {
                        i18 = Integer.MIN_VALUE;
                    } else {
                        layoutParams.width = -2;
                        i18 = 0;
                    }
                    i16 = i20;
                    z3 = z6;
                    z2 = z5;
                    measureChildBeforeLayout(virtualChildAt, i16, i, f3 == 0.0f ? this.mTotalLength : 0, i2, 0);
                    if (i18 != Integer.MIN_VALUE) {
                        layoutParams.width = i18;
                    }
                    int measuredWidth = virtualChildAt.getMeasuredWidth();
                    if (z7) {
                        view = virtualChildAt;
                        this.mTotalLength += layoutParams.leftMargin + measuredWidth + layoutParams.rightMargin + getNextLocationOffset(view);
                    } else {
                        view = virtualChildAt;
                        int i29 = this.mTotalLength;
                        this.mTotalLength = Math.max(i29, i29 + measuredWidth + layoutParams.leftMargin + layoutParams.rightMargin + getNextLocationOffset(view));
                    }
                    if (z3) {
                        i21 = Math.max(measuredWidth, i21);
                    }
                }
                i17 = 1073741824;
                if (mode2 == i17) {
                }
                z4 = false;
                int i27 = layoutParams.topMargin + layoutParams.bottomMargin;
                measuredHeight = view.getMeasuredHeight() + i27;
                i25 = View.combineMeasuredStates(i25, view.getMeasuredState());
                int i28 = ((((layoutParams.gravity >= 0 ? this.mGravity : layoutParams.gravity) & 112) >> 4) & -2) >> 1;
                iArr[i28] = Math.max(iArr[i28], baseline2);
                iArr2[i28] = Math.max(iArr2[i28], measuredHeight - baseline2);
                i22 = Math.max(i22, measuredHeight);
                if (!z9) {
                }
                if (layoutParams.weight <= 0.0f) {
                }
                i15 = getChildrenSkipCount(view, i16) + i16;
                f2 = f3;
                i20 = i15 + 1;
                iArr2 = iArr2;
                z6 = z3;
                z5 = z2;
                i19 = 1073741824;
            }
            i15 = i20;
            z3 = z6;
            z2 = z5;
            i20 = i15 + 1;
            iArr2 = iArr2;
            z6 = z3;
            z5 = z2;
            i19 = 1073741824;
        }
        if (this.mTotalLength > 0 && hasDividerBeforeChildAt(virtualChildCount)) {
            this.mTotalLength += this.mDividerWidth;
        }
        if (iArr[1] == -1 && iArr[0] == -1 && iArr[2] == -1 && iArr[3] == -1) {
            i4 = i22;
            i3 = i25;
        } else {
            i3 = i25;
            i4 = Math.max(i22, Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))));
        }
        if (z6 && (mode == Integer.MIN_VALUE || mode == 0)) {
            this.mTotalLength = 0;
            int i30 = 0;
            while (i30 < virtualChildCount) {
                View virtualChildAt2 = getVirtualChildAt(i30);
                if (virtualChildAt2 == null) {
                    this.mTotalLength += measureNullChild(i30);
                } else if (virtualChildAt2.getVisibility() == 8) {
                    i30 += getChildrenSkipCount(virtualChildAt2, i30);
                } else {
                    LayoutParams layoutParams2 = (LayoutParams) virtualChildAt2.getLayoutParams();
                    if (z7) {
                        this.mTotalLength += layoutParams2.leftMargin + i21 + layoutParams2.rightMargin + getNextLocationOffset(virtualChildAt2);
                    } else {
                        int i31 = this.mTotalLength;
                        i14 = i4;
                        this.mTotalLength = Math.max(i31, i31 + i21 + layoutParams2.leftMargin + layoutParams2.rightMargin + getNextLocationOffset(virtualChildAt2));
                        i30++;
                        i4 = i14;
                    }
                }
                i14 = i4;
                i30++;
                i4 = i14;
            }
        }
        int paddingLeft = this.mTotalLength + getPaddingLeft() + getPaddingRight();
        this.mTotalLength = paddingLeft;
        int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i, 0);
        int i32 = (16777215 & resolveSizeAndState) - this.mTotalLength;
        if (z8 || (i32 != 0 && f2 > 0.0f)) {
            float f4 = this.mWeightSum;
            if (f4 > 0.0f) {
                f2 = f4;
            }
            iArr[3] = -1;
            iArr[2] = -1;
            iArr[1] = -1;
            iArr[0] = -1;
            iArr2[3] = -1;
            iArr2[2] = -1;
            iArr2[1] = -1;
            iArr2[0] = -1;
            this.mTotalLength = 0;
            int i33 = i23;
            int i34 = i3;
            int i35 = -1;
            int i36 = 0;
            while (i36 < virtualChildCount) {
                View virtualChildAt3 = getVirtualChildAt(i36);
                if (virtualChildAt3 == null || virtualChildAt3.getVisibility() == 8) {
                    i11 = i32;
                    i10 = virtualChildCount;
                } else {
                    LayoutParams layoutParams3 = (LayoutParams) virtualChildAt3.getLayoutParams();
                    float f5 = layoutParams3.weight;
                    if (f5 > 0.0f) {
                        int i37 = (int) ((((float) i32) * f5) / f2);
                        float f6 = f2 - f5;
                        int i38 = i32 - i37;
                        i10 = virtualChildCount;
                        int childMeasureSpec = getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom() + layoutParams3.topMargin + layoutParams3.bottomMargin, layoutParams3.height);
                        if (layoutParams3.width == 0) {
                            i13 = 1073741824;
                            if (mode == 1073741824) {
                                if (i37 <= 0) {
                                    i37 = 0;
                                }
                                virtualChildAt3.measure(View.MeasureSpec.makeMeasureSpec(i37, 1073741824), childMeasureSpec);
                                i34 = View.combineMeasuredStates(i34, virtualChildAt3.getMeasuredState() & -16777216);
                                f2 = f6;
                                i11 = i38;
                            }
                        } else {
                            i13 = 1073741824;
                        }
                        int measuredWidth2 = virtualChildAt3.getMeasuredWidth() + i37;
                        if (measuredWidth2 < 0) {
                            measuredWidth2 = 0;
                        }
                        virtualChildAt3.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth2, i13), childMeasureSpec);
                        i34 = View.combineMeasuredStates(i34, virtualChildAt3.getMeasuredState() & -16777216);
                        f2 = f6;
                        i11 = i38;
                    } else {
                        i11 = i32;
                        i10 = virtualChildCount;
                    }
                    if (z7) {
                        this.mTotalLength += virtualChildAt3.getMeasuredWidth() + layoutParams3.leftMargin + layoutParams3.rightMargin + getNextLocationOffset(virtualChildAt3);
                        f = f2;
                    } else {
                        int i39 = this.mTotalLength;
                        f = f2;
                        this.mTotalLength = Math.max(i39, virtualChildAt3.getMeasuredWidth() + i39 + layoutParams3.leftMargin + layoutParams3.rightMargin + getNextLocationOffset(virtualChildAt3));
                    }
                    boolean z11 = mode2 != 1073741824 && layoutParams3.height == -1;
                    int i40 = layoutParams3.topMargin + layoutParams3.bottomMargin;
                    int measuredHeight2 = virtualChildAt3.getMeasuredHeight() + i40;
                    i35 = Math.max(i35, measuredHeight2);
                    if (!z11) {
                        i40 = measuredHeight2;
                    }
                    int max = Math.max(i33, i40);
                    if (z9) {
                        i12 = -1;
                        if (layoutParams3.height == -1) {
                            z = true;
                            if (z5 && (baseline = virtualChildAt3.getBaseline()) != i12) {
                                int i41 = ((((layoutParams3.gravity >= 0 ? this.mGravity : layoutParams3.gravity) & 112) >> 4) & -2) >> 1;
                                iArr[i41] = Math.max(iArr[i41], baseline);
                                iArr2[i41] = Math.max(iArr2[i41], measuredHeight2 - baseline);
                            }
                            z9 = z;
                            i33 = max;
                            f2 = f;
                        }
                    } else {
                        i12 = -1;
                    }
                    z = false;
                    int i41 = ((((layoutParams3.gravity >= 0 ? this.mGravity : layoutParams3.gravity) & 112) >> 4) & -2) >> 1;
                    iArr[i41] = Math.max(iArr[i41], baseline);
                    iArr2[i41] = Math.max(iArr2[i41], measuredHeight2 - baseline);
                    z9 = z;
                    i33 = max;
                    f2 = f;
                }
                i36++;
                i32 = i11;
                virtualChildCount = i10;
            }
            i7 = i2;
            i5 = virtualChildCount;
            this.mTotalLength += getPaddingLeft() + getPaddingRight();
            if (iArr[1] == -1 && iArr[0] == -1 && iArr[2] == -1 && iArr[3] == -1) {
                i9 = i35;
            } else {
                i9 = Math.max(i35, Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))));
            }
            i6 = i9;
            i8 = i33;
            i3 = i34;
        } else {
            i8 = Math.max(i23, i24);
            if (z6 && mode != 1073741824) {
                for (int i42 = 0; i42 < virtualChildCount; i42++) {
                    View virtualChildAt4 = getVirtualChildAt(i42);
                    if (!(virtualChildAt4 == null || virtualChildAt4.getVisibility() == 8 || ((LayoutParams) virtualChildAt4.getLayoutParams()).weight <= 0.0f)) {
                        virtualChildAt4.measure(View.MeasureSpec.makeMeasureSpec(i21, 1073741824), View.MeasureSpec.makeMeasureSpec(virtualChildAt4.getMeasuredHeight(), 1073741824));
                    }
                }
            }
            i7 = i2;
            i5 = virtualChildCount;
            i6 = i4;
        }
        if (z9 || mode2 == 1073741824) {
            i8 = i6;
        }
        setMeasuredDimension(resolveSizeAndState | (i3 & -16777216), View.resolveSizeAndState(Math.max(i8 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i7, i3 << 16));
        if (z10) {
            forceUniformHeight(i5, i);
        }
    }

    private void forceUniformHeight(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View virtualChildAt = getVirtualChildAt(i3);
            if (virtualChildAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (layoutParams.height == -1) {
                    int i4 = layoutParams.width;
                    layoutParams.width = virtualChildAt.getMeasuredWidth();
                    measureChildWithMargins(virtualChildAt, i2, 0, makeMeasureSpec, 0);
                    layoutParams.width = i4;
                }
            }
        }
    }

    void measureChildBeforeLayout(View view, int i, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.mOrientation == 1) {
            layoutVertical(i, i2, i3, i4);
        } else {
            layoutHorizontal(i, i2, i3, i4);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x009f  */
    void layoutVertical(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int paddingLeft = getPaddingLeft();
        int i9 = i3 - i;
        int paddingRight = i9 - getPaddingRight();
        int paddingRight2 = (i9 - paddingLeft) - getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        int i10 = this.mGravity;
        int i11 = i10 & 112;
        int i12 = i10 & 8388615;
        if (i11 == 16) {
            i5 = getPaddingTop() + (((i4 - i2) - this.mTotalLength) / 2);
        } else if (i11 != 80) {
            i5 = getPaddingTop();
        } else {
            i5 = ((getPaddingTop() + i4) - i2) - this.mTotalLength;
        }
        int i13 = 0;
        while (i13 < virtualChildCount) {
            View virtualChildAt = getVirtualChildAt(i13);
            if (virtualChildAt == null) {
                i5 += measureNullChild(i13);
            } else if (virtualChildAt.getVisibility() != 8) {
                int measuredWidth = virtualChildAt.getMeasuredWidth();
                int measuredHeight = virtualChildAt.getMeasuredHeight();
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                int i14 = layoutParams.gravity;
                if (i14 < 0) {
                    i14 = i12;
                }
                int absoluteGravity = GravityCompat.getAbsoluteGravity(i14, ViewCompat.getLayoutDirection(this)) & 7;
                if (absoluteGravity == 1) {
                    i8 = ((paddingRight2 - measuredWidth) / 2) + paddingLeft + layoutParams.leftMargin;
                    i7 = layoutParams.rightMargin;
                } else if (absoluteGravity != 5) {
                    i6 = layoutParams.leftMargin + paddingLeft;
                    if (hasDividerBeforeChildAt(i13)) {
                        i5 += this.mDividerHeight;
                    }
                    int i15 = i5 + layoutParams.topMargin;
                    setChildFrame(virtualChildAt, i6, i15 + getLocationOffset(virtualChildAt), measuredWidth, measuredHeight);
                    i13 += getChildrenSkipCount(virtualChildAt, i13);
                    i5 = i15 + measuredHeight + layoutParams.bottomMargin + getNextLocationOffset(virtualChildAt);
                } else {
                    i8 = paddingRight - measuredWidth;
                    i7 = layoutParams.rightMargin;
                }
                i6 = i8 - i7;
                if (hasDividerBeforeChildAt(i13)) {
                }
                int i15 = i5 + layoutParams.topMargin;
                setChildFrame(virtualChildAt, i6, i15 + getLocationOffset(virtualChildAt), measuredWidth, measuredHeight);
                i13 += getChildrenSkipCount(virtualChildAt, i13);
                i5 = i15 + measuredHeight + layoutParams.bottomMargin + getNextLocationOffset(virtualChildAt);
            }
            i13++;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00f7  */
    void layoutHorizontal(int i, int i2, int i3, int i4) {
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
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        int paddingTop = getPaddingTop();
        int i15 = i4 - i2;
        int paddingBottom = i15 - getPaddingBottom();
        int paddingBottom2 = (i15 - paddingTop) - getPaddingBottom();
        int virtualChildCount = getVirtualChildCount();
        int i16 = this.mGravity;
        int i17 = i16 & 112;
        boolean z = this.mBaselineAligned;
        int[] iArr = this.mMaxAscent;
        int[] iArr2 = this.mMaxDescent;
        int absoluteGravity = GravityCompat.getAbsoluteGravity(8388615 & i16, ViewCompat.getLayoutDirection(this));
        if (absoluteGravity == 1) {
            i5 = getPaddingLeft() + (((i3 - i) - this.mTotalLength) / 2);
        } else if (absoluteGravity != 5) {
            i5 = getPaddingLeft();
        } else {
            i5 = ((getPaddingLeft() + i3) - i) - this.mTotalLength;
        }
        if (isLayoutRtl) {
            i7 = virtualChildCount - 1;
            i6 = -1;
        } else {
            i7 = 0;
            i6 = 1;
        }
        int i18 = 0;
        while (i18 < virtualChildCount) {
            int i19 = i7 + (i6 * i18);
            View virtualChildAt = getVirtualChildAt(i19);
            if (virtualChildAt == null) {
                i5 += measureNullChild(i19);
            } else if (virtualChildAt.getVisibility() != 8) {
                int measuredWidth = virtualChildAt.getMeasuredWidth();
                int measuredHeight = virtualChildAt.getMeasuredHeight();
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (z) {
                    i10 = virtualChildCount;
                    if (layoutParams.height != -1) {
                        i11 = virtualChildAt.getBaseline();
                        i12 = layoutParams.gravity;
                        if (i12 < 0) {
                            i12 = i17;
                        }
                        i13 = i12 & 112;
                        i9 = i17;
                        if (i13 != 16) {
                            i14 = ((((paddingBottom2 - measuredHeight) / 2) + paddingTop) + layoutParams.topMargin) - layoutParams.bottomMargin;
                        } else if (i13 == 48) {
                            i14 = layoutParams.topMargin + paddingTop;
                            if (i11 != -1) {
                                i14 += iArr[1] - i11;
                            }
                        } else if (i13 != 80) {
                            i14 = paddingTop;
                        } else {
                            i14 = (paddingBottom - measuredHeight) - layoutParams.bottomMargin;
                            if (i11 != -1) {
                                i14 -= iArr2[2] - (virtualChildAt.getMeasuredHeight() - i11);
                            }
                        }
                        if (hasDividerBeforeChildAt(i19)) {
                            i5 += this.mDividerWidth;
                        }
                        int i20 = layoutParams.leftMargin + i5;
                        i8 = paddingTop;
                        setChildFrame(virtualChildAt, i20 + getLocationOffset(virtualChildAt), i14, measuredWidth, measuredHeight);
                        i18 += getChildrenSkipCount(virtualChildAt, i19);
                        i5 = i20 + measuredWidth + layoutParams.rightMargin + getNextLocationOffset(virtualChildAt);
                        i18++;
                        virtualChildCount = i10;
                        i17 = i9;
                        paddingTop = i8;
                    }
                } else {
                    i10 = virtualChildCount;
                }
                i11 = -1;
                i12 = layoutParams.gravity;
                if (i12 < 0) {
                }
                i13 = i12 & 112;
                i9 = i17;
                if (i13 != 16) {
                }
                if (hasDividerBeforeChildAt(i19)) {
                }
                int i20 = layoutParams.leftMargin + i5;
                i8 = paddingTop;
                setChildFrame(virtualChildAt, i20 + getLocationOffset(virtualChildAt), i14, measuredWidth, measuredHeight);
                i18 += getChildrenSkipCount(virtualChildAt, i19);
                i5 = i20 + measuredWidth + layoutParams.rightMargin + getNextLocationOffset(virtualChildAt);
                i18++;
                virtualChildCount = i10;
                i17 = i9;
                paddingTop = i8;
            }
            i8 = paddingTop;
            i10 = virtualChildCount;
            i9 = i17;
            i18++;
            virtualChildCount = i10;
            i17 = i9;
            paddingTop = i8;
        }
    }

    private void setChildFrame(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i3 + i, i4 + i2);
    }

    public void setOrientation(int i) {
        if (this.mOrientation != i) {
            this.mOrientation = i;
            requestLayout();
        }
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public void setGravity(int i) {
        if (this.mGravity != i) {
            if ((8388615 & i) == 0) {
                i |= 8388611;
            }
            if ((i & 112) == 0) {
                i |= 48;
            }
            this.mGravity = i;
            requestLayout();
        }
    }

    public int getGravity() {
        return this.mGravity;
    }

    public void setHorizontalGravity(int i) {
        int i2 = i & 8388615;
        int i3 = this.mGravity;
        if ((8388615 & i3) != i2) {
            this.mGravity = i2 | (-8388616 & i3);
            requestLayout();
        }
    }

    public void setVerticalGravity(int i) {
        int i2 = i & 112;
        int i3 = this.mGravity;
        if ((i3 & 112) != i2) {
            this.mGravity = i2 | (i3 & -113);
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        int i = this.mOrientation;
        if (i == 0) {
            return new LayoutParams(-2, -2);
        }
        if (i == 1) {
            return new LayoutParams(-1, -2);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public int gravity;
        public float weight;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.gravity = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.LinearLayoutCompat_Layout);
            this.weight = obtainStyledAttributes.getFloat(R.styleable.LinearLayoutCompat_Layout_android_layout_weight, 0.0f);
            this.gravity = obtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_Layout_android_layout_gravity, -1);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.gravity = -1;
            this.weight = 0.0f;
        }

        public LayoutParams(int i, int i2, float f) {
            super(i, i2);
            this.gravity = -1;
            this.weight = f;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = -1;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.gravity = -1;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.gravity = -1;
            this.weight = layoutParams.weight;
            this.gravity = layoutParams.gravity;
        }
    }
}
