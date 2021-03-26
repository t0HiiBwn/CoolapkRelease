package com.coolapk.market.view.userv9;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.PagerAdapter;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.UserProfile;
import com.coolapk.market.view.base.refresh.RefreshRecyclerFragment;
import com.coolapk.market.view.userv9.UserSpaceAppBarBehavior;
import com.coolapk.market.widget.slidr.ScrollStateViewPager;
import com.coolapk.market.widget.view.IgnoreInsetFrameLayout;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u001bH\u0002J\b\u0010\u001d\u001a\u00020\u0018H\u0016J\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u0003H\u0016J\u0010\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u0003H\u0016J\b\u0010\"\u001a\u00020\u001bH\u0016J\b\u0010#\u001a\u00020\u001bH\u0016J\u000e\u0010$\u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u0003J\u0010\u0010%\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020\u0003H\u0002R\u0014\u0010\u0002\u001a\u00020\u0003XD¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0003XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u00020\u0003XD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0005R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0005\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0005\"\u0004\b\u0016\u0010\u0013R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000¨\u0006'¸\u0006\u0000"}, d2 = {"com/coolapk/market/view/userv9/UserSpaceV9Activity$setupHeaderView$6$1", "Lcom/coolapk/market/view/userv9/UserSpaceAppBarBehavior$Callback;", "STATE_CONTINUE", "", "getSTATE_CONTINUE", "()I", "STATE_NONE", "getSTATE_NONE", "STATE_REFRESH", "getSTATE_REFRESH", "animator", "Landroid/animation/ValueAnimator;", "getAnimator", "()Landroid/animation/ValueAnimator;", "setAnimator", "(Landroid/animation/ValueAnimator;)V", "currentRefreshState", "getCurrentRefreshState", "setCurrentRefreshState", "(I)V", "offset", "getOffset", "setOffset", "pullDownRefreshEnable", "", "triggerRefresh", "checkPullDownToRefreshOffset", "", "checkTriggerRefresh", "hasPullDownOffset", "onOverScrollDown", "dyUnconsumed", "onPreScroll", "dy", "onSingleTap", "onStopScroll", "setPullDownOffset", "setRefreshState", "state", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: UserSpaceV9Activity.kt */
public final class UserSpaceV9Activity$setupHeaderView$$inlined$doOnNextPreDraw$1$lambda$1 implements UserSpaceAppBarBehavior.Callback {
    final /* synthetic */ int $continueThreshold;
    final /* synthetic */ int $maxPullDownThreshold;
    final /* synthetic */ int $pullDownRefreshThreshold;
    private final int STATE_CONTINUE = 1;
    private final int STATE_NONE;
    private final int STATE_REFRESH = 2;
    private ValueAnimator animator;
    private int currentRefreshState;
    private int offset;
    private boolean pullDownRefreshEnable = true;
    final /* synthetic */ UserSpaceV9Activity$setupHeaderView$$inlined$doOnNextPreDraw$1 this$0;
    private boolean triggerRefresh;

    UserSpaceV9Activity$setupHeaderView$$inlined$doOnNextPreDraw$1$lambda$1(int i, int i2, int i3, UserSpaceV9Activity$setupHeaderView$$inlined$doOnNextPreDraw$1 userSpaceV9Activity$setupHeaderView$$inlined$doOnNextPreDraw$1) {
        this.$maxPullDownThreshold = i;
        this.$pullDownRefreshThreshold = i2;
        this.$continueThreshold = i3;
        this.this$0 = userSpaceV9Activity$setupHeaderView$$inlined$doOnNextPreDraw$1;
    }

    public final int getOffset() {
        return this.offset;
    }

    public final void setOffset(int i) {
        this.offset = i;
    }

    public final ValueAnimator getAnimator() {
        return this.animator;
    }

    public final void setAnimator(ValueAnimator valueAnimator) {
        this.animator = valueAnimator;
    }

    public final int getCurrentRefreshState() {
        return this.currentRefreshState;
    }

    public final void setCurrentRefreshState(int i) {
        this.currentRefreshState = i;
    }

    public final int getSTATE_NONE() {
        return this.STATE_NONE;
    }

    public final int getSTATE_CONTINUE() {
        return this.STATE_CONTINUE;
    }

    public final int getSTATE_REFRESH() {
        return this.STATE_REFRESH;
    }

    @Override // com.coolapk.market.view.userv9.UserSpaceAppBarBehavior.Callback
    public void onSingleTap() {
        if (this.this$0.this$0.viewModel.isLoginUser()) {
            this.this$0.this$0.showChangeCoverDialog();
            return;
        }
        UserProfile userProfile = this.this$0.this$0.viewModel.getUserProfile();
        Intrinsics.checkNotNull(userProfile);
        String cover = userProfile.getCover();
        UserProfile userProfile2 = this.this$0.this$0.viewModel.getUserProfile();
        Intrinsics.checkNotNull(userProfile2);
        ActionManager.startPhotoViewActivity(UserSpaceV9Activity.access$getBinding$p(this.this$0.this$0).backgroundView, cover, userProfile2.getCover());
    }

    @Override // com.coolapk.market.view.userv9.UserSpaceAppBarBehavior.Callback
    public void onOverScrollDown(int i) {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        setPullDownOffset(this.offset + i);
    }

    @Override // com.coolapk.market.view.userv9.UserSpaceAppBarBehavior.Callback
    public int onPreScroll(int i) {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        int i2 = this.offset;
        if (i2 <= 0) {
            return 0;
        }
        if (i <= 0) {
            setPullDownOffset(Math.abs(i) + i2);
            return i;
        } else if (i < i2) {
            setPullDownOffset(i2 - i);
            return i;
        } else {
            setPullDownOffset(0);
            return i - i2;
        }
    }

    public final void setPullDownOffset(int i) {
        int i2 = this.$maxPullDownThreshold;
        if (i > i2) {
            i = i2;
        }
        this.offset = i;
        checkPullDownToRefreshOffset();
        int i3 = (int) (((double) i) * 0.9d);
        float f = (float) i3;
        ScrollStateViewPager scrollStateViewPager = UserSpaceV9Activity.access$getBinding$p(this.this$0.this$0).viewPager;
        Intrinsics.checkNotNullExpressionValue(scrollStateViewPager, "binding.viewPager");
        if (f != scrollStateViewPager.getTranslationY()) {
            ScrollStateViewPager scrollStateViewPager2 = UserSpaceV9Activity.access$getBinding$p(this.this$0.this$0).viewPager;
            Intrinsics.checkNotNullExpressionValue(scrollStateViewPager2, "binding.viewPager");
            scrollStateViewPager2.setTranslationY(f);
            IgnoreInsetFrameLayout ignoreInsetFrameLayout = UserSpaceV9Activity.access$getBinding$p(this.this$0.this$0).appBarHolder;
            Intrinsics.checkNotNullExpressionValue(ignoreInsetFrameLayout, "binding.appBarHolder");
            int i4 = ignoreInsetFrameLayout.getLayoutParams().height;
            IgnoreInsetFrameLayout ignoreInsetFrameLayout2 = UserSpaceV9Activity.access$getBinding$p(this.this$0.this$0).tabContainer;
            Intrinsics.checkNotNullExpressionValue(ignoreInsetFrameLayout2, "binding.tabContainer");
            ignoreInsetFrameLayout2.getLayoutParams().height = i4 + i3;
            UserSpaceV9Activity.access$getBinding$p(this.this$0.this$0).tabContainer.requestLayout();
        }
    }

    @Override // com.coolapk.market.view.userv9.UserSpaceAppBarBehavior.Callback
    public void onStopScroll() {
        if (this.offset != 0) {
            checkTriggerRefresh();
            ValueAnimator valueAnimator = this.animator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            ValueAnimator valueAnimator2 = new ValueAnimator();
            valueAnimator2.setIntValues(this.offset, 0);
            valueAnimator2.setInterpolator(new DecelerateInterpolator());
            valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
                /* class com.coolapk.market.view.userv9.UserSpaceV9Activity$setupHeaderView$$inlined$doOnNextPreDraw$1$lambda$1.AnonymousClass1 */
                final /* synthetic */ UserSpaceV9Activity$setupHeaderView$$inlined$doOnNextPreDraw$1$lambda$1 this$0;

                {
                    this.this$0 = r1;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Intrinsics.checkNotNullExpressionValue(valueAnimator, "it");
                    Object animatedValue = valueAnimator.getAnimatedValue();
                    Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
                    this.this$0.setPullDownOffset(((Integer) animatedValue).intValue());
                }
            });
            Unit unit = Unit.INSTANCE;
            this.animator = valueAnimator2;
            if (valueAnimator2 != null) {
                valueAnimator2.start();
            }
        }
    }

    private final void checkPullDownToRefreshOffset() {
        if (this.pullDownRefreshEnable) {
            int i = this.offset;
            if (i >= this.$pullDownRefreshThreshold) {
                setRefreshState(this.STATE_REFRESH);
            } else if (i >= this.$continueThreshold) {
                setRefreshState(this.STATE_CONTINUE);
            } else {
                setRefreshState(this.STATE_NONE);
            }
        }
    }

    private final void checkTriggerRefresh() {
        final Object obj;
        if (this.pullDownRefreshEnable) {
            if (this.offset >= this.$pullDownRefreshThreshold && this.triggerRefresh) {
                ScrollStateViewPager scrollStateViewPager = UserSpaceV9Activity.access$getBinding$p(this.this$0.this$0).viewPager;
                Intrinsics.checkNotNullExpressionValue(scrollStateViewPager, "binding.viewPager");
                PagerAdapter adapter = scrollStateViewPager.getAdapter();
                if (adapter != null) {
                    ScrollStateViewPager scrollStateViewPager2 = UserSpaceV9Activity.access$getBinding$p(this.this$0.this$0).viewPager;
                    Intrinsics.checkNotNullExpressionValue(scrollStateViewPager2, "binding.viewPager");
                    obj = adapter.instantiateItem((ViewGroup) UserSpaceV9Activity.access$getBinding$p(this.this$0.this$0).viewPager, scrollStateViewPager2.getCurrentItem());
                } else {
                    obj = null;
                }
                if (obj instanceof RefreshRecyclerFragment) {
                    RefreshRecyclerFragment refreshRecyclerFragment = (RefreshRecyclerFragment) obj;
                    refreshRecyclerFragment.setRefreshEnable(true);
                    this.pullDownRefreshEnable = false;
                    refreshRecyclerFragment.startDelayRefresh(new Runnable(this) {
                        /* class com.coolapk.market.view.userv9.UserSpaceV9Activity$setupHeaderView$$inlined$doOnNextPreDraw$1$lambda$1.AnonymousClass2 */
                        final /* synthetic */ UserSpaceV9Activity$setupHeaderView$$inlined$doOnNextPreDraw$1$lambda$1 this$0;

                        {
                            this.this$0 = r1;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            SwipeRefreshLayout swipeRefreshLayout = ((RefreshRecyclerFragment) obj).getSwipeRefreshLayout();
                            Intrinsics.checkNotNullExpressionValue(swipeRefreshLayout, "fragment.swipeRefreshLayout");
                            swipeRefreshLayout.setRefreshing(false);
                            ((RefreshRecyclerFragment) obj).getSwipeRefreshLayout().postDelayed(new Runnable(this) {
                                /* class com.coolapk.market.view.userv9.UserSpaceV9Activity$setupHeaderView$$inlined$doOnNextPreDraw$1$lambda$1.AnonymousClass2.AnonymousClass1 */
                                final /* synthetic */ AnonymousClass2 this$0;

                                {
                                    this.this$0 = r1;
                                }

                                @Override // java.lang.Runnable
                                public final void run() {
                                    ((RefreshRecyclerFragment) obj).setRefreshEnable(false);
                                    this.this$0.this$0.pullDownRefreshEnable = true;
                                }
                            }, 300);
                        }
                    });
                }
            }
            setRefreshState(this.STATE_NONE);
        }
    }

    private final void setRefreshState(int i) {
        int i2 = this.currentRefreshState;
        if (i2 != i) {
            int i3 = this.STATE_NONE;
            if (i2 == i3) {
                FrameLayout frameLayout = UserSpaceV9Activity.access$getBinding$p(this.this$0.this$0).refreshView;
                Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.refreshView");
                frameLayout.setVisibility(0);
                ViewPropertyAnimator alpha = UserSpaceV9Activity.access$getBinding$p(this.this$0.this$0).refreshView.animate().alpha(1.0f);
                alpha.setListener(null);
                alpha.setDuration(200);
                alpha.start();
            } else if (i == i3) {
                FrameLayout frameLayout2 = UserSpaceV9Activity.access$getBinding$p(this.this$0.this$0).refreshView;
                Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.refreshView");
                if (frameLayout2.getVisibility() == 0) {
                    ViewPropertyAnimator alpha2 = UserSpaceV9Activity.access$getBinding$p(this.this$0.this$0).refreshView.animate().alpha(0.0f);
                    alpha2.setListener(new AnimatorListenerAdapter(this) {
                        /* class com.coolapk.market.view.userv9.UserSpaceV9Activity$setupHeaderView$$inlined$doOnNextPreDraw$1$lambda$1.AnonymousClass3 */
                        final /* synthetic */ UserSpaceV9Activity$setupHeaderView$$inlined$doOnNextPreDraw$1$lambda$1 this$0;

                        {
                            this.this$0 = r1;
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            FrameLayout frameLayout = UserSpaceV9Activity.access$getBinding$p(this.this$0.this$0.this$0).refreshView;
                            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.refreshView");
                            frameLayout.setVisibility(8);
                        }
                    });
                    alpha2.setDuration(200);
                    alpha2.start();
                }
            }
            if (i == this.STATE_CONTINUE) {
                TextView textView = UserSpaceV9Activity.access$getBinding$p(this.this$0.this$0).refreshTextView;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.refreshTextView");
                textView.setText("继续下拉刷新");
                this.triggerRefresh = false;
            } else if (i == this.STATE_REFRESH) {
                TextView textView2 = UserSpaceV9Activity.access$getBinding$p(this.this$0.this$0).refreshTextView;
                Intrinsics.checkNotNullExpressionValue(textView2, "binding.refreshTextView");
                textView2.setText("松开立即刷新");
                this.triggerRefresh = true;
            } else {
                this.triggerRefresh = false;
            }
            this.currentRefreshState = i;
        }
    }

    @Override // com.coolapk.market.view.userv9.UserSpaceAppBarBehavior.Callback
    public boolean hasPullDownOffset() {
        return this.offset > 0;
    }
}
