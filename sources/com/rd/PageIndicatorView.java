package com.rd;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.text.TextUtilsCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.rd.IndicatorManager;
import com.rd.animation.type.AnimationType;
import com.rd.draw.controller.DrawController;
import com.rd.draw.data.Indicator;
import com.rd.draw.data.Orientation;
import com.rd.draw.data.PositionSavedState;
import com.rd.draw.data.RtlMode;
import com.rd.utils.CoordinatesUtils;
import com.rd.utils.DensityUtils;
import com.rd.utils.IdUtils;

public class PageIndicatorView extends View implements ViewPager.OnPageChangeListener, IndicatorManager.Listener, ViewPager.OnAdapterChangeListener {
    private boolean isInteractionEnabled;
    private IndicatorManager manager;
    private DataSetObserver setObserver;
    private ViewPager viewPager;

    public PageIndicatorView(Context context) {
        super(context);
        init(null);
    }

    public PageIndicatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public PageIndicatorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet);
    }

    public PageIndicatorView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init(attributeSet);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        findViewPager(getParent());
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        unRegisterSetObserver();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Indicator indicator = this.manager.indicator();
        PositionSavedState positionSavedState = new PositionSavedState(super.onSaveInstanceState());
        positionSavedState.setSelectedPosition(indicator.getSelectedPosition());
        positionSavedState.setSelectingPosition(indicator.getSelectingPosition());
        positionSavedState.setLastSelectedPosition(indicator.getLastSelectedPosition());
        return positionSavedState;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof PositionSavedState) {
            Indicator indicator = this.manager.indicator();
            PositionSavedState positionSavedState = (PositionSavedState) parcelable;
            indicator.setSelectedPosition(positionSavedState.getSelectedPosition());
            indicator.setSelectingPosition(positionSavedState.getSelectingPosition());
            indicator.setLastSelectedPosition(positionSavedState.getLastSelectedPosition());
            super.onRestoreInstanceState(positionSavedState.getSuperState());
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        Pair<Integer, Integer> measureViewSize = this.manager.drawer().measureViewSize(i, i2);
        setMeasuredDimension(((Integer) measureViewSize.first).intValue(), ((Integer) measureViewSize.second).intValue());
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.manager.drawer().draw(canvas);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.manager.drawer().touch(motionEvent);
        return true;
    }

    @Override // com.rd.IndicatorManager.Listener
    public void onIndicatorUpdated() {
        invalidate();
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        onPageScroll(i, f);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        onPageSelect(i);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (i == 0) {
            this.manager.indicator().setInteractiveAnimation(this.isInteractionEnabled);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnAdapterChangeListener
    public void onAdapterChanged(ViewPager viewPager2, PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
        updateState();
    }

    public void setCount(int i) {
        if (i >= 0 && this.manager.indicator().getCount() != i) {
            this.manager.indicator().setCount(i);
            updateVisibility();
            requestLayout();
        }
    }

    public int getCount() {
        return this.manager.indicator().getCount();
    }

    public void setDynamicCount(boolean z) {
        this.manager.indicator().setDynamicCount(z);
        if (z) {
            registerSetObserver();
        } else {
            unRegisterSetObserver();
        }
    }

    public void setRadius(int i) {
        if (i < 0) {
            i = 0;
        }
        this.manager.indicator().setRadius(DensityUtils.dpToPx(i));
        invalidate();
    }

    public void setRadius(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        this.manager.indicator().setRadius((int) f);
        invalidate();
    }

    public int getRadius() {
        return this.manager.indicator().getRadius();
    }

    public void setPadding(int i) {
        if (i < 0) {
            i = 0;
        }
        this.manager.indicator().setPadding(DensityUtils.dpToPx(i));
        invalidate();
    }

    public void setPadding(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        this.manager.indicator().setPadding((int) f);
        invalidate();
    }

    public int getPadding() {
        return this.manager.indicator().getPadding();
    }

    public void setScaleFactor(float f) {
        if (f > 1.0f) {
            f = 1.0f;
        } else if (f < 0.3f) {
            f = 0.3f;
        }
        this.manager.indicator().setScaleFactor(f);
    }

    public float getScaleFactor() {
        return this.manager.indicator().getScaleFactor();
    }

    public void setStrokeWidth(float f) {
        int radius = this.manager.indicator().getRadius();
        if (f < 0.0f) {
            f = 0.0f;
        } else {
            float f2 = (float) radius;
            if (f > f2) {
                f = f2;
            }
        }
        this.manager.indicator().setStroke((int) f);
        invalidate();
    }

    public void setStrokeWidth(int i) {
        int dpToPx = DensityUtils.dpToPx(i);
        int radius = this.manager.indicator().getRadius();
        if (dpToPx < 0) {
            dpToPx = 0;
        } else if (dpToPx > radius) {
            dpToPx = radius;
        }
        this.manager.indicator().setStroke(dpToPx);
        invalidate();
    }

    public int getStrokeWidth() {
        return this.manager.indicator().getStroke();
    }

    public void setSelectedColor(int i) {
        this.manager.indicator().setSelectedColor(i);
        invalidate();
    }

    public int getSelectedColor() {
        return this.manager.indicator().getSelectedColor();
    }

    public void setUnselectedColor(int i) {
        this.manager.indicator().setUnselectedColor(i);
        invalidate();
    }

    public int getUnselectedColor() {
        return this.manager.indicator().getUnselectedColor();
    }

    public void setAutoVisibility(boolean z) {
        if (!z) {
            setVisibility(0);
        }
        this.manager.indicator().setAutoVisibility(z);
        updateVisibility();
    }

    public void setOrientation(Orientation orientation) {
        if (orientation != null) {
            this.manager.indicator().setOrientation(orientation);
            requestLayout();
        }
    }

    public void setAnimationDuration(long j) {
        this.manager.indicator().setAnimationDuration(j);
    }

    public long getAnimationDuration() {
        return this.manager.indicator().getAnimationDuration();
    }

    public void setAnimationType(AnimationType animationType) {
        this.manager.onValueUpdated(null);
        if (animationType != null) {
            this.manager.indicator().setAnimationType(animationType);
        } else {
            this.manager.indicator().setAnimationType(AnimationType.NONE);
        }
        invalidate();
    }

    public void setInteractiveAnimation(boolean z) {
        this.manager.indicator().setInteractiveAnimation(z);
        this.isInteractionEnabled = z;
    }

    public void setViewPager(ViewPager viewPager2) {
        releaseViewPager();
        if (viewPager2 != null) {
            this.viewPager = viewPager2;
            viewPager2.addOnPageChangeListener(this);
            this.viewPager.addOnAdapterChangeListener(this);
            this.manager.indicator().setViewPagerId(this.viewPager.getId());
            setDynamicCount(this.manager.indicator().isDynamicCount());
            updateState();
        }
    }

    public void releaseViewPager() {
        ViewPager viewPager2 = this.viewPager;
        if (viewPager2 != null) {
            viewPager2.removeOnPageChangeListener(this);
            this.viewPager = null;
        }
    }

    public void setRtlMode(RtlMode rtlMode) {
        Indicator indicator = this.manager.indicator();
        if (rtlMode == null) {
            indicator.setRtlMode(RtlMode.Off);
        } else {
            indicator.setRtlMode(rtlMode);
        }
        if (this.viewPager != null) {
            int selectedPosition = indicator.getSelectedPosition();
            if (isRtl()) {
                selectedPosition = (indicator.getCount() - 1) - selectedPosition;
            } else {
                ViewPager viewPager2 = this.viewPager;
                if (viewPager2 != null) {
                    selectedPosition = viewPager2.getCurrentItem();
                }
            }
            indicator.setLastSelectedPosition(selectedPosition);
            indicator.setSelectingPosition(selectedPosition);
            indicator.setSelectedPosition(selectedPosition);
            invalidate();
        }
    }

    public int getSelection() {
        return this.manager.indicator().getSelectedPosition();
    }

    public void setSelection(int i) {
        Indicator indicator = this.manager.indicator();
        int adjustPosition = adjustPosition(i);
        if (adjustPosition != indicator.getSelectedPosition() && adjustPosition != indicator.getSelectingPosition()) {
            indicator.setInteractiveAnimation(false);
            indicator.setLastSelectedPosition(indicator.getSelectedPosition());
            indicator.setSelectingPosition(adjustPosition);
            indicator.setSelectedPosition(adjustPosition);
            this.manager.animate().basic();
        }
    }

    public void setSelected(int i) {
        Indicator indicator = this.manager.indicator();
        AnimationType animationType = indicator.getAnimationType();
        indicator.setAnimationType(AnimationType.NONE);
        setSelection(i);
        indicator.setAnimationType(animationType);
    }

    public void clearSelection() {
        Indicator indicator = this.manager.indicator();
        indicator.setInteractiveAnimation(false);
        indicator.setLastSelectedPosition(-1);
        indicator.setSelectingPosition(-1);
        indicator.setSelectedPosition(-1);
        this.manager.animate().basic();
    }

    public void setProgress(int i, float f) {
        Indicator indicator = this.manager.indicator();
        if (indicator.isInteractiveAnimation()) {
            int count = indicator.getCount();
            if (count <= 0 || i < 0) {
                i = 0;
            } else {
                int i2 = count - 1;
                if (i > i2) {
                    i = i2;
                }
            }
            if (f < 0.0f) {
                f = 0.0f;
            } else if (f > 1.0f) {
                f = 1.0f;
            }
            if (f == 1.0f) {
                indicator.setLastSelectedPosition(indicator.getSelectedPosition());
                indicator.setSelectedPosition(i);
            }
            indicator.setSelectingPosition(i);
            this.manager.animate().interactive(f);
        }
    }

    public void setClickListener(DrawController.ClickListener clickListener) {
        this.manager.drawer().setClickListener(clickListener);
    }

    private void init(AttributeSet attributeSet) {
        setupId();
        initIndicatorManager(attributeSet);
    }

    private void setupId() {
        if (getId() == -1) {
            setId(IdUtils.generateViewId());
        }
    }

    private void initIndicatorManager(AttributeSet attributeSet) {
        IndicatorManager indicatorManager = new IndicatorManager(this);
        this.manager = indicatorManager;
        indicatorManager.drawer().initAttributes(getContext(), attributeSet);
        Indicator indicator = this.manager.indicator();
        indicator.setPaddingLeft(getPaddingLeft());
        indicator.setPaddingTop(getPaddingTop());
        indicator.setPaddingRight(getPaddingRight());
        indicator.setPaddingBottom(getPaddingBottom());
        this.isInteractionEnabled = indicator.isInteractiveAnimation();
    }

    private void registerSetObserver() {
        ViewPager viewPager2;
        if (this.setObserver == null && (viewPager2 = this.viewPager) != null && viewPager2.getAdapter() != null) {
            this.setObserver = new DataSetObserver() {
                /* class com.rd.PageIndicatorView.AnonymousClass1 */

                @Override // android.database.DataSetObserver
                public void onChanged() {
                    PageIndicatorView.this.updateState();
                }
            };
            try {
                this.viewPager.getAdapter().registerDataSetObserver(this.setObserver);
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
    }

    private void unRegisterSetObserver() {
        ViewPager viewPager2;
        if (this.setObserver != null && (viewPager2 = this.viewPager) != null && viewPager2.getAdapter() != null) {
            try {
                this.viewPager.getAdapter().unregisterDataSetObserver(this.setObserver);
                this.setObserver = null;
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    public void updateState() {
        ViewPager viewPager2 = this.viewPager;
        if (viewPager2 != null && viewPager2.getAdapter() != null) {
            int count = this.viewPager.getAdapter().getCount();
            int currentItem = isRtl() ? (count - 1) - this.viewPager.getCurrentItem() : this.viewPager.getCurrentItem();
            this.manager.indicator().setSelectedPosition(currentItem);
            this.manager.indicator().setSelectingPosition(currentItem);
            this.manager.indicator().setLastSelectedPosition(currentItem);
            this.manager.indicator().setCount(count);
            this.manager.animate().end();
            updateVisibility();
            requestLayout();
        }
    }

    private void updateVisibility() {
        if (this.manager.indicator().isAutoVisibility()) {
            int count = this.manager.indicator().getCount();
            int visibility = getVisibility();
            if (visibility != 0 && count > 1) {
                setVisibility(0);
            } else if (visibility != 4 && count <= 1) {
                setVisibility(4);
            }
        }
    }

    private void onPageSelect(int i) {
        Indicator indicator = this.manager.indicator();
        boolean isViewMeasured = isViewMeasured();
        int count = indicator.getCount();
        if (isViewMeasured) {
            if (isRtl()) {
                i = (count - 1) - i;
            }
            setSelection(i);
        }
    }

    private void onPageScroll(int i, float f) {
        Indicator indicator = this.manager.indicator();
        if (isViewMeasured() && indicator.isInteractiveAnimation() && indicator.getAnimationType() != AnimationType.NONE) {
            Pair<Integer, Float> progress = CoordinatesUtils.getProgress(indicator, i, f, isRtl());
            setProgress(((Integer) progress.first).intValue(), ((Float) progress.second).floatValue());
        }
    }

    /* renamed from: com.rd.PageIndicatorView$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$rd$draw$data$RtlMode;

        static {
            int[] iArr = new int[RtlMode.values().length];
            $SwitchMap$com$rd$draw$data$RtlMode = iArr;
            try {
                iArr[RtlMode.On.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$rd$draw$data$RtlMode[RtlMode.Off.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$rd$draw$data$RtlMode[RtlMode.Auto.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private boolean isRtl() {
        int i = AnonymousClass2.$SwitchMap$com$rd$draw$data$RtlMode[this.manager.indicator().getRtlMode().ordinal()];
        if (i == 1) {
            return true;
        }
        if (i == 3 && TextUtilsCompat.getLayoutDirectionFromLocale(getContext().getResources().getConfiguration().locale) == 1) {
            return true;
        }
        return false;
    }

    private boolean isViewMeasured() {
        return (getMeasuredHeight() == 0 && getMeasuredWidth() == 0) ? false : true;
    }

    private void findViewPager(ViewParent viewParent) {
        if (viewParent != null && (viewParent instanceof ViewGroup) && ((ViewGroup) viewParent).getChildCount() > 0) {
            ViewPager findViewPager = findViewPager((ViewGroup) viewParent, this.manager.indicator().getViewPagerId());
            if (findViewPager != null) {
                setViewPager(findViewPager);
            } else {
                findViewPager(viewParent.getParent());
            }
        }
    }

    private ViewPager findViewPager(ViewGroup viewGroup, int i) {
        View findViewById;
        if (viewGroup.getChildCount() > 0 && (findViewById = viewGroup.findViewById(i)) != null && (findViewById instanceof ViewPager)) {
            return (ViewPager) findViewById;
        }
        return null;
    }

    private int adjustPosition(int i) {
        int count = this.manager.indicator().getCount() - 1;
        if (i < 0) {
            return 0;
        }
        return i > count ? count : i;
    }
}
