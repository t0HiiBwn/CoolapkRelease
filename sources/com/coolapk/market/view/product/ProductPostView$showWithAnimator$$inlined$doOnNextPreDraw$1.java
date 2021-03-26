package com.coolapk.market.view.product;

import android.animation.Animator;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"com/coolapk/market/extend/ViewExtendsKt$doOnNextPreDraw$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ViewExtends.kt */
public final class ProductPostView$showWithAnimator$$inlined$doOnNextPreDraw$1 implements ViewTreeObserver.OnPreDrawListener {
    final /* synthetic */ View $this_doOnNextPreDraw;
    final /* synthetic */ ProductPostView this$0;

    public ProductPostView$showWithAnimator$$inlined$doOnNextPreDraw$1(View view, ProductPostView productPostView) {
        this.$this_doOnNextPreDraw = view;
        this.this$0 = productPostView;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        this.$this_doOnNextPreDraw.getViewTreeObserver().removeOnPreDrawListener(this);
        View root = this.this$0.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        root.setBackground(new ColorDrawable(1728053248));
        FrameLayout frameLayout = this.this$0.binding.bgView;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.bgView");
        int width = frameLayout.getWidth() - NumberExtendsKt.getDp((Number) 36);
        int height = (frameLayout.getHeight() - this.this$0.getExtraStartPaddingBottom()) - NumberExtendsKt.getDp((Number) 36);
        Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(frameLayout, width, height, (float) NumberExtendsKt.getDp((Number) 20), (float) Math.sqrt((double) ((width * width) + (height * height))));
        Intrinsics.checkNotNullExpressionValue(createCircularReveal, "animator");
        createCircularReveal.setDuration(200);
        createCircularReveal.start();
        LinearLayout[] linearLayoutArr = {this.this$0.binding.itemView1, this.this$0.binding.itemView2, this.this$0.binding.itemView3, this.this$0.binding.itemView4, this.this$0.binding.itemView6, this.this$0.binding.itemView7};
        int i = 0;
        int i2 = 0;
        while (i < 6) {
            LinearLayout linearLayout = linearLayoutArr[i];
            Intrinsics.checkNotNullExpressionValue(linearLayout, "v");
            ViewExtendsKt.showShakingAnimation$default(linearLayout, 0, 30 * ((long) i2), 1, null);
            i++;
            i2++;
        }
        return false;
    }
}
