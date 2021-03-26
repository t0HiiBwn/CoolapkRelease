package com.coolapk.market.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.GestureDetectorCompat;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blankj.utilcode.util.ConvertUtils;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppTheme;
import com.coolapk.market.R;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.view.base.asynclist.AsyncListFragment;
import com.coolapk.market.view.base.asynclist.NewAsyncListFragment;
import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;
import java.lang.reflect.Field;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0018\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J\u0012\u0010%\u001a\u00020&2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020)H\u0016J \u0010*\u001a\u00020&2\u0006\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020)H\u0016J\u0010\u0010/\u001a\u00020&2\u0006\u0010+\u001a\u00020)H\u0016J\u0010\u00100\u001a\u00020&2\u0006\u0010+\u001a\u00020)H\u0016J\u0010\u00101\u001a\u00020&2\u0006\u0010+\u001a\u00020)H\u0016J\u0006\u00102\u001a\u00020&J\u0006\u00103\u001a\u00020&J\b\u00104\u001a\u00020&H\u0002J\u000e\u00105\u001a\u00020&2\u0006\u00106\u001a\u00020\rJ\u000e\u00107\u001a\u00020&2\u0006\u00106\u001a\u00020\rJ\u000e\u00108\u001a\u00020&2\u0006\u00109\u001a\u00020:J\u000e\u0010;\u001a\u00020&2\u0006\u0010<\u001a\u00020)J\u000e\u0010=\u001a\u00020&2\u0006\u0010\u0017\u001a\u00020>J\u000e\u0010\u0015\u001a\u00020&2\u0006\u0010#\u001a\u00020$J\u000e\u0010?\u001a\u00020&2\u0006\u0010\u0017\u001a\u00020>J\u000e\u0010\u001e\u001a\u00020&2\u0006\u0010#\u001a\u00020$R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0004\n\u0002\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\u0012X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0014\"\u0004\b\u001e\u0010\u0016R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/coolapk/market/widget/SymmetryAppHeader;", "Lcom/coolapk/market/widget/BaseAppHeader;", "Lcom/flyco/tablayout/listener/OnTabSelectListener;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "detector", "Landroidx/core/view/GestureDetectorCompat;", "lastBottomViewPager", "Landroidx/viewpager/widget/ViewPager;", "lastCenterViewPager", "lastSlidingTabLayout", "Lcom/coolapk/market/widget/SlidingTabLayoutCompat;", "leftIconView", "Landroid/view/ViewGroup;", "getLeftIconView", "()Landroid/view/ViewGroup;", "setLeftIconView", "(Landroid/view/ViewGroup;)V", "listener", "com/coolapk/market/widget/SymmetryAppHeader$listener$1", "Lcom/coolapk/market/widget/SymmetryAppHeader$listener$1;", "refreshView", "", "rightIconView", "getRightIconView", "setRightIconView", "titleView", "Landroid/widget/TextView;", "createIconView", "Landroid/widget/FrameLayout;", "icon", "Landroid/graphics/drawable/Drawable;", "initUI", "", "onPageScrollStateChanged", "state", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "onTabReselect", "onTabSelect", "removeBottomView", "removeCenterView", "scrollToTopAndRefresh", "setBottomTabLayout", "viewPager", "setCenterTabLayout", "setCenterTitle", "title", "", "setIconViewTint", "color", "setLeftIconListener", "Landroid/view/View$OnClickListener;", "setRightIconListener", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SymmetryAppHeader.kt */
public final class SymmetryAppHeader extends BaseAppHeader implements OnTabSelectListener, ViewPager.OnPageChangeListener {
    private final GestureDetectorCompat detector;
    private ViewPager lastBottomViewPager;
    private ViewPager lastCenterViewPager;
    private SlidingTabLayoutCompat lastSlidingTabLayout;
    public ViewGroup leftIconView;
    private final SymmetryAppHeader$listener$1 listener;
    private Object refreshView;
    public ViewGroup rightIconView;
    private TextView titleView;

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // com.flyco.tablayout.listener.OnTabSelectListener
    public void onTabReselect(int i) {
    }

    @Override // com.flyco.tablayout.listener.OnTabSelectListener
    public void onTabSelect(int i) {
    }

    public final ViewGroup getLeftIconView() {
        ViewGroup viewGroup = this.leftIconView;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftIconView");
        }
        return viewGroup;
    }

    public final void setLeftIconView(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
        this.leftIconView = viewGroup;
    }

    public final ViewGroup getRightIconView() {
        ViewGroup viewGroup = this.rightIconView;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightIconView");
        }
        return viewGroup;
    }

    public final void setRightIconView(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
        this.rightIconView = viewGroup;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SymmetryAppHeader(Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SymmetryAppHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        SymmetryAppHeader$listener$1 symmetryAppHeader$listener$1 = new SymmetryAppHeader$listener$1(this);
        this.listener = symmetryAppHeader$listener$1;
        GestureDetectorCompat gestureDetectorCompat = new GestureDetectorCompat(getContext(), symmetryAppHeader$listener$1);
        gestureDetectorCompat.setOnDoubleTapListener(symmetryAppHeader$listener$1);
        Unit unit = Unit.INSTANCE;
        this.detector = gestureDetectorCompat;
        initUI(attributeSet);
    }

    private final void initUI(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.SymmetryAppHeader);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…leable.SymmetryAppHeader)");
            Drawable drawable = obtainStyledAttributes.getDrawable(1);
            Drawable drawable2 = obtainStyledAttributes.getDrawable(2);
            String string = obtainStyledAttributes.getString(0);
            if (drawable != null) {
                setLeftIconView(drawable);
            }
            if (drawable2 != null) {
                setRightIconView(drawable2);
            }
            if (string != null) {
                setCenterTitle(string);
            }
            obtainStyledAttributes.recycle();
        }
    }

    public final void setLeftIconView(Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "icon");
        FrameLayout createIconView = createIconView(drawable);
        this.leftIconView = createIconView;
        if (createIconView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftIconView");
        }
        setLeftView(createIconView);
    }

    public final void setRightIconView(Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "icon");
        this.rightIconView = createIconView(drawable);
    }

    public final void setLeftIconListener(View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(onClickListener, "listener");
        ViewGroup viewGroup = this.leftIconView;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftIconView");
        }
        viewGroup.setOnClickListener(onClickListener);
    }

    public final void setRightIconListener(View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(onClickListener, "listener");
        ViewGroup viewGroup = this.rightIconView;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightIconView");
        }
        viewGroup.setOnClickListener(onClickListener);
    }

    public final void setIconViewTint(int i) {
        ImageView imageView;
        PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_IN);
        TextView textView = this.titleView;
        if (textView != null) {
            textView.setTextColor(i);
        }
        ViewGroup viewGroup = this.leftIconView;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftIconView");
        }
        View childAt = viewGroup.getChildAt(0);
        ImageView imageView2 = null;
        if (childAt != null) {
            if (!(childAt instanceof ImageView)) {
                childAt = null;
            }
            imageView = (ImageView) childAt;
        } else {
            imageView = null;
        }
        if (imageView != null) {
            Drawable mutate = DrawableCompat.wrap(imageView.getDrawable()).mutate();
            PorterDuffColorFilter porterDuffColorFilter2 = porterDuffColorFilter;
            mutate.setColorFilter(porterDuffColorFilter2);
            Unit unit = Unit.INSTANCE;
            imageView.setImageDrawable(mutate);
            ViewGroup viewGroup2 = this.rightIconView;
            if (viewGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rightIconView");
            }
            View childAt2 = viewGroup2.getChildAt(0);
            if (childAt2 != null) {
                if (childAt2 instanceof ImageView) {
                    imageView2 = childAt2;
                }
                imageView2 = imageView2;
            }
            if (imageView2 != null) {
                Drawable mutate2 = DrawableCompat.wrap(imageView2.getDrawable()).mutate();
                mutate2.setColorFilter(porterDuffColorFilter2);
                Unit unit2 = Unit.INSTANCE;
                imageView2.setImageDrawable(mutate2);
            }
        }
    }

    private final FrameLayout createIconView(Drawable drawable) {
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setBackgroundResource(ResourceUtils.resolveResId(frameLayout.getContext(), 16843676));
        ImageView imageView = new ImageView(frameLayout.getContext());
        imageView.setDuplicateParentStateEnabled(true);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        Drawable mutate = DrawableCompat.wrap(drawable).mutate();
        mutate.setColorFilter(new PorterDuffColorFilter(AppHolder.getAppTheme().getMainTextColor(), PorterDuff.Mode.SRC_IN));
        Unit unit = Unit.INSTANCE;
        imageView.setImageDrawable(mutate);
        Unit unit2 = Unit.INSTANCE;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        Unit unit3 = Unit.INSTANCE;
        frameLayout.addView(imageView, layoutParams);
        return frameLayout;
    }

    public final void setCenterTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        if (this.titleView == null) {
            TextView textView = new TextView(getContext());
            textView.setOnTouchListener(new SymmetryAppHeader$setCenterTitle$$inlined$apply$lambda$1(this, str));
            textView.setGravity(17);
            textView.setTextColor(AppHolder.getAppTheme().getTextColorPrimary());
            textView.setText(str);
            textView.setTextSize(18.0f);
            textView.setTextColor(AppHolder.getAppTheme().getMainTextColor());
            Unit unit = Unit.INSTANCE;
            this.titleView = textView;
        }
        this.lastCenterViewPager = null;
        setCenterView(this.titleView);
        TextView textView2 = this.titleView;
        if (textView2 != null) {
            textView2.setText(str);
        }
    }

    public final void setCenterTabLayout(ViewPager viewPager) {
        Intrinsics.checkNotNullParameter(viewPager, "viewPager");
        if (!Intrinsics.areEqual(this.lastCenterViewPager, viewPager)) {
            this.lastCenterViewPager = viewPager;
            FrameLayout frameLayout = new FrameLayout(getContext());
            View inflate = LayoutInflater.from(frameLayout.getContext()).inflate(2131559143, (ViewGroup) null, false);
            Objects.requireNonNull(inflate, "null cannot be cast to non-null type com.coolapk.market.widget.SlidingTabLayoutCompat");
            SlidingTabLayoutCompat slidingTabLayoutCompat = (SlidingTabLayoutCompat) inflate;
            slidingTabLayoutCompat.addOnPageChangeListener(this);
            AppTheme appTheme = AppHolder.getAppTheme();
            Context context = slidingTabLayoutCompat.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            slidingTabLayoutCompat.setIndicatorColor(appTheme.getTabIndicatorColor(context));
            slidingTabLayoutCompat.setTextSelectColor(slidingTabLayoutCompat.getIndicatorColor());
            slidingTabLayoutCompat.setTextUnselectColor(ResourceUtils.resolveData(slidingTabLayoutCompat.getContext(), 2130969533));
            slidingTabLayoutCompat.setTextsize(18.0f);
            slidingTabLayoutCompat.setIndicatorHeight(2.0f);
            slidingTabLayoutCompat.setTabPadding(16.0f);
            slidingTabLayoutCompat.setIndicatorWidthEqualTitle(true);
            slidingTabLayoutCompat.setViewPager(viewPager);
            slidingTabLayoutCompat.setCurrentTab(viewPager.getCurrentItem());
            slidingTabLayoutCompat.setDividerPadding(0.0f);
            slidingTabLayoutCompat.notifyDataSetChanged();
            int tabCount = slidingTabLayoutCompat.getTabCount();
            for (int i = 0; i < tabCount; i++) {
                TextView titleView2 = slidingTabLayoutCompat.getTitleView(i);
                Intrinsics.checkNotNullExpressionValue(titleView2, "getTitleView(i)");
                ViewParent parent = titleView2.getParent();
                Objects.requireNonNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                ViewParent parent2 = ((ViewGroup) parent).getParent();
                Objects.requireNonNull(parent2, "null cannot be cast to non-null type android.view.ViewGroup");
                ((ViewGroup) parent2).setBackgroundColor(0);
                TextView titleView3 = slidingTabLayoutCompat.getTitleView(i);
                Intrinsics.checkNotNullExpressionValue(titleView3, "getTitleView(i)");
                ViewParent parent3 = titleView3.getParent();
                Objects.requireNonNull(parent3, "null cannot be cast to non-null type android.view.ViewGroup");
                ((ViewGroup) parent3).setBackgroundResource(ResourceUtils.resolveResId(slidingTabLayoutCompat.getContext(), 16843534));
            }
            this.lastSlidingTabLayout = slidingTabLayoutCompat;
            Unit unit = Unit.INSTANCE;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -1);
            layoutParams.gravity = 17;
            Unit unit2 = Unit.INSTANCE;
            frameLayout.addView(slidingTabLayoutCompat, layoutParams);
            setCenterView(frameLayout);
        }
    }

    public final void setBottomTabLayout(ViewPager viewPager) {
        Intrinsics.checkNotNullParameter(viewPager, "viewPager");
        if (!Intrinsics.areEqual(this.lastBottomViewPager, viewPager)) {
            this.lastBottomViewPager = viewPager;
            FrameLayout frameLayout = new FrameLayout(getContext());
            View inflate = LayoutInflater.from(frameLayout.getContext()).inflate(2131559143, (ViewGroup) null, false);
            Objects.requireNonNull(inflate, "null cannot be cast to non-null type com.coolapk.market.widget.SlidingTabLayoutCompat");
            SlidingTabLayoutCompat slidingTabLayoutCompat = (SlidingTabLayoutCompat) inflate;
            slidingTabLayoutCompat.addOnPageChangeListener(this);
            AppTheme appTheme = AppHolder.getAppTheme();
            Context context = slidingTabLayoutCompat.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            slidingTabLayoutCompat.setIndicatorColor(appTheme.getTabIndicatorColor(context));
            slidingTabLayoutCompat.setTextSelectColor(slidingTabLayoutCompat.getIndicatorColor());
            slidingTabLayoutCompat.setTextUnselectColor(ResourceUtils.resolveData(slidingTabLayoutCompat.getContext(), 2130969533));
            slidingTabLayoutCompat.setTextsize(16.0f);
            slidingTabLayoutCompat.setTabSpaceEqual(true);
            slidingTabLayoutCompat.setIndicatorHeight(2.0f);
            slidingTabLayoutCompat.setTabPadding(0.0f);
            slidingTabLayoutCompat.setIndicatorWidthEqualTitle(true);
            slidingTabLayoutCompat.setViewPager(viewPager);
            slidingTabLayoutCompat.setCurrentTab(viewPager.getCurrentItem());
            slidingTabLayoutCompat.setDividerPadding(0.0f);
            slidingTabLayoutCompat.notifyDataSetChanged();
            int tabCount = slidingTabLayoutCompat.getTabCount();
            for (int i = 0; i < tabCount; i++) {
                TextView titleView2 = slidingTabLayoutCompat.getTitleView(i);
                Intrinsics.checkNotNullExpressionValue(titleView2, "getTitleView(i)");
                ViewParent parent = titleView2.getParent();
                Objects.requireNonNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                ViewParent parent2 = ((ViewGroup) parent).getParent();
                Objects.requireNonNull(parent2, "null cannot be cast to non-null type android.view.ViewGroup");
                ((ViewGroup) parent2).setBackgroundColor(0);
                TextView titleView3 = slidingTabLayoutCompat.getTitleView(i);
                Intrinsics.checkNotNullExpressionValue(titleView3, "getTitleView(i)");
                ViewParent parent3 = titleView3.getParent();
                Objects.requireNonNull(parent3, "null cannot be cast to non-null type android.view.ViewGroup");
                ((ViewGroup) parent3).setBackgroundResource(ResourceUtils.resolveResId(slidingTabLayoutCompat.getContext(), 16843534));
            }
            this.lastSlidingTabLayout = slidingTabLayoutCompat;
            Unit unit = Unit.INSTANCE;
            frameLayout.addView(slidingTabLayoutCompat, new FrameLayout.LayoutParams(-1, ConvertUtils.dp2px(40.0f)));
            setBottomView(frameLayout);
        }
    }

    public final void removeCenterView() {
        setCenterView(null);
        this.lastCenterViewPager = null;
    }

    public final void removeBottomView() {
        setBottomView(null);
        this.lastBottomViewPager = null;
    }

    /* access modifiers changed from: private */
    public final void scrollToTopAndRefresh() {
        Object obj = this.refreshView;
        if (obj instanceof NewAsyncListFragment) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.view.base.asynclist.NewAsyncListFragment<*>");
            ((NewAsyncListFragment) obj).scrollToTop(true);
            Object obj2 = this.refreshView;
            Objects.requireNonNull(obj2, "null cannot be cast to non-null type com.coolapk.market.view.base.asynclist.NewAsyncListFragment<*>");
            SwipeRefreshLayout swipeRefreshLayout = ((NewAsyncListFragment) obj2).getSwipeRefreshLayout();
            Intrinsics.checkNotNullExpressionValue(swipeRefreshLayout, "(refreshView as NewAsync…nt<*>).swipeRefreshLayout");
            swipeRefreshLayout.setRefreshing(true);
            Object obj3 = this.refreshView;
            Objects.requireNonNull(obj3, "null cannot be cast to non-null type com.coolapk.market.view.base.asynclist.NewAsyncListFragment<*>");
            ((NewAsyncListFragment) obj3).reloadData();
        } else if (obj instanceof AsyncListFragment) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.view.base.asynclist.AsyncListFragment<*, *>");
            ((AsyncListFragment) obj).scrollToTop(true);
            Object obj4 = this.refreshView;
            Objects.requireNonNull(obj4, "null cannot be cast to non-null type com.coolapk.market.view.base.asynclist.AsyncListFragment<*, *>");
            SwipeRefreshLayout swipeRefreshLayout2 = ((AsyncListFragment) obj4).getSwipeRefreshLayout();
            Intrinsics.checkNotNullExpressionValue(swipeRefreshLayout2, "(refreshView as AsyncLis…*, *>).swipeRefreshLayout");
            swipeRefreshLayout2.setRefreshing(true);
            Object obj5 = this.refreshView;
            Objects.requireNonNull(obj5, "null cannot be cast to non-null type com.coolapk.market.view.base.asynclist.AsyncListFragment<*, *>");
            ((AsyncListFragment) obj5).reloadData();
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.lastSlidingTabLayout != null) {
            Field declaredField = SlidingTabLayout.class.getDeclaredField("mTabsContainer");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(this.lastSlidingTabLayout);
            Objects.requireNonNull(obj, "null cannot be cast to non-null type android.widget.LinearLayout");
            LinearLayout linearLayout = (LinearLayout) obj;
            int childCount = linearLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = linearLayout.getChildAt(i2);
                if (i2 == i) {
                    Field declaredField2 = SlidingTabLayout.class.getDeclaredField("mViewPager");
                    declaredField2.setAccessible(true);
                    Object obj2 = declaredField2.get(this.lastSlidingTabLayout);
                    Objects.requireNonNull(obj2, "null cannot be cast to non-null type androidx.viewpager.widget.ViewPager");
                    ViewPager viewPager = (ViewPager) obj2;
                    PagerAdapter adapter = viewPager.getAdapter();
                    Intrinsics.checkNotNull(adapter);
                    Object instantiateItem = adapter.instantiateItem((ViewGroup) viewPager, viewPager.getCurrentItem());
                    Objects.requireNonNull(instantiateItem, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
                    Fragment fragment = (Fragment) instantiateItem;
                    if ((fragment instanceof NewAsyncListFragment) || (fragment instanceof AsyncListFragment)) {
                        this.refreshView = fragment;
                    }
                    childAt.setOnTouchListener(new SymmetryAppHeader$onPageSelected$1(this));
                } else {
                    childAt.setOnTouchListener(null);
                }
            }
        }
    }
}
