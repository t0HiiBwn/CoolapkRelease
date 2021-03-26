package com.coolapk.market.widget;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.GestureDetectorCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blankj.utilcode.util.ConvertUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppSetting;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.view.base.asynclist.AsyncListFragment;
import com.coolapk.market.view.base.asynclist.NewAsyncListFragment;
import com.coolapk.market.view.base.refresh.LocalMultiTypeFragment;
import com.coolapk.market.view.base.refresh.RefreshRecyclerFragment;
import com.coolapk.market.view.base.refresh.ViewPagerFragment;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0004\n\u0017\u001c!\u0018\u0000 C2\u00020\u00012\u00020\u0002:\u0001CB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)J\u0010\u0010*\u001a\u00020'2\b\u0010+\u001a\u0004\u0018\u00010,J\u000e\u0010-\u001a\u00020'2\u0006\u0010.\u001a\u00020\u0015J\u0010\u0010/\u001a\u00020'2\b\u00100\u001a\u0004\u0018\u000101J\u000e\u00102\u001a\u00020'2\u0006\u00103\u001a\u000204J\b\u00105\u001a\u00020\u001aH\u0002J\u0010\u00106\u001a\u00020'2\u0006\u00107\u001a\u00020\rH\u0002J\b\u00108\u001a\u00020'H\u0002J\b\u00109\u001a\u00020\rH\u0002J\b\u0010:\u001a\u00020'H\u0014J\u0018\u0010;\u001a\u00020'2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?H\u0016J\u000e\u0010@\u001a\u00020'2\u0006\u0010\u0019\u001a\u00020\u001aJ\b\u0010A\u001a\u00020'H\u0002J\b\u0010B\u001a\u00020'H\u0002R\u0010\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0004\n\u0002\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0004\n\u0002\u0010\u001dR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u00020!X\u0004¢\u0006\u0004\n\u0002\u0010\"R\u0010\u0010#\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/coolapk/market/widget/FastReturnView;", "Landroid/widget/FrameLayout;", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "dataSetObserver", "com/coolapk/market/widget/FastReturnView$dataSetObserver$1", "Lcom/coolapk/market/widget/FastReturnView$dataSetObserver$1;", "dependentViewGone", "", "detector", "Landroidx/core/view/GestureDetectorCompat;", "hideAnim", "Landroid/animation/Animator;", "isDependent", "isShow", "lastRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "listener", "com/coolapk/market/widget/FastReturnView$listener$1", "Lcom/coolapk/market/widget/FastReturnView$listener$1;", "offsetY", "", "onPageChangeListener", "com/coolapk/market/widget/FastReturnView$onPageChangeListener$1", "Lcom/coolapk/market/widget/FastReturnView$onPageChangeListener$1;", "refreshView", "", "scrollListener", "com/coolapk/market/widget/FastReturnView$scrollListener$1", "Lcom/coolapk/market/widget/FastReturnView$scrollListener$1;", "startAnim", "touchSlop", "", "addTo", "", "viewGroup", "Landroid/view/ViewGroup;", "bindFragment", "fragment", "Landroidx/fragment/app/Fragment;", "bindRecyclerView", "recyclerView", "bindViewPager", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "dependentAboveOn", "view", "Landroid/view/View;", "getBottomMargin", "hideView", "immediately", "initUI", "isShowFastReturnView", "onDetachedFromWindow", "onSharedPreferenceChanged", "sharedPreferences", "Landroid/content/SharedPreferences;", "key", "", "setOffset", "showView", "updateBottomMargin", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FastReturnView.kt */
public final class FastReturnView extends FrameLayout implements SharedPreferences.OnSharedPreferenceChangeListener {
    public static final Companion Companion = new Companion(null);
    private static final int MARGIN = NumberExtendsKt.getDp((Number) 12);
    private static final int WRAP_CONTENT = -2;
    private final FastReturnView$dataSetObserver$1 dataSetObserver;
    private boolean dependentViewGone;
    private final GestureDetectorCompat detector;
    private Animator hideAnim;
    private boolean isDependent;
    private boolean isShow;
    private RecyclerView lastRecyclerView;
    private final FastReturnView$listener$1 listener;
    private int offsetY;
    private final FastReturnView$onPageChangeListener$1 onPageChangeListener;
    private Object refreshView;
    private final FastReturnView$scrollListener$1 scrollListener;
    private Animator startAnim;
    private float touchSlop;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/coolapk/market/widget/FastReturnView$Companion;", "", "()V", "MARGIN", "", "WRAP_CONTENT", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FastReturnView.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FastReturnView(Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastReturnView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.touchSlop = ((float) ScreenUtils.getScreenHeight()) * 0.1f;
        FastReturnView$listener$1 fastReturnView$listener$1 = new FastReturnView$listener$1(this);
        this.listener = fastReturnView$listener$1;
        GestureDetectorCompat gestureDetectorCompat = new GestureDetectorCompat(getContext(), fastReturnView$listener$1);
        gestureDetectorCompat.setOnDoubleTapListener(fastReturnView$listener$1);
        Unit unit = Unit.INSTANCE;
        this.detector = gestureDetectorCompat;
        this.scrollListener = new FastReturnView$scrollListener$1(this);
        this.dataSetObserver = new FastReturnView$dataSetObserver$1(this);
        this.onPageChangeListener = new FastReturnView$onPageChangeListener$1(this);
        initUI();
        DataManager.getInstance().registerPreferenceChangeListener(this);
    }

    @Override // android.view.View, android.view.ViewGroup
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        DataManager.getInstance().unregisterPreferenceChangeListener(this);
        try {
            this.onPageChangeListener.clear();
            this.dataSetObserver.clear();
            this.scrollListener.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final void initUI() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(AppHolder.getAppTheme().getContentBackgroundColor());
        gradientDrawable.setAlpha((int) 229.5f);
        setBackgroundDrawable(gradientDrawable);
        setElevation((float) ConvertUtils.dp2px(1.0f));
        int dp2px = ConvertUtils.dp2px(32.0f);
        setMinimumHeight(dp2px);
        setMinimumWidth(dp2px);
        setVisibility(4);
        ImageView imageView = new ImageView(getContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        Drawable drawable = ResourceUtils.getDrawable(imageView.getContext(), 2131231530);
        int dp2px2 = ConvertUtils.dp2px(10.0f);
        Objects.requireNonNull(drawable, "null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
        BitmapDrawable bitmapDrawable = new BitmapDrawable(imageView.getResources(), Bitmap.createScaledBitmap(((BitmapDrawable) drawable).getBitmap(), dp2px2, dp2px2, true));
        DrawableCompat.setTint(bitmapDrawable, AppHolder.getAppTheme().getTextColorTertiary());
        imageView.setImageDrawable(bitmapDrawable);
        if (Build.VERSION.SDK_INT >= 23) {
            imageView.setBackground(ResourceUtils.getDrawable(imageView.getContext(), ResourceUtils.resolveResId(imageView.getContext(), 16843868)));
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dp2px, dp2px);
        layoutParams.gravity = 17;
        Unit unit = Unit.INSTANCE;
        addView(imageView, layoutParams);
    }

    /* access modifiers changed from: private */
    public final void showView() {
        if (!this.isShow) {
            this.isShow = true;
            Animator animator = this.hideAnim;
            if (animator != null) {
                animator.cancel();
            }
            setVisibility(0);
            setOnTouchListener(new FastReturnView$showView$1(this));
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, FrameLayout.ALPHA, getAlpha(), 1.0f);
            ofFloat.setDuration(200L);
            Unit unit = Unit.INSTANCE;
            ObjectAnimator objectAnimator = ofFloat;
            this.startAnim = objectAnimator;
            Intrinsics.checkNotNull(objectAnimator);
            objectAnimator.start();
        }
    }

    /* access modifiers changed from: private */
    public final void hideView(boolean z) {
        Animator animator;
        long j = 0;
        if (z && (animator = this.hideAnim) != null) {
            Intrinsics.checkNotNull(animator);
            if (animator.isStarted()) {
                Animator animator2 = this.hideAnim;
                Intrinsics.checkNotNull(animator2);
                if (animator2.getStartDelay() > 0) {
                    Animator animator3 = this.hideAnim;
                    if (animator3 != null) {
                        animator3.cancel();
                    }
                    this.isShow = true;
                }
            }
        }
        if (this.isShow) {
            this.isShow = false;
            Animator animator4 = this.startAnim;
            if (animator4 != null) {
                animator4.cancel();
            }
            setVisibility(0);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, FrameLayout.ALPHA, getAlpha(), 0.0f);
            ofFloat.setDuration(200L);
            if (!z) {
                j = 2000;
            }
            ofFloat.setStartDelay(j);
            ofFloat.addListener(new FastReturnView$hideView$$inlined$apply$lambda$1(this, z));
            Unit unit = Unit.INSTANCE;
            ObjectAnimator objectAnimator = ofFloat;
            this.hideAnim = objectAnimator;
            Intrinsics.checkNotNull(objectAnimator);
            objectAnimator.start();
        }
    }

    public final void addTo(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        if (viewGroup instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 81;
            layoutParams.bottomMargin = getBottomMargin();
            Unit unit = Unit.INSTANCE;
            viewGroup.addView(this, layoutParams);
        } else if (viewGroup instanceof LinearLayout) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 81;
            layoutParams2.bottomMargin = getBottomMargin();
            Unit unit2 = Unit.INSTANCE;
            viewGroup.addView(this, layoutParams2);
        } else if (viewGroup instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams3.addRule(12, -1);
            layoutParams3.addRule(14, -1);
            layoutParams3.bottomMargin = getBottomMargin();
            Unit unit3 = Unit.INSTANCE;
            viewGroup.addView(this, layoutParams3);
        } else if (viewGroup instanceof CoordinatorLayout) {
            CoordinatorLayout.LayoutParams layoutParams4 = new CoordinatorLayout.LayoutParams(-2, -2);
            layoutParams4.gravity = 81;
            layoutParams4.bottomMargin = getBottomMargin();
            Unit unit4 = Unit.INSTANCE;
            viewGroup.addView(this, layoutParams4);
        } else {
            throw new UnsupportedOperationException("You must implement it");
        }
    }

    public final void dependentAboveOn(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        boolean z = true;
        this.isDependent = true;
        if (view.getVisibility() != 8) {
            z = false;
        }
        this.dependentViewGone = z;
        ViewParent parent = view.getParent();
        Objects.requireNonNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        addTo((ViewGroup) parent);
        view.getViewTreeObserver().addOnGlobalLayoutListener(new FastReturnView$dependentAboveOn$1(this, view));
        view.addOnLayoutChangeListener(new FastReturnView$dependentAboveOn$2(this, view));
    }

    /* access modifiers changed from: private */
    public final void updateBottomMargin() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
            Objects.requireNonNull(layoutParams2, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            ((FrameLayout.LayoutParams) layoutParams2).bottomMargin = getBottomMargin();
        } else if (layoutParams instanceof LinearLayout.LayoutParams) {
            ViewGroup.LayoutParams layoutParams3 = getLayoutParams();
            Objects.requireNonNull(layoutParams3, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            ((LinearLayout.LayoutParams) layoutParams3).bottomMargin = getBottomMargin();
        } else if (layoutParams instanceof RelativeLayout.LayoutParams) {
            ViewGroup.LayoutParams layoutParams4 = getLayoutParams();
            Objects.requireNonNull(layoutParams4, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            ((RelativeLayout.LayoutParams) layoutParams4).bottomMargin = getBottomMargin();
        } else if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
            ViewGroup.LayoutParams layoutParams5 = getLayoutParams();
            Objects.requireNonNull(layoutParams5, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
            ((CoordinatorLayout.LayoutParams) layoutParams5).bottomMargin = getBottomMargin();
        } else {
            throw new UnsupportedOperationException("You must implement it");
        }
        invalidate();
    }

    private final int getBottomMargin() {
        return ((!this.isDependent || this.dependentViewGone) ? MARGIN : 0) + this.offsetY;
    }

    public final void setOffset(int i) {
        this.offsetY = i;
    }

    public final void bindRecyclerView(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Animator animator = this.hideAnim;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.startAnim;
        if (animator2 != null) {
            animator2.cancel();
        }
        setAlpha(0.0f);
        setVisibility(4);
        RecyclerView recyclerView2 = this.lastRecyclerView;
        if (recyclerView2 != null) {
            recyclerView2.removeOnScrollListener(this.scrollListener);
        }
        this.lastRecyclerView = recyclerView;
        recyclerView.addOnScrollListener(this.scrollListener);
    }

    public final void bindViewPager(ViewPager viewPager) {
        PagerAdapter adapter;
        if (viewPager != null && (adapter = viewPager.getAdapter()) != null) {
            Intrinsics.checkNotNullExpressionValue(adapter, "viewPager.adapter ?: return");
            this.onPageChangeListener.setViewPager(viewPager);
            viewPager.removeOnPageChangeListener(this.onPageChangeListener);
            viewPager.addOnPageChangeListener(this.onPageChangeListener);
            this.dataSetObserver.setViewPager(viewPager);
            try {
                adapter.unregisterDataSetObserver(this.dataSetObserver);
            } catch (Exception unused) {
            }
            try {
                adapter.registerDataSetObserver(this.dataSetObserver);
            } catch (Exception unused2) {
            }
            Object instantiateItem = adapter.instantiateItem((ViewGroup) viewPager, viewPager.getCurrentItem());
            Objects.requireNonNull(instantiateItem, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
            Fragment fragment = (Fragment) instantiateItem;
            if ((fragment instanceof NewAsyncListFragment) || (fragment instanceof AsyncListFragment)) {
                this.refreshView = fragment;
            }
            if ((fragment instanceof RefreshRecyclerFragment) && !(fragment instanceof LocalMultiTypeFragment)) {
                if (fragment.getView() == null) {
                    post(new FastReturnView$bindViewPager$1(this, viewPager));
                    return;
                }
                RecyclerView recyclerView = ((RefreshRecyclerFragment) fragment).getRecyclerView();
                Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
                bindRecyclerView(recyclerView);
            }
        }
    }

    public final void bindFragment(Fragment fragment) {
        if (fragment != null) {
            if (fragment.getView() == null) {
                post(new FastReturnView$bindFragment$1(this, fragment));
            } else if (fragment instanceof ViewPagerFragment) {
                bindViewPager(((ViewPagerFragment) fragment).obtainViewPage());
            } else if (fragment instanceof RefreshRecyclerFragment) {
                if ((fragment instanceof NewAsyncListFragment) || (fragment instanceof AsyncListFragment)) {
                    this.refreshView = fragment;
                }
                RecyclerView recyclerView = ((RefreshRecyclerFragment) fragment).getRecyclerView();
                Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
                bindRecyclerView(recyclerView);
            }
        }
    }

    /* access modifiers changed from: private */
    public final boolean isShowFastReturnView() {
        AppSetting appSetting = AppHolder.getAppSetting();
        Intrinsics.checkNotNullExpressionValue(appSetting, "AppHolder.getAppSetting()");
        return appSetting.isShowFastReturnView();
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        Intrinsics.checkNotNullParameter(str, "key");
        if (Intrinsics.areEqual(str, "show_fast_return_view") && isShowFastReturnView()) {
            hideView(true);
        }
    }
}
