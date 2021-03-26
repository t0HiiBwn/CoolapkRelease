package com.coolapk.market.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016¨\u0006\u000b"}, d2 = {"Lcom/coolapk/market/widget/TransWhiteProgressStyle;", "Lcom/coolapk/market/widget/ProgressStyle;", "context", "Landroid/content/Context;", "actionButton", "Lcom/coolapk/market/widget/ActionButton;", "(Landroid/content/Context;Lcom/coolapk/market/widget/ActionButton;)V", "createTextColor", "Landroid/content/res/ColorStateList;", "getBackgroundColor", "getForegroundColor", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ActionButton.kt */
public final class TransWhiteProgressStyle extends ProgressStyle {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TransWhiteProgressStyle(Context context, ActionButton actionButton) {
        super(context, actionButton);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(actionButton, "actionButton");
    }

    @Override // com.coolapk.market.widget.ProgressStyle
    public ColorStateList getBackgroundColor() {
        ColorStateList valueOf = ColorStateList.valueOf(ActionButtonKt.alpha(-1, 25));
        Intrinsics.checkNotNullExpressionValue(valueOf, "ColorStateList.valueOf(S…TE.alpha(Style.ALPHA_10))");
        return valueOf;
    }

    @Override // com.coolapk.market.widget.ProgressStyle
    public ColorStateList getForegroundColor() {
        ColorStateList valueOf = ColorStateList.valueOf(ActionButtonKt.alpha(-1, 25));
        Intrinsics.checkNotNullExpressionValue(valueOf, "ColorStateList.valueOf(S…TE.alpha(Style.ALPHA_10))");
        return valueOf;
    }

    @Override // com.coolapk.market.widget.Style
    public ColorStateList createTextColor() {
        ColorStateList valueOf = ColorStateList.valueOf(-1);
        Intrinsics.checkNotNullExpressionValue(valueOf, "ColorStateList.valueOf(Style.COLOR_WHITE)");
        return valueOf;
    }
}
