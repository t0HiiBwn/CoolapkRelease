package com.coolapk.market.view.node;

import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.widget.ViewVisibilityController;
import com.coolapk.market.widget.view.FloatingState;
import com.coolapk.market.widget.view.VXNestedScrollView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00009\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0003J\u0010\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u0003H\u0002J\u0018\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020%2\u0006\u0010\"\u001a\u00020\u0003H\u0016J\b\u0010&\u001a\u00020'H\u0002J\b\u0010(\u001a\u00020\u001fH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0005R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0005R\u001a\u0010\n\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0005\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0005R\u0011\u0010\u0016\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0005R\u0011\u0010\u0018\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0005R\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006)"}, d2 = {"com/coolapk/market/view/node/BaseNodePageActivity$initUIState$toolbarContentListener$1", "Lcom/coolapk/market/widget/view/VXNestedScrollView$OnScrollYChangedListener;", "appbarBackgroundFloatingEndThreshold", "", "getAppbarBackgroundFloatingEndThreshold", "()I", "appbarBackgroundFloatingStartThreshold", "getAppbarBackgroundFloatingStartThreshold", "appbarBackgroundScrollYThreshold", "getAppbarBackgroundScrollYThreshold", "minAppBarAlpha", "getMinAppBarAlpha", "setMinAppBarAlpha", "(I)V", "minToolbarAlpha", "", "getMinToolbarAlpha", "()F", "setMinToolbarAlpha", "(F)V", "toolbarAlphaFloatingStartThreshold", "getToolbarAlphaFloatingStartThreshold", "toolbarAlphaScrollYEndThreshold", "getToolbarAlphaScrollYEndThreshold", "toolbarAlphaScrollYStartThreshold", "getToolbarAlphaScrollYStartThreshold", "toolbarContentController", "Lcom/coolapk/market/widget/ViewVisibilityController;", "getToolbarContentController", "()Lcom/coolapk/market/widget/ViewVisibilityController;", "checkWithFloatingTop", "", "top", "checkWithScrollY", "scrollY", "onScrollYChanged", "view", "Lcom/coolapk/market/widget/view/VXNestedScrollView;", "shouldHandleByFloatingTop", "", "updateAppbarBottom", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: BaseNodePageActivity.kt */
public final class BaseNodePageActivity$initUIState$toolbarContentListener$1 implements VXNestedScrollView.OnScrollYChangedListener {
    private final int appbarBackgroundFloatingEndThreshold = NumberExtendsKt.getDp((Number) 32);
    private final int appbarBackgroundFloatingStartThreshold = NumberExtendsKt.getDp((Number) 64);
    private final int appbarBackgroundScrollYThreshold = NumberExtendsKt.getDp((Number) 96);
    private int minAppBarAlpha;
    private float minToolbarAlpha;
    final /* synthetic */ BaseNodePageActivity this$0;
    private final int toolbarAlphaFloatingStartThreshold = NumberExtendsKt.getDp((Number) 28);
    private final ViewVisibilityController toolbarContentController;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    BaseNodePageActivity$initUIState$toolbarContentListener$1(BaseNodePageActivity baseNodePageActivity) {
        this.this$0 = baseNodePageActivity;
        FrameLayout frameLayout = baseNodePageActivity.getBinding$presentation_coolapkAppRelease().toolbarContent;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.toolbarContent");
        this.toolbarContentController = new ViewVisibilityController(frameLayout, null, null, 0, 14, null);
        FrameLayout frameLayout2 = baseNodePageActivity.getBinding$presentation_coolapkAppRelease().toolbarContent;
        Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.toolbarContent");
        frameLayout2.setVisibility(8);
    }

    public final int getAppbarBackgroundFloatingStartThreshold() {
        return this.appbarBackgroundFloatingStartThreshold;
    }

    public final int getAppbarBackgroundFloatingEndThreshold() {
        return this.appbarBackgroundFloatingEndThreshold;
    }

    public final int getToolbarAlphaFloatingStartThreshold() {
        return this.toolbarAlphaFloatingStartThreshold;
    }

    public final int getAppbarBackgroundScrollYThreshold() {
        return this.appbarBackgroundScrollYThreshold;
    }

    public final int getToolbarAlphaScrollYStartThreshold() {
        return this.this$0.getToolbarAlphaScrollYStartThreshold$presentation_coolapkAppRelease();
    }

    public final int getToolbarAlphaScrollYEndThreshold() {
        return getToolbarAlphaScrollYStartThreshold() + NumberExtendsKt.getDp((Number) 32);
    }

    public final int getMinAppBarAlpha() {
        return this.minAppBarAlpha;
    }

    public final void setMinAppBarAlpha(int i) {
        this.minAppBarAlpha = i;
    }

    public final float getMinToolbarAlpha() {
        return this.minToolbarAlpha;
    }

    public final void setMinToolbarAlpha(float f) {
        this.minToolbarAlpha = f;
    }

    public final ViewVisibilityController getToolbarContentController() {
        return this.toolbarContentController;
    }

    @Override // com.coolapk.market.widget.view.VXNestedScrollView.OnScrollYChangedListener
    public void onScrollYChanged(VXNestedScrollView vXNestedScrollView, int i) {
        Intrinsics.checkNotNullParameter(vXNestedScrollView, "view");
        checkWithScrollY(i);
    }

    private final boolean shouldHandleByFloatingTop() {
        FloatingState floatingState = this.this$0.getHelper$presentation_coolapkAppRelease().getFloatingState();
        return floatingState == FloatingState.EXPANDED || floatingState == FloatingState.DRAGGING || floatingState == FloatingState.ANIMATING;
    }

    private final void checkWithScrollY(int i) {
        float f;
        if (!shouldHandleByFloatingTop()) {
            int i2 = this.appbarBackgroundScrollYThreshold;
            int i3 = i > i2 ? 255 : (int) (((float) (i * 255)) / ((float) i2));
            this.minAppBarAlpha = i3;
            this.this$0.setPendingAppBarBackgroundAlpha$presentation_coolapkAppRelease(i3);
            FrameLayout frameLayout = this.this$0.getBinding$presentation_coolapkAppRelease().appBar;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.appBar");
            Drawable background = frameLayout.getBackground();
            if (background != null) {
                background.setAlpha(this.minAppBarAlpha);
            }
            if (i <= getToolbarAlphaScrollYStartThreshold()) {
                f = 0.0f;
            } else {
                f = i >= getToolbarAlphaScrollYEndThreshold() ? 1.0f : ((float) (i - getToolbarAlphaScrollYStartThreshold())) / (((float) getToolbarAlphaScrollYEndThreshold()) - ((float) getToolbarAlphaScrollYStartThreshold()));
            }
            this.minToolbarAlpha = f;
            ViewVisibilityController viewVisibilityController = this.toolbarContentController;
            boolean z = false;
            if (f > ((float) 0)) {
                z = true;
            }
            viewVisibilityController.requestVisible(z);
            updateAppbarBottom();
        }
    }

    public final void checkWithFloatingTop(int i) {
        if (shouldHandleByFloatingTop()) {
            int minFloatingTop = this.this$0.getHelper$presentation_coolapkAppRelease().getMinFloatingTop();
            int i2 = this.appbarBackgroundFloatingStartThreshold;
            int i3 = 255;
            boolean z = true;
            if (i > i2 + minFloatingTop) {
                i3 = Math.max(0, this.minAppBarAlpha);
            } else {
                int i4 = this.appbarBackgroundFloatingEndThreshold;
                if (i >= i4 + minFloatingTop) {
                    i3 = Math.max((int) (((float) 255) * (((float) 1) - (((float) ((i - i4) - minFloatingTop)) / (((float) i2) - ((float) i4))))), this.minAppBarAlpha);
                }
            }
            this.this$0.setPendingAppBarBackgroundAlpha$presentation_coolapkAppRelease(i3);
            FrameLayout frameLayout = this.this$0.getBinding$presentation_coolapkAppRelease().appBar;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.appBar");
            Drawable background = frameLayout.getBackground();
            if (background != null) {
                background.setAlpha(i3);
            }
            int i5 = this.toolbarAlphaFloatingStartThreshold;
            float f = 1.0f;
            if (i > minFloatingTop + i5) {
                f = 0.0f;
            } else if (i >= minFloatingTop) {
                f = 1.0f - (((float) (i - minFloatingTop)) / ((float) i5));
            }
            float max = Math.max(this.minToolbarAlpha, f);
            ViewVisibilityController viewVisibilityController = this.toolbarContentController;
            if (max <= ((float) 0)) {
                z = false;
            }
            viewVisibilityController.requestVisible(z);
            updateAppbarBottom();
        }
    }

    private final void updateAppbarBottom() {
        boolean isFloatingViewExpandedOrAppendingExpanded = this.this$0.getHelper$presentation_coolapkAppRelease().isFloatingViewExpandedOrAppendingExpanded();
        FrameLayout frameLayout = this.this$0.getBinding$presentation_coolapkAppRelease().appBar;
        if (isFloatingViewExpandedOrAppendingExpanded && frameLayout.getPaddingBottom() == 0) {
            FrameLayout frameLayout2 = frameLayout;
            frameLayout2.setPadding(frameLayout2.getPaddingLeft(), frameLayout2.getPaddingTop(), frameLayout2.getPaddingRight(), NumberExtendsKt.getDp((Number) 8));
        } else if (!isFloatingViewExpandedOrAppendingExpanded && frameLayout.getPaddingBottom() > 0) {
            FrameLayout frameLayout3 = frameLayout;
            frameLayout3.setPadding(frameLayout3.getPaddingLeft(), frameLayout3.getPaddingTop(), frameLayout3.getPaddingRight(), 0);
        }
    }
}
