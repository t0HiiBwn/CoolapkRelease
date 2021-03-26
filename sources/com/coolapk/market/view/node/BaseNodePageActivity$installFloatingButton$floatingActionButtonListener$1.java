package com.coolapk.market.view.node;

import android.content.res.ColorStateList;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.view.base.refresh.RefreshRecyclerFragment;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import com.coolapk.market.widget.slidr.ScrollStateViewPager;
import com.coolapk.market.widget.view.VXNestedScrollView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.Subscription;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003H\u0002J\u000e\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0003J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0003H\u0016J\u000e\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"com/coolapk/market/view/node/BaseNodePageActivity$installFloatingButton$floatingActionButtonListener$1", "Landroidx/viewpager/widget/ViewPager$SimpleOnPageChangeListener;", "isMoveDownAnimating", "", "isRefresh", "", "refreshTouchSlop", "refreshViewVisibilityThreshold", "subscription", "Lrx/Subscription;", "animateToTransitionY", "", "y", "", "checkRefreshStates", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dy", "onFloatingTopChanged", "floatingTop", "onPageSelected", "position", "resetListenerTo", "showRefresh", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: BaseNodePageActivity.kt */
public final class BaseNodePageActivity$installFloatingButton$floatingActionButtonListener$1 extends ViewPager.SimpleOnPageChangeListener {
    private int isMoveDownAnimating;
    private boolean isRefresh;
    private int refreshTouchSlop = NumberExtendsKt.getDp((Number) 8);
    private final int refreshViewVisibilityThreshold = NumberExtendsKt.getDp((Number) 0);
    private Subscription subscription;
    final /* synthetic */ BaseNodePageActivity this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    BaseNodePageActivity$installFloatingButton$floatingActionButtonListener$1(BaseNodePageActivity baseNodePageActivity) {
        this.this$0 = baseNodePageActivity;
        baseNodePageActivity.getBinding$presentation_coolapkAppRelease().floatingButton.setOnClickListener(new View.OnClickListener(this) {
            /* class com.coolapk.market.view.node.BaseNodePageActivity$installFloatingButton$floatingActionButtonListener$1.AnonymousClass1 */
            final /* synthetic */ BaseNodePageActivity$installFloatingButton$floatingActionButtonListener$1 this$0;

            {
                this.this$0 = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (this.this$0.isMoveDownAnimating == 0) {
                    if (this.this$0.isRefresh) {
                        this.this$0.this$0.refreshAndScrollToTop();
                        return;
                    }
                    this.this$0.this$0.getBinding$presentation_coolapkAppRelease().nestedBackgroundView.setDisableScroll(true);
                    this.this$0.this$0.getBinding$presentation_coolapkAppRelease().nestedBackgroundView.postDelayed(new Runnable(this) {
                        /* class com.coolapk.market.view.node.BaseNodePageActivity$installFloatingButton$floatingActionButtonListener$1.AnonymousClass1.AnonymousClass1 */
                        final /* synthetic */ AnonymousClass1 this$0;

                        {
                            this.this$0 = r1;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            this.this$0.this$0.this$0.getBinding$presentation_coolapkAppRelease().nestedBackgroundView.setDisableScroll(false);
                        }
                    }, 300);
                    FloatingActionButton floatingActionButton = this.this$0.this$0.getBinding$presentation_coolapkAppRelease().floatingButton;
                    Intrinsics.checkNotNullExpressionValue(floatingActionButton, "binding.floatingButton");
                    float translationY = floatingActionButton.getTranslationY();
                    DrawSystemBarFrameLayout drawSystemBarFrameLayout = this.this$0.this$0.getBinding$presentation_coolapkAppRelease().mainContent;
                    Intrinsics.checkNotNullExpressionValue(drawSystemBarFrameLayout, "binding.mainContent");
                    this.this$0.this$0.onFloatingButtonAction(translationY - ((float) drawSystemBarFrameLayout.getLastInsetsRect().bottom));
                }
            }
        });
        baseNodePageActivity.getBinding$presentation_coolapkAppRelease().floatingButton.post(new Runnable(this) {
            /* class com.coolapk.market.view.node.BaseNodePageActivity$installFloatingButton$floatingActionButtonListener$1.AnonymousClass2 */
            final /* synthetic */ BaseNodePageActivity$installFloatingButton$floatingActionButtonListener$1 this$0;

            {
                this.this$0 = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                BaseNodePageActivity$installFloatingButton$floatingActionButtonListener$1 baseNodePageActivity$installFloatingButton$floatingActionButtonListener$1 = this.this$0;
                ScrollStateViewPager scrollStateViewPager = baseNodePageActivity$installFloatingButton$floatingActionButtonListener$1.this$0.getBinding$presentation_coolapkAppRelease().viewPager;
                Intrinsics.checkNotNullExpressionValue(scrollStateViewPager, "binding.viewPager");
                baseNodePageActivity$installFloatingButton$floatingActionButtonListener$1.onPageSelected(scrollStateViewPager.getCurrentItem());
            }
        });
        FloatingActionButton floatingActionButton = baseNodePageActivity.getBinding$presentation_coolapkAppRelease().floatingButton;
        Intrinsics.checkNotNullExpressionValue(floatingActionButton, "binding.floatingButton");
        floatingActionButton.setImageTintList(ColorStateList.valueOf(-1));
        FloatingActionButton floatingActionButton2 = baseNodePageActivity.getBinding$presentation_coolapkAppRelease().floatingButton;
        Intrinsics.checkNotNullExpressionValue(floatingActionButton2, "binding.floatingButton");
        floatingActionButton2.setVisibility(0);
    }

    @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        ScrollStateViewPager scrollStateViewPager = this.this$0.getBinding$presentation_coolapkAppRelease().viewPager;
        Intrinsics.checkNotNullExpressionValue(scrollStateViewPager, "binding.viewPager");
        PagerAdapter adapter = scrollStateViewPager.getAdapter();
        Object instantiateItem = adapter != null ? adapter.instantiateItem((ViewGroup) scrollStateViewPager, scrollStateViewPager.getCurrentItem()) : null;
        if (instantiateItem instanceof RefreshRecyclerFragment) {
            RefreshRecyclerFragment refreshRecyclerFragment = (RefreshRecyclerFragment) instantiateItem;
            if (refreshRecyclerFragment.isVisible()) {
                SwipeRefreshLayout swipeRefreshLayout = refreshRecyclerFragment.getSwipeRefreshLayout();
                Intrinsics.checkNotNullExpressionValue(swipeRefreshLayout, "fragment.swipeRefreshLayout");
                if (swipeRefreshLayout.isEnabled()) {
                    RecyclerView recyclerView = refreshRecyclerFragment.getRecyclerView();
                    Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
                    resetListenerTo(recyclerView);
                }
            }
        }
    }

    public final void resetListenerTo(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Subscription subscription2 = this.subscription;
        if (subscription2 != null) {
            subscription2.unsubscribe();
        }
        this.subscription = ViewExtendsKt.newScrollYObservable(recyclerView).subscribe(new BaseNodePageActivity$installFloatingButton$floatingActionButtonListener$1$resetListenerTo$1(this, recyclerView));
        checkRefreshStates(recyclerView, 0);
    }

    /* access modifiers changed from: private */
    public final void checkRefreshStates(RecyclerView recyclerView, int i) {
        boolean z = !ViewExtendsKt.canScrollDown(recyclerView);
        View view = this.this$0.getBinding$presentation_coolapkAppRelease().divider;
        Intrinsics.checkNotNullExpressionValue(view, "binding.divider");
        view.setVisibility(z ? 4 : 0);
        if (z) {
            showRefresh(false);
            return;
        }
        int i2 = this.refreshTouchSlop;
        if (i < (-i2)) {
            showRefresh(true);
        } else if (i > i2) {
            showRefresh(false);
        }
    }

    public final void onFloatingTopChanged(int i) {
        if (i + this.refreshViewVisibilityThreshold < this.this$0.getHelper$presentation_coolapkAppRelease().getMaxFloatingTop()) {
            FloatingActionButton floatingActionButton = this.this$0.getBinding$presentation_coolapkAppRelease().floatingButton;
            Intrinsics.checkNotNullExpressionValue(floatingActionButton, "binding.floatingButton");
            if (floatingActionButton.getTranslationY() != 0.0f && this.isMoveDownAnimating >= 0) {
                this.isMoveDownAnimating = -1;
                animateToTransitionY(0.0f);
                return;
            }
            return;
        }
        showRefresh(false);
        VXNestedScrollView vXNestedScrollView = this.this$0.getBinding$presentation_coolapkAppRelease().nestedBackgroundView;
        Intrinsics.checkNotNullExpressionValue(vXNestedScrollView, "binding.nestedBackgroundView");
        float maxFloatingTop = ((float) this.this$0.getHelper$presentation_coolapkAppRelease().getMaxFloatingTop()) - ((float) vXNestedScrollView.getHeight());
        FloatingActionButton floatingActionButton2 = this.this$0.getBinding$presentation_coolapkAppRelease().floatingButton;
        Intrinsics.checkNotNullExpressionValue(floatingActionButton2, "binding.floatingButton");
        if (floatingActionButton2.getTranslationY() != maxFloatingTop && this.isMoveDownAnimating <= 0) {
            this.isMoveDownAnimating = 1;
            animateToTransitionY(maxFloatingTop);
        }
    }

    private final void animateToTransitionY(float f) {
        this.this$0.getBinding$presentation_coolapkAppRelease().floatingButton.animate().translationY(f).setListener(new BaseNodePageActivity$installFloatingButton$floatingActionButtonListener$1$animateToTransitionY$1(this)).start();
    }

    public final void showRefresh(boolean z) {
        if (this.isRefresh != z) {
            this.isRefresh = z;
            if (z) {
                this.this$0.getBinding$presentation_coolapkAppRelease().floatingButton.setImageResource(2131231520);
            } else {
                this.this$0.getBinding$presentation_coolapkAppRelease().floatingButton.setImageResource(2131231443);
            }
        }
    }
}
