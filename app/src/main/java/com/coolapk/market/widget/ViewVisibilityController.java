package com.coolapk.market.widget;

import android.view.View;
import android.view.ViewPropertyAnimator;
import com.coolapk.market.extend.ViewExtendsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\b\u0007*\u0001\u0013\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\r\u0010\u0012\u001a\u00020\u0013H\u0002¢\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\u0006H\u0002J\b\u0010\u0016\u001a\u00020\u0006H\u0002J\u000e\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\fR\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/coolapk/market/widget/ViewVisibilityController;", "", "view", "Landroid/view/View;", "onShow", "Lkotlin/Function0;", "", "onHide", "duration", "", "(Landroid/view/View;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;J)V", "isHidingAnimation", "", "isVisible", "()Lkotlin/Unit;", "getOnHide", "()Lkotlin/jvm/functions/Function0;", "getOnShow", "createShowAdapter", "com/coolapk/market/widget/ViewVisibilityController$createShowAdapter$1", "()Lcom/coolapk/market/widget/ViewVisibilityController$createShowAdapter$1;", "doHide", "doShow", "requestVisible", "visible", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ViewVisibilityController.kt */
public final class ViewVisibilityController {
    private final long duration;
    private boolean isHidingAnimation;
    private final Function0<Unit> onHide;
    private final Function0<Unit> onShow;
    private final View view;

    public ViewVisibilityController(View view2, Function0<Unit> function0, Function0<Unit> function02, long j) {
        Intrinsics.checkNotNullParameter(view2, "view");
        this.view = view2;
        this.onShow = function0;
        this.onHide = function02;
        this.duration = j;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ViewVisibilityController(View view2, Function0 function0, Function0 function02, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(view2, (i & 2) != 0 ? null : function0, (i & 4) != 0 ? null : function02, (i & 8) != 0 ? 200 : j);
    }

    public final Function0<Unit> getOnHide() {
        return this.onHide;
    }

    public final Function0<Unit> getOnShow() {
        return this.onShow;
    }

    public final Unit isVisible() {
        ViewExtendsKt.visible(this.view);
        return Unit.INSTANCE;
    }

    public final void requestVisible(boolean z) {
        if (z) {
            doShow();
        } else {
            doHide();
        }
    }

    private final void doShow() {
        if (this.isHidingAnimation) {
            this.isHidingAnimation = false;
            ViewPropertyAnimator animate = this.view.animate();
            if (animate != null) {
                animate.cancel();
            }
            View view2 = this.view;
            view2.setVisibility(0);
            view2.animate().alpha(1.0f).setDuration(this.duration).setListener(createShowAdapter()).start();
        } else if (this.view.getVisibility() == 8) {
            View view3 = this.view;
            view3.setVisibility(0);
            view3.setAlpha(0.0f);
            view3.animate().alpha(1.0f).setDuration(this.duration).setListener(createShowAdapter()).start();
        }
    }

    private final void doHide() {
        if (!this.isHidingAnimation && this.view.getVisibility() == 0) {
            this.view.animate().alpha(0.0f).setDuration(this.duration).setListener(new ViewVisibilityController$doHide$1(this)).start();
            this.isHidingAnimation = true;
        }
    }

    private final ViewVisibilityController$createShowAdapter$1 createShowAdapter() {
        return new ViewVisibilityController$createShowAdapter$1(this);
    }
}
