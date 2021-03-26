package com.coolapk.market.view.photo;

import android.view.View;
import cn.bertsir.zbar.Qr.Symbol;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.util.KotlinExtendKt;
import com.coolapk.market.widget.view.MaxWidthFrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\n¢\u0006\u0002\b\u000e"}, d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "onLayoutChange"}, k = 3, mv = {1, 4, 2})
/* compiled from: QRCodeActivity.kt */
final class QRCodeActivity$init$4 implements View.OnLayoutChangeListener {
    final /* synthetic */ QRCodeActivity this$0;

    QRCodeActivity$init$4(QRCodeActivity qRCodeActivity) {
        this.this$0 = qRCodeActivity;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = i3 - i;
        int constrain$default = KotlinExtendKt.constrain$default(i9 - NumberExtendsKt.getDp((Number) 120), 0, 0, 1, (Object) null);
        MaxWidthFrameLayout maxWidthFrameLayout = QRCodeActivity.access$getBinding$p(this.this$0).cropLayout;
        Intrinsics.checkNotNullExpressionValue(maxWidthFrameLayout, "binding.cropLayout");
        Symbol.cropX = maxWidthFrameLayout.getLeft();
        MaxWidthFrameLayout maxWidthFrameLayout2 = QRCodeActivity.access$getBinding$p(this.this$0).cropLayout;
        Intrinsics.checkNotNullExpressionValue(maxWidthFrameLayout2, "binding.cropLayout");
        Symbol.cropY = maxWidthFrameLayout2.getTop();
        Symbol.cropWidth = constrain$default;
        Symbol.cropHeight = constrain$default;
        Symbol.screenWidth = i9;
        Symbol.screenHeight = i4 - i2;
    }
}
