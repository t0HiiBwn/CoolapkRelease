package com.google.android.flexbox;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import com.google.android.flexbox.FlexboxHelper;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

public class FlexboxLayout extends ViewGroup implements FlexContainer {
    public static final int SHOW_DIVIDER_BEGINNING = 1;
    public static final int SHOW_DIVIDER_END = 4;
    public static final int SHOW_DIVIDER_MIDDLE = 2;
    public static final int SHOW_DIVIDER_NONE = 0;
    private int mAlignContent;
    private int mAlignItems;
    private Drawable mDividerDrawableHorizontal;
    private Drawable mDividerDrawableVertical;
    private int mDividerHorizontalHeight;
    private int mDividerVerticalWidth;
    private int mFlexDirection;
    private List<FlexLine> mFlexLines;
    private FlexboxHelper.FlexLinesResult mFlexLinesResult;
    private int mFlexWrap;
    private FlexboxHelper mFlexboxHelper;
    private int mJustifyContent;
    private int mMaxLine;
    private SparseIntArray mOrderCache;
    private int[] mReorderedIndices;
    private int mShowDividerHorizontal;
    private int mShowDividerVertical;

    @Retention(RetentionPolicy.SOURCE)
    public @interface DividerMode {
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getDecorationLengthCrossAxis(View view) {
        return 0;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void updateViewCache(int i, View view) {
    }

    public FlexboxLayout(Context context) {
        this(context, null);
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMaxLine = -1;
        this.mFlexboxHelper = new FlexboxHelper(this);
        this.mFlexLines = new ArrayList();
        this.mFlexLinesResult = new FlexboxHelper.FlexLinesResult();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FlexboxLayout, i, 0);
        this.mFlexDirection = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_flexDirection, 0);
        this.mFlexWrap = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_flexWrap, 0);
        this.mJustifyContent = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_justifyContent, 0);
        this.mAlignItems = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_alignItems, 0);
        this.mAlignContent = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_alignContent, 0);
        this.mMaxLine = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_maxLine, -1);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.FlexboxLayout_dividerDrawable);
        if (drawable != null) {
            setDividerDrawableHorizontal(drawable);
            setDividerDrawableVertical(drawable);
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(R.styleable.FlexboxLayout_dividerDrawableHorizontal);
        if (drawable2 != null) {
            setDividerDrawableHorizontal(drawable2);
        }
        Drawable drawable3 = obtainStyledAttributes.getDrawable(R.styleable.FlexboxLayout_dividerDrawableVertical);
        if (drawable3 != null) {
            setDividerDrawableVertical(drawable3);
        }
        int i2 = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_showDivider, 0);
        if (i2 != 0) {
            this.mShowDividerVertical = i2;
            this.mShowDividerHorizontal = i2;
        }
        int i3 = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_showDividerVertical, 0);
        if (i3 != 0) {
            this.mShowDividerVertical = i3;
        }
        int i4 = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_showDividerHorizontal, 0);
        if (i4 != 0) {
            this.mShowDividerHorizontal = i4;
        }
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.mOrderCache == null) {
            this.mOrderCache = new SparseIntArray(getChildCount());
        }
        if (this.mFlexboxHelper.isOrderChangedFromLastMeasurement(this.mOrderCache)) {
            this.mReorderedIndices = this.mFlexboxHelper.createReorderedIndices(this.mOrderCache);
        }
        int i3 = this.mFlexDirection;
        if (i3 == 0 || i3 == 1) {
            measureHorizontal(i, i2);
        } else if (i3 == 2 || i3 == 3) {
            measureVertical(i, i2);
        } else {
            throw new IllegalStateException("Invalid value for the flex direction is set: " + this.mFlexDirection);
        }
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getFlexItemCount() {
        return getChildCount();
    }

    @Override // com.google.android.flexbox.FlexContainer
    public View getFlexItemAt(int i) {
        return getChildAt(i);
    }

    public View getReorderedChildAt(int i) {
        if (i < 0) {
            return null;
        }
        int[] iArr = this.mReorderedIndices;
        if (i >= iArr.length) {
            return null;
        }
        return getChildAt(iArr[i]);
    }

    @Override // com.google.android.flexbox.FlexContainer
    public View getReorderedFlexItemAt(int i) {
        return getReorderedChildAt(i);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (this.mOrderCache == null) {
            this.mOrderCache = new SparseIntArray(getChildCount());
        }
        this.mReorderedIndices = this.mFlexboxHelper.createReorderedIndices(view, i, layoutParams, this.mOrderCache);
        super.addView(view, i, layoutParams);
    }

    private void measureHorizontal(int i, int i2) {
        this.mFlexLines.clear();
        this.mFlexLinesResult.reset();
        this.mFlexboxHelper.calculateHorizontalFlexLines(this.mFlexLinesResult, i, i2);
        this.mFlexLines = this.mFlexLinesResult.mFlexLines;
        this.mFlexboxHelper.determineMainSize(i, i2);
        if (this.mAlignItems == 3) {
            for (FlexLine flexLine : this.mFlexLines) {
                int i3 = Integer.MIN_VALUE;
                for (int i4 = 0; i4 < flexLine.mItemCount; i4++) {
                    View reorderedChildAt = getReorderedChildAt(flexLine.mFirstIndex + i4);
                    if (!(reorderedChildAt == null || reorderedChildAt.getVisibility() == 8)) {
                        LayoutParams layoutParams = (LayoutParams) reorderedChildAt.getLayoutParams();
                        if (this.mFlexWrap != 2) {
                            i3 = Math.max(i3, reorderedChildAt.getMeasuredHeight() + Math.max(flexLine.mMaxBaseline - reorderedChildAt.getBaseline(), layoutParams.topMargin) + layoutParams.bottomMargin);
                        } else {
                            i3 = Math.max(i3, reorderedChildAt.getMeasuredHeight() + layoutParams.topMargin + Math.max((flexLine.mMaxBaseline - reorderedChildAt.getMeasuredHeight()) + reorderedChildAt.getBaseline(), layoutParams.bottomMargin));
                        }
                    }
                }
                flexLine.mCrossSize = i3;
            }
        }
        this.mFlexboxHelper.determineCrossSize(i, i2, getPaddingTop() + getPaddingBottom());
        this.mFlexboxHelper.stretchViews();
        setMeasuredDimensionForFlex(this.mFlexDirection, i, i2, this.mFlexLinesResult.mChildState);
    }

    private void measureVertical(int i, int i2) {
        this.mFlexLines.clear();
        this.mFlexLinesResult.reset();
        this.mFlexboxHelper.calculateVerticalFlexLines(this.mFlexLinesResult, i, i2);
        this.mFlexLines = this.mFlexLinesResult.mFlexLines;
        this.mFlexboxHelper.determineMainSize(i, i2);
        this.mFlexboxHelper.determineCrossSize(i, i2, getPaddingLeft() + getPaddingRight());
        this.mFlexboxHelper.stretchViews();
        setMeasuredDimensionForFlex(this.mFlexDirection, i, i2, this.mFlexLinesResult.mChildState);
    }

    private void setMeasuredDimensionForFlex(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (i == 0 || i == 1) {
            i5 = getSumOfCrossSize() + getPaddingTop() + getPaddingBottom();
            i6 = getLargestMainSize();
        } else if (i == 2 || i == 3) {
            i5 = getLargestMainSize();
            i6 = getSumOfCrossSize() + getPaddingLeft() + getPaddingRight();
        } else {
            throw new IllegalArgumentException("Invalid flex direction: " + i);
        }
        if (mode == Integer.MIN_VALUE) {
            if (size < i6) {
                i4 = View.combineMeasuredStates(i4, 16777216);
            } else {
                size = i6;
            }
            i7 = View.resolveSizeAndState(size, i2, i4);
        } else if (mode == 0) {
            i7 = View.resolveSizeAndState(i6, i2, i4);
        } else if (mode == 1073741824) {
            if (size < i6) {
                i4 = View.combineMeasuredStates(i4, 16777216);
            }
            i7 = View.resolveSizeAndState(size, i2, i4);
        } else {
            throw new IllegalStateException("Unknown width mode is set: " + mode);
        }
        if (mode2 == Integer.MIN_VALUE) {
            if (size2 < i5) {
                i4 = View.combineMeasuredStates(i4, 256);
            } else {
                size2 = i5;
            }
            i8 = View.resolveSizeAndState(size2, i3, i4);
        } else if (mode2 == 0) {
            i8 = View.resolveSizeAndState(i5, i3, i4);
        } else if (mode2 == 1073741824) {
            if (size2 < i5) {
                i4 = View.combineMeasuredStates(i4, 256);
            }
            i8 = View.resolveSizeAndState(size2, i3, i4);
        } else {
            throw new IllegalStateException("Unknown height mode is set: " + mode2);
        }
        setMeasuredDimension(i7, i8);
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getLargestMainSize() {
        int i = Integer.MIN_VALUE;
        for (FlexLine flexLine : this.mFlexLines) {
            i = Math.max(i, flexLine.mMainSize);
        }
        return i;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getSumOfCrossSize() {
        int i;
        int i2;
        int size = this.mFlexLines.size();
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            FlexLine flexLine = this.mFlexLines.get(i4);
            if (hasDividerBeforeFlexLine(i4)) {
                if (isMainAxisDirectionHorizontal()) {
                    i2 = this.mDividerHorizontalHeight;
                } else {
                    i2 = this.mDividerVerticalWidth;
                }
                i3 += i2;
            }
            if (hasEndDividerAfterFlexLine(i4)) {
                if (isMainAxisDirectionHorizontal()) {
                    i = this.mDividerHorizontalHeight;
                } else {
                    i = this.mDividerVerticalWidth;
                }
                i3 += i;
            }
            i3 += flexLine.mCrossSize;
        }
        return i3;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public boolean isMainAxisDirectionHorizontal() {
        int i = this.mFlexDirection;
        return i == 0 || i == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int i5 = this.mFlexDirection;
        boolean z2 = false;
        if (i5 == 0) {
            layoutHorizontal(layoutDirection == 1, i, i2, i3, i4);
        } else if (i5 == 1) {
            layoutHorizontal(layoutDirection != 1, i, i2, i3, i4);
        } else if (i5 == 2) {
            if (layoutDirection == 1) {
                z2 = true;
            }
            layoutVertical(this.mFlexWrap == 2 ? !z2 : z2, false, i, i2, i3, i4);
        } else if (i5 == 3) {
            if (layoutDirection == 1) {
                z2 = true;
            }
            layoutVertical(this.mFlexWrap == 2 ? !z2 : z2, true, i, i2, i3, i4);
        } else {
            throw new IllegalStateException("Invalid flex direction is set: " + this.mFlexDirection);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0184  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01e7  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01f4  */
    private void layoutHorizontal(boolean z, int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float f3;
        int i5;
        int i6;
        int i7;
        int i8;
        float f4;
        int i9;
        LayoutParams layoutParams;
        int i10;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int i11 = i3 - i;
        int paddingBottom = (i4 - i2) - getPaddingBottom();
        int paddingTop = getPaddingTop();
        int size = this.mFlexLines.size();
        int i12 = 0;
        while (i12 < size) {
            FlexLine flexLine = this.mFlexLines.get(i12);
            if (hasDividerBeforeFlexLine(i12)) {
                int i13 = this.mDividerHorizontalHeight;
                paddingBottom -= i13;
                paddingTop += i13;
            }
            int i14 = this.mJustifyContent;
            int i15 = 1;
            if (i14 == 0) {
                f3 = (float) paddingLeft;
                i10 = i11 - paddingRight;
            } else if (i14 == 1) {
                f3 = (float) ((i11 - flexLine.mMainSize) + paddingRight);
                i10 = flexLine.mMainSize - paddingLeft;
            } else if (i14 != 2) {
                if (i14 == 3) {
                    f3 = (float) paddingLeft;
                    int itemCountNotGone = flexLine.getItemCountNotGone();
                    f2 = ((float) (i11 - flexLine.mMainSize)) / (itemCountNotGone != 1 ? (float) (itemCountNotGone - 1) : 1.0f);
                    f = (float) (i11 - paddingRight);
                } else if (i14 == 4) {
                    int itemCountNotGone2 = flexLine.getItemCountNotGone();
                    f2 = itemCountNotGone2 != 0 ? ((float) (i11 - flexLine.mMainSize)) / ((float) itemCountNotGone2) : 0.0f;
                    float f5 = f2 / 2.0f;
                    f3 = ((float) paddingLeft) + f5;
                    f = ((float) (i11 - paddingRight)) - f5;
                } else if (i14 == 5) {
                    int itemCountNotGone3 = flexLine.getItemCountNotGone();
                    f2 = itemCountNotGone3 != 0 ? ((float) (i11 - flexLine.mMainSize)) / ((float) (itemCountNotGone3 + 1)) : 0.0f;
                    f3 = ((float) paddingLeft) + f2;
                    f = ((float) (i11 - paddingRight)) - f2;
                } else {
                    throw new IllegalStateException("Invalid justifyContent is set: " + this.mJustifyContent);
                }
                float max = Math.max(f2, 0.0f);
                i5 = 0;
                while (i5 < flexLine.mItemCount) {
                    int i16 = flexLine.mFirstIndex + i5;
                    View reorderedChildAt = getReorderedChildAt(i16);
                    if (reorderedChildAt == null || reorderedChildAt.getVisibility() == 8) {
                        i6 = paddingLeft;
                        i7 = i5;
                    } else {
                        LayoutParams layoutParams2 = (LayoutParams) reorderedChildAt.getLayoutParams();
                        float f6 = f3 + ((float) layoutParams2.leftMargin);
                        float f7 = f - ((float) layoutParams2.rightMargin);
                        if (hasDividerBeforeChildAtAlongMainAxis(i16, i5)) {
                            int i17 = this.mDividerVerticalWidth;
                            float f8 = (float) i17;
                            f6 += f8;
                            i8 = i17;
                            f4 = f7 - f8;
                        } else {
                            f4 = f7;
                            i8 = 0;
                        }
                        if (i5 == flexLine.mItemCount - i15) {
                            if ((this.mShowDividerVertical & 4) > 0) {
                                i9 = this.mDividerVerticalWidth;
                                if (this.mFlexWrap == 2) {
                                    i6 = paddingLeft;
                                    i7 = i5;
                                    layoutParams = layoutParams2;
                                    if (z) {
                                        this.mFlexboxHelper.layoutSingleChildHorizontal(reorderedChildAt, flexLine, Math.round(f4) - reorderedChildAt.getMeasuredWidth(), paddingTop, Math.round(f4), paddingTop + reorderedChildAt.getMeasuredHeight());
                                    } else {
                                        this.mFlexboxHelper.layoutSingleChildHorizontal(reorderedChildAt, flexLine, Math.round(f6), paddingTop, Math.round(f6) + reorderedChildAt.getMeasuredWidth(), paddingTop + reorderedChildAt.getMeasuredHeight());
                                    }
                                } else if (z) {
                                    i7 = i5;
                                    i6 = paddingLeft;
                                    layoutParams = layoutParams2;
                                    this.mFlexboxHelper.layoutSingleChildHorizontal(reorderedChildAt, flexLine, Math.round(f4) - reorderedChildAt.getMeasuredWidth(), paddingBottom - reorderedChildAt.getMeasuredHeight(), Math.round(f4), paddingBottom);
                                } else {
                                    i6 = paddingLeft;
                                    i7 = i5;
                                    layoutParams = layoutParams2;
                                    this.mFlexboxHelper.layoutSingleChildHorizontal(reorderedChildAt, flexLine, Math.round(f6), paddingBottom - reorderedChildAt.getMeasuredHeight(), Math.round(f6) + reorderedChildAt.getMeasuredWidth(), paddingBottom);
                                }
                                f3 = f6 + ((float) reorderedChildAt.getMeasuredWidth()) + max + ((float) layoutParams.rightMargin);
                                float measuredWidth = f4 - ((((float) reorderedChildAt.getMeasuredWidth()) + max) + ((float) layoutParams.leftMargin));
                                if (!z) {
                                    flexLine.updatePositionFromView(reorderedChildAt, i9, 0, i8, 0);
                                } else {
                                    flexLine.updatePositionFromView(reorderedChildAt, i8, 0, i9, 0);
                                }
                                f = measuredWidth;
                            }
                        }
                        i9 = 0;
                        if (this.mFlexWrap == 2) {
                        }
                        f3 = f6 + ((float) reorderedChildAt.getMeasuredWidth()) + max + ((float) layoutParams.rightMargin);
                        float measuredWidth = f4 - ((((float) reorderedChildAt.getMeasuredWidth()) + max) + ((float) layoutParams.leftMargin));
                        if (!z) {
                        }
                        f = measuredWidth;
                    }
                    i5 = i7 + 1;
                    paddingLeft = i6;
                    i15 = 1;
                }
                paddingTop += flexLine.mCrossSize;
                paddingBottom -= flexLine.mCrossSize;
                i12++;
                paddingLeft = paddingLeft;
            } else {
                f3 = ((float) paddingLeft) + (((float) (i11 - flexLine.mMainSize)) / 2.0f);
                f = ((float) (i11 - paddingRight)) - (((float) (i11 - flexLine.mMainSize)) / 2.0f);
                f2 = 0.0f;
                float max = Math.max(f2, 0.0f);
                i5 = 0;
                while (i5 < flexLine.mItemCount) {
                }
                paddingTop += flexLine.mCrossSize;
                paddingBottom -= flexLine.mCrossSize;
                i12++;
                paddingLeft = paddingLeft;
            }
            f = (float) i10;
            f2 = 0.0f;
            float max = Math.max(f2, 0.0f);
            i5 = 0;
            while (i5 < flexLine.mItemCount) {
            }
            paddingTop += flexLine.mCrossSize;
            paddingBottom -= flexLine.mCrossSize;
            i12++;
            paddingLeft = paddingLeft;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0181  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01e4  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01f1  */
    private void layoutVertical(boolean z, boolean z2, int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float f3;
        int i5;
        int i6;
        int i7;
        float f4;
        float f5;
        int i8;
        LayoutParams layoutParams;
        int i9;
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingRight = getPaddingRight();
        int paddingLeft = getPaddingLeft();
        int i10 = i4 - i2;
        int i11 = (i3 - i) - paddingRight;
        int size = this.mFlexLines.size();
        for (int i12 = 0; i12 < size; i12++) {
            FlexLine flexLine = this.mFlexLines.get(i12);
            if (hasDividerBeforeFlexLine(i12)) {
                int i13 = this.mDividerVerticalWidth;
                paddingLeft += i13;
                i11 -= i13;
            }
            int i14 = this.mJustifyContent;
            if (i14 == 0) {
                f3 = (float) paddingTop;
                i9 = i10 - paddingBottom;
            } else if (i14 == 1) {
                f3 = (float) ((i10 - flexLine.mMainSize) + paddingBottom);
                i9 = flexLine.mMainSize - paddingTop;
            } else if (i14 != 2) {
                if (i14 == 3) {
                    f3 = (float) paddingTop;
                    int itemCountNotGone = flexLine.getItemCountNotGone();
                    f2 = ((float) (i10 - flexLine.mMainSize)) / (itemCountNotGone != 1 ? (float) (itemCountNotGone - 1) : 1.0f);
                    f = (float) (i10 - paddingBottom);
                } else if (i14 == 4) {
                    int itemCountNotGone2 = flexLine.getItemCountNotGone();
                    f2 = itemCountNotGone2 != 0 ? ((float) (i10 - flexLine.mMainSize)) / ((float) itemCountNotGone2) : 0.0f;
                    float f6 = f2 / 2.0f;
                    f3 = ((float) paddingTop) + f6;
                    f = ((float) (i10 - paddingBottom)) - f6;
                } else if (i14 == 5) {
                    int itemCountNotGone3 = flexLine.getItemCountNotGone();
                    f2 = itemCountNotGone3 != 0 ? ((float) (i10 - flexLine.mMainSize)) / ((float) (itemCountNotGone3 + 1)) : 0.0f;
                    f3 = ((float) paddingTop) + f2;
                    f = ((float) (i10 - paddingBottom)) - f2;
                } else {
                    throw new IllegalStateException("Invalid justifyContent is set: " + this.mJustifyContent);
                }
                float max = Math.max(f2, 0.0f);
                i5 = 0;
                while (i5 < flexLine.mItemCount) {
                    int i15 = flexLine.mFirstIndex + i5;
                    View reorderedChildAt = getReorderedChildAt(i15);
                    if (reorderedChildAt == null || reorderedChildAt.getVisibility() == 8) {
                        i6 = i5;
                    } else {
                        LayoutParams layoutParams2 = (LayoutParams) reorderedChildAt.getLayoutParams();
                        float f7 = f3 + ((float) layoutParams2.topMargin);
                        float f8 = f - ((float) layoutParams2.bottomMargin);
                        if (hasDividerBeforeChildAtAlongMainAxis(i15, i5)) {
                            int i16 = this.mDividerHorizontalHeight;
                            float f9 = (float) i16;
                            f5 = f7 + f9;
                            i7 = i16;
                            f4 = f8 - f9;
                        } else {
                            f5 = f7;
                            f4 = f8;
                            i7 = 0;
                        }
                        if (i5 == flexLine.mItemCount - 1) {
                            if ((this.mShowDividerHorizontal & 4) > 0) {
                                i8 = this.mDividerHorizontalHeight;
                                if (z) {
                                    i6 = i5;
                                    layoutParams = layoutParams2;
                                    if (z2) {
                                        this.mFlexboxHelper.layoutSingleChildVertical(reorderedChildAt, flexLine, false, paddingLeft, Math.round(f4) - reorderedChildAt.getMeasuredHeight(), paddingLeft + reorderedChildAt.getMeasuredWidth(), Math.round(f4));
                                    } else {
                                        this.mFlexboxHelper.layoutSingleChildVertical(reorderedChildAt, flexLine, false, paddingLeft, Math.round(f5), paddingLeft + reorderedChildAt.getMeasuredWidth(), Math.round(f5) + reorderedChildAt.getMeasuredHeight());
                                    }
                                } else if (z2) {
                                    i6 = i5;
                                    layoutParams = layoutParams2;
                                    this.mFlexboxHelper.layoutSingleChildVertical(reorderedChildAt, flexLine, true, i11 - reorderedChildAt.getMeasuredWidth(), Math.round(f4) - reorderedChildAt.getMeasuredHeight(), i11, Math.round(f4));
                                } else {
                                    i6 = i5;
                                    layoutParams = layoutParams2;
                                    this.mFlexboxHelper.layoutSingleChildVertical(reorderedChildAt, flexLine, true, i11 - reorderedChildAt.getMeasuredWidth(), Math.round(f5), i11, Math.round(f5) + reorderedChildAt.getMeasuredHeight());
                                }
                                float measuredHeight = f5 + ((float) reorderedChildAt.getMeasuredHeight()) + max + ((float) layoutParams.bottomMargin);
                                float measuredHeight2 = f4 - ((((float) reorderedChildAt.getMeasuredHeight()) + max) + ((float) layoutParams.topMargin));
                                if (!z2) {
                                    flexLine.updatePositionFromView(reorderedChildAt, 0, i8, 0, i7);
                                } else {
                                    flexLine.updatePositionFromView(reorderedChildAt, 0, i7, 0, i8);
                                }
                                f3 = measuredHeight;
                                f = measuredHeight2;
                            }
                        }
                        i8 = 0;
                        if (z) {
                        }
                        float measuredHeight = f5 + ((float) reorderedChildAt.getMeasuredHeight()) + max + ((float) layoutParams.bottomMargin);
                        float measuredHeight2 = f4 - ((((float) reorderedChildAt.getMeasuredHeight()) + max) + ((float) layoutParams.topMargin));
                        if (!z2) {
                        }
                        f3 = measuredHeight;
                        f = measuredHeight2;
                    }
                    i5 = i6 + 1;
                }
                paddingLeft += flexLine.mCrossSize;
                i11 -= flexLine.mCrossSize;
            } else {
                f3 = (((float) (i10 - flexLine.mMainSize)) / 2.0f) + ((float) paddingTop);
                f = ((float) (i10 - paddingBottom)) - (((float) (i10 - flexLine.mMainSize)) / 2.0f);
                f2 = 0.0f;
                float max = Math.max(f2, 0.0f);
                i5 = 0;
                while (i5 < flexLine.mItemCount) {
                }
                paddingLeft += flexLine.mCrossSize;
                i11 -= flexLine.mCrossSize;
            }
            f = (float) i9;
            f2 = 0.0f;
            float max = Math.max(f2, 0.0f);
            i5 = 0;
            while (i5 < flexLine.mItemCount) {
            }
            paddingLeft += flexLine.mCrossSize;
            i11 -= flexLine.mCrossSize;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mDividerDrawableVertical != null || this.mDividerDrawableHorizontal != null) {
            if (this.mShowDividerHorizontal != 0 || this.mShowDividerVertical != 0) {
                int layoutDirection = ViewCompat.getLayoutDirection(this);
                int i = this.mFlexDirection;
                boolean z = false;
                boolean z2 = true;
                if (i == 0) {
                    boolean z3 = layoutDirection == 1;
                    if (this.mFlexWrap == 2) {
                        z = true;
                    }
                    drawDividersHorizontal(canvas, z3, z);
                } else if (i == 1) {
                    boolean z4 = layoutDirection != 1;
                    if (this.mFlexWrap == 2) {
                        z = true;
                    }
                    drawDividersHorizontal(canvas, z4, z);
                } else if (i == 2) {
                    if (layoutDirection != 1) {
                        z2 = false;
                    }
                    if (this.mFlexWrap == 2) {
                        z2 = !z2;
                    }
                    drawDividersVertical(canvas, z2, false);
                } else if (i == 3) {
                    if (layoutDirection == 1) {
                        z = true;
                    }
                    if (this.mFlexWrap == 2) {
                        z = !z;
                    }
                    drawDividersVertical(canvas, z, true);
                }
            }
        }
    }

    private void drawDividersHorizontal(Canvas canvas, boolean z, boolean z2) {
        int i;
        int i2;
        int i3;
        int i4;
        int paddingLeft = getPaddingLeft();
        int max = Math.max(0, (getWidth() - getPaddingRight()) - paddingLeft);
        int size = this.mFlexLines.size();
        for (int i5 = 0; i5 < size; i5++) {
            FlexLine flexLine = this.mFlexLines.get(i5);
            for (int i6 = 0; i6 < flexLine.mItemCount; i6++) {
                int i7 = flexLine.mFirstIndex + i6;
                View reorderedChildAt = getReorderedChildAt(i7);
                if (!(reorderedChildAt == null || reorderedChildAt.getVisibility() == 8)) {
                    LayoutParams layoutParams = (LayoutParams) reorderedChildAt.getLayoutParams();
                    if (hasDividerBeforeChildAtAlongMainAxis(i7, i6)) {
                        if (z) {
                            i4 = reorderedChildAt.getRight() + layoutParams.rightMargin;
                        } else {
                            i4 = (reorderedChildAt.getLeft() - layoutParams.leftMargin) - this.mDividerVerticalWidth;
                        }
                        drawVerticalDivider(canvas, i4, flexLine.mTop, flexLine.mCrossSize);
                    }
                    if (i6 == flexLine.mItemCount - 1 && (this.mShowDividerVertical & 4) > 0) {
                        if (z) {
                            i3 = (reorderedChildAt.getLeft() - layoutParams.leftMargin) - this.mDividerVerticalWidth;
                        } else {
                            i3 = reorderedChildAt.getRight() + layoutParams.rightMargin;
                        }
                        drawVerticalDivider(canvas, i3, flexLine.mTop, flexLine.mCrossSize);
                    }
                }
            }
            if (hasDividerBeforeFlexLine(i5)) {
                if (z2) {
                    i2 = flexLine.mBottom;
                } else {
                    i2 = flexLine.mTop - this.mDividerHorizontalHeight;
                }
                drawHorizontalDivider(canvas, paddingLeft, i2, max);
            }
            if (hasEndDividerAfterFlexLine(i5) && (this.mShowDividerHorizontal & 4) > 0) {
                if (z2) {
                    i = flexLine.mTop - this.mDividerHorizontalHeight;
                } else {
                    i = flexLine.mBottom;
                }
                drawHorizontalDivider(canvas, paddingLeft, i, max);
            }
        }
    }

    private void drawDividersVertical(Canvas canvas, boolean z, boolean z2) {
        int i;
        int i2;
        int i3;
        int i4;
        int paddingTop = getPaddingTop();
        int max = Math.max(0, (getHeight() - getPaddingBottom()) - paddingTop);
        int size = this.mFlexLines.size();
        for (int i5 = 0; i5 < size; i5++) {
            FlexLine flexLine = this.mFlexLines.get(i5);
            for (int i6 = 0; i6 < flexLine.mItemCount; i6++) {
                int i7 = flexLine.mFirstIndex + i6;
                View reorderedChildAt = getReorderedChildAt(i7);
                if (!(reorderedChildAt == null || reorderedChildAt.getVisibility() == 8)) {
                    LayoutParams layoutParams = (LayoutParams) reorderedChildAt.getLayoutParams();
                    if (hasDividerBeforeChildAtAlongMainAxis(i7, i6)) {
                        if (z2) {
                            i4 = reorderedChildAt.getBottom() + layoutParams.bottomMargin;
                        } else {
                            i4 = (reorderedChildAt.getTop() - layoutParams.topMargin) - this.mDividerHorizontalHeight;
                        }
                        drawHorizontalDivider(canvas, flexLine.mLeft, i4, flexLine.mCrossSize);
                    }
                    if (i6 == flexLine.mItemCount - 1 && (this.mShowDividerHorizontal & 4) > 0) {
                        if (z2) {
                            i3 = (reorderedChildAt.getTop() - layoutParams.topMargin) - this.mDividerHorizontalHeight;
                        } else {
                            i3 = reorderedChildAt.getBottom() + layoutParams.bottomMargin;
                        }
                        drawHorizontalDivider(canvas, flexLine.mLeft, i3, flexLine.mCrossSize);
                    }
                }
            }
            if (hasDividerBeforeFlexLine(i5)) {
                if (z) {
                    i2 = flexLine.mRight;
                } else {
                    i2 = flexLine.mLeft - this.mDividerVerticalWidth;
                }
                drawVerticalDivider(canvas, i2, paddingTop, max);
            }
            if (hasEndDividerAfterFlexLine(i5) && (this.mShowDividerVertical & 4) > 0) {
                if (z) {
                    i = flexLine.mLeft - this.mDividerVerticalWidth;
                } else {
                    i = flexLine.mRight;
                }
                drawVerticalDivider(canvas, i, paddingTop, max);
            }
        }
    }

    private void drawVerticalDivider(Canvas canvas, int i, int i2, int i3) {
        Drawable drawable = this.mDividerDrawableVertical;
        if (drawable != null) {
            drawable.setBounds(i, i2, this.mDividerVerticalWidth + i, i3 + i2);
            this.mDividerDrawableVertical.draw(canvas);
        }
    }

    private void drawHorizontalDivider(Canvas canvas, int i, int i2, int i3) {
        Drawable drawable = this.mDividerDrawableHorizontal;
        if (drawable != null) {
            drawable.setBounds(i, i2, i3 + i, this.mDividerHorizontalHeight + i2);
            this.mDividerDrawableHorizontal.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getFlexDirection() {
        return this.mFlexDirection;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setFlexDirection(int i) {
        if (this.mFlexDirection != i) {
            this.mFlexDirection = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getFlexWrap() {
        return this.mFlexWrap;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setFlexWrap(int i) {
        if (this.mFlexWrap != i) {
            this.mFlexWrap = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getJustifyContent() {
        return this.mJustifyContent;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setJustifyContent(int i) {
        if (this.mJustifyContent != i) {
            this.mJustifyContent = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getAlignItems() {
        return this.mAlignItems;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setAlignItems(int i) {
        if (this.mAlignItems != i) {
            this.mAlignItems = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getAlignContent() {
        return this.mAlignContent;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setAlignContent(int i) {
        if (this.mAlignContent != i) {
            this.mAlignContent = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getMaxLine() {
        return this.mMaxLine;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setMaxLine(int i) {
        if (this.mMaxLine != i) {
            this.mMaxLine = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.FlexContainer
    public List<FlexLine> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.mFlexLines.size());
        for (FlexLine flexLine : this.mFlexLines) {
            if (flexLine.getItemCountNotGone() != 0) {
                arrayList.add(flexLine);
            }
        }
        return arrayList;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getDecorationLengthMainAxis(View view, int i, int i2) {
        int i3;
        int i4 = 0;
        if (isMainAxisDirectionHorizontal()) {
            if (hasDividerBeforeChildAtAlongMainAxis(i, i2)) {
                i4 = 0 + this.mDividerVerticalWidth;
            }
            if ((this.mShowDividerVertical & 4) <= 0) {
                return i4;
            }
            i3 = this.mDividerVerticalWidth;
        } else {
            if (hasDividerBeforeChildAtAlongMainAxis(i, i2)) {
                i4 = 0 + this.mDividerHorizontalHeight;
            }
            if ((this.mShowDividerHorizontal & 4) <= 0) {
                return i4;
            }
            i3 = this.mDividerHorizontalHeight;
        }
        return i4 + i3;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void onNewFlexLineAdded(FlexLine flexLine) {
        if (isMainAxisDirectionHorizontal()) {
            if ((this.mShowDividerVertical & 4) > 0) {
                flexLine.mMainSize += this.mDividerVerticalWidth;
                flexLine.mDividerLengthInMainSize += this.mDividerVerticalWidth;
            }
        } else if ((this.mShowDividerHorizontal & 4) > 0) {
            flexLine.mMainSize += this.mDividerHorizontalHeight;
            flexLine.mDividerLengthInMainSize += this.mDividerHorizontalHeight;
        }
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getChildWidthMeasureSpec(int i, int i2, int i3) {
        return getChildMeasureSpec(i, i2, i3);
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getChildHeightMeasureSpec(int i, int i2, int i3) {
        return getChildMeasureSpec(i, i2, i3);
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void onNewFlexItemAdded(View view, int i, int i2, FlexLine flexLine) {
        if (!hasDividerBeforeChildAtAlongMainAxis(i, i2)) {
            return;
        }
        if (isMainAxisDirectionHorizontal()) {
            flexLine.mMainSize += this.mDividerVerticalWidth;
            flexLine.mDividerLengthInMainSize += this.mDividerVerticalWidth;
            return;
        }
        flexLine.mMainSize += this.mDividerHorizontalHeight;
        flexLine.mDividerLengthInMainSize += this.mDividerHorizontalHeight;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setFlexLines(List<FlexLine> list) {
        this.mFlexLines = list;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public List<FlexLine> getFlexLinesInternal() {
        return this.mFlexLines;
    }

    public Drawable getDividerDrawableHorizontal() {
        return this.mDividerDrawableHorizontal;
    }

    public Drawable getDividerDrawableVertical() {
        return this.mDividerDrawableVertical;
    }

    public void setDividerDrawable(Drawable drawable) {
        setDividerDrawableHorizontal(drawable);
        setDividerDrawableVertical(drawable);
    }

    public void setDividerDrawableHorizontal(Drawable drawable) {
        if (drawable != this.mDividerDrawableHorizontal) {
            this.mDividerDrawableHorizontal = drawable;
            if (drawable != null) {
                this.mDividerHorizontalHeight = drawable.getIntrinsicHeight();
            } else {
                this.mDividerHorizontalHeight = 0;
            }
            setWillNotDrawFlag();
            requestLayout();
        }
    }

    public void setDividerDrawableVertical(Drawable drawable) {
        if (drawable != this.mDividerDrawableVertical) {
            this.mDividerDrawableVertical = drawable;
            if (drawable != null) {
                this.mDividerVerticalWidth = drawable.getIntrinsicWidth();
            } else {
                this.mDividerVerticalWidth = 0;
            }
            setWillNotDrawFlag();
            requestLayout();
        }
    }

    public int getShowDividerVertical() {
        return this.mShowDividerVertical;
    }

    public int getShowDividerHorizontal() {
        return this.mShowDividerHorizontal;
    }

    public void setShowDivider(int i) {
        setShowDividerVertical(i);
        setShowDividerHorizontal(i);
    }

    public void setShowDividerVertical(int i) {
        if (i != this.mShowDividerVertical) {
            this.mShowDividerVertical = i;
            requestLayout();
        }
    }

    public void setShowDividerHorizontal(int i) {
        if (i != this.mShowDividerHorizontal) {
            this.mShowDividerHorizontal = i;
            requestLayout();
        }
    }

    private void setWillNotDrawFlag() {
        if (this.mDividerDrawableHorizontal == null && this.mDividerDrawableVertical == null) {
            setWillNotDraw(true);
        } else {
            setWillNotDraw(false);
        }
    }

    private boolean hasDividerBeforeChildAtAlongMainAxis(int i, int i2) {
        if (allViewsAreGoneBefore(i, i2)) {
            if (isMainAxisDirectionHorizontal()) {
                if ((this.mShowDividerVertical & 1) != 0) {
                    return true;
                }
                return false;
            } else if ((this.mShowDividerHorizontal & 1) != 0) {
                return true;
            } else {
                return false;
            }
        } else if (isMainAxisDirectionHorizontal()) {
            if ((this.mShowDividerVertical & 2) != 0) {
                return true;
            }
            return false;
        } else if ((this.mShowDividerHorizontal & 2) != 0) {
            return true;
        } else {
            return false;
        }
    }

    private boolean allViewsAreGoneBefore(int i, int i2) {
        for (int i3 = 1; i3 <= i2; i3++) {
            View reorderedChildAt = getReorderedChildAt(i - i3);
            if (!(reorderedChildAt == null || reorderedChildAt.getVisibility() == 8)) {
                return false;
            }
        }
        return true;
    }

    private boolean hasDividerBeforeFlexLine(int i) {
        if (i < 0 || i >= this.mFlexLines.size()) {
            return false;
        }
        if (allFlexLinesAreDummyBefore(i)) {
            if (isMainAxisDirectionHorizontal()) {
                if ((this.mShowDividerHorizontal & 1) != 0) {
                    return true;
                }
                return false;
            } else if ((this.mShowDividerVertical & 1) != 0) {
                return true;
            } else {
                return false;
            }
        } else if (isMainAxisDirectionHorizontal()) {
            if ((this.mShowDividerHorizontal & 2) != 0) {
                return true;
            }
            return false;
        } else if ((this.mShowDividerVertical & 2) != 0) {
            return true;
        } else {
            return false;
        }
    }

    private boolean allFlexLinesAreDummyBefore(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (this.mFlexLines.get(i2).getItemCountNotGone() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean hasEndDividerAfterFlexLine(int i) {
        if (i < 0 || i >= this.mFlexLines.size()) {
            return false;
        }
        for (int i2 = i + 1; i2 < this.mFlexLines.size(); i2++) {
            if (this.mFlexLines.get(i2).getItemCountNotGone() > 0) {
                return false;
            }
        }
        if (isMainAxisDirectionHorizontal()) {
            if ((this.mShowDividerHorizontal & 4) != 0) {
                return true;
            }
            return false;
        } else if ((this.mShowDividerVertical & 4) != 0) {
            return true;
        } else {
            return false;
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams implements FlexItem {
        public static final Parcelable.Creator<LayoutParams> CREATOR = new Parcelable.Creator<LayoutParams>() {
            /* class com.google.android.flexbox.FlexboxLayout.LayoutParams.AnonymousClass1 */

            @Override // android.os.Parcelable.Creator
            public LayoutParams createFromParcel(Parcel parcel) {
                return new LayoutParams(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public LayoutParams[] newArray(int i) {
                return new LayoutParams[i];
            }
        };
        private int mAlignSelf = -1;
        private float mFlexBasisPercent = -1.0f;
        private float mFlexGrow = 0.0f;
        private float mFlexShrink = 1.0f;
        private int mMaxHeight = 16777215;
        private int mMaxWidth = 16777215;
        private int mMinHeight = -1;
        private int mMinWidth = -1;
        private int mOrder = 1;
        private boolean mWrapBefore;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FlexboxLayout_Layout);
            this.mOrder = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_Layout_layout_order, 1);
            this.mFlexGrow = obtainStyledAttributes.getFloat(R.styleable.FlexboxLayout_Layout_layout_flexGrow, 0.0f);
            this.mFlexShrink = obtainStyledAttributes.getFloat(R.styleable.FlexboxLayout_Layout_layout_flexShrink, 1.0f);
            this.mAlignSelf = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_Layout_layout_alignSelf, -1);
            this.mFlexBasisPercent = obtainStyledAttributes.getFraction(R.styleable.FlexboxLayout_Layout_layout_flexBasisPercent, 1, 1, -1.0f);
            this.mMinWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlexboxLayout_Layout_layout_minWidth, -1);
            this.mMinHeight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlexboxLayout_Layout_layout_minHeight, -1);
            this.mMaxWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlexboxLayout_Layout_layout_maxWidth, 16777215);
            this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlexboxLayout_Layout_layout_maxHeight, 16777215);
            this.mWrapBefore = obtainStyledAttributes.getBoolean(R.styleable.FlexboxLayout_Layout_layout_wrapBefore, false);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.mOrder = layoutParams.mOrder;
            this.mFlexGrow = layoutParams.mFlexGrow;
            this.mFlexShrink = layoutParams.mFlexShrink;
            this.mAlignSelf = layoutParams.mAlignSelf;
            this.mFlexBasisPercent = layoutParams.mFlexBasisPercent;
            this.mMinWidth = layoutParams.mMinWidth;
            this.mMinHeight = layoutParams.mMinHeight;
            this.mMaxWidth = layoutParams.mMaxWidth;
            this.mMaxHeight = layoutParams.mMaxHeight;
            this.mWrapBefore = layoutParams.mWrapBefore;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(int i, int i2) {
            super(new ViewGroup.LayoutParams(i, i2));
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getWidth() {
            return this.width;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setWidth(int i) {
            this.width = i;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getHeight() {
            return this.height;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setHeight(int i) {
            this.height = i;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getOrder() {
            return this.mOrder;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setOrder(int i) {
            this.mOrder = i;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float getFlexGrow() {
            return this.mFlexGrow;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setFlexGrow(float f) {
            this.mFlexGrow = f;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float getFlexShrink() {
            return this.mFlexShrink;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setFlexShrink(float f) {
            this.mFlexShrink = f;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getAlignSelf() {
            return this.mAlignSelf;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setAlignSelf(int i) {
            this.mAlignSelf = i;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMinWidth() {
            return this.mMinWidth;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMinWidth(int i) {
            this.mMinWidth = i;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMinHeight() {
            return this.mMinHeight;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMinHeight(int i) {
            this.mMinHeight = i;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMaxWidth() {
            return this.mMaxWidth;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMaxWidth(int i) {
            this.mMaxWidth = i;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMaxHeight() {
            return this.mMaxHeight;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMaxHeight(int i) {
            this.mMaxHeight = i;
        }

        @Override // com.google.android.flexbox.FlexItem
        public boolean isWrapBefore() {
            return this.mWrapBefore;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setWrapBefore(boolean z) {
            this.mWrapBefore = z;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float getFlexBasisPercent() {
            return this.mFlexBasisPercent;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setFlexBasisPercent(float f) {
            this.mFlexBasisPercent = f;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginLeft() {
            return this.leftMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginTop() {
            return this.topMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginRight() {
            return this.rightMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginBottom() {
            return this.bottomMargin;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.mOrder);
            parcel.writeFloat(this.mFlexGrow);
            parcel.writeFloat(this.mFlexShrink);
            parcel.writeInt(this.mAlignSelf);
            parcel.writeFloat(this.mFlexBasisPercent);
            parcel.writeInt(this.mMinWidth);
            parcel.writeInt(this.mMinHeight);
            parcel.writeInt(this.mMaxWidth);
            parcel.writeInt(this.mMaxHeight);
            parcel.writeByte(this.mWrapBefore ? (byte) 1 : 0);
            parcel.writeInt(this.bottomMargin);
            parcel.writeInt(this.leftMargin);
            parcel.writeInt(this.rightMargin);
            parcel.writeInt(this.topMargin);
            parcel.writeInt(this.height);
            parcel.writeInt(this.width);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        protected LayoutParams(Parcel parcel) {
            super(0, 0);
            boolean z = false;
            this.mOrder = parcel.readInt();
            this.mFlexGrow = parcel.readFloat();
            this.mFlexShrink = parcel.readFloat();
            this.mAlignSelf = parcel.readInt();
            this.mFlexBasisPercent = parcel.readFloat();
            this.mMinWidth = parcel.readInt();
            this.mMinHeight = parcel.readInt();
            this.mMaxWidth = parcel.readInt();
            this.mMaxHeight = parcel.readInt();
            this.mWrapBefore = parcel.readByte() != 0 ? true : z;
            this.bottomMargin = parcel.readInt();
            this.leftMargin = parcel.readInt();
            this.rightMargin = parcel.readInt();
            this.topMargin = parcel.readInt();
            this.height = parcel.readInt();
            this.width = parcel.readInt();
        }
    }
}
