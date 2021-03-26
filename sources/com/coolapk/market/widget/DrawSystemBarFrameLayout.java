package com.coolapk.market.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.coolapk.market.R;
import com.coolapk.market.extend.ViewExtendsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class DrawSystemBarFrameLayout extends FrameLayout {
    private static final int DEFAULT_CHILD_GRAVITY = 8388659;
    private boolean alwaysDispatchNextInset;
    private boolean drawNavigation;
    private boolean drawStatusBar;
    private boolean drawSystemBar;
    private View mConsumeInsetChild;
    private Rect mLastInsetsRect;
    private final ArrayList<View> mMatchParentChildren;
    private Drawable mStatusBarScrim;
    private CopyOnWriteArrayList<OnInsetChangeListener> onInsetChangeListeners;
    public boolean requestLayoutRecursive;

    public interface OnInsetChangeListener {
        void onInsetChange(Rect rect);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public DrawSystemBarFrameLayout(Context context) {
        this(context, null);
    }

    public DrawSystemBarFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DrawSystemBarFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        boolean z = true;
        this.mMatchParentChildren = new ArrayList<>(1);
        this.mLastInsetsRect = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DrawSystemBarFrameLayout, 0, 0);
        this.drawNavigation = obtainStyledAttributes.getBoolean(0, false);
        this.drawStatusBar = obtainStyledAttributes.getBoolean(1, false);
        obtainStyledAttributes.recycle();
        if (!this.drawStatusBar && !this.drawNavigation) {
            z = false;
        }
        this.drawSystemBar = z;
        if (!isInEditMode()) {
            setupForDraw();
        }
    }

    private static Rect convertSystemWindowInset(WindowInsets windowInsets) {
        return new Rect(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
    }

    public Rect getLastInsetsRect() {
        return new Rect(this.mLastInsetsRect);
    }

    @Override // android.view.ViewParent, android.view.View
    public void requestLayout() {
        super.requestLayout();
        if (this.requestLayoutRecursive) {
            ViewExtendsKt.requestLayoutRecursive(this);
        }
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        if (this.mLastInsetsRect.equals(rect)) {
            return true;
        }
        setWindowInsets(rect);
        return true;
    }

    @Override // android.view.ViewParent, android.view.View
    public void requestFitSystemWindows() {
        this.alwaysDispatchNextInset = true;
        super.requestFitSystemWindows();
    }

    @Override // android.view.View, android.view.ViewGroup
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mLastInsetsRect.isEmpty() && ViewCompat.getFitsSystemWindows(this)) {
            ViewCompat.requestApplyInsets(this);
        }
    }

    private void setupForDraw() {
        Activity activity = (Activity) getContext();
        int i = 0;
        if (Build.VERSION.SDK_INT >= 21) {
            setFitsSystemWindows(this.drawSystemBar);
            if (this.drawSystemBar) {
                i = 256;
                activity.getWindow().addFlags(Integer.MIN_VALUE);
            }
            if (this.drawStatusBar) {
                i |= 1024;
            }
            if (this.drawNavigation) {
                i |= 512;
            }
            setSystemUiVisibility(i);
        } else if (Build.VERSION.SDK_INT == 19) {
            if (this.drawSystemBar) {
                setFitsSystemWindows(false);
            }
            if (this.drawStatusBar) {
                activity.getWindow().addFlags(67108864);
            }
        }
    }

    @Override // android.view.View, android.view.ViewGroup
    public WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        if (!this.drawSystemBar) {
            return super.dispatchApplyWindowInsets(windowInsets);
        }
        Rect convertSystemWindowInset = convertSystemWindowInset(windowInsets);
        if (!convertSystemWindowInset.equals(this.mLastInsetsRect) || this.alwaysDispatchNextInset) {
            setWindowInsets(convertSystemWindowInset);
            this.alwaysDispatchNextInset = false;
        }
        View view = this.mConsumeInsetChild;
        if (view == null) {
            return windowInsets.consumeSystemWindowInsets();
        }
        return view.dispatchApplyWindowInsets(windowInsets);
    }

    private void setWindowInsets(Rect rect) {
        this.mLastInsetsRect = new Rect(rect);
        Rect rect2 = new Rect(rect);
        CopyOnWriteArrayList<OnInsetChangeListener> copyOnWriteArrayList = this.onInsetChangeListeners;
        if (copyOnWriteArrayList != null) {
            Iterator<OnInsetChangeListener> it2 = copyOnWriteArrayList.iterator();
            while (it2.hasNext()) {
                rect2.set(this.mLastInsetsRect);
                it2.next().onInsetChange(rect);
            }
        }
        requestLayout();
    }

    @Override // android.view.ViewParent, android.view.ViewGroup
    public void recomputeViewAttributes(View view) {
        if (!this.drawStatusBar) {
            super.recomputeViewAttributes(view);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int childCount = getChildCount();
        boolean z = (View.MeasureSpec.getMode(i) == 1073741824 && View.MeasureSpec.getMode(i2) == 1073741824) ? false : true;
        this.mMatchParentChildren.clear();
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                measureChildWithMargins(childAt, i, 0, i2, 0);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                i7 = Math.max(i7, childAt.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin);
                i6 = Math.max(i6, childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin);
                i5 = combineMeasuredStates(i5, childAt.getMeasuredState());
                if (z && (layoutParams.width == -1 || layoutParams.height == -1)) {
                    this.mMatchParentChildren.add(childAt);
                }
            }
        }
        setMeasuredDimension(resolveSizeAndState(Math.max(i7 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i, i5), resolveSizeAndState(Math.max(i6 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i2, i5 << 16));
        int size = this.mMatchParentChildren.size();
        if (size > 1) {
            for (int i9 = 0; i9 < size; i9++) {
                View view = this.mMatchParentChildren.get(i9);
                LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
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
                if (this.drawSystemBar) {
                    int size2 = View.MeasureSpec.getSize(i4);
                    int size3 = View.MeasureSpec.getSize(i3);
                    if (!layoutParams2.drawStatusBar) {
                        size2 -= this.mLastInsetsRect.top;
                    }
                    if (!layoutParams2.drawNavigationBar) {
                        size2 -= this.mLastInsetsRect.bottom;
                    }
                    if (!layoutParams2.drawLeftRightInset) {
                        size3 = (size3 - this.mLastInsetsRect.left) - this.mLastInsetsRect.right;
                    }
                    i4 = View.MeasureSpec.makeMeasureSpec(size2, View.MeasureSpec.getMode(i4));
                    i3 = View.MeasureSpec.makeMeasureSpec(size3, View.MeasureSpec.getMode(i3));
                }
                view.measure(i3, i4);
            }
        }
    }

    @Override // android.view.View
    public void requestApplyInsets() {
        super.requestApplyInsets();
    }

    @Override // android.view.ViewGroup
    protected void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        if (this.drawSystemBar) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int size = View.MeasureSpec.getSize(i3);
            int size2 = View.MeasureSpec.getSize(i);
            if (!layoutParams.drawStatusBar) {
                size -= this.mLastInsetsRect.top;
            }
            if (!layoutParams.drawNavigationBar) {
                size -= this.mLastInsetsRect.bottom;
            }
            if (!layoutParams.drawLeftRightInset) {
                size2 = (size2 - this.mLastInsetsRect.left) - this.mLastInsetsRect.right;
            }
            i3 = View.MeasureSpec.makeMeasureSpec(size, View.MeasureSpec.getMode(i3));
            i = View.MeasureSpec.makeMeasureSpec(size2, View.MeasureSpec.getMode(i));
        }
        super.measureChildWithMargins(view, i, i2, i3, i4);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x009f  */
    @Override // android.widget.FrameLayout, android.view.View, android.view.ViewGroup
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingRight = (i3 - i) - getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = (i4 - i2) - getPaddingBottom();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i11 = layoutParams.gravity;
                if (i11 == -1) {
                    i11 = 8388659;
                }
                int absoluteGravity = Gravity.getAbsoluteGravity(i11, getLayoutDirection());
                int i12 = i11 & 112;
                int i13 = absoluteGravity & 7;
                if (i13 == 1) {
                    i9 = (((paddingRight - paddingLeft) - measuredWidth) / 2) + paddingLeft + layoutParams.leftMargin;
                    i8 = layoutParams.rightMargin;
                } else if (i13 != 5) {
                    i5 = layoutParams.leftMargin + paddingLeft;
                    if (i12 == 16) {
                        if (i12 != 80) {
                            i6 = layoutParams.topMargin + paddingTop;
                            if (this.drawSystemBar && !layoutParams.drawStatusBar) {
                                i6 += this.mLastInsetsRect.top;
                            }
                        } else {
                            i6 = (paddingBottom - measuredHeight) - layoutParams.bottomMargin;
                            if (this.drawSystemBar && !layoutParams.drawNavigationBar) {
                                i7 = this.mLastInsetsRect.bottom;
                            }
                        }
                        if (!layoutParams.drawLeftRightInset) {
                            i5 += this.mLastInsetsRect.left;
                        }
                        childAt.layout(i5, i6, measuredWidth + i5, measuredHeight + i6);
                    } else {
                        i6 = (((paddingBottom - paddingTop) - measuredHeight) / 2) + paddingTop + layoutParams.topMargin;
                        i7 = layoutParams.bottomMargin;
                    }
                    i6 -= i7;
                    if (!layoutParams.drawLeftRightInset) {
                    }
                    childAt.layout(i5, i6, measuredWidth + i5, measuredHeight + i6);
                } else {
                    i9 = paddingRight - measuredWidth;
                    i8 = layoutParams.rightMargin;
                }
                i5 = i9 - i8;
                if (i12 == 16) {
                }
                i6 -= i7;
                if (!layoutParams.drawLeftRightInset) {
                }
                childAt.layout(i5, i6, measuredWidth + i5, measuredHeight + i6);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        if (this.mStatusBarScrim != null && (i = this.mLastInsetsRect.top) > 0) {
            this.mStatusBarScrim.setBounds(0, 0, getWidth(), i);
            this.mStatusBarScrim.draw(canvas);
        }
    }

    public void setStatusBarScrimColor(int i) {
        setStatusBarScrim(new ColorDrawable(i));
    }

    public void setConsumeInsetChild(View view) {
        if (view.getParent() == this) {
            this.mConsumeInsetChild = view;
            return;
        }
        throw new RuntimeException("must be the child view!!!");
    }

    public void setStatusBarScrim(Drawable drawable) {
        if (this.mStatusBarScrim != drawable) {
            this.mStatusBarScrim = drawable != null ? drawable.mutate() : null;
            invalidate();
        }
    }

    public void addOnInsetChangeListener(OnInsetChangeListener onInsetChangeListener) {
        if (this.onInsetChangeListeners == null) {
            this.onInsetChangeListeners = new CopyOnWriteArrayList<>();
        }
        this.onInsetChangeListeners.add(onInsetChangeListener);
    }

    public void removeOnInsetChangeListener(OnInsetChangeListener onInsetChangeListener) {
        if (this.onInsetChangeListeners == null) {
            this.onInsetChangeListeners = new CopyOnWriteArrayList<>();
        }
        this.onInsetChangeListeners.remove(onInsetChangeListener);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            return new LayoutParams((FrameLayout.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public static class LayoutParams extends FrameLayout.LayoutParams {
        public boolean drawLeftRightInset = false;
        public boolean drawNavigationBar = false;
        public boolean drawStatusBar = false;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DrawSystemBarFrameLayout_Layout);
            this.drawStatusBar = obtainStyledAttributes.getBoolean(2, false);
            this.drawNavigationBar = obtainStyledAttributes.getBoolean(1, false);
            this.drawLeftRightInset = obtainStyledAttributes.getBoolean(0, false);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(int i, int i2, int i3) {
            super(i, i2);
            this.gravity = i3;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(FrameLayout.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((FrameLayout.LayoutParams) layoutParams);
            this.gravity = layoutParams.gravity;
            this.drawNavigationBar = layoutParams.drawNavigationBar;
            this.drawStatusBar = layoutParams.drawStatusBar;
            this.drawLeftRightInset = layoutParams.drawLeftRightInset;
        }
    }
}
