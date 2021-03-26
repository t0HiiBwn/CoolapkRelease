package com.coolapk.market.view.photo;

import android.animation.ValueAnimator;
import android.view.View;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.widget.view.MaxWidthFrameLayout;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/coolapk/market/view/photo/QRCodeActivity$startCamera$1$1"}, k = 3, mv = {1, 4, 2})
/* compiled from: QRCodeActivity.kt */
final class QRCodeActivity$startCamera$$inlined$apply$lambda$1 implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ QRCodeActivity this$0;

    QRCodeActivity$startCamera$$inlined$apply$lambda$1(QRCodeActivity qRCodeActivity) {
        this.this$0 = qRCodeActivity;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullExpressionValue(valueAnimator, "it");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        View view = QRCodeActivity.access$getBinding$p(this.this$0).scanLineView;
        Intrinsics.checkNotNullExpressionValue(view, "binding.scanLineView");
        MaxWidthFrameLayout maxWidthFrameLayout = QRCodeActivity.access$getBinding$p(this.this$0).cropLayout;
        Intrinsics.checkNotNullExpressionValue(maxWidthFrameLayout, "binding.cropLayout");
        view.setY((((float) (maxWidthFrameLayout.getHeight() - NumberExtendsKt.getDp((Number) 16))) * floatValue) + ((float) NumberExtendsKt.getDp((Number) 8)));
    }
}
