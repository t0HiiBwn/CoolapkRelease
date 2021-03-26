package com.coolapk.market.view.ad.toutiao;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.view.View;
import com.coolapk.market.extend.DrawableExtendsKt;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: DislikeDialog.kt */
final class DislikeDialog$onStart$1 implements Runnable {
    final /* synthetic */ View $decorView;

    DislikeDialog$onStart$1(View view) {
        this.$decorView = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Drawable background = this.$decorView.getBackground();
        if (background != null) {
            DrawableExtendsKt.findAndApplyGradientDrawable(background, AnonymousClass1.INSTANCE);
        }
        Drawable background2 = this.$decorView.getBackground();
        if (background2 instanceof InsetDrawable) {
            Rect rect = new Rect();
            background2.getPadding(rect);
            this.$decorView.setBackground(new InsetDrawable(((InsetDrawable) background2).getDrawable(), rect.left, rect.top, rect.right, rect.bottom));
        }
    }
}
