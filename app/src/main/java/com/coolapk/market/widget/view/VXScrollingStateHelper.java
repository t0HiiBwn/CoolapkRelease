package com.coolapk.market.widget.view;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.coolapk.market.extend.ExtraExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.util.KotlinExtendKt;
import com.coolapk.market.widget.view.VXNestedScrollView;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001a\u0010/\u001a\u00020$2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020$0#J\u000e\u0010/\u001a\u00020$2\u0006\u00100\u001a\u00020 J\u001a\u00101\u001a\u00020$2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020$0#J\u0006\u00102\u001a\u00020$J\u0006\u00103\u001a\u00020$J\b\u00104\u001a\u00020$H\u0002J\u0010\u00105\u001a\u00020$2\u0006\u0010\u0013\u001a\u00020\tH\u0002J\u0006\u00106\u001a\u000207J\u0006\u00108\u001a\u000207J\u0006\u00109\u001a\u000207J\u000e\u0010:\u001a\u0002072\u0006\u0010;\u001a\u00020\tJ\u000e\u0010<\u001a\u0002072\u0006\u0010;\u001a\u00020\tJ\u0006\u0010=\u001a\u000207J\u000e\u0010>\u001a\u00020\t2\u0006\u0010;\u001a\u00020\tJ\u000e\u0010?\u001a\u00020\t2\u0006\u0010@\u001a\u00020\tJ\u000e\u0010A\u001a\u00020$2\u0006\u0010B\u001a\u00020CJ\u0006\u0010D\u001a\u00020$J\u0016\u0010E\u001a\u00020$2\u0006\u0010F\u001a\u00020\t2\u0006\u0010G\u001a\u00020\tR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\t8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\t8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR$\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t8F@FX\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u000f\"\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u0018@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020 0\u001fj\b\u0012\u0004\u0012\u00020 `!X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R6\u0010\"\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020$0#0\u001fj\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020$0#`!X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\u00020\t8BX\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u000fR\u0011\u0010'\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b(\u0010\u000fR\u0014\u0010)\u001a\u00020\t8BX\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\u000fR\u0011\u0010+\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b,\u0010\u000fR\u000e\u0010-\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lcom/coolapk/market/widget/view/VXScrollingStateHelper;", "", "appendView", "Landroid/widget/FrameLayout;", "floatingView", "Lcom/coolapk/market/widget/view/VXProxyFloatingView;", "backgroundParent", "Lcom/coolapk/market/widget/view/VXNestedScrollView;", "cornerRadiusHeight", "", "(Landroid/widget/FrameLayout;Lcom/coolapk/market/widget/view/VXProxyFloatingView;Lcom/coolapk/market/widget/view/VXNestedScrollView;I)V", "animator", "Landroid/animation/ValueAnimator;", "appendViewTop", "getAppendViewTop", "()I", "coordinatorHeight", "getCoordinatorHeight", "getCornerRadiusHeight", "value", "currentFloatTop", "getCurrentFloatTop", "setCurrentFloatTop", "(I)V", "Lcom/coolapk/market/widget/view/FloatingState;", "floatingState", "getFloatingState", "()Lcom/coolapk/market/widget/view/FloatingState;", "setFloatingState", "(Lcom/coolapk/market/widget/view/FloatingState;)V", "floatingStateCallbacks", "Ljava/util/ArrayList;", "Lcom/coolapk/market/widget/view/ScrollStateHelperCallback;", "Lkotlin/collections/ArrayList;", "floatingViewTopListeners", "Lkotlin/Function1;", "", "maxAppendTop", "getMaxAppendTop", "maxFloatingTop", "getMaxFloatingTop", "minAppendTop", "getMinAppendTop", "minFloatingTop", "getMinFloatingTop", "minVelocityThreshold", "peekThreshold", "addFloatingStateCallback", "callback", "addFloatingTopChangeListener", "cancelCOEAnimation", "checkFloatViewScrollOffset", "dispatchFloatingStateChanged", "dispatchFloatingTopChanged", "isFloatingViewAppendingOrFakeAppending", "", "isFloatingViewExpandedOrAppendingExpanded", "isFloatingViewNeedCollapsedOrExpanded", "isFloatingViewScrollDownFromFloatingTop", "dy", "isFloatingViewScrollingOrScrollUpFromBottom", "isScrollingParentIsBeingTouched", "scrollBackgroundParentByDy", "scrollFloatingViewWithDelta", "delta", "startFloatingViewCOEAnimation", "velocity", "", "stopBackgroundViewScrolling", "syncUIState", "collapsedTop", "bottomInset", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: VXProxyFloatingView.kt */
public final class VXScrollingStateHelper {
    private ValueAnimator animator;
    private final FrameLayout appendView;
    private final VXNestedScrollView backgroundParent;
    private final int cornerRadiusHeight;
    private FloatingState floatingState = FloatingState.COLLAPSED;
    private final ArrayList<ScrollStateHelperCallback> floatingStateCallbacks = new ArrayList<>();
    private final VXProxyFloatingView floatingView;
    private ArrayList<Function1<Integer, Unit>> floatingViewTopListeners = new ArrayList<>();
    private final int minVelocityThreshold = NumberExtendsKt.getDp((Number) 64);
    private int peekThreshold = NumberExtendsKt.getDp((Number) 56);

    public VXScrollingStateHelper(FrameLayout frameLayout, VXProxyFloatingView vXProxyFloatingView, VXNestedScrollView vXNestedScrollView, int i) {
        Intrinsics.checkNotNullParameter(frameLayout, "appendView");
        Intrinsics.checkNotNullParameter(vXProxyFloatingView, "floatingView");
        Intrinsics.checkNotNullParameter(vXNestedScrollView, "backgroundParent");
        this.appendView = frameLayout;
        this.floatingView = vXProxyFloatingView;
        this.backgroundParent = vXNestedScrollView;
        this.cornerRadiusHeight = i;
        vXProxyFloatingView.setInitData(this);
        vXNestedScrollView.addOnScrollYChangedListener(new VXNestedScrollView.OnScrollYChangedListener(this) {
            /* class com.coolapk.market.widget.view.VXScrollingStateHelper.AnonymousClass1 */
            final /* synthetic */ VXScrollingStateHelper this$0;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.this$0 = r1;
            }

            @Override // com.coolapk.market.widget.view.VXNestedScrollView.OnScrollYChangedListener
            public void onScrollYChanged(VXNestedScrollView vXNestedScrollView, int i) {
                Intrinsics.checkNotNullParameter(vXNestedScrollView, "view");
                this.this$0.checkFloatViewScrollOffset();
            }
        });
        vXNestedScrollView.getChildAt(0).addOnLayoutChangeListener(new View.OnLayoutChangeListener(this) {
            /* class com.coolapk.market.widget.view.VXScrollingStateHelper.AnonymousClass2 */
            final /* synthetic */ VXScrollingStateHelper this$0;

            {
                this.this$0 = r1;
            }

            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                this.this$0.checkFloatViewScrollOffset();
            }
        });
    }

    public final int getCornerRadiusHeight() {
        return this.cornerRadiusHeight;
    }

    private final int getCoordinatorHeight() {
        ViewParent parent = this.backgroundParent.getParent();
        if (!(parent instanceof View)) {
            parent = null;
        }
        View view = (View) parent;
        if (view != null) {
            return view.getHeight() == 0 ? view.getMeasuredHeight() : view.getHeight();
        }
        return 0;
    }

    private final int getMaxAppendTop() {
        return (getCoordinatorHeight() - this.peekThreshold) + this.cornerRadiusHeight;
    }

    private final int getMinAppendTop() {
        return getCoordinatorHeight() - this.appendView.getHeight();
    }

    private final int getAppendViewTop() {
        return this.appendView.getTop() - this.backgroundParent.getScrollY();
    }

    public final int getMaxFloatingTop() {
        return getMaxAppendTop() - this.cornerRadiusHeight;
    }

    public final int getMinFloatingTop() {
        return getMinAppendTop() - this.cornerRadiusHeight;
    }

    public final int getCurrentFloatTop() {
        return (int) this.floatingView.getY();
    }

    public final void setCurrentFloatTop(int i) {
        if (i != getCurrentFloatTop()) {
            this.floatingView.setY((float) i);
            dispatchFloatingTopChanged(i);
        }
    }

    public final FloatingState getFloatingState() {
        return this.floatingState;
    }

    public final void setFloatingState(FloatingState floatingState2) {
        Intrinsics.checkNotNullParameter(floatingState2, "value");
        if (this.floatingState != floatingState2) {
            this.floatingState = floatingState2;
            dispatchFloatingStateChanged();
        }
    }

    public final void addFloatingTopChangeListener(Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "callback");
        this.floatingViewTopListeners.add(function1);
    }

    private final void dispatchFloatingTopChanged(int i) {
        for (Function1 function1 : CollectionsKt.toList(this.floatingViewTopListeners)) {
            function1.invoke(Integer.valueOf(i));
        }
    }

    public final void addFloatingStateCallback(Function1<? super FloatingState, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "callback");
        addFloatingStateCallback(new VXScrollingStateHelper$addFloatingStateCallback$1(function1));
    }

    public final void addFloatingStateCallback(ScrollStateHelperCallback scrollStateHelperCallback) {
        Intrinsics.checkNotNullParameter(scrollStateHelperCallback, "callback");
        this.floatingStateCallbacks.add(scrollStateHelperCallback);
    }

    private final void dispatchFloatingStateChanged() {
        Iterator<T> it2 = this.floatingStateCallbacks.iterator();
        while (it2.hasNext()) {
            it2.next().onFloatingStateChanged(this.floatingState);
        }
    }

    public final void syncUIState(int i, int i2) {
        this.peekThreshold = NumberExtendsKt.getDp((Number) 56) + i2;
        FrameLayout frameLayout = this.appendView;
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = getCoordinatorHeight() - i;
            frameLayout.setLayoutParams(layoutParams);
            VXProxyFloatingView vXProxyFloatingView = this.floatingView;
            ViewGroup.LayoutParams layoutParams2 = vXProxyFloatingView.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = (getCoordinatorHeight() - i) + this.cornerRadiusHeight;
                vXProxyFloatingView.setLayoutParams(layoutParams2);
                this.floatingView.post(new VXScrollingStateHelper$syncUIState$3(this));
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public final void checkFloatViewScrollOffset() {
        if (getAppendViewTop() >= getMaxAppendTop()) {
            if (this.floatingState == FloatingState.APPENDED) {
                setFloatingState(FloatingState.COLLAPSED);
            }
        } else if (!(this.floatingState == FloatingState.EXPANDED && this.floatingState == FloatingState.DRAGGING && this.floatingState == FloatingState.ANIMATING)) {
            setFloatingState(FloatingState.APPENDED);
        }
        if (this.floatingState == FloatingState.APPENDED || this.floatingState == FloatingState.COLLAPSED) {
            setCurrentFloatTop(KotlinExtendKt.constrain(getAppendViewTop(), getMaxAppendTop(), getMinAppendTop()) - this.cornerRadiusHeight);
        }
    }

    public final int scrollFloatingViewWithDelta(int i) {
        int maxFloatingTop;
        if (this.floatingState != FloatingState.DRAGGING) {
            return 0;
        }
        int currentFloatTop = getCurrentFloatTop();
        int i2 = currentFloatTop + i;
        if (i2 < getMinFloatingTop()) {
            setCurrentFloatTop(getMinFloatingTop());
            maxFloatingTop = getMinFloatingTop();
        } else if (i2 > getMaxFloatingTop()) {
            setCurrentFloatTop(getMaxFloatingTop());
            maxFloatingTop = getMaxFloatingTop();
        } else {
            setCurrentFloatTop(i2);
            return i;
        }
        return maxFloatingTop - currentFloatTop;
    }

    public final void cancelCOEAnimation() {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public final void startFloatingViewCOEAnimation(float f) {
        FloatingState floatingState2;
        long j;
        if (this.floatingState == FloatingState.DRAGGING) {
            setFloatingState(FloatingState.ANIMATING);
            int maxFloatingTop = getMaxFloatingTop() - getMinFloatingTop();
            int i = this.minVelocityThreshold;
            if (f > ((float) i)) {
                if (((float) getCurrentFloatTop()) + f > ((float) (getMinFloatingTop() + (maxFloatingTop / 6)))) {
                    floatingState2 = FloatingState.COLLAPSED;
                } else {
                    floatingState2 = FloatingState.EXPANDED;
                }
            } else if (f < ((float) (-i))) {
                if (((float) getCurrentFloatTop()) + f > ((float) (getMaxFloatingTop() - (maxFloatingTop / 6)))) {
                    floatingState2 = FloatingState.COLLAPSED;
                } else {
                    floatingState2 = FloatingState.EXPANDED;
                }
            } else if (getCurrentFloatTop() < getMinFloatingTop() + (maxFloatingTop / 2)) {
                floatingState2 = FloatingState.EXPANDED;
            } else {
                floatingState2 = FloatingState.COLLAPSED;
            }
            int maxFloatingTop2 = floatingState2 == FloatingState.COLLAPSED ? getMaxFloatingTop() : getMinFloatingTop();
            if (Math.abs(((float) getCurrentFloatTop()) + f) > ((float) maxFloatingTop)) {
                j = 200;
            } else {
                j = Math.abs(((float) getCurrentFloatTop()) + f) > ((float) (maxFloatingTop / 2)) ? 150 : 100;
            }
            ValueAnimator ofInt = ValueAnimator.ofInt(getCurrentFloatTop(), maxFloatingTop2);
            ofInt.setInterpolator(new FastOutSlowInInterpolator());
            ofInt.addUpdateListener(new VXScrollingStateHelper$startFloatingViewCOEAnimation$$inlined$apply$lambda$1(this, floatingState2, j));
            ExtraExtendsKt.addListeners$default(ofInt, null, new VXScrollingStateHelper$startFloatingViewCOEAnimation$$inlined$apply$lambda$2(this, floatingState2, j), 1, null);
            ofInt.setDuration(j);
            Unit unit = Unit.INSTANCE;
            this.animator = ofInt;
            if (ofInt != null) {
                ofInt.start();
            }
        }
    }

    public final void stopBackgroundViewScrolling() {
        boolean disableScroll = this.backgroundParent.getDisableScroll();
        this.backgroundParent.setDisableScroll(true);
        this.backgroundParent.setDisableScroll(disableScroll);
    }

    public final int scrollBackgroundParentByDy(int i) {
        return this.backgroundParent.scrollByDy(i);
    }

    public final boolean isScrollingParentIsBeingTouched() {
        return this.backgroundParent.isBeingTouchOrDisabledScrolled();
    }

    public final boolean isFloatingViewAppendingOrFakeAppending() {
        int appendViewTop = getAppendViewTop();
        FloatingState floatingState2 = this.floatingState;
        return floatingState2 == FloatingState.APPENDED || (floatingState2 == FloatingState.COLLAPSED && getMaxAppendTop() == appendViewTop) || (floatingState2 == FloatingState.EXPANDED && getMinAppendTop() == appendViewTop);
    }

    public final boolean isFloatingViewScrollingOrScrollUpFromBottom(int i) {
        int minFloatingTop = getMinFloatingTop() + 1;
        int maxFloatingTop = getMaxFloatingTop();
        int currentFloatTop = getCurrentFloatTop();
        if (minFloatingTop > currentFloatTop || maxFloatingTop <= currentFloatTop) {
            return getCurrentFloatTop() >= getMaxFloatingTop() && i > 0;
        }
        return true;
    }

    public final boolean isFloatingViewScrollDownFromFloatingTop(int i) {
        return getCurrentFloatTop() <= getMinFloatingTop() && i < 0;
    }

    public final boolean isFloatingViewNeedCollapsedOrExpanded() {
        int minFloatingTop = getMinFloatingTop() + 1;
        int maxFloatingTop = getMaxFloatingTop();
        int currentFloatTop = getCurrentFloatTop();
        return minFloatingTop <= currentFloatTop && maxFloatingTop > currentFloatTop;
    }

    public final boolean isFloatingViewExpandedOrAppendingExpanded() {
        return getCurrentFloatTop() == getMinFloatingTop();
    }
}
