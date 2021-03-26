package it.sephiroth.android.library.xtooltip;

import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "onPreDraw"}, k = 3, mv = {1, 1, 13})
/* compiled from: Tooltip.kt */
final class Tooltip$predrawListener$1 implements ViewTreeObserver.OnPreDrawListener {
    final /* synthetic */ Tooltip this$0;

    Tooltip$predrawListener$1(Tooltip tooltip) {
        this.this$0 = tooltip;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00b3, code lost:
        if (r0[1] != r6.this$0.mNewLocation[1]) goto L_0x00b5;
     */
    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        if (this.this$0.mHasAnchorView) {
            WeakReference weakReference = this.this$0.mAnchorView;
            View view = null;
            if ((weakReference != null ? (View) weakReference.get() : null) != null) {
                WeakReference weakReference2 = this.this$0.mAnchorView;
                if (weakReference2 != null) {
                    view = (View) weakReference2.get();
                }
                if (view == null) {
                    Intrinsics.throwNpe();
                }
                Intrinsics.checkExpressionValueIsNotNull(view, "mAnchorView?.get()!!");
                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                Intrinsics.checkExpressionValueIsNotNull(viewTreeObserver, "view.viewTreeObserver");
                if (!viewTreeObserver.isAlive()) {
                    this.this$0.removeListeners(view);
                } else if (this.this$0.isShowing() && this.this$0.mPopupView != null) {
                    view.getLocationOnScreen(this.this$0.mNewLocation);
                    if (this.this$0.mOldLocation == null) {
                        Tooltip tooltip = this.this$0;
                        tooltip.mOldLocation = new int[]{tooltip.mNewLocation[0], this.this$0.mNewLocation[1]};
                    }
                    int[] iArr = this.this$0.mOldLocation;
                    if (iArr == null) {
                        Intrinsics.throwNpe();
                    }
                    if (iArr[0] == this.this$0.mNewLocation[1]) {
                        int[] iArr2 = this.this$0.mOldLocation;
                        if (iArr2 == null) {
                            Intrinsics.throwNpe();
                        }
                    }
                    Tooltip tooltip2 = this.this$0;
                    int i = tooltip2.mNewLocation[0];
                    int[] iArr3 = this.this$0.mOldLocation;
                    if (iArr3 == null) {
                        Intrinsics.throwNpe();
                    }
                    float f = (float) (i - iArr3[0]);
                    int i2 = this.this$0.mNewLocation[1];
                    int[] iArr4 = this.this$0.mOldLocation;
                    if (iArr4 == null) {
                        Intrinsics.throwNpe();
                    }
                    tooltip2.offsetBy(f, (float) (i2 - iArr4[1]));
                    int[] iArr5 = this.this$0.mOldLocation;
                    if (iArr5 == null) {
                        Intrinsics.throwNpe();
                    }
                    iArr5[0] = this.this$0.mNewLocation[0];
                    int[] iArr6 = this.this$0.mOldLocation;
                    if (iArr6 == null) {
                        Intrinsics.throwNpe();
                    }
                    iArr6[1] = this.this$0.mNewLocation[1];
                }
            }
        }
        return true;
    }
}
