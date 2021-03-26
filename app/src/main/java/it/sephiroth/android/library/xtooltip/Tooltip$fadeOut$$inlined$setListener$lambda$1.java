package it.sephiroth.android.library.xtooltip;

import android.view.animation.Animation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/animation/Animation;", "invoke", "it/sephiroth/android/library/xtooltip/Tooltip$fadeOut$1$1"}, k = 3, mv = {1, 1, 13})
/* compiled from: Tooltip.kt */
final class Tooltip$fadeOut$$inlined$setListener$lambda$1 extends Lambda implements Function1<Animation, Unit> {
    final /* synthetic */ Tooltip this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Tooltip$fadeOut$$inlined$setListener$lambda$1(Tooltip tooltip) {
        super(1);
        this.this$0 = tooltip;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Animation animation) {
        invoke(animation);
        return Unit.INSTANCE;
    }

    public final void invoke(Animation animation) {
        this.this$0.isVisible = false;
        this.this$0.removeCallbacks();
        this.this$0.dismiss();
    }
}
