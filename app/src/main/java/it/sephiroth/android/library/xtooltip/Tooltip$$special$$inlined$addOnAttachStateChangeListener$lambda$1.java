package it.sephiroth.android.library.xtooltip;

import android.animation.ValueAnimator;
import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "<anonymous parameter 1>", "Landroid/view/View$OnAttachStateChangeListener;", "invoke", "it/sephiroth/android/library/xtooltip/Tooltip$preparePopup$2$4$1"}, k = 3, mv = {1, 1, 13})
/* compiled from: Tooltip.kt */
final class Tooltip$$special$$inlined$addOnAttachStateChangeListener$lambda$1 extends Lambda implements Function2<View, View.OnAttachStateChangeListener, Unit> {
    final /* synthetic */ Tooltip $this_run$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Tooltip$$special$$inlined$addOnAttachStateChangeListener$lambda$1(Tooltip tooltip) {
        super(2);
        this.$this_run$inlined = tooltip;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(View view, View.OnAttachStateChangeListener onAttachStateChangeListener) {
        invoke(view, onAttachStateChangeListener);
        return Unit.INSTANCE;
    }

    public final void invoke(View view, View.OnAttachStateChangeListener onAttachStateChangeListener) {
        Intrinsics.checkParameterIsNotNull(onAttachStateChangeListener, "<anonymous parameter 1>");
        ValueAnimator valueAnimator = this.$this_run$inlined.mAnimator;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
        if (this.$this_run$inlined.mShowDuration > 0) {
            this.$this_run$inlined.mHandler.removeCallbacks(this.$this_run$inlined.hideRunnable);
            this.$this_run$inlined.mHandler.postDelayed(this.$this_run$inlined.hideRunnable, this.$this_run$inlined.mShowDuration);
        }
        this.$this_run$inlined.mHandler.removeCallbacks(this.$this_run$inlined.activateRunnable);
        this.$this_run$inlined.mHandler.postDelayed(this.$this_run$inlined.activateRunnable, this.$this_run$inlined.mActivateDelay);
    }
}
