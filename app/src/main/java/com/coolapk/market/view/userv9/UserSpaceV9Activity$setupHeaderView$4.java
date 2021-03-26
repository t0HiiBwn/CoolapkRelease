package com.coolapk.market.view.userv9;

import android.view.ViewPropertyAnimator;
import android.widget.LinearLayout;
import com.coolapk.market.extend.NumberExtendsKt;
import com.google.android.material.appbar.AppBarLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0004\"\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"com/coolapk/market/view/userv9/UserSpaceV9Activity$setupHeaderView$4", "Lcom/google/android/material/appbar/AppBarLayout$OnOffsetChangedListener;", "isHidingAnimation", "", "()Z", "setHidingAnimation", "(Z)V", "onOffsetChanged", "", "appbar", "Lcom/google/android/material/appbar/AppBarLayout;", "verticalOffset", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: UserSpaceV9Activity.kt */
public final class UserSpaceV9Activity$setupHeaderView$4 implements AppBarLayout.OnOffsetChangedListener {
    private boolean isHidingAnimation;
    final /* synthetic */ UserSpaceV9Activity this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    UserSpaceV9Activity$setupHeaderView$4(UserSpaceV9Activity userSpaceV9Activity) {
        this.this$0 = userSpaceV9Activity;
    }

    public final boolean isHidingAnimation() {
        return this.isHidingAnimation;
    }

    public final void setHidingAnimation(boolean z) {
        this.isHidingAnimation = z;
    }

    @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
    public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
        Intrinsics.checkNotNullParameter(appBarLayout, "appbar");
        LinearLayout linearLayout = UserSpaceV9Activity.access$getBinding$p(this.this$0).userToolbar.toolbarActionContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.userToolbar.toolbarActionContainer");
        linearLayout.setTranslationY((float) Math.abs(i));
        if (appBarLayout.getTotalScrollRange() - Math.abs(i) < NumberExtendsKt.getDp((Number) 2)) {
            if (this.isHidingAnimation) {
                this.isHidingAnimation = false;
                ViewPropertyAnimator animate = UserSpaceV9Activity.access$getBinding$p(this.this$0).userToolbar.toolbarActionContainer.animate();
                if (animate != null) {
                    animate.cancel();
                }
                LinearLayout linearLayout2 = UserSpaceV9Activity.access$getBinding$p(this.this$0).userToolbar.toolbarActionContainer;
                linearLayout2.setVisibility(0);
                linearLayout2.animate().alpha(1.0f).setDuration(200).setListener(null).start();
                Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.userToolbar.tool…                        }");
                return;
            }
            LinearLayout linearLayout3 = UserSpaceV9Activity.access$getBinding$p(this.this$0).userToolbar.toolbarActionContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.userToolbar.toolbarActionContainer");
            if (linearLayout3.getVisibility() == 8) {
                LinearLayout linearLayout4 = UserSpaceV9Activity.access$getBinding$p(this.this$0).userToolbar.toolbarActionContainer;
                linearLayout4.setVisibility(0);
                linearLayout4.setAlpha(0.0f);
                linearLayout4.animate().alpha(1.0f).setDuration(200).setListener(null).start();
            }
        } else if (!this.isHidingAnimation) {
            LinearLayout linearLayout5 = UserSpaceV9Activity.access$getBinding$p(this.this$0).userToolbar.toolbarActionContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout5, "binding.userToolbar.toolbarActionContainer");
            if (linearLayout5.getVisibility() == 0) {
                UserSpaceV9Activity.access$getBinding$p(this.this$0).userToolbar.toolbarActionContainer.animate().alpha(0.0f).setDuration(200).setListener(new UserSpaceV9Activity$setupHeaderView$4$onOffsetChanged$3(this)).start();
                this.isHidingAnimation = true;
            }
        }
    }
}
