package com.coolapk.market.widget.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.NestedScrollingParent3;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u000e\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020 H\u0016J(\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u0012H\u0016J \u0010&\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u001dH\u0016J0\u0010'\u001a\u00020(2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010%\u001a\u00020,2\u0006\u0010-\u001a\u00020*H\u0016J8\u0010.\u001a\u00020(2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010/\u001a\u00020*2\u0006\u00100\u001a\u00020*2\u0006\u00101\u001a\u00020*2\u0006\u00102\u001a\u00020*2\u0006\u0010-\u001a\u00020*H\u0016J@\u0010.\u001a\u00020(2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010/\u001a\u00020*2\u0006\u00100\u001a\u00020*2\u0006\u00101\u001a\u00020*2\u0006\u00102\u001a\u00020*2\u0006\u0010-\u001a\u00020*2\u0006\u0010%\u001a\u00020,H\u0016J(\u00103\u001a\u00020(2\u0006\u00104\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\t2\u0006\u00105\u001a\u00020*2\u0006\u0010-\u001a\u00020*H\u0016J(\u00106\u001a\u00020\u00122\u0006\u00104\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\t2\u0006\u00105\u001a\u00020*2\u0006\u0010-\u001a\u00020*H\u0016J\u0018\u00107\u001a\u00020(2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010-\u001a\u00020*H\u0016J\u000e\u00108\u001a\u00020(2\u0006\u00109\u001a\u00020\u0017R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R$\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8B@BX\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/coolapk/market/widget/view/VXProxyFloatingView;", "Landroid/widget/FrameLayout;", "Landroidx/core/view/NestedScrollingParent3;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "acceptedTargetView", "Landroid/view/View;", "value", "Lcom/coolapk/market/widget/view/FloatingState;", "floatingState", "getFloatingState", "()Lcom/coolapk/market/widget/view/FloatingState;", "setFloatingState", "(Lcom/coolapk/market/widget/view/FloatingState;)V", "handleBackgroundParentFling", "", "handleByBackgroundParent", "handleInternalFling", "Ljava/lang/Boolean;", "helper", "Lcom/coolapk/market/widget/view/VXScrollingStateHelper;", "getHelper", "()Lcom/coolapk/market/widget/view/VXScrollingStateHelper;", "setHelper", "(Lcom/coolapk/market/widget/view/VXScrollingStateHelper;)V", "lastVelocityYValue", "", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "onNestedFling", "target", "velocityX", "velocityY", "consumed", "onNestedPreFling", "onNestedPreScroll", "", "dx", "", "dy", "", "type", "onNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onNestedScrollAccepted", "child", "axes", "onStartNestedScroll", "onStopNestedScroll", "setInitData", "vxHelper", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: VXProxyFloatingView.kt */
public final class VXProxyFloatingView extends FrameLayout implements NestedScrollingParent3 {
    private View acceptedTargetView;
    private boolean handleBackgroundParentFling = true;
    private boolean handleByBackgroundParent;
    private Boolean handleInternalFling;
    public VXScrollingStateHelper helper;
    private float lastVelocityYValue;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FloatingState.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[FloatingState.DRAGGING.ordinal()] = 1;
            iArr[FloatingState.COLLAPSED.ordinal()] = 2;
            iArr[FloatingState.EXPANDED.ordinal()] = 3;
            iArr[FloatingState.ANIMATING.ordinal()] = 4;
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View view, View view2, int i, int i2) {
        Intrinsics.checkNotNullParameter(view, "child");
        Intrinsics.checkNotNullParameter(view2, "target");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VXProxyFloatingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
    }

    public final VXScrollingStateHelper getHelper() {
        VXScrollingStateHelper vXScrollingStateHelper = this.helper;
        if (vXScrollingStateHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("helper");
        }
        return vXScrollingStateHelper;
    }

    public final void setHelper(VXScrollingStateHelper vXScrollingStateHelper) {
        Intrinsics.checkNotNullParameter(vXScrollingStateHelper, "<set-?>");
        this.helper = vXScrollingStateHelper;
    }

    private final FloatingState getFloatingState() {
        VXScrollingStateHelper vXScrollingStateHelper = this.helper;
        if (vXScrollingStateHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("helper");
        }
        return vXScrollingStateHelper.getFloatingState();
    }

    private final void setFloatingState(FloatingState floatingState) {
        VXScrollingStateHelper vXScrollingStateHelper = this.helper;
        if (vXScrollingStateHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("helper");
        }
        vXScrollingStateHelper.setFloatingState(floatingState);
    }

    public final void setInitData(VXScrollingStateHelper vXScrollingStateHelper) {
        Intrinsics.checkNotNullParameter(vXScrollingStateHelper, "vxHelper");
        this.helper = vXScrollingStateHelper;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View view, View view2, int i, int i2) {
        Intrinsics.checkNotNullParameter(view, "child");
        Intrinsics.checkNotNullParameter(view2, "target");
        if (this.handleByBackgroundParent) {
            this.handleBackgroundParentFling = true;
            return true;
        } else if (this.acceptedTargetView != null) {
            return false;
        } else {
            this.handleInternalFling = null;
            int i3 = WhenMappings.$EnumSwitchMapping$0[getFloatingState().ordinal()];
            if ((i3 != 1 && i3 != 2 && i3 != 3 && i3 != 4) || i != 2 || i2 != 0) {
                return false;
            }
            VXScrollingStateHelper vXScrollingStateHelper = this.helper;
            if (vXScrollingStateHelper == null) {
                Intrinsics.throwUninitializedPropertyAccessException("helper");
            }
            vXScrollingStateHelper.cancelCOEAnimation();
            setFloatingState(FloatingState.DRAGGING);
            this.acceptedTargetView = view2;
            return true;
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr, int i3) {
        Intrinsics.checkNotNullParameter(view, "target");
        Intrinsics.checkNotNullParameter(iArr, "consumed");
        if (!this.handleByBackgroundParent) {
            VXScrollingStateHelper vXScrollingStateHelper = this.helper;
            if (vXScrollingStateHelper == null) {
                Intrinsics.throwUninitializedPropertyAccessException("helper");
            }
            boolean isFloatingViewScrollingOrScrollUpFromBottom = vXScrollingStateHelper.isFloatingViewScrollingOrScrollUpFromBottom(i2);
            if (isFloatingViewScrollingOrScrollUpFromBottom && i3 == 0) {
                VXScrollingStateHelper vXScrollingStateHelper2 = this.helper;
                if (vXScrollingStateHelper2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("helper");
                }
                iArr[1] = -vXScrollingStateHelper2.scrollFloatingViewWithDelta(-i2);
            }
            if (this.handleInternalFling == null && isFloatingViewScrollingOrScrollUpFromBottom) {
                this.handleInternalFling = true;
            }
        } else if (i2 > 0) {
            VXScrollingStateHelper vXScrollingStateHelper3 = this.helper;
            if (vXScrollingStateHelper3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("helper");
            }
            iArr[1] = vXScrollingStateHelper3.scrollBackgroundParentByDy(i2);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(view, "target");
        throw new RuntimeException("Deprecated NestedScrollingParent2 Interface");
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        Intrinsics.checkNotNullParameter(view, "target");
        Intrinsics.checkNotNullParameter(iArr, "consumed");
        if (this.handleByBackgroundParent) {
            VXScrollingStateHelper vXScrollingStateHelper = this.helper;
            if (vXScrollingStateHelper == null) {
                Intrinsics.throwUninitializedPropertyAccessException("helper");
            }
            if (!vXScrollingStateHelper.isScrollingParentIsBeingTouched() && i4 < 0 && this.handleBackgroundParentFling) {
                VXScrollingStateHelper vXScrollingStateHelper2 = this.helper;
                if (vXScrollingStateHelper2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("helper");
                }
                iArr[1] = vXScrollingStateHelper2.scrollBackgroundParentByDy(i4);
                if (iArr[1] > i4 && i5 == 1) {
                    this.handleBackgroundParentFling = false;
                }
            }
        } else if (i5 == 0) {
            if (this.handleInternalFling == null) {
                VXScrollingStateHelper vXScrollingStateHelper3 = this.helper;
                if (vXScrollingStateHelper3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("helper");
                }
                if (vXScrollingStateHelper3.isFloatingViewScrollDownFromFloatingTop(i4)) {
                    this.handleInternalFling = true;
                }
            }
            VXScrollingStateHelper vXScrollingStateHelper4 = this.helper;
            if (vXScrollingStateHelper4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("helper");
            }
            iArr[1] = -vXScrollingStateHelper4.scrollFloatingViewWithDelta(-i4);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View view, int i) {
        Intrinsics.checkNotNullParameter(view, "target");
        if (!this.handleByBackgroundParent) {
            if (i == 0) {
                VXScrollingStateHelper vXScrollingStateHelper = this.helper;
                if (vXScrollingStateHelper == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("helper");
                }
                if (vXScrollingStateHelper.isFloatingViewNeedCollapsedOrExpanded()) {
                    VXScrollingStateHelper vXScrollingStateHelper2 = this.helper;
                    if (vXScrollingStateHelper2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("helper");
                    }
                    vXScrollingStateHelper2.startFloatingViewCOEAnimation(this.lastVelocityYValue);
                }
            }
            if (Intrinsics.areEqual(this.acceptedTargetView, view)) {
                this.acceptedTargetView = null;
            }
        }
    }

    @Override // android.view.ViewParent, android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        Intrinsics.checkNotNullParameter(view, "target");
        if (this.handleByBackgroundParent) {
            return false;
        }
        return super.onNestedFling(view, f, f2, z);
    }

    @Override // android.view.ViewParent, android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        Intrinsics.checkNotNullParameter(view, "target");
        if (this.handleByBackgroundParent) {
            return false;
        }
        this.lastVelocityYValue = -f2;
        Boolean bool = this.handleInternalFling;
        return bool != null ? bool.booleanValue() : super.onNestedPreFling(view, f, f2);
    }

    @Override // android.view.View, android.view.ViewGroup
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "ev");
        if (motionEvent.getActionMasked() == 0) {
            VXScrollingStateHelper vXScrollingStateHelper = this.helper;
            if (vXScrollingStateHelper == null) {
                Intrinsics.throwUninitializedPropertyAccessException("helper");
            }
            vXScrollingStateHelper.stopBackgroundViewScrolling();
            VXScrollingStateHelper vXScrollingStateHelper2 = this.helper;
            if (vXScrollingStateHelper2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("helper");
            }
            this.handleByBackgroundParent = vXScrollingStateHelper2.isFloatingViewAppendingOrFakeAppending();
            this.lastVelocityYValue = 0.0f;
        }
        super.dispatchTouchEvent(motionEvent);
        motionEvent.getAction();
        return true;
    }
}
