package com.coolapk.market.widget.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.coolapk.market.util.DisplayUtils;
import java.util.ArrayList;
import rx.subjects.PublishSubject;

public class KeyBoardLayout extends FrameLayout {
    private static final int DEFAULT_CHILD_GRAVITY = 8388659;
    private View fakeKeyBoardView;
    private PublishSubject<Boolean> fakeKeyboardObservable = PublishSubject.create();
    private boolean hasRealKeyboard;
    private boolean isFakeKeyBoardShowed;
    private int keyBoardHeight;
    private PublishSubject<Integer> keyboardHeightObservable = PublishSubject.create();
    private PublishSubject<Boolean> keyboardObservable = PublishSubject.create();
    private Rect mInset = new Rect();
    private final ArrayList<View> mMatchParentChildren = new ArrayList<>(1);
    private final int minKeyboardHeight;
    private boolean showFakeKeyBoardView;

    private int getNavigationBarHeight() {
        return 0;
    }

    public KeyBoardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int dp2px = DisplayUtils.dp2px(getContext(), 232.0f);
        this.minKeyboardHeight = dp2px;
        this.keyBoardHeight = dp2px;
    }

    private static Rect convertSystemWindowInset(WindowInsets windowInsets) {
        return new Rect(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        if (this.mInset.equals(rect)) {
            return true;
        }
        setWindowInsets(rect);
        return true;
    }

    @Override // android.view.View, android.view.ViewGroup
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mInset.isEmpty() && ViewCompat.getFitsSystemWindows(this)) {
            ViewCompat.requestApplyInsets(this);
        }
    }

    @Override // android.view.View, android.view.ViewGroup
    public WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        Rect convertSystemWindowInset = convertSystemWindowInset(windowInsets);
        if (!convertSystemWindowInset.equals(this.mInset)) {
            setWindowInsets(convertSystemWindowInset);
        }
        return windowInsets.consumeSystemWindowInsets();
    }

    private void setWindowInsets(Rect rect) {
        this.mInset = new Rect(rect);
        requestLayout();
        boolean z = rect.bottom > getNavigationBarHeight();
        this.hasRealKeyboard = z;
        this.keyboardObservable.onNext(Boolean.valueOf(z));
        if (this.hasRealKeyboard) {
            int abs = Math.abs(rect.bottom - getNavigationBarHeight());
            this.keyBoardHeight = abs;
            int i = this.minKeyboardHeight;
            if (abs < i) {
                this.keyBoardHeight = i;
            }
            this.keyboardHeightObservable.onNext(Integer.valueOf(this.keyBoardHeight));
        }
        if (this.hasRealKeyboard) {
            this.showFakeKeyBoardView = false;
        }
    }

    public int getKeyBoardHeight() {
        return this.keyBoardHeight;
    }

    public void setKeyBoardView(View view) {
        if (view.getParent() == this) {
            this.fakeKeyBoardView = view;
            return;
        }
        throw new IllegalArgumentException("view must be the child view of KeyBoardLinearLayout");
    }

    public boolean isRealKeyboard() {
        return this.hasRealKeyboard;
    }

    public void showFakeKeyBoardView(boolean z) {
        this.showFakeKeyBoardView = z;
    }

    public boolean isFakeKeyBoardShowed() {
        return this.isFakeKeyBoardShowed;
    }

    public PublishSubject<Boolean> getFakeKeyboardObservable() {
        return this.fakeKeyboardObservable;
    }

    public PublishSubject<Boolean> getKeyboardObservable() {
        return this.keyboardObservable;
    }

    public PublishSubject<Integer> getKeyboardHeightObservable() {
        return this.keyboardHeightObservable;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int childCount = getChildCount();
        int i6 = 0;
        boolean z = (View.MeasureSpec.getMode(i) == 1073741824 && View.MeasureSpec.getMode(i2) == 1073741824) ? false : true;
        this.mMatchParentChildren.clear();
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (i9 < childCount) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                int size = View.MeasureSpec.getSize(i2);
                View view = this.fakeKeyBoardView;
                if (view != null) {
                    if (this.hasRealKeyboard || !this.showFakeKeyBoardView) {
                        if (childAt == view) {
                            childAt.getLayoutParams().height = i6;
                        }
                    } else if (childAt == view) {
                        childAt.getLayoutParams().height = this.keyBoardHeight;
                    } else {
                        i5 = View.MeasureSpec.makeMeasureSpec(size - this.keyBoardHeight, View.MeasureSpec.getMode(i2));
                        measureChildWithMargins(childAt, i, 0, i5, 0);
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                        i10 = Math.max(i10, childAt.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin);
                        i8 = Math.max(i8, childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin);
                        i7 = combineMeasuredStates(i7, childAt.getMeasuredState());
                        if (z && (layoutParams.width == -1 || layoutParams.height == -1)) {
                            this.mMatchParentChildren.add(childAt);
                        }
                    }
                }
                i5 = i2;
                measureChildWithMargins(childAt, i, 0, i5, 0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                i10 = Math.max(i10, childAt.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin);
                i8 = Math.max(i8, childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin);
                i7 = combineMeasuredStates(i7, childAt.getMeasuredState());
                this.mMatchParentChildren.add(childAt);
            }
            i9++;
            i6 = 0;
        }
        setMeasuredDimension(resolveSizeAndState(Math.max(i10 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i, i7), resolveSizeAndState(Math.max(i8 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i2, i7 << 16));
        int size2 = this.mMatchParentChildren.size();
        if (size2 > 1) {
            for (int i11 = 0; i11 < size2; i11++) {
                View view2 = this.mMatchParentChildren.get(i11);
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) view2.getLayoutParams();
                if (layoutParams2.width == -1) {
                    i3 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()) - layoutParams2.leftMargin) - layoutParams2.rightMargin), 1073741824);
                } else {
                    i3 = getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + layoutParams2.leftMargin + layoutParams2.rightMargin, layoutParams2.width);
                }
                if (layoutParams2.height == -1) {
                    i4 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams2.topMargin) - layoutParams2.bottomMargin), 1073741824);
                } else {
                    i4 = getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom() + layoutParams2.topMargin + layoutParams2.bottomMargin, layoutParams2.height);
                }
                int size3 = View.MeasureSpec.getSize(i4);
                view2.measure(View.MeasureSpec.makeMeasureSpec((View.MeasureSpec.getSize(i3) - this.mInset.left) - this.mInset.right, View.MeasureSpec.getMode(i3)), View.MeasureSpec.makeMeasureSpec((size3 - this.mInset.top) - this.mInset.bottom, View.MeasureSpec.getMode(i4)));
            }
        }
    }

    @Override // android.view.ViewGroup
    protected void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        int size = View.MeasureSpec.getSize(i3);
        int size2 = View.MeasureSpec.getSize(i);
        super.measureChildWithMargins(view, View.MeasureSpec.makeMeasureSpec((size2 - this.mInset.left) - this.mInset.right, View.MeasureSpec.getMode(i)), i2, View.MeasureSpec.makeMeasureSpec((size - this.mInset.top) - this.mInset.bottom, View.MeasureSpec.getMode(i3)), i4);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x009b  */
    @Override // android.widget.FrameLayout, android.view.View, android.view.ViewGroup
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        View view;
        int i7;
        int i8;
        int i9;
        int i10;
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingRight = (i3 - i) - getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = (i4 - i2) - getPaddingBottom();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i12 = layoutParams.gravity;
                if (i12 == -1) {
                    i12 = 8388659;
                }
                int absoluteGravity = Gravity.getAbsoluteGravity(i12, getLayoutDirection());
                int i13 = i12 & 112;
                int i14 = absoluteGravity & 7;
                if (i14 == 1) {
                    i10 = (((paddingRight - paddingLeft) - measuredWidth) / 2) + paddingLeft + layoutParams.leftMargin;
                    i9 = layoutParams.rightMargin;
                } else if (i14 != 5) {
                    i5 = layoutParams.leftMargin + paddingLeft;
                    if (i13 != 16) {
                        i7 = (((paddingBottom - paddingTop) - measuredHeight) / 2) + paddingTop + layoutParams.topMargin;
                        i8 = layoutParams.bottomMargin;
                    } else if (i13 != 80) {
                        i6 = layoutParams.topMargin + paddingTop + this.mInset.top;
                        int i15 = i5 + this.mInset.left;
                        view = this.fakeKeyBoardView;
                        if (view != null) {
                            if (this.hasRealKeyboard || !this.showFakeKeyBoardView) {
                                if (childAt == view) {
                                    this.isFakeKeyBoardShowed = false;
                                    this.fakeKeyboardObservable.onNext(false);
                                    childAt.layout(i15, i4, measuredWidth + i15, i4 + measuredHeight);
                                }
                            } else if (childAt == view) {
                                this.isFakeKeyBoardShowed = true;
                                this.fakeKeyboardObservable.onNext(true);
                                childAt.layout(i15, i4 - this.keyBoardHeight, measuredWidth + i15, i4);
                            } else {
                                childAt.layout(i15, i6, measuredWidth + i15, measuredHeight + i6);
                            }
                        }
                        childAt.layout(i15, i6, measuredWidth + i15, measuredHeight + i6);
                    } else {
                        i7 = (paddingBottom - measuredHeight) - layoutParams.bottomMargin;
                        i8 = this.mInset.bottom;
                    }
                    i6 = i7 - i8;
                    int i15 = i5 + this.mInset.left;
                    view = this.fakeKeyBoardView;
                    if (view != null) {
                    }
                    childAt.layout(i15, i6, measuredWidth + i15, measuredHeight + i6);
                } else {
                    i10 = paddingRight - measuredWidth;
                    i9 = layoutParams.rightMargin;
                }
                i5 = i10 - i9;
                if (i13 != 16) {
                }
                i6 = i7 - i8;
                int i15 = i5 + this.mInset.left;
                view = this.fakeKeyBoardView;
                if (view != null) {
                }
                childAt.layout(i15, i6, measuredWidth + i15, measuredHeight + i6);
            }
        }
    }
}
