package com.coolapk.market.widget.video.cover;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00040\u00042\u000e\u0010\u0005\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Landroidx/core/view/WindowInsetsCompat;", "kotlin.jvm.PlatformType", "v", "Landroid/view/View;", "inset", "onApplyWindowInsets"}, k = 3, mv = {1, 4, 2})
/* compiled from: ControllerCover.kt */
final class ControllerCover$onCoverAttachedToWindow$1 implements OnApplyWindowInsetsListener {
    final /* synthetic */ ControllerCover this$0;

    ControllerCover$onCoverAttachedToWindow$1(ControllerCover controllerCover) {
        this.this$0 = controllerCover;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        LinearLayout linearLayout = ControllerCover.access$getBinding$p(this.this$0).topContainer;
        Intrinsics.checkNotNullExpressionValue(windowInsetsCompat, "inset");
        linearLayout.setPadding(0, windowInsetsCompat.getSystemWindowInsetTop() - NumberExtendsKt.getDp((Number) 4), windowInsetsCompat.getSystemWindowInsetRight(), 0);
        ControllerCover.access$getBinding$p(this.this$0).bottomContainer.setPadding(0, 0, windowInsetsCompat.getSystemWindowInsetRight(), 0);
        LinearLayout linearLayout2 = ControllerCover.access$getBinding$p(this.this$0).bottomContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.bottomContainer");
        ViewGroup.MarginLayoutParams marginParams = ViewExtendsKt.getMarginParams(linearLayout2);
        if (marginParams != null) {
            marginParams.bottomMargin = windowInsetsCompat.getSystemWindowInsetBottom();
        }
        return windowInsetsCompat;
    }
}
